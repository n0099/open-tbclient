package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.af;
/* loaded from: classes4.dex */
public class ag extends k<ad, af> {
    private com.baidu.tieba.pb.data.d hOn;
    private af.a hTN;

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hTN = new af.a() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // com.baidu.tieba.pb.pb.main.af.a
            public void b(ad adVar) {
                if (adVar != null) {
                    com.baidu.tieba.pb.c.a.a(ag.this.hOn, adVar, adVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public af b(ViewGroup viewGroup) {
        return new af(this.hNY.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.hTN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ad adVar, af afVar) {
        super.a(i, view, viewGroup, (ViewGroup) adVar, (ad) afVar);
        if (adVar != null) {
            adVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hNY.getUniqueId(), this.hOn, adVar, adVar.locate, 5);
            afVar.a(adVar);
            afVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hOn = dVar;
    }
}
