package com.baidu.tieba.pb.pb.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.p;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<p, d> {
    public boolean alE;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alE = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        d dVar = new d(LayoutInflater.from(this.mContext).inflate(w.j.pb_declare_area, (ViewGroup) null), this.mContext);
        dVar.alE = this.alE;
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, p pVar, d dVar) {
        if (dVar != null) {
            dVar.a(pVar);
            return dVar.getView();
        }
        return view;
    }
}
