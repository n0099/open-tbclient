package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class c extends q.a {
    public int aIf;
    public TextView cOA;
    public View dividerLine;

    public c(View view) {
        super(view);
        this.aIf = 3;
        this.cOA = (TextView) view.findViewById(e.g.look_more_view);
        this.dividerLine = view.findViewById(e.g.divider_line_above_more_god_replays);
        al.h(this.cOA, e.d.cp_cont_f);
        al.i(this.cOA, e.f.more_all);
        al.i(this.dividerLine, e.d.cp_bg_line_c);
    }
}
