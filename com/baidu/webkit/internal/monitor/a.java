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
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public C1833a f61002a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1833a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f61003a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61004b;

        /* renamed from: c  reason: collision with root package name */
        public long f61005c;

        /* renamed from: d  reason: collision with root package name */
        public long f61006d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f61007e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f61008f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f61009g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f61010h;

        public C1833a(a aVar) {
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
            this.f61010h = aVar;
            this.f61004b = true;
            this.f61005c = -1L;
            this.f61006d = -1L;
            this.f61009g = new HashMap();
        }

        public /* synthetic */ C1833a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61003a = false;
                this.f61004b = true;
                this.f61005c = -1L;
                this.f61006d = -1L;
                this.f61007e = false;
                this.f61008f = false;
                this.f61009g.clear();
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
                if (this.f61002a != null && this.f61002a.f61008f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f61002a.f61003a);
                    jSONObject.put("loadasycsearch", this.f61002a.f61004b);
                    jSONObject.put("starttosearch", this.f61002a.f61005c);
                    jSONObject.put("starttofragment", this.f61002a.f61006d);
                    jSONObject.put("state50", this.f61002a.f61007e);
                    for (String str : this.f61002a.f61009g.keySet()) {
                        jSONObject.put(str, this.f61002a.f61009g.get(str));
                    }
                    this.f61002a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f61002a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
