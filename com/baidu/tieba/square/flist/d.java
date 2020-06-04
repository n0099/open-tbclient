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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Um = null;
    private ForumRankModel lgN = null;
    private b lgO = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gVQ = null;
    private LikeModel dYI = null;
    private LinearLayout lgx = null;
    private g mPullView = null;
    private FrameLayout lgP = null;
    private String bAT = null;
    private boolean hZo = false;
    private final com.baidu.adp.base.d lgQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Um.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Um.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Um.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.hZo) {
                        d.this.Um.addHeaderView(d.this.gVQ, d.this.lgR, false);
                        d.this.hZo = false;
                    }
                    d.this.gVQ.setVisibility(0);
                    d.this.gVQ.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gVQ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bAT = forumRankData.pic_url;
                }
                d.this.lgO.a(forumRankData.forumsquare_list);
                d.this.lgO.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Um.getAdapter2().getFootersCount() <= 0) {
                    d.this.Um.addFooterView(d.this.lgx);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.lgP.setVisibility(0);
                    return;
                } else {
                    d.this.lgP.setVisibility(8);
                    return;
                }
            }
            d.this.Um.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u lgR = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bAT == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bAT);
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
        this.gVQ = new TbImageView(getPageContext().getPageActivity());
        this.gVQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Um = (BdListView) findViewById(R.id.list);
        this.gVQ.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gVQ.setVisibility(8);
        this.lgx = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lgx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Um.removeFooterView(d.this.lgx);
                d.this.lgO.CR(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.Um.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Um.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.lgN.LoadData()) {
                    d.this.Um.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.lgP = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lgN.aA(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lgN = new ForumRankModel(bundle);
        } else {
            this.lgN = new ForumRankModel(getIntent());
        }
        this.hZo = true;
        this.lgN.setLoadDataCallBack(this.lgQ);
        this.lgO = new b(getPageContext(), 0);
        this.lgO.CR(100);
        this.lgO.m(true);
        this.lgO.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Um.setAdapter((ListAdapter) this.lgO);
        if (this.lgN.LoadData()) {
            this.lgO.CR(100);
            showProgressBar();
        }
        this.dYI = new LikeModel(getPageContext());
        this.lgO.a(this.dYI);
    }

    private void dci() {
        ForumInfoData[] dch = this.lgO.dch();
        for (int i = 0; i < dch.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dch[i].forum_name);
            if (hasLikeForum == 1) {
                dch[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dch[i].is_like = 0;
            }
        }
        this.lgO.a(dch);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dci();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Um.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.lgO.ul(true);
        } else {
            this.Um.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.lgO.ul(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.lgO.cT(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.lgx, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.lgN != null) {
            this.lgN.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
