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
import d.a.j0.r.u.c;
import d.a.k0.d2.k.e.o;
import d.a.k0.d2.o.i;
import d.a.k0.x.f0.e;
/* loaded from: classes4.dex */
public class PbRecomChildTitleAdapter extends o<e, ViewHolder> {

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f18923a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18924b;

        /* renamed from: c  reason: collision with root package name */
        public View f18925c;

        public ViewHolder(View view) {
            super(view);
            this.f18923a = 3;
            c(view);
        }

        public void b(e eVar) {
            this.f18924b.setText(eVar.f63219e);
        }

        public final void c(View view) {
            this.f18924b = (TextView) view.findViewById(R.id.tv_title);
            this.f18925c = view.findViewById(R.id.title_top_line);
            c.d(this.f18924b).v(R.string.F_X02);
        }

        public void d() {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f18923a != skinType) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f18925c, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.f18924b, R.color.CAM_X0105);
                this.f18923a = skinType;
            }
        }
    }

    public PbRecomChildTitleAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.a.k0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, (e) obj, (ViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ViewHolder P(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.pb_reclist_title, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, e eVar, ViewHolder viewHolder) {
        super.W(i2, view, viewGroup, eVar, viewHolder);
        viewHolder.b(eVar);
        viewHolder.d();
        return view;
    }
}
