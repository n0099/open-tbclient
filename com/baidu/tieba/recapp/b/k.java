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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.data.l, l> implements m {
    private CustomMessageListener bMo;
    protected BaseActivity bSO;
    private CustomMessageListener eoj;
    private CustomMessageListener gCA;
    protected WeakReference<l> gCB;
    private boolean gCz;
    private boolean mIsFromCDN;

    public k(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.gCz = true;
        this.eoj = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && k.this.gCz) {
                    int playStatus = ((l) k.this.viewholder).getPlayStatus();
                    if (((l) k.this.viewholder).cg(k.this.mContext)) {
                        if (playStatus == -1) {
                            ((l) k.this.viewholder).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.viewholder).stopPlay();
                    }
                }
            }
        };
        this.bMo = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aQd();
            }
        };
        this.gCA = new CustomMessageListener(2004020) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.viewholder).stopPlay();
                }
            }
        };
        this.gCB = null;
        this.bSO = baseActivity;
        this.bSO.registerListener(this.eoj);
        this.bSO.registerListener(this.gCA);
        this.bSO.registerListener(this.bMo);
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
        if (lVar == null || lVar.bwK() == null) {
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
            AdvertAppInfo.ILegoAdvert bwK = lVar.bwK();
            Object tag = view.getTag(d.g.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && bwK.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public l onCreateViewHolder(ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar) {
        View view = (View) com.baidu.tieba.lego.card.b.aPz().a(this.bSO.getPageContext(), lVar.bwK(), 4);
        if (view != null) {
            return new l((com.baidu.tieba.lego.card.e.k) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar, l lVar2) {
        if (this.bSO == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bwK = lVar.bwK();
        view.setTag(d.g.tag_first, bwK);
        this.bSO.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bSO.getLayoutMode().aM(view);
        com.baidu.tbadk.core.data.b.a(lVar);
        if (!lVar.haO) {
            com.baidu.tbadk.distribute.a.KM().a(lVar.bwM(), lVar.forumId, lVar.threadId, "PB", "show", lVar.pageNumber);
            lVar.haO = true;
        }
        if (lVar != null) {
            com.baidu.tbadk.distribute.a.brA = lVar.dSg;
        }
        final AdvertAppInfo bwM = lVar.bwM();
        if (bwM.advertAppContext == null) {
            bwM.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        bwM.advertAppContext.pn = lVar.pageNumber;
        bwM.advertAppContext.aKi = "PB";
        com.baidu.tieba.lego.card.e.k kVar = (com.baidu.tieba.lego.card.e.k) view;
        bwK.setAdvertAppInfo(bwM);
        kVar.setFromCDN(this.mIsFromCDN);
        kVar.aT(bwK);
        final int i2 = lVar.pageNumber;
        final String str = lVar.forumId;
        kVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(bwM, true, i2, str);
                    } else if (i3 == 3) {
                        k.this.a(bwM, false, i2, str, (String) null);
                    } else {
                        k.this.a(bwM, false, i2, str);
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(bwM, false, i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
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
                    }.execute(str3);
                }
            }
        });
        kVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.k.5
            @Override // com.baidu.tieba.lego.card.c
            public void b(AdvertAppInfo advertAppInfo, int i3) {
                com.baidu.tieba.recapp.download.g.a(k.this.bSO.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.gCB == null || this.gCB.get() != lVar2) {
            this.gCB = new WeakReference<>(lVar2);
        }
        aQd();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.b.boX().a(com.baidu.tieba.recapp.report.e.c(advertAppInfo, 4, i));
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.b.boX().c(advertAppInfo.aKI, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str, String str2) {
        com.baidu.tbadk.distribute.a.KM().a(advertAppInfo, str, 0L, "FRS", "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, i2, i);
        c.rZ(str2);
        com.baidu.tieba.recapp.report.b.boX().a(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page("PB");
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.aKK);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void aQd() {
        l lVar = this.gCB != null ? this.gCB.get() : null;
        if (lVar != null) {
            lVar.aQd();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
