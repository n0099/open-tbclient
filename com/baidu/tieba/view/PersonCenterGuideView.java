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
/* loaded from: classes6.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private boolean kEd;
    private TbImageView kEe;
    private RotateAnimation kEf;
    private AlphaAnimation kEg;
    private AnimationSet kEh;
    private ObjectAnimator kEi;
    private ObjectAnimator kEj;
    private AnimatorSet kEk;
    private Animation.AnimationListener kEl;
    private final CustomMessageListener kEm;
    private View kqn;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kEd = false;
        this.kEl = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cQV();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kEm = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kEd) {
                    PersonCenterGuideView.this.kEd = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kqn.setVisibility(4);
                    PersonCenterGuideView.this.kEe.startAnimation(PersonCenterGuideView.this.kEh);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kEd);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kEd = false;
        this.kEl = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cQV();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kEm = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kEd) {
                    PersonCenterGuideView.this.kEd = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kqn.setVisibility(4);
                    PersonCenterGuideView.this.kEe.startAnimation(PersonCenterGuideView.this.kEh);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kEd);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kEd = false;
        this.kEl = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cQV();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kEm = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kEd) {
                    PersonCenterGuideView.this.kEd = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kqn.setVisibility(4);
                    PersonCenterGuideView.this.kEe.startAnimation(PersonCenterGuideView.this.kEh);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kEd);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kEe = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kEe.setIsRound(true);
        this.kqn = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kEf = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kEf.setDuration(660L);
        this.kEf.setAnimationListener(this.kEl);
        this.kEg = new AlphaAnimation(0.0f, 1.0f);
        this.kEg.setDuration(660L);
        this.kEh = new AnimationSet(true);
        this.kEh.addAnimation(this.kEf);
        this.kEh.addAnimation(this.kEg);
        this.kEd = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQV() {
        this.kqn.setVisibility(0);
        if (this.kEi == null) {
            this.kEi = ObjectAnimator.ofFloat(this.kqn, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kEk == null) {
            this.kEj = ObjectAnimator.ofFloat(this.kqn, "alpha", 0.0f, 1.0f);
        }
        if (this.kEk == null) {
            this.kEk = new AnimatorSet();
            this.kEk.setDuration(500L);
        }
        this.kEk.play(this.kEi).with(this.kEj);
        this.kEk.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kEe, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kqn, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kEk != null) {
            this.kEk.cancel();
        }
        if (this.kEh != null) {
            this.kEh.cancel();
        }
        if (this.kEf != null) {
            this.kEf.cancel();
        }
        if (this.kEg != null) {
            this.kEg.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kEm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kEm);
        clearAnim();
    }

    public void cQW() {
        clearAnim();
        setVisibility(8);
    }
}
