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
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f27346a;

    /* renamed from: b  reason: collision with root package name */
    public long f27347b;

    /* renamed from: c  reason: collision with root package name */
    public long f27348c;

    /* renamed from: d  reason: collision with root package name */
    public long f27349d;

    /* renamed from: e  reason: collision with root package name */
    public long f27350e;

    /* renamed from: f  reason: collision with root package name */
    public long f27351f;

    /* renamed from: g  reason: collision with root package name */
    public long f27352g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f27353h;

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
        this.f27346a = -1L;
        this.f27347b = -1L;
        this.f27348c = -1L;
        this.f27349d = -1L;
        this.f27350e = -1L;
        this.f27351f = -1L;
        this.f27352g = -1L;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f27346a = -1L;
            this.f27347b = -1L;
            this.f27348c = -1L;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f27349d = -1L;
            this.f27350e = -1L;
            this.f27351f = -1L;
            this.f27352g = -1L;
        }
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f27349d == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f27349d != -1) {
                    jSONObject.put("sf1", this.f27349d);
                }
                if (this.f27350e != -1) {
                    jSONObject.put("sf2", this.f27350e);
                }
                if (this.f27351f != -1) {
                    jSONObject.put("sf3", this.f27351f);
                }
                if (this.f27352g != -1) {
                    jSONObject.put("sf4", this.f27352g);
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
            if (this.f27346a == -1 && this.f27347b == -1 && this.f27348c == -1) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f27346a != -1) {
                    jSONObject.put(PrefetchEvent.STATE_CLICK, this.f27346a);
                }
                if (this.f27347b != -1) {
                    jSONObject.put("evajs", this.f27347b);
                }
                if (this.f27348c != -1) {
                    jSONObject.put("loadurl", this.f27348c);
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
