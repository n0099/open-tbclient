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
/* loaded from: classes.dex */
public class QuickWebView extends BaseWebView {
    private static String TAG = QuickWebView.class.getSimpleName();
    private int cPt;
    private b kHO;
    private boolean kHP;
    private boolean kHQ;
    private ObjectAnimator kHR;
    private ObjectAnimator kHS;
    private BaseWebView.e kHT;
    private Context mContext;
    private Drawable mDrawable;
    private ProgressBar mProgressBar;

    public QuickWebView(Context context) {
        super(context);
        this.kHP = false;
        this.kHT = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.kHP) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.cPt = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.kHQ) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.Cf(i);
                        return;
                    }
                    QuickWebView.this.kHQ = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.Cg(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kHP = false;
        this.kHT = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.kHP) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.cPt = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.kHQ) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.Cf(i);
                        return;
                    }
                    QuickWebView.this.kHQ = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.Cg(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.kHO = new b(this);
        this.mJsBridge.a(new a(context, this.kHO));
    }

    public void tF(boolean z) {
        if (z) {
            fh(this.mContext);
        }
    }

    private void fh(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(getProgressDrawable());
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.kHT);
    }

    private Drawable getProgressDrawable() {
        if (this.mDrawable == null) {
            this.mDrawable = getContext().getResources().getDrawable(R.drawable.quick_webview_progress);
        }
        return this.mDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf(int i) {
        if (this.kHR != null) {
            this.kHR.cancel();
            this.kHR = null;
        }
        this.kHR = ObjectAnimator.ofInt(this.mProgressBar, "progress", this.cPt, i);
        this.kHR.setDuration(100L);
        this.kHR.setInterpolator(new DecelerateInterpolator());
        this.kHR.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cg(final int i) {
        if (this.kHS != null) {
            this.kHS.cancel();
            this.kHS = null;
        }
        this.kHS = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.kHS.setDuration(150L);
        this.kHS.setInterpolator(new DecelerateInterpolator());
        this.kHS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.kHS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.kHQ = false;
            }
        });
        this.kHS.start();
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
                this.kHP = false;
                String str2 = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "_webview_time=" + System.currentTimeMillis();
                if (QuickWebViewSwitch.getInOn()) {
                    str = KY(str2);
                }
                str = str2;
            }
            super.loadUrl(str);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01d1 -> B:6:0x001d). Please submit an issue!!! */
    private String KY(String str) {
        URL url;
        String path;
        com.baidu.tieba.quickWebView.data.a La;
        boolean z;
        String[] split;
        String str2 = null;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            path = url.getPath();
            La = d.cTR().La(path);
        } catch (MalformedURLException e) {
        }
        if (La != null && !La.kIl) {
            String cacheDir = c.cTM().getCacheDir();
            String str3 = cacheDir + path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            File file = new File(str3);
            if (!str3.contains("/android_asset/") && !file.exists()) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", new Object[0]);
                return null;
            }
            String query = url.getQuery();
            String str4 = "file://" + cacheDir + path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            try {
                if (!TextUtils.isEmpty(query)) {
                    str4 = str4 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str4;
            }
            if (La.kIk != null && La.kIk.size() != 0) {
                if (!TextUtils.isEmpty(query) && (split = query.split(ETAG.ITEM_SEPARATOR)) != null) {
                    for (String str5 : split) {
                        String[] split2 = str5.split(ETAG.EQUAL);
                        if (split2 != null && split2.length == 2) {
                            hashMap.put("{" + split2[0] + "}", split2[1]);
                        }
                    }
                }
                hashMap.put("{client_version}", TbConfig.getVersion());
                hashMap.put("{client_type}", "2");
                Iterator<String> it = La.kIk.iterator();
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
                                String str6 = split3[i];
                                if (!z2) {
                                    sb.append(ETAG.ITEM_SEPARATOR);
                                    z = z2;
                                } else {
                                    z = false;
                                }
                                String[] split4 = str6.split(ETAG.EQUAL);
                                if (split4 != null && split4.length == 2) {
                                    String str7 = (String) hashMap.get(split4[1]);
                                    if (str7 == null) {
                                        str7 = split4[1];
                                        if (str7.contains("{") && str7.contains("}")) {
                                            str7 = null;
                                        }
                                    }
                                    sb.append(split4[0]);
                                    sb.append(ETAG.EQUAL);
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
                    if (this.kHO != null) {
                        this.kHO.a(quickWebViewBridgeData, null);
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
        if (this.kHO != null) {
            this.kHO.onDestory();
            this.kHO = null;
        }
        this.kHT = null;
        setOnProgressChangedListener(null);
        if (this.kHR != null) {
            this.kHR.cancel();
            this.kHR = null;
        }
        if (this.kHS != null) {
            this.kHS.cancel();
            this.kHS = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.kHP = true;
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
