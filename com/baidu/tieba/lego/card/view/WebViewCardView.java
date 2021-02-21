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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.lego.card.model.WebViewCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class WebViewCardView extends BaseCardView<WebViewCard> {
    private static boolean lfJ = true;
    private boolean enableTouchFromNet;
    private LinearLayout kWt;
    private XiubaTbJsBridge lef;
    private final CustomMessageListener lfK;
    private BaseWebView mWebView;

    public WebViewCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.enableTouchFromNet = true;
        this.lfK = new CustomMessageListener(CmdConfigCustom.CMD_COMMON_WEBVIEW_ENABLE_TOUCH) { // from class: com.baidu.tieba.lego.card.view.WebViewCardView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    boolean unused = WebViewCardView.lfJ = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
            }
        };
        this.eUY = tbPageContext;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.kWt = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_webview, (ViewGroup) null);
        dcF();
        return this.kWt;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void dcF() {
        this.mWebView = new BaseWebView(TbadkCoreApplication.getInst());
        if (this.lef == null) {
            this.lef = new XiubaTbJsBridge(this.eUY);
        }
        this.lef.setBaseWebView(this.mWebView);
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
                if (!WebViewCardView.this.enableTouchFromNet && !WebViewCardView.lfJ) {
                    ((WebView) view).requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        this.mWebView.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.lego.card.view.WebViewCardView.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                bf.bsV().a(WebViewCardView.this.eUY, new String[]{str}, true);
                return true;
            }
        });
        l(this.eUY.getUniqueId());
        this.kWt.addView(this.mWebView);
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
            return this.lef.dealJsInterface(optString, optString2, optString3, jsPromptResult);
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
    public void d(WebViewCard webViewCard) {
        if (this.mWebView != null) {
            this.enableTouchFromNet = webViewCard.isEnableTouchFromNet();
            if (webViewCard.getHeight() > 0) {
                setWebviewHeight(webViewCard.getHeight());
            } else if (webViewCard.getContainer() > 0) {
                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(getContext());
                switch (webViewCard.getContainer()) {
                    case 1:
                        setWebviewHeight(equipmentHeight - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds236));
                        break;
                    case 2:
                        setWebviewHeight(equipmentHeight - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds320));
                        break;
                }
            }
            if (!TextUtils.isEmpty(webViewCard.getPageUrl())) {
                CompatibleUtile.getInstance().loadUrl(this.mWebView, webViewCard.getPageUrl());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lfK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.lfK);
        }
    }
}
