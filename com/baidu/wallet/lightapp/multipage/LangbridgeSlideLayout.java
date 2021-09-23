package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
/* loaded from: classes8.dex */
public class LangbridgeSlideLayout extends PullToRefreshBase<ViewGroup> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LightappBrowserWebView f62327a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f62328b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62329c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LangbridgeSlideLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62329c = true;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, attributeSet)) == null) {
            return null;
        }
        return (LoadingLayout) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) ? new LoadingLayout(this, context) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeSlideLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeSlideLayout f62330a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62330a = this;
            }

            @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
            public View createLoadingView(Context context2, AttributeSet attributeSet2) {
                InterceptResult invokeLL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, context2, attributeSet2)) == null) {
                    LinearLayout linearLayout = new LinearLayout(context2);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 55));
                    return linearLayout;
                }
                return (View) invokeLL2.objValue;
            }

            @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
            public int getContentSize() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) getResources().getDimension(ResUtils.dimen(getContext(), "wallet_base_header_max_padding")) : invokeV.intValue;
            }
        } : (LoadingLayout) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LightappBrowserWebView lightappBrowserWebView = this.f62327a;
            return lightappBrowserWebView != null && lightappBrowserWebView.isTop && this.f62329c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSupportPullDown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f62329c = z;
            if (z) {
                return;
            }
            scrollTo(0, 0);
        }
    }

    public void setTarget(LightappBrowserWebView lightappBrowserWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lightappBrowserWebView) == null) {
            this.f62327a = lightappBrowserWebView;
            ViewGroup viewGroup = this.f62328b;
            if (viewGroup == null || lightappBrowserWebView == null) {
                return;
            }
            viewGroup.addView(lightappBrowserWebView, -1, -1);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public void startRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase
    public ViewGroup createRefreshableView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, attributeSet)) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.f62328b = frameLayout;
            return frameLayout;
        }
        return (ViewGroup) invokeLL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LangbridgeSlideLayout(Context context, AttributeSet attributeSet) {
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
        this.f62329c = true;
    }
}
