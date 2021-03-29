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
import d.b.i0.c2.k.g.e.a;
import d.b.i0.c2.k.g.f.b;
/* loaded from: classes5.dex */
public class SubPbReplyAdapter extends a<b, SubPbReplyViewHolder> {

    /* loaded from: classes5.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f19953a;

        /* renamed from: b  reason: collision with root package name */
        public View f19954b;

        /* renamed from: c  reason: collision with root package name */
        public int f19955c;

        public SubPbReplyViewHolder(View view) {
            super(view);
            this.f19955c = 3;
            this.f19953a = (TextView) view.findViewById(R.id.floor_reply_text);
            this.f19954b = view.findViewById(R.id.floor_reply_top_line);
        }

        public void c() {
            if (this.f19955c != TbadkApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f19953a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19954b, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f19953a, R.color.CAM_X0201);
            }
            this.f19955c = TbadkApplication.getInst().getSkinType();
        }
    }

    public SubPbReplyAdapter(d.b.i0.c2.k.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public SubPbReplyViewHolder R(ViewGroup viewGroup) {
        return new SubPbReplyViewHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        ((SubPbReplyViewHolder) this.k).f19953a.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.a())));
        ((SubPbReplyViewHolder) this.k).c();
        return subPbReplyViewHolder.a();
    }
}
