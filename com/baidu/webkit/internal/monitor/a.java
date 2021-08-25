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
    public C1868a f63633a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1868a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63634a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63635b;

        /* renamed from: c  reason: collision with root package name */
        public long f63636c;

        /* renamed from: d  reason: collision with root package name */
        public long f63637d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63638e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63639f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f63640g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f63641h;

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
            this.f63641h = aVar;
            this.f63635b = true;
            this.f63636c = -1L;
            this.f63637d = -1L;
            this.f63640g = new HashMap();
        }

        public /* synthetic */ C1868a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63634a = false;
                this.f63635b = true;
                this.f63636c = -1L;
                this.f63637d = -1L;
                this.f63638e = false;
                this.f63639f = false;
                this.f63640g.clear();
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
                if (this.f63633a != null && this.f63633a.f63639f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f63633a.f63634a);
                    jSONObject.put("loadasycsearch", this.f63633a.f63635b);
                    jSONObject.put("starttosearch", this.f63633a.f63636c);
                    jSONObject.put("starttofragment", this.f63633a.f63637d);
                    jSONObject.put("state50", this.f63633a.f63638e);
                    for (String str : this.f63633a.f63640g.keySet()) {
                        jSONObject.put(str, this.f63633a.f63640g.get(str));
                    }
                    this.f63633a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f63633a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
