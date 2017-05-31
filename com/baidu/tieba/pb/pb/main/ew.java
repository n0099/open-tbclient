package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ew extends dn<es, eu> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ew(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public eu onCreateViewHolder(ViewGroup viewGroup) {
        return new eu(this.elf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, es esVar, eu euVar) {
        super.onFillViewHolder(i, view, viewGroup, esVar, euVar);
        if (esVar != null) {
            euVar.a(esVar);
            euVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }
}
