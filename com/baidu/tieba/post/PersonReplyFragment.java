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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.n0.n2.g;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a.n0.n2.c {

    /* renamed from: e  reason: collision with root package name */
    public View f20089e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f20090f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f20091g;

    /* renamed from: h  reason: collision with root package name */
    public g f20092h;
    public h k;
    public d.a.m0.r.f0.g l;
    public PbListView m;
    public View n;
    public int p;
    public d.a.n0.n2.d s;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20093i = false;
    public NoDataView j = null;
    public boolean o = false;
    public int q = R.color.CAM_X0201;
    public boolean r = true;
    public View.OnClickListener t = new a();
    public PersonPostModel.c u = new c();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                PersonReplyFragment personReplyFragment = PersonReplyFragment.this;
                h hVar = personReplyFragment.k;
                if (hVar != null) {
                    hVar.dettachView(personReplyFragment.f20089e);
                    PersonReplyFragment.this.k = null;
                }
                if (PersonReplyFragment.this.s != null) {
                    PersonReplyFragment.this.s.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            PersonReplyFragment.this.f20092h.f(true);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PersonPostModel.c {
        public c() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void M(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment personReplyFragment = PersonReplyFragment.this;
                personReplyFragment.hideLoadingView(personReplyFragment.f20089e);
                PersonReplyFragment.this.f20090f.A(0L);
                if (personPostModel == null || (PersonReplyFragment.U0(personPostModel.postList) == 0 && PersonReplyFragment.this.r && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.f20090f.setVisibility(0);
                    PersonReplyFragment.this.S0(true);
                    return;
                }
                if (PersonReplyFragment.this.f20092h.getCount() == 0) {
                    PersonReplyFragment.this.f20090f.setVisibility(8);
                    PersonReplyFragment.this.S0(true);
                } else {
                    PersonReplyFragment.this.f20090f.setVisibility(0);
                    PersonReplyFragment.this.S0(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    l.M(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int U0 = PersonReplyFragment.U0(personPostModel.postList);
                if (U0 <= 0) {
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
                    if (U0 <= 0) {
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

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            PersonPostModel.PostInfoList h2;
            if (i2 >= 0 && PersonReplyFragment.this.f20092h != null && i2 < PersonReplyFragment.this.f20092h.getCount() && (h2 = PersonReplyFragment.this.f20092h.h(i2)) != null) {
                PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(h2.thread_id), String.valueOf(h2.post_id), "person_page", 18005);
                OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
                if (originalThreadInfo != null) {
                    createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
                }
                PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            }
        }
    }

    public static int U0(List<n> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) != null && (list.get(i3) instanceof PersonPostModel.PostInfoList)) {
                i2 += ((PersonPostModel.PostInfoList) list.get(i3)).content.length;
            }
        }
        return i2;
    }

    public final void S0(boolean z) {
        if (z) {
            if (this.f20090f != null) {
                NoDataView noDataView = this.j;
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
                this.f20090f.removeHeaderView(this.j);
                this.f20090f.addHeaderView(this.j);
            }
        } else if (this.f20090f != null) {
            NoDataView noDataView2 = this.j;
            if (noDataView2 != null) {
                noDataView2.setVisibility(8);
            }
            this.f20090f.removeHeaderView(this.j);
        }
    }

    public final void T0() {
        if (j.A()) {
            this.f20092h.f(true);
            return;
        }
        hideLoadingView(this.f20089e);
        S0(false);
        d.a.n0.n2.f.b(this.k, this.t, getActivity(), this.f20089e, getString(R.string.neterror), true);
        this.f20090f.setVisibility(8);
    }

    public final void V0() {
        g gVar = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.f20092h = gVar;
        gVar.i(this.u);
        this.f20090f.setAdapter((ListAdapter) this.f20092h);
        this.f20090f.setOnItemClickListener(new d());
    }

    public void W0() {
        if (this.f20093i) {
            return;
        }
        V0();
        this.f20093i = true;
        showLoadingView(this.f20089e);
        T0();
    }

    public void X0(d.a.n0.n2.d dVar) {
        this.s = dVar;
    }

    @Override // d.a.n0.n2.c
    public void b0() {
        g gVar = this.f20092h;
        if (gVar != null) {
            gVar.f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
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
                pbListView.d(i2);
            }
            this.l.I(i2);
            SkinManager.setBackgroundColor(this.f20089e, this.q, i2);
            g gVar = this.f20092h;
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
        this.f20089e = inflate;
        this.f20090f = (BdListView) inflate.findViewById(R.id.listview_reply);
        this.f20091g = (NavigationBarShadowView) this.f20089e.findViewById(R.id.navi_shadow_view_my_reply);
        this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.e.d(null, getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT)), null);
        return this.f20089e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.f20092h;
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        W0();
        this.f20092h.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        if (this.o && i4 > 2 && this.p != i4 && i3 + i2 == i4) {
            this.p = i4;
            this.f20092h.f(false);
            this.n.setVisibility(0);
            this.m.O();
        }
        if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.f20091g.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 1) {
            this.f20091g.c();
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
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(getPageContext());
        this.l = gVar;
        this.f20090f.setPullRefresh(gVar);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds176)));
        this.f20090f.x(textView, 0);
        this.l.a(new b());
        this.f20090f.setOnScrollListener(this);
        PbListView pbListView = new PbListView(getActivity());
        this.m = pbListView;
        pbListView.o(R.color.common_color_10022);
        this.m.C(SkinManager.getColor(R.color.common_color_10039));
        this.f20090f.setNextPage(this.m);
        View findViewById = this.m.b().findViewById(R.id.pb_more_view);
        this.n = findViewById;
        findViewById.setVisibility(8);
    }
}
