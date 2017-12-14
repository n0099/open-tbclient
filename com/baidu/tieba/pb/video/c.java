package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends j.a {
    public int apD;
    public View baf;
    public TextView cbf;

    public c(View view) {
        super(view);
        this.apD = 3;
        this.cbf = (TextView) view.findViewById(d.g.look_more_view);
        this.baf = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.i(this.cbf, d.C0096d.cp_cont_f);
        aj.j(this.cbf, d.f.more_all);
        aj.j(this.baf, d.C0096d.cp_bg_line_c);
    }
}
