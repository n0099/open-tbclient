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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes22.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e eXh;
    private d eXl;
    private CustomMessageListener eXy;
    private f lEP;
    private a lVX;
    private a lVY;
    private a lVZ;
    private a lWa;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eXy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eXy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            duh();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.eXh != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.eXh.uniqueId != ThreadAgreeAndShareLayout.this.eXh.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lEP != null && ThreadAgreeAndShareLayout.this.lEP.dmU() != null && ThreadAgreeAndShareLayout.this.lEP.dmU().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lEP.dmU().getBaijiahaoData().oriUgcNid)) {
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
        this.eXy = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.eXh.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bs(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.eXh = new e();
        this.eXh.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eXl = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.lVX = HG(0);
        this.lVY = HG(dimenPixelSize);
        this.lVZ = HG(dimenPixelSize);
        this.lWa = HG(dimenPixelSize);
        this.lVZ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lWa.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lVZ.setText(R.string.share_weixin_friend);
        this.lWa.setText(R.string.share_weixin_timeline);
        this.lVX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lVX.addAnimatorListener(this);
        this.lVY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lVY.addAnimatorListener(this);
        this.lVX.dui().setOnClickListener(this.mOnClickListener);
        this.lVY.dui().setOnClickListener(this.mOnClickListener);
        this.lVZ.dui().setOnClickListener(this.mOnClickListener);
        this.lWa.dui().setOnClickListener(this.mOnClickListener);
        bAu();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lEP = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        duh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bh.checkUpIsLogin(getContext())) {
            if (view == this.lVX.dui() || view == this.lVY.dui()) {
                if (view == this.lVX.dui()) {
                    this.lVX.playAnimation();
                    if (this.eXl != null) {
                        this.eXl.type = 1;
                        this.eXl.eEJ = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            duh();
                            if (this.eXl != null) {
                                this.eXl.eEM = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            vQ(true);
                            if (this.eXl != null) {
                                this.eXl.eEM = 0;
                                i2 = 0;
                            }
                        }
                        HF(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        vQ(true);
                    }
                    i2 = 0;
                    HF(i2);
                } else if (view == this.lVY.dui()) {
                    this.lVY.playAnimation();
                    if (this.eXl != null) {
                        this.eXl.type = 2;
                        this.eXl.eEJ = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            duh();
                            if (this.eXl != null) {
                                this.eXl.eEQ = 0;
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
                            vQ(false);
                            if (this.eXl != null) {
                                this.eXl.eEQ = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        vQ(false);
                        if (this.eXl != null) {
                            this.eXl.eEQ = 1;
                        }
                    }
                    HF(i);
                }
                this.eXh.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lEP != null && this.lEP.dmU() != null && this.lEP.dmU().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lEP.dmU().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.eXh));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.eXh));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eXl);
                buQ();
            } else if (view == this.lVZ.dui()) {
                if (this.lEP != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lEP.dmU(), 3);
                }
            } else if (view == this.lWa.dui() && this.lEP != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lEP.dmU(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void HF(int i) {
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
            com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(this);
            if (bM != null) {
                httpMessage.addParam("obj_source", bM.getCurrentPageKey());
            }
            if (!TextUtils.isEmpty(this.mAgreeData.postId)) {
                httpMessage.addParam("post_id", this.mAgreeData.postId);
            }
            if (this.lEP != null && this.lEP.dmU() != null && this.lEP.dmU().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lEP.dmU().getBaijiahaoData();
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

    public void vQ(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.lVX.lWc;
        TBLottieAnimationView tBLottieAnimationView2 = this.lVY.lWc;
        TextView textView = this.lVX.textView;
        TextView textView2 = this.lVY.textView;
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

    public void duh() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dui = this.lVX.dui();
            ap.a(dui, R.raw.lottie_agree);
            TBLottieAnimationView dui2 = this.lVY.dui();
            ap.a(dui2, R.raw.lottie_disagree);
            TextView textView = this.lVX.getTextView();
            TextView textView2 = this.lVY.getTextView();
            textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dui2.setProgress(0.0f);
                    dui.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                } else {
                    dui.setProgress(0.0f);
                    dui2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
                }
            } else {
                dui.setMinAndMaxProgress(0.0f, 0.0f);
                dui2.setMinAndMaxProgress(0.0f, 0.0f);
                dui.setProgress(0.0f);
                dui2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dui.setAlpha(0.5f);
                dui2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dui.setAlpha(0.66f);
                dui2.setAlpha(0.66f);
            } else {
                dui.setAlpha(1.0f);
                dui2.setAlpha(1.0f);
            }
            if (this.lEP != null && this.lEP.dmU() != null) {
                setVisibility(this.lEP.dmU().bnz() ? 8 : 0);
            }
        }
    }

    public void buQ() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eXl != null) {
            if (this.lEP == null || this.lEP.dmU() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                by dmU = this.lEP.dmU();
                if (dmU.bnx()) {
                    i3 = 2;
                } else if (dmU.bny()) {
                    i3 = 3;
                } else if (dmU.bqM()) {
                    i3 = 4;
                } else {
                    i3 = dmU.bqN() ? 5 : 1;
                }
                String nid = dmU.getNid();
                if (dmU.getBaijiahaoData() != null && !au.isEmpty(dmU.getBaijiahaoData().oriUgcVid)) {
                    str6 = dmU.getBaijiahaoData().oriUgcVid;
                }
                int bqQ = dmU.bqQ();
                String str7 = dmU.mRecomSource;
                String str8 = dmU.mRecomAbTag;
                String str9 = dmU.mRecomWeight;
                String str10 = dmU.mRecomExtra;
                str = str8;
                i = bqQ;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eXl.type == 1) {
                ar dY = new ar("c12003").al("obj_locate", this.eXl.eEJ).al("obj_param1", this.eXl.eEK).al("obj_source", this.eXl.eEL).al("obj_id", this.eXl.eEM).al("obj_name", i2).dY("nid", str4).al(IntentConfig.CARD_TYPE, i).dY(IntentConfig.RECOM_SOURCE, str2).dY("ab_tag", str).dY("weight", str5).dY("recom_extra", str6).dY("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dY);
                }
                com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(this);
                if (bM != null) {
                    dY.dY("obj_cur_page", bM.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                    dY.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                }
                TiebaStatic.log(dY);
            } else if (this.eXl.type == 2) {
                ar dY2 = new ar("c13271").al("obj_type", this.eXl.eEO).al("obj_locate", this.eXl.eEP).al("obj_id", this.eXl.eEQ).al("obj_name", i2).dY("nid", str4).al(IntentConfig.CARD_TYPE, i).dY(IntentConfig.RECOM_SOURCE, str2).dY("ab_tag", str).dY("weight", str5).dY("recom_extra", str6).dY("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dY2);
                }
                TiebaStatic.log(dY2);
            }
        }
    }

    public void bAu() {
        this.lVZ.HH(R.color.CAM_X0107);
        this.lWa.HH(R.color.CAM_X0107);
        this.lVZ.setImageResource(R.drawable.icon_weixin_112);
        this.lWa.setImageResource(R.drawable.icon_pengyouqun_112);
        this.lVX.duj();
        this.lVY.duj();
        this.lVZ.duj();
        this.lWa.duj();
        duh();
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

    public void setStatisticData(d dVar) {
        this.eXl = dVar;
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

    private a HG(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private View aaj;
        private TBLottieAnimationView lWc;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.aaj = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lWc = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dui() {
            return this.lWc;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lWc.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.lWc, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void HH(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lWc.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lWc.addAnimatorListener(animatorListener);
        }

        public void duj() {
            com.baidu.tbadk.core.util.e.a.buz().qm(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).qn(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ql(R.color.cp_cont_f_alpha50).qg(R.color.CAM_X0201).bq(this.aaj);
        }
    }
}
