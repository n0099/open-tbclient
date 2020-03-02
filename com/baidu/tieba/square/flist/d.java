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
/* loaded from: classes10.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView AG = null;
    private ForumRankModel kbF = null;
    private b kbG = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gdK = null;
    private LikeModel djU = null;
    private LinearLayout kbp = null;
    private h mPullView = null;
    private FrameLayout kbH = null;
    private String mImageUrl = null;
    private boolean gYQ = false;
    private final com.baidu.adp.base.d kbI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.AG.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.AG.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.AG.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.gYQ) {
                        d.this.AG.addHeaderView(d.this.gdK, d.this.kbJ, false);
                        d.this.gYQ = false;
                    }
                    d.this.gdK.setVisibility(0);
                    d.this.gdK.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gdK.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.mImageUrl = forumRankData.pic_url;
                }
                d.this.kbG.a(forumRankData.forumsquare_list);
                d.this.kbG.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.AG.getAdapter2().getFootersCount() <= 0) {
                    d.this.AG.addFooterView(d.this.kbp);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.kbH.setVisibility(0);
                    return;
                } else {
                    d.this.kbH.setVisibility(8);
                    return;
                }
            }
            d.this.AG.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u kbJ = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
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
        this.gdK = new TbImageView(getPageContext().getPageActivity());
        this.gdK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.AG = (BdListView) findViewById(R.id.list);
        this.gdK.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gdK.setVisibility(8);
        this.kbp = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.AG.removeFooterView(d.this.kbp);
                d.this.kbG.Bx(100);
            }
        });
        this.mPullView = new h(getPageContext());
        this.AG.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.AG.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.kbF.LoadData()) {
                    d.this.AG.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.kbH = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kbF.au(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.kbF = new ForumRankModel(bundle);
        } else {
            this.kbF = new ForumRankModel(getIntent());
        }
        this.gYQ = true;
        this.kbF.setLoadDataCallBack(this.kbI);
        this.kbG = new b(getPageContext(), 0);
        this.kbG.Bx(100);
        this.kbG.m(true);
        this.kbG.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.AG.setAdapter((ListAdapter) this.kbG);
        if (this.kbF.LoadData()) {
            this.kbG.Bx(100);
            showProgressBar();
        }
        this.djU = new LikeModel(getPageContext());
        this.kbG.a(this.djU);
    }

    private void cJB() {
        ForumInfoData[] cJA = this.kbG.cJA();
        for (int i = 0; i < cJA.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cJA[i].forum_name);
            if (hasLikeForum == 1) {
                cJA[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cJA[i].is_like = 0;
            }
        }
        this.kbG.a(cJA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cJB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.AG.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.kbG.sF(true);
        } else {
            this.AG.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.kbG.sF(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.kbG.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kbp, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.kbF != null) {
            this.kbF.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
