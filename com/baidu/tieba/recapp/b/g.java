package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.g<AdvertAppInfo, h> {
    private n bNs;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKG;
    private com.baidu.adp.lib.e.b<TbImageView> dKH;
    AdvertAppInfo.ILegoAdvert gCs;

    public g(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.akO(), bdUniqueId);
        this.gCs = null;
        this.dKG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.recapp.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axx */
            public com.baidu.tbadk.widget.layout.b nl() {
                return new com.baidu.tieba.recapp.widget.a(g.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b at(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b au(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.dKH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.recapp.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0141d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.bNs = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        View view2;
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.gCs = advertAppInfo.legoCard;
        if (cK(view)) {
            this.viewholder = onCreateViewHolder(viewGroup);
            if (this.viewholder == 0) {
                return null;
            }
            view2 = ((h) this.viewholder).getView();
        } else {
            view2 = view;
        }
        return onFillViewHolder(i, view2, viewGroup, advertAppInfo, (h) view2.getTag());
    }

    private boolean cK(View view) {
        if (view == null || view.getTag() == null || this.viewholder == 0 || this.gCs == null) {
            return true;
        }
        if (((h) this.viewholder).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((h) this.viewholder).getClass()) && (view.getTag(d.g.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.gCs.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(d.g.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        View view;
        if (this.gCs != null && (view = (View) com.baidu.tieba.lego.card.b.aPz().a(this.mPageContext, this.gCs, 1)) != null) {
            if (view instanceof com.baidu.tieba.recapp.lego.view.a.b) {
                com.baidu.tieba.recapp.lego.view.a.b bVar = (com.baidu.tieba.recapp.lego.view.a.b) view;
                bVar.setConstrainImagePool(this.dKH);
                bVar.setConstrainLayoutPool(this.dKG);
            }
            view.setTag(d.g.tag_first, this.gCs);
            return new h((com.baidu.tieba.lego.card.e.k) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public h onCreateViewHolder(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.gCs = advertAppInfo.legoCard;
        return onCreateViewHolder(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final AdvertAppInfo advertAppInfo, h hVar) {
        super.onFillViewHolder(i, view, viewGroup, advertAppInfo, hVar);
        if (this.bNs == null) {
            return null;
        }
        this.gCs = advertAppInfo.legoCard;
        if (this.gCs == null || view == null) {
            return null;
        }
        this.mPageContext.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mPageContext.getLayoutMode().aM(view);
        if (advertAppInfo instanceof AdvertAppInfo) {
            com.baidu.tbadk.core.data.b.a(advertAppInfo);
            com.baidu.tieba.lego.card.e.k kVar = (com.baidu.tieba.lego.card.e.k) view;
            kVar.setFromCDN(this.mIsFromCDN);
            kVar.aT(this.gCs);
            final String fid = this.bNs.getFid();
            final int pageNum = this.bNs.getPageNum();
            this.bNs.avh();
            kVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.g.3
                @Override // com.baidu.tieba.lego.card.a
                public void b(int i2, HashMap<String, Object> hashMap) {
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
                public void b(String str, String str2, HashMap<String, Object> hashMap) {
                    g.this.a(advertAppInfo, false, pageNum, fid, str, hashMap);
                    if (!TextUtils.isEmpty(str2)) {
                        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.g.3.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Void doInBackground(String... strArr) {
                                if (strArr != null && strArr.length > 0) {
                                    new x(strArr[0]).Cb();
                                    return null;
                                }
                                return null;
                            }
                        }.execute(str2);
                    }
                }
            });
            kVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.g.4
                @Override // com.baidu.tieba.lego.card.c
                public void b(AdvertAppInfo advertAppInfo2, int i2) {
                    com.baidu.tieba.recapp.download.g.a(TbadkCoreApplication.getInst().getContext(), advertAppInfo2, i2, g.this.b(advertAppInfo2, fid));
                }
            });
            if (!advertAppInfo.aKI) {
                advertAppInfo.aKI = true;
                this.bNs.a(advertAppInfo, "show");
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
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 4, i);
        com.baidu.tieba.recapp.report.b.boX().a(c);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.se((String) next.getValue());
                    }
                }
            }
        }
        if (z) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.b.boX().c(advertAppInfo.aKy, hashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2, HashMap<String, Object> hashMap) {
        com.baidu.tbadk.distribute.a.KM().a(advertAppInfo, str, 0L, "FRS", "click", i);
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 2, i);
        c.rZ(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.se((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.b.boX().a(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page("FRS");
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.aKA);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    @Override // com.baidu.tieba.frs.g
    public void release() {
        if (this.viewholder != 0) {
            ((h) this.viewholder).release();
        }
        super.release();
    }
}
