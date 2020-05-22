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
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes10.dex */
public class SquareForumListActivity extends ProxyAdkBaseActivity<SquareForumListActivity> {
    private static final int DEFAULT_PAGE_LIMIT = 20;
    private static final int MAX_LIST_SIZE = 50;
    private static final String RULE_URL_HOT = "http://tieba.baidu.com/mo/q/threadRule";
    private static final String RULE_URL_NEW = "http://tieba.baidu.com/mo/q/threadRuleNew";
    private TextView mFooterText;
    private BdListView mForumListView;
    private boolean mHasMore;
    private boolean mIsLoading;
    private a mListAdapter;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private int mPageType;
    private g mPullView;
    private View mRootView;
    private int mPageNum = 1;
    private final List<ForumSpaceForumInfo> mListData = new ArrayList();
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                SquareForumListActivity.this.mListAdapter.a((Long) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                SquareForumListActivity.this.mListAdapter.a((Long) customResponsedMessage.getData(), false);
            }
        }
    };
    private HttpMessageListener mForumListHttpListener = new HttpMessageListener(1003060, true) { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SquareForumListResHttpMsg) {
                SquareForumListActivity.this.mIsLoading = false;
                SquareForumListActivity.this.mForumListView.setVisibility(0);
                SquareForumListActivity.this.mForumListView.completePullRefreshPostDelayed(0L);
                SquareForumListActivity.this.hideLoadingView(SquareForumListActivity.this.mRootView);
                SquareForumListResHttpMsg squareForumListResHttpMsg = (SquareForumListResHttpMsg) httpResponsedMessage;
                if (!squareForumListResHttpMsg.hasError()) {
                    SquareForumListActivity.this.updateForumList(squareForumListResHttpMsg.getResponseData());
                    return;
                }
                l.showToast(SquareForumListActivity.this.getActivity(), squareForumListResHttpMsg.getErrorString());
                if (v.getCount(SquareForumListActivity.this.mListData) == 0 && !j.isNetWorkAvailable()) {
                    SquareForumListActivity.this.showNoNetworkView();
                    SquareForumListActivity.this.mForumListView.setVisibility(8);
                    SquareForumListActivity.this.mListFooter.setVisibility(8);
                }
            }
        }
    };
    private c mForumListSocketListener = new c(CmdConfigSocket.CMD_SQUARE_FORUM_LIST, true) { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof SquareForumListResSocketMsg) {
                SquareForumListActivity.this.mIsLoading = false;
                SquareForumListActivity.this.mForumListView.setVisibility(0);
                SquareForumListActivity.this.mForumListView.completePullRefreshPostDelayed(0L);
                SquareForumListActivity.this.hideLoadingView(SquareForumListActivity.this.mRootView);
                SquareForumListResSocketMsg squareForumListResSocketMsg = (SquareForumListResSocketMsg) socketResponsedMessage;
                if (!squareForumListResSocketMsg.hasError()) {
                    SquareForumListActivity.this.updateForumList(squareForumListResSocketMsg.getResponseData());
                    return;
                }
                l.showToast(SquareForumListActivity.this.getActivity(), squareForumListResSocketMsg.getErrorString());
                if (v.getCount(SquareForumListActivity.this.mListData) == 0 && !j.isNetWorkAvailable()) {
                    SquareForumListActivity.this.showNoNetworkView();
                    SquareForumListActivity.this.mForumListView.setVisibility(8);
                    SquareForumListActivity.this.mListFooter.setVisibility(8);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
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

    private void initViews() {
        setContentView(R.layout.square_forum_list_activity);
        this.mRootView = findViewById(R.id.square_forum_list_parent);
        int i = this.mPageType == 1 ? R.string.square_forum_hot : R.string.square_forum_new;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (SquareForumListActivity.this.mPageType == 1) {
                    str = SquareForumListActivity.RULE_URL_HOT;
                    TiebaStatic.log("c10564");
                } else {
                    TiebaStatic.log("c10585");
                    str = SquareForumListActivity.RULE_URL_NEW;
                }
                com.baidu.tbadk.browser.a.startWebActivity(SquareForumListActivity.this.getBaseContext(), str);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(i));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.hot_topic_rule), onClickListener);
        this.mPullView = new g(getPageContext());
        this.mForumListView = (BdListView) findViewById(R.id.forum_list_view);
        this.mForumListView.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.mForumListView.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.6
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (SquareForumListActivity.this.mIsLoading || !j.isNetWorkAvailable()) {
                    SquareForumListActivity.this.mForumListView.completePullRefreshPostDelayed(0L);
                    SquareForumListActivity.this.showToast(R.string.neterror);
                    return;
                }
                SquareForumListActivity.this.mPageNum = 1;
                SquareForumListActivity.this.loadForumList(false);
            }
        });
        this.mListFooter = LayoutInflater.from(getBaseContext()).inflate(R.layout.square_forum_list_footer, (ViewGroup) null);
        this.mFooterText = (TextView) this.mListFooter.findViewById(R.id.footer_text);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.SquareForumListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareForumListActivity.this.loadForumList(true);
            }
        });
        this.mForumListView.addFooterView(this.mListFooter);
        this.mListFooter.setVisibility(8);
        this.mListAdapter = new a(getPageContext(), this.mPageType);
        this.mForumListView.setAdapter((ListAdapter) this.mListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().onModeChanged(this.mRootView);
        getLayoutMode().onModeChanged(this.mListFooter);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mListFooter.findViewById(R.id.footer_divider), R.color.cp_bg_line_c);
        if (this.mHasMore) {
            am.setBackgroundResource(this.mListFooter, R.drawable.square_list_item_bg_selector);
        } else {
            am.setBackgroundColor(this.mListFooter, R.color.cp_bg_line_d);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListAdapter.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
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
            am.setViewTextColor(this.mFooterText, (int) R.color.cp_cont_d);
            sendMessage(new SquareForumListReq(this.mPageType, this.mPageNum, 20));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForumList(GetForumsFromForumClassResIdl getForumsFromForumClassResIdl) {
        if (getForumsFromForumClassResIdl == null || getForumsFromForumClassResIdl.data == null || getForumsFromForumClassResIdl.data.forum_info == null || getForumsFromForumClassResIdl.data.forum_info.isEmpty()) {
            showNoDataView();
            this.mForumListView.setVisibility(8);
            this.mListFooter.setVisibility(8);
            return;
        }
        this.mListFooter.setVisibility(0);
        this.mFooterText.setText(this.mHasMore ? R.string.recommend_frs_hot_thread_more : R.string.list_no_more);
        am.setViewTextColor(this.mFooterText, this.mHasMore ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        if (this.mHasMore) {
            am.setBackgroundResource(this.mListFooter, R.drawable.square_list_item_bg_selector);
        } else {
            am.setBackgroundColor(this.mListFooter, R.color.cp_bg_line_d);
        }
        updateForumList(getForumsFromForumClassResIdl.data.forum_info, this.mPageNum == 1);
        this.mListAdapter.setData(this.mListData);
    }

    private void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, a), NoDataViewFactory.d.dj(null, getPageContext().getString(R.string.no_data_text)), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getPageContext().getString(R.string.no_data_text)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoNetworkView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, a), NoDataViewFactory.d.dj(null, getPageContext().getString(R.string.network_not_available)), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getPageContext().getString(R.string.game_index_no_network_text)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void updateForumList(List<ForumSpaceForumInfo> list, boolean z) {
        if (z) {
            this.mListData.clear();
        }
        if (v.getCount(list) > 0) {
            for (ForumSpaceForumInfo forumSpaceForumInfo : list) {
                if (forumSpaceForumInfo.forum_id != null && forumSpaceForumInfo.forum_id.longValue() >= 0 && forumSpaceForumInfo.like_num != null && forumSpaceForumInfo.post_num != null && forumSpaceForumInfo.like_num.intValue() > 0 && forumSpaceForumInfo.post_num.intValue() > 0 && !TextUtils.isEmpty(forumSpaceForumInfo.avatar) && !TextUtils.isEmpty(forumSpaceForumInfo.forum_name)) {
                    if (v.getCount(this.mListData) < 50) {
                        this.mListData.add(forumSpaceForumInfo);
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
