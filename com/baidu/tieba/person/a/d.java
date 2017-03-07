package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.k, com.baidu.tieba.person.holder.d> {
    private View.OnClickListener eBq;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public com.baidu.tieba.person.holder.d onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.d(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(w.j.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.k kVar, com.baidu.tieba.person.holder.d dVar) {
        if (dVar == null || kVar == null) {
            return null;
        }
        dVar.u(this.eBq);
        dVar.e(kVar);
        return dVar.getView();
    }

    public void u(View.OnClickListener onClickListener) {
        this.eBq = onClickListener;
    }
}
