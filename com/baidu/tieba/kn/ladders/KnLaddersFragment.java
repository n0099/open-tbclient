package com.baidu.tieba.kn.ladders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class KnLaddersFragment extends BaseFragment implements q {

    /* renamed from: a  reason: collision with root package name */
    BdListView f1737a;
    private a b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public final void a(Bundle bundle) {
        super.a(bundle);
        this.c = com.baidu.tieba.sharedPref.b.a().a("key_kn_ladders_last_tab", 1);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public final void p() {
        super.p();
        if (this.d && this.e && this.b != null) {
            this.f1737a.b();
            this.e = false;
        }
        if (this.b != null) {
            this.b.notifyDataSetChanged();
            KnLaddersBannerAdapter f = this.b.f();
            if (f != null) {
                f.b();
            }
        }
        this.d = true;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        KnLaddersBannerAdapter f;
        super.d();
        if (this.b != null && (f = this.b.f()) != null) {
            f.a();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1737a = (BdListView) layoutInflater.inflate(R.layout.kn_ladders_fragment, viewGroup, false);
        this.b = new a(this);
        this.f1737a.setAdapter((ListAdapter) this.b);
        bb bbVar = new bb(i());
        this.f1737a.setPullRefresh(bbVar);
        bbVar.a(new m(this));
        return this.f1737a;
    }

    @Override // android.support.v4.app.Fragment
    public final void a(View view, Bundle bundle) {
        this.b.a(new n(this));
        this.f = true;
        KnLaddersModel.fetch(i(), this, this.f);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
    }

    @Override // com.baidu.tieba.kn.ladders.q
    public final void a(KnLaddersModel knLaddersModel) {
        this.f1737a.a();
        if (knLaddersModel != null) {
            if ((this.f && TiebaApplication.g().aT()) || (!this.f && knLaddersModel.mainbar != null && knLaddersModel.mainbar.offline == 1)) {
                y b = ((KnTabActivity) i()).b();
                b.f1763a.setVisibility(8);
                b.b.setVisibility(0);
                b.e.setText(knLaddersModel.mainbar.title);
                if (knLaddersModel.mainbar.link != null && knLaddersModel.mainbar.link.startsWith("webview:")) {
                    b.d.loadUrl(knLaddersModel.mainbar.link.replaceFirst("webview:", com.baidu.loginshare.e.f));
                    return;
                }
                return;
            }
            try {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(this.c);
                    aVar.e().i.setVisibility(4);
                    aVar.e().h.setVisibility(0);
                    if (b(knLaddersModel)) {
                        aVar.a(knLaddersModel.rank_page_info);
                        aVar.a(knLaddersModel.rank_info);
                    } else {
                        aVar.e().i.setVisibility(0);
                        aVar.e().h.setVisibility(4);
                        aVar.e().e.setText(i().getString(R.string.neterror));
                    }
                    this.b.notifyDataSetChanged();
                }
            } catch (NullPointerException e) {
                if (i() != null) {
                    UtilHelper.a((Context) i(), (int) R.string.neterror);
                }
            }
        }
    }

    private boolean b(KnLaddersModel knLaddersModel) {
        return (knLaddersModel.rank_info == null || knLaddersModel.rank_page_info == null || knLaddersModel.rank_info.length <= 0 || knLaddersModel.rank_page_info.pics == null || knLaddersModel.rank_page_info.pics.length <= 0 || knLaddersModel.rank_page_info.names == null || knLaddersModel.rank_page_info.names.length <= 0) ? false : true;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public final void r() {
        com.baidu.tieba.sharedPref.b.a().b("key_kn_ladders_last_tab", this.c);
        KnLaddersModel.cancel();
        super.r();
    }

    public final void a() {
        if (this.d) {
            this.f1737a.b();
        }
    }

    public final void a(boolean z) {
        this.e = z;
    }
}
