package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.u.c;
import d.b.i0.d2.h.d;
/* loaded from: classes3.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19206a;

    /* renamed from: b  reason: collision with root package name */
    public View f19207b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19208c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19209d;

    public PbChildTitleViewHolder(View view) {
        super(view);
        this.f19206a = view;
        this.f19207b = view.findViewById(R.id.pb_child_title_top_line);
        this.f19208c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f19209d = textView;
        c.d(textView).v(R.string.F_X02);
    }

    public void b(d dVar) {
        this.f19209d.setText(dVar.e());
    }

    public View c() {
        return this.f19206a;
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f19207b, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f19208c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f19209d, R.color.CAM_X0105);
    }

    public void e(int i) {
        View view = this.f19206a;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
