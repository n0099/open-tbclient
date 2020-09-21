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
/* loaded from: classes20.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView aiT;
    private TextView dUN;
    private int iUD;
    private i jhM;
    private TextView jjv;
    private TextView kuZ;
    private TextView kva;
    private View kvb;
    private ViewGroup.LayoutParams kvc;
    private int kvd;
    private int kve;
    private ValueAnimator kvf;
    private HotTopicDetailPkProcess kvg;
    private TextView kvh;
    private TextView kvi;
    private TextView kvj;
    private TextView kvk;
    private ColorStateList kvl;
    private ColorStateList kvm;
    private Runnable kvn;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.iUD = 3;
        this.kvd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kve = 0;
        this.kvl = ap.getColorList(R.color.cp_other_b);
        this.kvm = ap.getColorList(R.color.cp_link_tip_b);
        this.kvn = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kvi != null) {
                    HotTopicDetailPkLayout.this.kvi.setVisibility(8);
                    HotTopicDetailPkLayout.this.kvk.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        this.kvd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kve = 0;
        this.kvl = ap.getColorList(R.color.cp_other_b);
        this.kvm = ap.getColorList(R.color.cp_link_tip_b);
        this.kvn = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kvi != null) {
                    HotTopicDetailPkLayout.this.kvi.setVisibility(8);
                    HotTopicDetailPkLayout.this.kvk.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        this.kvd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kve = 0;
        this.kvl = ap.getColorList(R.color.cp_other_b);
        this.kvm = ap.getColorList(R.color.cp_link_tip_b);
        this.kvn = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kvi != null) {
                    HotTopicDetailPkLayout.this.kvi.setVisibility(8);
                    HotTopicDetailPkLayout.this.kvk.setVisibility(8);
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
        this.aiT = (TextView) findViewById(R.id.tagView);
        this.dUN = (TextView) findViewById(R.id.titleView);
        this.jjv = (TextView) findViewById(R.id.descView);
        this.kuZ = (TextView) findViewById(R.id.pkBtn1);
        this.kuZ.setOnClickListener(this);
        this.kva = (TextView) findViewById(R.id.pkBtn2);
        this.kva.setOnClickListener(this);
        this.kvb = findViewById(R.id.progressBottomLayout);
        this.kvc = this.kvb.getLayoutParams();
        this.kvc.height = this.kve;
        this.kvb.setLayoutParams(this.kvc);
        this.kvb.setAlpha(0.0f);
        this.kvg = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.kvh = (TextView) findViewById(R.id.pkText1);
        this.kvi = (TextView) findViewById(R.id.pkTextSubmit1);
        this.kvj = (TextView) findViewById(R.id.pkText2);
        this.kvk = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.jhM = iVar;
        ll(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ll(boolean z) {
        i iVar = this.jhM;
        int i = iVar.jhv == 1 ? 1 : 0;
        int i2 = iVar.jhv == 2 ? 1 : 0;
        long j = iVar.jit + iVar.jiu + i + i2;
        this.aiT.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.jjv.setText(iVar.jhu);
        this.kuZ.setText(iVar.jil);
        this.kva.setText(iVar.jio);
        this.kvh.setText("" + (iVar.jit + i));
        this.kvj.setText("" + (iVar.jiu + i2));
        if (j > 0) {
            if (iVar.jhv == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.kvg.setProcess(f + ((((float) iVar.jit) * 1.0f) / ((float) j)), z);
                } else {
                    this.kvg.setProcess(1.0f, z);
                }
            } else if (iVar.jhv == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.kvg.setProcess(((((float) iVar.jit) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.kvg.setProcess(0.0f, z);
                }
            } else {
                this.kvg.setProcess((((float) iVar.jit) * 1.0f) / ((float) j), z);
            }
        } else {
            this.kvg.setProcess(0.5f, z);
        }
        if (this.kvb.getVisibility() != 0) {
            if (iVar.jhv != 0) {
                this.kve = this.kvd;
                this.kvc = this.kvb.getLayoutParams();
                this.kvc.height = this.kve;
                this.kvb.setLayoutParams(this.kvc);
                this.kvb.setAlpha(1.0f);
                this.kvb.setVisibility(0);
            } else {
                this.kve = 0;
                this.kvc = this.kvb.getLayoutParams();
                this.kvc.height = this.kve;
                this.kvb.setLayoutParams(this.kvc);
                this.kvb.setAlpha(0.0f);
            }
        }
        cWi();
    }

    private void cWi() {
        if (this.jhM != null) {
            if (this.jhM.jhv == 1) {
                this.kuZ.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kva.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kuZ.setTextColor(ap.getColor(R.color.cp_cont_a));
                this.kva.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            } else if (this.jhM.jhv == 2) {
                this.kuZ.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kva.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kuZ.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kva.setTextColor(ap.getColor(R.color.cp_cont_a));
            } else {
                this.kuZ.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kva.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kuZ.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kva.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.kuZ.setBackgroundTintList(this.kvl);
                this.kva.setBackgroundTintList(this.kvm);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.kvl = ap.getColorList(R.color.cp_other_b);
            this.kvm = ap.getColorList(R.color.cp_link_tip_b);
            cWi();
            ap.setViewTextColor(this.aiT, R.color.cp_cont_d);
            ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
            ap.setViewTextColor(this.jjv, R.color.cp_cont_b);
            ap.setViewTextColor(this.kvh, R.color.cp_other_b);
            ap.setViewTextColor(this.kvi, R.color.cp_other_b);
            ap.setViewTextColor(this.kvj, R.color.cp_link_tip_b);
            ap.setViewTextColor(this.kvk, R.color.cp_link_tip_b);
            this.kvg.onChangeSkinType(i);
            this.iUD = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            cWj();
        } else if (id == R.id.pkBtn2) {
            cWk();
        }
    }

    private void cWj() {
        if (!HV()) {
            cWl();
            if (this.kvb.getVisibility() != 0) {
                Ed(1);
            } else if (this.kvf == null || !this.kvf.isRunning()) {
                Ec(1);
            }
        }
    }

    private void cWk() {
        if (!HV()) {
            cWl();
            if (this.kvb.getVisibility() != 0) {
                Ed(2);
            } else if (this.kvf == null || !this.kvf.isRunning()) {
                Ec(2);
            }
        }
    }

    private void cWl() {
        TiebaStatic.log(new aq("c13818").dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean HV() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Ec(int i) {
        this.pageContext.getOrignalPage().a(this.jhM, i);
    }

    private void Ed(int i) {
        if (this.kvf != null) {
            this.kvf.cancel();
        }
        this.kvb.setVisibility(0);
        this.kvf = ValueAnimator.ofFloat((this.kve * 1.0f) / this.kvd, 1.0f);
        this.kvf.setDuration((((this.kvd - this.kve) * 300) * 1.0f) / this.kvd);
        this.kvf.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kvf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.kvb.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.kvc.height = (int) (floatValue * HotTopicDetailPkLayout.this.kvd);
                HotTopicDetailPkLayout.this.kvb.setLayoutParams(HotTopicDetailPkLayout.this.kvc);
            }
        });
        this.kvf.start();
        Ec(i);
    }

    public void d(long j, final long j2, final int i) {
        int i2;
        if (this.kvf == null || !this.kvf.isRunning() || ((Float) this.kvf.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.kvf.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.jhM.jhv == 1) {
                        HotTopicDetailPkLayout.this.kvi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.kvk.setText("");
                    } else if (HotTopicDetailPkLayout.this.jhM.jhv == 2) {
                        HotTopicDetailPkLayout.this.kvi.setText("");
                        HotTopicDetailPkLayout.this.kvk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.kvi.setText("");
                        HotTopicDetailPkLayout.this.kvk.setText("");
                    }
                    HotTopicDetailPkLayout.this.jhM.jhv = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.jhM.jhv != 0) {
                        if (HotTopicDetailPkLayout.this.jhM.jhv == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.kvi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.kvk.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.kvi.setText("");
                                HotTopicDetailPkLayout.this.kvk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.kvi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.kvk.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.kvi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.kvk.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.kvi.setText("");
                            HotTopicDetailPkLayout.this.kvk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.kvi.setText("");
                            HotTopicDetailPkLayout.this.kvk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.kvi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.kvk.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.kvi.setText("");
                        HotTopicDetailPkLayout.this.kvk.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.kvi.setText("");
                        HotTopicDetailPkLayout.this.kvk.setText("");
                    }
                    HotTopicDetailPkLayout.this.jhM.jhv = i;
                }
                HotTopicDetailPkLayout.this.jhM.userPkId = j2;
                HotTopicDetailPkLayout.this.kvi.setVisibility(0);
                HotTopicDetailPkLayout.this.kvk.setVisibility(0);
                HotTopicDetailPkLayout.this.ll(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.kvn);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.kvn, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
