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
import d.a.m0.s0.a;
import d.a.n0.o2.b;
import d.a.n0.o2.e;
import java.util.List;
/* loaded from: classes5.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f20044e;

    /* renamed from: f  reason: collision with root package name */
    public View f20045f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20046g;

    /* renamed from: h  reason: collision with root package name */
    public e f20047h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20048i;
    public NoDataView j;
    public b k;
    public int l;
    public String m;

    public PostSearchListFragment() {
        this.l = -1;
        this.m = "";
    }

    public void D0() {
        List<b.a> list;
        b bVar = this.k;
        if (bVar != null && (list = bVar.f57845a) != null) {
            list.clear();
            this.f20047h.c(this.k.f57845a);
            this.f20047h.notifyDataSetChanged();
        }
        E0();
        F0();
    }

    public final void E0() {
        BdListView bdListView = this.f20046g;
        if (bdListView == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void F0() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void G0() {
        this.f20046g = (BdListView) this.f20045f.findViewById(R.id.result_list);
    }

    public void H0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        F0();
        hideLoadingView(this.f20045f);
        if (bVar == null || (list2 = bVar.f57845a) == null || list2.size() == 0) {
            if (z && (bVar2 = this.k) != null && (list = bVar2.f57845a) != null && list.size() != 0) {
                if (this.k.f57846b.b() == 1) {
                    J0();
                    return;
                } else {
                    L0();
                    return;
                }
            }
            E0();
            K0();
            this.f20046g.setVisibility(8);
            this.k = bVar;
            return;
        }
        if (z && (bVar3 = this.k) != null && (list3 = bVar3.f57845a) != null && list3.size() != 0) {
            b bVar4 = this.k;
            bVar4.f57846b = bVar.f57846b;
            bVar4.f57845a.addAll(bVar.f57845a);
        } else {
            this.k = bVar;
        }
        if (z) {
            N0();
        }
        if (this.k.f57846b.b() == 1) {
            J0();
        } else {
            L0();
        }
        this.f20047h.c(this.k.f57845a);
        this.f20047h.notifyDataSetChanged();
        if (!z) {
            this.f20046g.setSelection(0);
        }
        this.f20046g.setVisibility(0);
    }

    public void I0(boolean z) {
        PostSearchActivity postSearchActivity = this.f20044e;
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
            showLoadingView(this.f20045f, false, this.f20044e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f20044e.getModel().l(str, this.l);
            this.m = str;
        }
    }

    public final void J0() {
        this.f20046g.setNextPage(this.f20048i);
        this.f20048i.f();
        this.f20048i.A(this.f20044e.getResources().getString(R.string.pb_load_more));
    }

    public final void K0() {
        if (this.j == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f20044e.getPageContext().getPageActivity(), this.f20045f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20044e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
            this.j = a2;
            a2.f(this.f20044e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.j.setVisibility(0);
    }

    public final void L0() {
        this.f20046g.setNextPage(this.f20048i);
        this.f20048i.f();
        this.f20048i.A(this.f20044e.getResources().getString(R.string.list_no_more));
    }

    public final void M0() {
        this.f20046g.setNextPage(this.f20048i);
        this.f20048i.O();
    }

    public final void N0() {
        if (this.f20044e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f20044e.mForumId).param("fname", this.f20044e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20044e = (PostSearchActivity) getBaseFragmentActivity();
        e eVar = new e(this.f20044e.getPageContext());
        this.f20047h = eVar;
        eVar.d(this.l);
        BdListViewHelper.d(this.f20044e.getActivity(), this.f20046g, BdListViewHelper.HeadType.HASTAB);
        this.f20046g.setAdapter((ListAdapter) this.f20047h);
        PbListView pbListView = new PbListView(this.f20044e.getPageContext().getPageActivity());
        this.f20048i = pbListView;
        pbListView.a();
        this.f20046g.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        PostSearchActivity postSearchActivity = this.f20044e;
        if (postSearchActivity != null) {
            a.a(postSearchActivity.getPageContext(), this.f20045f);
        }
        PbListView pbListView = this.f20048i;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        e eVar = this.f20047h;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20045f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        G0();
        return this.f20045f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.l == this.f20044e.getPostSearchView().a()) {
            N0();
            I0(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        if (!StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f20044e.getModel().l(this.m, this.l)) {
            M0();
        }
    }

    public PostSearchListFragment(int i2) {
        this.l = -1;
        this.m = "";
        this.l = i2;
    }
}
