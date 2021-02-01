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
    private n kZO;
    private LegoListFragment lcD;
    private InterfaceC0776a lcE;
    private View lcw;
    private Animation lcx;
    private boolean lcy = false;
    private boolean lcz = false;
    private boolean lcA = false;
    private boolean lcB = false;
    private boolean lcC = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.dca() && a.this.lcw.getAlpha() == 0.0f) {
                a.this.dbW();
            }
        }
    };
    private Runnable lcF = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.lcD != null && a.this.lcD.dbn() == 1) {
                a.this.dcb();
            } else {
                a.this.dbV();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0776a {
        void dcd();

        void dce();

        void dcf();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.lcw = view.findViewById(R.id.cover_video);
        this.lcw.setOnClickListener(this.mOnClickListener);
        this.chW = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.chX = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.lcx = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.lcD = d.C(tbPageContext);
        this.kZO = d.A(tbPageContext);
    }

    public void dbV() {
        if (!dca() && !this.lcA) {
            clearAnimation();
            this.lcx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.dca()) {
                        a.this.lcA = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lcA = true;
            if (this.lcE != null) {
                this.lcE.dcf();
            }
            tI(true);
        }
    }

    public void dbW() {
        if (!dca() && !this.lcB) {
            clearAnimation();
            this.chX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.lcB = false;
                    a.this.dcb();
                    if (!a.this.dca()) {
                        a.this.tI(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lcw.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lcB = false;
                    a.this.dcb();
                    if (!a.this.dca()) {
                        a.this.tI(false);
                    }
                }
            }, 200L);
            this.lcB = true;
            if (this.lcE != null) {
                this.lcE.dce();
            }
        }
    }

    public void dbX() {
        if (!dca()) {
            if (!this.lcy) {
                clearAnimation();
            }
            if (!this.lcy) {
                this.chX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dbY();
                        a.this.lcy = false;
                        a.this.dcb();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lcw.startAnimation(this.chX);
                this.lcy = true;
                if (this.lcE != null) {
                    this.lcE.dcd();
                }
            }
        }
    }

    public void cpP() {
        if (!dca()) {
            if (!this.lcz) {
                clearAnimation();
            }
            if (!this.lcz) {
                this.chW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dbZ();
                        a.this.lcz = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lcw.setAlpha(1.0f);
                this.lcw.startAnimation(this.chW);
                this.lcz = true;
            }
        }
    }

    public void dbY() {
        if (!dca()) {
            clearAnimation();
            this.lcw.setAlpha(0.0f);
            tI(false);
        }
    }

    public void dbZ() {
        if (!dca()) {
            clearAnimation();
            this.lcw.setAlpha(1.0f);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lcF);
            tI(true);
        }
    }

    private void clearAnimation() {
        if (!dca()) {
            this.lcw.clearAnimation();
            this.lcy = false;
            this.lcz = false;
            this.lcA = false;
            this.lcB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(boolean z) {
        if (!dca()) {
            this.lcw.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dca() {
        return this.lcw == null;
    }

    public void a(InterfaceC0776a interfaceC0776a) {
        this.lcE = interfaceC0776a;
    }

    public void tJ(boolean z) {
        this.lcC = z;
    }

    public void dcb() {
        dcc();
        if (this.lcC) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.lcF, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void dcc() {
        clearAnimation();
        tI(false);
        this.lcw.setAlpha(0.0f);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lcF);
    }
}
