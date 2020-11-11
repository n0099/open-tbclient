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
/* loaded from: classes22.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private boolean nBi;
    private TbImageView nBj;
    private RotateAnimation nBk;
    private AlphaAnimation nBl;
    private AnimationSet nBm;
    private ObjectAnimator nBn;
    private ObjectAnimator nBo;
    private AnimatorSet nBp;
    private Animation.AnimationListener nBq;
    private final CustomMessageListener nBr;
    private View nlU;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nBi = false;
        this.nBq = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dSI();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nBr = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nBi) {
                    PersonCenterGuideView.this.nBi = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nlU.setVisibility(4);
                    PersonCenterGuideView.this.nBj.startAnimation(PersonCenterGuideView.this.nBm);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nBi);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nBi = false;
        this.nBq = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dSI();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nBr = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nBi) {
                    PersonCenterGuideView.this.nBi = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nlU.setVisibility(4);
                    PersonCenterGuideView.this.nBj.startAnimation(PersonCenterGuideView.this.nBm);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nBi);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nBi = false;
        this.nBq = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dSI();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nBr = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nBi) {
                    PersonCenterGuideView.this.nBi = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nlU.setVisibility(4);
                    PersonCenterGuideView.this.nBj.startAnimation(PersonCenterGuideView.this.nBm);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nBi);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nBj = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nBj.setIsRound(true);
        this.nlU = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nBk = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nBk.setDuration(660L);
        this.nBk.setAnimationListener(this.nBq);
        this.nBl = new AlphaAnimation(0.0f, 1.0f);
        this.nBl.setDuration(660L);
        this.nBm = new AnimationSet(true);
        this.nBm.addAnimation(this.nBk);
        this.nBm.addAnimation(this.nBl);
        this.nBi = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSI() {
        this.nlU.setVisibility(0);
        if (this.nBn == null) {
            this.nBn = ObjectAnimator.ofFloat(this.nlU, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nBp == null) {
            this.nBo = ObjectAnimator.ofFloat(this.nlU, "alpha", 0.0f, 1.0f);
        }
        if (this.nBp == null) {
            this.nBp = new AnimatorSet();
            this.nBp.setDuration(500L);
        }
        this.nBp.play(this.nBn).with(this.nBo);
        this.nBp.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.nBj, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.nlU, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nBp != null) {
            this.nBp.cancel();
        }
        if (this.nBm != null) {
            this.nBm.cancel();
        }
        if (this.nBk != null) {
            this.nBk.cancel();
        }
        if (this.nBl != null) {
            this.nBl.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nBr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nBr);
        clearAnim();
    }

    public void dSJ() {
        clearAnim();
        setVisibility(8);
    }
}
