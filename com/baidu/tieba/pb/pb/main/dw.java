package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class dw extends da<com.baidu.tieba.pb.data.i, com.baidu.tieba.pb.pb.a.c> {
    /* JADX INFO: Access modifiers changed from: protected */
    public dw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public com.baidu.tieba.pb.pb.a.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.c(LayoutInflater.from(this.mContext).inflate(r.j.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, com.baidu.tieba.pb.pb.a.c cVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, cVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.ehi.getLayoutMode().ai(this.mSkinType == 1);
        this.ehi.getLayoutMode().v(view);
        return view;
    }
}
