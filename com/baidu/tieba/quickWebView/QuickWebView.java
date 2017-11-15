package com.baidu.tieba.quickWebView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.p.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class QuickWebView extends BaseWebView {
    private static String TAG = QuickWebView.class.getSimpleName();
    private b fJU;
    private boolean fJV;
    private boolean fJW;
    private int fJX;
    private ObjectAnimator fJY;
    private ObjectAnimator fJZ;
    private BaseWebView.e fKa;
    private Context mContext;
    private ProgressBar mProgressBar;

    public QuickWebView(Context context) {
        super(context);
        this.fJV = false;
        this.fKa = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.fJV) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.fJX = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.fJW) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.ss(i);
                        return;
                    }
                    QuickWebView.this.fJW = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.st(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fJV = false;
        this.fKa = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.fJV) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.fJX = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.fJW) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.ss(i);
                        return;
                    }
                    QuickWebView.this.fJW = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.st(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.fJU = new b(this);
        this.mJsBridge.a(new a(context, this.fJU));
    }

    public void lE(boolean z) {
        if (z) {
            bP(this.mContext);
        }
    }

    private void bP(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(context.getResources().getDrawable(d.f.quick_webview_progress));
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.fKa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        if (this.fJY != null) {
            this.fJY.cancel();
            this.fJY = null;
        }
        this.fJY = ObjectAnimator.ofInt(this.mProgressBar, "progress", this.fJX, i);
        this.fJY.setDuration(100L);
        this.fJY.setInterpolator(new DecelerateInterpolator());
        this.fJY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(final int i) {
        if (this.fJZ != null) {
            this.fJZ.cancel();
            this.fJZ = null;
        }
        this.fJZ = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.fJZ.setDuration(150L);
        this.fJZ.setInterpolator(new DecelerateInterpolator());
        this.fJZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.fJZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.fJW = false;
            }
        });
        this.fJZ.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L12;
     */
    @Override // android.webkit.WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        if (!str.contains("javascript:")) {
            this.fJV = false;
            String str2 = str + (str.contains("?") ? "&" : "?") + "_webview_time=" + System.currentTimeMillis();
            if (ai.GM()) {
                str = rl(str2);
            }
            str = str2;
        }
        super.loadUrl(str);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01cd -> B:6:0x001d). Please submit an issue!!! */
    private String rl(String str) {
        URL url;
        String path;
        com.baidu.tieba.quickWebView.data.a ro;
        boolean z;
        String[] split;
        String str2 = null;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            path = url.getPath();
            ro = d.biT().ro(path);
        } catch (MalformedURLException e) {
        }
        if (ro != null && !ro.fKv) {
            String uj = c.biM().uj();
            String str3 = uj + path + ".html";
            File file = new File(str3);
            if (!str3.contains("/android_asset/") && !file.exists()) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", new Object[0]);
                return null;
            }
            String query = url.getQuery();
            String str4 = SkiaImageDecoder.FILE_PREFIX + uj + path + ".html";
            try {
                if (!TextUtils.isEmpty(query)) {
                    str4 = str4 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str4;
            }
            if (ro.fKu != null && ro.fKu.size() != 0) {
                if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                    for (String str5 : split) {
                        String[] split2 = str5.split("=");
                        if (split2 != null && split2.length == 2) {
                            hashMap.put("{" + split2[0] + "}", split2[1]);
                        }
                    }
                }
                hashMap.put("{client_version}", TbConfig.getVersion());
                hashMap.put("{client_type}", "2");
                Iterator<String> it = ro.fKu.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    StringBuilder sb = new StringBuilder();
                    String query2 = new URL(next).getQuery();
                    if (!TextUtils.isEmpty(query2)) {
                        String[] split3 = query2.split("&");
                        if (split3 != null) {
                            int length = split3.length;
                            int i = 0;
                            boolean z2 = true;
                            while (i < length) {
                                String str6 = split3[i];
                                if (!z2) {
                                    sb.append("&");
                                    z = z2;
                                } else {
                                    z = false;
                                }
                                String[] split4 = str6.split("=");
                                if (split4 != null && split4.length == 2) {
                                    String str7 = (String) hashMap.get(split4[1]);
                                    if (str7 == null) {
                                        str7 = split4[1];
                                        if (str7.contains("{") && str7.contains("}")) {
                                            str7 = null;
                                        }
                                    }
                                    sb.append(split4[0]);
                                    sb.append("=");
                                    if (!TextUtils.isEmpty(str7)) {
                                        sb.append(str7);
                                    }
                                }
                                i++;
                                z2 = z;
                            }
                        }
                        String sb2 = sb.toString();
                        if (!TextUtils.isEmpty(sb2)) {
                            next = next.replace(query2, sb2);
                        }
                    }
                    QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                    quickWebViewBridgeData.type = "get";
                    quickWebViewBridgeData.url = next;
                    quickWebViewBridgeData.begin = System.currentTimeMillis();
                    this.fJU.a(quickWebViewBridgeData, null);
                }
                str2 = str4;
                return str2;
            }
            return str4;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.fJU.onDestory();
        this.fJU = null;
        this.fKa = null;
        setOnProgressChangedListener(null);
        if (this.fJY != null) {
            this.fJY.cancel();
            this.fJY = null;
        }
        if (this.fJZ != null) {
            this.fJZ.cancel();
            this.fJZ = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.fJV = true;
        super.goBack();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView
    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        Log.e(TAG, "QuickWebView do not support setOnJsPromptCallback");
    }

    public void addJsPromptInterface(com.baidu.tieba.tbadkCore.e.b bVar) {
        this.mJsBridge.a(bVar);
    }
}
