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
    private e dDo;
    private d dDs;
    private CustomMessageListener dDy;
    private CustomMessageListener dDz;
    private a jGm;
    private a jGn;
    private a jGo;
    private a jGp;
    private com.baidu.tieba.pb.data.e jqZ;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dDy);
        MessageManager.getInstance().registerListener(this.dDz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dDy);
        MessageManager.getInstance().unRegisterListener(this.dDz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            cCi();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDy = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.dDo != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.dDo.uniqueId != ThreadAgreeAndShareLayout.this.dDo.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.jqZ != null && ThreadAgreeAndShareLayout.this.jqZ.cvr() != null && ThreadAgreeAndShareLayout.this.jqZ.cvr().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.jqZ.cvr().getBaijiahaoData().oriUgcNid)) {
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
        this.dDz = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.dDo.uniqueId != eVar.uniqueId) {
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
        this.dDo = new e();
        this.dDo.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.dDs = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.jGm = zV(0);
        this.jGn = zV(dimenPixelSize);
        this.jGo = zV(dimenPixelSize);
        this.jGp = zV(dimenPixelSize);
        this.jGo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jGp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jGo.setText(R.string.share_weixin_friend);
        this.jGp.setText(R.string.share_weixin_timeline);
        this.jGm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jGm.addAnimatorListener(this);
        this.jGn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jGn.addAnimatorListener(this);
        this.jGm.cCj().setOnClickListener(this.mOnClickListener);
        this.jGn.cCj().setOnClickListener(this.mOnClickListener);
        this.jGo.cCj().setOnClickListener(this.mOnClickListener);
        this.jGp.cCj().setOnClickListener(this.mOnClickListener);
        aVb();
    }

    public void setData(com.baidu.tieba.pb.data.e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jqZ = eVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        cCi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.jGm.cCj() || view == this.jGn.cCj()) {
                if (view == this.jGm.cCj()) {
                    this.jGm.playAnimation();
                    if (this.dDs != null) {
                        this.dDs.type = 1;
                        this.dDs.dmX = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            cCi();
                            if (this.dDs != null) {
                                this.dDs.dna = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            rS(true);
                            if (this.dDs != null) {
                                this.dDs.dna = 0;
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
                } else if (view == this.jGn.cCj()) {
                    this.jGn.playAnimation();
                    if (this.dDs != null) {
                        this.dDs.type = 2;
                        this.dDs.dmX = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            cCi();
                            if (this.dDs != null) {
                                this.dDs.dne = 0;
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
                            if (this.dDs != null) {
                                this.dDs.dne = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        rS(false);
                        if (this.dDs != null) {
                            this.dDs.dne = 1;
                        }
                    }
                    lc(i);
                }
                this.dDo.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.jqZ != null && this.jqZ.cvr() != null && this.jqZ.cvr().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.jqZ.cvr().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dDo));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dDo));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.dDs);
                aPN();
            } else if (view == this.jGo.cCj()) {
                if (this.jqZ != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.jqZ.cvr(), 3);
                }
            } else if (view == this.jGp.cCj() && this.jqZ != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.jqZ.cvr(), 2);
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
            if (this.jqZ != null && this.jqZ.cvr() != null && this.jqZ.cvr().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.jqZ.cvr().getBaijiahaoData();
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
        TBLottieAnimationView tBLottieAnimationView = this.jGm.jGr;
        TBLottieAnimationView tBLottieAnimationView2 = this.jGn.jGr;
        TextView textView = this.jGm.textView;
        TextView textView2 = this.jGn.textView;
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

    public void cCi() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cCj = this.jGm.cCj();
            am.a(cCj, R.raw.lottie_agree);
            TBLottieAnimationView cCj2 = this.jGn.cCj();
            am.a(cCj2, R.raw.lottie_disagree);
            TextView textView = this.jGm.getTextView();
            TextView textView2 = this.jGn.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cCj2.setProgress(0.0f);
                    cCj.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    cCj.setProgress(0.0f);
                    cCj2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cCj.setMinAndMaxProgress(0.0f, 0.0f);
                cCj2.setMinAndMaxProgress(0.0f, 0.0f);
                cCj.setProgress(0.0f);
                cCj2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cCj.setAlpha(0.5f);
                cCj2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cCj.setAlpha(0.66f);
                cCj2.setAlpha(0.66f);
            } else {
                cCj.setAlpha(1.0f);
                cCj2.setAlpha(1.0f);
            }
            if (this.jqZ != null && this.jqZ.cvr() != null) {
                setVisibility(this.jqZ.cvr().aMy() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aPN() {
        int i;
        if (this.dDs != null) {
            if (this.jqZ != null && this.jqZ.cvr() != null) {
                bj cvr = this.jqZ.cvr();
                if (cvr.aJr()) {
                    i = 2;
                } else if (cvr.aJs()) {
                    i = 3;
                } else if (cvr.aMw()) {
                    i = 4;
                } else if (cvr.aMx()) {
                    i = 5;
                }
                if (this.dDs.type != 1) {
                    TiebaStatic.log(new an("c12003").af("obj_locate", this.dDs.dmX).af("obj_param1", this.dDs.dmY).af("obj_source", this.dDs.dmZ).af("obj_id", this.dDs.dna).af("obj_name", i));
                    return;
                } else if (this.dDs.type == 2) {
                    TiebaStatic.log(new an("c13271").af("obj_type", this.dDs.dnc).af("obj_locate", this.dDs.dnd).af("obj_id", this.dDs.dne).af("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.dDs.type != 1) {
            }
        }
    }

    public void aVb() {
        this.jGo.zW(R.color.cp_cont_j);
        this.jGp.zW(R.color.cp_cont_j);
        this.jGo.setImageResource(R.drawable.icon_weixin_112);
        this.jGp.setImageResource(R.drawable.icon_pengyouqun_112);
        this.jGm.cCk();
        this.jGn.cCk();
        this.jGo.cCk();
        this.jGp.cCk();
        cCi();
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
        this.dDs = dVar;
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
        private View Xh;
        private TBLottieAnimationView jGr;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Xh = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.jGr = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cCj() {
            return this.jGr;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.jGr.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.jGr, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zW(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.jGr.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.jGr.addAnimatorListener(animatorListener);
        }

        public void cCk() {
            com.baidu.tbadk.core.util.e.a.aPr().kQ(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kR(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).kP(R.color.cp_cont_f_alpha50).kM(R.color.cp_bg_line_d).aR(this.Xh);
        }
    }
}
