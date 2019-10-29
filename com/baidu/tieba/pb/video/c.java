package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    public int csX;
    public View dividerLine;
    public TextView eNr;

    public c(View view) {
        super(view);
        this.csX = 3;
        this.eNr = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        am.setViewTextColor(this.eNr, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.eNr, R.drawable.more_all);
        am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
