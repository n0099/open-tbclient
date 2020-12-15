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
/* loaded from: classes21.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView akq;
    private TextView eAz;
    private int jQw;
    private i kdx;
    private TextView kfg;
    private TextView lqA;
    private View lqB;
    private ViewGroup.LayoutParams lqC;
    private int lqD;
    private int lqE;
    private ValueAnimator lqF;
    private HotTopicDetailPkProcess lqG;
    private TextView lqH;
    private TextView lqI;
    private TextView lqJ;
    private TextView lqK;
    private ColorStateList lqL;
    private ColorStateList lqM;
    private Runnable lqN;
    private TextView lqz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jQw = 3;
        this.lqD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lqE = 0;
        this.lqL = ap.getColorList(R.color.CAM_X0308);
        this.lqM = ap.getColorList(R.color.CAM_X0303);
        this.lqN = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lqI != null) {
                    HotTopicDetailPkLayout.this.lqI.setVisibility(8);
                    HotTopicDetailPkLayout.this.lqK.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        this.lqD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lqE = 0;
        this.lqL = ap.getColorList(R.color.CAM_X0308);
        this.lqM = ap.getColorList(R.color.CAM_X0303);
        this.lqN = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lqI != null) {
                    HotTopicDetailPkLayout.this.lqI.setVisibility(8);
                    HotTopicDetailPkLayout.this.lqK.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        this.lqD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lqE = 0;
        this.lqL = ap.getColorList(R.color.CAM_X0308);
        this.lqM = ap.getColorList(R.color.CAM_X0303);
        this.lqN = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lqI != null) {
                    HotTopicDetailPkLayout.this.lqI.setVisibility(8);
                    HotTopicDetailPkLayout.this.lqK.setVisibility(8);
                }
            }
        };
        initView();
    }

    private void initView() {
        e<?> J = com.baidu.adp.base.i.J(getContext());
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.kfg = (TextView) findViewById(R.id.descView);
        this.lqz = (TextView) findViewById(R.id.pkBtn1);
        this.lqz.setOnClickListener(this);
        this.lqA = (TextView) findViewById(R.id.pkBtn2);
        this.lqA.setOnClickListener(this);
        this.lqB = findViewById(R.id.progressBottomLayout);
        this.lqC = this.lqB.getLayoutParams();
        this.lqC.height = this.lqE;
        this.lqB.setLayoutParams(this.lqC);
        this.lqB.setAlpha(0.0f);
        this.lqG = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lqH = (TextView) findViewById(R.id.pkText1);
        this.lqI = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lqJ = (TextView) findViewById(R.id.pkText2);
        this.lqK = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kdx = iVar;
        mE(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(boolean z) {
        i iVar = this.kdx;
        int i = iVar.kdg == 1 ? 1 : 0;
        int i2 = iVar.kdg == 2 ? 1 : 0;
        long j = iVar.ked + iVar.kee + i + i2;
        this.akq.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), au.numberUniformFormatExtra(j)));
        this.kfg.setText(iVar.kdf);
        this.lqz.setText(iVar.kdV);
        this.lqA.setText(iVar.kdY);
        this.lqH.setText("" + (iVar.ked + i));
        this.lqJ.setText("" + (iVar.kee + i2));
        if (j > 0) {
            if (iVar.kdg == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lqG.setProcess(f + ((((float) iVar.ked) * 1.0f) / ((float) j)), z);
                } else {
                    this.lqG.setProcess(1.0f, z);
                }
            } else if (iVar.kdg == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lqG.setProcess(((((float) iVar.ked) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lqG.setProcess(0.0f, z);
                }
            } else {
                this.lqG.setProcess((((float) iVar.ked) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lqG.setProcess(0.5f, z);
        }
        if (this.lqB.getVisibility() != 0) {
            if (iVar.kdg != 0) {
                this.lqE = this.lqD;
                this.lqC = this.lqB.getLayoutParams();
                this.lqC.height = this.lqE;
                this.lqB.setLayoutParams(this.lqC);
                this.lqB.setAlpha(1.0f);
                this.lqB.setVisibility(0);
            } else {
                this.lqE = 0;
                this.lqC = this.lqB.getLayoutParams();
                this.lqC.height = this.lqE;
                this.lqB.setLayoutParams(this.lqC);
                this.lqB.setAlpha(0.0f);
            }
        }
        dkl();
    }

    private void dkl() {
        if (this.kdx != null) {
            if (this.kdx.kdg == 1) {
                this.lqz.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lqA.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqz.setTextColor(ap.getColor(R.color.CAM_X0101));
                this.lqA.setTextColor(ap.getColor(R.color.CAM_X0302));
            } else if (this.kdx.kdg == 2) {
                this.lqz.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqA.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lqz.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lqA.setTextColor(ap.getColor(R.color.CAM_X0101));
            } else {
                this.lqz.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqA.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqz.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lqA.setTextColor(ap.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lqz.setBackgroundTintList(this.lqL);
                this.lqA.setBackgroundTintList(this.lqM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            this.lqL = ap.getColorList(R.color.CAM_X0308);
            this.lqM = ap.getColorList(R.color.CAM_X0303);
            dkl();
            ap.setViewTextColor(this.akq, R.color.CAM_X0109);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.kfg, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqH, R.color.CAM_X0308);
            ap.setViewTextColor(this.lqI, R.color.CAM_X0308);
            ap.setViewTextColor(this.lqJ, R.color.CAM_X0303);
            ap.setViewTextColor(this.lqK, R.color.CAM_X0303);
            this.lqG.onChangeSkinType(i);
            this.jQw = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            dkm();
        } else if (id == R.id.pkBtn2) {
            dkn();
        }
    }

    private void dkm() {
        if (!Le()) {
            dko();
            if (this.lqB.getVisibility() != 0) {
                GC(1);
            } else if (this.lqF == null || !this.lqF.isRunning()) {
                GB(1);
            }
        }
    }

    private void dkn() {
        if (!Le()) {
            dko();
            if (this.lqB.getVisibility() != 0) {
                GC(2);
            } else if (this.lqF == null || !this.lqF.isRunning()) {
                GB(2);
            }
        }
    }

    private void dko() {
        TiebaStatic.log(new ar("c13818").dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean Le() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void GB(int i) {
        this.pageContext.getOrignalPage().a(this.kdx, i);
    }

    private void GC(int i) {
        if (this.lqF != null) {
            this.lqF.cancel();
        }
        this.lqB.setVisibility(0);
        this.lqF = ValueAnimator.ofFloat((this.lqE * 1.0f) / this.lqD, 1.0f);
        this.lqF.setDuration((((this.lqD - this.lqE) * 300) * 1.0f) / this.lqD);
        this.lqF.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lqF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lqB.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lqC.height = (int) (floatValue * HotTopicDetailPkLayout.this.lqD);
                HotTopicDetailPkLayout.this.lqB.setLayoutParams(HotTopicDetailPkLayout.this.lqC);
            }
        });
        this.lqF.start();
        GB(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.lqF == null || !this.lqF.isRunning() || ((Float) this.lqF.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lqF.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kdx.kdg == 1) {
                        HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lqK.setText("");
                    } else if (HotTopicDetailPkLayout.this.kdx.kdg == 2) {
                        HotTopicDetailPkLayout.this.lqI.setText("");
                        HotTopicDetailPkLayout.this.lqK.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lqI.setText("");
                        HotTopicDetailPkLayout.this.lqK.setText("");
                    }
                    HotTopicDetailPkLayout.this.kdx.kdg = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kdx.kdg != 0) {
                        if (HotTopicDetailPkLayout.this.kdx.kdg == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lqK.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lqI.setText("");
                                HotTopicDetailPkLayout.this.lqK.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lqK.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lqK.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lqI.setText("");
                            HotTopicDetailPkLayout.this.lqK.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lqI.setText("");
                            HotTopicDetailPkLayout.this.lqK.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lqK.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lqI.setText("");
                        HotTopicDetailPkLayout.this.lqK.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lqI.setText("");
                        HotTopicDetailPkLayout.this.lqK.setText("");
                    }
                    HotTopicDetailPkLayout.this.kdx.kdg = i;
                }
                HotTopicDetailPkLayout.this.kdx.userPkId = j2;
                HotTopicDetailPkLayout.this.lqI.setVisibility(0);
                HotTopicDetailPkLayout.this.lqK.setVisibility(0);
                HotTopicDetailPkLayout.this.mE(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lqN);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lqN, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
