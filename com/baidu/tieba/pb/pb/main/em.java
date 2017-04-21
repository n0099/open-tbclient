package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class em extends cx<com.baidu.tbadk.core.data.as, en> {
    /* JADX INFO: Access modifiers changed from: protected */
    public em(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public en onCreateViewHolder(ViewGroup viewGroup) {
        return new en(this.ekw.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cx, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, en enVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, enVar);
        if (asVar != null) {
            enVar.a(asVar);
        }
        return view;
    }
}
