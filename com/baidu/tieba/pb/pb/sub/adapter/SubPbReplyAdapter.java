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
import d.a.n0.e2.k.g.e.a;
import d.a.n0.e2.k.g.f.b;
/* loaded from: classes5.dex */
public class SubPbReplyAdapter extends a<b, SubPbReplyViewHolder> {

    /* loaded from: classes5.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f19415a;

        /* renamed from: b  reason: collision with root package name */
        public View f19416b;

        /* renamed from: c  reason: collision with root package name */
        public int f19417c;

        public SubPbReplyViewHolder(View view) {
            super(view);
            this.f19417c = 3;
            this.f19415a = (TextView) view.findViewById(R.id.floor_reply_text);
            this.f19416b = view.findViewById(R.id.floor_reply_top_line);
        }

        public void c() {
            if (this.f19417c != TbadkApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f19415a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19416b, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f19415a, R.color.CAM_X0201);
            }
            this.f19417c = TbadkApplication.getInst().getSkinType();
        }
    }

    public SubPbReplyAdapter(d.a.n0.e2.k.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public SubPbReplyViewHolder Q(ViewGroup viewGroup) {
        return new SubPbReplyViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        ((SubPbReplyViewHolder) this.k).f19415a.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.b())));
        ((SubPbReplyViewHolder) this.k).c();
        return subPbReplyViewHolder.a();
    }
}
