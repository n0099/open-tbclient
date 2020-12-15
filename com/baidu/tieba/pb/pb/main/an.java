package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class an extends o<com.baidu.tieba.pb.data.l, com.baidu.tieba.pb.pb.a.b> {
    public an(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cm */
    public com.baidu.tieba.pb.pb.a.b c(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, com.baidu.tieba.pb.pb.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) bVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        bVar.mTextView.setText(lVar.lBV);
        if (lVar.lBU != 0) {
            com.baidu.tbadk.core.util.ap.setImageResource(bVar.mImageView, lVar.lBU);
        } else {
            com.baidu.tbadk.core.util.ap.setImageResource(bVar.mImageView, R.drawable.new_pic_emotion_06);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(bVar.mTextView, R.color.CAM_X0109);
        if (lVar.grv != 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = lVar.grv;
        }
        if (lVar.lBW != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.mImageView.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.lBW, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (lVar.lBX != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) bVar.mTextView.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.leftMargin, marginLayoutParams2.rightMargin, lVar.lBX);
        }
        bVar.mImageView.setVisibility(lVar.lBY);
        return view;
    }
}
