package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ee extends cr<dr, ec> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ee(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public ec a(ViewGroup viewGroup) {
        return new ec(this.dOg.getPageContext(), LayoutInflater.from(this.mContext).inflate(u.h.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, dr drVar, ec ecVar) {
        super.a(i, view, viewGroup, (ViewGroup) drVar, (dr) ecVar);
        if (drVar != null) {
            ecVar.a(drVar);
            ecVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }
}
