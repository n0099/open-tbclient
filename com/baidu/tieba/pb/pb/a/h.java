package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.du;
import com.baidu.tieba.pb.view.y;
/* loaded from: classes.dex */
public class h extends du<com.baidu.tieba.pb.data.j, a> {
    public h(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(new y(this.euf.getPageContext()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, aVar);
        if (jVar != null && aVar != null) {
            aVar.esW.setData(jVar);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends z.a {
        public y esW;

        public a(y yVar) {
            super(yVar);
            this.esW = yVar;
        }
    }
}
