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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private com.baidu.adp.lib.h.d cIF;
    private LinearLayout dwA;
    private ImageView dwB;
    private ScaleAnimation dwC;
    private ScaleAnimation dwD;
    private boolean dwE;
    private boolean dwF;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dwG;
    private Animation dwH;
    private Animation dwI;
    private Runnable dwJ;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(r.h.im_chat_tip_view, (ViewGroup) null));
        this.dwE = false;
        this.dwF = false;
        this.dwJ = new f(this);
        this.cIF = new g(this);
        this.dwB = (ImageView) this.dvT.findViewById(r.g.im_chat_tip_view_delete);
        this.dwA = (LinearLayout) this.dvT.findViewById(r.g.im_chat_tip_holder);
        this.dwG = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e aAl() {
        if (this.dwG.isEmpty()) {
            int[] iArr = new int[2];
            this.dwB.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.dwB.getMeasuredHeight() / 2) + 15;
                this.dwG.J(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.dwG;
    }

    public void b(Handler handler) {
        if (!azX()) {
            azY();
            if (handler != null) {
                handler.removeCallbacks(this.dwJ);
                handler.post(this.dwJ);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.dwJ);
        this.dwB.clearAnimation();
        this.dwF = false;
        this.dwE = false;
        if (this.dwA.getWindowToken() != null) {
            this.dwA.clearAnimation();
            this.dwA.startAnimation(aAq());
            return;
        }
        azZ();
    }

    public void aAm() {
        if (!this.dwF && !this.dwE) {
            this.dwE = true;
            this.dwB.startAnimation(aAo());
        }
    }

    public void aAn() {
        if (!this.dwF && this.dwE) {
            this.dwE = false;
            this.dwB.startAnimation(aAp());
        }
    }

    private ScaleAnimation aAo() {
        if (this.dwC == null) {
            this.dwC = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.dwC.setDuration(150L);
            this.dwC.setFillAfter(true);
            this.dwC.setAnimationListener(this.cIF);
        }
        return this.dwC;
    }

    private ScaleAnimation aAp() {
        if (this.dwD == null) {
            this.dwD = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.dwD.setDuration(150L);
            this.dwD.setFillAfter(true);
            this.dwD.setAnimationListener(this.cIF);
        }
        return this.dwD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aAk() {
        if (this.dwH == null) {
            this.dwH = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.float_window_tip_in_anim);
        }
        return this.dwH;
    }

    private Animation aAq() {
        if (this.dwI == null) {
            this.dwI = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.float_window_tip_out_anim);
            this.dwI.setAnimationListener(this.cIF);
        }
        return this.dwI;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams azW() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
