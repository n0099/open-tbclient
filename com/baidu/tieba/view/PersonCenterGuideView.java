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
    private View lgX;
    private boolean luW;
    private TbImageView luX;
    private RotateAnimation luY;
    private AlphaAnimation luZ;
    private AnimationSet lva;
    private ObjectAnimator lvb;
    private ObjectAnimator lvc;
    private AnimatorSet lvd;
    private Animation.AnimationListener lve;
    private final CustomMessageListener lvf;
    private ImageView mCloseBtn;
    private TextView mTip;

    public PersonCenterGuideView(Context context) {
        super(context);
        this.luW = false;
        this.lve = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.deH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lvf = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.luW) {
                    PersonCenterGuideView.this.luW = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lgX.setVisibility(4);
                    PersonCenterGuideView.this.luX.startAnimation(PersonCenterGuideView.this.lva);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.luW);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.luW = false;
        this.lve = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.deH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lvf = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.luW) {
                    PersonCenterGuideView.this.luW = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lgX.setVisibility(4);
                    PersonCenterGuideView.this.luX.startAnimation(PersonCenterGuideView.this.lva);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.luW);
                }
            }
        };
        init(context);
    }

    public PersonCenterGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.luW = false;
        this.lve = new Animation.AnimationListener() { // from class: com.baidu.tieba.view.PersonCenterGuideView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PersonCenterGuideView.this.deH();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lvf = new CustomMessageListener(2921423) { // from class: com.baidu.tieba.view.PersonCenterGuideView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!PersonCenterGuideView.this.luW) {
                    PersonCenterGuideView.this.luW = true;
                    PersonCenterGuideView.this.setVisibility(0);
                    PersonCenterGuideView.this.lgX.setVisibility(4);
                    PersonCenterGuideView.this.luX.startAnimation(PersonCenterGuideView.this.lva);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("has_shown_person_center_guide", PersonCenterGuideView.this.luW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.person_center_header_guide_layout, this);
        this.luX = (TbImageView) findViewById(R.id.person_center_header_guide_circle);
        this.luX.setIsRound(true);
        this.lgX = findViewById(R.id.person_center_header_guide_tip_container);
        this.mTip = (TextView) findViewById(R.id.person_center_header_guide_tip);
        this.mCloseBtn = (ImageView) findViewById(R.id.person_center_header_guide_close);
        this.luY = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.luY.setDuration(660L);
        this.luY.setAnimationListener(this.lve);
        this.luZ = new AlphaAnimation(0.0f, 1.0f);
        this.luZ.setDuration(660L);
        this.lva = new AnimationSet(true);
        this.lva.addAnimation(this.luY);
        this.lva.addAnimation(this.luZ);
        this.luW = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("has_shown_person_center_guide", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deH() {
        this.lgX.setVisibility(0);
        if (this.lvb == null) {
            this.lvb = ObjectAnimator.ofFloat(this.lgX, "translationX", -this.mTip.getWidth(), 0.0f);
        }
        if (this.lvd == null) {
            this.lvc = ObjectAnimator.ofFloat(this.lgX, "alpha", 0.0f, 1.0f);
        }
        if (this.lvd == null) {
            this.lvd = new AnimatorSet();
            this.lvd.setDuration(500L);
        }
        this.lvd.play(this.lvb).with(this.lvc);
        this.lvd.start();
    }

    public void onChangeSkinType() {
        am.setImageResource(this.luX, R.drawable.person_center_head_guide_circle);
        am.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_white_n);
        am.setViewTextColor(this.mTip, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.lgX, R.drawable.person_center_header_guide_tip_bg);
    }

    private void clearAnim() {
        if (this.lvd != null) {
            this.lvd.cancel();
        }
        if (this.lva != null) {
            this.lva.cancel();
        }
        if (this.luY != null) {
            this.luY.cancel();
        }
        if (this.luZ != null) {
            this.luZ.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lvf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lvf);
        clearAnim();
    }

    public void deI() {
        clearAnim();
        setVisibility(8);
    }
}
