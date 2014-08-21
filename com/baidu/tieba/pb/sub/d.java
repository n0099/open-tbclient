package com.baidu.tieba.pb.sub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.pb.main.bf;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.e {
    private Context a;
    private TextView b = null;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private int g = 0;

    public d(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.f = com.baidu.adp.lib.e.b.a().a(this.a, v.new_sub_pb_list_more, null);
        this.b = (TextView) this.f.findViewById(u.sub_pb_more_text);
        this.c = (TextView) this.f.findViewById(u.sub_pb_more_text_marginright);
        this.d = (ProgressBar) this.f.findViewById(u.progress);
        return this.f;
    }

    public void c() {
        this.d.setVisibility(0);
        this.b.setText(this.a.getText(x.loading));
        e();
    }

    public void a(int i) {
        this.g = i;
        this.d.setVisibility(8);
        if (i > 0) {
            bf.a(this.a, this.b, i);
            this.c.setVisibility(0);
        } else {
            this.b.setText(this.a.getText(x.load_more));
            this.c.setVisibility(8);
        }
        e();
    }

    public void d() {
        this.d.setVisibility(8);
        if (this.g > 0) {
            bf.a(this.a, this.b, this.g);
            this.c.setVisibility(0);
        } else {
            this.b.setText(this.a.getText(x.load_more));
            this.c.setVisibility(8);
        }
        e();
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    protected void b(int i) {
        this.b.setTextColor(this.a.getResources().getColor(i));
    }

    @SuppressLint({"ResourceAsColor"})
    public void e() {
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        String charSequence = this.b.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.a.getString(x.loading))) {
                b(z ? com.baidu.tieba.r.sub_pb_more_text_1 : com.baidu.tieba.r.sub_pb_more_text);
            } else {
                b(z ? com.baidu.tieba.r.cp_link_tip_c_1 : com.baidu.tieba.r.cp_link_tip_c);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
