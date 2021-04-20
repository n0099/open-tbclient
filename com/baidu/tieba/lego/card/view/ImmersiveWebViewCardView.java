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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import d.b.c.e.p.l;
import d.b.i0.s2.v;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImmersiveWebViewCardView extends BaseCardView<ImmersiveWebViewCard> {
    public LinearLayout r;
    public BaseWebView s;
    public d.b.i0.d3.l0.a t;
    public XiubaTbJsBridge u;

    /* loaded from: classes4.dex */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return ImmersiveWebViewCardView.this.P(str2, jsPromptResult);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BaseWebView.d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            UrlManager.getInstance().dealOneLink(ImmersiveWebViewCardView.this.m, new String[]{str}, true);
            return true;
        }
    }

    public ImmersiveWebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        d.b.i0.d3.l0.a aVar = new d.b.i0.d3.l0.a();
        this.t = aVar;
        aVar.a(new XiubaTbJsBridge(this.m));
        this.t.a(new CommonTbJsBridge(this.m.getPageActivity()));
    }

    private void setWebviewHeight(int i) {
        BaseWebView baseWebView = this.s;
        if (baseWebView == null || i <= 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseWebView.getLayoutParams();
        layoutParams.height = i;
        this.s.setLayoutParams(layoutParams);
    }

    public View L() {
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

    @SuppressLint({"ClickableViewAccessibility"})
    public final void M() {
        L();
        if (this.u == null) {
            this.u = new XiubaTbJsBridge(this.m);
        }
        this.u.setBaseWebView(this.s);
        this.s.setHorizontalScrollBarEnabled(false);
        this.s.setWebChromeClient(new a());
        this.s.setOnLoadUrlListener(new b());
        this.r.addView(this.s);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: O */
    public void y(ImmersiveWebViewCard immersiveWebViewCard, int i) {
        if (TextUtils.isEmpty(immersiveWebViewCard.getPageUrl()) || this.s == null) {
        }
    }

    public final boolean P(String str, JsPromptResult jsPromptResult) {
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
    /* renamed from: Q */
    public void z(ImmersiveWebViewCard immersiveWebViewCard) {
        if (this.s == null) {
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
        v.p().k().c(immersiveWebViewCard.getShowExtra(), this.f18314e);
        immersiveWebViewCard.mHasShown = true;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        this.r = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_webview, (ViewGroup) null);
        M();
        return this.r;
    }
}
