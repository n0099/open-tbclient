package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f20132a;

    /* renamed from: b  reason: collision with root package name */
    public View f20133b;

    /* renamed from: c  reason: collision with root package name */
    public int f20134c;

    public GodReplyMoreViewHolder(View view) {
        super(view);
        this.f20134c = 3;
        this.f20132a = (TextView) view.findViewById(R.id.look_more_view);
        this.f20133b = view.findViewById(R.id.divider_line_above_more_god_replays);
        SkinManager.setViewTextColor(this.f20132a, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.f20132a, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.f20133b, R.color.CAM_X0204);
    }
}
