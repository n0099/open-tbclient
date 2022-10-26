package com.baidu.tieba;

import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class tc2 implements uc2, lc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zb2 a;
    public bl1 b;
    public volatile lc2[] c;
    public sc2 d;

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc2 a;

        public a(tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public tc2(sc2 sc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new zb2();
        this.b = um2.m();
        this.c = new lc2[]{new pc2(), new nc2(), new mc2(), new oc2()};
        this.d = sc2Var;
    }

    @Override // com.baidu.tieba.lc2
    public synchronized ArraySet a() {
        InterceptResult invokeV;
        ArraySet arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                m02.k("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet();
                for (lc2 lc2Var : this.c) {
                    arraySet.addAll(lc2Var.a());
                }
                m02.k("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uc2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gg3.k(new a(this), "performRecovery");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c03 e = c03.e();
            e03 e03Var = new e03(132);
            e03Var.d();
            e.h(e03Var);
        }
    }

    public void c(ArraySet arraySet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) && arraySet != null && !arraySet.isEmpty()) {
            m02.k("RecoveryPolicy", "deleteFiles start");
            Iterator it = arraySet.iterator();
            while (it.hasNext()) {
                qj4.k((String) it.next());
            }
            m02.k("RecoveryPolicy", "deleteFiles end");
        }
    }

    public void f(Collection collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, collection) == null) && collection != null && !collection.isEmpty()) {
            m02.k("RecoveryPolicy", "resetAccredit appIds=" + collection);
            this.a.g(new ArrayList(collection));
        }
    }
}
