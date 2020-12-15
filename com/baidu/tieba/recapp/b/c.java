package com.baidu.tieba.recapp.b;

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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.d, d> implements com.baidu.tieba.recapp.k, o {
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZr;
    private com.baidu.adp.lib.d.b<TbImageView> iZs;
    private CustomMessageListener kck;
    AdvertAppInfo.ILegoAdvert mHX;
    Runnable mHY;
    private boolean mIsFromCDN;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.mHX = null;
        this.iZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEP */
            public ConstrainImageLayout makeObject() {
                return new AdConstrainImageLayout(c.this.mPageContext.getPageActivity());
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
        this.iZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.recapp.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(c.this.mPageContext.getPageActivity());
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
        this.mHY = new Runnable() { // from class: com.baidu.tieba.recapp.b.c.5
            @Override // java.lang.Runnable
            public void run() {
                ((d) c.this.Wx).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        };
        this.kck = new CustomMessageListener(2921517) { // from class: com.baidu.tieba.recapp.b.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Wx != null) {
                    if (!(customResponsedMessage.getData() instanceof Boolean)) {
                        ((d) c.this.Wx).stopPlay();
                    } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ((d) c.this.Wx).stopPlay();
                    } else {
                        int playStatus = ((d) c.this.Wx).getPlayStatus();
                        if (((d) c.this.Wx).canPlay()) {
                            if (playStatus == -1) {
                                com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.mHY);
                                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mHY, 500L);
                            }
                        } else if (playStatus != -1) {
                            ((d) c.this.Wx).stopPlay();
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.eDY || bdUniqueId == AdvertAppInfo.eEa) {
                MessageManager.getInstance().registerListener(this.kck);
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
        if (dVar == null || dVar.imP == null || dVar.imP.legoCard == null) {
            return null;
        }
        this.mHX = dVar.imP.legoCard;
        if (dR(view)) {
            this.Wx = c(viewGroup);
            if (this.Wx != 0) {
                view2 = ((d) this.Wx).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, dVar, (d) view2.getTag());
                    if (m.class.isAssignableFrom(a2.getClass())) {
                        ((d) this.Wx).a(((m) a2).getVideoOrVrView());
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

    private boolean dR(View view) {
        if (view == null || view.getTag() == null || this.Wx == 0 || this.mHX == null) {
            return true;
        }
        if (((d) this.Wx).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((d) this.Wx).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.mHX.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cG */
    public d c(ViewGroup viewGroup) {
        View view;
        if (this.mHX != null && (view = (View) com.baidu.tieba.lego.card.b.ddA().a(this.mPageContext, this.mHX, 2)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.iZs);
                adPostImageView.setConstrainLayoutPool(this.iZr);
            }
            view.setTag(R.id.tag_first, this.mHX);
            return new d((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public d a(ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar) {
        if (dVar == null || dVar.imP == null || dVar.imP.legoCard == null) {
            return null;
        }
        this.mHX = dVar.imP.legoCard;
        return c(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar, d dVar2) {
        if (this.mPageContext == null) {
            return null;
        }
        if (dVar == null || dVar.imP == null) {
            return null;
        }
        this.mHX = dVar.imP.legoCard;
        if (this.mHX == null || view == null) {
            return null;
        }
        if (this.Wx == 0) {
            this.Wx = dVar2;
        }
        com.baidu.tbadk.core.data.c.a(dVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        final AdvertAppInfo csE = dVar.csE();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        this.mHX.setAdvertAppInfo(csE);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(this.mHX);
        final int i2 = dVar.mPn;
        final String str = dVar.fFV;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.c.3
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        c.this.a(csE, true, i2, str, (HashMap<String, Object>) hashMap);
                    } else if (i3 == 3) {
                        c.this.a(csE, false, i2, str, (String) null, (HashMap<String, Object>) hashMap);
                    } else {
                        c.this.a(csE, false, i2, str, (HashMap<String, Object>) hashMap);
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                c.this.a(csE, false, i2, str, str2, hashMap);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.c.3.1
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
                    }.execute(str3);
                }
            }
        });
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.c.4
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo, int i3) {
                com.baidu.tieba.recapp.download.h.a(c.this.mPageContext.getPageActivity(), advertAppInfo, i3, c.this.b(advertAppInfo, str));
            }
        });
        if (m.class.isAssignableFrom(view.getClass())) {
            dVar2.a(((m) view).getVideoOrVrView());
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
                        c.Sx((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.d.dGg().a(c);
        c.Jq(2);
        com.baidu.tieba.recapp.report.d.dGg().a(c);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2, HashMap<String, Object> hashMap) {
        com.baidu.tbadk.distribute.a.bCa().a(advertAppInfo, str, 0L, advertAppInfo.page, "click", i);
        com.baidu.tieba.recapp.report.c d = com.baidu.tieba.recapp.report.g.d(advertAppInfo, 2, i);
        d.Ss(str2);
        if (hashMap != null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next != null && "da_area".equals(next.getKey())) {
                    if (next.getValue() instanceof String) {
                        d.Sx((String) next.getValue());
                    }
                }
            }
        }
        com.baidu.tieba.recapp.report.d.dGg().a(d);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.page);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eEg);
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
        MessageManager.getInstance().unRegisterListener(this.kck);
    }
}
