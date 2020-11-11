package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends af.a {
    public int ajq;
    public View dividerLine;
    public TextView hYo;

    public c(View view) {
        super(view);
        this.ajq = 3;
        this.hYo = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ap.setViewTextColor(this.hYo, R.color.cp_cont_f);
        ap.setBackgroundResource(this.hYo, R.drawable.more_all);
        ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
