package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class eh extends cz<dw, ef> {
    /* JADX INFO: Access modifiers changed from: protected */
    public eh(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public ef onCreateViewHolder(ViewGroup viewGroup) {
        return new ef(this.eka.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, dw dwVar, ef efVar) {
        super.onFillViewHolder(i, view, viewGroup, dwVar, efVar);
        if (dwVar != null) {
            efVar.a(dwVar);
            efVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }
}
