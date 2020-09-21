package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.b> {
    private View.OnClickListener bnA;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cx */
    public com.baidu.tieba.person.b.b c(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.b bVar) {
        if (bVar == null || cVar == null) {
            return null;
        }
        bVar.F(this.bnA);
        bVar.h(cVar);
        return bVar.getView();
    }

    public void F(View.OnClickListener onClickListener) {
        this.bnA = onClickListener;
    }
}
