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
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.tbadkCore.data.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.widget.ListView.a<o, PbAppLegoViewHolder> implements l, p {
    private CustomMessageListener fZG;
    protected BaseFragmentActivity iMq;
    private CustomMessageListener kvo;
    private boolean mIsFromCDN;
    private boolean mUv;
    private CustomMessageListener mUw;
    protected WeakReference<PbAppLegoViewHolder> mUx;

    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mUv = true;
        this.kvo = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.XI != null && f.this.mUv) {
                    int playStatus = ((PbAppLegoViewHolder) f.this.XI).getPlayStatus();
                    if (((PbAppLegoViewHolder) f.this.XI).canPlay()) {
                        if (playStatus == -1) {
                            ((PbAppLegoViewHolder) f.this.XI).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((PbAppLegoViewHolder) f.this.XI).stopPlay();
                    }
                }
            }
        };
        this.fZG = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.adapter.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.dck();
            }
        };
        this.mUw = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.adapter.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.XI != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((PbAppLegoViewHolder) f.this.XI).stopPlay();
                }
            }
        };
        this.mUx = null;
        this.iMq = baseFragmentActivity;
        this.iMq.registerListener(this.kvo);
        this.iMq.registerListener(this.mUw);
        this.iMq.registerListener(this.fZG);
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
        if (oVar == null || oVar.dND() == null) {
            return null;
        }
        if (a(view, oVar)) {
            this.XI = a(viewGroup, oVar);
            if (this.XI != 0) {
                view2 = ((PbAppLegoViewHolder) this.XI).getView();
                if (view2 == null) {
                    View a2 = a(i, view2, viewGroup, oVar, (PbAppLegoViewHolder) view2.getTag());
                    if (n.class.isAssignableFrom(a2.getClass())) {
                        ((PbAppLegoViewHolder) this.XI).a(((n) a2).getVideoOrVrView());
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
        if (view == null || view.getTag() == null || this.XI == 0 || !((PbAppLegoViewHolder) this.XI).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.XI).getClass())) {
            return true;
        }
        AdvertAppInfo.ILegoAdvert dND = oVar.dND();
        Object tag = view.getTag(R.id.tag_first);
        if (tag instanceof AdvertAppInfo.ILegoAdvert) {
            return !dND.isReusable((AdvertAppInfo.ILegoAdvert) tag);
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
        View view = (View) com.baidu.tieba.lego.card.b.dbI().a(this.iMq.getPageContext(), oVar.dND(), 4);
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
        if (this.iMq == null) {
            return null;
        }
        if (oVar.dND() instanceof AdCard) {
            ((AdCard) oVar.dND()).isPBBanner = oVar.nza;
        }
        pbAppLegoViewHolder.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert dND = oVar.dND();
        view.setTag(R.id.tag_first, dND);
        this.iMq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iMq.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.d.a(oVar);
        if (oVar.eNm) {
            com.baidu.tieba.ad.a.a.bLM().onAdShow(com.baidu.tieba.ad.a.a.a(oVar.dNC()));
        }
        if (!oVar.nzb) {
            com.baidu.tbadk.distribute.a.bAX().a(oVar.qS(), oVar.forumId, oVar.threadId, oVar.dNF(), "show", oVar.pageNumber);
            oVar.nzb = true;
        }
        if (oVar != null) {
            com.baidu.tbadk.distribute.a.fBZ = oVar.jFH;
        }
        final AdvertAppInfo qS = oVar.qS();
        if (qS.advertAppContext == null) {
            qS.advertAppContext = new com.baidu.tbadk.core.data.d();
        }
        qS.advertAppContext.pn = oVar.pageNumber;
        qS.advertAppContext.page = oVar.dNF();
        qS.position = oVar.position;
        qS.eNm = oVar.eNm;
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        dND.setAdvertAppInfo(qS);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.aP(dND);
        final int i2 = oVar.pageNumber;
        final String str = oVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.adapter.f.4
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (t.HO(i3)) {
                        com.baidu.tieba.recapp.report.d.a(qS, i2, hashMap, i3);
                    } else {
                        com.baidu.tieba.recapp.report.d.a(qS, i2, str, (String) null, hashMap);
                    }
                    if (!qS.eNm) {
                        com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(qS));
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                com.baidu.tieba.recapp.report.d.a(qS, i2, str, str2, hashMap);
                if (!qS.eNm) {
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
            }
        });
        eVar.setDownloadAppCallback(new com.baidu.tieba.lego.card.c() { // from class: com.baidu.tieba.recapp.adapter.f.5
            @Override // com.baidu.tieba.lego.card.c
            public void c(AdvertAppInfo advertAppInfo, int i3) {
                h.a(f.this.iMq.getPageContext().getPageActivity(), advertAppInfo, i3, f.this.c(advertAppInfo, str));
            }
        });
        if (this.mUx == null || this.mUx.get() != pbAppLegoViewHolder) {
            this.mUx = new WeakReference<>(pbAppLegoViewHolder);
        }
        dck();
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
        downloadStaticsData.setApk_name(advertAppInfo.eMX);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void dck() {
        PbAppLegoViewHolder pbAppLegoViewHolder = this.mUx != null ? this.mUx.get() : null;
        if (pbAppLegoViewHolder != null) {
            pbAppLegoViewHolder.dck();
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.recapp.l
    public void onPause() {
        if (this.XI != 0) {
            ((PbAppLegoViewHolder) this.XI).stopPlay();
        }
        this.mUv = false;
    }

    @Override // com.baidu.tieba.recapp.l
    public void onResume() {
        if (this.XI != 0 && ((PbAppLegoViewHolder) this.XI).canPlay()) {
            if (((PbAppLegoViewHolder) this.XI).getPlayStatus() == -1) {
                ((PbAppLegoViewHolder) this.XI).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.mUv = true;
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void onDestroy() {
        if (this.XI != 0) {
            ((PbAppLegoViewHolder) this.XI).release();
        }
    }
}
