package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.t;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.a.a<t>> {
    private com.baidu.adp.lib.e.b<TbImageView> dqA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqz;
    private boolean isHost;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.cCy);
        this.dqz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.personPolymeric.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avZ */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dqA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.personPolymeric.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AO */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(f.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        t tVar = new t(this.mPageContext);
        tVar.setConstrainLayoutPool(this.dqz);
        tVar.setConstrainImagePool(this.dqA);
        tVar.currentPageType = 4;
        if (tVar.czP != null) {
            tVar.czP.ajY = 4;
        }
        if (tVar.bHO != null) {
            tVar.bHO.ajY = 4;
        }
        if (tVar.cAm != null) {
            tVar.cAm.cAZ = 4;
        }
        tVar.b(new ad<CardPersonDynamicThreadData>() { // from class: com.baidu.tieba.personPolymeric.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
                TiebaStatic.log(new an("c12042").r("obj_type", i.this.isHost ? 1 : 2));
            }
        });
        return new com.baidu.tieba.card.a.a<>(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.a.a<t> aVar) {
        aVar.ajC().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.ajC().a(cardPersonDynamicThreadData);
        return aVar.getView();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }
}
