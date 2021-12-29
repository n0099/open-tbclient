package com.bun.miitmdid;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<?> a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Object f54987b;

    /* renamed from: c  reason: collision with root package name */
    public String f54988c;

    /* renamed from: d  reason: collision with root package name */
    public Class<?>[] f54989d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f54990e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f54991f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54992g;

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
        this.f54992g = false;
        this.a = cls;
        this.f54987b = obj;
        this.f54988c = str;
        this.f54989d = clsArr;
        this.f54990e = objArr;
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
        this.f54992g = false;
        this.a = cls;
        this.f54987b = obj;
        this.f54988c = str;
        this.f54989d = clsArr;
        this.f54990e = objArr;
        this.f54991f = cls2;
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
        this.f54992g = false;
        this.a = cls;
        this.f54987b = obj;
        this.f54988c = str;
        this.f54989d = clsArr;
        this.f54990e = objArr;
        this.f54992g = z;
    }

    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getDeclaredMethod(this.f54988c, this.f54989d).invoke(this.f54987b, this.f54990e) : invokeV.objValue;
    }

    @Nullable
    public Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54991f : (Class) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54992g : invokeV.booleanValue;
    }
}
