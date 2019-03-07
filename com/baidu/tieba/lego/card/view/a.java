package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.activity.LegoListFragment;
/* loaded from: classes2.dex */
public class a {
    private Animation aeX;
    private Animation aeY;
    private l gEX;
    private View gHI;
    private Animation gHJ;
    private LegoListFragment gHP;
    private InterfaceC0269a gHQ;
    private TbPageContext<?> mContext;
    private boolean gHK = false;
    private boolean gHL = false;
    private boolean gHM = false;
    private boolean gHN = false;
    private boolean gHO = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.bAr() && a.this.gHI.getAlpha() == 0.0f) {
                a.this.bAm();
            }
        }
    };
    private Runnable gHR = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gHP != null && a.this.gHP.bzC() == 1) {
                a.this.bAs();
            } else {
                a.this.bAl();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0269a {
        void bAu();

        void bAv();

        void bAw();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gHI = view.findViewById(d.g.cover_video);
        this.gHI.setOnClickListener(this.mOnClickListener);
        this.aeX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.aeY = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.gHJ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.card_anim_alpha_0_to_1_duration_2000);
        this.gHP = d.u(tbPageContext);
        this.gEX = d.s(tbPageContext);
    }

    public void bAl() {
        if (!bAr() && !this.gHM) {
            clearAnimation();
            this.gHJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.bAr()) {
                        a.this.gHM = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gHM = true;
            if (this.gHQ != null) {
                this.gHQ.bAw();
            }
            lZ(true);
        }
    }

    public void bAm() {
        if (!bAr() && !this.gHN) {
            clearAnimation();
            this.aeY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.gHN = false;
                    a.this.bAs();
                    if (!a.this.bAr()) {
                        a.this.lZ(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gHI.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gHN = false;
                    a.this.bAs();
                    if (!a.this.bAr()) {
                        a.this.lZ(false);
                    }
                }
            }, 200L);
            this.gHN = true;
            if (this.gHQ != null) {
                this.gHQ.bAv();
            }
        }
    }

    public void bAn() {
        if (!bAr()) {
            if (!this.gHK) {
                clearAnimation();
            }
            if (!this.gHK) {
                this.aeY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.bAp();
                        a.this.gHK = false;
                        a.this.bAs();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gHI.startAnimation(this.aeY);
                this.gHK = true;
                if (this.gHQ != null) {
                    this.gHQ.bAu();
                }
            }
        }
    }

    public void bAo() {
        if (!bAr()) {
            if (!this.gHL) {
                clearAnimation();
            }
            if (!this.gHL) {
                this.aeX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.bAq();
                        a.this.gHL = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gHI.setAlpha(1.0f);
                this.gHI.startAnimation(this.aeX);
                this.gHL = true;
            }
        }
    }

    public void bAp() {
        if (!bAr()) {
            clearAnimation();
            this.gHI.setAlpha(0.0f);
            lZ(false);
        }
    }

    public void bAq() {
        if (!bAr()) {
            clearAnimation();
            this.gHI.setAlpha(1.0f);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gHR);
            lZ(true);
        }
    }

    private void clearAnimation() {
        if (!bAr()) {
            this.gHI.clearAnimation();
            this.gHK = false;
            this.gHL = false;
            this.gHM = false;
            this.gHN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(boolean z) {
        if (!bAr()) {
            this.gHI.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAr() {
        return this.gHI == null;
    }

    public void a(InterfaceC0269a interfaceC0269a) {
        this.gHQ = interfaceC0269a;
    }

    public void ma(boolean z) {
        this.gHO = z;
    }

    public void bAs() {
        bAt();
        if (this.gHO) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gHR, 3000L);
        }
    }

    public void bAt() {
        clearAnimation();
        lZ(false);
        this.gHI.setAlpha(0.0f);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gHR);
    }
}
