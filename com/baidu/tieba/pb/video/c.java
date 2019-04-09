package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends v.a {
    public int bUN;
    public View dividerLine;
    public TextView eij;

    public c(View view) {
        super(view);
        this.bUN = 3;
        this.eij = (TextView) view.findViewById(d.g.look_more_view);
        this.dividerLine = view.findViewById(d.g.divider_line_above_more_god_replays);
        al.j(this.eij, d.C0277d.cp_cont_f);
        al.k(this.eij, d.f.more_all);
        al.k(this.dividerLine, d.C0277d.cp_bg_line_c);
    }
}
