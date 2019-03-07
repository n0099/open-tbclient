package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ai;
/* loaded from: classes4.dex */
public class ah extends k<com.baidu.tbadk.core.data.aq, ai> {
    private com.baidu.tieba.pb.data.d hpr;
    private ai.a huP;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.huP = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void a(com.baidu.tbadk.core.data.aq aqVar) {
                if (aqVar != null) {
                    com.baidu.tieba.pb.c.a.a(ah.this.hpr, aqVar, aqVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public ai onCreateViewHolder(ViewGroup viewGroup) {
        return new ai(this.hpc.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_recommend_novel, viewGroup, false), this.huP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aq aqVar, ai aiVar) {
        super.onFillViewHolder(i, view, viewGroup, aqVar, aiVar);
        if (aqVar != null) {
            aqVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hpc.getUniqueId(), this.hpr, aqVar, aqVar.locate, 6);
            aiVar.b(aqVar);
        }
        return view;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hpr = dVar;
    }
}
