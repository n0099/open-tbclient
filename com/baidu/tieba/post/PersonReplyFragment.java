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
import c.a.s0.g0.h;
import c.a.s0.s.i0.f;
import c.a.t0.d3.g;
import c.a.t0.y2.e;
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
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes12.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c.a.t0.d3.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f49247e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f49248f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f49249g;

    /* renamed from: h  reason: collision with root package name */
    public g f49250h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49251i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f49252j;

    /* renamed from: k  reason: collision with root package name */
    public h f49253k;
    public c.a.s0.s.i0.g l;
    public PbListView m;
    public View n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public c.a.t0.d3.d s;
    public View.OnClickListener t;
    public PersonPostModel.c u;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f49254e;

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
            this.f49254e = personReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                PersonReplyFragment personReplyFragment = this.f49254e;
                h hVar = personReplyFragment.f49253k;
                if (hVar != null) {
                    hVar.dettachView(personReplyFragment.f49247e);
                    this.f49254e.f49253k = null;
                }
                if (this.f49254e.s != null) {
                    this.f49254e.s.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f49255e;

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
            this.f49255e = personReplyFragment;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f49255e.f49250h.f(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f49256e;

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
            this.f49256e = personReplyFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void onResult(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) && this.f49256e.isAdded()) {
                PersonReplyFragment personReplyFragment = this.f49256e;
                personReplyFragment.hideLoadingView(personReplyFragment.f49247e);
                this.f49256e.f49248f.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.getRealPostCount(personPostModel.postList) == 0 && this.f49256e.r && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.f49256e.f49248f.setVisibility(0);
                    this.f49256e.r(true);
                    return;
                }
                if (this.f49256e.f49250h.getCount() == 0) {
                    this.f49256e.f49248f.setVisibility(8);
                    this.f49256e.r(true);
                } else {
                    this.f49256e.f49248f.setVisibility(0);
                    this.f49256e.r(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    n.M(this.f49256e.getActivity(), personPostModel.getErrorString());
                }
                int realPostCount = PersonReplyFragment.getRealPostCount(personPostModel.postList);
                if (realPostCount <= 0) {
                    if (l.z()) {
                        this.f49256e.o = false;
                        this.f49256e.m.D(this.f49256e.getResources().getString(c.a.t0.y2.g.list_no_more));
                        this.f49256e.n.setVisibility(0);
                    } else {
                        this.f49256e.n.setVisibility(8);
                    }
                }
                this.f49256e.m.f();
                if (z) {
                    if (realPostCount <= 0) {
                        this.f49256e.o = false;
                    } else {
                        this.f49256e.o = true;
                    }
                    this.f49256e.p = 0;
                    this.f49256e.r = false;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonReplyFragment f49257e;

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
            this.f49257e = personReplyFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            PersonPostModel.PostInfoList h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || this.f49257e.f49250h == null || i2 >= this.f49257e.f49250h.getCount() || (h2 = this.f49257e.f49250h.h(i2)) == null) {
                return;
            }
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.f49257e.getActivity()).createCfgForPersonCenter(String.valueOf(h2.thread_id), String.valueOf(h2.post_id), "person_page", 18005);
            OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
            if (originalThreadInfo != null) {
                createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
            }
            this.f49257e.sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
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
        this.f49251i = false;
        this.f49252j = null;
        this.o = false;
        this.q = c.a.t0.y2.a.CAM_X0201;
        this.r = true;
        this.t = new a(this);
        this.u = new c(this);
    }

    public static int getRealPostCount(List<c.a.d.n.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
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

    @Override // c.a.t0.d3.c
    public void fetchDataOnNoNetRefresh() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f49250h) == null) {
            return;
        }
        gVar.f(true);
    }

    public void onActive() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f49251i) {
            return;
        }
        t();
        this.f49251i = true;
        showLoadingView(this.f49247e);
        s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                View view = this.n;
                if (view != null) {
                    SkinManager.setViewTextColor((TextView) view.findViewById(c.a.t0.y2.d.pb_more_text), c.a.t0.y2.a.common_color_10215, 1);
                }
                NoDataView noDataView = this.f49252j;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, c.a.t0.y2.a.CAM_X0201);
                }
                PbListView pbListView = this.m;
                if (pbListView != null) {
                    pbListView.d(i2);
                }
                this.l.C(i2);
                SkinManager.setBackgroundColor(this.f49247e, this.q, i2);
                g gVar = this.f49250h;
                if (gVar != null) {
                    gVar.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(e.person_reply_fragment, viewGroup, false);
            this.f49247e = inflate;
            this.f49248f = (BdListView) inflate.findViewById(c.a.t0.y2.d.listview_reply);
            this.f49249g = (NavigationBarShadowView) this.f49247e.findViewById(c.a.t0.y2.d.navi_shadow_view_my_reply);
            this.f49252j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(c.a.t0.y2.b.ds102)), NoDataViewFactory.e.d(null, getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT)), null);
            return this.f49247e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            g gVar = this.f49250h;
            if (gVar != null) {
                gVar.e();
                this.f49250h.i(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            onActive();
            this.f49250h.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i2, i3, i4) == null) {
            if (this.o && i4 > 2 && this.p != i4 && i3 + i2 == i4) {
                this.p = i4;
                this.f49250h.f(false);
                this.n.setVisibility(0);
                this.m.R();
            }
            if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f49249g.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 1) {
            this.f49249g.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f49252j;
            if (noDataView != null) {
                noDataView.onActivityStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f49252j;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view, bundle) == null) {
            c.a.s0.s.i0.g gVar = new c.a.s0.s.i0.g(getPageContext());
            this.l = gVar;
            this.f49248f.setPullRefresh(gVar);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + n.f(getActivity(), c.a.t0.y2.b.ds176)));
            this.f49248f.addHeaderView(textView, 0);
            this.l.a(new b(this));
            this.f49248f.setOnScrollListener(this);
            PbListView pbListView = new PbListView(getActivity());
            this.m = pbListView;
            pbListView.p(c.a.t0.y2.a.common_color_10022);
            this.m.F(SkinManager.getColor(c.a.t0.y2.a.common_color_10039));
            this.f49248f.setNextPage(this.m);
            View findViewById = this.m.b().findViewById(c.a.t0.y2.d.pb_more_view);
            this.n = findViewById;
            findViewById.setVisibility(8);
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                if (this.f49248f != null) {
                    NoDataView noDataView = this.f49252j;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.f49248f.removeHeaderView(this.f49252j);
                    this.f49248f.addHeaderView(this.f49252j);
                }
            } else if (this.f49248f != null) {
                NoDataView noDataView2 = this.f49252j;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.f49248f.removeHeaderView(this.f49252j);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (l.A()) {
                this.f49250h.f(true);
                return;
            }
            hideLoadingView(this.f49247e);
            r(false);
            c.a.t0.d3.f.b(this.f49253k, this.t, getActivity(), this.f49247e, getString(c.a.t0.y2.g.neterror), true);
            this.f49248f.setVisibility(8);
        }
    }

    public void setNoNetRefreshListener(c.a.t0.d3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.s = dVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            g gVar = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
            this.f49250h = gVar;
            gVar.i(this.u);
            this.f49248f.setAdapter((ListAdapter) this.f49250h);
            this.f49248f.setOnItemClickListener(new d(this));
        }
    }
}
