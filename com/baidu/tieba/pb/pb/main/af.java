package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class af extends m<com.baidu.tieba.pb.data.j, com.baidu.tieba.pb.pb.a.c> {
    /* JADX INFO: Access modifiers changed from: protected */
    public af(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.pb.pb.a.c b(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.c(LayoutInflater.from(this.mContext).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, com.baidu.tieba.pb.pb.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) cVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        cVar.mTextView.setText(jVar.ixd);
        com.baidu.tbadk.core.util.am.setImageResource(cVar.mImageView, R.drawable.new_pic_emotion_06);
        com.baidu.tbadk.core.util.am.setViewTextColor(cVar.mTextView, (int) R.color.cp_cont_d);
        return view;
    }
}
