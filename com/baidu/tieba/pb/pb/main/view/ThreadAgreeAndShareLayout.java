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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e fgI;
    private d fgM;
    private CustomMessageListener fgZ;
    private f lKf;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;
    private a mbm;
    private a mbn;
    private a mbo;
    private a mbp;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fgZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fgZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dtW();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.fgI != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.fgI.uniqueId != ThreadAgreeAndShareLayout.this.fgI.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lKf != null && ThreadAgreeAndShareLayout.this.lKf.dmE() != null && ThreadAgreeAndShareLayout.this.lKf.dmE().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lKf.dmE().getBaijiahaoData().oriUgcNid)) {
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
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.fgI.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bB(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.fgI = new e();
        this.fgI.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.fgM = new d();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.mbm = Hz(0);
        this.mbn = Hz(dimenPixelSize);
        this.mbo = Hz(dimenPixelSize);
        this.mbp = Hz(dimenPixelSize);
        this.mbo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mbp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mbo.setText(R.string.share_weixin_friend);
        this.mbp.setText(R.string.share_weixin_timeline);
        this.mbm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mbm.addAnimatorListener(this);
        this.mbn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mbn.addAnimatorListener(this);
        this.mbm.dtX().setOnClickListener(this.mOnClickListener);
        this.mbn.dtX().setOnClickListener(this.mOnClickListener);
        this.mbo.dtX().setOnClickListener(this.mOnClickListener);
        this.mbp.dtX().setOnClickListener(this.mOnClickListener);
        bCO();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lKf = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dtW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.mbm.dtX() || view == this.mbn.dtX()) {
                if (view == this.mbm.dtX()) {
                    this.mbm.playAnimation();
                    if (this.fgM != null) {
                        this.fgM.type = 1;
                        this.fgM.eOz = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dtW();
                            if (this.fgM != null) {
                                this.fgM.eOC = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            vR(true);
                            if (this.fgM != null) {
                                this.fgM.eOC = 0;
                                i2 = 0;
                            }
                        }
                        Hy(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        vR(true);
                    }
                    i2 = 0;
                    Hy(i2);
                } else if (view == this.mbn.dtX()) {
                    this.mbn.playAnimation();
                    if (this.fgM != null) {
                        this.fgM.type = 2;
                        this.fgM.eOz = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dtW();
                            if (this.fgM != null) {
                                this.fgM.eOG = 0;
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
                            vR(false);
                            if (this.fgM != null) {
                                this.fgM.eOG = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        vR(false);
                        if (this.fgM != null) {
                            this.fgM.eOG = 1;
                        }
                    }
                    Hy(i);
                }
                this.fgI.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lKf != null && this.lKf.dmE() != null && this.lKf.dmE().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lKf.dmE().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.fgI));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.fgI));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.fgM);
                bxl();
            } else if (view == this.mbo.dtX()) {
                if (this.lKf != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lKf.dmE(), 3);
                }
            } else if (view == this.mbp.dtX() && this.lKf != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lKf.dmE(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Hy(int i) {
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
            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
            if (bV != null) {
                httpMessage.addParam("obj_source", bV.getCurrentPageKey());
            }
            if (!TextUtils.isEmpty(this.mAgreeData.postId)) {
                httpMessage.addParam("post_id", this.mAgreeData.postId);
            }
            if (this.lKf != null && this.lKf.dmE() != null && this.lKf.dmE().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lKf.dmE().getBaijiahaoData();
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

    public void vR(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.mbm.mbr;
        TBLottieAnimationView tBLottieAnimationView2 = this.mbn.mbr;
        TextView textView = this.mbm.textView;
        TextView textView2 = this.mbn.textView;
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
                textView.setTextColor(ao.getColor(R.color.CAM_X0301));
                textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
                return;
            }
            textView.setTextColor(ao.getColor(R.color.CAM_X0107));
            textView2.setTextColor(ao.getColor(R.color.CAM_X0304));
            return;
        }
        textView.setTextColor(ao.getColor(R.color.CAM_X0107));
        textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
    }

    public void dtW() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dtX = this.mbm.dtX();
            ao.a(dtX, R.raw.lottie_agree);
            TBLottieAnimationView dtX2 = this.mbn.dtX();
            ao.a(dtX2, R.raw.lottie_disagree);
            TextView textView = this.mbm.getTextView();
            TextView textView2 = this.mbn.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dtX2.setProgress(0.0f);
                    dtX.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
                } else {
                    dtX.setProgress(0.0f);
                    dtX2.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ao.getColor(R.color.CAM_X0304));
                }
            } else {
                dtX.setMinAndMaxProgress(0.0f, 0.0f);
                dtX2.setMinAndMaxProgress(0.0f, 0.0f);
                dtX.setProgress(0.0f);
                dtX2.setProgress(0.0f);
                textView.setTextColor(ao.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dtX.setAlpha(0.5f);
                dtX2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dtX.setAlpha(0.66f);
                dtX2.setAlpha(0.66f);
            } else {
                dtX.setAlpha(1.0f);
                dtX2.setAlpha(1.0f);
            }
            if (this.lKf != null && this.lKf.dmE() != null) {
                setVisibility(this.lKf.dmE().bpZ() ? 8 : 0);
            }
        }
    }

    public void bxl() {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        int i2;
        int i3;
        String str7 = null;
        if (this.fgM != null) {
            if (this.lKf == null || this.lKf.dmE() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                i2 = 1;
            } else {
                bz dmE = this.lKf.dmE();
                if (dmE.bpX()) {
                    i3 = 2;
                } else if (dmE.bpY()) {
                    i3 = 3;
                } else if (dmE.bto()) {
                    i3 = 4;
                } else {
                    i3 = dmE.btp() ? 5 : 1;
                }
                str6 = dmE.bpO();
                if (dmE.getBaijiahaoData() != null && !at.isEmpty(dmE.getBaijiahaoData().oriUgcVid)) {
                    str7 = dmE.getBaijiahaoData().oriUgcVid;
                }
                i = dmE.bts();
                str4 = dmE.mRecomSource;
                str3 = dmE.mRecomAbTag;
                str2 = dmE.mRecomWeight;
                str = dmE.mRecomExtra;
                str5 = str7;
                i2 = i3;
            }
            if (this.fgM.type == 1) {
                aq dX = new aq("c12003").an("obj_locate", this.fgM.eOz).an("obj_param1", this.fgM.eOA).an("obj_source", this.fgM.eOB).an("obj_id", this.fgM.eOC).an("obj_name", i2).dX(IntentConfig.NID, str6).an(IntentConfig.CARD_TYPE, i).dX(IntentConfig.RECOM_SOURCE, str4).dX("ab_tag", str3).dX("weight", str2).dX("recom_extra", str).dX("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dX);
                }
                com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
                if (bV != null) {
                    dX.dX("obj_cur_page", bV.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                    dX.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
                }
                TiebaStatic.log(dX);
            } else if (this.fgM.type == 2) {
                aq dX2 = new aq("c13271").an("obj_type", this.fgM.eOE).an("obj_locate", this.fgM.eOF).an("obj_id", this.fgM.eOG).an("obj_name", i2).dX(IntentConfig.NID, str6).an(IntentConfig.CARD_TYPE, i).dX(IntentConfig.RECOM_SOURCE, str4).dX("ab_tag", str3).dX("weight", str2).dX("recom_extra", str).dX("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dX2);
                }
                TiebaStatic.log(dX2);
            }
        }
    }

    public void bCO() {
        this.mbo.HA(R.color.CAM_X0107);
        this.mbp.HA(R.color.CAM_X0107);
        this.mbo.setImageResource(R.drawable.icon_weixin_112);
        this.mbp.setImageResource(R.drawable.icon_pengyouqun_112);
        this.mbm.dtY();
        this.mbn.dtY();
        this.mbo.dtY();
        this.mbp.dtY();
        dtW();
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
        this.fgM = dVar;
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

    private a Hz(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private View aaS;
        private TBLottieAnimationView mbr;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.aaS = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.mbr = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dtX() {
            return this.mbr;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.mbr.playAnimation();
        }

        public void setImageResource(int i) {
            ao.setImageResource(this.mbr, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void HA(int i) {
            ao.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.mbr.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.mbr.addAnimatorListener(animatorListener);
        }

        public void dtY() {
            com.baidu.tbadk.core.util.f.a.bwU().qx(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).qy(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).qw(R.color.cp_cont_f_alpha50).qr(R.color.CAM_X0201).bz(this.aaS);
        }
    }
}
