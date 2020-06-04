package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class aj extends m<com.baidu.tieba.pb.data.j, com.baidu.tieba.pb.pb.a.b> {
    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public com.baidu.tieba.pb.pb.a.b b(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, com.baidu.tieba.pb.pb.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) bVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        bVar.mTextView.setText(jVar.jGj);
        com.baidu.tbadk.core.util.am.setImageResource(bVar.mImageView, R.drawable.new_pic_emotion_06);
        com.baidu.tbadk.core.util.am.setViewTextColor(bVar.mTextView, (int) R.color.cp_cont_d);
        return view;
    }
}
