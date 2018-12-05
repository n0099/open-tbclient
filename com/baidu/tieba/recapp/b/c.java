package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.d, d> implements m {
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dMD;
    private com.baidu.adp.lib.e.b<TbImageView> dME;
    AdvertAppInfo.ILegoAdvert gLO;
    private boolean mIsFromCDN;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.gLO = null;
        this.dMD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCN */
            public ConstrainImageLayout jz() {
                return new AdConstrainImageLayout(c.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dME = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.recapp.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ft */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(c.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar) {
        View view2;
        if (dVar == null || dVar.cXN == null || dVar.cXN.legoCard == null) {
            return null;
        }
        this.gLO = dVar.cXN.legoCard;
        if (bM(view)) {
            this.viewholder = onCreateViewHolder(viewGroup);
            if (this.viewholder != 0) {
                view2 = ((d) this.viewholder).getView();
                if (view2 == null) {
                    View onFillViewHolder = onFillViewHolder(i, view2, viewGroup, dVar, (d) view2.getTag());
                    if (com.baidu.tieba.recapp.k.class.isAssignableFrom(onFillViewHolder.getClass())) {
                        ((d) this.viewholder).a(((com.baidu.tieba.recapp.k) onFillViewHolder).getVideoOrVrView());
                        return onFillViewHolder;
                    }
                    return onFillViewHolder;
                }
                return view2;
            }
        }
        view2 = view;
        if (view2 == null) {
        }
    }

    private boolean bM(View view) {
        if (view == null || view.getTag() == null || this.viewholder == 0 || this.gLO == null) {
            return true;
        }
        if (((d) this.viewholder).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((d) this.viewholder).getClass()) && (view.getTag(e.g.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.gLO.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(e.g.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View view;
        if (this.gLO != null && (view = (View) com.baidu.tieba.lego.card.b.aXP().a(this.mPageContext, this.gLO, 2)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.dME);
                adPostImageView.setConstrainLayoutPool(this.dMD);
            }
            view.setTag(e.g.tag_first, this.gLO);
            return new d((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public d onCreateViewHolder(ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar) {
        if (dVar == null || dVar.cXN == null || dVar.cXN.legoCard == null) {
            return null;
        }
        this.gLO = dVar.cXN.legoCard;
        return onCreateViewHolder(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar, d dVar2) {
        if (this.mPageContext == null) {
            return null;
        }
        if (dVar == null || dVar.cXN == null) {
            return null;
        }
        this.gLO = dVar.cXN.legoCard;
        if (this.gLO == null || view == null) {
            return null;
        }
        com.baidu.tbadk.core.data.b.a(dVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        final AdvertAppInfo apV = dVar.apV();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        this.gLO.setAdvertAppInfo(apV);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.Z(this.gLO);
        final int i2 = dVar.mPn;
        final String str = dVar.cXO;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.c.3
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        c.this.a(apV, true, i2, str, (HashMap<String, Object>) hashMap);
                    } else if (i3 == 3) {
                        c.this.a(apV, false, i2, str, (String) null, (HashMap<String, Object>) hashMap);
                    } else {
                        c.this.a(apV, false, i2, str, (HashMap<String, Object>) hashMap);
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                c.this.a(apV, false, i2, str, str2, hashMap);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.c.3.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Void doInBackground(String... strArr) {
                            if (strArr != null && strArr.length > 0) {
                                new x(strArr[0]).CL();
                                return null;
                            }
                            return null;
                        }
                    }.execute(str3);
                }
            }
        });
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.c.4
            @Override // com.baidu.tieba.lego.card.c
            public void b(AdvertAppInfo advertAppInfo, int i3) {
                com.baidu.tieba.recapp.download.g.a(c.this.mPageContext.getPageActivity(), advertAppInfo, i3, c.this.b(advertAppInfo, str));
            }
        });
        if (com.baidu.tieba.recapp.k.class.isAssignableFrom(view.getClass())) {
            dVar2.a(((com.baidu.tieba.recapp.k) view).getVideoOrVrView());
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
                        c.uU((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.c.bvu().a(c);
        c.tT(2);
        com.baidu.tieba.recapp.report.c.bvu().a(c);
        if (z) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.c.bvu().d(advertAppInfo.apt, hashMap2);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2, HashMap<String, Object> hashMap) {
        com.baidu.tbadk.distribute.a.LK().a(advertAppInfo, str, 0L, "INDEX", AiAppsUBCStatistic.TYPE_CLICK, i);
        com.baidu.tieba.recapp.report.b d = com.baidu.tieba.recapp.report.f.d(advertAppInfo, 2, i);
        d.uP(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        d.uU((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.c.bvu().a(d);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page("INDEX");
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.apv);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
