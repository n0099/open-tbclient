package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.a.a<g, com.baidu.tieba.person.holder.e> {
    private TbPageContext GM;
    private View.OnClickListener eBG;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public com.baidu.tieba.person.holder.e a(ViewGroup viewGroup) {
        com.baidu.tieba.person.holder.e eVar = new com.baidu.tieba.person.holder.e(LayoutInflater.from(this.mContext).inflate(t.h.person_info_user_pics_layout, viewGroup, false), this.GM);
        eVar.eCM.setItemOnclickListener(this.eBG);
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.person.holder.e eVar) {
        if (gVar != null && eVar != null) {
            eVar.aSo();
            eVar.a(gVar);
        }
        return view;
    }

    public void J(View.OnClickListener onClickListener) {
        this.eBG = onClickListener;
    }
}
