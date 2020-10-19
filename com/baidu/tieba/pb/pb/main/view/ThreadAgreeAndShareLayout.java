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
/* loaded from: classes22.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e eCG;
    private com.baidu.tbadk.core.data.c eCK;
    private CustomMessageListener eCX;
    private f kYp;
    private a lpo;
    private a lpp;
    private a lpq;
    private a lpr;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eCX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eCX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            djF();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.eCG != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.eCG.uniqueId != ThreadAgreeAndShareLayout.this.eCG.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.kYp != null && ThreadAgreeAndShareLayout.this.kYp.dcA() != null && ThreadAgreeAndShareLayout.this.kYp.dcA().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.kYp.dcA().getBaijiahaoData().oriUgcNid)) {
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
        this.eCX = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.eCG.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bh(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.eCG = new e();
        this.eCG.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eCK = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.lpo = FL(0);
        this.lpp = FL(dimenPixelSize);
        this.lpq = FL(dimenPixelSize);
        this.lpr = FL(dimenPixelSize);
        this.lpq.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lpr.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lpq.setText(R.string.share_weixin_friend);
        this.lpr.setText(R.string.share_weixin_timeline);
        this.lpo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lpo.addAnimatorListener(this);
        this.lpp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lpp.addAnimatorListener(this);
        this.lpo.djG().setOnClickListener(this.mOnClickListener);
        this.lpp.djG().setOnClickListener(this.mOnClickListener);
        this.lpq.djG().setOnClickListener(this.mOnClickListener);
        this.lpr.djG().setOnClickListener(this.mOnClickListener);
        btm();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kYp = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        djF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.lpo.djG() || view == this.lpp.djG()) {
                if (view == this.lpo.djG()) {
                    this.lpo.playAnimation();
                    if (this.eCK != null) {
                        this.eCK.type = 1;
                        this.eCK.ela = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            djF();
                            if (this.eCK != null) {
                                this.eCK.eld = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            uK(true);
                            if (this.eCK != null) {
                                this.eCK.eld = 0;
                                i2 = 0;
                            }
                        }
                        FK(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        uK(true);
                    }
                    i2 = 0;
                    FK(i2);
                } else if (view == this.lpp.djG()) {
                    this.lpp.playAnimation();
                    if (this.eCK != null) {
                        this.eCK.type = 2;
                        this.eCK.ela = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            djF();
                            if (this.eCK != null) {
                                this.eCK.elh = 0;
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
                            uK(false);
                            if (this.eCK != null) {
                                this.eCK.elh = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        uK(false);
                        if (this.eCK != null) {
                            this.eCK.elh = 1;
                        }
                    }
                    FK(i);
                }
                this.eCG.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.kYp != null && this.kYp.dcA() != null && this.kYp.dcA().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.kYp.dcA().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.eCG));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.eCG));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eCK);
                bnM();
            } else if (view == this.lpq.djG()) {
                if (this.kYp != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kYp.dcA(), 3);
                }
            } else if (view == this.lpr.djG() && this.kYp != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kYp.dcA(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void FK(int i) {
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
            if (this.kYp != null && this.kYp.dcA() != null && this.kYp.dcA().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.kYp.dcA().getBaijiahaoData();
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

    public void uK(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.lpo.lpt;
        TBLottieAnimationView tBLottieAnimationView2 = this.lpp.lpt;
        TextView textView = this.lpo.textView;
        TextView textView2 = this.lpp.textView;
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

    public void djF() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView djG = this.lpo.djG();
            ap.a(djG, R.raw.lottie_agree);
            TBLottieAnimationView djG2 = this.lpp.djG();
            ap.a(djG2, R.raw.lottie_disagree);
            TextView textView = this.lpo.getTextView();
            TextView textView2 = this.lpp.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    djG2.setProgress(0.0f);
                    djG.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                } else {
                    djG.setProgress(0.0f);
                    djG2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
                }
            } else {
                djG.setMinAndMaxProgress(0.0f, 0.0f);
                djG2.setMinAndMaxProgress(0.0f, 0.0f);
                djG.setProgress(0.0f);
                djG2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                djG.setAlpha(0.5f);
                djG2.setAlpha(0.5f);
            } else if (skinType == 4) {
                djG.setAlpha(0.66f);
                djG2.setAlpha(0.66f);
            } else {
                djG.setAlpha(1.0f);
                djG2.setAlpha(1.0f);
            }
            if (this.kYp != null && this.kYp.dcA() != null) {
                setVisibility(this.kYp.dcA().bgR() ? 8 : 0);
            }
        }
    }

    public void bnM() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eCK != null) {
            if (this.kYp == null || this.kYp.dcA() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bw dcA = this.kYp.dcA();
                if (dcA.bgP()) {
                    i3 = 2;
                } else if (dcA.bgQ()) {
                    i3 = 3;
                } else if (dcA.bkc()) {
                    i3 = 4;
                } else {
                    i3 = dcA.bkd() ? 5 : 1;
                }
                String nid = dcA.getNid();
                if (dcA.getBaijiahaoData() != null && !at.isEmpty(dcA.getBaijiahaoData().oriUgcVid)) {
                    str6 = dcA.getBaijiahaoData().oriUgcVid;
                }
                int bkg = dcA.bkg();
                String str7 = dcA.mRecomSource;
                String str8 = dcA.mRecomAbTag;
                String str9 = dcA.mRecomWeight;
                String str10 = dcA.mRecomExtra;
                str = str8;
                i = bkg;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eCK.type == 1) {
                aq dK = new aq("c12003").aj("obj_locate", this.eCK.ela).aj("obj_param1", this.eCK.elb).aj("obj_source", this.eCK.elc).aj("obj_id", this.eCK.eld).aj("obj_name", i2).dK("nid", str4).aj(IntentConfig.CARD_TYPE, i).dK(IntentConfig.RECOM_SOURCE, str2).dK("ab_tag", str).dK("weight", str5).dK("recom_extra", str6).dK("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dK);
                }
                TiebaStatic.log(dK);
            } else if (this.eCK.type == 2) {
                aq dK2 = new aq("c13271").aj("obj_type", this.eCK.elf).aj("obj_locate", this.eCK.elg).aj("obj_id", this.eCK.elh).aj("obj_name", i2).dK("nid", str4).aj(IntentConfig.CARD_TYPE, i).dK(IntentConfig.RECOM_SOURCE, str2).dK("ab_tag", str).dK("weight", str5).dK("recom_extra", str6).dK("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dK2);
                }
                TiebaStatic.log(dK2);
            }
        }
    }

    public void btm() {
        this.lpq.FM(R.color.cp_cont_j);
        this.lpr.FM(R.color.cp_cont_j);
        this.lpq.setImageResource(R.drawable.icon_weixin_112);
        this.lpr.setImageResource(R.drawable.icon_pengyouqun_112);
        this.lpo.djH();
        this.lpp.djH();
        this.lpq.djH();
        this.lpr.djH();
        djF();
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
        this.eCK = cVar;
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

    private a FL(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private View Zh;
        private TBLottieAnimationView lpt;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Zh = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lpt = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView djG() {
            return this.lpt;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lpt.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.lpt, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void FM(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lpt.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lpt.addAnimatorListener(animatorListener);
        }

        public void djH() {
            com.baidu.tbadk.core.util.e.a.bnv().oT(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).oU(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oS(R.color.cp_cont_f_alpha50).oP(R.color.cp_bg_line_d).bf(this.Zh);
        }
    }
}
