package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
/* loaded from: classes5.dex */
public class LangBrigdeSlideLayout extends PullToRefreshBase<LightappWebView> {

    /* renamed from: a  reason: collision with root package name */
    public LightappBrowserWebView f24909a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24910b;

    public LangBrigdeSlideLayout(Context context) {
        super(context);
        this.f24910b = true;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        return new LoadingLayout(context) { // from class: com.baidu.wallet.lightapp.business.LangBrigdeSlideLayout.1
            @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
            public View createLoadingView(Context context2, AttributeSet attributeSet2) {
                LinearLayout linearLayout = new LinearLayout(context2);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 55));
                return linearLayout;
            }

            @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
            public int getContentSize() {
                return (int) getResources().getDimension(ResUtils.dimen(getContext(), "wallet_base_header_max_padding"));
            }
        };
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return this.f24909a.isTop && this.f24910b;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return false;
    }

    public void setSupportPullDown(boolean z) {
        this.f24910b = z;
        if (z) {
            return;
        }
        scrollTo(0, 0);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startRefreshing() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LightappWebView createRefreshableView(Context context, AttributeSet attributeSet) {
        LightappBrowserWebView lightappWebView = LightappWebViewCenter.getInstance().getLightappWebView(context);
        this.f24909a = lightappWebView;
        if (lightappWebView != null) {
            lightappWebView.setId(ResUtils.id(context, "cust_webview"));
        }
        return this.f24909a;
    }

    public LangBrigdeSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24910b = true;
    }
}
