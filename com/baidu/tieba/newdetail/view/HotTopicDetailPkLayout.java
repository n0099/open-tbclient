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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes8.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView dDu;
    private i iDX;
    private TextView iFF;
    private int iqP;
    private TextView irc;
    private ViewGroup.LayoutParams jOA;
    private int jOB;
    private int jOC;
    private ValueAnimator jOD;
    private HotTopicDetailPkProcess jOE;
    private TextView jOF;
    private TextView jOG;
    private TextView jOH;
    private TextView jOI;
    private ColorStateList jOJ;
    private ColorStateList jOK;
    private Runnable jOL;
    private TextView jOx;
    private TextView jOy;
    private View jOz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.iqP = 3;
        this.jOB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jOC = 0;
        this.jOJ = an.getColorList(R.color.cp_other_b);
        this.jOK = an.getColorList(R.color.cp_link_tip_b);
        this.jOL = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jOG != null) {
                    HotTopicDetailPkLayout.this.jOG.setVisibility(8);
                    HotTopicDetailPkLayout.this.jOI.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        this.jOB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jOC = 0;
        this.jOJ = an.getColorList(R.color.cp_other_b);
        this.jOK = an.getColorList(R.color.cp_link_tip_b);
        this.jOL = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jOG != null) {
                    HotTopicDetailPkLayout.this.jOG.setVisibility(8);
                    HotTopicDetailPkLayout.this.jOI.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        this.jOB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.jOC = 0;
        this.jOJ = an.getColorList(R.color.cp_other_b);
        this.jOK = an.getColorList(R.color.cp_link_tip_b);
        this.jOL = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.jOG != null) {
                    HotTopicDetailPkLayout.this.jOG.setVisibility(8);
                    HotTopicDetailPkLayout.this.jOI.setVisibility(8);
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
        this.irc = (TextView) findViewById(R.id.tagView);
        this.dDu = (TextView) findViewById(R.id.titleView);
        this.iFF = (TextView) findViewById(R.id.descView);
        this.jOx = (TextView) findViewById(R.id.pkBtn1);
        this.jOx.setOnClickListener(this);
        this.jOy = (TextView) findViewById(R.id.pkBtn2);
        this.jOy.setOnClickListener(this);
        this.jOz = findViewById(R.id.progressBottomLayout);
        this.jOA = this.jOz.getLayoutParams();
        this.jOA.height = this.jOC;
        this.jOz.setLayoutParams(this.jOA);
        this.jOz.setAlpha(0.0f);
        this.jOE = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.jOF = (TextView) findViewById(R.id.pkText1);
        this.jOG = (TextView) findViewById(R.id.pkTextSubmit1);
        this.jOH = (TextView) findViewById(R.id.pkText2);
        this.jOI = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.iDX = iVar;
        kd(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        i iVar = this.iDX;
        int i = iVar.iDG == 1 ? 1 : 0;
        int i2 = iVar.iDG == 2 ? 1 : 0;
        long j = iVar.iED + iVar.iEE + i + i2;
        this.irc.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), ar.numberUniformFormatExtra(j)));
        this.iFF.setText(iVar.iDF);
        this.jOx.setText(iVar.iEv);
        this.jOy.setText(iVar.iEy);
        this.jOF.setText("" + (iVar.iED + i));
        this.jOH.setText("" + (iVar.iEE + i2));
        if (j > 0) {
            if (iVar.iDG == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.jOE.setProcess(f + ((((float) iVar.iED) * 1.0f) / ((float) j)), z);
                } else {
                    this.jOE.setProcess(1.0f, z);
                }
            } else if (iVar.iDG == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.jOE.setProcess(((((float) iVar.iED) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.jOE.setProcess(0.0f, z);
                }
            } else {
                this.jOE.setProcess((((float) iVar.iED) * 1.0f) / ((float) j), z);
            }
        } else {
            this.jOE.setProcess(0.5f, z);
        }
        if (this.jOz.getVisibility() != 0) {
            if (iVar.iDG != 0) {
                this.jOC = this.jOB;
                this.jOA = this.jOz.getLayoutParams();
                this.jOA.height = this.jOC;
                this.jOz.setLayoutParams(this.jOA);
                this.jOz.setAlpha(1.0f);
                this.jOz.setVisibility(0);
            } else {
                this.jOC = 0;
                this.jOA = this.jOz.getLayoutParams();
                this.jOA.height = this.jOC;
                this.jOz.setLayoutParams(this.jOA);
                this.jOz.setAlpha(0.0f);
            }
        }
        cEe();
    }

    private void cEe() {
        if (this.iDX != null) {
            if (this.iDX.iDG == 1) {
                this.jOx.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.jOy.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jOx.setTextColor(an.getColor(R.color.cp_cont_a));
                this.jOy.setTextColor(an.getColor(R.color.cp_link_tip_a));
            } else if (this.iDX.iDG == 2) {
                this.jOx.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jOy.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.jOx.setTextColor(an.getColor(R.color.cp_other_b));
                this.jOy.setTextColor(an.getColor(R.color.cp_cont_a));
            } else {
                this.jOx.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jOy.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.jOx.setTextColor(an.getColor(R.color.cp_other_b));
                this.jOy.setTextColor(an.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.jOx.setBackgroundTintList(this.jOJ);
                this.jOy.setBackgroundTintList(this.jOK);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            an.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.jOJ = an.getColorList(R.color.cp_other_b);
            this.jOK = an.getColorList(R.color.cp_link_tip_b);
            cEe();
            an.setViewTextColor(this.irc, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.iFF, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jOF, (int) R.color.cp_other_b);
            an.setViewTextColor(this.jOG, (int) R.color.cp_other_b);
            an.setViewTextColor(this.jOH, (int) R.color.cp_link_tip_b);
            an.setViewTextColor(this.jOI, (int) R.color.cp_link_tip_b);
            this.jOE.onChangeSkinType(i);
            this.iqP = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            cEf();
        } else if (id == R.id.pkBtn2) {
            cEg();
        }
    }

    private void cEf() {
        if (!Bp()) {
            TiebaStatic.log(new ao("c13818"));
            if (this.jOz.getVisibility() != 0) {
                AK(1);
            } else if (this.jOD == null || !this.jOD.isRunning()) {
                AJ(1);
            }
        }
    }

    private void cEg() {
        if (!Bp()) {
            TiebaStatic.log(new ao("c13818"));
            if (this.jOz.getVisibility() != 0) {
                AK(2);
            } else if (this.jOD == null || !this.jOD.isRunning()) {
                AJ(2);
            }
        }
    }

    private boolean Bp() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void AJ(int i) {
        this.pageContext.getOrignalPage().a(this.iDX, i);
    }

    private void AK(int i) {
        if (this.jOD != null) {
            this.jOD.cancel();
        }
        this.jOz.setVisibility(0);
        this.jOD = ValueAnimator.ofFloat((this.jOC * 1.0f) / this.jOB, 1.0f);
        this.jOD.setDuration((((this.jOB - this.jOC) * 300) * 1.0f) / this.jOB);
        this.jOD.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jOD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.jOz.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.jOA.height = (int) (floatValue * HotTopicDetailPkLayout.this.jOB);
                HotTopicDetailPkLayout.this.jOz.setLayoutParams(HotTopicDetailPkLayout.this.jOA);
            }
        });
        this.jOD.start();
        AJ(i);
    }

    public void c(long j, final long j2, final int i) {
        int i2;
        if (this.jOD == null || !this.jOD.isRunning() || ((Float) this.jOD.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.jOD.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.iDX.iDG == 1) {
                        HotTopicDetailPkLayout.this.jOG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.jOI.setText("");
                    } else if (HotTopicDetailPkLayout.this.iDX.iDG == 2) {
                        HotTopicDetailPkLayout.this.jOG.setText("");
                        HotTopicDetailPkLayout.this.jOI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.jOG.setText("");
                        HotTopicDetailPkLayout.this.jOI.setText("");
                    }
                    HotTopicDetailPkLayout.this.iDX.iDG = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.iDX.iDG != 0) {
                        if (HotTopicDetailPkLayout.this.iDX.iDG == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.jOG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.jOI.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.jOG.setText("");
                                HotTopicDetailPkLayout.this.jOI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.jOG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.jOI.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.jOG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.jOI.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.jOG.setText("");
                            HotTopicDetailPkLayout.this.jOI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.jOG.setText("");
                            HotTopicDetailPkLayout.this.jOI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.jOG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.jOI.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.jOG.setText("");
                        HotTopicDetailPkLayout.this.jOI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.jOG.setText("");
                        HotTopicDetailPkLayout.this.jOI.setText("");
                    }
                    HotTopicDetailPkLayout.this.iDX.iDG = i;
                }
                HotTopicDetailPkLayout.this.iDX.userPkId = j2;
                HotTopicDetailPkLayout.this.jOG.setVisibility(0);
                HotTopicDetailPkLayout.this.jOI.setVisibility(0);
                HotTopicDetailPkLayout.this.kd(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.jOL);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.jOL, 3000L);
            }
        }, i2);
    }
}
