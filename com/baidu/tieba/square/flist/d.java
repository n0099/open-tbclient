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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
    private BdListView US = null;
    private ForumRankModel lAK = null;
    private b lAL = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView hiH = null;
    private LikeModel egK = null;
    private LinearLayout lAu = null;
    private g mPullView = null;
    private FrameLayout lAM = null;
    private String bFH = null;
    private boolean inP = false;
    private final com.baidu.adp.base.d lAN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.US.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.US.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.US.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.inP) {
                        d.this.US.addHeaderView(d.this.hiH, d.this.lAO, false);
                        d.this.inP = false;
                    }
                    d.this.hiH.setVisibility(0);
                    d.this.hiH.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.hiH.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bFH = forumRankData.pic_url;
                }
                d.this.lAL.a(forumRankData.forumsquare_list);
                d.this.lAL.m(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.US.getAdapter2().getFootersCount() <= 0) {
                    d.this.US.addFooterView(d.this.lAu);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.lAM.setVisibility(0);
                    return;
                } else {
                    d.this.lAM.setVisibility(8);
                    return;
                }
            }
            d.this.US.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final v lAO = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bFH == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bFH);
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
        this.hiH = new TbImageView(getPageContext().getPageActivity());
        this.hiH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.US = (BdListView) findViewById(R.id.list);
        this.hiH.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.hiH.setVisibility(8);
        this.lAu = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.US.removeFooterView(d.this.lAu);
                d.this.lAL.DT(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.US.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.US.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.lAK.LoadData()) {
                    d.this.US.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.lAM = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lAK.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lAK = new ForumRankModel(bundle);
        } else {
            this.lAK = new ForumRankModel(getIntent());
        }
        this.inP = true;
        this.lAK.setLoadDataCallBack(this.lAN);
        this.lAL = new b(getPageContext(), 0);
        this.lAL.DT(100);
        this.lAL.m(true);
        this.lAL.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.US.setAdapter((ListAdapter) this.lAL);
        if (this.lAK.LoadData()) {
            this.lAL.DT(100);
            showProgressBar();
        }
        this.egK = new LikeModel(getPageContext());
        this.lAL.a(this.egK);
    }

    private void dgx() {
        ForumInfoData[] dgw = this.lAL.dgw();
        for (int i = 0; i < dgw.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dgw[i].forum_name);
            if (hasLikeForum == 1) {
                dgw[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dgw[i].is_like = 0;
            }
        }
        this.lAL.a(dgw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dgx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.US.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.lAL.uA(true);
        } else {
            this.US.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.lAL.uA(false);
        }
        an.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.lAL.cZ(R.drawable.btn_add_end, R.drawable.btn_add);
        an.setBackgroundResource(this.lAu, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.lAK != null) {
            this.lAK.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
