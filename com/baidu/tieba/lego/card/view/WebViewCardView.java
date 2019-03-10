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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.WebViewCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WebViewCardView extends BaseCardView<WebViewCard> {
    private static boolean gKM = true;
    private boolean enableTouchFromNet;
    private XiubaTbJsBridge gJh;
    private final CustomMessageListener gKN;
    private LinearLayout gzU;
    private BaseWebView mWebView;

    public WebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.enableTouchFromNet = true;
        this.gKN = new CustomMessageListener(2002503) { // from class: com.baidu.tieba.lego.card.view.WebViewCardView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    boolean unused = WebViewCardView.gKM = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
            }
        };
        this.mContext = tbPageContext;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.gzU = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_webview, (ViewGroup) null);
        bAR();
        return this.gzU;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void bAR() {
        this.mWebView = new BaseWebView(TbadkCoreApplication.getInst());
        if (this.gJh == null) {
            this.gJh = new XiubaTbJsBridge(this.mContext);
        }
        this.gJh.setBaseWebView(this.mWebView);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.tieba.lego.card.view.WebViewCardView.1
            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return WebViewCardView.this.b(str2, jsPromptResult);
            }
        });
        this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.WebViewCardView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!WebViewCardView.this.enableTouchFromNet && !WebViewCardView.gKM) {
                    ((WebView) view).requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        this.mWebView.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.lego.card.view.WebViewCardView.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                ba.adD().a(WebViewCardView.this.mContext, new String[]{str}, true);
                return true;
            }
        });
        i(this.mContext.getUniqueId());
        this.gzU.addView(this.mWebView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(WebViewCard webViewCard, int i) {
        if (TextUtils.isEmpty(webViewCard.getPageUrl()) || this.mWebView == null) {
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
            return this.gJh.dealJsInterface(optString, optString2, optString3, jsPromptResult);
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
    public void e(WebViewCard webViewCard) {
        if (this.mWebView != null) {
            this.enableTouchFromNet = webViewCard.isEnableTouchFromNet();
            if (webViewCard.getHeight() > 0) {
                setWebviewHeight(webViewCard.getHeight());
            } else if (webViewCard.getContainer() > 0) {
                int aQ = com.baidu.adp.lib.util.l.aQ(getContext());
                switch (webViewCard.getContainer()) {
                    case 1:
                        setWebviewHeight(aQ - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds236));
                        break;
                    case 2:
                        setWebviewHeight(aQ - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds320));
                        break;
                }
            }
            if (!TextUtils.isEmpty(webViewCard.getPageUrl())) {
                CompatibleUtile.getInstance().loadUrl(this.mWebView, webViewCard.getPageUrl());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gKN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gKN);
        }
    }
}
