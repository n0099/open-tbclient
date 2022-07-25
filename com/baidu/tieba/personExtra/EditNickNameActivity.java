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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.am4;
import com.repackage.dr4;
import com.repackage.k55;
import com.repackage.l55;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.sl4;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BaseWebView b;
    public NavigationBar c;
    public View d;
    public TbPageContext<EditNickNameActivity> e;
    public k55 f;
    public l55 g;
    public boolean h;
    public dr4 i;
    public int j;

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.O1();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.Q1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                this.a.P1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                this.a.J1(null);
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                String title = this.a.b.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.a.c.setCenterTextTitle(title);
                }
                this.a.K1();
                if (ni.z()) {
                    this.a.U1();
                    this.a.h = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.S1();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.T1();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                am4.a("EditNickNameActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (!StringUtils.isNull(str)) {
                    if (!this.a.N1(str)) {
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

        public /* synthetic */ e(EditNickNameActivity editNickNameActivity, a aVar) {
            this(editNickNameActivity);
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

    public final String I1(String str) {
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

    public final void J1(String str) {
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

    public void K1() {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (k55Var = this.f) == null) {
            return;
        }
        k55Var.dettachView(this.d);
        this.f = null;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = findViewById(R.id.obfuscated_res_0x7f091b44);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f0924ca);
            this.b = baseWebView;
            baseWebView.setWebViewClient(new e(this, null));
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092439);
            this.c = navigationBar;
            if (this.j == 0) {
                navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0abc));
            }
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }

    public final boolean M1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String urlDecode = oi.getUrlDecode(str);
            if (urlDecode.contains(UrlSchemaHelper.SCHEMA_TYPE_MODIFY_NAME) && urlDecode.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                    boolean z = jSONObject.optInt("isclose") == 1;
                    String optString = jSONObject.optString("nickname");
                    if (z) {
                        J1(optString);
                    } else {
                        R1();
                    }
                    return true;
                } catch (JSONException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean N1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? M1(str) : invokeL.booleanValue;
    }

    public final void O1() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.h && (baseWebView = this.b) != null && !TextUtils.isEmpty(baseWebView.getUrl()) && this.b.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
                this.b.loadUrl("javascript:__js_bridge_modify_name_back_action()");
            } else {
                J1(null);
            }
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.loadUrl("javascript:__js_bridge_modify_name_save_action()");
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.h) {
                this.b.loadUrl("javascript:window.reload_page()");
            } else {
                this.b.loadUrl(this.a);
            }
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.i == null) {
                dr4 dr4Var = new dr4(getActivity());
                this.i = dr4Var;
                dr4Var.setMessage(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0abe));
                this.i.setPositiveButton(R.string.obfuscated_res_0x7f0f104a, new c(this));
                this.i.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new d(this));
                this.i.create(getPageContext());
            }
            this.i.show();
        }
    }

    public void S1() {
        TbPageContext<EditNickNameActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.e) == null || this.d == null) {
            return;
        }
        k55 k55Var = new k55(tbPageContext.getPageActivity());
        this.f = k55Var;
        k55Var.attachView(this.d, false);
        this.f.onChangeSkinType();
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17);
            if (this.g == null) {
                l55 l55Var = new l55(this.e.getPageActivity(), new b(this));
                this.g = l55Var;
                l55Var.onChangeSkinType();
            }
            this.b.setVisibility(8);
            this.g.m(string);
            this.g.attachView(this.d, false);
            this.g.p();
            this.g.k(this.e.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
        }
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l55 l55Var = this.g;
            if (l55Var != null) {
                l55Var.dettachView(this.d);
                this.g = null;
            }
            this.b.setVisibility(0);
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
                this.b.loadUrl(I1(this.a));
            }
            this.c.onChangeSkinType(getPageContext(), i);
        }
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
            setContentView(R.layout.obfuscated_res_0x7f0d0242);
            L1();
            sl4.g(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, keyEvent)) == null) {
            if (i == 4) {
                O1();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
