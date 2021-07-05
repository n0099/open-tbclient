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
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.w2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ImmersiveWebViewCardView extends BaseCardView<ImmersiveWebViewCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout r;
    public BaseWebView s;
    public d.a.s0.h3.l0.a t;
    public XiubaTbJsBridge u;

    /* loaded from: classes5.dex */
    public class a extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImmersiveWebViewCardView f18206a;

        public a(ImmersiveWebViewCardView immersiveWebViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immersiveWebViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18206a = immersiveWebViewCardView;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) ? this.f18206a.L(str2, jsPromptResult) : invokeLLLLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImmersiveWebViewCardView f18207e;

        public b(ImmersiveWebViewCardView immersiveWebViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immersiveWebViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18207e = immersiveWebViewCardView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                UrlManager.getInstance().dealOneLink(this.f18207e.m, new String[]{str}, true);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        d.a.s0.h3.l0.a aVar = new d.a.s0.h3.l0.a();
        this.t = aVar;
        aVar.a(new XiubaTbJsBridge(this.m));
        this.t.a(new CommonTbJsBridge(this.m.getPageActivity()));
    }

    private void setWebviewHeight(int i2) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || (baseWebView = this.s) == null || i2 <= 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseWebView.getLayoutParams();
        layoutParams.height = i2;
        this.s.setLayoutParams(layoutParams);
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.s == null) {
                BridgeWebView bridgeWebView = new BridgeWebView(this.m.getPageActivity());
                this.s = bridgeWebView;
                bridgeWebView.getSettings().setJavaScriptEnabled(true);
                this.s.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.s.getSettings().setAllowFileAccess(true);
                this.s.getSettings().setDatabaseEnabled(true);
                this.s.getSettings().setDomStorageEnabled(true);
            }
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            I();
            if (this.u == null) {
                this.u = new XiubaTbJsBridge(this.m);
            }
            this.u.setBaseWebView(this.s);
            this.s.setHorizontalScrollBarEnabled(false);
            this.s.setWebChromeClient(new a(this));
            this.s.setOnLoadUrlListener(new b(this));
            this.r.addView(this.s);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void v(ImmersiveWebViewCard immersiveWebViewCard, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, immersiveWebViewCard, i2) != null) || TextUtils.isEmpty(immersiveWebViewCard.getPageUrl()) || this.s == null) {
        }
    }

    public final boolean L(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jsPromptResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return this.u.dealJsInterface(optString, optString2, optString3, jsPromptResult);
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void w(ImmersiveWebViewCard immersiveWebViewCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, immersiveWebViewCard) == null) || this.s == null) {
            return;
        }
        if (immersiveWebViewCard.getHeight() > 0) {
            setWebviewHeight(immersiveWebViewCard.getHeight());
        } else {
            setWebviewHeight(l.i(getContext()));
        }
        if (immersiveWebViewCard.mHasShown) {
            return;
        }
        if (!TextUtils.isEmpty(immersiveWebViewCard.getPageUrl())) {
            CompatibleUtile.getInstance().loadUrl(this.s, immersiveWebViewCard.getPageUrl());
        }
        w.p().m().d(immersiveWebViewCard.getShowExtra(), this.f18190e);
        immersiveWebViewCard.mHasShown = true;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.r = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_webview, (ViewGroup) null);
            J();
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
