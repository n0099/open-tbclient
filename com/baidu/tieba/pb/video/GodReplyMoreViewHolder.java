package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f19955a;

    /* renamed from: b  reason: collision with root package name */
    public View f19956b;

    /* renamed from: c  reason: collision with root package name */
    public int f19957c;

    public GodReplyMoreViewHolder(View view) {
        super(view);
        this.f19957c = 3;
        this.f19955a = (TextView) view.findViewById(R.id.look_more_view);
        this.f19956b = view.findViewById(R.id.divider_line_above_more_god_replays);
        SkinManager.setViewTextColor(this.f19955a, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.f19955a, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.f19956b, R.color.CAM_X0204);
    }
}
