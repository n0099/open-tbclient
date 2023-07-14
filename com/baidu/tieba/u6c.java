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
public final class u6c implements b2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<b2c> a;
    public volatile boolean b;

    public u6c() {
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
                    Set<b2c> set = this.a;
                    this.a = null;
                    e(set);
                }
            }
        }
    }

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                Set<b2c> set = this.a;
                this.a = null;
                e(set);
            }
        }
    }

    public static void e(Collection<b2c> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, collection) != null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (b2c b2cVar : collection) {
            try {
                b2cVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        g2c.d(arrayList);
    }

    public void a(b2c b2cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, b2cVar) != null) || b2cVar.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add(b2cVar);
                    return;
                }
            }
        }
        b2cVar.unsubscribe();
    }

    public void b(b2c... b2cVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2cVarArr) == null) {
            int i = 0;
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new HashSet(b2cVarArr.length);
                        }
                        int length = b2cVarArr.length;
                        while (i < length) {
                            b2c b2cVar = b2cVarArr[i];
                            if (!b2cVar.isUnsubscribed()) {
                                this.a.add(b2cVar);
                            }
                            i++;
                        }
                        return;
                    }
                }
            }
            int length2 = b2cVarArr.length;
            while (i < length2) {
                b2cVarArr[i].unsubscribe();
                i++;
            }
        }
    }

    public void d(b2c b2cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, b2cVar) == null) && !this.b) {
            synchronized (this) {
                if (!this.b && this.a != null) {
                    boolean remove = this.a.remove(b2cVar);
                    if (remove) {
                        b2cVar.unsubscribe();
                    }
                }
            }
        }
    }
}
