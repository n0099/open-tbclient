package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i0.r.u.c;
import d.a.j0.d2.h.d;
/* loaded from: classes3.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19674a;

    /* renamed from: b  reason: collision with root package name */
    public View f19675b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19676c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19677d;

    public PbChildTitleViewHolder(View view) {
        super(view);
        this.f19674a = view;
        this.f19675b = view.findViewById(R.id.pb_child_title_top_line);
        this.f19676c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f19677d = textView;
        c.d(textView).v(R.string.F_X02);
    }

    public void b(d dVar) {
        this.f19677d.setText(dVar.e());
    }

    public View c() {
        return this.f19674a;
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f19675b, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f19676c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f19677d, R.color.CAM_X0105);
    }

    public void e(int i2) {
        View view = this.f19674a;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}
