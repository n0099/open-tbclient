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
/* loaded from: classes7.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e cZf;
    private d cZj;
    private CustomMessageListener cZp;
    private CustomMessageListener cZq;
    private f iDs;
    private a iSR;
    private a iSS;
    private a iST;
    private a iSU;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cZp);
        MessageManager.getInstance().registerListener(this.cZq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cZp);
        MessageManager.getInstance().unRegisterListener(this.cZq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            cpP();
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZp = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.cZf != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.cZf.uniqueId != ThreadAgreeAndShareLayout.this.cZf.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.iDs != null && ThreadAgreeAndShareLayout.this.iDs.ciS() != null && ThreadAgreeAndShareLayout.this.iDs.ciS().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.iDs.ciS().getBaijiahaoData().oriUgcNid)) {
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
        this.cZq = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.cZf.uniqueId != eVar.uniqueId) {
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
        this.cZf = new e();
        this.cZf.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.cZj = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.iSR = zg(0);
        this.iSS = zg(dimenPixelSize);
        this.iST = zg(dimenPixelSize);
        this.iSU = zg(dimenPixelSize);
        this.iST.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iSU.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iST.setText(R.string.share_weixin_friend);
        this.iSU.setText(R.string.share_weixin_timeline);
        this.iSR.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iSR.addAnimatorListener(this);
        this.iSS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iSS.addAnimatorListener(this);
        this.iSR.cpQ().setOnClickListener(this.mOnClickListener);
        this.iSS.cpQ().setOnClickListener(this.mOnClickListener);
        this.iST.cpQ().setOnClickListener(this.mOnClickListener);
        this.iSU.cpQ().setOnClickListener(this.mOnClickListener);
        aKd();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iDs = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        cpP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bc.checkUpIsLogin(getContext())) {
            if (view == this.iSR.cpQ() || view == this.iSS.cpQ()) {
                if (view == this.iSR.cpQ()) {
                    this.iSR.playAnimation();
                    if (this.cZj != null) {
                        this.cZj.type = 1;
                        this.cZj.cJx = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            cpP();
                            if (this.cZj != null) {
                                this.cZj.cJA = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            qG(true);
                            if (this.cZj != null) {
                                this.cZj.cJA = 0;
                                i2 = 0;
                            }
                        }
                        kB(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        qG(true);
                    }
                    i2 = 0;
                    kB(i2);
                } else if (view == this.iSS.cpQ()) {
                    this.iSS.playAnimation();
                    if (this.cZj != null) {
                        this.cZj.type = 2;
                        this.cZj.cJx = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            cpP();
                            if (this.cZj != null) {
                                this.cZj.cJE = 0;
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
                            qG(false);
                            if (this.cZj != null) {
                                this.cZj.cJE = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        qG(false);
                        if (this.cZj != null) {
                            this.cZj.cJE = 1;
                        }
                    }
                    kB(i);
                }
                this.cZf.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.iDs != null && this.iDs.ciS() != null && this.iDs.ciS().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.iDs.ciS().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.cZf));
                    a(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.cZf));
                    a(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.cZj);
                aFf();
            } else if (view == this.iST.cpQ()) {
                if (this.iDs != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iDs.ciS(), 3);
                }
            } else if (view == this.iSU.cpQ() && this.iDs != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.iDs.ciS(), 2);
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
            if (this.iDs != null && this.iDs.ciS() != null && this.iDs.ciS().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.iDs.ciS().getBaijiahaoData();
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

    public void qG(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.iSR.iSW;
        TBLottieAnimationView tBLottieAnimationView2 = this.iSS.iSW;
        TextView textView = this.iSR.textView;
        TextView textView2 = this.iSS.textView;
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

    public void cpP() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cpQ = this.iSR.cpQ();
            am.a(cpQ, R.raw.lottie_agree);
            TBLottieAnimationView cpQ2 = this.iSS.cpQ();
            am.a(cpQ2, R.raw.lottie_disagree);
            TextView textView = this.iSR.getTextView();
            TextView textView2 = this.iSS.getTextView();
            textView.setText(aq.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(aq.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cpQ2.setProgress(0.0f);
                    cpQ.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(am.getColor(R.color.cp_cont_j));
                } else {
                    cpQ.setProgress(0.0f);
                    cpQ2.setProgress(1.0f);
                    textView.setTextColor(am.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(am.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cpQ.setMinAndMaxProgress(0.0f, 0.0f);
                cpQ2.setMinAndMaxProgress(0.0f, 0.0f);
                cpQ.setProgress(0.0f);
                cpQ2.setProgress(0.0f);
                textView.setTextColor(am.getColor(R.color.cp_cont_j));
                textView2.setTextColor(am.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cpQ.setAlpha(0.5f);
                cpQ2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cpQ.setAlpha(0.66f);
                cpQ2.setAlpha(0.66f);
            } else {
                cpQ.setAlpha(1.0f);
                cpQ2.setAlpha(1.0f);
            }
            if (this.iDs != null && this.iDs.ciS() != null) {
                setVisibility(this.iDs.ciS().aBV() ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aFf() {
        int i;
        if (this.cZj != null) {
            if (this.iDs != null && this.iDs.ciS() != null) {
                bj ciS = this.iDs.ciS();
                if (ciS.ayL()) {
                    i = 2;
                } else if (ciS.aBS()) {
                    i = 3;
                } else if (ciS.aBT()) {
                    i = 4;
                } else if (ciS.aBU()) {
                    i = 5;
                }
                if (this.cZj.type != 1) {
                    TiebaStatic.log(new an("c12003").Z("obj_locate", this.cZj.cJx).Z("obj_param1", this.cZj.cJy).Z("obj_source", this.cZj.cJz).Z("obj_id", this.cZj.cJA).Z("obj_name", i));
                    return;
                } else if (this.cZj.type == 2) {
                    TiebaStatic.log(new an("c13271").Z("obj_type", this.cZj.cJC).Z("obj_locate", this.cZj.cJD).Z("obj_id", this.cZj.cJE).Z("obj_name", i));
                    return;
                } else {
                    return;
                }
            }
            i = 1;
            if (this.cZj.type != 1) {
            }
        }
    }

    public void aKd() {
        this.iST.zh(R.color.cp_cont_j);
        this.iSU.zh(R.color.cp_cont_j);
        this.iST.setImageResource(R.drawable.icon_weixin_112);
        this.iSU.setImageResource(R.drawable.icon_pengyouqun_112);
        this.iSR.cpR();
        this.iSS.cpR();
        this.iST.cpR();
        this.iSU.cpR();
        cpP();
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
        this.cZj = dVar;
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

    private a zg(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private View Dq;
        private TBLottieAnimationView iSW;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Dq = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.iSW = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cpQ() {
            return this.iSW;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.iSW.playAnimation();
        }

        public void setImageResource(int i) {
            am.setImageResource(this.iSW, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void zh(int i) {
            am.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.iSW.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.iSW.addAnimatorListener(animatorListener);
        }

        public void cpR() {
            com.baidu.tbadk.core.util.f.a.aEM().kp(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).kq(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ko(R.color.cp_cont_f_alpha50).kl(R.color.cp_bg_line_d).aQ(this.Dq);
        }
    }
}
