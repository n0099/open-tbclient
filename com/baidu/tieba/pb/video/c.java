package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends ad.a {
    public int ahx;
    public View dividerLine;
    public TextView gRv;

    public c(View view) {
        super(view);
        this.ahx = 3;
        this.gRv = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        an.setViewTextColor(this.gRv, (int) R.color.cp_cont_f);
        an.setBackgroundResource(this.gRv, R.drawable.more_all);
        an.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_c);
    }
}
