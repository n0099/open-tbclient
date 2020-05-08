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
    private View lhb;
    private boolean lva;
    private TbImageView lvb;
    private RotateAnimation lvc;
    private AlphaAnimation lvd;
    private AnimationSet lve;
    private ObjectAnimator lvf;
    private ObjectAnimator lvg;
    private AnimatorSet lvh;
    private Animation.AnimationListener lvi;
    private final CustomMessageListener lvj;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.lva = false;
        this.lvi = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.deE();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lvj = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lva) {
                    PersonCenterGuideView.this.lva = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lhb.setVisibility(4);
                    PersonCenterGuideView.this.lvb.startAnimation(PersonCenterGuideView.this.lve);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lva);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lva = false;
        this.lvi = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.deE();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lvj = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lva) {
                    PersonCenterGuideView.this.lva = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lhb.setVisibility(4);
                    PersonCenterGuideView.this.lvb.startAnimation(PersonCenterGuideView.this.lve);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lva);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lva = false;
        this.lvi = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.deE();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lvj = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lva) {
                    PersonCenterGuideView.this.lva = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lhb.setVisibility(4);
                    PersonCenterGuideView.this.lvb.startAnimation(PersonCenterGuideView.this.lve);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lva);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.lvb = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.lvb.setIsRound(true);
        this.lhb = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.lvc = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.lvc.setDuration(660L);
        this.lvc.setAnimationListener(this.lvi);
        this.lvd = new AlphaAnimation(0.0f, 1.0f);
        this.lvd.setDuration(660L);
        this.lve = new AnimationSet(true);
        this.lve.addAnimation(this.lvc);
        this.lve.addAnimation(this.lvd);
        this.lva = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deE() {
        this.lhb.setVisibility(0);
        if (this.lvf == null) {
            this.lvf = ObjectAnimator.ofFloat(this.lhb, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.lvh == null) {
            this.lvg = ObjectAnimator.ofFloat(this.lhb, "alpha", 0.0f, 1.0f);
        }
        if (this.lvh == null) {
            this.lvh = new AnimatorSet();
            this.lvh.setDuration(500L);
        }
        this.lvh.play(this.lvf).with(this.lvg);
        this.lvh.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.lvb, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.lhb, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.lvh != null) {
            this.lvh.cancel();
        }
        if (this.lve != null) {
            this.lve.cancel();
        }
        if (this.lvc != null) {
            this.lvc.cancel();
        }
        if (this.lvd != null) {
            this.lvd.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lvj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lvj);
        clearAnim();
    }

    public void deF() {
        clearAnim();
        setVisibility(8);
    }
}
