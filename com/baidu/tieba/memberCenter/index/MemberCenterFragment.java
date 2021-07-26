package com.baidu.tieba.memberCenter.index;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class MemberCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f18648e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f18649f;

    /* renamed from: g  reason: collision with root package name */
    public View f18650g;

    /* renamed from: h  reason: collision with root package name */
    public View f18651h;

    /* renamed from: i  reason: collision with root package name */
    public QuickWebView f18652i;
    public String j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f18653e;

        public a(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18653e = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || !str.contains("page/tb_vip")) {
                    if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f18653e.getPageContext(), new String[]{str}) != 3) {
                        return true;
                    }
                    if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                        if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                            d.a.p0.m.a.p(this.f18653e.getPageContext().getContext(), null, str, false, true, false, false, false);
                            return true;
                        }
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f18653e.getPageContext(), new String[]{str}, true);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BaseWebView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f18654e;

        public b(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18654e = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f18654e.T0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f18655e;

        public c(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18655e = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (j.z()) {
                    this.f18655e.T0();
                } else {
                    this.f18655e.S0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f18656a;

        public d(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18656a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f18656a.S0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f18657a;

        public e(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18657a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                this.f18657a.S0();
            }
        }
    }

    public MemberCenterFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
    }

    public final void O0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f18652i == null) {
            return;
        }
        if (j.A()) {
            T0();
            this.f18652i.loadUrl(str);
            return;
        }
        S0();
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f18650g.findViewById(R.id.view_navigation_bar);
            this.f18649f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18649f.setTitleText(R.string.member_center);
            SkinManager.setNavbarTitleColor(this.f18649f.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.f18649f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18649f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.f18649f.showBottomLine(false);
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18652i.setHorizontalScrollBarEnabled(false);
            this.f18652i.requestDisallowInterceptTouchEvent(true);
            this.f18652i.setOnLoadUrlListener(new a(this));
            this.f18652i.setOnPageStartedListener(new b(this));
            this.f18652i.setOnPageFinishedListener(new c(this));
            this.f18652i.setOnReceivedErrorListener(new d(this));
            this.f18652i.setOnReceivedSslErrorListener(new e(this));
        }
    }

    public void R0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.j = str;
        }
    }

    public final void S0() {
        QuickWebView quickWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (quickWebView = this.f18652i) == null || this.f18649f == null) {
            return;
        }
        quickWebView.setVisibility(8);
        this.f18649f.setVisibility(0);
        showNetRefreshView(this.f18651h, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f18652i == null || this.f18649f == null) {
            return;
        }
        hideNetRefreshView(this.f18651h);
        this.f18652i.setVisibility(0);
        this.f18649f.setVisibility(8);
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f18652i == null || this.k) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.mSkinType == i2) {
                return;
            }
            this.mSkinType = i2;
            if (this.f18652i != null) {
                if (StringUtils.isNull(this.j)) {
                    O0(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                } else {
                    O0(this.j);
                }
            }
            this.f18649f.onChangeSkinType(getPageContext(), i2);
            this.f18648e.c(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.index, (ViewGroup) null);
            this.f18650g = inflate;
            this.f18648e = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f18649f = (NavigationBar) this.f18650g.findViewById(R.id.view_navigation_bar);
            P0();
            this.f18651h = this.f18650g.findViewById(R.id.member_content_layout);
            this.f18652i = (QuickWebView) this.f18650g.findViewById(R.id.webview);
            Q0();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TiebaStatic.log("c10387");
            return this.f18650g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            QuickWebView quickWebView = this.f18652i;
            if (quickWebView != null) {
                quickWebView.destroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (this.f18652i == null || this.k) {
                return;
            }
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k = true;
            if (StringUtils.isNull(this.j)) {
                O0(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                return;
            }
            O0(this.j);
        }
    }
}
