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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private TextView atL;
    private boolean bKh;
    private int bLK;
    private ImageView bLL;
    private TextView bLM;
    private TextView bLN;
    private Runnable bLO;
    private Runnable bLP;
    private Runnable bLQ;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.bLK = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.bLO = new y(this);
        this.bLP = new z(this);
        this.bLQ = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.signallforum_progress);
        this.bLL = (ImageView) findViewById(com.baidu.tieba.v.signallforum_icon);
        this.atL = (TextView) findViewById(com.baidu.tieba.v.signallforun_status);
        this.bLM = (TextView) findViewById(com.baidu.tieba.v.signallforun_message1);
        this.bLN = (TextView) findViewById(com.baidu.tieba.v.signallforun_message2);
        nx();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.u.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void nx() {
        removeCallbacks(this.bLO);
        removeCallbacks(this.bLP);
        TbadkApplication.m251getInst().getSkinType();
        if (this.bKh) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.u.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.u.singnallforum_progress));
        }
        switch (this.bLK) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.bKh) {
                    aw.h(this.mProgress, com.baidu.tieba.u.btn_vip_all_sign);
                    aw.c(this.bLL, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    aw.h(this.mProgress, com.baidu.tieba.u.btn_all_sign);
                    aw.c(this.bLL, com.baidu.tieba.u.icon_all_sign);
                }
                this.atL.setText(com.baidu.tieba.y.signallforum_begin);
                return;
            case 1:
                post(this.bLQ);
                this.mProgress.setClickable(false);
                aw.h(this.mProgress, com.baidu.tieba.u.bg_all_sign_conduct);
                if (this.bKh) {
                    aw.c(this.bLL, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    aw.c(this.bLL, com.baidu.tieba.u.icon_all_sign);
                }
                this.atL.setText(com.baidu.tieba.y.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.bLO);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.bKh) {
                    aw.h(this.mProgress, com.baidu.tieba.u.bg_vip_sign_ok_d);
                    aw.c(this.bLL, com.baidu.tieba.u.icon_vip_sign_ok);
                } else {
                    aw.h(this.mProgress, com.baidu.tieba.u.bg_all_sign_ok_d);
                    aw.c(this.bLL, com.baidu.tieba.u.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.atL.setText(com.baidu.tieba.y.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.bKh) {
                    aw.c(this.bLL, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    aw.c(this.bLL, com.baidu.tieba.u.icon_all_sign);
                }
                aw.h(this.mProgress, com.baidu.tieba.u.bg_all_sign_conduct);
                this.atL.setText(com.baidu.tieba.y.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.bLK;
    }

    public void setSigning(int i) {
        if (this.bLK != 1 && this.bLK == 0) {
            this.mProgress.setProgress(i);
            this.bLK = 1;
            nx();
        }
    }

    public void adf() {
        if (this.bLK != 2) {
            this.bLK = 2;
            nx();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.bLL;
    }

    public TextView getmStatus() {
        return this.atL;
    }

    public TextView getMessage1() {
        return this.bLM;
    }

    public TextView getMessage2() {
        return this.bLN;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.bLK = i;
        nx();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.bLL = imageView;
    }

    public void setmStatus(TextView textView) {
        this.atL = textView;
    }

    public void setmMessage1(TextView textView) {
        this.bLM = textView;
    }

    public void setmMessage2(TextView textView) {
        this.bLN = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.bKh = z;
        nx();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.bLO = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.bLP = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.bLQ = runnable;
    }
}
