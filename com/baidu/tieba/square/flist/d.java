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
    private ForumRankModel kbD = null;
    private b kbE = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gdI = null;
    private LikeModel djT = null;
    private LinearLayout kbn = null;
    private h mPullView = null;
    private FrameLayout kbF = null;
    private String mImageUrl = null;
    private boolean gYO = false;
    private final com.baidu.adp.base.d kbG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
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
                    if (d.this.gYO) {
                        d.this.AG.addHeaderView(d.this.gdI, d.this.kbH, false);
                        d.this.gYO = false;
                    }
                    d.this.gdI.setVisibility(0);
                    d.this.gdI.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gdI.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.mImageUrl = forumRankData.pic_url;
                }
                d.this.kbE.a(forumRankData.forumsquare_list);
                d.this.kbE.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.AG.getAdapter2().getFootersCount() <= 0) {
                    d.this.AG.addFooterView(d.this.kbn);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.kbF.setVisibility(0);
                    return;
                } else {
                    d.this.kbF.setVisibility(8);
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
    private final u kbH = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
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
        this.gdI = new TbImageView(getPageContext().getPageActivity());
        this.gdI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.AG = (BdListView) findViewById(R.id.list);
        this.gdI.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gdI.setVisibility(8);
        this.kbn = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.AG.removeFooterView(d.this.kbn);
                d.this.kbE.Bx(100);
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
                if (!d.this.kbD.LoadData()) {
                    d.this.AG.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.kbF = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kbD.au(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.kbD = new ForumRankModel(bundle);
        } else {
            this.kbD = new ForumRankModel(getIntent());
        }
        this.gYO = true;
        this.kbD.setLoadDataCallBack(this.kbG);
        this.kbE = new b(getPageContext(), 0);
        this.kbE.Bx(100);
        this.kbE.m(true);
        this.kbE.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.AG.setAdapter((ListAdapter) this.kbE);
        if (this.kbD.LoadData()) {
            this.kbE.Bx(100);
            showProgressBar();
        }
        this.djT = new LikeModel(getPageContext());
        this.kbE.a(this.djT);
    }

    private void cJz() {
        ForumInfoData[] cJy = this.kbE.cJy();
        for (int i = 0; i < cJy.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cJy[i].forum_name);
            if (hasLikeForum == 1) {
                cJy[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cJy[i].is_like = 0;
            }
        }
        this.kbE.a(cJy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cJz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.AG.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.kbE.sF(true);
        } else {
            this.AG.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.kbE.sF(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.kbE.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kbn, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.kbD != null) {
            this.kbD.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
