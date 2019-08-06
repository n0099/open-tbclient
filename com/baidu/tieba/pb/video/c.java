package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    public int cdS;
    public View dividerLine;
    public TextView eDc;

    public c(View view) {
        super(view);
        this.cdS = 3;
        this.eDc = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        am.j(this.eDc, R.color.cp_cont_f);
        am.k(this.eDc, R.drawable.more_all);
        am.k(this.dividerLine, R.color.cp_bg_line_c);
    }
}
