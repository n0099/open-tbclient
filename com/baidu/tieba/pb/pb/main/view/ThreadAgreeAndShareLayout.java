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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes16.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private com.baidu.tbadk.core.data.c eeD;
    private CustomMessageListener eeQ;
    private e eez;
    private a kBH;
    private a kBI;
    private a kBJ;
    private a kBK;
    private f kli;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eeQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eeQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            cRB();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.eez != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.eez.uniqueId != ThreadAgreeAndShareLayout.this.eez.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.kli != null && ThreadAgreeAndShareLayout.this.kli.cKx() != null && ThreadAgreeAndShareLayout.this.kli.cKx().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.kli.cKx().getBaijiahaoData().oriUgcNid)) {
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
        this.eeQ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.eez.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.aZ(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.eez = new e();
        this.eez.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eeD = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.kBH = Ck(0);
        this.kBI = Ck(dimenPixelSize);
        this.kBJ = Ck(dimenPixelSize);
        this.kBK = Ck(dimenPixelSize);
        this.kBJ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kBK.setScaleType(ImageView.ScaleType.FIT_XY);
        this.kBJ.setText(R.string.share_weixin_friend);
        this.kBK.setText(R.string.share_weixin_timeline);
        this.kBH.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kBH.addAnimatorListener(this);
        this.kBI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.kBI.addAnimatorListener(this);
        this.kBH.cRC().setOnClickListener(this.mOnClickListener);
        this.kBI.cRC().setOnClickListener(this.mOnClickListener);
        this.kBJ.cRC().setOnClickListener(this.mOnClickListener);
        this.kBK.cRC().setOnClickListener(this.mOnClickListener);
        bgV();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kli = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        cRB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bf.checkUpIsLogin(getContext())) {
            if (view == this.kBH.cRC() || view == this.kBI.cRC()) {
                if (view == this.kBH.cRC()) {
                    this.kBH.playAnimation();
                    if (this.eeD != null) {
                        this.eeD.type = 1;
                        this.eeD.dNB = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            cRB();
                            if (this.eeD != null) {
                                this.eeD.dNE = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            tk(true);
                            if (this.eeD != null) {
                                this.eeD.dNE = 0;
                                i2 = 0;
                            }
                        }
                        Cj(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        tk(true);
                    }
                    i2 = 0;
                    Cj(i2);
                } else if (view == this.kBI.cRC()) {
                    this.kBI.playAnimation();
                    if (this.eeD != null) {
                        this.eeD.type = 2;
                        this.eeD.dNB = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            cRB();
                            if (this.eeD != null) {
                                this.eeD.dNI = 0;
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
                            tk(false);
                            if (this.eeD != null) {
                                this.eeD.dNI = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        tk(false);
                        if (this.eeD != null) {
                            this.eeD.dNI = 1;
                        }
                    }
                    Cj(i);
                }
                this.eez.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.kli != null && this.kli.cKx() != null && this.kli.cKx().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.kli.cKx().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.eez));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.eez));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eeD);
                bbL();
            } else if (view == this.kBJ.cRC()) {
                if (this.kli != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kli.cKx(), 3);
                }
            } else if (view == this.kBK.cRC() && this.kli != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.kli.cKx(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Cj(int i) {
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
            if (this.kli != null && this.kli.cKx() != null && this.kli.cKx().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.kli.cKx().getBaijiahaoData();
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

    public void tk(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.kBH.kBM;
        TBLottieAnimationView tBLottieAnimationView2 = this.kBI.kBM;
        TextView textView = this.kBH.textView;
        TextView textView2 = this.kBI.textView;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(as.numFormatOverWanNa(this.mAgreeData.agreeNum));
        textView2.setText(as.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
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
                textView.setTextColor(ao.getColor(R.color.cp_cont_h));
                textView2.setTextColor(ao.getColor(R.color.cp_cont_j));
                return;
            }
            textView.setTextColor(ao.getColor(R.color.cp_cont_j));
            textView2.setTextColor(ao.getColor(R.color.cp_link_tip_c));
            return;
        }
        textView.setTextColor(ao.getColor(R.color.cp_cont_j));
        textView2.setTextColor(ao.getColor(R.color.cp_cont_j));
    }

    public void cRB() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView cRC = this.kBH.cRC();
            ao.a(cRC, R.raw.lottie_agree);
            TBLottieAnimationView cRC2 = this.kBI.cRC();
            ao.a(cRC2, R.raw.lottie_disagree);
            TextView textView = this.kBH.getTextView();
            TextView textView2 = this.kBI.getTextView();
            textView.setText(as.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(as.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    cRC2.setProgress(0.0f);
                    cRC.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ao.getColor(R.color.cp_cont_j));
                } else {
                    cRC.setProgress(0.0f);
                    cRC2.setProgress(1.0f);
                    textView.setTextColor(ao.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ao.getColor(R.color.cp_link_tip_c));
                }
            } else {
                cRC.setMinAndMaxProgress(0.0f, 0.0f);
                cRC2.setMinAndMaxProgress(0.0f, 0.0f);
                cRC.setProgress(0.0f);
                cRC2.setProgress(0.0f);
                textView.setTextColor(ao.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ao.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                cRC.setAlpha(0.5f);
                cRC2.setAlpha(0.5f);
            } else if (skinType == 4) {
                cRC.setAlpha(0.66f);
                cRC2.setAlpha(0.66f);
            } else {
                cRC.setAlpha(1.0f);
                cRC2.setAlpha(1.0f);
            }
            if (this.kli != null && this.kli.cKx() != null) {
                setVisibility(this.kli.cKx().aUV() ? 8 : 0);
            }
        }
    }

    public void bbL() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eeD != null) {
            if (this.kli == null || this.kli.cKx() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bv cKx = this.kli.cKx();
                if (cKx.aUT()) {
                    i3 = 2;
                } else if (cKx.aUU()) {
                    i3 = 3;
                } else if (cKx.aYg()) {
                    i3 = 4;
                } else {
                    i3 = cKx.aYh() ? 5 : 1;
                }
                String nid = cKx.getNid();
                if (cKx.getBaijiahaoData() != null && !as.isEmpty(cKx.getBaijiahaoData().oriUgcVid)) {
                    str6 = cKx.getBaijiahaoData().oriUgcVid;
                }
                int aYk = cKx.aYk();
                String str7 = cKx.mRecomSource;
                String str8 = cKx.mRecomAbTag;
                String str9 = cKx.mRecomWeight;
                String str10 = cKx.mRecomExtra;
                str = str8;
                i = aYk;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eeD.type == 1) {
                ap dn = new ap("c12003").ah("obj_locate", this.eeD.dNB).ah("obj_param1", this.eeD.dNC).ah("obj_source", this.eeD.dND).ah("obj_id", this.eeD.dNE).ah("obj_name", i2).dn("nid", str4).ah(IntentConfig.CARD_TYPE, i).dn(IntentConfig.RECOM_SOURCE, str2).dn("ab_tag", str).dn("weight", str5).dn("recom_extra", str6).dn("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dn);
                }
                TiebaStatic.log(dn);
            } else if (this.eeD.type == 2) {
                ap dn2 = new ap("c13271").ah("obj_type", this.eeD.dNG).ah("obj_locate", this.eeD.dNH).ah("obj_id", this.eeD.dNI).ah("obj_name", i2).dn("nid", str4).ah(IntentConfig.CARD_TYPE, i).dn(IntentConfig.RECOM_SOURCE, str2).dn("ab_tag", str).dn("weight", str5).dn("recom_extra", str6).dn("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dn2);
                }
                TiebaStatic.log(dn2);
            }
        }
    }

    public void bgV() {
        this.kBJ.Cl(R.color.cp_cont_j);
        this.kBK.Cl(R.color.cp_cont_j);
        this.kBJ.setImageResource(R.drawable.icon_weixin_112);
        this.kBK.setImageResource(R.drawable.icon_pengyouqun_112);
        this.kBH.cRD();
        this.kBI.cRD();
        this.kBJ.cRD();
        this.kBK.cRD();
        cRB();
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
        this.eeD = cVar;
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

    private a Ck(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        private View XQ;
        private TBLottieAnimationView kBM;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.XQ = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.kBM = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView cRC() {
            return this.kBM;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.kBM.playAnimation();
        }

        public void setImageResource(int i) {
            ao.setImageResource(this.kBM, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Cl(int i) {
            ao.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.kBM.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.kBM.addAnimatorListener(animatorListener);
        }

        public void cRD() {
            com.baidu.tbadk.core.util.e.a.bbr().mf(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).mg(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).me(R.color.cp_cont_f_alpha50).mb(R.color.cp_bg_line_d).aX(this.XQ);
        }
    }
}
