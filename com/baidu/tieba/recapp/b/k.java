package com.baidu.tieba.recapp.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.view.CriusAdCardView;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.widget.ListView.a<m, l> implements com.baidu.tieba.recapp.m {
    private CustomMessageListener cOn;
    protected BaseActivity cXM;
    private CustomMessageListener gtT;
    private boolean iJI;
    private CustomMessageListener iJJ;
    protected WeakReference<l> iJK;
    private boolean mIsFromCDN;

    public k(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iJI = true;
        this.gtT = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && k.this.iJI) {
                    int playStatus = ((l) k.this.viewholder).getPlayStatus();
                    if (((l) k.this.viewholder).ek(k.this.mContext)) {
                        if (playStatus == -1) {
                            ((l) k.this.viewholder).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.viewholder).stopPlay();
                    }
                }
            }
        };
        this.cOn = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.bLD();
            }
        };
        this.iJJ = new CustomMessageListener(2004020) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.viewholder).stopPlay();
                }
            }
        };
        this.iJK = null;
        this.cXM = baseActivity;
        this.cXM.registerListener(this.gtT);
        this.cXM.registerListener(this.iJJ);
        this.cXM.registerListener(this.cOn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup, m mVar) {
        View view2;
        if (mVar == null || mVar.cqo() == null) {
            return null;
        }
        if (a(view, mVar)) {
            this.viewholder = onCreateViewHolder(viewGroup, mVar);
            if (this.viewholder != 0) {
                view2 = ((l) this.viewholder).getView();
                if (view2 == null) {
                    View onFillViewHolder = onFillViewHolder(i, view2, viewGroup, mVar, (l) view2.getTag());
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

    private boolean a(View view, m mVar) {
        if (view == null || view.getTag() == null || this.viewholder == 0) {
            return true;
        }
        if (((l) this.viewholder).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.viewholder).getClass())) {
            AdvertAppInfo.ILegoAdvert cqo = mVar.cqo();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && cqo.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bY */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public l onCreateViewHolder(ViewGroup viewGroup, m mVar) {
        View view = (View) com.baidu.tieba.lego.card.b.bLa().a(this.cXM.getPageContext(), mVar.cqo(), 4);
        if (view != null) {
            return new l((com.baidu.tieba.lego.card.view.e) view);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, l lVar) {
        if (this.cXM == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert cqo = mVar.cqo();
        view.setTag(R.id.tag_first, cqo);
        this.cXM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cXM.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.c.a(mVar);
        if (!mVar.jiy) {
            com.baidu.tbadk.distribute.a.arZ().a(mVar.pi(), mVar.forumId, mVar.threadId, mVar.cqq(), SmsLoginView.StatEvent.LOGIN_SHOW, mVar.pageNumber);
            mVar.jiy = true;
        }
        if (mVar != null) {
            com.baidu.tbadk.distribute.a.cse = mVar.fNI;
        }
        final AdvertAppInfo pi = mVar.pi();
        if (pi.advertAppContext == null) {
            pi.advertAppContext = new com.baidu.tbadk.core.data.c();
        }
        pi.advertAppContext.pn = mVar.pageNumber;
        pi.advertAppContext.page = mVar.cqq();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        cqo.setAdvertAppInfo(pi);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.ao(cqo);
        final int i2 = mVar.pageNumber;
        final String str = mVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(pi, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(pi, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(pi, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(pi, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Void doInBackground(String... strArr) {
                            if (strArr != null && strArr.length > 0) {
                                new x(strArr[0]).aim();
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
                com.baidu.tieba.recapp.download.h.a(k.this.cXM.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.iJK == null || this.iJK.get() != lVar) {
            this.iJK = new WeakReference<>(lVar);
        }
        bLD();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.c.cjE().a(a);
        a.zJ(2);
        com.baidu.tieba.recapp.report.c.cjE().a(a);
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.c.cjE().f(advertAppInfo.bFu, hashMap);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.arZ().a(advertAppInfo, str2, 0L, g(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(advertAppInfo, str, i2, i);
        a.Ey(str3);
        com.baidu.tieba.recapp.report.c.cjE().a(a);
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
        downloadStaticsData.setApk_name(advertAppInfo.bFw);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void bLD() {
        l lVar = this.iJK != null ? this.iJK.get() : null;
        if (lVar != null && !(lVar.fNW instanceof CriusAdCardView)) {
            lVar.bLD();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
