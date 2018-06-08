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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes3.dex */
public class SignAllForumProgressView extends FrameLayout {
    private TextView cXm;
    private int duration;
    private int gAG;
    private TextView gAH;
    private TextView gAI;
    private TbImageView gAJ;
    private RelativeLayout gAK;
    private Runnable gAL;
    private Runnable gAM;
    private Runnable gAN;
    private boolean gyT;
    private Context mContext;
    private ImageView mIcon;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public SignAllForumProgressView(Context context) {
        super(context);
        this.gAG = 0;
        this.duration = 2000;
        this.gAL = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.gAG == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gAL, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gAM, 2000L);
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
        this.gAM = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.gAN = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.gAG = 0;
        this.duration = 2000;
        this.gAL = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.gAG == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gAL, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gAM, 2000L);
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
        this.gAM = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.gAN = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.gAG = 0;
        this.duration = 2000;
        this.gAL = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.gAG == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gAL, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.gAM, 2000L);
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
        this.gAM = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.gAN = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.cXm = (TextView) findViewById(d.g.signallforun_status);
        this.gAH = (TextView) findViewById(d.g.signallforun_message1);
        this.gAI = (TextView) findViewById(d.g.signallforun_message2);
        this.gAJ = (TbImageView) findViewById(d.g.signallforum_banner_image);
        this.gAK = (RelativeLayout) findViewById(d.g.signallforum_banner_layout);
        Al();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), d.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void Al() {
        removeCallbacks(this.gAL);
        removeCallbacks(this.gAM);
        if (this.gyT) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.singnallforum_progress));
        }
        switch (this.gAG) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.gyT) {
                    al.i(this.mProgress, d.f.btn_vip_all_sign);
                    al.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    al.i(this.mProgress, d.f.btn_all_sign);
                    al.c(this.mIcon, d.f.icon_all_sign);
                }
                this.cXm.setText(d.k.signallforum_begin);
                return;
            case 1:
                post(this.gAN);
                this.mProgress.setClickable(false);
                al.i(this.mProgress, d.f.bg_all_sign_conduct);
                if (this.gyT) {
                    al.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    al.c(this.mIcon, d.f.icon_all_sign);
                }
                this.cXm.setText(d.k.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.gAL);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.gyT) {
                    al.i(this.mProgress, d.f.bg_vip_sign_ok_d);
                    al.c(this.mIcon, d.f.icon_vip_sign_ok);
                } else {
                    al.i(this.mProgress, d.f.bg_all_sign_ok_d);
                    al.c(this.mIcon, d.f.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.cXm.setText(d.k.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.gyT) {
                    al.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    al.c(this.mIcon, d.f.icon_all_sign);
                }
                al.i(this.mProgress, d.f.bg_all_sign_conduct);
                this.cXm.setText(d.k.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.gAG;
    }

    public void setSigning(int i) {
        if (this.gAG != 1 && this.gAG == 0) {
            this.mProgress.setProgress(i);
            this.gAG = 1;
            Al();
        }
    }

    public void setSignSuccess() {
        if (this.gAG != 2) {
            this.gAG = 2;
            Al();
        }
    }

    public void a(final BaseActivity<?> baseActivity, final String str, final String str2) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.gAK.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                SignAllForumProgressView.this.gAK.setVisibility(0);
                SignAllForumProgressView.this.gAJ.startLoad(str, 10, true);
                if (!StringUtils.isNull(str2)) {
                    SignAllForumProgressView.this.gAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!ay.zG().a(baseActivity.getPageContext(), "", new String[]{str2}, false, null, true) && !ay.zG().eT(str2)) {
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

    public void btU() {
        this.gAK.setVisibility(8);
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public TextView getMessage1() {
        return this.gAH;
    }

    public TextView getMessage2() {
        return this.gAI;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.gAG = i;
        Al();
    }

    public void setHasPrivilege(boolean z) {
        this.gyT = z;
        Al();
    }
}
