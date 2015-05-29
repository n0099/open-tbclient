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
import com.baidu.tbadk.core.util.ay;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private TextView aIu;
    private boolean chu;
    private int ciZ;
    private ImageView cja;
    private TextView cjb;
    private TextView cjc;
    private Runnable cjd;
    private Runnable cje;
    private Runnable cjf;
    private int duration;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public x(Context context) {
        super(context);
        this.ciZ = 0;
        this.duration = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.cjd = new y(this);
        this.cje = new z(this);
        this.cjf = new aa(this);
        init();
    }

    private void init() {
        this.mContext = getContext();
        com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.signallforum_progress);
        this.cja = (ImageView) findViewById(com.baidu.tieba.q.signallforum_icon);
        this.aIu = (TextView) findViewById(com.baidu.tieba.q.signallforun_status);
        this.cjb = (TextView) findViewById(com.baidu.tieba.q.signallforun_message1);
        this.cjc = (TextView) findViewById(com.baidu.tieba.q.signallforun_message2);
        uv();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.p.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void uv() {
        removeCallbacks(this.cjd);
        removeCallbacks(this.cje);
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.chu) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.p.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.p.singnallforum_progress));
        }
        switch (this.ciZ) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.chu) {
                    ay.i(this.mProgress, com.baidu.tieba.p.btn_vip_all_sign);
                    ay.c(this.cja, com.baidu.tieba.p.icon_vip_sign);
                } else {
                    ay.i(this.mProgress, com.baidu.tieba.p.btn_all_sign);
                    ay.c(this.cja, com.baidu.tieba.p.icon_all_sign);
                }
                this.aIu.setText(com.baidu.tieba.t.signallforum_begin);
                return;
            case 1:
                post(this.cjf);
                this.mProgress.setClickable(false);
                ay.i(this.mProgress, com.baidu.tieba.p.bg_all_sign_conduct);
                if (this.chu) {
                    ay.c(this.cja, com.baidu.tieba.p.icon_vip_sign);
                } else {
                    ay.c(this.cja, com.baidu.tieba.p.icon_all_sign);
                }
                this.aIu.setText(com.baidu.tieba.t.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.cjd);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.chu) {
                    ay.i(this.mProgress, com.baidu.tieba.p.bg_vip_sign_ok_d);
                    ay.c(this.cja, com.baidu.tieba.p.icon_vip_sign_ok);
                } else {
                    ay.i(this.mProgress, com.baidu.tieba.p.bg_all_sign_ok_d);
                    ay.c(this.cja, com.baidu.tieba.p.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.aIu.setText(com.baidu.tieba.t.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.chu) {
                    ay.c(this.cja, com.baidu.tieba.p.icon_vip_sign);
                } else {
                    ay.c(this.cja, com.baidu.tieba.p.icon_all_sign);
                }
                ay.i(this.mProgress, com.baidu.tieba.p.bg_all_sign_conduct);
                this.aIu.setText(com.baidu.tieba.t.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.ciZ;
    }

    public void setSigning(int i) {
        if (this.ciZ != 1 && this.ciZ == 0) {
            this.mProgress.setProgress(i);
            this.ciZ = 1;
            uv();
        }
    }

    public void akQ() {
        if (this.ciZ != 2) {
            this.ciZ = 2;
            uv();
        }
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public ImageView getIcon() {
        return this.cja;
    }

    public TextView getmStatus() {
        return this.aIu;
    }

    public TextView getMessage1() {
        return this.cjb;
    }

    public TextView getMessage2() {
        return this.cjc;
    }

    public int getProgress() {
        return this.mProgress.getProgress();
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.ciZ = i;
        uv();
    }

    public void setmContext(Context context) {
        this.mContext = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.mProgress = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.cja = imageView;
    }

    public void setmStatus(TextView textView) {
        this.aIu = textView;
    }

    public void setmMessage1(TextView textView) {
        this.cjb = textView;
    }

    public void setmMessage2(TextView textView) {
        this.cjc = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.chu = z;
        uv();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.cjd = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.cje = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.cjf = runnable;
    }
}
