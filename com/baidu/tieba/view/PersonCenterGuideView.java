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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private boolean kHJ;
    private TbImageView kHK;
    private RotateAnimation kHL;
    private AlphaAnimation kHM;
    private AnimationSet kHN;
    private ObjectAnimator kHO;
    private ObjectAnimator kHP;
    private AnimatorSet kHQ;
    private Animation.AnimationListener kHR;
    private final CustomMessageListener kHS;
    private View ktV;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kHJ = false;
        this.kHR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cSa();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kHS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kHJ) {
                    PersonCenterGuideView.this.kHJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.ktV.setVisibility(4);
                    PersonCenterGuideView.this.kHK.startAnimation(PersonCenterGuideView.this.kHN);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kHJ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kHJ = false;
        this.kHR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cSa();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kHS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kHJ) {
                    PersonCenterGuideView.this.kHJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.ktV.setVisibility(4);
                    PersonCenterGuideView.this.kHK.startAnimation(PersonCenterGuideView.this.kHN);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kHJ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kHJ = false;
        this.kHR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cSa();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kHS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kHJ) {
                    PersonCenterGuideView.this.kHJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.ktV.setVisibility(4);
                    PersonCenterGuideView.this.kHK.startAnimation(PersonCenterGuideView.this.kHN);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kHJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kHK = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kHK.setIsRound(true);
        this.ktV = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kHL = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kHL.setDuration(660L);
        this.kHL.setAnimationListener(this.kHR);
        this.kHM = new AlphaAnimation(0.0f, 1.0f);
        this.kHM.setDuration(660L);
        this.kHN = new AnimationSet(true);
        this.kHN.addAnimation(this.kHL);
        this.kHN.addAnimation(this.kHM);
        this.kHJ = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSa() {
        this.ktV.setVisibility(0);
        if (this.kHO == null) {
            this.kHO = ObjectAnimator.ofFloat(this.ktV, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kHQ == null) {
            this.kHP = ObjectAnimator.ofFloat(this.ktV, "alpha", 0.0f, 1.0f);
        }
        if (this.kHQ == null) {
            this.kHQ = new AnimatorSet();
            this.kHQ.setDuration(500L);
        }
        this.kHQ.play(this.kHO).with(this.kHP);
        this.kHQ.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kHK, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.ktV, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kHQ != null) {
            this.kHQ.cancel();
        }
        if (this.kHN != null) {
            this.kHN.cancel();
        }
        if (this.kHL != null) {
            this.kHL.cancel();
        }
        if (this.kHM != null) {
            this.kHM.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kHS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kHS);
        clearAnim();
    }

    public void cSb() {
        clearAnim();
        setVisibility(8);
    }
}
