package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.person.b.c> {
    private View.OnClickListener cIn;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public com.baidu.tieba.person.b.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(f.h.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.person.b.c cVar) {
        if (cVar == null || jVar == null) {
            return null;
        }
        cVar.u(this.cIn);
        cVar.g(jVar);
        return cVar.getView();
    }

    public void u(View.OnClickListener onClickListener) {
        this.cIn = onClickListener;
    }
}
