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
/* loaded from: classes9.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private TbImageView kKA;
    private RotateAnimation kKB;
    private AlphaAnimation kKC;
    private AnimationSet kKD;
    private ObjectAnimator kKE;
    private ObjectAnimator kKF;
    private AnimatorSet kKG;
    private Animation.AnimationListener kKH;
    private final CustomMessageListener kKI;
    private boolean kKz;
    private View kwK;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kKz = false;
        this.kKH = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTS();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kKI = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kKz) {
                    PersonCenterGuideView.this.kKz = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kwK.setVisibility(4);
                    PersonCenterGuideView.this.kKA.startAnimation(PersonCenterGuideView.this.kKD);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kKz);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kKz = false;
        this.kKH = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTS();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kKI = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kKz) {
                    PersonCenterGuideView.this.kKz = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kwK.setVisibility(4);
                    PersonCenterGuideView.this.kKA.startAnimation(PersonCenterGuideView.this.kKD);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kKz);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kKz = false;
        this.kKH = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTS();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kKI = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kKz) {
                    PersonCenterGuideView.this.kKz = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kwK.setVisibility(4);
                    PersonCenterGuideView.this.kKA.startAnimation(PersonCenterGuideView.this.kKD);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kKz);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kKA = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kKA.setIsRound(true);
        this.kwK = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kKB = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kKB.setDuration(660L);
        this.kKB.setAnimationListener(this.kKH);
        this.kKC = new AlphaAnimation(0.0f, 1.0f);
        this.kKC.setDuration(660L);
        this.kKD = new AnimationSet(true);
        this.kKD.addAnimation(this.kKB);
        this.kKD.addAnimation(this.kKC);
        this.kKz = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTS() {
        this.kwK.setVisibility(0);
        if (this.kKE == null) {
            this.kKE = ObjectAnimator.ofFloat(this.kwK, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kKG == null) {
            this.kKF = ObjectAnimator.ofFloat(this.kwK, "alpha", 0.0f, 1.0f);
        }
        if (this.kKG == null) {
            this.kKG = new AnimatorSet();
            this.kKG.setDuration(500L);
        }
        this.kKG.play(this.kKE).with(this.kKF);
        this.kKG.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kKA, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kwK, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kKG != null) {
            this.kKG.cancel();
        }
        if (this.kKD != null) {
            this.kKD.cancel();
        }
        if (this.kKB != null) {
            this.kKB.cancel();
        }
        if (this.kKC != null) {
            this.kKC.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kKI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kKI);
        clearAnim();
    }

    public void cTT() {
        clearAnim();
        setVisibility(8);
    }
}
