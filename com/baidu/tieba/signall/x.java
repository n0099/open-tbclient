package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private TextView axR;
    private boolean bQg;
    private int bRK;
    private ImageView bRL;
    private TextView bRM;
    private TextView bRN;
    private Runnable bRO;
    private Runnable bRP;
    private Runnable bRQ;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.bRK = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.bRO = new y(this);
        this.bRP = new z(this);
        this.bRQ = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.signallforum_progress);
        this.bRL = (ImageView) findViewById(com.baidu.tieba.w.signallforum_icon);
        this.axR = (TextView) findViewById(com.baidu.tieba.w.signallforun_status);
        this.bRM = (TextView) findViewById(com.baidu.tieba.w.signallforun_message1);
        this.bRN = (TextView) findViewById(com.baidu.tieba.w.signallforun_message2);
        qB();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.v.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void qB() {
        removeCallbacks(this.bRO);
        removeCallbacks(this.bRP);
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bQg) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.v.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.v.singnallforum_progress));
        }
        switch (this.bRK) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.bQg) {
                    bc.i(this.mProgress, com.baidu.tieba.v.btn_vip_all_sign);
                    bc.c(this.bRL, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    bc.i(this.mProgress, com.baidu.tieba.v.btn_all_sign);
                    bc.c(this.bRL, com.baidu.tieba.v.icon_all_sign);
                }
                this.axR.setText(com.baidu.tieba.z.signallforum_begin);
                return;
            case 1:
                post(this.bRQ);
                this.mProgress.setClickable(false);
                bc.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_conduct);
                if (this.bQg) {
                    bc.c(this.bRL, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    bc.c(this.bRL, com.baidu.tieba.v.icon_all_sign);
                }
                this.axR.setText(com.baidu.tieba.z.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.bRO);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.bQg) {
                    bc.i(this.mProgress, com.baidu.tieba.v.bg_vip_sign_ok_d);
                    bc.c(this.bRL, com.baidu.tieba.v.icon_vip_sign_ok);
                } else {
                    bc.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_ok_d);
                    bc.c(this.bRL, com.baidu.tieba.v.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.axR.setText(com.baidu.tieba.z.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.bQg) {
                    bc.c(this.bRL, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    bc.c(this.bRL, com.baidu.tieba.v.icon_all_sign);
                }
                bc.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_conduct);
                this.axR.setText(com.baidu.tieba.z.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.bRK;
    }

    public void setSigning(int i) {
        if (this.bRK != 1 && this.bRK == 0) {
            this.mProgress.setProgress(i);
            this.bRK = 1;
            qB();
        }
    }

    public void aea() {
        if (this.bRK != 2) {
            this.bRK = 2;
            qB();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.bRL;
    }

    public TextView getmStatus() {
        return this.axR;
    }

    public TextView getMessage1() {
        return this.bRM;
    }

    public TextView getMessage2() {
        return this.bRN;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.bRK = i;
        qB();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.bRL = imageView;
    }

    public void setmStatus(TextView textView) {
        this.axR = textView;
    }

    public void setmMessage1(TextView textView) {
        this.bRM = textView;
    }

    public void setmMessage2(TextView textView) {
        this.bRN = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.bQg = z;
        qB();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.bRO = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.bRP = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.bRQ = runnable;
    }
}
