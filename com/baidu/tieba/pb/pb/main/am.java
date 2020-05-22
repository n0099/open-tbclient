package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.an;
/* loaded from: classes9.dex */
public class am extends m<com.baidu.tbadk.core.data.as, an> {
    private com.baidu.tieba.pb.data.e jHu;
    private an.a jPW;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.jPW = new an.a() { // from class: com.baidu.tieba.pb.pb.main.am.1
            @Override // com.baidu.tieba.pb.pb.main.an.a
            public void a(com.baidu.tbadk.core.data.as asVar) {
                if (asVar != null) {
                    com.baidu.tieba.pb.c.a.a(am.this.jHu, asVar, asVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bY */
    public an b(ViewGroup viewGroup) {
        return new an(this.jGF.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.jPW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, an anVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) anVar);
        if (asVar != null) {
            asVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.jGF.getUniqueId(), this.jHu, asVar, asVar.locate, 6);
            anVar.b(asVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jHu = eVar;
    }
}
