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
    public C1864a f63433a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1864a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63434a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63435b;

        /* renamed from: c  reason: collision with root package name */
        public long f63436c;

        /* renamed from: d  reason: collision with root package name */
        public long f63437d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63438e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63439f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f63440g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f63441h;

        public C1864a(a aVar) {
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
            this.f63441h = aVar;
            this.f63435b = true;
            this.f63436c = -1L;
            this.f63437d = -1L;
            this.f63440g = new HashMap();
        }

        public /* synthetic */ C1864a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63434a = false;
                this.f63435b = true;
                this.f63436c = -1L;
                this.f63437d = -1L;
                this.f63438e = false;
                this.f63439f = false;
                this.f63440g.clear();
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
                if (this.f63433a != null && this.f63433a.f63439f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f63433a.f63434a);
                    jSONObject.put("loadasycsearch", this.f63433a.f63435b);
                    jSONObject.put("starttosearch", this.f63433a.f63436c);
                    jSONObject.put("starttofragment", this.f63433a.f63437d);
                    jSONObject.put("state50", this.f63433a.f63438e);
                    for (String str : this.f63433a.f63440g.keySet()) {
                        jSONObject.put(str, this.f63433a.f63440g.get(str));
                    }
                    this.f63433a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f63433a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
