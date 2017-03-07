package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class eo extends cz<com.baidu.tbadk.core.data.at, ep> {
    /* JADX INFO: Access modifiers changed from: protected */
    public eo(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public ep onCreateViewHolder(ViewGroup viewGroup) {
        return new ep(this.eka.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, ep epVar) {
        super.onFillViewHolder(i, view, viewGroup, atVar, epVar);
        if (atVar != null) {
            epVar.a(atVar);
        }
        return view;
    }
}
