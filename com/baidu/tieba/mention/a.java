package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class a extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d {
    private com.baidu.tbadk.core.view.q d;
    private LinearLayout e;
    private com.baidu.tbadk.core.view.b f;
    private com.baidu.tbadk.core.view.k g;
    private m b = null;
    private BdListView c = null;
    private boolean h = false;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.a.i.at_me_activity, viewGroup, false);
        this.d = new com.baidu.tbadk.core.view.q(getActivity());
        this.d.a(this);
        this.c = (BdListView) inflate.findViewById(com.baidu.tieba.a.h.atme_lv);
        this.c.setDividerHeight(0);
        this.c.setPullRefresh(this.d);
        this.e = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.bodyNotLogin);
        this.g = new com.baidu.tbadk.core.view.k(inflate, com.baidu.tieba.a.g.individual_center_news, com.baidu.tieba.a.g.individual_center_news_1, com.baidu.tieba.a.h.no_data_container, com.baidu.tieba.a.h.no_data_image, com.baidu.tieba.a.h.no_data_image_text);
        this.b = new m(this, 2, new b(this));
        this.b.a(this.c);
        this.b.a((ViewGroup) inflate.findViewById(com.baidu.tieba.a.h.mention_layout_atme));
        this.b.a(this.g);
        this.b.a("c/u/feed/atme");
        this.b.c();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        if (isAdded()) {
            this.g.a(i);
            if (this.d != null) {
                this.d.a(i);
            }
            if (this.f != null) {
                this.f.a(i);
            }
            if (this.b != null) {
                this.b.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.g.b();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.g.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (TbadkApplication.F()) {
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
        b();
    }

    public final void a() {
        if (this.b == null) {
            this.h = true;
            return;
        }
        this.h = false;
        if (TbadkApplication.F()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().j() > 0) {
                this.b.a(2);
            } else {
                this.b.a(1);
            }
            this.b.d();
            this.b.e();
            return;
        }
        b();
    }

    private void b() {
        if (this.f == null) {
            this.f = new com.baidu.tbadk.core.view.b(getActivity(), getString(com.baidu.tieba.a.k.login_msg_tab), getString(com.baidu.tieba.a.k.login_msg_form), 3);
            this.e.addView(this.f.a());
            this.f.a(TbadkApplication.j().l());
        } else {
            ((ViewGroup) this.f.a().getParent()).removeAllViews();
            this.e.addView(this.f.a());
            this.f.a(TbadkApplication.j().l());
        }
        this.c.setVisibility(8);
        this.e.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
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

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        if (!z) {
            this.b.b();
        }
    }
}
