package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.j;
import com.baidu.card.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes11.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, ag<k>> implements com.baidu.tieba.a.f {
    private aa<k> adt;
    private String aeX;
    private boolean aha;
    public BdUniqueId epM;
    private int gmh;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hss;
    private com.baidu.adp.lib.d.b<TbImageView> hst;
    private int krU;
    private int krV;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.krU = 0;
        this.krV = 0;
        this.gmh = 0;
        this.hss = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXn */
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
        this.hst = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWN */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
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
        this.adt = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aOi() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        an Dr = kVar.Dr("c13543");
                        Dr.ag("obj_type", kVar.af(kVar.dEA));
                        TiebaStatic.log(Dr);
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
        cgp();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aY(1024);
        eVar.aY(32768);
        if (this.krU > 0) {
            eVar.aX(this.krU);
        }
        eVar.aC(false);
        eVar.aD(false);
        aVar.a(eVar);
        final t tVar = new t(this.mPageContext.getPageActivity());
        tVar.setFrom("index");
        tVar.setConstrainLayoutPool(this.hss);
        tVar.setConstrainImagePool(this.hst);
        tVar.setFromCDN(this.aha);
        aVar.c(tVar);
        aVar.rK().be(l.getDimens(this.mContext, R.dimen.tbds25));
        if (!au(1) || !au(2)) {
            tVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.personPolymeric.a.a.g.4
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    g.this.h(i, i2, i3);
                    if (g.this.au(1) && g.this.au(2)) {
                        tVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 3;
        cVar.dBf = 3;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(8);
        ahVar.setShareReportFrom(6);
        ahVar.bm(4);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        ae rL = aVar.rL();
        rL.setSourceForPb(4);
        ag agVar = new ag(rL);
        agVar.setPageId(this.epM);
        agVar.bl(this.krV);
        a(new x() { // from class: com.baidu.tieba.personPolymeric.a.a.g.5
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    k kVar = (k) oVar;
                    kVar.objType = 1;
                    if (g.this.adt != null) {
                        g.this.adt.a(agVar2.getView(), kVar);
                    }
                    au.a((AbsThreadDataSupport) kVar, view.getContext(), 4, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ag<k> agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.st(kVar.position + 1);
        agVar.rM().setPage(this.aeX);
        if (!this.mIsHost) {
            agVar.rO();
        }
        agVar.b((ag<k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.personPolymeric.a.h(kVar);
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void Bt(int i) {
        this.krU = i;
    }

    public void Bs(int i) {
        this.krV = i;
    }

    private void cgp() {
        k.gHC = "c13542";
    }

    public void setTabType(int i) {
        this.gmh = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }
}
