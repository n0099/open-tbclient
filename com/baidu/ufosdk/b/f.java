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
    public static Display f59384a;

    /* renamed from: b  reason: collision with root package name */
    public static int f59385b;

    /* renamed from: c  reason: collision with root package name */
    public static int f59386c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f59385b == 0) {
                if (f59384a == null) {
                    f59384a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                if (j.a() < 13) {
                    point.set(f59384a.getWidth(), f59384a.getHeight());
                } else {
                    f59384a.getSize(point);
                }
                f59385b = point.x;
                f59386c = point.y;
            }
            int[] iArr = {f59385b, f59386c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }
}
