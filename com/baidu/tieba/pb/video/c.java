package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends q.a {
    public int azP;
    public View bjR;
    public TextView cwI;

    public c(View view) {
        super(view);
        this.azP = 3;
        this.cwI = (TextView) view.findViewById(d.g.look_more_view);
        this.bjR = view.findViewById(d.g.divider_line_above_more_god_replays);
        am.h(this.cwI, d.C0142d.cp_cont_f);
        am.i(this.cwI, d.f.more_all);
        am.i(this.bjR, d.C0142d.cp_bg_line_c);
    }
}
