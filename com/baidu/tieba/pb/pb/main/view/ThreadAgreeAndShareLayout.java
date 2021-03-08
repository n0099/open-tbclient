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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes2.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    private e ffO;
    private com.baidu.tbadk.core.data.e ffS;
    private CustomMessageListener fgf;
    private f lQH;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;
    private a mia;
    private a mib;
    private a mic;
    private a mie;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fgf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fgf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dsJ();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.ffO != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.ffO.uniqueId != ThreadAgreeAndShareLayout.this.ffO.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lQH != null && ThreadAgreeAndShareLayout.this.lQH.dlp() != null && ThreadAgreeAndShareLayout.this.lQH.dlp().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lQH.dlp().getBaijiahaoData().oriUgcNid)) {
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
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.ffO.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bx(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.ffO = new e();
        this.ffO.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.ffS = new com.baidu.tbadk.core.data.e();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.mia = Gp(0);
        this.mib = Gp(dimenPixelSize);
        this.mic = Gp(dimenPixelSize);
        this.mie = Gp(dimenPixelSize);
        this.mic.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mie.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mic.setText(R.string.share_weixin_friend);
        this.mie.setText(R.string.share_weixin_timeline);
        this.mia.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mia.addAnimatorListener(this);
        this.mib.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mib.addAnimatorListener(this);
        this.mia.dsK().setOnClickListener(this.mOnClickListener);
        this.mib.dsK().setOnClickListener(this.mOnClickListener);
        this.mic.dsK().setOnClickListener(this.mOnClickListener);
        this.mie.dsK().setOnClickListener(this.mOnClickListener);
        bzq();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lQH = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dsJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bh.checkUpIsLogin(getContext())) {
            if (view == this.mia.dsK() || view == this.mib.dsK()) {
                if (view == this.mia.dsK()) {
                    this.mia.playAnimation();
                    if (this.ffS != null) {
                        this.ffS.type = 1;
                        this.ffS.eNB = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dsJ();
                            if (this.ffS != null) {
                                this.ffS.eNE = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            wd(true);
                            if (this.ffS != null) {
                                this.ffS.eNE = 0;
                                i2 = 0;
                            }
                        }
                        Go(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        wd(true);
                    }
                    i2 = 0;
                    Go(i2);
                } else if (view == this.mib.dsK()) {
                    this.mib.playAnimation();
                    if (this.ffS != null) {
                        this.ffS.type = 2;
                        this.ffS.eNB = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dsJ();
                            if (this.ffS != null) {
                                this.ffS.eNI = 0;
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
                            wd(false);
                            if (this.ffS != null) {
                                this.ffS.eNI = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        wd(false);
                        if (this.ffS != null) {
                            this.ffS.eNI = 1;
                        }
                    }
                    Go(i);
                }
                this.ffO.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lQH != null && this.lQH.dlp() != null && this.lQH.dlp().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lQH.dlp().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ffO));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ffO));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.ffS);
                btP();
            } else if (view == this.mic.dsK()) {
                if (this.lQH != null) {
                    com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lQH.dlp(), 3);
                }
            } else if (view == this.mie.dsK() && this.lQH != null) {
                com.baidu.tieba.pb.pb.main.d.b.a(this.mContext, this.lQH.dlp(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Go(int i) {
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
            com.baidu.tbadk.pageExtra.c bR = d.bR(this);
            if (bR != null) {
                httpMessage.addParam("obj_source", bR.getCurrentPageKey());
            }
            if (!TextUtils.isEmpty(this.mAgreeData.postId)) {
                httpMessage.addParam("post_id", this.mAgreeData.postId);
            }
            if (this.lQH != null && this.lQH.dlp() != null && this.lQH.dlp().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lQH.dlp().getBaijiahaoData();
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

    public void wd(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.mia.mig;
        TBLottieAnimationView tBLottieAnimationView2 = this.mib.mig;
        TextView textView = this.mia.textView;
        TextView textView2 = this.mib.textView;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
        textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
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
                textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                return;
            }
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
            textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
            return;
        }
        textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
    }

    public void dsJ() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dsK = this.mia.dsK();
            ap.a(dsK, R.raw.lottie_agree);
            TBLottieAnimationView dsK2 = this.mib.dsK();
            ap.a(dsK2, R.raw.lottie_disagree);
            TextView textView = this.mia.getTextView();
            TextView textView2 = this.mib.getTextView();
            textView.setText(au.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(au.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dsK2.setProgress(0.0f);
                    dsK.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
                } else {
                    dsK.setProgress(0.0f);
                    dsK2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                    textView2.setTextColor(ap.getColor(R.color.CAM_X0304));
                }
            } else {
                dsK.setMinAndMaxProgress(0.0f, 0.0f);
                dsK2.setMinAndMaxProgress(0.0f, 0.0f);
                dsK.setProgress(0.0f);
                dsK2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.CAM_X0107));
                textView2.setTextColor(ap.getColor(R.color.CAM_X0107));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dsK.setAlpha(0.5f);
                dsK2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dsK.setAlpha(0.66f);
                dsK2.setAlpha(0.66f);
            } else {
                dsK.setAlpha(1.0f);
                dsK2.setAlpha(1.0f);
            }
            if (this.lQH != null && this.lQH.dlp() != null) {
                setVisibility(this.lQH.dlp().bmB() ? 8 : 0);
            }
        }
    }

    public void btP() {
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
        if (this.ffS != null) {
            if (this.lQH == null || this.lQH.dlp() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                i2 = 1;
            } else {
                cb dlp = this.lQH.dlp();
                if (dlp.bmz()) {
                    i3 = 2;
                } else if (dlp.bmA()) {
                    i3 = 3;
                } else if (dlp.bpP()) {
                    i3 = 4;
                } else {
                    i3 = dlp.bpQ() ? 5 : 1;
                }
                str6 = dlp.bmq();
                if (dlp.getBaijiahaoData() != null && !au.isEmpty(dlp.getBaijiahaoData().oriUgcVid)) {
                    str7 = dlp.getBaijiahaoData().oriUgcVid;
                }
                i = dlp.bpT();
                str4 = dlp.mRecomSource;
                str3 = dlp.mRecomAbTag;
                str2 = dlp.mRecomWeight;
                str = dlp.mRecomExtra;
                str5 = str7;
                i2 = i3;
            }
            if (this.ffS.type == 1) {
                ar dR = new ar("c12003").aq("obj_locate", this.ffS.eNB).aq("obj_param1", this.ffS.eNC).aq("obj_source", this.ffS.eND).aq("obj_id", this.ffS.eNE).aq("obj_name", i2).dR(IntentConfig.NID, str6).aq(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str4).dR("ab_tag", str3).dR("weight", str2).dR("recom_extra", str).dR("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR);
                }
                com.baidu.tbadk.pageExtra.c bR = d.bR(this);
                if (bR != null) {
                    dR.dR("obj_cur_page", bR.getCurrentPageKey());
                }
                if (d.bDP() != null) {
                    dR.dR("obj_pre_page", d.bDP());
                }
                TiebaStatic.log(dR);
            } else if (this.ffS.type == 2) {
                ar dR2 = new ar("c13271").aq("obj_type", this.ffS.eNG).aq("obj_locate", this.ffS.eNH).aq("obj_id", this.ffS.eNI).aq("obj_name", i2).dR(IntentConfig.NID, str6).aq(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str4).dR("ab_tag", str3).dR("weight", str2).dR("recom_extra", str).dR("obj_param6", str5);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR2);
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public void bzq() {
        this.mic.Gq(R.color.CAM_X0107);
        this.mie.Gq(R.color.CAM_X0107);
        this.mic.setImageResource(R.drawable.icon_weixin_112);
        this.mie.setImageResource(R.drawable.icon_pengyouqun_112);
        this.mia.dsL();
        this.mib.dsL();
        this.mic.dsL();
        this.mie.dsL();
        dsJ();
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

    public void setStatisticData(com.baidu.tbadk.core.data.e eVar) {
        this.ffS = eVar;
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

    private a Gp(int i) {
        a aVar = new a(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(aVar.getView(), layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private View acg;
        private TBLottieAnimationView mig;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.acg = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.mig = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dsK() {
            return this.mig;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.mig.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.mig, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Gq(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.mig.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.mig.addAnimatorListener(animatorListener);
        }

        public void dsL() {
            com.baidu.tbadk.core.util.f.a.bty().oW(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).oX(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).oV(R.color.cp_cont_f_alpha50).oQ(R.color.CAM_X0201).bv(this.acg);
        }
    }
}
