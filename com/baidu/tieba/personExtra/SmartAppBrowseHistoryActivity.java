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
import com.repackage.ji;
import com.repackage.k08;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.pk5;
import com.repackage.q08;
import com.repackage.qb5;
import com.repackage.r08;
import com.repackage.t35;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SmartAppBrowseHistoryAdapter mAdapter;
    public q08.b mDataLoadCallback;
    public r08 mHistoryRecordMoreDialog;
    public r08.b mItemMoreDialogCallBack;
    public FrameLayout mListContainer;
    public q08 mModel;
    public NavigationBar mNavigationBar;
    public t35 mNetRefreshView;
    public NoDataView mNoDataView;
    public View.OnClickListener mNoDataViewRefreshListener;
    public TextView mNoMoreDataView;
    public NoNetworkView mNoNetworkView;
    public View.OnClickListener mOnItemClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public View.OnClickListener mOnNoNetButtonClickListener;
    public BdRecyclerView mRecyclerView;

    /* loaded from: classes3.dex */
    public class a implements q08.b {
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

        @Override // com.repackage.q08.b
        public void a(boolean z, k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, k08Var) == null) {
                if (!z || k08Var == null) {
                    this.a.dealNoDataView(true);
                    this.a.dealNoMoreDataView(0);
                } else if (this.a.mAdapter != null) {
                    this.a.dealNoDataView(ListUtils.isEmpty(k08Var.a()));
                    this.a.dealNoMoreDataView(ListUtils.getCount(k08Var.a()));
                    this.a.mAdapter.i(k08Var.a());
                    this.a.mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements r08.b {
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

        @Override // com.repackage.r08.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.mAdapter == null) {
                return;
            }
            this.a.mAdapter.h(str);
            if (this.a.mAdapter.getItemCount() == 0) {
                this.a.dealNoDataView(true);
            }
            SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity = this.a;
            smartAppBrowseHistoryActivity.dealNoMoreDataView(smartAppBrowseHistoryActivity.mAdapter.getItemCount());
            this.a.mAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
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
                if (!pk5.b(smartApp.id, smartApp.link, "1191000600000000", smartApp.is_game)) {
                    if (ki.isEmpty(smartApp.h5_url)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{smartApp.h5_url});
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_source", "personal_center_list");
                statisticItem.param("obj_id", smartApp.swan_app_id.longValue());
                statisticItem.param("obj_name", smartApp.name);
                statisticItem.param("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(statisticItem);
                if (this.a.mAdapter != null) {
                    this.a.mAdapter.e(smartApp);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    if (this.a.mHistoryRecordMoreDialog == null) {
                        this.a.mHistoryRecordMoreDialog = new r08(this.a.getPageContext());
                        this.a.mHistoryRecordMoreDialog.e();
                        this.a.mHistoryRecordMoreDialog.f(this.a.mItemMoreDialogCallBack);
                    }
                    this.a.mHistoryRecordMoreDialog.d(smartApp);
                    this.a.mHistoryRecordMoreDialog.g();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ji.A()) {
                if (this.a.mNetRefreshView != null) {
                    this.a.mNetRefreshView.dettachView(this.a.mListContainer);
                    this.a.mNetRefreshView = null;
                }
                this.a.loadData();
                this.a.mRecyclerView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !qb5.a() && ji.A()) {
                this.a.loadData();
            }
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
    public void dealNoMoreDataView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            if (li.f(getActivity(), R.dimen.tbds177) * i >= li.i(getActivity()) - this.mNavigationBar.getHeight()) {
                this.mRecyclerView.z(this.mNoMoreDataView);
                this.mRecyclerView.r(this.mNoMoreDataView);
                return;
            }
            this.mRecyclerView.z(this.mNoMoreDataView);
        }
    }

    private void firstLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (ji.A()) {
                loadData();
                return;
            }
            this.mRecyclerView.setVisibility(8);
            if (this.mNetRefreshView == null) {
                this.mNetRefreshView = new t35(getActivity(), this.mOnNoNetButtonClickListener);
            }
            this.mNetRefreshView.k(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
            this.mNetRefreshView.m(getString(R.string.obfuscated_res_0x7f0f0c33));
            this.mNetRefreshView.attachView(this.mListContainer, true);
            this.mNetRefreshView.p();
            this.mNetRefreshView.onChangeSkinType();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0051);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f7);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f083b));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f091d27);
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.d(null, getString(R.string.obfuscated_res_0x7f0f0c5d)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getResources().getString(R.string.obfuscated_res_0x7f0f0f92), this.mNoDataViewRefreshListener)));
            this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.mListContainer = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091d26);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091d25);
            this.mRecyclerView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = new SmartAppBrowseHistoryAdapter(getActivity());
            this.mAdapter = smartAppBrowseHistoryAdapter;
            smartAppBrowseHistoryAdapter.j(this.mOnItemClickListener);
            this.mAdapter.k(this.mOnLongClickListener);
            this.mRecyclerView.setAdapter(this.mAdapter);
            this.mNoMoreDataView = new TextView(getActivity());
            this.mNoMoreDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, li.f(getActivity(), R.dimen.tbds182)));
            this.mNoMoreDataView.setGravity(17);
            this.mNoMoreDataView.setText(R.string.obfuscated_res_0x7f0f09f3);
            this.mNoMoreDataView.setTextSize(0, li.f(getActivity(), R.dimen.tbds33));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.mModel == null) {
                q08 q08Var = new q08();
                this.mModel = q08Var;
                q08Var.h(this.mDataLoadCallback);
            }
            this.mModel.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mNoNetworkView.c(getPageContext(), i);
            t35 t35Var = this.mNetRefreshView;
            if (t35Var != null) {
                t35Var.onChangeSkinType();
            }
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                this.mNoDataView.f(getPageContext(), i);
            }
            TextView textView = this.mNoMoreDataView;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.mNoMoreDataView, (int) R.color.CAM_X0109);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            q08 q08Var = this.mModel;
            if (q08Var != null) {
                q08Var.c();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
