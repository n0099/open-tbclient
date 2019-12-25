package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.aj;
/* loaded from: classes6.dex */
public class ai extends m<com.baidu.tbadk.core.data.at, aj> {
    private aj.a iHG;
    private com.baidu.tieba.pb.data.f izv;

    /* JADX INFO: Access modifiers changed from: protected */
    public ai(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iHG = new aj.a() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // com.baidu.tieba.pb.pb.main.aj.a
            public void a(com.baidu.tbadk.core.data.at atVar) {
                if (atVar != null) {
                    com.baidu.tieba.pb.c.a.a(ai.this.izv, atVar, atVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public aj b(ViewGroup viewGroup) {
        return new aj(this.iyA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.iHG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, aj ajVar) {
        super.a(i, view, viewGroup, (ViewGroup) atVar, (com.baidu.tbadk.core.data.at) ajVar);
        if (atVar != null) {
            atVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iyA.getUniqueId(), this.izv, atVar, atVar.locate, 6);
            ajVar.b(atVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
    }
}
