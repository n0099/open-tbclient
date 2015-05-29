package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bl extends bn<com.baidu.tieba.tbadkCore.data.i, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public bl(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.ahh().k(this.mContext, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.i iVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.tbadkCore.data.i) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) ay(i);
        this.bKZ.getLayoutMode().ab(this.mSkinType == 1);
        this.bKZ.getLayoutMode().j(view);
        pbRecBaseViewHolder.update(iVar2, i, this.mIsFromCDN);
        return view;
    }
}
