package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f19649a;

    /* renamed from: b  reason: collision with root package name */
    public View f19650b;

    /* renamed from: c  reason: collision with root package name */
    public int f19651c;

    public GodReplyMoreViewHolder(View view) {
        super(view);
        this.f19651c = 3;
        this.f19649a = (TextView) view.findViewById(R.id.look_more_view);
        this.f19650b = view.findViewById(R.id.divider_line_above_more_god_replays);
        SkinManager.setViewTextColor(this.f19649a, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.f19649a, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.f19650b, R.color.CAM_X0204);
    }
}
