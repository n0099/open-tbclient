package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private ProgressBar aNo;
    private TextView baS;
    private ImageView cVW;
    private boolean dMK;
    private Runnable dOA;
    private Runnable dOB;
    private int dOw;
    private TextView dOx;
    private TextView dOy;
    private Runnable dOz;
    private int duration;
    private Context mContext;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.dOw = 0;
        this.duration = 2000;
        this.dOz = new y(this);
        this.dOA = new z(this);
        this.dOB = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(t.h.signallforum_progress_view, this);
        this.aNo = (ProgressBar) findViewById(t.g.signallforum_progress);
        this.cVW = (ImageView) findViewById(t.g.signallforum_icon);
        this.baS = (TextView) findViewById(t.g.signallforun_status);
        this.dOx = (TextView) findViewById(t.g.signallforun_message1);
        this.dOy = (TextView) findViewById(t.g.signallforun_message2);
        wV();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), t.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void wV() {
        removeCallbacks(this.dOz);
        removeCallbacks(this.dOA);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.dMK) {
            this.aNo.setProgressDrawable(getResources().getDrawable(t.f.vip_singnallforum_progress));
        } else {
            this.aNo.setProgressDrawable(getResources().getDrawable(t.f.singnallforum_progress));
        }
        switch (this.dOw) {
            case 0:
                this.aNo.setClickable(true);
                this.aNo.setProgress(0);
                this.aNo.setSecondaryProgress(0);
                if (this.dMK) {
                    ar.k(this.aNo, t.f.btn_vip_all_sign);
                    ar.c(this.cVW, t.f.icon_vip_sign);
                } else {
                    ar.k(this.aNo, t.f.btn_all_sign);
                    ar.c(this.cVW, t.f.icon_all_sign);
                }
                this.baS.setText(t.j.signallforum_begin);
                return;
            case 1:
                post(this.dOB);
                this.aNo.setClickable(false);
                ar.k(this.aNo, t.f.bg_all_sign_conduct);
                if (this.dMK) {
                    ar.c(this.cVW, t.f.icon_vip_sign);
                } else {
                    ar.c(this.cVW, t.f.icon_all_sign);
                }
                this.baS.setText(t.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.aNo.getMax()) / 100;
                if (nextInt - this.aNo.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.aNo.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.aNo.getProgress(), 0, nextInt - this.aNo.getProgress(), 0, this.duration);
                }
                post(this.dOz);
                return;
            case 2:
                this.aNo.setClickable(true);
                if (this.dMK) {
                    ar.k(this.aNo, t.f.bg_vip_sign_ok_d);
                    ar.c(this.cVW, t.f.icon_vip_sign_ok);
                } else {
                    ar.k(this.aNo, t.f.bg_all_sign_ok_d);
                    ar.c(this.cVW, t.f.icon_all_sign_ok);
                }
                this.aNo.setProgress(0);
                this.baS.setText(t.j.signallforum_success);
                return;
            case 3:
                this.aNo.setClickable(false);
                if (this.dMK) {
                    ar.c(this.cVW, t.f.icon_vip_sign);
                } else {
                    ar.c(this.cVW, t.f.icon_all_sign);
                }
                ar.k(this.aNo, t.f.bg_all_sign_conduct);
                this.baS.setText(t.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.dOw;
    }

    public void setSigning(int i) {
        if (this.dOw != 1 && this.dOw == 0) {
            this.aNo.setProgress(i);
            this.dOw = 1;
            wV();
        }
    }

    public void aJo() {
        if (this.dOw != 2) {
            this.dOw = 2;
            wV();
        }
    }

    public ProgressBar getProgressBar() {
        return this.aNo;
    }

    public ImageView getIcon() {
        return this.cVW;
    }

    public TextView getmStatus() {
        return this.baS;
    }

    public TextView getMessage1() {
        return this.dOx;
    }

    public TextView getMessage2() {
        return this.dOy;
    }

    public int getProgress() {
        return this.aNo.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.dOw = i;
        wV();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.aNo = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cVW = imageView;
    }

    public void setmStatus(TextView textView) {
        this.baS = textView;
    }

    public void setmMessage1(TextView textView) {
        this.dOx = textView;
    }

    public void setmMessage2(TextView textView) {
        this.dOy = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.dMK = z;
        wV();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.dOz = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.dOA = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.dOB = runnable;
    }
}
