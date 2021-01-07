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
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView WV = null;
    private ForumRankModel nmn = null;
    private b nmo = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView iND = null;
    private LikeModel fpO = null;
    private LinearLayout nlX = null;
    private g mPullView = null;
    private FrameLayout nmp = null;
    private String cuF = null;
    private boolean jZN = false;
    private final e nmq = new e() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.WV.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.WV.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.WV.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.jZN) {
                        d.this.WV.addHeaderView(d.this.iND, d.this.nmr, false);
                        d.this.jZN = false;
                    }
                    d.this.iND.setVisibility(0);
                    d.this.iND.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.iND.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.cuF = forumRankData.pic_url;
                }
                d.this.nmo.a(forumRankData.forumsquare_list);
                d.this.nmo.t(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.WV.getAdapter2().getFootersCount() <= 0) {
                    d.this.WV.addFooterView(d.this.nlX);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.nmp.setVisibility(0);
                    return;
                } else {
                    d.this.nmp.setVisibility(8);
                    return;
                }
            }
            d.this.WV.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final v nmr = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.cuF == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.cuF);
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
        this.iND = new TbImageView(getPageContext().getPageActivity());
        this.iND.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.WV = (BdListView) findViewById(R.id.list);
        this.iND.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.iND.setVisibility(8);
        this.nlX = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nlX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WV.removeFooterView(d.this.nlX);
                d.this.nmo.JL(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.WV.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.WV.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.nmn.LoadData()) {
                    d.this.WV.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.nmp = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.nmn.aD(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.nmn = new ForumRankModel(bundle);
        } else {
            this.nmn = new ForumRankModel(getIntent());
        }
        this.jZN = true;
        this.nmn.setLoadDataCallBack(this.nmq);
        this.nmo = new b(getPageContext(), 0);
        this.nmo.JL(100);
        this.nmo.t(true);
        this.nmo.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.WV.setAdapter((ListAdapter) this.nmo);
        if (this.nmn.LoadData()) {
            this.nmo.JL(100);
            showProgressBar();
        }
        this.fpO = new LikeModel(getPageContext());
        this.nmo.a(this.fpO);
    }

    private void dNy() {
        ForumInfoData[] dNx = this.nmo.dNx();
        for (int i = 0; i < dNx.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dNx[i].forum_name);
            if (hasLikeForum == 1) {
                dNx[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dNx[i].is_like = 0;
            }
        }
        this.nmo.a(dNx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dNy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.WV.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.nmo.xV(true);
        } else {
            this.WV.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.nmo.xV(false);
        }
        ao.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.nmo.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.nlX, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.nmn != null) {
            this.nmn.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
