package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.a.a<e, com.baidu.tieba.person.b.c> {
    private TbPageContext ajr;
    private View.OnClickListener exP;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public com.baidu.tieba.person.b.c onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.c cVar = new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mContext).inflate(w.j.person_info_user_pics_layout, viewGroup, false), this.ajr);
        cVar.eyl.setItemOnclickListener(this.exP);
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, com.baidu.tieba.person.b.c cVar) {
        if (eVar != null && cVar != null) {
            cVar.aOH();
            cVar.a(eVar);
        }
        return view;
    }

    public void K(View.OnClickListener onClickListener) {
        this.exP = onClickListener;
    }
}
