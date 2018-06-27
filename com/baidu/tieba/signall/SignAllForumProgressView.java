package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes3.dex */
public class SignAllForumProgressView extends FrameLayout {
    private TextView cVp;
    private int duration;
    private boolean gCM;
    private TextView gEA;
    private TextView gEB;
    private TbImageView gEC;
    private RelativeLayout gED;
    private Runnable gEE;
    private Runnable gEF;
    private Runnable gEG;
    private int gEz;
    private Context mContext;
    private ImageView mIcon;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public SignAllForumProgressView(Context context) {
        super(context);
        this.gEz = 0;
        this.duration = 2000;
        this.gEE = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.gEz == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gEE, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gEF, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.gEF = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.gEG = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = l.dip2px(SignAllForumProgressView.this.mContext, 6.0f);
                int dip2px2 = l.dip2px(SignAllForumProgressView.this.mContext, 100.0f);
                int i = dip2px2 - (dip2px * 2);
                int i2 = (dip2px2 - i) / 2;
                SignAllForumProgressView.this.mProgress.getProgressDrawable().setBounds(i2, i2, i2 + i, i + i2);
            }
        };
        init();
    }

    public SignAllForumProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gEz = 0;
        this.duration = 2000;
        this.gEE = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.gEz == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gEE, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gEF, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.gEF = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.gEG = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = l.dip2px(SignAllForumProgressView.this.mContext, 6.0f);
                int dip2px2 = l.dip2px(SignAllForumProgressView.this.mContext, 100.0f);
                int i2 = dip2px2 - (dip2px * 2);
                int i22 = (dip2px2 - i2) / 2;
                SignAllForumProgressView.this.mProgress.getProgressDrawable().setBounds(i22, i22, i22 + i2, i2 + i22);
            }
        };
        init();
    }

    public SignAllForumProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gEz = 0;
        this.duration = 2000;
        this.gEE = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.gEz == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gEE, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gEF, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.gEF = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.gEG = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = l.dip2px(SignAllForumProgressView.this.mContext, 6.0f);
                int dip2px2 = l.dip2px(SignAllForumProgressView.this.mContext, 100.0f);
                int i2 = dip2px2 - (dip2px * 2);
                int i22 = (dip2px2 - i2) / 2;
                SignAllForumProgressView.this.mProgress.getProgressDrawable().setBounds(i22, i22, i22 + i2, i2 + i22);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(d.i.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(d.g.signallforum_progress);
        this.mIcon = (ImageView) findViewById(d.g.signallforum_icon);
        this.cVp = (TextView) findViewById(d.g.signallforun_status);
        this.gEA = (TextView) findViewById(d.g.signallforun_message1);
        this.gEB = (TextView) findViewById(d.g.signallforun_message2);
        this.gEC = (TbImageView) findViewById(d.g.signallforum_banner_image);
        this.gED = (RelativeLayout) findViewById(d.g.signallforum_banner_layout);
        AB();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), d.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void AB() {
        removeCallbacks(this.gEE);
        removeCallbacks(this.gEF);
        if (this.gCM) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.singnallforum_progress));
        }
        switch (this.gEz) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.gCM) {
                    am.i(this.mProgress, d.f.btn_vip_all_sign);
                    am.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    am.i(this.mProgress, d.f.btn_all_sign);
                    am.c(this.mIcon, d.f.icon_all_sign);
                }
                this.cVp.setText(d.k.signallforum_begin);
                return;
            case 1:
                post(this.gEG);
                this.mProgress.setClickable(false);
                am.i(this.mProgress, d.f.bg_all_sign_conduct);
                if (this.gCM) {
                    am.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    am.c(this.mIcon, d.f.icon_all_sign);
                }
                this.cVp.setText(d.k.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.gEE);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.gCM) {
                    am.i(this.mProgress, d.f.bg_vip_sign_ok_d);
                    am.c(this.mIcon, d.f.icon_vip_sign_ok);
                } else {
                    am.i(this.mProgress, d.f.bg_all_sign_ok_d);
                    am.c(this.mIcon, d.f.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.cVp.setText(d.k.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.gCM) {
                    am.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    am.c(this.mIcon, d.f.icon_all_sign);
                }
                am.i(this.mProgress, d.f.bg_all_sign_conduct);
                this.cVp.setText(d.k.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.gEz;
    }

    public void setSigning(int i) {
        if (this.gEz != 1 && this.gEz == 0) {
            this.mProgress.setProgress(i);
            this.gEz = 1;
            AB();
        }
    }

    public void setSignSuccess() {
        if (this.gEz != 2) {
            this.gEz = 2;
            AB();
        }
    }

    public void a(final BaseActivity<?> baseActivity, final String str, final String str2) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.gED.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                SignAllForumProgressView.this.gED.setVisibility(0);
                SignAllForumProgressView.this.gEC.startLoad(str, 10, true);
                if (!StringUtils.isNull(str2)) {
                    SignAllForumProgressView.this.gED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!az.zV().a(baseActivity.getPageContext(), "", new String[]{str2}, false, null, true) && !az.zV().eW(str2)) {
                                baseActivity.showToast(d.k.pluginstatus_tip_unknown);
                            } else {
                                TiebaStatic.log("c11758");
                            }
                        }
                    });
                }
            }
        }, 3000L);
    }

    public void buu() {
        this.gED.setVisibility(8);
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public TextView getMessage1() {
        return this.gEA;
    }

    public TextView getMessage2() {
        return this.gEB;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.gEz = i;
        AB();
    }

    public void setHasPrivilege(boolean z) {
        this.gCM = z;
        AB();
    }
}
