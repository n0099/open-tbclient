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
    private LinearLayout bum;
    private ScaleAnimation bun;
    private ScaleAnimation buo;
    private boolean bup;
    private boolean buq;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j bur;
    private Animation bus;
    private Animation but;
    private Runnable buu;
    private com.baidu.adp.lib.g.e buv;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.im_chat_tip_view, null));
        this.bup = false;
        this.buq = false;
        this.buu = new g(this);
        this.buv = new h(this);
        this.deleteView = (ImageView) this.btD.findViewById(com.baidu.tieba.q.im_chat_tip_view_delete);
        this.bum = (LinearLayout) this.btD.findViewById(com.baidu.tieba.q.im_chat_tip_holder);
        this.bur = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j Wu() {
        if (this.bur.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bur.u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bur;
    }

    public void b(Handler handler) {
        if (!Wf()) {
            Wg();
            if (handler != null) {
                handler.removeCallbacks(this.buu);
                handler.post(this.buu);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.buu);
        this.deleteView.clearAnimation();
        this.buq = false;
        this.bup = false;
        if (this.bum.getWindowToken() != null) {
            this.bum.clearAnimation();
            this.bum.startAnimation(Wz());
            return;
        }
        Wh();
    }

    public void Wv() {
        if (!this.buq && !this.bup) {
            this.bup = true;
            this.deleteView.startAnimation(Wx());
        }
    }

    public void Ww() {
        if (!this.buq && this.bup) {
            this.bup = false;
            this.deleteView.startAnimation(Wy());
        }
    }

    private ScaleAnimation Wx() {
        if (this.bun == null) {
            this.bun = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bun.setDuration(150L);
            this.bun.setFillAfter(true);
            this.bun.setAnimationListener(this.buv);
        }
        return this.bun;
    }

    private ScaleAnimation Wy() {
        if (this.buo == null) {
            this.buo = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.buo.setDuration(150L);
            this.buo.setFillAfter(true);
            this.buo.setAnimationListener(this.buv);
        }
        return this.buo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Wt() {
        if (this.bus == null) {
            this.bus = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.k.float_window_tip_in_anim);
        }
        return this.bus;
    }

    private Animation Wz() {
        if (this.but == null) {
            this.but = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.k.float_window_tip_out_anim);
            this.but.setAnimationListener(this.buv);
        }
        return this.but;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams We() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
