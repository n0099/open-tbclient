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
    private BdListView Ni = null;
    private ForumRankModel jaa = null;
    private b jab = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView ffP = null;
    private LikeModel cdr = null;
    private LinearLayout iZK = null;
    private i mPullView = null;
    private FrameLayout jac = null;
    private String bGz = null;
    private boolean geE = false;
    private final d jad = new d() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.Ni.completePullRefreshPostDelayed(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.Ni.setVisibility(8);
                ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.Ni.setVisibility(0);
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    if (ForumRankActivity.this.geE) {
                        ForumRankActivity.this.Ni.addHeaderView(ForumRankActivity.this.ffP, ForumRankActivity.this.jae, false);
                        ForumRankActivity.this.geE = false;
                    }
                    ForumRankActivity.this.ffP.setVisibility(0);
                    ForumRankActivity.this.ffP.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.ffP.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.af(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.bGz = forumRankData.pic_url;
                }
                ForumRankActivity.this.jab.a(forumRankData.forumsquare_list);
                ForumRankActivity.this.jab.i(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && ForumRankActivity.this.Ni.getAdapter2().oe() <= 0) {
                    ForumRankActivity.this.Ni.addFooterView(ForumRankActivity.this.iZK);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    ForumRankActivity.this.jac.setVisibility(0);
                    return;
                } else {
                    ForumRankActivity.this.jac.setVisibility(8);
                    return;
                }
            }
            ForumRankActivity.this.Ni.setVisibility(8);
            ForumRankActivity.this.showNetRefreshView(ForumRankActivity.this.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            if (forumRankData.error != null) {
                ForumRankActivity.this.showToast(forumRankData.error.usermsg);
            } else {
                ForumRankActivity.this.showToast(R.string.neterror);
            }
        }
    };
    private final u jae = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (ForumRankActivity.this.bGz == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ForumRankActivity.this.bGz);
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
        this.ffP = new TbImageView(getPageContext().getPageActivity());
        this.ffP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Ni = (BdListView) findViewById(R.id.list);
        this.ffP.setLayoutParams(new AbsListView.LayoutParams(l.af(getPageContext().getPageActivity()), (int) (l.af(getPageContext().getPageActivity()) * 0.5d)));
        this.ffP.setVisibility(8);
        this.iZK = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iZK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumRankActivity.this.Ni.removeFooterView(ForumRankActivity.this.iZK);
                ForumRankActivity.this.jab.Ac(100);
            }
        });
        this.mPullView = new i(getPageContext());
        this.Ni.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
        this.Ni.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.square.flist.ForumRankActivity.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (!ForumRankActivity.this.jaa.LoadData()) {
                    ForumRankActivity.this.Ni.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.jac = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jaa.ab(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jaa = new ForumRankModel(bundle);
        } else {
            this.jaa = new ForumRankModel(getIntent());
        }
        this.geE = true;
        this.jaa.setLoadDataCallBack(this.jad);
        this.jab = new b(getPageContext(), 0);
        this.jab.Ac(100);
        this.jab.i(true);
        this.jab.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Ni.setAdapter((ListAdapter) this.jab);
        if (this.jaa.LoadData()) {
            this.jab.Ac(100);
            showProgressBar();
        }
        this.cdr = new LikeModel(getPageContext());
        this.jab.a(this.cdr);
    }

    private void cnN() {
        ForumInfoData[] cnM = this.jab.cnM();
        for (int i = 0; i < cnM.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(cnM[i].forum_name);
            if (hasLikeForum == 1) {
                cnM[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                cnM[i].is_like = 0;
            }
        }
        this.jab.a(cnM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        cnN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1) {
            this.Ni.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.jab.qU(true);
        } else {
            this.Ni.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.jab.qU(false);
        }
        am.h(findViewById(R.id.root_view), i);
        this.mPullView.iV(i);
        this.jab.cw(R.drawable.btn_add_end, R.drawable.btn_add);
        am.k(this.iZK, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.jaa != null) {
            this.jaa.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
