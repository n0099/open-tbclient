package com.baidu.tieba;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.lz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleDragSortListView a;
    public final a b;
    public final lz5 c;

    /* loaded from: classes6.dex */
    public static class a extends mz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int F;
        public int G;
        public ListView H;

        @Override // com.baidu.tieba.pz5, com.baidu.tieba.lz5.j
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lz5 lz5Var, ListView listView) {
            super(lz5Var, listView, 0, 2, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz5Var, listView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((lz5) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = 0;
            this.G = Integer.MAX_VALUE;
            r(false);
            this.H = listView;
        }

        @Override // com.baidu.tieba.mz5, com.baidu.tieba.lz5.j
        public void c(View view2, Point point, Point point2) {
            View view3;
            int top;
            int top2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, point, point2) == null) {
                int firstVisiblePosition = this.H.getFirstVisiblePosition();
                int dividerHeight = this.H.getDividerHeight();
                int headerViewsCount = (this.F - firstVisiblePosition) + this.H.getHeaderViewsCount();
                int headerViewsCount2 = (this.G - firstVisiblePosition) + this.H.getHeaderViewsCount();
                int childCount = this.H.getChildCount();
                View view4 = null;
                if (headerViewsCount >= 0 && headerViewsCount < childCount) {
                    view3 = this.H.getChildAt(headerViewsCount);
                } else {
                    view3 = null;
                }
                if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                    view4 = this.H.getChildAt(headerViewsCount2);
                }
                if (view3 != null && point.y < (top2 = view3.getTop())) {
                    point.y = top2;
                }
                if (view4 != null && point.y > (top = (view4.getTop() - dividerHeight) - view2.getHeight())) {
                    point.y = top;
                }
            }
        }

        @Override // com.baidu.tieba.mz5
        public int v(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                int n = super.n(motionEvent);
                int headerViewsCount = n - this.H.getHeaderViewsCount();
                if (headerViewsCount >= this.F && headerViewsCount < this.G) {
                    return n;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        public void y(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                this.F = i;
                this.G = i2;
            }
        }
    }

    public kg9(SimpleDragSortListView simpleDragSortListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleDragSortListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = simpleDragSortListView;
        lz5 lz5Var = new lz5(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.c = lz5Var;
        simpleDragSortListView.setDragSortViewEventDelegate(lz5Var);
        a aVar = new a(this.c, simpleDragSortListView);
        this.b = aVar;
        aVar.d(-1);
        this.c.t0(this.b);
        this.c.v0(this.b);
        simpleDragSortListView.setOnTouchListener(this.b);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.c.p0(z);
        }
    }

    public void c(lz5.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.c.u0(iVar);
        }
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.b.y(i, i2);
        }
    }
}
