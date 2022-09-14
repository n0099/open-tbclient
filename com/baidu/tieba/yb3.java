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
/* loaded from: classes6.dex */
public final class yb3 extends zb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ yb3 b;

        public a(yb3 yb3Var, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb3Var, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yb3Var;
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
    public yb3(ub3 ub3Var) {
        super(ub3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ub3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ub3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.zb3
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a()) {
            long currentTimeMillis = zb3.f ? System.currentTimeMillis() : 0L;
            this.a.g(new a(this, this.b.n()));
            if (zb3.f) {
                Log.d("SwanCookieSyncPolicy", "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.g) {
            return;
        }
        long currentTimeMillis = zb3.f ? System.currentTimeMillis() : 0L;
        this.a.b();
        this.g = true;
        if (zb3.f) {
            Log.d("SwanCookieSyncPolicy", "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public ArrayList<tb3> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long currentTimeMillis = zb3.f ? System.currentTimeMillis() : 0L;
            ArrayList<tb3> arrayList = new ArrayList<>();
            try {
                arrayList = this.a.e(str);
            } catch (Exception e) {
                yz1.k("SwanCookieSyncPolicy", Log.getStackTraceString(e));
            }
            if (zb3.f) {
                Log.d("SwanCookieSyncPolicy", "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = zb3.f ? System.currentTimeMillis() : 0L;
            this.a.h();
            if (zb3.f) {
                Log.d("SwanCookieSyncPolicy", "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void m(ArrayList<tb3> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (zb3.f) {
            Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash start");
        }
        Iterator<tb3> it = arrayList.iterator();
        while (it.hasNext()) {
            tb3 next = it.next();
            if (next != null) {
                if (zb3.f) {
                    Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash result cookie:" + next.toString());
                }
                int i = next.i;
                if (i == 0) {
                    this.a.a(next);
                    this.b.y(next);
                } else if (i == 2) {
                    this.a.d(next.a, next.b, next.c);
                    this.b.g(next);
                } else if (i == 3) {
                    this.a.d(next.a, next.b, next.c);
                    this.a.a(next);
                    this.b.y(next);
                }
            }
        }
    }
}
