package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder;
/* loaded from: classes2.dex */
public class ai extends l<bb, PbRecommendNovelHolder> {
    private com.baidu.tieba.pb.data.f lJH;
    private PbRecommendNovelHolder.a lTl;

    /* JADX INFO: Access modifiers changed from: protected */
    public ai(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lTl = new PbRecommendNovelHolder.a() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.a
            public void a(bb bbVar) {
                if (bbVar != null) {
                    com.baidu.tieba.pb.c.a.a(ai.this.lJH, bbVar, bbVar.locate, 6);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cA */
    public PbRecommendNovelHolder e(ViewGroup viewGroup) {
        return new PbRecommendNovelHolder(this.lIN.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.lTl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bb bbVar, PbRecommendNovelHolder pbRecommendNovelHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bbVar, (bb) pbRecommendNovelHolder);
        if (bbVar != null) {
            bbVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lIN.getUniqueId(), this.lJH, bbVar, bbVar.locate, 6);
            pbRecommendNovelHolder.b(bbVar);
        }
        return view;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJH = fVar;
    }
}
