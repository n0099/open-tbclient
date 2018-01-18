package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ag extends m<ad, af> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ag(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public af onCreateViewHolder(ViewGroup viewGroup) {
        return new af(this.fJw.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ad adVar, af afVar) {
        super.onFillViewHolder(i, view, viewGroup, adVar, afVar);
        if (adVar != null) {
            afVar.a(adVar);
            afVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }
}
