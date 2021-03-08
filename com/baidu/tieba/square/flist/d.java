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
/* loaded from: classes7.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Yj = null;
    private ForumRankModel ntV = null;
    private b ntW = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView iQB = null;
    private LikeModel foW = null;
    private LinearLayout ntF = null;
    private g mPullView = null;
    private FrameLayout ntX = null;
    private String dev = null;
    private boolean kfa = false;
    private final e ntY = new e() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Yj.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Yj.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Yj.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.kfa) {
                        d.this.Yj.addHeaderView(d.this.iQB, d.this.ntZ, false);
                        d.this.kfa = false;
                    }
                    d.this.iQB.setVisibility(0);
                    d.this.iQB.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.iQB.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.dev = forumRankData.pic_url;
                }
                d.this.ntW.a(forumRankData.forumsquare_list);
                d.this.ntW.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Yj.getAdapter2().getFootersCount() <= 0) {
                    d.this.Yj.addFooterView(d.this.ntF);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.ntX.setVisibility(0);
                    return;
                } else {
                    d.this.ntX.setVisibility(8);
                    return;
                }
            }
            d.this.Yj.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w ntZ = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.dev == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.dev);
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
        this.iQB = new TbImageView(getPageContext().getPageActivity());
        this.iQB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Yj = (BdListView) findViewById(R.id.list);
        this.iQB.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.iQB.setVisibility(8);
        this.ntF = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ntF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Yj.removeFooterView(d.this.ntF);
                d.this.ntW.IC(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.Yj.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Yj.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.ntV.LoadData()) {
                    d.this.Yj.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.ntX = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ntV.aD(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ntV = new ForumRankModel(bundle);
        } else {
            this.ntV = new ForumRankModel(getIntent());
        }
        this.kfa = true;
        this.ntV.setLoadDataCallBack(this.ntY);
        this.ntW = new b(getPageContext(), 0);
        this.ntW.IC(100);
        this.ntW.s(true);
        this.ntW.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Yj.setAdapter((ListAdapter) this.ntW);
        if (this.ntV.LoadData()) {
            this.ntW.IC(100);
            showProgressBar();
        }
        this.foW = new LikeModel(getPageContext());
        this.ntW.a(this.foW);
    }

    private void dMh() {
        ForumInfoData[] dMg = this.ntW.dMg();
        for (int i = 0; i < dMg.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dMg[i].forum_name);
            if (hasLikeForum == 1) {
                dMg[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dMg[i].is_like = 0;
            }
        }
        this.ntW.a(dMg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dMh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Yj.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.ntW.yk(true);
        } else {
            this.Yj.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.ntW.yk(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.ntW.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.ntF, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.ntV != null) {
            this.ntV.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
