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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private View lUE;
    private ImageView mCloseBtn;
    private TextView mTip;
    private boolean miT;
    private TbImageView miU;
    private RotateAnimation miV;
    private AlphaAnimation miW;
    private AnimationSet miX;
    private ObjectAnimator miY;
    private ObjectAnimator miZ;
    private AnimatorSet mja;
    private Animation.AnimationListener mjb;
    private final CustomMessageListener mjc;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.miT = false;
        this.mjb = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dqB();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mjc = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.miT) {
                    PersonCenterGuideView.this.miT = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lUE.setVisibility(4);
                    PersonCenterGuideView.this.miU.startAnimation(PersonCenterGuideView.this.miX);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.miT);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.miT = false;
        this.mjb = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dqB();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mjc = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.miT) {
                    PersonCenterGuideView.this.miT = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lUE.setVisibility(4);
                    PersonCenterGuideView.this.miU.startAnimation(PersonCenterGuideView.this.miX);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.miT);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.miT = false;
        this.mjb = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dqB();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mjc = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.miT) {
                    PersonCenterGuideView.this.miT = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lUE.setVisibility(4);
                    PersonCenterGuideView.this.miU.startAnimation(PersonCenterGuideView.this.miX);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.miT);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.miU = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.miU.setIsRound(true);
        this.lUE = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.miV = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.miV.setDuration(660L);
        this.miV.setAnimationListener(this.mjb);
        this.miW = new AlphaAnimation(0.0f, 1.0f);
        this.miW.setDuration(660L);
        this.miX = new AnimationSet(true);
        this.miX.addAnimation(this.miV);
        this.miX.addAnimation(this.miW);
        this.miT = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqB() {
        this.lUE.setVisibility(0);
        if (this.miY == null) {
            this.miY = ObjectAnimator.ofFloat(this.lUE, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.mja == null) {
            this.miZ = ObjectAnimator.ofFloat(this.lUE, "alpha", 0.0f, 1.0f);
        }
        if (this.mja == null) {
            this.mja = new AnimatorSet();
            this.mja.setDuration(500L);
        }
        this.mja.play(this.miY).with(this.miZ);
        this.mja.start();
    }

    public void onChangeSkinType() {
        an.setImageResource(this.miU, R.drawable.person_center_head_guide_circle);
        an.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        an.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        an.setBackgroundResource(this.lUE, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.mja != null) {
            this.mja.cancel();
        }
        if (this.miX != null) {
            this.miX.cancel();
        }
        if (this.miV != null) {
            this.miV.cancel();
        }
        if (this.miW != null) {
            this.miW.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mjc);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mjc);
        clearAnim();
    }

    public void dqC() {
        clearAnim();
        setVisibility(8);
    }
}
