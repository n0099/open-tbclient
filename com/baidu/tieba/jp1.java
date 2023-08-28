package com.baidu.tieba;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tieba.vo1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jp1 {
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

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo1.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;

        /* renamed from: com.baidu.tieba.jp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0364a extends hq1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vo1.a b;
            public final /* synthetic */ a c;

            public C0364a(a aVar, vo1.a aVar2) {
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

            @Override // com.baidu.tieba.hq1
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.onFinish(this.c.b);
                }
            }
        }

        public a(vo1.a aVar, String str, int i, ArrayList arrayList) {
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
                vo1.a aVar = this.a;
                if (aVar != null) {
                    aVar.onFinish(this.b);
                }
                if (this.c == 1 && this.d != null) {
                    for (int i = 0; i < this.d.size(); i++) {
                        vo1.a aVar2 = (vo1.a) this.d.get(i);
                        if (aVar2 != null) {
                            jq1.c().b(new C0364a(this, aVar2));
                        }
                    }
                }
            }
        }
    }

    public static void b(vo1.a aVar, gp1 gp1Var, int i, ArrayList<vo1.a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, gp1Var, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) && gp1Var != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", gp1Var.a);
                jSONObject.put("1", gp1Var.b);
                jSONObject.put("2", String.valueOf(gp1Var.c));
                jSONObject.put("3", gp1Var.d);
                String jSONObject2 = jSONObject.toString();
                if (i == 1) {
                    if (z) {
                        bp1.j().f(false);
                    }
                } else if (i == 2) {
                    if (z) {
                        bp1.j().c(false);
                    }
                } else if (i == 3) {
                    if (z) {
                        bp1.j().k(false);
                    }
                } else if (z) {
                    bp1.j().n(false);
                }
                new Thread(new a(aVar, jSONObject2, i, arrayList)).start();
            } catch (Throwable th) {
                mq1.d(th);
            }
        }
    }
}
