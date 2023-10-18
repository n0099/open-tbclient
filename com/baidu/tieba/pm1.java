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
/* loaded from: classes7.dex */
public class pm1 implements lm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public wu3 c;
    public mm1 d;
    public fu3 e;
    public List<km1> f;
    public km1 g;
    public km1 h;
    public Map<String, String> i;
    public vu3 j;

    /* loaded from: classes7.dex */
    public class a implements vu3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm1 a;

        @Override // com.baidu.tieba.vu3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(pm1 pm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm1Var;
        }

        @Override // com.baidu.tieba.vu3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(om1.b(str));
                yu3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.vu3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (km1 km1Var : this.a.f) {
                        km1Var.a(0);
                        if (this.a.f.contains(km1Var)) {
                            this.a.f.remove(km1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (km1 km1Var2 : this.a.f) {
                    km1Var2.a(1001);
                    if (this.a.f.contains(km1Var2)) {
                        this.a.f.remove(km1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.vu3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.baidu.tieba.vu3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(om1.a(z));
            }
        }
    }

    public pm1(@NonNull JSONObject jSONObject, mm1 mm1Var, km1 km1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, mm1Var, km1Var};
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
            this.i = yu3.a("video", "app", optString, this.a, false);
            this.e = new qm1();
            wu3 wu3Var = new wu3(cr2.V().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = wu3Var;
            wu3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, km1Var, mm1Var);
            return;
        }
        km1Var.a(202);
    }

    @Override // com.baidu.tieba.lm1
    public synchronized void a(JSONObject jSONObject, km1 km1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, km1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = km1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.lm1
    public synchronized void b(JSONObject jSONObject, km1 km1Var, mm1 mm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, km1Var, mm1Var) == null) {
            synchronized (this) {
                this.d = mm1Var;
                if (this.c != null) {
                    this.g = km1Var;
                    if (km1Var != null && !this.f.contains(km1Var)) {
                        this.f.add(km1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
