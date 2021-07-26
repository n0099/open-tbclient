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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.q0.q2.g;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a.q0.q2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f20484e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f20485f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f20486g;

    /* renamed from: h  reason: collision with root package name */
    public g f20487h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20488i;
    public NoDataView j;
    public h k;
    public d.a.p0.s.f0.g l;
    public PbListView m;
    public View n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public d.a.q0.q2.d s;
    public View.OnClickListener t;
    public PersonPostModel.c u;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f20489e;

        public a(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20489e = personReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                PersonReplyFragment personReplyFragment = this.f20489e;
                h hVar = personReplyFragment.k;
                if (hVar != null) {
                    hVar.dettachView(personReplyFragment.f20484e);
                    this.f20489e.k = null;
                }
                if (this.f20489e.s != null) {
                    this.f20489e.s.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f20490e;

        public b(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20490e = personReplyFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f20490e.f20487h.f(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f20491e;

        public c(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20491e = personReplyFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void M(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) && this.f20491e.isAdded()) {
                PersonReplyFragment personReplyFragment = this.f20491e;
                personReplyFragment.hideLoadingView(personReplyFragment.f20484e);
                this.f20491e.f20485f.A(0L);
                if (personPostModel == null || (PersonReplyFragment.a1(personPostModel.postList) == 0 && this.f20491e.r && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.f20491e.f20485f.setVisibility(0);
                    this.f20491e.Y0(true);
                    return;
                }
                if (this.f20491e.f20487h.getCount() == 0) {
                    this.f20491e.f20485f.setVisibility(8);
                    this.f20491e.Y0(true);
                } else {
                    this.f20491e.f20485f.setVisibility(0);
                    this.f20491e.Y0(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    l.M(this.f20491e.getActivity(), personPostModel.getErrorString());
                }
                int a1 = PersonReplyFragment.a1(personPostModel.postList);
                if (a1 <= 0) {
                    if (j.z()) {
                        this.f20491e.o = false;
                        this.f20491e.m.A(this.f20491e.getResources().getString(R.string.list_no_more));
                        this.f20491e.n.setVisibility(0);
                    } else {
                        this.f20491e.n.setVisibility(8);
                    }
                }
                this.f20491e.m.f();
                if (z) {
                    if (a1 <= 0) {
                        this.f20491e.o = false;
                    } else {
                        this.f20491e.o = true;
                    }
                    this.f20491e.p = 0;
                    this.f20491e.r = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f20492e;

        public d(PersonReplyFragment personReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20492e = personReplyFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            PersonPostModel.PostInfoList h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || this.f20492e.f20487h == null || i2 >= this.f20492e.f20487h.getCount() || (h2 = this.f20492e.f20487h.h(i2)) == null) {
                return;
            }
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.f20492e.getActivity()).createCfgForPersonCenter(String.valueOf(h2.thread_id), String.valueOf(h2.post_id), "person_page", 18005);
            OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
            if (originalThreadInfo != null) {
                createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
            }
            this.f20492e.sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    public PersonReplyFragment() {
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
        this.f20488i = false;
        this.j = null;
        this.o = false;
        this.q = R.color.CAM_X0201;
        this.r = true;
        this.t = new a(this);
        this.u = new c(this);
    }

    public static int a1(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, list)) == null) {
            if (list == null) {
                return 0;
            }
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (list.get(i3) != null && (list.get(i3) instanceof PersonPostModel.PostInfoList)) {
                    i2 += ((PersonPostModel.PostInfoList) list.get(i3)).content.length;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (this.f20485f != null) {
                    NoDataView noDataView = this.j;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.f20485f.removeHeaderView(this.j);
                    this.f20485f.addHeaderView(this.j);
                }
            } else if (this.f20485f != null) {
                NoDataView noDataView2 = this.j;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.f20485f.removeHeaderView(this.j);
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (j.A()) {
                this.f20487h.f(true);
                return;
            }
            hideLoadingView(this.f20484e);
            Y0(false);
            d.a.q0.q2.f.b(this.k, this.t, getActivity(), this.f20484e, getString(R.string.neterror), true);
            this.f20485f.setVisibility(8);
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g gVar = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
            this.f20487h = gVar;
            gVar.i(this.u);
            this.f20485f.setAdapter((ListAdapter) this.f20487h);
            this.f20485f.setOnItemClickListener(new d(this));
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f20488i) {
            return;
        }
        b1();
        this.f20488i = true;
        showLoadingView(this.f20484e);
        Z0();
    }

    public void d1(d.a.q0.q2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.s = dVar;
        }
    }

    @Override // d.a.q0.q2.c
    public void e0() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.f20487h) == null) {
            return;
        }
        gVar.f(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                View view = this.n;
                if (view != null) {
                    SkinManager.setViewTextColor((TextView) view.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
                }
                NoDataView noDataView = this.j;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                PbListView pbListView = this.m;
                if (pbListView != null) {
                    pbListView.d(i2);
                }
                this.l.I(i2);
                SkinManager.setBackgroundColor(this.f20484e, this.q, i2);
                g gVar = this.f20487h;
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
            View inflate = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
            this.f20484e = inflate;
            this.f20485f = (BdListView) inflate.findViewById(R.id.listview_reply);
            this.f20486g = (NavigationBarShadowView) this.f20484e.findViewById(R.id.navi_shadow_view_my_reply);
            this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.e.d(null, getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT)), null);
            return this.f20484e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            g gVar = this.f20487h;
            if (gVar != null) {
                gVar.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            c1();
            this.f20487h.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048587, this, absListView, i2, i3, i4) == null) {
            if (this.o && i4 > 2 && this.p != i4 && i3 + i2 == i4) {
                this.p = i4;
                this.f20487h.f(false);
                this.n.setVisibility(0);
                this.m.O();
            }
            if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f20486g.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, absListView, i2) == null) && i2 == 1) {
            this.f20486g.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            NoDataView noDataView = this.j;
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
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, bundle) == null) {
            d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(getPageContext());
            this.l = gVar;
            this.f20485f.setPullRefresh(gVar);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds176)));
            this.f20485f.x(textView, 0);
            this.l.a(new b(this));
            this.f20485f.setOnScrollListener(this);
            PbListView pbListView = new PbListView(getActivity());
            this.m = pbListView;
            pbListView.o(R.color.common_color_10022);
            this.m.C(SkinManager.getColor(R.color.common_color_10039));
            this.f20485f.setNextPage(this.m);
            View findViewById = this.m.b().findViewById(R.id.pb_more_view);
            this.n = findViewById;
            findViewById.setVisibility(8);
        }
    }
}
