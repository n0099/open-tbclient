package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.view.CriusAdCardView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.data.l, l> implements m {
    private CustomMessageListener boJ;
    protected BaseActivity bxI;
    private CustomMessageListener etp;
    private boolean gFg;
    private CustomMessageListener gFh;
    protected WeakReference<l> gFi;
    private boolean mIsFromCDN;

    public k(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.gFg = true;
        this.etp = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && k.this.gFg) {
                    int playStatus = ((l) k.this.viewholder).getPlayStatus();
                    if (((l) k.this.viewholder).cS(k.this.mContext)) {
                        if (playStatus == -1) {
                            ((l) k.this.viewholder).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.viewholder).stopPlay();
                    }
                }
            }
        };
        this.boJ = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aWB();
            }
        };
        this.gFh = new CustomMessageListener(2004020) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.viewholder).stopPlay();
                }
            }
        };
        this.gFi = null;
        this.bxI = baseActivity;
        this.bxI.registerListener(this.etp);
        this.bxI.registerListener(this.gFh);
        this.bxI.registerListener(this.boJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar) {
        View view2;
        if (lVar == null || lVar.bBm() == null) {
            return null;
        }
        if (a(view, lVar)) {
            this.viewholder = onCreateViewHolder(viewGroup, lVar);
            if (this.viewholder != 0) {
                view2 = ((l) this.viewholder).getView();
                if (view2 == null) {
                    View onFillViewHolder = onFillViewHolder(i, view2, viewGroup, lVar, (l) view2.getTag());
                    if (com.baidu.tieba.recapp.k.class.isAssignableFrom(onFillViewHolder.getClass())) {
                        ((l) this.viewholder).a(((com.baidu.tieba.recapp.k) onFillViewHolder).getVideoOrVrView());
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

    private boolean a(View view, com.baidu.tieba.tbadkCore.data.l lVar) {
        if (view == null || view.getTag() == null || this.viewholder == 0) {
            return true;
        }
        if (((l) this.viewholder).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.viewholder).getClass())) {
            AdvertAppInfo.ILegoAdvert bBm = lVar.bBm();
            Object tag = view.getTag(e.g.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && bBm.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public l onCreateViewHolder(ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar) {
        View view = (View) com.baidu.tieba.lego.card.b.aVX().a(this.bxI.getPageContext(), lVar.bBm(), 4);
        if (view != null) {
            return new l((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar, l lVar2) {
        if (this.bxI == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bBm = lVar.bBm();
        view.setTag(e.g.tag_first, bBm);
        this.bxI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bxI.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.b.a(lVar);
        if (!lVar.her) {
            com.baidu.tbadk.distribute.a.KG().a(lVar.pv(), lVar.forumId, lVar.threadId, lVar.bBo(), "show", lVar.pageNumber);
            lVar.her = true;
        }
        if (lVar != null) {
            com.baidu.tbadk.distribute.a.aTX = lVar.dSr;
        }
        final AdvertAppInfo pv = lVar.pv();
        if (pv.advertAppContext == null) {
            pv.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        pv.advertAppContext.pn = lVar.pageNumber;
        pv.advertAppContext.page = lVar.bBo();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        bBm.setAdvertAppInfo(pv);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.Z(bBm);
        final int i2 = lVar.pageNumber;
        final String str = lVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(pv, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(pv, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(pv, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(pv, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Void doInBackground(String... strArr) {
                            if (strArr != null && strArr.length > 0) {
                                new x(strArr[0]).BH();
                                return null;
                            }
                            return null;
                        }
                    }.execute(str3);
                }
            }
        });
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.k.5
            @Override // com.baidu.tieba.lego.card.c
            public void b(AdvertAppInfo advertAppInfo, int i3) {
                com.baidu.tieba.recapp.download.g.a(k.this.bxI.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.gFi == null || this.gFi.get() != lVar2) {
            this.gFi = new WeakReference<>(lVar2);
        }
        aWB();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.c.btB().a(a);
        a.tz(2);
        com.baidu.tieba.recapp.report.c.btB().a(a);
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.c.btB().d(advertAppInfo.alS, hashMap);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.KG().a(advertAppInfo, str2, 0L, g(advertAppInfo), AiAppsUBCStatistic.TYPE_CLICK, i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(advertAppInfo, str, i2, i);
        a.uo(str3);
        com.baidu.tieba.recapp.report.c.btB().a(a);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    private String g(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.page) ? "PB" : advertAppInfo.page;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(g(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.alU);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void aWB() {
        l lVar = this.gFi != null ? this.gFi.get() : null;
        if (lVar != null && !(lVar.dSG instanceof CriusAdCardView)) {
            lVar.aWB();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
