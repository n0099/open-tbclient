package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c extends ad.a {
    public int aho;
    public View dividerLine;
    public TextView gXa;

    public c(View view) {
        super(view);
        this.aho = 3;
        this.gXa = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ao.setViewTextColor(this.gXa, R.color.cp_cont_f);
        ao.setBackgroundResource(this.gXa, R.drawable.more_all);
        ao.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
