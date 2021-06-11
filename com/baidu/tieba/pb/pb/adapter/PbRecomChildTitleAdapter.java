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
/* loaded from: classes5.dex */
public class PbRecomChildTitleAdapter extends o<e, ViewHolder> {

    /* loaded from: classes5.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f18914a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18915b;

        /* renamed from: c  reason: collision with root package name */
        public View f18916c;

        public ViewHolder(View view) {
            super(view);
            this.f18914a = 3;
            c(view);
        }

        public void b(e eVar) {
            this.f18915b.setText(eVar.f67217e);
        }

        public final void c(View view) {
            this.f18915b = (TextView) view.findViewById(R.id.tv_title);
            this.f18916c = view.findViewById(R.id.title_top_line);
            c.d(this.f18915b).x(R.string.F_X02);
        }

        public void d() {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f18914a != skinType) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f18916c, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.f18915b, R.color.CAM_X0105);
                this.f18914a = skinType;
            }
        }
    }

    public PbRecomChildTitleAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (e) obj, (ViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ViewHolder Q(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.pb_reclist_title, viewGroup, false));
    }

    public View i0(int i2, View view, ViewGroup viewGroup, e eVar, ViewHolder viewHolder) {
        super.X(i2, view, viewGroup, eVar, viewHolder);
        viewHolder.b(eVar);
        viewHolder.d();
        return view;
    }
}
