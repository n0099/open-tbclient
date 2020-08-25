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
/* loaded from: classes16.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e enZ;
    private com.baidu.tbadk.core.data.c eod;
    private CustomMessageListener eor;
    private f kAA;
    private a kRm;
    private a kRn;
    private a kRo;
    private a kRp;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eor);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dcr();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.enZ != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.enZ.uniqueId != ThreadAgreeAndShareLayout.this.enZ.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.kAA != null && ThreadAgreeAndShareLayout.this.kAA.cVl() != null && ThreadAgreeAndShareLayout.this.kAA.cVl().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.kAA.cVl().getBaijiahaoData().oriUgcNid)) {
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
        this.eor = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.enZ.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bb(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.enZ = new e();
        this.enZ.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eod = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.kRm = EE(0);
        this.kRn = EE(dimenPixelSize);
        this.kRo = EE(dimenPixelSize);
        this.kRp = EE(dimenPixelSize);
        this.kRo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kRp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kRo.setText(R.string.share_weixin_friend);
        this.kRp.setText(R.string.share_weixin_timeline);
        this.kRm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kRm.addAnimatorListener(this);
        this.kRn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kRn.addAnimatorListener(this);
        this.kRm.dcs().setOnClickListener(this.mOnClickListener);
        this.kRn.dcs().setOnClickListener(this.mOnClickListener);
        this.kRo.dcs().setOnClickListener(this.mOnClickListener);
        this.kRp.dcs().setOnClickListener(this.mOnClickListener);
        bpH();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kAA = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dcr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.kRm.dcs() || view == this.kRn.dcs()) {
                if (view == this.kRm.dcs()) {
                    this.kRm.playAnimation();
                    if (this.eod != null) {
                        this.eod.type = 1;
                        this.eod.dWK = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dcr();
                            if (this.eod != null) {
                                this.eod.dWN = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            tT(true);
                            if (this.eod != null) {
                                this.eod.dWN = 0;
                                i2 = 0;
                            }
                        }
                        ED(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        tT(true);
                    }
                    i2 = 0;
                    ED(i2);
                } else if (view == this.kRn.dcs()) {
                    this.kRn.playAnimation();
                    if (this.eod != null) {
                        this.eod.type = 2;
                        this.eod.dWK = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dcr();
                            if (this.eod != null) {
                                this.eod.dWR = 0;
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
                            tT(false);
                            if (this.eod != null) {
                                this.eod.dWR = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        tT(false);
                        if (this.eod != null) {
                            this.eod.dWR = 1;
                        }
                    }
                    ED(i);
                }
                this.enZ.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.kAA != null && this.kAA.cVl() != null && this.kAA.cVl().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.kAA.cVl().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.enZ));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.enZ));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eod);
                bkh();
            } else if (view == this.kRo.dcs()) {
                if (this.kAA != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kAA.cVl(), 3);
                }
            } else if (view == this.kRp.dcs() && this.kAA != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kAA.cVl(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void ED(int i) {
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
            if (this.kAA != null && this.kAA.cVl() != null && this.kAA.cVl().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.kAA.cVl().getBaijiahaoData();
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

    public void tT(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.kRm.kRr;
        TBLottieAnimationView tBLottieAnimationView2 = this.kRn.kRr;
        TextView textView = this.kRm.textView;
        TextView textView2 = this.kRn.textView;
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

    public void dcr() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dcs = this.kRm.dcs();
            ap.a(dcs, R.raw.lottie_agree);
            TBLottieAnimationView dcs2 = this.kRn.dcs();
            ap.a(dcs2, R.raw.lottie_disagree);
            TextView textView = this.kRm.getTextView();
            TextView textView2 = this.kRn.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dcs2.setProgress(0.0f);
                    dcs.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                } else {
                    dcs.setProgress(0.0f);
                    dcs2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
                }
            } else {
                dcs.setMinAndMaxProgress(0.0f, 0.0f);
                dcs2.setMinAndMaxProgress(0.0f, 0.0f);
                dcs.setProgress(0.0f);
                dcs2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dcs.setAlpha(0.5f);
                dcs2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dcs.setAlpha(0.66f);
                dcs2.setAlpha(0.66f);
            } else {
                dcs.setAlpha(1.0f);
                dcs2.setAlpha(1.0f);
            }
            if (this.kAA != null && this.kAA.cVl() != null) {
                setVisibility(this.kAA.cVl().bdo() ? 8 : 0);
            }
        }
    }

    public void bkh() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eod != null) {
            if (this.kAA == null || this.kAA.cVl() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bw cVl = this.kAA.cVl();
                if (cVl.bdm()) {
                    i3 = 2;
                } else if (cVl.bdn()) {
                    i3 = 3;
                } else if (cVl.bgz()) {
                    i3 = 4;
                } else {
                    i3 = cVl.bgA() ? 5 : 1;
                }
                String nid = cVl.getNid();
                if (cVl.getBaijiahaoData() != null && !at.isEmpty(cVl.getBaijiahaoData().oriUgcVid)) {
                    str6 = cVl.getBaijiahaoData().oriUgcVid;
                }
                int bgD = cVl.bgD();
                String str7 = cVl.mRecomSource;
                String str8 = cVl.mRecomAbTag;
                String str9 = cVl.mRecomWeight;
                String str10 = cVl.mRecomExtra;
                str = str8;
                i = bgD;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eod.type == 1) {
                aq dD = new aq("c12003").ai("obj_locate", this.eod.dWK).ai("obj_param1", this.eod.dWL).ai("obj_source", this.eod.dWM).ai("obj_id", this.eod.dWN).ai("obj_name", i2).dD("nid", str4).ai(IntentConfig.CARD_TYPE, i).dD(IntentConfig.RECOM_SOURCE, str2).dD("ab_tag", str).dD("weight", str5).dD("recom_extra", str6).dD("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dD);
                }
                TiebaStatic.log(dD);
            } else if (this.eod.type == 2) {
                aq dD2 = new aq("c13271").ai("obj_type", this.eod.dWP).ai("obj_locate", this.eod.dWQ).ai("obj_id", this.eod.dWR).ai("obj_name", i2).dD("nid", str4).ai(IntentConfig.CARD_TYPE, i).dD(IntentConfig.RECOM_SOURCE, str2).dD("ab_tag", str).dD("weight", str5).dD("recom_extra", str6).dD("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dD2);
                }
                TiebaStatic.log(dD2);
            }
        }
    }

    public void bpH() {
        this.kRo.EF(R.color.cp_cont_j);
        this.kRp.EF(R.color.cp_cont_j);
        this.kRo.setImageResource(R.drawable.icon_weixin_112);
        this.kRp.setImageResource(R.drawable.icon_pengyouqun_112);
        this.kRm.dct();
        this.kRn.dct();
        this.kRo.dct();
        this.kRp.dct();
        dcr();
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
        this.eod = cVar;
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

    private a EE(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        private View Yw;
        private TBLottieAnimationView kRr;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Yw = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.kRr = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dcs() {
            return this.kRr;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.kRr.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.kRr, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void EF(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.kRr.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.kRr.addAnimatorListener(animatorListener);
        }

        public void dct() {
            com.baidu.tbadk.core.util.e.a.bjQ().oj(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).ok(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oi(R.color.cp_cont_f_alpha50).of(R.color.cp_bg_line_d).aZ(this.Yw);
        }
    }
}
