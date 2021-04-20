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
import d.b.h0.r.u.c;
import d.b.i0.d2.k.e.o;
import d.b.i0.d2.o.i;
import d.b.i0.x.f0.e;
/* loaded from: classes3.dex */
public class PbRecomChildTitleAdapter extends o<e, ViewHolder> {

    /* loaded from: classes3.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f19170a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19171b;

        /* renamed from: c  reason: collision with root package name */
        public View f19172c;

        public ViewHolder(View view) {
            super(view);
            this.f19170a = 3;
            c(view);
        }

        public void b(e eVar) {
            this.f19171b.setText(eVar.f63808e);
        }

        public final void c(View view) {
            this.f19171b = (TextView) view.findViewById(R.id.tv_title);
            this.f19172c = view.findViewById(R.id.title_top_line);
            c.d(this.f19171b).v(R.string.F_X02);
        }

        public void d() {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f19170a != skinType) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f19172c, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.f19171b, R.color.CAM_X0105);
                this.f19170a = skinType;
            }
        }
    }

    public PbRecomChildTitleAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (e) obj, (ViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public ViewHolder R(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_reclist_title, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, e eVar, ViewHolder viewHolder) {
        super.X(i, view, viewGroup, eVar, viewHolder);
        viewHolder.b(eVar);
        viewHolder.d();
        return view;
    }
}
