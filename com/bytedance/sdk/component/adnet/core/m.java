package com.bytedance.sdk.component.adnet.core;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.face.a;
import java.util.Map;
/* loaded from: classes9.dex */
public class m<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final T f64698a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C1888a f64699b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f64700c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64701d;

    /* renamed from: e  reason: collision with root package name */
    public long f64702e;

    /* renamed from: f  reason: collision with root package name */
    public long f64703f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f64704g;

    /* renamed from: h  reason: collision with root package name */
    public long f64705h;

    /* loaded from: classes9.dex */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    public m(T t, a.C1888a c1888a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, c1888a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64701d = false;
        this.f64702e = 0L;
        this.f64703f = 0L;
        this.f64705h = 0L;
        this.f64698a = t;
        this.f64699b = c1888a;
        this.f64700c = null;
        if (c1888a != null) {
            this.f64705h = c1888a.f64729a;
        }
    }

    public static <T> m<T> a(T t, a.C1888a c1888a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, t, c1888a)) == null) ? new m<>(t, c1888a) : (m) invokeLL.objValue;
    }

    public m b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            this.f64703f = j2;
            return this;
        }
        return (m) invokeJ.objValue;
    }

    public static <T> m<T> a(VAdError vAdError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vAdError)) == null) ? new m<>(vAdError) : (m) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64700c == null : invokeV.booleanValue;
    }

    public m a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            this.f64702e = j2;
            return this;
        }
        return (m) invokeJ.objValue;
    }

    public String a(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Map<String, String> map;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            a.C1888a c1888a = this.f64699b;
            return (c1888a == null || (map = c1888a.f64736h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
        }
        return (String) invokeLL.objValue;
    }

    public m(VAdError vAdError) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vAdError};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64701d = false;
        this.f64702e = 0L;
        this.f64703f = 0L;
        this.f64705h = 0L;
        this.f64698a = null;
        this.f64699b = null;
        this.f64700c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        i iVar = vAdError.networkResponse;
        if (iVar != null) {
            this.f64705h = iVar.f64680a;
        } else {
            this.f64705h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.component.adnet.d.c.b("Response", "Response error code = " + this.f64705h);
    }
}
