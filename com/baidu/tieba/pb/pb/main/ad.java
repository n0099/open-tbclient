package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.au;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ad extends l<au, ae> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ad(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public ae onCreateViewHolder(ViewGroup viewGroup) {
        return new ae(this.eGQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, au auVar, ae aeVar) {
        super.onFillViewHolder(i, view, viewGroup, auVar, aeVar);
        if (auVar != null) {
            aeVar.a(auVar);
        }
        return view;
    }
}
