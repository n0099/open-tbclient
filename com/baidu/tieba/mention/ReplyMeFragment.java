package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.ae;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReplyMeFragment extends BaseFragment implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    private i f1355a = null;
    private BdListView b = null;
    private com.baidu.tieba.view.ab c;
    private LinearLayout d;
    private com.baidu.tieba.home.l e;
    private ae f;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.reply_me_activity, (ViewGroup) null);
        this.c = new com.baidu.tieba.view.ab(h());
        this.c.a(this);
        this.d = (LinearLayout) inflate.findViewById(R.id.bodyNotLogin);
        this.f = new ae(inflate, (int) R.drawable.pic_blank_page_search, (int) R.drawable.pic_blank_page_search_1);
        this.b = (BdListView) inflate.findViewById(R.id.replyme_lv);
        this.b.setPullRefresh(this.c);
        this.f1355a = new i(this, 1, new ac(this));
        this.f1355a.a(this.b);
        this.f1355a.a((ViewGroup) inflate.findViewById(R.id.mention_layout_replyme));
        this.f1355a.a(this.f);
        this.f1355a.a("c/u/feed/replyme");
        this.f1355a.c();
        return inflate;
    }

    @Override // com.baidu.tieba.BaseFragment
    public void b(int i) {
        super.b(i);
        if (k()) {
            if (i == 1) {
                this.b.setCacheColorHint(i().getColor(17170445));
                if (this.f.c()) {
                    this.b.setDivider(i().getDrawable(17170445));
                } else {
                    this.b.setDivider(i().getDrawable(R.drawable.list_divider_1));
                }
            } else {
                this.b.setCacheColorHint(i().getColor(17170445));
                if (this.f.c()) {
                    this.b.setDivider(i().getDrawable(17170445));
                } else {
                    this.b.setDivider(i().getDrawable(R.drawable.list_divider));
                }
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

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void o() {
        super.o();
        if (TiebaApplication.D()) {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            if (s.a().i() > 0) {
                this.f1355a.a(2);
            } else {
                this.f1355a.a(1);
            }
            this.f1355a.d();
            this.f1355a.e();
            return;
        }
        if (this.e == null) {
            this.e = new com.baidu.tieba.home.l(h(), a(R.string.login_msg_tab), a(R.string.login_msg_form), 3);
            this.d.addView(this.e.c());
            this.e.b(TiebaApplication.g().ap());
        } else {
            ((ViewGroup) this.e.c().getParent()).removeAllViews();
            this.d.addView(this.e.c());
            this.e.b(TiebaApplication.g().ap());
        }
        this.b.setVisibility(8);
        this.d.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.f.b();
    }

    @Override // android.support.v4.app.Fragment
    public void c() {
        super.c();
        this.f.a();
    }

    @Override // android.support.v4.app.Fragment
    public void q() {
        super.q();
        try {
            if (this.f1355a != null) {
                this.f1355a.f();
                this.f1355a.a();
            }
            System.gc();
        } catch (Exception e) {
            av.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void a() {
        this.f1355a.b();
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            a();
        }
    }
}
