package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class dt extends cs<com.baidu.tieba.pb.data.m, com.baidu.tieba.pb.pb.a.d> {
    /* JADX INFO: Access modifiers changed from: protected */
    public dt(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public com.baidu.tieba.pb.pb.a.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.d(LayoutInflater.from(this.mContext).inflate(r.h.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, com.baidu.tieba.pb.pb.a.d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tieba.pb.data.m) dVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.eow.getLayoutMode().ah(this.mSkinType == 1);
        this.eow.getLayoutMode().x(view);
        return view;
    }
}
