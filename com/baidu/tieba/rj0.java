package com.baidu.tieba;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.clickinfo.NadTouchInfoModel;
import com.baidu.tieba.d61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class rj0 implements oj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadTouchInfoModel a;
    public WeakReference<qj0> b;
    public WeakReference<View> c;
    public final Context d;
    public final int e;
    public final int f;
    public final int g;

    public rj0(@NonNull pj0 pj0Var, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pj0Var, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = lk0.b();
        this.c = new WeakReference<>(view2);
        this.b = new WeakReference<>(pj0Var.f0());
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        this.e = displayMetrics.widthPixels;
        this.f = displayMetrics.heightPixels;
        this.g = displayMetrics.densityDpi;
        this.a = new NadTouchInfoModel(-1);
        e();
    }

    @NonNull
    public static oj0 b(@Nullable oj0 oj0Var, @NonNull pj0 pj0Var, @NonNull View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, oj0Var, pj0Var, view2)) == null) {
            if (oj0Var == null) {
                return new rj0(pj0Var, view2);
            }
            rj0 rj0Var = (rj0) oj0Var;
            if (rj0Var.c.get() == null) {
                rj0Var.c = new WeakReference<>(view2);
            }
            if (rj0Var.b.get() == null) {
                rj0Var.b = new WeakReference<>(pj0Var.f0());
            }
            return rj0Var;
        }
        return (oj0) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oj0
    public String a() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            qj0 qj0Var = this.b.get();
            if (qj0Var == null) {
                return "";
            }
            int[] b = qj0Var.b();
            int[] iArr = new int[2];
            View view2 = this.c.get();
            if (view2 != null) {
                view2.getLocationOnScreen(iArr);
            }
            int i2 = iArr[1];
            if (view2 != null) {
                i = view2.getHeight() + i2;
            } else {
                i = 0;
            }
            Point d = d();
            int i3 = this.e;
            int i4 = this.f;
            if (d != null) {
                i3 = d.x;
                i4 = d.y;
            }
            String[] strArr = new String[9];
            strArr[0] = DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX;
            if (d61.c.j()) {
                str = "1";
            } else {
                str = "0";
            }
            strArr[1] = str;
            strArr[2] = String.valueOf(b[0]);
            strArr[3] = String.valueOf(b[1]);
            strArr[4] = String.valueOf(i2);
            strArr[5] = String.valueOf(i);
            strArr[6] = String.valueOf(i3);
            strArr[7] = String.valueOf(i4);
            strArr[8] = String.valueOf(this.g);
            String join = TextUtils.join(",", strArr);
            c();
            return join;
        }
        return (String) invokeV.objValue;
    }

    public final void c() {
        View view2;
        qj0 qj0Var;
        o51 o51Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && j51.a && (view2 = this.c.get()) != null && (qj0Var = this.b.get()) != null && (o51Var = (o51) i51.a().a(o51.class)) != null) {
            int[] iArr = qj0Var.b;
            o51Var.a(view2, iArr[0], iArr[1]);
        }
    }

    public final Point d() {
        InterceptResult invokeV;
        Display display;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view2 = this.c.get();
            if (view2 == null || Build.VERSION.SDK_INT < 17 || (display = view2.getDisplay()) == null) {
                return null;
            }
            Point point = new Point();
            display.getRealSize(point);
            return point;
        }
        return (Point) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NadTouchInfoModel nadTouchInfoModel = this.a;
            if (nadTouchInfoModel.b) {
                return;
            }
            nadTouchInfoModel.a = this.g;
            nadTouchInfoModel.b = true;
        }
    }
}
