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
    private TextView aPs;
    private boolean cPB;
    private int cRf;
    private ImageView cRg;
    private TextView cRh;
    private TextView cRi;
    private Runnable cRj;
    private Runnable cRk;
    private Runnable cRl;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public s(Context context) {
        super(context);
        this.cRf = 0;
        this.duration = 2000;
        this.cRj = new t(this);
        this.cRk = new u(this);
        this.cRl = new v(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(i.g.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(i.f.signallforum_progress);
        this.cRg = (ImageView) findViewById(i.f.signallforum_icon);
        this.aPs = (TextView) findViewById(i.f.signallforun_status);
        this.cRh = (TextView) findViewById(i.f.signallforun_message1);
        this.cRi = (TextView) findViewById(i.f.signallforun_message2);
        vt();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i.e.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void vt() {
        removeCallbacks(this.cRj);
        removeCallbacks(this.cRk);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cPB) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.singnallforum_progress));
        }
        switch (this.cRf) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.cPB) {
                    an.i(this.mProgress, i.e.btn_vip_all_sign);
                    an.c(this.cRg, i.e.icon_vip_sign);
                } else {
                    an.i(this.mProgress, i.e.btn_all_sign);
                    an.c(this.cRg, i.e.icon_all_sign);
                }
                this.aPs.setText(i.h.signallforum_begin);
                return;
            case 1:
                post(this.cRl);
                this.mProgress.setClickable(false);
                an.i(this.mProgress, i.e.bg_all_sign_conduct);
                if (this.cPB) {
                    an.c(this.cRg, i.e.icon_vip_sign);
                } else {
                    an.c(this.cRg, i.e.icon_all_sign);
                }
                this.aPs.setText(i.h.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.cRj);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.cPB) {
                    an.i(this.mProgress, i.e.bg_vip_sign_ok_d);
                    an.c(this.cRg, i.e.icon_vip_sign_ok);
                } else {
                    an.i(this.mProgress, i.e.bg_all_sign_ok_d);
                    an.c(this.cRg, i.e.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aPs.setText(i.h.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.cPB) {
                    an.c(this.cRg, i.e.icon_vip_sign);
                } else {
                    an.c(this.cRg, i.e.icon_all_sign);
                }
                an.i(this.mProgress, i.e.bg_all_sign_conduct);
                this.aPs.setText(i.h.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.cRf;
    }

    public void setSigning(int i) {
        if (this.cRf != 1 && this.cRf == 0) {
            this.mProgress.setProgress(i);
            this.cRf = 1;
            vt();
        }
    }

    public void atR() {
        if (this.cRf != 2) {
            this.cRf = 2;
            vt();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cRg;
    }

    public TextView getmStatus() {
        return this.aPs;
    }

    public TextView getMessage1() {
        return this.cRh;
    }

    public TextView getMessage2() {
        return this.cRi;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.cRf = i;
        vt();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cRg = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aPs = textView;
    }

    public void setmMessage1(TextView textView) {
        this.cRh = textView;
    }

    public void setmMessage2(TextView textView) {
        this.cRi = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.cPB = z;
        vt();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.cRj = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cRk = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cRl = runnable;
    }
}
