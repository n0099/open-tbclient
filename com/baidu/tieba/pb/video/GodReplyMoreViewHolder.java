package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public View dividerLine;
    public TextView izc;

    public GodReplyMoreViewHolder(View view) {
        super(view);
        this.aln = 3;
        this.izc = (TextView) view.findViewById(R.id.look_more_view);
        this.dividerLine = view.findViewById(R.id.divider_line_above_more_god_replays);
        ap.setViewTextColor(this.izc, R.color.CAM_X0106);
        ap.setBackgroundResource(this.izc, R.drawable.more_all);
        ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0204);
    }
}
