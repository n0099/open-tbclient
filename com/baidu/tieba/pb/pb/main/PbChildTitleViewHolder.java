package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.r.u.c;
import d.a.k0.d2.h.d;
/* loaded from: classes5.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f18962a;

    /* renamed from: b  reason: collision with root package name */
    public View f18963b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f18964c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18965d;

    public PbChildTitleViewHolder(View view) {
        super(view);
        this.f18962a = view;
        this.f18963b = view.findViewById(R.id.pb_child_title_top_line);
        this.f18964c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f18965d = textView;
        c.d(textView).v(R.string.F_X02);
    }

    public void b(d dVar) {
        this.f18965d.setText(dVar.e());
    }

    public View c() {
        return this.f18962a;
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f18963b, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f18964c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f18965d, R.color.CAM_X0105);
    }

    public void e(int i2) {
        View view = this.f18962a;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}
