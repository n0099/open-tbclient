package com.baidu.tieba.im.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.widget.ListView.e {
    private com.baidu.tbadk.a a;
    private TextView b = null;
    private ProgressBar c = null;
    private View.OnClickListener d = null;
    private View e = null;
    private View f;

    public p(com.baidu.tbadk.a aVar) {
        this.a = null;
        this.a = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final View a() {
        this.e = LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.listview_item_margin), 0, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.listview_item_margin));
        this.b = (TextView) this.e.findViewById(com.baidu.tieba.im.h.pb_more_text);
        this.f = this.e.findViewById(com.baidu.tieba.im.h.pb_more_view);
        this.f.setVisibility(8);
        this.c = (ProgressBar) this.e.findViewById(com.baidu.tieba.im.h.progress);
        a(TbadkApplication.j().l());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.e;
    }

    public final void a(int i) {
        int color;
        this.a.getLayoutMode().a(this.f);
        String string = this.a.getString(com.baidu.tieba.im.j.nearby_group_no_more);
        String charSequence = this.b.getText() != null ? this.b.getText().toString() : null;
        boolean z = i == 1;
        if (charSequence != null && charSequence.equals(string)) {
            color = this.a.getResources().getColor(z ? com.baidu.tieba.im.e.pb_list_morebutton_nomore_text_1 : com.baidu.tieba.im.e.pb_list_morebutton_nomore_text);
        } else {
            color = this.a.getResources().getColor(z ? com.baidu.tieba.im.e.pb_more_txt_1 : com.baidu.tieba.im.e.pb_more_txt);
        }
        this.b.setTextColor(color);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public final void c() {
        this.e.setVisibility(8);
    }

    public final void d() {
        this.e.setVisibility(0);
    }

    public final void e() {
        this.c.setVisibility(0);
        this.b.setText(this.a.getText(com.baidu.tieba.im.j.loading));
        this.f.setVisibility(0);
        a(TbadkApplication.j().l());
    }

    public final void f() {
        this.c.setVisibility(8);
        this.b.setText(com.baidu.tieba.im.j.nearby_group_no_more);
        this.b.setVisibility(0);
        this.f.setVisibility(0);
        a(TbadkApplication.j().l());
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final void onClick() {
        if (this.d != null) {
            this.d.onClick(this.e);
        }
    }
}
