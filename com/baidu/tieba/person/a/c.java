package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.person.b.c> {
    private View.OnClickListener baf;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public com.baidu.tieba.person.b.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(d.j.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.person.b.c cVar) {
        if (cVar == null || jVar == null) {
            return null;
        }
        cVar.p(this.baf);
        cVar.c(jVar);
        return cVar.getView();
    }

    public void p(View.OnClickListener onClickListener) {
        this.baf = onClickListener;
    }
}
