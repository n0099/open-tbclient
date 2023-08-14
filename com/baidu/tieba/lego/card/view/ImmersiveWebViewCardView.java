package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.fca;
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ImmersiveWebViewCardView extends BaseCardView<ImmersiveWebViewCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public BaseWebView n;
    public fca o;
    public XiubaTbJsBridge p;

    /* loaded from: classes6.dex */
    public class a extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImmersiveWebViewCardView a;

        public a(ImmersiveWebViewCardView immersiveWebViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immersiveWebViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = immersiveWebViewCardView;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) {
                return this.a.H(str2, jsPromptResult);
            }
            return invokeLLLLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImmersiveWebViewCardView a;

        public b(ImmersiveWebViewCardView immersiveWebViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immersiveWebViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = immersiveWebViewCardView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                UrlManager.getInstance().dealOneLink(this.a.i, new String[]{str}, true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmersiveWebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
        fca fcaVar = new fca();
        this.o = fcaVar;
        fcaVar.a(new XiubaTbJsBridge(this.i));
        this.o.a(new CommonTbJsBridge(this.i.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void v(ImmersiveWebViewCard immersiveWebViewCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, immersiveWebViewCard) != null) || this.n == null) {
            return;
        }
        if (immersiveWebViewCard.getHeight() > 0) {
            setWebviewHeight(immersiveWebViewCard.getHeight());
        } else {
            setWebviewHeight(BdUtilHelper.getEquipmentHeight(getContext()));
        }
        if (!immersiveWebViewCard.mHasShown) {
            if (!TextUtils.isEmpty(immersiveWebViewCard.getPageUrl())) {
                CompatibleUtile.getInstance().loadUrl(this.n, immersiveWebViewCard.getPageUrl());
            }
            immersiveWebViewCard.mHasShown = true;
        }
    }

    private void setWebviewHeight(int i) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, this, i) == null) && (baseWebView = this.n) != null && i > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseWebView.getLayoutParams();
            layoutParams.height = i;
            this.n.setLayoutParams(layoutParams);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.n == null) {
                BridgeWebView bridgeWebView = new BridgeWebView(this.i.getPageActivity());
                this.n = bridgeWebView;
                bridgeWebView.getSettings().setJavaScriptEnabled(true);
                this.n.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.n.getSettings().setAllowFileAccess(true);
                this.n.getSettings().setDatabaseEnabled(true);
                this.n.getSettings().setDomStorageEnabled(true);
            }
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            E();
            if (this.p == null) {
                this.p = new XiubaTbJsBridge(this.i);
            }
            this.p.setBaseWebView(this.n);
            this.n.setHorizontalScrollBarEnabled(false);
            this.n.setWebChromeClient(new a(this));
            this.n.setOnLoadUrlListener(new b(this));
            this.m.addView(this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: G */
    public void u(ImmersiveWebViewCard immersiveWebViewCard, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, immersiveWebViewCard, i) != null) || TextUtils.isEmpty(immersiveWebViewCard.getPageUrl()) || this.n == null) {
        }
    }

    public final boolean H(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jsPromptResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return this.p.dealJsInterface(optString, optString2, optString3, jsPromptResult);
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.m = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01ea, (ViewGroup) null);
            F();
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
