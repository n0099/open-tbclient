package com.baidu.wallet.lightapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class NoNetView extends RelativeLayout implements View.OnClickListener {
    public static int ERROR_SSL_GENERAL = 5000;

    /* renamed from: a  reason: collision with root package name */
    public Animation f25043a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f25044b;

    /* renamed from: c  reason: collision with root package name */
    public String f25045c;

    /* renamed from: d  reason: collision with root package name */
    public a f25046d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25047e;

    /* loaded from: classes5.dex */
    public interface a {
        void onReloadClick(String str);
    }

    public NoNetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25045c = "";
        a();
        b();
    }

    private void a() {
        this.f25043a = ResUtils.getAnimation(getContext(), "wallet_base_slide_from_right");
        this.f25044b = ResUtils.getAnimation(getContext(), "wallet_base_slide_to_right");
        this.f25043a.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.wallet.lightapp.widget.NoNetView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                NoNetView.this.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f25044b.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.wallet.lightapp.widget.NoNetView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                NoNetView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_no_net_error_layout"), this);
        findViewById(ResUtils.id(getContext(), "reload_btn")).setOnClickListener(this);
        this.f25047e = (TextView) findViewById(ResUtils.id(getContext(), "failure_cause_errcode"));
    }

    public void hide() {
        this.f25045c = "";
        setVisibility(8);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void notifyUrlFinish() {
        if (isShowing()) {
            setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (CheckUtils.isFastDoubleClick() || view.getId() != ResUtils.id(getContext(), "reload_btn") || (aVar = this.f25046d) == null) {
            return;
        }
        aVar.onReloadClick(this.f25045c);
    }

    public void setFailureCause(int i2) {
        if (this.f25047e != null) {
            this.f25047e.setText(String.format(ResUtils.getString(getContext(), "wallet_base_no_network_error_code"), Integer.valueOf(i2)));
        }
    }

    public void show(String str, a aVar) {
        this.f25045c = str;
        this.f25046d = aVar;
        setVisibility(0);
    }
}
