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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.Random;
/* loaded from: classes.dex */
public class s extends FrameLayout {
    private TextView aPA;
    private boolean cQX;
    private int cSB;
    private TextView cSC;
    private TextView cSD;
    private Runnable cSE;
    private Runnable cSF;
    private Runnable cSG;
    private ImageView cpm;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public s(Context context) {
        super(context);
        this.cSB = 0;
        this.duration = 2000;
        this.cSE = new t(this);
        this.cSF = new u(this);
        this.cSG = new v(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(i.g.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(i.f.signallforum_progress);
        this.cpm = (ImageView) findViewById(i.f.signallforum_icon);
        this.aPA = (TextView) findViewById(i.f.signallforun_status);
        this.cSC = (TextView) findViewById(i.f.signallforun_message1);
        this.cSD = (TextView) findViewById(i.f.signallforun_message2);
        vx();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i.e.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void vx() {
        removeCallbacks(this.cSE);
        removeCallbacks(this.cSF);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cQX) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.singnallforum_progress));
        }
        switch (this.cSB) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.cQX) {
                    an.i(this.mProgress, i.e.btn_vip_all_sign);
                    an.c(this.cpm, i.e.icon_vip_sign);
                } else {
                    an.i(this.mProgress, i.e.btn_all_sign);
                    an.c(this.cpm, i.e.icon_all_sign);
                }
                this.aPA.setText(i.h.signallforum_begin);
                return;
            case 1:
                post(this.cSG);
                this.mProgress.setClickable(false);
                an.i(this.mProgress, i.e.bg_all_sign_conduct);
                if (this.cQX) {
                    an.c(this.cpm, i.e.icon_vip_sign);
                } else {
                    an.c(this.cpm, i.e.icon_all_sign);
                }
                this.aPA.setText(i.h.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.cSE);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.cQX) {
                    an.i(this.mProgress, i.e.bg_vip_sign_ok_d);
                    an.c(this.cpm, i.e.icon_vip_sign_ok);
                } else {
                    an.i(this.mProgress, i.e.bg_all_sign_ok_d);
                    an.c(this.cpm, i.e.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aPA.setText(i.h.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.cQX) {
                    an.c(this.cpm, i.e.icon_vip_sign);
                } else {
                    an.c(this.cpm, i.e.icon_all_sign);
                }
                an.i(this.mProgress, i.e.bg_all_sign_conduct);
                this.aPA.setText(i.h.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.cSB;
    }

    public void setSigning(int i) {
        if (this.cSB != 1 && this.cSB == 0) {
            this.mProgress.setProgress(i);
            this.cSB = 1;
            vx();
        }
    }

    public void aux() {
        if (this.cSB != 2) {
            this.cSB = 2;
            vx();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cpm;
    }

    public TextView getmStatus() {
        return this.aPA;
    }

    public TextView getMessage1() {
        return this.cSC;
    }

    public TextView getMessage2() {
        return this.cSD;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.cSB = i;
        vx();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cpm = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aPA = textView;
    }

    public void setmMessage1(TextView textView) {
        this.cSC = textView;
    }

    public void setmMessage2(TextView textView) {
        this.cSD = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.cQX = z;
        vx();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.cSE = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cSF = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cSG = runnable;
    }
}
