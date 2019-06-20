package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.h<AdvertAppInfo, h> {
    private n cPJ;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ftY;
    private com.baidu.adp.lib.e.b<TbImageView> ftZ;
    AdvertAppInfo.ILegoAdvert izL;

    public g(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext(), bdUniqueId);
        this.izL = null;
        this.ftY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bmb */
            public ConstrainImageLayout makeObject() {
                return new AdConstrainImageLayout(g.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.ftZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.recapp.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajX */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.cPJ = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        View view2;
        if (advertAppInfo == null || advertAppInfo.legoCard == null) {
            return null;
        }
        this.izL = advertAppInfo.legoCard;
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
        if (view == null || view.getTag() == null || this.viewholder == 0 || this.izL == null) {
            return true;
        }
        if (((h) this.viewholder).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((h) this.viewholder).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.izL.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        View view;
        if (this.izL != null && (view = (View) com.baidu.tieba.lego.card.b.bHs().a(this.mPageContext, this.izL, 1)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.ftZ);
                adPostImageView.setConstrainLayoutPool(this.ftY);
            }
            view.setTag(R.id.tag_first, this.izL);
            return new h((com.baidu.tieba.lego.card.view.e) view);
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
        this.izL = advertAppInfo.legoCard;
        return onCreateViewHolder(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final AdvertAppInfo advertAppInfo, h hVar) {
        super.onFillViewHolder(i, view, viewGroup, advertAppInfo, hVar);
        if (this.cPJ == null) {
            return null;
        }
        this.izL = advertAppInfo.legoCard;
        if (this.izL == null || view == null) {
            return null;
        }
        this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (advertAppInfo instanceof AdvertAppInfo) {
            com.baidu.tbadk.core.data.c.a(advertAppInfo);
            com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
            eVar.setFromCDN(this.mIsFromCDN);
            eVar.ao(this.izL);
            final String fid = this.cPJ.getFid();
            final int pageNum = this.cPJ.getPageNum();
            this.cPJ.bkg();
            eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.g.3
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
                                    new x(strArr[0]).ahe();
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
                public void b(AdvertAppInfo advertAppInfo2, int i2) {
                    com.baidu.tieba.recapp.download.g.a(TbadkCoreApplication.getInst().getContext(), advertAppInfo2, i2, g.this.b(advertAppInfo2, fid));
                }
            });
            if (!advertAppInfo.bEe) {
                advertAppInfo.bEe = true;
                this.cPJ.a(advertAppInfo, SmsLoginView.StatEvent.LOGIN_SHOW);
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
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 706, i);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.Dp((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.c.cfH().a(c);
        c.yZ(2);
        com.baidu.tieba.recapp.report.c.cfH().a(c);
        if (z) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.c.cfH().f(advertAppInfo.bDV, hashMap2);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2, HashMap<String, Object> hashMap) {
        com.baidu.tbadk.distribute.a.aqF().a(advertAppInfo, str, 0L, "FRS", "click", i);
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 2, i);
        c.Dk(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.Dp((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.c.cfH().a(c);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page("FRS");
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.bDX);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        if (this.viewholder != 0) {
            ((h) this.viewholder).release();
        }
        super.release();
    }
}
