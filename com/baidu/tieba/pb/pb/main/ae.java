package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ae extends k<com.baidu.tieba.pb.data.g, com.baidu.tieba.pb.pb.a.c> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ae(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public com.baidu.tieba.pb.pb.a.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.c(LayoutInflater.from(this.mContext).inflate(d.h.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.g gVar, com.baidu.tieba.pb.pb.a.c cVar) {
        super.onFillViewHolder(i, view, viewGroup, gVar, cVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        cVar.mTextView.setText(gVar.hkt);
        com.baidu.tbadk.core.util.al.c(cVar.cyi, d.f.pic_emotion_gray_03);
        com.baidu.tbadk.core.util.al.j(cVar.mTextView, d.C0277d.cp_cont_d);
        return view;
    }
}
