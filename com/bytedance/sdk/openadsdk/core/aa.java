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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29722a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f29723b;

    /* renamed from: c  reason: collision with root package name */
    public static int f29724c;

    /* renamed from: d  reason: collision with root package name */
    public static int f29725d;

    /* renamed from: e  reason: collision with root package name */
    public static int f29726e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f29727f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashSet<String> f29728g;

    /* renamed from: h  reason: collision with root package name */
    public static final HashSet<String> f29729h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2069563328, "Lcom/bytedance/sdk/openadsdk/core/aa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2069563328, "Lcom/bytedance/sdk/openadsdk/core/aa;");
                return;
            }
        }
        f29722a = Build.VERSION.SDK_INT >= 16 && com.bytedance.sdk.openadsdk.r.j.e();
        f29723b = a();
        f29724c = -1;
        f29725d = -1;
        f29726e = -1;
        f29727f = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        f29728g = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        f29729h = hashSet2;
    }

    public static void a(Context context, WebView webView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, webView) == null) || context == null || webView == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                webView.loadUrl("about:blank");
                if (f29726e > 0) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f29722a || (Build.VERSION.SDK_INT == 16 && "ZTE N5".equals(Build.MODEL)) : invokeV.booleanValue;
    }

    public static void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, webView) == null) || webView == null) {
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
