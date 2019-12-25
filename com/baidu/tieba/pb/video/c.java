package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends v.a {
    public int MA;
    public View dividerLine;
    public TextView fEo;

    public c(View view) {
        super(view);
        this.MA = 3;
        this.fEo = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        am.setViewTextColor(this.fEo, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.fEo, R.drawable.more_all);
        am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
