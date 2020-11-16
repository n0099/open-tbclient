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
/* loaded from: classes22.dex */
public class d extends ProxyAdkBaseActivity<d> {
    private BdListView Wa = null;
    private ForumRankModel mSE = null;
    private b mSF = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView iqx = null;
    private LikeModel eYI = null;
    private LinearLayout mSm = null;
    private g mPullView = null;
    private FrameLayout mSG = null;
    private String cgQ = null;
    private boolean jyV = false;
    private final com.baidu.adp.base.d mSH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            d.this.hideProgressBar();
            d.this.Wa.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                d.this.Wa.setVisibility(8);
                d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                d.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                d.this.Wa.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (d.this.jyV) {
                        d.this.Wa.addHeaderView(d.this.iqx, d.this.mSI, false);
                        d.this.jyV = false;
                    }
                    d.this.iqx.setVisibility(0);
                    d.this.iqx.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.iqx.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.cgQ = forumRankData.pic_url;
                }
                d.this.mSF.a(forumRankData.forumsquare_list);
                d.this.mSF.s(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Wa.getAdapter2().getFootersCount() <= 0) {
                    d.this.Wa.addFooterView(d.this.mSm);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.mSG.setVisibility(0);
                    return;
                } else {
                    d.this.mSG.setVisibility(8);
                    return;
                }
            }
            d.this.Wa.setVisibility(8);
            d.this.showNetRefreshView(d.this.findViewById(R.id.root_view), d.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            d.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                d.this.showToast(forumRankData.error.usermsg);
            } else {
                d.this.showToast(R.string.neterror);
            }
        }
    };
    private final w mSI = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.cgQ == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.cgQ);
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
        this.iqx = new TbImageView(getPageContext().getPageActivity());
        this.iqx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Wa = (BdListView) findViewById(R.id.list);
        this.iqx.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.iqx.setVisibility(8);
        this.mSm = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mSm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Wa.removeFooterView(d.this.mSm);
                d.this.mSF.Ja(100);
            }
        });
        this.mPullView = new g(getPageContext());
        this.Wa.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.Wa.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.square.flist.d.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!d.this.mSE.LoadData()) {
                    d.this.Wa.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.mSG = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mSE.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mSE = new ForumRankModel(bundle);
        } else {
            this.mSE = new ForumRankModel(getIntent());
        }
        this.jyV = true;
        this.mSE.setLoadDataCallBack(this.mSH);
        this.mSF = new b(getPageContext(), 0);
        this.mSF.Ja(100);
        this.mSF.s(true);
        this.mSF.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Wa.setAdapter((ListAdapter) this.mSF);
        if (this.mSE.LoadData()) {
            this.mSF.Ja(100);
            showProgressBar();
        }
        this.eYI = new LikeModel(getPageContext());
        this.mSF.a(this.eYI);
    }

    private void dIo() {
        ForumInfoData[] dIn = this.mSF.dIn();
        for (int i = 0; i < dIn.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dIn[i].forum_name);
            if (hasLikeForum == 1) {
                dIn[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dIn[i].is_like = 0;
            }
        }
        this.mSF.a(dIn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dIo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Wa.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.mSF.xp(true);
        } else {
            this.Wa.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.mSF.xp(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.mSF.ds(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mSm, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.mSE != null) {
            this.mSE.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
