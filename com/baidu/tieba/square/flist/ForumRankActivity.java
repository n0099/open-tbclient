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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.ImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.a.c.a.e;
import d.a.c.e.p.l;
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f21475e = null;

    /* renamed from: f  reason: collision with root package name */
    public ForumRankModel f21476f = null;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.a3.h.b f21477g = null;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f21478h = null;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21479i = null;
    public LikeModel j = null;
    public LinearLayout k = null;
    public g l = null;
    public FrameLayout m = null;
    public String n = null;
    public boolean o = false;
    public final e p = new c();
    public final ImageProvider q = new d();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumRankActivity.this.f21475e.removeFooterView(ForumRankActivity.this.k);
            ForumRankActivity.this.f21477g.e(100);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ForumRankActivity.this.f21476f.LoadData()) {
                return;
            }
            ForumRankActivity.this.f21475e.A(0L);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.f21475e.A(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.f21475e.setVisibility(8);
                ForumRankActivity forumRankActivity = ForumRankActivity.this;
                forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.f21475e.setVisibility(0);
                String str = forumRankData.pic_url;
                if (str != null && str.length() > 0) {
                    if (ForumRankActivity.this.o) {
                        ForumRankActivity.this.f21475e.addHeaderView(ForumRankActivity.this.f21479i, ForumRankActivity.this.q, false);
                        ForumRankActivity.this.o = false;
                    }
                    ForumRankActivity.this.f21479i.setVisibility(0);
                    ForumRankActivity.this.f21479i.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.f21479i.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.k(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.n = forumRankData.pic_url;
                }
                ForumRankActivity.this.f21477g.f(forumRankData.forumsquare_list);
                ForumRankActivity.this.f21477g.h(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.f21478h.setTitleText(forumRankData.title);
                ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && ForumRankActivity.this.f21475e.getAdapter2().l() <= 0) {
                    ForumRankActivity.this.f21475e.addFooterView(ForumRankActivity.this.k);
                }
                ForumInfoData[] forumInfoDataArr2 = forumRankData.forumsquare_list;
                if (forumInfoDataArr2 == null || forumInfoDataArr2.length == 0) {
                    ForumRankActivity.this.m.setVisibility(0);
                    return;
                } else {
                    ForumRankActivity.this.m.setVisibility(8);
                    return;
                }
            }
            ForumRankActivity.this.f21475e.setVisibility(8);
            ForumRankActivity forumRankActivity2 = ForumRankActivity.this;
            forumRankActivity2.showNetRefreshView(forumRankActivity2.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
            ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
            NewErrorData newErrorData = forumRankData.error;
            if (newErrorData != null) {
                ForumRankActivity.this.showToast(newErrorData.usermsg);
            } else {
                ForumRankActivity.this.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends AbstractImageProvider {
        public d() {
        }

        @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
        public ArrayList<String> getImageUrl() {
            if (ForumRankActivity.this.n != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(ForumRankActivity.this.n);
                return arrayList;
            }
            return null;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        this.f21478h.onChangeSkinType(getPageContext(), i2);
        if (i2 != 1 && i2 != 4) {
            this.f21475e.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.f21477g.d(false);
        } else {
            this.f21475e.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.f21477g.d(true);
        }
        SkinManager.setFrsPBBgColor(findViewById(R.id.root_view), i2);
        this.l.I(i2);
        this.f21477g.i(R.drawable.btn_add_end, R.drawable.btn_add);
        SkinManager.setBackgroundResource(this.k, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u();
        t(bundle);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onNetRefreshButtonClicked() {
        ForumRankModel forumRankModel = this.f21476f;
        if (forumRankModel != null) {
            forumRankModel.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        v();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f21476f.z(bundle);
    }

    public final void t(Bundle bundle) {
        if (bundle != null) {
            this.f21476f = new ForumRankModel(bundle);
        } else {
            this.f21476f = new ForumRankModel(getIntent());
        }
        this.o = true;
        this.f21476f.setLoadDataCallBack(this.p);
        d.a.j0.a3.h.b bVar = new d.a.j0.a3.h.b(getPageContext(), 0);
        this.f21477g = bVar;
        bVar.e(100);
        this.f21477g.h(Boolean.TRUE);
        this.f21477g.g(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.f21475e.setAdapter((ListAdapter) this.f21477g);
        if (this.f21476f.LoadData()) {
            this.f21477g.e(100);
            showProgressBar();
        }
        LikeModel likeModel = new LikeModel(getPageContext());
        this.j = likeModel;
        this.f21477g.j(likeModel);
    }

    public final void u() {
        setContentView(R.layout.forum_rank_activity);
        TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
        this.f21479i = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f21478h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21478h.setTitleText("");
        this.f21475e = (BdListView) findViewById(R.id.list);
        this.f21479i.setLayoutParams(new AbsListView.LayoutParams(l.k(getPageContext().getPageActivity()), (int) (l.k(getPageContext().getPageActivity()) * 0.5d)));
        this.f21479i.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.k = linearLayout;
        linearLayout.setOnClickListener(new a());
        g gVar = new g(getPageContext());
        this.l = gVar;
        this.f21475e.setPullRefresh(gVar);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
        this.f21475e.x(textView, 0);
        this.l.a(new b());
        this.m = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    public final void v() {
        ForumInfoData[] a2 = this.f21477g.a();
        for (int i2 = 0; i2 < a2.length; i2++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(a2[i2].forum_name);
            if (hasLikeForum == 1) {
                a2[i2].is_like = 1;
            } else if (hasLikeForum == -1) {
                a2[i2].is_like = 0;
            }
        }
        this.f21477g.f(a2);
    }
}
