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
import d.a.n0.s0.a;
import d.a.o0.o2.b;
import d.a.o0.o2.e;
import java.util.List;
/* loaded from: classes5.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.p {

    /* renamed from: e  reason: collision with root package name */
    public PostSearchActivity f20203e;

    /* renamed from: f  reason: collision with root package name */
    public View f20204f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20205g;

    /* renamed from: h  reason: collision with root package name */
    public e f20206h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20207i;
    public NoDataView j;
    public b k;
    public int l;
    public String m;

    public PostSearchListFragment() {
        this.l = -1;
        this.m = "";
    }

    public void G0() {
        List<b.a> list;
        b bVar = this.k;
        if (bVar != null && (list = bVar.f61659a) != null) {
            list.clear();
            this.f20206h.c(this.k.f61659a);
            this.f20206h.notifyDataSetChanged();
        }
        H0();
        I0();
    }

    public final void H0() {
        BdListView bdListView = this.f20205g;
        if (bdListView == null) {
            return;
        }
        bdListView.setNextPage(null);
    }

    public final void I0() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void J0() {
        this.f20205g = (BdListView) this.f20204f.findViewById(R.id.result_list);
    }

    public void K0(b bVar, boolean z) {
        b bVar2;
        List<b.a> list;
        List<b.a> list2;
        b bVar3;
        List<b.a> list3;
        I0();
        hideLoadingView(this.f20204f);
        if (bVar == null || (list2 = bVar.f61659a) == null || list2.size() == 0) {
            if (z && (bVar2 = this.k) != null && (list = bVar2.f61659a) != null && list.size() != 0) {
                if (this.k.f61660b.b() == 1) {
                    M0();
                    return;
                } else {
                    O0();
                    return;
                }
            }
            H0();
            N0();
            this.f20205g.setVisibility(8);
            this.k = bVar;
            return;
        }
        if (z && (bVar3 = this.k) != null && (list3 = bVar3.f61659a) != null && list3.size() != 0) {
            b bVar4 = this.k;
            bVar4.f61660b = bVar.f61660b;
            bVar4.f61659a.addAll(bVar.f61659a);
        } else {
            this.k = bVar;
        }
        if (z) {
            Q0();
        }
        if (this.k.f61660b.b() == 1) {
            M0();
        } else {
            O0();
        }
        this.f20206h.c(this.k.f61659a);
        this.f20206h.notifyDataSetChanged();
        this.f20206h.e(this.f20203e.mSearchKey);
        this.f20206h.d(this.f20203e.mForumId);
        if (!z) {
            this.f20205g.setSelection(0);
        }
        this.f20205g.setVisibility(0);
    }

    public void L0(boolean z) {
        PostSearchActivity postSearchActivity = this.f20203e;
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
            showLoadingView(this.f20204f, false, this.f20203e.getResources().getDimensionPixelSize(R.dimen.ds320));
            this.f20203e.getModel().l(str, this.l);
            this.m = str;
        }
    }

    public final void M0() {
        this.f20205g.setNextPage(this.f20207i);
        this.f20207i.f();
        this.f20207i.A(this.f20203e.getResources().getString(R.string.pb_load_more));
    }

    public final void N0() {
        if (this.j == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f20203e.getPageContext().getPageActivity(), this.f20204f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20203e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_result), null);
            this.j = a2;
            a2.f(this.f20203e.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.j.setVisibility(0);
    }

    public final void O0() {
        this.f20205g.setNextPage(this.f20207i);
        this.f20207i.f();
        this.f20207i.A(this.f20203e.getResources().getString(R.string.list_no_more));
    }

    public final void P0() {
        this.f20205g.setNextPage(this.f20207i);
        this.f20207i.O();
    }

    public final void Q0() {
        if (this.f20203e == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12406").param("fid", this.f20203e.mForumId).param("fname", this.f20203e.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tab_id", this.l));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20203e = (PostSearchActivity) getBaseFragmentActivity();
        e eVar = new e(this.f20203e.getPageContext());
        this.f20206h = eVar;
        eVar.f(this.l);
        BdListViewHelper.d(this.f20203e.getActivity(), this.f20205g, BdListViewHelper.HeadType.HASTAB);
        this.f20205g.setAdapter((ListAdapter) this.f20206h);
        PbListView pbListView = new PbListView(this.f20203e.getPageContext().getPageActivity());
        this.f20207i = pbListView;
        pbListView.a();
        this.f20205g.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        PostSearchActivity postSearchActivity = this.f20203e;
        if (postSearchActivity != null) {
            a.a(postSearchActivity.getPageContext(), this.f20204f);
        }
        PbListView pbListView = this.f20207i;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        e eVar = this.f20206h;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20204f = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        J0();
        return this.f20204f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.l == this.f20203e.getPostSearchView().a()) {
            Q0();
            L0(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b bVar;
        if (!StringUtils.isNull(this.m) && (bVar = this.k) != null && bVar.b() && this.f20203e.getModel().l(this.m, this.l)) {
            P0();
        }
    }

    public PostSearchListFragment(int i2) {
        this.l = -1;
        this.m = "";
        this.l = i2;
    }
}
