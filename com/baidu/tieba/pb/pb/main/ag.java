package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ag extends k<com.baidu.tbadk.core.data.ao, ah> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ag(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public ah onCreateViewHolder(ViewGroup viewGroup) {
        return new ah(this.fNg.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ao aoVar, ah ahVar) {
        super.onFillViewHolder(i, view, viewGroup, aoVar, ahVar);
        if (aoVar != null) {
            ahVar.a(aoVar);
        }
        return view;
    }
}
