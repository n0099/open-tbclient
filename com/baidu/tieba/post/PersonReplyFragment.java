package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.av4;
import com.repackage.bv4;
import com.repackage.h65;
import com.repackage.o98;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.p98;
import com.repackage.qi;
import com.repackage.r98;
import com.repackage.s98;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, o98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BdListView b;
    public NavigationBarShadowView c;
    public s98 d;
    public boolean e;
    public NoDataView f;
    public h65 g;
    public bv4 h;
    public PbListView i;
    public View j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public p98 o;
    public View.OnClickListener p;
    public PersonPostModel.c q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonReplyFragment a;

        public a(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && oi.A()) {
                PersonReplyFragment personReplyFragment = this.a;
                h65 h65Var = personReplyFragment.g;
                if (h65Var != null) {
                    h65Var.dettachView(personReplyFragment.a);
                    this.a.g = null;
                }
                if (this.a.o != null) {
                    this.a.o.m();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements av4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonReplyFragment a;

        public b(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personReplyFragment;
        }

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.d.f(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonReplyFragment a;

        public c(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personReplyFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void j0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) && this.a.isAdded()) {
                PersonReplyFragment personReplyFragment = this.a;
                personReplyFragment.hideLoadingView(personReplyFragment.a);
                this.a.b.A(0L);
                if (personPostModel == null || (PersonReplyFragment.G1(personPostModel.postList) == 0 && this.a.n && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.a.b.setVisibility(0);
                    this.a.E1(true);
                    return;
                }
                if (this.a.d.getCount() == 0) {
                    this.a.b.setVisibility(8);
                    this.a.E1(true);
                } else {
                    this.a.b.setVisibility(0);
                    this.a.E1(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    qi.O(this.a.getActivity(), personPostModel.getErrorString());
                }
                int G1 = PersonReplyFragment.G1(personPostModel.postList);
                if (G1 <= 0) {
                    if (oi.z()) {
                        this.a.k = false;
                        this.a.i.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ea));
                        this.a.j.setVisibility(0);
                    } else {
                        this.a.j.setVisibility(8);
                    }
                }
                this.a.i.f();
                if (z) {
                    if (G1 <= 0) {
                        this.a.k = false;
                    } else {
                        this.a.k = true;
                    }
                    this.a.l = 0;
                    this.a.n = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonReplyFragment a;

        public d(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personReplyFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            PersonPostModel.PostInfoList h;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || this.a.d == null || i >= this.a.d.getCount() || (h = this.a.d.h(i)) == null) {
                return;
            }
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.a.getActivity()).createCfgForPersonCenter(String.valueOf(h.thread_id), String.valueOf(h.post_id), "person_page", 18005);
            OriginalThreadInfo originalThreadInfo = h.originalThreadInfo;
            if (originalThreadInfo != null) {
                createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
            }
            this.a.sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    public PersonReplyFragment() {
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
        this.e = false;
        this.f = null;
        this.k = false;
        this.m = R.color.CAM_X0201;
        this.n = true;
        this.p = new a(this);
        this.q = new c(this);
    }

    public static int G1(List<on> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return 0;
            }
            int size = list.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) != null && (list.get(i2) instanceof PersonPostModel.PostInfoList)) {
                    i += ((PersonPostModel.PostInfoList) list.get(i2)).content.length;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void E1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (this.b != null) {
                    NoDataView noDataView = this.f;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.b.removeHeaderView(this.f);
                    this.b.addHeaderView(this.f);
                }
            } else if (this.b != null) {
                NoDataView noDataView2 = this.f;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.b.removeHeaderView(this.f);
            }
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (oi.A()) {
                this.d.f(true);
                return;
            }
            hideLoadingView(this.a);
            E1(false);
            r98.b(this.g, this.p, getActivity(), this.a, getString(R.string.obfuscated_res_0x7f0f0c3c), true);
            this.b.setVisibility(8);
        }
    }

    @Override // com.repackage.o98
    public void G0() {
        s98 s98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (s98Var = this.d) == null) {
            return;
        }
        s98Var.f(true);
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            s98 s98Var = new s98(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
            this.d = s98Var;
            s98Var.i(this.q);
            this.b.setAdapter((ListAdapter) this.d);
            this.b.setOnItemClickListener(new d(this));
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.e) {
            return;
        }
        H1();
        this.e = true;
        showLoadingView(this.a);
        F1();
    }

    public void J1(p98 p98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p98Var) == null) {
            this.o = p98Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            if (isAdded()) {
                View view2 = this.j;
                if (view2 != null) {
                    SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f09180d), R.color.common_color_10215, 1);
                }
                NoDataView noDataView = this.f;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                PbListView pbListView = this.i;
                if (pbListView != null) {
                    pbListView.d(i);
                }
                this.h.H(i);
                SkinManager.setBackgroundColor(this.a, this.m, i);
                s98 s98Var = this.d;
                if (s98Var != null) {
                    s98Var.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0711, viewGroup, false);
            this.a = inflate;
            this.b = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09131f);
            this.c = (NavigationBarShadowView) this.a.findViewById(R.id.obfuscated_res_0x7f091614);
            this.f = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070231)), NoDataViewFactory.e.d(null, getArguments().getString("key_empty_view_text")), null);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            s98 s98Var = this.d;
            if (s98Var != null) {
                s98Var.e();
                this.d.i(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            I1();
            this.d.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048587, this, absListView, i, i2, i3) == null) {
            if (this.k && i3 > 2 && this.l != i3 && i2 + i == i3) {
                this.l = i3;
                this.d.f(false);
                this.j.setVisibility(0);
                this.i.Q();
            }
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.c.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, absListView, i) == null) && i == 1) {
            this.c.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            bv4 bv4Var = new bv4(getPageContext());
            this.h = bv4Var;
            this.b.setPullRefresh(bv4Var);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + qi.f(getActivity(), R.dimen.obfuscated_res_0x7f07025d)));
            this.b.x(textView, 0);
            this.h.f(new b(this));
            this.b.setOnScrollListener(this);
            PbListView pbListView = new PbListView(getActivity());
            this.i = pbListView;
            pbListView.p(R.color.common_color_10022);
            this.i.E(SkinManager.getColor(R.color.common_color_10039));
            this.b.setNextPage(this.i);
            View findViewById = this.i.b().findViewById(R.id.obfuscated_res_0x7f091810);
            this.j = findViewById;
            findViewById.setVisibility(8);
        }
    }
}
