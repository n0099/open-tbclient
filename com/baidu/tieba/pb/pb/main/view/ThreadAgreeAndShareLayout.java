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
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes9.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private CustomMessageListener dYC;
    private CustomMessageListener dYD;
    private e dYn;
    private com.baidu.tbadk.core.data.c dYr;
    private com.baidu.tieba.pb.data.e kcE;
    private a ksR;
    private a ksS;
    private a ksT;
    private a ksU;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dYC);
        MessageManager.getInstance().registerListener(this.dYD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dYC);
        MessageManager.getInstance().unRegisterListener(this.dYD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            cNO();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.dYn != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.dYn.uniqueId != ThreadAgreeAndShareLayout.this.dYn.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.kcE != null && ThreadAgreeAndShareLayout.this.kcE.cGO() != null && ThreadAgreeAndShareLayout.this.kcE.cGO().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.kcE.cGO().getBaijiahaoData().oriUgcNid)) {
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
        this.dYD = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.dYn.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.aT(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.dYn = new e();
        this.dYn.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.dYr = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.ksR = BK(0);
        this.ksS = BK(dimenPixelSize);
        this.ksT = BK(dimenPixelSize);
        this.ksU = BK(dimenPixelSize);
        this.ksT.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ksU.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ksT.setText(R.string.share_weixin_friend);
        this.ksU.setText(R.string.share_weixin_timeline);
        this.ksR.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ksR.addAnimatorListener(this);
        this.ksS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ksS.addAnimatorListener(this);
        this.ksR.cNP().setOnClickListener(this.mOnClickListener);
        this.ksS.cNP().setOnClickListener(this.mOnClickListener);
        this.ksT.cNP().setOnClickListener(this.mOnClickListener);
        this.ksU.cNP().setOnClickListener(this.mOnClickListener);
        bdo();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kcE = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        cNO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && be.checkUpIsLogin(getContext())) {
            if (view == this.ksR.cNP() || view == this.ksS.cNP()) {
                if (view == this.ksR.cNP()) {
                    this.ksR.playAnimation();
                    if (this.dYr != null) {
                        this.dYr.type = 1;
                        this.dYr.dHq = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            cNO();
                            if (this.dYr != null) {
                                this.dYr.dHt = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            sE(true);
                            if (this.dYr != null) {
                                this.dYr.dHt = 0;
                                i2 = 0;
                            }
                        }
                        lX(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        sE(true);
                    }
                    i2 = 0;
                    lX(i2);
                } else if (view == this.ksS.cNP()) {
                    this.ksS.playAnimation();
                    if (this.dYr != null) {
                        this.dYr.type = 2;
                        this.dYr.dHq = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            cNO();
                            if (this.dYr != null) {
                                this.dYr.dHx = 0;
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
                            sE(false);
                            if (this.dYr != null) {
                                this.dYr.dHx = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        sE(false);
                        if (this.dYr != null) {
                            this.dYr.dHx = 1;
                        }
                    }
                    lX(i);
                }
                this.dYn.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.kcE != null && this.kcE.cGO() != null && this.kcE.cGO().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.kcE.cGO().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dYn));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dYn));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.dYr);
                aXL();
            } else if (view == this.ksT.cNP()) {
                if (this.kcE != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kcE.cGO(), 3);
                }
            } else if (view == this.ksU.cNP() && this.kcE != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kcE.cGO(), 2);
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void lX(int i) {
        if (this.mAgreeData != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
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
            if (this.kcE != null && this.kcE.cGO() != null && this.kcE.cGO().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.kcE.cGO().getBaijiahaoData();
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

    public void sE(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.ksR.ksW;
        TBLottieAnimationView tBLottieAnimationView2 = this.ksS.ksW;
        TextView textView = this.ksR.textView;
        TextView textView2 = this.ksS.textView;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(ar.numFormatOverWanNa(this.mAgreeData.agreeNum));
        textView2.setText(ar.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
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
                textView.setTextColor(an.getColor(R.color.cp_cont_h));
                textView2.setTextColor(an.getColor(R.color.cp_cont_j));
                return;
            }
            textView.setTextColor(an.getColor(R.color.cp_cont_j));
            textView2.setTextColor(an.getColor(R.color.cp_link_tip_c));
            return;
        }
        textView.setTextColor(an.getColor(R.color.cp_cont_j));
        textView2.setTextColor(an.getColor(R.color.cp_cont_j));
    }

    public void cNO() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cNP = this.ksR.cNP();
            an.a(cNP, (int) R.raw.lottie_agree);
            TBLottieAnimationView cNP2 = this.ksS.cNP();
            an.a(cNP2, (int) R.raw.lottie_disagree);
            TextView textView = this.ksR.getTextView();
            TextView textView2 = this.ksS.getTextView();
            textView.setText(ar.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(ar.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cNP2.setProgress(0.0f);
                    cNP.setProgress(1.0f);
                    textView.setTextColor(an.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(an.getColor(R.color.cp_cont_j));
                } else {
                    cNP.setProgress(0.0f);
                    cNP2.setProgress(1.0f);
                    textView.setTextColor(an.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(an.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cNP.setMinAndMaxProgress(0.0f, 0.0f);
                cNP2.setMinAndMaxProgress(0.0f, 0.0f);
                cNP.setProgress(0.0f);
                cNP2.setProgress(0.0f);
                textView.setTextColor(an.getColor(R.color.cp_cont_j));
                textView2.setTextColor(an.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cNP.setAlpha(0.5f);
                cNP2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cNP.setAlpha(0.66f);
                cNP2.setAlpha(0.66f);
            } else {
                cNP.setAlpha(1.0f);
                cNP2.setAlpha(1.0f);
            }
            if (this.kcE != null && this.kcE.cGO() != null) {
                setVisibility(this.kcE.cGO().aQZ() ? 8 : 0);
            }
        }
    }

    public void aXL() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.dYr != null) {
            if (this.kcE == null || this.kcE.cGO() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bu cGO = this.kcE.cGO();
                if (cGO.aQX()) {
                    i3 = 2;
                } else if (cGO.aQY()) {
                    i3 = 3;
                } else if (cGO.aUl()) {
                    i3 = 4;
                } else {
                    i3 = cGO.aUm() ? 5 : 1;
                }
                String nid = cGO.getNid();
                if (cGO.getBaijiahaoData() != null && !ar.isEmpty(cGO.getBaijiahaoData().oriUgcVid)) {
                    str6 = cGO.getBaijiahaoData().oriUgcVid;
                }
                int aUp = cGO.aUp();
                String str7 = cGO.mRecomSource;
                String str8 = cGO.mRecomAbTag;
                String str9 = cGO.mRecomWeight;
                String str10 = cGO.mRecomExtra;
                str = str8;
                i = aUp;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.dYr.type == 1) {
                ao dk = new ao("c12003").ag("obj_locate", this.dYr.dHq).ag("obj_param1", this.dYr.dHr).ag("obj_source", this.dYr.dHs).ag("obj_id", this.dYr.dHt).ag("obj_name", i2).dk("nid", str4).ag(IntentConfig.CARD_TYPE, i).dk(IntentConfig.RECOM_SOURCE, str2).dk("ab_tag", str).dk("weight", str5).dk("recom_extra", str6).dk("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dk);
                }
                TiebaStatic.log(dk);
            } else if (this.dYr.type == 2) {
                ao dk2 = new ao("c13271").ag("obj_type", this.dYr.dHv).ag("obj_locate", this.dYr.dHw).ag("obj_id", this.dYr.dHx).ag("obj_name", i2).dk("nid", str4).ag(IntentConfig.CARD_TYPE, i).dk(IntentConfig.RECOM_SOURCE, str2).dk("ab_tag", str).dk("weight", str5).dk("recom_extra", str6).dk("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dk2);
                }
                TiebaStatic.log(dk2);
            }
        }
    }

    public void bdo() {
        this.ksT.BL(R.color.cp_cont_j);
        this.ksU.BL(R.color.cp_cont_j);
        this.ksT.setImageResource(R.drawable.icon_weixin_112);
        this.ksU.setImageResource(R.drawable.icon_pengyouqun_112);
        this.ksR.cNQ();
        this.ksS.cNQ();
        this.ksT.cNQ();
        this.ksU.cNQ();
        cNO();
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

    public void setStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.dYr = cVar;
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

    private a BK(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private View Ya;
        private TBLottieAnimationView ksW;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Ya = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.ksW = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cNP() {
            return this.ksW;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.ksW.playAnimation();
        }

        public void setImageResource(int i) {
            an.setImageResource(this.ksW, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void BL(int i) {
            an.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.ksW.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.ksW.addAnimatorListener(animatorListener);
        }

        public void cNQ() {
            com.baidu.tbadk.core.util.e.a.aXq().lL(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).lM(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).lK(R.color.cp_cont_f_alpha50).lH(R.color.cp_bg_line_d).aR(this.Ya);
        }
    }
}
