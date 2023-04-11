package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<String> b;
    public c c;
    public boolean d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;
        public volatile NetWork b;
        public final /* synthetic */ xa5 c;

        /* loaded from: classes6.dex */
        public class a implements Comparator<Map.Entry<String, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                    return (int) (gg.e(String.valueOf(entry.getValue()), 0) - gg.e(String.valueOf(entry2.getValue()), 0));
                }
                return invokeLL.intValue;
            }
        }

        public c(xa5 xa5Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa5Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xa5Var;
            this.a = null;
            this.b = null;
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                    String postNetData = this.b.postNetData();
                    if (this.b.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        if (jSONObject.optInt("error_code") == 0) {
                            String optString = jSONObject.optString("urls");
                            this.c.b = this.c.j(optString);
                            if (this.c.b != null && this.c.b.size() > 0) {
                                HashMap hashMap = new HashMap();
                                int i = 0;
                                for (int i2 = 0; i2 < this.c.b.size(); i2++) {
                                    String str = (String) this.c.b.get(i2);
                                    cb5 cb5Var = new cb5();
                                    cb5Var.a(str);
                                    if (cb5Var.d()) {
                                        hashMap.put(str, Integer.valueOf(cb5Var.b()));
                                    }
                                }
                                if (hashMap.size() > 0) {
                                    this.c.b = new ArrayList();
                                    ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                    Collections.sort(arrayList, new a(this));
                                    StringBuilder sb = new StringBuilder(50);
                                    for (Map.Entry entry : arrayList) {
                                        this.c.b.add(entry.getKey());
                                        if (i != 0) {
                                            sb.append(",");
                                        }
                                        i++;
                                        sb.append((String) entry.getKey());
                                    }
                                    optString = sb.toString();
                                }
                                p45.m().A("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                                p45.m().B("KeyOfSharedPrefIpList", optString);
                                return null;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.c.c = null;
                b bVar = this.a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.c.c = null;
                b bVar = this.a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.b != null) {
                    this.b.cancelNetConnect();
                    this.b = null;
                }
                this.c.c = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.c = null;
                b bVar = this.a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static xa5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-295551779, "Lcom/baidu/tieba/xa5$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-295551779, "Lcom/baidu/tieba/xa5$d;");
                    return;
                }
            }
            a = new xa5(null);
        }
    }

    public xa5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.d = false;
        this.b = null;
    }

    public static xa5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d.a;
        }
        return (xa5) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return p45.m().n("KeyOfSharedPrefImCount", 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = false;
        }
    }

    public /* synthetic */ xa5(a aVar) {
        this();
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TiebaIMConfig.defaultUrl.equals(str)) {
            this.a = str;
            p45.m().B("KeyOfSharedPrefValidIp", str);
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && this.c == null) {
            this.d = true;
            c cVar = new c(this, bVar);
            this.c = cVar;
            cVar.setSelfExecute(true);
            this.c.execute(new Object[0]);
        }
    }

    public List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null) {
                if (System.currentTimeMillis() - p45.m().o("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                    p45.m().B("KeyOfSharedPrefIpList", "");
                    return null;
                }
                this.b = j(p45.m().s("KeyOfSharedPrefIpList", null));
            }
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int e = e();
            if (e >= 10) {
                p45.m().z("KeyOfSharedPrefImCount", 0);
                p45.m().B("KeyOfSharedPrefValidIp", "");
                this.a = null;
                return null;
            }
            if (this.a == null) {
                this.a = p45.m().s("KeyOfSharedPrefValidIp", null);
            }
            if (!hi.isEmpty(this.a)) {
                p45.m().z("KeyOfSharedPrefImCount", e + 1);
            } else {
                this.a = null;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final List<String> j(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null && str.length() > 0 && (split = str.split(",")) != null && split.length > 0) {
                ArrayList arrayList = new ArrayList(3);
                for (String str2 : split) {
                    arrayList.add(str2);
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
