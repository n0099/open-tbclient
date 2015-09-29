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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.Random;
/* loaded from: classes.dex */
public class s extends FrameLayout {
    private TextView aPh;
    private boolean cPc;
    private int cQG;
    private ImageView cQH;
    private TextView cQI;
    private TextView cQJ;
    private Runnable cQK;
    private Runnable cQL;
    private Runnable cQM;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public s(Context context) {
        super(context);
        this.cQG = 0;
        this.duration = 2000;
        this.cQK = new t(this);
        this.cQL = new u(this);
        this.cQM = new v(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(i.g.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(i.f.signallforum_progress);
        this.cQH = (ImageView) findViewById(i.f.signallforum_icon);
        this.aPh = (TextView) findViewById(i.f.signallforun_status);
        this.cQI = (TextView) findViewById(i.f.signallforun_message1);
        this.cQJ = (TextView) findViewById(i.f.signallforun_message2);
        vw();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i.e.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void vw() {
        removeCallbacks(this.cQK);
        removeCallbacks(this.cQL);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cPc) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.singnallforum_progress));
        }
        switch (this.cQG) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.cPc) {
                    am.i(this.mProgress, i.e.btn_vip_all_sign);
                    am.c(this.cQH, i.e.icon_vip_sign);
                } else {
                    am.i(this.mProgress, i.e.btn_all_sign);
                    am.c(this.cQH, i.e.icon_all_sign);
                }
                this.aPh.setText(i.h.signallforum_begin);
                return;
            case 1:
                post(this.cQM);
                this.mProgress.setClickable(false);
                am.i(this.mProgress, i.e.bg_all_sign_conduct);
                if (this.cPc) {
                    am.c(this.cQH, i.e.icon_vip_sign);
                } else {
                    am.c(this.cQH, i.e.icon_all_sign);
                }
                this.aPh.setText(i.h.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.cQK);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.cPc) {
                    am.i(this.mProgress, i.e.bg_vip_sign_ok_d);
                    am.c(this.cQH, i.e.icon_vip_sign_ok);
                } else {
                    am.i(this.mProgress, i.e.bg_all_sign_ok_d);
                    am.c(this.cQH, i.e.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aPh.setText(i.h.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.cPc) {
                    am.c(this.cQH, i.e.icon_vip_sign);
                } else {
                    am.c(this.cQH, i.e.icon_all_sign);
                }
                am.i(this.mProgress, i.e.bg_all_sign_conduct);
                this.aPh.setText(i.h.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.cQG;
    }

    public void setSigning(int i) {
        if (this.cQG != 1 && this.cQG == 0) {
            this.mProgress.setProgress(i);
            this.cQG = 1;
            vw();
        }
    }

    public void atP() {
        if (this.cQG != 2) {
            this.cQG = 2;
            vw();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cQH;
    }

    public TextView getmStatus() {
        return this.aPh;
    }

    public TextView getMessage1() {
        return this.cQI;
    }

    public TextView getMessage2() {
        return this.cQJ;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.cQG = i;
        vw();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cQH = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aPh = textView;
    }

    public void setmMessage1(TextView textView) {
        this.cQI = textView;
    }

    public void setmMessage2(TextView textView) {
        this.cQJ = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.cPc = z;
        vw();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.cQK = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cQL = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cQM = runnable;
    }
}
