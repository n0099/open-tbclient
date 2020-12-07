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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView WX = null;
    private ForumRankModel ngG = null;
    private b ngH = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView iBp = null;
    private LikeModel fgf = null;
    private LinearLayout ngq = null;
    private g mPullView = null;
    private FrameLayout ngI = null;
    private String cny = null;
    private boolean jMx = false;
    private final com.baidu.adp.base.d ngJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.WX.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.WX.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.WX.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.jMx) {
                        d.this.WX.addHeaderView(d.this.iBp, d.this.ngK, false);
                        d.this.jMx = false;
                    }
                    d.this.iBp.setVisibility(0);
                    d.this.iBp.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.iBp.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.cny = forumRankData.pic_url;
                }
                d.this.ngH.a(forumRankData.forumsquare_list);
                d.this.ngH.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.WX.getAdapter2().getFootersCount() <= 0) {
                    d.this.WX.addFooterView(d.this.ngq);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.ngI.setVisibility(0);
                    return;
                } else {
                    d.this.ngI.setVisibility(8);
                    return;
                }
            }
            d.this.WX.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w ngK = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.cny == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.cny);
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
        this.iBp = new TbImageView(getPageContext().getPageActivity());
        this.iBp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.WX = (BdListView) findViewById(R.id.list);
        this.iBp.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.iBp.setVisibility(8);
        this.ngq = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ngq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WX.removeFooterView(d.this.ngq);
                d.this.ngH.JR(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.WX.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.WX.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.ngG.LoadData()) {
                    d.this.WX.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.ngI = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ngG.aD(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ngG = new ForumRankModel(bundle);
        } else {
            this.ngG = new ForumRankModel(getIntent());
        }
        this.jMx = true;
        this.ngG.setLoadDataCallBack(this.ngJ);
        this.ngH = new b(getPageContext(), 0);
        this.ngH.JR(100);
        this.ngH.s(true);
        this.ngH.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.WX.setAdapter((ListAdapter) this.ngH);
        if (this.ngG.LoadData()) {
            this.ngH.JR(100);
            showProgressBar();
        }
        this.fgf = new LikeModel(getPageContext());
        this.ngH.a(this.fgf);
    }

    private void dNE() {
        ForumInfoData[] dND = this.ngH.dND();
        for (int i = 0; i < dND.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dND[i].forum_name);
            if (hasLikeForum == 1) {
                dND[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dND[i].is_like = 0;
            }
        }
        this.ngH.a(dND);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dNE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.WX.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.ngH.xT(true);
        } else {
            this.WX.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.ngH.xT(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.ngH.dx(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.ngq, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.ngG != null) {
            this.ngG.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
