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
    private boolean kIS;
    private TbImageView kIT;
    private RotateAnimation kIU;
    private AlphaAnimation kIV;
    private AnimationSet kIW;
    private ObjectAnimator kIX;
    private ObjectAnimator kIY;
    private AnimatorSet kIZ;
    private Animation.AnimationListener kJa;
    private final CustomMessageListener kJb;
    private View kvg;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kIS = false;
        this.kJa = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTy();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kJb = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIS) {
                    PersonCenterGuideView.this.kIS = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kvg.setVisibility(4);
                    PersonCenterGuideView.this.kIT.startAnimation(PersonCenterGuideView.this.kIW);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIS);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIS = false;
        this.kJa = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTy();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kJb = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIS) {
                    PersonCenterGuideView.this.kIS = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kvg.setVisibility(4);
                    PersonCenterGuideView.this.kIT.startAnimation(PersonCenterGuideView.this.kIW);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIS);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIS = false;
        this.kJa = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTy();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kJb = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIS) {
                    PersonCenterGuideView.this.kIS = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kvg.setVisibility(4);
                    PersonCenterGuideView.this.kIT.startAnimation(PersonCenterGuideView.this.kIW);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIS);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kIT = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kIT.setIsRound(true);
        this.kvg = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kIU = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kIU.setDuration(660L);
        this.kIU.setAnimationListener(this.kJa);
        this.kIV = new AlphaAnimation(0.0f, 1.0f);
        this.kIV.setDuration(660L);
        this.kIW = new AnimationSet(true);
        this.kIW.addAnimation(this.kIU);
        this.kIW.addAnimation(this.kIV);
        this.kIS = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTy() {
        this.kvg.setVisibility(0);
        if (this.kIX == null) {
            this.kIX = ObjectAnimator.ofFloat(this.kvg, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kIZ == null) {
            this.kIY = ObjectAnimator.ofFloat(this.kvg, "alpha", 0.0f, 1.0f);
        }
        if (this.kIZ == null) {
            this.kIZ = new AnimatorSet();
            this.kIZ.setDuration(500L);
        }
        this.kIZ.play(this.kIX).with(this.kIY);
        this.kIZ.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kIT, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kvg, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kIZ != null) {
            this.kIZ.cancel();
        }
        if (this.kIW != null) {
            this.kIW.cancel();
        }
        if (this.kIU != null) {
            this.kIU.cancel();
        }
        if (this.kIV != null) {
            this.kIV.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kJb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kJb);
        clearAnim();
    }

    public void cTz() {
        clearAnim();
        setVisibility(8);
    }
}
