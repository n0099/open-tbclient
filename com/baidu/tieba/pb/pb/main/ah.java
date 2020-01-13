package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ag;
/* loaded from: classes7.dex */
public class ah extends m<ae, ag> {
    private com.baidu.tieba.pb.data.f iCZ;
    private ag.a iLh;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iLh = new ag.a() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tieba.pb.pb.main.ag.a
            public void b(ae aeVar) {
                if (aeVar != null) {
                    com.baidu.tieba.pb.c.a.a(ah.this.iCZ, aeVar, aeVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public ag b(ViewGroup viewGroup) {
        return new ag(this.iCe.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.iLh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ae aeVar, ag agVar) {
        super.a(i, view, viewGroup, (ViewGroup) aeVar, (ae) agVar);
        if (aeVar != null) {
            aeVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iCe.getUniqueId(), this.iCZ, aeVar, aeVar.locate, 5);
            agVar.a(aeVar);
            agVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
    }
}
