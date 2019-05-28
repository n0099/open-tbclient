package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    public int ccI;
    public View dividerLine;
    public TextView exX;

    public c(View view) {
        super(view);
        this.ccI = 3;
        this.exX = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        al.j(this.exX, R.color.cp_cont_f);
        al.k(this.exX, R.drawable.more_all);
        al.k(this.dividerLine, R.color.cp_bg_line_c);
    }
}
