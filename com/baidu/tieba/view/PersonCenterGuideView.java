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
    private View nAH;
    private TbImageView nPA;
    private RotateAnimation nPB;
    private AlphaAnimation nPC;
    private AnimationSet nPD;
    private ObjectAnimator nPE;
    private ObjectAnimator nPF;
    private AnimatorSet nPG;
    private Animation.AnimationListener nPH;
    private final CustomMessageListener nPI;
    private boolean nPz;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nPz = false;
        this.nPH = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dTO();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nPI = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nPz) {
                    PersonCenterGuideView.this.nPz = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nAH.setVisibility(4);
                    PersonCenterGuideView.this.nPA.startAnimation(PersonCenterGuideView.this.nPD);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nPz);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nPz = false;
        this.nPH = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dTO();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nPI = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nPz) {
                    PersonCenterGuideView.this.nPz = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nAH.setVisibility(4);
                    PersonCenterGuideView.this.nPA.startAnimation(PersonCenterGuideView.this.nPD);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nPz);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nPz = false;
        this.nPH = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dTO();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nPI = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nPz) {
                    PersonCenterGuideView.this.nPz = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nAH.setVisibility(4);
                    PersonCenterGuideView.this.nPA.startAnimation(PersonCenterGuideView.this.nPD);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nPz);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nPA = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nPA.setIsRound(true);
        this.nAH = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nPB = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nPB.setDuration(660L);
        this.nPB.setAnimationListener(this.nPH);
        this.nPC = new AlphaAnimation(0.0f, 1.0f);
        this.nPC.setDuration(660L);
        this.nPD = new AnimationSet(true);
        this.nPD.addAnimation(this.nPB);
        this.nPD.addAnimation(this.nPC);
        this.nPz = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTO() {
        this.nAH.setVisibility(0);
        if (this.nPE == null) {
            this.nPE = ObjectAnimator.ofFloat(this.nAH, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nPG == null) {
            this.nPF = ObjectAnimator.ofFloat(this.nAH, "alpha", 0.0f, 1.0f);
        }
        if (this.nPG == null) {
            this.nPG = new AnimatorSet();
            this.nPG.setDuration(500L);
        }
        this.nPG.play(this.nPE).with(this.nPF);
        this.nPG.start();
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.nPA, R.drawable.person_center_head_guide_circle);
        ao.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ao.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.nAH, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nPG != null) {
            this.nPG.cancel();
        }
        if (this.nPD != null) {
            this.nPD.cancel();
        }
        if (this.nPB != null) {
            this.nPB.cancel();
        }
        if (this.nPC != null) {
            this.nPC.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nPI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nPI);
        clearAnim();
    }

    public void dTP() {
        clearAnim();
        setVisibility(8);
    }
}
