package com.baidu.tieba.square.flist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {
    private BdListView MR = null;
    private ForumRankModel iTJ = null;
    private b iTK = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView faO = null;
    private LikeModel cco = null;
    private LinearLayout iTt = null;
    private i mPullView = null;
    private FrameLayout iTL = null;
    private String bFy = null;
    private boolean fZG = false;
    private final d iTM = new d() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.MR.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.MR.setVisibility(8);
                ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.MR.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (ForumRankActivity.this.fZG) {
                        ForumRankActivity.this.MR.addHeaderView(ForumRankActivity.this.faO, ForumRankActivity.this.iTN, false);
                        ForumRankActivity.this.fZG = false;
                    }
                    ForumRankActivity.this.faO.setVisibility(0);
                    ForumRankActivity.this.faO.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.faO.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.af(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.bFy = forumRankData.pic_url;
                }
                ForumRankActivity.this.iTK.a(forumRankData.forumsquare_list);
                ForumRankActivity.this.iTK.i(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && ForumRankActivity.this.MR.getAdapter2().getFootersCount() <= 0) {
                    ForumRankActivity.this.MR.addFooterView(ForumRankActivity.this.iTt);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    ForumRankActivity.this.iTL.setVisibility(0);
                    return;
                } else {
                    ForumRankActivity.this.iTL.setVisibility(8);
                    return;
                }
            }
            ForumRankActivity.this.MR.setVisibility(8);
            ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                ForumRankActivity.this.showToast(forumRankData.error.usermsg);
            } else {
                ForumRankActivity.this.showToast(R.string.neterror);
            }
        }
    };
    private final u iTN = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (ForumRankActivity.this.bFy == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ForumRankActivity.this.bFy);
            return arrayList;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData(bundle);
    }

    private void initUI() {
        setContentView(R.layout.forum_rank_activity);
        this.faO = new TbImageView(getPageContext().getPageActivity());
        this.faO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.MR = (BdListView) findViewById(R.id.list);
        this.faO.setLayoutParams(new AbsListView.LayoutParams(l.af(getPageContext().getPageActivity()), (int) (l.af(getPageContext().getPageActivity()) * 0.5d)));
        this.faO.setVisibility(8);
        this.iTt = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumRankActivity.this.MR.removeFooterView(ForumRankActivity.this.iTt);
                ForumRankActivity.this.iTK.zw(100);
            }
        });
        this.mPullView = new i(getPageContext());
        this.MR.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
        this.MR.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (!ForumRankActivity.this.iTJ.LoadData()) {
                    ForumRankActivity.this.MR.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.iTL = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iTJ.ab(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iTJ = new ForumRankModel(bundle);
        } else {
            this.iTJ = new ForumRankModel(getIntent());
        }
        this.fZG = true;
        this.iTJ.setLoadDataCallBack(this.iTM);
        this.iTK = new b(getPageContext(), 0);
        this.iTK.zw(100);
        this.iTK.i(true);
        this.iTK.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.MR.setAdapter((ListAdapter) this.iTK);
        if (this.iTJ.LoadData()) {
            this.iTK.zw(100);
            showProgressBar();
        }
        this.cco = new LikeModel(getPageContext());
        this.iTK.a(this.cco);
    }

    private void ckV() {
        ForumInfoData[] ckU = this.iTK.ckU();
        for (int i = 0; i < ckU.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(ckU[i].forum_name);
            if (hasLikeForum == 1) {
                ckU[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                ckU[i].is_like = 0;
            }
        }
        this.iTK.a(ckU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        ckV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1) {
            this.MR.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.iTK.qF(true);
        } else {
            this.MR.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.iTK.qF(false);
        }
        al.h(findViewById(R.id.root_view), i);
        this.mPullView.iP(i);
        this.iTK.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        al.k(this.iTt, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.iTJ != null) {
            this.iTJ.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
