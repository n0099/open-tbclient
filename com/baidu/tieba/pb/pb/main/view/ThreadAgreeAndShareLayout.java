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
    private e dDk;
    private d dDo;
    private CustomMessageListener dDu;
    private CustomMessageListener dDv;
    private a jGi;
    private a jGj;
    private a jGk;
    private a jGl;
    private com.baidu.tieba.pb.data.e jqV;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dDu);
        MessageManager.getInstance().registerListener(this.dDv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dDu);
        MessageManager.getInstance().unRegisterListener(this.dDv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            cCl();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDu = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.dDk != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.dDk.uniqueId != ThreadAgreeAndShareLayout.this.dDk.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.jqV != null && ThreadAgreeAndShareLayout.this.jqV.cvu() != null && ThreadAgreeAndShareLayout.this.jqV.cvu().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.jqV.cvu().getBaijiahaoData().oriUgcNid)) {
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
        this.dDv = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.dDk.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.aS(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.dDk = new e();
        this.dDk.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.dDo = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.jGi = zV(0);
        this.jGj = zV(dimenPixelSize);
        this.jGk = zV(dimenPixelSize);
        this.jGl = zV(dimenPixelSize);
        this.jGk.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jGl.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jGk.setText(R.string.share_weixin_friend);
        this.jGl.setText(R.string.share_weixin_timeline);
        this.jGi.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jGi.addAnimatorListener(this);
        this.jGj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jGj.addAnimatorListener(this);
        this.jGi.cCm().setOnClickListener(this.mOnClickListener);
        this.jGj.cCm().setOnClickListener(this.mOnClickListener);
        this.jGk.cCm().setOnClickListener(this.mOnClickListener);
        this.jGl.cCm().setOnClickListener(this.mOnClickListener);
        aVd();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jqV = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        cCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.jGi.cCm() || view == this.jGj.cCm()) {
                if (view == this.jGi.cCm()) {
                    this.jGi.playAnimation();
                    if (this.dDo != null) {
                        this.dDo.type = 1;
                        this.dDo.dmT = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            cCl();
                            if (this.dDo != null) {
                                this.dDo.dmW = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            rS(true);
                            if (this.dDo != null) {
                                this.dDo.dmW = 0;
                                i2 = 0;
                            }
                        }
                        lc(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        rS(true);
                    }
                    i2 = 0;
                    lc(i2);
                } else if (view == this.jGj.cCm()) {
                    this.jGj.playAnimation();
                    if (this.dDo != null) {
                        this.dDo.type = 2;
                        this.dDo.dmT = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            cCl();
                            if (this.dDo != null) {
                                this.dDo.dna = 0;
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
                            rS(false);
                            if (this.dDo != null) {
                                this.dDo.dna = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        rS(false);
                        if (this.dDo != null) {
                            this.dDo.dna = 1;
                        }
                    }
                    lc(i);
                }
                this.dDk.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.jqV != null && this.jqV.cvu() != null && this.jqV.cvu().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.jqV.cvu().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dDk));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dDk));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.dDo);
                aPQ();
            } else if (view == this.jGk.cCm()) {
                if (this.jqV != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.jqV.cvu(), 3);
                }
            } else if (view == this.jGl.cCm() && this.jqV != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.jqV.cvu(), 2);
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void lc(int i) {
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
            if (this.jqV != null && this.jqV.cvu() != null && this.jqV.cvu().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.jqV.cvu().getBaijiahaoData();
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

    public void rS(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.jGi.jGn;
        TBLottieAnimationView tBLottieAnimationView2 = this.jGj.jGn;
        TextView textView = this.jGi.textView;
        TextView textView2 = this.jGj.textView;
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

    public void cCl() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cCm = this.jGi.cCm();
            am.a(cCm, R.raw.lottie_agree);
            TBLottieAnimationView cCm2 = this.jGj.cCm();
            am.a(cCm2, R.raw.lottie_disagree);
            TextView textView = this.jGi.getTextView();
            TextView textView2 = this.jGj.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cCm2.setProgress(0.0f);
                    cCm.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    cCm.setProgress(0.0f);
                    cCm2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cCm.setMinAndMaxProgress(0.0f, 0.0f);
                cCm2.setMinAndMaxProgress(0.0f, 0.0f);
                cCm.setProgress(0.0f);
                cCm2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cCm.setAlpha(0.5f);
                cCm2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cCm.setAlpha(0.66f);
                cCm2.setAlpha(0.66f);
            } else {
                cCm.setAlpha(1.0f);
                cCm2.setAlpha(1.0f);
            }
            if (this.jqV != null && this.jqV.cvu() != null) {
                setVisibility(this.jqV.cvu().aMA() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aPQ() {
        int i;
        if (this.dDo != null) {
            if (this.jqV != null && this.jqV.cvu() != null) {
                bj cvu = this.jqV.cvu();
                if (cvu.aJt()) {
                    i = 2;
                } else if (cvu.aJu()) {
                    i = 3;
                } else if (cvu.aMy()) {
                    i = 4;
                } else if (cvu.aMz()) {
                    i = 5;
                }
                if (this.dDo.type != 1) {
                    TiebaStatic.log(new an("c12003").af("obj_locate", this.dDo.dmT).af("obj_param1", this.dDo.dmU).af("obj_source", this.dDo.dmV).af("obj_id", this.dDo.dmW).af("obj_name", i));
                    return;
                } else if (this.dDo.type == 2) {
                    TiebaStatic.log(new an("c13271").af("obj_type", this.dDo.dmY).af("obj_locate", this.dDo.dmZ).af("obj_id", this.dDo.dna).af("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.dDo.type != 1) {
            }
        }
    }

    public void aVd() {
        this.jGk.zW(R.color.cp_cont_j);
        this.jGl.zW(R.color.cp_cont_j);
        this.jGk.setImageResource(R.drawable.icon_weixin_112);
        this.jGl.setImageResource(R.drawable.icon_pengyouqun_112);
        this.jGi.cCn();
        this.jGj.cCn();
        this.jGk.cCn();
        this.jGl.cCn();
        cCl();
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
        this.dDo = dVar;
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

    private a zV(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private View Xe;
        private TBLottieAnimationView jGn;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Xe = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.jGn = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cCm() {
            return this.jGn;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.jGn.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.jGn, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zW(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.jGn.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.jGn.addAnimatorListener(animatorListener);
        }

        public void cCn() {
            com.baidu.tbadk.core.util.e.a.aPu().kQ(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kR(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).kP(R.color.cp_cont_f_alpha50).kM(R.color.cp_bg_line_d).aR(this.Xe);
        }
    }
}
