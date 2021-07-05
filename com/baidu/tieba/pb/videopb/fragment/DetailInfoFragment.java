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
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h2.h.e;
import d.a.s0.h3.h0.o;
import java.util.List;
/* loaded from: classes5.dex */
public class DetailInfoFragment extends BaseFragment implements d.a.s0.h2.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19784e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19785f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f19786g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19787h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPbViewModel f19788i;
    public d.a.s0.h2.o.f.a j;
    public int k;
    public String l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f19789a;

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
            this.f19789a = detailInfoFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 && this.f19789a.f19785f != null) {
                    this.f19789a.f19785f.j4();
                }
                if (i2 != 0 || recyclerView.canScrollVertically(-1) || this.f19789a.f19785f == null || this.f19789a.f19785f.L3()) {
                    return;
                }
                this.f19789a.f19788i.t(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            MutableLiveData<Boolean> e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                if (canScrollVertically && i3 > 0 && this.f19789a.f19785f != null && !this.f19789a.f19785f.L3() && ((e2 = this.f19789a.f19788i.e()) == null || e2.getValue() == null || e2.getValue().booleanValue())) {
                    this.f19789a.f19788i.t(false);
                }
                if (!canScrollVertically) {
                    if (Math.abs(i3) > 0 && this.f19789a.k != 0 && this.f19789a.f19785f != null) {
                        this.f19789a.f19785f.z4(8);
                    }
                    this.f19789a.k = 0;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19789a.f19785f != null && this.f19789a.k == 0) {
                    this.f19789a.f19785f.z4(0);
                }
                this.f19789a.k = 2;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f19790a;

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
            this.f19790a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19790a.y() == null || this.f19790a.y().D0() == null) {
                return;
            }
            this.f19790a.y().D0().a();
            this.f19790a.y().Z0();
            this.f19790a.j.n(this.f19790a.y().D0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f19791a;

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
            this.f19791a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19791a.y() == null || this.f19791a.y().D0() == null) {
                return;
            }
            this.f19791a.N0((String) customResponsedMessage.getData());
            this.f19791a.y().Z0();
            this.f19791a.j.n(this.f19791a.y().D0());
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

    public static DetailInfoFragment S0(VideoPbFragment videoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, videoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
            detailInfoFragment.setArguments(bundle);
            detailInfoFragment.f19785f = videoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    public final void M0(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || this.f19788i == null || eVar == null) {
            return;
        }
        V0(eVar);
        T0(eVar);
        this.j.n(eVar);
    }

    public final void N0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<o> X = y().D0().X();
        for (o oVar : X) {
            if (TextUtils.equals(str, oVar.D0())) {
                X.remove(oVar);
                return;
            }
        }
    }

    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.intValue;
    }

    public final void P0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pbListView = this.f19787h) == null) {
            return;
        }
        pbListView.j();
    }

    public final void Q0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
            this.f19786g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f19786g.addOnScrollListener(this.n);
            this.f19786g.setOnTouchListener(v().h3());
            PbListView pbListView = new PbListView(getContext());
            this.f19787h = pbListView;
            pbListView.b();
            this.f19787h.A("");
            this.f19787h.o(R.color.CAM_X0205);
            this.f19787h.v();
            this.f19787h.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f19787h.E(R.dimen.tbfontsize33);
            this.f19787h.y(R.color.CAM_X0110);
            this.f19787h.r(l.g(getContext(), R.dimen.tbds182));
            this.f19787h.q();
            if (!d.a.r0.c1.b.e.d()) {
                this.f19786g.setNextPage(this.f19787h);
            }
            this.j = new d.a.s0.h2.o.f.a(this, this.f19786g);
            if (y() == null || y().c1()) {
                return;
            }
            this.f19785f.p4(8);
        }
    }

    public void R0() {
        e D0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (D0 = y().D0()) == null) {
            return;
        }
        this.j.n(D0);
        this.j.l();
    }

    public final void T0(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || eVar == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            P0();
        } else if (ListUtils.isEmpty(eVar.f())) {
            a1();
        } else {
            P0();
            this.f19787h.A(getString(R.string.recommend_no_more_data));
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e c2 = this.f19788i.c();
            if (c2 == null) {
                c2 = this.f19788i.d();
            }
            M0(c2);
        }
    }

    public final void V0(e eVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) || eVar == null) {
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
            Z0();
        }
        this.l = r1;
        this.m = str;
    }

    public void W0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdTypeRecyclerView = this.f19786g) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || y() == null || y().D0() == null) {
            return;
        }
        M0(y().D0());
    }

    public void Y0() {
        d.a.s0.h2.o.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.m();
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19786g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            P0();
        }
    }

    public final void a1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f19787h) == null) {
            return;
        }
        pbListView.G(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.g(TbadkApplication.getInst(), R.dimen.tbds256));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f19788i == null) {
                return;
            }
            U0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            super.onAttach(context);
            if (context instanceof PbActivity) {
                this.f19784e = (PbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.h2.o.f.a aVar = this.j;
            if (aVar != null) {
                aVar.l();
            }
            PbListView pbListView = this.f19787h;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            if (d.a.r0.c1.b.e.d()) {
                SkinManager.setBackgroundColor(this.f19786g, R.color.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f19786g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
            this.f19788i = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
            Q0(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.o);
            super.onDestroy();
        }
    }

    public VideoPbFragment v() {
        InterceptResult invokeV;
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f19785f == null && (pbActivity = this.f19784e) != null) {
                Fragment findFragment = pbActivity.findFragment();
                if (findFragment instanceof VideoPbFragment) {
                    this.f19785f = (VideoPbFragment) findFragment;
                }
            }
            return this.f19785f;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? v().y() : (PbModel) invokeV.objValue;
    }

    public PbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbActivity pbActivity = this.f19784e;
            return pbActivity != null ? pbActivity : this.f19785f.z();
        }
        return (PbActivity) invokeV.objValue;
    }

    @Override // d.a.s0.h2.o.a
    public void z0(boolean z, int i2, int i3, int i4, e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || eVar == null || getActivity() == null) {
            return;
        }
        M0(eVar);
    }
}
