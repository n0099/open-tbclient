package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageView;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes8.dex */
public class tb0 implements ILiveFeedPageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fa0 a;
    public final int b;
    public boolean c;

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onSelectedRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public tb0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = qc0.a().b();
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedOther
    public boolean canSlideDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            fa0 fa0Var = this.a;
            if (fa0Var != null) {
                return fa0Var.w();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedOther
    public boolean canSlideUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            fa0 fa0Var = this.a;
            if (fa0Var != null) {
                return fa0Var.x();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedOther
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fa0 fa0Var = this.a;
            if (fa0Var != null) {
                return fa0Var.M();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void lazyLoad() {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (fa0Var = this.a) != null) {
            fa0Var.Q();
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onExternalRefresh() {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (fa0Var = this.a) != null) {
            fa0Var.W(null);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewDestroy() {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (fa0Var = this.a) != null) {
            fa0Var.T();
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewPause() {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (fa0Var = this.a) != null) {
            fa0Var.a0();
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewResume() {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (fa0Var = this.a) != null) {
            fa0Var.b0();
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            LiveFeedPageSdk.liveLog("LiveFeedPageViewImpl " + str + GlideException.IndentedAppendable.INDENT + this.a);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedOther
    public void addLiveFeedStatusListener(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedStatusListener) == null) && (fa0Var = this.a) != null) {
            fa0Var.v(liveFeedStatusListener);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onDarkModeChange(String str) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (fa0Var = this.a) != null) {
            fa0Var.S(str);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onExternalLoadMore(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onLoadMoreListener) == null) && (fa0Var = this.a) != null) {
            fa0Var.U(onLoadMoreListener);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onExternalRefresh(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, onRefreshListener) == null) && (fa0Var = this.a) != null) {
            fa0Var.W(onRefreshListener);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onFontSizeChanged(int i) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (fa0Var = this.a) != null) {
            fa0Var.X(i);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onUserVisibleHint(boolean z) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (fa0Var = this.a) != null) {
            fa0Var.e0(z);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedOther
    public void setIsHKTopBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public View onCreateView(FragmentActivity fragmentActivity, Fragment fragment, String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{fragmentActivity, fragment, str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            a("onCreateView hostType:   page: " + str);
            if (this.a == null) {
                int i = this.b;
                if (fragment != null) {
                    supportFragmentManager = fragment.getChildFragmentManager();
                } else {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
                this.a = new fa0(fragmentActivity, i, supportFragmentManager, str, str2, this.c, str3, str4, z);
                la0.u(fragmentActivity, "", "zhibopindao");
            }
            return this.a.A();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onTabSelectedEvent(String str, String str2) {
        fa0 fa0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) && (fa0Var = this.a) != null) {
            fa0Var.d0(str, str2);
        }
    }
}
