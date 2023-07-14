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
/* loaded from: classes7.dex */
public class sc0 implements ILiveFeedPageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eb0 a;
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

    public sc0() {
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
        this.b = pd0.a().b();
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedOther
    public boolean canSlideDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            eb0 eb0Var = this.a;
            if (eb0Var != null) {
                return eb0Var.w();
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
            eb0 eb0Var = this.a;
            if (eb0Var != null) {
                return eb0Var.x();
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
            eb0 eb0Var = this.a;
            if (eb0Var != null) {
                return eb0Var.M();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void lazyLoad() {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (eb0Var = this.a) != null) {
            eb0Var.Q();
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onExternalRefresh() {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (eb0Var = this.a) != null) {
            eb0Var.W(null);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewDestroy() {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (eb0Var = this.a) != null) {
            eb0Var.T();
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewPause() {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (eb0Var = this.a) != null) {
            eb0Var.a0();
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedLifecycle
    public void onViewResume() {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (eb0Var = this.a) != null) {
            eb0Var.b0();
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
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedStatusListener) == null) && (eb0Var = this.a) != null) {
            eb0Var.v(liveFeedStatusListener);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onDarkModeChange(String str) {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (eb0Var = this.a) != null) {
            eb0Var.S(str);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onExternalLoadMore(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onLoadMoreListener) == null) && (eb0Var = this.a) != null) {
            eb0Var.U(onLoadMoreListener);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedRefresh
    public void onExternalRefresh(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, onRefreshListener) == null) && (eb0Var = this.a) != null) {
            eb0Var.W(onRefreshListener);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onFontSizeChanged(int i) {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (eb0Var = this.a) != null) {
            eb0Var.X(i);
        }
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onUserVisibleHint(boolean z) {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (eb0Var = this.a) != null) {
            eb0Var.e0(z);
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
                this.a = new eb0(fragmentActivity, i, supportFragmentManager, str, str2, this.c, str3, str4, z);
                kb0.u(fragmentActivity, "", "zhibopindao");
            }
            return this.a.A();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.live.feedpage.interfaces.ILiveFeedPageView
    public void onTabSelectedEvent(String str, String str2) {
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) && (eb0Var = this.a) != null) {
            eb0Var.d0(str, str2);
        }
    }
}
