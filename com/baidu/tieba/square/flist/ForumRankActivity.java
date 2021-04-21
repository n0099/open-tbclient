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
import d.b.c.a.e;
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f20907e = null;

    /* renamed from: f  reason: collision with root package name */
    public ForumRankModel f20908f = null;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.a3.h.b f20909g = null;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f20910h = null;
    public TbImageView i = null;
    public LikeModel j = null;
    public LinearLayout k = null;
    public g l = null;
    public FrameLayout m = null;
    public String n = null;
    public boolean o = false;
    public final e p = new c();
    public final ImageProvider q = new d();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumRankActivity.this.f20907e.removeFooterView(ForumRankActivity.this.k);
            ForumRankActivity.this.f20909g.e(100);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ForumRankActivity.this.f20908f.LoadData()) {
                return;
            }
            ForumRankActivity.this.f20907e.A(0L);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            ForumRankActivity.this.hideProgressBar();
            ForumRankActivity.this.f20907e.A(0L);
            if (obj == null || !(obj instanceof ForumRankData)) {
                ForumRankActivity.this.f20907e.setVisibility(8);
                ForumRankActivity forumRankActivity = ForumRankActivity.this;
                forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.root_view), ForumRankActivity.this.getResources().getString(R.string.recommend_pb_no_net_text), true);
                ForumRankActivity.this.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                ForumRankActivity.this.showToast(R.string.neterror);
                return;
            }
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                ForumRankActivity.this.f20907e.setVisibility(0);
                String str = forumRankData.pic_url;
                if (str != null && str.length() > 0) {
                    if (ForumRankActivity.this.o) {
                        ForumRankActivity.this.f20907e.addHeaderView(ForumRankActivity.this.i, ForumRankActivity.this.q, false);
                        ForumRankActivity.this.o = false;
                    }
                    ForumRankActivity.this.i.setVisibility(0);
                    ForumRankActivity.this.i.setTag(forumRankData.pic_url);
                    ViewGroup.LayoutParams layoutParams = ForumRankActivity.this.i.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((l.k(ForumRankActivity.this.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                    ForumRankActivity.this.n = forumRankData.pic_url;
                }
                ForumRankActivity.this.f20909g.f(forumRankData.forumsquare_list);
                ForumRankActivity.this.f20909g.h(Boolean.valueOf(forumRankData.is_order != 0));
                ForumRankActivity.this.f20910h.setTitleText(forumRankData.title);
                ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && ForumRankActivity.this.f20907e.getAdapter2().l() <= 0) {
                    ForumRankActivity.this.f20907e.addFooterView(ForumRankActivity.this.k);
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
            ForumRankActivity.this.f20907e.setVisibility(8);
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

    /* loaded from: classes4.dex */
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
    public void onChangeSkinType(int i) {
        this.f20910h.onChangeSkinType(getPageContext(), i);
        if (i != 1 && i != 4) {
            this.f20907e.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
            this.f20909g.d(false);
        } else {
            this.f20907e.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
            this.f20909g.d(true);
        }
        SkinManager.setFrsPBBgColor(findViewById(R.id.root_view), i);
        this.l.I(i);
        this.f20909g.i(R.drawable.btn_add_end, R.drawable.btn_add);
        SkinManager.setBackgroundResource(this.k, R.drawable.bg_black_banner_down);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v();
        u(bundle);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onNetRefreshButtonClicked() {
        ForumRankModel forumRankModel = this.f20908f;
        if (forumRankModel != null) {
            forumRankModel.LoadData();
            hideNetRefreshView(findViewById(R.id.root_view));
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        w();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f20908f.z(bundle);
    }

    public final void u(Bundle bundle) {
        if (bundle != null) {
            this.f20908f = new ForumRankModel(bundle);
        } else {
            this.f20908f = new ForumRankModel(getIntent());
        }
        this.o = true;
        this.f20908f.setLoadDataCallBack(this.p);
        d.b.j0.a3.h.b bVar = new d.b.j0.a3.h.b(getPageContext(), 0);
        this.f20909g = bVar;
        bVar.e(100);
        this.f20909g.h(Boolean.TRUE);
        this.f20909g.g(ForumDetailActivityConfig.FromType.BAR_RANK);
        this.f20907e.setAdapter((ListAdapter) this.f20909g);
        if (this.f20908f.LoadData()) {
            this.f20909g.e(100);
            showProgressBar();
        }
        LikeModel likeModel = new LikeModel(getPageContext());
        this.j = likeModel;
        this.f20909g.j(likeModel);
    }

    public final void v() {
        setContentView(R.layout.forum_rank_activity);
        TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
        this.i = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f20910h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f20910h.setTitleText("");
        this.f20907e = (BdListView) findViewById(R.id.list);
        this.i.setLayoutParams(new AbsListView.LayoutParams(l.k(getPageContext().getPageActivity()), (int) (l.k(getPageContext().getPageActivity()) * 0.5d)));
        this.i.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.k = linearLayout;
        linearLayout.setOnClickListener(new a());
        g gVar = new g(getPageContext());
        this.l = gVar;
        this.f20907e.setPullRefresh(gVar);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
        this.f20907e.x(textView, 0);
        this.l.b(new b());
        this.m = (FrameLayout) findViewById(R.id.empty_textview_container);
    }

    public final void w() {
        ForumInfoData[] a2 = this.f20909g.a();
        for (int i = 0; i < a2.length; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(a2[i].forum_name);
            if (hasLikeForum == 1) {
                a2[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                a2[i].is_like = 0;
            }
        }
        this.f20909g.f(a2);
    }
}
