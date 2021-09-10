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
import c.a.e.e.p.l;
import c.a.r0.j2.h.e;
import c.a.r0.j3.i0.p;
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
import java.util.List;
/* loaded from: classes7.dex */
public class DetailInfoFragment extends BaseFragment implements c.a.r0.j2.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f55592e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f55593f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f55594g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f55595h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPbViewModel f55596i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.j2.o.f.c f55597j;
    public int k;
    public String l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f55598a;

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
            this.f55598a = detailInfoFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 && this.f55598a.f55593f != null) {
                    this.f55598a.f55593f.resetCommentView();
                }
                if (i2 != 0 || recyclerView.canScrollVertically(-1) || this.f55598a.f55593f == null || this.f55598a.f55593f.isVerticalVideo()) {
                    return;
                }
                this.f55598a.f55596i.setIsDetailTabTop(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            MutableLiveData<Boolean> isDetailTabTop;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                if (canScrollVertically && i3 > 0 && this.f55598a.f55593f != null && !this.f55598a.f55593f.isVerticalVideo() && ((isDetailTabTop = this.f55598a.f55596i.getIsDetailTabTop()) == null || isDetailTabTop.getValue() == null || isDetailTabTop.getValue().booleanValue())) {
                    this.f55598a.f55596i.setIsDetailTabTop(false);
                }
                if (!canScrollVertically) {
                    if (Math.abs(i3) > 0 && this.f55598a.k != 0 && this.f55598a.f55593f != null) {
                        this.f55598a.f55593f.setShadowVisible(8);
                    }
                    this.f55598a.k = 0;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f55598a.f55593f != null && this.f55598a.k == 0) {
                    this.f55598a.f55593f.setShadowVisible(0);
                }
                this.f55598a.k = 2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f55599a;

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
            this.f55599a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55599a.getPbModel() == null || this.f55599a.getPbModel().O0() == null) {
                return;
            }
            this.f55599a.getPbModel().O0().a();
            this.f55599a.getPbModel().l1();
            this.f55599a.f55597j.n(this.f55599a.getPbModel().O0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f55600a;

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
            this.f55600a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55600a.getPbModel() == null || this.f55600a.getPbModel().O0() == null) {
                return;
            }
            this.f55600a.h((String) customResponsedMessage.getData());
            this.f55600a.getPbModel().l1();
            this.f55600a.f55597j.n(this.f55600a.getPbModel().O0());
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

    public static DetailInfoFragment newInstance(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
            detailInfoFragment.setArguments(bundle);
            detailInfoFragment.f55593f = absVideoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    public final void g(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || this.f55596i == null || eVar == null) {
            return;
        }
        m(eVar);
        k(eVar);
        this.f55597j.n(eVar);
    }

    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AbsPbActivity absPbActivity = this.f55592e;
            return absPbActivity != null ? absPbActivity : this.f55593f.getPbActivity();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getVideoPbFragment().getPbModel() : (PbModel) invokeV.objValue;
    }

    public int getRecyclerViewState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f55593f == null && (absPbActivity = this.f55592e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f55593f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f55593f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<p> Y = getPbModel().O0().Y();
        for (p pVar : Y) {
            if (TextUtils.equals(str, pVar.D0())) {
                Y.remove(pVar);
                return;
            }
        }
    }

    public final void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.f55595h) == null) {
            return;
        }
        pbListView.j();
    }

    public void invalidataData() {
        e O0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (O0 = getPbModel().O0()) == null) {
            return;
        }
        this.f55597j.n(O0);
        this.f55597j.l();
    }

    public final void j(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
            this.f55594g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f55594g.addOnScrollListener(this.n);
            this.f55594g.setOnTouchListener(getVideoPbFragment().getOnTouchListener());
            PbListView pbListView = new PbListView(getContext());
            this.f55595h = pbListView;
            pbListView.b();
            this.f55595h.A("");
            this.f55595h.o(R.color.CAM_X0205);
            this.f55595h.v();
            this.f55595h.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55595h.E(R.dimen.tbfontsize33);
            this.f55595h.y(R.color.CAM_X0110);
            this.f55595h.r(l.g(getContext(), R.dimen.tbds182));
            this.f55595h.q();
            if (!c.a.q0.g1.b.e.d()) {
                this.f55594g.setNextPage(this.f55595h);
            }
            this.f55597j = new c.a.r0.j2.o.f.c(this, this.f55594g);
            if (getPbModel() == null || getPbModel().p1()) {
                return;
            }
            this.f55593f.setCommentContainerVisible(8);
        }
    }

    public final void k(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            i();
        } else if (ListUtils.isEmpty(eVar.f())) {
            o();
        } else {
            i();
            this.f55595h.A(getString(R.string.recommend_no_more_data));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            e data = this.f55596i.getData();
            if (data == null) {
                data = this.f55596i.getFirstLoadData();
            }
            g(data);
        }
    }

    public final void m(e eVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) || eVar == null) {
            return;
        }
        if (eVar.O() != null) {
            String Q = eVar.Q();
            str = eVar.O().L() != null ? eVar.O().L().oriUgcNid : null;
            r1 = Q;
        } else {
            str = null;
        }
        if (r1 != this.l || str != this.m) {
            n();
        }
        this.l = r1;
        this.m = str;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f55594g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            i();
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f55595h) == null) {
            return;
        }
        pbListView.G(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.g(TbadkApplication.getInst(), R.dimen.tbds256));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f55596i == null) {
                return;
            }
            l();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f55592e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.j2.o.f.c cVar = this.f55597j;
            if (cVar != null) {
                cVar.l();
            }
            PbListView pbListView = this.f55595h;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            if (c.a.q0.g1.b.e.d()) {
                SkinManager.setBackgroundColor(this.f55594g, R.color.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f55594g;
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
            if (getPbActivity() != null) {
                this.o.setTag(getPbActivity().getUniqueId());
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
            this.f55596i = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
            j(inflate);
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

    public void receiveFling(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeRecyclerView = this.f55594g) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    @Override // c.a.r0.j2.o.a
    public void refresh(boolean z, int i2, int i3, int i4, e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || eVar == null || getActivity() == null) {
            return;
        }
        g(eVar);
    }

    public void refreshByBrowseMode() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || getPbModel() == null || getPbModel().O0() == null) {
            return;
        }
        g(getPbModel().O0());
    }

    public void refreshFirstFloor() {
        c.a.r0.j2.o.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.f55597j) == null) {
            return;
        }
        cVar.m();
    }
}
