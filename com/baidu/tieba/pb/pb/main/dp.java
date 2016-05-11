package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dp extends cm<com.baidu.tieba.pb.data.g, com.baidu.tieba.pb.pb.a.j> {
    /* JADX INFO: Access modifiers changed from: protected */
    public dp(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.pb.pb.a.j b(ViewGroup viewGroup) {
        return new com.baidu.tieba.pb.pb.a.j(LayoutInflater.from(this.mContext).inflate(t.h.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.g gVar, com.baidu.tieba.pb.pb.a.j jVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.pb.data.g) jVar);
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.dhY.getLayoutMode().ae(this.mSkinType == 1);
        this.dhY.getLayoutMode().x(view);
        return view;
    }
}
