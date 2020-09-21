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
/* loaded from: classes22.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView VG = null;
    private ForumRankModel mjA = null;
    private b mjB = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView hIp = null;
    private LikeModel ezi = null;
    private LinearLayout mjk = null;
    private g mPullView = null;
    private FrameLayout mjC = null;
    private String bNJ = null;
    private boolean iQP = false;
    private final com.baidu.adp.base.d mjD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.VG.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.VG.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.VG.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.iQP) {
                        d.this.VG.addHeaderView(d.this.hIp, d.this.mjE, false);
                        d.this.iQP = false;
                    }
                    d.this.hIp.setVisibility(0);
                    d.this.hIp.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.hIp.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bNJ = forumRankData.pic_url;
                }
                d.this.mjB.a(forumRankData.forumsquare_list);
                d.this.mjB.r(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.VG.getAdapter2().getFootersCount() <= 0) {
                    d.this.VG.addFooterView(d.this.mjk);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.mjC.setVisibility(0);
                    return;
                } else {
                    d.this.mjC.setVisibility(8);
                    return;
                }
            }
            d.this.VG.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w mjE = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bNJ == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bNJ);
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
        this.hIp = new TbImageView(getPageContext().getPageActivity());
        this.hIp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.VG = (BdListView) findViewById(R.id.list);
        this.hIp.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.hIp.setVisibility(8);
        this.mjk = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mjk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.VG.removeFooterView(d.this.mjk);
                d.this.mjB.Hn(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.VG.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.VG.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.mjA.LoadData()) {
                    d.this.VG.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.mjC = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mjA.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mjA = new ForumRankModel(bundle);
        } else {
            this.mjA = new ForumRankModel(getIntent());
        }
        this.iQP = true;
        this.mjA.setLoadDataCallBack(this.mjD);
        this.mjB = new b(getPageContext(), 0);
        this.mjB.Hn(100);
        this.mjB.r(true);
        this.mjB.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.VG.setAdapter((ListAdapter) this.mjB);
        if (this.mjA.LoadData()) {
            this.mjB.Hn(100);
            showProgressBar();
        }
        this.ezi = new LikeModel(getPageContext());
        this.mjB.a(this.ezi);
    }

    private void dzc() {
        ForumInfoData[] dzb = this.mjB.dzb();
        for (int i = 0; i < dzb.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dzb[i].forum_name);
            if (hasLikeForum == 1) {
                dzb[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dzb[i].is_like = 0;
            }
        }
        this.mjB.a(dzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dzc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.VG.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.mjB.we(true);
        } else {
            this.VG.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.mjB.we(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.mjB.dn(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mjk, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.mjA != null) {
            this.mjA.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
