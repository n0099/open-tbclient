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
/* loaded from: classes11.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static Display a;

    /* renamed from: b  reason: collision with root package name */
    public static int f51526b;

    /* renamed from: c  reason: collision with root package name */
    public static int f51527c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f51526b == 0) {
                if (a == null) {
                    a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                if (j.a() < 13) {
                    point.set(a.getWidth(), a.getHeight());
                } else {
                    a.getSize(point);
                }
                f51526b = point.x;
                f51527c = point.y;
            }
            int[] iArr = {f51526b, f51527c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }
}
