package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h2.h.e;
import d.a.q0.h3.h0.o;
import java.util.List;
/* loaded from: classes4.dex */
public class DetailInfoFragment extends BaseFragment implements d.a.q0.h2.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f19927e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f19928f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f19929g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19930h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPbViewModel f19931i;
    public d.a.q0.h2.o.f.c j;
    public int k;
    public String l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f19932a;

        public a(DetailInfoFragment detailInfoFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19932a = detailInfoFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 && this.f19932a.f19928f != null) {
                    this.f19932a.f19928f.o4();
                }
                if (i2 != 0 || recyclerView.canScrollVertically(-1) || this.f19932a.f19928f == null || this.f19932a.f19928f.R3()) {
                    return;
                }
                this.f19932a.f19931i.t(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            MutableLiveData<Boolean> e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                if (canScrollVertically && i3 > 0 && this.f19932a.f19928f != null && !this.f19932a.f19928f.R3() && ((e2 = this.f19932a.f19931i.e()) == null || e2.getValue() == null || e2.getValue().booleanValue())) {
                    this.f19932a.f19931i.t(false);
                }
                if (!canScrollVertically) {
                    if (Math.abs(i3) > 0 && this.f19932a.k != 0 && this.f19932a.f19928f != null) {
                        this.f19932a.f19928f.F4(8);
                    }
                    this.f19932a.k = 0;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19932a.f19928f != null && this.f19932a.k == 0) {
                    this.f19932a.f19928f.F4(0);
                }
                this.f19932a.k = 2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f19933a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DetailInfoFragment detailInfoFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoFragment, Integer.valueOf(i2)};
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
            this.f19933a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19933a.y() == null || this.f19933a.y().L0() == null) {
                return;
            }
            this.f19933a.y().L0().a();
            this.f19933a.y().i1();
            this.f19933a.j.n(this.f19933a.y().L0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f19934a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DetailInfoFragment detailInfoFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoFragment, Integer.valueOf(i2)};
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
            this.f19934a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19934a.y() == null || this.f19934a.y().L0() == null) {
                return;
            }
            this.f19934a.T0((String) customResponsedMessage.getData());
            this.f19934a.y().i1();
            this.f19934a.j.n(this.f19934a.y().L0());
        }
    }

    public DetailInfoFragment() {
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
        this.k = 0;
        this.n = new a(this);
        this.o = new b(this, 2016488);
        this.p = new c(this, 2016331);
    }

    public static DetailInfoFragment Y0(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
            detailInfoFragment.setArguments(bundle);
            detailInfoFragment.f19928f = absVideoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    @Override // d.a.q0.h2.o.a
    public void D0(boolean z, int i2, int i3, int i4, e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || eVar == null || getActivity() == null) {
            return;
        }
        S0(eVar);
    }

    public final void S0(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || this.f19931i == null || eVar == null) {
            return;
        }
        b1(eVar);
        Z0(eVar);
        this.j.n(eVar);
    }

    public final void T0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<o> X = y().L0().X();
        for (o oVar : X) {
            if (TextUtils.equals(str, oVar.D0())) {
                X.remove(oVar);
                return;
            }
        }
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    public final void V0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.f19930h) == null) {
            return;
        }
        pbListView.j();
    }

    public final void W0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
            this.f19929g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f19929g.addOnScrollListener(this.n);
            this.f19929g.setOnTouchListener(v().m3());
            PbListView pbListView = new PbListView(getContext());
            this.f19930h = pbListView;
            pbListView.b();
            this.f19930h.A("");
            this.f19930h.o(R.color.CAM_X0205);
            this.f19930h.v();
            this.f19930h.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f19930h.E(R.dimen.tbfontsize33);
            this.f19930h.y(R.color.CAM_X0110);
            this.f19930h.r(l.g(getContext(), R.dimen.tbds182));
            this.f19930h.q();
            if (!d.a.p0.e1.b.e.d()) {
                this.f19929g.setNextPage(this.f19930h);
            }
            this.j = new d.a.q0.h2.o.f.c(this, this.f19929g);
            if (y() == null || y().l1()) {
                return;
            }
            this.f19928f.u4(8);
        }
    }

    public void X0() {
        e L0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (L0 = y().L0()) == null) {
            return;
        }
        this.j.n(L0);
        this.j.l();
    }

    public final void Z0(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) || eVar == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            V0();
        } else if (ListUtils.isEmpty(eVar.f())) {
            g1();
        } else {
            V0();
            this.f19930h.A(getString(R.string.recommend_no_more_data));
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e c2 = this.f19931i.c();
            if (c2 == null) {
                c2 = this.f19931i.d();
            }
            S0(c2);
        }
    }

    public final void b1(e eVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        if (eVar.N() != null) {
            String P = eVar.P();
            str = eVar.N().J() != null ? eVar.N().J().oriUgcNid : null;
            r1 = P;
        } else {
            str = null;
        }
        if (r1 != this.l || str != this.m) {
            f1();
        }
        this.l = r1;
        this.m = str;
    }

    public void c1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdTypeRecyclerView = this.f19929g) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || y() == null || y().L0() == null) {
            return;
        }
        S0(y().L0());
    }

    public void e1() {
        d.a.q0.h2.o.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.m();
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19929g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            V0();
        }
    }

    public final void g1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f19930h) == null) {
            return;
        }
        pbListView.G(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.g(TbadkApplication.getInst(), R.dimen.tbds256));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f19931i == null) {
                return;
            }
            a1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f19927e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.h2.o.f.c cVar = this.j;
            if (cVar != null) {
                cVar.l();
            }
            PbListView pbListView = this.f19930h;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            if (d.a.p0.e1.b.e.d()) {
                SkinManager.setBackgroundColor(this.f19929g, R.color.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f19929g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().registerListener(this.p);
            this.o.setSelfListener(true);
            if (z() != null) {
                this.o.setTag(z().getUniqueId());
            } else if (getPageContext() != null) {
                this.o.setTag(getPageContext().getUniqueId());
            }
            this.o.setPriority(-1);
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
            this.f19931i = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
            W0(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.o);
            super.onDestroy();
        }
    }

    public AbsVideoPbFragment v() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f19928f == null && (absPbActivity = this.f19927e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f19928f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f19928f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? v().y() : (PbModel) invokeV.objValue;
    }

    public AbsPbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            AbsPbActivity absPbActivity = this.f19927e;
            return absPbActivity != null ? absPbActivity : this.f19928f.z();
        }
        return (AbsPbActivity) invokeV.objValue;
    }
}
