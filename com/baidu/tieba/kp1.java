package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.dp1;
import com.baidu.tieba.p43;
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
/* loaded from: classes4.dex */
public class kp1 extends dp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements dp1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp1 a;

        public a(kp1 kp1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kp1Var;
        }

        @Override // com.baidu.tieba.dp1.a
        public at1 a(a13 a13Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, a13Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (!TextUtils.isEmpty(optString)) {
                    this.a.D(a13Var, optString, str);
                    return new at1(0);
                }
                ay1.c("PreLoadSubPackageApi", "subPackage root is null");
                return new at1(202);
            }
            return (at1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dp1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp1 a;

        public b(kp1 kp1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kp1Var;
        }

        @Override // com.baidu.tieba.dp1.a
        public at1 a(a13 a13Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, a13Var, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.a.B(a13Var, str, optJSONArray);
                    return new at1(0);
                }
                return new at1(202);
            }
            return (at1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a13 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ kp1 d;

        /* loaded from: classes4.dex */
        public class a implements p43.e {
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

            @Override // com.baidu.tieba.p43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.countDown();
                    this.b.add(this.c);
                }
            }

            @Override // com.baidu.tieba.p43.e
            public void b(int i, tc3 tc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                    this.a.countDown();
                    ay1.o("PreLoadSubPackageApi", "downloadSubPackage fail, code=" + i);
                }
            }
        }

        public c(kp1 kp1Var, a13 a13Var, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp1Var, a13Var, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kp1Var;
            this.a = a13Var;
            this.b = str;
            this.c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String k0 = this.a.k0();
                if (!TextUtils.isDigitsOnly(k0)) {
                    kp1 kp1Var = this.d;
                    String str = this.b;
                    kp1Var.d(str, new at1(202, "current version error:" + k0));
                    return;
                }
                List<y94> k = v84.i().k(this.a.b, Integer.parseInt(k0));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i = 0; i < this.c.length(); i++) {
                    String optString = this.c.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        if (kp1.E(optString, k) && this.a.u0(optString)) {
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
                            a13 a13Var = this.a;
                            p43.l(a13Var.b, a13Var.k0(), "1", str2, R, null, new a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e) {
                        ay1.d("PreLoadSubPackageApi", "loadSubPackages", e);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < this.c.length(); i2++) {
                    try {
                        jSONObject.put(this.c.optString(i2), synchronizedList.contains(this.c.optString(i2)) ? 0 : 1001);
                    } catch (Exception unused) {
                    }
                }
                this.d.d(this.b, new at1(0, jSONObject));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a13 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kp1 d;

        public d(kp1 kp1Var, a13 a13Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp1Var, a13Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kp1Var;
            this.a = a13Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.v0(this.b) && this.a.u0(this.b)) {
                    ay1.i("PreLoadSubPackageApi", "subPackage have existed");
                    this.d.d(this.c, new at1(1001, "subPackage have existed"));
                    return;
                }
                String R = this.a.R(this.b);
                if (!TextUtils.isEmpty(R)) {
                    this.d.C(this.a, this.b, R, this.c);
                    return;
                }
                ay1.i("PreLoadSubPackageApi", "subPackage cannot find aps key");
                this.d.d(this.c, new at1(202));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements p43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kp1 b;

        public e(kp1 kp1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kp1Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.p43.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ay1.i("PreLoadSubPackageApi", "preload subPackage success");
                this.b.d(this.a, new at1(0, "preload subPackage success"));
            }
        }

        @Override // com.baidu.tieba.p43.e
        public void b(int i, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                ay1.c("PreLoadSubPackageApi", "preload subPackage failed");
                this.b.d(this.a, new at1(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kp1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean E(@Nullable String str, @Nullable List<y94> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (y94 y94Var : list) {
                    if (y94Var != null && TextUtils.equals(y94Var.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(a13 a13Var, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, a13Var, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, a13Var, str, jSONArray), "PreLoadSubPackageApi", 2);
        }
    }

    public final void C(a13 a13Var, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a13Var, str, str2, str3) == null) {
            p43.l(a13Var.b, a13Var.k0(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void D(a13 a13Var, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, a13Var, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, a13Var, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public at1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#loadSubPackage", false);
            return l(str, true, new a(this));
        }
        return (at1) invokeL.objValue;
    }

    public at1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#loadSubPackages", false);
            return l(str, true, new b(this));
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Basic" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PreLoadSubPackageApi" : (String) invokeV.objValue;
    }
}
