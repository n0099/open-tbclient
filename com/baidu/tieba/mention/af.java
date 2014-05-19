package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class af extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d {
    private com.baidu.tbadk.core.view.q d;
    private LinearLayout e;
    private com.baidu.tbadk.core.view.b f;
    private com.baidu.tbadk.core.view.k g;
    private m b = null;
    private BdListView c = null;
    private boolean h = false;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.s.reply_me_activity, (ViewGroup) null);
        this.d = new com.baidu.tbadk.core.view.q(getActivity());
        this.d.a(this);
        this.e = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.bodyNotLogin);
        this.g = new com.baidu.tbadk.core.view.k(inflate, com.baidu.tieba.q.pic_blank_page_search, com.baidu.tieba.q.pic_blank_page_search_1, com.baidu.tieba.r.no_data_container, com.baidu.tieba.r.no_data_image, com.baidu.tieba.r.no_data_image_text);
        this.c = (BdListView) inflate.findViewById(com.baidu.tieba.r.replyme_lv);
        this.c.setDividerHeight(0);
        this.c.setPullRefresh(this.d);
        this.b = new m(this, 1, new ag(this));
        this.b.a(this.c);
        this.b.a((ViewGroup) inflate.findViewById(com.baidu.tieba.r.mention_layout_replyme1));
        this.b.a(this.g);
        this.b.a("c/u/feed/replyme");
        this.b.c();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
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

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
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
        g();
    }

    public void a() {
        if (this.b == null) {
            this.h = true;
            return;
        }
        this.h = false;
        if (TbadkApplication.isLogin()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() > 0) {
                this.b.a(2);
            } else {
                this.b.a(1);
            }
            this.b.d();
            this.b.e();
            return;
        }
        g();
    }

    private void g() {
        if (this.f == null) {
            this.f = new com.baidu.tbadk.core.view.b(getActivity(), getString(com.baidu.tieba.u.login_msg_tab), getString(com.baidu.tieba.u.login_msg_form), 3);
            this.e.addView(this.f.b());
            this.f.b(TbadkApplication.m252getInst().getSkinType());
        } else {
            ((ViewGroup) this.f.b().getParent()).removeAllViews();
            this.e.addView(this.f.b());
            this.f.b(TbadkApplication.m252getInst().getSkinType());
        }
        this.c.setVisibility(8);
        this.e.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.g.b();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.g.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.b != null) {
                this.b.f();
                this.b.a();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void f() {
        this.b.b();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (!z) {
            f();
        }
    }
}
