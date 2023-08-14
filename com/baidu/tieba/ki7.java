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
import com.baidu.adp.lib.util.BdUtilHelper;
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
public class ki7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public PbListView c;
    public ji7 d;
    public mi7 e;
    public jt9 f;
    public RelativeLayout g;
    public fk7 h;
    public boolean i;
    public gg7 j;
    public ItemInfo k;
    public int l;
    public View.OnClickListener m;
    public BdListView.p n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki7 a;

        public a(ki7 ki7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ki7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki7 a;

        public b(ki7 ki7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ki7Var;
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
                        this.a.c.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                        this.a.c.G(null);
                        if (this.a.i) {
                            this.a.c.R();
                            this.a.c.G(null);
                            this.a.a.c2();
                            return;
                        }
                        this.a.c.H(this.a.a.getResources().getString(R.string.list_has_no_more));
                        this.a.c.g();
                        this.a.c.G(null);
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
        public final /* synthetic */ ki7 b;

        public c(ki7 ki7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.f != null) {
                    this.b.f.m(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, 1);
                }
                vm6.b().e(true);
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
        public final /* synthetic */ ki7 b;

        public d(ki7 ki7Var, FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki7Var, frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki7Var;
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
                }
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.h();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
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

    public ki7(FrsCommonTabFragment frsCommonTabFragment, View view2, FrsViewData frsViewData) {
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
        this.l = 3;
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
        if (frsCommonTabFragment != null && view2 != null) {
            this.a = frsCommonTabFragment;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090c7f);
            this.b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            this.b.setOnSrollToBottomListener(this.n);
            this.b.addOnScrollListener(this.o);
            this.b.setRecyclerListener(new d(this, frsCommonTabFragment));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.b;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.b.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.c = pbListView;
            pbListView.c();
            this.c.s(R.color.transparent);
            this.c.w(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds182));
            this.c.B();
            this.c.L(R.dimen.tbfontsize33);
            this.c.J(SkinManager.getColor(R.color.CAM_X0107));
            this.c.F(R.color.CAM_X0110);
            this.c.v();
            FrsCommonTabFragment frsCommonTabFragment2 = this.a;
            BdTypeRecyclerView bdTypeRecyclerView3 = this.b;
            if (frsCommonTabFragment2.h == 16) {
                z = true;
            } else {
                z = false;
            }
            this.d = new ji7(frsCommonTabFragment2, bdTypeRecyclerView3, frsViewData, z);
            x(false);
            if (this.f == null) {
                this.f = new jt9(this.a.getPageContext(), this.b);
            }
            this.f.p(2);
            this.f.u(this.a.getUniqueId());
            if (g()) {
                this.g = new RelativeLayout(this.a.getContext());
                this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.h = new fk7(this.a, this.g);
                this.b.addHeaderView(this.g, 0);
                this.h.i(h());
            }
            FrsCommonTabFragment frsCommonTabFragment3 = this.a;
            if (frsCommonTabFragment3.h == 16) {
                gg7 gg7Var = new gg7(frsCommonTabFragment3);
                this.j = gg7Var;
                this.b.addHeaderView(gg7Var.a(), 0);
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
        ji7 ji7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (ji7Var = this.d) != null) {
            ji7Var.k(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || this.a == null) {
            return;
        }
        rf7 rf7Var = new rf7();
        rf7Var.a = this.a.g;
        rf7Var.b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, rf7Var));
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

    public jt9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (jt9) invokeV.objValue;
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
            jt9 jt9Var = this.f;
            if (jt9Var != null) {
                jt9Var.h();
            }
            ji7 ji7Var = this.d;
            if (ji7Var != null) {
                ji7Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setRecyclerListener(null);
                this.b.setAdapter(null);
                this.b.setOnScrollListener(null);
            }
        }
    }

    public void p() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (jt9Var = this.f) != null) {
            jt9Var.z();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.g();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rf7 rf7Var = new rf7();
            rf7Var.a = this.a.g;
            rf7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, rf7Var));
        }
    }

    public void s() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (jt9Var = this.f) != null) {
            jt9Var.o();
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

    public final boolean k(ArrayList<ym> arrayList, int i) {
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
                if (arrayList.get(i3) instanceof w35) {
                    int i4 = i3 - 1;
                    if ((arrayList.get(i4) instanceof w35) && ((w35) arrayList.get(i3)).position == ((w35) arrayList.get(i4)).position) {
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
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.l == i) {
            return;
        }
        this.l = i;
        ji7 ji7Var = this.d;
        if (ji7Var != null) {
            ji7Var.g();
        }
        PbListView pbListView = this.c;
        if (pbListView != null) {
            pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
            this.c.e(i);
        }
        fk7 fk7Var = this.h;
        if (fk7Var != null) {
            fk7Var.h();
        }
        gg7 gg7Var = this.j;
        if (gg7Var != null) {
            gg7Var.b();
        }
    }

    public void m(String str) {
        mi7 mi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !StringUtils.isNull(str) && (mi7Var = this.e) != null && !ListUtils.isEmpty(mi7Var.c)) {
            Iterator<ym> it = this.e.c.iterator();
            while (it.hasNext()) {
                ym next = it.next();
                ThreadData threadData = null;
                if (next instanceof w35) {
                    threadData = ((w35) next).t;
                } else if (next instanceof ThreadData) {
                    threadData = (ThreadData) next;
                }
                if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                    it.remove();
                }
            }
            if (ListUtils.isEmpty(this.e.c)) {
                this.e.c.add(new pf7());
            }
            this.d.j(this.e.c);
            this.d.g();
        }
    }

    public void o(mi7 mi7Var) {
        gg7 gg7Var;
        fk7 fk7Var;
        FrsCommonTabFragment frsCommonTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mi7Var) != null) || mi7Var == null) {
            return;
        }
        this.i = mi7Var.a;
        if (ListUtils.isEmpty(mi7Var.c)) {
            pf7 pf7Var = new pf7();
            ArrayList<ym> arrayList = new ArrayList<>();
            mi7Var.c = arrayList;
            arrayList.add(pf7Var);
            mi7Var.a = false;
        }
        this.e = mi7Var;
        this.c.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.b.setNextPage(this.c);
            if (k(mi7Var.c, 3)) {
                this.c.G(null);
                this.c.Q();
            } else {
                this.c.Q();
                this.c.G(this.m);
                this.c.H(this.a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.b.setNextPage(null);
            this.c.H(this.a.getResources().getString(R.string.list_has_no_more));
            this.c.G(null);
            this.c.g();
        }
        this.d.j(mi7Var.c);
        this.d.g();
        if (this.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
            this.f.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
        if (this.a != null && g() && (fk7Var = this.h) != null) {
            fk7Var.g(this.a.b2());
            this.h.j(this.a.e);
        }
        this.k = mi7Var.j;
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        if (frsCommonTabFragment2 != null && (frsCommonTabFragment2.getFragmentActivity() instanceof lg7)) {
            ((lg7) this.a.getFragmentActivity()).o1(this.k);
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3 != null && frsCommonTabFragment3.h == 16 && (gg7Var = this.j) != null) {
            gg7Var.c(this.k);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.b.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            if (!this.i) {
                this.n.onScrollToBottom();
            }
            jt9 jt9Var = this.f;
            if (jt9Var != null) {
                jt9Var.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
            }
        }
    }
}
