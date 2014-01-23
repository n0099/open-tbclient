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
import com.baidu.tieba.ap;
import com.baidu.tieba.view.cm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReplyMeFragment extends BaseFragment implements com.baidu.adp.widget.ListView.b {
    private cm c;
    private LinearLayout d;
    private com.baidu.tieba.home.o e;
    private ap f;
    private int g;
    private j a = null;
    private BdListView b = null;
    private boolean h = false;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = -1;
        View inflate = layoutInflater.inflate(R.layout.reply_me_activity, (ViewGroup) null);
        this.c = new cm(i());
        this.c.a(this);
        this.d = (LinearLayout) inflate.findViewById(R.id.bodyNotLogin);
        this.f = new ap(inflate, (int) R.drawable.pic_blank_page_search, (int) R.drawable.pic_blank_page_search_1);
        this.b = (BdListView) inflate.findViewById(R.id.replyme_lv);
        this.b.setPullRefresh(this.c);
        this.a = new j(this, 1, new ac(this));
        this.a.a(this.b);
        this.a.a((ViewGroup) inflate.findViewById(R.id.mention_layout_replyme));
        this.a.a(this.f);
        this.a.a("c/u/feed/replyme");
        this.a.c();
        return inflate;
    }

    @Override // com.baidu.tieba.BaseFragment
    public void d(int i) {
        super.d(i);
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
                    this.b.setDividerHeight(com.baidu.adp.lib.g.g.a((Context) i(), 1.0f));
                } else {
                    this.b.setCacheColorHint(j().getColor(17170445));
                    if (this.f.c()) {
                        this.b.setDivider(j().getDrawable(17170445));
                    } else {
                        this.b.setDivider(new ColorDrawable(j().getColor(R.color.day_divider)));
                    }
                    this.b.setDividerHeight(com.baidu.adp.lib.g.g.a((Context) i(), 1.0f));
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
            if (s.a().m() > 0) {
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
            this.e.b(TiebaApplication.h().al());
        } else {
            ((ViewGroup) this.e.e().getParent()).removeAllViews();
            this.d.addView(this.e.e());
            this.e.b(TiebaApplication.h().al());
        }
        this.b.setVisibility(8);
        this.d.setVisibility(0);
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
    public void t() {
        super.t();
        try {
            if (this.a != null) {
                this.a.f();
                this.a.a();
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "onDestroy", e.toString());
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
