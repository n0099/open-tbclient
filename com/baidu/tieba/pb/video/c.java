package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends r.a {
    public View bQs;
    public int bfL;
    public TextView cXx;

    public c(View view) {
        super(view);
        this.bfL = 3;
        this.cXx = (TextView) view.findViewById(d.g.look_more_view);
        this.bQs = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.r(this.cXx, d.C0140d.cp_cont_f);
        aj.s(this.cXx, d.f.more_all);
        aj.s(this.bQs, d.C0140d.cp_bg_line_c);
    }
}
