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
public class s extends FrameLayout {
    private TextView aUD;
    private ImageView cIF;
    private boolean dpu;
    private int dqY;
    private TextView dqZ;
    private TextView dra;
    private Runnable drb;
    private Runnable drc;
    private Runnable drd;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public s(Context context) {
        super(context);
        this.dqY = 0;
        this.duration = 2000;
        this.drb = new t(this);
        this.drc = new u(this);
        this.drd = new v(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(n.g.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(n.f.signallforum_progress);
        this.cIF = (ImageView) findViewById(n.f.signallforum_icon);
        this.aUD = (TextView) findViewById(n.f.signallforun_status);
        this.dqZ = (TextView) findViewById(n.f.signallforun_message1);
        this.dra = (TextView) findViewById(n.f.signallforun_message2);
        wd();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), n.e.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void wd() {
        removeCallbacks(this.drb);
        removeCallbacks(this.drc);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.dpu) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(n.e.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(n.e.singnallforum_progress));
        }
        switch (this.dqY) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.dpu) {
                    as.i(this.mProgress, n.e.btn_vip_all_sign);
                    as.c(this.cIF, n.e.icon_vip_sign);
                } else {
                    as.i(this.mProgress, n.e.btn_all_sign);
                    as.c(this.cIF, n.e.icon_all_sign);
                }
                this.aUD.setText(n.i.signallforum_begin);
                return;
            case 1:
                post(this.drd);
                this.mProgress.setClickable(false);
                as.i(this.mProgress, n.e.bg_all_sign_conduct);
                if (this.dpu) {
                    as.c(this.cIF, n.e.icon_vip_sign);
                } else {
                    as.c(this.cIF, n.e.icon_all_sign);
                }
                this.aUD.setText(n.i.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.drb);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.dpu) {
                    as.i(this.mProgress, n.e.bg_vip_sign_ok_d);
                    as.c(this.cIF, n.e.icon_vip_sign_ok);
                } else {
                    as.i(this.mProgress, n.e.bg_all_sign_ok_d);
                    as.c(this.cIF, n.e.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aUD.setText(n.i.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.dpu) {
                    as.c(this.cIF, n.e.icon_vip_sign);
                } else {
                    as.c(this.cIF, n.e.icon_all_sign);
                }
                as.i(this.mProgress, n.e.bg_all_sign_conduct);
                this.aUD.setText(n.i.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.dqY;
    }

    public void setSigning(int i) {
        if (this.dqY != 1 && this.dqY == 0) {
            this.mProgress.setProgress(i);
            this.dqY = 1;
            wd();
        }
    }

    public void azZ() {
        if (this.dqY != 2) {
            this.dqY = 2;
            wd();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cIF;
    }

    public TextView getmStatus() {
        return this.aUD;
    }

    public TextView getMessage1() {
        return this.dqZ;
    }

    public TextView getMessage2() {
        return this.dra;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.dqY = i;
        wd();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cIF = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aUD = textView;
    }

    public void setmMessage1(TextView textView) {
        this.dqZ = textView;
    }

    public void setmMessage2(TextView textView) {
        this.dra = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.dpu = z;
        wd();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.drb = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.drc = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.drd = runnable;
    }
}
