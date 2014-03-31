package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class af extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d {
    private com.baidu.tbadk.core.view.q c;
    private LinearLayout d;
    private com.baidu.tbadk.core.view.b e;
    private com.baidu.tbadk.core.view.k f;
    private m a = null;
    private BdListView b = null;
    private boolean g = false;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.a.i.reply_me_activity, (ViewGroup) null);
        this.c = new com.baidu.tbadk.core.view.q(getActivity());
        this.c.a(this);
        this.d = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.bodyNotLogin);
        this.f = new com.baidu.tbadk.core.view.k(inflate, com.baidu.tieba.a.g.pic_blank_page_search, com.baidu.tieba.a.g.pic_blank_page_search_1, com.baidu.tieba.a.h.no_data_container, com.baidu.tieba.a.h.no_data_image, com.baidu.tieba.a.h.no_data_image_text);
        this.b = (BdListView) inflate.findViewById(com.baidu.tieba.a.h.replyme_lv);
        this.b.setPullRefresh(this.c);
        this.a = new m(this, 1, new ag(this));
        this.a.a(this.b);
        this.a.a((ViewGroup) inflate.findViewById(com.baidu.tieba.a.h.mention_layout_replyme1));
        this.a.a(this.f);
        this.a.a("c/u/feed/replyme");
        this.a.c();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (i == 1) {
                if (this.f.c()) {
                    this.b.setDivider(getResources().getDrawable(17170445));
                } else {
                    this.b.setDivider(new ColorDrawable(getResources().getColor(com.baidu.tieba.a.e.night_divider)));
                }
                this.b.setDividerHeight(com.baidu.adp.lib.util.i.a((Context) getActivity(), 1.0f));
            } else {
                if (this.f.c()) {
                    this.b.setDivider(getResources().getDrawable(17170445));
                } else {
                    this.b.setDivider(new ColorDrawable(getResources().getColor(com.baidu.tieba.a.e.day_divider)));
                }
                this.b.setDividerHeight(com.baidu.adp.lib.util.i.a((Context) getActivity(), 1.0f));
            }
            this.f.a(i);
            if (this.c != null) {
                this.c.a(i);
            }
            if (this.e != null) {
                this.e.a(i);
            }
            if (this.a != null) {
                this.a.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (TbadkApplication.F()) {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            if (this.g) {
                this.g = false;
                a();
            }
            this.a.e();
            return;
        }
        this.f.b(8);
        b();
    }

    public final void a() {
        if (this.a == null) {
            this.g = true;
            return;
        }
        this.g = false;
        if (TbadkApplication.F()) {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().i() > 0) {
                this.a.a(2);
            } else {
                this.a.a(1);
            }
            this.a.d();
            this.a.e();
            return;
        }
        b();
    }

    private void b() {
        if (this.e == null) {
            this.e = new com.baidu.tbadk.core.view.b(getActivity(), getString(com.baidu.tieba.a.k.login_msg_tab), getString(com.baidu.tieba.a.k.login_msg_form), 3);
            this.d.addView(this.e.a());
            this.e.a(TbadkApplication.j().l());
        } else {
            ((ViewGroup) this.e.a().getParent()).removeAllViews();
            this.d.addView(this.e.a());
            this.e.a(TbadkApplication.j().l());
        }
        this.b.setVisibility(8);
        this.d.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f.b();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        try {
            if (this.a != null) {
                this.a.f();
                this.a.a();
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        if (!z) {
            this.a.b();
        }
    }
}
