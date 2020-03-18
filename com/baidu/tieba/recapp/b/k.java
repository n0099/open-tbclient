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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.view.CriusAdCardView;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class k extends com.baidu.adp.widget.ListView.a<m, l> implements com.baidu.tieba.recapp.m {
    private CustomMessageListener dQi;
    protected BaseFragmentActivity gsB;
    private CustomMessageListener hmu;
    private boolean jIl;
    private CustomMessageListener jIm;
    protected WeakReference<l> jIn;
    private boolean mIsFromCDN;

    public k(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jIl = true;
        this.hmu = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.recapp.b.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Ai != null && k.this.jIl) {
                    int playStatus = ((l) k.this.Ai).getPlayStatus();
                    if (((l) k.this.Ai).fn(k.this.mContext)) {
                        if (playStatus == -1) {
                            ((l) k.this.Ai).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                        }
                    } else if (playStatus != -1) {
                        ((l) k.this.Ai).stopPlay();
                    }
                }
            }
        };
        this.dQi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.recapp.b.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.ccF();
            }
        };
        this.jIm = new CustomMessageListener(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE) { // from class: com.baidu.tieba.recapp.b.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.Ai != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                    ((l) k.this.Ai).stopPlay();
                }
            }
        };
        this.jIn = null;
        this.gsB = baseFragmentActivity;
        this.gsB.registerListener(this.hmu);
        this.gsB.registerListener(this.jIm);
        this.gsB.registerListener(this.dQi);
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
        if (mVar == null || mVar.cLk() == null) {
            return null;
        }
        if (a(view, mVar)) {
            this.Ai = a(viewGroup, mVar);
            if (this.Ai != 0) {
                view2 = ((l) this.Ai).getView();
                if (view2 == null) {
                    View a = a(i, view2, viewGroup, mVar, (l) view2.getTag());
                    if (com.baidu.tieba.recapp.k.class.isAssignableFrom(a.getClass())) {
                        ((l) this.Ai).a(((com.baidu.tieba.recapp.k) a).getVideoOrVrView());
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

    private boolean a(View view, m mVar) {
        if (view == null || view.getTag() == null || this.Ai == 0) {
            return true;
        }
        if (((l) this.Ai).getClass().isAssignableFrom(view.getTag().getClass()) && view.getTag().getClass().isAssignableFrom(((l) this.Ai).getClass())) {
            AdvertAppInfo.ILegoAdvert cLk = mVar.cLk();
            Object tag = view.getTag(R.id.tag_first);
            return ((tag instanceof AdvertAppInfo.ILegoAdvert) && cLk.isReusable((AdvertAppInfo.ILegoAdvert) tag)) ? false : true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public l b(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public l a(ViewGroup viewGroup, m mVar) {
        View view = (View) com.baidu.tieba.lego.card.b.ccd().a(this.gsB.getPageContext(), mVar.cLk(), 4);
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
    public View a(int i, View view, ViewGroup viewGroup, m mVar, l lVar) {
        if (this.gsB == null) {
            return null;
        }
        lVar.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert cLk = mVar.cLk();
        view.setTag(R.id.tag_first, cLk);
        this.gsB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gsB.getLayoutMode().onModeChanged(view);
        com.baidu.tbadk.core.data.c.a(mVar);
        if (!mVar.kig) {
            com.baidu.tbadk.distribute.a.aOm().a(mVar.kK(), mVar.forumId, mVar.threadId, mVar.cLm(), "show", mVar.pageNumber);
            mVar.kig = true;
        }
        if (mVar != null) {
            com.baidu.tbadk.distribute.a.dwn = mVar.gGS;
        }
        final AdvertAppInfo kK = mVar.kK();
        if (kK.advertAppContext == null) {
            kK.advertAppContext = new com.baidu.tbadk.core.data.c();
        }
        kK.advertAppContext.pn = mVar.pageNumber;
        kK.advertAppContext.page = mVar.cLm();
        com.baidu.tieba.lego.card.view.e eVar = (com.baidu.tieba.lego.card.view.e) view;
        cLk.setAdvertAppInfo(kK);
        eVar.setFromCDN(this.mIsFromCDN);
        eVar.ax(cLk);
        final int i2 = mVar.pageNumber;
        final String str = mVar.forumId;
        eVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.b.k.4
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i3, HashMap hashMap) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        k.this.a(kK, true, i2, "hotarea");
                    } else if (i3 == 3) {
                        k.this.a(kK, "hotarea", i2, str, (String) null);
                    } else {
                        k.this.a(kK, false, i2, "hotarea");
                    }
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str2, String str3, HashMap<String, Object> hashMap) {
                k.this.a(kK, "button", i2, str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.b.k.4.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Void doInBackground(String... strArr) {
                            if (strArr != null && strArr.length > 0) {
                                new x(strArr[0]).postNetData();
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
                com.baidu.tieba.recapp.download.h.a(k.this.gsB.getPageContext().getPageActivity(), advertAppInfo, i3, k.this.b(advertAppInfo, str));
            }
        });
        if (this.jIn == null || this.jIn.get() != lVar) {
            this.jIn = new WeakReference<>(lVar);
        }
        ccF();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, boolean z, int i, String str) {
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(advertAppInfo, str, 706, i);
        com.baidu.tieba.recapp.report.c.cDK().a(a);
        a.Bg(2);
        com.baidu.tieba.recapp.report.c.cDK().a(a);
        if (z) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isDeepLink", "1");
            com.baidu.tieba.recapp.report.c.cDK().f(advertAppInfo.cNm, hashMap);
        }
        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(advertAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdvertAppInfo advertAppInfo, String str, int i, String str2, String str3) {
        com.baidu.tbadk.distribute.a.aOm().a(advertAppInfo, str2, 0L, g(advertAppInfo), "click", i);
        int i2 = 2;
        if (advertAppInfo != null && advertAppInfo.legoCard != null && advertAppInfo.legoCard.forFree()) {
            i2 = 102;
        }
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(advertAppInfo, str, i2, i);
        a.Ie(str3);
        com.baidu.tieba.recapp.report.c.cDK().a(a);
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
        downloadStaticsData.setApk_name(advertAppInfo.cNn);
        downloadStaticsData.setAdPosition(advertAppInfo.adPosition);
        downloadStaticsData.setPrice(advertAppInfo.price);
        downloadStaticsData.setExtensionInfo(advertAppInfo.extensionInfo);
        return downloadStaticsData;
    }

    public void ccF() {
        l lVar = this.jIn != null ? this.jIn.get() : null;
        if (lVar != null && !(lVar.gHg instanceof CriusAdCardView)) {
            lVar.ccF();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
