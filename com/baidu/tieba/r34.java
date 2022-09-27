package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n34;
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
public class r34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<n34> a;
    public String b;
    public String c;
    public int d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p34 a;
        public final /* synthetic */ r34 b;

        public a(r34 r34Var, p34 p34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r34Var, p34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r34Var;
            this.a = p34Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e = this.b.e();
                q34 q34Var = new q34();
                q34Var.a = this.b.b;
                q34Var.b = e;
                q34Var.c = this.b.c;
                c04.i().b(q34Var, this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070678, "Lcom/baidu/tieba/r34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070678, "Lcom/baidu/tieba/r34;");
                return;
            }
        }
        e = vj1.a;
    }

    public r34(ArrayList<o34> arrayList, String str, String str2) {
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
        ArrayList<n34> d = d(arrayList);
        this.a = d;
        this.b = str;
        this.c = str2;
        this.d = d.size();
    }

    public void c(p34 p34Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, p34Var) == null) || p34Var == null) {
            return;
        }
        fg3.l(new a(this, p34Var), "clipVideo");
    }

    public final ArrayList<n34> d(ArrayList<o34> arrayList) {
        InterceptResult invokeL;
        n34 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<n34> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<o34> it = arrayList.iterator();
                while (it.hasNext()) {
                    o34 next = it.next();
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
            Collections.sort(this.a, new n34.a());
            n34 n34Var = this.a.get(0);
            for (int i = 1; i < this.d; i++) {
                n34 n34Var2 = this.a.get(i);
                if (!n34Var.b(n34Var2)) {
                    arrayList.add(n34.a(n34Var));
                    n34Var = n34Var2;
                }
            }
            arrayList.add(n34.a(n34Var));
            if (e) {
                Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
