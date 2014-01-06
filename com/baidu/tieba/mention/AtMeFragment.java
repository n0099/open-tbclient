package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.aq;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.view.bw;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AtMeFragment extends BaseFragment implements com.baidu.adp.widget.ListView.b {
    private bw c;
    private LinearLayout d;
    private com.baidu.tieba.home.o e;
    private aq f;
    private int g;
    private j a = null;
    private BdListView b = null;
    private boolean h = false;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = -1;
        View inflate = layoutInflater.inflate(R.layout.at_me_activity, viewGroup, false);
        this.c = new bw(i());
        this.c.a(this);
        this.b = (BdListView) inflate.findViewById(R.id.atme_lv);
        this.b.setPullRefresh(this.c);
        this.d = (LinearLayout) inflate.findViewById(R.id.bodyNotLogin);
        this.f = new aq(inflate, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.a = new j(this, 2, new a(this));
        this.a.a(this.b);
        this.a.a(this.f);
        this.a.a("c/u/feed/atme");
        this.a.c();
        return inflate;
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (this.g != i) {
            this.g = i;
            if (n()) {
                if (i == 1) {
                    this.b.setCacheColorHint(j().getColor(17170445));
                    if (this.f.c()) {
                        this.b.setDivider(j().getDrawable(17170445));
                    } else {
                        this.b.setDivider(new ColorDrawable(j().getColor(R.color.night_divider)));
                    }
                    this.b.setDividerHeight(com.baidu.adp.lib.h.g.a((Context) i(), 1.0f));
                } else {
                    this.b.setCacheColorHint(j().getColor(17170445));
                    if (this.f.c()) {
                        this.b.setDivider(j().getDrawable(17170445));
                    } else {
                        this.b.setDivider(new ColorDrawable(j().getColor(R.color.day_divider)));
                    }
                    this.b.setDividerHeight(com.baidu.adp.lib.h.g.a((Context) i(), 1.0f));
                }
                this.f.a(i);
                if (this.c != null) {
                    this.c.a(i);
                }
                if (this.e != null) {
                    this.e.b(i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.f.b();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        this.f.a();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (TiebaApplication.B()) {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            if (this.h) {
                this.h = false;
                a();
            }
            this.a.e();
            return;
        }
        H();
    }

    public void a() {
        if (this.a == null) {
            this.h = true;
            return;
        }
        this.h = false;
        if (TiebaApplication.B()) {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            if (s.a().n() > 0) {
                this.a.a(2);
            } else {
                this.a.a(1);
            }
            this.a.d();
            this.a.e();
            return;
        }
        H();
    }

    private void H() {
        if (this.e == null) {
            this.e = new com.baidu.tieba.home.o(i(), a(R.string.login_msg_tab), a(R.string.login_msg_form), 3);
            this.d.addView(this.e.e());
            this.e.b(TiebaApplication.g().an());
        } else {
            ((ViewGroup) this.e.e().getParent()).removeAllViews();
            this.d.addView(this.e.e());
            this.e.b(TiebaApplication.g().an());
        }
        this.b.setVisibility(8);
        this.d.setVisibility(0);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        try {
            if (this.a != null) {
                this.a.f();
                this.a.a();
            }
            System.gc();
        } catch (Exception e) {
            bo.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void G() {
        this.a.b();
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            G();
        }
    }
}
