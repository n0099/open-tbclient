package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.b, com.baidu.tieba.person.b.a> {
    private View.OnClickListener aRW;
    private TbPageContext bID;
    private com.baidu.tieba.person.data.b ezx;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aRW = new c(this);
        this.bID = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public com.baidu.tieba.person.b.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.a aVar = new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(w.j.personinfo_book_shelf, viewGroup, false));
        aVar.onChangeSkinType(this.bID, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.b.a aVar) {
        a(aVar, bVar);
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null && aVar != null && this.bID != null) {
            this.ezx = bVar;
            aVar.ezZ.setText(bVar.ezP);
            if (bVar.ezT > 0) {
                aVar.eAa.setText(String.valueOf(bVar.ezT));
            } else if (!StringUtils.isNull(bVar.ezS)) {
                aVar.eAa.setText(bVar.ezS);
            }
            aVar.ezX.setOnClickListener(this.aRW);
            aVar.onChangeSkinType(this.bID, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }
}
