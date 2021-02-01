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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.AdConstrainImageLayout;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.d, CardAppLegoViewHolder> implements k, o {
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmF;
    private com.baidu.adp.lib.d.b<TbImageView> jmG;
    private CustomMessageListener ksY;
    private boolean mIsFromCDN;
    private TbPageContext<?> mPageContext;
    AdvertAppInfo.ILegoAdvert mRM;
    Runnable mRN;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.mRM = null;
        this.jmF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.recapp.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFf */
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
        this.jmG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.recapp.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
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
        this.mRN = new Runnable() { // from class: com.baidu.tieba.recapp.adapter.b.5
            @Override // java.lang.Runnable
            public void run() {
                ((CardAppLegoViewHolder) b.this.Wo).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        };
        this.ksY = new CustomMessageListener(2921517) { // from class: com.baidu.tieba.recapp.adapter.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.Wo != null) {
                    if (!(customResponsedMessage.getData() instanceof Boolean)) {
                        ((CardAppLegoViewHolder) b.this.Wo).stopPlay();
                    } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ((CardAppLegoViewHolder) b.this.Wo).stopPlay();
                    } else {
                        int playStatus = ((CardAppLegoViewHolder) b.this.Wo).getPlayStatus();
                        if (((CardAppLegoViewHolder) b.this.Wo).canPlay()) {
                            if (playStatus == -1) {
                                com.baidu.adp.lib.f.e.mA().removeCallbacks(b.this.mRN);
                                com.baidu.adp.lib.f.e.mA().postDelayed(b.this.mRN, 500L);
                            }
                        } else if (playStatus != -1) {
                            ((CardAppLegoViewHolder) b.this.Wo).stopPlay();
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.eLp || bdUniqueId == AdvertAppInfo.eLr) {
                MessageManager.getInstance().registerListener(this.ksY);
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
        if (dVar == null || dVar.iAn == null || dVar.iAn.legoCard == null) {
            return null;
        }
        this.mRM = dVar.iAn.legoCard;
        if (dZ(view)) {
            this.Wo = e(viewGroup);
            if (this.Wo != 0) {
                view2 = ((CardAppLegoViewHolder) this.Wo).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
                    if (m.class.isAssignableFrom(a2.getClass())) {
                        ((CardAppLegoViewHolder) this.Wo).a(((m) a2).getVideoOrVrView());
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

    private boolean dZ(View view) {
        if (view == null || view.getTag() == null || this.Wo == 0 || this.mRM == null) {
            return true;
        }
        if (((CardAppLegoViewHolder) this.Wo).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.Wo).getClass()) && (view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return !this.mRM.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cT */
    public CardAppLegoViewHolder e(ViewGroup viewGroup) {
        View view;
        if (this.mRM != null && (view = (View) com.baidu.tieba.lego.card.b.dbs().a(this.mPageContext, this.mRM, 2)) != null) {
            if (view instanceof AdPostImageView) {
                AdPostImageView adPostImageView = (AdPostImageView) view;
                adPostImageView.setConstrainImagePool(this.jmG);
                adPostImageView.setConstrainLayoutPool(this.jmF);
            }
            view.setTag(R.id.tag_first, this.mRM);
            return new CardAppLegoViewHolder((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public CardAppLegoViewHolder a(ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar) {
        if (dVar == null || dVar.iAn == null || dVar.iAn.legoCard == null) {
            return null;
        }
        this.mRM = dVar.iAn.legoCard;
        return e(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        if (this.mPageContext == null) {
            return null;
        }
        if (dVar == null || dVar.iAn == null) {
            return null;
        }
        this.mRM = dVar.iAn.legoCard;
        if (this.mRM == null || view == null) {
            return null;
        }
        if (this.Wo == 0) {
            this.Wo = cardAppLegoViewHolder;
        }
        com.baidu.tbadk.core.data.d.a(dVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        final AdvertAppInfo csS = dVar.csS();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        this.mRM.setAdvertAppInfo(csS);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(this.mRM);
        final int i2 = dVar.mPn;
        final String str = dVar.fNd;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.b.3
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (s.HL(i3)) {
                        com.baidu.tieba.recapp.report.d.a(csS, i2, hashMap, i3);
                    } else {
                        com.baidu.tieba.recapp.report.d.a(csS, i2, str, (String) null, hashMap);
                    }
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(csS));
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                com.baidu.tieba.recapp.report.d.a(csS, i2, str, str2, hashMap);
                com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(csS));
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.adapter.b.3.1
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
    public DownloadStaticsData c(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.page);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eLx);
        downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
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
        MessageManager.getInstance().unRegisterListener(this.ksY);
    }
}
