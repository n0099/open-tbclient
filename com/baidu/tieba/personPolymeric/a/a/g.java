package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.j;
import com.baidu.card.q;
import com.baidu.card.u;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes18.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, ak<k>> implements com.baidu.tieba.a.f {
    private aa<k> adN;
    private String afx;
    private boolean aib;
    public BdUniqueId eEU;
    private int gEw;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hLg;
    private com.baidu.adp.lib.d.b<TbImageView> hLh;
    private int kUR;
    private int kUS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.kUR = 0;
        this.kUS = 0;
        this.gEw = 0;
        this.hLg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cdX */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(g.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.hLh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bcD */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.adN = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aTN() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        ap ED = kVar.ED("c13543");
                        ED.ah("obj_type", kVar.ad(kVar.dLK));
                        TiebaStatic.log(ED);
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 2);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                    } else if (view instanceof TbImageView) {
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cnr();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.bg(1024);
        eVar.bg(32768);
        if (this.kUR > 0) {
            eVar.bf(this.kUR);
        }
        eVar.aD(false);
        eVar.aE(false);
        aVar.a(eVar);
        final u uVar = new u(this.mPageContext.getPageActivity());
        uVar.setFrom("index");
        uVar.setConstrainLayoutPool(this.hLg);
        uVar.setConstrainImagePool(this.hLh);
        uVar.setFromCDN(this.aib);
        aVar.c(uVar);
        aVar.se().bm(l.getDimens(this.mContext, R.dimen.tbds25));
        if (!aC(1) || !aC(2)) {
            uVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.personPolymeric.a.a.g.4
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    g.this.h(i, i2, i3);
                    if (g.this.aC(1) && g.this.aC(2)) {
                        uVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        q qVar = new q(this.mPageContext.getPageActivity());
        qVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) qVar);
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(4);
        asVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds26));
        aVar.a((com.baidu.card.h) asVar);
        ae aeVar = new ae(this.mPageContext.getPageActivity());
        aeVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) aeVar);
        y yVar = new y(this.mPageContext.getPageActivity());
        yVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) yVar);
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 3;
        cVar.dNH = 3;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(8);
        alVar.setShareReportFrom(6);
        alVar.setFromForPb(4);
        aVar.b(alVar);
        aVar.se().setBackgroundResource(R.drawable.addresslist_item_bg);
        ai sf = aVar.sf();
        sf.setSourceForPb(4);
        ak akVar = new ak(sf);
        akVar.setPageId(this.eEU);
        akVar.bt(this.kUS);
        a(new z() { // from class: com.baidu.tieba.personPolymeric.a.a.g.5
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar2 instanceof k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    k kVar = (k) qVar2;
                    kVar.objType = 1;
                    if (g.this.adN != null) {
                        g.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 4, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ak<k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        akVar.sg().setPage(this.afx);
        if (!this.mIsHost) {
            akVar.si();
        }
        akVar.b((ak<k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.personPolymeric.a.h(kVar);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void CV(int i) {
        this.kUR = i;
    }

    public void CU(int i) {
        this.kUS = i;
    }

    private void cnr() {
        k.hag = "c13542";
    }

    public void setTabType(int i) {
        this.gEw = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }
}
