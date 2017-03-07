package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.a.a<g, com.baidu.tieba.person.holder.e> {
    private TbPageContext ajF;
    private View.OnClickListener eBt;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public com.baidu.tieba.person.holder.e onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.person.holder.e eVar = new com.baidu.tieba.person.holder.e(LayoutInflater.from(this.mContext).inflate(w.j.person_info_user_pics_layout, viewGroup, false), this.ajF);
        eVar.eCn.setItemOnclickListener(this.eBt);
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.person.holder.e eVar) {
        if (gVar != null && eVar != null) {
            eVar.aQg();
            eVar.a(gVar);
        }
        return view;
    }

    public void I(View.OnClickListener onClickListener) {
        this.eBt = onClickListener;
    }
}
