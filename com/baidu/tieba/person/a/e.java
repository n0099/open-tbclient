package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.a.a<g, com.baidu.tieba.person.b.d> {
    private TbPageContext ajT;
    private View.OnClickListener ezz;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public com.baidu.tieba.person.b.d onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.d dVar = new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(w.j.person_info_user_pics_layout, viewGroup, false), this.ajT);
        dVar.eAi.setItemOnclickListener(this.ezz);
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.person.b.d dVar) {
        if (gVar != null && dVar != null) {
            dVar.aQp();
            dVar.a(gVar);
        }
        return view;
    }

    public void J(View.OnClickListener onClickListener) {
        this.ezz = onClickListener;
    }
}
