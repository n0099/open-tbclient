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
/* loaded from: classes8.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView akS;
    private TextView eKc;
    private int kdK;
    private i kqJ;
    private TextView kss;
    private TextView lvH;
    private TextView lvI;
    private View lvJ;
    private ViewGroup.LayoutParams lvK;
    private int lvL;
    private int lvM;
    private ValueAnimator lvN;
    private HotTopicDetailPkProcess lvO;
    private TextView lvP;
    private TextView lvQ;
    private TextView lvR;
    private TextView lvS;
    private ColorStateList lvT;
    private ColorStateList lvU;
    private Runnable lvV;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.kdK = 3;
        this.lvL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lvM = 0;
        this.lvT = ao.getColorList(R.color.CAM_X0308);
        this.lvU = ao.getColorList(R.color.CAM_X0303);
        this.lvV = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lvQ != null) {
                    HotTopicDetailPkLayout.this.lvQ.setVisibility(8);
                    HotTopicDetailPkLayout.this.lvS.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        this.lvL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lvM = 0;
        this.lvT = ao.getColorList(R.color.CAM_X0308);
        this.lvU = ao.getColorList(R.color.CAM_X0303);
        this.lvV = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lvQ != null) {
                    HotTopicDetailPkLayout.this.lvQ.setVisibility(8);
                    HotTopicDetailPkLayout.this.lvS.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        this.lvL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lvM = 0;
        this.lvT = ao.getColorList(R.color.CAM_X0308);
        this.lvU = ao.getColorList(R.color.CAM_X0303);
        this.lvV = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lvQ != null) {
                    HotTopicDetailPkLayout.this.lvQ.setVisibility(8);
                    HotTopicDetailPkLayout.this.lvS.setVisibility(8);
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
        this.akS = (TextView) findViewById(R.id.tagView);
        this.eKc = (TextView) findViewById(R.id.titleView);
        this.kss = (TextView) findViewById(R.id.descView);
        this.lvH = (TextView) findViewById(R.id.pkBtn1);
        this.lvH.setOnClickListener(this);
        this.lvI = (TextView) findViewById(R.id.pkBtn2);
        this.lvI.setOnClickListener(this);
        this.lvJ = findViewById(R.id.progressBottomLayout);
        this.lvK = this.lvJ.getLayoutParams();
        this.lvK.height = this.lvM;
        this.lvJ.setLayoutParams(this.lvK);
        this.lvJ.setAlpha(0.0f);
        this.lvO = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lvP = (TextView) findViewById(R.id.pkText1);
        this.lvQ = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lvR = (TextView) findViewById(R.id.pkText2);
        this.lvS = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kqJ = iVar;
        ne(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        i iVar = this.kqJ;
        int i = iVar.kqs == 1 ? 1 : 0;
        int i2 = iVar.kqs == 2 ? 1 : 0;
        long j = iVar.krq + iVar.krr + i + i2;
        this.akS.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.kss.setText(iVar.kqr);
        this.lvH.setText(iVar.kri);
        this.lvI.setText(iVar.krl);
        this.lvP.setText("" + (iVar.krq + i));
        this.lvR.setText("" + (iVar.krr + i2));
        if (j > 0) {
            if (iVar.kqs == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lvO.setProcess(f + ((((float) iVar.krq) * 1.0f) / ((float) j)), z);
                } else {
                    this.lvO.setProcess(1.0f, z);
                }
            } else if (iVar.kqs == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lvO.setProcess(((((float) iVar.krq) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lvO.setProcess(0.0f, z);
                }
            } else {
                this.lvO.setProcess((((float) iVar.krq) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lvO.setProcess(0.5f, z);
        }
        if (this.lvJ.getVisibility() != 0) {
            if (iVar.kqs != 0) {
                this.lvM = this.lvL;
                this.lvK = this.lvJ.getLayoutParams();
                this.lvK.height = this.lvM;
                this.lvJ.setLayoutParams(this.lvK);
                this.lvJ.setAlpha(1.0f);
                this.lvJ.setVisibility(0);
            } else {
                this.lvM = 0;
                this.lvK = this.lvJ.getLayoutParams();
                this.lvK.height = this.lvM;
                this.lvJ.setLayoutParams(this.lvK);
                this.lvJ.setAlpha(0.0f);
            }
        }
        djW();
    }

    private void djW() {
        if (this.kqJ != null) {
            if (this.kqJ.kqs == 1) {
                this.lvH.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lvI.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lvH.setTextColor(ao.getColor(R.color.CAM_X0101));
                this.lvI.setTextColor(ao.getColor(R.color.CAM_X0302));
            } else if (this.kqJ.kqs == 2) {
                this.lvH.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lvI.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lvH.setTextColor(ao.getColor(R.color.CAM_X0308));
                this.lvI.setTextColor(ao.getColor(R.color.CAM_X0101));
            } else {
                this.lvH.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lvI.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lvH.setTextColor(ao.getColor(R.color.CAM_X0308));
                this.lvI.setTextColor(ao.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lvH.setBackgroundTintList(this.lvT);
                this.lvI.setBackgroundTintList(this.lvU);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            ao.setBackgroundColor(this, R.color.CAM_X0201);
            this.lvT = ao.getColorList(R.color.CAM_X0308);
            this.lvU = ao.getColorList(R.color.CAM_X0303);
            djW();
            ao.setViewTextColor(this.akS, R.color.CAM_X0109);
            ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
            ao.setViewTextColor(this.kss, R.color.CAM_X0105);
            ao.setViewTextColor(this.lvP, R.color.CAM_X0308);
            ao.setViewTextColor(this.lvQ, R.color.CAM_X0308);
            ao.setViewTextColor(this.lvR, R.color.CAM_X0303);
            ao.setViewTextColor(this.lvS, R.color.CAM_X0303);
            this.lvO.onChangeSkinType(i);
            this.kdK = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            djX();
        } else if (id == R.id.pkBtn2) {
            djY();
        }
    }

    private void djX() {
        if (!KE()) {
            djZ();
            if (this.lvJ.getVisibility() != 0) {
                Gu(1);
            } else if (this.lvN == null || !this.lvN.isRunning()) {
                Gt(1);
            }
        }
    }

    private void djY() {
        if (!KE()) {
            djZ();
            if (this.lvJ.getVisibility() != 0) {
                Gu(2);
            } else if (this.lvN == null || !this.lvN.isRunning()) {
                Gt(2);
            }
        }
    }

    private void djZ() {
        TiebaStatic.log(new aq("c13818").dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean KE() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Gt(int i) {
        this.pageContext.getOrignalPage().a(this.kqJ, i);
    }

    private void Gu(int i) {
        if (this.lvN != null) {
            this.lvN.cancel();
        }
        this.lvJ.setVisibility(0);
        this.lvN = ValueAnimator.ofFloat((this.lvM * 1.0f) / this.lvL, 1.0f);
        this.lvN.setDuration((((this.lvL - this.lvM) * 300) * 1.0f) / this.lvL);
        this.lvN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lvN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lvJ.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lvK.height = (int) (floatValue * HotTopicDetailPkLayout.this.lvL);
                HotTopicDetailPkLayout.this.lvJ.setLayoutParams(HotTopicDetailPkLayout.this.lvK);
            }
        });
        this.lvN.start();
        Gt(i);
    }

    public void f(long j, final long j2, final int i) {
        int i2;
        if (this.lvN == null || !this.lvN.isRunning() || ((Float) this.lvN.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lvN.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kqJ.kqs == 1) {
                        HotTopicDetailPkLayout.this.lvQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lvS.setText("");
                    } else if (HotTopicDetailPkLayout.this.kqJ.kqs == 2) {
                        HotTopicDetailPkLayout.this.lvQ.setText("");
                        HotTopicDetailPkLayout.this.lvS.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lvQ.setText("");
                        HotTopicDetailPkLayout.this.lvS.setText("");
                    }
                    HotTopicDetailPkLayout.this.kqJ.kqs = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kqJ.kqs != 0) {
                        if (HotTopicDetailPkLayout.this.kqJ.kqs == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lvQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lvS.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lvQ.setText("");
                                HotTopicDetailPkLayout.this.lvS.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lvQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lvS.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lvQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lvS.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lvQ.setText("");
                            HotTopicDetailPkLayout.this.lvS.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lvQ.setText("");
                            HotTopicDetailPkLayout.this.lvS.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lvQ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lvS.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lvQ.setText("");
                        HotTopicDetailPkLayout.this.lvS.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lvQ.setText("");
                        HotTopicDetailPkLayout.this.lvS.setText("");
                    }
                    HotTopicDetailPkLayout.this.kqJ.kqs = i;
                }
                HotTopicDetailPkLayout.this.kqJ.userPkId = j2;
                HotTopicDetailPkLayout.this.lvQ.setVisibility(0);
                HotTopicDetailPkLayout.this.lvS.setVisibility(0);
                HotTopicDetailPkLayout.this.ne(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lvV);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lvV, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
