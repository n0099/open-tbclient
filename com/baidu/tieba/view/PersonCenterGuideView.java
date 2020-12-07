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
    private View nBe;
    private boolean nQH;
    private TbImageView nQI;
    private RotateAnimation nQJ;
    private AlphaAnimation nQK;
    private AnimationSet nQL;
    private ObjectAnimator nQM;
    private ObjectAnimator nQN;
    private AnimatorSet nQO;
    private Animation.AnimationListener nQP;
    private final CustomMessageListener nQQ;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nQH = false;
        this.nQP = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dYb();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nQQ = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nQH) {
                    PersonCenterGuideView.this.nQH = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nBe.setVisibility(4);
                    PersonCenterGuideView.this.nQI.startAnimation(PersonCenterGuideView.this.nQL);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nQH);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQH = false;
        this.nQP = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dYb();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nQQ = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nQH) {
                    PersonCenterGuideView.this.nQH = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nBe.setVisibility(4);
                    PersonCenterGuideView.this.nQI.startAnimation(PersonCenterGuideView.this.nQL);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nQH);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQH = false;
        this.nQP = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dYb();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nQQ = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nQH) {
                    PersonCenterGuideView.this.nQH = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nBe.setVisibility(4);
                    PersonCenterGuideView.this.nQI.startAnimation(PersonCenterGuideView.this.nQL);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nQH);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nQI = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nQI.setIsRound(true);
        this.nBe = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nQJ = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nQJ.setDuration(660L);
        this.nQJ.setAnimationListener(this.nQP);
        this.nQK = new AlphaAnimation(0.0f, 1.0f);
        this.nQK.setDuration(660L);
        this.nQL = new AnimationSet(true);
        this.nQL.addAnimation(this.nQJ);
        this.nQL.addAnimation(this.nQK);
        this.nQH = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYb() {
        this.nBe.setVisibility(0);
        if (this.nQM == null) {
            this.nQM = ObjectAnimator.ofFloat(this.nBe, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nQO == null) {
            this.nQN = ObjectAnimator.ofFloat(this.nBe, "alpha", 0.0f, 1.0f);
        }
        if (this.nQO == null) {
            this.nQO = new AnimatorSet();
            this.nQO.setDuration(500L);
        }
        this.nQO.play(this.nQM).with(this.nQN);
        this.nQO.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.nQI, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nBe, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nQO != null) {
            this.nQO.cancel();
        }
        if (this.nQL != null) {
            this.nQL.cancel();
        }
        if (this.nQJ != null) {
            this.nQJ.cancel();
        }
        if (this.nQK != null) {
            this.nQK.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nQQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nQQ);
        clearAnim();
    }

    public void dYc() {
        clearAnim();
        setVisibility(8);
    }
}
