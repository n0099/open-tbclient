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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes20.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView ajr;
    private TextView etx;
    private int jCS;
    private i jPS;
    private TextView jRA;
    private TextView lcX;
    private TextView lcY;
    private View lcZ;
    private ViewGroup.LayoutParams lda;
    private int ldb;
    private int ldc;
    private ValueAnimator ldd;
    private HotTopicDetailPkProcess lde;
    private TextView ldf;
    private TextView ldg;
    private TextView ldh;
    private TextView ldi;
    private ColorStateList ldj;
    private ColorStateList ldk;
    private Runnable ldl;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jCS = 3;
        this.ldb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.ldc = 0;
        this.ldj = ap.getColorList(R.color.CAM_X0308);
        this.ldk = ap.getColorList(R.color.CAM_X0303);
        this.ldl = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.ldg != null) {
                    HotTopicDetailPkLayout.this.ldg.setVisibility(8);
                    HotTopicDetailPkLayout.this.ldi.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        this.ldb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.ldc = 0;
        this.ldj = ap.getColorList(R.color.CAM_X0308);
        this.ldk = ap.getColorList(R.color.CAM_X0303);
        this.ldl = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.ldg != null) {
                    HotTopicDetailPkLayout.this.ldg.setVisibility(8);
                    HotTopicDetailPkLayout.this.ldi.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        this.ldb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.ldc = 0;
        this.ldj = ap.getColorList(R.color.CAM_X0308);
        this.ldk = ap.getColorList(R.color.CAM_X0303);
        this.ldl = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.ldg != null) {
                    HotTopicDetailPkLayout.this.ldg.setVisibility(8);
                    HotTopicDetailPkLayout.this.ldi.setVisibility(8);
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
        this.ajr = (TextView) findViewById(R.id.tagView);
        this.etx = (TextView) findViewById(R.id.titleView);
        this.jRA = (TextView) findViewById(R.id.descView);
        this.lcX = (TextView) findViewById(R.id.pkBtn1);
        this.lcX.setOnClickListener(this);
        this.lcY = (TextView) findViewById(R.id.pkBtn2);
        this.lcY.setOnClickListener(this);
        this.lcZ = findViewById(R.id.progressBottomLayout);
        this.lda = this.lcZ.getLayoutParams();
        this.lda.height = this.ldc;
        this.lcZ.setLayoutParams(this.lda);
        this.lcZ.setAlpha(0.0f);
        this.lde = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.ldf = (TextView) findViewById(R.id.pkText1);
        this.ldg = (TextView) findViewById(R.id.pkTextSubmit1);
        this.ldh = (TextView) findViewById(R.id.pkText2);
        this.ldi = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.jPS = iVar;
        mj(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(boolean z) {
        i iVar = this.jPS;
        int i = iVar.jPB == 1 ? 1 : 0;
        int i2 = iVar.jPB == 2 ? 1 : 0;
        long j = iVar.jQy + iVar.jQz + i + i2;
        this.ajr.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), au.numberUniformFormatExtra(j)));
        this.jRA.setText(iVar.jPA);
        this.lcX.setText(iVar.jQq);
        this.lcY.setText(iVar.jQt);
        this.ldf.setText("" + (iVar.jQy + i));
        this.ldh.setText("" + (iVar.jQz + i2));
        if (j > 0) {
            if (iVar.jPB == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lde.setProcess(f + ((((float) iVar.jQy) * 1.0f) / ((float) j)), z);
                } else {
                    this.lde.setProcess(1.0f, z);
                }
            } else if (iVar.jPB == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lde.setProcess(((((float) iVar.jQy) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lde.setProcess(0.0f, z);
                }
            } else {
                this.lde.setProcess((((float) iVar.jQy) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lde.setProcess(0.5f, z);
        }
        if (this.lcZ.getVisibility() != 0) {
            if (iVar.jPB != 0) {
                this.ldc = this.ldb;
                this.lda = this.lcZ.getLayoutParams();
                this.lda.height = this.ldc;
                this.lcZ.setLayoutParams(this.lda);
                this.lcZ.setAlpha(1.0f);
                this.lcZ.setVisibility(0);
            } else {
                this.ldc = 0;
                this.lda = this.lcZ.getLayoutParams();
                this.lda.height = this.ldc;
                this.lcZ.setLayoutParams(this.lda);
                this.lcZ.setAlpha(0.0f);
            }
        }
        deY();
    }

    private void deY() {
        if (this.jPS != null) {
            if (this.jPS.jPB == 1) {
                this.lcX.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lcY.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcX.setTextColor(ap.getColor(R.color.CAM_X0101));
                this.lcY.setTextColor(ap.getColor(R.color.CAM_X0302));
            } else if (this.jPS.jPB == 2) {
                this.lcX.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcY.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lcX.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lcY.setTextColor(ap.getColor(R.color.CAM_X0101));
            } else {
                this.lcX.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcY.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lcX.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lcY.setTextColor(ap.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lcX.setBackgroundTintList(this.ldj);
                this.lcY.setBackgroundTintList(this.ldk);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            this.ldj = ap.getColorList(R.color.CAM_X0308);
            this.ldk = ap.getColorList(R.color.CAM_X0303);
            deY();
            ap.setViewTextColor(this.ajr, R.color.CAM_X0109);
            ap.setViewTextColor(this.etx, R.color.CAM_X0105);
            ap.setViewTextColor(this.jRA, R.color.CAM_X0105);
            ap.setViewTextColor(this.ldf, R.color.CAM_X0308);
            ap.setViewTextColor(this.ldg, R.color.CAM_X0308);
            ap.setViewTextColor(this.ldh, R.color.CAM_X0303);
            ap.setViewTextColor(this.ldi, R.color.CAM_X0303);
            this.lde.onChangeSkinType(i);
            this.jCS = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            deZ();
        } else if (id == R.id.pkBtn2) {
            dfa();
        }
    }

    private void deZ() {
        if (!Jd()) {
            dfb();
            if (this.lcZ.getVisibility() != 0) {
                FN(1);
            } else if (this.ldd == null || !this.ldd.isRunning()) {
                FM(1);
            }
        }
    }

    private void dfa() {
        if (!Jd()) {
            dfb();
            if (this.lcZ.getVisibility() != 0) {
                FN(2);
            } else if (this.ldd == null || !this.ldd.isRunning()) {
                FM(2);
            }
        }
    }

    private void dfb() {
        TiebaStatic.log(new ar("c13818").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean Jd() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void FM(int i) {
        this.pageContext.getOrignalPage().a(this.jPS, i);
    }

    private void FN(int i) {
        if (this.ldd != null) {
            this.ldd.cancel();
        }
        this.lcZ.setVisibility(0);
        this.ldd = ValueAnimator.ofFloat((this.ldc * 1.0f) / this.ldb, 1.0f);
        this.ldd.setDuration((((this.ldb - this.ldc) * 300) * 1.0f) / this.ldb);
        this.ldd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ldd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lcZ.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lda.height = (int) (floatValue * HotTopicDetailPkLayout.this.ldb);
                HotTopicDetailPkLayout.this.lcZ.setLayoutParams(HotTopicDetailPkLayout.this.lda);
            }
        });
        this.ldd.start();
        FM(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.ldd == null || !this.ldd.isRunning() || ((Float) this.ldd.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.ldd.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.jPS.jPB == 1) {
                        HotTopicDetailPkLayout.this.ldg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.ldi.setText("");
                    } else if (HotTopicDetailPkLayout.this.jPS.jPB == 2) {
                        HotTopicDetailPkLayout.this.ldg.setText("");
                        HotTopicDetailPkLayout.this.ldi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.ldg.setText("");
                        HotTopicDetailPkLayout.this.ldi.setText("");
                    }
                    HotTopicDetailPkLayout.this.jPS.jPB = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.jPS.jPB != 0) {
                        if (HotTopicDetailPkLayout.this.jPS.jPB == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.ldg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.ldi.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.ldg.setText("");
                                HotTopicDetailPkLayout.this.ldi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.ldg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.ldi.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.ldg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.ldi.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.ldg.setText("");
                            HotTopicDetailPkLayout.this.ldi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.ldg.setText("");
                            HotTopicDetailPkLayout.this.ldi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.ldg.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.ldi.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.ldg.setText("");
                        HotTopicDetailPkLayout.this.ldi.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.ldg.setText("");
                        HotTopicDetailPkLayout.this.ldi.setText("");
                    }
                    HotTopicDetailPkLayout.this.jPS.jPB = i;
                }
                HotTopicDetailPkLayout.this.jPS.userPkId = j2;
                HotTopicDetailPkLayout.this.ldg.setVisibility(0);
                HotTopicDetailPkLayout.this.ldi.setVisibility(0);
                HotTopicDetailPkLayout.this.mj(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.ldl);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.ldl, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
