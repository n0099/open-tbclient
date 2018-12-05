package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.person.b.c> {
    private View.OnClickListener dem;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mTbPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public com.baidu.tieba.person.b.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(e.h.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.person.b.c cVar) {
        if (cVar == null || kVar == null) {
            return null;
        }
        cVar.w(this.dem);
        cVar.g(kVar);
        return cVar.getView();
    }

    public void w(View.OnClickListener onClickListener) {
        this.dem = onClickListener;
    }
}
