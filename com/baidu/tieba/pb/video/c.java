package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class c extends q.a {
    public int azF;
    public TextView czi;
    public View dividerLine;

    public c(View view) {
        super(view);
        this.azF = 3;
        this.czi = (TextView) view.findViewById(f.g.look_more_view);
        this.dividerLine = view.findViewById(f.g.divider_line_above_more_god_replays);
        am.h(this.czi, f.d.cp_cont_f);
        am.i(this.czi, f.C0146f.more_all);
        am.i(this.dividerLine, f.d.cp_bg_line_c);
    }
}
