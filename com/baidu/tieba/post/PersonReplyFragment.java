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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.f0.h;
import c.a.o0.r.l0.f;
import c.a.p0.f3.g;
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
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c.a.p0.f3.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f35610b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBarShadowView f35611c;

    /* renamed from: d  reason: collision with root package name */
    public g f35612d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35613e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f35614f;

    /* renamed from: g  reason: collision with root package name */
    public h f35615g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.l0.g f35616h;
    public PbListView i;
    public View j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public c.a.p0.f3.d o;
    public View.OnClickListener p;
    public PersonPostModel.c q;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                PersonReplyFragment personReplyFragment = this.a;
                h hVar = personReplyFragment.f35615g;
                if (hVar != null) {
                    hVar.dettachView(personReplyFragment.a);
                    this.a.f35615g = null;
                }
                if (this.a.o != null) {
                    this.a.o.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
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

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f35612d.f(true);
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void I(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) && this.a.isAdded()) {
                PersonReplyFragment personReplyFragment = this.a;
                personReplyFragment.hideLoadingView(personReplyFragment.a);
                this.a.f35610b.A(0L);
                if (personPostModel == null || (PersonReplyFragment.Q0(personPostModel.postList) == 0 && this.a.n && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.a.f35610b.setVisibility(0);
                    this.a.O0(true);
                    return;
                }
                if (this.a.f35612d.getCount() == 0) {
                    this.a.f35610b.setVisibility(8);
                    this.a.O0(true);
                } else {
                    this.a.f35610b.setVisibility(0);
                    this.a.O0(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    n.N(this.a.getActivity(), personPostModel.getErrorString());
                }
                int Q0 = PersonReplyFragment.Q0(personPostModel.postList);
                if (Q0 <= 0) {
                    if (l.z()) {
                        this.a.k = false;
                        this.a.i.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
                        this.a.j.setVisibility(0);
                    } else {
                        this.a.j.setVisibility(8);
                    }
                }
                this.a.i.f();
                if (z) {
                    if (Q0 <= 0) {
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

    /* loaded from: classes5.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PersonPostModel.PostInfoList h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || this.a.f35612d == null || i >= this.a.f35612d.getCount() || (h2 = this.a.f35612d.h(i)) == null) {
                return;
            }
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.a.getActivity()).createCfgForPersonCenter(String.valueOf(h2.thread_id), String.valueOf(h2.post_id), "person_page", 18005);
            OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
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
        this.f35613e = false;
        this.f35614f = null;
        this.k = false;
        this.m = R.color.CAM_X0201;
        this.n = true;
        this.p = new a(this);
        this.q = new c(this);
    }

    public static int Q0(List<c.a.d.o.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, list)) == null) {
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

    public final void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (this.f35610b != null) {
                    NoDataView noDataView = this.f35614f;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.f35610b.removeHeaderView(this.f35614f);
                    this.f35610b.addHeaderView(this.f35614f);
                }
            } else if (this.f35610b != null) {
                NoDataView noDataView2 = this.f35614f;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.f35610b.removeHeaderView(this.f35614f);
            }
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (l.A()) {
                this.f35612d.f(true);
                return;
            }
            hideLoadingView(this.a);
            O0(false);
            c.a.p0.f3.f.b(this.f35615g, this.p, getActivity(), this.a, getString(R.string.obfuscated_res_0x7f0f0c15), true);
            this.f35610b.setVisibility(8);
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g gVar = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
            this.f35612d = gVar;
            gVar.i(this.q);
            this.f35610b.setAdapter((ListAdapter) this.f35612d);
            this.f35610b.setOnItemClickListener(new d(this));
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f35613e) {
            return;
        }
        R0();
        this.f35613e = true;
        showLoadingView(this.a);
        P0();
    }

    public void T0(c.a.p0.f3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.o = dVar;
        }
    }

    @Override // c.a.p0.f3.c
    public void Y() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.f35612d) == null) {
            return;
        }
        gVar.f(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            if (isAdded()) {
                View view = this.j;
                if (view != null) {
                    SkinManager.setViewTextColor((TextView) view.findViewById(R.id.obfuscated_res_0x7f0916ed), R.color.common_color_10215, 1);
                }
                NoDataView noDataView = this.f35614f;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                PbListView pbListView = this.i;
                if (pbListView != null) {
                    pbListView.d(i);
                }
                this.f35616h.H(i);
                SkinManager.setBackgroundColor(this.a, this.m, i);
                g gVar = this.f35612d;
                if (gVar != null) {
                    gVar.notifyDataSetChanged();
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
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06dc, viewGroup, false);
            this.a = inflate;
            this.f35610b = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09128d);
            this.f35611c = (NavigationBarShadowView) this.a.findViewById(R.id.obfuscated_res_0x7f091507);
            this.f35614f = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07022a)), NoDataViewFactory.e.d(null, getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT)), null);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            g gVar = this.f35612d;
            if (gVar != null) {
                gVar.e();
                this.f35612d.i(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            S0();
            this.f35612d.notifyDataSetChanged();
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
                this.f35612d.f(false);
                this.j.setVisibility(0);
                this.i.R();
            }
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f35611c.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, absListView, i) == null) && i == 1) {
            this.f35611c.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f35614f;
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
            NoDataView noDataView = this.f35614f;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, bundle) == null) {
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(getPageContext());
            this.f35616h = gVar;
            this.f35610b.setPullRefresh(gVar);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + n.f(getActivity(), R.dimen.obfuscated_res_0x7f070255)));
            this.f35610b.x(textView, 0);
            this.f35616h.f(new b(this));
            this.f35610b.setOnScrollListener(this);
            PbListView pbListView = new PbListView(getActivity());
            this.i = pbListView;
            pbListView.p(R.color.common_color_10022);
            this.i.F(SkinManager.getColor(R.color.common_color_10039));
            this.f35610b.setNextPage(this.i);
            View findViewById = this.i.b().findViewById(R.id.obfuscated_res_0x7f0916f0);
            this.j = findViewById;
            findViewById.setVisibility(8);
        }
    }
}
