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
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f6447a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f6448b;
    private static int c;
    private static int d;
    private static int e;
    private static Handler f;
    private static final HashSet<String> g;
    private static final HashSet<String> h;

    static {
        f6447a = Build.VERSION.SDK_INT >= 16 && ad.e();
        f6448b = a();
        c = -1;
        d = -1;
        e = -1;
        f = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        g = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        h = hashSet2;
    }

    public static void a(Context context, WebView webView) {
        if (context != null && webView != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                try {
                    webView.loadUrl("about:blank");
                    if (e > 0) {
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
                } catch (Exception e2) {
                }
            }
        }
    }

    private static boolean a() {
        return f6447a || (Build.VERSION.SDK_INT == 16 && "ZTE N5".equals(Build.MODEL));
    }

    public static void a(WebView webView) {
        if (webView != null) {
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            ViewParent parent = webView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.removeAllViews();
            try {
                webView.destroy();
            } catch (Throwable th) {
            }
        }
    }
}
