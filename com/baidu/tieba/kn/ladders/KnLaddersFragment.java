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
import com.baidu.tieba.util.am;
import com.baidu.tieba.view.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class KnLaddersFragment extends BaseFragment implements q {

    /* renamed from: a  reason: collision with root package name */
    BdListView f1176a;
    private a b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;

    @Override // android.support.v4.app.Fragment
    public final void a(Bundle bundle) {
        super.a(bundle);
        this.c = TiebaApplication.f().getSharedPreferences("settings", 0).getInt("key_kn_ladders_last_tab", 1);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public final void n() {
        super.n();
        if (this.d && this.e && this.b != null) {
            this.f1176a.b();
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

    @Override // android.support.v4.app.Fragment
    public void d() {
        KnLaddersBannerAdapter f;
        super.d();
        if (this.b != null && (f = this.b.f()) != null) {
            f.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1176a = (BdListView) layoutInflater.inflate(R.layout.kn_ladders_fragment, viewGroup, false);
        this.b = new a(this);
        this.f1176a.setAdapter((ListAdapter) this.b);
        bb bbVar = new bb(g());
        this.f1176a.setPullRefresh(bbVar);
        bbVar.a(new m(this));
        return this.f1176a;
    }

    @Override // android.support.v4.app.Fragment
    public final void a(View view, Bundle bundle) {
        this.b.a(new n(this));
        this.f = true;
        KnLaddersModel.fetch(g(), this, this.f);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void a(int i) {
    }

    @Override // com.baidu.tieba.kn.ladders.q
    public final void a(KnLaddersModel knLaddersModel) {
        this.f1176a.a();
        if (knLaddersModel != null) {
            if ((this.f && TiebaApplication.f().bd()) || (!this.f && knLaddersModel.mainbar != null && knLaddersModel.mainbar.offline == 1)) {
                x a2 = ((KnTabActivity) g()).a();
                a2.f1201a.setVisibility(8);
                a2.b.setVisibility(0);
                a2.e.setText(knLaddersModel.mainbar.title);
                if (knLaddersModel.mainbar.link != null && knLaddersModel.mainbar.link.startsWith("webview:")) {
                    a2.d.loadUrl(knLaddersModel.mainbar.link.replaceFirst("webview:", com.baidu.loginshare.e.f));
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
                        aVar.e().e.setText(g().getString(R.string.neterror));
                    }
                    this.b.notifyDataSetChanged();
                }
            } catch (NullPointerException e) {
                if (g() != null) {
                    am.a((Context) g(), (int) R.string.neterror);
                }
            }
        }
    }

    private boolean b(KnLaddersModel knLaddersModel) {
        return (knLaddersModel.rank_info == null || knLaddersModel.rank_page_info == null || knLaddersModel.rank_info.length <= 0 || knLaddersModel.rank_page_info.pics == null || knLaddersModel.rank_page_info.pics.length <= 0 || knLaddersModel.rank_page_info.names == null || knLaddersModel.rank_page_info.names.length <= 0) ? false : true;
    }

    @Override // android.support.v4.app.Fragment
    public final void p() {
        TiebaApplication.f().getSharedPreferences("settings", 0).edit().putInt("key_kn_ladders_last_tab", this.c).commit();
        KnLaddersModel.cancel();
        super.p();
    }

    public final void a() {
        if (this.d) {
            this.f1176a.b();
        }
    }

    public final void a(boolean z) {
        this.e = z;
    }
}
