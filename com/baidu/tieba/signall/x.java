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
    private ProgressBar bDI;
    private TextView bbq;
    private ImageView dsV;
    private int duration;
    private boolean eiv;
    private int ekh;
    private TextView eki;
    private TextView ekj;
    private Runnable ekk;
    private Runnable ekl;
    private Runnable ekm;
    private Context mContext;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.ekh = 0;
        this.duration = 2000;
        this.ekk = new y(this);
        this.ekl = new z(this);
        this.ekm = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(t.h.signallforum_progress_view, this);
        this.bDI = (ProgressBar) findViewById(t.g.signallforum_progress);
        this.dsV = (ImageView) findViewById(t.g.signallforum_icon);
        this.bbq = (TextView) findViewById(t.g.signallforun_status);
        this.eki = (TextView) findViewById(t.g.signallforun_message1);
        this.ekj = (TextView) findViewById(t.g.signallforun_message2);
        uY();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), t.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void uY() {
        removeCallbacks(this.ekk);
        removeCallbacks(this.ekl);
        TbadkCoreApplication.m11getInst().getSkinType();
        if (this.eiv) {
            this.bDI.setProgressDrawable(getResources().getDrawable(t.f.vip_singnallforum_progress));
        } else {
            this.bDI.setProgressDrawable(getResources().getDrawable(t.f.singnallforum_progress));
        }
        switch (this.ekh) {
            case 0:
                this.bDI.setClickable(true);
                this.bDI.setProgress(0);
                this.bDI.setSecondaryProgress(0);
                if (this.eiv) {
                    at.k(this.bDI, t.f.btn_vip_all_sign);
                    at.c(this.dsV, t.f.icon_vip_sign);
                } else {
                    at.k(this.bDI, t.f.btn_all_sign);
                    at.c(this.dsV, t.f.icon_all_sign);
                }
                this.bbq.setText(t.j.signallforum_begin);
                return;
            case 1:
                post(this.ekm);
                this.bDI.setClickable(false);
                at.k(this.bDI, t.f.bg_all_sign_conduct);
                if (this.eiv) {
                    at.c(this.dsV, t.f.icon_vip_sign);
                } else {
                    at.c(this.dsV, t.f.icon_all_sign);
                }
                this.bbq.setText(t.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.bDI.getMax()) / 100;
                if (nextInt - this.bDI.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.bDI.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.bDI.getProgress(), 0, nextInt - this.bDI.getProgress(), 0, this.duration);
                }
                post(this.ekk);
                return;
            case 2:
                this.bDI.setClickable(true);
                if (this.eiv) {
                    at.k(this.bDI, t.f.bg_vip_sign_ok_d);
                    at.c(this.dsV, t.f.icon_vip_sign_ok);
                } else {
                    at.k(this.bDI, t.f.bg_all_sign_ok_d);
                    at.c(this.dsV, t.f.icon_all_sign_ok);
                }
                this.bDI.setProgress(0);
                this.bbq.setText(t.j.signallforum_success);
                return;
            case 3:
                this.bDI.setClickable(false);
                if (this.eiv) {
                    at.c(this.dsV, t.f.icon_vip_sign);
                } else {
                    at.c(this.dsV, t.f.icon_all_sign);
                }
                at.k(this.bDI, t.f.bg_all_sign_conduct);
                this.bbq.setText(t.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.ekh;
    }

    public void setSigning(int i) {
        if (this.ekh != 1 && this.ekh == 0) {
            this.bDI.setProgress(i);
            this.ekh = 1;
            uY();
        }
    }

    public void aQA() {
        if (this.ekh != 2) {
            this.ekh = 2;
            uY();
        }
    }

    public ProgressBar getProgressBar() {
        return this.bDI;
    }

    public ImageView getIcon() {
        return this.dsV;
    }

    public TextView getmStatus() {
        return this.bbq;
    }

    public TextView getMessage1() {
        return this.eki;
    }

    public TextView getMessage2() {
        return this.ekj;
    }

    public int getProgress() {
        return this.bDI.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.ekh = i;
        uY();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.bDI = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.dsV = imageView;
    }

    public void setmStatus(TextView textView) {
        this.bbq = textView;
    }

    public void setmMessage1(TextView textView) {
        this.eki = textView;
    }

    public void setmMessage2(TextView textView) {
        this.ekj = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.eiv = z;
        uY();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.ekk = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.ekl = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.ekm = runnable;
    }
}
