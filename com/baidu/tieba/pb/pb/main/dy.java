package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dy extends db<com.baidu.tieba.pb.data.f, com.baidu.tieba.pb.pb.a.j> {
    /* JADX INFO: Access modifiers changed from: protected */
    public dy(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public com.baidu.tieba.pb.pb.a.j b(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.j(LayoutInflater.from(this.mContext).inflate(t.h.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.f fVar, com.baidu.tieba.pb.pb.a.j jVar) {
        super.a(i, view, viewGroup, (ViewGroup) fVar, (com.baidu.tieba.pb.data.f) jVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.dfw.getLayoutMode().ab(this.mSkinType == 1);
        this.dfw.getLayoutMode().x(view);
        return view;
    }
}
