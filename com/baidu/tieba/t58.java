package com.baidu.tieba;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.da;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class t58 {
    public static /* synthetic */ Interceptable $ic;
    public static t58 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, String> a;
    public da<String> b;

    /* loaded from: classes8.dex */
    public class a extends bv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t58 a;

        public a(t58 t58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t58Var;
        }

        @Override // com.baidu.tieba.bv4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && rua.f(activity)) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : this.a.a.snapshot().entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(",");
                }
                if (sb.length() <= 1) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
                this.a.b.a("transition_cache_key", sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements da.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t58 a;

        public b(t58 t58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.da.a
        /* renamed from: b */
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && str2 != null && !str2.isEmpty()) {
                for (String str3 : str2.split(",")) {
                    String[] split = str3.split("=");
                    if (split != null && split.length == 2) {
                        this.a.a.put(split[0], split[1]);
                    }
                }
            }
        }
    }

    public t58() {
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
        this.a = new LruCache<>(10);
        e05.k();
        this.b = e05.l("tb.recently_vistited_forum_animation");
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new a(this));
        this.b.f("transition_cache_key", new b(this));
    }

    public u58 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return new u58(null);
            }
            return new u58(this.a.get(str));
        }
        return (u58) invokeL.objValue;
    }

    public static t58 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (t58.class) {
                    if (c == null) {
                        c = new t58();
                    }
                }
            }
            return c;
        }
        return (t58) invokeV.objValue;
    }

    public void e(String str, u58 u58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, u58Var) == null) {
            this.a.put(str, u58Var.toString());
        }
    }
}
