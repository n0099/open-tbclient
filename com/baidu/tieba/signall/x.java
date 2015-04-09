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
    private TextView aGm;
    private boolean cdq;
    private int ceV;
    private ImageView ceW;
    private TextView ceX;
    private TextView ceY;
    private Runnable ceZ;
    private Runnable cfa;
    private Runnable cfb;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.ceV = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.ceZ = new y(this);
        this.cfa = new z(this);
        this.cfb = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.signallforum_progress);
        this.ceW = (ImageView) findViewById(com.baidu.tieba.v.signallforum_icon);
        this.aGm = (TextView) findViewById(com.baidu.tieba.v.signallforun_status);
        this.ceX = (TextView) findViewById(com.baidu.tieba.v.signallforun_message1);
        this.ceY = (TextView) findViewById(com.baidu.tieba.v.signallforun_message2);
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
        removeCallbacks(this.ceZ);
        removeCallbacks(this.cfa);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cdq) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.u.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.u.singnallforum_progress));
        }
        switch (this.ceV) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.cdq) {
                    ba.i(this.mProgress, com.baidu.tieba.u.btn_vip_all_sign);
                    ba.c(this.ceW, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    ba.i(this.mProgress, com.baidu.tieba.u.btn_all_sign);
                    ba.c(this.ceW, com.baidu.tieba.u.icon_all_sign);
                }
                this.aGm.setText(com.baidu.tieba.y.signallforum_begin);
                return;
            case 1:
                post(this.cfb);
                this.mProgress.setClickable(false);
                ba.i(this.mProgress, com.baidu.tieba.u.bg_all_sign_conduct);
                if (this.cdq) {
                    ba.c(this.ceW, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    ba.c(this.ceW, com.baidu.tieba.u.icon_all_sign);
                }
                this.aGm.setText(com.baidu.tieba.y.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.ceZ);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.cdq) {
                    ba.i(this.mProgress, com.baidu.tieba.u.bg_vip_sign_ok_d);
                    ba.c(this.ceW, com.baidu.tieba.u.icon_vip_sign_ok);
                } else {
                    ba.i(this.mProgress, com.baidu.tieba.u.bg_all_sign_ok_d);
                    ba.c(this.ceW, com.baidu.tieba.u.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aGm.setText(com.baidu.tieba.y.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.cdq) {
                    ba.c(this.ceW, com.baidu.tieba.u.icon_vip_sign);
                } else {
                    ba.c(this.ceW, com.baidu.tieba.u.icon_all_sign);
                }
                ba.i(this.mProgress, com.baidu.tieba.u.bg_all_sign_conduct);
                this.aGm.setText(com.baidu.tieba.y.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.ceV;
    }

    public void setSigning(int i) {
        if (this.ceV != 1 && this.ceV == 0) {
            this.mProgress.setProgress(i);
            this.ceV = 1;
            tM();
        }
    }

    public void ajg() {
        if (this.ceV != 2) {
            this.ceV = 2;
            tM();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.ceW;
    }

    public TextView getmStatus() {
        return this.aGm;
    }

    public TextView getMessage1() {
        return this.ceX;
    }

    public TextView getMessage2() {
        return this.ceY;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.ceV = i;
        tM();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.ceW = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aGm = textView;
    }

    public void setmMessage1(TextView textView) {
        this.ceX = textView;
    }

    public void setmMessage2(TextView textView) {
        this.ceY = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.cdq = z;
        tM();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.ceZ = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cfa = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cfb = runnable;
    }
}
