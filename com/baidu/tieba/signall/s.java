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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.Random;
/* loaded from: classes.dex */
public class s extends FrameLayout {
    private TextView aQl;
    private boolean cIh;
    private int cJL;
    private ImageView cJM;
    private TextView cJN;
    private TextView cJO;
    private Runnable cJP;
    private Runnable cJQ;
    private Runnable cJR;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public s(Context context) {
        super(context);
        this.cJL = 0;
        this.duration = 2000;
        this.cJP = new t(this);
        this.cJQ = new u(this);
        this.cJR = new v(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(i.g.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(i.f.signallforum_progress);
        this.cJM = (ImageView) findViewById(i.f.signallforum_icon);
        this.aQl = (TextView) findViewById(i.f.signallforun_status);
        this.cJN = (TextView) findViewById(i.f.signallforun_message1);
        this.cJO = (TextView) findViewById(i.f.signallforun_message2);
        vE();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i.e.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void vE() {
        removeCallbacks(this.cJP);
        removeCallbacks(this.cJQ);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cIh) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.singnallforum_progress));
        }
        switch (this.cJL) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.cIh) {
                    al.h(this.mProgress, i.e.btn_vip_all_sign);
                    al.c(this.cJM, i.e.icon_vip_sign);
                } else {
                    al.h(this.mProgress, i.e.btn_all_sign);
                    al.c(this.cJM, i.e.icon_all_sign);
                }
                this.aQl.setText(i.h.signallforum_begin);
                return;
            case 1:
                post(this.cJR);
                this.mProgress.setClickable(false);
                al.h(this.mProgress, i.e.bg_all_sign_conduct);
                if (this.cIh) {
                    al.c(this.cJM, i.e.icon_vip_sign);
                } else {
                    al.c(this.cJM, i.e.icon_all_sign);
                }
                this.aQl.setText(i.h.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.cJP);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.cIh) {
                    al.h(this.mProgress, i.e.bg_vip_sign_ok_d);
                    al.c(this.cJM, i.e.icon_vip_sign_ok);
                } else {
                    al.h(this.mProgress, i.e.bg_all_sign_ok_d);
                    al.c(this.cJM, i.e.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aQl.setText(i.h.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.cIh) {
                    al.c(this.cJM, i.e.icon_vip_sign);
                } else {
                    al.c(this.cJM, i.e.icon_all_sign);
                }
                al.h(this.mProgress, i.e.bg_all_sign_conduct);
                this.aQl.setText(i.h.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.cJL;
    }

    public void setSigning(int i) {
        if (this.cJL != 1 && this.cJL == 0) {
            this.mProgress.setProgress(i);
            this.cJL = 1;
            vE();
        }
    }

    public void arB() {
        if (this.cJL != 2) {
            this.cJL = 2;
            vE();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cJM;
    }

    public TextView getmStatus() {
        return this.aQl;
    }

    public TextView getMessage1() {
        return this.cJN;
    }

    public TextView getMessage2() {
        return this.cJO;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.cJL = i;
        vE();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cJM = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aQl = textView;
    }

    public void setmMessage1(TextView textView) {
        this.cJN = textView;
    }

    public void setmMessage2(TextView textView) {
        this.cJO = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.cIh = z;
        vE();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.cJP = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cJQ = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cJR = runnable;
    }
}
