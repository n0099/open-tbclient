package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class jd3 extends kd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ jd3 b;

        public a(jd3 jd3Var, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jd3Var;
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.m(this.a);
                this.b.j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd3(fd3 fd3Var) {
        super(fd3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fd3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fd3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kd3
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b.a()) {
            return;
        }
        long j = 0;
        if (kd3.f) {
            j = System.currentTimeMillis();
        }
        this.a.g(new a(this, this.b.n()));
        if (kd3.f) {
            Log.d("SwanCookieSyncPolicy", "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - j));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g) {
            return;
        }
        long j = 0;
        if (kd3.f) {
            j = System.currentTimeMillis();
        }
        this.a.b();
        this.g = true;
        if (kd3.f) {
            Log.d("SwanCookieSyncPolicy", "clearExpiredCookies costTime:" + (System.currentTimeMillis() - j));
        }
    }

    public void l() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (kd3.f) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            this.a.h();
            if (kd3.f) {
                Log.d("SwanCookieSyncPolicy", "preInitDatabase costTime:" + (System.currentTimeMillis() - j));
            }
        }
    }

    public ArrayList<ed3> k(String str) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (kd3.f) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            ArrayList<ed3> arrayList = new ArrayList<>();
            try {
                arrayList = this.a.e(str);
            } catch (Exception e) {
                j12.k("SwanCookieSyncPolicy", Log.getStackTraceString(e));
            }
            if (kd3.f) {
                Log.d("SwanCookieSyncPolicy", "getCookiesForDomain costTime:" + (System.currentTimeMillis() - j));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void m(ArrayList<ed3> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            if (kd3.f) {
                Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash start");
            }
            Iterator<ed3> it = arrayList.iterator();
            while (it.hasNext()) {
                ed3 next = it.next();
                if (next != null) {
                    if (kd3.f) {
                        Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash result cookie:" + next.toString());
                    }
                    int i = next.i;
                    if (i != 0) {
                        if (i != 2) {
                            if (i == 3) {
                                this.a.d(next.a, next.b, next.c);
                                this.a.a(next);
                                this.b.y(next);
                            }
                        } else {
                            this.a.d(next.a, next.b, next.c);
                            this.b.g(next);
                        }
                    } else {
                        this.a.a(next);
                        this.b.y(next);
                    }
                }
            }
        }
    }
}
