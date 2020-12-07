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
    private int jQu;
    private i kdv;
    private TextView kfe;
    private ViewGroup.LayoutParams lqA;
    private int lqB;
    private int lqC;
    private ValueAnimator lqD;
    private HotTopicDetailPkProcess lqE;
    private TextView lqF;
    private TextView lqG;
    private TextView lqH;
    private TextView lqI;
    private ColorStateList lqJ;
    private ColorStateList lqK;
    private Runnable lqL;
    private TextView lqx;
    private TextView lqy;
    private View lqz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.jQu = 3;
        this.lqB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lqC = 0;
        this.lqJ = ap.getColorList(R.color.CAM_X0308);
        this.lqK = ap.getColorList(R.color.CAM_X0303);
        this.lqL = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lqG != null) {
                    HotTopicDetailPkLayout.this.lqG.setVisibility(8);
                    HotTopicDetailPkLayout.this.lqI.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQu = 3;
        this.lqB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lqC = 0;
        this.lqJ = ap.getColorList(R.color.CAM_X0308);
        this.lqK = ap.getColorList(R.color.CAM_X0303);
        this.lqL = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lqG != null) {
                    HotTopicDetailPkLayout.this.lqG.setVisibility(8);
                    HotTopicDetailPkLayout.this.lqI.setVisibility(8);
                }
            }
        };
        initView();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQu = 3;
        this.lqB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.lqC = 0;
        this.lqJ = ap.getColorList(R.color.CAM_X0308);
        this.lqK = ap.getColorList(R.color.CAM_X0303);
        this.lqL = new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (HotTopicDetailPkLayout.this.lqG != null) {
                    HotTopicDetailPkLayout.this.lqG.setVisibility(8);
                    HotTopicDetailPkLayout.this.lqI.setVisibility(8);
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
        this.kfe = (TextView) findViewById(R.id.descView);
        this.lqx = (TextView) findViewById(R.id.pkBtn1);
        this.lqx.setOnClickListener(this);
        this.lqy = (TextView) findViewById(R.id.pkBtn2);
        this.lqy.setOnClickListener(this);
        this.lqz = findViewById(R.id.progressBottomLayout);
        this.lqA = this.lqz.getLayoutParams();
        this.lqA.height = this.lqC;
        this.lqz.setLayoutParams(this.lqA);
        this.lqz.setAlpha(0.0f);
        this.lqE = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.lqF = (TextView) findViewById(R.id.pkText1);
        this.lqG = (TextView) findViewById(R.id.pkTextSubmit1);
        this.lqH = (TextView) findViewById(R.id.pkText2);
        this.lqI = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void a(@NonNull i iVar) {
        this.kdv = iVar;
        mE(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(boolean z) {
        i iVar = this.kdv;
        int i = iVar.kde == 1 ? 1 : 0;
        int i2 = iVar.kde == 2 ? 1 : 0;
        long j = iVar.keb + iVar.kec + i + i2;
        this.akq.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), au.numberUniformFormatExtra(j)));
        this.kfe.setText(iVar.kdd);
        this.lqx.setText(iVar.kdT);
        this.lqy.setText(iVar.kdW);
        this.lqF.setText("" + (iVar.keb + i));
        this.lqH.setText("" + (iVar.kec + i2));
        if (j > 0) {
            if (iVar.kde == 1) {
                if (j > 1) {
                    float f = 1.0f / ((float) j);
                    if (f < 0.02f) {
                        f = 0.02f;
                    }
                    this.lqE.setProcess(f + ((((float) iVar.keb) * 1.0f) / ((float) j)), z);
                } else {
                    this.lqE.setProcess(1.0f, z);
                }
            } else if (iVar.kde == 2) {
                if (j > 1) {
                    float f2 = 1.0f / ((float) j);
                    if (f2 < 0.02f) {
                        f2 = 0.02f;
                    }
                    this.lqE.setProcess(((((float) iVar.keb) * 1.0f) / ((float) j)) - f2, z);
                } else {
                    this.lqE.setProcess(0.0f, z);
                }
            } else {
                this.lqE.setProcess((((float) iVar.keb) * 1.0f) / ((float) j), z);
            }
        } else {
            this.lqE.setProcess(0.5f, z);
        }
        if (this.lqz.getVisibility() != 0) {
            if (iVar.kde != 0) {
                this.lqC = this.lqB;
                this.lqA = this.lqz.getLayoutParams();
                this.lqA.height = this.lqC;
                this.lqz.setLayoutParams(this.lqA);
                this.lqz.setAlpha(1.0f);
                this.lqz.setVisibility(0);
            } else {
                this.lqC = 0;
                this.lqA = this.lqz.getLayoutParams();
                this.lqA.height = this.lqC;
                this.lqz.setLayoutParams(this.lqA);
                this.lqz.setAlpha(0.0f);
            }
        }
        dkk();
    }

    private void dkk() {
        if (this.kdv != null) {
            if (this.kdv.kde == 1) {
                this.lqx.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lqy.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqx.setTextColor(ap.getColor(R.color.CAM_X0101));
                this.lqy.setTextColor(ap.getColor(R.color.CAM_X0302));
            } else if (this.kdv.kde == 2) {
                this.lqx.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqy.setBackgroundResource(R.drawable.bg_pk_btn_select);
                this.lqx.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lqy.setTextColor(ap.getColor(R.color.CAM_X0101));
            } else {
                this.lqx.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqy.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
                this.lqx.setTextColor(ap.getColor(R.color.CAM_X0308));
                this.lqy.setTextColor(ap.getColor(R.color.CAM_X0302));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.lqx.setBackgroundTintList(this.lqJ);
                this.lqy.setBackgroundTintList(this.lqK);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQu != i) {
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            this.lqJ = ap.getColorList(R.color.CAM_X0308);
            this.lqK = ap.getColorList(R.color.CAM_X0303);
            dkk();
            ap.setViewTextColor(this.akq, R.color.CAM_X0109);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.kfe, R.color.CAM_X0105);
            ap.setViewTextColor(this.lqF, R.color.CAM_X0308);
            ap.setViewTextColor(this.lqG, R.color.CAM_X0308);
            ap.setViewTextColor(this.lqH, R.color.CAM_X0303);
            ap.setViewTextColor(this.lqI, R.color.CAM_X0303);
            this.lqE.onChangeSkinType(i);
            this.jQu = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            dkl();
        } else if (id == R.id.pkBtn2) {
            dkm();
        }
    }

    private void dkl() {
        if (!Le()) {
            dkn();
            if (this.lqz.getVisibility() != 0) {
                GC(1);
            } else if (this.lqD == null || !this.lqD.isRunning()) {
                GB(1);
            }
        }
    }

    private void dkm() {
        if (!Le()) {
            dkn();
            if (this.lqz.getVisibility() != 0) {
                GC(2);
            } else if (this.lqD == null || !this.lqD.isRunning()) {
                GB(2);
            }
        }
    }

    private void dkn() {
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
        this.pageContext.getOrignalPage().a(this.kdv, i);
    }

    private void GC(int i) {
        if (this.lqD != null) {
            this.lqD.cancel();
        }
        this.lqz.setVisibility(0);
        this.lqD = ValueAnimator.ofFloat((this.lqC * 1.0f) / this.lqB, 1.0f);
        this.lqD.setDuration((((this.lqB - this.lqC) * 300) * 1.0f) / this.lqB);
        this.lqD.setInterpolator(new AccelerateDecelerateInterpolator());
        this.lqD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HotTopicDetailPkLayout.this.lqz.setAlpha(floatValue);
                HotTopicDetailPkLayout.this.lqA.height = (int) (floatValue * HotTopicDetailPkLayout.this.lqB);
                HotTopicDetailPkLayout.this.lqz.setLayoutParams(HotTopicDetailPkLayout.this.lqA);
            }
        });
        this.lqD.start();
        GB(i);
    }

    public void e(long j, final long j2, final int i) {
        int i2;
        if (this.lqD == null || !this.lqD.isRunning() || ((Float) this.lqD.getAnimatedValue()).floatValue() >= 1.0f) {
            i2 = 0;
        } else {
            i2 = (int) ((1.0f - ((Float) this.lqD.getAnimatedValue()).floatValue()) * 300.0f);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (j2 == 0) {
                    if (HotTopicDetailPkLayout.this.kdv.kde == 1) {
                        HotTopicDetailPkLayout.this.lqG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        HotTopicDetailPkLayout.this.lqI.setText("");
                    } else if (HotTopicDetailPkLayout.this.kdv.kde == 2) {
                        HotTopicDetailPkLayout.this.lqG.setText("");
                        HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    } else {
                        HotTopicDetailPkLayout.this.lqG.setText("");
                        HotTopicDetailPkLayout.this.lqI.setText("");
                    }
                    HotTopicDetailPkLayout.this.kdv.kde = 0;
                } else {
                    if (HotTopicDetailPkLayout.this.kdv.kde != 0) {
                        if (HotTopicDetailPkLayout.this.kdv.kde == 1) {
                            if (i == 1) {
                                HotTopicDetailPkLayout.this.lqG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                                HotTopicDetailPkLayout.this.lqI.setText("");
                            } else if (i == 2) {
                                HotTopicDetailPkLayout.this.lqG.setText("");
                                HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            } else {
                                HotTopicDetailPkLayout.this.lqG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                                HotTopicDetailPkLayout.this.lqI.setText("");
                            }
                        } else if (i == 1) {
                            HotTopicDetailPkLayout.this.lqG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.lqI.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.lqG.setText("");
                            HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.lqG.setText("");
                            HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    } else if (i == 1) {
                        HotTopicDetailPkLayout.this.lqG.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.lqI.setText("");
                    } else if (i == 2) {
                        HotTopicDetailPkLayout.this.lqG.setText("");
                        HotTopicDetailPkLayout.this.lqI.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.lqG.setText("");
                        HotTopicDetailPkLayout.this.lqI.setText("");
                    }
                    HotTopicDetailPkLayout.this.kdv.kde = i;
                }
                HotTopicDetailPkLayout.this.kdv.userPkId = j2;
                HotTopicDetailPkLayout.this.lqG.setVisibility(0);
                HotTopicDetailPkLayout.this.lqI.setVisibility(0);
                HotTopicDetailPkLayout.this.mE(true);
                HotTopicDetailPkLayout.this.removeCallbacks(HotTopicDetailPkLayout.this.lqL);
                HotTopicDetailPkLayout.this.postDelayed(HotTopicDetailPkLayout.this.lqL, IMConnection.RETRY_DELAY_TIMES);
            }
        }, i2);
    }
}
