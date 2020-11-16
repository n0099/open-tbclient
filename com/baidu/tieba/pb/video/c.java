package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends af.a {
    public int ajv;
    public View dividerLine;
    public TextView hYO;

    public c(View view) {
        super(view);
        this.ajv = 3;
        this.hYO = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ap.setViewTextColor(this.hYO, R.color.CAM_X0106);
        ap.setBackgroundResource(this.hYO, R.drawable.more_all);
        ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0204);
    }
}
