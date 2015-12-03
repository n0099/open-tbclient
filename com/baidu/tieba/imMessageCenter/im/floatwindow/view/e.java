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
    private ScaleAnimation cbA;
    private boolean cbB;
    private boolean cbC;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e cbD;
    private Animation cbE;
    private Animation cbF;
    private Runnable cbG;
    private com.baidu.adp.lib.h.d cbH;
    private LinearLayout cby;
    private ScaleAnimation cbz;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(n.g.im_chat_tip_view, (ViewGroup) null));
        this.cbB = false;
        this.cbC = false;
        this.cbG = new f(this);
        this.cbH = new g(this);
        this.deleteView = (ImageView) this.caQ.findViewById(n.f.im_chat_tip_view_delete);
        this.cby = (LinearLayout) this.caQ.findViewById(n.f.im_chat_tip_holder);
        this.cbD = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e aci() {
        if (this.cbD.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.cbD.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.cbD;
    }

    public void b(Handler handler) {
        if (!abT()) {
            abU();
            if (handler != null) {
                handler.removeCallbacks(this.cbG);
                handler.post(this.cbG);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.cbG);
        this.deleteView.clearAnimation();
        this.cbC = false;
        this.cbB = false;
        if (this.cby.getWindowToken() != null) {
            this.cby.clearAnimation();
            this.cby.startAnimation(acn());
            return;
        }
        abV();
    }

    public void acj() {
        if (!this.cbC && !this.cbB) {
            this.cbB = true;
            this.deleteView.startAnimation(acl());
        }
    }

    public void ack() {
        if (!this.cbC && this.cbB) {
            this.cbB = false;
            this.deleteView.startAnimation(acm());
        }
    }

    private ScaleAnimation acl() {
        if (this.cbz == null) {
            this.cbz = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.cbz.setDuration(150L);
            this.cbz.setFillAfter(true);
            this.cbz.setAnimationListener(this.cbH);
        }
        return this.cbz;
    }

    private ScaleAnimation acm() {
        if (this.cbA == null) {
            this.cbA = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.cbA.setDuration(150L);
            this.cbA.setFillAfter(true);
            this.cbA.setAnimationListener(this.cbH);
        }
        return this.cbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ach() {
        if (this.cbE == null) {
            this.cbE = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), n.a.float_window_tip_in_anim);
        }
        return this.cbE;
    }

    private Animation acn() {
        if (this.cbF == null) {
            this.cbF = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), n.a.float_window_tip_out_anim);
            this.cbF.setAnimationListener(this.cbH);
        }
        return this.cbF;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams abS() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
