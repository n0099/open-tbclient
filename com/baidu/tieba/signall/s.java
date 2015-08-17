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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.Random;
/* loaded from: classes.dex */
public class s extends FrameLayout {
    private TextView aPX;
    private int cBn;
    private ImageView cBo;
    private TextView cBp;
    private TextView cBq;
    private Runnable cBr;
    private Runnable cBs;
    private Runnable cBt;
    private boolean czJ;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public s(Context context) {
        super(context);
        this.cBn = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.cBr = new t(this);
        this.cBs = new u(this);
        this.cBt = new v(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(i.g.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(i.f.signallforum_progress);
        this.cBo = (ImageView) findViewById(i.f.signallforum_icon);
        this.aPX = (TextView) findViewById(i.f.signallforun_status);
        this.cBp = (TextView) findViewById(i.f.signallforun_message1);
        this.cBq = (TextView) findViewById(i.f.signallforun_message2);
        vz();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i.e.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void vz() {
        removeCallbacks(this.cBr);
        removeCallbacks(this.cBs);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.czJ) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(i.e.singnallforum_progress));
        }
        switch (this.cBn) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.czJ) {
                    al.i(this.mProgress, i.e.btn_vip_all_sign);
                    al.c(this.cBo, i.e.icon_vip_sign);
                } else {
                    al.i(this.mProgress, i.e.btn_all_sign);
                    al.c(this.cBo, i.e.icon_all_sign);
                }
                this.aPX.setText(i.C0057i.signallforum_begin);
                return;
            case 1:
                post(this.cBt);
                this.mProgress.setClickable(false);
                al.i(this.mProgress, i.e.bg_all_sign_conduct);
                if (this.czJ) {
                    al.c(this.cBo, i.e.icon_vip_sign);
                } else {
                    al.c(this.cBo, i.e.icon_all_sign);
                }
                this.aPX.setText(i.C0057i.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.cBr);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.czJ) {
                    al.i(this.mProgress, i.e.bg_vip_sign_ok_d);
                    al.c(this.cBo, i.e.icon_vip_sign_ok);
                } else {
                    al.i(this.mProgress, i.e.bg_all_sign_ok_d);
                    al.c(this.cBo, i.e.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aPX.setText(i.C0057i.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.czJ) {
                    al.c(this.cBo, i.e.icon_vip_sign);
                } else {
                    al.c(this.cBo, i.e.icon_all_sign);
                }
                al.i(this.mProgress, i.e.bg_all_sign_conduct);
                this.aPX.setText(i.C0057i.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.cBn;
    }

    public void setSigning(int i) {
        if (this.cBn != 1 && this.cBn == 0) {
            this.mProgress.setProgress(i);
            this.cBn = 1;
            vz();
        }
    }

    public void ans() {
        if (this.cBn != 2) {
            this.cBn = 2;
            vz();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cBo;
    }

    public TextView getmStatus() {
        return this.aPX;
    }

    public TextView getMessage1() {
        return this.cBp;
    }

    public TextView getMessage2() {
        return this.cBq;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.cBn = i;
        vz();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cBo = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aPX = textView;
    }

    public void setmMessage1(TextView textView) {
        this.cBp = textView;
    }

    public void setmMessage2(TextView textView) {
        this.cBq = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.czJ = z;
        vz();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.cBr = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cBs = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cBt = runnable;
    }
}
