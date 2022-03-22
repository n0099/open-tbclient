package com.baidu.tieba.view.widget.mediaedit.listener;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.q4.n.c.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes6.dex */
public class DragMultiMediaItemCallback extends ItemTouchHelper.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f37183b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37184c;

    /* renamed from: d  reason: collision with root package name */
    public MultiMediaAdapter f37185d;

    /* renamed from: e  reason: collision with root package name */
    public a f37186e;

    public DragMultiMediaItemCallback(String str, String str2, MultiMediaAdapter multiMediaAdapter, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, multiMediaAdapter, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37184c = false;
        this.f37185d = multiMediaAdapter;
        this.f37186e = aVar;
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
            MultiMediaAdapter multiMediaAdapter = this.f37185d;
            if (multiMediaAdapter != null) {
                multiMediaAdapter.h(false);
                this.f37185d.f();
            }
            MultiMediaAdapter multiMediaAdapter2 = this.f37185d;
            if (multiMediaAdapter2 != null && this.a != this.f37183b && this.f37184c) {
                this.f37184c = false;
                if (this.f37186e != null) {
                    multiMediaAdapter2.g();
                    this.f37186e.c(this.a, this.f37183b);
                }
            }
            a aVar = this.f37186e;
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
            this.f37186e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, recyclerView, viewHolder, viewHolder2)) == null) {
            this.f37184c = true;
            this.f37183b = viewHolder2.getAdapterPosition();
            Collections.swap(this.f37185d.d(), viewHolder.getAdapterPosition(), this.f37183b);
            this.f37185d.notifyItemMoved(viewHolder.getAdapterPosition(), this.f37183b);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) {
            super.onSelectedChanged(viewHolder, i);
            if (viewHolder == null) {
                return;
            }
            if (i != 0) {
                this.a = viewHolder.getAdapterPosition();
            }
            viewHolder.itemView.setScaleX(1.1f);
            viewHolder.itemView.setScaleY(1.1f);
            int[] iArr = new int[2];
            viewHolder.itemView.getLocationOnScreen(iArr);
            viewHolder.itemView.getLocationInWindow(new int[2]);
            this.f37185d.h(true);
            a aVar = this.f37186e;
            if (aVar != null) {
                aVar.setDragMode(this.a, iArr[0]);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) {
        }
    }
}
