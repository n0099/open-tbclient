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
import d.b.i0.d2.k.g.e.a;
import d.b.i0.d2.k.g.f.b;
/* loaded from: classes3.dex */
public class SubPbReplyAdapter extends a<b, SubPbReplyViewHolder> {

    /* loaded from: classes3.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f19638a;

        /* renamed from: b  reason: collision with root package name */
        public View f19639b;

        /* renamed from: c  reason: collision with root package name */
        public int f19640c;

        public SubPbReplyViewHolder(View view) {
            super(view);
            this.f19640c = 3;
            this.f19638a = (TextView) view.findViewById(R.id.floor_reply_text);
            this.f19639b = view.findViewById(R.id.floor_reply_top_line);
        }

        public void c() {
            if (this.f19640c != TbadkApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f19638a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19639b, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f19638a, R.color.CAM_X0201);
            }
            this.f19640c = TbadkApplication.getInst().getSkinType();
        }
    }

    public SubPbReplyAdapter(d.b.i0.d2.k.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public SubPbReplyViewHolder R(ViewGroup viewGroup) {
        return new SubPbReplyViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        ((SubPbReplyViewHolder) this.k).f19638a.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.a())));
        ((SubPbReplyViewHolder) this.k).c();
        return subPbReplyViewHolder.a();
    }
}
