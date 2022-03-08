package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
/* loaded from: classes6.dex */
public class PullToRefreshPinnedSectionListView extends PullToRefreshBase<PinnedSectionListView> implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListView a;

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f49492b;

    /* renamed from: c  reason: collision with root package name */
    public AbsListView.OnScrollListener f49493c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullToRefreshPinnedSectionListView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            LoadingLayout loadingLayout = this.f49492b;
            return loadingLayout == null || loadingLayout.getState() != LoadingLayout.State.NO_MORE_DATA;
        }
        return invokeV.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ListAdapter adapter = this.a.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            return (this.a.getChildCount() > 0 ? this.a.getChildAt(0).getTop() : 0) >= 0;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ListAdapter adapter = this.a.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
                View childAt = this.a.getChildAt(Math.min(lastVisiblePosition - this.a.getFirstVisiblePosition(), this.a.getChildCount() - 1));
                return childAt != null && childAt.getBottom() <= this.a.getBottom();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (isScrollLoadEnabled()) {
                return this.f49492b;
            }
            return super.getFooterLoadingLayout();
        }
        return (LoadingLayout) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void onPullUpRefreshComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPullUpRefreshComplete();
            LoadingLayout loadingLayout = this.f49492b;
            if (loadingLayout != null) {
                loadingLayout.setState(LoadingLayout.State.RESET);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048582, this, absListView, i2, i3, i4) == null) || (onScrollListener = this.f49493c) == null) {
            return;
        }
        onScrollListener.onScroll(absListView, i2, i3, i4);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, absListView, i2) == null) {
            if (isScrollLoadEnabled() && a() && ((i2 == 0 || i2 == 2) && isReadyForPullUp())) {
                startLoading();
            }
            AbsListView.OnScrollListener onScrollListener = this.f49493c;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i2);
            }
        }
    }

    public void setHasMoreData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            LoadingLayout loadingLayout = this.f49492b;
            if (loadingLayout != null) {
                loadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
            }
            LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
            if (footerLoadingLayout != null) {
                footerLoadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
            }
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onScrollListener) == null) {
            this.f49493c = onScrollListener;
        }
    }

    public void setRefreshingText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || isScrollLoadEnabled() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.f49492b == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.f49492b = footerLoadingLayout;
                this.a.addFooterView(footerLoadingLayout, null, false);
            }
            this.f49492b.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.f49492b;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.startLoading();
            LoadingLayout loadingLayout = this.f49492b;
            if (loadingLayout != null) {
                loadingLayout.setState(LoadingLayout.State.REFRESHING);
                this.f49492b.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshPinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setPullLoadEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public PinnedSectionListView createRefreshableView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) {
            PinnedSectionListView pinnedSectionListView = new PinnedSectionListView(context);
            this.a = pinnedSectionListView;
            pinnedSectionListView.setOnScrollListener(this);
            return pinnedSectionListView;
        }
        return (PinnedSectionListView) invokeLL.objValue;
    }
}
