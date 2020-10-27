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
    private TextView epn;
    private i jJk;
    private TextView jKS;
    private int jvY;
    private TextView kWI;
    private TextView kWJ;
    private View kWK;
    private ViewGroup.LayoutParams kWL;
    private int kWM;
    private int kWN;
    private ValueAnimator kWO;
    private HotTopicDetailPkProcess kWP;
    private TextView kWQ;
    private TextView kWR;
    private TextView kWS;
    private TextView kWT;
    private ColorStateList kWU;
    private ColorStateList kWV;
    private Runnable kWW;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jvY = 3;
        this.kWM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kWN = 0;
        this.kWU = ap.getColorList(R.color.cp_other_b);
        this.kWV = ap.getColorList(R.color.cp_link_tip_b);
        this.kWW = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kWR != null) {
                    HotTopicDetailPkLayout.this.kWR.setVisibility(8);
                    HotTopicDetailPkLayout.this.kWT.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        this.kWM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kWN = 0;
        this.kWU = ap.getColorList(R.color.cp_other_b);
        this.kWV = ap.getColorList(R.color.cp_link_tip_b);
        this.kWW = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kWR != null) {
                    HotTopicDetailPkLayout.this.kWR.setVisibility(8);
                    HotTopicDetailPkLayout.this.kWT.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        this.kWM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kWN = 0;
        this.kWU = ap.getColorList(R.color.cp_other_b);
        this.kWV = ap.getColorList(R.color.cp_link_tip_b);
        this.kWW = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kWR != null) {
                    HotTopicDetailPkLayout.this.kWR.setVisibility(8);
                    HotTopicDetailPkLayout.this.kWT.setVisibility(8);
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
        this.epn = (TextView) findViewById(R.id.titleView);
        this.jKS = (TextView) findViewById(R.id.descView);
        this.kWI = (TextView) findViewById(R.id.pkBtn1);
        this.kWI.setOnClickListener(this);
        this.kWJ = (TextView) findViewById(R.id.pkBtn2);
        this.kWJ.setOnClickListener(this);
        this.kWK = findViewById(R.id.progressBottomLayout);
        this.kWL = this.kWK.getLayoutParams();
        this.kWL.height = this.kWN;
        this.kWK.setLayoutParams(this.kWL);
        this.kWK.setAlpha(0.0f);
        this.kWP = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.kWQ = (TextView) findViewById(R.id.pkText1);
        this.kWR = (TextView) findViewById(R.id.pkTextSubmit1);
        this.kWS = (TextView) findViewById(R.id.pkText2);
        this.kWT = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.jJk = iVar;
        lZ(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(boolean z) {
        i iVar = this.jJk;
        int i = iVar.jIT == 1 ? 1 : 0;
        int i2 = iVar.jIT == 2 ? 1 : 0;
        long j = iVar.jJQ + iVar.jJR + i + i2;
        this.ajm.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.jKS.setText(iVar.jIS);
        this.kWI.setText(iVar.jJI);
        this.kWJ.setText(iVar.jJL);
        this.kWQ.setText("" + (iVar.jJQ + i));
        this.kWS.setText("" + (iVar.jJR + i2));
        if (j > 0) {
            if (iVar.jIT == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.kWP.setProcess(f + ((((float) iVar.jJQ) * 1.0f) / ((float) j)), z);
                } else {
                    this.kWP.setProcess(1.0f, z);
                }
            } else if (iVar.jIT == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.kWP.setProcess(((((float) iVar.jJQ) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.kWP.setProcess(0.0f, z);
                }
            } else {
                this.kWP.setProcess((((float) iVar.jJQ) * 1.0f) / ((float) j), z);
            }
        } else {
            this.kWP.setProcess(0.5f, z);
        }
        if (this.kWK.getVisibility() != 0) {
            if (iVar.jIT != 0) {
                this.kWN = this.kWM;
                this.kWL = this.kWK.getLayoutParams();
                this.kWL.height = this.kWN;
                this.kWK.setLayoutParams(this.kWL);
                this.kWK.setAlpha(1.0f);
                this.kWK.setVisibility(0);
            } else {
                this.kWN = 0;
                this.kWL = this.kWK.getLayoutParams();
                this.kWL.height = this.kWN;
                this.kWK.setLayoutParams(this.kWL);
                this.kWK.setAlpha(0.0f);
            }
        }
        dcZ();
    }

    private void dcZ() {
        if (this.jJk != null) {
            if (this.jJk.jIT == 1) {
                this.kWI.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kWJ.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kWI.setTextColor(ap.getColor(R.color.cp_cont_a));
                this.kWJ.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            } else if (this.jJk.jIT == 2) {
                this.kWI.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kWJ.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kWI.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kWJ.setTextColor(ap.getColor(R.color.cp_cont_a));
            } else {
                this.kWI.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kWJ.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kWI.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kWJ.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.kWI.setBackgroundTintList(this.kWU);
                this.kWJ.setBackgroundTintList(this.kWV);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.kWU = ap.getColorList(R.color.cp_other_b);
            this.kWV = ap.getColorList(R.color.cp_link_tip_b);
            dcZ();
            ap.setViewTextColor(this.ajm, R.color.cp_cont_d);
            ap.setViewTextColor(this.epn, R.color.cp_cont_b);
            ap.setViewTextColor(this.jKS, R.color.cp_cont_b);
            ap.setViewTextColor(this.kWQ, R.color.cp_other_b);
            ap.setViewTextColor(this.kWR, R.color.cp_other_b);
            ap.setViewTextColor(this.kWS, R.color.cp_link_tip_b);
            ap.setViewTextColor(this.kWT, R.color.cp_link_tip_b);
            this.kWP.onChangeSkinType(i);
            this.jvY = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            dda();
        } else if (id == R.id.pkBtn2) {
            ddb();
        }
    }

    private void dda() {
        if (!Jl()) {
            ddc();
            if (this.kWK.getVisibility() != 0) {
                Fc(1);
            } else if (this.kWO == null || !this.kWO.isRunning()) {
                Fb(1);
            }
        }
    }

    private void ddb() {
        if (!Jl()) {
            ddc();
            if (this.kWK.getVisibility() != 0) {
                Fc(2);
            } else if (this.kWO == null || !this.kWO.isRunning()) {
                Fb(2);
            }
        }
    }

    private void ddc() {
        TiebaStatic.log(new aq("c13818").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean Jl() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Fb(int i) {
        this.pageContext.getOrignalPage().a(this.jJk, i);
    }

    private void Fc(int i) {
        if (this.kWO != null) {
            this.kWO.cancel();
        }
        this.kWK.setVisibility(0);
        this.kWO = ValueAnimator.ofFloat((this.kWN * 1.0f) / this.kWM, 1.0f);
        this.kWO.setDuration((((this.kWM - this.kWN) * 300) * 1.0f) / this.kWM);
        this.kWO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kWO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.kWK.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.kWL.height = (int) (floatValue * HotTopicDetailPkLayout.this.kWM);
                HotTopicDetailPkLayout.this.kWK.setLayoutParams(HotTopicDetailPkLayout.this.kWL);
            }
        });
        this.kWO.start();
        Fb(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.kWO == null || !this.kWO.isRunning() || ((Float) this.kWO.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.kWO.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.jJk.jIT == 1) {
                        HotTopicDetailPkLayout.this.kWR.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.kWT.setText("");
                    } else if (HotTopicDetailPkLayout.this.jJk.jIT == 2) {
                        HotTopicDetailPkLayout.this.kWR.setText("");
                        HotTopicDetailPkLayout.this.kWT.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.kWR.setText("");
                        HotTopicDetailPkLayout.this.kWT.setText("");
                    }
                    HotTopicDetailPkLayout.this.jJk.jIT = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.jJk.jIT != 0) {
                        if (HotTopicDetailPkLayout.this.jJk.jIT == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.kWR.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.kWT.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.kWR.setText("");
                                HotTopicDetailPkLayout.this.kWT.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.kWR.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.kWT.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.kWR.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.kWT.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.kWR.setText("");
                            HotTopicDetailPkLayout.this.kWT.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.kWR.setText("");
                            HotTopicDetailPkLayout.this.kWT.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.kWR.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.kWT.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.kWR.setText("");
                        HotTopicDetailPkLayout.this.kWT.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.kWR.setText("");
                        HotTopicDetailPkLayout.this.kWT.setText("");
                    }
                    HotTopicDetailPkLayout.this.jJk.jIT = i;
                }
                HotTopicDetailPkLayout.this.jJk.userPkId = j2;
                HotTopicDetailPkLayout.this.kWR.setVisibility(0);
                HotTopicDetailPkLayout.this.kWT.setVisibility(0);
                HotTopicDetailPkLayout.this.lZ(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.kWW);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.kWW, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
