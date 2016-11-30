package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class eg extends ct<dv, ee> {
    /* JADX INFO: Access modifiers changed from: protected */
    public eg(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public ee a(ViewGroup viewGroup) {
        return new ee(this.eug.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.h.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ct, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, dv dvVar, ee eeVar) {
        super.a(i, view, viewGroup, (ViewGroup) dvVar, (dv) eeVar);
        if (dvVar != null) {
            eeVar.a(dvVar);
            eeVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }
}
