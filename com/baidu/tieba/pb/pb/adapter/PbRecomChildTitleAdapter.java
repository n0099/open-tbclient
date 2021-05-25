package com.baidu.tieba.pb.pb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.m0.r.u.c;
import d.a.n0.e2.k.e.o;
import d.a.n0.e2.o.i;
import d.a.n0.z.f0.e;
/* loaded from: classes3.dex */
public class PbRecomChildTitleAdapter extends o<e, ViewHolder> {

    /* loaded from: classes3.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f18837a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18838b;

        /* renamed from: c  reason: collision with root package name */
        public View f18839c;

        public ViewHolder(View view) {
            super(view);
            this.f18837a = 3;
            c(view);
        }

        public void b(e eVar) {
            this.f18838b.setText(eVar.f63499e);
        }

        public final void c(View view) {
            this.f18838b = (TextView) view.findViewById(R.id.tv_title);
            this.f18839c = view.findViewById(R.id.title_top_line);
            c.d(this.f18838b).x(R.string.F_X02);
        }

        public void d() {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f18837a != skinType) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f18839c, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.f18838b, R.color.CAM_X0105);
                this.f18837a = skinType;
            }
        }
    }

    public PbRecomChildTitleAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, (e) obj, (ViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ViewHolder P(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.pb_reclist_title, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, e eVar, ViewHolder viewHolder) {
        super.W(i2, view, viewGroup, eVar, viewHolder);
        viewHolder.b(eVar);
        viewHolder.d();
        return view;
    }
}
