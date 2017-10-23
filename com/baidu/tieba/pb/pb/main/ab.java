package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ab extends k<y, aa> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ab(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public aa onCreateViewHolder(ViewGroup viewGroup) {
        return new aa(this.eDo.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, y yVar, aa aaVar) {
        super.onFillViewHolder(i, view, viewGroup, yVar, aaVar);
        if (yVar != null) {
            aaVar.a(yVar);
            aaVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }
}
