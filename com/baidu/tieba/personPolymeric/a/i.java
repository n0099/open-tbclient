package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.a.a<t>> {
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dod;
    private com.baidu.adp.lib.e.b<TbImageView> doe;
    private boolean isHost;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.cCc);
        this.dod = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.personPolymeric.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avY */
            public ConstrainImageLayout mo9if() {
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
        this.doe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.personPolymeric.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0141d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        t tVar = new t(this.mPageContext);
        tVar.setConstrainLayoutPool(this.dod);
        tVar.setConstrainImagePool(this.doe);
        tVar.currentPageType = 4;
        if (tVar.czw != null) {
            tVar.czw.aka = 4;
        }
        if (tVar.bFe != null) {
            tVar.bFe.aka = 4;
        }
        if (tVar.czT != null) {
            tVar.czT.cAF = 4;
        }
        tVar.b(new ab<CardPersonDynamicThreadData>() { // from class: com.baidu.tieba.personPolymeric.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
                TiebaStatic.log(new am("c12042").r("obj_type", i.this.isHost ? 1 : 2));
            }
        });
        return new com.baidu.tieba.card.a.a<>(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.a.a<t> aVar) {
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.ajG().a(cardPersonDynamicThreadData);
        return aVar.getView();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }
}
