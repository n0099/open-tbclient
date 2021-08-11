package com.baidu.webkit.internal.monitor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f63442a;

    /* renamed from: b  reason: collision with root package name */
    public long f63443b;

    /* renamed from: c  reason: collision with root package name */
    public long f63444c;

    /* renamed from: d  reason: collision with root package name */
    public long f63445d;

    /* renamed from: e  reason: collision with root package name */
    public long f63446e;

    /* renamed from: f  reason: collision with root package name */
    public long f63447f;

    /* renamed from: g  reason: collision with root package name */
    public long f63448g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f63449h;

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
        this.f63442a = -1L;
        this.f63443b = -1L;
        this.f63444c = -1L;
        this.f63445d = -1L;
        this.f63446e = -1L;
        this.f63447f = -1L;
        this.f63448g = -1L;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f63442a = -1L;
            this.f63443b = -1L;
            this.f63444c = -1L;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f63445d = -1L;
            this.f63446e = -1L;
            this.f63447f = -1L;
            this.f63448g = -1L;
        }
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f63445d == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f63445d != -1) {
                    jSONObject.put("sf1", this.f63445d);
                }
                if (this.f63446e != -1) {
                    jSONObject.put("sf2", this.f63446e);
                }
                if (this.f63447f != -1) {
                    jSONObject.put("sf3", this.f63447f);
                }
                if (this.f63448g != -1) {
                    jSONObject.put("sf4", this.f63448g);
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
            if (this.f63442a == -1 && this.f63443b == -1 && this.f63444c == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f63442a != -1) {
                    jSONObject.put(PrefetchEvent.STATE_CLICK, this.f63442a);
                }
                if (this.f63443b != -1) {
                    jSONObject.put("evajs", this.f63443b);
                }
                if (this.f63444c != -1) {
                    jSONObject.put("loadurl", this.f63444c);
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
