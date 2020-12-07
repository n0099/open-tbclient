package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ar;
/* loaded from: classes22.dex */
public class aq extends o<com.baidu.tbadk.core.data.bb, ar> {
    private com.baidu.tieba.pb.data.f lEt;
    private ar.a lNX;

    /* JADX INFO: Access modifiers changed from: protected */
    public aq(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lNX = new ar.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.pb.pb.main.ar.a
            public void a(com.baidu.tbadk.core.data.bb bbVar) {
                if (bbVar != null) {
                    com.baidu.tieba.pb.c.a.a(aq.this.lEt, bbVar, bbVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: co */
    public ar c(ViewGroup viewGroup) {
        return new ar(this.lDG.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.lNX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.bb bbVar, ar arVar) {
        super.a(i, view, viewGroup, (ViewGroup) bbVar, (com.baidu.tbadk.core.data.bb) arVar);
        if (bbVar != null) {
            bbVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lDG.getUniqueId(), this.lEt, bbVar, bbVar.locate, 6);
            arVar.b(bbVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEt = fVar;
    }
}
