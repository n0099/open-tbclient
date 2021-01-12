package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes10.dex */
public class b extends e implements f {
    private int bSv;
    private RoundRectRelativeLayout bud;
    private CommonWebLayout bue;
    private View bug;
    private float buh;
    private boolean hkI;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bue;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Wt()) {
            Wo();
        }
    }

    public void aJ(String str, int i) {
        View findViewById;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            this.bSv = 80;
            int Wp = Wp();
            this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
            setWidth(Wp);
            setHeight((int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f));
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.bud);
            }
            Ko();
            this.bue.loadUrl(str);
        }
    }

    public void Wo() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bue != null) {
                    b.this.bue.release();
                }
            }
        });
    }

    private void initView() {
        this.buh = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bud = new RoundRectRelativeLayout(this.mActivity);
        q(this.bud);
        r(this.bud);
        setContentView(this.bud);
    }

    private void q(ViewGroup viewGroup) {
        this.bue = new CommonWebLayout(this.mActivity);
        this.bue.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_transparent));
        this.bue.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gU(String str) {
                super.gU(str);
                if (b.this.bug != null) {
                    b.this.bug.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dO(int i) {
                super.dO(i);
                if (i == 100 && b.this.bug != null) {
                    b.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gV(String str) {
                super.gV(str);
                if (b.this.bug != null) {
                    b.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bug != null) {
                    b.this.bug.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bue, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bug = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bug, layoutParams);
        this.bug.setVisibility(8);
    }

    private int Wp() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private void Ko() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bSv) {
                case 5:
                    translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    break;
                case 80:
                    translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    break;
            }
            if (translateAnimation != null) {
                translateAnimation.setDuration(250L);
                translateAnimation.setInterpolator(new LinearInterpolator());
                getContentView().startAnimation(translateAnimation);
            }
        }
    }

    private boolean Wt() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hkI) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bSv) {
            case 5:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                break;
            case 80:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                break;
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.Wo();
                    b.this.hkI = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hkI = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void dL(int i) {
        dismiss();
        if (this.bue != null) {
            this.bue.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
