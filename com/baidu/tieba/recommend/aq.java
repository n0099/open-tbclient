package com.baidu.tieba.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.data.bl;
import com.baidu.tieba.util.NetWorkCore;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.a.d {
    private BdListView b;
    private ProgressBar c;
    private BaseFragmentActivity d;
    private ae e;
    private com.baidu.tieba.view.bb f;
    private View g;
    private com.baidu.tieba.view.ai h;
    private com.baidu.tieba.view.ba i;
    private View j;
    private View.OnClickListener k;

    public aq(Context context, View.OnClickListener onClickListener) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        if (!(context instanceof BaseFragmentActivity)) {
            throw new IllegalArgumentException();
        }
        this.k = onClickListener;
        this.d = (BaseFragmentActivity) context;
        l();
    }

    public void b() {
        this.c.setVisibility(0);
    }

    public void a(com.baidu.tieba.data.ac acVar) {
        this.e.a(acVar);
        this.e.notifyDataSetChanged();
        if (this.e.getCount() > 0) {
            this.j.setVisibility(0);
        }
    }

    public void c() {
        this.c.setVisibility(8);
        this.i.d();
        this.b.a();
    }

    public void a(com.baidu.tieba.data.ae aeVar) {
        if (aeVar != null) {
            this.h.setInterests(aeVar.a());
            if (aeVar.a() != null && aeVar.a().size() > 0) {
                this.h.setInitSelectTagName(((bl) aeVar.a().get(0)).b());
            }
        }
    }

    public void a(String str) {
        if (this.h != null) {
            this.h.setInitSelectTagName(str);
        }
    }

    private void l() {
        this.g = LayoutInflater.from(this.d).inflate(R.layout.discovery_activity, (ViewGroup) null);
        this.e = new ae(this.d, this.k);
        this.b = (BdListView) this.g.findViewById(R.id.discovery_list);
        this.c = (ProgressBar) this.g.findViewById(R.id.progress);
        this.b.setAdapter((ListAdapter) this.e);
        this.f = new com.baidu.tieba.view.bb(this.d);
        this.b.setPullRefresh(this.f);
        this.h = new com.baidu.tieba.view.ai(this.d);
        this.h.setPadding(0, this.b.getDividerHeight(), 0, 0);
        this.b.addHeaderView(this.h);
        this.h.getAddButton().setOnClickListener(this.k);
        this.i = new com.baidu.tieba.view.ba(this.d);
        this.b.setNextPage(this.i);
        this.j = this.i.b().findViewById(R.id.pb_more_view);
        this.i.b().setPadding(0, 0, 0, 0);
        this.j.setVisibility(8);
        this.j.setOnClickListener(this.k);
    }

    public void a(int i) {
        com.baidu.tieba.util.ah.b(this.g, i);
        this.e.notifyDataSetChanged();
        this.f.a(i);
        this.h.a(i);
        if (i == 1) {
            com.baidu.tieba.util.ah.h(this.j, (int) R.drawable.bg_list_all_1);
        } else {
            com.baidu.tieba.util.ah.h(this.j, (int) R.drawable.bg_list_all);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public com.baidu.tieba.data.af b(int i) {
        return (com.baidu.tieba.data.af) this.e.getItem(i);
    }

    public View d() {
        return this.j;
    }

    public View e() {
        return this.h.getAddButton();
    }

    public ae f() {
        return this.e;
    }

    public void g() {
        this.i.c();
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.b.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.b.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.f.a(bVar);
    }

    public View h() {
        return this.g;
    }

    public int i() {
        return R.id.discovery_bar;
    }

    public void j() {
        com.baidu.tieba.util.a a2 = this.e.a();
        a2.a();
        a2.b();
    }

    public void k() {
        com.baidu.tieba.util.a a2 = this.e.a();
        int firstVisiblePosition = this.b.getFirstVisiblePosition();
        int lastVisiblePosition = this.b.getLastVisiblePosition();
        int i = firstVisiblePosition < 2 ? firstVisiblePosition : 2;
        int i2 = lastVisiblePosition - i;
        a2.a();
        NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this.d);
        boolean z = c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG;
        int i3 = 0;
        for (int i4 = firstVisiblePosition - i; i4 < this.e.getCount(); i4++) {
            if (z || i4 <= i2) {
                com.baidu.tieba.data.af afVar = (com.baidu.tieba.data.af) this.e.getItem(i4);
                if (afVar != null) {
                    ArrayList a3 = afVar.a();
                    int size = a3.size();
                    if (i3 < 13) {
                        for (int i5 = 0; i5 < size && i3 < 13; i5++) {
                            i3++;
                            a2.a(((com.baidu.tieba.data.ad) a3.get(i5)).b(), new ar(this));
                        }
                    }
                    if (z && i3 >= 13) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public void a(com.baidu.tieba.view.ao aoVar) {
        this.h.setSelectInterestItemClickListener(aoVar);
    }
}
