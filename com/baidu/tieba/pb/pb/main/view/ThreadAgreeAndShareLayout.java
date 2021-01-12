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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes2.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e fbZ;
    private d fcd;
    private CustomMessageListener fcr;
    private f lFA;
    private a lWE;
    private a lWF;
    private a lWG;
    private a lWH;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fcr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fcr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dqf();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.fbZ != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.fbZ.uniqueId != ThreadAgreeAndShareLayout.this.fbZ.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lFA != null && ThreadAgreeAndShareLayout.this.lFA.diN() != null && ThreadAgreeAndShareLayout.this.lFA.diN().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lFA.diN().getBaijiahaoData().oriUgcNid)) {
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
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.fbZ.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bB(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.fbZ = new e();
        this.fbZ.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.fcd = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.lWE = FT(0);
        this.lWF = FT(dimenPixelSize);
        this.lWG = FT(dimenPixelSize);
        this.lWH = FT(dimenPixelSize);
        this.lWG.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lWH.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lWG.setText(R.string.share_weixin_friend);
        this.lWH.setText(R.string.share_weixin_timeline);
        this.lWE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lWE.addAnimatorListener(this);
        this.lWF.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lWF.addAnimatorListener(this);
        this.lWE.dqg().setOnClickListener(this.mOnClickListener);
        this.lWF.dqg().setOnClickListener(this.mOnClickListener);
        this.lWG.dqg().setOnClickListener(this.mOnClickListener);
        this.lWH.dqg().setOnClickListener(this.mOnClickListener);
        byV();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lFA = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dqf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.lWE.dqg() || view == this.lWF.dqg()) {
                if (view == this.lWE.dqg()) {
                    this.lWE.playAnimation();
                    if (this.fcd != null) {
                        this.fcd.type = 1;
                        this.fcd.eJO = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dqf();
                            if (this.fcd != null) {
                                this.fcd.eJR = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            vN(true);
                            if (this.fcd != null) {
                                this.fcd.eJR = 0;
                                i2 = 0;
                            }
                        }
                        FS(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        vN(true);
                    }
                    i2 = 0;
                    FS(i2);
                } else if (view == this.lWF.dqg()) {
                    this.lWF.playAnimation();
                    if (this.fcd != null) {
                        this.fcd.type = 2;
                        this.fcd.eJO = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dqf();
                            if (this.fcd != null) {
                                this.fcd.eJV = 0;
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
                            vN(false);
                            if (this.fcd != null) {
                                this.fcd.eJV = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        vN(false);
                        if (this.fcd != null) {
                            this.fcd.eJV = 1;
                        }
                    }
                    FS(i);
                }
                this.fbZ.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lFA != null && this.lFA.diN() != null && this.lFA.diN().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lFA.diN().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.fbZ));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.fbZ));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.fcd);
                bts();
            } else if (view == this.lWG.dqg()) {
                if (this.lFA != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lFA.diN(), 3);
                }
            } else if (view == this.lWH.dqg() && this.lFA != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lFA.diN(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void FS(int i) {
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
            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
            if (bV != null) {
                httpMessage.addParam("obj_source", bV.getCurrentPageKey());
            }
            if (!TextUtils.isEmpty(this.mAgreeData.postId)) {
                httpMessage.addParam("post_id", this.mAgreeData.postId);
            }
            if (this.lFA != null && this.lFA.diN() != null && this.lFA.diN().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lFA.diN().getBaijiahaoData();
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

    public void vN(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.lWE.lWJ;
        TBLottieAnimationView tBLottieAnimationView2 = this.lWF.lWJ;
        TextView textView = this.lWE.textView;
        TextView textView2 = this.lWF.textView;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
        textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
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
                textView.setTextColor(ao.getColor(R.color.CAM_X0301));
                textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
                return;
            }
            textView.setTextColor(ao.getColor(R.color.CAM_X0107));
            textView2.setTextColor(ao.getColor(R.color.CAM_X0304));
            return;
        }
        textView.setTextColor(ao.getColor(R.color.CAM_X0107));
        textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
    }

    public void dqf() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dqg = this.lWE.dqg();
            ao.a(dqg, R.raw.lottie_agree);
            TBLottieAnimationView dqg2 = this.lWF.dqg();
            ao.a(dqg2, R.raw.lottie_disagree);
            TextView textView = this.lWE.getTextView();
            TextView textView2 = this.lWF.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dqg2.setProgress(0.0f);
                    dqg.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
                } else {
                    dqg.setProgress(0.0f);
                    dqg2.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ao.getColor(R.color.CAM_X0304));
                }
            } else {
                dqg.setMinAndMaxProgress(0.0f, 0.0f);
                dqg2.setMinAndMaxProgress(0.0f, 0.0f);
                dqg.setProgress(0.0f);
                dqg2.setProgress(0.0f);
                textView.setTextColor(ao.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dqg.setAlpha(0.5f);
                dqg2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dqg.setAlpha(0.66f);
                dqg2.setAlpha(0.66f);
            } else {
                dqg.setAlpha(1.0f);
                dqg2.setAlpha(1.0f);
            }
            if (this.lFA != null && this.lFA.diN() != null) {
                setVisibility(this.lFA.diN().bmg() ? 8 : 0);
            }
        }
    }

    public void bts() {
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
        if (this.fcd != null) {
            if (this.lFA == null || this.lFA.diN() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                i2 = 1;
            } else {
                bz diN = this.lFA.diN();
                if (diN.bme()) {
                    i3 = 2;
                } else if (diN.bmf()) {
                    i3 = 3;
                } else if (diN.bpv()) {
                    i3 = 4;
                } else {
                    i3 = diN.bpw() ? 5 : 1;
                }
                str6 = diN.blV();
                if (diN.getBaijiahaoData() != null && !at.isEmpty(diN.getBaijiahaoData().oriUgcVid)) {
                    str7 = diN.getBaijiahaoData().oriUgcVid;
                }
                i = diN.bpz();
                str4 = diN.mRecomSource;
                str3 = diN.mRecomAbTag;
                str2 = diN.mRecomWeight;
                str = diN.mRecomExtra;
                str5 = str7;
                i2 = i3;
            }
            if (this.fcd.type == 1) {
                aq dW = new aq("c12003").an("obj_locate", this.fcd.eJO).an("obj_param1", this.fcd.eJP).an("obj_source", this.fcd.eJQ).an("obj_id", this.fcd.eJR).an("obj_name", i2).dW(IntentConfig.NID, str6).an(IntentConfig.CARD_TYPE, i).dW(IntentConfig.RECOM_SOURCE, str4).dW("ab_tag", str3).dW("weight", str2).dW("recom_extra", str).dW("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dW);
                }
                com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
                if (bV != null) {
                    dW.dW("obj_cur_page", bV.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                    dW.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                }
                TiebaStatic.log(dW);
            } else if (this.fcd.type == 2) {
                aq dW2 = new aq("c13271").an("obj_type", this.fcd.eJT).an("obj_locate", this.fcd.eJU).an("obj_id", this.fcd.eJV).an("obj_name", i2).dW(IntentConfig.NID, str6).an(IntentConfig.CARD_TYPE, i).dW(IntentConfig.RECOM_SOURCE, str4).dW("ab_tag", str3).dW("weight", str2).dW("recom_extra", str).dW("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dW2);
                }
                TiebaStatic.log(dW2);
            }
        }
    }

    public void byV() {
        this.lWG.FU(R.color.CAM_X0107);
        this.lWH.FU(R.color.CAM_X0107);
        this.lWG.setImageResource(R.drawable.icon_weixin_112);
        this.lWH.setImageResource(R.drawable.icon_pengyouqun_112);
        this.lWE.dqh();
        this.lWF.dqh();
        this.lWG.dqh();
        this.lWH.dqh();
        dqf();
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
        this.fcd = dVar;
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

    private a FT(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private View aaQ;
        private TBLottieAnimationView lWJ;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.aaQ = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lWJ = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dqg() {
            return this.lWJ;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lWJ.playAnimation();
        }

        public void setImageResource(int i) {
            ao.setImageResource(this.lWJ, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void FU(int i) {
            ao.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lWJ.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lWJ.addAnimatorListener(animatorListener);
        }

        public void dqh() {
            com.baidu.tbadk.core.util.f.a.btb().oQ(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).oR(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oP(R.color.cp_cont_f_alpha50).oK(R.color.CAM_X0201).bz(this.aaQ);
        }
    }
}
