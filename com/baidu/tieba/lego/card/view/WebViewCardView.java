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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.lego.card.model.WebViewCard;
import d.a.c.e.p.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WebViewCardView extends BaseCardView<WebViewCard> {
    public static boolean w = true;
    public boolean r;
    public LinearLayout s;
    public BaseWebView t;
    public XiubaTbJsBridge u;
    public final CustomMessageListener v;

    /* loaded from: classes4.dex */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return WebViewCardView.this.O(str2, jsPromptResult);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!WebViewCardView.this.r && !WebViewCardView.w) {
                ((WebView) view).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BaseWebView.d {
        public c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            UrlManager.getInstance().dealOneLink(WebViewCardView.this.m, new String[]{str}, true);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            boolean unused = WebViewCardView.w = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    public WebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.r = true;
        this.v = new d(2002503);
        this.m = tbPageContext;
    }

    private void setWebviewHeight(int i2) {
        BaseWebView baseWebView = this.t;
        if (baseWebView == null || i2 <= 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseWebView.getLayoutParams();
        layoutParams.height = i2;
        this.t.setLayoutParams(layoutParams);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void M() {
        this.t = new BaseWebView(TbadkCoreApplication.getInst());
        if (this.u == null) {
            this.u = new XiubaTbJsBridge(this.m);
        }
        this.u.setBaseWebView(this.t);
        this.t.setHorizontalScrollBarEnabled(false);
        this.t.setWebChromeClient(new a());
        this.t.setOnTouchListener(new b());
        this.t.setOnLoadUrlListener(new c());
        k(this.m.getUniqueId());
        this.s.addView(this.t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: N */
    public void w(WebViewCard webViewCard, int i2) {
        if (TextUtils.isEmpty(webViewCard.getPageUrl()) || this.t == null) {
        }
    }

    public final boolean O(String str, JsPromptResult jsPromptResult) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: P */
    public void x(WebViewCard webViewCard) {
        if (this.t == null) {
            return;
        }
        this.r = webViewCard.isEnableTouchFromNet();
        if (webViewCard.getHeight() > 0) {
            setWebviewHeight(webViewCard.getHeight());
        } else if (webViewCard.getContainer() > 0) {
            int i2 = l.i(getContext());
            int container = webViewCard.getContainer();
            if (container == 1) {
                setWebviewHeight(i2 - l.g(getContext(), R.dimen.ds236));
            } else if (container == 2) {
                setWebviewHeight(i2 - l.g(getContext(), R.dimen.ds320));
            }
        }
        if (TextUtils.isEmpty(webViewCard.getPageUrl())) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.t, webViewCard.getPageUrl());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.a.n0.k1.o.l.e
    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.v.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.v);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View t() {
        this.s = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_webview, (ViewGroup) null);
        M();
        return this.s;
    }
}
