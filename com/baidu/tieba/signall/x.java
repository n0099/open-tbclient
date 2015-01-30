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
    private TextView axU;
    private boolean bQh;
    private int bRL;
    private ImageView bRM;
    private TextView bRN;
    private TextView bRO;
    private Runnable bRP;
    private Runnable bRQ;
    private Runnable bRR;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.bRL = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.bRP = new y(this);
        this.bRQ = new z(this);
        this.bRR = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.signallforum_progress);
        this.bRM = (ImageView) findViewById(com.baidu.tieba.w.signallforum_icon);
        this.axU = (TextView) findViewById(com.baidu.tieba.w.signallforun_status);
        this.bRN = (TextView) findViewById(com.baidu.tieba.w.signallforun_message1);
        this.bRO = (TextView) findViewById(com.baidu.tieba.w.signallforun_message2);
        qH();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.v.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void qH() {
        removeCallbacks(this.bRP);
        removeCallbacks(this.bRQ);
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bQh) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.v.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.v.singnallforum_progress));
        }
        switch (this.bRL) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.bQh) {
                    bc.i(this.mProgress, com.baidu.tieba.v.btn_vip_all_sign);
                    bc.c(this.bRM, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    bc.i(this.mProgress, com.baidu.tieba.v.btn_all_sign);
                    bc.c(this.bRM, com.baidu.tieba.v.icon_all_sign);
                }
                this.axU.setText(com.baidu.tieba.z.signallforum_begin);
                return;
            case 1:
                post(this.bRR);
                this.mProgress.setClickable(false);
                bc.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_conduct);
                if (this.bQh) {
                    bc.c(this.bRM, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    bc.c(this.bRM, com.baidu.tieba.v.icon_all_sign);
                }
                this.axU.setText(com.baidu.tieba.z.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.bRP);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.bQh) {
                    bc.i(this.mProgress, com.baidu.tieba.v.bg_vip_sign_ok_d);
                    bc.c(this.bRM, com.baidu.tieba.v.icon_vip_sign_ok);
                } else {
                    bc.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_ok_d);
                    bc.c(this.bRM, com.baidu.tieba.v.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.axU.setText(com.baidu.tieba.z.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.bQh) {
                    bc.c(this.bRM, com.baidu.tieba.v.icon_vip_sign);
                } else {
                    bc.c(this.bRM, com.baidu.tieba.v.icon_all_sign);
                }
                bc.i(this.mProgress, com.baidu.tieba.v.bg_all_sign_conduct);
                this.axU.setText(com.baidu.tieba.z.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.bRL;
    }

    public void setSigning(int i) {
        if (this.bRL != 1 && this.bRL == 0) {
            this.mProgress.setProgress(i);
            this.bRL = 1;
            qH();
        }
    }

    public void aef() {
        if (this.bRL != 2) {
            this.bRL = 2;
            qH();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.bRM;
    }

    public TextView getmStatus() {
        return this.axU;
    }

    public TextView getMessage1() {
        return this.bRN;
    }

    public TextView getMessage2() {
        return this.bRO;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.bRL = i;
        qH();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.bRM = imageView;
    }

    public void setmStatus(TextView textView) {
        this.axU = textView;
    }

    public void setmMessage1(TextView textView) {
        this.bRN = textView;
    }

    public void setmMessage2(TextView textView) {
        this.bRO = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.bQh = z;
        qH();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.bRP = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.bRQ = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.bRR = runnable;
    }
}
