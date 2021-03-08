package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView bXo;
    private List<String> bXp;
    private SchemeCallback bXr;
    private String eOm;
    private boolean how;
    private a oux;

    /* loaded from: classes10.dex */
    public interface a {
        void nG(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bXr = new SchemeCallback() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bXo.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bXo.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.oux = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bXp == null) {
            this.bXp = new ArrayList();
        }
        this.bXp.add(str);
        this.bXo.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bXo != null) {
            this.bXo.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bXo != null ? this.bXo.getOriginalUrl() : "";
    }

    public boolean bYX() {
        return this.how;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bXo != null) {
            this.bXo.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStart() {
        if (this.bXo != null) {
            this.bXo.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bXo.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStop() {
        if (this.bXo != null) {
            this.bXo.onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void release() {
        this.oux = null;
        this.how = false;
        removeAllViews();
        if (this.bXo != null) {
            if (this.bXp != null) {
                for (String str : this.bXp) {
                    this.bXo.removeJavascriptInterface(str);
                }
                this.bXp.clear();
            }
            this.bXo.stopLoading();
            this.bXo.removeAllViews();
            this.bXo.loadUrl("about:blank");
            this.bXo.freeMemory();
            this.bXo.destroy();
        }
    }

    private void init() {
        this.how = false;
        setBackgroundColor(0);
        this.bXo = new CommonWebView(getContext());
        this.bXo.setVerticalScrollEnabled(false);
        this.bXo.setHorizontalScrollEnabled(false);
        this.bXo.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.how = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.oux != null) {
                                AlaActiveWebView.this.oux.nG(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.rt(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.rt(uri);
                }
            }
        });
        addView(this.bXo, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bXo.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(String str) {
        this.eOm = str;
        this.bXo.loadUrl("file:///android_asset/web/error.html");
        this.bXo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bXo != null && AlaActiveWebView.this.bXo.getUrl() != null && AlaActiveWebView.this.bXo.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.eOm)) {
                    AlaActiveWebView.this.bXo.loadUrl(AlaActiveWebView.this.eOm);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bXr;
    }
}
