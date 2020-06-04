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
    private View lAV;
    private boolean lOR;
    private TbImageView lOS;
    private RotateAnimation lOT;
    private AlphaAnimation lOU;
    private AnimationSet lOV;
    private ObjectAnimator lOW;
    private ObjectAnimator lOX;
    private AnimatorSet lOY;
    private Animation.AnimationListener lOZ;
    private final CustomMessageListener lPa;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.lOR = false;
        this.lOZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dmk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lPa = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lOR) {
                    PersonCenterGuideView.this.lOR = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lAV.setVisibility(4);
                    PersonCenterGuideView.this.lOS.startAnimation(PersonCenterGuideView.this.lOV);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lOR);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lOR = false;
        this.lOZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dmk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lPa = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lOR) {
                    PersonCenterGuideView.this.lOR = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lAV.setVisibility(4);
                    PersonCenterGuideView.this.lOS.startAnimation(PersonCenterGuideView.this.lOV);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lOR);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lOR = false;
        this.lOZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dmk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lPa = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lOR) {
                    PersonCenterGuideView.this.lOR = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lAV.setVisibility(4);
                    PersonCenterGuideView.this.lOS.startAnimation(PersonCenterGuideView.this.lOV);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lOR);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.lOS = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.lOS.setIsRound(true);
        this.lAV = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.lOT = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.lOT.setDuration(660L);
        this.lOT.setAnimationListener(this.lOZ);
        this.lOU = new AlphaAnimation(0.0f, 1.0f);
        this.lOU.setDuration(660L);
        this.lOV = new AnimationSet(true);
        this.lOV.addAnimation(this.lOT);
        this.lOV.addAnimation(this.lOU);
        this.lOR = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmk() {
        this.lAV.setVisibility(0);
        if (this.lOW == null) {
            this.lOW = ObjectAnimator.ofFloat(this.lAV, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.lOY == null) {
            this.lOX = ObjectAnimator.ofFloat(this.lAV, "alpha", 0.0f, 1.0f);
        }
        if (this.lOY == null) {
            this.lOY = new AnimatorSet();
            this.lOY.setDuration(500L);
        }
        this.lOY.play(this.lOW).with(this.lOX);
        this.lOY.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.lOS, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.lAV, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.lOY != null) {
            this.lOY.cancel();
        }
        if (this.lOV != null) {
            this.lOV.cancel();
        }
        if (this.lOT != null) {
            this.lOT.cancel();
        }
        if (this.lOU != null) {
            this.lOU.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lPa);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lPa);
        clearAnim();
    }

    public void dml() {
        clearAnim();
        setVisibility(8);
    }
}
