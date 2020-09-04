package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ao;
/* loaded from: classes16.dex */
public class ap extends o<am, ao> {
    private com.baidu.tieba.pb.data.f kAn;
    private ao.a kJC;

    /* JADX INFO: Access modifiers changed from: protected */
    public ap(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kJC = new ao.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
            @Override // com.baidu.tieba.pb.pb.main.ao.a
            public void b(am amVar) {
                if (amVar != null) {
                    com.baidu.tieba.pb.c.a.a(ap.this.kAn, amVar, amVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public ao b(ViewGroup viewGroup) {
        return new ao(this.kzA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.kJC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, am amVar, ao aoVar) {
        super.a(i, view, viewGroup, (ViewGroup) amVar, (am) aoVar);
        if (amVar != null) {
            amVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kzA.getUniqueId(), this.kAn, amVar, amVar.locate, 5);
            aoVar.a(amVar);
            aoVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAn = fVar;
    }
}
