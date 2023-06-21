package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.an5;
import com.baidu.tieba.cg9;
import com.baidu.tieba.dg9;
import com.baidu.tieba.mw5;
import com.baidu.tieba.s86;
import com.baidu.tieba.vi;
import com.baidu.tieba.wf9;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public FrameLayout b;
    public BdRecyclerView c;
    public NoNetworkView d;
    public an5 e;
    public NoDataView f;
    public TextView g;
    public SmartAppBrowseHistoryAdapter h;
    public cg9 i;
    public dg9 j;
    public cg9.b k;
    public dg9.b l;
    public View.OnClickListener m;
    public View.OnLongClickListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes7.dex */
    public class a implements cg9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartAppBrowseHistoryActivity a;

        public a(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartAppBrowseHistoryActivity;
        }

        @Override // com.baidu.tieba.cg9.b
        public void a(boolean z, wf9 wf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, wf9Var) == null) {
                if (z && wf9Var != null) {
                    if (this.a.h == null) {
                        return;
                    }
                    this.a.K1(ListUtils.isEmpty(wf9Var.a()));
                    this.a.L1(ListUtils.getCount(wf9Var.a()));
                    this.a.h.p(wf9Var.a());
                    this.a.h.notifyDataSetChanged();
                    return;
                }
                this.a.K1(true);
                this.a.L1(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dg9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartAppBrowseHistoryActivity a;

        public b(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartAppBrowseHistoryActivity;
        }

        @Override // com.baidu.tieba.dg9.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.h != null) {
                this.a.h.o(str);
                if (this.a.h.getItemCount() == 0) {
                    this.a.K1(true);
                }
                SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity = this.a;
                smartAppBrowseHistoryActivity.L1(smartAppBrowseHistoryActivity.h.getItemCount());
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartAppBrowseHistoryActivity a;

        public c(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
                SmartApp smartApp = (SmartApp) view2.getTag();
                if (!s86.b(smartApp.id, smartApp.link, "1191000600000000", smartApp.is_game)) {
                    if (vi.isEmpty(smartApp.h5_url)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{smartApp.h5_url});
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_source", "personal_center_list");
                statisticItem.param("obj_id", smartApp.naws_app_id.longValue());
                statisticItem.param("obj_name", smartApp.name);
                statisticItem.param("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(statisticItem);
                if (this.a.h != null) {
                    this.a.h.l(smartApp);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartAppBrowseHistoryActivity a;

        public d(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2.getTag() instanceof SmartApp) {
                    SmartApp smartApp = (SmartApp) view2.getTag();
                    if (this.a.j == null) {
                        this.a.j = new dg9(this.a.getPageContext());
                        this.a.j.e();
                        this.a.j.f(this.a.l);
                    }
                    this.a.j.d(smartApp);
                    this.a.j.g();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartAppBrowseHistoryActivity a;

        public e(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.e != null) {
                    this.a.e.dettachView(this.a.b);
                    this.a.e = null;
                }
                this.a.a();
                this.a.c.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartAppBrowseHistoryActivity a;

        public f(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || mw5.a() || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                return;
            }
            this.a.a();
        }
    }

    public SmartAppBrowseHistoryActivity() {
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
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.n = new d(this);
        this.o = new e(this);
        this.p = new f(this);
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                a();
                return;
            }
            this.c.setVisibility(8);
            if (this.e == null) {
                this.e = new an5(getActivity(), this.o);
            }
            this.e.k(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
            this.e.m(getString(R.string.obfuscated_res_0x7f0f0df3));
            this.e.attachView(this.b, true);
            this.e.p();
            this.e.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            initView();
            M1();
        }
    }

    public final void K1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (this.c != null) {
                    NoDataView noDataView = this.f;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.c.removeHeaderView(this.f);
                    this.c.addHeaderView(this.f);
                }
            } else if (this.c != null) {
                NoDataView noDataView2 = this.f;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.c.removeHeaderView(this.f);
            }
        }
    }

    public final void L1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (wi.g(getActivity(), R.dimen.tbds177) * i >= wi.j(getActivity()) - this.a.getHeight()) {
                this.c.removeFooterView(this.g);
                this.c.addFooterView(this.g);
                return;
            }
            this.c.removeFooterView(this.g);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.i == null) {
                cg9 cg9Var = new cg9();
                this.i = cg9Var;
                cg9Var.h(this.k);
            }
            this.i.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            cg9 cg9Var = this.i;
            if (cg9Var != null) {
                cg9Var.c();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = this.h;
            if (smartAppBrowseHistoryAdapter != null) {
                smartAppBrowseHistoryAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0056);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091862);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f092181);
            this.f = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.d(null, getString(R.string.no_history_now)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getResources().getString(R.string.obfuscated_res_0x7f0f11ca), this.p)));
            this.f.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.b = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092180);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f09217f);
            this.c = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = new SmartAppBrowseHistoryAdapter(getActivity());
            this.h = smartAppBrowseHistoryAdapter;
            smartAppBrowseHistoryAdapter.q(this.m);
            this.h.r(this.n);
            this.c.setAdapter(this.h);
            this.g = new TextView(getActivity());
            this.g.setLayoutParams(new RecyclerView.LayoutParams(-1, wi.g(getActivity(), R.dimen.tbds182)));
            this.g.setGravity(17);
            this.g.setText(R.string.list_has_no_more);
            this.g.setTextSize(0, wi.g(getActivity(), R.dimen.tbds33));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(getPageContext(), i);
            this.d.d(getPageContext(), i);
            an5 an5Var = this.e;
            if (an5Var != null) {
                an5Var.onChangeSkinType();
            }
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                this.f.f(getPageContext(), i);
            }
            TextView textView = this.g;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            }
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = this.h;
            if (smartAppBrowseHistoryAdapter != null) {
                smartAppBrowseHistoryAdapter.notifyDataSetChanged();
            }
        }
    }
}
