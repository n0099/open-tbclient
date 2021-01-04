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
    private View nFm;
    private boolean nUe;
    private TbImageView nUf;
    private RotateAnimation nUg;
    private AlphaAnimation nUh;
    private AnimationSet nUi;
    private ObjectAnimator nUj;
    private ObjectAnimator nUk;
    private AnimatorSet nUl;
    private Animation.AnimationListener nUm;
    private final CustomMessageListener nUn;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nUe = false;
        this.nUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dXF();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nUn = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nUe) {
                    PersonCenterGuideView.this.nUe = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nFm.setVisibility(4);
                    PersonCenterGuideView.this.nUf.startAnimation(PersonCenterGuideView.this.nUi);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nUe);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nUe = false;
        this.nUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dXF();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nUn = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nUe) {
                    PersonCenterGuideView.this.nUe = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nFm.setVisibility(4);
                    PersonCenterGuideView.this.nUf.startAnimation(PersonCenterGuideView.this.nUi);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nUe);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUe = false;
        this.nUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dXF();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nUn = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nUe) {
                    PersonCenterGuideView.this.nUe = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nFm.setVisibility(4);
                    PersonCenterGuideView.this.nUf.startAnimation(PersonCenterGuideView.this.nUi);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nUe);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nUf = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nUf.setIsRound(true);
        this.nFm = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nUg = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nUg.setDuration(660L);
        this.nUg.setAnimationListener(this.nUm);
        this.nUh = new AlphaAnimation(0.0f, 1.0f);
        this.nUh.setDuration(660L);
        this.nUi = new AnimationSet(true);
        this.nUi.addAnimation(this.nUg);
        this.nUi.addAnimation(this.nUh);
        this.nUe = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXF() {
        this.nFm.setVisibility(0);
        if (this.nUj == null) {
            this.nUj = ObjectAnimator.ofFloat(this.nFm, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nUl == null) {
            this.nUk = ObjectAnimator.ofFloat(this.nFm, "alpha", 0.0f, 1.0f);
        }
        if (this.nUl == null) {
            this.nUl = new AnimatorSet();
            this.nUl.setDuration(500L);
        }
        this.nUl.play(this.nUj).with(this.nUk);
        this.nUl.start();
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.nUf, R.drawable.person_center_head_guide_circle);
        ao.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ao.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.nFm, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nUl != null) {
            this.nUl.cancel();
        }
        if (this.nUi != null) {
            this.nUi.cancel();
        }
        if (this.nUg != null) {
            this.nUg.cancel();
        }
        if (this.nUh != null) {
            this.nUh.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nUn);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nUn);
        clearAnim();
    }

    public void dXG() {
        clearAnim();
        setVisibility(8);
    }
}
