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
/* loaded from: classes8.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Ao = null;
    private ForumRankModel kaz = null;
    private b kaA = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gbH = null;
    private LikeModel dfN = null;
    private LinearLayout kai = null;
    private h mPullView = null;
    private FrameLayout kaB = null;
    private String mImageUrl = null;
    private boolean gWN = false;
    private final com.baidu.adp.base.d kaC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Ao.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Ao.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Ao.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.gWN) {
                        d.this.Ao.addHeaderView(d.this.gbH, d.this.kaD, false);
                        d.this.gWN = false;
                    }
                    d.this.gbH.setVisibility(0);
                    d.this.gbH.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gbH.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.mImageUrl = forumRankData.pic_url;
                }
                d.this.kaA.a(forumRankData.forumsquare_list);
                d.this.kaA.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Ao.getAdapter2().getFootersCount() <= 0) {
                    d.this.Ao.addFooterView(d.this.kai);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.kaB.setVisibility(0);
                    return;
                } else {
                    d.this.kaB.setVisibility(8);
                    return;
                }
            }
            d.this.Ao.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u kaD = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.mImageUrl == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.mImageUrl);
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
        this.gbH = new TbImageView(getPageContext().getPageActivity());
        this.gbH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Ao = (BdListView) findViewById(R.id.list);
        this.gbH.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gbH.setVisibility(8);
        this.kai = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Ao.removeFooterView(d.this.kai);
                d.this.kaA.Bo(100);
            }
        });
        this.mPullView = new h(getPageContext());
        this.Ao.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Ao.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.kaz.LoadData()) {
                    d.this.Ao.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.kaB = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kaz.au(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.kaz = new ForumRankModel(bundle);
        } else {
            this.kaz = new ForumRankModel(getIntent());
        }
        this.gWN = true;
        this.kaz.setLoadDataCallBack(this.kaC);
        this.kaA = new b(getPageContext(), 0);
        this.kaA.Bo(100);
        this.kaA.m(true);
        this.kaA.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Ao.setAdapter((ListAdapter) this.kaA);
        if (this.kaz.LoadData()) {
            this.kaA.Bo(100);
            showProgressBar();
        }
        this.dfN = new LikeModel(getPageContext());
        this.kaA.a(this.dfN);
    }

    private void cHT() {
        ForumInfoData[] cHS = this.kaA.cHS();
        for (int i = 0; i < cHS.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cHS[i].forum_name);
            if (hasLikeForum == 1) {
                cHS[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cHS[i].is_like = 0;
            }
        }
        this.kaA.a(cHS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cHT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Ao.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.kaA.sB(true);
        } else {
            this.Ao.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.kaA.sB(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.kaA.cF(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kai, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.kaz != null) {
            this.kaz.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
