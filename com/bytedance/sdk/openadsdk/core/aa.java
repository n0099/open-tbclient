package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.utils.ae;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f27843a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f27844b;

    /* renamed from: c  reason: collision with root package name */
    public static int f27845c;

    /* renamed from: d  reason: collision with root package name */
    public static int f27846d;

    /* renamed from: e  reason: collision with root package name */
    public static int f27847e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f27848f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashSet<String> f27849g;

    /* renamed from: h  reason: collision with root package name */
    public static final HashSet<String> f27850h;

    static {
        f27843a = Build.VERSION.SDK_INT >= 16 && ae.e();
        f27844b = a();
        f27845c = -1;
        f27846d = -1;
        f27847e = -1;
        f27848f = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        f27849g = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        f27850h = hashSet2;
    }

    public static void a(Context context, WebView webView) {
        if (context == null || webView == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                webView.loadUrl("about:blank");
                if (f27847e > 0) {
                    View rootView = webView.getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(createBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a() {
        return f27843a || (Build.VERSION.SDK_INT == 16 && "ZTE N5".equals(Build.MODEL));
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.setWebChromeClient(null);
        webView.setWebViewClient(null);
        ViewParent parent = webView.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(webView);
        }
        webView.removeAllViews();
        try {
            webView.destroy();
        } catch (Throwable unused) {
        }
    }
}
