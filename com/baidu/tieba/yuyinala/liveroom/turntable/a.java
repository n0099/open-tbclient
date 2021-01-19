package com.baidu.tieba.yuyinala.liveroom.turntable;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
/* loaded from: classes10.dex */
public class a extends e implements f {
    private int bSv;
    private RoundRectRelativeLayout bud;
    private CommonWebLayout bue;
    private View bug;
    private float buh;
    private Context mContext;
    private InterfaceC0932a oso;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.turntable.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0932a {
        void onDismiss();
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bue;
    }

    public void a(InterfaceC0932a interfaceC0932a) {
        this.oso = interfaceC0932a;
    }

    public void Fp(String str) {
        View findViewById;
        int Wr;
        int Ws;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bSv = 80;
                    Wr = Wp();
                    Ws = Wq();
                    this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bSv = 5;
                    Wr = Wr();
                    Ws = Ws();
                    this.bud.setCornerRadius(this.buh, 0.0f, 0.0f, this.buh);
                    break;
                default:
                    this.bSv = 80;
                    Wr = Wp();
                    Ws = Wq();
                    this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
                    break;
            }
            setWidth(Wr);
            setHeight(Ws);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ah(this.bud);
            }
            Ko();
            this.bue.loadUrl(str);
        }
    }

    public void Wo() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Wt()) {
            Wo();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.bue != null) {
                    a.this.bue.release();
                }
                if (a.this.oso != null) {
                    a.this.oso.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.buh = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bud = new RoundRectRelativeLayout(this.mContext);
        q(this.bud);
        r(this.bud);
        setContentView(this.bud);
    }

    private void q(ViewGroup viewGroup) {
        this.bue = new CommonWebLayout(this.mContext);
        this.bue.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bue.setCallback(new c() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gU(String str) {
                super.gU(str);
                if (a.this.bug != null) {
                    a.this.bug.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dO(int i) {
                super.dO(i);
                if (i == 100 && a.this.bug != null) {
                    a.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gV(String str) {
                super.gV(str);
                if (a.this.bug != null) {
                    a.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.bug != null) {
                    a.this.bug.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bue, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bug = LayoutInflater.from(this.mContext).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bug, layoutParams);
        this.bug.setVisibility(8);
    }

    private int Wp() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Wq() {
        return (Wp() * 470) / 375;
    }

    private int Wr() {
        return (Ws() * 375) / 470;
    }

    private int Ws() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.Wo();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void dL(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
