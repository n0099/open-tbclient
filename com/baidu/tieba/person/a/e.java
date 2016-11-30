package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.a.a<g, com.baidu.tieba.person.holder.e> {
    private TbPageContext GO;
    private View.OnClickListener eKi;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public com.baidu.tieba.person.holder.e a(ViewGroup viewGroup) {
        com.baidu.tieba.person.holder.e eVar = new com.baidu.tieba.person.holder.e(LayoutInflater.from(this.mContext).inflate(r.h.person_info_user_pics_layout, viewGroup, false), this.GO);
        eVar.eLo.setItemOnclickListener(this.eKi);
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.person.holder.e eVar) {
        if (gVar != null && eVar != null) {
            eVar.aUT();
            eVar.a(gVar);
        }
        return view;
    }

    public void K(View.OnClickListener onClickListener) {
        this.eKi = onClickListener;
    }
}
