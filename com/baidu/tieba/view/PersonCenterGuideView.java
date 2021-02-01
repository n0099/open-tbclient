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
/* loaded from: classes2.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private View nKr;
    private boolean nZD;
    private TbImageView nZE;
    private RotateAnimation nZF;
    private AlphaAnimation nZG;
    private AnimationSet nZH;
    private ObjectAnimator nZI;
    private ObjectAnimator nZJ;
    private AnimatorSet nZK;
    private Animation.AnimationListener nZL;
    private final CustomMessageListener nZM;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nZD = false;
        this.nZL = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZM = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nZD) {
                    PersonCenterGuideView.this.nZD = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nKr.setVisibility(4);
                    PersonCenterGuideView.this.nZE.startAnimation(PersonCenterGuideView.this.nZH);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nZD);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nZD = false;
        this.nZL = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZM = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nZD) {
                    PersonCenterGuideView.this.nZD = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nKr.setVisibility(4);
                    PersonCenterGuideView.this.nZE.startAnimation(PersonCenterGuideView.this.nZH);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nZD);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZD = false;
        this.nZL = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZM = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nZD) {
                    PersonCenterGuideView.this.nZD = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nKr.setVisibility(4);
                    PersonCenterGuideView.this.nZE.startAnimation(PersonCenterGuideView.this.nZH);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nZD);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nZE = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nZE.setIsRound(true);
        this.nKr = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nZF = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nZF.setDuration(660L);
        this.nZF.setAnimationListener(this.nZL);
        this.nZG = new AlphaAnimation(0.0f, 1.0f);
        this.nZG.setDuration(660L);
        this.nZH = new AnimationSet(true);
        this.nZH.addAnimation(this.nZF);
        this.nZH.addAnimation(this.nZG);
        this.nZD = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWc() {
        this.nKr.setVisibility(0);
        if (this.nZI == null) {
            this.nZI = ObjectAnimator.ofFloat(this.nKr, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nZK == null) {
            this.nZJ = ObjectAnimator.ofFloat(this.nKr, "alpha", 0.0f, 1.0f);
        }
        if (this.nZK == null) {
            this.nZK = new AnimatorSet();
            this.nZK.setDuration(500L);
        }
        this.nZK.play(this.nZI).with(this.nZJ);
        this.nZK.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.nZE, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nKr, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nZK != null) {
            this.nZK.cancel();
        }
        if (this.nZH != null) {
            this.nZH.cancel();
        }
        if (this.nZF != null) {
            this.nZF.cancel();
        }
        if (this.nZG != null) {
            this.nZG.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nZM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nZM);
        clearAnim();
    }

    public void dWd() {
        clearAnim();
        setVisibility(8);
    }
}
