package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, af<k>> implements com.baidu.tieba.a.f {
    private z<k> JE;
    private String Lg;
    private boolean Nj;
    public BdUniqueId dxg;
    private int fpl;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gri;
    private com.baidu.adp.lib.d.b<TbImageView> grj;
    private int jlW;
    private int jlX;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Nj = true;
        this.jlW = 0;
        this.jlX = 0;
        this.fpl = 0;
        this.gri = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bEy */
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
        this.grj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFP */
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
        this.JE = new z<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.axQ() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        an zG = kVar.zG("c13543");
                        zG.Z("obj_type", kVar.ac(kVar.cNb));
                        TiebaStatic.log(zG);
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
        bNs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.aI(1024);
        eVar.aI(32768);
        if (this.jlW > 0) {
            eVar.aH(this.jlW);
        }
        eVar.Y(false);
        eVar.Z(false);
        aVar.a(eVar);
        final s sVar = new s(this.mPageContext.getPageActivity());
        sVar.setFrom("index");
        sVar.setConstrainLayoutPool(this.gri);
        sVar.setConstrainImagePool(this.grj);
        sVar.setFromCDN(this.Nj);
        aVar.c(sVar);
        aVar.mS().aN(l.getDimens(this.mContext, R.dimen.tbds25));
        if (!ae(1) || !ae(2)) {
            sVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.personPolymeric.a.a.g.4
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    g.this.g(i, i2, i3);
                    if (g.this.ae(1) && g.this.ae(2)) {
                        sVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        if (this.fpl == 2) {
            aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 3;
        dVar.cJD = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setShareReportFrom(6);
        agVar.aV(4);
        aVar.b(agVar);
        aVar.mS().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad mT = aVar.mT();
        mT.aM(4);
        af afVar = new af(mT);
        afVar.setPageId(this.dxg);
        afVar.aU(this.jlX);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.personPolymeric.a.a.g.5
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (g.this.JE != null) {
                        g.this.JE.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, af<k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cNb == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        afVar.mU().setPage(this.Lg);
        if (!this.mIsHost) {
            afVar.mW();
        }
        afVar.b((af<k>) kVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        com.baidu.tieba.personPolymeric.a.d(kVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void zQ(int i) {
        this.jlW = i;
    }

    public void zP(int i) {
        this.jlX = i;
    }

    private void bNs() {
        k.fKw = "c13542";
    }

    public void setTabType(int i) {
        this.fpl = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }
}
