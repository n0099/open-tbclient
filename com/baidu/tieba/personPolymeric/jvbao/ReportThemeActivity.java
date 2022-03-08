package com.baidu.tieba.personPolymeric.jvbao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.r0.z2.k.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ReportThemeActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean mCanShowLoadingView = true;
    public static CustomMessageListener mLoadingViewListener;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler handler;
    public boolean isRequesting;
    public c.a.r0.z2.h.a mAdapter;
    public View mBack;
    public PersonPostModel.c mCallBack;
    public TextView mConfirm;
    public TextView mConfirmNumView;
    public ArrayList<n> mData;
    public boolean mHasMore;
    public View mListContainerView;
    public View mListRootView;
    public BdListView mListView;
    public PbListView mLoadMoreView;
    public PersonPostModel mModel;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public PersonPostModel.d mOnResult;
    public l mRefreshView;
    public View mRootView;
    public TextView mThemeView;
    public final int maxReportThemeNum;
    public String portrait;
    public int reportNum;
    public ArrayList<String> reportThemeList;

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = ReportThemeActivity.mCanShowLoadingView = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportThemeActivity a;

        public b(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reportThemeActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                this.a.refreshConfirmUI(message.arg1);
                if (message.arg1 > 10) {
                    this.a.mConfirmNumView.setText(this.a.getString(R.string.choose_report_theme_num, new Object[]{10}));
                    new BdTopToast(this.a.getActivity()).setIcon(false).setContent(this.a.getResources().getString(R.string.max_choose_report_theme_num)).show(this.a.mNavigationBar);
                    return;
                }
                this.a.mConfirmNumView.setText(this.a.getString(R.string.choose_report_theme_num, new Object[]{Integer.valueOf(message.arg1)}));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReportThemeActivity f45810e;

        public c(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45810e = reportThemeActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45810e.mAdapter != null && this.f45810e.mHasMore) {
                if (this.f45810e.mLoadMoreView != null && !this.f45810e.mLoadMoreView.m()) {
                    this.f45810e.sendNetReq(true);
                }
                this.f45810e.sendNetReq(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReportThemeActivity f45811e;

        public d(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45811e = reportThemeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ReportThemeActivity reportThemeActivity = this.f45811e;
                reportThemeActivity.reportThemeList = reportThemeActivity.getReportThemeList();
                TiebaStatic.log("c14576");
                Intent intent = new Intent();
                intent.putExtra(ReportThemeActivityConfig.REPORT_TID_LIST, this.f45811e.reportThemeList);
                this.f45811e.setResult(-1, intent);
                this.f45811e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements PersonPostModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReportThemeActivity f45812e;

        public e(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45812e = reportThemeActivity;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
        public void on(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                this.f45812e.dealNetData(personPostModel, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReportThemeActivity f45813e;

        public f(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45813e = reportThemeActivity;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void onResult(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                this.f45813e.dealNetData(personPostModel, z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(422209324, "Lcom/baidu/tieba/personPolymeric/jvbao/ReportThemeActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(422209324, "Lcom/baidu/tieba/personPolymeric/jvbao/ReportThemeActivity;");
                return;
            }
        }
        mLoadingViewListener = new a(2921440);
    }

    public ReportThemeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mConfirmNumView = null;
        this.mNavigationBar = null;
        this.mBack = null;
        this.mListView = null;
        this.mAdapter = null;
        this.maxReportThemeNum = 10;
        this.isRequesting = false;
        this.mHasMore = false;
        this.reportNum = 0;
        this.reportThemeList = null;
        this.portrait = null;
        this.mData = new ArrayList<>();
        this.handler = new b(this);
        this.mOnResult = new e(this);
        this.mCallBack = new f(this);
    }

    private boolean dealHasMore(PersonPostModel personPostModel, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, this, personPostModel, z)) == null) {
            if (personPostModel != null) {
                boolean z2 = !ListUtils.isEmpty(personPostModel.threadList);
                if (!z) {
                    return z2;
                }
                if (personPostModel.threadList.size() >= 20) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealNetData(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, this, personPostModel, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.isRequesting = false;
            hideLoadingView(this.mRootView);
            hideNetRefreshView(this.mListRootView);
            this.mThemeView.setVisibility(0);
            this.mConfirmNumView.setVisibility(0);
            if (personPostModel != null && (personPostModel2 = this.mModel) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                this.mModel.threadList.addAll(c.a.r0.z2.j.c.a.c(personPostModel.threadList));
            }
            this.mHasMore = dealHasMore(personPostModel, z);
            PersonPostModel personPostModel3 = this.mModel;
            if (personPostModel3 != null) {
                if (ListUtils.isEmpty(personPostModel3.threadList) && !c.a.d.f.p.l.z()) {
                    showNetRefreshView(this.mListRootView, null, false);
                    this.mListContainerView.setVisibility(8);
                } else {
                    if (this.mHasMore) {
                        showLoadMoreView();
                    } else {
                        showNoMoreView();
                    }
                    setData(this.mModel.threadList);
                }
            }
            c.a.r0.z2.b.d().l(System.currentTimeMillis() - currentTimeMillis);
            c.a.r0.z2.b.d().p(System.currentTimeMillis() - c.a.r0.z2.b.d().g());
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, bundle) == null) {
            PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, true, PersonPostModel.FROM_PERSON_POST);
            this.mModel = personPostModel;
            personPostModel.setUniqueId(getUniqueId());
            TiebaStatic.log("c14572");
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.report_user));
            this.mConfirm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.confirm));
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mConfirm.setOnClickListener(new d(this));
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            initNavigationBar();
            this.mRootView = findViewById(R.id.rootLayout);
            this.mListContainerView = findViewById(R.id.list_container);
            this.mListRootView = findViewById(R.id.list_rootview);
            this.mThemeView = (TextView) findViewById(R.id.choose_theme);
            this.mListView = (BdListView) findViewById(R.id.report_theme_list);
            this.mConfirmNumView = (TextView) findViewById(R.id.confirm_num);
            c.a.r0.z2.h.a aVar = new c.a.r0.z2.h.a(this, this.mData);
            this.mAdapter = aVar;
            this.mListView.setAdapter((ListAdapter) aVar);
            this.mListView.setOnSrollToBottomListener(new c(this));
            MessageManager.getInstance().registerListener(mLoadingViewListener);
            PbListView pbListView = new PbListView(this);
            this.mLoadMoreView = pbListView;
            pbListView.a();
            this.mLoadMoreView.p(R.color.CAM_X0205);
            this.mLoadMoreView.t(c.a.d.f.p.n.f(this, R.dimen.tbds182));
            this.mLoadMoreView.y();
            this.mLoadMoreView.H(R.dimen.tbfontsize33);
            this.mLoadMoreView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.mLoadMoreView.B(R.color.CAM_X0110);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNetReq(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65553, this, z) == null) || this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        this.portrait = getIntent().getStringExtra("portrait");
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(ReportThemeActivityConfig.REPORT_TID_LIST);
        this.reportThemeList = stringArrayListExtra;
        this.reportNum = stringArrayListExtra.size();
        this.mConfirmNumView.setText(getPageContext().getPageActivity().getString(R.string.choose_report_theme_num, new Object[]{Integer.valueOf(getReportNum())}));
        this.mConfirmNumView.setVisibility(8);
        this.mThemeView.setVisibility(8);
        this.mConfirm.setEnabled(false);
        this.mModel.fetchPost(getPageContext(), this.mCallBack, z, null, true, 0, false, true, null, this.portrait);
    }

    private void showNoDataView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, this, i2) == null) {
            String string = getResources().getString(R.string.no_data_common_txt);
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
            this.mListView.removeHeaderView(this.mNoDataView);
            this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mListView.addHeaderView(this.mNoDataView);
        }
    }

    public void forceRefresh(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.mModel == null || this.mRootView == null || (view = this.mListRootView) == null) {
            return;
        }
        hideNetRefreshView(view);
        this.mListContainerView.setVisibility(0);
        if (c.a.d.f.p.l.z()) {
            if (z && mCanShowLoadingView) {
                showLoadingView(this.mRootView);
            }
            sendNetReq(true);
            scrollToTop();
            return;
        }
        this.mListContainerView.setVisibility(8);
        showNetRefreshView(this.mListRootView, null, false);
    }

    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mListView : (BdListView) invokeV.objValue;
    }

    public int getReportNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.reportNum : invokeV.intValue;
    }

    public ArrayList<String> getReportThemeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.reportThemeList : (ArrayList) invokeV.objValue;
    }

    public void hideLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mListView.setNextPage(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mConfirmNumView, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.mListView, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.mThemeView, (int) R.color.CAM_X0109);
            this.mConfirm.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0304, i2));
            SkinManager.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            PbListView pbListView = this.mLoadMoreView;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.mLoadMoreView.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.report_theme_activity);
            initData(bundle);
            initView();
            forceRefresh(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            this.mListView.setOnSrollToBottomListener(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onNetRefreshButtonClicked();
            forceRefresh(true);
        }
    }

    public void refreshConfirmUI(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 < 1) {
                this.mConfirm.setEnabled(false);
            } else {
                this.mConfirm.setEnabled(true);
            }
        }
    }

    public void scrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mListView.smoothScrollToPosition(0);
        }
    }

    public void setData(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            setThreadData(arrayList);
        }
    }

    public void setListViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mListView.setVisibility(z ? 0 : 8);
        }
    }

    public void setThreadData(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) {
            if (ListUtils.isEmpty(arrayList)) {
                hideLoadMoreView();
                if (this.mListView.getHeaderViewsCount() == 0) {
                    this.mListContainerView.setVisibility(8);
                    showNoDataView(R.string.nad_no_network);
                }
            } else {
                NoDataView noDataView = this.mNoDataView;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.mListView.removeHeaderView(this.mNoDataView);
                }
            }
            this.mAdapter.j(arrayList);
        }
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mListView.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.M(0);
            this.mLoadMoreView.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, view, str, z) == null) {
            if (this.mRefreshView == null) {
                l lVar = new l(getPageContext().getPageActivity(), getNetRefreshListener());
                this.mRefreshView = lVar;
                lVar.e(getPageContext().getResources().getString(R.string.refresh_view_title_text));
                this.mRefreshView.d(null);
                this.mRefreshView.c(getPageContext().getResources().getString(R.string.refresh_view_button_text));
                this.mRefreshView.f();
                this.mRefreshView.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mRefreshView.onChangeSkinType();
            this.mRefreshView.attachView(view, z);
        }
    }

    public void showNoMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mListView.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.M(0);
            this.mLoadMoreView.f();
            this.mLoadMoreView.D(getPageContext().getString(R.string.list_no_more));
        }
    }

    public void showNoMoreViewWithText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mListView.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.M(0);
            this.mLoadMoreView.f();
            this.mLoadMoreView.D(getPageContext().getString(i2));
        }
    }
}
