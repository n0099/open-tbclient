package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d {
    private com.baidu.tbadk.core.view.v d;
    private LinearLayout e;
    private com.baidu.tbadk.core.view.d f;
    private com.baidu.tbadk.core.view.p g;
    private NoNetworkView h;
    private c b = null;
    private BdListView c = null;
    private boolean i = false;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.at_me_activity, viewGroup, false);
        this.d = new com.baidu.tbadk.core.view.v(getActivity());
        this.d.a(this);
        this.c = (BdListView) inflate.findViewById(com.baidu.tieba.u.atme_lv);
        this.c.setDividerHeight(0);
        this.c.setPullRefresh(this.d);
        this.e = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.bodyNotLogin);
        this.g = new com.baidu.tbadk.core.view.p(inflate, com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1, com.baidu.tieba.u.no_data_container, com.baidu.tieba.u.no_data_image, com.baidu.tieba.u.no_data_image_text);
        this.b = new c(this, 2, new b(this));
        this.b.a(this.c);
        this.b.a((ViewGroup) inflate.findViewById(com.baidu.tieba.u.mention_layout_atme));
        this.b.a(this.g);
        this.b.a("c/u/feed/atme");
        this.b.c();
        this.h = (NoNetworkView) inflate.findViewById(com.baidu.tieba.u.view_no_network_at);
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
                this.b.f();
            }
            if (this.h != null) {
                this.h.a(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.g.b();
        if (this.f != null) {
            this.f.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.g.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            if (this.i) {
                this.i = false;
                a();
            }
            this.b.e();
        } else {
            this.g.b(8);
            g();
        }
        c(TbadkApplication.m252getInst().getSkinType());
    }

    public void a() {
        if (this.b == null) {
            this.i = true;
            return;
        }
        this.i = false;
        if (TbadkApplication.isLogin()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().n() > 0) {
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
            this.f = new com.baidu.tbadk.core.view.d(getActivity(), getString(com.baidu.tieba.x.login_msg_tab), getString(com.baidu.tieba.x.login_msg_form), 3);
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
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.b != null) {
                this.b.a();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.toString());
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
