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
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Display f23297a;

    /* renamed from: b  reason: collision with root package name */
    public static int f23298b;

    /* renamed from: c  reason: collision with root package name */
    public static int f23299c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f23298b == 0) {
                if (f23297a == null) {
                    f23297a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                if (j.a() < 13) {
                    point.set(f23297a.getWidth(), f23297a.getHeight());
                } else {
                    f23297a.getSize(point);
                }
                f23298b = point.x;
                f23299c = point.y;
            }
            int[] iArr = {f23298b, f23299c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }
}
