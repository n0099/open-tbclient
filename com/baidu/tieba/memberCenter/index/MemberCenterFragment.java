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
import c.a.e.e.p.j;
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
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class MemberCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f54095e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f54096f;

    /* renamed from: g  reason: collision with root package name */
    public View f54097g;

    /* renamed from: h  reason: collision with root package name */
    public View f54098h;

    /* renamed from: i  reason: collision with root package name */
    public QuickWebView f54099i;

    /* renamed from: j  reason: collision with root package name */
    public String f54100j;
    public boolean k;

    /* loaded from: classes7.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f54101e;

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
            this.f54101e = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || !str.contains("page/tb_vip")) {
                    if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f54101e.getPageContext(), new String[]{str}) != 3) {
                        return true;
                    }
                    if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                        if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                            c.a.p0.m.a.q(this.f54101e.getPageContext().getContext(), null, str, false, true, false, false, false);
                            return true;
                        }
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f54101e.getPageContext(), new String[]{str}, true);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BaseWebView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f54102e;

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
            this.f54102e = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f54102e.showNormalView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f54103e;

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
            this.f54103e = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (j.z()) {
                    this.f54103e.showNormalView();
                } else {
                    this.f54103e.showNetRefreshView();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f54104a;

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
            this.f54104a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f54104a.showNetRefreshView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberCenterFragment f54105a;

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
            this.f54105a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                this.f54105a.showNetRefreshView();
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

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f54099i == null) {
            return;
        }
        if (j.A()) {
            showNormalView();
            this.f54099i.loadUrl(str);
            return;
        }
        showNetRefreshView();
    }

    public void initNavBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f54097g.findViewById(R.id.view_navigation_bar);
            this.f54096f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f54096f.setTitleText(R.string.member_center);
            SkinManager.setNavbarTitleColor(this.f54096f.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.f54096f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54096f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.f54096f.showBottomLine(false);
        }
    }

    public final void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f54099i.setHorizontalScrollBarEnabled(false);
            this.f54099i.requestDisallowInterceptTouchEvent(true);
            this.f54099i.setOnLoadUrlListener(new a(this));
            this.f54099i.setOnPageStartedListener(new b(this));
            this.f54099i.setOnPageFinishedListener(new c(this));
            this.f54099i.setOnReceivedErrorListener(new d(this));
            this.f54099i.setOnReceivedSslErrorListener(new e(this));
        }
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f54099i == null || this.k) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.mSkinType == i2) {
                return;
            }
            this.mSkinType = i2;
            if (this.f54099i != null) {
                if (StringUtils.isNull(this.f54100j)) {
                    c(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                } else {
                    c(this.f54100j);
                }
            }
            this.f54096f.onChangeSkinType(getPageContext(), i2);
            this.f54095e.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.index, (ViewGroup) null);
            this.f54097g = inflate;
            this.f54095e = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f54096f = (NavigationBar) this.f54097g.findViewById(R.id.view_navigation_bar);
            initNavBar();
            this.f54098h = this.f54097g.findViewById(R.id.member_content_layout);
            this.f54099i = (QuickWebView) this.f54097g.findViewById(R.id.webview);
            initWebView();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TiebaStatic.log("c10387");
            return this.f54097g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            QuickWebView quickWebView = this.f54099i;
            if (quickWebView != null) {
                quickWebView.destroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            if (this.f54099i == null || this.k) {
                return;
            }
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k = true;
            if (StringUtils.isNull(this.f54100j)) {
                c(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                return;
            }
            c(this.f54100j);
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f54100j = str;
        }
    }

    public final void showNetRefreshView() {
        QuickWebView quickWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (quickWebView = this.f54099i) == null || this.f54096f == null) {
            return;
        }
        quickWebView.setVisibility(8);
        this.f54096f.setVisibility(0);
        showNetRefreshView(this.f54098h, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
    }

    public final void showNormalView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f54099i == null || this.f54096f == null) {
            return;
        }
        hideNetRefreshView(this.f54098h);
        this.f54099i.setVisibility(0);
        this.f54096f.setVisibility(8);
    }
}
