package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.f.j;
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Display f56655a;

    /* renamed from: b  reason: collision with root package name */
    public static int f56656b;

    /* renamed from: c  reason: collision with root package name */
    public static int f56657c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f56656b == 0) {
                if (f56655a == null) {
                    f56655a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                if (j.a() < 13) {
                    point.set(f56655a.getWidth(), f56655a.getHeight());
                } else {
                    f56655a.getSize(point);
                }
                f56656b = point.x;
                f56657c = point.y;
            }
            int[] iArr = {f56656b, f56657c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }
}
