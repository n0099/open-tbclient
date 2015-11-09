package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private Animation bMA;
    private Animation bMB;
    private Runnable bMC;
    private com.baidu.adp.lib.g.d bMD;
    private LinearLayout bMu;
    private ScaleAnimation bMv;
    private ScaleAnimation bMw;
    private boolean bMx;
    private boolean bMy;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bMz;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_tip_view, (ViewGroup) null));
        this.bMx = false;
        this.bMy = false;
        this.bMC = new f(this);
        this.bMD = new g(this);
        this.deleteView = (ImageView) this.bLM.findViewById(i.f.im_chat_tip_view_delete);
        this.bMu = (LinearLayout) this.bLM.findViewById(i.f.im_chat_tip_holder);
        this.bMz = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e Zc() {
        if (this.bMz.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bMz.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bMz;
    }

    public void b(Handler handler) {
        if (!YN()) {
            YO();
            if (handler != null) {
                handler.removeCallbacks(this.bMC);
                handler.post(this.bMC);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.bMC);
        this.deleteView.clearAnimation();
        this.bMy = false;
        this.bMx = false;
        if (this.bMu.getWindowToken() != null) {
            this.bMu.clearAnimation();
            this.bMu.startAnimation(Zh());
            return;
        }
        YP();
    }

    public void Zd() {
        if (!this.bMy && !this.bMx) {
            this.bMx = true;
            this.deleteView.startAnimation(Zf());
        }
    }

    public void Ze() {
        if (!this.bMy && this.bMx) {
            this.bMx = false;
            this.deleteView.startAnimation(Zg());
        }
    }

    private ScaleAnimation Zf() {
        if (this.bMv == null) {
            this.bMv = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bMv.setDuration(150L);
            this.bMv.setFillAfter(true);
            this.bMv.setAnimationListener(this.bMD);
        }
        return this.bMv;
    }

    private ScaleAnimation Zg() {
        if (this.bMw == null) {
            this.bMw = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.bMw.setDuration(150L);
            this.bMw.setFillAfter(true);
            this.bMw.setAnimationListener(this.bMD);
        }
        return this.bMw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Zb() {
        if (this.bMA == null) {
            this.bMA = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_in_anim);
        }
        return this.bMA;
    }

    private Animation Zh() {
        if (this.bMB == null) {
            this.bMB = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_out_anim);
            this.bMB.setAnimationListener(this.bMD);
        }
        return this.bMB;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams YM() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
