package com.baidu.tieba.recapp.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    private p gey;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    AdvertAppInfo.ILegoAdvert mNk;

    public d(p pVar, BdUniqueId bdUniqueId) {
        super(pVar.getTbPageContext(), bdUniqueId);
        this.mNk = null;
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.adapter.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHK */
            public ConstrainImageLayout makeObject() {
                return new AdConstrainImageLayout(d.this.mPageContext.getPageActivity());
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.recapp.adapter.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byk */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(d.this.mPageContext.getPageActivity());
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
        this.gey = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        View view2;
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.mNk = advertAppInfo.legoCard;
        if (eb(view)) {
            this.Wu = e(viewGroup);
            if (this.Wu == 0) {
                return null;
            }
            view2 = ((FrsAppLegoViewHolder) this.Wu).getView();
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
    }

    private boolean eb(View view) {
        if (view == null || view.getTag() == null || this.Wu == 0 || this.mNk == null) {
            return true;
        }
        if (((FrsAppLegoViewHolder) this.Wu).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.Wu).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.mNk.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cU */
    public FrsAppLegoViewHolder e(ViewGroup viewGroup) {
        View view;
        if (this.mNk != null && (view = (View) com.baidu.tieba.lego.card.b.ddl().a(this.mPageContext, this.mNk, 1)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.jlF);
                adPostImageView.setConstrainLayoutPool(this.jlE);
            }
            view.setTag(R.id.tag_first, this.mNk);
            return new FrsAppLegoViewHolder((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public FrsAppLegoViewHolder a(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.mNk = advertAppInfo.legoCard;
        return e(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) advertAppInfo, (AdvertAppInfo) frsAppLegoViewHolder);
        if (this.gey == null) {
            return null;
        }
        this.mNk = advertAppInfo.legoCard;
        if (this.mNk == null || view == null) {
            return null;
        }
        this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (advertAppInfo instanceof AdvertAppInfo) {
            com.baidu.tbadk.core.data.c.a(advertAppInfo);
            com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
            eVar.setFromCDN(this.mIsFromCDN);
            eVar.aN(this.mNk);
            final String fid = this.gey.getFid();
            final int pageNum = this.gey.getPageNum();
            this.gey.cFy();
            eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.d.3
                @Override // com.baidu.tieba.lego.card.a
                public void d(int i2, HashMap<String, Object> hashMap) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            d.this.a(advertAppInfo, true, pageNum, fid, hashMap);
                        } else if (i2 == 3) {
                            d.this.a(advertAppInfo, false, pageNum, fid, (String) null, hashMap);
                        } else {
                            d.this.a(advertAppInfo, false, pageNum, fid, hashMap);
                        }
                    }
                }

                @Override // com.baidu.tieba.lego.card.a
                public void a(String str, String str2, HashMap<String, Object> hashMap) {
                    d.this.a(advertAppInfo, false, pageNum, fid, str, hashMap);
                    if (!TextUtils.isEmpty(str2)) {
                        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.adapter.d.3.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Void doInBackground(String... strArr) {
                                if (strArr != null && strArr.length > 0) {
                                    new z(strArr[0]).postNetData();
                                    return null;
                                }
                                return null;
                            }
                        }.execute(str2);
                    }
                }
            });
            eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.adapter.d.4
                @Override // com.baidu.tieba.lego.card.c
                public void c(AdvertAppInfo advertAppInfo2, int i2) {
                    h.a(TbadkCoreApplication.getInst().getContext(), advertAppInfo2, i2, d.this.c(advertAppInfo2, fid));
                }
            });
            if (!advertAppInfo.eOd) {
                advertAppInfo.eOd = true;
                this.gey.a(advertAppInfo, "show");
            }
        }
        if (m.class.isAssignableFrom(view.getClass())) {
            frsAppLegoViewHolder.a(((m) view).getVideoOrVrView());
            return view;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, HashMap<String, Object> hashMap) {
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 706, i);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        b2.Sf((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.e.dFV().a(b2);
        b2.Jk(2);
        com.baidu.tieba.recapp.report.e.dFV().a(b2);
        com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2, HashMap<String, Object> hashMap) {
        com.baidu.tbadk.distribute.a.bEv().a(advertAppInfo, str, 0L, advertAppInfo.page, "click", i);
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 2, i);
        b2.Sa(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        b2.Sf((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.e.dFV().a(b2);
        com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData c(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.page);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eNW);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        if (this.Wu != 0) {
            ((FrsAppLegoViewHolder) this.Wu).release();
        }
        super.release();
    }
}
