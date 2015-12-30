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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private ScaleAnimation cfA;
    private boolean cfB;
    private boolean cfC;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e cfD;
    private Animation cfE;
    private Animation cfF;
    private Runnable cfG;
    private com.baidu.adp.lib.h.d cfH;
    private LinearLayout cfy;
    private ScaleAnimation cfz;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(n.h.im_chat_tip_view, (ViewGroup) null));
        this.cfB = false;
        this.cfC = false;
        this.cfG = new f(this);
        this.cfH = new g(this);
        this.deleteView = (ImageView) this.ceR.findViewById(n.g.im_chat_tip_view_delete);
        this.cfy = (LinearLayout) this.ceR.findViewById(n.g.im_chat_tip_holder);
        this.cfD = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e adr() {
        if (this.cfD.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.cfD.F(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.cfD;
    }

    public void b(Handler handler) {
        if (!adc()) {
            add();
            if (handler != null) {
                handler.removeCallbacks(this.cfG);
                handler.post(this.cfG);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.cfG);
        this.deleteView.clearAnimation();
        this.cfC = false;
        this.cfB = false;
        if (this.cfy.getWindowToken() != null) {
            this.cfy.clearAnimation();
            this.cfy.startAnimation(adw());
            return;
        }
        ade();
    }

    public void ads() {
        if (!this.cfC && !this.cfB) {
            this.cfB = true;
            this.deleteView.startAnimation(adu());
        }
    }

    public void adt() {
        if (!this.cfC && this.cfB) {
            this.cfB = false;
            this.deleteView.startAnimation(adv());
        }
    }

    private ScaleAnimation adu() {
        if (this.cfz == null) {
            this.cfz = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.cfz.setDuration(150L);
            this.cfz.setFillAfter(true);
            this.cfz.setAnimationListener(this.cfH);
        }
        return this.cfz;
    }

    private ScaleAnimation adv() {
        if (this.cfA == null) {
            this.cfA = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.cfA.setDuration(150L);
            this.cfA.setFillAfter(true);
            this.cfA.setAnimationListener(this.cfH);
        }
        return this.cfA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation adq() {
        if (this.cfE == null) {
            this.cfE = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), n.a.float_window_tip_in_anim);
        }
        return this.cfE;
    }

    private Animation adw() {
        if (this.cfF == null) {
            this.cfF = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), n.a.float_window_tip_out_anim);
            this.cfF.setAnimationListener(this.cfH);
        }
        return this.cfF;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams adb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
