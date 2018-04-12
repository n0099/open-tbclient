package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class af extends k<ac, ae> {
    /* JADX INFO: Access modifiers changed from: protected */
    public af(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public ae onCreateViewHolder(ViewGroup viewGroup) {
        return new ae(this.fgM.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ac acVar, ae aeVar) {
        super.onFillViewHolder(i, view2, viewGroup, acVar, aeVar);
        if (acVar != null) {
            aeVar.a(acVar);
            aeVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view2;
    }
}
