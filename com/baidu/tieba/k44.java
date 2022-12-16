package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g44;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class k44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<g44> a;
    public String b;
    public String c;
    public int d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i44 a;
        public final /* synthetic */ k44 b;

        public a(k44 k44Var, i44 i44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k44Var, i44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k44Var;
            this.a = i44Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e = this.b.e();
                j44 j44Var = new j44();
                j44Var.a = this.b.b;
                j44Var.b = e;
                j44Var.c = this.b.c;
                v04.i().b(j44Var, this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863102, "Lcom/baidu/tieba/k44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863102, "Lcom/baidu/tieba/k44;");
                return;
            }
        }
        e = ok1.a;
    }

    public k44(ArrayList<h44> arrayList, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<g44> d = d(arrayList);
        this.a = d;
        this.b = str;
        this.c = str2;
        this.d = d.size();
    }

    public void c(i44 i44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, i44Var) != null) || i44Var == null) {
            return;
        }
        yg3.l(new a(this, i44Var), "clipVideo");
    }

    public final ArrayList<g44> d(ArrayList<h44> arrayList) {
        InterceptResult invokeL;
        g44 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<g44> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<h44> it = arrayList.iterator();
                while (it.hasNext()) {
                    h44 next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        arrayList2.add(a2);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public ArrayList<long[]> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<long[]> arrayList = new ArrayList<>();
            if (this.d == 0) {
                return arrayList;
            }
            if (e) {
                Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.a);
            }
            Collections.sort(this.a, new g44.a());
            g44 g44Var = this.a.get(0);
            for (int i = 1; i < this.d; i++) {
                g44 g44Var2 = this.a.get(i);
                if (!g44Var.b(g44Var2)) {
                    arrayList.add(g44.a(g44Var));
                    g44Var = g44Var2;
                }
            }
            arrayList.add(g44.a(g44Var));
            if (e) {
                Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
