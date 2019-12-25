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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes6.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e cYV;
    private d cYZ;
    private CustomMessageListener cZf;
    private CustomMessageListener cZg;
    private a iPn;
    private a iPo;
    private a iPp;
    private a iPq;
    private f izO;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cZf);
        MessageManager.getInstance().registerListener(this.cZg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cZf);
        MessageManager.getInstance().unRegisterListener(this.cZg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            coI();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZf = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.cYV != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.cYV.uniqueId != ThreadAgreeAndShareLayout.this.cYV.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.izO != null && ThreadAgreeAndShareLayout.this.izO.chK() != null && ThreadAgreeAndShareLayout.this.izO.chK().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.izO.chK().getBaijiahaoData().oriUgcNid)) {
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
        this.cZg = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.cYV.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.aN(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.cYV = new e();
        this.cYV.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.cYZ = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.iPn = zb(0);
        this.iPo = zb(dimenPixelSize);
        this.iPp = zb(dimenPixelSize);
        this.iPq = zb(dimenPixelSize);
        this.iPp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iPq.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iPp.setText(R.string.share_weixin_friend);
        this.iPq.setText(R.string.share_weixin_timeline);
        this.iPn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iPn.addAnimatorListener(this);
        this.iPo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iPo.addAnimatorListener(this);
        this.iPn.coJ().setOnClickListener(this.mOnClickListener);
        this.iPo.coJ().setOnClickListener(this.mOnClickListener);
        this.iPp.coJ().setOnClickListener(this.mOnClickListener);
        this.iPq.coJ().setOnClickListener(this.mOnClickListener);
        aJJ();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.izO = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        coI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.iPn.coJ() || view == this.iPo.coJ()) {
                if (view == this.iPn.coJ()) {
                    this.iPn.playAnimation();
                    if (this.cYZ != null) {
                        this.cYZ.type = 1;
                        this.cYZ.cJm = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            coI();
                            if (this.cYZ != null) {
                                this.cYZ.cJp = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            qu(true);
                            if (this.cYZ != null) {
                                this.cYZ.cJp = 0;
                                i2 = 0;
                            }
                        }
                        kB(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        qu(true);
                    }
                    i2 = 0;
                    kB(i2);
                } else if (view == this.iPo.coJ()) {
                    this.iPo.playAnimation();
                    if (this.cYZ != null) {
                        this.cYZ.type = 2;
                        this.cYZ.cJm = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            coI();
                            if (this.cYZ != null) {
                                this.cYZ.cJt = 0;
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
                            qu(false);
                            if (this.cYZ != null) {
                                this.cYZ.cJt = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        qu(false);
                        if (this.cYZ != null) {
                            this.cYZ.cJt = 1;
                        }
                    }
                    kB(i);
                }
                this.cYV.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.izO != null && this.izO.chK() != null && this.izO.chK().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.izO.chK().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.cYV));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.cYV));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.cYZ);
                aEM();
            } else if (view == this.iPp.coJ()) {
                if (this.izO != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.izO.chK(), 3);
                }
            } else if (view == this.iPq.coJ() && this.izO != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.izO.chK(), 2);
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void kB(int i) {
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
            if (this.izO != null && this.izO.chK() != null && this.izO.chK().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.izO.chK().getBaijiahaoData();
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

    public void qu(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.iPn.iPs;
        TBLottieAnimationView tBLottieAnimationView2 = this.iPo.iPs;
        TextView textView = this.iPn.textView;
        TextView textView2 = this.iPo.textView;
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

    public void coI() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView coJ = this.iPn.coJ();
            am.a(coJ, R.raw.lottie_agree);
            TBLottieAnimationView coJ2 = this.iPo.coJ();
            am.a(coJ2, R.raw.lottie_disagree);
            TextView textView = this.iPn.getTextView();
            TextView textView2 = this.iPo.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    coJ2.setProgress(0.0f);
                    coJ.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    coJ.setProgress(0.0f);
                    coJ2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                coJ.setMinAndMaxProgress(0.0f, 0.0f);
                coJ2.setMinAndMaxProgress(0.0f, 0.0f);
                coJ.setProgress(0.0f);
                coJ2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                coJ.setAlpha(0.5f);
                coJ2.setAlpha(0.5f);
            } else if (skinType == 4) {
                coJ.setAlpha(0.66f);
                coJ2.setAlpha(0.66f);
            } else {
                coJ.setAlpha(1.0f);
                coJ2.setAlpha(1.0f);
            }
            if (this.izO != null && this.izO.chK() != null) {
                setVisibility(this.izO.chK().aBC() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aEM() {
        int i;
        if (this.cYZ != null) {
            if (this.izO != null && this.izO.chK() != null) {
                bj chK = this.izO.chK();
                if (chK.ays()) {
                    i = 2;
                } else if (chK.aBz()) {
                    i = 3;
                } else if (chK.aBA()) {
                    i = 4;
                } else if (chK.aBB()) {
                    i = 5;
                }
                if (this.cYZ.type != 1) {
                    TiebaStatic.log(new an("c12003").Z("obj_locate", this.cYZ.cJm).Z("obj_param1", this.cYZ.cJn).Z("obj_source", this.cYZ.cJo).Z("obj_id", this.cYZ.cJp).Z("obj_name", i));
                    return;
                } else if (this.cYZ.type == 2) {
                    TiebaStatic.log(new an("c13271").Z("obj_type", this.cYZ.cJr).Z("obj_locate", this.cYZ.cJs).Z("obj_id", this.cYZ.cJt).Z("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.cYZ.type != 1) {
            }
        }
    }

    public void aJJ() {
        this.iPp.zc(R.color.cp_cont_j);
        this.iPq.zc(R.color.cp_cont_j);
        this.iPp.setImageResource(R.drawable.icon_weixin_112);
        this.iPq.setImageResource(R.drawable.icon_pengyouqun_112);
        this.iPn.coK();
        this.iPo.coK();
        this.iPp.coK();
        this.iPq.coK();
        coI();
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
        this.cYZ = dVar;
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

    private a zb(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private View Dl;
        private TBLottieAnimationView iPs;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Dl = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.iPs = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView coJ() {
            return this.iPs;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.iPs.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.iPs, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zc(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.iPs.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.iPs.addAnimatorListener(animatorListener);
        }

        public void coK() {
            com.baidu.tbadk.core.util.f.a.aEt().kp(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kq(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ko(R.color.cp_cont_f_alpha50).kl(R.color.cp_bg_line_d).aM(this.Dl);
        }
    }
}
