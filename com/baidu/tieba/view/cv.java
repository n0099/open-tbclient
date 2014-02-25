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
public class cv extends com.baidu.adp.widget.ListView.c {
    private com.baidu.tieba.f a;
    private TextView b = null;
    private ProgressBar c = null;
    private View.OnClickListener d = null;
    private View e = null;
    private View f;

    public cv(com.baidu.tieba.f fVar) {
        this.a = null;
        this.a = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.e = LayoutInflater.from(this.a).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin), 0, this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin));
        this.b = (TextView) this.e.findViewById(R.id.pb_more_text);
        this.f = this.e.findViewById(R.id.pb_more_view);
        this.f.setVisibility(8);
        this.c = (ProgressBar) this.e.findViewById(R.id.progress);
        a(TiebaApplication.g().al());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.e;
    }

    public void a(int i) {
        int color;
        this.a.getLayoutMode().a(this.f);
        String string = this.a.getString(R.string.nearby_group_no_more);
        String charSequence = this.b.getText() != null ? this.b.getText().toString() : null;
        boolean z = i == 1;
        if (charSequence != null && charSequence.equals(string)) {
            color = this.a.getResources().getColor(z ? R.color.pb_list_morebutton_nomore_text_1 : R.color.pb_list_morebutton_nomore_text);
        } else {
            color = this.a.getResources().getColor(z ? R.color.pb_more_txt_1 : R.color.pb_more_txt);
        }
        this.b.setTextColor(color);
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
        this.b.setText(this.a.getText(R.string.loading));
        this.f.setVisibility(0);
        a(TiebaApplication.g().al());
    }

    public void f() {
        this.c.setVisibility(8);
        this.b.setText(R.string.nearby_group_no_more);
        this.b.setVisibility(0);
        this.f.setVisibility(0);
        a(TiebaApplication.g().al());
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.d != null) {
            this.d.onClick(this.e);
        }
    }
}
