package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ar;
/* loaded from: classes16.dex */
public class aq extends o<com.baidu.tbadk.core.data.az, ar> {
    private com.baidu.tieba.pb.data.f kAn;
    private ar.a kJF;

    /* JADX INFO: Access modifiers changed from: protected */
    public aq(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kJF = new ar.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.pb.pb.main.ar.a
            public void a(com.baidu.tbadk.core.data.az azVar) {
                if (azVar != null) {
                    com.baidu.tieba.pb.c.a.a(aq.this.kAn, azVar, azVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cj */
    public ar b(ViewGroup viewGroup) {
        return new ar(this.kzA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.kJF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.az azVar, ar arVar) {
        super.a(i, view, viewGroup, (ViewGroup) azVar, (com.baidu.tbadk.core.data.az) arVar);
        if (azVar != null) {
            azVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kzA.getUniqueId(), this.kAn, azVar, azVar.locate, 6);
            arVar.b(azVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAn = fVar;
    }
}
