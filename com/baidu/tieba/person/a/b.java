package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.c, PersonInfoAddUserPicViewHolder> {
    private View.OnClickListener bDc;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cN */
    public PersonInfoAddUserPicViewHolder e(ViewGroup viewGroup) {
        return new PersonInfoAddUserPicViewHolder(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, PersonInfoAddUserPicViewHolder personInfoAddUserPicViewHolder) {
        if (personInfoAddUserPicViewHolder == null || cVar == null) {
            return null;
        }
        personInfoAddUserPicViewHolder.H(this.bDc);
        personInfoAddUserPicViewHolder.h(cVar);
        return personInfoAddUserPicViewHolder.getView();
    }

    public void H(View.OnClickListener onClickListener) {
        this.bDc = onClickListener;
    }
}
