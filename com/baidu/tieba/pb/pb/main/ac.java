package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ac extends l<z, ab> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ac(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public ab onCreateViewHolder(ViewGroup viewGroup) {
        return new ab(this.eFn.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, z zVar, ab abVar) {
        super.onFillViewHolder(i, view, viewGroup, zVar, abVar);
        if (zVar != null) {
            abVar.a(zVar);
            abVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }
}
