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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private com.baidu.adp.lib.h.d cCN;
    private boolean dpA;
    private boolean dpB;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dpC;
    private Animation dpD;
    private Animation dpE;
    private Runnable dpF;
    private LinearLayout dpw;
    private ImageView dpx;
    private ScaleAnimation dpy;
    private ScaleAnimation dpz;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_tip_view, (ViewGroup) null));
        this.dpA = false;
        this.dpB = false;
        this.dpF = new f(this);
        this.cCN = new g(this);
        this.dpx = (ImageView) this.doO.findViewById(t.g.im_chat_tip_view_delete);
        this.dpw = (LinearLayout) this.doO.findViewById(t.g.im_chat_tip_holder);
        this.dpC = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e axQ() {
        if (this.dpC.isEmpty()) {
            int[] iArr = new int[2];
            this.dpx.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.dpx.getMeasuredHeight() / 2) + 15;
                this.dpC.H(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.dpC;
    }

    public void b(Handler handler) {
        if (!axB()) {
            axC();
            if (handler != null) {
                handler.removeCallbacks(this.dpF);
                handler.post(this.dpF);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.dpF);
        this.dpx.clearAnimation();
        this.dpB = false;
        this.dpA = false;
        if (this.dpw.getWindowToken() != null) {
            this.dpw.clearAnimation();
            this.dpw.startAnimation(axV());
            return;
        }
        axD();
    }

    public void axR() {
        if (!this.dpB && !this.dpA) {
            this.dpA = true;
            this.dpx.startAnimation(axT());
        }
    }

    public void axS() {
        if (!this.dpB && this.dpA) {
            this.dpA = false;
            this.dpx.startAnimation(axU());
        }
    }

    private ScaleAnimation axT() {
        if (this.dpy == null) {
            this.dpy = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.dpy.setDuration(150L);
            this.dpy.setFillAfter(true);
            this.dpy.setAnimationListener(this.cCN);
        }
        return this.dpy;
    }

    private ScaleAnimation axU() {
        if (this.dpz == null) {
            this.dpz = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.dpz.setDuration(150L);
            this.dpz.setFillAfter(true);
            this.dpz.setAnimationListener(this.cCN);
        }
        return this.dpz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation axP() {
        if (this.dpD == null) {
            this.dpD = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), t.a.float_window_tip_in_anim);
        }
        return this.dpD;
    }

    private Animation axV() {
        if (this.dpE == null) {
            this.dpE = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), t.a.float_window_tip_out_anim);
            this.dpE.setAnimationListener(this.cCN);
        }
        return this.dpE;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams axA() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
