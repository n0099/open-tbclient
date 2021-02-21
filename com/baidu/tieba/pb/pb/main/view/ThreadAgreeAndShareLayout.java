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
    private f lOF;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;
    private a mfY;
    private a mfZ;
    private a mga;
    private a mgb;

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
            dsA();
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
                            if (ThreadAgreeAndShareLayout.this.lOF != null && ThreadAgreeAndShareLayout.this.lOF.dlg() != null && ThreadAgreeAndShareLayout.this.lOF.dlg().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lOF.dlg().getBaijiahaoData().oriUgcNid)) {
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
        this.mfY = Gm(0);
        this.mfZ = Gm(dimenPixelSize);
        this.mga = Gm(dimenPixelSize);
        this.mgb = Gm(dimenPixelSize);
        this.mga.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mgb.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mga.setText(R.string.share_weixin_friend);
        this.mgb.setText(R.string.share_weixin_timeline);
        this.mfY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mfY.addAnimatorListener(this);
        this.mfZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mfZ.addAnimatorListener(this);
        this.mfY.dsB().setOnClickListener(this.mOnClickListener);
        this.mfZ.dsB().setOnClickListener(this.mOnClickListener);
        this.mga.dsB().setOnClickListener(this.mOnClickListener);
        this.mgb.dsB().setOnClickListener(this.mOnClickListener);
        bzn();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lOF = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dsA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bh.checkUpIsLogin(getContext())) {
            if (view == this.mfY.dsB() || view == this.mfZ.dsB()) {
                if (view == this.mfY.dsB()) {
                    this.mfY.playAnimation();
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
                            dsA();
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
                } else if (view == this.mfZ.dsB()) {
                    this.mfZ.playAnimation();
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
                            dsA();
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
                    if (this.lOF != null && this.lOF.dlg() != null && this.lOF.dlg().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lOF.dlg().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.fep));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.fep));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.fet);
                btM();
            } else if (view == this.mga.dsB()) {
                if (this.lOF != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lOF.dlg(), 3);
                }
            } else if (view == this.mgb.dsB() && this.lOF != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lOF.dlg(), 2);
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
            if (this.lOF != null && this.lOF.dlg() != null && this.lOF.dlg().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lOF.dlg().getBaijiahaoData();
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
        TBLottieAnimationView tBLottieAnimationView = this.mfY.mgd;
        TBLottieAnimationView tBLottieAnimationView2 = this.mfZ.mgd;
        TextView textView = this.mfY.textView;
        TextView textView2 = this.mfZ.textView;
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

    public void dsA() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dsB = this.mfY.dsB();
            ap.a(dsB, R.raw.lottie_agree);
            TBLottieAnimationView dsB2 = this.mfZ.dsB();
            ap.a(dsB2, R.raw.lottie_disagree);
            TextView textView = this.mfY.getTextView();
            TextView textView2 = this.mfZ.getTextView();
            textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dsB2.setProgress(0.0f);
                    dsB.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                } else {
                    dsB.setProgress(0.0f);
                    dsB2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
                }
            } else {
                dsB.setMinAndMaxProgress(0.0f, 0.0f);
                dsB2.setMinAndMaxProgress(0.0f, 0.0f);
                dsB.setProgress(0.0f);
                dsB2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dsB.setAlpha(0.5f);
                dsB2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dsB.setAlpha(0.66f);
                dsB2.setAlpha(0.66f);
            } else {
                dsB.setAlpha(1.0f);
                dsB2.setAlpha(1.0f);
            }
            if (this.lOF != null && this.lOF.dlg() != null) {
                setVisibility(this.lOF.dlg().bmz() ? 8 : 0);
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
            if (this.lOF == null || this.lOF.dlg() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                i2 = 1;
            } else {
                cb dlg = this.lOF.dlg();
                if (dlg.bmx()) {
                    i3 = 2;
                } else if (dlg.bmy()) {
                    i3 = 3;
                } else if (dlg.bpN()) {
                    i3 = 4;
                } else {
                    i3 = dlg.bpO() ? 5 : 1;
                }
                str6 = dlg.bmo();
                if (dlg.getBaijiahaoData() != null && !au.isEmpty(dlg.getBaijiahaoData().oriUgcVid)) {
                    str7 = dlg.getBaijiahaoData().oriUgcVid;
                }
                i = dlg.bpR();
                str4 = dlg.mRecomSource;
                str3 = dlg.mRecomAbTag;
                str2 = dlg.mRecomWeight;
                str = dlg.mRecomExtra;
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
        this.mga.Gn(R.color.CAM_X0107);
        this.mgb.Gn(R.color.CAM_X0107);
        this.mga.setImageResource(R.drawable.icon_weixin_112);
        this.mgb.setImageResource(R.drawable.icon_pengyouqun_112);
        this.mfY.dsC();
        this.mfZ.dsC();
        this.mga.dsC();
        this.mgb.dsC();
        dsA();
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
        private TBLottieAnimationView mgd;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.aaM = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.mgd = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dsB() {
            return this.mgd;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.mgd.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.mgd, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Gn(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.mgd.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.mgd.addAnimatorListener(animatorListener);
        }

        public void dsC() {
            com.baidu.tbadk.core.util.f.a.btv().oV(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).oW(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oU(R.color.cp_cont_f_alpha50).oP(R.color.CAM_X0201).bv(this.aaM);
        }
    }
}
