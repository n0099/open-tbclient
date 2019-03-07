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
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import com.baidu.tieba.recapp.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImmersiveWebViewCardView extends BaseCardView<ImmersiveWebViewCard> {
    private XiubaTbJsBridge gJg;
    private LinearLayout gzT;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private BaseWebView mWebView;

    public ImmersiveWebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mContext = tbPageContext;
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(this.mContext));
        this.jsBridge.a(new com.baidu.tbadk.browser.b(this.mContext.getPageActivity()));
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gzT = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_webview, (ViewGroup) null);
        bAQ();
        return this.gzT;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void bAQ() {
        createWebView();
        if (this.gJg == null) {
            this.gJg = new XiubaTbJsBridge(this.mContext);
        }
        this.gJg.setBaseWebView(this.mWebView);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.tieba.lego.card.view.ImmersiveWebViewCardView.1
            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return ImmersiveWebViewCardView.this.b(str2, jsPromptResult);
            }
        });
        this.mWebView.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.lego.card.view.ImmersiveWebViewCardView.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                ba.adD().a(ImmersiveWebViewCardView.this.mContext, new String[]{str}, true);
                return true;
            }
        });
        this.gzT.addView(this.mWebView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(ImmersiveWebViewCard immersiveWebViewCard, int i) {
        if (TextUtils.isEmpty(immersiveWebViewCard.getPageUrl()) || this.mWebView == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("interfaceName");
            String optString2 = jSONObject.optString("methodName");
            String optString3 = jSONObject.optString("param");
            if (StringUtils.isNull(optString) || StringUtils.isNull(optString2) || StringUtils.isNull(optString3)) {
                return false;
            }
            return this.gJg.dealJsInterface(optString, optString2, optString3, jsPromptResult);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void setWebviewHeight(int i) {
        if (this.mWebView != null && i > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mWebView.getLayoutParams();
            layoutParams.height = i;
            this.mWebView.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(ImmersiveWebViewCard immersiveWebViewCard) {
        if (this.mWebView != null) {
            if (immersiveWebViewCard.getHeight() > 0) {
                setWebviewHeight(immersiveWebViewCard.getHeight());
            } else {
                setWebviewHeight(com.baidu.adp.lib.util.l.aQ(getContext()));
            }
            if (!immersiveWebViewCard.mHasShown) {
                if (!TextUtils.isEmpty(immersiveWebViewCard.getPageUrl())) {
                    CompatibleUtile.getInstance().loadUrl(this.mWebView, immersiveWebViewCard.getPageUrl());
                }
                r.bWG().bWC().ca(immersiveWebViewCard.getShowExtra(), this.mFrom);
                immersiveWebViewCard.mHasShown = true;
            }
        }
    }

    public View createWebView() {
        if (this.mWebView == null) {
            this.mWebView = new BridgeWebView(this.mContext.getPageActivity());
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.getSettings().setAllowFileAccess(true);
            this.mWebView.getSettings().setDatabaseEnabled(true);
            this.mWebView.getSettings().setDomStorageEnabled(true);
        }
        return this.mWebView;
    }
}
