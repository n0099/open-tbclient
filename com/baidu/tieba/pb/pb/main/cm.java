package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cm extends cs<com.baidu.tieba.tbadkCore.data.r, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cm(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aXW().n(this.mContext, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.eat.getLayoutMode().af(this.mSkinType == 1);
        this.eat.getLayoutMode().w(view);
        if (pbRecBaseViewHolder.getRootView() != null) {
            com.baidu.tbadk.core.util.av.l(pbRecBaseViewHolder.getRootView(), u.d.cp_bg_line_d);
        }
        pbRecBaseViewHolder.update((com.baidu.tieba.tbadkCore.data.r) aw(i), i, this.mIsFromCDN);
        return view;
    }
}
