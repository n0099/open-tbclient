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
import com.baidu.tieba.d;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {
    private BdListView Pj = null;
    private ForumRankModel iAP = null;
    private b iAQ = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView eKE = null;
    private LikeModel bUt = null;
    private LinearLayout iAz = null;
    private i mPullView = null;
    private FrameLayout iAR = null;
    private String bym = null;
    private boolean fII = false;
    private final d iAS = new d() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.Pj.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.Pj.setVisibility(8);
                ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(d.g.root_view), ForumRankActivity.this.getResources().getString(d.j.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(d.j.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.Pj.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (ForumRankActivity.this.fII) {
                        ForumRankActivity.this.Pj.addHeaderView(ForumRankActivity.this.eKE, ForumRankActivity.this.iAT, false);
                        ForumRankActivity.this.fII = false;
                    }
                    ForumRankActivity.this.eKE.setVisibility(0);
                    ForumRankActivity.this.eKE.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.eKE.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.aO(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.bym = forumRankData.pic_url;
                }
                ForumRankActivity.this.iAQ.a(forumRankData.forumsquare_list);
                ForumRankActivity.this.iAQ.i(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && ForumRankActivity.this.Pj.getAdapter2().getFootersCount() <= 0) {
                    ForumRankActivity.this.Pj.addFooterView(ForumRankActivity.this.iAz);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    ForumRankActivity.this.iAR.setVisibility(0);
                    return;
                } else {
                    ForumRankActivity.this.iAR.setVisibility(8);
                    return;
                }
            }
            ForumRankActivity.this.Pj.setVisibility(8);
            ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(d.g.root_view), ForumRankActivity.this.getResources().getString(d.j.recommend_pb_no_net_text), true);
            ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                ForumRankActivity.this.showToast(forumRankData.error.usermsg);
            } else {
                ForumRankActivity.this.showToast(d.j.neterror);
            }
        }
    };
    private final u iAT = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (ForumRankActivity.this.bym == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ForumRankActivity.this.bym);
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
        setContentView(d.h.forum_rank_activity);
        this.eKE = new TbImageView(getPageContext().getPageActivity());
        this.eKE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Pj = (BdListView) findViewById(d.g.list);
        this.eKE.setLayoutParams(new AbsListView.LayoutParams(l.aO(getPageContext().getPageActivity()), (int) (l.aO(getPageContext().getPageActivity()) * 0.5d)));
        this.eKE.setVisibility(8);
        this.iAz = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumRankActivity.this.Pj.removeFooterView(ForumRankActivity.this.iAz);
                ForumRankActivity.this.iAQ.yp(100);
            }
        });
        this.mPullView = new i(getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(getActivity(), d.e.ds98)));
        this.Pj.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (!ForumRankActivity.this.iAP.LoadData()) {
                    ForumRankActivity.this.Pj.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.iAR = (FrameLayout) findViewById(d.g.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iAP.aa(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iAP = new ForumRankModel(bundle);
        } else {
            this.iAP = new ForumRankModel(getIntent());
        }
        this.fII = true;
        this.iAP.setLoadDataCallBack(this.iAS);
        this.iAQ = new b(getPageContext(), 0);
        this.iAQ.yp(100);
        this.iAQ.i(true);
        this.iAQ.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Pj.setAdapter((ListAdapter) this.iAQ);
        if (this.iAP.LoadData()) {
            this.iAQ.yp(100);
            showProgressBar();
        }
        this.bUt = new LikeModel(getPageContext());
        this.iAQ.a(this.bUt);
    }

    private void ccO() {
        ForumInfoData[] ccN = this.iAQ.ccN();
        for (int i = 0; i < ccN.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(ccN[i].forum_name);
            if (hasLikeForum == 1) {
                ccN[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                ccN[i].is_like = 0;
            }
        }
        this.iAQ.a(ccN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        ccO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1) {
            this.Pj.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10150));
            this.iAQ.pP(true);
        } else {
            this.Pj.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10163));
            this.iAQ.pP(false);
        }
        al.h(findViewById(d.g.root_view), i);
        this.mPullView.ib(i);
        this.iAQ.ck(d.f.btn_add_end, d.f.btn_add);
        al.k(this.iAz, d.f.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.iAP != null) {
            this.iAP.LoadData();
            hideNetRefreshView(findViewById(d.g.root_view));
        }
    }
}
