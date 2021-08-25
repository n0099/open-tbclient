package com.baidu.tieba.view.widget.mediaedit.listener;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.a4.l.c.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes7.dex */
public class DragMultiMediaItemCallback extends ItemTouchHelper.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f58431a;

    /* renamed from: b  reason: collision with root package name */
    public int f58432b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58433c;

    /* renamed from: d  reason: collision with root package name */
    public MultiMediaAdapter f58434d;

    /* renamed from: e  reason: collision with root package name */
    public a f58435e;

    public DragMultiMediaItemCallback(String str, String str2, MultiMediaAdapter multiMediaAdapter, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, multiMediaAdapter, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58433c = false;
        this.f58434d = multiMediaAdapter;
        this.f58435e = aVar;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, recyclerView, viewHolder, viewHolder2)) == null) {
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, viewHolder) == null) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setScaleX(1.0f);
            viewHolder.itemView.setScaleY(1.0f);
            MultiMediaAdapter multiMediaAdapter = this.f58434d;
            if (multiMediaAdapter != null) {
                multiMediaAdapter.setDragMode(false);
                this.f58434d.notifyDataChanged();
            }
            MultiMediaAdapter multiMediaAdapter2 = this.f58434d;
            if (multiMediaAdapter2 != null && this.f58431a != this.f58432b && this.f58433c) {
                this.f58433c = false;
                if (this.f58435e != null) {
                    multiMediaAdapter2.resetPlayIndex();
                    this.f58435e.onMutiItemPosChanged(this.f58431a, this.f58432b);
                }
            }
            a aVar = this.f58435e;
            if (aVar != null) {
                aVar.setDragMode(-1, 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, viewHolder)) == null) ? ItemTouchHelper.Callback.makeMovementFlags(15, 0) : invokeLL.intValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f58435e.isLongPress();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, recyclerView, viewHolder, viewHolder2)) == null) {
            this.f58433c = true;
            this.f58432b = viewHolder2.getAdapterPosition();
            Collections.swap(this.f58434d.getList(), viewHolder.getAdapterPosition(), this.f58432b);
            this.f58434d.notifyItemMoved(viewHolder.getAdapterPosition(), this.f58432b);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) {
            super.onSelectedChanged(viewHolder, i2);
            if (viewHolder == null) {
                return;
            }
            if (i2 != 0) {
                this.f58431a = viewHolder.getAdapterPosition();
            }
            viewHolder.itemView.setScaleX(1.1f);
            viewHolder.itemView.setScaleY(1.1f);
            int[] iArr = new int[2];
            viewHolder.itemView.getLocationOnScreen(iArr);
            viewHolder.itemView.getLocationInWindow(new int[2]);
            this.f58434d.setDragMode(true);
            a aVar = this.f58435e;
            if (aVar != null) {
                aVar.setDragMode(this.f58431a, iArr[0]);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i2) == null) {
        }
    }
}
