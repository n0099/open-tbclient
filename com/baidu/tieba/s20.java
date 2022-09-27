package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v20;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class s20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s20 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public v20 b;
    public w20 c;

    /* loaded from: classes5.dex */
    public class a implements v20.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ s20 b;

        public a(s20 s20Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s20Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s20Var;
            this.a = dVar;
        }

        @Override // com.baidu.tieba.v20.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v20.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(new m50(this.b.a, jSONArray.getJSONObject(i).getString("pkg")));
                    }
                } catch (Exception unused) {
                }
                this.a.b(arrayList, bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements v20.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(s20 s20Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s20Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.v20.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v20.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.a.b(e.a(str), bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements v20.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(s20 s20Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s20Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.v20.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v20.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.a.b(str, bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d<T> extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public u20<T> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(u20<T> u20Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u20Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u20Var;
        }

        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                obtainMessage(1, i, 0, Pair.create(exc, bundle)).sendToTarget();
            }
        }

        public void b(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.u20<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                int i = message.what;
                if (i == 0) {
                    Pair pair = (Pair) message.obj;
                    this.a.onResult(pair.first, (Bundle) pair.second);
                } else if (i != 1) {
                } else {
                    Pair pair2 = (Pair) message.obj;
                    this.a.onError(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<f> a;

        public e(List<f> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.addAll(list);
        }

        public static e a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        arrayList.add(new f(jSONObject.getString("pkg"), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                    }
                    return new e(arrayList);
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public List<f> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "sids {" + this.a + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;
        public final long c;

        public f(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "aid {packageName='" + this.a + "', aid='" + this.b + "', priority=" + this.c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public s20(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        w20 w20Var = new w20(new e60());
        this.c = w20Var;
        this.b = w20Var.a();
        v20.a aVar = new v20.a();
        aVar.a = new g60();
        aVar.b = new f60();
        aVar.c = this.a;
        aVar.d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        aVar.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.b.b(aVar);
        this.b.c(new v20.b());
    }

    public static synchronized s20 e(Context context) {
        InterceptResult invokeL;
        s20 s20Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (s20.class) {
                if (d == null) {
                    d = new s20(context.getApplicationContext());
                }
                s20Var = d;
            }
            return s20Var;
        }
        return (s20) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.g("aid", null).a : (String) invokeV.objValue;
    }

    public v20 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (v20) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.g("iid", null).a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.g("oid", null).a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b.g("ssaid", null).a : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b.e(this.a.getPackageName()) : invokeV.booleanValue;
    }

    public void i(u20<l50> u20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, u20Var, looper) == null) {
            new d(u20Var, looper).b(new l50(), new Bundle());
        }
    }

    public void j(u20<String> u20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, u20Var) == null) {
            k("gaid", u20Var, Looper.getMainLooper());
        }
    }

    public final void k(String str, u20<String> u20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, u20Var, looper) == null) {
            this.b.a(str, null, new c(this, new d(u20Var, looper)));
        }
    }

    public void l(u20<String> u20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, u20Var) == null) {
            k("oid", u20Var, Looper.getMainLooper());
        }
    }

    public void m(u20<List<m50>> u20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, u20Var, looper) == null) {
            this.b.a("sids", null, new a(this, new d(u20Var, looper)));
        }
    }

    public void n(u20<e> u20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, u20Var) == null) {
            o(u20Var, Looper.getMainLooper());
        }
    }

    public void o(u20<e> u20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, u20Var, looper) == null) {
            this.b.a("sids", null, new b(this, new d(u20Var, looper)));
        }
    }
}
