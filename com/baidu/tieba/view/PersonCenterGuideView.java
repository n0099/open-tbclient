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
    private View lUB;
    private ImageView mCloseBtn;
    private TextView mTip;
    private boolean miQ;
    private TbImageView miR;
    private RotateAnimation miS;
    private AlphaAnimation miT;
    private AnimationSet miU;
    private ObjectAnimator miV;
    private ObjectAnimator miW;
    private AnimatorSet miX;
    private Animation.AnimationListener miY;
    private final CustomMessageListener miZ;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.miQ = false;
        this.miY = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dqx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.miZ = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.miQ) {
                    PersonCenterGuideView.this.miQ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lUB.setVisibility(4);
                    PersonCenterGuideView.this.miR.startAnimation(PersonCenterGuideView.this.miU);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.miQ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.miQ = false;
        this.miY = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dqx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.miZ = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.miQ) {
                    PersonCenterGuideView.this.miQ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lUB.setVisibility(4);
                    PersonCenterGuideView.this.miR.startAnimation(PersonCenterGuideView.this.miU);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.miQ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.miQ = false;
        this.miY = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dqx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.miZ = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.miQ) {
                    PersonCenterGuideView.this.miQ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lUB.setVisibility(4);
                    PersonCenterGuideView.this.miR.startAnimation(PersonCenterGuideView.this.miU);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.miQ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.miR = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.miR.setIsRound(true);
        this.lUB = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.miS = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.miS.setDuration(660L);
        this.miS.setAnimationListener(this.miY);
        this.miT = new AlphaAnimation(0.0f, 1.0f);
        this.miT.setDuration(660L);
        this.miU = new AnimationSet(true);
        this.miU.addAnimation(this.miS);
        this.miU.addAnimation(this.miT);
        this.miQ = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqx() {
        this.lUB.setVisibility(0);
        if (this.miV == null) {
            this.miV = ObjectAnimator.ofFloat(this.lUB, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.miX == null) {
            this.miW = ObjectAnimator.ofFloat(this.lUB, "alpha", 0.0f, 1.0f);
        }
        if (this.miX == null) {
            this.miX = new AnimatorSet();
            this.miX.setDuration(500L);
        }
        this.miX.play(this.miV).with(this.miW);
        this.miX.start();
    }

    public void onChangeSkinType() {
        an.setImageResource(this.miR, R.drawable.person_center_head_guide_circle);
        an.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        an.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        an.setBackgroundResource(this.lUB, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.miX != null) {
            this.miX.cancel();
        }
        if (this.miU != null) {
            this.miU.cancel();
        }
        if (this.miS != null) {
            this.miS.cancel();
        }
        if (this.miT != null) {
            this.miT.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.miZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.miZ);
        clearAnim();
    }

    public void dqy() {
        clearAnim();
        setVisibility(8);
    }
}
