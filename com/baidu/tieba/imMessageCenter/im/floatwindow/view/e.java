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
    private LinearLayout bLZ;
    private ScaleAnimation bMa;
    private ScaleAnimation bMb;
    private boolean bMc;
    private boolean bMd;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bMe;
    private Animation bMf;
    private Animation bMg;
    private Runnable bMh;
    private com.baidu.adp.lib.g.d bMi;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_tip_view, (ViewGroup) null));
        this.bMc = false;
        this.bMd = false;
        this.bMh = new f(this);
        this.bMi = new g(this);
        this.deleteView = (ImageView) this.bLr.findViewById(i.f.im_chat_tip_view_delete);
        this.bLZ = (LinearLayout) this.bLr.findViewById(i.f.im_chat_tip_holder);
        this.bMe = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e YL() {
        if (this.bMe.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bMe.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bMe;
    }

    public void b(Handler handler) {
        if (!Yw()) {
            Yx();
            if (handler != null) {
                handler.removeCallbacks(this.bMh);
                handler.post(this.bMh);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.bMh);
        this.deleteView.clearAnimation();
        this.bMd = false;
        this.bMc = false;
        if (this.bLZ.getWindowToken() != null) {
            this.bLZ.clearAnimation();
            this.bLZ.startAnimation(YQ());
            return;
        }
        Yy();
    }

    public void YM() {
        if (!this.bMd && !this.bMc) {
            this.bMc = true;
            this.deleteView.startAnimation(YO());
        }
    }

    public void YN() {
        if (!this.bMd && this.bMc) {
            this.bMc = false;
            this.deleteView.startAnimation(YP());
        }
    }

    private ScaleAnimation YO() {
        if (this.bMa == null) {
            this.bMa = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bMa.setDuration(150L);
            this.bMa.setFillAfter(true);
            this.bMa.setAnimationListener(this.bMi);
        }
        return this.bMa;
    }

    private ScaleAnimation YP() {
        if (this.bMb == null) {
            this.bMb = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.bMb.setDuration(150L);
            this.bMb.setFillAfter(true);
            this.bMb.setAnimationListener(this.bMi);
        }
        return this.bMb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YK() {
        if (this.bMf == null) {
            this.bMf = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_in_anim);
        }
        return this.bMf;
    }

    private Animation YQ() {
        if (this.bMg == null) {
            this.bMg = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_out_anim);
            this.bMg.setAnimationListener(this.bMi);
        }
        return this.bMg;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams Yv() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
