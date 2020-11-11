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
/* loaded from: classes26.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, l> implements com.baidu.tieba.recapp.i, m {
    private CustomMessageListener fJF;
    protected BaseFragmentActivity ilu;
    private CustomMessageListener jNV;
    private boolean mIsFromCDN;
    private boolean mtG;
    private CustomMessageListener mtH;
    protected WeakReference<l> mtI;

    public k(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mtG = true;
        this.jNV = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Vy != null && k.this.mtG) {
                    int playStatus = ((l) k.this.Vy).getPlayStatus();
                    if (((l) k.this.Vy).canPlay()) {
                        if (playStatus == -1) {
                            ((l) k.this.Vy).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.Vy).stopPlay();
                    }
                }
            }
        };
        this.fJF = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cZu();
            }
        };
        this.mtH = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Vy != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.Vy).stopPlay();
                }
            }
        };
        this.mtI = null;
        this.ilu = baseFragmentActivity;
        this.ilu.registerListener(this.jNV);
        this.ilu.registerListener(this.mtH);
        this.ilu.registerListener(this.fJF);
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
        if (nVar == null || nVar.dJO() == null) {
            return null;
        }
        if (a(view, nVar)) {
            this.Vy = a(viewGroup, nVar);
            if (this.Vy != 0) {
                view2 = ((l) this.Vy).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, nVar, (l) view2.getTag());
                    if (com.baidu.tieba.recapp.k.class.isAssignableFrom(a2.getClass())) {
                        ((l) this.Vy).a(((com.baidu.tieba.recapp.k) a2).getVideoOrVrView());
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

    private boolean a(View view, n nVar) {
        if (view == null || view.getTag() == null || this.Vy == 0) {
            return true;
        }
        if (((l) this.Vy).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.Vy).getClass())) {
            AdvertAppInfo.ILegoAdvert dJO = nVar.dJO();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dJO.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public l c(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public l a(ViewGroup viewGroup, n nVar) {
        View view = (View) com.baidu.tieba.lego.card.b.cYS().a(this.ilu.getPageContext(), nVar.dJO(), 4);
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
        if (this.ilu == null) {
            return null;
        }
        if (nVar.dJO() instanceof AdCard) {
            ((AdCard) nVar.dJO()).isPBBanner = nVar.mWO;
        }
        lVar.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dJO = nVar.dJO();
        view.setTag(R.id.tag_first, dJO);
        this.ilu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ilu.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.b.a(nVar);
        if (!nVar.mWP) {
            com.baidu.tbadk.distribute.a.bzk().a(nVar.rq(), nVar.forumId, nVar.threadId, nVar.dJQ(), "show", nVar.pageNumber);
            nVar.mWP = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.fmC = nVar.jbX;
        }
        final AdvertAppInfo rq = nVar.rq();
        if (rq.advertAppContext == null) {
            rq.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        rq.advertAppContext.pn = nVar.pageNumber;
        rq.advertAppContext.page = nVar.dJQ();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dJO.setAdvertAppInfo(rq);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aM(dJO);
        final int i2 = nVar.pageNumber;
        final String str = nVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(rq, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(rq, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(rq, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(rq, "button", i2, str, str2);
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
                com.baidu.tieba.recapp.download.h.a(k.this.ilu.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.mtI == null || this.mtI.get() != lVar) {
            this.mtI = new WeakReference<>(lVar);
        }
        cZu();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.d.dBp().a(a2);
        a2.HY(2);
        com.baidu.tieba.recapp.report.d.dBp().a(a2);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.bzk().a(advertAppInfo, str2, 0L, f(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, i2, i);
        a2.RI(str3);
        com.baidu.tieba.recapp.report.d.dBp().a(a2);
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
        downloadStaticsData.setApk_name(advertAppInfo.eyR);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void cZu() {
        l lVar = this.mtI != null ? this.mtI.get() : null;
        if (lVar != null && !(lVar.jcl instanceof CriusAdCardView)) {
            lVar.cZu();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public void onPause() {
        if (this.Vy != 0) {
            ((l) this.Vy).stopPlay();
        }
        this.mtG = false;
    }

    @Override // com.baidu.tieba.recapp.i
    public void onResume() {
        if (this.Vy != 0 && ((l) this.Vy).canPlay()) {
            if (((l) this.Vy).getPlayStatus() == -1) {
                ((l) this.Vy).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.mtG = true;
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void onDestroy() {
        if (this.Vy != 0) {
            ((l) this.Vy).release();
        }
    }
}
