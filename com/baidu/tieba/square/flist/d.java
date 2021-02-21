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
    private ForumRankModel nrR = null;
    private b nrS = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView iOS = null;
    private LikeModel fnw = null;
    private LinearLayout nrB = null;
    private g mPullView = null;
    private FrameLayout nrT = null;
    private String dcS = null;
    private boolean kcX = false;
    private final e nrU = new e() { // from class: com.baidu.tieba.square.flist.d.3
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
                    if (d.this.kcX) {
                        d.this.WO.addHeaderView(d.this.iOS, d.this.nrV, false);
                        d.this.kcX = false;
                    }
                    d.this.iOS.setVisibility(0);
                    d.this.iOS.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.iOS.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.dcS = forumRankData.pic_url;
                }
                d.this.nrS.a(forumRankData.forumsquare_list);
                d.this.nrS.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.WO.getAdapter2().getFootersCount() <= 0) {
                    d.this.WO.addFooterView(d.this.nrB);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.nrT.setVisibility(0);
                    return;
                } else {
                    d.this.nrT.setVisibility(8);
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
    private final w nrV = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
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
        this.iOS = new TbImageView(getPageContext().getPageActivity());
        this.iOS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.WO = (BdListView) findViewById(R.id.list);
        this.iOS.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.iOS.setVisibility(8);
        this.nrB = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nrB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WO.removeFooterView(d.this.nrB);
                d.this.nrS.Iy(100);
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
                if (!d.this.nrR.LoadData()) {
                    d.this.WO.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.nrT = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.nrR.aD(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.nrR = new ForumRankModel(bundle);
        } else {
            this.nrR = new ForumRankModel(getIntent());
        }
        this.kcX = true;
        this.nrR.setLoadDataCallBack(this.nrU);
        this.nrS = new b(getPageContext(), 0);
        this.nrS.Iy(100);
        this.nrS.s(true);
        this.nrS.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.WO.setAdapter((ListAdapter) this.nrS);
        if (this.nrR.LoadData()) {
            this.nrS.Iy(100);
            showProgressBar();
        }
        this.fnw = new LikeModel(getPageContext());
        this.nrS.a(this.fnw);
    }

    private void dLZ() {
        ForumInfoData[] dLY = this.nrS.dLY();
        for (int i = 0; i < dLY.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dLY[i].forum_name);
            if (hasLikeForum == 1) {
                dLY[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dLY[i].is_like = 0;
            }
        }
        this.nrS.a(dLY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dLZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.WO.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.nrS.yk(true);
        } else {
            this.WO.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.nrS.yk(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.nrS.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nrB, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.nrR != null) {
            this.nrR.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
