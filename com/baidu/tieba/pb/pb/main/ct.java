package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ct extends cp {
    /* JADX INFO: Access modifiers changed from: protected */
    public ct(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cp
    /* renamed from: ab */
    public cu aa(ViewGroup viewGroup) {
        return new cu(LayoutInflater.from(this.mContext).inflate(n.h.pb_newchudian_multi_img_item, viewGroup, false), this.cDQ, this.cDr, this.cDq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cp
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, cs csVar) {
        super.a(i, view, viewGroup, rVar, csVar);
        if (rVar == null || rVar.aFA() == null) {
            return null;
        }
        ((cu) csVar).a(this.mContext, rVar.aFA(), this.cBf);
        return view;
    }
}
