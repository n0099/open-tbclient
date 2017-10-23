package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.as;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ac extends k<as, ad> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ac(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public ad onCreateViewHolder(ViewGroup viewGroup) {
        return new ad(this.eDo.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, as asVar, ad adVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, adVar);
        if (asVar != null) {
            adVar.a(asVar);
        }
        return view;
    }
}
