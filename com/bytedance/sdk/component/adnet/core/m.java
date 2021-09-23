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
    public final T f64663a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C1886a f64664b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f64665c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64666d;

    /* renamed from: e  reason: collision with root package name */
    public long f64667e;

    /* renamed from: f  reason: collision with root package name */
    public long f64668f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f64669g;

    /* renamed from: h  reason: collision with root package name */
    public long f64670h;

    /* loaded from: classes9.dex */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    public m(T t, a.C1886a c1886a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, c1886a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64666d = false;
        this.f64667e = 0L;
        this.f64668f = 0L;
        this.f64670h = 0L;
        this.f64663a = t;
        this.f64664b = c1886a;
        this.f64665c = null;
        if (c1886a != null) {
            this.f64670h = c1886a.f64694a;
        }
    }

    public static <T> m<T> a(T t, a.C1886a c1886a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, t, c1886a)) == null) ? new m<>(t, c1886a) : (m) invokeLL.objValue;
    }

    public m b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            this.f64668f = j2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64665c == null : invokeV.booleanValue;
    }

    public m a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            this.f64667e = j2;
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
            a.C1886a c1886a = this.f64664b;
            return (c1886a == null || (map = c1886a.f64701h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
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
        this.f64666d = false;
        this.f64667e = 0L;
        this.f64668f = 0L;
        this.f64670h = 0L;
        this.f64663a = null;
        this.f64664b = null;
        this.f64665c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        i iVar = vAdError.networkResponse;
        if (iVar != null) {
            this.f64670h = iVar.f64645a;
        } else {
            this.f64670h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.component.adnet.d.c.b("Response", "Response error code = " + this.f64670h);
    }
}
