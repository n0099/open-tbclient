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
    private BdListView VX = null;
    private ForumRankModel mzb = null;
    private b mzc = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView hXk = null;
    private LikeModel eLp = null;
    private LinearLayout myL = null;
    private g mPullView = null;
    private FrameLayout mzd = null;
    private String bUs = null;
    private boolean jfJ = false;
    private final com.baidu.adp.base.d mze = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.VX.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.VX.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.VX.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.jfJ) {
                        d.this.VX.addHeaderView(d.this.hXk, d.this.mzf, false);
                        d.this.jfJ = false;
                    }
                    d.this.hXk.setVisibility(0);
                    d.this.hXk.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.hXk.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bUs = forumRankData.pic_url;
                }
                d.this.mzc.a(forumRankData.forumsquare_list);
                d.this.mzc.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.VX.getAdapter2().getFootersCount() <= 0) {
                    d.this.VX.addFooterView(d.this.myL);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.mzd.setVisibility(0);
                    return;
                } else {
                    d.this.mzd.setVisibility(8);
                    return;
                }
            }
            d.this.VX.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w mzf = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bUs == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bUs);
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
        this.hXk = new TbImageView(getPageContext().getPageActivity());
        this.hXk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.VX = (BdListView) findViewById(R.id.list);
        this.hXk.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.hXk.setVisibility(8);
        this.myL = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.myL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.VX.removeFooterView(d.this.myL);
                d.this.mzc.HT(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.VX.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.VX.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.mzb.LoadData()) {
                    d.this.VX.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.mzd = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mzb.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mzb = new ForumRankModel(bundle);
        } else {
            this.mzb = new ForumRankModel(getIntent());
        }
        this.jfJ = true;
        this.mzb.setLoadDataCallBack(this.mze);
        this.mzc = new b(getPageContext(), 0);
        this.mzc.HT(100);
        this.mzc.s(true);
        this.mzc.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.VX.setAdapter((ListAdapter) this.mzc);
        if (this.mzb.LoadData()) {
            this.mzc.HT(100);
            showProgressBar();
        }
        this.eLp = new LikeModel(getPageContext());
        this.mzc.a(this.eLp);
    }

    private void dCN() {
        ForumInfoData[] dCM = this.mzc.dCM();
        for (int i = 0; i < dCM.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dCM[i].forum_name);
            if (hasLikeForum == 1) {
                dCM[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dCM[i].is_like = 0;
            }
        }
        this.mzc.a(dCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dCN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.VX.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.mzc.wL(true);
        } else {
            this.VX.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.mzc.wL(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.mzc.dn(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.myL, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.mzb != null) {
            this.mzb.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
