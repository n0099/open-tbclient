package com.baidu.tieba.quickWebView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class QuickWebView extends BaseWebView {
    public static String s = QuickWebView.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q2.a f20368e;

    /* renamed from: f  reason: collision with root package name */
    public QuickWebViewBridge f20369f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f20370g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20371h;
    public boolean i;
    public int j;
    public ObjectAnimator k;
    public ObjectAnimator l;
    public Context m;
    public Drawable n;
    public int o;
    public String p;
    public String q;
    public BaseWebView.g r;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.g {
        public a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
        public void a(WebView webView, int i) {
            if (QuickWebView.this.f20370g == null) {
                return;
            }
            if (QuickWebView.this.f20371h) {
                QuickWebView.this.f20370g.setVisibility(8);
                return;
            }
            QuickWebView quickWebView = QuickWebView.this;
            quickWebView.j = quickWebView.f20370g.getProgress();
            if (i < 100 || QuickWebView.this.i) {
                QuickWebView.this.f20370g.setVisibility(0);
                QuickWebView.this.n(i);
                return;
            }
            QuickWebView.this.i = true;
            QuickWebView.this.f20370g.setProgress(i);
            QuickWebView quickWebView2 = QuickWebView.this;
            quickWebView2.m(quickWebView2.f20370g.getProgress());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20373e;

        public b(int i) {
            this.f20373e = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QuickWebView.this.f20370g.setProgress((int) (this.f20373e + ((100 - this.f20373e) * valueAnimator.getAnimatedFraction())));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QuickWebView.this.f20370g.setProgress(0);
            QuickWebView.this.f20370g.setVisibility(8);
            QuickWebView.this.f20370g.setAlpha(1.0f);
            QuickWebView.this.i = false;
        }
    }

    public QuickWebView(Context context) {
        super(context);
        this.f20369f = null;
        this.f20371h = false;
        this.o = 0;
        this.p = "";
        this.q = "0.0.0.0";
        this.r = new a();
        k(context);
    }

    private Drawable getProgressDrawable() {
        if (this.n == null) {
            this.n = getContext().getResources().getDrawable(R.drawable.quick_webview_progress);
        }
        return this.n;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        super.destroy();
        d.b.i0.q2.a aVar = this.f20368e;
        if (aVar != null) {
            aVar.e();
            this.f20368e = null;
        }
        this.r = null;
        setOnProgressChangedListener(null);
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.k = null;
        }
        ObjectAnimator objectAnimator2 = this.l;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.l = null;
        }
        this.f20370g = null;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.f20371h = true;
        super.goBack();
    }

    public void h(d.b.i0.d3.l0.b bVar) {
        this.mJsBridge.a(bVar);
    }

    public final void i(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        this.f20370g = progressBar;
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds5), 0, 0));
        this.f20370g.setProgressDrawable(getProgressDrawable());
        addView(this.f20370g);
        setOnProgressChangedListener(this.r);
    }

    public final String j(String str) {
        Iterator<String> it;
        String str2;
        Iterator<String> it2;
        String str3;
        String[] split;
        HashMap hashMap = new HashMap();
        String str4 = null;
        try {
            URL url = new URL(str);
            d.b.i0.q2.d.a c2 = d.b.i0.q2.c.a().c(url.getPath());
            try {
                if (c2 == null) {
                    if (d.b.i0.q2.c.a().b() != null) {
                        this.o = 3;
                    }
                    return null;
                }
                int i = 2;
                int i2 = 0;
                if (!c2.f60534e) {
                    this.o = 4;
                    d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "processing bundle", "url", str, "module", c2.f60531b);
                    return null;
                }
                String q = d.b.i0.q2.b.o().q(c2.f60531b);
                if (!TextUtils.isEmpty(c2.f60531b)) {
                    try {
                        if (!TextUtils.isEmpty(c2.f60532c) && !TextUtils.isEmpty(q)) {
                            this.p = c2.f60531b;
                            this.q = q;
                            String str5 = d.b.i0.q2.b.o().n() + "/" + c2.f60531b + "/" + q + "/";
                            String str6 = c2.f60532c;
                            if (!c2.f60532c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                str6 = c2.f60532c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                            }
                            String str7 = str5 + str6;
                            File file = new File(str7);
                            ArrayList<String> arrayList = c2.f60533d;
                            if (!str7.contains("/android_asset/")) {
                                if (!file.exists()) {
                                    this.o = 2;
                                    d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", "module", this.p);
                                    return null;
                                } else if (ListUtils.isEmpty(arrayList)) {
                                    return null;
                                } else {
                                    for (String str8 : arrayList) {
                                        if (StringUtils.isNull(str8)) {
                                            d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "static file path is null", "module", this.p);
                                            this.o = 1;
                                            return null;
                                        } else if (!new File(str5, str8).exists()) {
                                            this.o = 1;
                                            d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "bundle incomplete", "url", str8, "module", this.p);
                                            return null;
                                        }
                                    }
                                }
                            }
                            String query = url.getQuery();
                            String str9 = "file://" + str5 + str6;
                            try {
                                if (!TextUtils.isEmpty(query)) {
                                    str9 = str9 + "?" + query;
                                }
                                if (c2.f60530a != null && c2.f60530a.size() != 0) {
                                    String str10 = "&";
                                    if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                        int length = split.length;
                                        int i3 = 0;
                                        while (i3 < length) {
                                            String[] split2 = split[i3].split("=");
                                            if (split2 != null && split2.length == i) {
                                                hashMap.put(StringUtil.ARRAY_START + split2[0] + "}", split2[1]);
                                            }
                                            i3++;
                                            i = 2;
                                        }
                                    }
                                    hashMap.put("{client_version}", TbConfig.getVersion());
                                    hashMap.put("{client_type}", "2");
                                    Iterator<String> it3 = c2.f60530a.iterator();
                                    while (it3.hasNext()) {
                                        String next = it3.next();
                                        StringBuilder sb = new StringBuilder();
                                        String query2 = new URL(next).getQuery();
                                        if (TextUtils.isEmpty(query2)) {
                                            it = it3;
                                            str2 = str10;
                                        } else {
                                            String[] split3 = query2.split(str10);
                                            if (split3 != null) {
                                                int length2 = split3.length;
                                                boolean z = true;
                                                while (i2 < length2) {
                                                    String str11 = split3[i2];
                                                    if (z) {
                                                        z = false;
                                                    } else {
                                                        sb.append(str10);
                                                    }
                                                    String[] split4 = str11.split("=");
                                                    if (split4 != null) {
                                                        it2 = it3;
                                                        str3 = str10;
                                                        if (split4.length == 2) {
                                                            String str12 = (String) hashMap.get(split4[1]);
                                                            if (str12 == null) {
                                                                str12 = split4[1];
                                                                if (str12.contains(StringUtil.ARRAY_START) && str12.contains("}")) {
                                                                    str12 = null;
                                                                }
                                                            }
                                                            sb.append(split4[0]);
                                                            sb.append("=");
                                                            if (!TextUtils.isEmpty(str12)) {
                                                                sb.append(str12);
                                                            }
                                                            i2++;
                                                            it3 = it2;
                                                            str10 = str3;
                                                        }
                                                    } else {
                                                        it2 = it3;
                                                        str3 = str10;
                                                    }
                                                    i2++;
                                                    it3 = it2;
                                                    str10 = str3;
                                                }
                                            }
                                            it = it3;
                                            str2 = str10;
                                            String sb2 = sb.toString();
                                            if (!TextUtils.isEmpty(sb2)) {
                                                next = next.replace(query2, sb2);
                                            }
                                        }
                                        QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                                        quickWebViewBridgeData.type = "get";
                                        quickWebViewBridgeData.url = next;
                                        quickWebViewBridgeData.module = c2.f60531b;
                                        quickWebViewBridgeData.begin = System.currentTimeMillis();
                                        if (this.f20368e != null) {
                                            this.f20368e.f(quickWebViewBridgeData, null);
                                        }
                                        it3 = it;
                                        str10 = str2;
                                        i2 = 0;
                                    }
                                    return str9;
                                }
                                return str9;
                            } catch (MalformedURLException unused) {
                                str4 = str9;
                                return str4;
                            }
                        }
                    } catch (MalformedURLException unused2) {
                        str4 = null;
                    }
                }
                return null;
            } catch (MalformedURLException unused3) {
            }
        } catch (MalformedURLException unused4) {
        }
    }

    public final void k(Context context) {
        this.m = context;
        initCommonJsBridge(context);
        this.f20368e = new d.b.i0.q2.a(this);
        QuickWebViewBridge quickWebViewBridge = new QuickWebViewBridge(context, this.f20368e);
        this.f20369f = quickWebViewBridge;
        this.mJsBridge.a(quickWebViewBridge);
    }

    public void l(boolean z) {
        if (z) {
            i(this.m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0155  */
    @Override // android.webkit.WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        String str2 = str;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
            HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().f50663a;
            String str3 = null;
            for (String str4 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str4) && str2.contains(str4)) {
                    str3 = str4;
                }
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(hashMap.get(str3))) {
                String str5 = hashMap.get(str3);
                Uri parse = Uri.parse(str);
                String str6 = (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost())) ? "" : parse.getScheme() + "://" + parse.getHost();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    str2 = str2.replace(str6, str5);
                }
            }
        }
        if (!str2.contains("javascript:")) {
            this.f20371h = false;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str2.contains("?") ? "&" : "?");
            sb.append("_webview_time=");
            sb.append(System.currentTimeMillis());
            str2 = sb.toString();
            d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", IntentConfig.START, "url", str2);
            if (QuickWebViewSwitch.getInOn()) {
                String j = j(str2);
                if (!TextUtils.isEmpty(j)) {
                    d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", ProgressInfo.JSON_KEY_END, "url", j, "module", this.p);
                    str2 = j;
                    z = true;
                    String substring = str2.length() <= 100 ? str2.substring(0, 100) : str2;
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.o).param("obj_name", d.b.i0.q2.b.f60504h).param("obj_param1", this.p).param("obj_id", this.q));
                    this.o = 0;
                    this.q = "0.0.0.0";
                    this.p = "";
                    d.b.h0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                }
            } else {
                this.o = 5;
            }
            z = false;
            if (str2.length() <= 100) {
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.o).param("obj_name", d.b.i0.q2.b.f60504h).param("obj_param1", this.p).param("obj_id", this.q));
            this.o = 0;
            this.q = "0.0.0.0";
            this.p = "";
            d.b.h0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
        }
        if (this.f20369f != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f20369f.setLastLoadUrlTime(currentTimeMillis);
            this.mCommonJsBridge.setLastLoadUrlTime(currentTimeMillis);
        }
        super.loadUrl(str2);
    }

    public final void m(int i) {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.l = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20370g, "alpha", 1.0f, 0.0f);
        this.l = ofFloat;
        ofFloat.setDuration(150L);
        this.l.setInterpolator(new DecelerateInterpolator());
        this.l.addUpdateListener(new b(i));
        this.l.addListener(new c());
        this.l.start();
    }

    public final void n(int i) {
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.k = null;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f20370g, "progress", this.j, i);
        this.k = ofInt;
        ofInt.setDuration(100L);
        this.k.setInterpolator(new DecelerateInterpolator());
        this.k.start();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView
    public void setOnJsPromptCallback(d.b.i0.d3.l0.c cVar) {
        Log.e(s, "QuickWebView do not support setOnJsPromptCallback");
    }

    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20369f = null;
        this.f20371h = false;
        this.o = 0;
        this.p = "";
        this.q = "0.0.0.0";
        this.r = new a();
        k(context);
    }
}
