package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class cg extends cl<com.baidu.tieba.tbadkCore.data.q, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cg(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public PbRecBaseViewHolder b(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aEE().j(this.mContext, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aG(i);
        this.cNL.getLayoutMode().ac(this.mSkinType == 1);
        this.cNL.getLayoutMode().x(view);
        pbRecBaseViewHolder.update(qVar2, i, this.mIsFromCDN);
        return view;
    }
}
