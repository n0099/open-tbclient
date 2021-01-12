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
    private View nAG;
    private RotateAnimation nPA;
    private AlphaAnimation nPB;
    private AnimationSet nPC;
    private ObjectAnimator nPD;
    private ObjectAnimator nPE;
    private AnimatorSet nPF;
    private Animation.AnimationListener nPG;
    private final CustomMessageListener nPH;
    private boolean nPy;
    private TbImageView nPz;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nPy = false;
        this.nPG = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
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
        this.nPH = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nPy) {
                    PersonCenterGuideView.this.nPy = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nAG.setVisibility(4);
                    PersonCenterGuideView.this.nPz.startAnimation(PersonCenterGuideView.this.nPC);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nPy);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nPy = false;
        this.nPG = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
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
        this.nPH = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nPy) {
                    PersonCenterGuideView.this.nPy = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nAG.setVisibility(4);
                    PersonCenterGuideView.this.nPz.startAnimation(PersonCenterGuideView.this.nPC);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nPy);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nPy = false;
        this.nPG = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
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
        this.nPH = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nPy) {
                    PersonCenterGuideView.this.nPy = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nAG.setVisibility(4);
                    PersonCenterGuideView.this.nPz.startAnimation(PersonCenterGuideView.this.nPC);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nPy);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nPz = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nPz.setIsRound(true);
        this.nAG = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nPA = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nPA.setDuration(660L);
        this.nPA.setAnimationListener(this.nPG);
        this.nPB = new AlphaAnimation(0.0f, 1.0f);
        this.nPB.setDuration(660L);
        this.nPC = new AnimationSet(true);
        this.nPC.addAnimation(this.nPA);
        this.nPC.addAnimation(this.nPB);
        this.nPy = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTO() {
        this.nAG.setVisibility(0);
        if (this.nPD == null) {
            this.nPD = ObjectAnimator.ofFloat(this.nAG, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nPF == null) {
            this.nPE = ObjectAnimator.ofFloat(this.nAG, "alpha", 0.0f, 1.0f);
        }
        if (this.nPF == null) {
            this.nPF = new AnimatorSet();
            this.nPF.setDuration(500L);
        }
        this.nPF.play(this.nPD).with(this.nPE);
        this.nPF.start();
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.nPz, R.drawable.person_center_head_guide_circle);
        ao.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ao.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.nAG, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nPF != null) {
            this.nPF.cancel();
        }
        if (this.nPC != null) {
            this.nPC.cancel();
        }
        if (this.nPA != null) {
            this.nPA.cancel();
        }
        if (this.nPB != null) {
            this.nPB.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nPH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nPH);
        clearAnim();
    }

    public void dTP() {
        clearAnim();
        setVisibility(8);
    }
}
