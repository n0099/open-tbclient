package com.baidu.webkit.internal.monitor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f52999b;

    /* renamed from: c  reason: collision with root package name */
    public long f53000c;

    /* renamed from: d  reason: collision with root package name */
    public long f53001d;

    /* renamed from: e  reason: collision with root package name */
    public long f53002e;

    /* renamed from: f  reason: collision with root package name */
    public long f53003f;

    /* renamed from: g  reason: collision with root package name */
    public long f53004g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f53005h;

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
        this.f52999b = -1L;
        this.f53000c = -1L;
        this.f53001d = -1L;
        this.f53002e = -1L;
        this.f53003f = -1L;
        this.f53004g = -1L;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.a = -1L;
            this.f52999b = -1L;
            this.f53000c = -1L;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f53001d = -1L;
            this.f53002e = -1L;
            this.f53003f = -1L;
            this.f53004g = -1L;
        }
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f53001d == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f53001d != -1) {
                    jSONObject.put("sf1", this.f53001d);
                }
                if (this.f53002e != -1) {
                    jSONObject.put("sf2", this.f53002e);
                }
                if (this.f53003f != -1) {
                    jSONObject.put("sf3", this.f53003f);
                }
                if (this.f53004g != -1) {
                    jSONObject.put("sf4", this.f53004g);
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
            if (this.a == -1 && this.f52999b == -1 && this.f53000c == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.a != -1) {
                    jSONObject.put("click", this.a);
                }
                if (this.f52999b != -1) {
                    jSONObject.put("evajs", this.f52999b);
                }
                if (this.f53000c != -1) {
                    jSONObject.put("loadurl", this.f53000c);
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
