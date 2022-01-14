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
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public C2031a a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52780b;

        /* renamed from: c  reason: collision with root package name */
        public long f52781c;

        /* renamed from: d  reason: collision with root package name */
        public long f52782d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52783e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f52784f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f52785g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f52786h;

        public C2031a(a aVar) {
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
            this.f52786h = aVar;
            this.f52780b = true;
            this.f52781c = -1L;
            this.f52782d = -1L;
            this.f52785g = new HashMap();
        }

        public /* synthetic */ C2031a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = false;
                this.f52780b = true;
                this.f52781c = -1L;
                this.f52782d = -1L;
                this.f52783e = false;
                this.f52784f = false;
                this.f52785g.clear();
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
                if (this.a != null && this.a.f52784f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.a.a);
                    jSONObject.put("loadasycsearch", this.a.f52780b);
                    jSONObject.put("starttosearch", this.a.f52781c);
                    jSONObject.put("starttofragment", this.a.f52782d);
                    jSONObject.put("state50", this.a.f52783e);
                    for (String str : this.a.f52785g.keySet()) {
                        jSONObject.put(str, this.a.f52785g.get(str));
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
