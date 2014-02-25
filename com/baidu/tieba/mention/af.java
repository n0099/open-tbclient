package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.aj;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.j implements com.baidu.adp.widget.ListView.b {
    private ct d;
    private LinearLayout e;
    private com.baidu.tieba.home.r f;
    private aj g;
    private l b = null;
    private BdListView c = null;
    private boolean h = false;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.reply_me_activity, (ViewGroup) null);
        this.d = new ct(getActivity());
        this.d.a(this);
        this.e = (LinearLayout) inflate.findViewById(R.id.bodyNotLogin);
        this.g = new aj(inflate, (int) R.drawable.pic_blank_page_search, (int) R.drawable.pic_blank_page_search_1);
        this.c = (BdListView) inflate.findViewById(R.id.replyme_lv);
        this.c.setPullRefresh(this.d);
        this.b = new l(this, 1, new ag(this));
        this.b.a(this.c);
        this.b.a((ViewGroup) inflate.findViewById(R.id.mention_layout_replyme));
        this.b.a(this.g);
        this.b.a("c/u/feed/replyme");
        this.b.c();
        return inflate;
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            if (i == 1) {
                this.c.setCacheColorHint(getResources().getColor(17170445));
                if (this.g.c()) {
                    this.c.setDivider(getResources().getDrawable(17170445));
                } else {
                    this.c.setDivider(new ColorDrawable(getResources().getColor(R.color.night_divider)));
                }
                this.c.setDividerHeight(BdUtilHelper.a((Context) getActivity(), 1.0f));
            } else {
                this.c.setCacheColorHint(getResources().getColor(17170445));
                if (this.g.c()) {
                    this.c.setDivider(getResources().getDrawable(17170445));
                } else {
                    this.c.setDivider(new ColorDrawable(getResources().getColor(R.color.day_divider)));
                }
                this.c.setDividerHeight(BdUtilHelper.a((Context) getActivity(), 1.0f));
            }
            this.g.a(i);
            if (this.d != null) {
                this.d.a(i);
            }
            if (this.f != null) {
                this.f.b(i);
            }
            if (this.b != null) {
                this.b.g();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TiebaApplication.B()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            if (this.h) {
                this.h = false;
                a();
            }
            this.b.e();
            return;
        }
        this.g.b(8);
        d();
    }

    public void a() {
        if (this.b == null) {
            this.h = true;
            return;
        }
        this.h = false;
        if (TiebaApplication.B()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            if (v.a().m() > 0) {
                this.b.a(2);
            } else {
                this.b.a(1);
            }
            this.b.d();
            this.b.e();
            return;
        }
        d();
    }

    private void d() {
        if (this.f == null) {
            this.f = new com.baidu.tieba.home.r(getActivity(), getString(R.string.login_msg_tab), getString(R.string.login_msg_form), 3);
            this.e.addView(this.f.e());
            this.f.b(TiebaApplication.g().al());
        } else {
            ((ViewGroup) this.f.e().getParent()).removeAllViews();
            this.e.addView(this.f.e());
            this.f.b(TiebaApplication.g().al());
        }
        this.c.setVisibility(8);
        this.e.setVisibility(0);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.g.b();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.g.a();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.b != null) {
                this.b.f();
                this.b.a();
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void c() {
        this.b.b();
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            c();
        }
    }
}
