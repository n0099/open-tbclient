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
/* loaded from: classes16.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private View mbU;
    private boolean mqR;
    private TbImageView mqS;
    private RotateAnimation mqT;
    private AlphaAnimation mqU;
    private AnimationSet mqV;
    private ObjectAnimator mqW;
    private ObjectAnimator mqX;
    private AnimatorSet mqY;
    private Animation.AnimationListener mqZ;
    private final CustomMessageListener mra;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.mqR = false;
        this.mqZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dtN();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mra = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mqR) {
                    PersonCenterGuideView.this.mqR = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mbU.setVisibility(4);
                    PersonCenterGuideView.this.mqS.startAnimation(PersonCenterGuideView.this.mqV);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mqR);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mqR = false;
        this.mqZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dtN();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mra = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mqR) {
                    PersonCenterGuideView.this.mqR = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mbU.setVisibility(4);
                    PersonCenterGuideView.this.mqS.startAnimation(PersonCenterGuideView.this.mqV);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mqR);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mqR = false;
        this.mqZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dtN();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mra = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mqR) {
                    PersonCenterGuideView.this.mqR = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mbU.setVisibility(4);
                    PersonCenterGuideView.this.mqS.startAnimation(PersonCenterGuideView.this.mqV);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mqR);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.mqS = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.mqS.setIsRound(true);
        this.mbU = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.mqT = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mqT.setDuration(660L);
        this.mqT.setAnimationListener(this.mqZ);
        this.mqU = new AlphaAnimation(0.0f, 1.0f);
        this.mqU.setDuration(660L);
        this.mqV = new AnimationSet(true);
        this.mqV.addAnimation(this.mqT);
        this.mqV.addAnimation(this.mqU);
        this.mqR = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtN() {
        this.mbU.setVisibility(0);
        if (this.mqW == null) {
            this.mqW = ObjectAnimator.ofFloat(this.mbU, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.mqY == null) {
            this.mqX = ObjectAnimator.ofFloat(this.mbU, "alpha", 0.0f, 1.0f);
        }
        if (this.mqY == null) {
            this.mqY = new AnimatorSet();
            this.mqY.setDuration(500L);
        }
        this.mqY.play(this.mqW).with(this.mqX);
        this.mqY.start();
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.mqS, R.drawable.person_center_head_guide_circle);
        ao.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ao.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ao.setBackgroundResource(this.mbU, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.mqY != null) {
            this.mqY.cancel();
        }
        if (this.mqV != null) {
            this.mqV.cancel();
        }
        if (this.mqT != null) {
            this.mqT.cancel();
        }
        if (this.mqU != null) {
            this.mqU.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mra);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mra);
        clearAnim();
    }

    public void dtO() {
        clearAnim();
        setVisibility(8);
    }
}
