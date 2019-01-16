package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.ai;
/* loaded from: classes6.dex */
public class ah extends k<com.baidu.tbadk.core.data.ao, ai> {
    private com.baidu.tieba.pb.data.d fYY;
    private ai.a geG;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.geG = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void a(com.baidu.tbadk.core.data.ao aoVar) {
                if (aoVar != null) {
                    com.baidu.tieba.pb.c.a.a(ah.this.fYY, aoVar, aoVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public ai onCreateViewHolder(ViewGroup viewGroup) {
        return new ai(this.fYJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_recommend_novel, viewGroup, false), this.geG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ao aoVar, ai aiVar) {
        super.onFillViewHolder(i, view, viewGroup, aoVar, aiVar);
        if (aoVar != null) {
            aoVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.fYJ.getUniqueId(), this.fYY, aoVar, aoVar.locate, 6);
            aiVar.b(aoVar);
        }
        return view;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fYY = dVar;
    }
}
