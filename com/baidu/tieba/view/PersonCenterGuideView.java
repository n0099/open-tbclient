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
    private boolean lNJ;
    private TbImageView lNK;
    private RotateAnimation lNL;
    private AlphaAnimation lNM;
    private AnimationSet lNN;
    private ObjectAnimator lNO;
    private ObjectAnimator lNP;
    private AnimatorSet lNQ;
    private Animation.AnimationListener lNR;
    private final CustomMessageListener lNS;
    private View lzM;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.lNJ = false;
        this.lNR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dlV();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lNS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lNJ) {
                    PersonCenterGuideView.this.lNJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lzM.setVisibility(4);
                    PersonCenterGuideView.this.lNK.startAnimation(PersonCenterGuideView.this.lNN);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lNJ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lNJ = false;
        this.lNR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dlV();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lNS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lNJ) {
                    PersonCenterGuideView.this.lNJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lzM.setVisibility(4);
                    PersonCenterGuideView.this.lNK.startAnimation(PersonCenterGuideView.this.lNN);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lNJ);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lNJ = false;
        this.lNR = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dlV();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lNS = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.lNJ) {
                    PersonCenterGuideView.this.lNJ = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lzM.setVisibility(4);
                    PersonCenterGuideView.this.lNK.startAnimation(PersonCenterGuideView.this.lNN);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.lNJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.lNK = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.lNK.setIsRound(true);
        this.lzM = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.lNL = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.lNL.setDuration(660L);
        this.lNL.setAnimationListener(this.lNR);
        this.lNM = new AlphaAnimation(0.0f, 1.0f);
        this.lNM.setDuration(660L);
        this.lNN = new AnimationSet(true);
        this.lNN.addAnimation(this.lNL);
        this.lNN.addAnimation(this.lNM);
        this.lNJ = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlV() {
        this.lzM.setVisibility(0);
        if (this.lNO == null) {
            this.lNO = ObjectAnimator.ofFloat(this.lzM, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.lNQ == null) {
            this.lNP = ObjectAnimator.ofFloat(this.lzM, "alpha", 0.0f, 1.0f);
        }
        if (this.lNQ == null) {
            this.lNQ = new AnimatorSet();
            this.lNQ.setDuration(500L);
        }
        this.lNQ.play(this.lNO).with(this.lNP);
        this.lNQ.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.lNK, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.lzM, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.lNQ != null) {
            this.lNQ.cancel();
        }
        if (this.lNN != null) {
            this.lNN.cancel();
        }
        if (this.lNL != null) {
            this.lNL.cancel();
        }
        if (this.lNM != null) {
            this.lNM.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lNS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lNS);
        clearAnim();
    }

    public void dlW() {
        clearAnim();
        setVisibility(8);
    }
}
