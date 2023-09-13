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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.aa5;
import com.baidu.tieba.cn;
import com.baidu.tieba.f0a;
import com.baidu.tieba.g0a;
import com.baidu.tieba.i0a;
import com.baidu.tieba.j0a;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.wn5;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, f0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BdListView b;
    public NavigationBarShadowView c;
    public j0a d;
    public boolean e;
    public NoDataView f;
    public wn5 g;
    public aa5 h;
    public PbListView i;
    public View j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public g0a o;
    public View.OnClickListener p;
    public PersonPostModel.c q;

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                PersonReplyFragment personReplyFragment = this.a;
                wn5 wn5Var = personReplyFragment.g;
                if (wn5Var != null) {
                    wn5Var.dettachView(personReplyFragment.a);
                    this.a.g = null;
                }
                if (this.a.o != null) {
                    this.a.o.u();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements z95.g {
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

        @Override // com.baidu.tieba.z95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.d.f(true);
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public void B0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) || !this.a.isAdded()) {
                return;
            }
            PersonReplyFragment personReplyFragment = this.a;
            personReplyFragment.hideLoadingView(personReplyFragment.a);
            this.a.b.z(0L);
            if (personPostModel != null && (PersonReplyFragment.k2(personPostModel.postList) != 0 || !this.a.n || !StringUtils.isNull(personPostModel.getErrorString()))) {
                if (this.a.d.getCount() == 0) {
                    this.a.b.setVisibility(8);
                    this.a.i2(true);
                } else {
                    this.a.b.setVisibility(0);
                    this.a.i2(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    BdUtilHelper.showToast(this.a.getActivity(), personPostModel.getErrorString());
                }
                int k2 = PersonReplyFragment.k2(personPostModel.postList);
                if (k2 <= 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.j.setVisibility(8);
                    } else {
                        this.a.k = false;
                        this.a.i.H(this.a.getResources().getString(R.string.list_no_more));
                        this.a.j.setVisibility(0);
                    }
                }
                this.a.i.g();
                if (z) {
                    if (k2 <= 0) {
                        this.a.k = false;
                    } else {
                        this.a.k = true;
                    }
                    this.a.l = 0;
                    this.a.n = false;
                    return;
                }
                return;
            }
            this.a.b.setVisibility(0);
            this.a.i2(true);
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || i < 0 || this.a.d == null || i >= this.a.d.getCount() || (h = this.a.d.h(i)) == null) {
                return;
            }
            if (StringUtils.isNotNull(h.targetScheme)) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{h.targetScheme});
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

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.d.f(true);
                return;
            }
            hideLoadingView(this.a);
            i2(false);
            i0a.b(this.g, this.p, getActivity(), this.a, getString(R.string.obfuscated_res_0x7f0f0e40), true);
            this.b.setVisibility(8);
        }
    }

    public void n2(g0a g0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g0aVar) == null) {
            this.o = g0aVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, absListView, i) == null) && i == 1) {
            this.c.c();
        }
    }

    public static int k2(List<cn> list) {
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
                    i += ((PersonPostModel.PostInfoList) list.get(i2)).content.size();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void i2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
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

    @Override // com.baidu.tieba.f0a
    public void Z0() {
        j0a j0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (j0aVar = this.d) != null) {
            j0aVar.f(true);
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.e) {
            l2();
            this.e = true;
            showLoadingView(this.a);
            j2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            j0a j0aVar = this.d;
            if (j0aVar != null) {
                j0aVar.e();
                this.d.i(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            m2();
            this.d.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j0a j0aVar = new j0a(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
            this.d = j0aVar;
            j0aVar.i(this.q);
            this.b.setAdapter((ListAdapter) this.d);
            this.b.setOnItemClickListener(new d(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            if (!isAdded()) {
                return;
            }
            View view2 = this.j;
            if (view2 != null) {
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.e(i);
            }
            this.h.C(i);
            SkinManager.setBackgroundColor(this.a, this.m, i);
            j0a j0aVar = this.d;
            if (j0aVar != null) {
                j0aVar.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d080f, viewGroup, false);
            this.a = inflate;
            this.b = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09156f);
            this.c = (NavigationBarShadowView) this.a.findViewById(R.id.obfuscated_res_0x7f0918fc);
            this.f = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07035e)), NoDataViewFactory.e.d(null, getArguments().getString("key_empty_view_text")), null);
            return this.a;
        }
        return (View) invokeLLL.objValue;
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
                this.i.U();
            }
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.c.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            aa5 aa5Var = new aa5(getPageContext());
            this.h = aa5Var;
            this.b.setPullRefresh(aa5Var);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070387)));
            this.b.w(textView, 0);
            this.h.a(new b(this));
            this.b.setOnScrollListener(this);
            PbListView pbListView = new PbListView(getActivity());
            this.i = pbListView;
            pbListView.s(R.color.common_color_10022);
            this.i.J(SkinManager.getColor(R.color.common_color_10039));
            this.b.setNextPage(this.i);
            View findViewById = this.i.c().findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
        }
    }
}
