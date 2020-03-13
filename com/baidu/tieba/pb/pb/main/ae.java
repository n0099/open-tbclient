package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ad;
/* loaded from: classes9.dex */
public class ae extends l<ab, ad> {
    private com.baidu.tieba.pb.data.e iEU;
    private ad.a iMQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public ae(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iMQ = new ad.a() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // com.baidu.tieba.pb.pb.main.ad.a
            public void b(ab abVar) {
                if (abVar != null) {
                    com.baidu.tieba.pb.c.a.a(ae.this.iEU, abVar, abVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public ad b(ViewGroup viewGroup) {
        return new ad(this.iEk.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.iMQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ab abVar, ad adVar) {
        super.a(i, view, viewGroup, (ViewGroup) abVar, (ab) adVar);
        if (abVar != null) {
            abVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iEk.getUniqueId(), this.iEU, abVar, abVar.locate, 5);
            adVar.a(abVar);
            adVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEU = eVar;
    }
}
