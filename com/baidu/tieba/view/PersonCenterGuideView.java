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
    private View nBg;
    private boolean nQJ;
    private TbImageView nQK;
    private RotateAnimation nQL;
    private AlphaAnimation nQM;
    private AnimationSet nQN;
    private ObjectAnimator nQO;
    private ObjectAnimator nQP;
    private AnimatorSet nQQ;
    private Animation.AnimationListener nQR;
    private final CustomMessageListener nQS;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nQJ = false;
        this.nQR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dYc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nQS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nQJ) {
                    PersonCenterGuideView.this.nQJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nBg.setVisibility(4);
                    PersonCenterGuideView.this.nQK.startAnimation(PersonCenterGuideView.this.nQN);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nQJ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQJ = false;
        this.nQR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dYc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nQS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nQJ) {
                    PersonCenterGuideView.this.nQJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nBg.setVisibility(4);
                    PersonCenterGuideView.this.nQK.startAnimation(PersonCenterGuideView.this.nQN);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nQJ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQJ = false;
        this.nQR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dYc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nQS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nQJ) {
                    PersonCenterGuideView.this.nQJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nBg.setVisibility(4);
                    PersonCenterGuideView.this.nQK.startAnimation(PersonCenterGuideView.this.nQN);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nQJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nQK = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nQK.setIsRound(true);
        this.nBg = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nQL = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nQL.setDuration(660L);
        this.nQL.setAnimationListener(this.nQR);
        this.nQM = new AlphaAnimation(0.0f, 1.0f);
        this.nQM.setDuration(660L);
        this.nQN = new AnimationSet(true);
        this.nQN.addAnimation(this.nQL);
        this.nQN.addAnimation(this.nQM);
        this.nQJ = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYc() {
        this.nBg.setVisibility(0);
        if (this.nQO == null) {
            this.nQO = ObjectAnimator.ofFloat(this.nBg, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nQQ == null) {
            this.nQP = ObjectAnimator.ofFloat(this.nBg, "alpha", 0.0f, 1.0f);
        }
        if (this.nQQ == null) {
            this.nQQ = new AnimatorSet();
            this.nQQ.setDuration(500L);
        }
        this.nQQ.play(this.nQO).with(this.nQP);
        this.nQQ.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.nQK, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nBg, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nQQ != null) {
            this.nQQ.cancel();
        }
        if (this.nQN != null) {
            this.nQN.cancel();
        }
        if (this.nQL != null) {
            this.nQL.cancel();
        }
        if (this.nQM != null) {
            this.nQM.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nQS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nQS);
        clearAnim();
    }

    public void dYd() {
        clearAnim();
        setVisibility(8);
    }
}
