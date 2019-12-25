package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ag;
/* loaded from: classes6.dex */
public class ah extends m<ae, ag> {
    private ag.a iHD;
    private com.baidu.tieba.pb.data.f izv;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iHD = new ag.a() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tieba.pb.pb.main.ag.a
            public void b(ae aeVar) {
                if (aeVar != null) {
                    com.baidu.tieba.pb.c.a.a(ah.this.izv, aeVar, aeVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public ag b(ViewGroup viewGroup) {
        return new ag(this.iyA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.iHD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ae aeVar, ag agVar) {
        super.a(i, view, viewGroup, (ViewGroup) aeVar, (ae) agVar);
        if (aeVar != null) {
            aeVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iyA.getUniqueId(), this.izv, aeVar, aeVar.locate, 5);
            agVar.a(aeVar);
            agVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
    }
}
