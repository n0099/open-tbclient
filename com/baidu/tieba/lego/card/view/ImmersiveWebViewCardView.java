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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import com.baidu.tieba.recapp.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ImmersiveWebViewCardView extends BaseCardView<ImmersiveWebViewCard> {
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private LinearLayout kSH;
    private XiubaTbJsBridge lau;
    private BaseWebView mWebView;

    public ImmersiveWebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eXu = tbPageContext;
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(this.eXu));
        this.jsBridge.a(new CommonTbJsBridge(this.eXu.getPageActivity()));
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.kSH = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_webview, (ViewGroup) null);
        des();
        return this.kSH;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void des() {
        createWebView();
        if (this.lau == null) {
            this.lau = new XiubaTbJsBridge(this.eXu);
        }
        this.lau.setBaseWebView(this.mWebView);
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
                be.bwv().a(ImmersiveWebViewCardView.this.eXu, new String[]{str}, true);
                return true;
            }
        });
        this.kSH.addView(this.mWebView);
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
            return this.lau.dealJsInterface(optString, optString2, optString3, jsPromptResult);
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
    public void d(ImmersiveWebViewCard immersiveWebViewCard) {
        if (this.mWebView != null) {
            if (immersiveWebViewCard.getHeight() > 0) {
                setWebviewHeight(immersiveWebViewCard.getHeight());
            } else {
                setWebviewHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(getContext()));
            }
            if (!immersiveWebViewCard.mHasShown) {
                if (!TextUtils.isEmpty(immersiveWebViewCard.getPageUrl())) {
                    CompatibleUtile.getInstance().loadUrl(this.mWebView, immersiveWebViewCard.getPageUrl());
                }
                r.dEW().dES().ek(immersiveWebViewCard.getShowExtra(), this.mFrom);
                immersiveWebViewCard.mHasShown = true;
            }
        }
    }

    public View createWebView() {
        if (this.mWebView == null) {
            this.mWebView = new BridgeWebView(this.eXu.getPageActivity());
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.getSettings().setAllowFileAccess(true);
            this.mWebView.getSettings().setDatabaseEnabled(true);
            this.mWebView.getSettings().setDomStorageEnabled(true);
        }
        return this.mWebView;
    }
}
