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
/* loaded from: classes21.dex */
public class PersonCenterGuideView extends RelativeLayout {
    private ImageView mCloseBtn;
    private View mDK;
    private TextView mTip;
    private boolean mTm;
    private TbImageView mTn;
    private RotateAnimation mTp;
    private AlphaAnimation mTq;
    private AnimationSet mTr;
    private ObjectAnimator mTs;
    private ObjectAnimator mTt;
    private AnimatorSet mTu;
    private Animation.AnimationListener mTv;
    private final CustomMessageListener mTw;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.mTm = false;
        this.mTv = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dJm();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mTw = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mTm) {
                    PersonCenterGuideView.this.mTm = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mDK.setVisibility(4);
                    PersonCenterGuideView.this.mTn.startAnimation(PersonCenterGuideView.this.mTr);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mTm);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTm = false;
        this.mTv = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dJm();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mTw = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mTm) {
                    PersonCenterGuideView.this.mTm = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mDK.setVisibility(4);
                    PersonCenterGuideView.this.mTn.startAnimation(PersonCenterGuideView.this.mTr);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mTm);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTm = false;
        this.mTv = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dJm();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mTw = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.mTm) {
                    PersonCenterGuideView.this.mTm = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.mDK.setVisibility(4);
                    PersonCenterGuideView.this.mTn.startAnimation(PersonCenterGuideView.this.mTr);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.mTm);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.mTn = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.mTn.setIsRound(true);
        this.mDK = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.mTp = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mTp.setDuration(660L);
        this.mTp.setAnimationListener(this.mTv);
        this.mTq = new AlphaAnimation(0.0f, 1.0f);
        this.mTq.setDuration(660L);
        this.mTr = new AnimationSet(true);
        this.mTr.addAnimation(this.mTp);
        this.mTr.addAnimation(this.mTq);
        this.mTm = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJm() {
        this.mDK.setVisibility(0);
        if (this.mTs == null) {
            this.mTs = ObjectAnimator.ofFloat(this.mDK, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.mTu == null) {
            this.mTt = ObjectAnimator.ofFloat(this.mDK, "alpha", 0.0f, 1.0f);
        }
        if (this.mTu == null) {
            this.mTu = new AnimatorSet();
            this.mTu.setDuration(500L);
        }
        this.mTu.play(this.mTs).with(this.mTt);
        this.mTu.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.mTn, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.mDK, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.mTu != null) {
            this.mTu.cancel();
        }
        if (this.mTr != null) {
            this.mTr.cancel();
        }
        if (this.mTp != null) {
            this.mTp.cancel();
        }
        if (this.mTq != null) {
            this.mTq.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mTw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mTw);
        clearAnim();
    }

    public void dJn() {
        clearAnim();
        setVisibility(8);
    }
}
