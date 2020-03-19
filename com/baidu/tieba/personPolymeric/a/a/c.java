package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, af<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.f> JZ;
    private String LC;
    private boolean NK;
    public BdUniqueId dBK;
    private com.baidu.adp.lib.d.b<ImageView> dMQ;
    private com.baidu.adp.lib.d.b<GifView> dMR;
    private int fsC;
    private int joD;
    private int joE;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.NK = true;
        this.joD = 0;
        this.joE = 0;
        this.fsC = 0;
        this.dMQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aUR */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.azR().isShowImages();
                foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                if (isShowImages) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(ImageView imageView) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    ((ForeDrawableImageView) imageView).stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public ImageView activateObject(ImageView imageView) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (com.baidu.tbadk.core.i.azR().isShowImages()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public ImageView passivateObject(ImageView imageView) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    ((ForeDrawableImageView) imageView).stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
        }, 12, 0);
        this.dMR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bHp */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.azR().isShowImages();
                gifView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                if (isShowImages) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: g */
            public void destroyObject(GifView gifView) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.onDestroy();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: h */
            public GifView activateObject(GifView gifView) {
                gifView.setTag(null);
                if (com.baidu.tbadk.core.i.azR().isShowImages()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: i */
            public GifView passivateObject(GifView gifView) {
                gifView.release();
                gifView.onDestroy();
                gifView.setImageDrawable(null);
                gifView.aPT();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.JZ = new z<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                if (view != null && fVar != null && fVar.aAj() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        an zZ = fVar.zZ("c13543");
                        zZ.X("obj_type", fVar.ae(fVar.cRt));
                        TiebaStatic.log(zZ);
                        com.baidu.tieba.personPolymeric.a.a(view, fVar, 2);
                    } else if (view instanceof TbImageView) {
                        com.baidu.tieba.personPolymeric.a.a(view, fVar, 3);
                    } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                        com.baidu.tieba.personPolymeric.a.a(view, fVar, 2);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, fVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBK);
        eVar.aL(1024);
        eVar.aL(32768);
        if (this.joD > 0) {
            eVar.aK(this.joD);
        }
        eVar.ab(false);
        eVar.ac(false);
        aVar.a(eVar);
        l lVar = new l(this.mPageContext.getPageActivity());
        lVar.setFrom("index");
        lVar.setObjectPool(this.dMQ, this.dMR);
        lVar.setFromCDN(this.NK);
        lVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        lVar.setCornerStyle(1);
        aVar.a((com.baidu.card.h) lVar);
        if (this.fsC == 2) {
            aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 3;
        dVar.cNV = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setShareReportFrom(6);
        agVar.aZ(4);
        aVar.b(agVar);
        aVar.ni().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad nj = aVar.nj();
        nj.aQ(4);
        af afVar = new af(nj);
        afVar.setPageId(this.dBK);
        afVar.aY(this.joE);
        a(new s() { // from class: com.baidu.tieba.personPolymeric.a.a.c.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) mVar;
                    fVar.objType = 1;
                    if (c.this.JZ != null) {
                        c.this.JZ.a(afVar2.getView(), fVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) fVar, view.getContext(), 4, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, af<com.baidu.tieba.card.data.f> afVar) {
        if (fVar == null || afVar == null || afVar.getView() == null || fVar.cRt == null) {
            return null;
        }
        fVar.rv(fVar.position + 1);
        afVar.nk().setPage(this.LC);
        if (!this.mIsHost) {
            afVar.nm();
        }
        afVar.b((af<com.baidu.tieba.card.data.f>) fVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.personPolymeric.a.e(fVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }

    public void Af(int i) {
        this.joD = i;
    }

    private void bPl() {
        k.fNP = "c13542";
    }

    public void setTabType(int i) {
        this.fsC = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Ae(int i) {
        this.joE = i;
    }
}
