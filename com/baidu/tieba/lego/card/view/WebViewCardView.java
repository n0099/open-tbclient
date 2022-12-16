package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WebViewCardView extends BaseCardView<WebViewCard> {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean r = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean m;
    public LinearLayout n;
    public BaseWebView o;
    public XiubaTbJsBridge p;
    public final CustomMessageListener q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-295244648, "Lcom/baidu/tieba/lego/card/view/WebViewCardView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-295244648, "Lcom/baidu/tieba/lego/card/view/WebViewCardView;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebViewCardView a;

        public a(WebViewCardView webViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewCardView;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) {
                return this.a.I(str2, jsPromptResult);
            }
            return invokeLLLLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebViewCardView a;

        public b(WebViewCardView webViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewCardView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (!this.a.m && !WebViewCardView.r) {
                    ((WebView) view2).requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebViewCardView a;

        public c(WebViewCardView webViewCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewCardView;
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebViewCardView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WebViewCardView webViewCardView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewCardView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            boolean unused = WebViewCardView.r = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = true;
        this.q = new d(this, 2002503);
        this.i = tbPageContext;
    }

    private void setWebviewHeight(int i) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65542, this, i) == null) && (baseWebView = this.o) != null && i > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseWebView.getLayoutParams();
            layoutParams.height = i;
            this.o.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.nm7
    public void c(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.q.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.q);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.n = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01c7, (ViewGroup) null);
            G();
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o = new BaseWebView(TbadkCoreApplication.getInst());
            if (this.p == null) {
                this.p = new XiubaTbJsBridge(this.i);
            }
            this.p.setBaseWebView(this.o);
            this.o.setHorizontalScrollBarEnabled(false);
            this.o.setWebChromeClient(new a(this));
            this.o.setOnTouchListener(new b(this));
            this.o.setOnLoadUrlListener(new c(this));
            c(this.i.getUniqueId());
            this.n.addView(this.o);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: H */
    public void t(WebViewCard webViewCard, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webViewCard, i) != null) || TextUtils.isEmpty(webViewCard.getPageUrl()) || this.o == null) {
        }
    }

    public final boolean I(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jsPromptResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString(Constants.EXTRA_PARAM);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void u(WebViewCard webViewCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, webViewCard) != null) || this.o == null) {
            return;
        }
        this.m = webViewCard.isEnableTouchFromNet();
        if (webViewCard.getHeight() > 0) {
            setWebviewHeight(webViewCard.getHeight());
        } else if (webViewCard.getContainer() > 0) {
            int j = yi.j(getContext());
            int container = webViewCard.getContainer();
            if (container != 1) {
                if (container == 2) {
                    setWebviewHeight(j - yi.g(getContext(), R.dimen.obfuscated_res_0x7f07029e));
                }
            } else {
                setWebviewHeight(j - yi.g(getContext(), R.dimen.obfuscated_res_0x7f070280));
            }
        }
        if (!TextUtils.isEmpty(webViewCard.getPageUrl())) {
            CompatibleUtile.getInstance().loadUrl(this.o, webViewCard.getPageUrl());
        }
    }
}
