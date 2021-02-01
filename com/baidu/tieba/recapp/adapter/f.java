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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.data.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.widget.ListView.a<o, PbAppLegoViewHolder> implements k, com.baidu.tieba.recapp.o {
    private CustomMessageListener fYg;
    protected BaseFragmentActivity iKt;
    private CustomMessageListener ksY;
    private boolean mIsFromCDN;
    private boolean mRV;
    private CustomMessageListener mRW;
    protected WeakReference<PbAppLegoViewHolder> mRX;

    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mRV = true;
        this.ksY = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.Wo != null && f.this.mRV) {
                    int playStatus = ((PbAppLegoViewHolder) f.this.Wo).getPlayStatus();
                    if (((PbAppLegoViewHolder) f.this.Wo).canPlay()) {
                        if (playStatus == -1) {
                            ((PbAppLegoViewHolder) f.this.Wo).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((PbAppLegoViewHolder) f.this.Wo).stopPlay();
                    }
                }
            }
        };
        this.fYg = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.adapter.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.dbU();
            }
        };
        this.mRW = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.adapter.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.Wo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((PbAppLegoViewHolder) f.this.Wo).stopPlay();
                }
            }
        };
        this.mRX = null;
        this.iKt = baseFragmentActivity;
        this.iKt.registerListener(this.ksY);
        this.iKt.registerListener(this.mRW);
        this.iKt.registerListener(this.fYg);
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
        if (oVar == null || oVar.dNm() == null) {
            return null;
        }
        if (a(view, oVar)) {
            this.Wo = a(viewGroup, oVar);
            if (this.Wo != 0) {
                view2 = ((PbAppLegoViewHolder) this.Wo).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, oVar, (PbAppLegoViewHolder) view2.getTag());
                    if (m.class.isAssignableFrom(a2.getClass())) {
                        ((PbAppLegoViewHolder) this.Wo).a(((m) a2).getVideoOrVrView());
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
        if (view == null || view.getTag() == null || this.Wo == 0) {
            return true;
        }
        if (((PbAppLegoViewHolder) this.Wo).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.Wo).getClass())) {
            AdvertAppInfo.ILegoAdvert dNm = oVar.dNm();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && dNm.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cX */
    public PbAppLegoViewHolder e(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public PbAppLegoViewHolder a(ViewGroup viewGroup, o oVar) {
        View view = (View) com.baidu.tieba.lego.card.b.dbs().a(this.iKt.getPageContext(), oVar.dNm(), 4);
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
        if (this.iKt == null) {
            return null;
        }
        if (oVar.dNm() instanceof AdCard) {
            ((AdCard) oVar.dNm()).isPBBanner = oVar.nwv;
        }
        pbAppLegoViewHolder.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dNm = oVar.dNm();
        view.setTag(R.id.tag_first, dNm);
        this.iKt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iKt.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.d.a(oVar);
        if (!oVar.nww) {
            com.baidu.tbadk.distribute.a.bAU().a(oVar.qS(), oVar.forumId, oVar.threadId, oVar.dNo(), "show", oVar.pageNumber);
            oVar.nww = true;
        }
        if (oVar != null) {
            com.baidu.tbadk.distribute.a.fAA = oVar.jDK;
        }
        final AdvertAppInfo qS = oVar.qS();
        if (qS.advertAppContext == null) {
            qS.advertAppContext = new com.baidu.tbadk.core.data.d();
        }
        qS.advertAppContext.pn = oVar.pageNumber;
        qS.advertAppContext.page = oVar.dNo();
        qS.position = oVar.position;
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dNm.setAdvertAppInfo(qS);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aN(dNm);
        final int i2 = oVar.pageNumber;
        final String str = oVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.f.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (s.HL(i3)) {
                        com.baidu.tieba.recapp.report.d.a(qS, i2, hashMap, i3);
                    } else {
                        com.baidu.tieba.recapp.report.d.a(qS, i2, str, (String) null, hashMap);
                    }
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(qS));
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                com.baidu.tieba.recapp.report.d.a(qS, i2, str, str2, hashMap);
                com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(qS));
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.adapter.f.4.1
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
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.adapter.f.5
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo, int i3) {
                h.a(f.this.iKt.getPageContext().getPageActivity(), advertAppInfo, i3, f.this.c(advertAppInfo, str));
            }
        });
        if (this.mRX == null || this.mRX.get() != pbAppLegoViewHolder) {
            this.mRX = new WeakReference<>(pbAppLegoViewHolder);
        }
        dbU();
        return view;
    }

    private String k(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.page) ? "PB" : advertAppInfo.page;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadStaticsData c(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(k(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.eLx);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void dbU() {
        PbAppLegoViewHolder pbAppLegoViewHolder = this.mRX != null ? this.mRX.get() : null;
        if (pbAppLegoViewHolder != null) {
            pbAppLegoViewHolder.dbU();
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
        if (this.Wo != 0) {
            ((PbAppLegoViewHolder) this.Wo).stopPlay();
        }
        this.mRV = false;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
        if (this.Wo != 0 && ((PbAppLegoViewHolder) this.Wo).canPlay()) {
            if (((PbAppLegoViewHolder) this.Wo).getPlayStatus() == -1) {
                ((PbAppLegoViewHolder) this.Wo).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.mRV = true;
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
        if (this.Wo != 0) {
            ((PbAppLegoViewHolder) this.Wo).release();
        }
    }
}
