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
/* loaded from: classes11.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView bVO;
    private List<String> bVP;
    private SchemeCallback bVR;
    private String eML;
    private boolean hmM;
    private a osr;

    /* loaded from: classes11.dex */
    public interface a {
        void nG(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bVR = new SchemeCallback() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bVO.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bVO.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.osr = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bVP == null) {
            this.bVP = new ArrayList();
        }
        this.bVP.add(str);
        this.bVO.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bVO != null) {
            this.bVO.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bVO != null ? this.bVO.getOriginalUrl() : "";
    }

    public boolean bYR() {
        return this.hmM;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bVO != null) {
            this.bVO.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStart() {
        if (this.bVO != null) {
            this.bVO.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bVO.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStop() {
        if (this.bVO != null) {
            this.bVO.onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void release() {
        this.osr = null;
        this.hmM = false;
        removeAllViews();
        if (this.bVO != null) {
            if (this.bVP != null) {
                for (String str : this.bVP) {
                    this.bVO.removeJavascriptInterface(str);
                }
                this.bVP.clear();
            }
            this.bVO.stopLoading();
            this.bVO.removeAllViews();
            this.bVO.loadUrl("about:blank");
            this.bVO.freeMemory();
            this.bVO.destroy();
        }
    }

    private void init() {
        this.hmM = false;
        setBackgroundColor(0);
        this.bVO = new CommonWebView(getContext());
        this.bVO.setVerticalScrollEnabled(false);
        this.bVO.setHorizontalScrollEnabled(false);
        this.bVO.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.hmM = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.osr != null) {
                                AlaActiveWebView.this.osr.nG(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.rl(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.rl(uri);
                }
            }
        });
        addView(this.bVO, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bVO.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(String str) {
        this.eML = str;
        this.bVO.loadUrl("file:///android_asset/web/error.html");
        this.bVO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bVO != null && AlaActiveWebView.this.bVO.getUrl() != null && AlaActiveWebView.this.bVO.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.eML)) {
                    AlaActiveWebView.this.bVO.loadUrl(AlaActiveWebView.this.eML);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bVR;
    }
}
