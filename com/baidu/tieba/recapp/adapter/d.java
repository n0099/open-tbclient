package com.baidu.tieba.recapp.adapter;

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
import com.baidu.tieba.frs.k;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    private q gcm;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmT;
    private com.baidu.adp.lib.d.b<TbImageView> jmU;
    AdvertAppInfo.ILegoAdvert mSe;

    public d(q qVar, BdUniqueId bdUniqueId) {
        super(qVar.getTbPageContext(), bdUniqueId);
        this.mSe = null;
        this.jmT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.adapter.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFm */
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
        this.jmU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.recapp.adapter.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(d.this.mPageContext.getPageActivity());
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
        this.gcm = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        View view2;
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.mSe = advertAppInfo.legoCard;
        if (dZ(view)) {
            this.Wo = e(viewGroup);
            if (this.Wo == 0) {
                return null;
            }
            view2 = ((FrsAppLegoViewHolder) this.Wo).getView();
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
    }

    private boolean dZ(View view) {
        if (view == null || view.getTag() == null || this.Wo == 0 || this.mSe == null) {
            return true;
        }
        if (((FrsAppLegoViewHolder) this.Wo).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.Wo).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.mSe.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cV */
    public FrsAppLegoViewHolder e(ViewGroup viewGroup) {
        View view;
        if (this.mSe != null && (view = (View) com.baidu.tieba.lego.card.b.dbz().a(this.mPageContext, this.mSe, 1)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.jmU);
                adPostImageView.setConstrainLayoutPool(this.jmT);
            }
            view.setTag(R.id.tag_first, this.mSe);
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
        this.mSe = advertAppInfo.legoCard;
        return e(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) advertAppInfo, (AdvertAppInfo) frsAppLegoViewHolder);
        if (this.gcm == null) {
            return null;
        }
        this.mSe = advertAppInfo.legoCard;
        if (this.mSe == null || view == null) {
            return null;
        }
        this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (cCo()) {
            advertAppInfo.position = i - this.jfU.getTopThreadSize();
        }
        com.baidu.tbadk.core.data.d.a(advertAppInfo);
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(this.mSe);
        final String fid = this.gcm.getFid();
        final int pageNum = this.gcm.getPageNum();
        this.gcm.cDa();
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.d.3
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i2, HashMap<String, Object> hashMap) {
                if (t.HL(i2)) {
                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, pageNum, hashMap, i2);
                } else {
                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, pageNum, fid, (String) null, hashMap);
                }
                com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str, String str2, HashMap<String, Object> hashMap) {
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                hashMap.put("da_area", "button");
                com.baidu.tieba.recapp.report.d.a(advertAppInfo, pageNum, fid, str, hashMap);
                com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
                if (!TextUtils.isEmpty(str2)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.adapter.d.3.1
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
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.adapter.d.4
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo2, int i2) {
                h.a(TbadkCoreApplication.getInst().getContext(), advertAppInfo2, i2, d.this.c(advertAppInfo2, fid));
            }
        });
        if (!advertAppInfo.eLD) {
            advertAppInfo.eLD = true;
            this.gcm.a(advertAppInfo, "show");
        }
        if (n.class.isAssignableFrom(view.getClass())) {
            frsAppLegoViewHolder.a(((n) view).getVideoOrVrView());
            return view;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData c(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.page);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eLw);
        downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        if (this.Wo != 0) {
            ((FrsAppLegoViewHolder) this.Wo).release();
        }
        super.release();
    }
}
