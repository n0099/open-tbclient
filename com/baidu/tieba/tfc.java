package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class tfc implements zac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<zac> a;
    public volatile boolean b;

    public tfc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.b) {
            synchronized (this) {
                if (!this.b && this.a != null) {
                    Set<zac> set = this.a;
                    this.a = null;
                    e(set);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                Set<zac> set = this.a;
                this.a = null;
                e(set);
            }
        }
    }

    public static void e(Collection<zac> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, collection) != null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (zac zacVar : collection) {
            try {
                zacVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        ebc.d(arrayList);
    }

    public void a(zac zacVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zacVar) != null) || zacVar.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add(zacVar);
                    return;
                }
            }
        }
        zacVar.unsubscribe();
    }

    public void b(zac... zacVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zacVarArr) == null) {
            int i = 0;
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new HashSet(zacVarArr.length);
                        }
                        int length = zacVarArr.length;
                        while (i < length) {
                            zac zacVar = zacVarArr[i];
                            if (!zacVar.isUnsubscribed()) {
                                this.a.add(zacVar);
                            }
                            i++;
                        }
                        return;
                    }
                }
            }
            int length2 = zacVarArr.length;
            while (i < length2) {
                zacVarArr[i].unsubscribe();
                i++;
            }
        }
    }

    public void d(zac zacVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, zacVar) == null) && !this.b) {
            synchronized (this) {
                if (!this.b && this.a != null) {
                    boolean remove = this.a.remove(zacVar);
                    if (remove) {
                        zacVar.unsubscribe();
                    }
                }
            }
        }
    }
}
