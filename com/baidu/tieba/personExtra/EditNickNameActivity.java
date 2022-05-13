package com.baidu.tieba.personExtra;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.repackage.fm4;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.mm4;
import com.repackage.nr4;
import com.repackage.x45;
import com.repackage.y45;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String MODIFY_NICKNAME_URL;
    public nr4 mDialog;
    public boolean mLoadSuccess;
    public x45 mLoadingView;
    public NavigationBar mNavigationBar;
    public TbPageContext<EditNickNameActivity> mPageContext;
    public y45 mRefreshView;
    public View mRootView;
    public int mType;
    public String mUrl;
    public BaseWebView mWebView;

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
                this.a.onBackClick();
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
                this.a.reloadPage();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                this.a.onSaveClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                this.a.goBackOrFinish(null);
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
                String title = this.a.mWebView.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.a.mNavigationBar.setCenterTextTitle(title);
                }
                this.a.hideLoadingView();
                if (ki.z()) {
                    this.a.showNormalView();
                    this.a.mLoadSuccess = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.showLoadingView();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.showNetRefreshView();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                mm4.a("EditNickNameActivity", webView);
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
                    if (!this.a.nativeJump(str)) {
                        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.mPageContext, new String[]{str});
                        if (dealOneLinkWithOutJumpWebView == 1) {
                            this.a.finish();
                            return true;
                        } else if (dealOneLinkWithOutJumpWebView == 0) {
                            return true;
                        } else {
                            this.a.mWebView.loadUrl(str);
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
                return;
            }
        }
        this.MODIFY_NICKNAME_URL = "https://tieba.baidu.com/n/interact/modifyname";
    }

    private String createUrlNightType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackOrFinish(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            BaseWebView baseWebView = this.mWebView;
            if (baseWebView != null && baseWebView.canGoBack()) {
                this.mWebView.goBack();
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921033, str));
            }
            finish();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091b24);
            BaseWebView baseWebView = (BaseWebView) findViewById(R.id.obfuscated_res_0x7f092477);
            this.mWebView = baseWebView;
            baseWebView.setWebViewClient(new e(this, null));
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.mNavigationBar = navigationBar;
            if (this.mType == 0) {
                navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0ad5));
            }
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }

    private boolean jumpOrFinish(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            String urlDecode = li.getUrlDecode(str);
            if (urlDecode.contains(UrlSchemaHelper.SCHEMA_TYPE_MODIFY_NAME) && urlDecode.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                    boolean z = jSONObject.optInt("isclose") == 1;
                    String optString = jSONObject.optString("nickname");
                    if (z) {
                        goBackOrFinish(optString);
                    } else {
                        showDialog();
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nativeJump(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? jumpOrFinish(str) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.mLoadSuccess && (baseWebView = this.mWebView) != null && !TextUtils.isEmpty(baseWebView.getUrl()) && this.mWebView.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
                this.mWebView.loadUrl("javascript:__js_bridge_modify_name_back_action()");
            } else {
                goBackOrFinish(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mWebView.loadUrl("javascript:__js_bridge_modify_name_save_action()");
        }
    }

    private void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.mDialog == null) {
                nr4 nr4Var = new nr4(getActivity());
                this.mDialog = nr4Var;
                nr4Var.setMessage(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0ad8));
                this.mDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f107c, new c(this));
                this.mDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new d(this));
                this.mDialog.create(getPageContext());
            }
            this.mDialog.show();
        }
    }

    public void hideLoadingView() {
        x45 x45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (x45Var = this.mLoadingView) == null) {
            return;
        }
        x45Var.dettachView(this.mRootView);
        this.mLoadingView = null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            if (i != 1 && i != 4) {
                this.mWebView.loadUrl(this.mUrl);
            } else {
                this.mWebView.loadUrl(createUrlNightType(this.mUrl));
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.mPageContext = getPageContext();
            this.mType = getIntent().getIntExtra(EditNickNameActivityConfig.PARAM_TYPE, 0);
            String stringExtra = getIntent().getStringExtra(EditNickNameActivityConfig.PARAM_URL);
            this.mUrl = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mUrl = "https://tieba.baidu.com/n/interact/modifyname";
            }
            setContentView(R.layout.obfuscated_res_0x7f0d024b);
            initView();
            fm4.f(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, keyEvent)) == null) {
            if (i == 4) {
                onBackClick();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void reloadPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.mLoadSuccess) {
                this.mWebView.loadUrl("javascript:window.reload_page()");
            } else {
                this.mWebView.loadUrl(this.mUrl);
            }
        }
    }

    public void showLoadingView() {
        TbPageContext<EditNickNameActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tbPageContext = this.mPageContext) == null || this.mRootView == null) {
            return;
        }
        x45 x45Var = new x45(tbPageContext.getPageActivity());
        this.mLoadingView = x45Var;
        x45Var.attachView(this.mRootView, false);
        this.mLoadingView.onChangeSkinType();
    }

    public void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c2d);
            if (this.mRefreshView == null) {
                y45 y45Var = new y45(this.mPageContext.getPageActivity(), new b(this));
                this.mRefreshView = y45Var;
                y45Var.onChangeSkinType();
            }
            this.mWebView.setVisibility(8);
            this.mRefreshView.m(string);
            this.mRefreshView.attachView(this.mRootView, false);
            this.mRefreshView.p();
            this.mRefreshView.k(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070295));
        }
    }

    public void showNormalView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y45 y45Var = this.mRefreshView;
            if (y45Var != null) {
                y45Var.dettachView(this.mRootView);
                this.mRefreshView = null;
            }
            this.mWebView.setVisibility(0);
        }
    }
}
