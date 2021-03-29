package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.u.c;
import d.b.i0.c2.h.d;
/* loaded from: classes4.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19526a;

    /* renamed from: b  reason: collision with root package name */
    public View f19527b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19528c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19529d;

    public PbChildTitleViewHolder(View view) {
        super(view);
        this.f19526a = view;
        this.f19527b = view.findViewById(R.id.pb_child_title_top_line);
        this.f19528c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f19529d = textView;
        c.a(textView).s(R.string.F_X02);
    }

    public void b(d dVar) {
        this.f19529d.setText(dVar.e());
    }

    public View c() {
        return this.f19526a;
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f19527b, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f19528c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f19529d, R.color.CAM_X0105);
    }

    public void e(int i) {
        View view = this.f19526a;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
