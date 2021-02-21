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
/* loaded from: classes8.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {
    private TextView ajQ;
    private TextView eHx;
    private int kgW;
    private i kuz;
    private TextView kwi;
    private ValueAnimator lzA;
    private HotTopicDetailPkProcess lzB;
    private TextView lzC;
    private TextView lzD;
    private TextView lzE;
    private TextView lzF;
    private ColorStateList lzG;
    private ColorStateList lzH;
    private Runnable lzI;
    private TextView lzu;
    private TextView lzv;
    private View lzw;
    private ViewGroup.LayoutParams lzx;
    private int lzy;
    private int lzz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.kgW = 3;
        this.lzy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lzz = 0;
        this.lzG = ap.getColorList(R.color.CAM_X0308);
        this.lzH = ap.getColorList(R.color.CAM_X0303);
        this.lzI = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lzD != null) {
                    HotTopicDetailPkLayout.this.lzD.setVisibility(8);
                    HotTopicDetailPkLayout.this.lzF.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        this.lzy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lzz = 0;
        this.lzG = ap.getColorList(R.color.CAM_X0308);
        this.lzH = ap.getColorList(R.color.CAM_X0303);
        this.lzI = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lzD != null) {
                    HotTopicDetailPkLayout.this.lzD.setVisibility(8);
                    HotTopicDetailPkLayout.this.lzF.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        this.lzy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lzz = 0;
        this.lzG = ap.getColorList(R.color.CAM_X0308);
        this.lzH = ap.getColorList(R.color.CAM_X0303);
        this.lzI = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lzD != null) {
                    HotTopicDetailPkLayout.this.lzD.setVisibility(8);
                    HotTopicDetailPkLayout.this.lzF.setVisibility(8);
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
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.eHx = (TextView) findViewById(R.id.titleView);
        this.kwi = (TextView) findViewById(R.id.descView);
        this.lzu = (TextView) findViewById(R.id.pkBtn1);
        this.lzu.setOnClickListener(this);
        this.lzv = (TextView) findViewById(R.id.pkBtn2);
        this.lzv.setOnClickListener(this);
        this.lzw = findViewById(R.id.progressBottomLayout);
        this.lzx = this.lzw.getLayoutParams();
        this.lzx.height = this.lzz;
        this.lzw.setLayoutParams(this.lzx);
        this.lzw.setAlpha(0.0f);
        this.lzB = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lzC = (TextView) findViewById(R.id.pkText1);
        this.lzD = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lzE = (TextView) findViewById(R.id.pkText2);
        this.lzF = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kuz = iVar;
        nf(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(boolean z) {
        i iVar = this.kuz;
        int i = iVar.kui == 1 ? 1 : 0;
        int i2 = iVar.kui == 2 ? 1 : 0;
        long j = iVar.kvg + iVar.kvh + i + i2;
        this.ajQ.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), au.numberUniformFormatExtra(j)));
        this.kwi.setText(iVar.kuh);
        this.lzu.setText(iVar.kuY);
        this.lzv.setText(iVar.kvb);
        this.lzC.setText("" + (iVar.kvg + i));
        this.lzE.setText("" + (iVar.kvh + i2));
        if (j > 0) {
            if (iVar.kui == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lzB.setProcess(f + ((((float) iVar.kvg) * 1.0f) / ((float) j)), z);
                } else {
                    this.lzB.setProcess(1.0f, z);
                }
            } else if (iVar.kui == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lzB.setProcess(((((float) iVar.kvg) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lzB.setProcess(0.0f, z);
                }
            } else {
                this.lzB.setProcess((((float) iVar.kvg) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lzB.setProcess(0.5f, z);
        }
        if (this.lzw.getVisibility() != 0) {
            if (iVar.kui != 0) {
                this.lzz = this.lzy;
                this.lzx = this.lzw.getLayoutParams();
                this.lzx.height = this.lzz;
                this.lzw.setLayoutParams(this.lzx);
                this.lzw.setAlpha(1.0f);
                this.lzw.setVisibility(0);
            } else {
                this.lzz = 0;
                this.lzx = this.lzw.getLayoutParams();
                this.lzx.height = this.lzz;
                this.lzw.setLayoutParams(this.lzx);
                this.lzw.setAlpha(0.0f);
            }
        }
        dim();
    }

    private void dim() {
        if (this.kuz != null) {
            if (this.kuz.kui == 1) {
                this.lzu.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lzv.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzu.setTextColor(ap.getColor(R.color.CAM_X0101));
                this.lzv.setTextColor(ap.getColor(R.color.CAM_X0302));
            } else if (this.kuz.kui == 2) {
                this.lzu.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzv.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lzu.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lzv.setTextColor(ap.getColor(R.color.CAM_X0101));
            } else {
                this.lzu.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzv.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzu.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lzv.setTextColor(ap.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lzu.setBackgroundTintList(this.lzG);
                this.lzv.setBackgroundTintList(this.lzH);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            this.lzG = ap.getColorList(R.color.CAM_X0308);
            this.lzH = ap.getColorList(R.color.CAM_X0303);
            dim();
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0109);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
            ap.setViewTextColor(this.kwi, R.color.CAM_X0105);
            ap.setViewTextColor(this.lzC, R.color.CAM_X0308);
            ap.setViewTextColor(this.lzD, R.color.CAM_X0308);
            ap.setViewTextColor(this.lzE, R.color.CAM_X0303);
            ap.setViewTextColor(this.lzF, R.color.CAM_X0303);
            this.lzB.onChangeSkinType(i);
            this.kgW = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            din();
        } else if (id == R.id.pkBtn2) {
            dio();
        }
    }

    private void din() {
        if (!HZ()) {
            dip();
            if (this.lzw.getVisibility() != 0) {
                Fg(1);
            } else if (this.lzA == null || !this.lzA.isRunning()) {
                Ff(1);
            }
        }
    }

    private void dio() {
        if (!HZ()) {
            dip();
            if (this.lzw.getVisibility() != 0) {
                Fg(2);
            } else if (this.lzA == null || !this.lzA.isRunning()) {
                Ff(2);
            }
        }
    }

    private void dip() {
        TiebaStatic.log(new ar("c13818").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("topic_id", this.pageContext.getOrignalPage().getTopicId()));
    }

    private boolean HZ() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.pageContext.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    private void Ff(int i) {
        this.pageContext.getOrignalPage().a(this.kuz, i);
    }

    private void Fg(int i) {
        if (this.lzA != null) {
            this.lzA.cancel();
        }
        this.lzw.setVisibility(0);
        this.lzA = ValueAnimator.ofFloat((this.lzz * 1.0f) / this.lzy, 1.0f);
        this.lzA.setDuration((((this.lzy - this.lzz) * 300) * 1.0f) / this.lzy);
        this.lzA.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lzA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lzw.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lzx.height = (int) (floatValue * HotTopicDetailPkLayout.this.lzy);
                HotTopicDetailPkLayout.this.lzw.setLayoutParams(HotTopicDetailPkLayout.this.lzx);
            }
        });
        this.lzA.start();
        Ff(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.lzA == null || !this.lzA.isRunning() || ((Float) this.lzA.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lzA.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kuz.kui == 1) {
                        HotTopicDetailPkLayout.this.lzD.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lzF.setText("");
                    } else if (HotTopicDetailPkLayout.this.kuz.kui == 2) {
                        HotTopicDetailPkLayout.this.lzD.setText("");
                        HotTopicDetailPkLayout.this.lzF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lzD.setText("");
                        HotTopicDetailPkLayout.this.lzF.setText("");
                    }
                    HotTopicDetailPkLayout.this.kuz.kui = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kuz.kui != 0) {
                        if (HotTopicDetailPkLayout.this.kuz.kui == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lzD.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lzF.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lzD.setText("");
                                HotTopicDetailPkLayout.this.lzF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lzD.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lzF.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lzD.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lzF.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lzD.setText("");
                            HotTopicDetailPkLayout.this.lzF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lzD.setText("");
                            HotTopicDetailPkLayout.this.lzF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lzD.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lzF.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lzD.setText("");
                        HotTopicDetailPkLayout.this.lzF.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lzD.setText("");
                        HotTopicDetailPkLayout.this.lzF.setText("");
                    }
                    HotTopicDetailPkLayout.this.kuz.kui = i;
                }
                HotTopicDetailPkLayout.this.kuz.userPkId = j2;
                HotTopicDetailPkLayout.this.lzD.setVisibility(0);
                HotTopicDetailPkLayout.this.lzF.setVisibility(0);
                HotTopicDetailPkLayout.this.nf(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lzI);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lzI, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
