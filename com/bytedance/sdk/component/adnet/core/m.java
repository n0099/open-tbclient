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
/* loaded from: classes6.dex */
public class m<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final T f27921a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C0316a f27922b;

    /* renamed from: c  reason: collision with root package name */
    public final VAdError f27923c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27924d;

    /* renamed from: e  reason: collision with root package name */
    public long f27925e;

    /* renamed from: f  reason: collision with root package name */
    public long f27926f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f27927g;

    /* renamed from: h  reason: collision with root package name */
    public long f27928h;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    public m(T t, a.C0316a c0316a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, c0316a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27924d = false;
        this.f27925e = 0L;
        this.f27926f = 0L;
        this.f27928h = 0L;
        this.f27921a = t;
        this.f27922b = c0316a;
        this.f27923c = null;
        if (c0316a != null) {
            this.f27928h = c0316a.f27956a;
        }
    }

    public static <T> m<T> a(T t, a.C0316a c0316a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, t, c0316a)) == null) ? new m<>(t, c0316a) : (m) invokeLL.objValue;
    }

    public m b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            this.f27926f = j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27923c == null : invokeV.booleanValue;
    }

    public m a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            this.f27925e = j;
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
            a.C0316a c0316a = this.f27922b;
            return (c0316a == null || (map = c0316a.f27963h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
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
        this.f27924d = false;
        this.f27925e = 0L;
        this.f27926f = 0L;
        this.f27928h = 0L;
        this.f27921a = null;
        this.f27922b = null;
        this.f27923c = vAdError;
        if (0 != 0 || vAdError == null) {
            return;
        }
        i iVar = vAdError.networkResponse;
        if (iVar != null) {
            this.f27928h = iVar.f27904a;
        } else {
            this.f27928h = vAdError.getErrorCode();
        }
        com.bytedance.sdk.component.adnet.d.d.b("Response", "Response error code = " + this.f27928h);
    }
}
