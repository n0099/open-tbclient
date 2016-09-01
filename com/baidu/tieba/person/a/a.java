package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.a, com.baidu.tieba.person.holder.c> {
    private TbPageContext GM;
    private View.OnClickListener eBD;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public com.baidu.tieba.person.holder.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.c(LayoutInflater.from(this.GM.getPageActivity()).inflate(t.h.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.a aVar, com.baidu.tieba.person.holder.c cVar) {
        if (cVar == null || aVar == null) {
            return null;
        }
        cVar.H(this.eBD);
        cVar.c(aVar);
        return cVar.getView();
    }

    public void H(View.OnClickListener onClickListener) {
        this.eBD = onClickListener;
    }
}
