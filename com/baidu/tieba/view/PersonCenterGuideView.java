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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private View nFl;
    private boolean nUd;
    private TbImageView nUe;
    private RotateAnimation nUf;
    private AlphaAnimation nUg;
    private AnimationSet nUh;
    private ObjectAnimator nUi;
    private ObjectAnimator nUj;
    private AnimatorSet nUk;
    private Animation.AnimationListener nUl;
    private final CustomMessageListener nUm;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nUd = false;
        this.nUl = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dXG();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nUm = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nUd) {
                    PersonCenterGuideView.this.nUd = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nFl.setVisibility(4);
                    PersonCenterGuideView.this.nUe.startAnimation(PersonCenterGuideView.this.nUh);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nUd);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nUd = false;
        this.nUl = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dXG();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nUm = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nUd) {
                    PersonCenterGuideView.this.nUd = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nFl.setVisibility(4);
                    PersonCenterGuideView.this.nUe.startAnimation(PersonCenterGuideView.this.nUh);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nUd);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUd = false;
        this.nUl = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dXG();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nUm = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nUd) {
                    PersonCenterGuideView.this.nUd = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nFl.setVisibility(4);
                    PersonCenterGuideView.this.nUe.startAnimation(PersonCenterGuideView.this.nUh);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nUd);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nUe = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nUe.setIsRound(true);
        this.nFl = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nUf = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nUf.setDuration(660L);
        this.nUf.setAnimationListener(this.nUl);
        this.nUg = new AlphaAnimation(0.0f, 1.0f);
        this.nUg.setDuration(660L);
        this.nUh = new AnimationSet(true);
        this.nUh.addAnimation(this.nUf);
        this.nUh.addAnimation(this.nUg);
        this.nUd = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXG() {
        this.nFl.setVisibility(0);
        if (this.nUi == null) {
            this.nUi = ObjectAnimator.ofFloat(this.nFl, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nUk == null) {
            this.nUj = ObjectAnimator.ofFloat(this.nFl, "alpha", 0.0f, 1.0f);
        }
        if (this.nUk == null) {
            this.nUk = new AnimatorSet();
            this.nUk.setDuration(500L);
        }
        this.nUk.play(this.nUi).with(this.nUj);
        this.nUk.start();
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.nUe, R.drawable.person_center_head_guide_circle);
        ao.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ao.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.nFl, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nUk != null) {
            this.nUk.cancel();
        }
        if (this.nUh != null) {
            this.nUh.cancel();
        }
        if (this.nUf != null) {
            this.nUf.cancel();
        }
        if (this.nUg != null) {
            this.nUg.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nUm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nUm);
        clearAnim();
    }

    public void dXH() {
        clearAnim();
        setVisibility(8);
    }
}
