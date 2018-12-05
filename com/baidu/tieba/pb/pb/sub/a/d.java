package com.baidu.tieba.pb.pb.sub.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.pb.pb.sub.a.a<com.baidu.tieba.pb.pb.sub.b.b, a> {
    public d(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.pb.sub.b.b bVar, a aVar) {
        ((a) this.viewholder).gjC.setText(String.format(TbadkApplication.getInst().getString(e.j.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.getReplyNum())));
        ((a) this.viewholder).onChangeSkinType();
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private View cVt;
        private TextView gjC;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.gjC = (TextView) view.findViewById(e.g.floor_reply_text);
            this.cVt = view.findViewById(e.g.floor_reply_top_line);
        }

        public void onChangeSkinType() {
            if (this.mSkinType != TbadkApplication.getInst().getSkinType()) {
                al.h(this.gjC, e.d.cp_cont_b);
                al.j(this.cVt, e.d.cp_bg_line_e);
                al.j(this.gjC, e.d.cp_bg_line_d);
            }
            this.mSkinType = TbadkApplication.getInst().getSkinType();
        }
    }
}
