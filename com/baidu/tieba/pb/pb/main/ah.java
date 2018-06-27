package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ah extends k<com.baidu.tbadk.core.data.ap, ai> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public ai onCreateViewHolder(ViewGroup viewGroup) {
        return new ai(this.fxh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ap apVar, ai aiVar) {
        super.onFillViewHolder(i, view, viewGroup, apVar, aiVar);
        if (apVar != null) {
            aiVar.a(apVar);
        }
        return view;
    }
}
