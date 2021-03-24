package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
/* loaded from: classes5.dex */
public class PullToRefreshPinnedSectionListView extends PullToRefreshBase<PinnedSectionListView> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public ListView f24138a;

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f24139b;

    /* renamed from: c  reason: collision with root package name */
    public AbsListView.OnScrollListener f24140c;

    public PullToRefreshPinnedSectionListView(Context context) {
        this(context, null);
    }

    private boolean a() {
        LoadingLayout loadingLayout = this.f24139b;
        return loadingLayout == null || loadingLayout.getState() != LoadingLayout.State.NO_MORE_DATA;
    }

    private boolean b() {
        ListAdapter adapter = this.f24138a.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return (this.f24138a.getChildCount() > 0 ? this.f24138a.getChildAt(0).getTop() : 0) >= 0;
    }

    private boolean c() {
        ListAdapter adapter = this.f24138a.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.f24138a.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.f24138a.getChildAt(Math.min(lastVisiblePosition - this.f24138a.getFirstVisiblePosition(), this.f24138a.getChildCount() - 1));
            return childAt != null && childAt.getBottom() <= this.f24138a.getBottom();
        }
        return false;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        if (isScrollLoadEnabled()) {
            return this.f24139b;
        }
        return super.getFooterLoadingLayout();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return b();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return c();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
        LoadingLayout loadingLayout = this.f24139b;
        if (loadingLayout != null) {
            loadingLayout.setState(LoadingLayout.State.RESET);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f24140c;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && a() && ((i == 0 || i == 2) && isReadyForPullUp())) {
            startLoading();
        }
        AbsListView.OnScrollListener onScrollListener = this.f24140c;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setHasMoreData(boolean z) {
        LoadingLayout loadingLayout = this.f24139b;
        if (loadingLayout != null) {
            loadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f24140c = onScrollListener;
    }

    public void setRefreshingText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (getHeaderLoadingLayout() != null) {
            getHeaderLoadingLayout().setRefreshingLabel(str);
        }
        if (getFooterLoadingLayout() != null) {
            getFooterLoadingLayout().setRefreshingLabel(str);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.f24139b == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.f24139b = footerLoadingLayout;
                this.f24138a.addFooterView(footerLoadingLayout, null, false);
            }
            this.f24139b.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.f24139b;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startLoading() {
        super.startLoading();
        LoadingLayout loadingLayout = this.f24139b;
        if (loadingLayout != null) {
            loadingLayout.setState(LoadingLayout.State.REFRESHING);
            this.f24139b.setVisibility(0);
        }
    }

    public PullToRefreshPinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public PinnedSectionListView createRefreshableView(Context context, AttributeSet attributeSet) {
        PinnedSectionListView pinnedSectionListView = new PinnedSectionListView(context);
        this.f24138a = pinnedSectionListView;
        pinnedSectionListView.setOnScrollListener(this);
        return pinnedSectionListView;
    }
}
