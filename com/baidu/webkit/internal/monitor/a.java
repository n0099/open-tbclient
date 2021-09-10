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
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public C1868a f63813a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1868a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63814a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63815b;

        /* renamed from: c  reason: collision with root package name */
        public long f63816c;

        /* renamed from: d  reason: collision with root package name */
        public long f63817d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63818e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63819f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f63820g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f63821h;

        public C1868a(a aVar) {
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
            this.f63821h = aVar;
            this.f63815b = true;
            this.f63816c = -1L;
            this.f63817d = -1L;
            this.f63820g = new HashMap();
        }

        public /* synthetic */ C1868a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63814a = false;
                this.f63815b = true;
                this.f63816c = -1L;
                this.f63817d = -1L;
                this.f63818e = false;
                this.f63819f = false;
                this.f63820g.clear();
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
                if (this.f63813a != null && this.f63813a.f63819f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f63813a.f63814a);
                    jSONObject.put("loadasycsearch", this.f63813a.f63815b);
                    jSONObject.put("starttosearch", this.f63813a.f63816c);
                    jSONObject.put("starttofragment", this.f63813a.f63817d);
                    jSONObject.put("state50", this.f63813a.f63818e);
                    for (String str : this.f63813a.f63820g.keySet()) {
                        jSONObject.put(str, this.f63813a.f63820g.get(str));
                    }
                    this.f63813a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f63813a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
