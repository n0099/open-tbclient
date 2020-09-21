package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ao;
/* loaded from: classes21.dex */
public class ap extends o<am, ao> {
    private com.baidu.tieba.pb.data.f kIK;
    private ao.a kSc;

    /* JADX INFO: Access modifiers changed from: protected */
    public ap(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kSc = new ao.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
            @Override // com.baidu.tieba.pb.pb.main.ao.a
            public void b(am amVar) {
                if (amVar != null) {
                    com.baidu.tieba.pb.c.a.a(ap.this.kIK, amVar, amVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cj */
    public ao c(ViewGroup viewGroup) {
        return new ao(this.kHX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.kSc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, am amVar, ao aoVar) {
        super.a(i, view, viewGroup, (ViewGroup) amVar, (am) aoVar);
        if (amVar != null) {
            amVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kHX.getUniqueId(), this.kIK, amVar, amVar.locate, 5);
            aoVar.a(amVar);
            aoVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kIK = fVar;
    }
}
