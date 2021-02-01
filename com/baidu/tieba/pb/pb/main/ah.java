package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder;
/* loaded from: classes2.dex */
public class ah extends l<af, PbPageNewsInfoHolder> {
    private com.baidu.tieba.pb.data.f lNT;
    private PbPageNewsInfoHolder.a lXA;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lXA = new PbPageNewsInfoHolder.a() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.a
            public void b(af afVar) {
                if (afVar != null) {
                    com.baidu.tieba.pb.c.a.a(ah.this.lNT, afVar, afVar.locate, 5);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cz */
    public PbPageNewsInfoHolder e(ViewGroup viewGroup) {
        return new PbPageNewsInfoHolder(this.lMX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_page_news, viewGroup, false), this.lXA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, af afVar, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        super.a(i, view, viewGroup, (ViewGroup) afVar, (af) pbPageNewsInfoHolder);
        if (afVar != null) {
            afVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lMX.getUniqueId(), this.lNT, afVar, afVar.locate, 5);
            pbPageNewsInfoHolder.a(afVar);
            pbPageNewsInfoHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lNT = fVar;
    }
}
