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
    private ForumRankModel lZW = null;
    private b lZX = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView hBn = null;
    private LikeModel exb = null;
    private LinearLayout lZG = null;
    private g mPullView = null;
    private FrameLayout lZY = null;
    private String bLJ = null;
    private boolean iIo = false;
    private final com.baidu.adp.base.d lZZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.d.3
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
                    if (d.this.iIo) {
                        d.this.Vo.addHeaderView(d.this.hBn, d.this.maa, false);
                        d.this.iIo = false;
                    }
                    d.this.hBn.setVisibility(0);
                    d.this.hBn.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = d.this.hBn.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.getEquipmentWidth(d.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    d.this.bLJ = forumRankData.pic_url;
                }
                d.this.lZX.a(forumRankData.forumsquare_list);
                d.this.lZX.q(Boolean.valueOf(forumRankData.is_order != 0));
                d.this.mNavigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100 && d.this.Vo.getAdapter2().getFootersCount() <= 0) {
                    d.this.Vo.addFooterView(d.this.lZG);
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    d.this.lZY.setVisibility(0);
                    return;
                } else {
                    d.this.lZY.setVisibility(8);
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
    private final w maa = new AbstractImageProvider() { // from class: com.baidu.tieba.square.flist.d.4
        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            if (d.this.bLJ == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(d.this.bLJ);
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
        this.hBn = new TbImageView(getPageContext().getPageActivity());
        this.hBn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.Vo = (BdListView) findViewById(R.id.list);
        this.hBn.setLayoutParams(new AbsListView.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), (int) (l.getEquipmentWidth(getPageContext().getPageActivity()) * 0.5d)));
        this.hBn.setVisibility(8);
        this.lZG = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Vo.removeFooterView(d.this.lZG);
                d.this.lZX.GM(100);
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
                if (!d.this.lZW.LoadData()) {
                    d.this.Vo.completePullRefreshPostDelayed(0L);
                }
            }
        });
        this.lZY = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lZW.aC(bundle);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lZW = new ForumRankModel(bundle);
        } else {
            this.lZW = new ForumRankModel(getIntent());
        }
        this.iIo = true;
        this.lZW.setLoadDataCallBack(this.lZZ);
        this.lZX = new b(getPageContext(), 0);
        this.lZX.GM(100);
        this.lZX.q(true);
        this.lZX.a(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.Vo.setAdapter((ListAdapter) this.lZX);
        if (this.lZW.LoadData()) {
            this.lZX.GM(100);
            showProgressBar();
        }
        this.exb = new LikeModel(getPageContext());
        this.lZX.a(this.exb);
    }

    private void dvj() {
        ForumInfoData[] dvi = this.lZX.dvi();
        for (int i = 0; i < dvi.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(dvi[i].forum_name);
            if (hasLikeForum == 1) {
                dvi[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                dvi[i].is_like = 0;
            }
        }
        this.lZX.a(dvi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        dvj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (i == 1 || i == 4) {
            this.Vo.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.lZX.vV(true);
        } else {
            this.Vo.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.lZX.vV(false);
        }
        ap.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.mPullView.changeSkin(i);
        this.lZX.dj(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.lZG, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.lZW != null) {
            this.lZW.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }
}
