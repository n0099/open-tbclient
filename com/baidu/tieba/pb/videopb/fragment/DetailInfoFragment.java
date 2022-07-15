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
import com.repackage.jr7;
import com.repackage.ni8;
import com.repackage.pi;
import com.repackage.py7;
import com.repackage.wy7;
import java.util.List;
/* loaded from: classes3.dex */
public class DetailInfoFragment extends BaseFragment implements py7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public BdTypeRecyclerView c;
    public PbListView d;
    public VideoPbViewModel e;
    public wy7 f;
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
                    this.a.b.c5();
                }
                if (i != 0 || recyclerView.canScrollVertically(-1) || this.a.b == null || this.a.b.E4()) {
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
                if (canScrollVertically && i2 > 0 && this.a.b != null && !this.a.b.E4() && ((e = this.a.e.e()) == null || e.getValue() == null || e.getValue().booleanValue())) {
                    this.a.e.u(false);
                }
                if (!canScrollVertically) {
                    if (Math.abs(i2) > 0 && this.a.g != 0 && this.a.b != null) {
                        this.a.b.u5(8);
                    }
                    this.a.g = 0;
                    return;
                }
                if (Math.abs(i2) > 0 && this.a.b != null && this.a.g == 0) {
                    this.a.b.u5(0);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.F() == null || this.a.F().R1() == null) {
                return;
            }
            this.a.F().R1().a();
            this.a.F().s2();
            this.a.f.n(this.a.F().R1());
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.F() == null || this.a.F().R1() == null) {
                return;
            }
            this.a.A1((String) customResponsedMessage.getData());
            this.a.F().s2();
            this.a.f.n(this.a.F().R1());
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

    public static DetailInfoFragment F1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
            detailInfoFragment.setArguments(bundle);
            detailInfoFragment.b = absVideoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    public final void A1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<ni8> Y = F().R1().Y();
        for (ni8 ni8Var : Y) {
            if (TextUtils.equals(str, ni8Var.R0())) {
                Y.remove(ni8Var);
                return;
            }
        }
    }

    public AbsVideoPbFragment B() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment E0 = absPbActivity.E0();
                if (E0 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) E0;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.intValue;
    }

    public final void C1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pbListView = this.d) == null) {
            return;
        }
        pbListView.k();
    }

    public final void D1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09170e);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.addOnScrollListener(this.j);
            this.c.setOnTouchListener(B().X3());
            PbListView pbListView = new PbListView(getContext());
            this.d = pbListView;
            pbListView.b();
            this.d.C("");
            this.d.p(R.color.CAM_X0205);
            this.d.x();
            this.d.E(SkinManager.getColor(R.color.CAM_X0107));
            this.d.G(R.dimen.tbfontsize33);
            this.d.A(R.color.CAM_X0110);
            this.d.t(pi.f(getContext(), R.dimen.tbds182));
            this.d.s();
            this.c.setNextPage(this.d);
            this.f = new wy7(this, this.c);
            if (F() == null || F().A2()) {
                return;
            }
            this.b.i5(8);
        }
    }

    public void E1() {
        jr7 R1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (R1 = F().R1()) == null) {
            return;
        }
        this.f.n(R1);
        this.f.l();
    }

    public PbModel F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? B().F() : (PbModel) invokeV.objValue;
    }

    public final void G1(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            C1();
        } else if (ListUtils.isEmpty(jr7Var.f())) {
            N1();
        } else {
            C1();
            this.d.C(getString(R.string.obfuscated_res_0x7f0f0f8d));
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            jr7 c2 = this.e.c();
            if (c2 == null) {
                c2 = this.e.d();
            }
            y1(c2);
        }
    }

    public final void I1(jr7 jr7Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        if (jr7Var.O() != null) {
            String Q = jr7Var.Q();
            str = jr7Var.O().getBaijiahaoData() != null ? jr7Var.O().getBaijiahaoData().oriUgcNid : null;
            r1 = Q;
        } else {
            str = null;
        }
        if (r1 != this.h || str != this.i) {
            M1();
        }
        this.h = r1;
        this.i = str;
    }

    public void J1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdTypeRecyclerView = this.c) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || F() == null || F().R1() == null) {
            return;
        }
        y1(F().R1());
    }

    public void L1() {
        wy7 wy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (wy7Var = this.f) == null) {
            return;
        }
        wy7Var.m();
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            C1();
        }
    }

    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : this.b.N();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final void N1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.d) == null) {
            return;
        }
        pbListView.I(getString(R.string.obfuscated_res_0x7f0f0c72), R.drawable.new_pic_emotion_08, pi.f(TbadkApplication.getInst(), R.dimen.tbds256));
    }

    @Override // com.repackage.py7
    public void i1(boolean z, int i, int i2, int i3, jr7 jr7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jr7Var, str, Integer.valueOf(i4)}) == null) || jr7Var == null || getActivity() == null) {
            return;
        }
        y1(jr7Var);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.e == null) {
                return;
            }
            H1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            super.onChangeSkinType(i);
            wy7 wy7Var = this.f;
            if (wy7Var != null) {
                wy7Var.l();
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
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().registerListener(this.l);
            this.k.setSelfListener(true);
            if (N() != null) {
                this.k.setTag(N().getUniqueId());
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0677, viewGroup, false);
            this.e = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
            D1(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.k);
            super.onDestroy();
        }
    }

    public final void y1(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, jr7Var) == null) || this.e == null || jr7Var == null) {
            return;
        }
        I1(jr7Var);
        G1(jr7Var);
        this.f.n(jr7Var);
        if (this.a instanceof PbActivity) {
            this.e.v(false);
            ((PbActivity) this.a).j1(jr7Var.g(), this.c);
        }
    }
}
