package com.baidu.tieba.quickWebView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class QuickWebView extends BaseWebView {
    private static String TAG = QuickWebView.class.getSimpleName();
    private b lAA;
    private boolean lAB;
    private boolean lAC;
    private int lAD;
    private ObjectAnimator lAE;
    private ObjectAnimator lAF;
    private BaseWebView.e lAG;
    private Context mContext;
    private Drawable mDrawable;
    private ProgressBar mProgressBar;

    public QuickWebView(Context context) {
        super(context);
        this.lAB = false;
        this.lAG = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.lAB) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.lAD = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.lAC) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.Ga(i);
                        return;
                    }
                    QuickWebView.this.lAC = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.Gb(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lAB = false;
        this.lAG = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.lAB) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.lAD = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.lAC) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.Ga(i);
                        return;
                    }
                    QuickWebView.this.lAC = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.Gb(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.lAA = new b(this);
        this.mJsBridge.a(new a(context, this.lAA));
    }

    public void vk(boolean z) {
        if (z) {
            fy(this.mContext);
        }
    }

    private void fy(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(getProgressDrawable());
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.lAG);
    }

    private Drawable getProgressDrawable() {
        if (this.mDrawable == null) {
            this.mDrawable = getContext().getResources().getDrawable(R.drawable.quick_webview_progress);
        }
        return this.mDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(int i) {
        if (this.lAE != null) {
            this.lAE.cancel();
            this.lAE = null;
        }
        this.lAE = ObjectAnimator.ofInt(this.mProgressBar, "progress", this.lAD, i);
        this.lAE.setDuration(100L);
        this.lAE.setInterpolator(new DecelerateInterpolator());
        this.lAE.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb(final int i) {
        if (this.lAF != null) {
            this.lAF.cancel();
            this.lAF = null;
        }
        this.lAF = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.lAF.setDuration(150L);
        this.lAF.setInterpolator(new DecelerateInterpolator());
        this.lAF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.lAF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.lAC = false;
            }
        });
        this.lAF.start();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        boolean z;
        if (!StringUtils.isNull(str)) {
            if (str.contains("javascript:")) {
                z = false;
            } else {
                this.lAB = false;
                String str2 = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "_webview_time=" + System.currentTimeMillis();
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                if (QuickWebViewSwitch.getInOn()) {
                    str = Pb(str2);
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", str);
                        z = true;
                    }
                }
                str = str2;
                z = false;
            }
            TiebaStatic.log(new aq("c13835").dD("obj_locate", z ? "1" : "2").dD("obj_id", c.dmE().dmF()).dD("obj_source", str));
            com.baidu.tbadk.core.d.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", str, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            super.loadUrl(str);
        }
    }

    private String Pb(String str) {
        String str2;
        URL url;
        String path;
        com.baidu.tieba.quickWebView.data.a Pf;
        boolean z;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            path = url.getPath();
            Pf = d.dmK().Pf(path);
        } catch (MalformedURLException e) {
            str2 = null;
        }
        if (Pf == null) {
            if (!d.dmK().dmL()) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "processing bundle", "url", str);
            }
            return null;
        } else if (Pf.lBc) {
            return null;
        } else {
            String cacheDir = c.dmE().getCacheDir();
            String str3 = cacheDir + path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            File file = new File(str3);
            List<String> Pg = d.dmK().Pg(path);
            if (!str3.contains("/android_asset/")) {
                if (!file.exists()) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", new Object[0]);
                    return null;
                } else if (y.isEmpty(Pg)) {
                    return null;
                } else {
                    for (String str4 : Pg) {
                        if (StringUtils.isNull(str4)) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "static file path is null", new Object[0]);
                            return null;
                        } else if (!new File(cacheDir, str4).exists()) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "bundle incomplete", "url", str4, "version", c.dmE().dmF());
                            return null;
                        }
                    }
                }
            }
            String query = url.getQuery();
            String str5 = "file://" + cacheDir + path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            try {
                if (!TextUtils.isEmpty(query)) {
                    str5 = str5 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str5;
            }
            if (Pf.lBb != null && Pf.lBb.size() != 0) {
                if (!TextUtils.isEmpty(query) && (split = query.split(ETAG.ITEM_SEPARATOR)) != null) {
                    for (String str6 : split) {
                        String[] split2 = str6.split(ETAG.EQUAL);
                        if (split2 != null && split2.length == 2) {
                            hashMap.put("{" + split2[0] + "}", split2[1]);
                        }
                    }
                }
                hashMap.put("{client_version}", TbConfig.getVersion());
                hashMap.put("{client_type}", "2");
                Iterator<String> it = Pf.lBb.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    StringBuilder sb = new StringBuilder();
                    String query2 = new URL(next).getQuery();
                    if (!TextUtils.isEmpty(query2)) {
                        String[] split3 = query2.split(ETAG.ITEM_SEPARATOR);
                        if (split3 != null) {
                            int length = split3.length;
                            int i = 0;
                            boolean z2 = true;
                            while (i < length) {
                                String str7 = split3[i];
                                if (!z2) {
                                    sb.append(ETAG.ITEM_SEPARATOR);
                                    z = z2;
                                } else {
                                    z = false;
                                }
                                String[] split4 = str7.split(ETAG.EQUAL);
                                if (split4 != null && split4.length == 2) {
                                    String str8 = (String) hashMap.get(split4[1]);
                                    if (str8 == null) {
                                        str8 = split4[1];
                                        if (str8.contains("{") && str8.contains("}")) {
                                            str8 = null;
                                        }
                                    }
                                    sb.append(split4[0]);
                                    sb.append(ETAG.EQUAL);
                                    if (!TextUtils.isEmpty(str8)) {
                                        sb.append(str8);
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
                    if (this.lAA != null) {
                        this.lAA.a(quickWebViewBridgeData, null);
                    }
                }
                str2 = str5;
                return str2;
            }
            return str5;
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        super.destroy();
        if (this.lAA != null) {
            this.lAA.onDestory();
            this.lAA = null;
        }
        this.lAG = null;
        setOnProgressChangedListener(null);
        if (this.lAE != null) {
            this.lAE.cancel();
            this.lAE = null;
        }
        if (this.lAF != null) {
            this.lAF.cancel();
            this.lAF = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.lAB = true;
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
