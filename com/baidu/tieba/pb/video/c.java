package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends aa.a {
    public int agt;
    public View dividerLine;
    public TextView gEF;

    public c(View view) {
        super(view);
        this.agt = 3;
        this.gEF = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        am.setViewTextColor(this.gEF, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.gEF, R.drawable.more_all);
        am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
