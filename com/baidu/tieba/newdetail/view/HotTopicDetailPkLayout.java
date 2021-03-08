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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes7.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView ali;
    private TextView eIY;
    private int kiZ;
    private i kwB;
    private TextView kyk;
    private int lBA;
    private int lBB;
    private ValueAnimator lBC;
    private HotTopicDetailPkProcess lBD;
    private TextView lBE;
    private TextView lBF;
    private TextView lBG;
    private TextView lBH;
    private ColorStateList lBI;
    private ColorStateList lBJ;
    private Runnable lBK;
    private TextView lBw;
    private TextView lBx;
    private View lBy;
    private ViewGroup.LayoutParams lBz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.kiZ = 3;
        this.lBA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lBB = 0;
        this.lBI = ap.getColorList(R.color.CAM_X0308);
        this.lBJ = ap.getColorList(R.color.CAM_X0303);
        this.lBK = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lBF != null) {
                    HotTopicDetailPkLayout.this.lBF.setVisibility(8);
                    HotTopicDetailPkLayout.this.lBH.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        this.lBA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lBB = 0;
        this.lBI = ap.getColorList(R.color.CAM_X0308);
        this.lBJ = ap.getColorList(R.color.CAM_X0303);
        this.lBK = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lBF != null) {
                    HotTopicDetailPkLayout.this.lBF.setVisibility(8);
                    HotTopicDetailPkLayout.this.lBH.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        this.lBA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lBB = 0;
        this.lBI = ap.getColorList(R.color.CAM_X0308);
        this.lBJ = ap.getColorList(R.color.CAM_X0303);
        this.lBK = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lBF != null) {
                    HotTopicDetailPkLayout.this.lBF.setVisibility(8);
                    HotTopicDetailPkLayout.this.lBH.setVisibility(8);
                }
            }
        };
        initView();
    }

    private void initView() {
        f<?> J = j.J(getContext());
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
        this.ali = (TextView) findViewById(R.id.tagView);
        this.eIY = (TextView) findViewById(R.id.titleView);
        this.kyk = (TextView) findViewById(R.id.descView);
        this.lBw = (TextView) findViewById(R.id.pkBtn1);
        this.lBw.setOnClickListener(this);
        this.lBx = (TextView) findViewById(R.id.pkBtn2);
        this.lBx.setOnClickListener(this);
        this.lBy = findViewById(R.id.progressBottomLayout);
        this.lBz = this.lBy.getLayoutParams();
        this.lBz.height = this.lBB;
        this.lBy.setLayoutParams(this.lBz);
        this.lBy.setAlpha(0.0f);
        this.lBD = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lBE = (TextView) findViewById(R.id.pkText1);
        this.lBF = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lBG = (TextView) findViewById(R.id.pkText2);
        this.lBH = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kwB = iVar;
        nf(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(boolean z) {
        i iVar = this.kwB;
        int i = iVar.kwk == 1 ? 1 : 0;
        int i2 = iVar.kwk == 2 ? 1 : 0;
        long j = iVar.kxi + iVar.kxj + i + i2;
        this.ali.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), au.numberUniformFormatExtra(j)));
        this.kyk.setText(iVar.kwj);
        this.lBw.setText(iVar.kxa);
        this.lBx.setText(iVar.kxd);
        this.lBE.setText("" + (iVar.kxi + i));
        this.lBG.setText("" + (iVar.kxj + i2));
        if (j > 0) {
            if (iVar.kwk == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lBD.setProcess(f + ((((float) iVar.kxi) * 1.0f) / ((float) j)), z);
                } else {
                    this.lBD.setProcess(1.0f, z);
                }
            } else if (iVar.kwk == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lBD.setProcess(((((float) iVar.kxi) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lBD.setProcess(0.0f, z);
                }
            } else {
                this.lBD.setProcess((((float) iVar.kxi) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lBD.setProcess(0.5f, z);
        }
        if (this.lBy.getVisibility() != 0) {
            if (iVar.kwk != 0) {
                this.lBB = this.lBA;
                this.lBz = this.lBy.getLayoutParams();
                this.lBz.height = this.lBB;
                this.lBy.setLayoutParams(this.lBz);
                this.lBy.setAlpha(1.0f);
                this.lBy.setVisibility(0);
            } else {
                this.lBB = 0;
                this.lBz = this.lBy.getLayoutParams();
                this.lBz.height = this.lBB;
                this.lBy.setLayoutParams(this.lBz);
                this.lBy.setAlpha(0.0f);
            }
        }
        div();
    }

    private void div() {
        if (this.kwB != null) {
            if (this.kwB.kwk == 1) {
                this.lBw.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lBx.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lBw.setTextColor(ap.getColor(R.color.CAM_X0101));
                this.lBx.setTextColor(ap.getColor(R.color.CAM_X0302));
            } else if (this.kwB.kwk == 2) {
                this.lBw.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lBx.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lBw.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lBx.setTextColor(ap.getColor(R.color.CAM_X0101));
            } else {
                this.lBw.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lBx.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lBw.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lBx.setTextColor(ap.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lBw.setBackgroundTintList(this.lBI);
                this.lBx.setBackgroundTintList(this.lBJ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            this.lBI = ap.getColorList(R.color.CAM_X0308);
            this.lBJ = ap.getColorList(R.color.CAM_X0303);
            div();
            ap.setViewTextColor(this.ali, R.color.CAM_X0109);
            ap.setViewTextColor(this.eIY, R.color.CAM_X0105);
            ap.setViewTextColor(this.kyk, R.color.CAM_X0105);
            ap.setViewTextColor(this.lBE, R.color.CAM_X0308);
            ap.setViewTextColor(this.lBF, R.color.CAM_X0308);
            ap.setViewTextColor(this.lBG, R.color.CAM_X0303);
            ap.setViewTextColor(this.lBH, R.color.CAM_X0303);
            this.lBD.onChangeSkinType(i);
            this.kiZ = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            diw();
        } else if (id == R.id.pkBtn2) {
            dix();
        }
    }

    private void diw() {
        if (!Ic()) {
            diy();
            if (this.lBy.getVisibility() != 0) {
                Fj(1);
            } else if (this.lBC == null || !this.lBC.isRunning()) {
                Fi(1);
            }
        }
    }

    private void dix() {
        if (!Ic()) {
            diy();
            if (this.lBy.getVisibility() != 0) {
                Fj(2);
            } else if (this.lBC == null || !this.lBC.isRunning()) {
                Fi(2);
            }
        }
    }

    private void diy() {
        TiebaStatic.log(new ar("c13818").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean Ic() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Fi(int i) {
        this.pageContext.getOrignalPage().a(this.kwB, i);
    }

    private void Fj(int i) {
        if (this.lBC != null) {
            this.lBC.cancel();
        }
        this.lBy.setVisibility(0);
        this.lBC = ValueAnimator.ofFloat((this.lBB * 1.0f) / this.lBA, 1.0f);
        this.lBC.setDuration((((this.lBA - this.lBB) * 300) * 1.0f) / this.lBA);
        this.lBC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lBC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lBy.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lBz.height = (int) (floatValue * HotTopicDetailPkLayout.this.lBA);
                HotTopicDetailPkLayout.this.lBy.setLayoutParams(HotTopicDetailPkLayout.this.lBz);
            }
        });
        this.lBC.start();
        Fi(i);
    }

    public void d(long j, final long j2, final int i) {
        int i2;
        if (this.lBC == null || !this.lBC.isRunning() || ((Float) this.lBC.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lBC.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kwB.kwk == 1) {
                        HotTopicDetailPkLayout.this.lBF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lBH.setText("");
                    } else if (HotTopicDetailPkLayout.this.kwB.kwk == 2) {
                        HotTopicDetailPkLayout.this.lBF.setText("");
                        HotTopicDetailPkLayout.this.lBH.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lBF.setText("");
                        HotTopicDetailPkLayout.this.lBH.setText("");
                    }
                    HotTopicDetailPkLayout.this.kwB.kwk = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kwB.kwk != 0) {
                        if (HotTopicDetailPkLayout.this.kwB.kwk == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lBF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lBH.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lBF.setText("");
                                HotTopicDetailPkLayout.this.lBH.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lBF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lBH.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lBF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lBH.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lBF.setText("");
                            HotTopicDetailPkLayout.this.lBH.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lBF.setText("");
                            HotTopicDetailPkLayout.this.lBH.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lBF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lBH.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lBF.setText("");
                        HotTopicDetailPkLayout.this.lBH.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lBF.setText("");
                        HotTopicDetailPkLayout.this.lBH.setText("");
                    }
                    HotTopicDetailPkLayout.this.kwB.kwk = i;
                }
                HotTopicDetailPkLayout.this.kwB.userPkId = j2;
                HotTopicDetailPkLayout.this.lBF.setVisibility(0);
                HotTopicDetailPkLayout.this.lBH.setVisibility(0);
                HotTopicDetailPkLayout.this.nf(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lBK);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lBK, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
