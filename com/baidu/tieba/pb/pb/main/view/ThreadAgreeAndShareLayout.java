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
    private e eQR;
    private com.baidu.tbadk.core.data.c eQV;
    private CustomMessageListener eRi;
    private a lHJ;
    private a lHK;
    private a lHL;
    private a lHM;
    private f lqP;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eRi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eRi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dpp();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.eQR != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.eQR.uniqueId != ThreadAgreeAndShareLayout.this.eQR.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lqP != null && ThreadAgreeAndShareLayout.this.lqP.dik() != null && ThreadAgreeAndShareLayout.this.lqP.dik().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lqP.dik().getBaijiahaoData().oriUgcNid)) {
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
        this.eRi = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.eQR.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bm(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.eQR = new e();
        this.eQR.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eQV = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.lHJ = Gr(0);
        this.lHK = Gr(dimenPixelSize);
        this.lHL = Gr(dimenPixelSize);
        this.lHM = Gr(dimenPixelSize);
        this.lHL.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lHM.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lHL.setText(R.string.share_weixin_friend);
        this.lHM.setText(R.string.share_weixin_timeline);
        this.lHJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lHJ.addAnimatorListener(this);
        this.lHK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lHK.addAnimatorListener(this);
        this.lHJ.dpq().setOnClickListener(this.mOnClickListener);
        this.lHK.dpq().setOnClickListener(this.mOnClickListener);
        this.lHL.dpq().setOnClickListener(this.mOnClickListener);
        this.lHM.dpq().setOnClickListener(this.mOnClickListener);
        bxE();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lqP = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dpp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.lHJ.dpq() || view == this.lHK.dpq()) {
                if (view == this.lHJ.dpq()) {
                    this.lHJ.playAnimation();
                    if (this.eQV != null) {
                        this.eQV.type = 1;
                        this.eQV.ezt = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dpp();
                            if (this.eQV != null) {
                                this.eQV.ezw = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            vk(true);
                            if (this.eQV != null) {
                                this.eQV.ezw = 0;
                                i2 = 0;
                            }
                        }
                        Gq(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        vk(true);
                    }
                    i2 = 0;
                    Gq(i2);
                } else if (view == this.lHK.dpq()) {
                    this.lHK.playAnimation();
                    if (this.eQV != null) {
                        this.eQV.type = 2;
                        this.eQV.ezt = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dpp();
                            if (this.eQV != null) {
                                this.eQV.ezA = 0;
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
                            vk(false);
                            if (this.eQV != null) {
                                this.eQV.ezA = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        vk(false);
                        if (this.eQV != null) {
                            this.eQV.ezA = 1;
                        }
                    }
                    Gq(i);
                }
                this.eQR.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lqP != null && this.lqP.dik() != null && this.lqP.dik().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lqP.dik().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.eQR));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.eQR));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eQV);
                bsf();
            } else if (view == this.lHL.dpq()) {
                if (this.lqP != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.lqP.dik(), 3);
                }
            } else if (view == this.lHM.dpq() && this.lqP != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.lqP.dik(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Gq(int i) {
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
            if (this.lqP != null && this.lqP.dik() != null && this.lqP.dik().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lqP.dik().getBaijiahaoData();
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

    public void vk(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.lHJ.lHO;
        TBLottieAnimationView tBLottieAnimationView2 = this.lHK.lHO;
        TextView textView = this.lHJ.textView;
        TextView textView2 = this.lHK.textView;
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

    public void dpp() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dpq = this.lHJ.dpq();
            ap.a(dpq, R.raw.lottie_agree);
            TBLottieAnimationView dpq2 = this.lHK.dpq();
            ap.a(dpq2, R.raw.lottie_disagree);
            TextView textView = this.lHJ.getTextView();
            TextView textView2 = this.lHK.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dpq2.setProgress(0.0f);
                    dpq.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                } else {
                    dpq.setProgress(0.0f);
                    dpq2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
                }
            } else {
                dpq.setMinAndMaxProgress(0.0f, 0.0f);
                dpq2.setMinAndMaxProgress(0.0f, 0.0f);
                dpq.setProgress(0.0f);
                dpq2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dpq.setAlpha(0.5f);
                dpq2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dpq.setAlpha(0.66f);
                dpq2.setAlpha(0.66f);
            } else {
                dpq.setAlpha(1.0f);
                dpq2.setAlpha(1.0f);
            }
            if (this.lqP != null && this.lqP.dik() != null) {
                setVisibility(this.lqP.dik().blk() ? 8 : 0);
            }
        }
    }

    public void bsf() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eQV != null) {
            if (this.lqP == null || this.lqP.dik() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bw dik = this.lqP.dik();
                if (dik.bli()) {
                    i3 = 2;
                } else if (dik.blj()) {
                    i3 = 3;
                } else if (dik.bov()) {
                    i3 = 4;
                } else {
                    i3 = dik.bow() ? 5 : 1;
                }
                String nid = dik.getNid();
                if (dik.getBaijiahaoData() != null && !at.isEmpty(dik.getBaijiahaoData().oriUgcVid)) {
                    str6 = dik.getBaijiahaoData().oriUgcVid;
                }
                int boz = dik.boz();
                String str7 = dik.mRecomSource;
                String str8 = dik.mRecomAbTag;
                String str9 = dik.mRecomWeight;
                String str10 = dik.mRecomExtra;
                str = str8;
                i = boz;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eQV.type == 1) {
                aq dR = new aq("c12003").al("obj_locate", this.eQV.ezt).al("obj_param1", this.eQV.ezu).al("obj_source", this.eQV.ezv).al("obj_id", this.eQV.ezw).al("obj_name", i2).dR("nid", str4).al(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str2).dR("ab_tag", str).dR("weight", str5).dR("recom_extra", str6).dR("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR);
                }
                TiebaStatic.log(dR);
            } else if (this.eQV.type == 2) {
                aq dR2 = new aq("c13271").al("obj_type", this.eQV.ezy).al("obj_locate", this.eQV.ezz).al("obj_id", this.eQV.ezA).al("obj_name", i2).dR("nid", str4).al(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str2).dR("ab_tag", str).dR("weight", str5).dR("recom_extra", str6).dR("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR2);
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public void bxE() {
        this.lHL.Gs(R.color.cp_cont_j);
        this.lHM.Gs(R.color.cp_cont_j);
        this.lHL.setImageResource(R.drawable.icon_weixin_112);
        this.lHM.setImageResource(R.drawable.icon_pengyouqun_112);
        this.lHJ.dpr();
        this.lHK.dpr();
        this.lHL.dpr();
        this.lHM.dpr();
        dpp();
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
        this.eQV = cVar;
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

    private a Gr(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private View Zi;
        private TBLottieAnimationView lHO;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Zi = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lHO = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dpq() {
            return this.lHO;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lHO.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.lHO, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Gs(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lHO.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lHO.addAnimatorListener(animatorListener);
        }

        public void dpr() {
            com.baidu.tbadk.core.util.e.a.brO().pp(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).pq(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).po(R.color.cp_cont_f_alpha50).pk(R.color.cp_bg_line_d).bk(this.Zi);
        }
    }
}
