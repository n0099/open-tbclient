package com.baidu.tieba.pb.pb.sub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.j0.d2.k.g.e.a;
import d.b.j0.d2.k.g.f.b;
/* loaded from: classes3.dex */
public class SubPbReplyAdapter extends a<b, SubPbReplyViewHolder> {

    /* loaded from: classes3.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f19646a;

        /* renamed from: b  reason: collision with root package name */
        public View f19647b;

        /* renamed from: c  reason: collision with root package name */
        public int f19648c;

        public SubPbReplyViewHolder(View view) {
            super(view);
            this.f19648c = 3;
            this.f19646a = (TextView) view.findViewById(R.id.floor_reply_text);
            this.f19647b = view.findViewById(R.id.floor_reply_top_line);
        }

        public void c() {
            if (this.f19648c != TbadkApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f19646a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19647b, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f19646a, R.color.CAM_X0201);
            }
            this.f19648c = TbadkApplication.getInst().getSkinType();
        }
    }

    public SubPbReplyAdapter(d.b.j0.d2.k.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public SubPbReplyViewHolder R(ViewGroup viewGroup) {
        return new SubPbReplyViewHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        ((SubPbReplyViewHolder) this.k).f19646a.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.a())));
        ((SubPbReplyViewHolder) this.k).c();
        return subPbReplyViewHolder.a();
    }
}
