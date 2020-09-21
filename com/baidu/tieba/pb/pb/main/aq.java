package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ar;
/* loaded from: classes21.dex */
public class aq extends o<com.baidu.tbadk.core.data.az, ar> {
    private com.baidu.tieba.pb.data.f kIK;
    private ar.a kSf;

    /* JADX INFO: Access modifiers changed from: protected */
    public aq(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kSf = new ar.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.pb.pb.main.ar.a
            public void a(com.baidu.tbadk.core.data.az azVar) {
                if (azVar != null) {
                    com.baidu.tieba.pb.c.a.a(aq.this.kIK, azVar, azVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ck */
    public ar c(ViewGroup viewGroup) {
        return new ar(this.kHX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.kSf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.az azVar, ar arVar) {
        super.a(i, view, viewGroup, (ViewGroup) azVar, (com.baidu.tbadk.core.data.az) arVar);
        if (azVar != null) {
            azVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kHX.getUniqueId(), this.kIK, azVar, azVar.locate, 6);
            arVar.b(azVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kIK = fVar;
    }
}
