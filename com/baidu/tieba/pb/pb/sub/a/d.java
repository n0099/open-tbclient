package com.baidu.tieba.pb.pb.sub.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.pb.pb.sub.a.a<com.baidu.tieba.pb.pb.sub.b.b, a> {
    public d(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cu */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.sub_pb_reply_num_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.pb.sub.b.b bVar, a aVar) {
        ((a) this.Wx).lYw.setText(String.format(TbadkApplication.getInst().getString(R.string.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.getReplyNum())));
        ((a) this.Wx).onChangeSkinType();
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private View ijX;
        private TextView lYw;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.lYw = (TextView) view.findViewById(R.id.floor_reply_text);
            this.ijX = view.findViewById(R.id.floor_reply_top_line);
        }

        public void onChangeSkinType() {
            if (this.mSkinType != TbadkApplication.getInst().getSkinType()) {
                ap.setViewTextColor(this.lYw, R.color.CAM_X0105);
                ap.setBackgroundColor(this.ijX, R.color.CAM_X0204);
                ap.setBackgroundColor(this.lYw, R.color.CAM_X0201);
            }
            this.mSkinType = TbadkApplication.getInst().getSkinType();
        }
    }
}
