package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes3.dex */
public class j extends FrameLayout {
    private int duration;
    private TextView duy;
    private boolean gRl;
    private int gSY;
    private TextView gSZ;
    private TextView gTa;
    private TbImageView gTb;
    private RelativeLayout gTc;
    private Runnable gTd;
    private Runnable gTe;
    private Runnable gTf;
    private ImageView jt;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public j(Context context) {
        super(context);
        this.gSY = 0;
        this.duration = 2000;
        this.gTd = new Runnable() { // from class: com.baidu.tieba.signall.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.mScroller.computeScrollOffset()) {
                    int currX = j.this.mScroller.getCurrX();
                    if (currX < (j.this.mProgress.getMax() * 9) / 10 || j.this.gSY == 2) {
                        j.this.mProgress.setProgress(currX);
                        j.this.postDelayed(j.this.gTd, 16L);
                        return;
                    }
                    j.this.mScroller.forceFinished(true);
                    j.this.postDelayed(j.this.gTe, 2000L);
                    return;
                }
                int progress = j.this.mProgress.getProgress();
                int max = (j.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    j.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    j.this.post(this);
                }
            }
        };
        this.gTe = new Runnable() { // from class: com.baidu.tieba.signall.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.postDelayed(this, 2000L);
            }
        };
        this.gTf = new Runnable() { // from class: com.baidu.tieba.signall.j.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = com.baidu.adp.lib.util.l.dip2px(j.this.mContext, 6.0f);
                int dip2px2 = com.baidu.adp.lib.util.l.dip2px(j.this.mContext, 100.0f);
                int i = dip2px2 - (dip2px * 2);
                int i2 = (dip2px2 - i) / 2;
                j.this.mProgress.getProgressDrawable().setBounds(i2, i2, i2 + i, i + i2);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(d.h.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(d.g.signallforum_progress);
        this.jt = (ImageView) findViewById(d.g.signallforum_icon);
        this.duy = (TextView) findViewById(d.g.signallforun_status);
        this.gSZ = (TextView) findViewById(d.g.signallforun_message1);
        this.gTa = (TextView) findViewById(d.g.signallforun_message2);
        this.gTb = (TbImageView) findViewById(d.g.signallforum_banner_image);
        this.gTc = (RelativeLayout) findViewById(d.g.signallforum_banner_layout);
        Ea();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), d.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void Ea() {
        removeCallbacks(this.gTd);
        removeCallbacks(this.gTe);
        if (this.gRl) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.singnallforum_progress));
        }
        switch (this.gSY) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.gRl) {
                    aj.s(this.mProgress, d.f.btn_vip_all_sign);
                    aj.c(this.jt, d.f.icon_vip_sign);
                } else {
                    aj.s(this.mProgress, d.f.btn_all_sign);
                    aj.c(this.jt, d.f.icon_all_sign);
                }
                this.duy.setText(d.j.signallforum_begin);
                return;
            case 1:
                post(this.gTf);
                this.mProgress.setClickable(false);
                aj.s(this.mProgress, d.f.bg_all_sign_conduct);
                if (this.gRl) {
                    aj.c(this.jt, d.f.icon_vip_sign);
                } else {
                    aj.c(this.jt, d.f.icon_all_sign);
                }
                this.duy.setText(d.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.gTd);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.gRl) {
                    aj.s(this.mProgress, d.f.bg_vip_sign_ok_d);
                    aj.c(this.jt, d.f.icon_vip_sign_ok);
                } else {
                    aj.s(this.mProgress, d.f.bg_all_sign_ok_d);
                    aj.c(this.jt, d.f.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.duy.setText(d.j.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.gRl) {
                    aj.c(this.jt, d.f.icon_vip_sign);
                } else {
                    aj.c(this.jt, d.f.icon_all_sign);
                }
                aj.s(this.mProgress, d.f.bg_all_sign_conduct);
                this.duy.setText(d.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.gSY;
    }

    public void setSigning(int i) {
        if (this.gSY != 1 && this.gSY == 0) {
            this.mProgress.setProgress(i);
            this.gSY = 1;
            Ea();
        }
    }

    public void btN() {
        if (this.gSY != 2) {
            this.gSY = 2;
            Ea();
        }
    }

    public void a(final BaseActivity<?> baseActivity, final String str, final String str2) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.j.4
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.gTc.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                j.this.gTc.setVisibility(0);
                j.this.gTb.startLoad(str, 10, true);
                if (!StringUtils.isNull(str2)) {
                    j.this.gTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!aw.Du().a(baseActivity.getPageContext(), "", new String[]{str2}, false, null, true) && !aw.Du().eC(str2)) {
                                baseActivity.showToast(d.j.pluginstatus_tip_unknown);
                            } else {
                                TiebaStatic.log("c11758");
                            }
                        }
                    });
                }
            }
        }, 3000L);
    }

    public void btO() {
        this.gTc.setVisibility(8);
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public TextView getMessage1() {
        return this.gSZ;
    }

    public TextView getMessage2() {
        return this.gTa;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.gSY = i;
        Ea();
    }

    public void setHasPrivilege(boolean z) {
        this.gRl = z;
        Ea();
    }
}
