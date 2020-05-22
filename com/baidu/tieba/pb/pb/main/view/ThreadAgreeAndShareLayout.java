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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes9.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private CustomMessageListener dRK;
    private CustomMessageListener dRL;
    private e dRv;
    private com.baidu.tbadk.core.data.c dRz;
    private com.baidu.tieba.pb.data.e jHO;
    private a jXT;
    private a jXU;
    private a jXV;
    private a jXW;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRK);
        MessageManager.getInstance().registerListener(this.dRL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dRK);
        MessageManager.getInstance().unRegisterListener(this.dRL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            cJg();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.dRv != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.dRv.uniqueId != ThreadAgreeAndShareLayout.this.dRv.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.jHO != null && ThreadAgreeAndShareLayout.this.jHO.cCi() != null && ThreadAgreeAndShareLayout.this.jHO.cCi().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.jHO.cCi().getBaijiahaoData().oriUgcNid)) {
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
        this.dRL = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.dRv.uniqueId != eVar.uniqueId) {
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
        this.dRv = new e();
        this.dRv.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.dRz = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.jXT = AG(0);
        this.jXU = AG(dimenPixelSize);
        this.jXV = AG(dimenPixelSize);
        this.jXW = AG(dimenPixelSize);
        this.jXV.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jXW.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jXV.setText(R.string.share_weixin_friend);
        this.jXW.setText(R.string.share_weixin_timeline);
        this.jXT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jXT.addAnimatorListener(this);
        this.jXU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jXU.addAnimatorListener(this);
        this.jXT.cJh().setOnClickListener(this.mOnClickListener);
        this.jXU.cJh().setOnClickListener(this.mOnClickListener);
        this.jXV.cJh().setOnClickListener(this.mOnClickListener);
        this.jXW.cJh().setOnClickListener(this.mOnClickListener);
        bbl();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jHO = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        cJg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.jXT.cJh() || view == this.jXU.cJh()) {
                if (view == this.jXT.cJh()) {
                    this.jXT.playAnimation();
                    if (this.dRz != null) {
                        this.dRz.type = 1;
                        this.dRz.dAZ = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            cJg();
                            if (this.dRz != null) {
                                this.dRz.dBc = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            sq(true);
                            if (this.dRz != null) {
                                this.dRz.dBc = 0;
                                i2 = 0;
                            }
                        }
                        lE(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        sq(true);
                    }
                    i2 = 0;
                    lE(i2);
                } else if (view == this.jXU.cJh()) {
                    this.jXU.playAnimation();
                    if (this.dRz != null) {
                        this.dRz.type = 2;
                        this.dRz.dAZ = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            cJg();
                            if (this.dRz != null) {
                                this.dRz.dBg = 0;
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
                            sq(false);
                            if (this.dRz != null) {
                                this.dRz.dBg = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        sq(false);
                        if (this.dRz != null) {
                            this.dRz.dBg = 1;
                        }
                    }
                    lE(i);
                }
                this.dRv.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.jHO != null && this.jHO.cCi() != null && this.jHO.cCi().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.jHO.cCi().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dRv));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dRv));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.dRz);
                aVQ();
            } else if (view == this.jXV.cJh()) {
                if (this.jHO != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.jHO.cCi(), 3);
                }
            } else if (view == this.jXW.cJh() && this.jHO != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.jHO.cCi(), 2);
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void lE(int i) {
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
            if (this.jHO != null && this.jHO.cCi() != null && this.jHO.cCi().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.jHO.cCi().getBaijiahaoData();
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

    public void sq(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.jXT.jXY;
        TBLottieAnimationView tBLottieAnimationView2 = this.jXU.jXY;
        TextView textView = this.jXT.textView;
        TextView textView2 = this.jXU.textView;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
        textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
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
                textView.setTextColor(am.getColor(R.color.cp_cont_h));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                return;
            }
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
            textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        textView.setTextColor(am.getColor(R.color.cp_cont_j));
        textView2.setTextColor(am.getColor(R.color.cp_cont_j));
    }

    public void cJg() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cJh = this.jXT.cJh();
            am.a(cJh, (int) R.raw.lottie_agree);
            TBLottieAnimationView cJh2 = this.jXU.cJh();
            am.a(cJh2, (int) R.raw.lottie_disagree);
            TextView textView = this.jXT.getTextView();
            TextView textView2 = this.jXU.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cJh2.setProgress(0.0f);
                    cJh.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    cJh.setProgress(0.0f);
                    cJh2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cJh.setMinAndMaxProgress(0.0f, 0.0f);
                cJh2.setMinAndMaxProgress(0.0f, 0.0f);
                cJh.setProgress(0.0f);
                cJh2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cJh.setAlpha(0.5f);
                cJh2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cJh.setAlpha(0.66f);
                cJh2.setAlpha(0.66f);
            } else {
                cJh.setAlpha(1.0f);
                cJh2.setAlpha(1.0f);
            }
            if (this.jHO != null && this.jHO.cCi() != null) {
                setVisibility(this.jHO.cCi().aSx() ? 8 : 0);
            }
        }
    }

    public void aVQ() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.dRz != null) {
            if (this.jHO == null || this.jHO.cCi() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bk cCi = this.jHO.cCi();
                if (cCi.aPm()) {
                    i3 = 2;
                } else if (cCi.aPn()) {
                    i3 = 3;
                } else if (cCi.aSv()) {
                    i3 = 4;
                } else {
                    i3 = cCi.aSw() ? 5 : 1;
                }
                String nid = cCi.getNid();
                if (cCi.getBaijiahaoData() != null && !aq.isEmpty(cCi.getBaijiahaoData().oriUgcVid)) {
                    str6 = cCi.getBaijiahaoData().oriUgcVid;
                }
                int aSA = cCi.aSA();
                String str7 = cCi.mRecomSource;
                String str8 = cCi.mRecomAbTag;
                String str9 = cCi.mRecomWeight;
                String str10 = cCi.mRecomExtra;
                str = str8;
                i = aSA;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.dRz.type == 1) {
                an dh = new an("c12003").ag("obj_locate", this.dRz.dAZ).ag("obj_param1", this.dRz.dBa).ag("obj_source", this.dRz.dBb).ag("obj_id", this.dRz.dBc).ag("obj_name", i2).dh("nid", str4).ag(IntentConfig.CARD_TYPE, i).dh(IntentConfig.RECOM_SOURCE, str2).dh("ab_tag", str).dh("weight", str5).dh("recom_extra", str6).dh("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dh);
                }
                TiebaStatic.log(dh);
            } else if (this.dRz.type == 2) {
                an dh2 = new an("c13271").ag("obj_type", this.dRz.dBe).ag("obj_locate", this.dRz.dBf).ag("obj_id", this.dRz.dBg).ag("obj_name", i2).dh("nid", str4).ag(IntentConfig.CARD_TYPE, i).dh(IntentConfig.RECOM_SOURCE, str2).dh("ab_tag", str).dh("weight", str5).dh("recom_extra", str6).dh("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dh2);
                }
                TiebaStatic.log(dh2);
            }
        }
    }

    public void bbl() {
        this.jXV.AH(R.color.cp_cont_j);
        this.jXW.AH(R.color.cp_cont_j);
        this.jXV.setImageResource(R.drawable.icon_weixin_112);
        this.jXW.setImageResource(R.drawable.icon_pengyouqun_112);
        this.jXT.cJi();
        this.jXU.cJi();
        this.jXV.cJi();
        this.jXW.cJi();
        cJg();
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
        this.dRz = cVar;
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

    private a AG(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private View Xw;
        private TBLottieAnimationView jXY;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Xw = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.jXY = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cJh() {
            return this.jXY;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.jXY.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.jXY, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void AH(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.jXY.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.jXY.addAnimatorListener(animatorListener);
        }

        public void cJi() {
            com.baidu.tbadk.core.util.e.a.aVv().ls(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).lt(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).lr(R.color.cp_cont_f_alpha50).lo(R.color.cp_bg_line_d).aR(this.Xw);
        }
    }
}
