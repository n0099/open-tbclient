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
    private boolean kHE;
    private TbImageView kHF;
    private RotateAnimation kHG;
    private AlphaAnimation kHH;
    private AnimationSet kHI;
    private ObjectAnimator kHJ;
    private ObjectAnimator kHK;
    private AnimatorSet kHL;
    private Animation.AnimationListener kHM;
    private final CustomMessageListener kHN;
    private View ktQ;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kHE = false;
        this.kHM = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cRY();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kHN = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kHE) {
                    PersonCenterGuideView.this.kHE = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.ktQ.setVisibility(4);
                    PersonCenterGuideView.this.kHF.startAnimation(PersonCenterGuideView.this.kHI);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kHE);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kHE = false;
        this.kHM = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cRY();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kHN = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kHE) {
                    PersonCenterGuideView.this.kHE = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.ktQ.setVisibility(4);
                    PersonCenterGuideView.this.kHF.startAnimation(PersonCenterGuideView.this.kHI);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kHE);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kHE = false;
        this.kHM = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cRY();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kHN = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kHE) {
                    PersonCenterGuideView.this.kHE = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.ktQ.setVisibility(4);
                    PersonCenterGuideView.this.kHF.startAnimation(PersonCenterGuideView.this.kHI);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kHE);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kHF = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kHF.setIsRound(true);
        this.ktQ = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kHG = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kHG.setDuration(660L);
        this.kHG.setAnimationListener(this.kHM);
        this.kHH = new AlphaAnimation(0.0f, 1.0f);
        this.kHH.setDuration(660L);
        this.kHI = new AnimationSet(true);
        this.kHI.addAnimation(this.kHG);
        this.kHI.addAnimation(this.kHH);
        this.kHE = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRY() {
        this.ktQ.setVisibility(0);
        if (this.kHJ == null) {
            this.kHJ = ObjectAnimator.ofFloat(this.ktQ, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kHL == null) {
            this.kHK = ObjectAnimator.ofFloat(this.ktQ, "alpha", 0.0f, 1.0f);
        }
        if (this.kHL == null) {
            this.kHL = new AnimatorSet();
            this.kHL.setDuration(500L);
        }
        this.kHL.play(this.kHJ).with(this.kHK);
        this.kHL.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kHF, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.ktQ, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kHL != null) {
            this.kHL.cancel();
        }
        if (this.kHI != null) {
            this.kHI.cancel();
        }
        if (this.kHG != null) {
            this.kHG.cancel();
        }
        if (this.kHH != null) {
            this.kHH.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kHN);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kHN);
        clearAnim();
    }

    public void cRZ() {
        clearAnim();
        setVisibility(8);
    }
}
