package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.d0.h;
import d.b.i0.r.f0.f;
import d.b.j0.m2.g;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, d.b.j0.m2.c {

    /* renamed from: e  reason: collision with root package name */
    public View f20270e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f20271f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f20272g;

    /* renamed from: h  reason: collision with root package name */
    public g f20273h;
    public h k;
    public d.b.i0.r.f0.g l;
    public PbListView m;
    public View n;
    public int p;
    public d.b.j0.m2.d s;
    public boolean i = false;
    public NoDataView j = null;
    public boolean o = false;
    public int q = R.color.CAM_X0201;
    public boolean r = true;
    public View.OnClickListener t = new a();
    public PersonPostModel.c u = new c();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                PersonReplyFragment personReplyFragment = PersonReplyFragment.this;
                h hVar = personReplyFragment.k;
                if (hVar != null) {
                    hVar.dettachView(personReplyFragment.f20270e);
                    PersonReplyFragment.this.k = null;
                }
                if (PersonReplyFragment.this.s != null) {
                    PersonReplyFragment.this.s.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            PersonReplyFragment.this.f20273h.f(true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PersonPostModel.c {
        public c() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void p0(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment personReplyFragment = PersonReplyFragment.this;
                personReplyFragment.hideLoadingView(personReplyFragment.f20270e);
                PersonReplyFragment.this.f20271f.A(0L);
                if (personPostModel == null || (PersonReplyFragment.S0(personPostModel.postList) == 0 && PersonReplyFragment.this.r && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.f20271f.setVisibility(0);
                    PersonReplyFragment.this.Q0(true);
                    return;
                }
                if (PersonReplyFragment.this.f20273h.getCount() == 0) {
                    PersonReplyFragment.this.f20271f.setVisibility(8);
                    PersonReplyFragment.this.Q0(true);
                } else {
                    PersonReplyFragment.this.f20271f.setVisibility(0);
                    PersonReplyFragment.this.Q0(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    l.L(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int S0 = PersonReplyFragment.S0(personPostModel.postList);
                if (S0 <= 0) {
                    if (j.z()) {
                        PersonReplyFragment.this.o = false;
                        PersonReplyFragment.this.m.A(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.n.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.n.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.m.f();
                if (z) {
                    if (S0 <= 0) {
                        PersonReplyFragment.this.o = false;
                    } else {
                        PersonReplyFragment.this.o = true;
                    }
                    PersonReplyFragment.this.p = 0;
                    PersonReplyFragment.this.r = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PersonPostModel.PostInfoList h2;
            if (i >= 0 && PersonReplyFragment.this.f20273h != null && i < PersonReplyFragment.this.f20273h.getCount() && (h2 = PersonReplyFragment.this.f20273h.h(i)) != null) {
                PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(h2.thread_id), String.valueOf(h2.post_id), "person_page", 18005);
                OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
                if (originalThreadInfo != null) {
                    createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
                }
                PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            }
        }
    }

    public static int S0(List<n> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) != null && (list.get(i2) instanceof PersonPostModel.PostInfoList)) {
                i += ((PersonPostModel.PostInfoList) list.get(i2)).content.length;
            }
        }
        return i;
    }

    public final void Q0(boolean z) {
        if (z) {
            if (this.f20271f != null) {
                NoDataView noDataView = this.j;
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
                this.f20271f.removeHeaderView(this.j);
                this.f20271f.addHeaderView(this.j);
            }
        } else if (this.f20271f != null) {
            NoDataView noDataView2 = this.j;
            if (noDataView2 != null) {
                noDataView2.setVisibility(8);
            }
            this.f20271f.removeHeaderView(this.j);
        }
    }

    public final void R0() {
        if (j.A()) {
            this.f20273h.f(true);
            return;
        }
        hideLoadingView(this.f20270e);
        Q0(false);
        d.b.j0.m2.f.b(this.k, this.t, getActivity(), this.f20270e, getString(R.string.neterror), true);
        this.f20271f.setVisibility(8);
    }

    public final void T0() {
        g gVar = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.f20273h = gVar;
        gVar.i(this.u);
        this.f20271f.setAdapter((ListAdapter) this.f20273h);
        this.f20271f.setOnItemClickListener(new d());
    }

    public void U0() {
        if (this.i) {
            return;
        }
        T0();
        this.i = true;
        showLoadingView(this.f20270e);
        R0();
    }

    public void V0(d.b.j0.m2.d dVar) {
        this.s = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            View view = this.n;
            if (view != null) {
                SkinManager.setViewTextColor((TextView) view.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.d(i);
            }
            this.l.I(i);
            SkinManager.setBackgroundColor(this.f20270e, this.q, i);
            g gVar = this.f20273h;
            if (gVar != null) {
                gVar.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.f20270e = inflate;
        this.f20271f = (BdListView) inflate.findViewById(R.id.listview_reply);
        this.f20272g = (NavigationBarShadowView) this.f20270e.findViewById(R.id.navi_shadow_view_my_reply);
        this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.e.d(null, getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT)), null);
        return this.f20270e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.f20273h;
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        U0();
        this.f20273h.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.o && i3 > 2 && this.p != i3 && i2 + i == i3) {
            this.p = i3;
            this.f20273h.f(false);
            this.n.setVisibility(0);
            this.m.O();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.f20272g.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f20272g.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(getPageContext());
        this.l = gVar;
        this.f20271f.setPullRefresh(gVar);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds176)));
        this.f20271f.x(textView, 0);
        this.l.b(new b());
        this.f20271f.setOnScrollListener(this);
        PbListView pbListView = new PbListView(getActivity());
        this.m = pbListView;
        pbListView.o(R.color.common_color_10022);
        this.m.C(SkinManager.getColor(R.color.common_color_10039));
        this.f20271f.setNextPage(this.m);
        View findViewById = this.m.b().findViewById(R.id.pb_more_view);
        this.n = findViewById;
        findViewById.setVisibility(8);
    }

    @Override // d.b.j0.m2.c
    public void u() {
        g gVar = this.f20273h;
        if (gVar != null) {
            gVar.f(true);
        }
    }
}
