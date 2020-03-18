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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.d;
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
    private e ddL;
    private d ddP;
    private CustomMessageListener ddV;
    private CustomMessageListener ddW;
    private com.baidu.tieba.pb.data.e iGO;
    private a iWa;
    private a iWb;
    private a iWc;
    private a iWd;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddV);
        MessageManager.getInstance().registerListener(this.ddW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddV);
        MessageManager.getInstance().unRegisterListener(this.ddW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            crF();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddV = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.ddL != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.ddL.uniqueId != ThreadAgreeAndShareLayout.this.ddL.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.iGO != null && ThreadAgreeAndShareLayout.this.iGO.ckP() != null && ThreadAgreeAndShareLayout.this.iGO.ckP().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.iGO.ckP().getBaijiahaoData().oriUgcNid)) {
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
        this.ddW = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.ddL.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.aR(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.ddL = new e();
        this.ddL.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.ddP = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.iWa = zu(0);
        this.iWb = zu(dimenPixelSize);
        this.iWc = zu(dimenPixelSize);
        this.iWd = zu(dimenPixelSize);
        this.iWc.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iWd.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iWc.setText(R.string.share_weixin_friend);
        this.iWd.setText(R.string.share_weixin_timeline);
        this.iWa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iWa.addAnimatorListener(this);
        this.iWb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iWb.addAnimatorListener(this);
        this.iWa.crG().setOnClickListener(this.mOnClickListener);
        this.iWb.crG().setOnClickListener(this.mOnClickListener);
        this.iWc.crG().setOnClickListener(this.mOnClickListener);
        this.iWd.crG().setOnClickListener(this.mOnClickListener);
        aMG();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iGO = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        crF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.iWa.crG() || view == this.iWb.crG()) {
                if (view == this.iWa.crG()) {
                    this.iWa.playAnimation();
                    if (this.ddP != null) {
                        this.ddP.type = 1;
                        this.ddP.cNP = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            crF();
                            if (this.ddP != null) {
                                this.ddP.cNS = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            qO(true);
                            if (this.ddP != null) {
                                this.ddP.cNS = 0;
                                i2 = 0;
                            }
                        }
                        kS(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        qO(true);
                    }
                    i2 = 0;
                    kS(i2);
                } else if (view == this.iWb.crG()) {
                    this.iWb.playAnimation();
                    if (this.ddP != null) {
                        this.ddP.type = 2;
                        this.ddP.cNP = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            crF();
                            if (this.ddP != null) {
                                this.ddP.cNW = 0;
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
                            qO(false);
                            if (this.ddP != null) {
                                this.ddP.cNW = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        qO(false);
                        if (this.ddP != null) {
                            this.ddP.cNW = 1;
                        }
                    }
                    kS(i);
                }
                this.ddL.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.iGO != null && this.iGO.ckP() != null && this.iGO.ckP().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.iGO.ckP().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddL));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddL));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.ddP);
                aHy();
            } else if (view == this.iWc.crG()) {
                if (this.iGO != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iGO.ckP(), 3);
                }
            } else if (view == this.iWd.crG() && this.iGO != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iGO.ckP(), 2);
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void kS(int i) {
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
            if (this.iGO != null && this.iGO.ckP() != null && this.iGO.ckP().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.iGO.ckP().getBaijiahaoData();
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

    public void qO(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.iWa.iWf;
        TBLottieAnimationView tBLottieAnimationView2 = this.iWb.iWf;
        TextView textView = this.iWa.textView;
        TextView textView2 = this.iWb.textView;
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

    public void crF() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView crG = this.iWa.crG();
            am.a(crG, R.raw.lottie_agree);
            TBLottieAnimationView crG2 = this.iWb.crG();
            am.a(crG2, R.raw.lottie_disagree);
            TextView textView = this.iWa.getTextView();
            TextView textView2 = this.iWb.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    crG2.setProgress(0.0f);
                    crG.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    crG.setProgress(0.0f);
                    crG2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                crG.setMinAndMaxProgress(0.0f, 0.0f);
                crG2.setMinAndMaxProgress(0.0f, 0.0f);
                crG.setProgress(0.0f);
                crG2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                crG.setAlpha(0.5f);
                crG2.setAlpha(0.5f);
            } else if (skinType == 4) {
                crG.setAlpha(0.66f);
                crG2.setAlpha(0.66f);
            } else {
                crG.setAlpha(1.0f);
                crG2.setAlpha(1.0f);
            }
            if (this.iGO != null && this.iGO.ckP() != null) {
                setVisibility(this.iGO.ckP().aEm() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aHy() {
        int i;
        if (this.ddP != null) {
            if (this.iGO != null && this.iGO.ckP() != null) {
                bj ckP = this.iGO.ckP();
                if (ckP.aBg()) {
                    i = 2;
                } else if (ckP.aBh()) {
                    i = 3;
                } else if (ckP.aEk()) {
                    i = 4;
                } else if (ckP.aEl()) {
                    i = 5;
                }
                if (this.ddP.type != 1) {
                    TiebaStatic.log(new an("c12003").X("obj_locate", this.ddP.cNP).X("obj_param1", this.ddP.cNQ).X("obj_source", this.ddP.cNR).X("obj_id", this.ddP.cNS).X("obj_name", i));
                    return;
                } else if (this.ddP.type == 2) {
                    TiebaStatic.log(new an("c13271").X("obj_type", this.ddP.cNU).X("obj_locate", this.ddP.cNV).X("obj_id", this.ddP.cNW).X("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.ddP.type != 1) {
            }
        }
    }

    public void aMG() {
        this.iWc.zv(R.color.cp_cont_j);
        this.iWd.zv(R.color.cp_cont_j);
        this.iWc.setImageResource(R.drawable.icon_weixin_112);
        this.iWd.setImageResource(R.drawable.icon_pengyouqun_112);
        this.iWa.crH();
        this.iWb.crH();
        this.iWc.crH();
        this.iWd.crH();
        crF();
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
        this.ddP = dVar;
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

    private a zu(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private View DM;
        private TBLottieAnimationView iWf;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.DM = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.iWf = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView crG() {
            return this.iWf;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.iWf.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.iWf, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zv(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.iWf.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.iWf.addAnimatorListener(animatorListener);
        }

        public void crH() {
            com.baidu.tbadk.core.util.e.a.aHf().kG(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kH(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).kF(R.color.cp_cont_f_alpha50).kC(R.color.cp_bg_line_d).aQ(this.DM);
        }
    }
}
