package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends j.a {
    public int apA;
    public View bae;
    public TextView cbb;

    public c(View view) {
        super(view);
        this.apA = 3;
        this.cbb = (TextView) view.findViewById(d.g.look_more_view);
        this.bae = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.i(this.cbb, d.C0082d.cp_cont_f);
        aj.j(this.cbb, d.f.more_all);
        aj.j(this.bae, d.C0082d.cp_bg_line_c);
    }
}
