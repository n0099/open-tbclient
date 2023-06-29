package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.f02;
import com.baidu.tieba.rf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m02 extends f02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Basic" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PreLoadSubPackageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ m02 d;

        /* loaded from: classes6.dex */
        public class a implements rf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountDownLatch a;
            public final /* synthetic */ List b;
            public final /* synthetic */ String c;

            public a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, countDownLatch, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = countDownLatch;
                this.b = list;
                this.c = str;
            }

            @Override // com.baidu.tieba.rf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.countDown();
                    this.b.add(this.c);
                }
            }

            @Override // com.baidu.tieba.rf3.e
            public void b(int i, vn3 vn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                    this.a.countDown();
                    c92.o("PreLoadSubPackageApi", "downloadSubPackage fail, code=" + i);
                }
            }
        }

        public c(m02 m02Var, cc3 cc3Var, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m02Var, cc3Var, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = m02Var;
            this.a = cc3Var;
            this.b = str;
            this.c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String k0 = this.a.k0();
                if (!TextUtils.isDigitsOnly(k0)) {
                    m02 m02Var = this.d;
                    String str = this.b;
                    m02Var.d(str, new c42(202, "current version error:" + k0));
                    return;
                }
                List<cl4> k = zj4.i().k(this.a.b, Integer.parseInt(k0));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.c.length(); i2++) {
                    String optString = this.c.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (m02.E(optString, k) && this.a.u0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String R = this.a.R(str2);
                        if (TextUtils.isEmpty(R)) {
                            countDownLatch.countDown();
                        } else {
                            cc3 cc3Var = this.a;
                            rf3.l(cc3Var.b, cc3Var.k0(), "1", str2, R, null, new a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e) {
                        c92.d("PreLoadSubPackageApi", "loadSubPackages", e);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.c.length(); i3++) {
                    try {
                        String optString2 = this.c.optString(i3);
                        if (synchronizedList.contains(this.c.optString(i3))) {
                            i = 0;
                        } else {
                            i = 1001;
                        }
                        jSONObject.put(optString2, i);
                    } catch (Exception unused) {
                    }
                }
                this.d.d(this.b, new c42(0, jSONObject));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m02 a;

        public a(m02 m02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m02Var;
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (TextUtils.isEmpty(optString)) {
                    c92.c("PreLoadSubPackageApi", "subPackage root is null");
                    return new c42(202);
                }
                this.a.D(cc3Var, optString, str);
                return new c42(0);
            }
            return (c42) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m02 a;

        public b(m02 m02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m02Var;
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    return new c42(202);
                }
                this.a.B(cc3Var, str, optJSONArray);
                return new c42(0);
            }
            return (c42) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ m02 d;

        public d(m02 m02Var, cc3 cc3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m02Var, cc3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = m02Var;
            this.a = cc3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.v0(this.b) && this.a.u0(this.b)) {
                    c92.i("PreLoadSubPackageApi", "subPackage have existed");
                    this.d.d(this.c, new c42(1001, "subPackage have existed"));
                    return;
                }
                String R = this.a.R(this.b);
                if (!TextUtils.isEmpty(R)) {
                    this.d.C(this.a, this.b, R, this.c);
                    return;
                }
                c92.i("PreLoadSubPackageApi", "subPackage cannot find aps key");
                this.d.d(this.c, new c42(202));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements rf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ m02 b;

        public e(m02 m02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m02Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.rf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c92.i("PreLoadSubPackageApi", "preload subPackage success");
                this.b.d(this.a, new c42(0, "preload subPackage success"));
            }
        }

        @Override // com.baidu.tieba.rf3.e
        public void b(int i, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                c92.c("PreLoadSubPackageApi", "preload subPackage failed");
                this.b.d(this.a, new c42(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m02(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean E(@Nullable String str, @Nullable List<cl4> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (cl4 cl4Var : list) {
                    if (cl4Var != null && TextUtils.equals(cl4Var.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void C(cc3 cc3Var, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cc3Var, str, str2, str3) == null) {
            rf3.l(cc3Var.b, cc3Var.k0(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void B(cc3 cc3Var, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cc3Var, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, cc3Var, str, jSONArray), "PreLoadSubPackageApi", 2);
        }
    }

    public final void D(cc3 cc3Var, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cc3Var, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, cc3Var, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public c42 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#loadSubPackage", false);
            return l(str, true, new a(this));
        }
        return (c42) invokeL.objValue;
    }

    public c42 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#loadSubPackages", false);
            return l(str, true, new b(this));
        }
        return (c42) invokeL.objValue;
    }
}
