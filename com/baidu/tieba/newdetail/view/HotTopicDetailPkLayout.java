package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes7.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView akb;
    private TextView eFr;
    private int jZf;
    private i kme;
    private TextView knN;
    private TextView lrb;
    private TextView lrc;
    private View lrd;
    private ViewGroup.LayoutParams lre;
    private int lrf;
    private int lrg;
    private ValueAnimator lrh;
    private HotTopicDetailPkProcess lri;
    private TextView lrj;
    private TextView lrk;
    private TextView lrl;
    private TextView lrm;
    private ColorStateList lrn;
    private ColorStateList lro;
    private Runnable lrp;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jZf = 3;
        this.lrf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lrg = 0;
        this.lrn = ao.getColorList(R.color.CAM_X0308);
        this.lro = ao.getColorList(R.color.CAM_X0303);
        this.lrp = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lrk != null) {
                    HotTopicDetailPkLayout.this.lrk.setVisibility(8);
                    HotTopicDetailPkLayout.this.lrm.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        this.lrf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lrg = 0;
        this.lrn = ao.getColorList(R.color.CAM_X0308);
        this.lro = ao.getColorList(R.color.CAM_X0303);
        this.lrp = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lrk != null) {
                    HotTopicDetailPkLayout.this.lrk.setVisibility(8);
                    HotTopicDetailPkLayout.this.lrm.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        this.lrf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lrg = 0;
        this.lrn = ao.getColorList(R.color.CAM_X0308);
        this.lro = ao.getColorList(R.color.CAM_X0303);
        this.lrp = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lrk != null) {
                    HotTopicDetailPkLayout.this.lrk.setVisibility(8);
                    HotTopicDetailPkLayout.this.lrm.setVisibility(8);
                }
            }
        };
        initView();
    }

    private void initView() {
        f<?> K = j.K(getContext());
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
        this.akb = (TextView) findViewById(R.id.tagView);
        this.eFr = (TextView) findViewById(R.id.titleView);
        this.knN = (TextView) findViewById(R.id.descView);
        this.lrb = (TextView) findViewById(R.id.pkBtn1);
        this.lrb.setOnClickListener(this);
        this.lrc = (TextView) findViewById(R.id.pkBtn2);
        this.lrc.setOnClickListener(this);
        this.lrd = findViewById(R.id.progressBottomLayout);
        this.lre = this.lrd.getLayoutParams();
        this.lre.height = this.lrg;
        this.lrd.setLayoutParams(this.lre);
        this.lrd.setAlpha(0.0f);
        this.lri = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lrj = (TextView) findViewById(R.id.pkText1);
        this.lrk = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lrl = (TextView) findViewById(R.id.pkText2);
        this.lrm = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kme = iVar;
        na(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(boolean z) {
        i iVar = this.kme;
        int i = iVar.klN == 1 ? 1 : 0;
        int i2 = iVar.klN == 2 ? 1 : 0;
        long j = iVar.kmL + iVar.kmM + i + i2;
        this.akb.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.knN.setText(iVar.klM);
        this.lrb.setText(iVar.kmD);
        this.lrc.setText(iVar.kmG);
        this.lrj.setText("" + (iVar.kmL + i));
        this.lrl.setText("" + (iVar.kmM + i2));
        if (j > 0) {
            if (iVar.klN == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lri.setProcess(f + ((((float) iVar.kmL) * 1.0f) / ((float) j)), z);
                } else {
                    this.lri.setProcess(1.0f, z);
                }
            } else if (iVar.klN == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lri.setProcess(((((float) iVar.kmL) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lri.setProcess(0.0f, z);
                }
            } else {
                this.lri.setProcess((((float) iVar.kmL) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lri.setProcess(0.5f, z);
        }
        if (this.lrd.getVisibility() != 0) {
            if (iVar.klN != 0) {
                this.lrg = this.lrf;
                this.lre = this.lrd.getLayoutParams();
                this.lre.height = this.lrg;
                this.lrd.setLayoutParams(this.lre);
                this.lrd.setAlpha(1.0f);
                this.lrd.setVisibility(0);
            } else {
                this.lrg = 0;
                this.lre = this.lrd.getLayoutParams();
                this.lre.height = this.lrg;
                this.lrd.setLayoutParams(this.lre);
                this.lrd.setAlpha(0.0f);
            }
        }
        dge();
    }

    private void dge() {
        if (this.kme != null) {
            if (this.kme.klN == 1) {
                this.lrb.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lrc.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lrb.setTextColor(ao.getColor(R.color.CAM_X0101));
                this.lrc.setTextColor(ao.getColor(R.color.CAM_X0302));
            } else if (this.kme.klN == 2) {
                this.lrb.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lrc.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lrb.setTextColor(ao.getColor(R.color.CAM_X0308));
                this.lrc.setTextColor(ao.getColor(R.color.CAM_X0101));
            } else {
                this.lrb.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lrc.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lrb.setTextColor(ao.getColor(R.color.CAM_X0308));
                this.lrc.setTextColor(ao.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lrb.setBackgroundTintList(this.lrn);
                this.lrc.setBackgroundTintList(this.lro);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            ao.setBackgroundColor(this, R.color.CAM_X0201);
            this.lrn = ao.getColorList(R.color.CAM_X0308);
            this.lro = ao.getColorList(R.color.CAM_X0303);
            dge();
            ao.setViewTextColor(this.akb, R.color.CAM_X0109);
            ao.setViewTextColor(this.eFr, R.color.CAM_X0105);
            ao.setViewTextColor(this.knN, R.color.CAM_X0105);
            ao.setViewTextColor(this.lrj, R.color.CAM_X0308);
            ao.setViewTextColor(this.lrk, R.color.CAM_X0308);
            ao.setViewTextColor(this.lrl, R.color.CAM_X0303);
            ao.setViewTextColor(this.lrm, R.color.CAM_X0303);
            this.lri.onChangeSkinType(i);
            this.jZf = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            dgf();
        } else if (id == R.id.pkBtn2) {
            dgg();
        }
    }

    private void dgf() {
        if (!GJ()) {
            dgh();
            if (this.lrd.getVisibility() != 0) {
                EO(1);
            } else if (this.lrh == null || !this.lrh.isRunning()) {
                EN(1);
            }
        }
    }

    private void dgg() {
        if (!GJ()) {
            dgh();
            if (this.lrd.getVisibility() != 0) {
                EO(2);
            } else if (this.lrh == null || !this.lrh.isRunning()) {
                EN(2);
            }
        }
    }

    private void dgh() {
        TiebaStatic.log(new aq("c13818").dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean GJ() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void EN(int i) {
        this.pageContext.getOrignalPage().a(this.kme, i);
    }

    private void EO(int i) {
        if (this.lrh != null) {
            this.lrh.cancel();
        }
        this.lrd.setVisibility(0);
        this.lrh = ValueAnimator.ofFloat((this.lrg * 1.0f) / this.lrf, 1.0f);
        this.lrh.setDuration((((this.lrf - this.lrg) * 300) * 1.0f) / this.lrf);
        this.lrh.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lrh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lrd.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lre.height = (int) (floatValue * HotTopicDetailPkLayout.this.lrf);
                HotTopicDetailPkLayout.this.lrd.setLayoutParams(HotTopicDetailPkLayout.this.lre);
            }
        });
        this.lrh.start();
        EN(i);
    }

    public void f(long j, final long j2, final int i) {
        int i2;
        if (this.lrh == null || !this.lrh.isRunning() || ((Float) this.lrh.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lrh.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kme.klN == 1) {
                        HotTopicDetailPkLayout.this.lrk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lrm.setText("");
                    } else if (HotTopicDetailPkLayout.this.kme.klN == 2) {
                        HotTopicDetailPkLayout.this.lrk.setText("");
                        HotTopicDetailPkLayout.this.lrm.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lrk.setText("");
                        HotTopicDetailPkLayout.this.lrm.setText("");
                    }
                    HotTopicDetailPkLayout.this.kme.klN = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kme.klN != 0) {
                        if (HotTopicDetailPkLayout.this.kme.klN == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lrk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lrm.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lrk.setText("");
                                HotTopicDetailPkLayout.this.lrm.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lrk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lrm.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lrk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lrm.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lrk.setText("");
                            HotTopicDetailPkLayout.this.lrm.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lrk.setText("");
                            HotTopicDetailPkLayout.this.lrm.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lrk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lrm.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lrk.setText("");
                        HotTopicDetailPkLayout.this.lrm.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lrk.setText("");
                        HotTopicDetailPkLayout.this.lrm.setText("");
                    }
                    HotTopicDetailPkLayout.this.kme.klN = i;
                }
                HotTopicDetailPkLayout.this.kme.userPkId = j2;
                HotTopicDetailPkLayout.this.lrk.setVisibility(0);
                HotTopicDetailPkLayout.this.lrm.setVisibility(0);
                HotTopicDetailPkLayout.this.na(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lrp);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lrp, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
