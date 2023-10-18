package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class uh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210953, "Lcom/baidu/tieba/uh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210953, "Lcom/baidu/tieba/uh3;");
                return;
            }
        }
        a = am1.a;
    }

    public static void a(@NonNull BdSailorWebView bdSailorWebView) {
        AbsoluteLayout webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bdSailorWebView) == null) {
            Drawable d = rj4.d(bdSailorWebView.getContext(), R.drawable.obfuscated_res_0x7f08142e);
            Drawable d2 = rj4.d(bdSailorWebView.getContext(), R.drawable.obfuscated_res_0x7f08142d);
            if (BdZeusUtil.isWebkitLoaded()) {
                webView = bdSailorWebView.getCurrentWebView();
            } else {
                webView = bdSailorWebView.getCurrentWebView().getWebView();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                webView.setVerticalScrollbarThumbDrawable(d);
                webView.setHorizontalScrollbarThumbDrawable(d2);
                return;
            }
            b(webView, d, d2);
        }
    }

    public static void b(@Nullable View view2, Drawable drawable, Drawable drawable2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, view2, drawable, drawable2) != null) || view2 == null) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view2);
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, drawable);
            Method declaredMethod2 = obj2.getClass().getDeclaredMethod("setHorizontalThumbDrawable", Drawable.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(obj2, drawable2);
        } catch (Throwable th) {
            if (a) {
                th.printStackTrace();
            }
        }
    }
}
