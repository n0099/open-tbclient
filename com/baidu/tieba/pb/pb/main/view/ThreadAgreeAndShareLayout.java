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
    private f lKe;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;
    private a mbl;
    private a mbm;
    private a mbn;
    private a mbo;

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
            dtX();
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
                            if (ThreadAgreeAndShareLayout.this.lKe != null && ThreadAgreeAndShareLayout.this.lKe.dmF() != null && ThreadAgreeAndShareLayout.this.lKe.dmF().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lKe.dmF().getBaijiahaoData().oriUgcNid)) {
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
        this.mbl = Hz(0);
        this.mbm = Hz(dimenPixelSize);
        this.mbn = Hz(dimenPixelSize);
        this.mbo = Hz(dimenPixelSize);
        this.mbn.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mbo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mbn.setText(R.string.share_weixin_friend);
        this.mbo.setText(R.string.share_weixin_timeline);
        this.mbl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mbl.addAnimatorListener(this);
        this.mbm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mbm.addAnimatorListener(this);
        this.mbl.dtY().setOnClickListener(this.mOnClickListener);
        this.mbm.dtY().setOnClickListener(this.mOnClickListener);
        this.mbn.dtY().setOnClickListener(this.mOnClickListener);
        this.mbo.dtY().setOnClickListener(this.mOnClickListener);
        bCP();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lKe = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dtX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.mbl.dtY() || view == this.mbm.dtY()) {
                if (view == this.mbl.dtY()) {
                    this.mbl.playAnimation();
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
                            dtX();
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
                } else if (view == this.mbm.dtY()) {
                    this.mbm.playAnimation();
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
                            dtX();
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
                    if (this.lKe != null && this.lKe.dmF() != null && this.lKe.dmF().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lKe.dmF().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.fgI));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.fgI));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.fgM);
                bxm();
            } else if (view == this.mbn.dtY()) {
                if (this.lKe != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lKe.dmF(), 3);
                }
            } else if (view == this.mbo.dtY() && this.lKe != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lKe.dmF(), 2);
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
            if (this.lKe != null && this.lKe.dmF() != null && this.lKe.dmF().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lKe.dmF().getBaijiahaoData();
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
        TBLottieAnimationView tBLottieAnimationView = this.mbl.mbq;
        TBLottieAnimationView tBLottieAnimationView2 = this.mbm.mbq;
        TextView textView = this.mbl.textView;
        TextView textView2 = this.mbm.textView;
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

    public void dtX() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dtY = this.mbl.dtY();
            ao.a(dtY, R.raw.lottie_agree);
            TBLottieAnimationView dtY2 = this.mbm.dtY();
            ao.a(dtY2, R.raw.lottie_disagree);
            TextView textView = this.mbl.getTextView();
            TextView textView2 = this.mbm.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dtY2.setProgress(0.0f);
                    dtY.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
                } else {
                    dtY.setProgress(0.0f);
                    dtY2.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ao.getColor(R.color.CAM_X0304));
                }
            } else {
                dtY.setMinAndMaxProgress(0.0f, 0.0f);
                dtY2.setMinAndMaxProgress(0.0f, 0.0f);
                dtY.setProgress(0.0f);
                dtY2.setProgress(0.0f);
                textView.setTextColor(ao.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ao.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dtY.setAlpha(0.5f);
                dtY2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dtY.setAlpha(0.66f);
                dtY2.setAlpha(0.66f);
            } else {
                dtY.setAlpha(1.0f);
                dtY2.setAlpha(1.0f);
            }
            if (this.lKe != null && this.lKe.dmF() != null) {
                setVisibility(this.lKe.dmF().bqa() ? 8 : 0);
            }
        }
    }

    public void bxm() {
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
            if (this.lKe == null || this.lKe.dmF() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                i2 = 1;
            } else {
                bz dmF = this.lKe.dmF();
                if (dmF.bpY()) {
                    i3 = 2;
                } else if (dmF.bpZ()) {
                    i3 = 3;
                } else if (dmF.btp()) {
                    i3 = 4;
                } else {
                    i3 = dmF.btq() ? 5 : 1;
                }
                str6 = dmF.bpP();
                if (dmF.getBaijiahaoData() != null && !at.isEmpty(dmF.getBaijiahaoData().oriUgcVid)) {
                    str7 = dmF.getBaijiahaoData().oriUgcVid;
                }
                i = dmF.btt();
                str4 = dmF.mRecomSource;
                str3 = dmF.mRecomAbTag;
                str2 = dmF.mRecomWeight;
                str = dmF.mRecomExtra;
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
                if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                    dX.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
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

    public void bCP() {
        this.mbn.HA(R.color.CAM_X0107);
        this.mbo.HA(R.color.CAM_X0107);
        this.mbn.setImageResource(R.drawable.icon_weixin_112);
        this.mbo.setImageResource(R.drawable.icon_pengyouqun_112);
        this.mbl.dtZ();
        this.mbm.dtZ();
        this.mbn.dtZ();
        this.mbo.dtZ();
        dtX();
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
        private TBLottieAnimationView mbq;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.aaS = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.mbq = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dtY() {
            return this.mbq;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.mbq.playAnimation();
        }

        public void setImageResource(int i) {
            ao.setImageResource(this.mbq, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void HA(int i) {
            ao.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.mbq.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.mbq.addAnimatorListener(animatorListener);
        }

        public void dtZ() {
            com.baidu.tbadk.core.util.f.a.bwV().qx(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).qy(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).qw(R.color.cp_cont_f_alpha50).qr(R.color.CAM_X0201).bz(this.aaS);
        }
    }
}
