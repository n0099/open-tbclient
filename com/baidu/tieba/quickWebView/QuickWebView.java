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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class QuickWebView extends BaseWebView {
    private static String TAG = QuickWebView.class.getSimpleName();
    private Context mContext;
    private Drawable mDrawable;
    private String mModuleName;
    private int mOfflineErrorType;
    private ProgressBar mProgressBar;
    private a mProxy;
    QuickWebViewBridge mRV;
    private boolean mRW;
    private boolean mRX;
    private int mRY;
    private ObjectAnimator mRZ;
    private ObjectAnimator mSa;
    private BaseWebView.e mSb;
    private String mVersion;

    public QuickWebView(Context context) {
        super(context);
        this.mRV = null;
        this.mRW = false;
        this.mOfflineErrorType = 0;
        this.mModuleName = "";
        this.mVersion = "0.0.0.0";
        this.mSb = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.mRW) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.mRY = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.mRX) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.HK(i);
                        return;
                    }
                    QuickWebView.this.mRX = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.HL(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRV = null;
        this.mRW = false;
        this.mOfflineErrorType = 0;
        this.mModuleName = "";
        this.mVersion = "0.0.0.0";
        this.mSb = new BaseWebView.e() { // from class: com.baidu.tieba.quickWebView.QuickWebView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
            public void onProgressChanged(WebView webView, int i) {
                if (QuickWebView.this.mProgressBar != null) {
                    if (QuickWebView.this.mRW) {
                        QuickWebView.this.mProgressBar.setVisibility(8);
                        return;
                    }
                    QuickWebView.this.mRY = QuickWebView.this.mProgressBar.getProgress();
                    if (i < 100 || QuickWebView.this.mRX) {
                        QuickWebView.this.mProgressBar.setVisibility(0);
                        QuickWebView.this.HK(i);
                        return;
                    }
                    QuickWebView.this.mRX = true;
                    QuickWebView.this.mProgressBar.setProgress(i);
                    QuickWebView.this.HL(QuickWebView.this.mProgressBar.getProgress());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initCommonJsBridge(context);
        this.mProxy = new a(this);
        this.mRV = new QuickWebViewBridge(context, this.mProxy);
        this.mJsBridge.a(this.mRV);
    }

    public void xx(boolean z) {
        if (z) {
            gN(this.mContext);
        }
    }

    private void gN(Context context) {
        this.mProgressBar = new ProgressBar(context, null, 16842872);
        this.mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds5), 0, 0));
        this.mProgressBar.setProgressDrawable(getProgressDrawable());
        addView(this.mProgressBar);
        setOnProgressChangedListener(this.mSb);
    }

    private Drawable getProgressDrawable() {
        if (this.mDrawable == null) {
            this.mDrawable = getContext().getResources().getDrawable(R.drawable.quick_webview_progress);
        }
        return this.mDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK(int i) {
        if (this.mRZ != null) {
            this.mRZ.cancel();
            this.mRZ = null;
        }
        this.mRZ = ObjectAnimator.ofInt(this.mProgressBar, "progress", this.mRY, i);
        this.mRZ.setDuration(100L);
        this.mRZ.setInterpolator(new DecelerateInterpolator());
        this.mRZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL(final int i) {
        if (this.mSa != null) {
            this.mSa.cancel();
            this.mSa = null;
        }
        this.mSa = ObjectAnimator.ofFloat(this.mProgressBar, "alpha", 1.0f, 0.0f);
        this.mSa.setDuration(150L);
        this.mSa.setInterpolator(new DecelerateInterpolator());
        this.mSa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.quickWebView.QuickWebView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QuickWebView.this.mProgressBar.setProgress((int) ((valueAnimator.getAnimatedFraction() * (100 - i)) + i));
            }
        });
        this.mSa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.quickWebView.QuickWebView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickWebView.this.mProgressBar.setProgress(0);
                QuickWebView.this.mProgressBar.setVisibility(8);
                QuickWebView.this.mProgressBar.setAlpha(1.0f);
                QuickWebView.this.mRX = false;
            }
        });
        this.mSa.start();
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
                this.mRW = false;
                str2 = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "_webview_time=" + System.currentTimeMillis();
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                if (QuickWebViewSwitch.getInOn()) {
                    String localUrlByUrl = getLocalUrlByUrl(str2);
                    if (TextUtils.isEmpty(localUrlByUrl)) {
                        z = false;
                        str3 = str2;
                    } else {
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", localUrlByUrl, BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                        z = true;
                        str3 = localUrlByUrl;
                    }
                    str2 = str3;
                } else {
                    this.mOfflineErrorType = 5;
                    z = false;
                }
                String substring = str2.length() > 100 ? str2.substring(0, 100) : str2;
                TiebaStatic.log(new ar("c13835").dR("obj_locate", z ? "1" : "2").dR("obj_source", substring).aq("obj_type", this.mOfflineErrorType).aq("obj_name", b.mSl).dR("obj_param1", this.mModuleName).dR("obj_id", this.mVersion));
                this.mOfflineErrorType = 0;
                this.mVersion = "0.0.0.0";
                this.mModuleName = "";
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            if (this.mRV != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mRV.setLastLoadUrlTime(currentTimeMillis);
                this.mCommonJsBridge.setLastLoadUrlTime(currentTimeMillis);
            }
            super.loadUrl(str2);
        }
    }

    private String getLocalUrlByUrl(String str) {
        String str2;
        URL url;
        com.baidu.tieba.quickWebView.data.a Rn;
        boolean z;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            Rn = c.dDb().Rn(url.getPath());
        } catch (MalformedURLException e) {
            str2 = null;
        }
        if (Rn == null) {
            if (c.dDb().dDc() != null) {
                this.mOfflineErrorType = 3;
            }
            return null;
        } else if (!Rn.mSz) {
            this.mOfflineErrorType = 4;
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "processing bundle", "url", str, BdStatsConstant.StatsKey.TYPE, Rn.kwi);
            return null;
        } else {
            String Rl = b.dCX().Rl(Rn.kwi);
            if (TextUtils.isEmpty(Rn.kwi) || TextUtils.isEmpty(Rn.path) || TextUtils.isEmpty(Rl)) {
                return null;
            }
            this.mModuleName = Rn.kwi;
            this.mVersion = Rl;
            String str3 = b.dCX().getCacheDir() + "/" + Rn.kwi + "/" + Rl + "/";
            String str4 = !Rn.path.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION) ? Rn.path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION : Rn.path;
            String str5 = str3 + str4;
            File file = new File(str5);
            ArrayList<String> arrayList = Rn.mSC;
            if (!str5.contains("/android_asset/")) {
                if (!file.exists()) {
                    this.mOfflineErrorType = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                    return null;
                } else if (y.isEmpty(arrayList)) {
                    return null;
                } else {
                    for (String str6 : arrayList) {
                        if (StringUtils.isNull(str6)) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "static file path is null", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                            this.mOfflineErrorType = 1;
                            return null;
                        } else if (!new File(str3, str6).exists()) {
                            this.mOfflineErrorType = 1;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "bundle incomplete", "url", str6, BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                            return null;
                        }
                    }
                }
            }
            String query = url.getQuery();
            String str7 = "file://" + str3 + str4;
            try {
                if (!TextUtils.isEmpty(query)) {
                    str7 = str7 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str7;
            }
            if (Rn.mSB != null && Rn.mSB.size() != 0) {
                if (!TextUtils.isEmpty(query) && (split = query.split(ETAG.ITEM_SEPARATOR)) != null) {
                    for (String str8 : split) {
                        String[] split2 = str8.split("=");
                        if (split2 != null && split2.length == 2) {
                            hashMap.put("{" + split2[0] + "}", split2[1]);
                        }
                    }
                }
                hashMap.put("{client_version}", TbConfig.getVersion());
                hashMap.put("{client_type}", "2");
                Iterator<String> it = Rn.mSB.iterator();
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
                                String str9 = split3[i];
                                if (!z2) {
                                    sb.append(ETAG.ITEM_SEPARATOR);
                                    z = z2;
                                } else {
                                    z = false;
                                }
                                String[] split4 = str9.split("=");
                                if (split4 != null && split4.length == 2) {
                                    String str10 = (String) hashMap.get(split4[1]);
                                    if (str10 == null) {
                                        str10 = split4[1];
                                        if (str10.contains("{") && str10.contains("}")) {
                                            str10 = null;
                                        }
                                    }
                                    sb.append(split4[0]);
                                    sb.append("=");
                                    if (!TextUtils.isEmpty(str10)) {
                                        sb.append(str10);
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
                    quickWebViewBridgeData.module = Rn.kwi;
                    quickWebViewBridgeData.begin = System.currentTimeMillis();
                    if (this.mProxy != null) {
                        this.mProxy.a(quickWebViewBridgeData, null);
                    }
                }
                str2 = str7;
                return str2;
            }
            return str7;
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        super.destroy();
        if (this.mProxy != null) {
            this.mProxy.onDestory();
            this.mProxy = null;
        }
        this.mSb = null;
        setOnProgressChangedListener(null);
        if (this.mRZ != null) {
            this.mRZ.cancel();
            this.mRZ = null;
        }
        if (this.mSa != null) {
            this.mSa.cancel();
            this.mSa = null;
        }
        this.mProgressBar = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.mRW = true;
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
