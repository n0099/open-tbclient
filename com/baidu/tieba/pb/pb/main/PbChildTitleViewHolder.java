package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.m0.r.u.c;
import d.a.n0.e2.h.d;
/* loaded from: classes5.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f18876a;

    /* renamed from: b  reason: collision with root package name */
    public View f18877b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f18878c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18879d;

    public PbChildTitleViewHolder(View view) {
        super(view);
        this.f18876a = view;
        this.f18877b = view.findViewById(R.id.pb_child_title_top_line);
        this.f18878c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f18879d = textView;
        c.d(textView).x(R.string.F_X02);
    }

    public void b(d dVar) {
        this.f18879d.setText(dVar.e());
    }

    public View c() {
        return this.f18876a;
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f18877b, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f18878c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f18879d, R.color.CAM_X0105);
    }

    public void e(int i2) {
        View view = this.f18876a;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}
