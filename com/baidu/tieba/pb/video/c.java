package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends y.a {
    public int afW;
    public View dividerLine;
    public TextView gpF;

    public c(View view) {
        super(view);
        this.afW = 3;
        this.gpF = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        am.setViewTextColor(this.gpF, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.gpF, R.drawable.more_all);
        am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
