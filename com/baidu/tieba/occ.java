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
/* loaded from: classes7.dex */
public final class occ implements u7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<u7c> a;
    public volatile boolean b;

    public occ() {
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
                    Set<u7c> set = this.a;
                    this.a = null;
                    e(set);
                }
            }
        }
    }

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                Set<u7c> set = this.a;
                this.a = null;
                e(set);
            }
        }
    }

    public static void e(Collection<u7c> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, collection) != null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (u7c u7cVar : collection) {
            try {
                u7cVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        z7c.d(arrayList);
    }

    public void a(u7c u7cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, u7cVar) != null) || u7cVar.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add(u7cVar);
                    return;
                }
            }
        }
        u7cVar.unsubscribe();
    }

    public void b(u7c... u7cVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u7cVarArr) == null) {
            int i = 0;
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new HashSet(u7cVarArr.length);
                        }
                        int length = u7cVarArr.length;
                        while (i < length) {
                            u7c u7cVar = u7cVarArr[i];
                            if (!u7cVar.isUnsubscribed()) {
                                this.a.add(u7cVar);
                            }
                            i++;
                        }
                        return;
                    }
                }
            }
            int length2 = u7cVarArr.length;
            while (i < length2) {
                u7cVarArr[i].unsubscribe();
                i++;
            }
        }
    }

    public void d(u7c u7cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, u7cVar) == null) && !this.b) {
            synchronized (this) {
                if (!this.b && this.a != null) {
                    boolean remove = this.a.remove(u7cVar);
                    if (remove) {
                        u7cVar.unsubscribe();
                    }
                }
            }
        }
    }
}
