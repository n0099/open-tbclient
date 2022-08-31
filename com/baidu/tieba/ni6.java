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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes5.dex */
public class ni6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public PbListView c;
    public mi6 d;
    public pi6 e;
    public u88 f;
    public RelativeLayout g;
    public ek6 h;
    public boolean i;
    public yf6 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ni6 a;

        public a(ni6 ni6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ni6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ni6 a;

        public b(ni6 ni6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ni6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b != null) {
                    this.a.b.stopScroll();
                }
                if (this.a.c == null || this.a.a == null) {
                    return;
                }
                if (pi.z()) {
                    this.a.b.setNextPage(this.a.c);
                    this.a.c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.c.B(null);
                    if (this.a.i) {
                        this.a.c.N();
                        this.a.c.B(null);
                        this.a.a.L1();
                        return;
                    }
                    this.a.c.C(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                    this.a.c.f();
                    this.a.c.B(null);
                    return;
                }
                this.a.b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ni6 b;

        public c(ni6 ni6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ni6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.f != null) {
                    this.b.f.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, true);
                }
                a06.b().e(true);
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

    /* loaded from: classes5.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;
        public final /* synthetic */ ni6 b;

        public d(ni6 ni6Var, FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni6Var, frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ni6Var;
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

    public ni6(FrsCommonTabFragment frsCommonTabFragment, View view2, FrsViewData frsViewData) {
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
        if (frsCommonTabFragment == null || view2 == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090af5);
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
        this.c.t(ri.f(this.a.getActivity(), R.dimen.tbds182));
        this.c.x();
        this.c.G(R.dimen.tbfontsize33);
        this.c.E(SkinManager.getColor(R.color.CAM_X0107));
        this.c.A(R.color.CAM_X0110);
        this.c.s();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.d = new mi6(frsCommonTabFragment2, this.b, frsViewData, frsCommonTabFragment2.h == 16);
        x(false);
        if (this.f == null) {
            this.f = new u88(this.a.getPageContext(), this.b);
        }
        this.f.p(2);
        this.f.u(this.a.getUniqueId());
        if (g()) {
            this.g = new RelativeLayout(this.a.getContext());
            this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.h = new ek6(this.a, this.g);
            this.b.t(this.g, 0);
            this.h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.h == 16) {
            yf6 yf6Var = new yf6(frsCommonTabFragment3);
            this.j = yf6Var;
            this.b.t(yf6Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment != null) {
                return frsCommonTabFragment.j == 1 || frsCommonTabFragment.h == 16;
            }
            return false;
        }
        return invokeV.booleanValue;
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

    public u88 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (u88) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || i < 0) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int i3 = 1;
            while (i2 < arrayList.size() && i3 <= i) {
                if (arrayList.get(i2) instanceof jr4) {
                    int i4 = i2 - 1;
                    i2 = ((arrayList.get(i4) instanceof jr4) && ((jr4) arrayList.get(i2)).position == ((jr4) arrayList.get(i4)).position) ? i2 + 1 : 1;
                }
                i3++;
            }
            return i3 > i;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i) {
        mi6 mi6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (!UbsABTestHelper.isFeedVideoImmersionTransition() && (mi6Var = this.d) != null) {
                mi6Var.f();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.c.d(i);
            }
            ek6 ek6Var = this.h;
            if (ek6Var != null) {
                ek6Var.h();
            }
            yf6 yf6Var = this.j;
            if (yf6Var != null) {
                yf6Var.b();
            }
        }
    }

    public void m(String str) {
        pi6 pi6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (pi6Var = this.e) == null || ListUtils.isEmpty(pi6Var.c)) {
            return;
        }
        Iterator<pn> it = this.e.c.iterator();
        while (it.hasNext()) {
            pn next = it.next();
            ThreadData threadData = null;
            if (next instanceof jr4) {
                threadData = ((jr4) next).t;
            } else if (next instanceof ThreadData) {
                threadData = (ThreadData) next;
            }
            if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.e.c)) {
            this.e.c.add(new if6());
        }
        this.d.i(this.e.c);
        this.d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            u88 u88Var = this.f;
            if (u88Var != null) {
                u88Var.h();
            }
            mi6 mi6Var = this.d;
            if (mi6Var != null) {
                mi6Var.g();
            }
        }
    }

    public void o(pi6 pi6Var) {
        yf6 yf6Var;
        ek6 ek6Var;
        FrsCommonTabFragment frsCommonTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pi6Var) == null) || pi6Var == null) {
            return;
        }
        this.i = pi6Var.a;
        if (ListUtils.isEmpty(pi6Var.c)) {
            if6 if6Var = new if6();
            ArrayList<pn> arrayList = new ArrayList<>();
            pi6Var.c = arrayList;
            arrayList.add(if6Var);
            pi6Var.a = false;
        }
        this.e = pi6Var;
        this.c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.b.setNextPage(this.c);
            if (k(pi6Var.c, 3)) {
                this.c.B(null);
                this.c.M();
            } else {
                this.c.M();
                this.c.B(this.l);
                this.c.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09eb));
            }
        } else {
            this.b.setNextPage(null);
            this.c.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
            this.c.B(null);
            this.c.f();
        }
        this.d.i(pi6Var.c);
        this.d.f();
        if (this.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
            this.f.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
        if (this.a != null && g() && (ek6Var = this.h) != null) {
            ek6Var.g(this.a.J1());
            this.h.j(this.a.e);
        }
        this.k = pi6Var.j;
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        if (frsCommonTabFragment2 != null && (frsCommonTabFragment2.getFragmentActivity() instanceof cg6)) {
            ((cg6) this.a.getFragmentActivity()).B0(this.k);
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3 == null || frsCommonTabFragment3.h != 16 || (yf6Var = this.j) == null) {
            return;
        }
        yf6Var.c(this.k);
    }

    public void p() {
        u88 u88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (u88Var = this.f) == null) {
            return;
        }
        u88Var.y();
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
            jf6 jf6Var = new jf6();
            jf6Var.a = this.a.g;
            jf6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, jf6Var));
        }
    }

    public void s() {
        u88 u88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (u88Var = this.f) == null) {
            return;
        }
        u88Var.o();
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.b.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            if (this.i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        mi6 mi6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (mi6Var = this.d) == null) {
            return;
        }
        mi6Var.j(z);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.a == null) {
            return;
        }
        jf6 jf6Var = new jf6();
        jf6Var.a = this.a.g;
        jf6Var.b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, jf6Var));
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
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i);
    }
}
