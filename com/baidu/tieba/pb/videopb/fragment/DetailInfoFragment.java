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
import b.a.e.e.p.l;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.r.f;
import b.a.r0.l3.j0.p;
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
/* loaded from: classes9.dex */
public class DetailInfoFragment extends BaseFragment implements b.a.r0.k2.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f52807e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f52808f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f52809g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f52810h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPbViewModel f52811i;
    public b.a.r0.k2.y.f.c j;
    public int k;
    public String l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f52812a;

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
            this.f52812a = detailInfoFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 && this.f52812a.f52808f != null) {
                    this.f52812a.f52808f.resetCommentView();
                }
                if (i2 != 0 || recyclerView.canScrollVertically(-1) || this.f52812a.f52808f == null || this.f52812a.f52808f.isVerticalVideo()) {
                    return;
                }
                this.f52812a.f52811i.setIsDetailTabTop(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            MutableLiveData<Boolean> isDetailTabTop;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                if (canScrollVertically && i3 > 0 && this.f52812a.f52808f != null && !this.f52812a.f52808f.isVerticalVideo() && ((isDetailTabTop = this.f52812a.f52811i.getIsDetailTabTop()) == null || isDetailTabTop.getValue() == null || isDetailTabTop.getValue().booleanValue())) {
                    this.f52812a.f52811i.setIsDetailTabTop(false);
                }
                if (!canScrollVertically) {
                    if (Math.abs(i3) > 0 && this.f52812a.k != 0 && this.f52812a.f52808f != null) {
                        this.f52812a.f52808f.setShadowVisible(8);
                    }
                    this.f52812a.k = 0;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f52812a.f52808f != null && this.f52812a.k == 0) {
                    this.f52812a.f52808f.setShadowVisible(0);
                }
                this.f52812a.k = 2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f52813a;

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
            this.f52813a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f52813a.getPbModel() == null || this.f52813a.getPbModel().P0() == null) {
                return;
            }
            this.f52813a.getPbModel().P0().a();
            this.f52813a.getPbModel().o1();
            this.f52813a.j.n(this.f52813a.getPbModel().P0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoFragment f52814a;

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
            this.f52814a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f52814a.getPbModel() == null || this.f52814a.getPbModel().P0() == null) {
                return;
            }
            this.f52814a.h((String) customResponsedMessage.getData());
            this.f52814a.getPbModel().o1();
            this.f52814a.j.n(this.f52814a.getPbModel().P0());
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
            detailInfoFragment.f52808f = absVideoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    public final void g(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || this.f52811i == null || fVar == null) {
            return;
        }
        m(fVar);
        k(fVar);
        this.j.n(fVar);
    }

    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AbsPbActivity absPbActivity = this.f52807e;
            return absPbActivity != null ? absPbActivity : this.f52808f.getPbActivity();
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
            if (this.f52808f == null && (absPbActivity = this.f52807e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f52808f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f52808f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<p> Y = getPbModel().P0().Y();
        for (p pVar : Y) {
            if (TextUtils.equals(str, pVar.J0())) {
                Y.remove(pVar);
                return;
            }
        }
    }

    public final void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.f52810h) == null) {
            return;
        }
        pbListView.k();
    }

    public void invalidataData() {
        f P0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (P0 = getPbModel().P0()) == null) {
            return;
        }
        this.j.n(P0);
        this.j.l();
    }

    public final void j(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(i.pb_detail_info_list);
            this.f52809g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f52809g.addOnScrollListener(this.n);
            this.f52809g.setOnTouchListener(getVideoPbFragment().getOnTouchListener());
            PbListView pbListView = new PbListView(getContext());
            this.f52810h = pbListView;
            pbListView.b();
            this.f52810h.C("");
            this.f52810h.p(b.a.r0.k2.f.CAM_X0205);
            this.f52810h.x();
            this.f52810h.E(SkinManager.getColor(b.a.r0.k2.f.CAM_X0107));
            this.f52810h.G(g.tbfontsize33);
            this.f52810h.A(b.a.r0.k2.f.CAM_X0110);
            this.f52810h.s(l.g(getContext(), g.tbds182));
            this.f52810h.r();
            if (!b.a.q0.g1.b.c.d()) {
                this.f52809g.setNextPage(this.f52810h);
            }
            this.j = new b.a.r0.k2.y.f.c(this, this.f52809g);
            if (getPbModel() == null || getPbModel().s1()) {
                return;
            }
            this.f52808f.setCommentContainerVisible(8);
        }
    }

    public final void k(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            i();
        } else if (ListUtils.isEmpty(fVar.f())) {
            o();
        } else {
            i();
            this.f52810h.C(getString(b.a.r0.k2.l.recommend_no_more_data));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f data = this.f52811i.getData();
            if (data == null) {
                data = this.f52811i.getFirstLoadData();
            }
            g(data);
        }
    }

    public final void m(f fVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.O() != null) {
            String Q = fVar.Q();
            str = fVar.O().L() != null ? fVar.O().L().oriUgcNid : null;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f52809g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            i();
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f52810h) == null) {
            return;
        }
        pbListView.I(getString(b.a.r0.k2.l.no_relevant_content), h.new_pic_emotion_08, l.g(TbadkApplication.getInst(), g.tbds256));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f52811i == null) {
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
                this.f52807e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.k2.y.f.c cVar = this.j;
            if (cVar != null) {
                cVar.l();
            }
            PbListView pbListView = this.f52810h;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            if (b.a.q0.g1.b.c.d()) {
                SkinManager.setBackgroundColor(this.f52809g, b.a.r0.k2.f.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f52809g;
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
            View inflate = layoutInflater.inflate(j.pb_detail_info_fragment, viewGroup, false);
            this.f52811i = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
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
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeRecyclerView = this.f52809g) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    @Override // b.a.r0.k2.y.a
    public void refresh(boolean z, int i2, int i3, int i4, f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) || fVar == null || getActivity() == null) {
            return;
        }
        g(fVar);
    }

    public void refreshByBrowseMode() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || getPbModel() == null || getPbModel().P0() == null) {
            return;
        }
        g(getPbModel().P0());
    }

    public void refreshFirstFloor() {
        b.a.r0.k2.y.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.m();
    }
}
