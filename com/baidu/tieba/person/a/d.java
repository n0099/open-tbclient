package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.b.d<f, com.baidu.tieba.person.b.d> {
    private View.OnClickListener hKf;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public com.baidu.tieba.person.b.d onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.d dVar = new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(d.h.person_info_user_pics_layout, viewGroup, false), this.mPageContext);
        dVar.hKH.setItemOnclickListener(this.hKf);
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.person.b.d dVar) {
        if (fVar != null && dVar != null) {
            dVar.ank();
            dVar.a(fVar);
        }
        return view;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hKf = onClickListener;
    }
}
