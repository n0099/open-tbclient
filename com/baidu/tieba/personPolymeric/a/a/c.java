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
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, af<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.f> JE;
    private String Lg;
    private boolean Nj;
    private com.baidu.adp.lib.d.b<ImageView> dIh;
    private com.baidu.adp.lib.d.b<GifView> dIi;
    public BdUniqueId dxg;
    private int fpl;
    private int jlR;
    private int jlS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Nj = true;
        this.jlR = 0;
        this.jlS = 0;
        this.fpl = 0;
        this.dIh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aSt */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
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
                    if (com.baidu.tbadk.core.i.axy().isShowImages()) {
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
        this.dIi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bFv */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
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
                if (com.baidu.tbadk.core.i.axy().isShowImages()) {
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
                gifView.aNq();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.JE = new z<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                if (view != null && fVar != null && fVar.axQ() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        an zG = fVar.zG("c13543");
                        zG.Z("obj_type", fVar.ac(fVar.cNb));
                        TiebaStatic.log(zG);
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
        if (this.jlR > 0) {
            eVar.aH(this.jlR);
        }
        eVar.Y(false);
        eVar.Z(false);
        aVar.a(eVar);
        l lVar = new l(this.mPageContext.getPageActivity());
        lVar.setFrom("index");
        lVar.setObjectPool(this.dIh, this.dIi);
        lVar.setFromCDN(this.Nj);
        lVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        lVar.setCornerStyle(1);
        aVar.a((com.baidu.card.h) lVar);
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
        afVar.aU(this.jlS);
        a(new s() { // from class: com.baidu.tieba.personPolymeric.a.a.c.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) mVar;
                    fVar.objType = 1;
                    if (c.this.JE != null) {
                        c.this.JE.a(afVar2.getView(), fVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) fVar, view.getContext(), 4, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, af<com.baidu.tieba.card.data.f> afVar) {
        if (fVar == null || afVar == null || afVar.getView() == null || fVar.cNb == null) {
            return null;
        }
        fVar.rm(fVar.position + 1);
        afVar.mU().setPage(this.Lg);
        if (!this.mIsHost) {
            afVar.mW();
        }
        afVar.b((af<com.baidu.tieba.card.data.f>) fVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        com.baidu.tieba.personPolymeric.a.d(fVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void zQ(int i) {
        this.jlR = i;
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

    public void zP(int i) {
        this.jlS = i;
    }
}
