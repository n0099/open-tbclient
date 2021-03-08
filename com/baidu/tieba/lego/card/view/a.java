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
    private Animation cjx;
    private Animation cjy;
    private TbPageContext<?> eWx;
    private n lcf;
    private View leN;
    private Animation leO;
    private LegoListFragment leU;
    private InterfaceC0783a leV;
    private boolean leP = false;
    private boolean leQ = false;
    private boolean leR = false;
    private boolean leS = false;
    private boolean leT = true;
    private int mPosition = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.dcq() && a.this.leN.getAlpha() == 0.0f) {
                a.this.dcm();
            }
        }
    };
    private Runnable leW = new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.7
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.leU != null && a.this.leU.dbD() == 1) {
                a.this.dcr();
            } else {
                a.this.dcl();
            }
        }
    };

    /* renamed from: com.baidu.tieba.lego.card.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0783a {
        void dct();

        void dcu();

        void dcv();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.leN = view.findViewById(R.id.cover_video);
        this.leN.setOnClickListener(this.mOnClickListener);
        this.cjx = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.cjy = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.leO = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.leU = d.C(tbPageContext);
        this.lcf = d.A(tbPageContext);
    }

    public void dcl() {
        if (!dcq() && !this.leR) {
            clearAnimation();
            this.leO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, false));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!a.this.dcq()) {
                        a.this.leR = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.leR = true;
            if (this.leV != null) {
                this.leV.dcv();
            }
            tI(true);
        }
    }

    public void dcm() {
        if (!dcq() && !this.leS) {
            clearAnimation();
            this.cjy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.leS = false;
                    a.this.dcr();
                    if (!a.this.dcq()) {
                        a.this.tI(false);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.leN.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.card.view.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.leS = false;
                    a.this.dcr();
                    if (!a.this.dcq()) {
                        a.this.tI(false);
                    }
                }
            }, 200L);
            this.leS = true;
            if (this.leV != null) {
                this.leV.dcu();
            }
        }
    }

    public void dcn() {
        if (!dcq()) {
            if (!this.leP) {
                clearAnimation();
            }
            if (!this.leP) {
                this.cjy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOGGLE_SHOW_VIDEO_VIEW, true));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dco();
                        a.this.leP = false;
                        a.this.dcr();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.leN.startAnimation(this.cjy);
                this.leP = true;
                if (this.leV != null) {
                    this.leV.dct();
                }
            }
        }
    }

    public void cqc() {
        if (!dcq()) {
            if (!this.leQ) {
                clearAnimation();
            }
            if (!this.leQ) {
                this.cjx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.a.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dcp();
                        a.this.leQ = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.leN.setAlpha(1.0f);
                this.leN.startAnimation(this.cjx);
                this.leQ = true;
            }
        }
    }

    public void dco() {
        if (!dcq()) {
            clearAnimation();
            this.leN.setAlpha(0.0f);
            tI(false);
        }
    }

    public void dcp() {
        if (!dcq()) {
            clearAnimation();
            this.leN.setAlpha(1.0f);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leW);
            tI(true);
        }
    }

    private void clearAnimation() {
        if (!dcq()) {
            this.leN.clearAnimation();
            this.leP = false;
            this.leQ = false;
            this.leR = false;
            this.leS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(boolean z) {
        if (!dcq()) {
            this.leN.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dcq() {
        return this.leN == null;
    }

    public void a(InterfaceC0783a interfaceC0783a) {
        this.leV = interfaceC0783a;
    }

    public void tJ(boolean z) {
        this.leT = z;
    }

    public void dcr() {
        dcs();
        if (this.leT) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.leW, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void dcs() {
        clearAnimation();
        tI(false);
        this.leN.setAlpha(0.0f);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leW);
    }
}
