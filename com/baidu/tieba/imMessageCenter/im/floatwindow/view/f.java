package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.imMessageCenter.im.floatwindow.o {
    private LinearLayout brj;
    private ScaleAnimation brk;
    private ScaleAnimation brl;
    private boolean brm;
    private boolean brn;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j bro;
    private Animation brp;
    private Animation brq;
    private Runnable brr;
    private com.baidu.adp.lib.g.e brs;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.im_chat_tip_view, null));
        this.brm = false;
        this.brn = false;
        this.brr = new g(this);
        this.brs = new h(this);
        this.deleteView = (ImageView) this.bqC.findViewById(com.baidu.tieba.v.im_chat_tip_view_delete);
        this.brj = (LinearLayout) this.bqC.findViewById(com.baidu.tieba.v.im_chat_tip_holder);
        this.bro = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j UP() {
        if (this.bro.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bro.u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bro;
    }

    public void b(Handler handler) {
        if (!UA()) {
            UB();
            if (handler != null) {
                handler.removeCallbacks(this.brr);
                handler.post(this.brr);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.brr);
        this.deleteView.clearAnimation();
        this.brn = false;
        this.brm = false;
        if (this.brj.getWindowToken() != null) {
            this.brj.clearAnimation();
            this.brj.startAnimation(UU());
            return;
        }
        UC();
    }

    public void UQ() {
        if (!this.brn && !this.brm) {
            this.brm = true;
            this.deleteView.startAnimation(US());
        }
    }

    public void UR() {
        if (!this.brn && this.brm) {
            this.brm = false;
            this.deleteView.startAnimation(UT());
        }
    }

    private ScaleAnimation US() {
        if (this.brk == null) {
            this.brk = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.brk.setDuration(150L);
            this.brk.setFillAfter(true);
            this.brk.setAnimationListener(this.brs);
        }
        return this.brk;
    }

    private ScaleAnimation UT() {
        if (this.brl == null) {
            this.brl = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.brl.setDuration(150L);
            this.brl.setFillAfter(true);
            this.brl.setAnimationListener(this.brs);
        }
        return this.brl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation UO() {
        if (this.brp == null) {
            this.brp = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.p.float_window_tip_in_anim);
        }
        return this.brp;
    }

    private Animation UU() {
        if (this.brq == null) {
            this.brq = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.p.float_window_tip_out_anim);
            this.brq.setAnimationListener(this.brs);
        }
        return this.brq;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams Uz() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
