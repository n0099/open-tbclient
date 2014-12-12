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
import com.baidu.tbadk.core.util.ax;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private TextView awU;
    private boolean bOx;
    private int bQb;
    private TextView bQc;
    private TextView bQd;
    private Runnable bQe;
    private Runnable bQf;
    private Runnable bQg;
    private int duration;
    private Context mContext;
    private ImageView mIcon;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.bQb = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.bQe = new y(this);
        this.bQf = new z(this);
        this.bQg = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.signallforum_progress);
        this.mIcon = (ImageView) findViewById(com.baidu.tieba.w.signallforum_icon);
        this.awU = (TextView) findViewById(com.baidu.tieba.w.signallforun_status);
        this.bQc = (TextView) findViewById(com.baidu.tieba.w.signallforun_message1);
        this.bQd = (TextView) findViewById(com.baidu.tieba.w.signallforun_message2);
        qw();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.v.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void qw() {
        removeCallbacks(this.bQe);
        removeCallbacks(this.bQf);
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bOx) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.v.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.v.singnallforum_progress));
        }
        switch (this.bQb) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.bOx) {
                    ax.i(this.mProgress, com.baidu.tieba.v.btn_vip_all_sign);
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    ax.i(this.mProgress, com.baidu.tieba.v.btn_all_sign);
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_all_sign);
                }
                this.awU.setText(com.baidu.tieba.z.signallforum_begin);
                return;
            case 1:
                post(this.bQg);
                this.mProgress.setClickable(false);
                ax.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_conduct);
                if (this.bOx) {
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_all_sign);
                }
                this.awU.setText(com.baidu.tieba.z.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.bQe);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.bOx) {
                    ax.i(this.mProgress, com.baidu.tieba.v.bg_vip_sign_ok_d);
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_vip_sign_ok);
                } else {
                    ax.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_ok_d);
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.awU.setText(com.baidu.tieba.z.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.bOx) {
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    ax.c(this.mIcon, com.baidu.tieba.v.icon_all_sign);
                }
                ax.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_conduct);
                this.awU.setText(com.baidu.tieba.z.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.bQb;
    }

    public void setSigning(int i) {
        if (this.bQb != 1 && this.bQb == 0) {
            this.mProgress.setProgress(i);
            this.bQb = 1;
            qw();
        }
    }

    public void adB() {
        if (this.bQb != 2) {
            this.bQb = 2;
            qw();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.mIcon;
    }

    public TextView getmStatus() {
        return this.awU;
    }

    public TextView getMessage1() {
        return this.bQc;
    }

    public TextView getMessage2() {
        return this.bQd;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.bQb = i;
        qw();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.mIcon = imageView;
    }

    public void setmStatus(TextView textView) {
        this.awU = textView;
    }

    public void setmMessage1(TextView textView) {
        this.bQc = textView;
    }

    public void setmMessage2(TextView textView) {
        this.bQd = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.bOx = z;
        qw();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.bQe = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.bQf = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.bQg = runnable;
    }
}
