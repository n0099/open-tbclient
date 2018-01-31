package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends r.a {
    public View bOk;
    public int bdS;
    public TextView cUM;

    public c(View view) {
        super(view);
        this.bdS = 3;
        this.cUM = (TextView) view.findViewById(d.g.look_more_view);
        this.bOk = view.findViewById(d.g.divider_line_above_more_god_replays);
        aj.r(this.cUM, d.C0108d.cp_cont_f);
        aj.s(this.cUM, d.f.more_all);
        aj.s(this.bOk, d.C0108d.cp_bg_line_c);
    }
}
