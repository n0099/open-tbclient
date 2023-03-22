package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class so1 implements oo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ax3 c;
    public po1 d;
    public jw3 e;
    public List<no1> f;
    public no1 g;
    public no1 h;
    public Map<String, String> i;
    public zw3 j;

    /* loaded from: classes6.dex */
    public class a implements zw3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so1 a;

        @Override // com.baidu.tieba.zw3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(so1 so1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = so1Var;
        }

        @Override // com.baidu.tieba.zw3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(ro1.b(str));
                cx3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.zw3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (no1 no1Var : this.a.f) {
                        no1Var.a(0);
                        if (this.a.f.contains(no1Var)) {
                            this.a.f.remove(no1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (no1 no1Var2 : this.a.f) {
                    no1Var2.a(1001);
                    if (this.a.f.contains(no1Var2)) {
                        this.a.f.remove(no1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.zw3
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.baidu.tieba.zw3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(ro1.a(z));
            }
        }
    }

    public so1(@NonNull JSONObject jSONObject, po1 po1Var, no1 no1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, po1Var, no1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.b = optString;
            this.i = cx3.a("video", "app", optString, this.a, false);
            this.e = new to1();
            ax3 ax3Var = new ax3(gt2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = ax3Var;
            ax3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, no1Var, po1Var);
            return;
        }
        no1Var.a(202);
    }

    @Override // com.baidu.tieba.oo1
    public synchronized void a(JSONObject jSONObject, no1 no1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, no1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = no1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.oo1
    public synchronized void b(JSONObject jSONObject, no1 no1Var, po1 po1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, no1Var, po1Var) == null) {
            synchronized (this) {
                this.d = po1Var;
                if (this.c != null) {
                    this.g = no1Var;
                    if (no1Var != null && !this.f.contains(no1Var)) {
                        this.f.add(no1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
