package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends q.a {
    public int aqQ;
    public View baf;
    public TextView cql;

    public c(View view2) {
        super(view2);
        this.aqQ = 3;
        this.cql = (TextView) view2.findViewById(d.g.look_more_view);
        this.baf = view2.findViewById(d.g.divider_line_above_more_god_replays);
        ak.h(this.cql, d.C0126d.cp_cont_f);
        ak.i(this.cql, d.f.more_all);
        ak.i(this.baf, d.C0126d.cp_bg_line_c);
    }
}
