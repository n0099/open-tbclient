package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class c extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.person.b.c> {
    private View.OnClickListener bkE;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cx */
    public com.baidu.tieba.person.b.c b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.person.b.c cVar) {
        if (cVar == null || mVar == null) {
            return null;
        }
        cVar.F(this.bkE);
        cVar.h(mVar);
        return cVar.getView();
    }

    public void F(View.OnClickListener onClickListener) {
        this.bkE = onClickListener;
    }
}
