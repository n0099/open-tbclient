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
/* loaded from: classes21.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView ajl;
    private TextView egP;
    private int jjB;
    private i jwL;
    private TextView jyt;
    private TextView kKl;
    private TextView kKm;
    private View kKn;
    private ViewGroup.LayoutParams kKo;
    private int kKp;
    private int kKq;
    private ValueAnimator kKr;
    private HotTopicDetailPkProcess kKs;
    private TextView kKt;
    private TextView kKu;
    private TextView kKv;
    private TextView kKw;
    private ColorStateList kKx;
    private ColorStateList kKy;
    private Runnable kKz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jjB = 3;
        this.kKp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kKq = 0;
        this.kKx = ap.getColorList(R.color.cp_other_b);
        this.kKy = ap.getColorList(R.color.cp_link_tip_b);
        this.kKz = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kKu != null) {
                    HotTopicDetailPkLayout.this.kKu.setVisibility(8);
                    HotTopicDetailPkLayout.this.kKw.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        this.kKp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kKq = 0;
        this.kKx = ap.getColorList(R.color.cp_other_b);
        this.kKy = ap.getColorList(R.color.cp_link_tip_b);
        this.kKz = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kKu != null) {
                    HotTopicDetailPkLayout.this.kKu.setVisibility(8);
                    HotTopicDetailPkLayout.this.kKw.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        this.kKp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.kKq = 0;
        this.kKx = ap.getColorList(R.color.cp_other_b);
        this.kKy = ap.getColorList(R.color.cp_link_tip_b);
        this.kKz = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.kKu != null) {
                    HotTopicDetailPkLayout.this.kKu.setVisibility(8);
                    HotTopicDetailPkLayout.this.kKw.setVisibility(8);
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
        this.ajl = (TextView) findViewById(R.id.tagView);
        this.egP = (TextView) findViewById(R.id.titleView);
        this.jyt = (TextView) findViewById(R.id.descView);
        this.kKl = (TextView) findViewById(R.id.pkBtn1);
        this.kKl.setOnClickListener(this);
        this.kKm = (TextView) findViewById(R.id.pkBtn2);
        this.kKm.setOnClickListener(this);
        this.kKn = findViewById(R.id.progressBottomLayout);
        this.kKo = this.kKn.getLayoutParams();
        this.kKo.height = this.kKq;
        this.kKn.setLayoutParams(this.kKo);
        this.kKn.setAlpha(0.0f);
        this.kKs = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.kKt = (TextView) findViewById(R.id.pkText1);
        this.kKu = (TextView) findViewById(R.id.pkTextSubmit1);
        this.kKv = (TextView) findViewById(R.id.pkText2);
        this.kKw = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.jwL = iVar;
        lJ(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        i iVar = this.jwL;
        int i = iVar.jwu == 1 ? 1 : 0;
        int i2 = iVar.jwu == 2 ? 1 : 0;
        long j = iVar.jxr + iVar.jxs + i + i2;
        this.ajl.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), at.numberUniformFormatExtra(j)));
        this.jyt.setText(iVar.jwt);
        this.kKl.setText(iVar.jxj);
        this.kKm.setText(iVar.jxm);
        this.kKt.setText("" + (iVar.jxr + i));
        this.kKv.setText("" + (iVar.jxs + i2));
        if (j > 0) {
            if (iVar.jwu == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.kKs.setProcess(f + ((((float) iVar.jxr) * 1.0f) / ((float) j)), z);
                } else {
                    this.kKs.setProcess(1.0f, z);
                }
            } else if (iVar.jwu == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.kKs.setProcess(((((float) iVar.jxr) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.kKs.setProcess(0.0f, z);
                }
            } else {
                this.kKs.setProcess((((float) iVar.jxr) * 1.0f) / ((float) j), z);
            }
        } else {
            this.kKs.setProcess(0.5f, z);
        }
        if (this.kKn.getVisibility() != 0) {
            if (iVar.jwu != 0) {
                this.kKq = this.kKp;
                this.kKo = this.kKn.getLayoutParams();
                this.kKo.height = this.kKq;
                this.kKn.setLayoutParams(this.kKo);
                this.kKn.setAlpha(1.0f);
                this.kKn.setVisibility(0);
            } else {
                this.kKq = 0;
                this.kKo = this.kKn.getLayoutParams();
                this.kKo.height = this.kKq;
                this.kKn.setLayoutParams(this.kKo);
                this.kKn.setAlpha(0.0f);
            }
        }
        cZR();
    }

    private void cZR() {
        if (this.jwL != null) {
            if (this.jwL.jwu == 1) {
                this.kKl.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kKm.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kKl.setTextColor(ap.getColor(R.color.cp_cont_a));
                this.kKm.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            } else if (this.jwL.jwu == 2) {
                this.kKl.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kKm.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.kKl.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kKm.setTextColor(ap.getColor(R.color.cp_cont_a));
            } else {
                this.kKl.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kKm.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.kKl.setTextColor(ap.getColor(R.color.cp_other_b));
                this.kKm.setTextColor(ap.getColor(R.color.cp_link_tip_a));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.kKl.setBackgroundTintList(this.kKx);
                this.kKm.setBackgroundTintList(this.kKy);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            this.kKx = ap.getColorList(R.color.cp_other_b);
            this.kKy = ap.getColorList(R.color.cp_link_tip_b);
            cZR();
            ap.setViewTextColor(this.ajl, R.color.cp_cont_d);
            ap.setViewTextColor(this.egP, R.color.cp_cont_b);
            ap.setViewTextColor(this.jyt, R.color.cp_cont_b);
            ap.setViewTextColor(this.kKt, R.color.cp_other_b);
            ap.setViewTextColor(this.kKu, R.color.cp_other_b);
            ap.setViewTextColor(this.kKv, R.color.cp_link_tip_b);
            ap.setViewTextColor(this.kKw, R.color.cp_link_tip_b);
            this.kKs.onChangeSkinType(i);
            this.jjB = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            cZS();
        } else if (id == R.id.pkBtn2) {
            cZT();
        }
    }

    private void cZS() {
        if (!IS()) {
            cZU();
            if (this.kKn.getVisibility() != 0) {
                EJ(1);
            } else if (this.kKr == null || !this.kKr.isRunning()) {
                EI(1);
            }
        }
    }

    private void cZT() {
        if (!IS()) {
            cZU();
            if (this.kKn.getVisibility() != 0) {
                EJ(2);
            } else if (this.kKr == null || !this.kKr.isRunning()) {
                EI(2);
            }
        }
    }

    private void cZU() {
        TiebaStatic.log(new aq("c13818").dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean IS() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void EI(int i) {
        this.pageContext.getOrignalPage().a(this.jwL, i);
    }

    private void EJ(int i) {
        if (this.kKr != null) {
            this.kKr.cancel();
        }
        this.kKn.setVisibility(0);
        this.kKr = ValueAnimator.ofFloat((this.kKq * 1.0f) / this.kKp, 1.0f);
        this.kKr.setDuration((((this.kKp - this.kKq) * 300) * 1.0f) / this.kKp);
        this.kKr.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kKr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.kKn.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.kKo.height = (int) (floatValue * HotTopicDetailPkLayout.this.kKp);
                HotTopicDetailPkLayout.this.kKn.setLayoutParams(HotTopicDetailPkLayout.this.kKo);
            }
        });
        this.kKr.start();
        EI(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.kKr == null || !this.kKr.isRunning() || ((Float) this.kKr.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.kKr.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.jwL.jwu == 1) {
                        HotTopicDetailPkLayout.this.kKu.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.kKw.setText("");
                    } else if (HotTopicDetailPkLayout.this.jwL.jwu == 2) {
                        HotTopicDetailPkLayout.this.kKu.setText("");
                        HotTopicDetailPkLayout.this.kKw.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.kKu.setText("");
                        HotTopicDetailPkLayout.this.kKw.setText("");
                    }
                    HotTopicDetailPkLayout.this.jwL.jwu = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.jwL.jwu != 0) {
                        if (HotTopicDetailPkLayout.this.jwL.jwu == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.kKu.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.kKw.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.kKu.setText("");
                                HotTopicDetailPkLayout.this.kKw.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.kKu.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.kKw.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.kKu.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.kKw.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.kKu.setText("");
                            HotTopicDetailPkLayout.this.kKw.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.kKu.setText("");
                            HotTopicDetailPkLayout.this.kKw.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.kKu.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.kKw.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.kKu.setText("");
                        HotTopicDetailPkLayout.this.kKw.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.kKu.setText("");
                        HotTopicDetailPkLayout.this.kKw.setText("");
                    }
                    HotTopicDetailPkLayout.this.jwL.jwu = i;
                }
                HotTopicDetailPkLayout.this.jwL.userPkId = j2;
                HotTopicDetailPkLayout.this.kKu.setVisibility(0);
                HotTopicDetailPkLayout.this.kKw.setVisibility(0);
                HotTopicDetailPkLayout.this.lJ(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.kKz);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.kKz, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
