package com.baidu.wallet.lightapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.base.LightappWebView;
/* loaded from: classes5.dex */
public class PullToRefreshWebview extends PullToRefreshBase<LightappWebView> {

    /* renamed from: a  reason: collision with root package name */
    public LightappWebView f24999a;

    public PullToRefreshWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return this.f24999a.getScrollY() == 0;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return true;
    }

    public PullToRefreshWebview(Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LightappWebView createRefreshableView(Context context, AttributeSet attributeSet) {
        LightappWebView lightappWebView = new LightappWebView(context);
        this.f24999a = lightappWebView;
        lightappWebView.setVerticalScrollBarEnabled(false);
        return this.f24999a;
    }
}
