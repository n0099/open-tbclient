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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Um = null;
    private ForumRankModel lfE = null;
    private b lfF = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView gVF = null;
    private LikeModel dYI = null;
    private LinearLayout lfo = null;
    private g mPullView = null;
    private FrameLayout lfG = null;
    private String bAT = null;
    private boolean hYB = false;
    private final com.baidu.adp.base.d lfH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Um.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Um.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Um.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.hYB) {
                        d.this.Um.addHeaderView(d.this.gVF, d.this.lfI, false);
                        d.this.hYB = false;
                    }
                    d.this.gVF.setVisibility(0);
                    d.this.gVF.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.gVF.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bAT = forumRankData.pic_url;
                }
                d.this.lfF.a(forumRankData.forumsquare_list);
                d.this.lfF.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Um.getAdapter2().getFootersCount() <= 0) {
                    d.this.Um.addFooterView(d.this.lfo);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.lfG.setVisibility(0);
                    return;
                } else {
                    d.this.lfG.setVisibility(8);
                    return;
                }
            }
            d.this.Um.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final u lfI = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bAT == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bAT);
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
        this.gVF = new TbImageView(getPageContext().getPageActivity());
        this.gVF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Um = (BdListView) findViewById(R.id.list);
        this.gVF.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.gVF.setVisibility(8);
        this.lfo = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lfo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Um.removeFooterView(d.this.lfo);
                d.this.lfF.CP(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.Um.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Um.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.lfE.LoadData()) {
                    d.this.Um.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.lfG = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lfE.aA(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lfE = new ForumRankModel(bundle);
        } else {
            this.lfE = new ForumRankModel(getIntent());
        }
        this.hYB = true;
        this.lfE.setLoadDataCallBack(this.lfH);
        this.lfF = new b(getPageContext(), 0);
        this.lfF.CP(100);
        this.lfF.m(true);
        this.lfF.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Um.setAdapter((ListAdapter) this.lfF);
        if (this.lfE.LoadData()) {
            this.lfF.CP(100);
            showProgressBar();
        }
        this.dYI = new LikeModel(getPageContext());
        this.lfF.a(this.dYI);
    }

    private void dbT() {
        ForumInfoData[] dbS = this.lfF.dbS();
        for (int i = 0; i < dbS.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dbS[i].forum_name);
            if (hasLikeForum == 1) {
                dbS[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dbS[i].is_like = 0;
            }
        }
        this.lfF.a(dbS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dbT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Um.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.lfF.ul(true);
        } else {
            this.Um.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.lfF.ul(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.lfF.cT(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.lfo, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.lfE != null) {
            this.lfE.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
