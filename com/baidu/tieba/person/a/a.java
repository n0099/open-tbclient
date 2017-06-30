package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.a, com.baidu.tieba.person.b.a> {
    private TbPageContext ajP;
    private View.OnClickListener bKg;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public com.baidu.tieba.person.b.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.ajP.getPageActivity()).inflate(w.j.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.a aVar, com.baidu.tieba.person.b.a aVar2) {
        if (aVar2 == null || aVar == null) {
            return null;
        }
        aVar2.v(this.bKg);
        aVar2.f(aVar);
        return aVar2.getView();
    }

    public void v(View.OnClickListener onClickListener) {
        this.bKg = onClickListener;
    }
}
