package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.InterceptRecyclerView;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.TagGridLayoutManager;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.TagAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class kp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public TagAdapter b;
    public np8 c;

    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;

        public a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                super.getItemOffsets(rect, view2, recyclerView, state);
                int i = this.a;
                rect.set(i / 2, this.b, i / 2, 0);
            }
        }
    }

    public kp8(Context context, RecyclerView recyclerView, np8 np8Var, op8 op8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, np8Var, op8Var, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null && recyclerView != null && np8Var != null && op8Var != null) {
            this.a = recyclerView;
            if ((recyclerView instanceof InterceptRecyclerView) && recyclerView.getItemAnimator() != null) {
                recyclerView.getItemAnimator().setChangeDuration(0L);
                recyclerView.getItemAnimator().setAddDuration(0L);
                ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
            }
            TagAdapter tagAdapter = new TagAdapter(op8Var, np8Var, context);
            this.b = tagAdapter;
            tagAdapter.setHasStableIds(true);
            this.a.setAdapter(this.b);
            this.c = np8Var;
            if (i2 == 1) {
                ip8 ip8Var = new ip8(recyclerView, i);
                TagGridLayoutManager tagGridLayoutManager = new TagGridLayoutManager(context, this.a, ip8Var.b());
                tagGridLayoutManager.setSpanSizeLookup(ip8Var);
                this.a.setLayoutManager(tagGridLayoutManager);
                this.a.addItemDecoration(new a(i, i));
                return;
            }
            this.a.addItemDecoration(new a(i, 0));
            this.a.setLayoutManager(new LinearLayoutManager(context, 0, false));
            return;
        }
        throw new IllegalArgumentException("入参不能为null");
    }

    public lp8 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.c.d(i);
        }
        return (lp8) invokeI.objValue;
    }

    public void c(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.c.g(list);
        }
    }

    public void d(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.h(list);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c.i(i);
        }
    }

    public void g(mp8 mp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mp8Var) == null) {
            this.c.k(mp8Var);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c.m(i);
        }
    }

    public List<lp8> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.f();
        }
        return (List) invokeV.objValue;
    }

    public void f(ml8 ml8Var, ll8 ll8Var) {
        TagAdapter tagAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, ml8Var, ll8Var) == null) && (tagAdapter = this.b) != null) {
            tagAdapter.q(ml8Var, ll8Var);
        }
    }
}
