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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.CriusAdCardView;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, l> implements com.baidu.tieba.recapp.l {
    private CustomMessageListener ePf;
    protected BaseFragmentActivity hep;
    private CustomMessageListener iCJ;
    private boolean leX;
    private CustomMessageListener leY;
    protected WeakReference<l> leZ;
    private boolean mIsFromCDN;

    public k(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.leX = true;
        this.iCJ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Up != null && k.this.leX) {
                    int playStatus = ((l) k.this.Up).getPlayStatus();
                    if (((l) k.this.Up).fi(k.this.mContext)) {
                        if (playStatus == -1) {
                            ((l) k.this.Up).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.Up).stopPlay();
                    }
                }
            }
        };
        this.ePf = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cxF();
            }
        };
        this.leY = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Up != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.Up).stopPlay();
                }
            }
        };
        this.leZ = null;
        this.hep = baseFragmentActivity;
        this.hep.registerListener(this.iCJ);
        this.hep.registerListener(this.leY);
        this.hep.registerListener(this.ePf);
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
        if (nVar == null || nVar.dhO() == null) {
            return null;
        }
        if (a(view, nVar)) {
            this.Up = a(viewGroup, nVar);
            if (this.Up != 0) {
                view2 = ((l) this.Up).getView();
                if (view2 == null) {
                    View a = a(i, view2, viewGroup, nVar, (l) view2.getTag());
                    if (com.baidu.tieba.recapp.j.class.isAssignableFrom(a.getClass())) {
                        ((l) this.Up).a(((com.baidu.tieba.recapp.j) a).getVideoOrVrView());
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
        if (view == null || view.getTag() == null || this.Up == 0) {
            return true;
        }
        if (((l) this.Up).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.Up).getClass())) {
            AdvertAppInfo.ILegoAdvert dhO = nVar.dhO();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dhO.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cG */
    public l b(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public l a(ViewGroup viewGroup, n nVar) {
        View view = (View) com.baidu.tieba.lego.card.b.cxd().a(this.hep.getPageContext(), nVar.dhO(), 4);
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
        if (this.hep == null) {
            return null;
        }
        if (nVar.dhO() instanceof AdCard) {
            ((AdCard) nVar.dhO()).isPBBanner = nVar.lFJ;
        }
        lVar.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dhO = nVar.dhO();
        view.setTag(R.id.tag_first, dhO);
        this.hep.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hep.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.b.a(nVar);
        if (!nVar.lFK) {
            com.baidu.tbadk.distribute.a.beN().a(nVar.pL(), nVar.forumId, nVar.threadId, nVar.dhQ(), "show", nVar.pageNumber);
            nVar.lFK = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.esT = nVar.hTf;
        }
        final AdvertAppInfo pL = nVar.pL();
        if (pL.advertAppContext == null) {
            pL.advertAppContext = new com.baidu.tbadk.core.data.b();
        }
        pL.advertAppContext.pn = nVar.pageNumber;
        pL.advertAppContext.page = nVar.dhQ();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dhO.setAdvertAppInfo(pL);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aE(dhO);
        final int i2 = nVar.pageNumber;
        final String str = nVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(pL, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(pL, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(pL, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(pL, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Void doInBackground(String... strArr) {
                            if (strArr != null && strArr.length > 0) {
                                new y(strArr[0]).postNetData();
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
                com.baidu.tieba.recapp.download.h.a(k.this.hep.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.leZ == null || this.leZ.get() != lVar) {
            this.leZ = new WeakReference<>(lVar);
        }
        cxF();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.d.cZR().a(a);
        a.Du(2);
        com.baidu.tieba.recapp.report.d.cZR().a(a);
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.d.cZR().f(advertAppInfo.dGN, hashMap);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.beN().a(advertAppInfo, str2, 0L, g(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, i2, i);
        a.Ma(str3);
        com.baidu.tieba.recapp.report.d.cZR().a(a);
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
        downloadStaticsData.setApk_name(advertAppInfo.dGO);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void cxF() {
        l lVar = this.leZ != null ? this.leZ.get() : null;
        if (lVar != null && !(lVar.hTt instanceof CriusAdCardView)) {
            lVar.cxF();
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
