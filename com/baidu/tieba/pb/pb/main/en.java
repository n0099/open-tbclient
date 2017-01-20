package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class en extends da<com.baidu.tbadk.core.data.ar, eo> {
    /* JADX INFO: Access modifiers changed from: protected */
    public en(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public eo onCreateViewHolder(ViewGroup viewGroup) {
        return new eo(this.ehi.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ar arVar, eo eoVar) {
        super.onFillViewHolder(i, view, viewGroup, arVar, eoVar);
        if (arVar != null) {
            eoVar.a(arVar);
        }
        return view;
    }
}
