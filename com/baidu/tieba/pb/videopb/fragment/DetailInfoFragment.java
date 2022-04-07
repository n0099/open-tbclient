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
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz7;
import com.repackage.iz7;
import com.repackage.oi;
import com.repackage.vk8;
import com.repackage.yr7;
import java.util.List;
/* loaded from: classes3.dex */
public class DetailInfoFragment extends BaseFragment implements bz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public BdTypeRecyclerView c;
    public PbListView d;
    public VideoPbViewModel e;
    public iz7 f;
    public int g;
    public String h;
    public String i;
    public RecyclerView.OnScrollListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoFragment a;

        public a(DetailInfoFragment detailInfoFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 && this.a.b != null) {
                    this.a.b.i4();
                }
                if (i != 0 || recyclerView.canScrollVertically(-1) || this.a.b == null || this.a.b.K3()) {
                    return;
                }
                this.a.e.u(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                if (canScrollVertically && i2 > 0 && this.a.b != null && !this.a.b.K3() && ((e = this.a.e.e()) == null || e.getValue() == null || e.getValue().booleanValue())) {
                    this.a.e.u(false);
                }
                if (!canScrollVertically) {
                    if (Math.abs(i2) > 0 && this.a.g != 0 && this.a.b != null) {
                        this.a.b.A4(8);
                    }
                    this.a.g = 0;
                    return;
                }
                if (Math.abs(i2) > 0 && this.a.b != null && this.a.g == 0) {
                    this.a.b.A4(0);
                }
                this.a.g = 2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DetailInfoFragment detailInfoFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w() == null || this.a.w().T0() == null) {
                return;
            }
            this.a.w().T0().a();
            this.a.w().u1();
            this.a.f.n(this.a.w().T0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DetailInfoFragment detailInfoFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w() == null || this.a.w().T0() == null) {
                return;
            }
            this.a.I0((String) customResponsedMessage.getData());
            this.a.w().u1();
            this.a.f.n(this.a.w().T0());
        }
    }

    public DetailInfoFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        this.j = new a(this);
        this.k = new b(this, 2016488);
        this.l = new c(this, 2016331);
    }

    public static DetailInfoFragment N0(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
            detailInfoFragment.setArguments(bundle);
            detailInfoFragment.b = absVideoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    public final void H0(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, yr7Var) == null) || this.e == null || yr7Var == null) {
            return;
        }
        Q0(yr7Var);
        O0(yr7Var);
        this.f.n(yr7Var);
        if (this.a instanceof PbActivity) {
            this.e.v(false);
            ((PbActivity) this.a).logOnPbDataSet(yr7Var.g());
        }
    }

    public final void I0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<vk8> Y = w().T0().Y();
        for (vk8 vk8Var : Y) {
            if (TextUtils.equals(str, vk8Var.N0())) {
                Y.remove(vk8Var);
                return;
            }
        }
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.intValue;
    }

    public final void K0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pbListView = this.d) == null) {
            return;
        }
        pbListView.k();
    }

    public final void L0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091695);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.addOnScrollListener(this.j);
            this.c.setOnTouchListener(t().d3());
            PbListView pbListView = new PbListView(getContext());
            this.d = pbListView;
            pbListView.b();
            this.d.C("");
            this.d.p(R.color.CAM_X0205);
            this.d.x();
            this.d.E(SkinManager.getColor(R.color.CAM_X0107));
            this.d.G(R.dimen.tbfontsize33);
            this.d.A(R.color.CAM_X0110);
            this.d.t(oi.f(getContext(), R.dimen.tbds182));
            this.d.s();
            this.c.setNextPage(this.d);
            this.f = new iz7(this, this.c);
            if (w() == null || w().C1()) {
                return;
            }
            this.b.o4(8);
        }
    }

    public void M0() {
        yr7 T0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (T0 = w().T0()) == null) {
            return;
        }
        this.f.n(T0);
        this.f.l();
    }

    public final void O0(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, yr7Var) == null) || yr7Var == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            K0();
        } else if (ListUtils.isEmpty(yr7Var.f())) {
            V0();
        } else {
            K0();
            this.d.C(getString(R.string.obfuscated_res_0x7f0f0f5b));
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            yr7 c2 = this.e.c();
            if (c2 == null) {
                c2 = this.e.d();
            }
            H0(c2);
        }
    }

    public final void Q0(yr7 yr7Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yr7Var) == null) || yr7Var == null) {
            return;
        }
        if (yr7Var.O() != null) {
            String Q = yr7Var.Q();
            str = yr7Var.O().getBaijiahaoData() != null ? yr7Var.O().getBaijiahaoData().oriUgcNid : null;
            r1 = Q;
        } else {
            str = null;
        }
        if (r1 != this.h || str != this.i) {
            U0();
        }
        this.h = r1;
        this.i = str;
    }

    public void R0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdTypeRecyclerView = this.c) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || w() == null || w().T0() == null) {
            return;
        }
        H0(w().T0());
    }

    public void T0() {
        iz7 iz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iz7Var = this.f) == null) {
            return;
        }
        iz7Var.m();
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            K0();
        }
    }

    public final void V0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.d) == null) {
            return;
        }
        pbListView.I(getString(R.string.obfuscated_res_0x7f0f0c5b), R.drawable.new_pic_emotion_08, oi.f(TbadkApplication.getInst(), R.dimen.tbds256));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.e == null) {
                return;
            }
            P0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            super.onChangeSkinType(i);
            iz7 iz7Var = this.f;
            if (iz7Var != null) {
                iz7Var.l();
            }
            PbListView pbListView = this.d;
            if (pbListView != null) {
                pbListView.d(i);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
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
            MessageManager.getInstance().registerListener(this.l);
            this.k.setSelfListener(true);
            if (x() != null) {
                this.k.setTag(x().getUniqueId());
            } else if (getPageContext() != null) {
                this.k.setTag(getPageContext().getUniqueId());
            }
            this.k.setPriority(-1);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0676, viewGroup, false);
            this.e = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
            L0(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.k);
            super.onDestroy();
        }
    }

    public AbsVideoPbFragment t() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.repackage.bz7
    public void t0(boolean z, int i, int i2, int i3, yr7 yr7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), yr7Var, str, Integer.valueOf(i4)}) == null) || yr7Var == null || getActivity() == null) {
            return;
        }
        H0(yr7Var);
    }

    public PbModel w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? t().w() : (PbModel) invokeV.objValue;
    }

    public AbsPbActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : this.b.x();
        }
        return (AbsPbActivity) invokeV.objValue;
    }
}
