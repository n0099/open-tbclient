package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends af.a {
    public int aku;
    public View dividerLine;
    public TextView ijL;

    public c(View view) {
        super(view);
        this.aku = 3;
        this.ijL = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ap.setViewTextColor(this.ijL, R.color.CAM_X0106);
        ap.setBackgroundResource(this.ijL, R.drawable.more_all);
        ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0204);
    }
}
