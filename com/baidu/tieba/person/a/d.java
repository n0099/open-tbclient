package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoUserPicsHolder;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.adapter.a<f, PersonInfoUserPicsHolder> {
    private TbPageContext mPageContext;
    private View.OnClickListener msw;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cQ */
    public PersonInfoUserPicsHolder e(ViewGroup viewGroup) {
        PersonInfoUserPicsHolder personInfoUserPicsHolder = new PersonInfoUserPicsHolder(LayoutInflater.from(this.mContext).inflate(R.layout.person_info_user_pics_layout, viewGroup, false), this.mPageContext);
        personInfoUserPicsHolder.msX.setItemOnclickListener(this.msw);
        return personInfoUserPicsHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, PersonInfoUserPicsHolder personInfoUserPicsHolder) {
        if (fVar != null && personInfoUserPicsHolder != null) {
            personInfoUserPicsHolder.dwx();
            personInfoUserPicsHolder.a(fVar);
        }
        return view;
    }
}
