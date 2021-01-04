package com.baidu.tieba.recapp.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.d, CardAppLegoViewHolder> implements k, o {
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    private CustomMessageListener kpw;
    private boolean mIsFromCDN;
    AdvertAppInfo.ILegoAdvert mNk;
    Runnable mNl;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.mNk = null;
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHK */
            public ConstrainImageLayout makeObject() {
                return new AdConstrainImageLayout(b.this.mPageContext.getPageActivity());
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.recapp.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byk */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
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
        this.mNl = new Runnable() { // from class: com.baidu.tieba.recapp.adapter.b.5
            @Override // java.lang.Runnable
            public void run() {
                ((CardAppLegoViewHolder) b.this.Wu).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        };
        this.kpw = new CustomMessageListener(2921517) { // from class: com.baidu.tieba.recapp.adapter.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.Wu != null) {
                    if (!(customResponsedMessage.getData() instanceof Boolean)) {
                        ((CardAppLegoViewHolder) b.this.Wu).stopPlay();
                    } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ((CardAppLegoViewHolder) b.this.Wu).stopPlay();
                    } else {
                        int playStatus = ((CardAppLegoViewHolder) b.this.Wu).getPlayStatus();
                        if (((CardAppLegoViewHolder) b.this.Wu).canPlay()) {
                            if (playStatus == -1) {
                                com.baidu.adp.lib.f.e.mB().removeCallbacks(b.this.mNl);
                                com.baidu.adp.lib.f.e.mB().postDelayed(b.this.mNl, 500L);
                            }
                        } else if (playStatus != -1) {
                            ((CardAppLegoViewHolder) b.this.Wu).stopPlay();
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.eNO || bdUniqueId == AdvertAppInfo.eNQ) {
                MessageManager.getInstance().registerListener(this.kpw);
            }
        }
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
        if (dVar == null || dVar.izk == null || dVar.izk.legoCard == null) {
            return null;
        }
        this.mNk = dVar.izk.legoCard;
        if (eb(view)) {
            this.Wu = e(viewGroup);
            if (this.Wu != 0) {
                view2 = ((CardAppLegoViewHolder) this.Wu).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
                    if (m.class.isAssignableFrom(a2.getClass())) {
                        ((CardAppLegoViewHolder) this.Wu).a(((m) a2).getVideoOrVrView());
                        return a2;
                    }
                    return a2;
                }
                return view2;
            }
        }
        view2 = view;
        if (view2 == null) {
        }
    }

    private boolean eb(View view) {
        if (view == null || view.getTag() == null || this.Wu == 0 || this.mNk == null) {
            return true;
        }
        if (((CardAppLegoViewHolder) this.Wu).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.Wu).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.mNk.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cS */
    public CardAppLegoViewHolder e(ViewGroup viewGroup) {
        View view;
        if (this.mNk != null && (view = (View) com.baidu.tieba.lego.card.b.ddl().a(this.mPageContext, this.mNk, 2)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.jlF);
                adPostImageView.setConstrainLayoutPool(this.jlE);
            }
            view.setTag(R.id.tag_first, this.mNk);
            return new CardAppLegoViewHolder((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public CardAppLegoViewHolder a(ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar) {
        if (dVar == null || dVar.izk == null || dVar.izk.legoCard == null) {
            return null;
        }
        this.mNk = dVar.izk.legoCard;
        return e(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        if (this.mPageContext == null) {
            return null;
        }
        if (dVar == null || dVar.izk == null) {
            return null;
        }
        this.mNk = dVar.izk.legoCard;
        if (this.mNk == null || view == null) {
            return null;
        }
        if (this.Wu == 0) {
            this.Wu = cardAppLegoViewHolder;
        }
        com.baidu.tbadk.core.data.c.a(dVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        final AdvertAppInfo cvx = dVar.cvx();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        this.mNk.setAdvertAppInfo(cvx);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(this.mNk);
        final int i2 = dVar.mPn;
        final String str = dVar.fPy;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.b.3
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        b.this.a(cvx, true, i2, str, (HashMap<String, Object>) hashMap);
                    } else if (i3 == 3) {
                        b.this.a(cvx, false, i2, str, (String) null, (HashMap<String, Object>) hashMap);
                    } else {
                        b.this.a(cvx, false, i2, str, (HashMap<String, Object>) hashMap);
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                b.this.a(cvx, false, i2, str, str2, hashMap);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.adapter.b.3.1
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
                    }.execute(str3);
                }
            }
        });
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.adapter.b.4
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo, int i3) {
                h.a(b.this.mPageContext.getPageActivity(), advertAppInfo, i3, b.this.c(advertAppInfo, str));
            }
        });
        if (m.class.isAssignableFrom(view.getClass())) {
            cardAppLegoViewHolder.a(((m) view).getVideoOrVrView());
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
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.h.c(advertAppInfo, 2, i);
        c.Sa(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        c.Sf((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.e.dFV().a(c);
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

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kpw);
    }
}
