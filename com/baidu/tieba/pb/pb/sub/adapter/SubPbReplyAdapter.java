package com.baidu.tieba.pb.pb.sub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class SubPbReplyAdapter extends a<com.baidu.tieba.pb.pb.sub.a.b, SubPbReplyViewHolder> {
    public SubPbReplyAdapter(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cG */
    public SubPbReplyViewHolder e(ViewGroup viewGroup) {
        return new SubPbReplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.adapter.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.pb.sub.a.b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        ((SubPbReplyViewHolder) this.Wu).mdM.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.getReplyNum())));
        ((SubPbReplyViewHolder) this.Wu).onChangeSkinType();
        return subPbReplyViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {
        private View iwu;
        private int mSkinType;
        private TextView mdM;

        public SubPbReplyViewHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mdM = (TextView) view.findViewById(R.id.floor_reply_text);
            this.iwu = view.findViewById(R.id.floor_reply_top_line);
        }

        public void onChangeSkinType() {
            if (this.mSkinType != TbadkApplication.getInst().getSkinType()) {
                ao.setViewTextColor(this.mdM, R.color.CAM_X0105);
                ao.setBackgroundColor(this.iwu, R.color.CAM_X0204);
                ao.setBackgroundColor(this.mdM, R.color.CAM_X0201);
            }
            this.mSkinType = TbadkApplication.getInst().getSkinType();
        }
    }
}
