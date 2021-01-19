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
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes.dex */
public class QuickWebView extends BaseWebView {
    private static String TAG = QuickWebView.class.getSimpleName();
    private Context mContext;
    private Drawable mDrawable;
    private int mGA;
    private ObjectAnimator mGB;
    private ObjectAnimator mGC;
    private int mGD;
    private BaseWebView.e mGE;
    private boolean mGy;
    private boolean mGz;
    private ProgressBar mProgressBar;
    private a mProxy;

    public QuickWebView(Context context) {
        super(context);
        this.mGy = false;
        this.mGD = 0;
        this.mGE = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.mGy) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.mGA = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.mGz) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.Hp(i);
                        return;
                    }
                    QuickWebView.this.mGz = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.Hq(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGy = false;
        this.mGD = 0;
        this.mGE = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.mGy) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.mGA = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.mGz) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.Hp(i);
                        return;
                    }
                    QuickWebView.this.mGz = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.Hq(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.mProxy = new a(this);
        this.mJsBridge.a(new QuickWebViewBridge(context, this.mProxy));
    }

    public void xf(boolean z) {
        if (z) {
            gL(this.mContext);
        }
    }

    private void gL(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(getProgressDrawable());
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.mGE);
    }

    private Drawable getProgressDrawable() {
        if (this.mDrawable == null) {
            this.mDrawable = getContext().getResources().getDrawable(R.drawable.quick_webview_progress);
        }
        return this.mDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp(int i) {
        if (this.mGB != null) {
            this.mGB.cancel();
            this.mGB = null;
        }
        this.mGB = ObjectAnimator.ofInt(this.mProgressBar, "progress", this.mGA, i);
        this.mGB.setDuration(100L);
        this.mGB.setInterpolator(new DecelerateInterpolator());
        this.mGB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq(final int i) {
        if (this.mGC != null) {
            this.mGC.cancel();
            this.mGC = null;
        }
        this.mGC = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.mGC.setDuration(150L);
        this.mGC.setInterpolator(new DecelerateInterpolator());
        this.mGC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.mGC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.mGz = false;
            }
        });
        this.mGC.start();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        String str2;
        boolean z;
        String str3;
        if (!StringUtils.isNull(str)) {
            if (str.contains("javascript:")) {
                str2 = str;
            } else {
                this.mGy = false;
                str2 = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "_webview_time=" + System.currentTimeMillis();
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                if (QuickWebViewSwitch.getInOn()) {
                    String Qj = Qj(str2);
                    if (TextUtils.isEmpty(Qj)) {
                        z = false;
                        str3 = str2;
                    } else {
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", Qj);
                        z = true;
                        str3 = Qj;
                    }
                    str2 = str3;
                } else {
                    this.mGD = 5;
                    z = false;
                }
                String substring = str2.length() > 100 ? str2.substring(0, 100) : str2;
                TiebaStatic.log(new aq("c13835").dW("obj_locate", z ? "1" : "2").dW("obj_id", b.dAy().dAA()).dW("obj_source", substring).an("obj_type", this.mGD).an("obj_name", b.mGP));
                this.mGD = 0;
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            super.loadUrl(str2);
        }
    }

    private String Qj(String str) {
        String str2;
        URL url;
        String path;
        com.baidu.tieba.quickWebView.data.a Qm;
        boolean z;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            path = url.getPath();
            Qm = c.dAG().Qm(path);
        } catch (MalformedURLException e) {
            str2 = null;
        }
        if (Qm == null) {
            if (!c.dAG().dAI()) {
                this.mGD = 4;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "processing bundle", "url", str);
            } else if (c.dAG().dAH() != null) {
                this.mGD = 3;
            }
            return null;
        } else if (Qm.mHc) {
            return null;
        } else {
            String cacheDir = b.dAy().getCacheDir();
            String str3 = cacheDir + path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            File file = new File(str3);
            List<String> Qn = c.dAG().Qn(path);
            if (!str3.contains("/android_asset/")) {
                if (!file.exists()) {
                    this.mGD = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", new Object[0]);
                    return null;
                } else if (x.isEmpty(Qn)) {
                    return null;
                } else {
                    for (String str4 : Qn) {
                        if (StringUtils.isNull(str4)) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "static file path is null", new Object[0]);
                            this.mGD = 1;
                            return null;
                        } else if (!new File(cacheDir, str4).exists()) {
                            this.mGD = 1;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "bundle incomplete", "url", str4, "version", b.dAy().dAA());
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
            if (Qm.mHb != null && Qm.mHb.size() != 0) {
                if (!TextUtils.isEmpty(query) && (split = query.split(ETAG.ITEM_SEPARATOR)) != null) {
                    for (String str6 : split) {
                        String[] split2 = str6.split("=");
                        if (split2 != null && split2.length == 2) {
                            hashMap.put("{" + split2[0] + "}", split2[1]);
                        }
                    }
                }
                hashMap.put("{client_version}", TbConfig.getVersion());
                hashMap.put("{client_type}", "2");
                Iterator<String> it = Qm.mHb.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    StringBuilder sb = new StringBuilder();
                    String query2 = new URL(next).getQuery();
                    if (!TextUtils.isEmpty(query2)) {
                        String[] split3 = query2.split(ETAG.ITEM_SEPARATOR);
                        if (split3 != null) {
                            boolean z2 = true;
                            int length = split3.length;
                            int i = 0;
                            while (i < length) {
                                String str7 = split3[i];
                                if (!z2) {
                                    sb.append(ETAG.ITEM_SEPARATOR);
                                    z = z2;
                                } else {
                                    z = false;
                                }
                                String[] split4 = str7.split("=");
                                if (split4 != null && split4.length == 2) {
                                    String str8 = (String) hashMap.get(split4[1]);
                                    if (str8 == null) {
                                        str8 = split4[1];
                                        if (str8.contains("{") && str8.contains("}")) {
                                            str8 = null;
                                        }
                                    }
                                    sb.append(split4[0]);
                                    sb.append("=");
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
                    if (this.mProxy != null) {
                        this.mProxy.a(quickWebViewBridgeData, null);
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
        if (this.mProxy != null) {
            this.mProxy.onDestory();
            this.mProxy = null;
        }
        this.mGE = null;
        setOnProgressChangedListener(null);
        if (this.mGB != null) {
            this.mGB.cancel();
            this.mGB = null;
        }
        if (this.mGC != null) {
            this.mGC.cancel();
            this.mGC = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.mGy = true;
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
