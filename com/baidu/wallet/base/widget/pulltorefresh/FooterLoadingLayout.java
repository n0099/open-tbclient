package com.baidu.wallet.base.widget.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
/* loaded from: classes5.dex */
public class FooterLoadingLayout extends LoadingLayout {

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f24510a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24511b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f24512c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f24513d;

    public FooterLoadingLayout(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f24510a = (ProgressBar) findViewById(ResUtils.id(getContext(), "bd_wallet_progress_footer"));
        this.f24511b = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_loadmore_text"));
        setState(LoadingLayout.State.RESET);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    @SuppressLint({"InflateParams"})
    public View createLoadingView(Context context, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), "wallet_base_load_more"), (ViewGroup) null);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public int getContentSize() {
        return ResUtils.dimen(getContext(), "wallet_base_footer_height");
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onNoMoreData() {
        this.f24511b.setVisibility(0);
        if (TextUtils.isEmpty(this.f24513d)) {
            this.f24511b.setText(ResUtils.getString(getContext(), "wallet_base_no_more"));
        } else {
            this.f24511b.setText(this.f24513d);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        this.f24510a.setVisibility(0);
        this.f24511b.setVisibility(0);
        if (TextUtils.isEmpty(this.f24512c)) {
            this.f24511b.setText(ResUtils.string(getContext(), "wallet_base_refresh_loading"));
        } else {
            this.f24511b.setText(this.f24512c);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        if (TextUtils.isEmpty(this.f24512c)) {
            this.f24511b.setText(ResUtils.string(getContext(), "wallet_base_refresh_loading"));
        } else {
            this.f24511b.setText(this.f24512c);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        this.f24510a.setVisibility(8);
        this.f24511b.setVisibility(4);
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setNoMoreDataLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f24513d = charSequence;
        TextView textView = this.f24511b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f24512c = charSequence;
        TextView textView = this.f24511b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void showTopDivider(boolean z) {
        View findViewById = findViewById(ResUtils.id(getContext(), "bd_wallet_progress_footer"));
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
