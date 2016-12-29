package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class eg extends cs<com.baidu.tbadk.core.data.aq, eh> {
    /* JADX INFO: Access modifiers changed from: protected */
    public eg(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public eh a(ViewGroup viewGroup) {
        return new eh(this.dYB.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.h.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aq aqVar, eh ehVar) {
        super.a(i, view, viewGroup, (ViewGroup) aqVar, (com.baidu.tbadk.core.data.aq) ehVar);
        if (aqVar != null) {
            ehVar.a(aqVar);
        }
        return view;
    }
}
