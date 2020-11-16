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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e ePS;
    private d ePW;
    private CustomMessageListener eQj;
    private a lIb;
    private a lIc;
    private a lId;
    private a lIe;
    private f lre;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eQj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eQj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            doP();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.ePS != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.ePS.uniqueId != ThreadAgreeAndShareLayout.this.ePS.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lre != null && ThreadAgreeAndShareLayout.this.lre.dhH() != null && ThreadAgreeAndShareLayout.this.lre.dhH().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lre.dhH().getBaijiahaoData().oriUgcNid)) {
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
        this.eQj = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.ePS.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bp(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.ePS = new e();
        this.ePS.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.ePW = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.lIb = GP(0);
        this.lIc = GP(dimenPixelSize);
        this.lId = GP(dimenPixelSize);
        this.lIe = GP(dimenPixelSize);
        this.lId.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lIe.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lId.setText(R.string.share_weixin_friend);
        this.lIe.setText(R.string.share_weixin_timeline);
        this.lIb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lIb.addAnimatorListener(this);
        this.lIc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lIc.addAnimatorListener(this);
        this.lIb.doQ().setOnClickListener(this.mOnClickListener);
        this.lIc.doQ().setOnClickListener(this.mOnClickListener);
        this.lId.doQ().setOnClickListener(this.mOnClickListener);
        this.lIe.doQ().setOnClickListener(this.mOnClickListener);
        bwU();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lre = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        doP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bh.checkUpIsLogin(getContext())) {
            if (view == this.lIb.doQ() || view == this.lIc.doQ()) {
                if (view == this.lIb.doQ()) {
                    this.lIb.playAnimation();
                    if (this.ePW != null) {
                        this.ePW.type = 1;
                        this.ePW.exI = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            doP();
                            if (this.ePW != null) {
                                this.ePW.exL = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            vn(true);
                            if (this.ePW != null) {
                                this.ePW.exL = 0;
                                i2 = 0;
                            }
                        }
                        GO(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        vn(true);
                    }
                    i2 = 0;
                    GO(i2);
                } else if (view == this.lIc.doQ()) {
                    this.lIc.playAnimation();
                    if (this.ePW != null) {
                        this.ePW.type = 2;
                        this.ePW.exI = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            doP();
                            if (this.ePW != null) {
                                this.ePW.exP = 0;
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
                            vn(false);
                            if (this.ePW != null) {
                                this.ePW.exP = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        vn(false);
                        if (this.ePW != null) {
                            this.ePW.exP = 1;
                        }
                    }
                    GO(i);
                }
                this.ePS.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lre != null && this.lre.dhH() != null && this.lre.dhH().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lre.dhH().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ePS));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ePS));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.ePW);
                brt();
            } else if (view == this.lId.doQ()) {
                if (this.lre != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.lre.dhH(), 3);
                }
            } else if (view == this.lIe.doQ() && this.lre != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.lre.dhH(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void GO(int i) {
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
            if (!TextUtils.isEmpty(this.mAgreeData.postId)) {
                httpMessage.addParam("post_id", this.mAgreeData.postId);
            }
            if (this.lre != null && this.lre.dhH() != null && this.lre.dhH().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lre.dhH().getBaijiahaoData();
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

    public void vn(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.lIb.lIg;
        TBLottieAnimationView tBLottieAnimationView2 = this.lIc.lIg;
        TextView textView = this.lIb.textView;
        TextView textView2 = this.lIc.textView;
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

    public void doP() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView doQ = this.lIb.doQ();
            ap.a(doQ, R.raw.lottie_agree);
            TBLottieAnimationView doQ2 = this.lIc.doQ();
            ap.a(doQ2, R.raw.lottie_disagree);
            TextView textView = this.lIb.getTextView();
            TextView textView2 = this.lIc.getTextView();
            textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    doQ2.setProgress(0.0f);
                    doQ.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                } else {
                    doQ.setProgress(0.0f);
                    doQ2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
                }
            } else {
                doQ.setMinAndMaxProgress(0.0f, 0.0f);
                doQ2.setMinAndMaxProgress(0.0f, 0.0f);
                doQ.setProgress(0.0f);
                doQ2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                doQ.setAlpha(0.5f);
                doQ2.setAlpha(0.5f);
            } else if (skinType == 4) {
                doQ.setAlpha(0.66f);
                doQ2.setAlpha(0.66f);
            } else {
                doQ.setAlpha(1.0f);
                doQ2.setAlpha(1.0f);
            }
            if (this.lre != null && this.lre.dhH() != null) {
                setVisibility(this.lre.dhH().bkm() ? 8 : 0);
            }
        }
    }

    public void brt() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.ePW != null) {
            if (this.lre == null || this.lre.dhH() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bx dhH = this.lre.dhH();
                if (dhH.bkk()) {
                    i3 = 2;
                } else if (dhH.bkl()) {
                    i3 = 3;
                } else if (dhH.bnz()) {
                    i3 = 4;
                } else {
                    i3 = dhH.bnA() ? 5 : 1;
                }
                String nid = dhH.getNid();
                if (dhH.getBaijiahaoData() != null && !au.isEmpty(dhH.getBaijiahaoData().oriUgcVid)) {
                    str6 = dhH.getBaijiahaoData().oriUgcVid;
                }
                int bnD = dhH.bnD();
                String str7 = dhH.mRecomSource;
                String str8 = dhH.mRecomAbTag;
                String str9 = dhH.mRecomWeight;
                String str10 = dhH.mRecomExtra;
                str = str8;
                i = bnD;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.ePW.type == 1) {
                ar dR = new ar("c12003").ak("obj_locate", this.ePW.exI).ak("obj_param1", this.ePW.exJ).ak("obj_source", this.ePW.exK).ak("obj_id", this.ePW.exL).ak("obj_name", i2).dR("nid", str4).ak(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str2).dR("ab_tag", str).dR("weight", str5).dR("recom_extra", str6).dR("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR);
                }
                TiebaStatic.log(dR);
            } else if (this.ePW.type == 2) {
                ar dR2 = new ar("c13271").ak("obj_type", this.ePW.exN).ak("obj_locate", this.ePW.exO).ak("obj_id", this.ePW.exP).ak("obj_name", i2).dR("nid", str4).ak(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str2).dR("ab_tag", str).dR("weight", str5).dR("recom_extra", str6).dR("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR2);
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public void bwU() {
        this.lId.GQ(R.color.CAM_X0107);
        this.lIe.GQ(R.color.CAM_X0107);
        this.lId.setImageResource(R.drawable.icon_weixin_112);
        this.lIe.setImageResource(R.drawable.icon_pengyouqun_112);
        this.lIb.doR();
        this.lIc.doR();
        this.lId.doR();
        this.lIe.doR();
        doP();
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
        this.ePW = dVar;
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

    private a GP(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private View Zn;
        private TBLottieAnimationView lIg;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Zn = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lIg = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView doQ() {
            return this.lIg;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lIg.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.lIg, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void GQ(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lIg.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lIg.addAnimatorListener(animatorListener);
        }

        public void doR() {
            com.baidu.tbadk.core.util.e.a.brc().pM(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).pN(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).pL(R.color.cp_cont_f_alpha50).pG(R.color.CAM_X0201).bn(this.Zn);
        }
    }
}
