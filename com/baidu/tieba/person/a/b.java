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
    private View.OnClickListener aRY;
    private TbPageContext bKU;
    private com.baidu.tieba.person.data.b eBN;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aRY = new c(this);
        this.bKU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public com.baidu.tieba.person.b.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.a aVar = new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(w.j.personinfo_book_shelf, viewGroup, false));
        aVar.onChangeSkinType(this.bKU, TbadkCoreApplication.m9getInst().getSkinType());
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
        if (bVar != null && aVar != null && this.bKU != null) {
            this.eBN = bVar;
            aVar.eCp.setText(bVar.eCf);
            if (bVar.eCj > 0) {
                aVar.eCq.setText(String.valueOf(bVar.eCj));
            } else if (!StringUtils.isNull(bVar.eCi)) {
                aVar.eCq.setText(bVar.eCi);
            }
            aVar.eCn.setOnClickListener(this.aRY);
            aVar.onChangeSkinType(this.bKU, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }
}
