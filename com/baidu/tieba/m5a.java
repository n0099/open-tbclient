package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public final class m5a implements i3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<i3a> a;
    public volatile boolean b;

    public m5a() {
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

    @Override // com.baidu.tieba.i3a
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.i3a
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                List<i3a> list = this.a;
                this.a = null;
                c(list);
            }
        }
    }

    public m5a(i3a i3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i3aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        LinkedList linkedList = new LinkedList();
        this.a = linkedList;
        linkedList.add(i3aVar);
    }

    public static void c(Collection<i3a> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, collection) != null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (i3a i3aVar : collection) {
            try {
                i3aVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        n3a.d(arrayList);
    }

    public void a(i3a i3aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, i3aVar) != null) || i3aVar.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    List list = this.a;
                    if (list == null) {
                        list = new LinkedList();
                        this.a = list;
                    }
                    list.add(i3aVar);
                    return;
                }
            }
        }
        i3aVar.unsubscribe();
    }

    public m5a(i3a... i3aVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i3aVarArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new LinkedList(Arrays.asList(i3aVarArr));
    }

    public void b(i3a i3aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3aVar) == null) && !this.b) {
            synchronized (this) {
                List<i3a> list = this.a;
                if (!this.b && list != null) {
                    boolean remove = list.remove(i3aVar);
                    if (remove) {
                        i3aVar.unsubscribe();
                    }
                }
            }
        }
    }
}
