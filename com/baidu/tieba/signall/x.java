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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private ProgressBar aQj;
    private TextView bfC;
    private ImageView dqR;
    private int duration;
    private boolean efk;
    private int egV;
    private TextView egW;
    private TextView egX;
    private Runnable egY;
    private Runnable egZ;
    private Runnable eha;
    private Context mContext;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.egV = 0;
        this.duration = 2000;
        this.egY = new y(this);
        this.egZ = new z(this);
        this.eha = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(t.h.signallforum_progress_view, this);
        this.aQj = (ProgressBar) findViewById(t.g.signallforum_progress);
        this.dqR = (ImageView) findViewById(t.g.signallforum_icon);
        this.bfC = (TextView) findViewById(t.g.signallforun_status);
        this.egW = (TextView) findViewById(t.g.signallforun_message1);
        this.egX = (TextView) findViewById(t.g.signallforun_message2);
        xo();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), t.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void xo() {
        removeCallbacks(this.egY);
        removeCallbacks(this.egZ);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.efk) {
            this.aQj.setProgressDrawable(getResources().getDrawable(t.f.vip_singnallforum_progress));
        } else {
            this.aQj.setProgressDrawable(getResources().getDrawable(t.f.singnallforum_progress));
        }
        switch (this.egV) {
            case 0:
                this.aQj.setClickable(true);
                this.aQj.setProgress(0);
                this.aQj.setSecondaryProgress(0);
                if (this.efk) {
                    at.k(this.aQj, t.f.btn_vip_all_sign);
                    at.c(this.dqR, t.f.icon_vip_sign);
                } else {
                    at.k(this.aQj, t.f.btn_all_sign);
                    at.c(this.dqR, t.f.icon_all_sign);
                }
                this.bfC.setText(t.j.signallforum_begin);
                return;
            case 1:
                post(this.eha);
                this.aQj.setClickable(false);
                at.k(this.aQj, t.f.bg_all_sign_conduct);
                if (this.efk) {
                    at.c(this.dqR, t.f.icon_vip_sign);
                } else {
                    at.c(this.dqR, t.f.icon_all_sign);
                }
                this.bfC.setText(t.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.aQj.getMax()) / 100;
                if (nextInt - this.aQj.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.aQj.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.aQj.getProgress(), 0, nextInt - this.aQj.getProgress(), 0, this.duration);
                }
                post(this.egY);
                return;
            case 2:
                this.aQj.setClickable(true);
                if (this.efk) {
                    at.k(this.aQj, t.f.bg_vip_sign_ok_d);
                    at.c(this.dqR, t.f.icon_vip_sign_ok);
                } else {
                    at.k(this.aQj, t.f.bg_all_sign_ok_d);
                    at.c(this.dqR, t.f.icon_all_sign_ok);
                }
                this.aQj.setProgress(0);
                this.bfC.setText(t.j.signallforum_success);
                return;
            case 3:
                this.aQj.setClickable(false);
                if (this.efk) {
                    at.c(this.dqR, t.f.icon_vip_sign);
                } else {
                    at.c(this.dqR, t.f.icon_all_sign);
                }
                at.k(this.aQj, t.f.bg_all_sign_conduct);
                this.bfC.setText(t.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.egV;
    }

    public void setSigning(int i) {
        if (this.egV != 1 && this.egV == 0) {
            this.aQj.setProgress(i);
            this.egV = 1;
            xo();
        }
    }

    public void aQe() {
        if (this.egV != 2) {
            this.egV = 2;
            xo();
        }
    }

    public ProgressBar getProgressBar() {
        return this.aQj;
    }

    public ImageView getIcon() {
        return this.dqR;
    }

    public TextView getmStatus() {
        return this.bfC;
    }

    public TextView getMessage1() {
        return this.egW;
    }

    public TextView getMessage2() {
        return this.egX;
    }

    public int getProgress() {
        return this.aQj.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.egV = i;
        xo();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.aQj = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.dqR = imageView;
    }

    public void setmStatus(TextView textView) {
        this.bfC = textView;
    }

    public void setmMessage1(TextView textView) {
        this.egW = textView;
    }

    public void setmMessage2(TextView textView) {
        this.egX = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.efk = z;
        xo();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.egY = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.egZ = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.eha = runnable;
    }
}
