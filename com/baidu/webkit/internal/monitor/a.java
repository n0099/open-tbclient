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
    public C1874a f61921a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1874a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f61922a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61923b;

        /* renamed from: c  reason: collision with root package name */
        public long f61924c;

        /* renamed from: d  reason: collision with root package name */
        public long f61925d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f61926e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f61927f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f61928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f61929h;

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
            this.f61929h = aVar;
            this.f61923b = true;
            this.f61924c = -1L;
            this.f61925d = -1L;
            this.f61928g = new HashMap();
        }

        public /* synthetic */ C1874a(a aVar, byte b2) {
            this(aVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61922a = false;
                this.f61923b = true;
                this.f61924c = -1L;
                this.f61925d = -1L;
                this.f61926e = false;
                this.f61927f = false;
                this.f61928g.clear();
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
                if (this.f61921a != null && this.f61921a.f61927f) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("coldbootfirst", this.f61921a.f61922a);
                    jSONObject.put("loadasycsearch", this.f61921a.f61923b);
                    jSONObject.put("starttosearch", this.f61921a.f61924c);
                    jSONObject.put("starttofragment", this.f61921a.f61925d);
                    jSONObject.put("state50", this.f61921a.f61926e);
                    for (String str : this.f61921a.f61928g.keySet()) {
                        jSONObject.put(str, this.f61921a.f61928g.get(str));
                    }
                    this.f61921a.a();
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                Log.printStackTrace(th);
                this.f61921a.a();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
