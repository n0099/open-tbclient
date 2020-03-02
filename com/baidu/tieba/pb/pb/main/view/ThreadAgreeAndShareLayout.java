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
    private e ddk;
    private d ddo;
    private CustomMessageListener ddv;
    private CustomMessageListener ddw;
    private com.baidu.tieba.pb.data.e iFb;
    private a iUn;
    private a iUo;
    private a iUp;
    private a iUq;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddv);
        MessageManager.getInstance().registerListener(this.ddw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddv);
        MessageManager.getInstance().unRegisterListener(this.ddw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            crj();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddv = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.ddk != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.ddk.uniqueId != ThreadAgreeAndShareLayout.this.ddk.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.iFb != null && ThreadAgreeAndShareLayout.this.iFb.cku() != null && ThreadAgreeAndShareLayout.this.iFb.cku().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.iFb.cku().getBaijiahaoData().oriUgcNid)) {
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
        this.ddw = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.ddk.uniqueId != eVar.uniqueId) {
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
        this.ddk = new e();
        this.ddk.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.ddo = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.iUn = zm(0);
        this.iUo = zm(dimenPixelSize);
        this.iUp = zm(dimenPixelSize);
        this.iUq = zm(dimenPixelSize);
        this.iUp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iUq.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iUp.setText(R.string.share_weixin_friend);
        this.iUq.setText(R.string.share_weixin_timeline);
        this.iUn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iUn.addAnimatorListener(this);
        this.iUo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iUo.addAnimatorListener(this);
        this.iUn.crk().setOnClickListener(this.mOnClickListener);
        this.iUo.crk().setOnClickListener(this.mOnClickListener);
        this.iUp.crk().setOnClickListener(this.mOnClickListener);
        this.iUq.crk().setOnClickListener(this.mOnClickListener);
        aMB();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iFb = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        crj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.iUn.crk() || view == this.iUo.crk()) {
                if (view == this.iUn.crk()) {
                    this.iUn.playAnimation();
                    if (this.ddo != null) {
                        this.ddo.type = 1;
                        this.ddo.cNB = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            crj();
                            if (this.ddo != null) {
                                this.ddo.cNE = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            qI(true);
                            if (this.ddo != null) {
                                this.ddo.cNE = 0;
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
                } else if (view == this.iUo.crk()) {
                    this.iUo.playAnimation();
                    if (this.ddo != null) {
                        this.ddo.type = 2;
                        this.ddo.cNB = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            crj();
                            if (this.ddo != null) {
                                this.ddo.cNI = 0;
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
                            if (this.ddo != null) {
                                this.ddo.cNI = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        qI(false);
                        if (this.ddo != null) {
                            this.ddo.cNI = 1;
                        }
                    }
                    kS(i);
                }
                this.ddk.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.iFb != null && this.iFb.cku() != null && this.iFb.cku().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.iFb.cku().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddk));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddk));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.ddo);
                aHt();
            } else if (view == this.iUp.crk()) {
                if (this.iFb != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iFb.cku(), 3);
                }
            } else if (view == this.iUq.crk() && this.iFb != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iFb.cku(), 2);
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
            if (this.iFb != null && this.iFb.cku() != null && this.iFb.cku().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.iFb.cku().getBaijiahaoData();
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
        TBLottieAnimationView tBLottieAnimationView = this.iUn.iUs;
        TBLottieAnimationView tBLottieAnimationView2 = this.iUo.iUs;
        TextView textView = this.iUn.textView;
        TextView textView2 = this.iUo.textView;
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

    public void crj() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView crk = this.iUn.crk();
            am.a(crk, R.raw.lottie_agree);
            TBLottieAnimationView crk2 = this.iUo.crk();
            am.a(crk2, R.raw.lottie_disagree);
            TextView textView = this.iUn.getTextView();
            TextView textView2 = this.iUo.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    crk2.setProgress(0.0f);
                    crk.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    crk.setProgress(0.0f);
                    crk2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                crk.setMinAndMaxProgress(0.0f, 0.0f);
                crk2.setMinAndMaxProgress(0.0f, 0.0f);
                crk.setProgress(0.0f);
                crk2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                crk.setAlpha(0.5f);
                crk2.setAlpha(0.5f);
            } else if (skinType == 4) {
                crk.setAlpha(0.66f);
                crk2.setAlpha(0.66f);
            } else {
                crk.setAlpha(1.0f);
                crk2.setAlpha(1.0f);
            }
            if (this.iFb != null && this.iFb.cku() != null) {
                setVisibility(this.iFb.cku().aEi() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aHt() {
        int i;
        if (this.ddo != null) {
            if (this.iFb != null && this.iFb.cku() != null) {
                bj cku = this.iFb.cku();
                if (cku.aBd()) {
                    i = 2;
                } else if (cku.aBe()) {
                    i = 3;
                } else if (cku.aEg()) {
                    i = 4;
                } else if (cku.aEh()) {
                    i = 5;
                }
                if (this.ddo.type != 1) {
                    TiebaStatic.log(new an("c12003").X("obj_locate", this.ddo.cNB).X("obj_param1", this.ddo.cNC).X("obj_source", this.ddo.cND).X("obj_id", this.ddo.cNE).X("obj_name", i));
                    return;
                } else if (this.ddo.type == 2) {
                    TiebaStatic.log(new an("c13271").X("obj_type", this.ddo.cNG).X("obj_locate", this.ddo.cNH).X("obj_id", this.ddo.cNI).X("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.ddo.type != 1) {
            }
        }
    }

    public void aMB() {
        this.iUp.zn(R.color.cp_cont_j);
        this.iUq.zn(R.color.cp_cont_j);
        this.iUp.setImageResource(R.drawable.icon_weixin_112);
        this.iUq.setImageResource(R.drawable.icon_pengyouqun_112);
        this.iUn.crl();
        this.iUo.crl();
        this.iUp.crl();
        this.iUq.crl();
        crj();
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
        this.ddo = dVar;
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
        private TBLottieAnimationView iUs;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.DM = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.iUs = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView crk() {
            return this.iUs;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.iUs.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.iUs, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zn(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.iUs.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.iUs.addAnimatorListener(animatorListener);
        }

        public void crl() {
            com.baidu.tbadk.core.util.f.a.aHa().kG(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kH(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).kF(R.color.cp_cont_f_alpha50).kC(R.color.cp_bg_line_d).aQ(this.DM);
        }
    }
}
