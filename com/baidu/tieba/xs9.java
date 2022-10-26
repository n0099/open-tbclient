package com.baidu.tieba;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_ListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class xs9 implements WrapperListAdapter, Filterable {
    public static /* synthetic */ Interceptable $ic;
    public static final ArrayList f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ListAdapter a;
    public ArrayList b;
    public ArrayList c;
    public boolean d;
    public final boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311083, "Lcom/baidu/tieba/xs9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311083, "Lcom/baidu/tieba/xs9;");
                return;
            }
        }
        f = new ArrayList();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ListAdapter listAdapter = this.a;
            if (listAdapter == null) {
                return true;
            }
            if (this.d && listAdapter.areAllItemsEnabled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int b;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a != null) {
                b = b() + c();
                c = this.a.getCount();
            } else {
                b = b();
                c = c();
            }
            return b + c;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e) {
                return ((Filterable) this.a).getFilter();
            }
            return null;
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.a;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.a;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && !listAdapter.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public xs9(ArrayList arrayList, ArrayList arrayList2, ListAdapter listAdapter) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, arrayList2, listAdapter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = listAdapter;
        this.e = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.b = f;
        } else {
            this.b = arrayList;
        }
        if (arrayList2 == null) {
            this.c = f;
        } else {
            this.c = arrayList2;
        }
        if (a(this.b) && a(this.c)) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
    }

    public final boolean a(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((PLA_ListView.a) it.next()).c) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int c = c();
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i >= c && (i2 = i - c) < listAdapter.getCount()) {
                return this.a.getItemId(i2);
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int c = c();
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i >= c && (i2 = i - c) < listAdapter.getCount()) {
                return this.a.getItemViewType(i2);
            }
            return -2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, dataSetObserver) == null) && (listAdapter = this.a) != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, dataSetObserver) == null) && (listAdapter = this.a) != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            boolean z = false;
            for (int i = 0; i < this.c.size(); i++) {
                if (((PLA_ListView.a) this.c.get(i)).a == view2) {
                    this.c.remove(i);
                    if (a(this.b) && a(this.c)) {
                        z = true;
                    }
                    this.d = z;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            boolean z = false;
            for (int i = 0; i < this.b.size(); i++) {
                if (((PLA_ListView.a) this.b.get(i)).a == view2) {
                    this.b.remove(i);
                    if (a(this.b) && a(this.c)) {
                        z = true;
                    }
                    this.d = z;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            int c = c();
            if (i < c) {
                return ((PLA_ListView.a) this.b.get(i)).b;
            }
            int i2 = i - c;
            int i3 = 0;
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.a.getItem(i2);
            }
            return ((PLA_ListView.a) this.c.get(i2 - i3)).b;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            int c = c();
            if (i < c) {
                return ((PLA_ListView.a) this.b.get(i)).c;
            }
            int i2 = i - c;
            int i3 = 0;
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.a.isEnabled(i2);
            }
            return ((PLA_ListView.a) this.c.get(i2 - i3)).c;
        }
        return invokeI.booleanValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            int c = c();
            if (i < c) {
                return ((PLA_ListView.a) this.b.get(i)).a;
            }
            int i2 = i - c;
            int i3 = 0;
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.a.getView(i2, view2, viewGroup);
            }
            return ((PLA_ListView.a) this.c.get(i2 - i3)).a;
        }
        return (View) invokeILL.objValue;
    }
}
