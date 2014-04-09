package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao extends com.baidu.adp.widget.ListView.e {
    final /* synthetic */ ak a;
    private com.baidu.tbadk.core.e b;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private View g;

    public ao(ak akVar, com.baidu.tbadk.core.e eVar) {
        this.a = akVar;
        this.b = null;
        this.b = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final View a() {
        this.f = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.new_pb_list_more, (ViewGroup) null);
        this.f.setPadding(0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_margin));
        this.c = (TextView) this.f.findViewById(com.baidu.tieba.a.h.pb_more_text);
        this.g = this.f.findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.g.setVisibility(8);
        this.d = (ProgressBar) this.f.findViewById(com.baidu.tieba.a.h.progress);
        TbadkApplication.j().l();
        c();
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.f;
    }

    public final void c() {
        this.b.b().a(this.g);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void d() {
        this.f.setVisibility(0);
    }

    public final void e() {
        this.d.setVisibility(0);
        this.c.setText(this.b.getText(com.baidu.tieba.a.k.loading));
        this.g.setVisibility(0);
    }

    public final void f() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        if (this.c != null) {
            this.c.setText(com.baidu.tieba.a.k.no_more_to_load);
        }
    }

    public final void g() {
        this.d.setVisibility(8);
        this.c.setText(com.baidu.tieba.a.k.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
