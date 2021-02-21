package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public View dividerLine;
    public TextView ixt;

    public GodReplyMoreViewHolder(View view) {
        super(view);
        this.ajU = 3;
        this.ixt = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ap.setViewTextColor(this.ixt, R.color.CAM_X0106);
        ap.setBackgroundResource(this.ixt, R.drawable.more_all);
        ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0204);
    }
}
