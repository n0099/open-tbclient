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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes15.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView dJr;
    private i iKd;
    private TextView iLL;
    private int iwV;
    private TextView ixi;
    private TextView jWX;
    private TextView jWY;
    private View jWZ;
    private ViewGroup.LayoutParams jXa;
    private int jXb;
    private int jXc;
    private ValueAnimator jXd;
    private HotTopicDetailPkProcess jXe;
    private TextView jXf;
    private TextView jXg;
    private TextView jXh;
    private TextView jXi;
    private ColorStateList jXj;
    private ColorStateList jXk;
    private Runnable jXl;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.iwV = 3;
        this.jXb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jXc = 0;
        this.jXj = ao.getColorList(R.color.cp_other_b);
        this.jXk = ao.getColorList(R.color.cp_link_tip_b);
        this.jXl = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jXg != null) {
                    HotTopicDetailPkLayout.this.jXg.setVisibility(8);
                    HotTopicDetailPkLayout.this.jXi.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        this.jXb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jXc = 0;
        this.jXj = ao.getColorList(R.color.cp_other_b);
        this.jXk = ao.getColorList(R.color.cp_link_tip_b);
        this.jXl = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jXg != null) {
                    HotTopicDetailPkLayout.this.jXg.setVisibility(8);
                    HotTopicDetailPkLayout.this.jXi.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        this.jXb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jXc = 0;
        this.jXj = ao.getColorList(R.color.cp_other_b);
        this.jXk = ao.getColorList(R.color.cp_link_tip_b);
        this.jXl = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jXg != null) {
                    HotTopicDetailPkLayout.this.jXg.setVisibility(8);
                    HotTopicDetailPkLayout.this.jXi.setVisibility(8);
                }
            }
        };
        initView();
    }

    private void initView() {
        e<?> G = com.baidu.adp.base.i.G(getContext());
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
        this.ixi = (TextView) findViewById(R.id.tagView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.iLL = (TextView) findViewById(R.id.descView);
        this.jWX = (TextView) findViewById(R.id.pkBtn1);
        this.jWX.setOnClickListener(this);
        this.jWY = (TextView) findViewById(R.id.pkBtn2);
        this.jWY.setOnClickListener(this);
        this.jWZ = findViewById(R.id.progressBottomLayout);
        this.jXa = this.jWZ.getLayoutParams();
        this.jXa.height = this.jXc;
        this.jWZ.setLayoutParams(this.jXa);
        this.jWZ.setAlpha(0.0f);
        this.jXe = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.jXf = (TextView) findViewById(R.id.pkText1);
        this.jXg = (TextView) findViewById(R.id.pkTextSubmit1);
        this.jXh = (TextView) findViewById(R.id.pkText2);
        this.jXi = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.iKd = iVar;
        kH(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(boolean z) {
        i iVar = this.iKd;
        int i = iVar.iJM == 1 ? 1 : 0;
        int i2 = iVar.iJM == 2 ? 1 : 0;
        long j = iVar.iKJ + iVar.iKK + i + i2;
        this.ixi.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), as.numberUniformFormatExtra(j)));
        this.iLL.setText(iVar.iJL);
        this.jWX.setText(iVar.iKB);
        this.jWY.setText(iVar.iKE);
        this.jXf.setText("" + (iVar.iKJ + i));
        this.jXh.setText("" + (iVar.iKK + i2));
        if (j > 0) {
            if (iVar.iJM == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.jXe.setProcess(f + ((((float) iVar.iKJ) * 1.0f) / ((float) j)), z);
                } else {
                    this.jXe.setProcess(1.0f, z);
                }
            } else if (iVar.iJM == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.jXe.setProcess(((((float) iVar.iKJ) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.jXe.setProcess(0.0f, z);
                }
            } else {
                this.jXe.setProcess((((float) iVar.iKJ) * 1.0f) / ((float) j), z);
            }
        } else {
            this.jXe.setProcess(0.5f, z);
        }
        if (this.jWZ.getVisibility() != 0) {
            if (iVar.iJM != 0) {
                this.jXc = this.jXb;
                this.jXa = this.jWZ.getLayoutParams();
                this.jXa.height = this.jXc;
                this.jWZ.setLayoutParams(this.jXa);
                this.jWZ.setAlpha(1.0f);
                this.jWZ.setVisibility(0);
            } else {
                this.jXc = 0;
                this.jXa = this.jWZ.getLayoutParams();
                this.jXa.height = this.jXc;
                this.jWZ.setLayoutParams(this.jXa);
                this.jWZ.setAlpha(0.0f);
            }
        }
        cHN();
    }

    private void cHN() {
        if (this.iKd != null) {
            if (this.iKd.iJM == 1) {
                this.jWX.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.jWY.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWX.setTextColor(ao.getColor(R.color.cp_cont_a));
                this.jWY.setTextColor(ao.getColor(R.color.cp_link_tip_a));
            } else if (this.iKd.iJM == 2) {
                this.jWX.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWY.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.jWX.setTextColor(ao.getColor(R.color.cp_other_b));
                this.jWY.setTextColor(ao.getColor(R.color.cp_cont_a));
            } else {
                this.jWX.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWY.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWX.setTextColor(ao.getColor(R.color.cp_other_b));
                this.jWY.setTextColor(ao.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.jWX.setBackgroundTintList(this.jXj);
                this.jWY.setBackgroundTintList(this.jXk);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwV != i) {
            ao.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.jXj = ao.getColorList(R.color.cp_other_b);
            this.jXk = ao.getColorList(R.color.cp_link_tip_b);
            cHN();
            ao.setViewTextColor(this.ixi, R.color.cp_cont_d);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
            ao.setViewTextColor(this.iLL, R.color.cp_cont_b);
            ao.setViewTextColor(this.jXf, R.color.cp_other_b);
            ao.setViewTextColor(this.jXg, R.color.cp_other_b);
            ao.setViewTextColor(this.jXh, R.color.cp_link_tip_b);
            ao.setViewTextColor(this.jXi, R.color.cp_link_tip_b);
            this.jXe.onChangeSkinType(i);
            this.iwV = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            cHO();
        } else if (id == R.id.pkBtn2) {
            cHP();
        }
    }

    private void cHO() {
        if (!BR()) {
            cHQ();
            if (this.jWZ.getVisibility() != 0) {
                Bj(1);
            } else if (this.jXd == null || !this.jXd.isRunning()) {
                Bi(1);
            }
        }
    }

    private void cHP() {
        if (!BR()) {
            cHQ();
            if (this.jWZ.getVisibility() != 0) {
                Bj(2);
            } else if (this.jXd == null || !this.jXd.isRunning()) {
                Bi(2);
            }
        }
    }

    private void cHQ() {
        TiebaStatic.log(new ap("c13818").dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean BR() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Bi(int i) {
        this.pageContext.getOrignalPage().a(this.iKd, i);
    }

    private void Bj(int i) {
        if (this.jXd != null) {
            this.jXd.cancel();
        }
        this.jWZ.setVisibility(0);
        this.jXd = ValueAnimator.ofFloat((this.jXc * 1.0f) / this.jXb, 1.0f);
        this.jXd.setDuration((((this.jXb - this.jXc) * 300) * 1.0f) / this.jXb);
        this.jXd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jXd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.jWZ.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.jXa.height = (int) (floatValue * HotTopicDetailPkLayout.this.jXb);
                HotTopicDetailPkLayout.this.jWZ.setLayoutParams(HotTopicDetailPkLayout.this.jXa);
            }
        });
        this.jXd.start();
        Bi(i);
    }

    public void d(long j, final long j2, final int i) {
        int i2;
        if (this.jXd == null || !this.jXd.isRunning() || ((Float) this.jXd.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.jXd.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.iKd.iJM == 1) {
                        HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.jXi.setText("");
                    } else if (HotTopicDetailPkLayout.this.iKd.iJM == 2) {
                        HotTopicDetailPkLayout.this.jXg.setText("");
                        HotTopicDetailPkLayout.this.jXi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.jXg.setText("");
                        HotTopicDetailPkLayout.this.jXi.setText("");
                    }
                    HotTopicDetailPkLayout.this.iKd.iJM = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.iKd.iJM != 0) {
                        if (HotTopicDetailPkLayout.this.iKd.iJM == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.jXi.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.jXg.setText("");
                                HotTopicDetailPkLayout.this.jXi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.jXi.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.jXi.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.jXg.setText("");
                            HotTopicDetailPkLayout.this.jXi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.jXg.setText("");
                            HotTopicDetailPkLayout.this.jXi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.jXi.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.jXg.setText("");
                        HotTopicDetailPkLayout.this.jXi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.jXg.setText("");
                        HotTopicDetailPkLayout.this.jXi.setText("");
                    }
                    HotTopicDetailPkLayout.this.iKd.iJM = i;
                }
                HotTopicDetailPkLayout.this.iKd.userPkId = j2;
                HotTopicDetailPkLayout.this.jXg.setVisibility(0);
                HotTopicDetailPkLayout.this.jXi.setVisibility(0);
                HotTopicDetailPkLayout.this.kH(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.jXl);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.jXl, 3000L);
            }
        }, i2);
    }
}
