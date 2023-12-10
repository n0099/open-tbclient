package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public String b;
    public boolean c;

    public iob() {
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
        this.a = new JSONObject();
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            i(UbcRemoteStat.CONNECTED, "preconnect_app_hosts", str);
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

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            i(UbcRemoteStat.CONNECTED, "preconnect_enabled", Boolean.valueOf(z));
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            i(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (new File(str).isDirectory()) {
                this.b = str;
                return;
            }
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
    }

    public void d(int i, long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i != 3 && i != 2) {
                if (l() != null) {
                    throw new IllegalArgumentException("Storage path must not be set");
                }
            } else if (l() != null) {
                this.c = true;
            } else {
                throw new IllegalArgumentException("Storage path must be set");
            }
            if (i != 0 && i != 2) {
                z = false;
            } else {
                z = true;
            }
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_enabled", Boolean.valueOf(!z));
            if (i != 0) {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalArgumentException("Unknown cache mode");
                    }
                    i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", 2);
                } else {
                    i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", 1);
                }
            } else {
                i(SchemeCollecter.CLASSIFY_BASE, "http_cache_mode", 0);
            }
            i(SchemeCollecter.CLASSIFY_BASE, "http_cache_size", Long.valueOf(j));
        }
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
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
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
}
