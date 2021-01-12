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
/* loaded from: classes8.dex */
public class a {
    private Animation cdO;
    private Animation cdP;
    private TbPageContext<?> eSJ;
    private n kRM;
    private InterfaceC0774a kUA;
    private View kUs;
    private Animation kUt;
    private LegoListFragment kUz;
    private boolean kUu = false;
    private boolean kUv = false;
    private boolean kUw = false;
    private boolean kUx = false;
    private boolean kUy = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.dac() && a.this.kUs.getAlpha() == 0.0f) {
                a.this.cZY();
            }
        }
    };
    private Runnable kUB = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.kUz != null && a.this.kUz.cZp() == 1) {
                a.this.dad();
            } else {
                a.this.cZX();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0774a {
        void daf();

        void dag();

        void dah();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.kUs = view.findViewById(R.id.cover_video);
        this.kUs.setOnClickListener(this.mOnClickListener);
        this.cdO = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.cdP = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.kUt = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.kUz = d.A(tbPageContext);
        this.kRM = d.y(tbPageContext);
    }

    public void cZX() {
        if (!dac() && !this.kUw) {
            clearAnimation();
            this.kUt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.dac()) {
                        a.this.kUw = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kUw = true;
            if (this.kUA != null) {
                this.kUA.dah();
            }
            tv(true);
        }
    }

    public void cZY() {
        if (!dac() && !this.kUx) {
            clearAnimation();
            this.cdP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.kUx = false;
                    a.this.dad();
                    if (!a.this.dac()) {
                        a.this.tv(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kUs.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kUx = false;
                    a.this.dad();
                    if (!a.this.dac()) {
                        a.this.tv(false);
                    }
                }
            }, 200L);
            this.kUx = true;
            if (this.kUA != null) {
                this.kUA.dag();
            }
        }
    }

    public void cZZ() {
        if (!dac()) {
            if (!this.kUu) {
                clearAnimation();
            }
            if (!this.kUu) {
                this.cdP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.daa();
                        a.this.kUu = false;
                        a.this.dad();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kUs.startAnimation(this.cdP);
                this.kUu = true;
                if (this.kUA != null) {
                    this.kUA.daf();
                }
            }
        }
    }

    public void coK() {
        if (!dac()) {
            if (!this.kUv) {
                clearAnimation();
            }
            if (!this.kUv) {
                this.cdO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dab();
                        a.this.kUv = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kUs.setAlpha(1.0f);
                this.kUs.startAnimation(this.cdO);
                this.kUv = true;
            }
        }
    }

    public void daa() {
        if (!dac()) {
            clearAnimation();
            this.kUs.setAlpha(0.0f);
            tv(false);
        }
    }

    public void dab() {
        if (!dac()) {
            clearAnimation();
            this.kUs.setAlpha(1.0f);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kUB);
            tv(true);
        }
    }

    private void clearAnimation() {
        if (!dac()) {
            this.kUs.clearAnimation();
            this.kUu = false;
            this.kUv = false;
            this.kUw = false;
            this.kUx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(boolean z) {
        if (!dac()) {
            this.kUs.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dac() {
        return this.kUs == null;
    }

    public void a(InterfaceC0774a interfaceC0774a) {
        this.kUA = interfaceC0774a;
    }

    public void tw(boolean z) {
        this.kUy = z;
    }

    public void dad() {
        dae();
        if (this.kUy) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kUB, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void dae() {
        clearAnimation();
        tv(false);
        this.kUs.setAlpha(0.0f);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kUB);
    }
}
