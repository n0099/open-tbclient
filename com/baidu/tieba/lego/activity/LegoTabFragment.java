package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.f0.g;
import c.a.o0.f0.h;
import c.a.p0.o1.j;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes7.dex */
public class LegoTabFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f53502e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.o1.s.a f53503f;

    /* renamed from: g  reason: collision with root package name */
    public h f53504g;

    /* renamed from: h  reason: collision with root package name */
    public g f53505h;

    /* renamed from: i  reason: collision with root package name */
    public long f53506i;

    /* renamed from: j  reason: collision with root package name */
    public String f53507j;
    public String k;
    public String l;
    public String m;
    public List<c.a.p0.o1.p.d> n;
    public j o;
    public c.a.p0.o1.d p;
    public c.a.p0.o1.c q;
    public CustomMessageListener r;

    /* loaded from: classes7.dex */
    public class a implements c.a.p0.o1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f53508a;

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
            this.f53508a = legoTabFragment;
        }

        @Override // c.a.p0.o1.d
        public void a(int i2, long j2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2}) == null) {
                this.f53508a.f53503f.c(2, j2, str, i2, str2);
            }
        }

        @Override // c.a.p0.o1.d
        public void b(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, str) == null) {
                this.f53508a.f53503f.a(j2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.p0.o1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f53509a;

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
            this.f53509a = legoTabFragment;
        }

        @Override // c.a.p0.o1.c
        public void a(List<c.a.p0.o1.p.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LegoTabFragment legoTabFragment = this.f53509a;
                List<c.a.p0.o1.p.d> list2 = legoTabFragment.n;
                if (list2 == null) {
                    legoTabFragment.n = new ArrayList();
                } else {
                    list2.clear();
                }
                if (list != null && list.size() > 0) {
                    this.f53509a.n.addAll(list);
                }
                this.f53509a.s();
            }
        }

        @Override // c.a.p0.o1.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LegoTabFragment legoTabFragment = this.f53509a;
                legoTabFragment.n(legoTabFragment.getView());
            }
        }

        @Override // c.a.p0.o1.c
        public void c(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, str) == null) {
                this.f53509a.f53503f.c(1, j2, str, 1, "");
            }
        }

        @Override // c.a.p0.o1.c
        public void d(String str, String str2, String str3, List<c.a.p0.o1.p.e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) {
                this.f53509a.k = str;
                this.f53509a.l = str2;
                this.f53509a.m = str3;
                this.f53509a.q();
                this.f53509a.p(list);
            }
        }

        @Override // c.a.p0.o1.c
        public void e(long j2, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2), str2}) == null) {
                this.f53509a.f53503f.c(1, j2, str, i2, str2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f53510a;

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
            this.f53510a = legoTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f53510a.q();
                this.f53510a.s();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.p0.o1.s.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f53511a;

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
            this.f53511a = legoTabFragment;
        }

        @Override // c.a.p0.o1.s.b
        public void a(boolean z, Message message, boolean z2, long j2, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j2), str, Integer.valueOf(i2)}) == null) {
                this.f53511a.q();
                if (z) {
                    LegoTabFragment legoTabFragment = this.f53511a;
                    legoTabFragment.n(legoTabFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || this.f53511a.f53502e.hasContentData() || (dataRes != null && dataRes.cards != null)) {
                    this.f53511a.f53502e.updateData(z, j2, str, dataRes, z2, i2);
                } else if (this.f53511a.getPageContext() == null || this.f53511a.getPageContext().getResources() == null) {
                } else {
                    LegoTabFragment legoTabFragment2 = this.f53511a;
                    legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.f53511a.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }
        }

        @Override // c.a.p0.o1.s.b
        public void b(long j2, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2, Integer.valueOf(i2)}) == null) {
                LegoTabFragment legoTabFragment = this.f53511a;
                legoTabFragment.n(legoTabFragment.getView());
                if (this.f53511a.f53502e.hasContentData()) {
                    this.f53511a.f53502e.updateError(j2, str, str2, i2);
                } else if (this.f53511a.getPageContext() == null || this.f53511a.getPageContext().getResources() == null) {
                } else {
                    LegoTabFragment legoTabFragment2 = this.f53511a;
                    legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.f53511a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
                }
            }
        }

        @Override // c.a.p0.o1.s.b
        public void c(long j2, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, message, Boolean.valueOf(z)}) == null) {
                LegoTabFragment legoTabFragment = this.f53511a;
                legoTabFragment.n(legoTabFragment.getView());
                this.f53511a.f53502e.updateHotData(j2, str, (DataRes) message, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f53512e;

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
            this.f53512e = legoTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53512e.f53503f == null) {
                return;
            }
            this.f53512e.f53503f.c(1, this.f53512e.f53506i, this.f53512e.f53507j, 1, "");
            this.f53512e.hideNetRefreshView();
            LegoTabFragment legoTabFragment = this.f53512e;
            legoTabFragment.r(legoTabFragment.getView(), false, this.f53512e.getResources().getDimensionPixelSize(R.dimen.ds360));
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

    public String getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53507j : (String) invokeV.objValue;
    }

    public final void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.f53504g) == null) {
            return;
        }
        hVar.dettachView(getView());
        this.f53504g = null;
    }

    public final void n(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (gVar = this.f53505h) == null) {
            return;
        }
        gVar.dettachView(view);
        this.f53505h = null;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.o1.s.a c2 = c.a.p0.o1.r.b.d().c(getPageContext(), getUniqueId());
            this.f53503f = c2;
            c2.b(new d(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            o();
            ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
            this.f53502e = scrollFragmentTabHost;
            scrollFragmentTabHost.setPageUniqueId(getUniqueId());
            this.f53502e.initViewPager(this.p, this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f53502e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            if (isPrimary() && (scrollFragmentTabHost = this.f53502e) != null && scrollFragmentTabHost.isTagListEmpty()) {
                this.f53502e.startFirstLoad(this.f53506i, this.f53507j);
                r(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    public final void p(List<c.a.p0.o1.p.e> list) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || (count = ListUtils.getCount(list)) <= 0 || this.f53502e == null) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= count) {
                break;
            } else if (list.get(i3).f22740a == this.f53506i) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.f53502e.setFirstPosition(i2);
        this.f53502e.addNewTagList(list, i2);
        this.f53502e.setCurrentTab(i2);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.o == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.m)) {
            this.o.j(this.l, this.m);
        } else {
            this.o.i(this.k);
        }
    }

    public final void r(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.f53505h == null) {
                if (i2 < 0) {
                    this.f53505h = new g(getActivity());
                } else {
                    this.f53505h = new g(getActivity(), i2);
                }
                this.f53505h.onChangeSkinType();
            }
            this.f53505h.attachView(view, z);
        }
    }

    public final void s() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (jVar = this.o) == null) {
            return;
        }
        jVar.g(this.n);
    }

    public void setItemId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f53507j = str;
        }
    }

    public void setNavigationBarViewHolder(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            this.o = jVar;
        }
    }

    public void setPageId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.f53506i = j2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048592, this, view, str, z) == null) {
            if (this.f53504g == null) {
                this.f53504g = new h(getPageContext().getPageActivity(), new e(this));
            }
            this.f53504g.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.f53504g.l(str);
            this.f53504g.attachView(view, z);
            this.f53504g.o();
        }
    }
}
