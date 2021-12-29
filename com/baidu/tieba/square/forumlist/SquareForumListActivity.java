package com.baidu.tieba.square.forumlist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.i0.f;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumsFromForumClass.DataRes;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes12.dex */
public class SquareForumListActivity extends ProxyAdkBaseActivity<SquareForumListActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_PAGE_LIMIT = 20;
    public static final int MAX_LIST_SIZE = 50;
    public static final String RULE_URL_HOT = "http://tieba.baidu.com/mo/q/threadRule";
    public static final String RULE_URL_NEW = "http://tieba.baidu.com/mo/q/threadRuleNew";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mFooterText;
    public HttpMessageListener mForumListHttpListener;
    public c.a.d.c.g.c mForumListSocketListener;
    public BdListView mForumListView;
    public boolean mHasMore;
    public boolean mIsLoading;
    public CustomMessageListener mLikeForumListener;
    public c.a.t0.s3.i.a mListAdapter;
    public final List<ForumSpaceForumInfo> mListData;
    public View mListFooter;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public int mPageNum;
    public int mPageType;
    public c.a.s0.s.i0.g mPullView;
    public View mRootView;
    public CustomMessageListener mUnlikeForumListener;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SquareForumListActivity squareForumListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i2)};
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

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SquareForumListActivity squareForumListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i2)};
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

    /* loaded from: classes12.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SquareForumListActivity squareForumListActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.mForumListView.completePullRefreshPostDelayed(0L);
                SquareForumListActivity squareForumListActivity = this.a;
                squareForumListActivity.hideLoadingView(squareForumListActivity.mRootView);
                SquareForumListResHttpMsg squareForumListResHttpMsg = (SquareForumListResHttpMsg) httpResponsedMessage;
                if (!squareForumListResHttpMsg.hasError()) {
                    this.a.updateForumList(squareForumListResHttpMsg.getResponseData());
                    return;
                }
                n.M(this.a.getActivity(), squareForumListResHttpMsg.getErrorString());
                if (ListUtils.getCount(this.a.mListData) != 0 || l.z()) {
                    return;
                }
                this.a.showNoNetworkView();
                this.a.mForumListView.setVisibility(8);
                this.a.mListFooter.setVisibility(8);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareForumListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SquareForumListActivity squareForumListActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.mForumListView.completePullRefreshPostDelayed(0L);
                SquareForumListActivity squareForumListActivity = this.a;
                squareForumListActivity.hideLoadingView(squareForumListActivity.mRootView);
                SquareForumListResSocketMsg squareForumListResSocketMsg = (SquareForumListResSocketMsg) socketResponsedMessage;
                if (!squareForumListResSocketMsg.hasError()) {
                    this.a.updateForumList(squareForumListResSocketMsg.getResponseData());
                    return;
                }
                n.M(this.a.getActivity(), squareForumListResSocketMsg.getErrorString());
                if (ListUtils.getCount(this.a.mListData) != 0 || l.z()) {
                    return;
                }
                this.a.showNoNetworkView();
                this.a.mForumListView.setVisibility(8);
                this.a.mListFooter.setVisibility(8);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareForumListActivity f49863e;

        public e(SquareForumListActivity squareForumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49863e = squareForumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49863e.mPageType == 1) {
                    TiebaStatic.log("c10564");
                    str = SquareForumListActivity.RULE_URL_HOT;
                } else {
                    TiebaStatic.log("c10585");
                    str = SquareForumListActivity.RULE_URL_NEW;
                }
                c.a.s0.m.a.m(this.f49863e.getBaseContext(), str);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareForumListActivity f49864e;

        public f(SquareForumListActivity squareForumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49864e = squareForumListActivity;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f49864e.mIsLoading || !l.z()) {
                    this.f49864e.mForumListView.completePullRefreshPostDelayed(0L);
                    this.f49864e.showToast(R.string.neterror);
                    return;
                }
                this.f49864e.mPageNum = 1;
                this.f49864e.loadForumList(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SquareForumListActivity f49865e;

        public g(SquareForumListActivity squareForumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareForumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49865e = squareForumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49865e.loadForumList(true);
            }
        }
    }

    public SquareForumListActivity() {
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
            setContentView(R.layout.square_forum_list_activity);
            this.mRootView = findViewById(R.id.square_forum_list_parent);
            int i2 = this.mPageType == 1 ? R.string.square_forum_hot : R.string.square_forum_new;
            e eVar = new e(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(i2));
            this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.hot_topic_rule), eVar);
            this.mPullView = new c.a.s0.s.i0.g(getPageContext());
            BdListView bdListView = (BdListView) findViewById(R.id.forum_list_view);
            this.mForumListView = bdListView;
            bdListView.setPullRefresh(this.mPullView);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + n.f(getActivity(), R.dimen.ds98)));
            this.mForumListView.addHeaderView(textView, 0);
            this.mPullView.a(new f(this));
            View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.square_forum_list_footer, (ViewGroup) null);
            this.mListFooter = inflate;
            this.mFooterText = (TextView) inflate.findViewById(R.id.footer_text);
            this.mListFooter.setOnClickListener(new g(this));
            this.mForumListView.addFooterView(this.mListFooter);
            this.mListFooter.setVisibility(8);
            c.a.t0.s3.i.a aVar = new c.a.t0.s3.i.a(getPageContext(), this.mPageType);
            this.mListAdapter = aVar;
            this.mForumListView.setAdapter((ListAdapter) aVar);
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
            this.mFooterText.setText(R.string.flist_loading);
            SkinManager.setViewTextColor(this.mFooterText, R.color.CAM_X0109);
            sendMessage(new SquareForumListReq(this.mPageType, this.mPageNum, 20));
        }
    }

    private void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, a2), NoDataViewFactory.e.d(null, getPageContext().getString(R.string.no_data_text)), null);
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getPageContext().getString(R.string.no_data_text)));
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoNetworkView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, a2), NoDataViewFactory.e.d(null, getPageContext().getString(R.string.network_not_available)), null);
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getPageContext().getString(R.string.game_index_no_network_text)));
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
                this.mFooterText.setText(this.mHasMore ? R.string.recommend_frs_hot_thread_more : R.string.list_no_more);
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

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().j(this.mRootView);
            getLayoutMode().j(this.mListFooter);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mListFooter.findViewById(R.id.footer_divider), R.color.CAM_X0204);
            if (this.mHasMore) {
                SkinManager.setBackgroundResource(this.mListFooter, R.drawable.square_list_item_bg_selector);
            } else {
                SkinManager.setBackgroundColor(this.mListFooter, R.color.CAM_X0201);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mListAdapter.notifyDataSetChanged();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
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
