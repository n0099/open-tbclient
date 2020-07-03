package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ak;
/* loaded from: classes9.dex */
public class al extends m<ai, ak> {
    private com.baidu.tieba.pb.data.e kck;
    private ak.a kkP;

    /* JADX INFO: Access modifiers changed from: protected */
    public al(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kkP = new ak.a() { // from class: com.baidu.tieba.pb.pb.main.al.1
            @Override // com.baidu.tieba.pb.pb.main.ak.a
            public void b(ai aiVar) {
                if (aiVar != null) {
                    com.baidu.tieba.pb.c.a.a(al.this.kck, aiVar, aiVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cj */
    public ak b(ViewGroup viewGroup) {
        return new ak(this.kbv.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.kkP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ai aiVar, ak akVar) {
        super.a(i, view, viewGroup, (ViewGroup) aiVar, (ai) akVar);
        if (aiVar != null) {
            aiVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kbv.getUniqueId(), this.kck, aiVar, aiVar.locate, 5);
            akVar.a(aiVar);
            akVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
    }
}
