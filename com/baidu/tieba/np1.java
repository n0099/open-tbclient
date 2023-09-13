package com.baidu.tieba;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tieba.zo1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i == 1) {
                return 2010;
            }
            if (i == 2) {
                return IMConstants.IM_MSG_TYPE_SHIELD;
            }
            if (i == 3) {
                return 2012;
            }
            if (i == 4) {
                return 2013;
            }
            if (i == 5) {
                return 2014;
            }
            return i == 6 ? 2015 : 2009;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo1.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;

        /* renamed from: com.baidu.tieba.np1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0417a extends lq1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zo1.a b;
            public final /* synthetic */ a c;

            public C0417a(a aVar, zo1.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.b = aVar2;
            }

            @Override // com.baidu.tieba.lq1
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.onFinish(this.c.b);
                }
            }
        }

        public a(zo1.a aVar, String str, int i, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
            this.c = i;
            this.d = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zo1.a aVar = this.a;
                if (aVar != null) {
                    aVar.onFinish(this.b);
                }
                if (this.c == 1 && this.d != null) {
                    for (int i = 0; i < this.d.size(); i++) {
                        zo1.a aVar2 = (zo1.a) this.d.get(i);
                        if (aVar2 != null) {
                            nq1.c().b(new C0417a(this, aVar2));
                        }
                    }
                }
            }
        }
    }

    public static void b(zo1.a aVar, kp1 kp1Var, int i, ArrayList<zo1.a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, kp1Var, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) && kp1Var != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", kp1Var.a);
                jSONObject.put("1", kp1Var.b);
                jSONObject.put("2", String.valueOf(kp1Var.c));
                jSONObject.put("3", kp1Var.d);
                String jSONObject2 = jSONObject.toString();
                if (i == 1) {
                    if (z) {
                        fp1.j().f(false);
                    }
                } else if (i == 2) {
                    if (z) {
                        fp1.j().c(false);
                    }
                } else if (i == 3) {
                    if (z) {
                        fp1.j().k(false);
                    }
                } else if (z) {
                    fp1.j().n(false);
                }
                new Thread(new a(aVar, jSONObject2, i, arrayList)).start();
            } catch (Throwable th) {
                qq1.d(th);
            }
        }
    }
}
