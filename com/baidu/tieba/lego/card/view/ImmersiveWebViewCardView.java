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
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.z2.y;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ImmersiveWebViewCardView extends BaseCardView<ImmersiveWebViewCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f51142f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f51143g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.l3.n0.a f51144h;

    /* renamed from: i  reason: collision with root package name */
    public XiubaTbJsBridge f51145i;

    /* loaded from: classes9.dex */
    public class a extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImmersiveWebViewCardView f51146a;

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
            this.f51146a = immersiveWebViewCardView;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) ? this.f51146a.e(str2, jsPromptResult) : invokeLLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImmersiveWebViewCardView f51147e;

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
            this.f51147e = immersiveWebViewCardView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                UrlManager.getInstance().dealOneLink(this.f51147e.mContext, new String[]{str}, true);
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
        this.mContext = tbPageContext;
        b.a.r0.l3.n0.a aVar = new b.a.r0.l3.n0.a();
        this.f51144h = aVar;
        aVar.a(new XiubaTbJsBridge(this.mContext));
        this.f51144h.a(new CommonTbJsBridge(this.mContext.getPageActivity()));
    }

    private void setWebviewHeight(int i2) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || (baseWebView = this.f51143g) == null || i2 <= 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseWebView.getLayoutParams();
        layoutParams.height = i2;
        this.f51143g.setLayoutParams(layoutParams);
    }

    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f51143g == null) {
                BridgeWebView bridgeWebView = new BridgeWebView(this.mContext.getPageActivity());
                this.f51143g = bridgeWebView;
                bridgeWebView.getSettings().setJavaScriptEnabled(true);
                this.f51143g.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.f51143g.getSettings().setAllowFileAccess(true);
                this.f51143g.getSettings().setDatabaseEnabled(true);
                this.f51143g.getSettings().setDomStorageEnabled(true);
            }
            return this.f51143g;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            createWebView();
            if (this.f51145i == null) {
                this.f51145i = new XiubaTbJsBridge(this.mContext);
            }
            this.f51145i.setBaseWebView(this.f51143g);
            this.f51143g.setHorizontalScrollBarEnabled(false);
            this.f51143g.setWebChromeClient(new a(this));
            this.f51143g.setOnLoadUrlListener(new b(this));
            this.f51142f.addView(this.f51143g);
        }
    }

    public final boolean e(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jsPromptResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return this.f51145i.dealJsInterface(optString, optString2, optString3, jsPromptResult);
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f51142f = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_webview, (ViewGroup) null);
            d();
            return this.f51142f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(ImmersiveWebViewCard immersiveWebViewCard, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, immersiveWebViewCard, i2) != null) || TextUtils.isEmpty(immersiveWebViewCard.getPageUrl()) || this.f51143g == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(ImmersiveWebViewCard immersiveWebViewCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, immersiveWebViewCard) == null) || this.f51143g == null) {
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
            CompatibleUtile.getInstance().loadUrl(this.f51143g, immersiveWebViewCard.getPageUrl());
        }
        y.o().l().d(immersiveWebViewCard.getShowExtra(), this.mFrom);
        immersiveWebViewCard.mHasShown = true;
    }
}
