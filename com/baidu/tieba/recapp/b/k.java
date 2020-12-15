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
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes26.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, l> implements com.baidu.tieba.recapp.k, o {
    private CustomMessageListener fQU;
    protected BaseFragmentActivity ixe;
    private CustomMessageListener kck;
    private boolean mIh;
    private CustomMessageListener mIi;
    protected WeakReference<l> mIj;
    private boolean mIsFromCDN;

    public k(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIh = true;
        this.kck = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Wx != null && k.this.mIh) {
                    int playStatus = ((l) k.this.Wx).getPlayStatus();
                    if (((l) k.this.Wx).canPlay()) {
                        if (playStatus == -1) {
                            ((l) k.this.Wx).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.Wx).stopPlay();
                    }
                }
            }
        };
        this.fQU = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.dec();
            }
        };
        this.mIi = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Wx != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.Wx).stopPlay();
                }
            }
        };
        this.mIj = null;
        this.ixe = baseFragmentActivity;
        this.ixe.registerListener(this.kck);
        this.ixe.registerListener(this.mIi);
        this.ixe.registerListener(this.fQU);
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
        if (nVar == null || nVar.dOW() == null) {
            return null;
        }
        if (a(view, nVar)) {
            this.Wx = a(viewGroup, nVar);
            if (this.Wx != 0) {
                view2 = ((l) this.Wx).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, nVar, (l) view2.getTag());
                    if (m.class.isAssignableFrom(a2.getClass())) {
                        ((l) this.Wx).a(((m) a2).getVideoOrVrView());
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
        if (view == null || view.getTag() == null || this.Wx == 0) {
            return true;
        }
        if (((l) this.Wx).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.Wx).getClass())) {
            AdvertAppInfo.ILegoAdvert dOW = nVar.dOW();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dOW.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cK */
    public l c(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public l a(ViewGroup viewGroup, n nVar) {
        View view = (View) com.baidu.tieba.lego.card.b.ddA().a(this.ixe.getPageContext(), nVar.dOW(), 4);
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
        if (this.ixe == null) {
            return null;
        }
        if (nVar.dOW() instanceof AdCard) {
            ((AdCard) nVar.dOW()).isPBBanner = nVar.nlG;
        }
        lVar.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dOW = nVar.dOW();
        view.setTag(R.id.tag_first, dOW);
        this.ixe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ixe.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.c.a(nVar);
        if (!nVar.nlH) {
            com.baidu.tbadk.distribute.a.bCa().a(nVar.rs(), nVar.forumId, nVar.threadId, nVar.dOY(), "show", nVar.pageNumber);
            nVar.nlH = true;
        }
        if (nVar != null) {
            com.baidu.tbadk.distribute.a.ftn = nVar.jqp;
        }
        final AdvertAppInfo rs = nVar.rs();
        if (rs.advertAppContext == null) {
            rs.advertAppContext = new com.baidu.tbadk.core.data.c();
        }
        rs.advertAppContext.pn = nVar.pageNumber;
        rs.advertAppContext.page = nVar.dOY();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dOW.setAdvertAppInfo(rs);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(dOW);
        final int i2 = nVar.pageNumber;
        final String str = nVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(rs, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(rs, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(rs, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(rs, "button", i2, str, str2);
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
                com.baidu.tieba.recapp.download.h.a(k.this.ixe.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.mIj == null || this.mIj.get() != lVar) {
            this.mIj = new WeakReference<>(lVar);
        }
        dec();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.d.dGg().a(a2);
        a2.Jq(2);
        com.baidu.tieba.recapp.report.d.dGg().a(a2);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.bCa().a(advertAppInfo, str2, 0L, i(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.g.a(advertAppInfo, str, i2, i);
        a2.Ss(str3);
        com.baidu.tieba.recapp.report.d.dGg().a(a2);
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(advertAppInfo));
    }

    private String i(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.page) ? "PB" : advertAppInfo.page;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData b(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(i(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eEg);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void dec() {
        l lVar = this.mIj != null ? this.mIj.get() : null;
        if (lVar != null) {
            lVar.dec();
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
        if (this.Wx != 0) {
            ((l) this.Wx).stopPlay();
        }
        this.mIh = false;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
        if (this.Wx != 0 && ((l) this.Wx).canPlay()) {
            if (((l) this.Wx).getPlayStatus() == -1) {
                ((l) this.Wx).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.mIh = true;
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
        if (this.Wx != 0) {
            ((l) this.Wx).release();
        }
    }
}
