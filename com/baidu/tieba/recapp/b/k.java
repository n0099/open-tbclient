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
import com.baidu.tbadk.core.util.aa;
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
    private CustomMessageListener fgi;
    protected BaseFragmentActivity hwQ;
    private CustomMessageListener iXN;
    private boolean lCO;
    private CustomMessageListener lCP;
    protected WeakReference<l> lCQ;
    private boolean mIsFromCDN;

    public k(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.lCO = true;
        this.iXN = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.UO != null && k.this.lCO) {
                    int playStatus = ((l) k.this.UO).getPlayStatus();
                    if (((l) k.this.UO).canPlay()) {
                        if (playStatus == -1) {
                            ((l) k.this.UO).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.UO).stopPlay();
                    }
                }
            }
        };
        this.fgi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cMv();
            }
        };
        this.lCP = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.UO != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.UO).stopPlay();
                }
            }
        };
        this.lCQ = null;
        this.hwQ = baseFragmentActivity;
        this.hwQ.registerListener(this.iXN);
        this.hwQ.registerListener(this.lCP);
        this.hwQ.registerListener(this.fgi);
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
        if (nVar == null || nVar.dwu() == null) {
            return null;
        }
        if (a(view, nVar)) {
            this.UO = a(viewGroup, nVar);
            if (this.UO != 0) {
                view2 = ((l) this.UO).getView();
                if (view2 == null) {
                    View a = a(i, view2, viewGroup, nVar, (l) view2.getTag());
                    if (com.baidu.tieba.recapp.k.class.isAssignableFrom(a.getClass())) {
                        ((l) this.UO).a(((com.baidu.tieba.recapp.k) a).getVideoOrVrView());
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
        if (view == null || view.getTag() == null || this.UO == 0) {
            return true;
        }
        if (((l) this.UO).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.UO).getClass())) {
            AdvertAppInfo.ILegoAdvert dwu = nVar.dwu();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dwu.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cF */
    public l b(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public l a(ViewGroup viewGroup, n nVar) {
        View view = (View) com.baidu.tieba.lego.card.b.cLT().a(this.hwQ.getPageContext(), nVar.dwu(), 4);
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
        if (this.hwQ == null) {
            return null;
        }
        if (nVar.dwu() instanceof AdCard) {
            ((AdCard) nVar.dwu()).isPBBanner = nVar.meK;
        }
        lVar.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dwu = nVar.dwu();
        view.setTag(R.id.tag_first, dwu);
        this.hwQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hwQ.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.b.a(nVar);
        if (!nVar.meL) {
            com.baidu.tbadk.distribute.a.bri().a(nVar.rl(), nVar.forumId, nVar.threadId, nVar.dww(), "show", nVar.pageNumber);
            nVar.meL = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.eJK = nVar.ino;
        }
        final AdvertAppInfo rl = nVar.rl();
        if (rl.advertAppContext == null) {
            rl.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        rl.advertAppContext.pn = nVar.pageNumber;
        rl.advertAppContext.page = nVar.dww();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dwu.setAdvertAppInfo(rl);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aG(dwu);
        final int i2 = nVar.pageNumber;
        final String str = nVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(rl, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(rl, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(rl, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(rl, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
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
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.b.k.5
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo, int i3) {
                com.baidu.tieba.recapp.download.h.a(k.this.hwQ.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.lCQ == null || this.lCQ.get() != lVar) {
            this.lCQ = new WeakReference<>(lVar);
        }
        cMv();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.d.doi().a(a);
        a.Gl(2);
        com.baidu.tieba.recapp.report.d.doi().a(a);
        boolean a2 = com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
        if (z && !a2) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.d.doi().f(advertAppInfo.dWh, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.bri().a(advertAppInfo, str2, 0L, f(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, i2, i);
        a.PF(str3);
        com.baidu.tieba.recapp.report.d.doi().a(a);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
    }

    private String f(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.page) ? "PB" : advertAppInfo.page;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(f(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.dWi);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void cMv() {
        l lVar = this.lCQ != null ? this.lCQ.get() : null;
        if (lVar != null && !(lVar.inD instanceof CriusAdCardView)) {
            lVar.cMv();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public void onPause() {
        if (this.UO != 0) {
            ((l) this.UO).stopPlay();
        }
        this.lCO = false;
    }

    @Override // com.baidu.tieba.recapp.i
    public void onResume() {
        if (this.UO != 0 && ((l) this.UO).canPlay()) {
            if (((l) this.UO).getPlayStatus() == -1) {
                ((l) this.UO).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.lCO = true;
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void onDestroy() {
        if (this.UO != 0) {
            ((l) this.UO).release();
        }
    }
}
