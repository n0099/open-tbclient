package com.baidu.tieba;

import androidx.annotation.NonNull;
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
/* loaded from: classes6.dex */
public class kk2 implements lk2, ck2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qj2 a;
    public ss1 b;
    public volatile ck2[] c;
    public jk2 d;

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk2 a;

        public a(kk2 kk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public kk2(@NonNull jk2 jk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jk2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new qj2();
        this.b = lu2.m();
        this.c = new ck2[]{new gk2(), new ek2(), new dk2(), new fk2()};
        this.d = jk2Var;
    }

    @Override // com.baidu.tieba.ck2
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                d82.k("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (ck2 ck2Var : this.c) {
                    arraySet.addAll((ArraySet<? extends String>) ck2Var.a());
                }
                d82.k("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lk2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xn3.k(new a(this), "performRecovery");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            t73 e = t73.e();
            v73 v73Var = new v73(132);
            v73Var.d();
            e.h(v73Var);
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) && arraySet != null && !arraySet.isEmpty()) {
            d82.k("RecoveryPolicy", "deleteFiles start");
            Iterator<String> it = arraySet.iterator();
            while (it.hasNext()) {
                hr4.k(it.next());
            }
            d82.k("RecoveryPolicy", "deleteFiles end");
        }
    }

    public void f(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, collection) == null) && collection != null && !collection.isEmpty()) {
            d82.k("RecoveryPolicy", "resetAccredit appIds=" + collection);
            this.a.g(new ArrayList(collection));
        }
    }
}
