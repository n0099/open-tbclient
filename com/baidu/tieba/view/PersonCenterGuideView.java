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
    private View nfY;
    private boolean nvo;
    private TbImageView nvp;
    private RotateAnimation nvq;
    private AlphaAnimation nvr;
    private AnimationSet nvs;
    private ObjectAnimator nvt;
    private ObjectAnimator nvu;
    private AnimatorSet nvv;
    private Animation.AnimationListener nvw;
    private final CustomMessageListener nvx;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.nvo = false;
        this.nvw = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dQg();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nvx = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nvo) {
                    PersonCenterGuideView.this.nvo = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nfY.setVisibility(4);
                    PersonCenterGuideView.this.nvp.startAnimation(PersonCenterGuideView.this.nvs);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nvo);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvo = false;
        this.nvw = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dQg();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nvx = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nvo) {
                    PersonCenterGuideView.this.nvo = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nfY.setVisibility(4);
                    PersonCenterGuideView.this.nvp.startAnimation(PersonCenterGuideView.this.nvs);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nvo);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvo = false;
        this.nvw = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dQg();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nvx = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.nvo) {
                    PersonCenterGuideView.this.nvo = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nfY.setVisibility(4);
                    PersonCenterGuideView.this.nvp.startAnimation(PersonCenterGuideView.this.nvs);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.nvo);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.nvp = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.nvp.setIsRound(true);
        this.nfY = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.nvq = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.nvq.setDuration(660L);
        this.nvq.setAnimationListener(this.nvw);
        this.nvr = new AlphaAnimation(0.0f, 1.0f);
        this.nvr.setDuration(660L);
        this.nvs = new AnimationSet(true);
        this.nvs.addAnimation(this.nvq);
        this.nvs.addAnimation(this.nvr);
        this.nvo = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQg() {
        this.nfY.setVisibility(0);
        if (this.nvt == null) {
            this.nvt = ObjectAnimator.ofFloat(this.nfY, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.nvv == null) {
            this.nvu = ObjectAnimator.ofFloat(this.nfY, "alpha", 0.0f, 1.0f);
        }
        if (this.nvv == null) {
            this.nvv = new AnimatorSet();
            this.nvv.setDuration(500L);
        }
        this.nvv.play(this.nvt).with(this.nvu);
        this.nvv.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.nvp, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.nfY, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.nvv != null) {
            this.nvv.cancel();
        }
        if (this.nvs != null) {
            this.nvs.cancel();
        }
        if (this.nvq != null) {
            this.nvq.cancel();
        }
        if (this.nvr != null) {
            this.nvr.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.nvx);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.nvx);
        clearAnim();
    }

    public void dQh() {
        clearAnim();
        setVisibility(8);
    }
}
