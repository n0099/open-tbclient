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
    private View nKR;
    private boolean oad;
    private TbImageView oae;
    private RotateAnimation oaf;
    private AlphaAnimation oag;
    private AnimationSet oah;
    private ObjectAnimator oai;
    private ObjectAnimator oaj;
    private AnimatorSet oak;
    private Animation.AnimationListener oal;
    private final CustomMessageListener oam;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.oad = false;
        this.oal = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oam = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.oad) {
                    PersonCenterGuideView.this.oad = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nKR.setVisibility(4);
                    PersonCenterGuideView.this.oae.startAnimation(PersonCenterGuideView.this.oah);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.oad);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oad = false;
        this.oal = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oam = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.oad) {
                    PersonCenterGuideView.this.oad = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nKR.setVisibility(4);
                    PersonCenterGuideView.this.oae.startAnimation(PersonCenterGuideView.this.oah);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.oad);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oad = false;
        this.oal = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.dWk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oam = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.oad) {
                    PersonCenterGuideView.this.oad = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.nKR.setVisibility(4);
                    PersonCenterGuideView.this.oae.startAnimation(PersonCenterGuideView.this.oah);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.oad);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.oae = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.oae.setIsRound(true);
        this.nKR = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.oaf = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.oaf.setDuration(660L);
        this.oaf.setAnimationListener(this.oal);
        this.oag = new AlphaAnimation(0.0f, 1.0f);
        this.oag.setDuration(660L);
        this.oah = new AnimationSet(true);
        this.oah.addAnimation(this.oaf);
        this.oah.addAnimation(this.oag);
        this.oad = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWk() {
        this.nKR.setVisibility(0);
        if (this.oai == null) {
            this.oai = ObjectAnimator.ofFloat(this.nKR, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.oak == null) {
            this.oaj = ObjectAnimator.ofFloat(this.nKR, "alpha", 0.0f, 1.0f);
        }
        if (this.oak == null) {
            this.oak = new AnimatorSet();
            this.oak.setDuration(500L);
        }
        this.oak.play(this.oai).with(this.oaj);
        this.oak.start();
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.oae, R.drawable.person_center_head_guide_circle);
        ap.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nKR, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.oak != null) {
            this.oak.cancel();
        }
        if (this.oah != null) {
            this.oah.cancel();
        }
        if (this.oaf != null) {
            this.oaf.cancel();
        }
        if (this.oag != null) {
            this.oag.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.oam);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.oam);
        clearAnim();
    }

    public void dWl() {
        clearAnim();
        setVisibility(8);
    }
}
