package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes5.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {

    /* renamed from: a  reason: collision with root package name */
    public ScrollView f24141a;

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return this.f24141a.getScrollY() == 0;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public ScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        ScrollView scrollView = new ScrollView(context, attributeSet);
        this.f24141a = scrollView;
        scrollView.setOverScrollMode(2);
        this.f24141a.setVerticalScrollBarEnabled(false);
        return this.f24141a;
    }
}
