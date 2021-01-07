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
    private int bXh;
    private RoundRectRelativeLayout byQ;
    private CommonWebLayout byR;
    private View byS;
    private float byT;
    private boolean hpp;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.byR;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!aam()) {
            aah();
        }
    }

    public void aJ(String str, int i) {
        View findViewById;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            this.bXh = 80;
            int aai = aai();
            this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
            setWidth(aai);
            setHeight((int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f));
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.byQ);
            }
            Oj();
            this.byR.loadUrl(str);
        }
    }

    public void aah() {
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
                if (b.this.byR != null) {
                    b.this.byR.release();
                }
            }
        });
    }

    private void initView() {
        this.byT = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.byQ = new RoundRectRelativeLayout(this.mActivity);
        q(this.byQ);
        r(this.byQ);
        setContentView(this.byQ);
    }

    private void q(ViewGroup viewGroup) {
        this.byR = new CommonWebLayout(this.mActivity);
        this.byR.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_transparent));
        this.byR.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            /* renamed from: if */
            public void mo20if(String str) {
                super.mo20if(str);
                if (b.this.byS != null) {
                    b.this.byS.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && b.this.byS != null) {
                    b.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ig(String str) {
                super.ig(str);
                if (b.this.byS != null) {
                    b.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.byS != null) {
                    b.this.byS.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.byR, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.byS = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.byS, layoutParams);
        this.byS.setVisibility(8);
    }

    private int aai() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private void Oj() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXh) {
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

    private boolean aam() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hpp) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bXh) {
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
                    b.this.aah();
                    b.this.hpp = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hpp = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
        if (this.byR != null) {
            this.byR.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
