package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.Date;
/* loaded from: classes.dex */
public class h {
    private View a;
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;

    public h(View view) {
        if (view != null) {
            this.a = view;
            this.b = (TextView) view.findViewById(v.title);
            this.c = (TextView) view.findViewById(v.content);
            this.d = (TextView) view.findViewById(v.time);
            this.e = view.findViewById(v.line);
        }
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            if (this.b != null && ajVar.c() != null) {
                this.b.setText(ajVar.c());
            }
            if (this.c != null && ajVar.d() != null) {
                this.c.setText(ajVar.d());
            }
            if (this.d != null) {
                String e = bm.e(new Date(ajVar.e()));
                if (e == null) {
                    e = "";
                }
                this.d.setText(e);
            }
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.a.setBackgroundResource(u.list_item_selector_1);
            this.e.setBackgroundResource(s.cp_bg_line_b_1);
            this.b.setTextColor(this.a.getContext().getResources().getColor(s.cp_cont_b_1));
            this.c.setTextColor(this.a.getContext().getResources().getColor(s.cp_cont_d_1));
            this.d.setTextColor(this.a.getContext().getResources().getColor(s.cp_cont_d_1));
            return;
        }
        this.a.setBackgroundResource(u.list_item_selector);
        this.e.setBackgroundResource(s.cp_bg_line_b);
        this.b.setTextColor(this.a.getContext().getResources().getColor(s.cp_cont_b));
        this.c.setTextColor(this.a.getContext().getResources().getColor(s.cp_cont_d));
        this.d.setTextColor(this.a.getContext().getResources().getColor(s.cp_cont_d));
    }
}
