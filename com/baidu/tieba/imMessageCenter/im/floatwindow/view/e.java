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
    private LinearLayout cjX;
    private ImageView cjY;
    private ScaleAnimation cjZ;
    private ScaleAnimation cka;
    private boolean ckb;
    private boolean ckc;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e ckd;
    private Animation cke;
    private Animation ckf;
    private Runnable ckg;
    private com.baidu.adp.lib.h.d ckh;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_tip_view, (ViewGroup) null));
        this.ckb = false;
        this.ckc = false;
        this.ckg = new f(this);
        this.ckh = new g(this);
        this.cjY = (ImageView) this.cjq.findViewById(t.g.im_chat_tip_view_delete);
        this.cjX = (LinearLayout) this.cjq.findViewById(t.g.im_chat_tip_holder);
        this.ckd = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e agA() {
        if (this.ckd.isEmpty()) {
            int[] iArr = new int[2];
            this.cjY.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.cjY.getMeasuredHeight() / 2) + 15;
                this.ckd.E(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.ckd;
    }

    public void b(Handler handler) {
        if (!agl()) {
            agm();
            if (handler != null) {
                handler.removeCallbacks(this.ckg);
                handler.post(this.ckg);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.ckg);
        this.cjY.clearAnimation();
        this.ckc = false;
        this.ckb = false;
        if (this.cjX.getWindowToken() != null) {
            this.cjX.clearAnimation();
            this.cjX.startAnimation(agF());
            return;
        }
        agn();
    }

    public void agB() {
        if (!this.ckc && !this.ckb) {
            this.ckb = true;
            this.cjY.startAnimation(agD());
        }
    }

    public void agC() {
        if (!this.ckc && this.ckb) {
            this.ckb = false;
            this.cjY.startAnimation(agE());
        }
    }

    private ScaleAnimation agD() {
        if (this.cjZ == null) {
            this.cjZ = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.cjZ.setDuration(150L);
            this.cjZ.setFillAfter(true);
            this.cjZ.setAnimationListener(this.ckh);
        }
        return this.cjZ;
    }

    private ScaleAnimation agE() {
        if (this.cka == null) {
            this.cka = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.cka.setDuration(150L);
            this.cka.setFillAfter(true);
            this.cka.setAnimationListener(this.ckh);
        }
        return this.cka;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation agz() {
        if (this.cke == null) {
            this.cke = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.float_window_tip_in_anim);
        }
        return this.cke;
    }

    private Animation agF() {
        if (this.ckf == null) {
            this.ckf = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.float_window_tip_out_anim);
            this.ckf.setAnimationListener(this.ckh);
        }
        return this.ckf;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams agk() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
