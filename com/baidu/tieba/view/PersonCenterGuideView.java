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
/* loaded from: classes22.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private View mTx;
    private boolean niN;
    private TbImageView niO;
    private RotateAnimation niP;
    private AlphaAnimation niQ;
    private AnimationSet niR;
    private ObjectAnimator niS;
    private ObjectAnimator niT;
    private AnimatorSet niU;
    private Animation.AnimationListener niV;
    private final CustomMessageListener niW;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.niN = false;
        this.niV = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dMY();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.niW = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.niN) {
                    PersonCenterGuideView.this.niN = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mTx.setVisibility(4);
                    PersonCenterGuideView.this.niO.startAnimation(PersonCenterGuideView.this.niR);
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.niN);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.niN = false;
        this.niV = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dMY();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.niW = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.niN) {
                    PersonCenterGuideView.this.niN = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mTx.setVisibility(4);
                    PersonCenterGuideView.this.niO.startAnimation(PersonCenterGuideView.this.niR);
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.niN);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.niN = false;
        this.niV = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dMY();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.niW = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.niN) {
                    PersonCenterGuideView.this.niN = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mTx.setVisibility(4);
                    PersonCenterGuideView.this.niO.startAnimation(PersonCenterGuideView.this.niR);
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.niN);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.niO = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.niO.setIsRound(true);
        this.mTx = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.niP = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.niP.setDuration(660L);
        this.niP.setAnimationListener(this.niV);
        this.niQ = new AlphaAnimation(0.0f, 1.0f);
        this.niQ.setDuration(660L);
        this.niR = new AnimationSet(true);
        this.niR.addAnimation(this.niP);
        this.niR.addAnimation(this.niQ);
        this.niN = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMY() {
        this.mTx.setVisibility(0);
        if (this.niS == null) {
            this.niS = ObjectAnimator.ofFloat(this.mTx, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.niU == null) {
            this.niT = ObjectAnimator.ofFloat(this.mTx, "alpha", 0.0f, 1.0f);
        }
        if (this.niU == null) {
            this.niU = new AnimatorSet();
            this.niU.setDuration(500L);
        }
        this.niU.play(this.niS).with(this.niT);
        this.niU.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.niO, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.mTx, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.niU != null) {
            this.niU.cancel();
        }
        if (this.niR != null) {
            this.niR.cancel();
        }
        if (this.niP != null) {
            this.niP.cancel();
        }
        if (this.niQ != null) {
            this.niQ.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.niW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.niW);
        clearAnim();
    }

    public void dMZ() {
        clearAnim();
        setVisibility(8);
    }
}
