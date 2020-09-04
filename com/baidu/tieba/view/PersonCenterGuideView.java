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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private AlphaAnimation mJA;
    private AnimationSet mJB;
    private ObjectAnimator mJC;
    private ObjectAnimator mJD;
    private AnimatorSet mJE;
    private Animation.AnimationListener mJF;
    private final CustomMessageListener mJG;
    private boolean mJx;
    private TbImageView mJy;
    private RotateAnimation mJz;
    private TextView mTip;
    private View mtZ;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.mJx = false;
        this.mJF = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dFs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mJG = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mJx) {
                    PersonCenterGuideView.this.mJx = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mtZ.setVisibility(4);
                    PersonCenterGuideView.this.mJy.startAnimation(PersonCenterGuideView.this.mJB);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mJx);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mJx = false;
        this.mJF = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dFs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mJG = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mJx) {
                    PersonCenterGuideView.this.mJx = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mtZ.setVisibility(4);
                    PersonCenterGuideView.this.mJy.startAnimation(PersonCenterGuideView.this.mJB);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mJx);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJx = false;
        this.mJF = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dFs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mJG = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mJx) {
                    PersonCenterGuideView.this.mJx = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mtZ.setVisibility(4);
                    PersonCenterGuideView.this.mJy.startAnimation(PersonCenterGuideView.this.mJB);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mJx);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.mJy = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.mJy.setIsRound(true);
        this.mtZ = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.mJz = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mJz.setDuration(660L);
        this.mJz.setAnimationListener(this.mJF);
        this.mJA = new AlphaAnimation(0.0f, 1.0f);
        this.mJA.setDuration(660L);
        this.mJB = new AnimationSet(true);
        this.mJB.addAnimation(this.mJz);
        this.mJB.addAnimation(this.mJA);
        this.mJx = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFs() {
        this.mtZ.setVisibility(0);
        if (this.mJC == null) {
            this.mJC = ObjectAnimator.ofFloat(this.mtZ, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.mJE == null) {
            this.mJD = ObjectAnimator.ofFloat(this.mtZ, "alpha", 0.0f, 1.0f);
        }
        if (this.mJE == null) {
            this.mJE = new AnimatorSet();
            this.mJE.setDuration(500L);
        }
        this.mJE.play(this.mJC).with(this.mJD);
        this.mJE.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.mJy, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.mtZ, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.mJE != null) {
            this.mJE.cancel();
        }
        if (this.mJB != null) {
            this.mJB.cancel();
        }
        if (this.mJz != null) {
            this.mJz.cancel();
        }
        if (this.mJA != null) {
            this.mJA.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mJG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mJG);
        clearAnim();
    }

    public void dFt() {
        clearAnim();
        setVisibility(8);
    }
}
