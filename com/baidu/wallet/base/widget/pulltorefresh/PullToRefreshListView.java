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
/* loaded from: classes10.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ListView f57873a;

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f57874b;

    /* renamed from: c  reason: collision with root package name */
    public AbsListView.OnScrollListener f57875c;

    /* renamed from: d  reason: collision with root package name */
    public int f57876d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullToRefreshListView(Context context) {
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
            LoadingLayout loadingLayout = this.f57874b;
            return loadingLayout == null || loadingLayout.getState() != LoadingLayout.State.NO_MORE_DATA;
        }
        return invokeV.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ListAdapter adapter = this.f57873a.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            return (this.f57873a.getChildCount() > 0 ? this.f57873a.getChildAt(0).getTop() : 0) >= 0 && this.f57876d == 0;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ListAdapter adapter = this.f57873a.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            int lastVisiblePosition = this.f57873a.getLastVisiblePosition();
            if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
                View childAt = this.f57873a.getChildAt(Math.min(lastVisiblePosition - this.f57873a.getFirstVisiblePosition(), this.f57873a.getChildCount() - 1));
                return childAt != null && childAt.getBottom() <= this.f57873a.getBottom();
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
                return this.f57874b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c() && a() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void onPullUpRefreshComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPullUpRefreshComplete();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, absListView, i2, i3, i4) == null) {
            AbsListView.OnScrollListener onScrollListener = this.f57875c;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i2, i3, i4);
            }
            this.f57876d = i2;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, absListView, i2) == null) {
            if (isScrollLoadEnabled() && a() && ((i2 == 0 || i2 == 2) && isReadyForPullUp())) {
                startLoading();
            }
            AbsListView.OnScrollListener onScrollListener = this.f57875c;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i2);
            }
        }
    }

    public void setHasMoreData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            LoadingLayout loadingLayout = this.f57874b;
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
            this.f57875c = onScrollListener;
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
            if (this.f57874b == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.f57874b = footerLoadingLayout;
                this.f57873a.addFooterView(footerLoadingLayout, null, false);
            }
            this.f57874b.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.f57874b;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    public void showOrHideFootView(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (loadingLayout = this.f57874b) == null || loadingLayout.getVisibility() == i2) {
            return;
        }
        this.f57874b.show(i2 == 0);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.startLoading();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
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
        this.f57876d = 0;
        setPullLoadEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) {
            ListView listView = new ListView(context);
            this.f57873a = listView;
            listView.setOnScrollListener(this);
            return listView;
        }
        return (ListView) invokeLL.objValue;
    }
}
