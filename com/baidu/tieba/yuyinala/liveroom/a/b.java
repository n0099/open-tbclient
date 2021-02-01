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
/* loaded from: classes11.dex */
public class b extends e implements f {
    private float bAh;
    private CommonWebLayout bVC;
    private View bVD;
    private RoundRectRelativeLayout bWv;
    private int bWw;
    private boolean hCH;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bVC;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Yi()) {
            Yc();
        }
    }

    public void cd(String str, int i) {
        View findViewById;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            this.bWw = 80;
            int Ye = Ye();
            this.bWv.setCornerRadius(this.bAh, this.bAh, 0.0f, 0.0f);
            setWidth(Ye);
            setHeight((int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f));
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.bWv);
            }
            LN();
            this.bVC.loadUrl(str);
        }
    }

    public void Yc() {
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
                if (b.this.bVC != null) {
                    b.this.bVC.release();
                }
            }
        });
    }

    private void initView() {
        this.bAh = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bWv = new RoundRectRelativeLayout(this.mActivity);
        x(this.bWv);
        y(this.bWv);
        setContentView(this.bWv);
    }

    private void x(ViewGroup viewGroup) {
        this.bVC = new CommonWebLayout(this.mActivity);
        this.bVC.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_transparent));
        this.bVC.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (b.this.bVD != null) {
                    b.this.bVD.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fn(int i) {
                super.fn(i);
                if (i == 100 && b.this.bVD != null) {
                    b.this.bVD.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iu(String str) {
                super.iu(str);
                if (b.this.bVD != null) {
                    b.this.bVD.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void f(String str, int i, String str2) {
                super.f(str, i, str2);
                if (b.this.bVD != null) {
                    b.this.bVD.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bVC, new ViewGroup.LayoutParams(-1, -1));
    }

    private void y(ViewGroup viewGroup) {
        this.bVD = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bVD, layoutParams);
        this.bVD.setVisibility(8);
    }

    private int Ye() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private void LN() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bWw) {
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

    private boolean Yi() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hCH) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bWw) {
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
                    b.this.Yc();
                    b.this.hCH = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hCH = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fp(int i) {
        dismiss();
        if (this.bVC != null) {
            this.bVC.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
