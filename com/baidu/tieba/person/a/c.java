package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.widget.ListView.a<o, PersonInfoUserPicViewHolder> {
    private View.OnClickListener bGM;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cP */
    public PersonInfoUserPicViewHolder e(ViewGroup viewGroup) {
        return new PersonInfoUserPicViewHolder(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, PersonInfoUserPicViewHolder personInfoUserPicViewHolder) {
        if (personInfoUserPicViewHolder == null || oVar == null) {
            return null;
        }
        personInfoUserPicViewHolder.H(this.bGM);
        personInfoUserPicViewHolder.h(oVar);
        return personInfoUserPicViewHolder.getView();
    }

    public void H(View.OnClickListener onClickListener) {
        this.bGM = onClickListener;
    }
}
