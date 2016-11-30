package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.l, com.baidu.tieba.person.holder.d> {
    private View.OnClickListener eKf;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public com.baidu.tieba.person.holder.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.d(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(r.h.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.l lVar, com.baidu.tieba.person.holder.d dVar) {
        if (dVar == null || lVar == null) {
            return null;
        }
        dVar.x(this.eKf);
        dVar.d(lVar);
        return dVar.getView();
    }

    public void x(View.OnClickListener onClickListener) {
        this.eKf = onClickListener;
    }
}
