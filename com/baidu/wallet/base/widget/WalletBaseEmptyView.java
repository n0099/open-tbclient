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
    public ImageView f23974a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23975b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23976c;

    /* renamed from: d  reason: collision with root package name */
    public Button f23977d;

    /* renamed from: e  reason: collision with root package name */
    public View f23978e;

    /* renamed from: f  reason: collision with root package name */
    public View f23979f;

    /* renamed from: g  reason: collision with root package name */
    public EmptyBtnClickListener f23980g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23981h;

    /* loaded from: classes5.dex */
    public interface EmptyBtnClickListener {
        void onBtnClick();
    }

    public WalletBaseEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setRetryBtnVisiablity(int i) {
        this.f23977d.setVisibility(i);
    }

    public void setShowLoading(boolean z) {
        this.f23981h = z;
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        this.f23980g = emptyBtnClickListener;
    }

    public void showLoadingPage(boolean z) {
        if (z) {
            this.f23978e.setVisibility(0);
            this.f23979f.setVisibility(8);
            return;
        }
        this.f23978e.setVisibility(8);
        this.f23979f.setVisibility(0);
    }

    public void showOnlyTip1(int i, CharSequence charSequence) {
        showLoadingPage(false);
        this.f23974a.setBackgroundResource(i);
        this.f23975b.setText(charSequence);
        this.f23976c.setVisibility(4);
        this.f23977d.setVisibility(8);
    }

    public void showTip1_NextBtn(int i, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        showLoadingPage(false);
        this.f23974a.setBackgroundResource(i);
        this.f23975b.setText(charSequence);
        this.f23976c.setVisibility(4);
        this.f23977d.setVisibility(0);
        this.f23977d.setText(charSequence2);
        this.f23980g = emptyBtnClickListener;
    }

    public void showTip1_Tip2(int i, CharSequence charSequence, CharSequence charSequence2) {
        showLoadingPage(false);
        this.f23974a.setBackgroundResource(i);
        this.f23975b.setText(charSequence);
        this.f23976c.setVisibility(0);
        this.f23976c.setText(charSequence2);
        this.f23977d.setVisibility(8);
    }

    public void showTip1_Tip2_NextBtn(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        showLoadingPage(false);
        this.f23974a.setBackgroundResource(i);
        this.f23975b.setText(charSequence);
        this.f23976c.setVisibility(0);
        this.f23976c.setText(charSequence2);
        this.f23977d.setVisibility(0);
        this.f23977d.setText(charSequence3);
        this.f23980g = emptyBtnClickListener;
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_empty_layout"), this);
        this.f23974a = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
        this.f23975b = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
        this.f23976c = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
        this.f23977d = (Button) findViewById(ResUtils.id(context, "reload_btn"));
        this.f23978e = findViewById(ResUtils.id(context, "progress_layout"));
        this.f23979f = findViewById(ResUtils.id(context, "reload_layout"));
        this.f23977d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.WalletBaseEmptyView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WalletBaseEmptyView.this.f23980g != null) {
                    if (WalletBaseEmptyView.this.f23981h) {
                        WalletBaseEmptyView.this.showLoadingPage(true);
                    }
                    WalletBaseEmptyView.this.f23980g.onBtnClick();
                }
            }
        });
    }

    public WalletBaseEmptyView(Context context) {
        super(context);
        a(context);
    }
}
