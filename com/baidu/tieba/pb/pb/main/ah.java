package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class ah extends k<com.baidu.tbadk.core.data.ao, ai> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public ai onCreateViewHolder(ViewGroup viewGroup) {
        return new ai(this.fME.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ao aoVar, ai aiVar) {
        super.onFillViewHolder(i, view, viewGroup, aoVar, aiVar);
        if (aoVar != null) {
            aiVar.a(aoVar);
        }
        return view;
    }
}
