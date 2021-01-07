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
    private Animation ciB;
    private Animation ciC;
    private TbPageContext<?> eXu;
    private n kWr;
    private View kYX;
    private Animation kYY;
    private LegoListFragment kZe;
    private InterfaceC0791a kZf;
    private boolean kYZ = false;
    private boolean kZa = false;
    private boolean kZb = false;
    private boolean kZc = false;
    private boolean kZd = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.ddU() && a.this.kYX.getAlpha() == 0.0f) {
                a.this.ddQ();
            }
        }
    };
    private Runnable kZg = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.kZe != null && a.this.kZe.ddh() == 1) {
                a.this.ddV();
            } else {
                a.this.ddP();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0791a {
        void ddX();

        void ddY();

        void ddZ();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.eXu = tbPageContext;
        this.kYX = view.findViewById(R.id.cover_video);
        this.kYX.setOnClickListener(this.mOnClickListener);
        this.ciB = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.ciC = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.kYY = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.kZe = d.A(tbPageContext);
        this.kWr = d.y(tbPageContext);
    }

    public void ddP() {
        if (!ddU() && !this.kZb) {
            clearAnimation();
            this.kYY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.ddU()) {
                        a.this.kZb = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kZb = true;
            if (this.kZf != null) {
                this.kZf.ddZ();
            }
            tz(true);
        }
    }

    public void ddQ() {
        if (!ddU() && !this.kZc) {
            clearAnimation();
            this.ciC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.kZc = false;
                    a.this.ddV();
                    if (!a.this.ddU()) {
                        a.this.tz(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kYX.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kZc = false;
                    a.this.ddV();
                    if (!a.this.ddU()) {
                        a.this.tz(false);
                    }
                }
            }, 200L);
            this.kZc = true;
            if (this.kZf != null) {
                this.kZf.ddY();
            }
        }
    }

    public void ddR() {
        if (!ddU()) {
            if (!this.kYZ) {
                clearAnimation();
            }
            if (!this.kYZ) {
                this.ciC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.ddS();
                        a.this.kYZ = false;
                        a.this.ddV();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kYX.startAnimation(this.ciC);
                this.kYZ = true;
                if (this.kZf != null) {
                    this.kZf.ddX();
                }
            }
        }
    }

    public void csC() {
        if (!ddU()) {
            if (!this.kZa) {
                clearAnimation();
            }
            if (!this.kZa) {
                this.ciB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.ddT();
                        a.this.kZa = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kYX.setAlpha(1.0f);
                this.kYX.startAnimation(this.ciB);
                this.kZa = true;
            }
        }
    }

    public void ddS() {
        if (!ddU()) {
            clearAnimation();
            this.kYX.setAlpha(0.0f);
            tz(false);
        }
    }

    public void ddT() {
        if (!ddU()) {
            clearAnimation();
            this.kYX.setAlpha(1.0f);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZg);
            tz(true);
        }
    }

    private void clearAnimation() {
        if (!ddU()) {
            this.kYX.clearAnimation();
            this.kYZ = false;
            this.kZa = false;
            this.kZb = false;
            this.kZc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz(boolean z) {
        if (!ddU()) {
            this.kYX.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddU() {
        return this.kYX == null;
    }

    public void a(InterfaceC0791a interfaceC0791a) {
        this.kZf = interfaceC0791a;
    }

    public void tA(boolean z) {
        this.kZd = z;
    }

    public void ddV() {
        ddW();
        if (this.kZd) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kZg, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void ddW() {
        clearAnimation();
        tz(false);
        this.kYX.setAlpha(0.0f);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZg);
    }
}
