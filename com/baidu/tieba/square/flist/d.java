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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView TX = null;
    private ForumRankModel kNj = null;
    private b kNk = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gGS = null;
    private LikeModel dKo = null;
    private LinearLayout kMT = null;
    private h mPullView = null;
    private FrameLayout kNl = null;
    private String btm = null;
    private boolean hJY = false;
    private final com.baidu.adp.base.d kNm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.TX.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.TX.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.TX.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.hJY) {
                        d.this.TX.addHeaderView(d.this.gGS, d.this.kNn, false);
                        d.this.hJY = false;
                    }
                    d.this.gGS.setVisibility(0);
                    d.this.gGS.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gGS.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.btm = forumRankData.pic_url;
                }
                d.this.kNk.a(forumRankData.forumsquare_list);
                d.this.kNk.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.TX.getAdapter2().getFootersCount() <= 0) {
                    d.this.TX.addFooterView(d.this.kMT);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.kNl.setVisibility(0);
                    return;
                } else {
                    d.this.kNl.setVisibility(8);
                    return;
                }
            }
            d.this.TX.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u kNn = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.btm == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.btm);
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
        this.gGS = new TbImageView(getPageContext().getPageActivity());
        this.gGS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.TX = (BdListView) findViewById(R.id.list);
        this.gGS.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gGS.setVisibility(8);
        this.kMT = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.TX.removeFooterView(d.this.kMT);
                d.this.kNk.Cf(100);
            }
        });
        this.mPullView = new h(getPageContext());
        this.TX.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.TX.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.kNj.LoadData()) {
                    d.this.TX.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.kNl = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kNj.au(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.kNj = new ForumRankModel(bundle);
        } else {
            this.kNj = new ForumRankModel(getIntent());
        }
        this.hJY = true;
        this.kNj.setLoadDataCallBack(this.kNm);
        this.kNk = new b(getPageContext(), 0);
        this.kNk.Cf(100);
        this.kNk.m(true);
        this.kNk.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.TX.setAdapter((ListAdapter) this.kNk);
        if (this.kNj.LoadData()) {
            this.kNk.Cf(100);
            showProgressBar();
        }
        this.dKo = new LikeModel(getPageContext());
        this.kNk.a(this.dKo);
    }

    private void cUR() {
        ForumInfoData[] cUQ = this.kNk.cUQ();
        for (int i = 0; i < cUQ.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cUQ[i].forum_name);
            if (hasLikeForum == 1) {
                cUQ[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cUQ[i].is_like = 0;
            }
        }
        this.kNk.a(cUQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cUR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.TX.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.kNk.tN(true);
        } else {
            this.TX.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.kNk.tN(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.kNk.cO(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kMT, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.kNj != null) {
            this.kNj.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
