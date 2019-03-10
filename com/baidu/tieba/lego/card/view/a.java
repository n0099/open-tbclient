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
    private l gEY;
    private View gHJ;
    private Animation gHK;
    private LegoListFragment gHQ;
    private InterfaceC0269a gHR;
    private TbPageContext<?> mContext;
    private boolean gHL = false;
    private boolean gHM = false;
    private boolean gHN = false;
    private boolean gHO = false;
    private boolean gHP = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.bAs() && a.this.gHJ.getAlpha() == 0.0f) {
                a.this.bAn();
            }
        }
    };
    private Runnable gHS = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gHQ != null && a.this.gHQ.bzD() == 1) {
                a.this.bAt();
            } else {
                a.this.bAm();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0269a {
        void bAv();

        void bAw();

        void bAx();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gHJ = view.findViewById(d.g.cover_video);
        this.gHJ.setOnClickListener(this.mOnClickListener);
        this.aeX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.aeY = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.gHK = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.card_anim_alpha_0_to_1_duration_2000);
        this.gHQ = d.u(tbPageContext);
        this.gEY = d.s(tbPageContext);
    }

    public void bAm() {
        if (!bAs() && !this.gHN) {
            clearAnimation();
            this.gHK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.bAs()) {
                        a.this.gHN = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gHN = true;
            if (this.gHR != null) {
                this.gHR.bAx();
            }
            lZ(true);
        }
    }

    public void bAn() {
        if (!bAs() && !this.gHO) {
            clearAnimation();
            this.aeY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.gHO = false;
                    a.this.bAt();
                    if (!a.this.bAs()) {
                        a.this.lZ(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gHJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gHO = false;
                    a.this.bAt();
                    if (!a.this.bAs()) {
                        a.this.lZ(false);
                    }
                }
            }, 200L);
            this.gHO = true;
            if (this.gHR != null) {
                this.gHR.bAw();
            }
        }
    }

    public void bAo() {
        if (!bAs()) {
            if (!this.gHL) {
                clearAnimation();
            }
            if (!this.gHL) {
                this.aeY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.bAq();
                        a.this.gHL = false;
                        a.this.bAt();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gHJ.startAnimation(this.aeY);
                this.gHL = true;
                if (this.gHR != null) {
                    this.gHR.bAv();
                }
            }
        }
    }

    public void bAp() {
        if (!bAs()) {
            if (!this.gHM) {
                clearAnimation();
            }
            if (!this.gHM) {
                this.aeX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.bAr();
                        a.this.gHM = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gHJ.setAlpha(1.0f);
                this.gHJ.startAnimation(this.aeX);
                this.gHM = true;
            }
        }
    }

    public void bAq() {
        if (!bAs()) {
            clearAnimation();
            this.gHJ.setAlpha(0.0f);
            lZ(false);
        }
    }

    public void bAr() {
        if (!bAs()) {
            clearAnimation();
            this.gHJ.setAlpha(1.0f);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gHS);
            lZ(true);
        }
    }

    private void clearAnimation() {
        if (!bAs()) {
            this.gHJ.clearAnimation();
            this.gHL = false;
            this.gHM = false;
            this.gHN = false;
            this.gHO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(boolean z) {
        if (!bAs()) {
            this.gHJ.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAs() {
        return this.gHJ == null;
    }

    public void a(InterfaceC0269a interfaceC0269a) {
        this.gHR = interfaceC0269a;
    }

    public void ma(boolean z) {
        this.gHP = z;
    }

    public void bAt() {
        bAu();
        if (this.gHP) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gHS, 3000L);
        }
    }

    public void bAu() {
        clearAnimation();
        lZ(false);
        this.gHJ.setAlpha(0.0f);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gHS);
    }
}
