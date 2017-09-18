package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.person.b.b> {
    private View.OnClickListener aYG;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public com.baidu.tieba.person.b.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(d.j.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.person.b.b bVar) {
        if (bVar == null || kVar == null) {
            return null;
        }
        bVar.p(this.aYG);
        bVar.c(kVar);
        return bVar.getView();
    }

    public void p(View.OnClickListener onClickListener) {
        this.aYG = onClickListener;
    }
}
