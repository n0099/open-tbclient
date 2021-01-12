package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public View dividerLine;
    public TextView irB;

    public GodReplyMoreViewHolder(View view) {
        super(view);
        this.akf = 3;
        this.irB = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ao.setViewTextColor(this.irB, R.color.CAM_X0106);
        ao.setBackgroundResource(this.irB, R.drawable.more_all);
        ao.setBackgroundResource(this.dividerLine, R.color.CAM_X0204);
    }
}
