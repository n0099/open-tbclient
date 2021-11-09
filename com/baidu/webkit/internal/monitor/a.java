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
    public C1833a f61001a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1833a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f61002a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61003b;

        /* renamed from: c  reason: collision with root package name */
        public long f61004c;

        /* renamed from: d  reason: collision with root package name */
        public long f61005d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f61006e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f61007f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f61008g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f61009h;

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
            this.f61009h = aVar;
            this.f61003b = true;
            this.f61004c = -1L;
            this.f61005d = -1L;
            this.f61008g = new HashMap();
        }

        public /* synthetic */ C1833a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61002a = false;
                this.f61003b = true;
                this.f61004c = -1L;
                this.f61005d = -1L;
                this.f61006e = false;
                this.f61007f = false;
                this.f61008g.clear();
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
                if (this.f61001a != null && this.f61001a.f61007f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f61001a.f61002a);
                    jSONObject.put("loadasycsearch", this.f61001a.f61003b);
                    jSONObject.put("starttosearch", this.f61001a.f61004c);
                    jSONObject.put("starttofragment", this.f61001a.f61005d);
                    jSONObject.put("state50", this.f61001a.f61006e);
                    for (String str : this.f61001a.f61008g.keySet()) {
                        jSONObject.put(str, this.f61001a.f61008g.get(str));
                    }
                    this.f61001a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f61001a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
