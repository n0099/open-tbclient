package com.baidu.tieba.square.forumlist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.bv4;
import com.baidu.tieba.cv4;
import com.baidu.tieba.db;
import com.baidu.tieba.gi8;
import com.baidu.tieba.km4;
import com.baidu.tieba.pi;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumsFromForumClass.DataRes;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes5.dex */
public class SquareForumListActivity extends BaseActivity<SquareForumListActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_PAGE_LIMIT = 20;
    public static final int MAX_LIST_SIZE = 50;
    public static final String RULE_URL_HOT = "https://tieba.baidu.com/mo/q/threadRule";
    public static final String RULE_URL_NEW = "https://tieba.baidu.com/mo/q/threadRuleNew";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mFooterText;
    public HttpMessageListener mForumListHttpListener;
    public db mForumListSocketListener;
    public BdListView mForumListView;
    public boolean mHasMore;
    public boolean mIsLoading;
    public CustomMessageListener mLikeForumListener;
    public gi8 mListAdapter;
    public final List<ForumSpaceForumInfo> mListData;
    public View mListFooter;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public int mPageNum;
    public int mPageType;
    public cv4 mPullView;
    public View mRootView;
    public CustomMessageListener mUnlikeForumListener;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SquareForumListActivity squareForumListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i)};
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
            this.a = squareForumListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.mListAdapter.f((Long) customResponsedMessage.getData(), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SquareForumListActivity squareForumListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i)};
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
            this.a = squareForumListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.mListAdapter.f((Long) customResponsedMessage.getData(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SquareForumListActivity squareForumListActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareForumListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof SquareForumListResHttpMsg)) {
                this.a.mIsLoading = false;
                this.a.mForumListView.setVisibility(0);
                this.a.mForumListView.A(0L);
                SquareForumListActivity squareForumListActivity = this.a;
                squareForumListActivity.hideLoadingView(squareForumListActivity.mRootView);
                SquareForumListResHttpMsg squareForumListResHttpMsg = (SquareForumListResHttpMsg) httpResponsedMessage;
                if (!squareForumListResHttpMsg.hasError()) {
                    this.a.updateForumList(squareForumListResHttpMsg.getResponseData());
                    return;
                }
                ri.N(this.a.getActivity(), squareForumListResHttpMsg.getErrorString());
                if (ListUtils.getCount(this.a.mListData) != 0 || pi.z()) {
                    return;
                }
                this.a.showNoNetworkView();
                this.a.mForumListView.setVisibility(8);
                this.a.mListFooter.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends db {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SquareForumListActivity squareForumListActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareForumListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof SquareForumListResSocketMsg)) {
                this.a.mIsLoading = false;
                this.a.mForumListView.setVisibility(0);
                this.a.mForumListView.A(0L);
                SquareForumListActivity squareForumListActivity = this.a;
                squareForumListActivity.hideLoadingView(squareForumListActivity.mRootView);
                SquareForumListResSocketMsg squareForumListResSocketMsg = (SquareForumListResSocketMsg) socketResponsedMessage;
                if (!squareForumListResSocketMsg.hasError()) {
                    this.a.updateForumList(squareForumListResSocketMsg.getResponseData());
                    return;
                }
                ri.N(this.a.getActivity(), squareForumListResSocketMsg.getErrorString());
                if (ListUtils.getCount(this.a.mListData) != 0 || pi.z()) {
                    return;
                }
                this.a.showNoNetworkView();
                this.a.mForumListView.setVisibility(8);
                this.a.mListFooter.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        public e(SquareForumListActivity squareForumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareForumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.mPageType == 1) {
                    TiebaStatic.log("c10564");
                    str = SquareForumListActivity.RULE_URL_HOT;
                } else {
                    TiebaStatic.log("c10585");
                    str = SquareForumListActivity.RULE_URL_NEW;
                }
                km4.o(this.a.getBaseContext(), str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements bv4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        public f(SquareForumListActivity squareForumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareForumListActivity;
        }

        @Override // com.baidu.tieba.bv4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.mIsLoading || !pi.z()) {
                    this.a.mForumListView.A(0L);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                    return;
                }
                this.a.mPageNum = 1;
                this.a.loadForumList(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        public g(SquareForumListActivity squareForumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareForumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.loadForumList(true);
            }
        }
    }

    public SquareForumListActivity() {
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
        this.mPageNum = 1;
        this.mListData = new ArrayList();
        this.mLikeForumListener = new a(this, 2001335);
        this.mUnlikeForumListener = new b(this, 2001336);
        this.mForumListHttpListener = new c(this, CmdConfigHttp.CMD_SQUARE_FORUM_LIST, true);
        this.mForumListSocketListener = new d(this, 309097, true);
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d07d0);
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091ef1);
            int i = this.mPageType == 1 ? R.string.obfuscated_res_0x7f0f11d1 : R.string.obfuscated_res_0x7f0f11d2;
            e eVar = new e(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091626);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(i));
            this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f0894), eVar);
            this.mPullView = new cv4(getPageContext());
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f090a6d);
            this.mForumListView = bdListView;
            bdListView.setPullRefresh(this.mPullView);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ri.f(getActivity(), R.dimen.obfuscated_res_0x7f070282)));
            this.mForumListView.x(textView, 0);
            this.mPullView.f(new f(this));
            View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.obfuscated_res_0x7f0d07d1, (ViewGroup) null);
            this.mListFooter = inflate;
            this.mFooterText = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a23);
            this.mListFooter.setOnClickListener(new g(this));
            this.mForumListView.addFooterView(this.mListFooter);
            this.mListFooter.setVisibility(8);
            gi8 gi8Var = new gi8(getPageContext(), this.mPageType);
            this.mListAdapter = gi8Var;
            this.mForumListView.setAdapter((ListAdapter) gi8Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadForumList(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65550, this, z) == null) || this.mIsLoading) {
            return;
        }
        if (this.mHasMore || !z) {
            if (z) {
                this.mPageNum++;
            }
            this.mIsLoading = true;
            this.mFooterText.setText(R.string.obfuscated_res_0x7f0f0637);
            SkinManager.setViewTextColor(this.mFooterText, (int) R.color.CAM_X0109);
            sendMessage(new SquareForumListReq(this.mPageType, this.mPageNum, 20));
        }
    }

    private void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, a2), NoDataViewFactory.e.d(null, getPageContext().getString(R.string.obfuscated_res_0x7f0f0c5a)), null);
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getPageContext().getString(R.string.obfuscated_res_0x7f0f0c5a)));
            this.mNoDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoNetworkView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, a2), NoDataViewFactory.e.d(null, getPageContext().getString(R.string.obfuscated_res_0x7f0f0c41)), null);
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getPageContext().getString(R.string.obfuscated_res_0x7f0f079e)));
            this.mNoDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForumList(GetForumsFromForumClassResIdl getForumsFromForumClassResIdl) {
        DataRes dataRes;
        List<ForumSpaceForumInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, getForumsFromForumClassResIdl) == null) {
            if (getForumsFromForumClassResIdl != null && (dataRes = getForumsFromForumClassResIdl.data) != null && (list = dataRes.forum_info) != null && !list.isEmpty()) {
                this.mListFooter.setVisibility(0);
                this.mFooterText.setText(this.mHasMore ? R.string.obfuscated_res_0x7f0f0fa3 : R.string.obfuscated_res_0x7f0f09ee);
                SkinManager.setViewTextColor(this.mFooterText, this.mHasMore ? R.color.CAM_X0302 : R.color.CAM_X0109);
                if (this.mHasMore) {
                    SkinManager.setBackgroundResource(this.mListFooter, R.drawable.square_list_item_bg_selector);
                } else {
                    SkinManager.setBackgroundColor(this.mListFooter, R.color.CAM_X0201);
                }
                updateForumList(getForumsFromForumClassResIdl.data.forum_info, this.mPageNum == 1);
                this.mListAdapter.e(this.mListData);
                return;
            }
            showNoDataView();
            this.mForumListView.setVisibility(8);
            this.mListFooter.setVisibility(8);
        }
    }

    public void hideNoDataView() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (noDataView = this.mNoDataView) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(this.mRootView);
            getLayoutMode().k(this.mListFooter);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mListFooter.findViewById(R.id.obfuscated_res_0x7f090a21), R.color.CAM_X0204);
            if (this.mHasMore) {
                SkinManager.setBackgroundResource(this.mListFooter, R.drawable.square_list_item_bg_selector);
            } else {
                SkinManager.setBackgroundColor(this.mListFooter, R.color.CAM_X0201);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mListAdapter.notifyDataSetChanged();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mPageType = getIntent().getIntExtra(SquareForumListActivityConfig.KEY_PAGE_TYPE, 1);
            initViews();
            this.mForumListView.setVisibility(8);
            showLoadingView(this.mRootView, true);
            registerListener(this.mLikeForumListener);
            registerListener(this.mUnlikeForumListener);
            registerListener(this.mForumListHttpListener);
            registerListener(this.mForumListSocketListener);
            loadForumList(false);
        }
    }

    private void updateForumList(List<ForumSpaceForumInfo> list, boolean z) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65553, this, list, z) == null) {
            if (z) {
                this.mListData.clear();
            }
            if (ListUtils.getCount(list) > 0) {
                for (ForumSpaceForumInfo forumSpaceForumInfo : list) {
                    Long l = forumSpaceForumInfo.forum_id;
                    if (l != null && l.longValue() >= 0 && (num = forumSpaceForumInfo.like_num) != null && forumSpaceForumInfo.post_num != null && num.intValue() > 0 && forumSpaceForumInfo.post_num.intValue() > 0 && !TextUtils.isEmpty(forumSpaceForumInfo.avatar) && !TextUtils.isEmpty(forumSpaceForumInfo.forum_name)) {
                        if (ListUtils.getCount(this.mListData) >= 50) {
                            return;
                        }
                        this.mListData.add(forumSpaceForumInfo);
                    }
                }
            }
        }
    }
}
