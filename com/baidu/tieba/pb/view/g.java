package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.a;
/* loaded from: classes.dex */
public class g extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0072a cBf;
    public TextView cMO;
    public TextView cMP;
    private String cMQ;
    private int cMR;
    private Context mContext;

    public g(Context context, a.InterfaceC0072a interfaceC0072a) {
        super(context);
        this.cMO = null;
        this.cMP = null;
        this.cMR = -1;
        this.cBf = null;
        a(context, interfaceC0072a);
    }

    public void a(Context context, a.InterfaceC0072a interfaceC0072a) {
        if (context != null) {
            this.mContext = context;
            this.cBf = interfaceC0072a;
            View inflate = LayoutInflater.from(context).inflate(n.h.pb_newchudian_description, (ViewGroup) this, true);
            as.j(inflate, n.d.cp_bg_line_c);
            this.cMO = (TextView) inflate.findViewById(n.g.description_main);
            as.b(this.cMO, n.d.cp_cont_b, 1);
            this.cMP = (TextView) inflate.findViewById(n.g.description_sub);
            as.b(this.cMP, n.d.cp_cont_c, 1);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ax.isEmpty(this.cMQ)) {
            com.baidu.tbadk.browser.f.B(this.mContext, this.cMQ);
            if (this.cBf != null) {
                switch (this.cMR) {
                    case 0:
                        this.cBf.t(this.cMQ, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 1:
                        this.cBf.t(this.cMQ, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 2:
                        this.cBf.t(this.cMQ, "IMAGE2", "LINK_IMAGE");
                        return;
                    case 3:
                        this.cBf.t(this.cMQ, "IMAGE3", "LINK_IMAGE");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void ad(String str, int i) {
        this.cMQ = str;
        this.cMR = i;
    }
}
