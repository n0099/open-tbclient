package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ae extends m<com.baidu.tbadk.core.data.as, af> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ae(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public af onCreateViewHolder(ViewGroup viewGroup) {
        return new af(this.eMB.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, af afVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, afVar);
        if (asVar != null) {
            afVar.a(asVar);
        }
        return view;
    }
}
