package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
/* loaded from: classes5.dex */
public class LangbridgeSlideLayout extends PullToRefreshBase<ViewGroup> {

    /* renamed from: a  reason: collision with root package name */
    public LightappBrowserWebView f25736a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f25737b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25738c;

    public LangbridgeSlideLayout(Context context) {
        super(context);
        this.f25738c = true;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        return new LoadingLayout(context) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeSlideLayout.1
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
        LightappBrowserWebView lightappBrowserWebView = this.f25736a;
        return lightappBrowserWebView != null && lightappBrowserWebView.isTop && this.f25738c;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return false;
    }

    public void setSupportPullDown(boolean z) {
        this.f25738c = z;
        if (z) {
            return;
        }
        scrollTo(0, 0);
    }

    public void setTarget(LightappBrowserWebView lightappBrowserWebView) {
        this.f25736a = lightappBrowserWebView;
        ViewGroup viewGroup = this.f25737b;
        if (viewGroup == null || lightappBrowserWebView == null) {
            return;
        }
        viewGroup.addView(lightappBrowserWebView, -1, -1);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startRefreshing() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public ViewGroup createRefreshableView(Context context, AttributeSet attributeSet) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.f25737b = frameLayout;
        return frameLayout;
    }

    public LangbridgeSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25738c = true;
    }
}
