package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.r.u.c;
import d.b.j0.d2.h.d;
/* loaded from: classes3.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19214a;

    /* renamed from: b  reason: collision with root package name */
    public View f19215b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19216c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19217d;

    public PbChildTitleViewHolder(View view) {
        super(view);
        this.f19214a = view;
        this.f19215b = view.findViewById(R.id.pb_child_title_top_line);
        this.f19216c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f19217d = textView;
        c.d(textView).v(R.string.F_X02);
    }

    public void b(d dVar) {
        this.f19217d.setText(dVar.e());
    }

    public View c() {
        return this.f19214a;
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f19215b, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f19216c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f19217d, R.color.CAM_X0105);
    }

    public void e(int i) {
        View view = this.f19214a;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
