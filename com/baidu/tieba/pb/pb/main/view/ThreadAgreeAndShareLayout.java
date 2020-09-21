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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes21.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private CustomMessageListener eqL;
    private e equ;
    private com.baidu.tbadk.core.data.c eqy;
    private f kJe;
    private a kZW;
    private a kZX;
    private a kZY;
    private a kZZ;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eqL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eqL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dfW();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.equ != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.equ.uniqueId != ThreadAgreeAndShareLayout.this.equ.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.kJe != null && ThreadAgreeAndShareLayout.this.kJe.cYR() != null && ThreadAgreeAndShareLayout.this.kJe.cYR().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.kJe.cYR().getBaijiahaoData().oriUgcNid)) {
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
        this.eqL = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.equ.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bd(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.equ = new e();
        this.equ.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eqy = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.kZW = Ff(0);
        this.kZX = Ff(dimenPixelSize);
        this.kZY = Ff(dimenPixelSize);
        this.kZZ = Ff(dimenPixelSize);
        this.kZY.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kZZ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kZY.setText(R.string.share_weixin_friend);
        this.kZZ.setText(R.string.share_weixin_timeline);
        this.kZW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kZW.addAnimatorListener(this);
        this.kZX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kZX.addAnimatorListener(this);
        this.kZW.dfX().setOnClickListener(this.mOnClickListener);
        this.kZX.dfX().setOnClickListener(this.mOnClickListener);
        this.kZY.dfX().setOnClickListener(this.mOnClickListener);
        this.kZZ.dfX().setOnClickListener(this.mOnClickListener);
        bqC();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kJe = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dfW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.kZW.dfX() || view == this.kZX.dfX()) {
                if (view == this.kZW.dfX()) {
                    this.kZW.playAnimation();
                    if (this.eqy != null) {
                        this.eqy.type = 1;
                        this.eqy.dYY = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dfW();
                            if (this.eqy != null) {
                                this.eqy.dZb = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            ud(true);
                            if (this.eqy != null) {
                                this.eqy.dZb = 0;
                                i2 = 0;
                            }
                        }
                        Fe(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        ud(true);
                    }
                    i2 = 0;
                    Fe(i2);
                } else if (view == this.kZX.dfX()) {
                    this.kZX.playAnimation();
                    if (this.eqy != null) {
                        this.eqy.type = 2;
                        this.eqy.dYY = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dfW();
                            if (this.eqy != null) {
                                this.eqy.dZf = 0;
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
                            ud(false);
                            if (this.eqy != null) {
                                this.eqy.dZf = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        ud(false);
                        if (this.eqy != null) {
                            this.eqy.dZf = 1;
                        }
                    }
                    Fe(i);
                }
                this.equ.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.kJe != null && this.kJe.cYR() != null && this.kJe.cYR().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.kJe.cYR().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.equ));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.equ));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eqy);
                blc();
            } else if (view == this.kZY.dfX()) {
                if (this.kJe != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kJe.cYR(), 3);
                }
            } else if (view == this.kZZ.dfX() && this.kJe != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kJe.cYR(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Fe(int i) {
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
            if (this.kJe != null && this.kJe.cYR() != null && this.kJe.cYR().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.kJe.cYR().getBaijiahaoData();
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

    public void ud(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.kZW.lab;
        TBLottieAnimationView tBLottieAnimationView2 = this.kZX.lab;
        TextView textView = this.kZW.textView;
        TextView textView2 = this.kZX.textView;
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
                textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                return;
            }
            textView.setTextColor(ap.getColor(R.color.cp_cont_j));
            textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        textView.setTextColor(ap.getColor(R.color.cp_cont_j));
        textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
    }

    public void dfW() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dfX = this.kZW.dfX();
            ap.a(dfX, R.raw.lottie_agree);
            TBLottieAnimationView dfX2 = this.kZX.dfX();
            ap.a(dfX2, R.raw.lottie_disagree);
            TextView textView = this.kZW.getTextView();
            TextView textView2 = this.kZX.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dfX2.setProgress(0.0f);
                    dfX.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                } else {
                    dfX.setProgress(0.0f);
                    dfX2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
                }
            } else {
                dfX.setMinAndMaxProgress(0.0f, 0.0f);
                dfX2.setMinAndMaxProgress(0.0f, 0.0f);
                dfX.setProgress(0.0f);
                dfX2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dfX.setAlpha(0.5f);
                dfX2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dfX.setAlpha(0.66f);
                dfX2.setAlpha(0.66f);
            } else {
                dfX.setAlpha(1.0f);
                dfX2.setAlpha(1.0f);
            }
            if (this.kJe != null && this.kJe.cYR() != null) {
                setVisibility(this.kJe.cYR().bei() ? 8 : 0);
            }
        }
    }

    public void blc() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eqy != null) {
            if (this.kJe == null || this.kJe.cYR() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bw cYR = this.kJe.cYR();
                if (cYR.beg()) {
                    i3 = 2;
                } else if (cYR.beh()) {
                    i3 = 3;
                } else if (cYR.bht()) {
                    i3 = 4;
                } else {
                    i3 = cYR.bhu() ? 5 : 1;
                }
                String nid = cYR.getNid();
                if (cYR.getBaijiahaoData() != null && !at.isEmpty(cYR.getBaijiahaoData().oriUgcVid)) {
                    str6 = cYR.getBaijiahaoData().oriUgcVid;
                }
                int bhx = cYR.bhx();
                String str7 = cYR.mRecomSource;
                String str8 = cYR.mRecomAbTag;
                String str9 = cYR.mRecomWeight;
                String str10 = cYR.mRecomExtra;
                str = str8;
                i = bhx;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eqy.type == 1) {
                aq dF = new aq("c12003").ai("obj_locate", this.eqy.dYY).ai("obj_param1", this.eqy.dYZ).ai("obj_source", this.eqy.dZa).ai("obj_id", this.eqy.dZb).ai("obj_name", i2).dF("nid", str4).ai(IntentConfig.CARD_TYPE, i).dF(IntentConfig.RECOM_SOURCE, str2).dF("ab_tag", str).dF("weight", str5).dF("recom_extra", str6).dF("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dF);
                }
                TiebaStatic.log(dF);
            } else if (this.eqy.type == 2) {
                aq dF2 = new aq("c13271").ai("obj_type", this.eqy.dZd).ai("obj_locate", this.eqy.dZe).ai("obj_id", this.eqy.dZf).ai("obj_name", i2).dF("nid", str4).ai(IntentConfig.CARD_TYPE, i).dF(IntentConfig.RECOM_SOURCE, str2).dF("ab_tag", str).dF("weight", str5).dF("recom_extra", str6).dF("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dF2);
                }
                TiebaStatic.log(dF2);
            }
        }
    }

    public void bqC() {
        this.kZY.Fg(R.color.cp_cont_j);
        this.kZZ.Fg(R.color.cp_cont_j);
        this.kZY.setImageResource(R.drawable.icon_weixin_112);
        this.kZZ.setImageResource(R.drawable.icon_pengyouqun_112);
        this.kZW.dfY();
        this.kZX.dfY();
        this.kZY.dfY();
        this.kZZ.dfY();
        dfW();
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
        this.eqy = cVar;
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

    private a Ff(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private View YQ;
        private TBLottieAnimationView lab;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.YQ = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lab = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dfX() {
            return this.lab;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lab.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.lab, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Fg(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lab.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lab.addAnimatorListener(animatorListener);
        }

        public void dfY() {
            com.baidu.tbadk.core.util.e.a.bkL().ov(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).ow(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ou(R.color.cp_cont_f_alpha50).or(R.color.cp_bg_line_d).bb(this.YQ);
        }
    }
}
