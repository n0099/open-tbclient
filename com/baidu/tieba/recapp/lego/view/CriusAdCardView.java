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
    private DownloadCacheKey eOe;
    private d eOf;
    private LinearLayout iRc;
    protected String kLy;
    protected CustomMessageListener kMA;
    private com.baidu.b.a.d.a kMr;
    private ViewGroup kMs;
    private ApkDownloadView kMt;
    private AdCloseView kMu;
    private JumpButton kMv;
    private AdThreadCommentAndPraiseInfoLayout kMw;
    private CriusAdCard kMx;
    private boolean kMy;
    private com.baidu.tieba.ad.browser.newstyle.view.a kMz;
    private HeadImageView keL;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kMy = true;
        this.eOf = null;
        this.kMA = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.kLy) && CriusAdCardView.this.kLy.equals(downloadData.getId()) && CriusAdCardView.this.kMt != null) {
                    CriusAdCardView.this.kMt.t(downloadData);
                }
            }
        };
        this.kMr = new com.baidu.b.a.d.a();
        this.kMr.a(new a.InterfaceC0090a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0090a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.kMx == null || CriusAdCardView.this.kMx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kMx.getAdvertAppInfo().dAu;
                int b = (CriusAdCardView.this.kMx.directDownload || !CriusAdCardView.this.kMx.getAdvertAppInfo().aOz()) ? r.b(CriusAdCardView.this.dIF, str, str4) : r.c(CriusAdCardView.this.dIF, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.iZo != null) {
                        CriusAdCardView.this.iZo.d(b, null);
                    }
                } else if (CriusAdCardView.this.iZo != null) {
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
                    CriusAdCardView.this.iZo.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctA() {
        this.iRc = new LinearLayout(this.dIF.getPageActivity());
        this.iRc.setOrientation(1);
        return this.iRc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.kMs, R.drawable.addresslist_item_bg);
        this.kMr.h(this.dIF.getPageActivity(), i == 1 || i == 4);
        if (this.kMt != null) {
            this.kMt.onChangeSkinType(i);
        }
        if (this.kMu != null) {
            this.kMu.onChangeSkinType();
        }
        if (this.kMw != null) {
            this.kMw.onChangeSkinType();
        }
        am.setBackgroundResource(this.kMv, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.kMv, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.kMx = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cUI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bmx();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmy();
    }

    private void bmx() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().a(this.eOe, this.eOf);
        }
    }

    private void bmy() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().b(this.eOe, this.eOf);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.keL != null) {
            this.keL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aXN() || advertAppInfo == null) {
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
            if (!this.kMx.directDownload) {
                a(this.kMx, advertAppInfo);
                this.kMt.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void br(View view) {
                        CriusAdCardView.this.cUH();
                    }
                });
            } else {
                this.kMt.setOnClickListener(aVar);
            }
            this.kMA.setTag(this.dIF.getUniqueId());
            MessageManager.getInstance().registerListener(this.kMA);
            this.kLy = advertAppInfo.dAx;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.kMt.setData(c);
            this.kMt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.kMx.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.kMt.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.kMu != null && advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kMu.setPage(getBusinessType());
            this.kMu.setData(advertAppInfo);
            this.kMu.onChangeSkinType();
            if (this.kMu instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.kMu).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.dIF.getPageActivity(), this.kMu, 40, 40, 40, 120);
        }
    }

    private void cUF() {
        if (this.kMv != null) {
            this.kMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a dO;
                    if (CriusAdCardView.this.criusData != null && (dO = CriusAdCardView.this.criusData.dO("viewbtn")) != null) {
                        if (!t.Mt(dO.anq) && CriusAdCardView.this.iZo != null) {
                            CriusAdCardView.this.iZo.a(dO.anr, dO.ans, null);
                        }
                        if (TextUtils.isEmpty(dO.ant)) {
                            int b = r.b(CriusAdCardView.this.dIF, dO.anq, (CriusAdCardView.this.kMx == null || CriusAdCardView.this.kMx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kMx.getAdvertAppInfo().dAu);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.iZo != null) {
                                CriusAdCardView.this.iZo.d(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.dIF.getPageActivity());
                        aVar.vO(dO.ant);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = r.b(CriusAdCardView.this.dIF, dO.anq, (CriusAdCardView.this.kMx == null || CriusAdCardView.this.kMx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kMx.getAdvertAppInfo().dAu);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.iZo != null) {
                                    CriusAdCardView.this.iZo.d(b2, null);
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
        if (this.kMw != null) {
            final com.baidu.b.a.c.a dO = this.criusData.dO("bottombar");
            if (dO != null) {
                a(this.kMx.getAdvertAppInfo(), dO);
                this.kMw.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.kMw.setBarNameClickEnabled(false);
                this.kMw.setReplyTimeVisible(false);
                if (dO.anu != Integer.MIN_VALUE) {
                    this.kMw.setShareClickable(true);
                    this.kMw.setShareContainerBgGray(false);
                } else {
                    this.kMw.setShareClickable(false);
                    this.kMw.setShareContainerBgGray(true);
                }
                this.kMw.getCommentContainer().setOnClickListener(aVar);
                this.kMw.setNeedAddReplyIcon(true);
                this.kMw.setCommentNumEnable(true);
                this.kMw.setCommentClickable(true);
                this.kMw.setReplayContainerBgGray(true);
                this.kMw.setOnClickListener(aVar);
                this.kMw.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return CriusAdCardView.this.kMx.getAdvertAppInfo();
                    }
                });
                if (dO.anw != Integer.MIN_VALUE) {
                    this.kMw.setAgreeClickable(true);
                    this.kMw.setPraiseContainerBgGray(false);
                } else {
                    this.kMw.setAgreeClickable(false);
                    this.kMw.setPraiseContainerBgGray(true);
                }
                this.kMw.onChangeSkinType();
            }
            if (this.kMw != null) {
                if (this.kMu == null) {
                    this.kMu = new AdCloseView(this.dIF.getPageActivity());
                }
                if (this.kMu.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kMu.getParent()).removeView(this.kMu);
                }
                this.kMw.addAdMoreView(this.kMu);
                l(this.kMx.getAdvertAppInfo());
            }
        }
    }

    public void a(bk bkVar, com.baidu.b.a.c.a aVar) {
        if (bkVar != null && aVar != null) {
            if (this.kMy || (bkVar.aRW() <= 0 && bkVar.aSa() <= 0)) {
                if (this.kMy) {
                    this.kMy = false;
                }
                bkVar.kq(aVar.anv);
                bkVar.ky(aVar.anw);
                bkVar.cd(aVar.anu);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.kMx != null) {
            distributeVideoView.setPageContext(this.dIF);
            distributeVideoView.setVideoTailFrameData(this.kMx.tailFrame);
            distributeVideoView.setChargeInfo(this.kMx.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cUG() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.kMx.getAdvertAppInfo();
        a aVar = new a(this.kMx);
        setCriusViewClick(aVar);
        View dR = this.kMr.dR("head");
        if (dR != null && (dR instanceof HeadImageView)) {
            this.keL = (HeadImageView) dR;
            setHeadLongClick(advertAppInfo);
        }
        View dR2 = this.kMr.dR("download");
        if (dR2 != null && (dR2 instanceof ApkDownloadView)) {
            this.kMt = (ApkDownloadView) dR2;
            this.kMt.x(this.dIF.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View dR3 = this.kMr.dR("closead");
        if (dR3 != null && (dR3 instanceof AdCloseView)) {
            this.kMu = (AdCloseView) dR3;
            l(advertAppInfo);
        }
        View dR4 = this.kMr.dR("viewbtn");
        if (dR4 != null && (dR4 instanceof JumpButton)) {
            this.kMv = (JumpButton) dR4;
            cUF();
        }
        View dR5 = this.kMr.dR("bottombar");
        if (dR5 != null && (dR5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dR5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.kMw = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dS = this.kMr.dS("video");
        if (dS != null && (distributeVideoView = (DistributeVideoView) dS.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.kMx.directDownload) {
            this.kMs.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.anq)) {
            this.kMs.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dS = this.kMr.dS("video");
        if (dS == null || (distributeVideoView = (DistributeVideoView) dS.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dS = this.kMr.dS("video");
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
                zY = com.baidu.tieba.ad.download.d.bmD().zX(str);
            } else {
                zY = com.baidu.tieba.ad.download.d.bmD().zY(scheme);
            }
            if (zY == null) {
                zY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dAx);
                com.baidu.tieba.ad.download.d.bmD().a(zY, null);
            }
            i(zY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.eOe = downloadCacheKey;
        bmy();
        this.eOf = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bmD().d(downloadCacheKey);
        if (d != null) {
            this.kMt.a(d.getCurrentState());
        } else {
            this.kMt.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.kMx != null || this.kMx.getAdvertAppInfo() != null) {
            str = this.kMx.getAdvertAppInfo().page;
        }
        this.kMz = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kMt, d, str);
        this.eOf = new com.baidu.tieba.ad.download.a.b(this.kMz);
        if (d.extra().getPercent() > 0) {
            this.kMz.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bmx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard kME;

        public a(CriusAdCard criusAdCard) {
            this.kME = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.dIF.showToast(R.string.neterror);
            } else if (this.kME != null) {
                AdvertAppInfo advertAppInfo = this.kME.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aOz()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !com.baidu.adp.lib.util.j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.kMt) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.kMt, z);
                    CriusAdCardView.this.cUH();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.anq;
                }
                if (k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dAw;
                }
                int b = r.b(CriusAdCardView.this.dIF, str, (CriusAdCardView.this.kMx == null || CriusAdCardView.this.kMx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kMx.getAdvertAppInfo().dAu);
                if (CriusAdCardView.this.iZo != null) {
                    CriusAdCardView.this.iZo.d(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUH() {
        if (this.iZo != null) {
            this.iZo.d(3, null);
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
                    com.baidu.tieba.ad.download.d.bmD().aw(this.dIF.getPageActivity(), advertAppInfo.dAx);
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
                        if (CriusAdCardView.this.kMt != null) {
                            CriusAdCardView.this.kMt.q(CriusAdCardView.this.c(advertAppInfo, i));
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
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dIF.getPageActivity()) && this.iZp != null) {
                this.iZp.b(advertAppInfo, i);
                if (this.kMt != null) {
                    this.kMt.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cUI() {
        boolean z = true;
        if (this.iRc != null && this.kMr != null) {
            this.iRc.removeAllViews();
            com.baidu.b.a.d.a aVar = this.kMr;
            Activity pageActivity = this.dIF.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.kMs = aVar.a(pageActivity, aVar2, z);
            this.iRc.addView(this.kMs);
            am.setBackgroundResource(this.kMs, R.drawable.addresslist_item_bg);
            cUG();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ctG() {
        if (this.kMr != null && ((TextView) this.kMr.dS("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.dIF.getPageActivity()));
            cUI();
        }
    }
}
