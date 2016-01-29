package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0074a cHL;
    public TextView cVC;
    public TextView cVD;
    private String cVE;
    private int cVF;
    private Context mContext;

    public g(Context context, a.InterfaceC0074a interfaceC0074a) {
        super(context);
        this.cVC = null;
        this.cVD = null;
        this.cVF = -1;
        this.cHL = null;
        a(context, interfaceC0074a);
    }

    public void a(Context context, a.InterfaceC0074a interfaceC0074a) {
        if (context != null) {
            this.mContext = context;
            this.cHL = interfaceC0074a;
            View inflate = LayoutInflater.from(context).inflate(t.h.pb_newchudian_description, (ViewGroup) this, true);
            ar.l(inflate, t.d.cp_bg_line_c);
            this.cVC = (TextView) inflate.findViewById(t.g.description_main);
            ar.b(this.cVC, t.d.cp_cont_b, 1);
            this.cVD = (TextView) inflate.findViewById(t.g.description_sub);
            ar.b(this.cVD, t.d.cp_cont_c, 1);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aw.isEmpty(this.cVE)) {
            com.baidu.tbadk.browser.f.B(this.mContext, this.cVE);
            if (this.cHL != null) {
                switch (this.cVF) {
                    case 0:
                        this.cHL.u(this.cVE, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 1:
                        this.cHL.u(this.cVE, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 2:
                        this.cHL.u(this.cVE, "IMAGE2", "LINK_IMAGE");
                        return;
                    case 3:
                        this.cHL.u(this.cVE, "IMAGE3", "LINK_IMAGE");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void af(String str, int i) {
        this.cVE = str;
        this.cVF = i;
    }
}
