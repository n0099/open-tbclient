package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
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
            this.b = (TextView) view.findViewById(u.title);
            this.c = (TextView) view.findViewById(u.content);
            this.d = (TextView) view.findViewById(u.time);
            this.e = view.findViewById(u.line);
        }
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.b != null && akVar.c() != null) {
                this.b.setText(akVar.c());
            }
            if (this.c != null && akVar.d() != null) {
                this.c.setText(akVar.d());
            }
            if (this.d != null) {
                String e = ba.e(new Date(akVar.e()));
                if (e == null) {
                    e = "";
                }
                this.d.setText(e);
            }
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.a.setBackgroundResource(t.list_item_selector_1);
            this.e.setBackgroundResource(r.cp_bg_line_b_1);
            this.b.setTextColor(this.a.getContext().getResources().getColor(r.cp_cont_b_1));
            this.c.setTextColor(this.a.getContext().getResources().getColor(r.cp_cont_d_1));
            this.d.setTextColor(this.a.getContext().getResources().getColor(r.cp_cont_d_1));
            return;
        }
        this.a.setBackgroundResource(t.list_item_selector);
        this.e.setBackgroundResource(r.cp_bg_line_b);
        this.b.setTextColor(this.a.getContext().getResources().getColor(r.cp_cont_b));
        this.c.setTextColor(this.a.getContext().getResources().getColor(r.cp_cont_d));
        this.d.setTextColor(this.a.getContext().getResources().getColor(r.cp_cont_d));
    }
}
