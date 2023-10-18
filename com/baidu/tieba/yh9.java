package com.baidu.tieba;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.pageStayDuration.IPageStayDuration;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.pageStayDuration.PageStayDurationStat;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.kj9;
import com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class yh9 implements IPageStayDuration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final PbFragment b;
    public bi9 c;
    public ai9 d;
    public dk9 e;
    public oi9 f;
    public View.OnClickListener g;
    public View.OnClickListener h;
    public TbRichTextView.z i;
    public View.OnLongClickListener j;
    public tg9 k;
    public final MoreGodReplyModel l;
    public PageStayDurationItem m;
    public long n;
    public BdListView.p o;
    public AbsListView.OnScrollListener p;
    public kj9.b q;
    public PbFragment.g3 r;

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a053" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public a(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.l.X()) {
                this.a.l.Y();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ yh9 b;

        public final boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 2 || i == 1 : invokeI.booleanValue;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i, i2, i3) == null) {
            }
        }

        public b(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yh9Var;
            this.a = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i) == null) {
                if (!a(this.a) && a(i) && (pbFragment = this.b.b) != null && pbFragment.E6() != null) {
                    this.b.b.E6().p3();
                    this.b.b.E6().J1();
                }
                this.a = i;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements kj9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public c(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // com.baidu.tieba.kj9.b
        public void onSuccess(List<pea> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                return;
            }
            this.a.w();
        }

        @Override // com.baidu.tieba.kj9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.e.L4(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ yh9 b;

        public d(yh9 yh9Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yh9Var;
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.i();
                this.b.a = false;
                PbFragment pbFragment = this.b.b;
                if (pbFragment != null) {
                    if (pbFragment.E6() != null) {
                        this.b.b.E6().k4(false);
                        li9 T0 = this.b.b.E6().T0();
                        T0.n0(this.b.b.e0().s1(), true);
                        T0.f0();
                    }
                    yh9 yh9Var = this.b;
                    yh9Var.b.T7(yh9Var.r);
                }
                Runnable runnable = this.a;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public e(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public f(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public g(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !this.a.l.X()) {
                this.a.l.Y();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements PbFragment.g3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public h(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.g3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.h();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;

        public i(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.g(false);
            }
        }
    }

    public yh9(PbFragment pbFragment, dk9 dk9Var, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, dk9Var, viewStub};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new h(this);
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.e0());
        this.l = moreGodReplyModel;
        moreGodReplyModel.Z(this.q);
        this.e = dk9Var;
        this.b = pbFragment;
        this.c = new bi9(pbFragment, viewStub);
        this.d = new ai9(this);
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.c.o(i2);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    public void p(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.i = zVar;
        }
    }

    public void q(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onLongClickListener) == null) {
            this.j = onLongClickListener;
        }
    }

    public void r(tg9 tg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tg9Var) == null) {
            this.k = tg9Var;
        }
    }

    public final void s(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bdTypeListView) == null) && this.f == null) {
            oi9 oi9Var = new oi9(this.b, pea.X0);
            this.f = oi9Var;
            oi9Var.v0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbFragment pbFragment = this.b;
            if (pbFragment == null) {
                return null;
            }
            return pbFragment.getNextPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i(null);
        }
    }

    public bi9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (bi9) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && k()) {
            w();
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
            String currentPageKey = getCurrentPageKey();
            if (!ListUtils.isEmpty(arrayList2)) {
                arrayList = new ArrayList();
                arrayList.addAll(arrayList2);
            } else {
                arrayList = null;
            }
            if (getPageStayFilter() != null && !getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
                return arrayList;
            }
            if (!StringUtils.isNull(currentPageKey)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m == null) {
                PageStayDurationItem pageStayDurationItem = new PageStayDurationItem();
                this.m = pageStayDurationItem;
                pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
                this.m.setCurrentPageKey(getCurrentPageKey());
                PbModel e0 = this.b.e0();
                if (e0 != null) {
                    this.m.setFid(JavaTypesHelper.toLong(e0.getForumId(), 0L));
                    this.m.setTid(JavaTypesHelper.toLong(e0.M1(), 0L));
                }
            }
            return this.m;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean m = this.c.m();
            this.c.p();
            if (!m) {
                this.c.d().setOnClickListener(new e(this));
                this.c.c().setOnClickListener(new f(this));
                this.c.f().G(new g(this));
                this.c.e().setOnScrollListener(this.p);
            }
            this.n = System.currentTimeMillis();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!k()) {
                this.b.Q6();
                this.a = true;
                this.d.h(false);
                this.d.g(true);
                t();
                w();
                this.c.q(new i(this));
                this.b.D5(this.r);
                this.l.Y();
            }
            this.b.E6().J1();
        }
    }

    public void i(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            this.l.cancelLoadData();
            this.b.Q6();
            if (!k() && runnable != null) {
                runnable.run();
                return;
            }
            if (k() && !this.d.e()) {
                this.c.r(new d(this, runnable));
            }
            if (this.n != 0) {
                PageStayDurationItem pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.setStayDurationTime(System.currentTimeMillis() - this.n);
                PageStayDurationStat.getInstance().stat(this.b.getContext(), pageStayDurationItem, getPageStayFilter());
            }
        }
    }

    public final void v(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ye9Var) == null) {
            this.f.q(ye9Var);
            li9 T0 = this.e.T0();
            this.f.setFromCDN(T0.d0());
            this.f.o(ye9Var.O().getAuthor().getUserId());
            this.f.c(T0.e0());
            this.f.e(this.g);
            this.f.k(this.h);
            this.f.n(this.i);
            this.f.d(this.j);
            this.f.z0(this.k);
        }
    }

    public final void w() {
        List<yh> U;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (U = this.l.U()) == null) {
            return;
        }
        ye9 s1 = this.l.V().s1();
        this.c.p();
        this.c.e().setOnSrollToBottomListener(this.o);
        BdTypeListView e2 = this.c.e();
        this.d.d();
        s(e2);
        v(s1);
        e2.setData(new ArrayList(U));
        this.c.g().setCenterTextTitle(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0cc5), StringHelper.numFormatOver10000(s1.T().b.size())));
        this.c.b(this.l.W());
        if (e2.getAdapter2() instanceof ph) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
