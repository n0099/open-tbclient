package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends q.a {
    public int azI;
    public View bkw;
    public TextView czl;

    public c(View view) {
        super(view);
        this.azI = 3;
        this.czl = (TextView) view.findViewById(d.g.look_more_view);
        this.bkw = view.findViewById(d.g.divider_line_above_more_god_replays);
        am.h(this.czl, d.C0140d.cp_cont_f);
        am.i(this.czl, d.f.more_all);
        am.i(this.bkw, d.C0140d.cp_bg_line_c);
    }
}
