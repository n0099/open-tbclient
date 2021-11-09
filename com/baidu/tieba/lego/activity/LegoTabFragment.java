package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.g0.g;
import b.a.q0.g0.h;
import b.a.r0.q1.j;
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
/* loaded from: classes9.dex */
public class LegoTabFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f51061e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.q1.s.a f51062f;

    /* renamed from: g  reason: collision with root package name */
    public h f51063g;

    /* renamed from: h  reason: collision with root package name */
    public g f51064h;

    /* renamed from: i  reason: collision with root package name */
    public long f51065i;
    public String j;
    public String k;
    public String l;
    public String m;
    public List<b.a.r0.q1.p.d> n;
    public j o;
    public b.a.r0.q1.d p;
    public b.a.r0.q1.c q;
    public CustomMessageListener r;

    /* loaded from: classes9.dex */
    public class a implements b.a.r0.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f51066a;

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
            this.f51066a = legoTabFragment;
        }

        @Override // b.a.r0.q1.d
        public void a(int i2, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2}) == null) {
                this.f51066a.f51062f.c(2, j, str, i2, str2);
            }
        }

        @Override // b.a.r0.q1.d
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.f51066a.f51062f.a(j, str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.r0.q1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f51067a;

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
            this.f51067a = legoTabFragment;
        }

        @Override // b.a.r0.q1.c
        public void a(List<b.a.r0.q1.p.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LegoTabFragment legoTabFragment = this.f51067a;
                List<b.a.r0.q1.p.d> list2 = legoTabFragment.n;
                if (list2 == null) {
                    legoTabFragment.n = new ArrayList();
                } else {
                    list2.clear();
                }
                if (list != null && list.size() > 0) {
                    this.f51067a.n.addAll(list);
                }
                this.f51067a.s();
            }
        }

        @Override // b.a.r0.q1.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LegoTabFragment legoTabFragment = this.f51067a;
                legoTabFragment.n(legoTabFragment.getView());
            }
        }

        @Override // b.a.r0.q1.c
        public void c(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str) == null) {
                this.f51067a.f51062f.c(1, j, str, 1, "");
            }
        }

        @Override // b.a.r0.q1.c
        public void d(String str, String str2, String str3, List<b.a.r0.q1.p.e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) {
                this.f51067a.k = str;
                this.f51067a.l = str2;
                this.f51067a.m = str3;
                this.f51067a.q();
                this.f51067a.p(list);
            }
        }

        @Override // b.a.r0.q1.c
        public void e(long j, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) {
                this.f51067a.f51062f.c(1, j, str, i2, str2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f51068a;

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
            this.f51068a = legoTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f51068a.q();
                this.f51068a.s();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.a.r0.q1.s.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f51069a;

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
            this.f51069a = legoTabFragment;
        }

        @Override // b.a.r0.q1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i2)}) == null) {
                this.f51069a.q();
                if (z) {
                    LegoTabFragment legoTabFragment = this.f51069a;
                    legoTabFragment.n(legoTabFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || this.f51069a.f51061e.hasContentData() || (dataRes != null && dataRes.cards != null)) {
                    this.f51069a.f51061e.updateData(z, j, str, dataRes, z2, i2);
                } else if (this.f51069a.getPageContext() == null || this.f51069a.getPageContext().getResources() == null) {
                } else {
                    LegoTabFragment legoTabFragment2 = this.f51069a;
                    legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.f51069a.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }
        }

        @Override // b.a.r0.q1.s.b
        public void b(long j, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
                LegoTabFragment legoTabFragment = this.f51069a;
                legoTabFragment.n(legoTabFragment.getView());
                if (this.f51069a.f51061e.hasContentData()) {
                    this.f51069a.f51061e.updateError(j, str, str2, i2);
                } else if (this.f51069a.getPageContext() == null || this.f51069a.getPageContext().getResources() == null) {
                } else {
                    LegoTabFragment legoTabFragment2 = this.f51069a;
                    legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.f51069a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
                }
            }
        }

        @Override // b.a.r0.q1.s.b
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
                LegoTabFragment legoTabFragment = this.f51069a;
                legoTabFragment.n(legoTabFragment.getView());
                this.f51069a.f51061e.updateHotData(j, str, (DataRes) message, z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoTabFragment f51070e;

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
            this.f51070e = legoTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51070e.f51062f == null) {
                return;
            }
            this.f51070e.f51062f.c(1, this.f51070e.f51065i, this.f51070e.j, 1, "");
            this.f51070e.hideNetRefreshView();
            LegoTabFragment legoTabFragment = this.f51070e;
            legoTabFragment.r(legoTabFragment.getView(), false, this.f51070e.getResources().getDimensionPixelSize(R.dimen.ds360));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.f51063g) == null) {
            return;
        }
        hVar.dettachView(getView());
        this.f51063g = null;
    }

    public final void n(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (gVar = this.f51064h) == null) {
            return;
        }
        gVar.dettachView(view);
        this.f51064h = null;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.q1.s.a c2 = b.a.r0.q1.r.b.d().c(getPageContext(), getUniqueId());
            this.f51062f = c2;
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
            this.f51061e = scrollFragmentTabHost;
            scrollFragmentTabHost.setPageUniqueId(getUniqueId());
            this.f51061e.initViewPager(this.p, this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f51061e;
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
            if (isPrimary() && (scrollFragmentTabHost = this.f51061e) != null && scrollFragmentTabHost.isTagListEmpty()) {
                this.f51061e.startFirstLoad(this.f51065i, this.j);
                r(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    public final void p(List<b.a.r0.q1.p.e> list) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || (count = ListUtils.getCount(list)) <= 0 || this.f51061e == null) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= count) {
                break;
            } else if (list.get(i3).f22738a == this.f51065i) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.f51061e.setFirstPosition(i2);
        this.f51061e.addNewTagList(list, i2);
        this.f51061e.setCurrentTab(i2);
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
            if (this.f51064h == null) {
                if (i2 < 0) {
                    this.f51064h = new g(getActivity());
                } else {
                    this.f51064h = new g(getActivity(), i2);
                }
                this.f51064h.onChangeSkinType();
            }
            this.f51064h.attachView(view, z);
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
            this.j = str;
        }
    }

    public void setNavigationBarViewHolder(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            this.o = jVar;
        }
    }

    public void setPageId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.f51065i = j;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048592, this, view, str, z) == null) {
            if (this.f51063g == null) {
                this.f51063g = new h(getPageContext().getPageActivity(), new e(this));
            }
            this.f51063g.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.f51063g.l(str);
            this.f51063g.attachView(view, z);
            this.f51063g.o();
        }
    }
}
