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
    public static Display f56656a;

    /* renamed from: b  reason: collision with root package name */
    public static int f56657b;

    /* renamed from: c  reason: collision with root package name */
    public static int f56658c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f56657b == 0) {
                if (f56656a == null) {
                    f56656a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                if (j.a() < 13) {
                    point.set(f56656a.getWidth(), f56656a.getHeight());
                } else {
                    f56656a.getSize(point);
                }
                f56657b = point.x;
                f56658c = point.y;
            }
            int[] iArr = {f56657b, f56658c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }
}
