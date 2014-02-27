package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn extends com.baidu.adp.widget.ListView.c {
    final /* synthetic */ bj a;
    private com.baidu.tieba.k b;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private View g;

    public bn(bj bjVar, com.baidu.tieba.k kVar) {
        this.a = bjVar;
        this.b = null;
        this.b = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public final View a() {
        this.f = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.f.setPadding(0, this.b.getResources().getDimensionPixelSize(R.dimen.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(R.dimen.listview_item_margin));
        this.c = (TextView) this.f.findViewById(R.id.pb_more_text);
        this.g = this.f.findViewById(R.id.pb_more_view);
        this.g.setVisibility(8);
        this.d = (ProgressBar) this.f.findViewById(R.id.progress);
        TiebaApplication.g().ae();
        c();
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.f;
    }

    public final void c() {
        this.b.a().a(this.g);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void d() {
        this.f.setVisibility(0);
    }

    public final void e() {
        this.d.setVisibility(0);
        this.c.setText(this.b.getText(R.string.loading));
        this.g.setVisibility(0);
    }

    public final void f() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        if (this.c != null) {
            this.c.setText(R.string.no_more_to_load);
        }
    }

    public final void g() {
        this.d.setVisibility(8);
        this.c.setText(R.string.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public final void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
