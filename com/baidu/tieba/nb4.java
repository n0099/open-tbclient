package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jb4;
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
/* loaded from: classes7.dex */
public class nb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jb4> a;
    public String b;
    public String c;
    public int d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb4 a;
        public final /* synthetic */ nb4 b;

        public a(nb4 nb4Var, lb4 lb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb4Var, lb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nb4Var;
            this.a = lb4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<long[]> e = this.b.e();
                mb4 mb4Var = new mb4();
                mb4Var.a = this.b.b;
                mb4Var.b = e;
                mb4Var.c = this.b.c;
                y74.i().b(mb4Var, this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996681, "Lcom/baidu/tieba/nb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996681, "Lcom/baidu/tieba/nb4;");
                return;
            }
        }
        e = rr1.a;
    }

    public nb4(ArrayList<kb4> arrayList, String str, String str2) {
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
        ArrayList<jb4> d = d(arrayList);
        this.a = d;
        this.b = str;
        this.c = str2;
        this.d = d.size();
    }

    public void c(lb4 lb4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, lb4Var) != null) || lb4Var == null) {
            return;
        }
        bo3.l(new a(this, lb4Var), "clipVideo");
    }

    public final ArrayList<jb4> d(ArrayList<kb4> arrayList) {
        InterceptResult invokeL;
        jb4 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ArrayList<jb4> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<kb4> it = arrayList.iterator();
                while (it.hasNext()) {
                    kb4 next = it.next();
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
            Collections.sort(this.a, new jb4.a());
            jb4 jb4Var = this.a.get(0);
            for (int i = 1; i < this.d; i++) {
                jb4 jb4Var2 = this.a.get(i);
                if (!jb4Var.b(jb4Var2)) {
                    arrayList.add(jb4.a(jb4Var));
                    jb4Var = jb4Var2;
                }
            }
            arrayList.add(jb4.a(jb4Var));
            if (e) {
                Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
