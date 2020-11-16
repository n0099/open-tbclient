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
/* loaded from: classes21.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private boolean nCF;
    private TbImageView nCG;
    private RotateAnimation nCH;
    private AlphaAnimation nCI;
    private AnimationSet nCJ;
    private ObjectAnimator nCK;
    private ObjectAnimator nCL;
    private AnimatorSet nCM;
    private Animation.AnimationListener nCN;
    private final CustomMessageListener nCO;
    private View nnb;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nCF = false;
        this.nCN = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dSH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nCO = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nCF) {
                    PersonCenterGuideView.this.nCF = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nnb.setVisibility(4);
                    PersonCenterGuideView.this.nCG.startAnimation(PersonCenterGuideView.this.nCJ);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nCF);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nCF = false;
        this.nCN = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dSH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nCO = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nCF) {
                    PersonCenterGuideView.this.nCF = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nnb.setVisibility(4);
                    PersonCenterGuideView.this.nCG.startAnimation(PersonCenterGuideView.this.nCJ);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nCF);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCF = false;
        this.nCN = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dSH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nCO = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nCF) {
                    PersonCenterGuideView.this.nCF = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nnb.setVisibility(4);
                    PersonCenterGuideView.this.nCG.startAnimation(PersonCenterGuideView.this.nCJ);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nCF);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nCG = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nCG.setIsRound(true);
        this.nnb = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nCH = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nCH.setDuration(660L);
        this.nCH.setAnimationListener(this.nCN);
        this.nCI = new AlphaAnimation(0.0f, 1.0f);
        this.nCI.setDuration(660L);
        this.nCJ = new AnimationSet(true);
        this.nCJ.addAnimation(this.nCH);
        this.nCJ.addAnimation(this.nCI);
        this.nCF = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSH() {
        this.nnb.setVisibility(0);
        if (this.nCK == null) {
            this.nCK = ObjectAnimator.ofFloat(this.nnb, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nCM == null) {
            this.nCL = ObjectAnimator.ofFloat(this.nnb, "alpha", 0.0f, 1.0f);
        }
        if (this.nCM == null) {
            this.nCM = new AnimatorSet();
            this.nCM.setDuration(500L);
        }
        this.nCM.play(this.nCK).with(this.nCL);
        this.nCM.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.nCG, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nnb, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nCM != null) {
            this.nCM.cancel();
        }
        if (this.nCJ != null) {
            this.nCJ.cancel();
        }
        if (this.nCH != null) {
            this.nCH.cancel();
        }
        if (this.nCI != null) {
            this.nCI.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nCO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nCO);
        clearAnim();
    }

    public void dSI() {
        clearAnim();
        setVisibility(8);
    }
}
