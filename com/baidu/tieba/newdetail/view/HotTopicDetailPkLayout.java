package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes21.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView ajm;
    private TextView evg;
    private int jBV;
    private i jPi;
    private TextView jQQ;
    private TextView lcF;
    private TextView lcG;
    private View lcH;
    private ViewGroup.LayoutParams lcI;
    private int lcJ;
    private int lcK;
    private ValueAnimator lcL;
    private HotTopicDetailPkProcess lcM;
    private TextView lcN;
    private TextView lcO;
    private TextView lcP;
    private TextView lcQ;
    private ColorStateList lcR;
    private ColorStateList lcS;
    private Runnable lcT;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jBV = 3;
        this.lcJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lcK = 0;
        this.lcR = ap.getColorList(R.color.cp_other_b);
        this.lcS = ap.getColorList(R.color.cp_link_tip_b);
        this.lcT = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lcO != null) {
                    HotTopicDetailPkLayout.this.lcO.setVisibility(8);
                    HotTopicDetailPkLayout.this.lcQ.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        this.lcJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lcK = 0;
        this.lcR = ap.getColorList(R.color.cp_other_b);
        this.lcS = ap.getColorList(R.color.cp_link_tip_b);
        this.lcT = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lcO != null) {
                    HotTopicDetailPkLayout.this.lcO.setVisibility(8);
                    HotTopicDetailPkLayout.this.lcQ.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        this.lcJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lcK = 0;
        this.lcR = ap.getColorList(R.color.cp_other_b);
        this.lcS = ap.getColorList(R.color.cp_link_tip_b);
        this.lcT = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lcO != null) {
                    HotTopicDetailPkLayout.this.lcO.setVisibility(8);
                    HotTopicDetailPkLayout.this.lcQ.setVisibility(8);
                }
            }
        };
        initView();
    }

    private void initView() {
        e<?> I = com.baidu.adp.base.i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.evg = (TextView) findViewById(R.id.titleView);
        this.jQQ = (TextView) findViewById(R.id.descView);
        this.lcF = (TextView) findViewById(R.id.pkBtn1);
        this.lcF.setOnClickListener(this);
        this.lcG = (TextView) findViewById(R.id.pkBtn2);
        this.lcG.setOnClickListener(this);
        this.lcH = findViewById(R.id.progressBottomLayout);
        this.lcI = this.lcH.getLayoutParams();
        this.lcI.height = this.lcK;
        this.lcH.setLayoutParams(this.lcI);
        this.lcH.setAlpha(0.0f);
        this.lcM = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lcN = (TextView) findViewById(R.id.pkText1);
        this.lcO = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lcP = (TextView) findViewById(R.id.pkText2);
        this.lcQ = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.jPi = iVar;
        mi(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(boolean z) {
        i iVar = this.jPi;
        int i = iVar.jOR == 1 ? 1 : 0;
        int i2 = iVar.jOR == 2 ? 1 : 0;
        long j = iVar.jPO + iVar.jPP + i + i2;
        this.ajm.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.jQQ.setText(iVar.jOQ);
        this.lcF.setText(iVar.jPG);
        this.lcG.setText(iVar.jPJ);
        this.lcN.setText("" + (iVar.jPO + i));
        this.lcP.setText("" + (iVar.jPP + i2));
        if (j > 0) {
            if (iVar.jOR == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lcM.setProcess(f + ((((float) iVar.jPO) * 1.0f) / ((float) j)), z);
                } else {
                    this.lcM.setProcess(1.0f, z);
                }
            } else if (iVar.jOR == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lcM.setProcess(((((float) iVar.jPO) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lcM.setProcess(0.0f, z);
                }
            } else {
                this.lcM.setProcess((((float) iVar.jPO) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lcM.setProcess(0.5f, z);
        }
        if (this.lcH.getVisibility() != 0) {
            if (iVar.jOR != 0) {
                this.lcK = this.lcJ;
                this.lcI = this.lcH.getLayoutParams();
                this.lcI.height = this.lcK;
                this.lcH.setLayoutParams(this.lcI);
                this.lcH.setAlpha(1.0f);
                this.lcH.setVisibility(0);
            } else {
                this.lcK = 0;
                this.lcI = this.lcH.getLayoutParams();
                this.lcI.height = this.lcK;
                this.lcH.setLayoutParams(this.lcI);
                this.lcH.setAlpha(0.0f);
            }
        }
        dfB();
    }

    private void dfB() {
        if (this.jPi != null) {
            if (this.jPi.jOR == 1) {
                this.lcF.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lcG.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcF.setTextColor(ap.getColor(R.color.cp_cont_a));
                this.lcG.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            } else if (this.jPi.jOR == 2) {
                this.lcF.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcG.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lcF.setTextColor(ap.getColor(R.color.cp_other_b));
                this.lcG.setTextColor(ap.getColor(R.color.cp_cont_a));
            } else {
                this.lcF.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcG.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcF.setTextColor(ap.getColor(R.color.cp_other_b));
                this.lcG.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lcF.setBackgroundTintList(this.lcR);
                this.lcG.setBackgroundTintList(this.lcS);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.lcR = ap.getColorList(R.color.cp_other_b);
            this.lcS = ap.getColorList(R.color.cp_link_tip_b);
            dfB();
            ap.setViewTextColor(this.ajm, R.color.cp_cont_d);
            ap.setViewTextColor(this.evg, R.color.cp_cont_b);
            ap.setViewTextColor(this.jQQ, R.color.cp_cont_b);
            ap.setViewTextColor(this.lcN, R.color.cp_other_b);
            ap.setViewTextColor(this.lcO, R.color.cp_other_b);
            ap.setViewTextColor(this.lcP, R.color.cp_link_tip_b);
            ap.setViewTextColor(this.lcQ, R.color.cp_link_tip_b);
            this.lcM.onChangeSkinType(i);
            this.jBV = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            dfC();
        } else if (id == R.id.pkBtn2) {
            dfD();
        }
    }

    private void dfC() {
        if (!JM()) {
            dfE();
            if (this.lcH.getVisibility() != 0) {
                Fp(1);
            } else if (this.lcL == null || !this.lcL.isRunning()) {
                Fo(1);
            }
        }
    }

    private void dfD() {
        if (!JM()) {
            dfE();
            if (this.lcH.getVisibility() != 0) {
                Fp(2);
            } else if (this.lcL == null || !this.lcL.isRunning()) {
                Fo(2);
            }
        }
    }

    private void dfE() {
        TiebaStatic.log(new aq("c13818").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean JM() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Fo(int i) {
        this.pageContext.getOrignalPage().a(this.jPi, i);
    }

    private void Fp(int i) {
        if (this.lcL != null) {
            this.lcL.cancel();
        }
        this.lcH.setVisibility(0);
        this.lcL = ValueAnimator.ofFloat((this.lcK * 1.0f) / this.lcJ, 1.0f);
        this.lcL.setDuration((((this.lcJ - this.lcK) * 300) * 1.0f) / this.lcJ);
        this.lcL.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lcL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lcH.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lcI.height = (int) (floatValue * HotTopicDetailPkLayout.this.lcJ);
                HotTopicDetailPkLayout.this.lcH.setLayoutParams(HotTopicDetailPkLayout.this.lcI);
            }
        });
        this.lcL.start();
        Fo(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.lcL == null || !this.lcL.isRunning() || ((Float) this.lcL.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lcL.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.jPi.jOR == 1) {
                        HotTopicDetailPkLayout.this.lcO.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lcQ.setText("");
                    } else if (HotTopicDetailPkLayout.this.jPi.jOR == 2) {
                        HotTopicDetailPkLayout.this.lcO.setText("");
                        HotTopicDetailPkLayout.this.lcQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lcO.setText("");
                        HotTopicDetailPkLayout.this.lcQ.setText("");
                    }
                    HotTopicDetailPkLayout.this.jPi.jOR = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.jPi.jOR != 0) {
                        if (HotTopicDetailPkLayout.this.jPi.jOR == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lcO.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lcQ.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lcO.setText("");
                                HotTopicDetailPkLayout.this.lcQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lcO.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lcQ.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lcO.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lcQ.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lcO.setText("");
                            HotTopicDetailPkLayout.this.lcQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lcO.setText("");
                            HotTopicDetailPkLayout.this.lcQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lcO.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lcQ.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lcO.setText("");
                        HotTopicDetailPkLayout.this.lcQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lcO.setText("");
                        HotTopicDetailPkLayout.this.lcQ.setText("");
                    }
                    HotTopicDetailPkLayout.this.jPi.jOR = i;
                }
                HotTopicDetailPkLayout.this.jPi.userPkId = j2;
                HotTopicDetailPkLayout.this.lcO.setVisibility(0);
                HotTopicDetailPkLayout.this.lcQ.setVisibility(0);
                HotTopicDetailPkLayout.this.mi(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lcT);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lcT, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
