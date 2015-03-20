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
import com.baidu.tbadk.core.util.ba;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private TextView aGe;
    private boolean cdb;
    private int ceG;
    private ImageView ceH;
    private TextView ceI;
    private TextView ceJ;
    private Runnable ceK;
    private Runnable ceL;
    private Runnable ceM;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.ceG = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.ceK = new y(this);
        this.ceL = new z(this);
        this.ceM = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.signallforum_progress);
        this.ceH = (ImageView) findViewById(com.baidu.tieba.v.signallforum_icon);
        this.aGe = (TextView) findViewById(com.baidu.tieba.v.signallforun_status);
        this.ceI = (TextView) findViewById(com.baidu.tieba.v.signallforun_message1);
        this.ceJ = (TextView) findViewById(com.baidu.tieba.v.signallforun_message2);
        tM();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.u.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void tM() {
        removeCallbacks(this.ceK);
        removeCallbacks(this.ceL);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cdb) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.u.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.u.singnallforum_progress));
        }
        switch (this.ceG) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.cdb) {
                    ba.i(this.mProgress, com.baidu.tieba.u.btn_vip_all_sign);
                    ba.c(this.ceH, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    ba.i(this.mProgress, com.baidu.tieba.u.btn_all_sign);
                    ba.c(this.ceH, com.baidu.tieba.u.icon_all_sign);
                }
                this.aGe.setText(com.baidu.tieba.y.signallforum_begin);
                return;
            case 1:
                post(this.ceM);
                this.mProgress.setClickable(false);
                ba.i(this.mProgress, com.baidu.tieba.u.bg_all_sign_conduct);
                if (this.cdb) {
                    ba.c(this.ceH, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    ba.c(this.ceH, com.baidu.tieba.u.icon_all_sign);
                }
                this.aGe.setText(com.baidu.tieba.y.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.ceK);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.cdb) {
                    ba.i(this.mProgress, com.baidu.tieba.u.bg_vip_sign_ok_d);
                    ba.c(this.ceH, com.baidu.tieba.u.icon_vip_sign_ok);
                } else {
                    ba.i(this.mProgress, com.baidu.tieba.u.bg_all_sign_ok_d);
                    ba.c(this.ceH, com.baidu.tieba.u.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aGe.setText(com.baidu.tieba.y.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.cdb) {
                    ba.c(this.ceH, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    ba.c(this.ceH, com.baidu.tieba.u.icon_all_sign);
                }
                ba.i(this.mProgress, com.baidu.tieba.u.bg_all_sign_conduct);
                this.aGe.setText(com.baidu.tieba.y.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.ceG;
    }

    public void setSigning(int i) {
        if (this.ceG != 1 && this.ceG == 0) {
            this.mProgress.setProgress(i);
            this.ceG = 1;
            tM();
        }
    }

    public void aiR() {
        if (this.ceG != 2) {
            this.ceG = 2;
            tM();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.ceH;
    }

    public TextView getmStatus() {
        return this.aGe;
    }

    public TextView getMessage1() {
        return this.ceI;
    }

    public TextView getMessage2() {
        return this.ceJ;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.ceG = i;
        tM();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.ceH = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aGe = textView;
    }

    public void setmMessage1(TextView textView) {
        this.ceI = textView;
    }

    public void setmMessage2(TextView textView) {
        this.ceJ = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.cdb = z;
        tM();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.ceK = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.ceL = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.ceM = runnable;
    }
}
