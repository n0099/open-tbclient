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
public class g extends LinearLayout implements View.OnClickListener {
    private b.a daU;
    private int dqA;
    public TextView dqx;
    public TextView dqy;
    private String dqz;
    private Context mContext;

    public g(Context context, b.a aVar) {
        super(context);
        this.dqx = null;
        this.dqy = null;
        this.dqA = -1;
        this.daU = null;
        a(context, aVar);
    }

    public void a(Context context, b.a aVar) {
        if (context != null) {
            this.mContext = context;
            this.daU = aVar;
            View inflate = LayoutInflater.from(context).inflate(t.h.pb_newchudian_description, (ViewGroup) this, true);
            at.l(inflate, t.d.cp_bg_line_c);
            this.dqx = (TextView) inflate.findViewById(t.g.description_main);
            at.b(this.dqx, t.d.cp_cont_b, 1);
            this.dqy = (TextView) inflate.findViewById(t.g.description_sub);
            at.b(this.dqy, t.d.cp_cont_c, 1);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ay.isEmpty(this.dqz)) {
            com.baidu.tbadk.browser.f.s(this.mContext, this.dqz);
            if (this.daU != null) {
                switch (this.dqA) {
                    case 0:
                        this.daU.y(this.dqz, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 1:
                        this.daU.y(this.dqz, "IMAGE1", "LINK_IMAGE");
                        return;
                    case 2:
                        this.daU.y(this.dqz, "IMAGE2", "LINK_IMAGE");
                        return;
                    case 3:
                        this.daU.y(this.dqz, "IMAGE3", "LINK_IMAGE");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void ao(String str, int i) {
        this.dqz = str;
        this.dqA = i;
    }
}
