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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.h08;
import com.baidu.tieba.ks8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.r78;
import com.baidu.tieba.y78;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class DetailInfoFragment extends BaseFragment implements r78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public BdTypeRecyclerView c;
    public PbListView d;
    public VideoPbViewModel e;
    public y78 f;
    public int g;
    public String h;
    public String i;
    public RecyclerView.OnScrollListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
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
                    this.a.b.d5();
                }
                if (i == 0 && !recyclerView.canScrollVertically(-1) && this.a.b != null && !this.a.b.G4()) {
                    this.a.e.u(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                if (canScrollVertically && i2 > 0 && this.a.b != null && !this.a.b.G4() && ((e = this.a.e.e()) == null || e.getValue() == null || e.getValue().booleanValue())) {
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.M() != null && this.a.M().l1() != null) {
                this.a.M().l1().a();
                this.a.M().O1();
                this.a.f.n(this.a.M().l1());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.M() != null && this.a.M().l1() != null) {
                this.a.E1((String) customResponsedMessage.getData());
                this.a.M().O1();
                this.a.f.n(this.a.M().l1());
            }
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

    public static DetailInfoFragment J1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
            detailInfoFragment.setArguments(bundle);
            detailInfoFragment.b = absVideoPbFragment;
            return detailInfoFragment;
        }
        return (DetailInfoFragment) invokeL.objValue;
    }

    public void N1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (bdTypeRecyclerView = this.c) != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.e == null) {
                return;
            }
            L1();
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
            y78 y78Var = this.f;
            if (y78Var != null) {
                y78Var.l();
            }
            PbListView pbListView = this.d;
            if (pbListView != null) {
                pbListView.e(i);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    public final void D1(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, h08Var) != null) || this.e == null || h08Var == null) {
            return;
        }
        M1(h08Var);
        K1(h08Var);
        this.f.n(h08Var);
        if (this.a instanceof PbActivity) {
            this.e.v(false);
            ((PbActivity) this.a).B1(h08Var.g(), this.c);
        }
    }

    public final void E1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<ks8> c0 = M().l1().c0();
        for (ks8 ks8Var : c0) {
            if (TextUtils.equals(str, ks8Var.n1())) {
                c0.remove(ks8Var);
                return;
            }
        }
    }

    public final void K1(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, h08Var) != null) || h08Var == null) {
            return;
        }
        if (PermissionUtil.isBrowseMode()) {
            G1();
        } else if (ListUtils.isEmpty(h08Var.f())) {
            Q1();
        } else {
            G1();
            this.d.F(getString(R.string.recommend_no_more_data));
        }
    }

    public final void M1(h08 h08Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, h08Var) != null) || h08Var == null) {
            return;
        }
        String str2 = null;
        if (h08Var.Q() != null) {
            String S = h08Var.S();
            if (h08Var.Q().getBaijiahaoData() != null) {
                str2 = h08Var.Q().getBaijiahaoData().oriUgcNid;
            }
            str = str2;
            str2 = S;
        } else {
            str = null;
        }
        if (str2 != this.h || str != this.i) {
            P1();
        }
        this.h = str2;
        this.i = str;
    }

    public int F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final void G1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pbListView = this.d) != null) {
            pbListView.m();
        }
    }

    public void I1() {
        h08 l1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (l1 = M().l1()) == null) {
            return;
        }
        this.f.n(l1);
        this.f.l();
    }

    public AbsVideoPbFragment J() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment e1 = absPbActivity.e1();
                if (e1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) e1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h08 c2 = this.e.c();
            if (c2 == null) {
                c2 = this.e.d();
            }
            D1(c2);
        }
    }

    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return J().M();
        }
        return (PbModel) invokeV.objValue;
    }

    public void O1() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (y78Var = this.f) != null) {
            y78Var.m();
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            G1();
        }
    }

    public final void Q1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (pbListView = this.d) != null) {
            pbListView.L(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, yi.g(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public AbsPbActivity R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return this.b.R();
        }
        return (AbsPbActivity) invokeV.objValue;
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

    public final void H1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09188f);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.addOnScrollListener(this.j);
            this.c.setOnTouchListener(J().Z3());
            PbListView pbListView = new PbListView(getContext());
            this.d = pbListView;
            pbListView.c();
            this.d.F("");
            this.d.r(R.color.CAM_X0205);
            this.d.A();
            this.d.H(SkinManager.getColor(R.color.CAM_X0107));
            this.d.J(R.dimen.tbfontsize33);
            this.d.D(R.color.CAM_X0110);
            this.d.v(yi.g(getContext(), R.dimen.tbds182));
            this.d.u();
            this.c.setNextPage(this.d);
            this.f = new y78(this, this.c);
            if (M() != null && !M().W1()) {
                this.b.i5(8);
            }
        }
    }

    @Override // com.baidu.tieba.r78
    public void n1(boolean z, int i, int i2, int i3, h08 h08Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), h08Var, str, Integer.valueOf(i4)}) == null) && h08Var != null && getActivity() != null) {
            D1(h08Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().registerListener(this.l);
            this.k.setSelfListener(true);
            if (R() != null) {
                this.k.setTag(R().getUniqueId());
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
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06e7, viewGroup, false);
            this.e = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
            H1(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
