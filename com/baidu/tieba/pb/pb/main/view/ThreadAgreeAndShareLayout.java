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
    private e eod;
    private com.baidu.tbadk.core.data.c eoi;
    private CustomMessageListener eov;
    private f kAH;
    private a kRt;
    private a kRu;
    private a kRv;
    private a kRw;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eov);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eov);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dcs();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.eod != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.eod.uniqueId != ThreadAgreeAndShareLayout.this.eod.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.kAH != null && ThreadAgreeAndShareLayout.this.kAH.cVm() != null && ThreadAgreeAndShareLayout.this.kAH.cVm().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.kAH.cVm().getBaijiahaoData().oriUgcNid)) {
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
        this.eov = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.eod.uniqueId != eVar.uniqueId) {
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
        this.eod = new e();
        this.eod.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eoi = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.kRt = EE(0);
        this.kRu = EE(dimenPixelSize);
        this.kRv = EE(dimenPixelSize);
        this.kRw = EE(dimenPixelSize);
        this.kRv.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kRw.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kRv.setText(R.string.share_weixin_friend);
        this.kRw.setText(R.string.share_weixin_timeline);
        this.kRt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kRt.addAnimatorListener(this);
        this.kRu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kRu.addAnimatorListener(this);
        this.kRt.dct().setOnClickListener(this.mOnClickListener);
        this.kRu.dct().setOnClickListener(this.mOnClickListener);
        this.kRv.dct().setOnClickListener(this.mOnClickListener);
        this.kRw.dct().setOnClickListener(this.mOnClickListener);
        bpI();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kAH = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dcs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.kRt.dct() || view == this.kRu.dct()) {
                if (view == this.kRt.dct()) {
                    this.kRt.playAnimation();
                    if (this.eoi != null) {
                        this.eoi.type = 1;
                        this.eoi.dWO = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dcs();
                            if (this.eoi != null) {
                                this.eoi.dWR = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            tV(true);
                            if (this.eoi != null) {
                                this.eoi.dWR = 0;
                                i2 = 0;
                            }
                        }
                        ED(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        tV(true);
                    }
                    i2 = 0;
                    ED(i2);
                } else if (view == this.kRu.dct()) {
                    this.kRu.playAnimation();
                    if (this.eoi != null) {
                        this.eoi.type = 2;
                        this.eoi.dWO = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dcs();
                            if (this.eoi != null) {
                                this.eoi.dWV = 0;
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
                            tV(false);
                            if (this.eoi != null) {
                                this.eoi.dWV = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        tV(false);
                        if (this.eoi != null) {
                            this.eoi.dWV = 1;
                        }
                    }
                    ED(i);
                }
                this.eod.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.kAH != null && this.kAH.cVm() != null && this.kAH.cVm().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.kAH.cVm().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.eod));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.eod));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eoi);
                bkh();
            } else if (view == this.kRv.dct()) {
                if (this.kAH != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kAH.cVm(), 3);
                }
            } else if (view == this.kRw.dct() && this.kAH != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kAH.cVm(), 2);
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
            if (this.kAH != null && this.kAH.cVm() != null && this.kAH.cVm().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.kAH.cVm().getBaijiahaoData();
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

    public void tV(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.kRt.kRy;
        TBLottieAnimationView tBLottieAnimationView2 = this.kRu.kRy;
        TextView textView = this.kRt.textView;
        TextView textView2 = this.kRu.textView;
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

    public void dcs() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dct = this.kRt.dct();
            ap.a(dct, R.raw.lottie_agree);
            TBLottieAnimationView dct2 = this.kRu.dct();
            ap.a(dct2, R.raw.lottie_disagree);
            TextView textView = this.kRt.getTextView();
            TextView textView2 = this.kRu.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dct2.setProgress(0.0f);
                    dct.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                } else {
                    dct.setProgress(0.0f);
                    dct2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
                }
            } else {
                dct.setMinAndMaxProgress(0.0f, 0.0f);
                dct2.setMinAndMaxProgress(0.0f, 0.0f);
                dct.setProgress(0.0f);
                dct2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dct.setAlpha(0.5f);
                dct2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dct.setAlpha(0.66f);
                dct2.setAlpha(0.66f);
            } else {
                dct.setAlpha(1.0f);
                dct2.setAlpha(1.0f);
            }
            if (this.kAH != null && this.kAH.cVm() != null) {
                setVisibility(this.kAH.cVm().bdo() ? 8 : 0);
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
        if (this.eoi != null) {
            if (this.kAH == null || this.kAH.cVm() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bw cVm = this.kAH.cVm();
                if (cVm.bdm()) {
                    i3 = 2;
                } else if (cVm.bdn()) {
                    i3 = 3;
                } else if (cVm.bgz()) {
                    i3 = 4;
                } else {
                    i3 = cVm.bgA() ? 5 : 1;
                }
                String nid = cVm.getNid();
                if (cVm.getBaijiahaoData() != null && !at.isEmpty(cVm.getBaijiahaoData().oriUgcVid)) {
                    str6 = cVm.getBaijiahaoData().oriUgcVid;
                }
                int bgD = cVm.bgD();
                String str7 = cVm.mRecomSource;
                String str8 = cVm.mRecomAbTag;
                String str9 = cVm.mRecomWeight;
                String str10 = cVm.mRecomExtra;
                str = str8;
                i = bgD;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eoi.type == 1) {
                aq dD = new aq("c12003").ai("obj_locate", this.eoi.dWO).ai("obj_param1", this.eoi.dWP).ai("obj_source", this.eoi.dWQ).ai("obj_id", this.eoi.dWR).ai("obj_name", i2).dD("nid", str4).ai(IntentConfig.CARD_TYPE, i).dD(IntentConfig.RECOM_SOURCE, str2).dD("ab_tag", str).dD("weight", str5).dD("recom_extra", str6).dD("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dD);
                }
                TiebaStatic.log(dD);
            } else if (this.eoi.type == 2) {
                aq dD2 = new aq("c13271").ai("obj_type", this.eoi.dWT).ai("obj_locate", this.eoi.dWU).ai("obj_id", this.eoi.dWV).ai("obj_name", i2).dD("nid", str4).ai(IntentConfig.CARD_TYPE, i).dD(IntentConfig.RECOM_SOURCE, str2).dD("ab_tag", str).dD("weight", str5).dD("recom_extra", str6).dD("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dD2);
                }
                TiebaStatic.log(dD2);
            }
        }
    }

    public void bpI() {
        this.kRv.EF(R.color.cp_cont_j);
        this.kRw.EF(R.color.cp_cont_j);
        this.kRv.setImageResource(R.drawable.icon_weixin_112);
        this.kRw.setImageResource(R.drawable.icon_pengyouqun_112);
        this.kRt.dcu();
        this.kRu.dcu();
        this.kRv.dcu();
        this.kRw.dcu();
        dcs();
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
        this.eoi = cVar;
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
        private View Yy;
        private TBLottieAnimationView kRy;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Yy = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.kRy = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dct() {
            return this.kRy;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.kRy.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.kRy, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void EF(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.kRy.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.kRy.addAnimatorListener(animatorListener);
        }

        public void dcu() {
            com.baidu.tbadk.core.util.e.a.bjQ().oj(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).ok(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oi(R.color.cp_cont_f_alpha50).of(R.color.cp_bg_line_d).aZ(this.Yy);
        }
    }
}
