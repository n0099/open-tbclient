package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class WalletBaseEmptyView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f23579a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23580b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23581c;

    /* renamed from: d  reason: collision with root package name */
    public Button f23582d;

    /* renamed from: e  reason: collision with root package name */
    public View f23583e;

    /* renamed from: f  reason: collision with root package name */
    public View f23584f;

    /* renamed from: g  reason: collision with root package name */
    public EmptyBtnClickListener f23585g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23586h;

    /* loaded from: classes5.dex */
    public interface EmptyBtnClickListener {
        void onBtnClick();
    }

    public WalletBaseEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setRetryBtnVisiablity(int i2) {
        this.f23582d.setVisibility(i2);
    }

    public void setShowLoading(boolean z) {
        this.f23586h = z;
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        this.f23585g = emptyBtnClickListener;
    }

    public void showLoadingPage(boolean z) {
        if (z) {
            this.f23583e.setVisibility(0);
            this.f23584f.setVisibility(8);
            return;
        }
        this.f23583e.setVisibility(8);
        this.f23584f.setVisibility(0);
    }

    public void showOnlyTip1(int i2, CharSequence charSequence) {
        showLoadingPage(false);
        this.f23579a.setBackgroundResource(i2);
        this.f23580b.setText(charSequence);
        this.f23581c.setVisibility(4);
        this.f23582d.setVisibility(8);
    }

    public void showTip1_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        showLoadingPage(false);
        this.f23579a.setBackgroundResource(i2);
        this.f23580b.setText(charSequence);
        this.f23581c.setVisibility(4);
        this.f23582d.setVisibility(0);
        this.f23582d.setText(charSequence2);
        this.f23585g = emptyBtnClickListener;
    }

    public void showTip1_Tip2(int i2, CharSequence charSequence, CharSequence charSequence2) {
        showLoadingPage(false);
        this.f23579a.setBackgroundResource(i2);
        this.f23580b.setText(charSequence);
        this.f23581c.setVisibility(0);
        this.f23581c.setText(charSequence2);
        this.f23582d.setVisibility(8);
    }

    public void showTip1_Tip2_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        showLoadingPage(false);
        this.f23579a.setBackgroundResource(i2);
        this.f23580b.setText(charSequence);
        this.f23581c.setVisibility(0);
        this.f23581c.setText(charSequence2);
        this.f23582d.setVisibility(0);
        this.f23582d.setText(charSequence3);
        this.f23585g = emptyBtnClickListener;
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_empty_layout"), this);
        this.f23579a = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
        this.f23580b = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
        this.f23581c = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
        this.f23582d = (Button) findViewById(ResUtils.id(context, "reload_btn"));
        this.f23583e = findViewById(ResUtils.id(context, "progress_layout"));
        this.f23584f = findViewById(ResUtils.id(context, "reload_layout"));
        this.f23582d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.WalletBaseEmptyView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WalletBaseEmptyView.this.f23585g != null) {
                    if (WalletBaseEmptyView.this.f23586h) {
                        WalletBaseEmptyView.this.showLoadingPage(true);
                    }
                    WalletBaseEmptyView.this.f23585g.onBtnClick();
                }
            }
        });
    }

    public WalletBaseEmptyView(Context context) {
        super(context);
        a(context);
    }
}
