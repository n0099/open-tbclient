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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private TextView aYD;
    private ImageView cMV;
    private int duration;
    private boolean dwG;
    private int dys;
    private TextView dyt;
    private TextView dyu;
    private Runnable dyv;
    private Runnable dyw;
    private Runnable dyx;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.dys = 0;
        this.duration = 2000;
        this.dyv = new y(this);
        this.dyw = new z(this);
        this.dyx = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(n.h.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(n.g.signallforum_progress);
        this.cMV = (ImageView) findViewById(n.g.signallforum_icon);
        this.aYD = (TextView) findViewById(n.g.signallforun_status);
        this.dyt = (TextView) findViewById(n.g.signallforun_message1);
        this.dyu = (TextView) findViewById(n.g.signallforun_message2);
        vN();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), n.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void vN() {
        removeCallbacks(this.dyv);
        removeCallbacks(this.dyw);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.dwG) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(n.f.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(n.f.singnallforum_progress));
        }
        switch (this.dys) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.dwG) {
                    as.i(this.mProgress, n.f.btn_vip_all_sign);
                    as.c(this.cMV, n.f.icon_vip_sign);
                } else {
                    as.i(this.mProgress, n.f.btn_all_sign);
                    as.c(this.cMV, n.f.icon_all_sign);
                }
                this.aYD.setText(n.j.signallforum_begin);
                return;
            case 1:
                post(this.dyx);
                this.mProgress.setClickable(false);
                as.i(this.mProgress, n.f.bg_all_sign_conduct);
                if (this.dwG) {
                    as.c(this.cMV, n.f.icon_vip_sign);
                } else {
                    as.c(this.cMV, n.f.icon_all_sign);
                }
                this.aYD.setText(n.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.dyv);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.dwG) {
                    as.i(this.mProgress, n.f.bg_vip_sign_ok_d);
                    as.c(this.cMV, n.f.icon_vip_sign_ok);
                } else {
                    as.i(this.mProgress, n.f.bg_all_sign_ok_d);
                    as.c(this.cMV, n.f.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aYD.setText(n.j.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.dwG) {
                    as.c(this.cMV, n.f.icon_vip_sign);
                } else {
                    as.c(this.cMV, n.f.icon_all_sign);
                }
                as.i(this.mProgress, n.f.bg_all_sign_conduct);
                this.aYD.setText(n.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.dys;
    }

    public void setSigning(int i) {
        if (this.dys != 1 && this.dys == 0) {
            this.mProgress.setProgress(i);
            this.dys = 1;
            vN();
        }
    }

    public void aCh() {
        if (this.dys != 2) {
            this.dys = 2;
            vN();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cMV;
    }

    public TextView getmStatus() {
        return this.aYD;
    }

    public TextView getMessage1() {
        return this.dyt;
    }

    public TextView getMessage2() {
        return this.dyu;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.dys = i;
        vN();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cMV = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aYD = textView;
    }

    public void setmMessage1(TextView textView) {
        this.dyt = textView;
    }

    public void setmMessage2(TextView textView) {
        this.dyu = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.dwG = z;
        vN();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.dyv = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.dyw = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.dyx = runnable;
    }
}
