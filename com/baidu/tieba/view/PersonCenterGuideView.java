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
/* loaded from: classes16.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private boolean mJf;
    private TbImageView mJg;
    private RotateAnimation mJh;
    private AlphaAnimation mJi;
    private AnimationSet mJj;
    private ObjectAnimator mJk;
    private ObjectAnimator mJl;
    private AnimatorSet mJm;
    private Animation.AnimationListener mJn;
    private final CustomMessageListener mJo;
    private TextView mTip;
    private View mtH;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.mJf = false;
        this.mJn = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dFj();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mJo = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mJf) {
                    PersonCenterGuideView.this.mJf = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mtH.setVisibility(4);
                    PersonCenterGuideView.this.mJg.startAnimation(PersonCenterGuideView.this.mJj);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mJf);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mJf = false;
        this.mJn = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dFj();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mJo = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mJf) {
                    PersonCenterGuideView.this.mJf = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mtH.setVisibility(4);
                    PersonCenterGuideView.this.mJg.startAnimation(PersonCenterGuideView.this.mJj);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mJf);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJf = false;
        this.mJn = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dFj();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mJo = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mJf) {
                    PersonCenterGuideView.this.mJf = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mtH.setVisibility(4);
                    PersonCenterGuideView.this.mJg.startAnimation(PersonCenterGuideView.this.mJj);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mJf);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.mJg = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.mJg.setIsRound(true);
        this.mtH = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.mJh = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mJh.setDuration(660L);
        this.mJh.setAnimationListener(this.mJn);
        this.mJi = new AlphaAnimation(0.0f, 1.0f);
        this.mJi.setDuration(660L);
        this.mJj = new AnimationSet(true);
        this.mJj.addAnimation(this.mJh);
        this.mJj.addAnimation(this.mJi);
        this.mJf = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFj() {
        this.mtH.setVisibility(0);
        if (this.mJk == null) {
            this.mJk = ObjectAnimator.ofFloat(this.mtH, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.mJm == null) {
            this.mJl = ObjectAnimator.ofFloat(this.mtH, "alpha", 0.0f, 1.0f);
        }
        if (this.mJm == null) {
            this.mJm = new AnimatorSet();
            this.mJm.setDuration(500L);
        }
        this.mJm.play(this.mJk).with(this.mJl);
        this.mJm.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.mJg, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.mtH, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.mJm != null) {
            this.mJm.cancel();
        }
        if (this.mJj != null) {
            this.mJj.cancel();
        }
        if (this.mJh != null) {
            this.mJh.cancel();
        }
        if (this.mJi != null) {
            this.mJi.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mJo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mJo);
        clearAnim();
    }

    public void dFk() {
        clearAnim();
        setVisibility(8);
    }
}
