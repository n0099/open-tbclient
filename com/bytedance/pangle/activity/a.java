package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38014b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38015c;

    /* renamed from: d  reason: collision with root package name */
    public Method f38016d;

    public a(@NonNull Activity activity, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.f38014b = str;
        this.f38015c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f38016d == null) {
                try {
                    Method method = this.a.getClass().getMethod(this.f38014b, View.class);
                    if (method != null) {
                        this.f38016d = method;
                    }
                } catch (NoSuchMethodException unused) {
                }
                throw new IllegalStateException("Could not find method " + this.f38014b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f38015c);
            }
            try {
                this.f38016d.invoke(this.a, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }
}
