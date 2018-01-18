package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends r.a {
    public View bOc;
    public int bdK;
    public TextView cUr;

    public c(View view) {
        super(view);
        this.bdK = 3;
        this.cUr = (TextView) view.findViewById(d.g.look_more_view);
        this.bOc = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.r(this.cUr, d.C0107d.cp_cont_f);
        aj.s(this.cUr, d.f.more_all);
        aj.s(this.bOc, d.C0107d.cp_bg_line_c);
    }
}
