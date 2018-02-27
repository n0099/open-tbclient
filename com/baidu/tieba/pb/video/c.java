package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends r.a {
    public View bQf;
    public int bfz;
    public TextView cXl;

    public c(View view) {
        super(view);
        this.bfz = 3;
        this.cXl = (TextView) view.findViewById(d.g.look_more_view);
        this.bQf = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.r(this.cXl, d.C0141d.cp_cont_f);
        aj.s(this.cXl, d.f.more_all);
        aj.s(this.bQf, d.C0141d.cp_bg_line_c);
    }
}
