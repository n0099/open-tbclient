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
    private boolean kIE;
    private TbImageView kIF;
    private RotateAnimation kIG;
    private AlphaAnimation kIH;
    private AnimationSet kII;
    private ObjectAnimator kIJ;
    private ObjectAnimator kIK;
    private AnimatorSet kIL;
    private Animation.AnimationListener kIM;
    private final CustomMessageListener kIN;
    private View kuS;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kIE = false;
        this.kIM = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTv();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kIN = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIE) {
                    PersonCenterGuideView.this.kIE = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kuS.setVisibility(4);
                    PersonCenterGuideView.this.kIF.startAnimation(PersonCenterGuideView.this.kII);
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIE);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIE = false;
        this.kIM = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTv();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kIN = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIE) {
                    PersonCenterGuideView.this.kIE = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kuS.setVisibility(4);
                    PersonCenterGuideView.this.kIF.startAnimation(PersonCenterGuideView.this.kII);
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIE);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIE = false;
        this.kIM = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTv();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kIN = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIE) {
                    PersonCenterGuideView.this.kIE = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kuS.setVisibility(4);
                    PersonCenterGuideView.this.kIF.startAnimation(PersonCenterGuideView.this.kII);
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIE);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kIF = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kIF.setIsRound(true);
        this.kuS = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kIG = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kIG.setDuration(660L);
        this.kIG.setAnimationListener(this.kIM);
        this.kIH = new AlphaAnimation(0.0f, 1.0f);
        this.kIH.setDuration(660L);
        this.kII = new AnimationSet(true);
        this.kII.addAnimation(this.kIG);
        this.kII.addAnimation(this.kIH);
        this.kIE = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTv() {
        this.kuS.setVisibility(0);
        if (this.kIJ == null) {
            this.kIJ = ObjectAnimator.ofFloat(this.kuS, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kIL == null) {
            this.kIK = ObjectAnimator.ofFloat(this.kuS, "alpha", 0.0f, 1.0f);
        }
        if (this.kIL == null) {
            this.kIL = new AnimatorSet();
            this.kIL.setDuration(500L);
        }
        this.kIL.play(this.kIJ).with(this.kIK);
        this.kIL.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kIF, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kuS, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kIL != null) {
            this.kIL.cancel();
        }
        if (this.kII != null) {
            this.kII.cancel();
        }
        if (this.kIG != null) {
            this.kIG.cancel();
        }
        if (this.kIH != null) {
            this.kIH.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kIN);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kIN);
        clearAnim();
    }

    public void cTw() {
        clearAnim();
        setVisibility(8);
    }
}
