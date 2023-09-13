package com.baidu.tieba.memberCenter.index;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.an6;
import com.baidu.tieba.bn6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.cn6;
import com.baidu.tieba.dn6;
import com.baidu.tieba.k59;
import com.baidu.tieba.um6;
import com.baidu.tieba.zm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class NewMemberCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView a;
    public NavigationBar b;
    public View c;
    public View d;
    public TbWebView e;
    public String f;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements zm6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewMemberCenterFragment a;

        public a(NewMemberCenterFragment newMemberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMemberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newMemberCenterFragment;
        }

        @Override // com.baidu.tieba.zm6
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (!StringUtils.isNull(str) && str.contains("page/tb_vip")) {
                    return false;
                }
                if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                    return false;
                }
                if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    BrowserHelper.startWebActivity(this.a.getPageContext().getContext(), null, str, false, true, false, false, false);
                    return true;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{str}, true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bn6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewMemberCenterFragment a;

        public b(NewMemberCenterFragment newMemberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMemberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newMemberCenterFragment;
        }

        @Override // com.baidu.tieba.bn6
        public void c(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.c2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements an6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewMemberCenterFragment a;

        public c(NewMemberCenterFragment newMemberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMemberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newMemberCenterFragment;
        }

        @Override // com.baidu.tieba.an6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.c2();
                } else {
                    this.a.b2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements cn6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewMemberCenterFragment a;

        public d(NewMemberCenterFragment newMemberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMemberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newMemberCenterFragment;
        }

        @Override // com.baidu.tieba.cn6
        public void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                this.a.b2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements dn6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewMemberCenterFragment a;

        public e(NewMemberCenterFragment newMemberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMemberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newMemberCenterFragment;
        }

        @Override // com.baidu.tieba.dn6
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                this.a.b2();
            }
        }
    }

    public NewMemberCenterFragment() {
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
        this.g = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.e != null && !this.g) {
            refresh();
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e != null && this.b != null) {
            hideNetRefreshView(this.d);
            this.e.setVisibility(0);
            this.b.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TbWebView tbWebView = this.e;
            if (tbWebView != null) {
                tbWebView.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroyView();
            this.e.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            this.e.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (this.e != null && !this.g) {
                refresh();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            this.e.onResume();
            c();
        }
    }

    public final void Y1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.e == null) {
            return;
        }
        if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            c2();
            this.e.loadUrl(str);
            return;
        }
        b2();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f = arguments.getString("key_url", "");
            }
            new k59("my_tab_vip_banner_bubble").i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.b.setTitleText(R.string.member_center);
            SkinManager.setNavbarTitleColor(this.b.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.b.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.b.showBottomLine(false);
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.setHorizontalScrollBarEnabled(false);
            this.e.requestDisallowInterceptTouchEvent(true);
            this.e.setOnLoadUrlListener(new a(this));
            this.e.setOnPageStartedListener(new b(this));
            this.e.setOnPageFinishedListener(new c(this));
            this.e.setOnReceivedErrorListener(new d(this));
            this.e.setOnReceivedSslErrorListener(new e(this));
        }
    }

    public final void b2() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tbWebView = this.e) != null && this.b != null) {
            tbWebView.setVisibility(8);
            this.b.setVisibility(0);
            showNetRefreshView(this.d, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e40), true);
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g = true;
            if (StringUtils.isNull(this.f)) {
                Y1(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                return;
            }
            Y1(this.f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && i == 25078) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (intent != null) {
                hashMap.put(WalletPayResultActivityConfig.PAY_RESULT, intent.getStringExtra(WalletPayResultActivityConfig.PAY_RESULT));
                um6.a().d(this.e, "tbPayResult", hashMap);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.mSkinType == i) {
                return;
            }
            this.mSkinType = i;
            EMManager.from(this.c).setBackGroundColor(R.color.CAM_X0201);
            if (this.e != null) {
                if (StringUtils.isNull(this.f)) {
                    Y1(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                } else {
                    Y1(this.f);
                }
            }
            this.b.onChangeSkinType(getPageContext(), i);
            this.a.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0460, (ViewGroup) null);
            this.c = inflate;
            this.a = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.b = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
            Z1();
            this.d = this.c.findViewById(R.id.obfuscated_res_0x7f091732);
            this.e = (TbWebView) this.c.findViewById(R.id.obfuscated_res_0x7f092a51);
            a2();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TiebaStatic.log("c10387");
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
