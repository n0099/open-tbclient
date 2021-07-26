package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class DragSortCursorAdapter extends CursorAdapter implements DragSortListView.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REMOVED = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f27120a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f27121b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSortCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cursor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Cursor) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27120a = new SparseIntArray();
        this.f27121b = new ArrayList<>();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f27120a.clear();
            this.f27121b.clear();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ArrayList arrayList = new ArrayList();
            int size = this.f27120a.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f27120a.keyAt(i2) == this.f27120a.valueAt(i2)) {
                    arrayList.add(Integer.valueOf(this.f27120a.keyAt(i2)));
                }
            }
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f27120a.delete(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
            super.changeCursor(cursor);
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.b
    public void drag(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.h
    public void drop(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        int i4 = this.f27120a.get(i2, i2);
        if (i2 > i3) {
            while (i2 > i3) {
                SparseIntArray sparseIntArray = this.f27120a;
                int i5 = i2 - 1;
                sparseIntArray.put(i2, sparseIntArray.get(i5, i5));
                i2--;
            }
        } else {
            while (i2 < i3) {
                SparseIntArray sparseIntArray2 = this.f27120a;
                int i6 = i2 + 1;
                sparseIntArray2.put(i2, sparseIntArray2.get(i6, i6));
                i2 = i6;
            }
        }
        this.f27120a.put(i3, i4);
        b();
        notifyDataSetChanged();
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.getCount() - this.f27121b.size() : invokeV.intValue;
    }

    public int getCursorPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f27120a.get(i2, i2) : invokeI.intValue;
    }

    public ArrayList<Integer> getCursorPositions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < getCount(); i2++) {
                arrayList.add(Integer.valueOf(this.f27120a.get(i2, i2)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) ? super.getDropDownView(this.f27120a.get(i2, i2), view, viewGroup) : (View) invokeILL.objValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? super.getItem(this.f27120a.get(i2, i2)) : invokeI.objValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? super.getItemId(this.f27120a.get(i2, i2)) : invokeI.longValue;
    }

    public int getListPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f27121b.contains(Integer.valueOf(i2))) {
                return -1;
            }
            int indexOfValue = this.f27120a.indexOfValue(i2);
            return indexOfValue < 0 ? i2 : this.f27120a.keyAt(indexOfValue);
        }
        return invokeI.intValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) ? super.getView(this.f27120a.get(i2, i2), view, viewGroup) : (View) invokeILL.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.m
    public void remove(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = this.f27120a.get(i2, i2);
            if (!this.f27121b.contains(Integer.valueOf(i3))) {
                this.f27121b.add(Integer.valueOf(i3));
            }
            int count = getCount();
            while (i2 < count) {
                SparseIntArray sparseIntArray = this.f27120a;
                int i4 = i2 + 1;
                sparseIntArray.put(i2, sparseIntArray.get(i4, i4));
                i2 = i4;
            }
            this.f27120a.delete(count);
            b();
            notifyDataSetChanged();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            a();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cursor)) == null) {
            Cursor swapCursor = super.swapCursor(cursor);
            a();
            return swapCursor;
        }
        return (Cursor) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSortCursorAdapter(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cursor, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Cursor) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27120a = new SparseIntArray();
        this.f27121b = new ArrayList<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSortCursorAdapter(Context context, Cursor cursor, int i2) {
        super(context, cursor, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cursor, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Cursor) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27120a = new SparseIntArray();
        this.f27121b = new ArrayList<>();
    }
}
