package com.baidu.tieba;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class mn extends BaseAdapter implements wn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ListAdapter b;
    public ArrayList<c> c;
    public ArrayList<c> d;
    public boolean e;
    public DataSetObserver f;
    public DataSetObserver g;
    public b h;

    /* loaded from: classes6.dex */
    public interface b {
        void onPreLoad();
    }

    /* loaded from: classes6.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn a;

        public a(mn mnVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mnVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mnVar;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
                if (this.a.f != null) {
                    this.a.f.onChanged();
                }
                if (this.a.h != null) {
                    this.a.h.onPreLoad();
                }
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onInvalidated();
                if (this.a.f != null) {
                    this.a.f.onInvalidated();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public Object b;
        public boolean c;

        public c(mn mnVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mnVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public mn(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        boolean z = false;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = context;
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        if (i(this.c) && i(this.d)) {
            z = true;
        }
        this.e = z;
        this.g = new a(this);
    }

    public void c(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            d(view2, null, true, -1);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int n = n();
            ListAdapter listAdapter = this.b;
            if (listAdapter != null && i >= n && (i2 = i - n) < listAdapter.getCount()) {
                return this.b.getItemId(i2);
            }
            return Long.MIN_VALUE;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            int n = n();
            ListAdapter listAdapter = this.b;
            if (listAdapter != null && i >= n && (i2 = i - n) < listAdapter.getCount()) {
                return this.b.getItemViewType(i2);
            }
            return -2;
        }
        return invokeI.intValue;
    }

    public final boolean i(ArrayList<c> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().c) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.b;
            this.b = listAdapter;
            if (listAdapter != null) {
                boolean z = listAdapter instanceof Filterable;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dataSetObserver) == null) {
            super.registerDataSetObserver(dataSetObserver);
            this.f = dataSetObserver;
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.g);
            }
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.h = bVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dataSetObserver) == null) {
            super.unregisterDataSetObserver(dataSetObserver);
            this.f = dataSetObserver;
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(this.g);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                if (this.e && listAdapter.areAllItemsEnabled()) {
                    return true;
                }
                return false;
            }
            return super.areAllItemsEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter, com.baidu.tieba.wn
    public int getCount() {
        InterceptResult invokeV;
        int l;
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b != null) {
                l = l() + n();
                n = this.b.getCount();
            } else {
                l = l();
                n = n();
            }
            return l + n;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ListAdapter listAdapter = this.b;
            if (listAdapter == null) {
                return 1;
            }
            return listAdapter.getViewTypeCount() + 1;
        }
        return invokeV.intValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return super.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null && !listAdapter.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.d.size();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.d.size();
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, com.baidu.tieba.wn
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || !vi.E()) {
            return;
        }
        super.notifyDataSetChanged();
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void d(View view2, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, obj, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || view2 == null) {
            return;
        }
        c cVar = new c(this);
        cVar.a = view2;
        cVar.b = obj;
        cVar.c = z;
        if (i >= 0 && i <= this.d.size()) {
            this.d.add(i, cVar);
        } else {
            this.d.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void f(View view2, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{view2, obj, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || view2 == null) {
            return;
        }
        c cVar = new c(this);
        cVar.a = view2;
        cVar.b = obj;
        cVar.c = z;
        if (i >= 0 && i <= this.c.size()) {
            this.c.add(i, cVar);
        } else {
            this.c.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void e(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            f(view2, null, true, i);
        }
    }

    @Override // android.widget.Adapter, com.baidu.tieba.wn
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            int n = n();
            if (i < n) {
                return this.c.get(i).b;
            }
            int i2 = i - n;
            int i3 = 0;
            ListAdapter listAdapter = this.b;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.b.getItem(i2);
            }
            int i4 = i2 - i3;
            if (i4 >= 0 && i4 < this.d.size()) {
                return this.d.get(i4).b;
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            int n = n();
            if (i < n) {
                return this.c.get(i).c;
            }
            int i3 = i - n;
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                i2 = listAdapter.getCount();
                if (i3 < i2) {
                    return this.b.isEnabled(i3);
                }
            } else {
                i2 = 0;
            }
            int i4 = i3 - i2;
            if (i4 < 0 || i4 >= this.d.size()) {
                return false;
            }
            return this.d.get(i4).c;
        }
        return invokeI.booleanValue;
    }

    public boolean p(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view2)) == null) {
            boolean z = false;
            if (view2 == null) {
                return false;
            }
            for (int i = 0; i < this.d.size(); i++) {
                if (this.d.get(i).a == view2) {
                    this.d.remove(i);
                    if (i(this.c) && i(this.d)) {
                        z = true;
                    }
                    this.e = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean q(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view2)) == null) {
            boolean z = false;
            if (view2 == null) {
                return false;
            }
            for (int i = 0; i < this.c.size(); i++) {
                if (this.c.get(i).a == view2) {
                    this.c.remove(i);
                    if (i(this.c) && i(this.d)) {
                        z = true;
                    }
                    this.e = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            int n = n();
            if (i < n) {
                View view3 = this.c.get(i).a;
                if (view3 == null) {
                    return j();
                }
                return view3;
            }
            int i2 = i - n;
            int i3 = 0;
            ListAdapter listAdapter = this.b;
            View view4 = null;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                try {
                    view4 = this.b.getView(i2, view2, viewGroup);
                } catch (Exception e) {
                    if (e.getMessage() != null) {
                        BdLog.detailException(e);
                        Log.e("BdListAdapter", e.getMessage());
                        e.printStackTrace();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                    view4 = this.b.getView(i2, view2, viewGroup);
                }
                if (view4 == null) {
                    return j();
                }
                return view4;
            }
            try {
                view4 = this.d.get(i2 - i3).a;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            if (view4 == null) {
                return j();
            }
            return view4;
        }
        return (View) invokeILL.objValue;
    }

    public final View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TextView textView = new TextView(this.a);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0bcd));
            int d = vi.d(this.a, 15.0f);
            textView.setPadding(d, d, d, d);
            return textView;
        }
        return (View) invokeV.objValue;
    }
}
