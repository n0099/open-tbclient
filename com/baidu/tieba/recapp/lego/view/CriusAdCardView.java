package com.baidu.tieba.recapp.lego.view;

import android.app.Activity;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.d.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.d;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.j;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdCriusCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.t;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements j {
    private com.baidu.b.a.c.a criusData;
    private DownloadCacheKey eOp;
    private d eOq;
    private LinearLayout iRP;
    protected String kMH;
    private com.baidu.b.a.d.a kNA;
    private ViewGroup kNB;
    private ApkDownloadView kNC;
    private AdCloseView kND;
    private JumpButton kNE;
    private AdThreadCommentAndPraiseInfoLayout kNF;
    private CriusAdCard kNG;
    private boolean kNH;
    private com.baidu.tieba.ad.browser.newstyle.view.a kNI;
    protected CustomMessageListener kNJ;
    private HeadImageView kfR;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kNH = true;
        this.eOq = null;
        this.kNJ = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.kMH) && CriusAdCardView.this.kMH.equals(downloadData.getId()) && CriusAdCardView.this.kNC != null) {
                    CriusAdCardView.this.kNC.t(downloadData);
                }
            }
        };
        this.kNA = new com.baidu.b.a.d.a();
        this.kNA.a(new a.InterfaceC0090a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0090a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.kNG == null || CriusAdCardView.this.kNG.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kNG.getAdvertAppInfo().dAu;
                int b = (CriusAdCardView.this.kNG.directDownload || !CriusAdCardView.this.kNG.getAdvertAppInfo().aOz()) ? r.b(CriusAdCardView.this.dIF, str, str4) : r.c(CriusAdCardView.this.dIF, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.jab != null) {
                        CriusAdCardView.this.jab.d(b, null);
                    }
                } else if (CriusAdCardView.this.jab != null) {
                    if (map == null) {
                        str2 = "";
                        str3 = "";
                    } else {
                        if (!map.containsKey("data-als-stat")) {
                            str2 = "";
                        } else {
                            str2 = map.get("data-als-stat");
                        }
                        str3 = map.containsKey("data-url-stat") ? map.get("data-url-stat") : "";
                    }
                    CriusAdCardView.this.jab.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctJ() {
        this.iRP = new LinearLayout(this.dIF.getPageActivity());
        this.iRP.setOrientation(1);
        return this.iRP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.kNB, R.drawable.addresslist_item_bg);
        this.kNA.h(this.dIF.getPageActivity(), i == 1 || i == 4);
        if (this.kNC != null) {
            this.kNC.onChangeSkinType(i);
        }
        if (this.kND != null) {
            this.kND.onChangeSkinType();
        }
        if (this.kNF != null) {
            this.kNF.onChangeSkinType();
        }
        am.setBackgroundResource(this.kNE, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.kNE, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.kNG = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cUY();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bmz();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmA();
    }

    private void bmz() {
        if (this.eOp != null && this.eOq != null) {
            com.baidu.tieba.ad.download.d.bmF().a(this.eOp, this.eOq);
        }
    }

    private void bmA() {
        if (this.eOp != null && this.eOq != null) {
            com.baidu.tieba.ad.download.d.bmF().b(this.eOp, this.eOq);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.kfR != null) {
            this.kfR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aXO() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.dIF.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aOz()) {
            if (!this.kNG.directDownload) {
                a(this.kNG, advertAppInfo);
                this.kNC.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void br(View view) {
                        CriusAdCardView.this.cUX();
                    }
                });
            } else {
                this.kNC.setOnClickListener(aVar);
            }
            this.kNJ.setTag(this.dIF.getUniqueId());
            MessageManager.getInstance().registerListener(this.kNJ);
            this.kMH = advertAppInfo.dAx;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.kNC.setData(c);
            this.kNC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.kNG.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.kNC.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.kND != null && advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kND.setPage(getBusinessType());
            this.kND.setData(advertAppInfo);
            this.kND.onChangeSkinType();
            if (this.kND instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.kND).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.dIF.getPageActivity(), this.kND, 40, 40, 40, 120);
        }
    }

    private void cUV() {
        if (this.kNE != null) {
            this.kNE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a dO;
                    if (CriusAdCardView.this.criusData != null && (dO = CriusAdCardView.this.criusData.dO("viewbtn")) != null) {
                        if (!t.Mu(dO.anq) && CriusAdCardView.this.jab != null) {
                            CriusAdCardView.this.jab.a(dO.anr, dO.ans, null);
                        }
                        if (TextUtils.isEmpty(dO.ant)) {
                            int b = r.b(CriusAdCardView.this.dIF, dO.anq, (CriusAdCardView.this.kNG == null || CriusAdCardView.this.kNG.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kNG.getAdvertAppInfo().dAu);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.jab != null) {
                                CriusAdCardView.this.jab.d(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.dIF.getPageActivity());
                        aVar.vO(dO.ant);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = r.b(CriusAdCardView.this.dIF, dO.anq, (CriusAdCardView.this.kNG == null || CriusAdCardView.this.kNG.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kNG.getAdvertAppInfo().dAu);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.jab != null) {
                                    CriusAdCardView.this.jab.d(b2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.dIF).aST();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.kNF != null) {
            final com.baidu.b.a.c.a dO = this.criusData.dO("bottombar");
            if (dO != null) {
                a(this.kNG.getAdvertAppInfo(), dO);
                this.kNF.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.kNF.setBarNameClickEnabled(false);
                this.kNF.setReplyTimeVisible(false);
                if (dO.anu != Integer.MIN_VALUE) {
                    this.kNF.setShareClickable(true);
                    this.kNF.setShareContainerBgGray(false);
                } else {
                    this.kNF.setShareClickable(false);
                    this.kNF.setShareContainerBgGray(true);
                }
                this.kNF.getCommentContainer().setOnClickListener(aVar);
                this.kNF.setNeedAddReplyIcon(true);
                this.kNF.setCommentNumEnable(true);
                this.kNF.setCommentClickable(true);
                this.kNF.setReplayContainerBgGray(true);
                this.kNF.setOnClickListener(aVar);
                this.kNF.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return dO.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return dO.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return dO.anx;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return dO.any;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.kNG.getAdvertAppInfo();
                    }
                });
                if (dO.anw != Integer.MIN_VALUE) {
                    this.kNF.setAgreeClickable(true);
                    this.kNF.setPraiseContainerBgGray(false);
                } else {
                    this.kNF.setAgreeClickable(false);
                    this.kNF.setPraiseContainerBgGray(true);
                }
                this.kNF.onChangeSkinType();
            }
            if (this.kNF != null) {
                if (this.kND == null) {
                    this.kND = new AdCloseView(this.dIF.getPageActivity());
                }
                if (this.kND.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kND.getParent()).removeView(this.kND);
                }
                this.kNF.addAdMoreView(this.kND);
                l(this.kNG.getAdvertAppInfo());
            }
        }
    }

    public void a(bk bkVar, com.baidu.b.a.c.a aVar) {
        if (bkVar != null && aVar != null) {
            if (this.kNH || (bkVar.aRW() <= 0 && bkVar.aSa() <= 0)) {
                if (this.kNH) {
                    this.kNH = false;
                }
                bkVar.ks(aVar.anv);
                bkVar.kA(aVar.anw);
                bkVar.cd(aVar.anu);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.kNG != null) {
            distributeVideoView.setPageContext(this.dIF);
            distributeVideoView.setVideoTailFrameData(this.kNG.tailFrame);
            distributeVideoView.setChargeInfo(this.kNG.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cUW() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.kNG.getAdvertAppInfo();
        a aVar = new a(this.kNG);
        setCriusViewClick(aVar);
        View dR = this.kNA.dR("head");
        if (dR != null && (dR instanceof HeadImageView)) {
            this.kfR = (HeadImageView) dR;
            setHeadLongClick(advertAppInfo);
        }
        View dR2 = this.kNA.dR("download");
        if (dR2 != null && (dR2 instanceof ApkDownloadView)) {
            this.kNC = (ApkDownloadView) dR2;
            this.kNC.x(this.dIF.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View dR3 = this.kNA.dR("closead");
        if (dR3 != null && (dR3 instanceof AdCloseView)) {
            this.kND = (AdCloseView) dR3;
            l(advertAppInfo);
        }
        View dR4 = this.kNA.dR("viewbtn");
        if (dR4 != null && (dR4 instanceof JumpButton)) {
            this.kNE = (JumpButton) dR4;
            cUV();
        }
        View dR5 = this.kNA.dR("bottombar");
        if (dR5 != null && (dR5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dR5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.kNF = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dS = this.kNA.dS("video");
        if (dS != null && (distributeVideoView = (DistributeVideoView) dS.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.kNG.directDownload) {
            this.kNB.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.anq)) {
            this.kNB.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dS = this.kNA.dS("video");
        if (dS == null || (distributeVideoView = (DistributeVideoView) dS.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dS = this.kNA.dS("video");
        if (dS != null && (distributeVideoView = (DistributeVideoView) dS.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey zY;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dAu;
            if (!TextUtils.isEmpty(str)) {
                zY = com.baidu.tieba.ad.download.d.bmF().zX(str);
            } else {
                zY = com.baidu.tieba.ad.download.d.bmF().zY(scheme);
            }
            if (zY == null) {
                zY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dAx);
                com.baidu.tieba.ad.download.d.bmF().a(zY, null);
            }
            i(zY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.eOp = downloadCacheKey;
        bmA();
        this.eOq = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey);
        if (d != null) {
            this.kNC.a(d.getCurrentState());
        } else {
            this.kNC.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.kNG != null || this.kNG.getAdvertAppInfo() != null) {
            str = this.kNG.getAdvertAppInfo().page;
        }
        this.kNI = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kNC, d, str);
        this.eOq = new com.baidu.tieba.ad.download.a.b(this.kNI);
        if (d.extra().getPercent() > 0) {
            this.kNI.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bmz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard kNN;

        public a(CriusAdCard criusAdCard) {
            this.kNN = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.dIF.showToast(R.string.neterror);
            } else if (this.kNN != null) {
                AdvertAppInfo advertAppInfo = this.kNN.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aOz()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !com.baidu.adp.lib.util.j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.kNC) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.kNC, z);
                    CriusAdCardView.this.cUX();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.anq;
                }
                if (k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dAw;
                }
                int b = r.b(CriusAdCardView.this.dIF, str, (CriusAdCardView.this.kNG == null || CriusAdCardView.this.kNG.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kNG.getAdvertAppInfo().dAu);
                if (CriusAdCardView.this.jab != null) {
                    CriusAdCardView.this.jab.d(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUX() {
        if (this.jab != null) {
            this.jab.d(3, null);
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null && apkDownloadView != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        com.baidu.tieba.recapp.download.h.f(advertAppInfo);
                        apkDownloadView.r(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    com.baidu.tieba.recapp.download.h.aN(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bmF().aw(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dAx);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dAv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dAu, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aOz()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dIF.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
                aVar.vO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.kNC != null) {
                            CriusAdCardView.this.kNC.q(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.dIF).aST();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aOy() != 0) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dIF.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dIF.getPageActivity()) && this.jac != null) {
                this.jac.b(advertAppInfo, i);
                if (this.kNC != null) {
                    this.kNC.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cUY() {
        boolean z = true;
        if (this.iRP != null && this.kNA != null) {
            this.iRP.removeAllViews();
            com.baidu.b.a.d.a aVar = this.kNA;
            Activity pageActivity = this.dIF.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.kNB = aVar.a(pageActivity, aVar2, z);
            this.iRP.addView(this.kNB);
            am.setBackgroundResource(this.kNB, R.drawable.addresslist_item_bg);
            cUW();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ctP() {
        if (this.kNA != null && ((TextView) this.kNA.dS("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.dIF.getPageActivity()));
            cUY();
        }
    }
}
