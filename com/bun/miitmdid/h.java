package com.bun.miitmdid;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<?> a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Object f51529b;

    /* renamed from: c  reason: collision with root package name */
    public String f51530c;

    /* renamed from: d  reason: collision with root package name */
    public Class<?>[] f51531d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f51532e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f51533f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51534g;

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {cls, obj, str, clsArr, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51534g = false;
        this.a = cls;
        this.f51529b = obj;
        this.f51530c = str;
        this.f51531d = clsArr;
        this.f51532e = objArr;
    }

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {cls, obj, str, clsArr, objArr, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51534g = false;
        this.a = cls;
        this.f51529b = obj;
        this.f51530c = str;
        this.f51531d = clsArr;
        this.f51532e = objArr;
        this.f51533f = cls2;
    }

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {cls, obj, str, clsArr, objArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51534g = false;
        this.a = cls;
        this.f51529b = obj;
        this.f51530c = str;
        this.f51531d = clsArr;
        this.f51532e = objArr;
        this.f51534g = z;
    }

    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getDeclaredMethod(this.f51530c, this.f51531d).invoke(this.f51529b, this.f51532e) : invokeV.objValue;
    }

    @Nullable
    public Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51533f : (Class) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51534g : invokeV.booleanValue;
    }
}
