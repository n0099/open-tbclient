package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class an extends o<com.baidu.tieba.pb.data.l, com.baidu.tieba.pb.pb.a.b> {
    public an(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public com.baidu.tieba.pb.pb.a.b c(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, com.baidu.tieba.pb.pb.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) bVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        bVar.mTextView.setText(lVar.kGw);
        if (lVar.kGv != 0) {
            com.baidu.tbadk.core.util.ap.setImageResource(bVar.mImageView, lVar.kGv);
        } else {
            com.baidu.tbadk.core.util.ap.setImageResource(bVar.mImageView, R.drawable.new_pic_emotion_06);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(bVar.mTextView, R.color.cp_cont_d);
        if (lVar.fHA != 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = lVar.fHA;
        }
        if (lVar.kGx != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.mImageView.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.kGx, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (lVar.kGy != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) bVar.mTextView.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.leftMargin, marginLayoutParams2.rightMargin, lVar.kGy);
        }
        return view;
    }
}
