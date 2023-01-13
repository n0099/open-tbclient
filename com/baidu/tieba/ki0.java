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
import com.baidu.tieba.r31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class ki0 implements hi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadTouchInfoModel a;
    public WeakReference<ji0> b;
    public WeakReference<View> c;
    public final Context d;
    public final int e;
    public final int f;
    public final int g;

    public ki0(@NonNull ii0 ii0Var, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ii0Var, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ej0.b();
        this.c = new WeakReference<>(view2);
        this.b = new WeakReference<>(ii0Var.J());
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        this.e = displayMetrics.widthPixels;
        this.f = displayMetrics.heightPixels;
        this.g = displayMetrics.densityDpi;
        this.a = new NadTouchInfoModel(-1);
        e();
    }

    @NonNull
    public static hi0 b(@Nullable hi0 hi0Var, @NonNull ii0 ii0Var, @NonNull View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, hi0Var, ii0Var, view2)) == null) {
            if (hi0Var == null) {
                return new ki0(ii0Var, view2);
            }
            ki0 ki0Var = (ki0) hi0Var;
            if (ki0Var.c.get() == null) {
                ki0Var.c = new WeakReference<>(view2);
            }
            if (ki0Var.b.get() == null) {
                ki0Var.b = new WeakReference<>(ii0Var.J());
            }
            return ki0Var;
        }
        return (hi0) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hi0
    public String a() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ji0 ji0Var = this.b.get();
            if (ji0Var == null) {
                return "";
            }
            int[] b = ji0Var.b();
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
            strArr[0] = "v2";
            if (r31.c.j()) {
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
        ji0 ji0Var;
        e31 e31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && z21.a && (view2 = this.c.get()) != null && (ji0Var = this.b.get()) != null && (e31Var = (e31) y21.a().a(e31.class)) != null) {
            int[] iArr = ji0Var.b;
            e31Var.a(view2, iArr[0], iArr[1]);
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
