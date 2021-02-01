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
    private int kgI;
    private i kul;
    private TextView kvU;
    private TextView lzg;
    private TextView lzh;
    private View lzi;
    private ViewGroup.LayoutParams lzj;
    private int lzk;
    private int lzl;
    private ValueAnimator lzm;
    private HotTopicDetailPkProcess lzn;
    private TextView lzo;
    private TextView lzp;
    private TextView lzq;
    private TextView lzr;
    private ColorStateList lzs;
    private ColorStateList lzt;
    private Runnable lzu;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.kgI = 3;
        this.lzk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lzl = 0;
        this.lzs = ap.getColorList(R.color.CAM_X0308);
        this.lzt = ap.getColorList(R.color.CAM_X0303);
        this.lzu = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lzp != null) {
                    HotTopicDetailPkLayout.this.lzp.setVisibility(8);
                    HotTopicDetailPkLayout.this.lzr.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgI = 3;
        this.lzk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lzl = 0;
        this.lzs = ap.getColorList(R.color.CAM_X0308);
        this.lzt = ap.getColorList(R.color.CAM_X0303);
        this.lzu = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lzp != null) {
                    HotTopicDetailPkLayout.this.lzp.setVisibility(8);
                    HotTopicDetailPkLayout.this.lzr.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgI = 3;
        this.lzk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lzl = 0;
        this.lzs = ap.getColorList(R.color.CAM_X0308);
        this.lzt = ap.getColorList(R.color.CAM_X0303);
        this.lzu = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lzp != null) {
                    HotTopicDetailPkLayout.this.lzp.setVisibility(8);
                    HotTopicDetailPkLayout.this.lzr.setVisibility(8);
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
        this.kvU = (TextView) findViewById(R.id.descView);
        this.lzg = (TextView) findViewById(R.id.pkBtn1);
        this.lzg.setOnClickListener(this);
        this.lzh = (TextView) findViewById(R.id.pkBtn2);
        this.lzh.setOnClickListener(this);
        this.lzi = findViewById(R.id.progressBottomLayout);
        this.lzj = this.lzi.getLayoutParams();
        this.lzj.height = this.lzl;
        this.lzi.setLayoutParams(this.lzj);
        this.lzi.setAlpha(0.0f);
        this.lzn = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lzo = (TextView) findViewById(R.id.pkText1);
        this.lzp = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lzq = (TextView) findViewById(R.id.pkText2);
        this.lzr = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kul = iVar;
        nf(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(boolean z) {
        i iVar = this.kul;
        int i = iVar.ktU == 1 ? 1 : 0;
        int i2 = iVar.ktU == 2 ? 1 : 0;
        long j = iVar.kuS + iVar.kuT + i + i2;
        this.ajQ.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), au.numberUniformFormatExtra(j)));
        this.kvU.setText(iVar.ktT);
        this.lzg.setText(iVar.kuK);
        this.lzh.setText(iVar.kuN);
        this.lzo.setText("" + (iVar.kuS + i));
        this.lzq.setText("" + (iVar.kuT + i2));
        if (j > 0) {
            if (iVar.ktU == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lzn.setProcess(f + ((((float) iVar.kuS) * 1.0f) / ((float) j)), z);
                } else {
                    this.lzn.setProcess(1.0f, z);
                }
            } else if (iVar.ktU == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lzn.setProcess(((((float) iVar.kuS) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lzn.setProcess(0.0f, z);
                }
            } else {
                this.lzn.setProcess((((float) iVar.kuS) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lzn.setProcess(0.5f, z);
        }
        if (this.lzi.getVisibility() != 0) {
            if (iVar.ktU != 0) {
                this.lzl = this.lzk;
                this.lzj = this.lzi.getLayoutParams();
                this.lzj.height = this.lzl;
                this.lzi.setLayoutParams(this.lzj);
                this.lzi.setAlpha(1.0f);
                this.lzi.setVisibility(0);
            } else {
                this.lzl = 0;
                this.lzj = this.lzi.getLayoutParams();
                this.lzj.height = this.lzl;
                this.lzi.setLayoutParams(this.lzj);
                this.lzi.setAlpha(0.0f);
            }
        }
        dif();
    }

    private void dif() {
        if (this.kul != null) {
            if (this.kul.ktU == 1) {
                this.lzg.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lzh.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzg.setTextColor(ap.getColor(R.color.CAM_X0101));
                this.lzh.setTextColor(ap.getColor(R.color.CAM_X0302));
            } else if (this.kul.ktU == 2) {
                this.lzg.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzh.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lzg.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lzh.setTextColor(ap.getColor(R.color.CAM_X0101));
            } else {
                this.lzg.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzh.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lzg.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lzh.setTextColor(ap.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lzg.setBackgroundTintList(this.lzs);
                this.lzh.setBackgroundTintList(this.lzt);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgI != i) {
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            this.lzs = ap.getColorList(R.color.CAM_X0308);
            this.lzt = ap.getColorList(R.color.CAM_X0303);
            dif();
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0109);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
            ap.setViewTextColor(this.kvU, R.color.CAM_X0105);
            ap.setViewTextColor(this.lzo, R.color.CAM_X0308);
            ap.setViewTextColor(this.lzp, R.color.CAM_X0308);
            ap.setViewTextColor(this.lzq, R.color.CAM_X0303);
            ap.setViewTextColor(this.lzr, R.color.CAM_X0303);
            this.lzn.onChangeSkinType(i);
            this.kgI = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            dig();
        } else if (id == R.id.pkBtn2) {
            dih();
        }
    }

    private void dig() {
        if (!HZ()) {
            dii();
            if (this.lzi.getVisibility() != 0) {
                Fg(1);
            } else if (this.lzm == null || !this.lzm.isRunning()) {
                Ff(1);
            }
        }
    }

    private void dih() {
        if (!HZ()) {
            dii();
            if (this.lzi.getVisibility() != 0) {
                Fg(2);
            } else if (this.lzm == null || !this.lzm.isRunning()) {
                Ff(2);
            }
        }
    }

    private void dii() {
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
        this.pageContext.getOrignalPage().a(this.kul, i);
    }

    private void Fg(int i) {
        if (this.lzm != null) {
            this.lzm.cancel();
        }
        this.lzi.setVisibility(0);
        this.lzm = ValueAnimator.ofFloat((this.lzl * 1.0f) / this.lzk, 1.0f);
        this.lzm.setDuration((((this.lzk - this.lzl) * 300) * 1.0f) / this.lzk);
        this.lzm.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lzm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lzi.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lzj.height = (int) (floatValue * HotTopicDetailPkLayout.this.lzk);
                HotTopicDetailPkLayout.this.lzi.setLayoutParams(HotTopicDetailPkLayout.this.lzj);
            }
        });
        this.lzm.start();
        Ff(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.lzm == null || !this.lzm.isRunning() || ((Float) this.lzm.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lzm.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kul.ktU == 1) {
                        HotTopicDetailPkLayout.this.lzp.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lzr.setText("");
                    } else if (HotTopicDetailPkLayout.this.kul.ktU == 2) {
                        HotTopicDetailPkLayout.this.lzp.setText("");
                        HotTopicDetailPkLayout.this.lzr.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lzp.setText("");
                        HotTopicDetailPkLayout.this.lzr.setText("");
                    }
                    HotTopicDetailPkLayout.this.kul.ktU = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kul.ktU != 0) {
                        if (HotTopicDetailPkLayout.this.kul.ktU == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lzp.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lzr.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lzp.setText("");
                                HotTopicDetailPkLayout.this.lzr.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lzp.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lzr.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lzp.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lzr.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lzp.setText("");
                            HotTopicDetailPkLayout.this.lzr.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lzp.setText("");
                            HotTopicDetailPkLayout.this.lzr.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lzp.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lzr.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lzp.setText("");
                        HotTopicDetailPkLayout.this.lzr.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lzp.setText("");
                        HotTopicDetailPkLayout.this.lzr.setText("");
                    }
                    HotTopicDetailPkLayout.this.kul.ktU = i;
                }
                HotTopicDetailPkLayout.this.kul.userPkId = j2;
                HotTopicDetailPkLayout.this.lzp.setVisibility(0);
                HotTopicDetailPkLayout.this.lzr.setVisibility(0);
                HotTopicDetailPkLayout.this.nf(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lzu);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lzu, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
