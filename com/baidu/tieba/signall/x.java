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
import com.baidu.tbadk.TbadkApplication;
import java.util.Random;
/* loaded from: classes.dex */
public class x extends FrameLayout {
    private int a;
    private Context b;
    private ProgressBar c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private Scroller h;
    private int i;
    private boolean j;
    private Runnable k;
    private Runnable l;
    private Runnable m;

    public x(Context context) {
        super(context);
        this.a = 0;
        this.i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        this.k = new y(this);
        this.l = new z(this);
        this.m = new aa(this);
        c();
    }

    private void c() {
        this.b = getContext();
        com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.signallforum_progress_view, this);
        this.c = (ProgressBar) findViewById(com.baidu.tieba.u.signallforum_progress);
        this.d = (ImageView) findViewById(com.baidu.tieba.u.signallforum_icon);
        this.e = (TextView) findViewById(com.baidu.tieba.u.signallforun_status);
        this.f = (TextView) findViewById(com.baidu.tieba.u.signallforun_message1);
        this.g = (TextView) findViewById(com.baidu.tieba.u.signallforun_message2);
        a();
        this.h = new Scroller(this.b, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void a() {
        removeCallbacks(this.k);
        removeCallbacks(this.l);
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        if (this.j) {
            this.c.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.t.vip_singnallforum_progress));
        } else {
            this.c.setProgressDrawable(getResources().getDrawable(com.baidu.tieba.t.singnallforum_progress));
        }
        switch (this.a) {
            case 0:
                this.c.setClickable(true);
                this.c.setProgress(0);
                this.c.setSecondaryProgress(0);
                if (this.j) {
                    this.c.setBackgroundResource(z ? com.baidu.tieba.t.btn_vip_all_sign_1 : com.baidu.tieba.t.btn_vip_all_sign);
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_vip_sign_1 : com.baidu.tieba.t.icon_vip_sign);
                } else {
                    this.c.setBackgroundResource(z ? com.baidu.tieba.t.btn_all_sign_1 : com.baidu.tieba.t.btn_all_sign);
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_all_sign_1 : com.baidu.tieba.t.icon_all_sign);
                }
                this.e.setText(com.baidu.tieba.x.signallforum_begin);
                return;
            case 1:
                post(this.m);
                this.c.setClickable(false);
                this.c.setBackgroundResource(z ? com.baidu.tieba.t.bg_all_sign_conduct_1 : com.baidu.tieba.t.bg_all_sign_conduct);
                if (this.j) {
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_vip_sign_1 : com.baidu.tieba.t.icon_vip_sign);
                } else {
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_all_sign_1 : com.baidu.tieba.t.icon_all_sign);
                }
                this.e.setText(com.baidu.tieba.x.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.c.getMax()) / 100;
                if (nextInt - this.c.getProgress() < 0) {
                    this.h.startScroll(nextInt, 0, this.c.getProgress() - nextInt, 0, this.i);
                } else {
                    this.h.startScroll(this.c.getProgress(), 0, nextInt - this.c.getProgress(), 0, this.i);
                }
                post(this.k);
                return;
            case 2:
                this.c.setClickable(true);
                if (this.j) {
                    this.c.setBackgroundResource(z ? com.baidu.tieba.t.bg_vip_sign_ok_d_1 : com.baidu.tieba.t.bg_vip_sign_ok_d);
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_vip_sign_ok_1 : com.baidu.tieba.t.icon_vip_sign_ok);
                } else {
                    this.c.setBackgroundResource(z ? com.baidu.tieba.t.bg_all_sign_ok_d_1 : com.baidu.tieba.t.bg_all_sign_ok_d);
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_all_sign_ok_1 : com.baidu.tieba.t.icon_all_sign_ok);
                }
                this.c.setProgress(0);
                this.e.setText(com.baidu.tieba.x.signallforum_success);
                return;
            case 3:
                this.c.setClickable(false);
                if (this.j) {
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_vip_sign_1 : com.baidu.tieba.t.icon_vip_sign);
                } else {
                    this.d.setImageResource(z ? com.baidu.tieba.t.icon_all_sign_1 : com.baidu.tieba.t.icon_all_sign);
                }
                this.c.setBackgroundResource(z ? com.baidu.tieba.t.bg_all_sign_conduct_1 : com.baidu.tieba.t.bg_all_sign_conduct);
                this.e.setText(com.baidu.tieba.x.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.a;
    }

    public void setSigning(int i) {
        if (this.a != 1 && this.a == 0) {
            this.c.setProgress(i);
            this.a = 1;
            a();
        }
    }

    public void b() {
        if (this.a != 2) {
            this.a = 2;
            a();
        }
    }

    public ProgressBar getProgressBar() {
        return this.c;
    }

    public ImageView getIcon() {
        return this.d;
    }

    public TextView getmStatus() {
        return this.e;
    }

    public TextView getMessage1() {
        return this.f;
    }

    public TextView getMessage2() {
        return this.g;
    }

    public int getProgress() {
        return this.c.getProgress();
    }

    public void setDuration(int i) {
        this.i = i;
    }

    public void setmCurrentStatus(int i) {
        this.a = i;
        a();
    }

    public void setmContext(Context context) {
        this.b = context;
    }

    public void setmProgress(ProgressBar progressBar) {
        this.c = progressBar;
    }

    public void setmIcon(ImageView imageView) {
        this.d = imageView;
    }

    public void setmStatus(TextView textView) {
        this.e = textView;
    }

    public void setmMessage1(TextView textView) {
        this.f = textView;
    }

    public void setmMessage2(TextView textView) {
        this.g = textView;
    }

    public void setmScroller(Scroller scroller) {
        this.h = scroller;
    }

    public void setHasPrivilege(boolean z) {
        this.j = z;
        a();
    }

    public void setProgressAnimation(Runnable runnable) {
        this.k = runnable;
    }

    public void setCheckRunnable(Runnable runnable) {
        this.l = runnable;
    }

    public void setChangeSizeRunnable(Runnable runnable) {
        this.m = runnable;
    }
}
