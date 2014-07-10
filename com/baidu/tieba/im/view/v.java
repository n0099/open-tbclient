package com.baidu.tieba.im.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.e {
    private BaseActivity a;
    private TextView b = null;
    private ProgressBar c = null;
    private View.OnClickListener d = null;
    private View e = null;
    private View f;

    public v(BaseActivity baseActivity) {
        this.a = null;
        this.a = baseActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.e = LayoutInflater.from(this.a).inflate(w.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.b = (TextView) this.e.findViewById(com.baidu.tieba.v.pb_more_text);
        this.f = this.e.findViewById(com.baidu.tieba.v.pb_more_view);
        this.f.setVisibility(8);
        this.c = (ProgressBar) this.e.findViewById(com.baidu.tieba.v.progress);
        a(TbadkApplication.m252getInst().getSkinType());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.e;
    }

    public void a(int i) {
        int color;
        this.a.getLayoutMode().a(this.f);
        String string = this.a.getString(y.nearby_group_no_more);
        String charSequence = this.b.getText() != null ? this.b.getText().toString() : null;
        boolean z = i == 1;
        if (charSequence != null && charSequence.equals(string)) {
            color = this.a.getResources().getColor(z ? com.baidu.tieba.s.pb_list_morebutton_nomore_text_1 : com.baidu.tieba.s.pb_list_morebutton_nomore_text);
        } else {
            color = this.a.getResources().getColor(z ? com.baidu.tieba.s.pb_more_txt_1 : com.baidu.tieba.s.pb_more_txt);
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
        this.b.setText(this.a.getText(y.loading));
        this.f.setVisibility(0);
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void f() {
        this.c.setVisibility(8);
        this.b.setText(y.nearby_group_no_more);
        this.b.setVisibility(0);
        this.f.setVisibility(0);
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void g() {
        this.c.setVisibility(8);
        this.b.setText(y.load_more);
        a(TbadkApplication.m252getInst().getSkinType());
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.d != null) {
            this.d.onClick(this.e);
        }
    }
}
