package com.baidu.webkit.internal.monitor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public C2023a a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C2023a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f51411b;

        /* renamed from: c  reason: collision with root package name */
        public long f51412c;

        /* renamed from: d  reason: collision with root package name */
        public long f51413d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51414e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f51415f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f51416g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f51417h;

        public C2023a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51417h = aVar;
            this.f51411b = true;
            this.f51412c = -1L;
            this.f51413d = -1L;
            this.f51416g = new HashMap();
        }

        public /* synthetic */ C2023a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = false;
                this.f51411b = true;
                this.f51412c = -1L;
                this.f51413d = -1L;
                this.f51414e = false;
                this.f51415f = false;
                this.f51416g.clear();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.a != null && this.a.f51415f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.a.a);
                    jSONObject.put("loadasycsearch", this.a.f51411b);
                    jSONObject.put("starttosearch", this.a.f51412c);
                    jSONObject.put("starttofragment", this.a.f51413d);
                    jSONObject.put("state50", this.a.f51414e);
                    for (String str : this.a.f51416g.keySet()) {
                        jSONObject.put(str, this.a.f51416g.get(str));
                    }
                    this.a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
