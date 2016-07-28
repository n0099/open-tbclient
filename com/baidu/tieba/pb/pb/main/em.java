package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class em extends cs<com.baidu.tbadk.core.data.am, en> {
    /* JADX INFO: Access modifiers changed from: protected */
    public em(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public en a(ViewGroup viewGroup) {
        return new en(this.eat.getPageContext(), LayoutInflater.from(this.mContext).inflate(u.h.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.am amVar, en enVar) {
        super.a(i, view, viewGroup, (ViewGroup) amVar, (com.baidu.tbadk.core.data.am) enVar);
        if (amVar != null) {
            enVar.a(amVar);
        }
        return view;
    }
}
