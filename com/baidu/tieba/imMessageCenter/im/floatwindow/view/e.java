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
    private LinearLayout bIc;
    private ScaleAnimation bId;
    private ScaleAnimation bIe;
    private boolean bIf;
    private boolean bIg;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bIh;
    private Animation bIi;
    private Animation bIj;
    private Runnable bIk;
    private com.baidu.adp.lib.g.d bIl;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_tip_view, (ViewGroup) null));
        this.bIf = false;
        this.bIg = false;
        this.bIk = new f(this);
        this.bIl = new g(this);
        this.deleteView = (ImageView) this.bHu.findViewById(i.f.im_chat_tip_view_delete);
        this.bIc = (LinearLayout) this.bHu.findViewById(i.f.im_chat_tip_holder);
        this.bIh = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e Yb() {
        if (this.bIh.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bIh.s(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bIh;
    }

    public void b(Handler handler) {
        if (!XM()) {
            XN();
            if (handler != null) {
                handler.removeCallbacks(this.bIk);
                handler.post(this.bIk);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.bIk);
        this.deleteView.clearAnimation();
        this.bIg = false;
        this.bIf = false;
        if (this.bIc.getWindowToken() != null) {
            this.bIc.clearAnimation();
            this.bIc.startAnimation(Yg());
            return;
        }
        XO();
    }

    public void Yc() {
        if (!this.bIg && !this.bIf) {
            this.bIf = true;
            this.deleteView.startAnimation(Ye());
        }
    }

    public void Yd() {
        if (!this.bIg && this.bIf) {
            this.bIf = false;
            this.deleteView.startAnimation(Yf());
        }
    }

    private ScaleAnimation Ye() {
        if (this.bId == null) {
            this.bId = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bId.setDuration(150L);
            this.bId.setFillAfter(true);
            this.bId.setAnimationListener(this.bIl);
        }
        return this.bId;
    }

    private ScaleAnimation Yf() {
        if (this.bIe == null) {
            this.bIe = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.bIe.setDuration(150L);
            this.bIe.setFillAfter(true);
            this.bIe.setAnimationListener(this.bIl);
        }
        return this.bIe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Ya() {
        if (this.bIi == null) {
            this.bIi = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_in_anim);
        }
        return this.bIi;
    }

    private Animation Yg() {
        if (this.bIj == null) {
            this.bIj = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_out_anim);
            this.bIj.setAnimationListener(this.bIl);
        }
        return this.bIj;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams XL() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
