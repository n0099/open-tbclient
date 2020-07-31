package com.baidu.tieba.pb.pb.sub.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.pb.pb.sub.a.a<com.baidu.tieba.pb.pb.sub.b.b, a> {
    public d(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.pb.sub.b.b bVar, a aVar) {
        ((a) this.Uj).kEa.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.getReplyNum())));
        ((a) this.Uj).onChangeSkinType();
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private View gXm;
        private TextView kEa;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.kEa = (TextView) view.findViewById(R.id.floor_reply_text);
            this.gXm = view.findViewById(R.id.floor_reply_top_line);
        }

        public void onChangeSkinType() {
            if (this.mSkinType != TbadkApplication.getInst().getSkinType()) {
                ao.setViewTextColor(this.kEa, R.color.cp_cont_b);
                ao.setBackgroundColor(this.gXm, R.color.cp_bg_line_c);
                ao.setBackgroundColor(this.kEa, R.color.cp_bg_line_d);
            }
            this.mSkinType = TbadkApplication.getInst().getSkinType();
        }
    }
}
