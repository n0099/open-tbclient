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
import com.baidu.adp.base.d;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {
    private BdListView xL = null;
    private ForumRankModel jcz = null;
    private b jcA = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView fjZ = null;
    private LikeModel crO = null;
    private LinearLayout jcj = null;
    private i mPullView = null;
    private FrameLayout jcB = null;
    private String bXS = null;
    private boolean gfR = false;
    private final d jcC = new d() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.xL.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.xL.setVisibility(8);
                ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.xL.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (ForumRankActivity.this.gfR) {
                        ForumRankActivity.this.xL.addHeaderView(ForumRankActivity.this.fjZ, ForumRankActivity.this.jcD, false);
                        ForumRankActivity.this.gfR = false;
                    }
                    ForumRankActivity.this.fjZ.setVisibility(0);
                    ForumRankActivity.this.fjZ.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.fjZ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.bXS = forumRankData.pic_url;
                }
                ForumRankActivity.this.jcA.a(forumRankData.forumsquare_list);
                ForumRankActivity.this.jcA.i(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && ForumRankActivity.this.xL.getAdapter2().getFootersCount() <= 0) {
                    ForumRankActivity.this.xL.addFooterView(ForumRankActivity.this.jcj);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    ForumRankActivity.this.jcB.setVisibility(0);
                    return;
                } else {
                    ForumRankActivity.this.jcB.setVisibility(8);
                    return;
                }
            }
            ForumRankActivity.this.xL.setVisibility(8);
            ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                ForumRankActivity.this.showToast(forumRankData.error.usermsg);
            } else {
                ForumRankActivity.this.showToast(R.string.neterror);
            }
        }
    };
    private final u jcD = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (ForumRankActivity.this.bXS == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ForumRankActivity.this.bXS);
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
        this.fjZ = new TbImageView(getPageContext().getPageActivity());
        this.fjZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.xL = (BdListView) findViewById(R.id.list);
        this.fjZ.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.fjZ.setVisibility(8);
        this.jcj = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumRankActivity.this.xL.removeFooterView(ForumRankActivity.this.jcj);
                ForumRankActivity.this.jcA.yO(100);
            }
        });
        this.mPullView = new i(getPageContext());
        this.xL.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds98)));
        this.xL.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (!ForumRankActivity.this.jcz.LoadData()) {
                    ForumRankActivity.this.xL.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.jcB = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jcz.aa(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jcz = new ForumRankModel(bundle);
        } else {
            this.jcz = new ForumRankModel(getIntent());
        }
        this.gfR = true;
        this.jcz.setLoadDataCallBack(this.jcC);
        this.jcA = new b(getPageContext(), 0);
        this.jcA.yO(100);
        this.jcA.i(true);
        this.jcA.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.xL.setAdapter((ListAdapter) this.jcA);
        if (this.jcz.LoadData()) {
            this.jcA.yO(100);
            showProgressBar();
        }
        this.crO = new LikeModel(getPageContext());
        this.jcA.a(this.crO);
    }

    private void cmG() {
        ForumInfoData[] cmF = this.jcA.cmF();
        for (int i = 0; i < cmF.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cmF[i].forum_name);
            if (hasLikeForum == 1) {
                cmF[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cmF[i].is_like = 0;
            }
        }
        this.jcA.a(cmF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cmG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.xL.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.jcA.qH(true);
        } else {
            this.xL.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.jcA.qH(false);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.jcA.cm(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jcj, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.jcz != null) {
            this.jcz.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
