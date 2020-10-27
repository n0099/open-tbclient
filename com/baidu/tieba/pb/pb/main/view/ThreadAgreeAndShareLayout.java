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
    private e eLc;
    private com.baidu.tbadk.core.data.c eLg;
    private CustomMessageListener eLt;
    private a lBN;
    private a lBO;
    private a lBP;
    private a lBQ;
    private f lkO;
    private AgreeData mAgreeData;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private CustomMessageListener mThreadAgreeChangedListener;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eLt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eLt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.mAgreeData != null) {
            this.mAgreeData.agreeType = agreeData.agreeType;
            this.mAgreeData.hasAgree = agreeData.hasAgree;
            this.mAgreeData.diffAgreeNum = agreeData.diffAgreeNum;
            this.mAgreeData.agreeNum = agreeData.agreeNum;
            this.mAgreeData.disAgreeNum = agreeData.disAgreeNum;
            dmM();
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
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && agreeData != null && ThreadAgreeAndShareLayout.this.eLc != null && !ThreadAgreeAndShareLayout.this.mAgreeData.isInPost && ThreadAgreeAndShareLayout.this.eLc.uniqueId != ThreadAgreeAndShareLayout.this.eLc.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (ThreadAgreeAndShareLayout.this.lkO != null && ThreadAgreeAndShareLayout.this.lkO.dfI() != null && ThreadAgreeAndShareLayout.this.lkO.dfI().getBaijiahaoData() != null && TextUtils.equals(str, ThreadAgreeAndShareLayout.this.lkO.dfI().getBaijiahaoData().oriUgcNid)) {
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
        this.eLt = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (ThreadAgreeAndShareLayout.this.mAgreeData != null && !TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.mAgreeData.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && ThreadAgreeAndShareLayout.this.mAgreeData.postId.equals(agreeData.postId) && !ThreadAgreeAndShareLayout.this.mAgreeData.isInThread && ThreadAgreeAndShareLayout.this.eLc.uniqueId != eVar.uniqueId) {
                        ThreadAgreeAndShareLayout.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAgreeAndShareLayout.this.bi(view);
            }
        };
        setOrientation(0);
        setGravity(17);
        this.mContext = context;
        this.eLc = new e();
        this.eLc.uniqueId = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        initView();
        this.eLg = new com.baidu.tbadk.core.data.c();
    }

    private void initView() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.lBN = Ge(0);
        this.lBO = Ge(dimenPixelSize);
        this.lBP = Ge(dimenPixelSize);
        this.lBQ = Ge(dimenPixelSize);
        this.lBP.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lBQ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lBP.setText(R.string.share_weixin_friend);
        this.lBQ.setText(R.string.share_weixin_timeline);
        this.lBN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lBN.addAnimatorListener(this);
        this.lBO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.lBO.addAnimatorListener(this);
        this.lBN.dmN().setOnClickListener(this.mOnClickListener);
        this.lBO.dmN().setOnClickListener(this.mOnClickListener);
        this.lBP.dmN().setOnClickListener(this.mOnClickListener);
        this.lBQ.dmN().setOnClickListener(this.mOnClickListener);
        bvf();
    }

    public void setData(f fVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lkO = fVar;
        this.mAgreeData = agreeData;
        this.mAgreeData.isInThread = true;
        dmM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(View view) {
        int i = 0;
        int i2 = 1;
        if (this.mAgreeData != null && bg.checkUpIsLogin(getContext())) {
            if (view == this.lBN.dmN() || view == this.lBO.dmN()) {
                if (view == this.lBN.dmN()) {
                    this.lBN.playAnimation();
                    if (this.eLg != null) {
                        this.eLg.type = 1;
                        this.eLg.etA = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 2) {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum--;
                            this.mAgreeData.agreeNum--;
                            dmM();
                            if (this.eLg != null) {
                                this.eLg.etD = 1;
                            }
                        } else {
                            this.mAgreeData.agreeType = 2;
                            this.mAgreeData.hasAgree = true;
                            this.mAgreeData.diffAgreeNum += 2;
                            this.mAgreeData.agreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            vb(true);
                            if (this.eLg != null) {
                                this.eLg.etD = 0;
                                i2 = 0;
                            }
                        }
                        Gd(i2);
                    } else {
                        this.mAgreeData.agreeType = 2;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum++;
                        this.mAgreeData.agreeNum++;
                        vb(true);
                    }
                    i2 = 0;
                    Gd(i2);
                } else if (view == this.lBO.dmN()) {
                    this.lBO.playAnimation();
                    if (this.eLg != null) {
                        this.eLg.type = 2;
                        this.eLg.etA = 4;
                    }
                    if (this.mAgreeData.hasAgree) {
                        if (this.mAgreeData.agreeType == 5) {
                            this.mAgreeData.agreeType = 5;
                            this.mAgreeData.hasAgree = false;
                            this.mAgreeData.diffAgreeNum++;
                            this.mAgreeData.disAgreeNum--;
                            dmM();
                            if (this.eLg != null) {
                                this.eLg.etH = 0;
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
                            vb(false);
                            if (this.eLg != null) {
                                this.eLg.etH = 1;
                            }
                        }
                    } else {
                        this.mAgreeData.agreeType = 5;
                        this.mAgreeData.hasAgree = true;
                        this.mAgreeData.diffAgreeNum--;
                        this.mAgreeData.disAgreeNum++;
                        vb(false);
                        if (this.eLg != null) {
                            this.eLg.etH = 1;
                        }
                    }
                    Gd(i);
                }
                this.eLc.agreeData = this.mAgreeData;
                if (this.mAgreeData.isInThread) {
                    if (this.lkO != null && this.lkO.dfI() != null && this.lkO.dfI().getBaijiahaoData() != null) {
                        this.mAgreeData.nid = this.lkO.dfI().getBaijiahaoData().oriUgcNid;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.eLc));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_THREAD);
                } else if (this.mAgreeData.isInPost) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.eLc));
                    dispatchMutiProcessAgree(this.mAgreeData, AgreeEvent.IS_POST);
                }
                setStatisticData(this.eLg);
                bpF();
            } else if (view == this.lBP.dmN()) {
                if (this.lkO != null) {
                    com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.lkO.dfI(), 3);
                }
            } else if (view == this.lBQ.dmN() && this.lkO != null) {
                com.baidu.tieba.pb.pb.main.d.a.a(this.mContext, this.lkO.dfI(), 2);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void Gd(int i) {
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
            if (this.lkO != null && this.lkO.dfI() != null && this.lkO.dfI().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = this.lkO.dfI().getBaijiahaoData();
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

    public void vb(boolean z) {
        if (this.mAgreeData == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.lBN.lBS;
        TBLottieAnimationView tBLottieAnimationView2 = this.lBO.lBS;
        TextView textView = this.lBN.textView;
        TextView textView2 = this.lBO.textView;
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

    public void dmM() {
        if (this.mAgreeData != null) {
            TBLottieAnimationView dmN = this.lBN.dmN();
            ap.a(dmN, R.raw.lottie_agree);
            TBLottieAnimationView dmN2 = this.lBO.dmN();
            ap.a(dmN2, R.raw.lottie_disagree);
            TextView textView = this.lBN.getTextView();
            TextView textView2 = this.lBO.getTextView();
            textView.setText(at.numFormatOverWanNa(this.mAgreeData.agreeNum));
            textView2.setText(at.numFormatOverWanNa(this.mAgreeData.disAgreeNum));
            if (this.mAgreeData.hasAgree) {
                if (this.mAgreeData.agreeType == 2) {
                    dmN2.setProgress(0.0f);
                    dmN.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_h));
                    textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
                } else {
                    dmN.setProgress(0.0f);
                    dmN2.setProgress(1.0f);
                    textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                    textView2.setTextColor(ap.getColor(R.color.cp_link_tip_c));
                }
            } else {
                dmN.setMinAndMaxProgress(0.0f, 0.0f);
                dmN2.setMinAndMaxProgress(0.0f, 0.0f);
                dmN.setProgress(0.0f);
                dmN2.setProgress(0.0f);
                textView.setTextColor(ap.getColor(R.color.cp_cont_j));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_j));
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                dmN.setAlpha(0.5f);
                dmN2.setAlpha(0.5f);
            } else if (skinType == 4) {
                dmN.setAlpha(0.66f);
                dmN2.setAlpha(0.66f);
            } else {
                dmN.setAlpha(1.0f);
                dmN2.setAlpha(1.0f);
            }
            if (this.lkO != null && this.lkO.dfI() != null) {
                setVisibility(this.lkO.dfI().biK() ? 8 : 0);
            }
        }
    }

    public void bpF() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6 = null;
        if (this.eLg != null) {
            if (this.lkO == null || this.lkO.dfI() == null) {
                str = null;
                str2 = null;
                i = 0;
                str3 = null;
                str4 = null;
                i2 = 1;
                str5 = null;
            } else {
                bw dfI = this.lkO.dfI();
                if (dfI.biI()) {
                    i3 = 2;
                } else if (dfI.biJ()) {
                    i3 = 3;
                } else if (dfI.blV()) {
                    i3 = 4;
                } else {
                    i3 = dfI.blW() ? 5 : 1;
                }
                String nid = dfI.getNid();
                if (dfI.getBaijiahaoData() != null && !at.isEmpty(dfI.getBaijiahaoData().oriUgcVid)) {
                    str6 = dfI.getBaijiahaoData().oriUgcVid;
                }
                int blZ = dfI.blZ();
                String str7 = dfI.mRecomSource;
                String str8 = dfI.mRecomAbTag;
                String str9 = dfI.mRecomWeight;
                String str10 = dfI.mRecomExtra;
                str = str8;
                i = blZ;
                str4 = nid;
                i2 = i3;
                str5 = str9;
                str2 = str7;
                str3 = str6;
                str6 = str10;
            }
            if (this.eLg.type == 1) {
                aq dR = new aq("c12003").aj("obj_locate", this.eLg.etA).aj("obj_param1", this.eLg.etB).aj("obj_source", this.eLg.etC).aj("obj_id", this.eLg.etD).aj("obj_name", i2).dR("nid", str4).aj(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str2).dR("ab_tag", str).dR("weight", str5).dR("recom_extra", str6).dR("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR);
                }
                TiebaStatic.log(dR);
            } else if (this.eLg.type == 2) {
                aq dR2 = new aq("c13271").aj("obj_type", this.eLg.etF).aj("obj_locate", this.eLg.etG).aj("obj_id", this.eLg.etH).aj("obj_name", i2).dR("nid", str4).aj(IntentConfig.CARD_TYPE, i).dR(IntentConfig.RECOM_SOURCE, str2).dR("ab_tag", str).dR("weight", str5).dR("recom_extra", str6).dR("obj_param6", str3);
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.b(getTbPageContext().getPageActivity(), dR2);
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public void bvf() {
        this.lBP.Gf(R.color.cp_cont_j);
        this.lBQ.Gf(R.color.cp_cont_j);
        this.lBP.setImageResource(R.drawable.icon_weixin_112);
        this.lBQ.setImageResource(R.drawable.icon_pengyouqun_112);
        this.lBN.dmO();
        this.lBO.dmO();
        this.lBP.dmO();
        this.lBQ.dmO();
        dmM();
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
        this.eLg = cVar;
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

    private a Ge(int i) {
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
        private TBLottieAnimationView lBS;
        private TextView textView;
        private View view;

        public a(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.view = inflate;
            this.Zi = inflate.findViewById(R.id.item_bg);
            this.textView = (TextView) inflate.findViewById(R.id.item_text);
            this.lBS = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public View getView() {
            return this.view;
        }

        public TBLottieAnimationView dmN() {
            return this.lBS;
        }

        public TextView getTextView() {
            return this.textView;
        }

        public void playAnimation() {
            this.lBS.playAnimation();
        }

        public void setImageResource(int i) {
            ap.setImageResource(this.lBS, i);
        }

        public void setText(int i) {
            this.textView.setText(i);
        }

        public void Gf(int i) {
            ap.setViewTextColor(this.textView, i, 1);
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            this.lBS.setScaleType(scaleType);
        }

        public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
            this.lBS.addAnimatorListener(animatorListener);
        }

        public void dmO() {
            com.baidu.tbadk.core.util.e.a.bpo().pe(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).pf(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).pd(R.color.cp_cont_f_alpha50).pa(R.color.cp_bg_line_d).bg(this.Zi);
        }
    }
}
