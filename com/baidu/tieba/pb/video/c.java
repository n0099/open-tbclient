package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class c extends q.a {
    public int aLH;
    public TextView cXX;
    public View dividerLine;

    public c(View view) {
        super(view);
        this.aLH = 3;
        this.cXX = (TextView) view.findViewById(e.g.look_more_view);
        this.dividerLine = view.findViewById(e.g.divider_line_above_more_god_replays);
        al.h(this.cXX, e.d.cp_cont_f);
        al.i(this.cXX, e.f.more_all);
        al.i(this.dividerLine, e.d.cp_bg_line_c);
    }
}
