package com.baidu.tieba.pb.pb.main.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes2.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private CustomMessageListener feG;
    private e fep;
    private com.baidu.tbadk.core.data.e fet;
    private f lOq;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;
    private a mfJ;
    private a mfK;
    private a mfL;
    private a mfM;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.feG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.feG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dst();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.fep != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.fep.uniqueId != ThreadAgreeAndShareLayout.this.fep.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lOq != null && ThreadAgreeAndShareLayout.this.lOq.dkZ() != null && ThreadAgreeAndShareLayout.this.lOq.dkZ().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lOq.dkZ().getBaijiahaoData().oriUgcNid)) {
                                ThreadAgreeAndShareLayout.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = ThreadAgreeAndShareLayout.this.mAgreeData.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            ThreadAgreeAndShareLayout.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.fep.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bx(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.fep = new e();
        this.fep.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.fet = new com.baidu.tbadk.core.data.e();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.mfJ = Gm(0);
        this.mfK = Gm(dimenPixelSize);
        this.mfL = Gm(dimenPixelSize);
        this.mfM = Gm(dimenPixelSize);
        this.mfL.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mfM.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mfL.setText(R.string.share_weixin_friend);
        this.mfM.setText(R.string.share_weixin_timeline);
        this.mfJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mfJ.addAnimatorListener(this);
        this.mfK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mfK.addAnimatorListener(this);
        this.mfJ.dsu().setOnClickListener(this.mOnClickListener);
        this.mfK.dsu().setOnClickListener(this.mOnClickListener);
        this.mfL.dsu().setOnClickListener(this.mOnClickListener);
        this.mfM.dsu().setOnClickListener(this.mOnClickListener);
        bzn();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lOq = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bh.checkUpIsLogin(getContext())) {
            if (view == this.mfJ.dsu() || view == this.mfK.dsu()) {
                if (view == this.mfJ.dsu()) {
                    this.mfJ.playAnimation();
                    if (this.fet != null) {
                        this.fet.type = 1;
                        this.fet.eMa = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dst();
                            if (this.fet != null) {
                                this.fet.eMd = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            wd(true);
                            if (this.fet != null) {
                                this.fet.eMd = 0;
                                i2 = 0;
                            }
                        }
                        Gl(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        wd(true);
                    }
                    i2 = 0;
                    Gl(i2);
                } else if (view == this.mfK.dsu()) {
                    this.mfK.playAnimation();
                    if (this.fet != null) {
                        this.fet.type = 2;
                        this.fet.eMa = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dst();
                            if (this.fet != null) {
                                this.fet.eMh = 0;
                                i = 1;
                            } else {
                                i = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum -= 2;
                            this.mAgreeData.agreeNum--;
                            this.mAgreeData.disAgreeNum++;
                            wd(false);
                            if (this.fet != null) {
                                this.fet.eMh = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        wd(false);
                        if (this.fet != null) {
                            this.fet.eMh = 1;
                        }
                    }
                    Gl(i);
                }
                this.fep.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lOq != null && this.lOq.dkZ() != null && this.lOq.dkZ().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lOq.dkZ().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.fep));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.fep));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.fet);
                btM();
            } else if (view == this.mfL.dsu()) {
                if (this.lOq != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lOq.dkZ(), 3);
                }
            } else if (view == this.mfM.dsu() && this.lOq != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lOq.dkZ(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Gl(int i) {
        if (this.mAgreeData != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            httpMessage.addParam("thread_id", this.mAgreeData.threadId);
            httpMessage.addParam("op_type", i);
            if (this.mAgreeData.objType == 0) {
                this.mAgreeData.objType = 3;
            }
            httpMessage.addParam("obj_type", this.mAgreeData.objType);
            httpMessage.addParam("agree_type", this.mAgreeData.agreeType);
            httpMessage.addParam("forum_id", this.mAgreeData.forumId);
            com.baidu.tbadk.pageExtra.c bR = d.bR(this);
            if (bR != null) {
                httpMessage.addParam("obj_source", bR.getCurrentPageKey());
            }
            if (!TextUtils.isEmpty(this.mAgreeData.postId)) {
                httpMessage.addParam("post_id", this.mAgreeData.postId);
            }
            if (this.lOq != null && this.lOq.dkZ() != null && this.lOq.dkZ().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lOq.dkZ().getBaijiahaoData();
                httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void wd(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.mfJ.mfO;
        TBLottieAnimationView tBLottieAnimationView2 = this.mfK.mfO;
        TextView textView = this.mfJ.textView;
        TextView textView2 = this.mfK.textView;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
        textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
        tBLottieAnimationView.clearColorFilter();
        tBLottieAnimationView2.clearColorFilter();
        if (z) {
            tBLottieAnimationView.playAnimation();
            tBLottieAnimationView2.cancelAnimation();
            tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            tBLottieAnimationView2.playAnimation();
            tBLottieAnimationView.cancelAnimation();
            tBLottieAnimationView.setMinAndMaxProgress(0.0f, 0.0f);
        }
        tBLottieAnimationView.setFrame(0);
        tBLottieAnimationView2.setFrame(0);
        if (this.mAgreeData.hasAgree) {
            if (this.mAgreeData.agreeType == 2) {
                textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                return;
            }
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
            textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
            return;
        }
        textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
    }

    public void dst() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dsu = this.mfJ.dsu();
            ap.a(dsu, R.raw.lottie_agree);
            TBLottieAnimationView dsu2 = this.mfK.dsu();
            ap.a(dsu2, R.raw.lottie_disagree);
            TextView textView = this.mfJ.getTextView();
            TextView textView2 = this.mfK.getTextView();
            textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dsu2.setProgress(0.0f);
                    dsu.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                } else {
                    dsu.setProgress(0.0f);
                    dsu2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
                }
            } else {
                dsu.setMinAndMaxProgress(0.0f, 0.0f);
                dsu2.setMinAndMaxProgress(0.0f, 0.0f);
                dsu.setProgress(0.0f);
                dsu2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dsu.setAlpha(0.5f);
                dsu2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dsu.setAlpha(0.66f);
                dsu2.setAlpha(0.66f);
            } else {
                dsu.setAlpha(1.0f);
                dsu2.setAlpha(1.0f);
            }
            if (this.lOq != null && this.lOq.dkZ() != null) {
                setVisibility(this.lOq.dkZ().bmz() ? 8 : 0);
            }
        }
    }

    public void btM() {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        int i2;
        int i3;
        String str7 = null;
        if (this.fet != null) {
            if (this.lOq == null || this.lOq.dkZ() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                i2 = 1;
            } else {
                cb dkZ = this.lOq.dkZ();
                if (dkZ.bmx()) {
                    i3 = 2;
                } else if (dkZ.bmy()) {
                    i3 = 3;
                } else if (dkZ.bpN()) {
                    i3 = 4;
                } else {
                    i3 = dkZ.bpO() ? 5 : 1;
                }
                str6 = dkZ.bmo();
                if (dkZ.getBaijiahaoData() != null && !au.isEmpty(dkZ.getBaijiahaoData().oriUgcVid)) {
                    str7 = dkZ.getBaijiahaoData().oriUgcVid;
                }
                i = dkZ.bpR();
                str4 = dkZ.mRecomSource;
                str3 = dkZ.mRecomAbTag;
                str2 = dkZ.mRecomWeight;
                str = dkZ.mRecomExtra;
                str5 = str7;
                i2 = i3;
            }
            if (this.fet.type == 1) {
                ar dR = new ar("c12003").ap("obj_locate", this.fet.eMa).ap("obj_param1", this.fet.eMb).ap("obj_source", this.fet.eMc).ap("obj_id", this.fet.eMd).ap("obj_name", i2).dR(IntentConfig.NID, str6).ap(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str4).dR("ab_tag", str3).dR("weight", str2).dR("recom_extra", str).dR("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR);
                }
                com.baidu.tbadk.pageExtra.c bR = d.bR(this);
                if (bR != null) {
                    dR.dR("obj_cur_page", bR.getCurrentPageKey());
                }
                if (d.bDM() != null) {
                    dR.dR("obj_pre_page", d.bDM());
                }
                TiebaStatic.log(dR);
            } else if (this.fet.type == 2) {
                ar dR2 = new ar("c13271").ap("obj_type", this.fet.eMf).ap("obj_locate", this.fet.eMg).ap("obj_id", this.fet.eMh).ap("obj_name", i2).dR(IntentConfig.NID, str6).ap(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str4).dR("ab_tag", str3).dR("weight", str2).dR("recom_extra", str).dR("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR2);
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public void bzn() {
        this.mfL.Gn(R.color.CAM_X0107);
        this.mfM.Gn(R.color.CAM_X0107);
        this.mfL.setImageResource(R.drawable.icon_weixin_112);
        this.mfM.setImageResource(R.drawable.icon_pengyouqun_112);
        this.mfJ.dsv();
        this.mfK.dsv();
        this.mfL.dsv();
        this.mfM.dsv();
        dst();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.e eVar) {
        this.fet = eVar;
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public TbPageContext getTbPageContext() {
        if (this.mPageContext == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.mPageContext;
    }

    private a Gm(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private View aaM;
        private TBLottieAnimationView mfO;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.aaM = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.mfO = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dsu() {
            return this.mfO;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.mfO.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.mfO, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Gn(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.mfO.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.mfO.addAnimatorListener(animatorListener);
        }

        public void dsv() {
            com.baidu.tbadk.core.util.f.a.btv().oV(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).oW(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oU(R.color.cp_cont_f_alpha50).oP(R.color.CAM_X0201).bv(this.aaM);
        }
    }
}
