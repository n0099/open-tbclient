package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends j.a {
    public int apG;
    public View baj;
    public TextView cbj;

    public c(View view) {
        super(view);
        this.apG = 3;
        this.cbj = (TextView) view.findViewById(d.g.look_more_view);
        this.baj = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.i(this.cbj, d.C0095d.cp_cont_f);
        aj.j(this.cbj, d.f.more_all);
        aj.j(this.baj, d.C0095d.cp_bg_line_c);
    }
}
