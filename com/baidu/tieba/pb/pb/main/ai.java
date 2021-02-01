package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder;
/* loaded from: classes2.dex */
public class ai extends l<bd, PbRecommendNovelHolder> {
    private com.baidu.tieba.pb.data.f lNT;
    private PbRecommendNovelHolder.a lXD;

    /* JADX INFO: Access modifiers changed from: protected */
    public ai(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lXD = new PbRecommendNovelHolder.a() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.a
            public void a(bd bdVar) {
                if (bdVar != null) {
                    com.baidu.tieba.pb.c.a.a(ai.this.lNT, bdVar, bdVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cA */
    public PbRecommendNovelHolder e(ViewGroup viewGroup) {
        return new PbRecommendNovelHolder(this.lMX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.lXD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bd bdVar, PbRecommendNovelHolder pbRecommendNovelHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bdVar, (bd) pbRecommendNovelHolder);
        if (bdVar != null) {
            bdVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lMX.getUniqueId(), this.lNT, bdVar, bdVar.locate, 6);
            pbRecommendNovelHolder.b(bdVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lNT = fVar;
    }
}
