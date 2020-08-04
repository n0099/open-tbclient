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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView UL = null;
    private ForumRankModel lIb = null;
    private b lIc = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView hoq = null;
    private LikeModel emT = null;
    private LinearLayout lHL = null;
    private g mPullView = null;
    private FrameLayout lId = null;
    private String bGf = null;
    private boolean itT = false;
    private final com.baidu.adp.base.d lIe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.UL.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.UL.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.UL.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.itT) {
                        d.this.UL.addHeaderView(d.this.hoq, d.this.lIf, false);
                        d.this.itT = false;
                    }
                    d.this.hoq.setVisibility(0);
                    d.this.hoq.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.hoq.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bGf = forumRankData.pic_url;
                }
                d.this.lIc.a(forumRankData.forumsquare_list);
                d.this.lIc.o(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.UL.getAdapter2().getFootersCount() <= 0) {
                    d.this.UL.addFooterView(d.this.lHL);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.lId.setVisibility(0);
                    return;
                } else {
                    d.this.lId.setVisibility(8);
                    return;
                }
            }
            d.this.UL.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w lIf = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bGf == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bGf);
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
        this.hoq = new TbImageView(getPageContext().getPageActivity());
        this.hoq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.UL = (BdListView) findViewById(R.id.list);
        this.hoq.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.hoq.setVisibility(8);
        this.lHL = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.UL.removeFooterView(d.this.lHL);
                d.this.lIc.Ep(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.UL.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.UL.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.lIb.LoadData()) {
                    d.this.UL.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.lId = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lIb.aD(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lIb = new ForumRankModel(bundle);
        } else {
            this.lIb = new ForumRankModel(getIntent());
        }
        this.itT = true;
        this.lIb.setLoadDataCallBack(this.lIe);
        this.lIc = new b(getPageContext(), 0);
        this.lIc.Ep(100);
        this.lIc.o(true);
        this.lIc.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.UL.setAdapter((ListAdapter) this.lIc);
        if (this.lIb.LoadData()) {
            this.lIc.Ep(100);
            showProgressBar();
        }
        this.emT = new LikeModel(getPageContext());
        this.lIc.a(this.emT);
    }

    private void djH() {
        ForumInfoData[] djG = this.lIc.djG();
        for (int i = 0; i < djG.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(djG[i].forum_name);
            if (hasLikeForum == 1) {
                djG[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                djG[i].is_like = 0;
            }
        }
        this.lIc.a(djG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        djH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.UL.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.lIc.ve(true);
        } else {
            this.UL.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.lIc.ve(false);
        }
        ao.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.lIc.db(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.lHL, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.lIb != null) {
            this.lIb.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
