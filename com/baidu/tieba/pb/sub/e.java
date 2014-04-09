package com.baidu.tieba.pb.sub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.pb.main.ba;
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.widget.ListView.e {
    private Context a;
    private TextView b = null;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private int g = 0;

    public e(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final View a() {
        this.f = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.new_sub_pb_list_more, (ViewGroup) null);
        this.b = (TextView) this.f.findViewById(com.baidu.tieba.a.h.sub_pb_more_text);
        this.c = (TextView) this.f.findViewById(com.baidu.tieba.a.h.sub_pb_more_text_marginright);
        this.d = (ProgressBar) this.f.findViewById(com.baidu.tieba.a.h.progress);
        return this.f;
    }

    public final void c() {
        this.d.setVisibility(0);
        this.b.setText(this.a.getText(com.baidu.tieba.a.k.loading));
        e();
    }

    public final void a(int i) {
        this.g = i;
        this.d.setVisibility(8);
        if (i > 0) {
            ba.a(this.a, this.b, i);
            this.c.setVisibility(0);
        } else {
            this.b.setText(this.a.getText(com.baidu.tieba.a.k.load_more));
            this.c.setVisibility(8);
        }
        e();
    }

    public final void d() {
        this.d.setVisibility(8);
        if (this.g > 0) {
            ba.a(this.a, this.b, this.g);
            this.c.setVisibility(0);
        } else {
            this.b.setText(this.a.getText(com.baidu.tieba.a.k.load_more));
            this.c.setVisibility(8);
        }
        e();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    private void b(int i) {
        this.b.setTextColor(this.a.getResources().getColor(i));
    }

    @SuppressLint({"ResourceAsColor"})
    private void e() {
        boolean z = TbadkApplication.j().l() == 1;
        String charSequence = this.b.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.a.getString(com.baidu.tieba.a.k.loading))) {
                b(z ? com.baidu.tieba.a.e.sub_pb_more_text_1 : com.baidu.tieba.a.e.sub_pb_more_text);
            } else {
                b(z ? com.baidu.tieba.a.e.cp_link_tip_c_1 : com.baidu.tieba.a.e.cp_link_tip_c);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
