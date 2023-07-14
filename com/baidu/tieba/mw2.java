package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.lw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class mw2 extends v73 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, oq3<Bundle>> h;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public String g;

    /* loaded from: classes7.dex */
    public class a implements oq3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mw2 b;

        public a(mw2 mw2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mw2Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                this.b.g = bundle.getString("key_launch_app_id");
                this.b.f = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.a, this.b.g)) {
                    mw2 mw2Var = this.b;
                    mw2Var.d.putInt(DnsModel.MSG_OK, mw2Var.f);
                    this.b.c();
                }
                mw2.h.remove(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements oq3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lw2.e b;

        public b(String str, lw2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar};
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
            this.b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                String string = bundle.getString("key_launch_app_id");
                int i = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.a, string)) {
                    if (i == 0) {
                        this.b.b();
                    } else {
                        this.b.a();
                    }
                }
                mw2.h.remove(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987009, "Lcom/baidu/tieba/mw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987009, "Lcom/baidu/tieba/mw2;");
                return;
            }
        }
        boolean z = fs1.a;
        h = new cq4();
    }

    public mw2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = -1;
        this.g = "";
    }

    public static void k(String str) {
        oq3<Bundle> oq3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && (oq3Var = h.get(str)) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            oq3Var.a(bundle);
        }
    }

    public static void l(String str) {
        oq3<Bundle> oq3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && (oq3Var = h.get(str)) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            oq3Var.a(bundle);
        }
    }

    @Override // com.baidu.tieba.v73
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("desAppId");
            h.put(string, new a(this, string));
        }
    }

    public static void j(String str, lw2.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, str, eVar) == null) && !TextUtils.isEmpty(str) && eVar != null) {
            h.put(str, new b(str, eVar));
        }
    }
}
