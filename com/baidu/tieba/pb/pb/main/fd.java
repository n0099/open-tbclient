package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fd extends dn<com.baidu.tbadk.core.data.au, fe> {
    /* JADX INFO: Access modifiers changed from: protected */
    public fd(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public fe onCreateViewHolder(ViewGroup viewGroup) {
        return new fe(this.elf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.au auVar, fe feVar) {
        super.onFillViewHolder(i, view, viewGroup, auVar, feVar);
        if (auVar != null) {
            feVar.a(auVar);
        }
        return view;
    }
}
