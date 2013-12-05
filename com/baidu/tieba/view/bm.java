package com.baidu.tieba.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.widget.ListView.c {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f2676a;
    private TextView b = null;
    private ProgressBar c = null;
    private View.OnClickListener d = null;
    private View e = null;
    private View f;

    public bm(com.baidu.tieba.j jVar) {
        this.f2676a = null;
        this.f2676a = jVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.e = LayoutInflater.from(this.f2676a).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.f2676a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin), 0, this.f2676a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin));
        this.b = (TextView) this.e.findViewById(R.id.pb_more_text);
        this.f = this.e.findViewById(R.id.pb_more_view);
        this.f.setVisibility(8);
        this.c = (ProgressBar) this.e.findViewById(R.id.progress);
        a(TiebaApplication.h().an());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.e;
    }

    public void a(int i) {
        this.f2676a.getLayoutMode().a(this.f);
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void c() {
        this.e.setVisibility(8);
    }

    public void d() {
        this.e.setVisibility(0);
    }

    public void e() {
        this.c.setVisibility(0);
        this.b.setText(this.f2676a.getText(R.string.loading));
        this.f.setVisibility(0);
    }

    public void f() {
        this.c.setVisibility(8);
        this.b.setText(R.string.nearby_group_no_more);
        this.b.setVisibility(0);
        this.f.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.d != null) {
            this.d.onClick(this.e);
        }
    }
}
