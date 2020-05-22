package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.j;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, ag<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.f> adt;
    private String aeX;
    private boolean aha;
    private com.baidu.adp.lib.d.b<ImageView> eBr;
    private com.baidu.adp.lib.d.b<GifView> eBs;
    public BdUniqueId epM;
    private int glW;
    private int kqO;
    private int kqP;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.kqO = 0;
        this.kqP = 0;
        this.glW = 0;
        this.eBr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bjk */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = k.aNQ().isShowImages();
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
                    if (k.aNQ().isShowImages()) {
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
        this.eBs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bPO */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = k.aNQ().isShowImages();
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
                if (k.aNQ().isShowImages()) {
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
                gifView.ber();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.adt = new aa<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.personPolymeric.a.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                if (view != null && fVar != null && fVar.aOi() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        an Dr = fVar.Dr("c13543");
                        Dr.ag("obj_type", fVar.af(fVar.dEA));
                        TiebaStatic.log(Dr);
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
        cgg();
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
        if (this.kqO > 0) {
            eVar.aX(this.kqO);
        }
        eVar.aC(false);
        eVar.aD(false);
        aVar.a(eVar);
        m mVar = new m(this.mPageContext.getPageActivity());
        mVar.setFrom("index");
        mVar.setObjectPool(this.eBr, this.eBs);
        mVar.setFromCDN(this.aha);
        mVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds20));
        mVar.setCornerStyle(1);
        aVar.a((com.baidu.card.h) mVar);
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
        agVar.bl(this.kqP);
        a(new x() { // from class: com.baidu.tieba.personPolymeric.a.a.c.4
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) oVar;
                    fVar.objType = 1;
                    if (c.this.adt != null) {
                        c.this.adt.a(agVar2.getView(), fVar);
                    }
                    au.a((AbsThreadDataSupport) fVar, view.getContext(), 4, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, ag<com.baidu.tieba.card.data.f> agVar) {
        if (fVar == null || agVar == null || agVar.getView() == null || fVar.dEA == null) {
            return null;
        }
        fVar.sr(fVar.position + 1);
        agVar.rM().setPage(this.aeX);
        if (!this.mIsHost) {
            agVar.rO();
        }
        agVar.b((ag<com.baidu.tieba.card.data.f>) fVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.personPolymeric.a.h(fVar);
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void Br(int i) {
        this.kqO = i;
    }

    private void cgg() {
        com.baidu.tieba.card.data.k.gHr = "c13542";
    }

    public void setTabType(int i) {
        this.glW = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Bq(int i) {
        this.kqP = i;
    }
}
