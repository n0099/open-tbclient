package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes.dex */
public class f extends l<j, a> {
    public f(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.pb.view.g(this.eIu.getPageContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, aVar);
        if (jVar != null && aVar != null) {
            aVar.eHm.setData(jVar);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.pb.view.g eHm;

        public a(com.baidu.tieba.pb.view.g gVar) {
            super(gVar);
            this.eHm = gVar;
        }
    }
}
