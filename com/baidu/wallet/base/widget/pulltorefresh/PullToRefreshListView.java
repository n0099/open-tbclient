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
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public ListView f23828a;

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f23829b;

    /* renamed from: c  reason: collision with root package name */
    public AbsListView.OnScrollListener f23830c;

    /* renamed from: d  reason: collision with root package name */
    public int f23831d;

    public PullToRefreshListView(Context context) {
        this(context, null);
    }

    private boolean a() {
        LoadingLayout loadingLayout = this.f23829b;
        return loadingLayout == null || loadingLayout.getState() != LoadingLayout.State.NO_MORE_DATA;
    }

    private boolean b() {
        ListAdapter adapter = this.f23828a.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return (this.f23828a.getChildCount() > 0 ? this.f23828a.getChildAt(0).getTop() : 0) >= 0 && this.f23831d == 0;
    }

    private boolean c() {
        ListAdapter adapter = this.f23828a.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.f23828a.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.f23828a.getChildAt(Math.min(lastVisiblePosition - this.f23828a.getFirstVisiblePosition(), this.f23828a.getChildCount() - 1));
            return childAt != null && childAt.getBottom() <= this.f23828a.getBottom();
        }
        return false;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        if (isScrollLoadEnabled()) {
            return this.f23829b;
        }
        return super.getFooterLoadingLayout();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return b();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return c() && a();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f23830c;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
        this.f23831d = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && a() && ((i == 0 || i == 2) && isReadyForPullUp())) {
            startLoading();
        }
        AbsListView.OnScrollListener onScrollListener = this.f23830c;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setHasMoreData(boolean z) {
        LoadingLayout loadingLayout = this.f23829b;
        if (loadingLayout != null) {
            loadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f23830c = onScrollListener;
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
            if (this.f23829b == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.f23829b = footerLoadingLayout;
                this.f23828a.addFooterView(footerLoadingLayout, null, false);
            }
            this.f23829b.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.f23829b;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    public void showOrHideFootView(int i) {
        LoadingLayout loadingLayout = this.f23829b;
        if (loadingLayout == null || loadingLayout.getVisibility() == i) {
            return;
        }
        this.f23829b.setVisibility(i);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startLoading() {
        super.startLoading();
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23831d = 0;
        setPullLoadEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        this.f23828a = listView;
        listView.setOnScrollListener(this);
        return listView;
    }
}
