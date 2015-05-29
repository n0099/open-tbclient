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
    private LinearLayout bul;
    private ScaleAnimation bum;
    private ScaleAnimation bun;
    private boolean buo;
    private boolean bup;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j buq;
    private Animation bur;
    private Animation bus;
    private Runnable but;
    private com.baidu.adp.lib.g.e buu;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.im_chat_tip_view, null));
        this.buo = false;
        this.bup = false;
        this.but = new g(this);
        this.buu = new h(this);
        this.deleteView = (ImageView) this.btC.findViewById(com.baidu.tieba.q.im_chat_tip_view_delete);
        this.bul = (LinearLayout) this.btC.findViewById(com.baidu.tieba.q.im_chat_tip_holder);
        this.buq = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j Wt() {
        if (this.buq.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.buq.u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.buq;
    }

    public void b(Handler handler) {
        if (!We()) {
            Wf();
            if (handler != null) {
                handler.removeCallbacks(this.but);
                handler.post(this.but);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.but);
        this.deleteView.clearAnimation();
        this.bup = false;
        this.buo = false;
        if (this.bul.getWindowToken() != null) {
            this.bul.clearAnimation();
            this.bul.startAnimation(Wy());
            return;
        }
        Wg();
    }

    public void Wu() {
        if (!this.bup && !this.buo) {
            this.buo = true;
            this.deleteView.startAnimation(Ww());
        }
    }

    public void Wv() {
        if (!this.bup && this.buo) {
            this.buo = false;
            this.deleteView.startAnimation(Wx());
        }
    }

    private ScaleAnimation Ww() {
        if (this.bum == null) {
            this.bum = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bum.setDuration(150L);
            this.bum.setFillAfter(true);
            this.bum.setAnimationListener(this.buu);
        }
        return this.bum;
    }

    private ScaleAnimation Wx() {
        if (this.bun == null) {
            this.bun = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.bun.setDuration(150L);
            this.bun.setFillAfter(true);
            this.bun.setAnimationListener(this.buu);
        }
        return this.bun;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Ws() {
        if (this.bur == null) {
            this.bur = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.k.float_window_tip_in_anim);
        }
        return this.bur;
    }

    private Animation Wy() {
        if (this.bus == null) {
            this.bus = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.k.float_window_tip_out_anim);
            this.bus.setAnimationListener(this.buu);
        }
        return this.bus;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams Wd() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
