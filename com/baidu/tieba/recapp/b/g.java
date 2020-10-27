package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes26.dex */
public class g extends com.baidu.tieba.frs.k<AdvertAppInfo, h> {
    private n fHO;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iHO;
    private com.baidu.adp.lib.d.b<TbImageView> iHP;
    AdvertAppInfo.ILegoAdvert mnA;

    public g(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext(), bdUniqueId);
        this.mnA = null;
        this.iHO = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyu */
            public ConstrainImageLayout makeObject() {
                return new AdConstrainImageLayout(g.this.mPageContext.getPageActivity());
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
        this.iHP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.recapp.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bqz */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10264));
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
        this.fHO = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        View view2;
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.mnA = advertAppInfo.legoCard;
        if (dx(view)) {
            this.Vy = c(viewGroup);
            if (this.Vy == 0) {
                return null;
            }
            view2 = ((h) this.Vy).getView();
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, advertAppInfo, (h) view2.getTag());
    }

    private boolean dx(View view) {
        if (view == null || view.getTag() == null || this.Vy == 0 || this.mnA == null) {
            return true;
        }
        if (((h) this.Vy).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((h) this.Vy).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.mnA.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cH */
    public h c(ViewGroup viewGroup) {
        View view;
        if (this.mnA != null && (view = (View) com.baidu.tieba.lego.card.b.cWr().a(this.mPageContext, this.mnA, 1)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.iHP);
                adPostImageView.setConstrainLayoutPool(this.iHO);
            }
            view.setTag(R.id.tag_first, this.mnA);
            return new h((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public h a(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.mnA = advertAppInfo.legoCard;
        return c(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final AdvertAppInfo advertAppInfo, h hVar) {
        super.a(i, view, viewGroup, (ViewGroup) advertAppInfo, (AdvertAppInfo) hVar);
        if (this.fHO == null) {
            return null;
        }
        this.mnA = advertAppInfo.legoCard;
        if (this.mnA == null || view == null) {
            return null;
        }
        this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (advertAppInfo instanceof AdvertAppInfo) {
            com.baidu.tbadk.core.data.b.a(advertAppInfo);
            com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
            eVar.setFromCDN(this.mIsFromCDN);
            eVar.aM(this.mnA);
            final String fid = this.fHO.getFid();
            final int pageNum = this.fHO.getPageNum();
            this.fHO.cwi();
            eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.g.3
                @Override // com.baidu.tieba.lego.card.a
                public void d(int i2, HashMap<String, Object> hashMap) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            g.this.a(advertAppInfo, true, pageNum, fid, hashMap);
                        } else if (i2 == 3) {
                            g.this.a(advertAppInfo, false, pageNum, fid, (String) null, hashMap);
                        } else {
                            g.this.a(advertAppInfo, false, pageNum, fid, hashMap);
                        }
                    }
                }

                @Override // com.baidu.tieba.lego.card.a
                public void a(String str, String str2, HashMap<String, Object> hashMap) {
                    g.this.a(advertAppInfo, false, pageNum, fid, str, hashMap);
                    if (!TextUtils.isEmpty(str2)) {
                        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.g.3.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Void doInBackground(String... strArr) {
                                if (strArr != null && strArr.length > 0) {
                                    new aa(strArr[0]).postNetData();
                                    return null;
                                }
                                return null;
                            }
                        }.execute(str2);
                    }
                }
            });
            eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.g.4
                @Override // com.baidu.tieba.lego.card.c
                public void c(AdvertAppInfo advertAppInfo2, int i2) {
                    com.baidu.tieba.recapp.download.h.a(TbadkCoreApplication.getInst().getContext(), advertAppInfo2, i2, g.this.b(advertAppInfo2, fid));
                }
            });
            if (!advertAppInfo.etf) {
                advertAppInfo.etf = true;
                this.fHO.a(advertAppInfo, "show");
            }
        }
        if (com.baidu.tieba.recapp.k.class.isAssignableFrom(view.getClass())) {
            hVar.a(((com.baidu.tieba.recapp.k) view).getVideoOrVrView());
            return view;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, HashMap<String, Object> hashMap) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 706, i);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.Rw((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.d.dyN().a(c);
        c.HL(2);
        com.baidu.tieba.recapp.report.d.dyN().a(c);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2, HashMap<String, Object> hashMap) {
        com.baidu.tbadk.distribute.a.bwL().a(advertAppInfo, str, 0L, "FRS", "click", i);
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 2, i);
        c.Rr(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.Rw((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.d.dyN().a(c);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page("FRS");
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.esX);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        if (this.Vy != 0) {
            ((h) this.Vy).release();
        }
        super.release();
    }
}
