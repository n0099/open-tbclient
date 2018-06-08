package com.baidu.tieba.quickWebView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.o.an;
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
    private b ghM;
    private boolean ghN;
    private boolean ghO;
    private int ghP;
    private ObjectAnimator ghQ;
    private ObjectAnimator ghR;
    private BaseWebView.e ghS;
    private Context mContext;
    private Drawable mDrawable;
    private ProgressBar mProgressBar;

    public QuickWebView(Context context) {
        super(context);
        this.ghN = false;
        this.ghS = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.ghN) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.ghP = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.ghO) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.rV(i);
                        return;
                    }
                    QuickWebView.this.ghO = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.rW(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghN = false;
        this.ghS = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.ghN) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.ghP = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.ghO) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.rV(i);
                        return;
                    }
                    QuickWebView.this.ghO = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.rW(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.ghM = new b(this);
        this.mJsBridge.a(new a(context, this.ghM));
    }

    public void lI(boolean z) {
        if (z) {
            cd(this.mContext);
        }
    }

    private void cd(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(getProgressDrawable());
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.ghS);
    }

    private Drawable getProgressDrawable() {
        if (this.mDrawable == null) {
            this.mDrawable = getContext().getResources().getDrawable(d.f.quick_webview_progress);
        }
        return this.mDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rV(int i) {
        if (this.ghQ != null) {
            this.ghQ.cancel();
            this.ghQ = null;
        }
        this.ghQ = ObjectAnimator.ofInt(this.mProgressBar, NotificationCompat.CATEGORY_PROGRESS, this.ghP, i);
        this.ghQ.setDuration(100L);
        this.ghQ.setInterpolator(new DecelerateInterpolator());
        this.ghQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW(final int i) {
        if (this.ghR != null) {
            this.ghR.cancel();
            this.ghR = null;
        }
        this.ghR = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.ghR.setDuration(150L);
        this.ghR.setInterpolator(new DecelerateInterpolator());
        this.ghR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.ghR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.ghO = false;
            }
        });
        this.ghR.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L16;
     */
    @Override // android.webkit.WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        if (!StringUtils.isNull(str)) {
            if (!str.contains("javascript:")) {
                this.ghN = false;
                String str2 = str + (str.contains("?") ? "&" : "?") + "_webview_time=" + System.currentTimeMillis();
                if (an.KJ()) {
                    str = sF(str2);
                }
                str = str2;
            }
            super.loadUrl(str);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01d1 -> B:6:0x001d). Please submit an issue!!! */
    private String sF(String str) {
        URL url;
        String path;
        com.baidu.tieba.quickWebView.data.a sI;
        boolean z;
        String[] split;
        String str2 = null;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            path = url.getPath();
            sI = d.bnQ().sI(path);
        } catch (MalformedURLException e) {
        }
        if (sI != null && !sI.gin) {
            String ye = c.bnK().ye();
            String str3 = ye + path + ".html";
            File file = new File(str3);
            if (!str3.contains("/android_asset/") && !file.exists()) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", new Object[0]);
                return null;
            }
            String query = url.getQuery();
            String str4 = SkiaImageDecoder.FILE_PREFIX + ye + path + ".html";
            try {
                if (!TextUtils.isEmpty(query)) {
                    str4 = str4 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str4;
            }
            if (sI.gim != null && sI.gim.size() != 0) {
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
                Iterator<String> it = sI.gim.iterator();
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
                    if (this.ghM != null) {
                        this.ghM.a(quickWebViewBridgeData, null);
                    }
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
        if (this.ghM != null) {
            this.ghM.onDestory();
            this.ghM = null;
        }
        this.ghS = null;
        setOnProgressChangedListener(null);
        if (this.ghQ != null) {
            this.ghQ.cancel();
            this.ghQ = null;
        }
        if (this.ghR != null) {
            this.ghR.cancel();
            this.ghR = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.ghN = true;
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
