package com.baidu.tieba.personExtra;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq4;
import com.baidu.tieba.ka5;
import com.baidu.tieba.la5;
import com.baidu.tieba.lv4;
import com.baidu.tieba.sp4;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BaseWebView b;
    public NavigationBar c;
    public View d;
    public TbPageContext<EditNickNameActivity> e;
    public ka5 f;
    public la5 g;
    public boolean h;
    public lv4 i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditNickNameActivity a;

        public a(EditNickNameActivity editNickNameActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editNickNameActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editNickNameActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.K1();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditNickNameActivity a;

        public b(EditNickNameActivity editNickNameActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editNickNameActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editNickNameActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.M1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditNickNameActivity a;

        public c(EditNickNameActivity editNickNameActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editNickNameActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editNickNameActivity;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
                this.a.L1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditNickNameActivity a;

        public d(EditNickNameActivity editNickNameActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editNickNameActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editNickNameActivity;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
                this.a.F1(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditNickNameActivity a;

        public e(EditNickNameActivity editNickNameActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editNickNameActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editNickNameActivity;
        }

        public /* synthetic */ e(EditNickNameActivity editNickNameActivity, a aVar) {
            this(editNickNameActivity);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                aq4.a("EditNickNameActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                String title = this.a.b.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.a.c.setCenterTextTitle(title);
                }
                this.a.G1();
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.Q1();
                    this.a.h = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.O1();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.P1();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (!StringUtils.isNull(str)) {
                    if (!this.a.J1(str)) {
                        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.e, new String[]{str});
                        if (dealOneLinkWithOutJumpWebView == 1) {
                            this.a.finish();
                            return true;
                        } else if (dealOneLinkWithOutJumpWebView == 0) {
                            return true;
                        } else {
                            this.a.b.loadUrl(str);
                        }
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    public EditNickNameActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void G1() {
        ka5 ka5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ka5Var = this.f) != null) {
            ka5Var.dettachView(this.d);
            this.f = null;
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.loadUrl("javascript:__js_bridge_modify_name_save_action()");
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.h) {
                this.b.loadUrl("javascript:window.reload_page()");
            } else {
                this.b.loadUrl(this.a);
            }
        }
    }

    public void O1() {
        TbPageContext<EditNickNameActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tbPageContext = this.e) != null && this.d != null) {
            ka5 ka5Var = new ka5(tbPageContext.getPageActivity());
            this.f = ka5Var;
            ka5Var.attachView(this.d, false);
            this.f.onChangeSkinType();
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            la5 la5Var = this.g;
            if (la5Var != null) {
                la5Var.dettachView(this.d);
                this.g = null;
            }
            this.b.setVisibility(0);
        }
    }

    public final boolean J1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return I1(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, keyEvent)) == null) {
            if (i == 4) {
                K1();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final String E1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            try {
                if (StringUtils.isNull(new URL(str).getQuery())) {
                    return str + "?isNightModel=1";
                }
                return str + "&isNightModel=1";
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final boolean I1(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String urlDecode = xi.getUrlDecode(str);
            if (!urlDecode.contains(UrlSchemaHelper.SCHEMA_TYPE_MODIFY_NAME) || !urlDecode.contains("data=")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                if (jSONObject.optInt("isclose") == 1) {
                    z = true;
                } else {
                    z = false;
                }
                String optString = jSONObject.optString("nickname");
                if (z) {
                    F1(optString);
                } else {
                    N1();
                }
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.e = getPageContext();
            this.j = getIntent().getIntExtra(EditNickNameActivityConfig.PARAM_TYPE, 0);
            String stringExtra = getIntent().getStringExtra(EditNickNameActivityConfig.PARAM_URL);
            this.a = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.a = "https://tieba.baidu.com/n/interact/modifyname";
            }
            setContentView(R.layout.obfuscated_res_0x7f0d024f);
            H1();
            sp4.g(getApplicationContext());
        }
    }

    public final void F1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            BaseWebView baseWebView = this.b;
            if (baseWebView != null && baseWebView.canGoBack()) {
                this.b.goBack();
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921033, str));
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            if (i != 1 && i != 4) {
                this.b.loadUrl(this.a);
            } else {
                this.b.loadUrl(E1(this.a));
            }
            this.c.onChangeSkinType(getPageContext(), i);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = findViewById(R.id.root_layout);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f09271c);
            this.b = baseWebView;
            baseWebView.setWebViewClient(new e(this, null));
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            if (this.j == 0) {
                navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b4d));
            }
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.i == null) {
                lv4 lv4Var = new lv4(getActivity());
                this.i = lv4Var;
                lv4Var.setMessage(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0b4f));
                this.i.setPositiveButton(R.string.obfuscated_res_0x7f0f110d, new c(this));
                this.i.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new d(this));
                this.i.create(getPageContext());
            }
            this.i.show();
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cb8);
            if (this.g == null) {
                la5 la5Var = new la5(this.e.getPageActivity(), new b(this));
                this.g = la5Var;
                la5Var.onChangeSkinType();
            }
            this.b.setVisibility(8);
            this.g.m(string);
            this.g.attachView(this.d, false);
            this.g.p();
            this.g.k(this.e.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
        }
    }

    public final void K1() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.h && (baseWebView = this.b) != null && !TextUtils.isEmpty(baseWebView.getUrl()) && this.b.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
                this.b.loadUrl("javascript:__js_bridge_modify_name_back_action()");
            } else {
                F1(null);
            }
        }
    }
}
