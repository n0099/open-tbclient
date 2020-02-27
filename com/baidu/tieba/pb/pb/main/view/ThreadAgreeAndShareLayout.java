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
    private e ddj;
    private d ddn;
    private CustomMessageListener ddt;
    private CustomMessageListener ddv;
    private com.baidu.tieba.pb.data.e iEZ;
    private a iUl;
    private a iUm;
    private a iUn;
    private a iUo;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddt);
        MessageManager.getInstance().registerListener(this.ddv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddt);
        MessageManager.getInstance().unRegisterListener(this.ddv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            crh();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddt = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.ddj != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.ddj.uniqueId != ThreadAgreeAndShareLayout.this.ddj.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.iEZ != null && ThreadAgreeAndShareLayout.this.iEZ.cks() != null && ThreadAgreeAndShareLayout.this.iEZ.cks().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.iEZ.cks().getBaijiahaoData().oriUgcNid)) {
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
        this.ddv = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.ddj.uniqueId != eVar.uniqueId) {
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
        this.ddj = new e();
        this.ddj.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.ddn = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.iUl = zm(0);
        this.iUm = zm(dimenPixelSize);
        this.iUn = zm(dimenPixelSize);
        this.iUo = zm(dimenPixelSize);
        this.iUn.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iUo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iUn.setText(R.string.share_weixin_friend);
        this.iUo.setText(R.string.share_weixin_timeline);
        this.iUl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iUl.addAnimatorListener(this);
        this.iUm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iUm.addAnimatorListener(this);
        this.iUl.cri().setOnClickListener(this.mOnClickListener);
        this.iUm.cri().setOnClickListener(this.mOnClickListener);
        this.iUn.cri().setOnClickListener(this.mOnClickListener);
        this.iUo.cri().setOnClickListener(this.mOnClickListener);
        aMz();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iEZ = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        crh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.iUl.cri() || view == this.iUm.cri()) {
                if (view == this.iUl.cri()) {
                    this.iUl.playAnimation();
                    if (this.ddn != null) {
                        this.ddn.type = 1;
                        this.ddn.cNA = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            crh();
                            if (this.ddn != null) {
                                this.ddn.cND = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            qI(true);
                            if (this.ddn != null) {
                                this.ddn.cND = 0;
                                i2 = 0;
                            }
                        }
                        kS(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        qI(true);
                    }
                    i2 = 0;
                    kS(i2);
                } else if (view == this.iUm.cri()) {
                    this.iUm.playAnimation();
                    if (this.ddn != null) {
                        this.ddn.type = 2;
                        this.ddn.cNA = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            crh();
                            if (this.ddn != null) {
                                this.ddn.cNH = 0;
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
                            qI(false);
                            if (this.ddn != null) {
                                this.ddn.cNH = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        qI(false);
                        if (this.ddn != null) {
                            this.ddn.cNH = 1;
                        }
                    }
                    kS(i);
                }
                this.ddj.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.iEZ != null && this.iEZ.cks() != null && this.iEZ.cks().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.iEZ.cks().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddj));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddj));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.ddn);
                aHr();
            } else if (view == this.iUn.cri()) {
                if (this.iEZ != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iEZ.cks(), 3);
                }
            } else if (view == this.iUo.cri() && this.iEZ != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iEZ.cks(), 2);
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
            if (this.iEZ != null && this.iEZ.cks() != null && this.iEZ.cks().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.iEZ.cks().getBaijiahaoData();
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

    public void qI(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.iUl.iUq;
        TBLottieAnimationView tBLottieAnimationView2 = this.iUm.iUq;
        TextView textView = this.iUl.textView;
        TextView textView2 = this.iUm.textView;
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

    public void crh() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cri = this.iUl.cri();
            am.a(cri, R.raw.lottie_agree);
            TBLottieAnimationView cri2 = this.iUm.cri();
            am.a(cri2, R.raw.lottie_disagree);
            TextView textView = this.iUl.getTextView();
            TextView textView2 = this.iUm.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cri2.setProgress(0.0f);
                    cri.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    cri.setProgress(0.0f);
                    cri2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cri.setMinAndMaxProgress(0.0f, 0.0f);
                cri2.setMinAndMaxProgress(0.0f, 0.0f);
                cri.setProgress(0.0f);
                cri2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cri.setAlpha(0.5f);
                cri2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cri.setAlpha(0.66f);
                cri2.setAlpha(0.66f);
            } else {
                cri.setAlpha(1.0f);
                cri2.setAlpha(1.0f);
            }
            if (this.iEZ != null && this.iEZ.cks() != null) {
                setVisibility(this.iEZ.cks().aEg() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aHr() {
        int i;
        if (this.ddn != null) {
            if (this.iEZ != null && this.iEZ.cks() != null) {
                bj cks = this.iEZ.cks();
                if (cks.aBb()) {
                    i = 2;
                } else if (cks.aBc()) {
                    i = 3;
                } else if (cks.aEe()) {
                    i = 4;
                } else if (cks.aEf()) {
                    i = 5;
                }
                if (this.ddn.type != 1) {
                    TiebaStatic.log(new an("c12003").X("obj_locate", this.ddn.cNA).X("obj_param1", this.ddn.cNB).X("obj_source", this.ddn.cNC).X("obj_id", this.ddn.cND).X("obj_name", i));
                    return;
                } else if (this.ddn.type == 2) {
                    TiebaStatic.log(new an("c13271").X("obj_type", this.ddn.cNF).X("obj_locate", this.ddn.cNG).X("obj_id", this.ddn.cNH).X("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.ddn.type != 1) {
            }
        }
    }

    public void aMz() {
        this.iUn.zn(R.color.cp_cont_j);
        this.iUo.zn(R.color.cp_cont_j);
        this.iUn.setImageResource(R.drawable.icon_weixin_112);
        this.iUo.setImageResource(R.drawable.icon_pengyouqun_112);
        this.iUl.crj();
        this.iUm.crj();
        this.iUn.crj();
        this.iUo.crj();
        crh();
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
        this.ddn = dVar;
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

    private a zm(int i) {
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
        private TBLottieAnimationView iUq;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.DM = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.iUq = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cri() {
            return this.iUq;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.iUq.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.iUq, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zn(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.iUq.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.iUq.addAnimatorListener(animatorListener);
        }

        public void crj() {
            com.baidu.tbadk.core.util.f.a.aGY().kG(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kH(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).kF(R.color.cp_cont_f_alpha50).kC(R.color.cp_bg_line_d).aQ(this.DM);
        }
    }
}
