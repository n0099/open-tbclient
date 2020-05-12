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
    private BdListView Ua = null;
    private ForumRankModel kNn = null;
    private b kNo = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gGY = null;
    private LikeModel dKs = null;
    private LinearLayout kMX = null;
    private h mPullView = null;
    private FrameLayout kNp = null;
    private String btq = null;
    private boolean hKe = false;
    private final com.baidu.adp.base.d kNq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Ua.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Ua.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Ua.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.hKe) {
                        d.this.Ua.addHeaderView(d.this.gGY, d.this.kNr, false);
                        d.this.hKe = false;
                    }
                    d.this.gGY.setVisibility(0);
                    d.this.gGY.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gGY.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.btq = forumRankData.pic_url;
                }
                d.this.kNo.a(forumRankData.forumsquare_list);
                d.this.kNo.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Ua.getAdapter2().getFootersCount() <= 0) {
                    d.this.Ua.addFooterView(d.this.kMX);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.kNp.setVisibility(0);
                    return;
                } else {
                    d.this.kNp.setVisibility(8);
                    return;
                }
            }
            d.this.Ua.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u kNr = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.btq == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.btq);
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
        this.gGY = new TbImageView(getPageContext().getPageActivity());
        this.gGY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Ua = (BdListView) findViewById(R.id.list);
        this.gGY.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gGY.setVisibility(8);
        this.kMX = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Ua.removeFooterView(d.this.kMX);
                d.this.kNo.Cf(100);
            }
        });
        this.mPullView = new h(getPageContext());
        this.Ua.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Ua.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.kNn.LoadData()) {
                    d.this.Ua.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.kNp = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kNn.au(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.kNn = new ForumRankModel(bundle);
        } else {
            this.kNn = new ForumRankModel(getIntent());
        }
        this.hKe = true;
        this.kNn.setLoadDataCallBack(this.kNq);
        this.kNo = new b(getPageContext(), 0);
        this.kNo.Cf(100);
        this.kNo.m(true);
        this.kNo.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Ua.setAdapter((ListAdapter) this.kNo);
        if (this.kNn.LoadData()) {
            this.kNo.Cf(100);
            showProgressBar();
        }
        this.dKs = new LikeModel(getPageContext());
        this.kNo.a(this.dKs);
    }

    private void cUP() {
        ForumInfoData[] cUO = this.kNo.cUO();
        for (int i = 0; i < cUO.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cUO[i].forum_name);
            if (hasLikeForum == 1) {
                cUO[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cUO[i].is_like = 0;
            }
        }
        this.kNo.a(cUO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cUP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Ua.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.kNo.tN(true);
        } else {
            this.Ua.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.kNo.tN(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.kNo.cO(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kMX, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.kNn != null) {
            this.kNn.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
