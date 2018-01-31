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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.o.ai;
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
    private b gzb;
    private boolean gzc;
    private boolean gzd;
    private int gze;
    private ObjectAnimator gzf;
    private ObjectAnimator gzg;
    private BaseWebView.e gzh;
    private Context mContext;
    private ProgressBar mProgressBar;
    private Drawable wz;

    public QuickWebView(Context context) {
        super(context);
        this.gzc = false;
        this.gzh = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.gzc) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.gze = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.gzd) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.uo(i);
                        return;
                    }
                    QuickWebView.this.gzd = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.up(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzc = false;
        this.gzh = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.gzc) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.gze = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.gzd) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.uo(i);
                        return;
                    }
                    QuickWebView.this.gzd = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.up(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.gzb = new b(this);
        this.mJsBridge.a(new a(context, this.gzb));
    }

    public void lO(boolean z) {
        if (z) {
            ca(this.mContext);
        }
    }

    private void ca(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(getProgressDrawable());
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.gzh);
    }

    private Drawable getProgressDrawable() {
        if (this.wz == null) {
            this.wz = getContext().getResources().getDrawable(d.f.quick_webview_progress);
        }
        return this.wz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(int i) {
        if (this.gzf != null) {
            this.gzf.cancel();
            this.gzf = null;
        }
        this.gzf = ObjectAnimator.ofInt(this.mProgressBar, NotificationCompat.CATEGORY_PROGRESS, this.gze, i);
        this.gzf.setDuration(100L);
        this.gzf.setInterpolator(new DecelerateInterpolator());
        this.gzf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(final int i) {
        if (this.gzg != null) {
            this.gzg.cancel();
            this.gzg = null;
        }
        this.gzg = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.gzg.setDuration(150L);
        this.gzg.setInterpolator(new DecelerateInterpolator());
        this.gzg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.gzg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.gzd = false;
            }
        });
        this.gzg.start();
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
            this.gzc = false;
            String str2 = str + (str.contains("?") ? "&" : "?") + "_webview_time=" + System.currentTimeMillis();
            if (ai.Oj()) {
                str = rx(str2);
            }
            str = str2;
        }
        super.loadUrl(str);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01cd -> B:6:0x001d). Please submit an issue!!! */
    private String rx(String str) {
        URL url;
        String path;
        com.baidu.tieba.quickWebView.data.a rA;
        boolean z;
        String[] split;
        String str2 = null;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            path = url.getPath();
            rA = d.bmA().rA(path);
        } catch (MalformedURLException e) {
        }
        if (rA != null && !rA.gzC) {
            String BC = c.bmt().BC();
            String str3 = BC + path + ".html";
            File file = new File(str3);
            if (!str3.contains("/android_asset/") && !file.exists()) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", new Object[0]);
                return null;
            }
            String query = url.getQuery();
            String str4 = SkiaImageDecoder.FILE_PREFIX + BC + path + ".html";
            try {
                if (!TextUtils.isEmpty(query)) {
                    str4 = str4 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str4;
            }
            if (rA.gzB != null && rA.gzB.size() != 0) {
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
                Iterator<String> it = rA.gzB.iterator();
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
                    this.gzb.a(quickWebViewBridgeData, null);
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
        this.gzb.onDestory();
        this.gzb = null;
        this.gzh = null;
        setOnProgressChangedListener(null);
        if (this.gzf != null) {
            this.gzf.cancel();
            this.gzf = null;
        }
        if (this.gzg != null) {
            this.gzg.cancel();
            this.gzg = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.gzc = true;
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
