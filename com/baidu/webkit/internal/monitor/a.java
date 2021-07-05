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

    /* renamed from: a  reason: collision with root package name */
    public C0302a f27337a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0302a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27338a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f27339b;

        /* renamed from: c  reason: collision with root package name */
        public long f27340c;

        /* renamed from: d  reason: collision with root package name */
        public long f27341d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27342e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27343f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f27344g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f27345h;

        public C0302a(a aVar) {
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
            this.f27345h = aVar;
            this.f27339b = true;
            this.f27340c = -1L;
            this.f27341d = -1L;
            this.f27344g = new HashMap();
        }

        public /* synthetic */ C0302a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27338a = false;
                this.f27339b = true;
                this.f27340c = -1L;
                this.f27341d = -1L;
                this.f27342e = false;
                this.f27343f = false;
                this.f27344g.clear();
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
                if (this.f27337a != null && this.f27337a.f27343f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f27337a.f27338a);
                    jSONObject.put("loadasycsearch", this.f27337a.f27339b);
                    jSONObject.put("starttosearch", this.f27337a.f27340c);
                    jSONObject.put("starttofragment", this.f27337a.f27341d);
                    jSONObject.put("state50", this.f27337a.f27342e);
                    for (String str : this.f27337a.f27344g.keySet()) {
                        jSONObject.put(str, this.f27337a.f27344g.get(str));
                    }
                    this.f27337a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f27337a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
