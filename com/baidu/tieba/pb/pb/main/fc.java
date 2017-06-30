package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fc extends du<com.baidu.tieba.pb.data.i, com.baidu.tieba.pb.pb.a.g> {
    /* JADX INFO: Access modifiers changed from: protected */
    public fc(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public com.baidu.tieba.pb.pb.a.g onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.g(LayoutInflater.from(this.mContext).inflate(w.j.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, com.baidu.tieba.pb.pb.a.g gVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, gVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.euf.getLayoutMode().ah(this.mSkinType == 1);
        this.euf.getLayoutMode().t(view);
        return view;
    }
}
