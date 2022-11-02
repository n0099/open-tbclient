package com.baidu.tieba;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.forumSquare.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class sh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public RelativeLayout b;
    public ca5 c;
    public RecyclerView d;
    public LinearLayoutManager e;
    public LeftAdapter f;
    public BdTypeRecyclerView g;
    public LinearLayoutManager h;
    public PbListView i;
    public oh6 j;
    public BdListView.p k;
    public BdListView.p l;
    public final View m;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh6 a;

        public a(sh6 sh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sh6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g != null) {
                    this.a.g.stopScroll();
                }
                if (this.a.k != null) {
                    this.a.k.onScrollToBottom();
                }
            }
        }
    }

    public sh6(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = tbPageContext;
        this.m = view2;
        h();
        g();
    }

    public void n(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048587, this, i, i2) != null) || (bdTypeRecyclerView = this.g) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i > this.g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.g.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void p(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            q(list, 0);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.d.setVisibility(i);
            this.g.setVisibility(i);
        }
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) && (leftAdapter = this.f) != null) {
            leftAdapter.k(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) && (bdTypeRecyclerView = this.g) != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.k = pVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g.setVisibility(i);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || str == null) {
            return;
        }
        int f = this.f.f(str);
        this.f.l(f);
        z(f);
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.g.getFirstVisiblePosition();
            int i = 0;
            View childAt = this.g.getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
        }
        return (Pair) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f091c7c);
            this.d = (RecyclerView) this.m.findViewById(R.id.obfuscated_res_0x7f091ce4);
            this.g = (BdTypeRecyclerView) this.m.findViewById(R.id.obfuscated_res_0x7f091ce6);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.g.setNextPage(this.i);
            this.i.j();
            this.i.b().setPadding(0, 0, 0, 0);
            this.i.D(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0e1c));
            this.i.f();
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f.g();
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setNextPage(null);
        }
    }

    public void f() {
        ca5 ca5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ca5Var = this.c) != null) {
            ca5Var.dettachView(this.b);
            this.c = null;
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ca5 ca5Var = this.c;
            if (ca5Var != null) {
                return ca5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g.setNextPage(this.i);
            this.i.j();
            this.i.b().setPadding(0, 0, 0, 0);
            this.i.O();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            fo foVar = new fo();
            foVar.a = this.a.getString(R.string.obfuscated_res_0x7f0f06e1);
            foVar.b = R.drawable.new_pic_emotion_06;
            arrayList.add(foVar);
            this.j.c(arrayList);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getPageActivity());
            this.e = linearLayoutManager;
            this.d.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.a.getPageActivity());
            this.f = leftAdapter;
            this.d.setAdapter(leftAdapter);
            this.j = new oh6(this.a, this.g);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.a.getPageActivity());
            this.h = linearLayoutManager2;
            this.g.setLayoutManager(linearLayoutManager2);
            this.g.setFadingEdgeLength(0);
            this.g.setOverScrollMode(2);
            this.g.setOnSrollToBottomListener(this.l);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.i = pbListView;
            pbListView.b();
            this.i.p(R.color.CAM_X0205);
            this.i.t(xi.g(this.a.getPageActivity(), R.dimen.tbds182));
            this.i.y();
            this.i.H(R.dimen.tbfontsize33);
            this.i.F(SkinManager.getColor(R.color.CAM_X0107));
            this.i.B(R.color.CAM_X0110);
            this.i.s();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.setNextPage(this.i);
            this.i.j();
            this.i.b().setPadding(0, xi.g(this.a.getPageActivity(), R.dimen.tbds62), 0, xi.g(this.a.getPageActivity(), R.dimen.tbds362));
            this.i.D(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06e0));
            this.i.f();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            oh6 oh6Var = this.j;
            if (oh6Var != null) {
                oh6Var.b();
            }
            LeftAdapter leftAdapter = this.f;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.i.d(i);
            }
            ca5 ca5Var = this.c;
            if (ca5Var != null) {
                ca5Var.onChangeSkinType();
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048598, this, z) != null) || i()) {
            return;
        }
        if (this.c == null) {
            ca5 ca5Var = new ca5(this.a.getPageActivity());
            this.c = ca5Var;
            ca5Var.s(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028e));
        }
        this.c.onChangeSkinType();
        this.c.attachView(this.b, z);
    }

    public final void z(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && (recyclerView = this.d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.f.getItemCount() - 1) {
                i = this.f.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void o(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.f.j(position, list);
            if (z) {
                z(position);
            }
        }
    }

    public void q(List<wn> list, int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                r();
                return;
            }
            if (i > 0) {
                Pair<Integer, Integer> c = c();
                int intValue = ((Integer) c.first).intValue();
                int intValue2 = ((Integer) c.second).intValue();
                int i2 = intValue - i;
                if (this.h != null && (bdTypeRecyclerView = this.g) != null) {
                    bdTypeRecyclerView.z();
                    this.h.scrollToPositionWithOffset(i2, intValue2);
                    this.g.A();
                }
            }
            this.j.c(list);
        }
    }
}
