package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import d.a.r0.d0.g;
import d.a.r0.d0.h;
import d.a.s0.n1.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class LegoTabFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f18138e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.n1.s.a f18139f;

    /* renamed from: g  reason: collision with root package name */
    public h f18140g;

    /* renamed from: h  reason: collision with root package name */
    public g f18141h;

    /* renamed from: i  reason: collision with root package name */
    public long f18142i;
    public String j;
    public String k;
    public String l;
    public String m;
    public List<d.a.s0.n1.p.d> n;
    public j o;
    public d.a.s0.n1.d p;
    public d.a.s0.n1.c q;
    public CustomMessageListener r;

    /* loaded from: classes5.dex */
    public class a implements d.a.s0.n1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f18143a;

        public a(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18143a = legoTabFragment;
        }

        @Override // d.a.s0.n1.d
        public void a(int i2, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2}) == null) {
                this.f18143a.f18139f.c(2, j, str, i2, str2);
            }
        }

        @Override // d.a.s0.n1.d
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.f18143a.f18139f.a(j, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.s0.n1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f18144a;

        public b(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18144a = legoTabFragment;
        }

        @Override // d.a.s0.n1.c
        public void a(List<d.a.s0.n1.p.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LegoTabFragment legoTabFragment = this.f18144a;
                List<d.a.s0.n1.p.d> list2 = legoTabFragment.n;
                if (list2 == null) {
                    legoTabFragment.n = new ArrayList();
                } else {
                    list2.clear();
                }
                if (list != null && list.size() > 0) {
                    this.f18144a.n.addAll(list);
                }
                this.f18144a.c1();
            }
        }

        @Override // d.a.s0.n1.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LegoTabFragment legoTabFragment = this.f18144a;
                legoTabFragment.T0(legoTabFragment.getView());
            }
        }

        @Override // d.a.s0.n1.c
        public void c(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str) == null) {
                this.f18144a.f18139f.c(1, j, str, 1, "");
            }
        }

        @Override // d.a.s0.n1.c
        public void d(String str, String str2, String str3, List<d.a.s0.n1.p.e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) {
                this.f18144a.k = str;
                this.f18144a.l = str2;
                this.f18144a.m = str3;
                this.f18144a.X0();
                this.f18144a.W0(list);
            }
        }

        @Override // d.a.s0.n1.c
        public void e(long j, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) {
                this.f18144a.f18139f.c(1, j, str, i2, str2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f18145a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoTabFragment legoTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18145a = legoTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f18145a.X0();
                this.f18145a.c1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.s0.n1.s.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f18146a;

        public d(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18146a = legoTabFragment;
        }

        @Override // d.a.s0.n1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i2)}) == null) {
                this.f18146a.X0();
                if (z) {
                    LegoTabFragment legoTabFragment = this.f18146a;
                    legoTabFragment.T0(legoTabFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || this.f18146a.f18138e.f() || (dataRes != null && dataRes.cards != null)) {
                    this.f18146a.f18138e.n(z, j, str, dataRes, z2, i2);
                } else if (this.f18146a.getPageContext() == null || this.f18146a.getPageContext().getResources() == null) {
                } else {
                    LegoTabFragment legoTabFragment2 = this.f18146a;
                    legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.f18146a.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }
        }

        @Override // d.a.s0.n1.s.b
        public void b(long j, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
                LegoTabFragment legoTabFragment = this.f18146a;
                legoTabFragment.T0(legoTabFragment.getView());
                if (this.f18146a.f18138e.f()) {
                    this.f18146a.f18138e.o(j, str, str2, i2);
                } else if (this.f18146a.getPageContext() == null || this.f18146a.getPageContext().getResources() == null) {
                } else {
                    LegoTabFragment legoTabFragment2 = this.f18146a;
                    legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.f18146a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
                }
            }
        }

        @Override // d.a.s0.n1.s.b
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
                LegoTabFragment legoTabFragment = this.f18146a;
                legoTabFragment.T0(legoTabFragment.getView());
                this.f18146a.f18138e.p(j, str, (DataRes) message, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f18147e;

        public e(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18147e = legoTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18147e.f18139f == null) {
                return;
            }
            this.f18147e.f18139f.c(1, this.f18147e.f18142i, this.f18147e.j, 1, "");
            this.f18147e.U0();
            LegoTabFragment legoTabFragment = this.f18147e;
            legoTabFragment.b1(legoTabFragment.getView(), false, this.f18147e.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    public LegoTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this, 2016449);
    }

    public final void T0(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (gVar = this.f18141h) == null) {
            return;
        }
        gVar.dettachView(view);
        this.f18141h = null;
    }

    public final void U0() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.f18140g) == null) {
            return;
        }
        hVar.dettachView(getView());
        this.f18140g = null;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.s0.n1.s.a c2 = d.a.s0.n1.r.b.d().c(getPageContext(), getUniqueId());
            this.f18139f = c2;
            c2.b(new d(this));
        }
    }

    public final void W0(List<d.a.s0.n1.p.e> list) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (count = ListUtils.getCount(list)) <= 0 || this.f18138e == null) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= count) {
                break;
            } else if (list.get(i3).f63903a == this.f18142i) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.f18138e.setFirstPosition(i2);
        this.f18138e.d(list, i2);
        this.f18138e.setCurrentTab(i2);
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.o == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.m)) {
            this.o.j(this.l, this.m);
        } else {
            this.o.i(this.k);
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.j = str;
        }
    }

    public void Z0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jVar) == null) {
            this.o = jVar;
        }
    }

    public void a1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f18142i = j;
        }
    }

    public final void b1(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.f18141h == null) {
                if (i2 < 0) {
                    this.f18141h = new g(getActivity());
                } else {
                    this.f18141h = new g(getActivity(), i2);
                }
                this.f18141h.onChangeSkinType();
            }
            this.f18141h.attachView(view, z);
        }
    }

    public final void c1() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (jVar = this.o) == null) {
            return;
        }
        jVar.g(this.n);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            V0();
            ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
            this.f18138e = scrollFragmentTabHost;
            scrollFragmentTabHost.setPageUniqueId(getUniqueId());
            this.f18138e.h(this.p, this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f18138e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.k(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.lego_tab_control, (ViewGroup) null);
            inflate.setDrawingCacheEnabled(false);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isPrimary() && (scrollFragmentTabHost = this.f18138e) != null && scrollFragmentTabHost.j()) {
                this.f18138e.m(this.f18142i, this.j);
                b1(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, view, str, z) == null) {
            if (this.f18140g == null) {
                this.f18140g = new h(getPageContext().getPageActivity(), new e(this));
            }
            this.f18140g.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.f18140g.l(str);
            this.f18140g.attachView(view, z);
            this.f18140g.o();
        }
    }
}
