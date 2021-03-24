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
import d.b.b.e.p.l;
import d.b.h0.s0.a;
import d.b.i0.m2.b;
import d.b.i0.m2.e;
import java.util.List;
/* loaded from: classes5.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f20598e;

    /* renamed from: f  reason: collision with root package name */
    public View f20599f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20600g;

    /* renamed from: h  reason: collision with root package name */
    public e f20601h;
    public PbListView i;
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
        if (bVar != null && (list = bVar.f56889a) != null) {
            list.clear();
            this.f20601h.c(this.k.f56889a);
            this.f20601h.notifyDataSetChanged();
        }
        F0();
        G0();
    }

    public final void F0() {
        BdListView bdListView = this.f20600g;
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
        this.f20600g = (BdListView) this.f20599f.findViewById(R.id.result_list);
    }

    public void I0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        G0();
        hideLoadingView(this.f20599f);
        if (bVar == null || (list2 = bVar.f56889a) == null || list2.size() == 0) {
            if (z && (bVar2 = this.k) != null && (list = bVar2.f56889a) != null && list.size() != 0) {
                if (this.k.f56890b.b() == 1) {
                    K0();
                    return;
                } else {
                    M0();
                    return;
                }
            }
            F0();
            L0();
            this.f20600g.setVisibility(8);
            this.k = bVar;
            return;
        }
        if (z && (bVar3 = this.k) != null && (list3 = bVar3.f56889a) != null && list3.size() != 0) {
            b bVar4 = this.k;
            bVar4.f56890b = bVar.f56890b;
            bVar4.f56889a.addAll(bVar.f56889a);
        } else {
            this.k = bVar;
        }
        if (z) {
            O0();
        }
        if (this.k.f56890b.b() == 1) {
            K0();
        } else {
            M0();
        }
        this.f20601h.c(this.k.f56889a);
        this.f20601h.notifyDataSetChanged();
        if (!z) {
            this.f20600g.setSelection(0);
        }
        this.f20600g.setVisibility(0);
    }

    public void J0(boolean z) {
        PostSearchActivity postSearchActivity = this.f20598e;
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
            showLoadingView(this.f20599f, false, this.f20598e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f20598e.getModel().l(str, this.l);
            this.m = str;
        }
    }

    public final void K0() {
        this.f20600g.setNextPage(this.i);
        this.i.f();
        this.i.A(this.f20598e.getResources().getString(R.string.pb_load_more));
    }

    public final void L0() {
        if (this.j == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f20598e.getPageContext().getPageActivity(), this.f20599f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20598e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
            this.j = a2;
            a2.f(this.f20598e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.j.setVisibility(0);
    }

    public final void M0() {
        this.f20600g.setNextPage(this.i);
        this.i.f();
        this.i.A(this.f20598e.getResources().getString(R.string.list_no_more));
    }

    public final void N0() {
        this.f20600g.setNextPage(this.i);
        this.i.O();
    }

    public final void O0() {
        if (this.f20598e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f20598e.mForumId).param("fname", this.f20598e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20598e = (PostSearchActivity) getBaseFragmentActivity();
        e eVar = new e(this.f20598e.getPageContext());
        this.f20601h = eVar;
        eVar.d(this.l);
        BdListViewHelper.d(this.f20598e.getActivity(), this.f20600g, BdListViewHelper.HeadType.HASTAB);
        this.f20600g.setAdapter((ListAdapter) this.f20601h);
        PbListView pbListView = new PbListView(this.f20598e.getPageContext().getPageActivity());
        this.i = pbListView;
        pbListView.a();
        this.f20600g.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        PostSearchActivity postSearchActivity = this.f20598e;
        if (postSearchActivity != null) {
            a.a(postSearchActivity.getPageContext(), this.f20599f);
        }
        PbListView pbListView = this.i;
        if (pbListView != null) {
            pbListView.d(i);
        }
        e eVar = this.f20601h;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20599f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        H0();
        return this.f20599f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.l == this.f20598e.getPostSearchView().a()) {
            O0();
            J0(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        if (!StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f20598e.getModel().l(this.m, this.l)) {
            N0();
        }
    }

    public PostSearchListFragment(int i) {
        this.l = -1;
        this.m = "";
        this.l = i;
    }
}
