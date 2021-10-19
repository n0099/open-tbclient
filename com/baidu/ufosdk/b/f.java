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
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Display f59730a;

    /* renamed from: b  reason: collision with root package name */
    public static int f59731b;

    /* renamed from: c  reason: collision with root package name */
    public static int f59732c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f59731b == 0) {
                if (f59730a == null) {
                    f59730a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                if (j.a() < 13) {
                    point.set(f59730a.getWidth(), f59730a.getHeight());
                } else {
                    f59730a.getSize(point);
                }
                f59731b = point.x;
                f59732c = point.y;
            }
            int[] iArr = {f59731b, f59732c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }
}
