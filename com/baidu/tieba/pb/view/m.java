package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m extends LinearLayout implements View.OnClickListener {
    private b.a ddo;
    public TextView dsB;
    public TextView dsC;
    private String dsD;
    private int dsE;
    private Context mContext;

    public m(Context context, b.a aVar) {
        super(context);
        this.dsB = null;
        this.dsC = null;
        this.dsE = -1;
        this.ddo = null;
        a(context, aVar);
    }

    public void a(Context context, b.a aVar) {
        if (context != null) {
            this.mContext = context;
            this.ddo = aVar;
            View inflate = LayoutInflater.from(context).inflate(t.h.pb_newchudian_description, (ViewGroup) this, true);
            at.l(inflate, t.d.cp_bg_line_c);
            this.dsB = (TextView) inflate.findViewById(t.g.description_main);
            at.c(this.dsB, t.d.cp_cont_b, 1);
            this.dsC = (TextView) inflate.findViewById(t.g.description_sub);
            at.c(this.dsC, t.d.cp_cont_c, 1);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ay.isEmpty(this.dsD)) {
            com.baidu.tbadk.browser.f.t(this.mContext, this.dsD);
            if (this.ddo != null) {
                switch (this.dsE) {
                    case 0:
                        this.ddo.z(this.dsD, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 1:
                        this.ddo.z(this.dsD, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 2:
                        this.ddo.z(this.dsD, "IMAGE2", "LINK_IMAGE");
                        return;
                    case 3:
                        this.ddo.z(this.dsD, "IMAGE3", "LINK_IMAGE");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void as(String str, int i) {
        this.dsD = str;
        this.dsE = i;
    }
}
