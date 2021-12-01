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
/* loaded from: classes12.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public C1946a a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C1946a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54282b;

        /* renamed from: c  reason: collision with root package name */
        public long f54283c;

        /* renamed from: d  reason: collision with root package name */
        public long f54284d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54285e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f54286f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f54287g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f54288h;

        public C1946a(a aVar) {
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
            this.f54288h = aVar;
            this.f54282b = true;
            this.f54283c = -1L;
            this.f54284d = -1L;
            this.f54287g = new HashMap();
        }

        public /* synthetic */ C1946a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = false;
                this.f54282b = true;
                this.f54283c = -1L;
                this.f54284d = -1L;
                this.f54285e = false;
                this.f54286f = false;
                this.f54287g.clear();
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
                if (this.a != null && this.a.f54286f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.a.a);
                    jSONObject.put("loadasycsearch", this.a.f54282b);
                    jSONObject.put("starttosearch", this.a.f54283c);
                    jSONObject.put("starttofragment", this.a.f54284d);
                    jSONObject.put("state50", this.a.f54285e);
                    for (String str : this.a.f54287g.keySet()) {
                        jSONObject.put(str, this.a.f54287g.get(str));
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
