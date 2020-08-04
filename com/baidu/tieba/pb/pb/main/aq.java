package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ar;
/* loaded from: classes16.dex */
public class aq extends o<com.baidu.tbadk.core.data.ay, ar> {
    private com.baidu.tieba.pb.data.f kkO;
    private ar.a ktT;

    /* JADX INFO: Access modifiers changed from: protected */
    public aq(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.ktT = new ar.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.pb.pb.main.ar.a
            public void a(com.baidu.tbadk.core.data.ay ayVar) {
                if (ayVar != null) {
                    com.baidu.tieba.pb.c.a.a(aq.this.kkO, ayVar, ayVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cn */
    public ar b(ViewGroup viewGroup) {
        return new ar(this.kkb.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.ktT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ay ayVar, ar arVar) {
        super.a(i, view, viewGroup, (ViewGroup) ayVar, (com.baidu.tbadk.core.data.ay) arVar);
        if (ayVar != null) {
            ayVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kkb.getUniqueId(), this.kkO, ayVar, ayVar.locate, 6);
            arVar.b(ayVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkO = fVar;
    }
}
