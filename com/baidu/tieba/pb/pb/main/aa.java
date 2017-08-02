package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aa extends l<com.baidu.tieba.pb.data.i, com.baidu.tieba.pb.pb.a.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    public aa(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public com.baidu.tieba.pb.pb.a.e onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.e(LayoutInflater.from(this.mContext).inflate(d.j.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, com.baidu.tieba.pb.pb.a.e eVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, eVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.eFn.getLayoutMode().ah(this.mSkinType == 1);
        this.eFn.getLayoutMode().t(view);
        return view;
    }
}
