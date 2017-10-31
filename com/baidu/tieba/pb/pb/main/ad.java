package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ad extends m<aa, ac> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ad(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public ac onCreateViewHolder(ViewGroup viewGroup) {
        return new ac(this.eMh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, aa aaVar, ac acVar) {
        super.onFillViewHolder(i, view, viewGroup, aaVar, acVar);
        if (aaVar != null) {
            acVar.a(aaVar);
            acVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }
}
