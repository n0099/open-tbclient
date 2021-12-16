package com.baidu.webkit.internal.monitor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f54869b;

    /* renamed from: c  reason: collision with root package name */
    public long f54870c;

    /* renamed from: d  reason: collision with root package name */
    public long f54871d;

    /* renamed from: e  reason: collision with root package name */
    public long f54872e;

    /* renamed from: f  reason: collision with root package name */
    public long f54873f;

    /* renamed from: g  reason: collision with root package name */
    public long f54874g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f54875h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.f54869b = -1L;
        this.f54870c = -1L;
        this.f54871d = -1L;
        this.f54872e = -1L;
        this.f54873f = -1L;
        this.f54874g = -1L;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.a = -1L;
            this.f54869b = -1L;
            this.f54870c = -1L;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f54871d = -1L;
            this.f54872e = -1L;
            this.f54873f = -1L;
            this.f54874g = -1L;
        }
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f54871d == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f54871d != -1) {
                    jSONObject.put("sf1", this.f54871d);
                }
                if (this.f54872e != -1) {
                    jSONObject.put("sf2", this.f54872e);
                }
                if (this.f54873f != -1) {
                    jSONObject.put("sf3", this.f54873f);
                }
                if (this.f54874g != -1) {
                    jSONObject.put("sf4", this.f54874g);
                }
                d();
                return jSONObject;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                d();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == -1 && this.f54869b == -1 && this.f54870c == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.a != -1) {
                    jSONObject.put("click", this.a);
                }
                if (this.f54869b != -1) {
                    jSONObject.put("evajs", this.f54869b);
                }
                if (this.f54870c != -1) {
                    jSONObject.put("loadurl", this.f54870c);
                }
                c();
                return jSONObject;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                c();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
