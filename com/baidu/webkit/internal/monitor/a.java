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
    public C1872a f64124a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1872a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64125a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64126b;

        /* renamed from: c  reason: collision with root package name */
        public long f64127c;

        /* renamed from: d  reason: collision with root package name */
        public long f64128d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64129e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64130f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f64131g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f64132h;

        public C1872a(a aVar) {
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
            this.f64132h = aVar;
            this.f64126b = true;
            this.f64127c = -1L;
            this.f64128d = -1L;
            this.f64131g = new HashMap();
        }

        public /* synthetic */ C1872a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64125a = false;
                this.f64126b = true;
                this.f64127c = -1L;
                this.f64128d = -1L;
                this.f64129e = false;
                this.f64130f = false;
                this.f64131g.clear();
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
                if (this.f64124a != null && this.f64124a.f64130f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f64124a.f64125a);
                    jSONObject.put("loadasycsearch", this.f64124a.f64126b);
                    jSONObject.put("starttosearch", this.f64124a.f64127c);
                    jSONObject.put("starttofragment", this.f64124a.f64128d);
                    jSONObject.put("state50", this.f64124a.f64129e);
                    for (String str : this.f64124a.f64131g.keySet()) {
                        jSONObject.put(str, this.f64124a.f64131g.get(str));
                    }
                    this.f64124a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f64124a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
