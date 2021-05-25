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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumsFromForumClass.DataRes;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes5.dex */
public class SquareForumListActivity extends ProxyAdkBaseActivity<SquareForumListActivity> {
    public static final int DEFAULT_PAGE_LIMIT = 20;
    public static final int MAX_LIST_SIZE = 50;
    public static final String RULE_URL_HOT = "http://tieba.baidu.com/mo/q/threadRule";
    public static final String RULE_URL_NEW = "http://tieba.baidu.com/mo/q/threadRuleNew";
    public TextView mFooterText;
    public BdListView mForumListView;
    public boolean mHasMore;
    public boolean mIsLoading;
    public d.a.n0.b3.i.a mListAdapter;
    public View mListFooter;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public int mPageType;
    public d.a.m0.r.f0.g mPullView;
    public View mRootView;
    public int mPageNum = 1;
    public final List<ForumSpaceForumInfo> mListData = new ArrayList();
    public CustomMessageListener mLikeForumListener = new a(2001335);
    public CustomMessageListener mUnlikeForumListener = new b(2001336);
    public HttpMessageListener mForumListHttpListener = new c(CmdConfigHttp.CMD_SQUARE_FORUM_LIST, true);
    public d.a.c.c.g.c mForumListSocketListener = new d(309097, true);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            SquareForumListActivity.this.mListAdapter.f((Long) customResponsedMessage.getData(), true);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            SquareForumListActivity.this.mListAdapter.f((Long) customResponsedMessage.getData(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SquareForumListResHttpMsg) {
                SquareForumListActivity.this.mIsLoading = false;
                SquareForumListActivity.this.mForumListView.setVisibility(0);
                SquareForumListActivity.this.mForumListView.A(0L);
                SquareForumListActivity squareForumListActivity = SquareForumListActivity.this;
                squareForumListActivity.hideLoadingView(squareForumListActivity.mRootView);
                SquareForumListResHttpMsg squareForumListResHttpMsg = (SquareForumListResHttpMsg) httpResponsedMessage;
                if (!squareForumListResHttpMsg.hasError()) {
                    SquareForumListActivity.this.updateForumList(squareForumListResHttpMsg.getResponseData());
                    return;
                }
                l.M(SquareForumListActivity.this.getActivity(), squareForumListResHttpMsg.getErrorString());
                if (ListUtils.getCount(SquareForumListActivity.this.mListData) != 0 || j.z()) {
                    return;
                }
                SquareForumListActivity.this.showNoNetworkView();
                SquareForumListActivity.this.mForumListView.setVisibility(8);
                SquareForumListActivity.this.mListFooter.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.c.c.g.c {
        public d(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof SquareForumListResSocketMsg) {
                SquareForumListActivity.this.mIsLoading = false;
                SquareForumListActivity.this.mForumListView.setVisibility(0);
                SquareForumListActivity.this.mForumListView.A(0L);
                SquareForumListActivity squareForumListActivity = SquareForumListActivity.this;
                squareForumListActivity.hideLoadingView(squareForumListActivity.mRootView);
                SquareForumListResSocketMsg squareForumListResSocketMsg = (SquareForumListResSocketMsg) socketResponsedMessage;
                if (!squareForumListResSocketMsg.hasError()) {
                    SquareForumListActivity.this.updateForumList(squareForumListResSocketMsg.getResponseData());
                    return;
                }
                l.M(SquareForumListActivity.this.getActivity(), squareForumListResSocketMsg.getErrorString());
                if (ListUtils.getCount(SquareForumListActivity.this.mListData) != 0 || j.z()) {
                    return;
                }
                SquareForumListActivity.this.showNoNetworkView();
                SquareForumListActivity.this.mForumListView.setVisibility(8);
                SquareForumListActivity.this.mListFooter.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (SquareForumListActivity.this.mPageType == 1) {
                TiebaStatic.log("c10564");
                str = SquareForumListActivity.RULE_URL_HOT;
            } else {
                TiebaStatic.log("c10585");
                str = SquareForumListActivity.RULE_URL_NEW;
            }
            d.a.m0.l.a.l(SquareForumListActivity.this.getBaseContext(), str);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f.g {
        public f() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (SquareForumListActivity.this.mIsLoading || !j.z()) {
                SquareForumListActivity.this.mForumListView.A(0L);
                SquareForumListActivity.this.showToast(R.string.neterror);
                return;
            }
            SquareForumListActivity.this.mPageNum = 1;
            SquareForumListActivity.this.loadForumList(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareForumListActivity.this.loadForumList(true);
        }
    }

    private void initViews() {
        setContentView(R.layout.square_forum_list_activity);
        this.mRootView = findViewById(R.id.square_forum_list_parent);
        int i2 = this.mPageType == 1 ? R.string.square_forum_hot : R.string.square_forum_new;
        e eVar = new e();
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(i2));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.hot_topic_rule), eVar);
        this.mPullView = new d.a.m0.r.f0.g(getPageContext());
        BdListView bdListView = (BdListView) findViewById(R.id.forum_list_view);
        this.mForumListView = bdListView;
        bdListView.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
        this.mForumListView.x(textView, 0);
        this.mPullView.a(new f());
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.square_forum_list_footer, (ViewGroup) null);
        this.mListFooter = inflate;
        this.mFooterText = (TextView) inflate.findViewById(R.id.footer_text);
        this.mListFooter.setOnClickListener(new g());
        this.mForumListView.addFooterView(this.mListFooter);
        this.mListFooter.setVisibility(8);
        d.a.n0.b3.i.a aVar = new d.a.n0.b3.i.a(getPageContext(), this.mPageType);
        this.mListAdapter = aVar;
        this.mForumListView.setAdapter((ListAdapter) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadForumList(boolean z) {
        if (this.mIsLoading) {
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
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, a2), NoDataViewFactory.e.d(null, getPageContext().getString(R.string.no_data_text)), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getPageContext().getString(R.string.no_data_text)));
        this.mNoDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoNetworkView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, a2), NoDataViewFactory.e.d(null, getPageContext().getString(R.string.network_not_available)), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getPageContext().getString(R.string.game_index_no_network_text)));
        this.mNoDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForumList(GetForumsFromForumClassResIdl getForumsFromForumClassResIdl) {
        DataRes dataRes;
        List<ForumSpaceForumInfo> list;
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

    public void hideNoDataView() {
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
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
            noDataView.f(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
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

    private void updateForumList(List<ForumSpaceForumInfo> list, boolean z) {
        Integer num;
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
