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
/* loaded from: classes2.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private TextView mTip;
    private View nMW;
    private boolean ocj;
    private TbImageView ock;
    private RotateAnimation ocl;
    private AlphaAnimation ocm;
    private AnimationSet ocn;
    private ObjectAnimator oco;
    private ObjectAnimator ocp;
    private AnimatorSet ocq;
    private Animation.AnimationListener ocs;
    private final CustomMessageListener oct;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.ocj = false;
        this.ocs = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oct = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.ocj) {
                    PersonCenterGuideView.this.ocj = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nMW.setVisibility(4);
                    PersonCenterGuideView.this.ock.startAnimation(PersonCenterGuideView.this.ocn);
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.ocj);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ocj = false;
        this.ocs = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oct = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.ocj) {
                    PersonCenterGuideView.this.ocj = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nMW.setVisibility(4);
                    PersonCenterGuideView.this.ock.startAnimation(PersonCenterGuideView.this.ocn);
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.ocj);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ocj = false;
        this.ocs = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWs();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oct = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.ocj) {
                    PersonCenterGuideView.this.ocj = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nMW.setVisibility(4);
                    PersonCenterGuideView.this.ock.startAnimation(PersonCenterGuideView.this.ocn);
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.ocj);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.ock = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.ock.setIsRound(true);
        this.nMW = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.ocl = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.ocl.setDuration(660L);
        this.ocl.setAnimationListener(this.ocs);
        this.ocm = new AlphaAnimation(0.0f, 1.0f);
        this.ocm.setDuration(660L);
        this.ocn = new AnimationSet(true);
        this.ocn.addAnimation(this.ocl);
        this.ocn.addAnimation(this.ocm);
        this.ocj = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWs() {
        this.nMW.setVisibility(0);
        if (this.oco == null) {
            this.oco = ObjectAnimator.ofFloat(this.nMW, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.ocq == null) {
            this.ocp = ObjectAnimator.ofFloat(this.nMW, "alpha", 0.0f, 1.0f);
        }
        if (this.ocq == null) {
            this.ocq = new AnimatorSet();
            this.ocq.setDuration(500L);
        }
        this.ocq.play(this.oco).with(this.ocp);
        this.ocq.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.ock, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nMW, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.ocq != null) {
            this.ocq.cancel();
        }
        if (this.ocn != null) {
            this.ocn.cancel();
        }
        if (this.ocl != null) {
            this.ocl.cancel();
        }
        if (this.ocm != null) {
            this.ocm.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.oct);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.oct);
        clearAnim();
    }

    public void dWt() {
        clearAnim();
        setVisibility(8);
    }
}
