package com.baidu.turbonet.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TurbonetConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    public String f37767b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37768c;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface HttpCacheSetting {
    }

    public TurbonetConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37768c = false;
        this.a = new JSONObject();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            i("conn", "preconnect_app_hosts", str);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            i("bdns", "baidu_dns_enabled", Boolean.valueOf(z));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            i(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
        }
    }

    public void d(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i != 3 && i != 2) {
                if (l() != null) {
                    throw new IllegalArgumentException("Storage path must not be set");
                }
            } else if (l() != null) {
                this.f37768c = true;
            } else {
                throw new IllegalArgumentException("Storage path must be set");
            }
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(!(i == 0 || i == 2)));
            if (i == 0) {
                i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISABLED");
            } else if (i == 1) {
                i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "MEMORY");
            } else if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Unknown cache mode");
            } else {
                i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", "DISK");
            }
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_size", Long.valueOf(j));
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            i("conn", "preconnect_enabled", Boolean.valueOf(z));
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            i(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
        }
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (JSONObject) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37768c : invokeV.booleanValue;
    }

    public void i(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, obj) == null) {
            try {
                JSONObject optJSONObject = this.a.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.a.put(str, optJSONObject);
            } catch (JSONException e2) {
                throw new IllegalStateException("JSON expcetion:", e2);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i >= 0) {
                i("misc", "request_timeout", Integer.valueOf(i));
                return;
            }
            throw new IllegalArgumentException(String.format("Invalid timeout second, %d is negative.", Integer.valueOf(i)));
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (new File(str).isDirectory()) {
                this.f37767b = str;
                return;
            }
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37767b : (String) invokeV.objValue;
    }
}
