package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class k80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k80 c;
    public static HashMap<String, AtomicBoolean> d;
    public transient /* synthetic */ FieldHolder $fh;
    public i80 a;
    public m80 b;

    /* loaded from: classes5.dex */
    public class b implements IMPushUploadResponseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ k80 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.a;
                    bVar.e.g(bVar.b, bVar.a, bVar.c, bVar.d);
                }
            }
        }

        public b(k80 k80Var, String str, Context context, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, str, context, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k80Var;
            this.a = str;
            this.b = context;
            this.c = list;
            this.d = i;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                ((AtomicBoolean) k80.d.get(this.a)).set(false);
                if (i == 0) {
                    this.e.a.f().execute(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ k80 d;

        public a(k80 k80Var, Context context, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, context, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = k80Var;
            this.a = context;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.j(this.a, this.b, this.c);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947866822, "Lcom/baidu/tieba/k80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947866822, "Lcom/baidu/tieba/k80;");
                return;
            }
        }
        d = new HashMap<>(2);
    }

    public void f() {
        i80 i80Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (i80Var = this.a) != null) {
            i80Var.c();
        }
    }

    public k80(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i80.h(context);
        this.b = new m80();
    }

    public static Boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (d.get(str) == null) {
                d.put(str, new AtomicBoolean(false));
                return Boolean.FALSE;
            }
            return Boolean.valueOf(d.get(str).get());
        }
        return (Boolean) invokeL.objValue;
    }

    public static k80 h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (c == null) {
                synchronized (k80.class) {
                    if (c == null) {
                        c = new k80(context);
                    }
                }
            }
            return c;
        }
        return (k80) invokeL.objValue;
    }

    public synchronized void e(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, str, i) == null) {
            synchronized (this) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(str) && context != null && RequsetNetworkUtils.isConnected(context) && n80.f(context) && n80.e(context, Integer.parseInt(str))) {
                    if (this.a != null) {
                        this.a.f().execute(new a(this, context, str, i));
                    }
                    return;
                }
                q90.a("FlowTrackManager", "flow 无网、参数不对、未命中小流量不上报");
            }
        }
    }

    public final void g(Context context, String str, List<o80> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, list, i) == null) && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (o80 o80Var : list) {
                if (o80Var != null) {
                    arrayList.add(o80Var.b());
                }
            }
            q90.a("FlowTrackManager", "flow clear上报成功的数据");
            c90.j(context).e(str, arrayList);
            if (c90.j(context).i(str) > 0) {
                j(context, str, i);
            }
        }
    }

    public final void j(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, context, str, i) == null) {
            q90.a("FlowTrackManager", "flow begin uplodFlow~~~");
            if (d.get(str) == null) {
                d.put(str, new AtomicBoolean(true));
            } else {
                d.get(str).set(true);
            }
            ArrayList arrayList = new ArrayList();
            m80 m80Var = this.b;
            if (m80Var != null) {
                byte[] c2 = m80Var.c(context, str, arrayList, i);
                if (c2 != null && arrayList.size() > 0) {
                    if (c2.length >= 307200) {
                        q90.a("FlowTrackManager", "flow 上报数据长度超过300k");
                        d.get(str).set(false);
                        return;
                    }
                    IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new b(this, str, context, arrayList, i));
                    return;
                }
                q90.a("FlowTrackManager", "flow 上报数据为空");
                d.get(str).set(false);
            }
        }
    }
}
