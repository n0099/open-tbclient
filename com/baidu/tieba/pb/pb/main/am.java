package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.an;
/* loaded from: classes9.dex */
public class am extends m<com.baidu.tbadk.core.data.ax, an> {
    private com.baidu.tieba.pb.data.e kck;
    private an.a kkS;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kkS = new an.a() { // from class: com.baidu.tieba.pb.pb.main.am.1
            @Override // com.baidu.tieba.pb.pb.main.an.a
            public void a(com.baidu.tbadk.core.data.ax axVar) {
                if (axVar != null) {
                    com.baidu.tieba.pb.c.a.a(am.this.kck, axVar, axVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ck */
    public an b(ViewGroup viewGroup) {
        return new an(this.kbv.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.kkS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, an anVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) anVar);
        if (axVar != null) {
            axVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kbv.getUniqueId(), this.kck, axVar, axVar.locate, 6);
            anVar.b(axVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
    }
}
