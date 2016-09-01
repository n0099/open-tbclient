package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ef extends cs<ds, ed> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ef(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public ed a(ViewGroup viewGroup) {
        return new ed(this.emy.getPageContext(), LayoutInflater.from(this.mContext).inflate(t.h.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ds dsVar, ed edVar) {
        super.a(i, view, viewGroup, (ViewGroup) dsVar, (ds) edVar);
        if (dsVar != null) {
            edVar.a(dsVar);
            edVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }
}
