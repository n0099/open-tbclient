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
/* loaded from: classes11.dex */
public final class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f61240a;

    /* renamed from: b  reason: collision with root package name */
    public final String f61241b;

    /* renamed from: c  reason: collision with root package name */
    public final int f61242c;

    /* renamed from: d  reason: collision with root package name */
    public Method f61243d;

    public a(@NonNull Activity activity, int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61240a = activity;
        this.f61241b = str;
        this.f61242c = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f61243d == null) {
                try {
                    Method method = this.f61240a.getClass().getMethod(this.f61241b, View.class);
                    if (method != null) {
                        this.f61243d = method;
                    }
                } catch (NoSuchMethodException unused) {
                }
                throw new IllegalStateException("Could not find method " + this.f61241b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f61242c);
            }
            try {
                this.f61243d.invoke(this.f61240a, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }
}
