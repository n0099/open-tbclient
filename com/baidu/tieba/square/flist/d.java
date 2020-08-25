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
/* loaded from: classes17.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Vo = null;
    private ForumRankModel lZH = null;
    private b lZI = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView hBh = null;
    private LikeModel ewX = null;
    private LinearLayout lZr = null;
    private g mPullView = null;
    private FrameLayout lZJ = null;
    private String bLF = null;
    private boolean iIi = false;
    private final com.baidu.adp.base.d lZK = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Vo.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Vo.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Vo.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.iIi) {
                        d.this.Vo.addHeaderView(d.this.hBh, d.this.lZL, false);
                        d.this.iIi = false;
                    }
                    d.this.hBh.setVisibility(0);
                    d.this.hBh.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.hBh.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bLF = forumRankData.pic_url;
                }
                d.this.lZI.a(forumRankData.forumsquare_list);
                d.this.lZI.q(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Vo.getAdapter2().getFootersCount() <= 0) {
                    d.this.Vo.addFooterView(d.this.lZr);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.lZJ.setVisibility(0);
                    return;
                } else {
                    d.this.lZJ.setVisibility(8);
                    return;
                }
            }
            d.this.Vo.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w lZL = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bLF == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bLF);
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
        this.hBh = new TbImageView(getPageContext().getPageActivity());
        this.hBh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Vo = (BdListView) findViewById(R.id.list);
        this.hBh.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.hBh.setVisibility(8);
        this.lZr = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lZr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Vo.removeFooterView(d.this.lZr);
                d.this.lZI.GM(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.Vo.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Vo.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.lZH.LoadData()) {
                    d.this.Vo.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.lZJ = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lZH.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lZH = new ForumRankModel(bundle);
        } else {
            this.lZH = new ForumRankModel(getIntent());
        }
        this.iIi = true;
        this.lZH.setLoadDataCallBack(this.lZK);
        this.lZI = new b(getPageContext(), 0);
        this.lZI.GM(100);
        this.lZI.q(true);
        this.lZI.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Vo.setAdapter((ListAdapter) this.lZI);
        if (this.lZH.LoadData()) {
            this.lZI.GM(100);
            showProgressBar();
        }
        this.ewX = new LikeModel(getPageContext());
        this.lZI.a(this.ewX);
    }

    private void dve() {
        ForumInfoData[] dvd = this.lZI.dvd();
        for (int i = 0; i < dvd.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dvd[i].forum_name);
            if (hasLikeForum == 1) {
                dvd[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dvd[i].is_like = 0;
            }
        }
        this.lZI.a(dvd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dve();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Vo.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.lZI.vT(true);
        } else {
            this.Vo.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.lZI.vT(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.lZI.dj(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.lZr, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.lZH != null) {
            this.lZH.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
