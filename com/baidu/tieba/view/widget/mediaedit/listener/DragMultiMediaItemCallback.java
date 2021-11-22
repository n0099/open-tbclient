package com.baidu.tieba.view.widget.mediaedit.listener;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.r0.d4.l.c.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes9.dex */
public class DragMultiMediaItemCallback extends ItemTouchHelper.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f56580a;

    /* renamed from: b  reason: collision with root package name */
    public int f56581b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56582c;

    /* renamed from: d  reason: collision with root package name */
    public MultiMediaAdapter f56583d;

    /* renamed from: e  reason: collision with root package name */
    public a f56584e;

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
        this.f56582c = false;
        this.f56583d = multiMediaAdapter;
        this.f56584e = aVar;
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
            MultiMediaAdapter multiMediaAdapter = this.f56583d;
            if (multiMediaAdapter != null) {
                multiMediaAdapter.setDragMode(false);
                this.f56583d.notifyDataChanged();
            }
            MultiMediaAdapter multiMediaAdapter2 = this.f56583d;
            if (multiMediaAdapter2 != null && this.f56580a != this.f56581b && this.f56582c) {
                this.f56582c = false;
                if (this.f56584e != null) {
                    multiMediaAdapter2.resetPlayIndex();
                    this.f56584e.onMutiItemPosChanged(this.f56580a, this.f56581b);
                }
            }
            a aVar = this.f56584e;
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
            this.f56584e.isLongPress();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, recyclerView, viewHolder, viewHolder2)) == null) {
            this.f56582c = true;
            this.f56581b = viewHolder2.getAdapterPosition();
            Collections.swap(this.f56583d.getList(), viewHolder.getAdapterPosition(), this.f56581b);
            this.f56583d.notifyItemMoved(viewHolder.getAdapterPosition(), this.f56581b);
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
                this.f56580a = viewHolder.getAdapterPosition();
            }
            viewHolder.itemView.setScaleX(1.1f);
            viewHolder.itemView.setScaleY(1.1f);
            int[] iArr = new int[2];
            viewHolder.itemView.getLocationOnScreen(iArr);
            viewHolder.itemView.getLocationInWindow(new int[2]);
            this.f56583d.setDragMode(true);
            a aVar = this.f56584e;
            if (aVar != null) {
                aVar.setDragMode(this.f56580a, iArr[0]);
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
