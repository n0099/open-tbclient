package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.a, com.baidu.tieba.person.holder.c> {
    private TbPageContext ajF;
    private View.OnClickListener eBq;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public com.baidu.tieba.person.holder.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.c(LayoutInflater.from(this.ajF.getPageActivity()).inflate(w.j.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.a aVar, com.baidu.tieba.person.holder.c cVar) {
        if (cVar == null || aVar == null) {
            return null;
        }
        cVar.u(this.eBq);
        cVar.e(aVar);
        return cVar.getView();
    }

    public void u(View.OnClickListener onClickListener) {
        this.eBq = onClickListener;
    }
}
