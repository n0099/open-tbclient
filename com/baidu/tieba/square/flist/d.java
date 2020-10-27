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
    private BdListView VY = null;
    private ForumRankModel mLL = null;
    private b mLM = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView ijK = null;
    private LikeModel eTL = null;
    private LinearLayout mLv = null;
    private g mPullView = null;
    private FrameLayout mLN = null;
    private String ccQ = null;
    private boolean jsh = false;
    private final com.baidu.adp.base.d mLO = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.VY.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.VY.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.VY.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.jsh) {
                        d.this.VY.addHeaderView(d.this.ijK, d.this.mLP, false);
                        d.this.jsh = false;
                    }
                    d.this.ijK.setVisibility(0);
                    d.this.ijK.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.ijK.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.ccQ = forumRankData.pic_url;
                }
                d.this.mLM.a(forumRankData.forumsquare_list);
                d.this.mLM.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.VY.getAdapter2().getFootersCount() <= 0) {
                    d.this.VY.addFooterView(d.this.mLv);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.mLN.setVisibility(0);
                    return;
                } else {
                    d.this.mLN.setVisibility(8);
                    return;
                }
            }
            d.this.VY.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w mLP = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.ccQ == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.ccQ);
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
        this.ijK = new TbImageView(getPageContext().getPageActivity());
        this.ijK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.VY = (BdListView) findViewById(R.id.list);
        this.ijK.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.ijK.setVisibility(8);
        this.mLv = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.VY.removeFooterView(d.this.mLv);
                d.this.mLM.Im(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.VY.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.VY.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.mLL.LoadData()) {
                    d.this.VY.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.mLN = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mLL.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mLL = new ForumRankModel(bundle);
        } else {
            this.mLL = new ForumRankModel(getIntent());
        }
        this.jsh = true;
        this.mLL.setLoadDataCallBack(this.mLO);
        this.mLM = new b(getPageContext(), 0);
        this.mLM.Im(100);
        this.mLM.s(true);
        this.mLM.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.VY.setAdapter((ListAdapter) this.mLM);
        if (this.mLL.LoadData()) {
            this.mLM.Im(100);
            showProgressBar();
        }
        this.eTL = new LikeModel(getPageContext());
        this.mLM.a(this.eTL);
    }

    private void dFV() {
        ForumInfoData[] dFU = this.mLM.dFU();
        for (int i = 0; i < dFU.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dFU[i].forum_name);
            if (hasLikeForum == 1) {
                dFU[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dFU[i].is_like = 0;
            }
        }
        this.mLM.a(dFU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dFV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.VY.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.mLM.xc(true);
        } else {
            this.VY.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.mLM.xc(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.mLM.dp(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mLv, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.mLL != null) {
            this.mLL.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
