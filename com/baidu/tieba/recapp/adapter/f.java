package com.baidu.tieba.recapp.adapter;

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
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.widget.ListView.a<o, PbAppLegoViewHolder> implements k, com.baidu.tieba.recapp.o {
    private CustomMessageListener gay;
    protected BaseFragmentActivity iJr;
    private CustomMessageListener kpw;
    private boolean mIsFromCDN;
    private boolean mNs;
    private CustomMessageListener mNt;
    protected WeakReference<PbAppLegoViewHolder> mNu;

    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mNs = true;
        this.kpw = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.Wu != null && f.this.mNs) {
                    int playStatus = ((PbAppLegoViewHolder) f.this.Wu).getPlayStatus();
                    if (((PbAppLegoViewHolder) f.this.Wu).canPlay()) {
                        if (playStatus == -1) {
                            ((PbAppLegoViewHolder) f.this.Wu).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((PbAppLegoViewHolder) f.this.Wu).stopPlay();
                    }
                }
            }
        };
        this.gay = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.adapter.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.ddO();
            }
        };
        this.mNt = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.adapter.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.Wu != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((PbAppLegoViewHolder) f.this.Wu).stopPlay();
                }
            }
        };
        this.mNu = null;
        this.iJr = baseFragmentActivity;
        this.iJr.registerListener(this.kpw);
        this.iJr.registerListener(this.mNt);
        this.iJr.registerListener(this.gay);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup, o oVar) {
        View view2;
        if (oVar == null || oVar.dOT() == null) {
            return null;
        }
        if (a(view, oVar)) {
            this.Wu = a(viewGroup, oVar);
            if (this.Wu != 0) {
                view2 = ((PbAppLegoViewHolder) this.Wu).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, oVar, (PbAppLegoViewHolder) view2.getTag());
                    if (m.class.isAssignableFrom(a2.getClass())) {
                        ((PbAppLegoViewHolder) this.Wu).a(((m) a2).getVideoOrVrView());
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

    private boolean a(View view, o oVar) {
        if (view == null || view.getTag() == null || this.Wu == 0) {
            return true;
        }
        if (((PbAppLegoViewHolder) this.Wu).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.Wu).getClass())) {
            AdvertAppInfo.ILegoAdvert dOT = oVar.dOT();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dOT.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cW */
    public PbAppLegoViewHolder e(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public PbAppLegoViewHolder a(ViewGroup viewGroup, o oVar) {
        View view = (View) com.baidu.tieba.lego.card.b.ddm().a(this.iJr.getPageContext(), oVar.dOT(), 4);
        if (view != null) {
            PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((com.baidu.tieba.lego.card.view.e) view);
            pbAppLegoViewHolder.setIsRecyclable(false);
            return pbAppLegoViewHolder;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        if (this.iJr == null) {
            return null;
        }
        if (oVar.dOT() instanceof AdCard) {
            ((AdCard) oVar.dOT()).isPBBanner = oVar.nrr;
        }
        pbAppLegoViewHolder.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dOT = oVar.dOT();
        view.setTag(R.id.tag_first, dOT);
        this.iJr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iJr.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.c.a(oVar);
        if (!oVar.nrs) {
            com.baidu.tbadk.distribute.a.bEw().a(oVar.qU(), oVar.forumId, oVar.threadId, oVar.dOV(), "show", oVar.pageNumber);
            oVar.nrs = true;
        }
        if (oVar != null) {
            com.baidu.tbadk.distribute.a.fCT = oVar.jCL;
        }
        final AdvertAppInfo qU = oVar.qU();
        if (qU.advertAppContext == null) {
            qU.advertAppContext = new com.baidu.tbadk.core.data.c();
        }
        qU.advertAppContext.pn = oVar.pageNumber;
        qU.advertAppContext.page = oVar.dOV();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dOT.setAdvertAppInfo(qU);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(dOT);
        final int i2 = oVar.pageNumber;
        final String str = oVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.f.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        f.this.a(qU, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        f.this.a(qU, "hotarea", i2, str, (String) null);
                    } else {
                        f.this.a(qU, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str2, String str3, HashMap<String, Object> hashMap) {
                f.this.a(qU, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.adapter.f.4.1
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
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.adapter.f.5
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo, int i3) {
                h.a(f.this.iJr.getPageContext().getPageActivity(), advertAppInfo, i3, f.this.c(advertAppInfo, str));
            }
        });
        if (this.mNu == null || this.mNu.get() != pbAppLegoViewHolder) {
            this.mNu = new WeakReference<>(pbAppLegoViewHolder);
        }
        ddO();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.e.dFW().a(a2);
        a2.Jk(2);
        com.baidu.tieba.recapp.report.e.dFW().a(a2);
        com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.bEw().a(advertAppInfo, str2, 0L, j(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.c a2 = com.baidu.tieba.recapp.report.h.a(advertAppInfo, str, i2, i);
        a2.RZ(str3);
        com.baidu.tieba.recapp.report.e.dFW().a(a2);
        com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(advertAppInfo));
    }

    private String j(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.page) ? "PB" : advertAppInfo.page;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData c(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(j(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eNW);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void ddO() {
        PbAppLegoViewHolder pbAppLegoViewHolder = this.mNu != null ? this.mNu.get() : null;
        if (pbAppLegoViewHolder != null) {
            pbAppLegoViewHolder.ddO();
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
        if (this.Wu != 0) {
            ((PbAppLegoViewHolder) this.Wu).stopPlay();
        }
        this.mNs = false;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
        if (this.Wu != 0 && ((PbAppLegoViewHolder) this.Wu).canPlay()) {
            if (((PbAppLegoViewHolder) this.Wu).getPlayStatus() == -1) {
                ((PbAppLegoViewHolder) this.Wu).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.mNs = true;
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
        if (this.Wu != 0) {
            ((PbAppLegoViewHolder) this.Wu).release();
        }
    }
}
