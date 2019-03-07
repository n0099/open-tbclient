package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends v.a {
    public int bUJ;
    public View dividerLine;
    public TextView eiA;

    public c(View view) {
        super(view);
        this.bUJ = 3;
        this.eiA = (TextView) view.findViewById(d.g.look_more_view);
        this.dividerLine = view.findViewById(d.g.divider_line_above_more_god_replays);
        al.j(this.eiA, d.C0236d.cp_cont_f);
        al.k(this.eiA, d.f.more_all);
        al.k(this.dividerLine, d.C0236d.cp_bg_line_c);
    }
}
