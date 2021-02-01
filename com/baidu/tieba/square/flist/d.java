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
/* loaded from: classes8.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView WO = null;
    private ForumRankModel nrr = null;
    private b nrs = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView iOE = null;
    private LikeModel fnw = null;
    private LinearLayout nrb = null;
    private g mPullView = null;
    private FrameLayout nrt = null;
    private String dcS = null;
    private boolean kcJ = false;
    private final e nru = new e() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.WO.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.WO.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.WO.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.kcJ) {
                        d.this.WO.addHeaderView(d.this.iOE, d.this.nrv, false);
                        d.this.kcJ = false;
                    }
                    d.this.iOE.setVisibility(0);
                    d.this.iOE.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.iOE.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.dcS = forumRankData.pic_url;
                }
                d.this.nrs.a(forumRankData.forumsquare_list);
                d.this.nrs.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.WO.getAdapter2().getFootersCount() <= 0) {
                    d.this.WO.addFooterView(d.this.nrb);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.nrt.setVisibility(0);
                    return;
                } else {
                    d.this.nrt.setVisibility(8);
                    return;
                }
            }
            d.this.WO.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w nrv = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.dcS == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.dcS);
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
        this.iOE = new TbImageView(getPageContext().getPageActivity());
        this.iOE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.WO = (BdListView) findViewById(R.id.list);
        this.iOE.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.iOE.setVisibility(8);
        this.nrb = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nrb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WO.removeFooterView(d.this.nrb);
                d.this.nrs.Iy(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.WO.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.WO.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.nrr.LoadData()) {
                    d.this.WO.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.nrt = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.nrr.aD(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.nrr = new ForumRankModel(bundle);
        } else {
            this.nrr = new ForumRankModel(getIntent());
        }
        this.kcJ = true;
        this.nrr.setLoadDataCallBack(this.nru);
        this.nrs = new b(getPageContext(), 0);
        this.nrs.Iy(100);
        this.nrs.s(true);
        this.nrs.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.WO.setAdapter((ListAdapter) this.nrs);
        if (this.nrr.LoadData()) {
            this.nrs.Iy(100);
            showProgressBar();
        }
        this.fnw = new LikeModel(getPageContext());
        this.nrs.a(this.fnw);
    }

    private void dLR() {
        ForumInfoData[] dLQ = this.nrs.dLQ();
        for (int i = 0; i < dLQ.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dLQ[i].forum_name);
            if (hasLikeForum == 1) {
                dLQ[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dLQ[i].is_like = 0;
            }
        }
        this.nrs.a(dLQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dLR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.WO.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.nrs.yk(true);
        } else {
            this.WO.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.nrs.yk(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.nrs.dq(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nrb, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.nrr != null) {
            this.nrr.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
