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
    private BdListView Nj = null;
    private ForumRankModel jdz = null;
    private b jdA = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView fic = null;
    private LikeModel cer = null;
    private LinearLayout jdj = null;
    private i mPullView = null;
    private FrameLayout jdB = null;
    private String bGY = null;
    private boolean ghl = false;
    private final d jdC = new d() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.Nj.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.Nj.setVisibility(8);
                ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.Nj.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (ForumRankActivity.this.ghl) {
                        ForumRankActivity.this.Nj.addHeaderView(ForumRankActivity.this.fic, ForumRankActivity.this.jdD, false);
                        ForumRankActivity.this.ghl = false;
                    }
                    ForumRankActivity.this.fic.setVisibility(0);
                    ForumRankActivity.this.fic.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.fic.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.af(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.bGY = forumRankData.pic_url;
                }
                ForumRankActivity.this.jdA.a(forumRankData.forumsquare_list);
                ForumRankActivity.this.jdA.i(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && ForumRankActivity.this.Nj.getAdapter2().og() <= 0) {
                    ForumRankActivity.this.Nj.addFooterView(ForumRankActivity.this.jdj);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    ForumRankActivity.this.jdB.setVisibility(0);
                    return;
                } else {
                    ForumRankActivity.this.jdB.setVisibility(8);
                    return;
                }
            }
            ForumRankActivity.this.Nj.setVisibility(8);
            ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                ForumRankActivity.this.showToast(forumRankData.error.usermsg);
            } else {
                ForumRankActivity.this.showToast(R.string.neterror);
            }
        }
    };
    private final u jdD = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (ForumRankActivity.this.bGY == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ForumRankActivity.this.bGY);
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
        this.fic = new TbImageView(getPageContext().getPageActivity());
        this.fic.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Nj = (BdListView) findViewById(R.id.list);
        this.fic.setLayoutParams(new AbsListView.LayoutParams(l.af(getPageContext().getPageActivity()), (int) (l.af(getPageContext().getPageActivity()) * 0.5d)));
        this.fic.setVisibility(8);
        this.jdj = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumRankActivity.this.Nj.removeFooterView(ForumRankActivity.this.jdj);
                ForumRankActivity.this.jdA.Ah(100);
            }
        });
        this.mPullView = new i(getPageContext());
        this.Nj.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
        this.Nj.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (!ForumRankActivity.this.jdz.LoadData()) {
                    ForumRankActivity.this.Nj.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.jdB = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jdz.ab(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jdz = new ForumRankModel(bundle);
        } else {
            this.jdz = new ForumRankModel(getIntent());
        }
        this.ghl = true;
        this.jdz.setLoadDataCallBack(this.jdC);
        this.jdA = new b(getPageContext(), 0);
        this.jdA.Ah(100);
        this.jdA.i(true);
        this.jdA.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Nj.setAdapter((ListAdapter) this.jdA);
        if (this.jdz.LoadData()) {
            this.jdA.Ah(100);
            showProgressBar();
        }
        this.cer = new LikeModel(getPageContext());
        this.jdA.a(this.cer);
    }

    private void coS() {
        ForumInfoData[] coR = this.jdA.coR();
        for (int i = 0; i < coR.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(coR[i].forum_name);
            if (hasLikeForum == 1) {
                coR[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                coR[i].is_like = 0;
            }
        }
        this.jdA.a(coR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        coS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Nj.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.jdA.qY(true);
        } else {
            this.Nj.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.jdA.qY(false);
        }
        am.h(findViewById(R.id.root_view), i);
        this.mPullView.iY(i);
        this.jdA.cv(R.drawable.btn_add_end, R.drawable.btn_add);
        am.k(this.jdj, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.jdz != null) {
            this.jdz.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
