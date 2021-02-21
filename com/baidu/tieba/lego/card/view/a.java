package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListFragment;
/* loaded from: classes9.dex */
public class a {
    private Animation chW;
    private Animation chX;
    private TbPageContext<?> eUY;
    private n lac;
    private View lcK;
    private Animation lcL;
    private LegoListFragment lcR;
    private InterfaceC0777a lcS;
    private boolean lcM = false;
    private boolean lcN = false;
    private boolean lcO = false;
    private boolean lcP = false;
    private boolean lcQ = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.dch() && a.this.lcK.getAlpha() == 0.0f) {
                a.this.dcd();
            }
        }
    };
    private Runnable lcT = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.lcR != null && a.this.lcR.dbu() == 1) {
                a.this.dci();
            } else {
                a.this.dcc();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0777a {
        void dck();

        void dcl();

        void dcm();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.lcK = view.findViewById(R.id.cover_video);
        this.lcK.setOnClickListener(this.mOnClickListener);
        this.chW = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.chX = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.lcL = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.lcR = d.C(tbPageContext);
        this.lac = d.A(tbPageContext);
    }

    public void dcc() {
        if (!dch() && !this.lcO) {
            clearAnimation();
            this.lcL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.dch()) {
                        a.this.lcO = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lcO = true;
            if (this.lcS != null) {
                this.lcS.dcm();
            }
            tI(true);
        }
    }

    public void dcd() {
        if (!dch() && !this.lcP) {
            clearAnimation();
            this.chX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.lcP = false;
                    a.this.dci();
                    if (!a.this.dch()) {
                        a.this.tI(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lcK.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lcP = false;
                    a.this.dci();
                    if (!a.this.dch()) {
                        a.this.tI(false);
                    }
                }
            }, 200L);
            this.lcP = true;
            if (this.lcS != null) {
                this.lcS.dcl();
            }
        }
    }

    public void dce() {
        if (!dch()) {
            if (!this.lcM) {
                clearAnimation();
            }
            if (!this.lcM) {
                this.chX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dcf();
                        a.this.lcM = false;
                        a.this.dci();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lcK.startAnimation(this.chX);
                this.lcM = true;
                if (this.lcS != null) {
                    this.lcS.dck();
                }
            }
        }
    }

    public void cpW() {
        if (!dch()) {
            if (!this.lcN) {
                clearAnimation();
            }
            if (!this.lcN) {
                this.chW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dcg();
                        a.this.lcN = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lcK.setAlpha(1.0f);
                this.lcK.startAnimation(this.chW);
                this.lcN = true;
            }
        }
    }

    public void dcf() {
        if (!dch()) {
            clearAnimation();
            this.lcK.setAlpha(0.0f);
            tI(false);
        }
    }

    public void dcg() {
        if (!dch()) {
            clearAnimation();
            this.lcK.setAlpha(1.0f);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lcT);
            tI(true);
        }
    }

    private void clearAnimation() {
        if (!dch()) {
            this.lcK.clearAnimation();
            this.lcM = false;
            this.lcN = false;
            this.lcO = false;
            this.lcP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(boolean z) {
        if (!dch()) {
            this.lcK.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dch() {
        return this.lcK == null;
    }

    public void a(InterfaceC0777a interfaceC0777a) {
        this.lcS = interfaceC0777a;
    }

    public void tJ(boolean z) {
        this.lcQ = z;
    }

    public void dci() {
        dcj();
        if (this.lcQ) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.lcT, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void dcj() {
        clearAnimation();
        tI(false);
        this.lcK.setAlpha(0.0f);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lcT);
    }
}
