package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.o0.z0.l;
import d.a.p0.l2.h;
import d.a.p0.l2.i;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SmartAppBrowseHistoryAdapter mAdapter;
    public h.b mDataLoadCallback;
    public i mHistoryRecordMoreDialog;
    public i.b mItemMoreDialogCallBack;
    public FrameLayout mListContainer;
    public h mModel;
    public NavigationBar mNavigationBar;
    public d.a.o0.d0.h mNetRefreshView;
    public NoDataView mNoDataView;
    public View.OnClickListener mNoDataViewRefreshListener;
    public TextView mNoMoreDataView;
    public NoNetworkView mNoNetworkView;
    public View.OnClickListener mOnItemClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public View.OnClickListener mOnNoNetButtonClickListener;
    public BdRecyclerView mRecyclerView;

    /* loaded from: classes4.dex */
    public class a implements h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmartAppBrowseHistoryActivity f20153a;

        public a(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20153a = smartAppBrowseHistoryActivity;
        }

        @Override // d.a.p0.l2.h.b
        public void a(boolean z, d.a.p0.l2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
                if (!z || aVar == null) {
                    this.f20153a.dealNoDataView(true);
                    this.f20153a.dealNoMoreDataView(0);
                } else if (this.f20153a.mAdapter != null) {
                    this.f20153a.dealNoDataView(ListUtils.isEmpty(aVar.a()));
                    this.f20153a.dealNoMoreDataView(ListUtils.getCount(aVar.a()));
                    this.f20153a.mAdapter.i(aVar.a());
                    this.f20153a.mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmartAppBrowseHistoryActivity f20154a;

        public b(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20154a = smartAppBrowseHistoryActivity;
        }

        @Override // d.a.p0.l2.i.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f20154a.mAdapter == null) {
                return;
            }
            this.f20154a.mAdapter.h(str);
            if (this.f20154a.mAdapter.getItemCount() == 0) {
                this.f20154a.dealNoDataView(true);
            }
            SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity = this.f20154a;
            smartAppBrowseHistoryActivity.dealNoMoreDataView(smartAppBrowseHistoryActivity.mAdapter.getItemCount());
            this.f20154a.mAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartAppBrowseHistoryActivity f20155e;

        public c(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20155e = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SmartApp)) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (!d.a.p0.u.a.b(smartApp.id, smartApp.link, "1191000600000000", smartApp.is_game)) {
                    if (k.isEmpty(smartApp.h5_url)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f20155e.getPageContext(), new String[]{smartApp.h5_url});
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_source", "personal_center_list");
                statisticItem.param("obj_id", smartApp.swan_app_id.longValue());
                statisticItem.param("obj_name", smartApp.name);
                statisticItem.param("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(statisticItem);
                if (this.f20155e.mAdapter != null) {
                    this.f20155e.mAdapter.e(smartApp);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartAppBrowseHistoryActivity f20156e;

        public d(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20156e = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view.getTag() instanceof SmartApp) {
                    SmartApp smartApp = (SmartApp) view.getTag();
                    if (this.f20156e.mHistoryRecordMoreDialog == null) {
                        this.f20156e.mHistoryRecordMoreDialog = new i(this.f20156e.getPageContext());
                        this.f20156e.mHistoryRecordMoreDialog.e();
                        this.f20156e.mHistoryRecordMoreDialog.f(this.f20156e.mItemMoreDialogCallBack);
                    }
                    this.f20156e.mHistoryRecordMoreDialog.d(smartApp);
                    this.f20156e.mHistoryRecordMoreDialog.g();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartAppBrowseHistoryActivity f20157e;

        public e(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20157e = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                if (this.f20157e.mNetRefreshView != null) {
                    this.f20157e.mNetRefreshView.dettachView(this.f20157e.mListContainer);
                    this.f20157e.mNetRefreshView = null;
                }
                this.f20157e.loadData();
                this.f20157e.mRecyclerView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartAppBrowseHistoryActivity f20158e;

        public f(SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartAppBrowseHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20158e = smartAppBrowseHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !l.a() && j.A()) {
                this.f20158e.loadData();
            }
        }
    }

    public SmartAppBrowseHistoryActivity() {
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
        this.mDataLoadCallback = new a(this);
        this.mItemMoreDialogCallBack = new b(this);
        this.mOnItemClickListener = new c(this);
        this.mOnLongClickListener = new d(this);
        this.mOnNoNetButtonClickListener = new e(this);
        this.mNoDataViewRefreshListener = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealNoDataView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            if (z) {
                if (this.mRecyclerView != null) {
                    NoDataView noDataView = this.mNoDataView;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.mRecyclerView.removeHeaderView(this.mNoDataView);
                    this.mRecyclerView.s(this.mNoDataView);
                }
            } else if (this.mRecyclerView != null) {
                NoDataView noDataView2 = this.mNoDataView;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.mRecyclerView.removeHeaderView(this.mNoDataView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealNoMoreDataView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i2) == null) {
            if (d.a.c.e.p.l.g(getActivity(), R.dimen.tbds177) * i2 >= d.a.c.e.p.l.i(getActivity()) - this.mNavigationBar.getHeight()) {
                this.mRecyclerView.y(this.mNoMoreDataView);
                this.mRecyclerView.r(this.mNoMoreDataView);
                return;
            }
            this.mRecyclerView.y(this.mNoMoreDataView);
        }
    }

    private void firstLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (j.A()) {
                loadData();
                return;
            }
            this.mRecyclerView.setVisibility(8);
            if (this.mNetRefreshView == null) {
                this.mNetRefreshView = new d.a.o0.d0.h(getActivity(), this.mOnNoNetButtonClickListener);
            }
            this.mNetRefreshView.j(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
            this.mNetRefreshView.l(getString(R.string.neterror));
            this.mNetRefreshView.attachView(this.mListContainer, true);
            this.mNetRefreshView.o();
            this.mNetRefreshView.onChangeSkinType();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            setContentView(R.layout.activity_smart_app_browse_history);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.d(null, getString(R.string.no_history_now)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getResources().getString(R.string.refresh), this.mNoDataViewRefreshListener)));
            this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.mListContainer = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
            this.mRecyclerView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = new SmartAppBrowseHistoryAdapter(getActivity());
            this.mAdapter = smartAppBrowseHistoryAdapter;
            smartAppBrowseHistoryAdapter.j(this.mOnItemClickListener);
            this.mAdapter.k(this.mOnLongClickListener);
            this.mRecyclerView.setAdapter(this.mAdapter);
            this.mNoMoreDataView = new TextView(getActivity());
            this.mNoMoreDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, d.a.c.e.p.l.g(getActivity(), R.dimen.tbds182)));
            this.mNoMoreDataView.setGravity(17);
            this.mNoMoreDataView.setText(R.string.list_has_no_more);
            this.mNoMoreDataView.setTextSize(0, d.a.c.e.p.l.g(getActivity(), R.dimen.tbds33));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.mModel == null) {
                h hVar = new h();
                this.mModel = hVar;
                hVar.g(this.mDataLoadCallback);
            }
            this.mModel.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mNoNetworkView.c(getPageContext(), i2);
            d.a.o0.d0.h hVar = this.mNetRefreshView;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                this.mNoDataView.f(getPageContext(), i2);
            }
            TextView textView = this.mNoMoreDataView;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.mNoMoreDataView, R.color.CAM_X0109);
            }
            SkinManager.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0201);
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = this.mAdapter;
            if (smartAppBrowseHistoryAdapter != null) {
                smartAppBrowseHistoryAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initView();
            firstLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onStart();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = this.mAdapter;
            if (smartAppBrowseHistoryAdapter != null) {
                smartAppBrowseHistoryAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStop();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
