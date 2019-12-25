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
/* loaded from: classes7.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Ak = null;
    private ForumRankModel jWW = null;
    private b jWX = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView fYy = null;
    private LikeModel dfB = null;
    private LinearLayout jWG = null;
    private h mPullView = null;
    private FrameLayout jWY = null;
    private String mImageUrl = null;
    private boolean gTt = false;
    private final com.baidu.adp.base.d jWZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Ak.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Ak.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Ak.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.gTt) {
                        d.this.Ak.addHeaderView(d.this.fYy, d.this.jXa, false);
                        d.this.gTt = false;
                    }
                    d.this.fYy.setVisibility(0);
                    d.this.fYy.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.fYy.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.mImageUrl = forumRankData.pic_url;
                }
                d.this.jWX.a(forumRankData.forumsquare_list);
                d.this.jWX.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Ak.getAdapter2().getFootersCount() <= 0) {
                    d.this.Ak.addFooterView(d.this.jWG);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.jWY.setVisibility(0);
                    return;
                } else {
                    d.this.jWY.setVisibility(8);
                    return;
                }
            }
            d.this.Ak.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u jXa = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
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
        this.fYy = new TbImageView(getPageContext().getPageActivity());
        this.fYy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Ak = (BdListView) findViewById(R.id.list);
        this.fYy.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.fYy.setVisibility(8);
        this.jWG = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Ak.removeFooterView(d.this.jWG);
                d.this.jWX.Bj(100);
            }
        });
        this.mPullView = new h(getPageContext());
        this.Ak.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Ak.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.jWW.LoadData()) {
                    d.this.Ak.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.jWY = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jWW.au(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jWW = new ForumRankModel(bundle);
        } else {
            this.jWW = new ForumRankModel(getIntent());
        }
        this.gTt = true;
        this.jWW.setLoadDataCallBack(this.jWZ);
        this.jWX = new b(getPageContext(), 0);
        this.jWX.Bj(100);
        this.jWX.m(true);
        this.jWX.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Ak.setAdapter((ListAdapter) this.jWX);
        if (this.jWW.LoadData()) {
            this.jWX.Bj(100);
            showProgressBar();
        }
        this.dfB = new LikeModel(getPageContext());
        this.jWX.a(this.dfB);
    }

    private void cGP() {
        ForumInfoData[] cGO = this.jWX.cGO();
        for (int i = 0; i < cGO.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cGO[i].forum_name);
            if (hasLikeForum == 1) {
                cGO[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cGO[i].is_like = 0;
            }
        }
        this.jWX.a(cGO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cGP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Ak.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.jWX.sp(true);
        } else {
            this.Ak.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.jWX.sp(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.jWX.cG(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jWG, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.jWW != null) {
            this.jWW.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
