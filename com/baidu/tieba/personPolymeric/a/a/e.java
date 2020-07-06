package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.card.j;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes11.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, ak<k>> implements com.baidu.tieba.a.f {
    private aa<k> adX;
    private String afG;
    private boolean aik;
    private com.baidu.adp.lib.d.b<ImageView> eLl;
    private com.baidu.adp.lib.d.b<GifView> eLm;
    public BdUniqueId eyE;
    private int gyV;
    private int kLR;
    private int kLS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.kLR = 0;
        this.kLS = 0;
        this.gyV = 0;
        this.adX = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aPS() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 2);
                    } else if (view instanceof TbImageView) {
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 6);
                    } else if (id == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 2);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                    }
                }
            }
        };
        this.eLl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.personPolymeric.a.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blM */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(e.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                foreDrawableImageView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
        }, 8, 0);
        this.eLm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.personPolymeric.a.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bSU */
            public GifView makeObject() {
                GifView gifView = new GifView(e.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                gifView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
                gifView.bgx();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.be(1024);
        eVar.be(32768);
        if (this.kLR > 0) {
            eVar.bd(this.kLR);
        }
        eVar.aD(false);
        eVar.aE(false);
        aVar.a(eVar);
        ad adVar = new ad(this.mPageContext);
        adVar.b((Boolean) false);
        adVar.e(0, 0, 0, l.getDimens(this.mContext, R.dimen.tbds20));
        adVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        adVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds25));
        aVar.a((com.baidu.card.h) adVar);
        final m mVar = new m(this.mPageContext.getPageActivity());
        mVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        mVar.setFromForPb(4);
        mVar.setObjectPool(this.eLl, this.eLm);
        mVar.setFromCDN(this.aik);
        mVar.b((Boolean) true);
        mVar.bi(R.color.cp_bg_line_c);
        mVar.e(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39));
        mVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.e.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null) {
                    aw.a(absThreadDataSupport.aPS().dNX, e.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(mVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) mVar);
        com.baidu.card.an anVar = new com.baidu.card.an(this.mPageContext.getPageActivity());
        anVar.setTopMargin(-l.getDimens(this.mContext, R.dimen.tbds18));
        aVar.a((com.baidu.card.h) anVar);
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(4);
        aVar.a((com.baidu.card.h) asVar);
        j jVar = new j(this.mPageContext.getPageActivity());
        jVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.h) jVar);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 3;
        cVar.dHw = 3;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(8);
        alVar.setShareReportFrom(6);
        alVar.setFromForPb(4);
        aVar.b(alVar);
        aVar.sc().setBackgroundResource(R.drawable.addresslist_item_bg);
        ai sd = aVar.sd();
        sd.setSourceForPb(4);
        ak<k> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        akVar.br(this.kLS);
        a(new z() { // from class: com.baidu.tieba.personPolymeric.a.a.e.5
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (e.this.adX != null) {
                        e.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 4, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ak<k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        akVar.se().setPage(this.afG);
        if (!this.mIsHost) {
            akVar.sg();
        }
        akVar.b((ak<k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.personPolymeric.a.h(kVar);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void Cv(int i) {
        this.kLR = i;
    }

    public void setTabType(int i) {
        this.gyV = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Cu(int i) {
        this.kLS = i;
    }
}
