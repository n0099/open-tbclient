package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends q.a {
    public int ayX;
    public View bir;
    public TextView cyO;

    public c(View view) {
        super(view);
        this.ayX = 3;
        this.cyO = (TextView) view.findViewById(d.g.look_more_view);
        this.bir = view.findViewById(d.g.divider_line_above_more_god_replays);
        al.h(this.cyO, d.C0141d.cp_cont_f);
        al.i(this.cyO, d.f.more_all);
        al.i(this.bir, d.C0141d.cp_bg_line_c);
    }
}
