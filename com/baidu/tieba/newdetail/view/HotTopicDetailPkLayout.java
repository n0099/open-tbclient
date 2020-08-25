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
/* loaded from: classes15.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView aix;
    private TextView dSz;
    private int iLR;
    private i iZb;
    private TextView jaJ;
    private HotTopicDetailPkProcess kmA;
    private TextView kmB;
    private TextView kmC;
    private TextView kmD;
    private TextView kmE;
    private ColorStateList kmF;
    private ColorStateList kmG;
    private Runnable kmH;
    private TextView kmt;
    private TextView kmu;
    private View kmv;
    private ViewGroup.LayoutParams kmw;
    private int kmx;
    private int kmy;
    private ValueAnimator kmz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.iLR = 3;
        this.kmx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kmy = 0;
        this.kmF = ap.getColorList(R.color.cp_other_b);
        this.kmG = ap.getColorList(R.color.cp_link_tip_b);
        this.kmH = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kmC != null) {
                    HotTopicDetailPkLayout.this.kmC.setVisibility(8);
                    HotTopicDetailPkLayout.this.kmE.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        this.kmx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kmy = 0;
        this.kmF = ap.getColorList(R.color.cp_other_b);
        this.kmG = ap.getColorList(R.color.cp_link_tip_b);
        this.kmH = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kmC != null) {
                    HotTopicDetailPkLayout.this.kmC.setVisibility(8);
                    HotTopicDetailPkLayout.this.kmE.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        this.kmx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kmy = 0;
        this.kmF = ap.getColorList(R.color.cp_other_b);
        this.kmG = ap.getColorList(R.color.cp_link_tip_b);
        this.kmH = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kmC != null) {
                    HotTopicDetailPkLayout.this.kmC.setVisibility(8);
                    HotTopicDetailPkLayout.this.kmE.setVisibility(8);
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
        this.aix = (TextView) findViewById(R.id.tagView);
        this.dSz = (TextView) findViewById(R.id.titleView);
        this.jaJ = (TextView) findViewById(R.id.descView);
        this.kmt = (TextView) findViewById(R.id.pkBtn1);
        this.kmt.setOnClickListener(this);
        this.kmu = (TextView) findViewById(R.id.pkBtn2);
        this.kmu.setOnClickListener(this);
        this.kmv = findViewById(R.id.progressBottomLayout);
        this.kmw = this.kmv.getLayoutParams();
        this.kmw.height = this.kmy;
        this.kmv.setLayoutParams(this.kmw);
        this.kmv.setAlpha(0.0f);
        this.kmA = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.kmB = (TextView) findViewById(R.id.pkText1);
        this.kmC = (TextView) findViewById(R.id.pkTextSubmit1);
        this.kmD = (TextView) findViewById(R.id.pkText2);
        this.kmE = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.iZb = iVar;
        lh(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh(boolean z) {
        i iVar = this.iZb;
        int i = iVar.iYK == 1 ? 1 : 0;
        int i2 = iVar.iYK == 2 ? 1 : 0;
        long j = iVar.iZH + iVar.iZI + i + i2;
        this.aix.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.jaJ.setText(iVar.iYJ);
        this.kmt.setText(iVar.iZz);
        this.kmu.setText(iVar.iZC);
        this.kmB.setText("" + (iVar.iZH + i));
        this.kmD.setText("" + (iVar.iZI + i2));
        if (j > 0) {
            if (iVar.iYK == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.kmA.setProcess(f + ((((float) iVar.iZH) * 1.0f) / ((float) j)), z);
                } else {
                    this.kmA.setProcess(1.0f, z);
                }
            } else if (iVar.iYK == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.kmA.setProcess(((((float) iVar.iZH) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.kmA.setProcess(0.0f, z);
                }
            } else {
                this.kmA.setProcess((((float) iVar.iZH) * 1.0f) / ((float) j), z);
            }
        } else {
            this.kmA.setProcess(0.5f, z);
        }
        if (this.kmv.getVisibility() != 0) {
            if (iVar.iYK != 0) {
                this.kmy = this.kmx;
                this.kmw = this.kmv.getLayoutParams();
                this.kmw.height = this.kmy;
                this.kmv.setLayoutParams(this.kmw);
                this.kmv.setAlpha(1.0f);
                this.kmv.setVisibility(0);
            } else {
                this.kmy = 0;
                this.kmw = this.kmv.getLayoutParams();
                this.kmw.height = this.kmy;
                this.kmv.setLayoutParams(this.kmw);
                this.kmv.setAlpha(0.0f);
            }
        }
        cSC();
    }

    private void cSC() {
        if (this.iZb != null) {
            if (this.iZb.iYK == 1) {
                this.kmt.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kmu.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmt.setTextColor(ap.getColor(R.color.cp_cont_a));
                this.kmu.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            } else if (this.iZb.iYK == 2) {
                this.kmt.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmu.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kmt.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kmu.setTextColor(ap.getColor(R.color.cp_cont_a));
            } else {
                this.kmt.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmu.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmt.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kmu.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.kmt.setBackgroundTintList(this.kmF);
                this.kmu.setBackgroundTintList(this.kmG);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.kmF = ap.getColorList(R.color.cp_other_b);
            this.kmG = ap.getColorList(R.color.cp_link_tip_b);
            cSC();
            ap.setViewTextColor(this.aix, R.color.cp_cont_d);
            ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
            ap.setViewTextColor(this.jaJ, R.color.cp_cont_b);
            ap.setViewTextColor(this.kmB, R.color.cp_other_b);
            ap.setViewTextColor(this.kmC, R.color.cp_other_b);
            ap.setViewTextColor(this.kmD, R.color.cp_link_tip_b);
            ap.setViewTextColor(this.kmE, R.color.cp_link_tip_b);
            this.kmA.onChangeSkinType(i);
            this.iLR = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            cSD();
        } else if (id == R.id.pkBtn2) {
            cSE();
        }
    }

    private void cSD() {
        if (!Hu()) {
            cSF();
            if (this.kmv.getVisibility() != 0) {
                DC(1);
            } else if (this.kmz == null || !this.kmz.isRunning()) {
                DB(1);
            }
        }
    }

    private void cSE() {
        if (!Hu()) {
            cSF();
            if (this.kmv.getVisibility() != 0) {
                DC(2);
            } else if (this.kmz == null || !this.kmz.isRunning()) {
                DB(2);
            }
        }
    }

    private void cSF() {
        TiebaStatic.log(new aq("c13818").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean Hu() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void DB(int i) {
        this.pageContext.getOrignalPage().a(this.iZb, i);
    }

    private void DC(int i) {
        if (this.kmz != null) {
            this.kmz.cancel();
        }
        this.kmv.setVisibility(0);
        this.kmz = ValueAnimator.ofFloat((this.kmy * 1.0f) / this.kmx, 1.0f);
        this.kmz.setDuration((((this.kmx - this.kmy) * 300) * 1.0f) / this.kmx);
        this.kmz.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kmz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.kmv.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.kmw.height = (int) (floatValue * HotTopicDetailPkLayout.this.kmx);
                HotTopicDetailPkLayout.this.kmv.setLayoutParams(HotTopicDetailPkLayout.this.kmw);
            }
        });
        this.kmz.start();
        DB(i);
    }

    public void d(long j, final long j2, final int i) {
        int i2;
        if (this.kmz == null || !this.kmz.isRunning() || ((Float) this.kmz.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.kmz.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.iZb.iYK == 1) {
                        HotTopicDetailPkLayout.this.kmC.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.kmE.setText("");
                    } else if (HotTopicDetailPkLayout.this.iZb.iYK == 2) {
                        HotTopicDetailPkLayout.this.kmC.setText("");
                        HotTopicDetailPkLayout.this.kmE.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.kmC.setText("");
                        HotTopicDetailPkLayout.this.kmE.setText("");
                    }
                    HotTopicDetailPkLayout.this.iZb.iYK = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.iZb.iYK != 0) {
                        if (HotTopicDetailPkLayout.this.iZb.iYK == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.kmC.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.kmE.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.kmC.setText("");
                                HotTopicDetailPkLayout.this.kmE.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.kmC.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.kmE.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.kmC.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.kmE.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.kmC.setText("");
                            HotTopicDetailPkLayout.this.kmE.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.kmC.setText("");
                            HotTopicDetailPkLayout.this.kmE.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.kmC.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.kmE.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.kmC.setText("");
                        HotTopicDetailPkLayout.this.kmE.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.kmC.setText("");
                        HotTopicDetailPkLayout.this.kmE.setText("");
                    }
                    HotTopicDetailPkLayout.this.iZb.iYK = i;
                }
                HotTopicDetailPkLayout.this.iZb.userPkId = j2;
                HotTopicDetailPkLayout.this.kmC.setVisibility(0);
                HotTopicDetailPkLayout.this.kmE.setVisibility(0);
                HotTopicDetailPkLayout.this.lh(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.kmH);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.kmH, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
