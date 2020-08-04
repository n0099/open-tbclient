package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.CriusAdCardView;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes20.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, l> implements com.baidu.tieba.recapp.i, m {
    private CustomMessageListener eVA;
    protected BaseFragmentActivity hjZ;
    private CustomMessageListener iIP;
    private boolean lmn;
    private CustomMessageListener lmo;
    protected WeakReference<l> lmp;
    private boolean mIsFromCDN;

    public k(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.lmn = true;
        this.iIP = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Uj != null && k.this.lmn) {
                    int playStatus = ((l) k.this.Uj).getPlayStatus();
                    if (((l) k.this.Uj).canPlay()) {
                        if (playStatus == -1) {
                            ((l) k.this.Uj).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.Uj).stopPlay();
                    }
                }
            }
        };
        this.eVA = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cBD();
            }
        };
        this.lmo = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Uj != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.Uj).stopPlay();
                }
            }
        };
        this.lmp = null;
        this.hjZ = baseFragmentActivity;
        this.hjZ.registerListener(this.iIP);
        this.hjZ.registerListener(this.lmo);
        this.hjZ.registerListener(this.eVA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup, n nVar) {
        View view2;
        if (nVar == null || nVar.dkX() == null) {
            return null;
        }
        if (a(view, nVar)) {
            this.Uj = a(viewGroup, nVar);
            if (this.Uj != 0) {
                view2 = ((l) this.Uj).getView();
                if (view2 == null) {
                    View a = a(i, view2, viewGroup, nVar, (l) view2.getTag());
                    if (com.baidu.tieba.recapp.k.class.isAssignableFrom(a.getClass())) {
                        ((l) this.Uj).a(((com.baidu.tieba.recapp.k) a).getVideoOrVrView());
                        return a;
                    }
                    return a;
                }
                return view2;
            }
        }
        view2 = view;
        if (view2 == null) {
        }
    }

    private boolean a(View view, n nVar) {
        if (view == null || view.getTag() == null || this.Uj == 0) {
            return true;
        }
        if (((l) this.Uj).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.Uj).getClass())) {
            AdvertAppInfo.ILegoAdvert dkX = nVar.dkX();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dkX.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cJ */
    public l b(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public l a(ViewGroup viewGroup, n nVar) {
        View view = (View) com.baidu.tieba.lego.card.b.cBb().a(this.hjZ.getPageContext(), nVar.dkX(), 4);
        if (view != null) {
            l lVar = new l((com.baidu.tieba.lego.card.view.e) view);
            lVar.setIsRecyclable(false);
            return lVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, l lVar) {
        if (this.hjZ == null) {
            return null;
        }
        if (nVar.dkX() instanceof AdCard) {
            ((AdCard) nVar.dkX()).isPBBanner = nVar.lNa;
        }
        lVar.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dkX = nVar.dkX();
        view.setTag(R.id.tag_first, dkX);
        this.hjZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hjZ.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.b.a(nVar);
        if (!nVar.lNb) {
            com.baidu.tbadk.distribute.a.biw().a(nVar.pM(), nVar.forumId, nVar.threadId, nVar.dkZ(), "show", nVar.pageNumber);
            nVar.lNb = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.ezm = nVar.hZg;
        }
        final AdvertAppInfo pM = nVar.pM();
        if (pM.advertAppContext == null) {
            pM.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        pM.advertAppContext.pn = nVar.pageNumber;
        pM.advertAppContext.page = nVar.dkZ();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dkX.setAdvertAppInfo(pM);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aE(dkX);
        final int i2 = nVar.pageNumber;
        final String str = nVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(pM, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(pM, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(pM, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(pM, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
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
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.k.5
            @Override // com.baidu.tieba.lego.card.c
            public void b(AdvertAppInfo advertAppInfo, int i3) {
                com.baidu.tieba.recapp.download.h.a(k.this.hjZ.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.lmp == null || this.lmp.get() != lVar) {
            this.lmp = new WeakReference<>(lVar);
        }
        cBD();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.d.dcY().a(a);
        a.DQ(2);
        com.baidu.tieba.recapp.report.d.dcY().a(a);
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.d.dcY().f(advertAppInfo.dMY, hashMap);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.biw().a(advertAppInfo, str2, 0L, g(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, i2, i);
        a.MI(str3);
        com.baidu.tieba.recapp.report.d.dcY().a(a);
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
        downloadStaticsData.setApk_name(advertAppInfo.dMZ);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void cBD() {
        l lVar = this.lmp != null ? this.lmp.get() : null;
        if (lVar != null && !(lVar.hZu instanceof CriusAdCardView)) {
            lVar.cBD();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public void onPause() {
        if (this.Uj != 0) {
            ((l) this.Uj).stopPlay();
        }
        this.lmn = false;
    }

    @Override // com.baidu.tieba.recapp.i
    public void onResume() {
        if (this.Uj != 0 && ((l) this.Uj).canPlay()) {
            if (((l) this.Uj).getPlayStatus() == -1) {
                ((l) this.Uj).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.lmn = true;
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void onDestroy() {
        if (this.Uj != 0) {
            ((l) this.Uj).release();
        }
    }
}
