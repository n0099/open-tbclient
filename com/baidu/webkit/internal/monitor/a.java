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
    public C1874a f64159a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1874a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64160a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64161b;

        /* renamed from: c  reason: collision with root package name */
        public long f64162c;

        /* renamed from: d  reason: collision with root package name */
        public long f64163d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64164e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64165f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f64166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f64167h;

        public C1874a(a aVar) {
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
            this.f64167h = aVar;
            this.f64161b = true;
            this.f64162c = -1L;
            this.f64163d = -1L;
            this.f64166g = new HashMap();
        }

        public /* synthetic */ C1874a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64160a = false;
                this.f64161b = true;
                this.f64162c = -1L;
                this.f64163d = -1L;
                this.f64164e = false;
                this.f64165f = false;
                this.f64166g.clear();
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
                if (this.f64159a != null && this.f64159a.f64165f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f64159a.f64160a);
                    jSONObject.put("loadasycsearch", this.f64159a.f64161b);
                    jSONObject.put("starttosearch", this.f64159a.f64162c);
                    jSONObject.put("starttofragment", this.f64159a.f64163d);
                    jSONObject.put("state50", this.f64159a.f64164e);
                    for (String str : this.f64159a.f64166g.keySet()) {
                        jSONObject.put(str, this.f64159a.f64166g.get(str));
                    }
                    this.f64159a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f64159a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
