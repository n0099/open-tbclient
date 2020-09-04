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
    private TextView aiz;
    private TextView dSD;
    private int iLX;
    private i iZh;
    private TextView jaP;
    private TextView kmA;
    private TextView kmB;
    private View kmC;
    private ViewGroup.LayoutParams kmD;
    private int kmE;
    private int kmF;
    private ValueAnimator kmG;
    private HotTopicDetailPkProcess kmH;
    private TextView kmI;
    private TextView kmJ;
    private TextView kmK;
    private TextView kmL;
    private ColorStateList kmM;
    private ColorStateList kmN;
    private Runnable kmO;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.iLX = 3;
        this.kmE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kmF = 0;
        this.kmM = ap.getColorList(R.color.cp_other_b);
        this.kmN = ap.getColorList(R.color.cp_link_tip_b);
        this.kmO = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kmJ != null) {
                    HotTopicDetailPkLayout.this.kmJ.setVisibility(8);
                    HotTopicDetailPkLayout.this.kmL.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        this.kmE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kmF = 0;
        this.kmM = ap.getColorList(R.color.cp_other_b);
        this.kmN = ap.getColorList(R.color.cp_link_tip_b);
        this.kmO = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kmJ != null) {
                    HotTopicDetailPkLayout.this.kmJ.setVisibility(8);
                    HotTopicDetailPkLayout.this.kmL.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        this.kmE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kmF = 0;
        this.kmM = ap.getColorList(R.color.cp_other_b);
        this.kmN = ap.getColorList(R.color.cp_link_tip_b);
        this.kmO = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kmJ != null) {
                    HotTopicDetailPkLayout.this.kmJ.setVisibility(8);
                    HotTopicDetailPkLayout.this.kmL.setVisibility(8);
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
        this.aiz = (TextView) findViewById(R.id.tagView);
        this.dSD = (TextView) findViewById(R.id.titleView);
        this.jaP = (TextView) findViewById(R.id.descView);
        this.kmA = (TextView) findViewById(R.id.pkBtn1);
        this.kmA.setOnClickListener(this);
        this.kmB = (TextView) findViewById(R.id.pkBtn2);
        this.kmB.setOnClickListener(this);
        this.kmC = findViewById(R.id.progressBottomLayout);
        this.kmD = this.kmC.getLayoutParams();
        this.kmD.height = this.kmF;
        this.kmC.setLayoutParams(this.kmD);
        this.kmC.setAlpha(0.0f);
        this.kmH = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.kmI = (TextView) findViewById(R.id.pkText1);
        this.kmJ = (TextView) findViewById(R.id.pkTextSubmit1);
        this.kmK = (TextView) findViewById(R.id.pkText2);
        this.kmL = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.iZh = iVar;
        lj(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        i iVar = this.iZh;
        int i = iVar.iYQ == 1 ? 1 : 0;
        int i2 = iVar.iYQ == 2 ? 1 : 0;
        long j = iVar.iZN + iVar.iZO + i + i2;
        this.aiz.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.jaP.setText(iVar.iYP);
        this.kmA.setText(iVar.iZF);
        this.kmB.setText(iVar.iZI);
        this.kmI.setText("" + (iVar.iZN + i));
        this.kmK.setText("" + (iVar.iZO + i2));
        if (j > 0) {
            if (iVar.iYQ == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.kmH.setProcess(f + ((((float) iVar.iZN) * 1.0f) / ((float) j)), z);
                } else {
                    this.kmH.setProcess(1.0f, z);
                }
            } else if (iVar.iYQ == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.kmH.setProcess(((((float) iVar.iZN) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.kmH.setProcess(0.0f, z);
                }
            } else {
                this.kmH.setProcess((((float) iVar.iZN) * 1.0f) / ((float) j), z);
            }
        } else {
            this.kmH.setProcess(0.5f, z);
        }
        if (this.kmC.getVisibility() != 0) {
            if (iVar.iYQ != 0) {
                this.kmF = this.kmE;
                this.kmD = this.kmC.getLayoutParams();
                this.kmD.height = this.kmF;
                this.kmC.setLayoutParams(this.kmD);
                this.kmC.setAlpha(1.0f);
                this.kmC.setVisibility(0);
            } else {
                this.kmF = 0;
                this.kmD = this.kmC.getLayoutParams();
                this.kmD.height = this.kmF;
                this.kmC.setLayoutParams(this.kmD);
                this.kmC.setAlpha(0.0f);
            }
        }
        cSD();
    }

    private void cSD() {
        if (this.iZh != null) {
            if (this.iZh.iYQ == 1) {
                this.kmA.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kmB.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmA.setTextColor(ap.getColor(R.color.cp_cont_a));
                this.kmB.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            } else if (this.iZh.iYQ == 2) {
                this.kmA.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmB.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kmA.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kmB.setTextColor(ap.getColor(R.color.cp_cont_a));
            } else {
                this.kmA.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmB.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kmA.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kmB.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.kmA.setBackgroundTintList(this.kmM);
                this.kmB.setBackgroundTintList(this.kmN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.kmM = ap.getColorList(R.color.cp_other_b);
            this.kmN = ap.getColorList(R.color.cp_link_tip_b);
            cSD();
            ap.setViewTextColor(this.aiz, R.color.cp_cont_d);
            ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
            ap.setViewTextColor(this.jaP, R.color.cp_cont_b);
            ap.setViewTextColor(this.kmI, R.color.cp_other_b);
            ap.setViewTextColor(this.kmJ, R.color.cp_other_b);
            ap.setViewTextColor(this.kmK, R.color.cp_link_tip_b);
            ap.setViewTextColor(this.kmL, R.color.cp_link_tip_b);
            this.kmH.onChangeSkinType(i);
            this.iLX = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            cSE();
        } else if (id == R.id.pkBtn2) {
            cSF();
        }
    }

    private void cSE() {
        if (!Hu()) {
            cSG();
            if (this.kmC.getVisibility() != 0) {
                DC(1);
            } else if (this.kmG == null || !this.kmG.isRunning()) {
                DB(1);
            }
        }
    }

    private void cSF() {
        if (!Hu()) {
            cSG();
            if (this.kmC.getVisibility() != 0) {
                DC(2);
            } else if (this.kmG == null || !this.kmG.isRunning()) {
                DB(2);
            }
        }
    }

    private void cSG() {
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
        this.pageContext.getOrignalPage().a(this.iZh, i);
    }

    private void DC(int i) {
        if (this.kmG != null) {
            this.kmG.cancel();
        }
        this.kmC.setVisibility(0);
        this.kmG = ValueAnimator.ofFloat((this.kmF * 1.0f) / this.kmE, 1.0f);
        this.kmG.setDuration((((this.kmE - this.kmF) * 300) * 1.0f) / this.kmE);
        this.kmG.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kmG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.kmC.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.kmD.height = (int) (floatValue * HotTopicDetailPkLayout.this.kmE);
                HotTopicDetailPkLayout.this.kmC.setLayoutParams(HotTopicDetailPkLayout.this.kmD);
            }
        });
        this.kmG.start();
        DB(i);
    }

    public void d(long j, final long j2, final int i) {
        int i2;
        if (this.kmG == null || !this.kmG.isRunning() || ((Float) this.kmG.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.kmG.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.iZh.iYQ == 1) {
                        HotTopicDetailPkLayout.this.kmJ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.kmL.setText("");
                    } else if (HotTopicDetailPkLayout.this.iZh.iYQ == 2) {
                        HotTopicDetailPkLayout.this.kmJ.setText("");
                        HotTopicDetailPkLayout.this.kmL.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.kmJ.setText("");
                        HotTopicDetailPkLayout.this.kmL.setText("");
                    }
                    HotTopicDetailPkLayout.this.iZh.iYQ = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.iZh.iYQ != 0) {
                        if (HotTopicDetailPkLayout.this.iZh.iYQ == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.kmJ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.kmL.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.kmJ.setText("");
                                HotTopicDetailPkLayout.this.kmL.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.kmJ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.kmL.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.kmJ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.kmL.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.kmJ.setText("");
                            HotTopicDetailPkLayout.this.kmL.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.kmJ.setText("");
                            HotTopicDetailPkLayout.this.kmL.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.kmJ.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.kmL.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.kmJ.setText("");
                        HotTopicDetailPkLayout.this.kmL.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.kmJ.setText("");
                        HotTopicDetailPkLayout.this.kmL.setText("");
                    }
                    HotTopicDetailPkLayout.this.iZh.iYQ = i;
                }
                HotTopicDetailPkLayout.this.iZh.userPkId = j2;
                HotTopicDetailPkLayout.this.kmJ.setVisibility(0);
                HotTopicDetailPkLayout.this.kmL.setVisibility(0);
                HotTopicDetailPkLayout.this.lj(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.kmO);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.kmO, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
