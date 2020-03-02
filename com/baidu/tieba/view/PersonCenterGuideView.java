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
    private boolean kIG;
    private TbImageView kIH;
    private RotateAnimation kII;
    private AlphaAnimation kIJ;
    private AnimationSet kIK;
    private ObjectAnimator kIL;
    private ObjectAnimator kIM;
    private AnimatorSet kIN;
    private Animation.AnimationListener kIO;
    private final CustomMessageListener kIP;
    private View kuU;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.kIG = false;
        this.kIO = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kIP = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIG) {
                    PersonCenterGuideView.this.kIG = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kuU.setVisibility(4);
                    PersonCenterGuideView.this.kIH.startAnimation(PersonCenterGuideView.this.kIK);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIG);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIG = false;
        this.kIO = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kIP = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIG) {
                    PersonCenterGuideView.this.kIG = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kuU.setVisibility(4);
                    PersonCenterGuideView.this.kIH.startAnimation(PersonCenterGuideView.this.kIK);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIG);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIG = false;
        this.kIO = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.cTx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kIP = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.kIG) {
                    PersonCenterGuideView.this.kIG = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.kuU.setVisibility(4);
                    PersonCenterGuideView.this.kIH.startAnimation(PersonCenterGuideView.this.kIK);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.kIG);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.kIH = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.kIH.setIsRound(true);
        this.kuU = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.kII = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.kII.setDuration(660L);
        this.kII.setAnimationListener(this.kIO);
        this.kIJ = new AlphaAnimation(0.0f, 1.0f);
        this.kIJ.setDuration(660L);
        this.kIK = new AnimationSet(true);
        this.kIK.addAnimation(this.kII);
        this.kIK.addAnimation(this.kIJ);
        this.kIG = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTx() {
        this.kuU.setVisibility(0);
        if (this.kIL == null) {
            this.kIL = ObjectAnimator.ofFloat(this.kuU, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.kIN == null) {
            this.kIM = ObjectAnimator.ofFloat(this.kuU, "alpha", 0.0f, 1.0f);
        }
        if (this.kIN == null) {
            this.kIN = new AnimatorSet();
            this.kIN.setDuration(500L);
        }
        this.kIN.play(this.kIL).with(this.kIM);
        this.kIN.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.kIH, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kuU, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.kIN != null) {
            this.kIN.cancel();
        }
        if (this.kIK != null) {
            this.kIK.cancel();
        }
        if (this.kII != null) {
            this.kII.cancel();
        }
        if (this.kIJ != null) {
            this.kIJ.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.kIP);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.kIP);
        clearAnim();
    }

    public void cTy() {
        clearAnim();
        setVisibility(8);
    }
}
