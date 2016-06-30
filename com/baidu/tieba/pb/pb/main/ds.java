package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ds extends cr<com.baidu.tieba.pb.data.l, com.baidu.tieba.pb.pb.a.d> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ds(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public com.baidu.tieba.pb.pb.a.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.d(LayoutInflater.from(this.mContext).inflate(u.h.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, com.baidu.tieba.pb.pb.a.d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) dVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dOg.getLayoutMode().ad(this.mSkinType == 1);
        this.dOg.getLayoutMode().w(view);
        return view;
    }
}
