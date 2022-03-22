package com.bun.miitmdid;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<?> a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Object f37977b;

    /* renamed from: c  reason: collision with root package name */
    public String f37978c;

    /* renamed from: d  reason: collision with root package name */
    public Class<?>[] f37979d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f37980e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f37981f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37982g;

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {cls, obj, str, clsArr, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37982g = false;
        this.a = cls;
        this.f37977b = obj;
        this.f37978c = str;
        this.f37979d = clsArr;
        this.f37980e = objArr;
    }

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {cls, obj, str, clsArr, objArr, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37982g = false;
        this.a = cls;
        this.f37977b = obj;
        this.f37978c = str;
        this.f37979d = clsArr;
        this.f37980e = objArr;
        this.f37981f = cls2;
    }

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {cls, obj, str, clsArr, objArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37982g = false;
        this.a = cls;
        this.f37977b = obj;
        this.f37978c = str;
        this.f37979d = clsArr;
        this.f37980e = objArr;
        this.f37982g = z;
    }

    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getDeclaredMethod(this.f37978c, this.f37979d).invoke(this.f37977b, this.f37980e) : invokeV.objValue;
    }

    @Nullable
    public Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37981f : (Class) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37982g : invokeV.booleanValue;
    }
}
