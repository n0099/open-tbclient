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
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public C0304a f27605a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0304a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27606a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f27607b;

        /* renamed from: c  reason: collision with root package name */
        public long f27608c;

        /* renamed from: d  reason: collision with root package name */
        public long f27609d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27610e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27611f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f27612g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f27613h;

        public C0304a(a aVar) {
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
            this.f27613h = aVar;
            this.f27607b = true;
            this.f27608c = -1L;
            this.f27609d = -1L;
            this.f27612g = new HashMap();
        }

        public /* synthetic */ C0304a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27606a = false;
                this.f27607b = true;
                this.f27608c = -1L;
                this.f27609d = -1L;
                this.f27610e = false;
                this.f27611f = false;
                this.f27612g.clear();
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
                if (this.f27605a != null && this.f27605a.f27611f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f27605a.f27606a);
                    jSONObject.put("loadasycsearch", this.f27605a.f27607b);
                    jSONObject.put("starttosearch", this.f27605a.f27608c);
                    jSONObject.put("starttofragment", this.f27605a.f27609d);
                    jSONObject.put("state50", this.f27605a.f27610e);
                    for (String str : this.f27605a.f27612g.keySet()) {
                        jSONObject.put(str, this.f27605a.f27612g.get(str));
                    }
                    this.f27605a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f27605a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
