package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.data.l, l> implements m {
    private CustomMessageListener beZ;
    protected BaseActivity bkU;
    private CustomMessageListener dUZ;
    private boolean gjI;
    private CustomMessageListener gjJ;
    protected WeakReference<l> gjK;
    private boolean mIsFromCDN;

    public k(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.gjI = true;
        this.dUZ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && k.this.gjI) {
                    int playStatus = ((l) k.this.viewholder).getPlayStatus();
                    if (((l) k.this.viewholder).cf(k.this.mContext)) {
                        if (playStatus == -1) {
                            ((l) k.this.viewholder).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.viewholder).stopPlay();
                    }
                }
            }
        };
        this.beZ = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aPZ();
            }
        };
        this.gjJ = new CustomMessageListener(2004020) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.viewholder).stopPlay();
                }
            }
        };
        this.gjK = null;
        this.bkU = baseActivity;
        this.bkU.registerListener(this.dUZ);
        this.bkU.registerListener(this.gjJ);
        this.bkU.registerListener(this.beZ);
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
        if (lVar == null || lVar.bwQ() == null) {
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
            AdvertAppInfo.ILegoAdvert bwQ = lVar.bwQ();
            Object tag = view.getTag(d.g.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && bwQ.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public l onCreateViewHolder(ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar) {
        View view = (View) com.baidu.tieba.lego.card.b.aPu().a(this.bkU.getPageContext(), lVar.bwQ(), 4);
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
        if (this.bkU == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bwQ = lVar.bwQ();
        view.setTag(d.g.tag_first, bwQ);
        this.bkU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bkU.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.b.a(lVar);
        if (!lVar.gIT) {
            com.baidu.tbadk.distribute.a.GR().a(lVar.ok(), lVar.forumId, lVar.threadId, "PB", "show", lVar.pageNumber);
            lVar.gIT = true;
        }
        if (lVar != null) {
            com.baidu.tbadk.distribute.a.aKo = lVar.dwC;
        }
        final AdvertAppInfo ok = lVar.ok();
        if (ok.advertAppContext == null) {
            ok.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        ok.advertAppContext.pn = lVar.pageNumber;
        ok.advertAppContext.adp = "PB";
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        bwQ.setAdvertAppInfo(ok);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.R(bwQ);
        final int i2 = lVar.pageNumber;
        final String str = lVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(ok, true, i2, str);
                    } else if (i3 == 3) {
                        k.this.a(ok, false, i2, str, (String) null);
                    } else {
                        k.this.a(ok, false, i2, str);
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(ok, false, i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Void doInBackground(String... strArr) {
                            if (strArr != null && strArr.length > 0) {
                                new y(strArr[0]).yl();
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
                com.baidu.tieba.recapp.download.g.a(k.this.bkU.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.gjK == null || this.gjK.get() != lVar2) {
            this.gjK = new WeakReference<>(lVar2);
        }
        aPZ();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 706, i);
        com.baidu.tieba.recapp.report.b.bpc().a(c);
        c.sd(2);
        com.baidu.tieba.recapp.report.b.bpc().a(c);
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.b.bpc().d(advertAppInfo.adO, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2) {
        com.baidu.tbadk.distribute.a.GR().a(advertAppInfo, str, 0L, "FRS", "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, i2, i);
        c.tb(str2);
        com.baidu.tieba.recapp.report.b.bpc().a(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page("PB");
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.adQ);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void aPZ() {
        l lVar = this.gjK != null ? this.gjK.get() : null;
        if (lVar != null) {
            lVar.aPZ();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
