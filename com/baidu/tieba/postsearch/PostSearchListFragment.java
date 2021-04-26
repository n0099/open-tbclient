package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.s0.a;
import d.a.j0.n2.b;
import d.a.j0.n2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f20834e;

    /* renamed from: f  reason: collision with root package name */
    public View f20835f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20836g;

    /* renamed from: h  reason: collision with root package name */
    public e f20837h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20838i;
    public NoDataView j;
    public b k;
    public int l;
    public String m;

    public PostSearchListFragment() {
        this.l = -1;
        this.m = "";
    }

    public void E0() {
        List<b.a> list;
        b bVar = this.k;
        if (bVar != null && (list = bVar.f56966a) != null) {
            list.clear();
            this.f20837h.c(this.k.f56966a);
            this.f20837h.notifyDataSetChanged();
        }
        F0();
        G0();
    }

    public final void F0() {
        BdListView bdListView = this.f20836g;
        if (bdListView == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void G0() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void H0() {
        this.f20836g = (BdListView) this.f20835f.findViewById(R.id.result_list);
    }

    public void I0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        G0();
        hideLoadingView(this.f20835f);
        if (bVar == null || (list2 = bVar.f56966a) == null || list2.size() == 0) {
            if (z && (bVar2 = this.k) != null && (list = bVar2.f56966a) != null && list.size() != 0) {
                if (this.k.f56967b.b() == 1) {
                    K0();
                    return;
                } else {
                    M0();
                    return;
                }
            }
            F0();
            L0();
            this.f20836g.setVisibility(8);
            this.k = bVar;
            return;
        }
        if (z && (bVar3 = this.k) != null && (list3 = bVar3.f56966a) != null && list3.size() != 0) {
            b bVar4 = this.k;
            bVar4.f56967b = bVar.f56967b;
            bVar4.f56966a.addAll(bVar.f56966a);
        } else {
            this.k = bVar;
        }
        if (z) {
            O0();
        }
        if (this.k.f56967b.b() == 1) {
            K0();
        } else {
            M0();
        }
        this.f20837h.c(this.k.f56966a);
        this.f20837h.notifyDataSetChanged();
        if (!z) {
            this.f20836g.setSelection(0);
        }
        this.f20836g.setVisibility(0);
    }

    public void J0(boolean z) {
        PostSearchActivity postSearchActivity = this.f20834e;
        if (postSearchActivity == null) {
            return;
        }
        String str = postSearchActivity.mSearchKey;
        if (StringUtils.isNull(str)) {
            return;
        }
        boolean z2 = true;
        boolean z3 = !str.equals(this.m) || z;
        b bVar = this.k;
        if (bVar != null && (bVar == null || bVar.a())) {
            z2 = z3;
        }
        if (z2) {
            showLoadingView(this.f20835f, false, this.f20834e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f20834e.getModel().l(str, this.l);
            this.m = str;
        }
    }

    public final void K0() {
        this.f20836g.setNextPage(this.f20838i);
        this.f20838i.f();
        this.f20838i.A(this.f20834e.getResources().getString(R.string.pb_load_more));
    }

    public final void L0() {
        if (this.j == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f20834e.getPageContext().getPageActivity(), this.f20835f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20834e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
            this.j = a2;
            a2.f(this.f20834e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.j.setVisibility(0);
    }

    public final void M0() {
        this.f20836g.setNextPage(this.f20838i);
        this.f20838i.f();
        this.f20838i.A(this.f20834e.getResources().getString(R.string.list_no_more));
    }

    public final void N0() {
        this.f20836g.setNextPage(this.f20838i);
        this.f20838i.O();
    }

    public final void O0() {
        if (this.f20834e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f20834e.mForumId).param("fname", this.f20834e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20834e = (PostSearchActivity) getBaseFragmentActivity();
        e eVar = new e(this.f20834e.getPageContext());
        this.f20837h = eVar;
        eVar.d(this.l);
        BdListViewHelper.d(this.f20834e.getActivity(), this.f20836g, BdListViewHelper.HeadType.HASTAB);
        this.f20836g.setAdapter((ListAdapter) this.f20837h);
        PbListView pbListView = new PbListView(this.f20834e.getPageContext().getPageActivity());
        this.f20838i = pbListView;
        pbListView.a();
        this.f20836g.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        PostSearchActivity postSearchActivity = this.f20834e;
        if (postSearchActivity != null) {
            a.a(postSearchActivity.getPageContext(), this.f20835f);
        }
        PbListView pbListView = this.f20838i;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        e eVar = this.f20837h;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20835f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        H0();
        return this.f20835f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.l == this.f20834e.getPostSearchView().a()) {
            O0();
            J0(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        if (!StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f20834e.getModel().l(this.m, this.l)) {
            N0();
        }
    }

    public PostSearchListFragment(int i2) {
        this.l = -1;
        this.m = "";
        this.l = i2;
    }
}
