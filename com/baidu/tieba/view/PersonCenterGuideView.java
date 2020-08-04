package com.baidu.tieba.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private View mbW;
    private boolean mqT;
    private TbImageView mqU;
    private RotateAnimation mqV;
    private AlphaAnimation mqW;
    private AnimationSet mqX;
    private ObjectAnimator mqY;
    private ObjectAnimator mqZ;
    private AnimatorSet mra;
    private Animation.AnimationListener mrb;
    private final CustomMessageListener mrc;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.mqT = false;
        this.mrb = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dtO();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mrc = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mqT) {
                    PersonCenterGuideView.this.mqT = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mbW.setVisibility(4);
                    PersonCenterGuideView.this.mqU.startAnimation(PersonCenterGuideView.this.mqX);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mqT);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mqT = false;
        this.mrb = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dtO();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mrc = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mqT) {
                    PersonCenterGuideView.this.mqT = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mbW.setVisibility(4);
                    PersonCenterGuideView.this.mqU.startAnimation(PersonCenterGuideView.this.mqX);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mqT);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mqT = false;
        this.mrb = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dtO();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mrc = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mqT) {
                    PersonCenterGuideView.this.mqT = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mbW.setVisibility(4);
                    PersonCenterGuideView.this.mqU.startAnimation(PersonCenterGuideView.this.mqX);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mqT);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.mqU = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.mqU.setIsRound(true);
        this.mbW = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.mqV = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mqV.setDuration(660L);
        this.mqV.setAnimationListener(this.mrb);
        this.mqW = new AlphaAnimation(0.0f, 1.0f);
        this.mqW.setDuration(660L);
        this.mqX = new AnimationSet(true);
        this.mqX.addAnimation(this.mqV);
        this.mqX.addAnimation(this.mqW);
        this.mqT = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtO() {
        this.mbW.setVisibility(0);
        if (this.mqY == null) {
            this.mqY = ObjectAnimator.ofFloat(this.mbW, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.mra == null) {
            this.mqZ = ObjectAnimator.ofFloat(this.mbW, "alpha", 0.0f, 1.0f);
        }
        if (this.mra == null) {
            this.mra = new AnimatorSet();
            this.mra.setDuration(500L);
        }
        this.mra.play(this.mqY).with(this.mqZ);
        this.mra.start();
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.mqU, R.drawable.person_center_head_guide_circle);
        ao.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ao.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ao.setBackgroundResource(this.mbW, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.mra != null) {
            this.mra.cancel();
        }
        if (this.mqX != null) {
            this.mqX.cancel();
        }
        if (this.mqV != null) {
            this.mqV.cancel();
        }
        if (this.mqW != null) {
            this.mqW.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mrc);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mrc);
        clearAnim();
    }

    public void dtP() {
        clearAnim();
        setVisibility(8);
    }
}
