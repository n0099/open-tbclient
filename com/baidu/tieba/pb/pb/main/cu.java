package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class cu extends db<com.baidu.tieba.tbadkCore.data.r, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cu(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public PbRecBaseViewHolder b(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aLw().m(this.mContext, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) aF(i);
        this.dfw.getLayoutMode().ab(this.mSkinType == 1);
        this.dfw.getLayoutMode().x(view);
        pbRecBaseViewHolder.update(rVar2, i, this.mIsFromCDN);
        return view;
    }
}
