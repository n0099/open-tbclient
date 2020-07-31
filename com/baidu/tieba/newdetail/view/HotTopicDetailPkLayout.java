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
    private i iKb;
    private TextView iLJ;
    private int iwT;
    private TextView ixg;
    private TextView jWV;
    private TextView jWW;
    private View jWX;
    private ViewGroup.LayoutParams jWY;
    private int jWZ;
    private int jXa;
    private ValueAnimator jXb;
    private HotTopicDetailPkProcess jXc;
    private TextView jXd;
    private TextView jXe;
    private TextView jXf;
    private TextView jXg;
    private ColorStateList jXh;
    private ColorStateList jXi;
    private Runnable jXj;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.iwT = 3;
        this.jWZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jXa = 0;
        this.jXh = ao.getColorList(R.color.cp_other_b);
        this.jXi = ao.getColorList(R.color.cp_link_tip_b);
        this.jXj = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jXe != null) {
                    HotTopicDetailPkLayout.this.jXe.setVisibility(8);
                    HotTopicDetailPkLayout.this.jXg.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwT = 3;
        this.jWZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jXa = 0;
        this.jXh = ao.getColorList(R.color.cp_other_b);
        this.jXi = ao.getColorList(R.color.cp_link_tip_b);
        this.jXj = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jXe != null) {
                    HotTopicDetailPkLayout.this.jXe.setVisibility(8);
                    HotTopicDetailPkLayout.this.jXg.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = 3;
        this.jWZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jXa = 0;
        this.jXh = ao.getColorList(R.color.cp_other_b);
        this.jXi = ao.getColorList(R.color.cp_link_tip_b);
        this.jXj = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jXe != null) {
                    HotTopicDetailPkLayout.this.jXe.setVisibility(8);
                    HotTopicDetailPkLayout.this.jXg.setVisibility(8);
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
        this.ixg = (TextView) findViewById(R.id.tagView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.iLJ = (TextView) findViewById(R.id.descView);
        this.jWV = (TextView) findViewById(R.id.pkBtn1);
        this.jWV.setOnClickListener(this);
        this.jWW = (TextView) findViewById(R.id.pkBtn2);
        this.jWW.setOnClickListener(this);
        this.jWX = findViewById(R.id.progressBottomLayout);
        this.jWY = this.jWX.getLayoutParams();
        this.jWY.height = this.jXa;
        this.jWX.setLayoutParams(this.jWY);
        this.jWX.setAlpha(0.0f);
        this.jXc = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.jXd = (TextView) findViewById(R.id.pkText1);
        this.jXe = (TextView) findViewById(R.id.pkTextSubmit1);
        this.jXf = (TextView) findViewById(R.id.pkText2);
        this.jXg = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.iKb = iVar;
        kH(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(boolean z) {
        i iVar = this.iKb;
        int i = iVar.iJK == 1 ? 1 : 0;
        int i2 = iVar.iJK == 2 ? 1 : 0;
        long j = iVar.iKH + iVar.iKI + i + i2;
        this.ixg.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), as.numberUniformFormatExtra(j)));
        this.iLJ.setText(iVar.iJJ);
        this.jWV.setText(iVar.iKz);
        this.jWW.setText(iVar.iKC);
        this.jXd.setText("" + (iVar.iKH + i));
        this.jXf.setText("" + (iVar.iKI + i2));
        if (j > 0) {
            if (iVar.iJK == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.jXc.setProcess(f + ((((float) iVar.iKH) * 1.0f) / ((float) j)), z);
                } else {
                    this.jXc.setProcess(1.0f, z);
                }
            } else if (iVar.iJK == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.jXc.setProcess(((((float) iVar.iKH) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.jXc.setProcess(0.0f, z);
                }
            } else {
                this.jXc.setProcess((((float) iVar.iKH) * 1.0f) / ((float) j), z);
            }
        } else {
            this.jXc.setProcess(0.5f, z);
        }
        if (this.jWX.getVisibility() != 0) {
            if (iVar.iJK != 0) {
                this.jXa = this.jWZ;
                this.jWY = this.jWX.getLayoutParams();
                this.jWY.height = this.jXa;
                this.jWX.setLayoutParams(this.jWY);
                this.jWX.setAlpha(1.0f);
                this.jWX.setVisibility(0);
            } else {
                this.jXa = 0;
                this.jWY = this.jWX.getLayoutParams();
                this.jWY.height = this.jXa;
                this.jWX.setLayoutParams(this.jWY);
                this.jWX.setAlpha(0.0f);
            }
        }
        cHN();
    }

    private void cHN() {
        if (this.iKb != null) {
            if (this.iKb.iJK == 1) {
                this.jWV.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.jWW.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWV.setTextColor(ao.getColor(R.color.cp_cont_a));
                this.jWW.setTextColor(ao.getColor(R.color.cp_link_tip_a));
            } else if (this.iKb.iJK == 2) {
                this.jWV.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWW.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.jWV.setTextColor(ao.getColor(R.color.cp_other_b));
                this.jWW.setTextColor(ao.getColor(R.color.cp_cont_a));
            } else {
                this.jWV.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWW.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jWV.setTextColor(ao.getColor(R.color.cp_other_b));
                this.jWW.setTextColor(ao.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.jWV.setBackgroundTintList(this.jXh);
                this.jWW.setBackgroundTintList(this.jXi);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwT != i) {
            ao.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.jXh = ao.getColorList(R.color.cp_other_b);
            this.jXi = ao.getColorList(R.color.cp_link_tip_b);
            cHN();
            ao.setViewTextColor(this.ixg, R.color.cp_cont_d);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
            ao.setViewTextColor(this.iLJ, R.color.cp_cont_b);
            ao.setViewTextColor(this.jXd, R.color.cp_other_b);
            ao.setViewTextColor(this.jXe, R.color.cp_other_b);
            ao.setViewTextColor(this.jXf, R.color.cp_link_tip_b);
            ao.setViewTextColor(this.jXg, R.color.cp_link_tip_b);
            this.jXc.onChangeSkinType(i);
            this.iwT = i;
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
            if (this.jWX.getVisibility() != 0) {
                Bj(1);
            } else if (this.jXb == null || !this.jXb.isRunning()) {
                Bi(1);
            }
        }
    }

    private void cHP() {
        if (!BR()) {
            cHQ();
            if (this.jWX.getVisibility() != 0) {
                Bj(2);
            } else if (this.jXb == null || !this.jXb.isRunning()) {
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
        this.pageContext.getOrignalPage().a(this.iKb, i);
    }

    private void Bj(int i) {
        if (this.jXb != null) {
            this.jXb.cancel();
        }
        this.jWX.setVisibility(0);
        this.jXb = ValueAnimator.ofFloat((this.jXa * 1.0f) / this.jWZ, 1.0f);
        this.jXb.setDuration((((this.jWZ - this.jXa) * 300) * 1.0f) / this.jWZ);
        this.jXb.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jXb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.jWX.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.jWY.height = (int) (floatValue * HotTopicDetailPkLayout.this.jWZ);
                HotTopicDetailPkLayout.this.jWX.setLayoutParams(HotTopicDetailPkLayout.this.jWY);
            }
        });
        this.jXb.start();
        Bi(i);
    }

    public void d(long j, final long j2, final int i) {
        int i2;
        if (this.jXb == null || !this.jXb.isRunning() || ((Float) this.jXb.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.jXb.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.iKb.iJK == 1) {
                        HotTopicDetailPkLayout.this.jXe.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.jXg.setText("");
                    } else if (HotTopicDetailPkLayout.this.iKb.iJK == 2) {
                        HotTopicDetailPkLayout.this.jXe.setText("");
                        HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.jXe.setText("");
                        HotTopicDetailPkLayout.this.jXg.setText("");
                    }
                    HotTopicDetailPkLayout.this.iKb.iJK = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.iKb.iJK != 0) {
                        if (HotTopicDetailPkLayout.this.iKb.iJK == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.jXe.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.jXg.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.jXe.setText("");
                                HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.jXe.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.jXg.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.jXe.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.jXg.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.jXe.setText("");
                            HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.jXe.setText("");
                            HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.jXe.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.jXg.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.jXe.setText("");
                        HotTopicDetailPkLayout.this.jXg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.jXe.setText("");
                        HotTopicDetailPkLayout.this.jXg.setText("");
                    }
                    HotTopicDetailPkLayout.this.iKb.iJK = i;
                }
                HotTopicDetailPkLayout.this.iKb.userPkId = j2;
                HotTopicDetailPkLayout.this.jXe.setVisibility(0);
                HotTopicDetailPkLayout.this.jXg.setVisibility(0);
                HotTopicDetailPkLayout.this.kH(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.jXj);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.jXj, 3000L);
            }
        }, i2);
    }
}
