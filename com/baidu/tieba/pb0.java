package com.baidu.tieba;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public final class pb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pools.Pool a;
    public final SimpleArrayMap b;
    public final ArrayList c;
    public final HashSet d;

    public pb0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Pools.SimplePool(10);
        this.b = new SimpleArrayMap();
        this.c = new ArrayList();
        this.d = new HashSet();
    }

    public ArrayList i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.c.clear();
            this.d.clear();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                e(this.b.keyAt(i), this.c, this.d);
            }
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void a(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, obj, obj2) == null) && this.b.containsKey(obj) && this.b.containsKey(obj2)) {
            ArrayList arrayList = (ArrayList) this.b.get(obj);
            if (arrayList == null) {
                arrayList = f();
                this.b.put(obj, arrayList);
            }
            arrayList.add(obj2);
        }
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && !this.b.containsKey(obj)) {
            this.b.put(obj, null);
        }
    }

    public boolean d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            return this.b.containsKey(obj);
        }
        return invokeL.booleanValue;
    }

    public List g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            return (List) this.b.get(obj);
        }
        return (List) invokeL.objValue;
    }

    public boolean j(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ArrayList arrayList = (ArrayList) this.b.valueAt(i);
                if (arrayList != null && arrayList.contains(obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            arrayList.clear();
            this.a.release(arrayList);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ArrayList arrayList = (ArrayList) this.b.valueAt(i);
                if (arrayList != null) {
                    k(arrayList);
                }
            }
            this.b.clear();
        }
    }

    public final ArrayList f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = (ArrayList) this.a.acquire();
            if (arrayList == null) {
                return new ArrayList();
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, obj, arrayList, hashSet) != null) || arrayList.contains(obj) || hashSet.contains(obj)) {
            return;
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public List h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            int size = this.b.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                ArrayList arrayList2 = (ArrayList) this.b.valueAt(i);
                if (arrayList2 != null && arrayList2.contains(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.b.keyAt(i));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
