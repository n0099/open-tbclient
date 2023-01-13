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
public class sq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public PbListView c;
    public rq6 d;
    public uq6 e;
    public gk8 f;
    public RelativeLayout g;
    public ms6 h;
    public boolean i;
    public oo6 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq6 a;

        public a(sq6 sq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq6Var;
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
        public final /* synthetic */ sq6 a;

        public b(sq6 sq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq6Var;
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
                        this.a.c.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                        this.a.c.E(null);
                        if (this.a.i) {
                            this.a.c.Q();
                            this.a.c.E(null);
                            this.a.a.X1();
                            return;
                        }
                        this.a.c.F(this.a.a.getResources().getString(R.string.list_has_no_more));
                        this.a.c.g();
                        this.a.c.E(null);
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
        public final /* synthetic */ sq6 b;

        public c(sq6 sq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.f != null) {
                    this.b.f.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, true);
                }
                s86.b().e(true);
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
        public final /* synthetic */ sq6 b;

        public d(sq6 sq6Var, FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq6Var, frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq6Var;
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
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.k();
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

    public sq6(FrsCommonTabFragment frsCommonTabFragment, View view2, FrsViewData frsViewData) {
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
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090b54);
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
            pbListView.c();
            this.c.r(R.color.transparent);
            this.c.v(zi.g(this.a.getActivity(), R.dimen.tbds182));
            this.c.A();
            this.c.J(R.dimen.tbfontsize33);
            this.c.H(SkinManager.getColor(R.color.CAM_X0107));
            this.c.D(R.color.CAM_X0110);
            this.c.u();
            FrsCommonTabFragment frsCommonTabFragment2 = this.a;
            BdTypeRecyclerView bdTypeRecyclerView3 = this.b;
            if (frsCommonTabFragment2.h == 16) {
                z = true;
            } else {
                z = false;
            }
            this.d = new rq6(frsCommonTabFragment2, bdTypeRecyclerView3, frsViewData, z);
            x(false);
            if (this.f == null) {
                this.f = new gk8(this.a.getPageContext(), this.b);
            }
            this.f.p(2);
            this.f.u(this.a.getUniqueId());
            if (g()) {
                this.g = new RelativeLayout(this.a.getContext());
                this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.h = new ms6(this.a, this.g);
                this.b.t(this.g, 0);
                this.h.i(h());
            }
            FrsCommonTabFragment frsCommonTabFragment3 = this.a;
            if (frsCommonTabFragment3.h == 16) {
                oo6 oo6Var = new oo6(frsCommonTabFragment3);
                this.j = oo6Var;
                this.b.t(oo6Var.a(), 0);
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
        rq6 rq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (rq6Var = this.d) != null) {
            rq6Var.k(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || this.a == null) {
            return;
        }
        zn6 zn6Var = new zn6();
        zn6Var.a = this.a.g;
        zn6Var.b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, zn6Var));
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

    public gk8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (gk8) invokeV.objValue;
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
            gk8 gk8Var = this.f;
            if (gk8Var != null) {
                gk8Var.h();
            }
            rq6 rq6Var = this.d;
            if (rq6Var != null) {
                rq6Var.h();
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
        gk8 gk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (gk8Var = this.f) != null) {
            gk8Var.z();
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
            zn6 zn6Var = new zn6();
            zn6Var.a = this.a.g;
            zn6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, zn6Var));
        }
    }

    public void s() {
        gk8 gk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (gk8Var = this.f) != null) {
            gk8Var.o();
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

    public final boolean k(ArrayList<yn> arrayList, int i) {
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
                if (arrayList.get(i3) instanceof jv4) {
                    int i4 = i3 - 1;
                    if ((arrayList.get(i4) instanceof jv4) && ((jv4) arrayList.get(i3)).position == ((jv4) arrayList.get(i4)).position) {
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
            rq6 rq6Var = this.d;
            if (rq6Var != null) {
                rq6Var.g();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.H(SkinManager.getColor(R.color.CAM_X0107));
                this.c.e(i);
            }
            ms6 ms6Var = this.h;
            if (ms6Var != null) {
                ms6Var.h();
            }
            oo6 oo6Var = this.j;
            if (oo6Var != null) {
                oo6Var.b();
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
        uq6 uq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !StringUtils.isNull(str) && (uq6Var = this.e) != null && !ListUtils.isEmpty(uq6Var.c)) {
            Iterator<yn> it = this.e.c.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                ThreadData threadData = null;
                if (next instanceof jv4) {
                    threadData = ((jv4) next).t;
                } else if (next instanceof ThreadData) {
                    threadData = (ThreadData) next;
                }
                if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                    it.remove();
                }
            }
            if (ListUtils.isEmpty(this.e.c)) {
                this.e.c.add(new xn6());
            }
            this.d.j(this.e.c);
            this.d.g();
        }
    }

    public void o(uq6 uq6Var) {
        oo6 oo6Var;
        ms6 ms6Var;
        FrsCommonTabFragment frsCommonTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uq6Var) != null) || uq6Var == null) {
            return;
        }
        this.i = uq6Var.a;
        if (ListUtils.isEmpty(uq6Var.c)) {
            xn6 xn6Var = new xn6();
            ArrayList<yn> arrayList = new ArrayList<>();
            uq6Var.c = arrayList;
            arrayList.add(xn6Var);
            uq6Var.a = false;
        }
        this.e = uq6Var;
        this.c.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.b.setNextPage(this.c);
            if (k(uq6Var.c, 3)) {
                this.c.E(null);
                this.c.P();
            } else {
                this.c.P();
                this.c.E(this.l);
                this.c.F(this.a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.b.setNextPage(null);
            this.c.F(this.a.getResources().getString(R.string.list_has_no_more));
            this.c.E(null);
            this.c.g();
        }
        this.d.j(uq6Var.c);
        this.d.g();
        if (this.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
            this.f.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
        if (this.a != null && g() && (ms6Var = this.h) != null) {
            ms6Var.g(this.a.V1());
            this.h.j(this.a.e);
        }
        this.k = uq6Var.j;
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        if (frsCommonTabFragment2 != null && (frsCommonTabFragment2.getFragmentActivity() instanceof to6)) {
            ((to6) this.a.getFragmentActivity()).K0(this.k);
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3 != null && frsCommonTabFragment3.h == 16 && (oo6Var = this.j) != null) {
            oo6Var.c(this.k);
        }
    }
}
