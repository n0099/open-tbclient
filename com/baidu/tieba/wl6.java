package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class wl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public PbListView c;
    public vl6 d;
    public yl6 e;
    public kc8 f;
    public RelativeLayout g;
    public on6 h;
    public boolean i;
    public tj6 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl6 a;

        public a(wl6 wl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl6 a;

        public b(wl6 wl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b != null) {
                    this.a.b.stopScroll();
                }
                if (this.a.c != null && this.a.a != null) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.b.setNextPage(this.a.c);
                        this.a.c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                        this.a.c.C(null);
                        if (this.a.i) {
                            this.a.c.O();
                            this.a.c.C(null);
                            this.a.a.M1();
                            return;
                        }
                        this.a.c.D(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
                        this.a.c.f();
                        this.a.c.C(null);
                        return;
                    }
                    this.a.b.setNextPage(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ wl6 b;

        public c(wl6 wl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.f != null) {
                    this.b.f.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, true);
                }
                s36.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;
        public final /* synthetic */ wl6 b;

        public d(wl6 wl6Var, FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl6Var, frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl6Var;
            this.a = frsCommonTabFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            FrsCommonTabFragment frsCommonTabFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.b.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
                    this.b.f.k(view2);
                    this.b.f.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), false, true);
                }
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f09002d);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.k();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f09002b);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.p();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        }
    }

    public wl6(FrsCommonTabFragment frsCommonTabFragment, View view2, FrsViewData frsViewData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, view2, frsViewData};
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
        this.m = new b(this);
        this.n = new c(this);
        if (frsCommonTabFragment != null && view2 != null) {
            this.a = frsCommonTabFragment;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090b2a);
            this.b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            this.b.setOnSrollToBottomListener(this.m);
            this.b.addOnScrollListener(this.n);
            this.b.setRecyclerListener(new d(this, frsCommonTabFragment));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.b;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.b.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.c = pbListView;
            pbListView.b();
            this.c.p(R.color.transparent);
            this.c.t(xi.g(this.a.getActivity(), R.dimen.tbds182));
            this.c.y();
            this.c.H(R.dimen.tbfontsize33);
            this.c.F(SkinManager.getColor(R.color.CAM_X0107));
            this.c.B(R.color.CAM_X0110);
            this.c.s();
            FrsCommonTabFragment frsCommonTabFragment2 = this.a;
            BdTypeRecyclerView bdTypeRecyclerView3 = this.b;
            if (frsCommonTabFragment2.h == 16) {
                z = true;
            } else {
                z = false;
            }
            this.d = new vl6(frsCommonTabFragment2, bdTypeRecyclerView3, frsViewData, z);
            x(false);
            if (this.f == null) {
                this.f = new kc8(this.a.getPageContext(), this.b);
            }
            this.f.p(2);
            this.f.u(this.a.getUniqueId());
            if (g()) {
                this.g = new RelativeLayout(this.a.getContext());
                this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.h = new on6(this.a, this.g);
                this.b.t(this.g, 0);
                this.h.i(h());
            }
            FrsCommonTabFragment frsCommonTabFragment3 = this.a;
            if (frsCommonTabFragment3.h == 16) {
                tj6 tj6Var = new tj6(frsCommonTabFragment3);
                this.j = tj6Var;
                this.b.t(tj6Var.a(), 0);
                this.j.c(this.k);
            }
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (bdTypeRecyclerView = this.b) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdTypeRecyclerView.setVisibility(i);
        }
    }

    public void w(boolean z) {
        vl6 vl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (vl6Var = this.d) != null) {
            vl6Var.j(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || this.a == null) {
            return;
        }
        ej6 ej6Var = new ej6();
        ej6Var.a = this.a.g;
        ej6Var.b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ej6Var));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (bdTypeRecyclerView = this.b) != null) {
            bdTypeRecyclerView.setSelection(i);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment != null) {
                if (frsCommonTabFragment.j == 1 || frsCommonTabFragment.h == 16) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public kc8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (kc8) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            kc8 kc8Var = this.f;
            if (kc8Var != null) {
                kc8Var.h();
            }
            vl6 vl6Var = this.d;
            if (vl6Var != null) {
                vl6Var.g();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setRecyclerListener(null);
            }
        }
    }

    public void p() {
        kc8 kc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (kc8Var = this.f) != null) {
            kc8Var.z();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ej6 ej6Var = new ej6();
            ej6Var.a = this.a.g;
            ej6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ej6Var));
        }
    }

    public void s() {
        kc8 kc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (kc8Var = this.f) != null) {
            kc8Var.o();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.scrollToPosition(0);
        }
    }

    public final List<FrsTabInfo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 2;
            builder.tab_type = Integer.valueOf(this.a.h);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.a.h);
            FrsTabInfo build2 = builder2.build(true);
            arrayList.add(build);
            arrayList.add(build2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean k(ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || i < 0) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int i2 = 1;
            for (int i3 = 1; i3 < arrayList.size() && i2 <= i; i3++) {
                if (arrayList.get(i3) instanceof vu4) {
                    int i4 = i3 - 1;
                    if ((arrayList.get(i4) instanceof vu4) && ((vu4) arrayList.get(i3)).position == ((vu4) arrayList.get(i4)).position) {
                    }
                }
                i2++;
            }
            if (i2 <= i) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            vl6 vl6Var = this.d;
            if (vl6Var != null) {
                vl6Var.f();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.c.d(i);
            }
            on6 on6Var = this.h;
            if (on6Var != null) {
                on6Var.h();
            }
            tj6 tj6Var = this.j;
            if (tj6Var != null) {
                tj6Var.b();
            }
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.b.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            if (!this.i) {
                this.m.onScrollToBottom();
            }
        }
    }

    public void m(String str) {
        yl6 yl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !StringUtils.isNull(str) && (yl6Var = this.e) != null && !ListUtils.isEmpty(yl6Var.c)) {
            Iterator<wn> it = this.e.c.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                ThreadData threadData = null;
                if (next instanceof vu4) {
                    threadData = ((vu4) next).t;
                } else if (next instanceof ThreadData) {
                    threadData = (ThreadData) next;
                }
                if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                    it.remove();
                }
            }
            if (ListUtils.isEmpty(this.e.c)) {
                this.e.c.add(new cj6());
            }
            this.d.i(this.e.c);
            this.d.f();
        }
    }

    public void o(yl6 yl6Var) {
        tj6 tj6Var;
        on6 on6Var;
        FrsCommonTabFragment frsCommonTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yl6Var) != null) || yl6Var == null) {
            return;
        }
        this.i = yl6Var.a;
        if (ListUtils.isEmpty(yl6Var.c)) {
            cj6 cj6Var = new cj6();
            ArrayList<wn> arrayList = new ArrayList<>();
            yl6Var.c = arrayList;
            arrayList.add(cj6Var);
            yl6Var.a = false;
        }
        this.e = yl6Var;
        this.c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.b.setNextPage(this.c);
            if (k(yl6Var.c, 3)) {
                this.c.C(null);
                this.c.N();
            } else {
                this.c.N();
                this.c.C(this.l);
                this.c.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a17));
            }
        } else {
            this.b.setNextPage(null);
            this.c.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
            this.c.C(null);
            this.c.f();
        }
        this.d.i(yl6Var.c);
        this.d.f();
        if (this.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
            this.f.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
        if (this.a != null && g() && (on6Var = this.h) != null) {
            on6Var.g(this.a.K1());
            this.h.j(this.a.e);
        }
        this.k = yl6Var.j;
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        if (frsCommonTabFragment2 != null && (frsCommonTabFragment2.getFragmentActivity() instanceof xj6)) {
            ((xj6) this.a.getFragmentActivity()).K0(this.k);
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3 != null && frsCommonTabFragment3.h == 16 && (tj6Var = this.j) != null) {
            tj6Var.c(this.k);
        }
    }
}
