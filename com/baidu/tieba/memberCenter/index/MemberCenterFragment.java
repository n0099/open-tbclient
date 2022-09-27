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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class MemberCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView a;
    public NavigationBar b;
    public View c;
    public View d;
    public QuickWebView e;
    public String f;
    public boolean g;

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberCenterFragment a;

        public a(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || !str.contains("page/tb_vip")) {
                    if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str}) != 3) {
                        return true;
                    }
                    if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                        if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                            yo4.t(this.a.getPageContext().getContext(), null, str, false, true, false, false, false);
                            return true;
                        }
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{str}, true);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BaseWebView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberCenterFragment a;

        public b(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void D0(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.x1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberCenterFragment a;

        public c(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.x1();
                } else {
                    this.a.w1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberCenterFragment a;

        public d(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                this.a.w1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberCenterFragment a;

        public e(MemberCenterFragment memberCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberCenterFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                this.a.w1();
            }
        }
    }

    public MemberCenterFragment() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.e == null || this.g) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.mSkinType == i) {
                return;
            }
            this.mSkinType = i;
            if (this.e != null) {
                if (StringUtils.isNull(this.f)) {
                    s1(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                } else {
                    s1(this.f);
                }
            }
            this.b.onChangeSkinType(getPageContext(), i);
            this.a.d(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03cc, (ViewGroup) null);
            this.c = inflate;
            this.a = (NoNetworkView) inflate.findViewById(R.id.obfuscated_res_0x7f0925c6);
            this.b = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0925c4);
            t1();
            this.d = this.c.findViewById(R.id.obfuscated_res_0x7f0914ea);
            this.e = (QuickWebView) this.c.findViewById(R.id.obfuscated_res_0x7f092659);
            u1();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TiebaStatic.log("c10387");
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            QuickWebView quickWebView = this.e;
            if (quickWebView != null) {
                quickWebView.destroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrimary();
            if (this.e == null || this.g) {
                return;
            }
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = true;
            if (StringUtils.isNull(this.f)) {
                s1(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
                return;
            }
            s1(this.f);
        }
    }

    public final void s1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.e == null) {
            return;
        }
        if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            x1();
            this.e.loadUrl(str);
            return;
        }
        w1();
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0925c4);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.b.setTitleText(R.string.obfuscated_res_0x7f0f0acb);
            SkinManager.setNavbarTitleColor(this.b.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
            if (this.b.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b.getBackImageView(), R.drawable.obfuscated_res_0x7f080628, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.b.showBottomLine(false);
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.setHorizontalScrollBarEnabled(false);
            this.e.requestDisallowInterceptTouchEvent(true);
            this.e.setOnLoadUrlListener(new a(this));
            this.e.setOnPageStartedListener(new b(this));
            this.e.setOnPageFinishedListener(new c(this));
            this.e.setOnReceivedErrorListener(new d(this));
            this.e.setOnReceivedSslErrorListener(new e(this));
        }
    }

    public void v1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f = str;
        }
    }

    public final void w1() {
        QuickWebView quickWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (quickWebView = this.e) == null || this.b == null) {
            return;
        }
        quickWebView.setVisibility(8);
        this.b.setVisibility(0);
        showNetRefreshView(this.d, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c59), true);
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.e == null || this.b == null) {
            return;
        }
        hideNetRefreshView(this.d);
        this.e.setVisibility(0);
        this.b.setVisibility(8);
    }
}
