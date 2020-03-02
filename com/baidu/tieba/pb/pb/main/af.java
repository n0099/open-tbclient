package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.at;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ag;
/* loaded from: classes9.dex */
public class af extends l<at, ag> {
    private com.baidu.tieba.pb.data.e iEI;
    private ag.a iMH;

    /* JADX INFO: Access modifiers changed from: protected */
    public af(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iMH = new ag.a() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // com.baidu.tieba.pb.pb.main.ag.a
            public void a(at atVar) {
                if (atVar != null) {
                    com.baidu.tieba.pb.c.a.a(af.this.iEI, atVar, atVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public ag b(ViewGroup viewGroup) {
        return new ag(this.iDY.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.iMH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, at atVar, ag agVar) {
        super.a(i, view, viewGroup, (ViewGroup) atVar, (at) agVar);
        if (atVar != null) {
            atVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iDY.getUniqueId(), this.iEI, atVar, atVar.locate, 6);
            agVar.b(atVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEI = eVar;
    }
}
