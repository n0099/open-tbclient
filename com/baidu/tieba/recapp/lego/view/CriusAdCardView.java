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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.c.a.d.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdCriusCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.t;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes20.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private DownloadCacheKey fdc;
    private d fdd;
    private LinearLayout jBy;
    private HeadImageView kIJ;
    protected String lnS;
    private com.baidu.c.a.d.a loO;
    private ViewGroup loP;
    private ApkDownloadView loQ;
    private AdCloseView loR;
    private JumpButton loS;
    private AdThreadCommentAndPraiseInfoLayout loT;
    private CriusAdCard loU;
    private boolean loV;
    private com.baidu.tieba.ad.browser.newstyle.view.a loW;
    protected CustomMessageListener loX;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.loV = true;
        this.fdd = null;
        this.loX = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.lnS) && CriusAdCardView.this.lnS.equals(downloadData.getId()) && CriusAdCardView.this.loQ != null) {
                    CriusAdCardView.this.loQ.t(downloadData);
                }
            }
        };
        this.loO = new com.baidu.c.a.d.a();
        this.loO.a(new a.InterfaceC0095a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0095a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.loU == null || CriusAdCardView.this.loU.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.loU.getAdvertAppInfo().dMW;
                int c = (CriusAdCardView.this.loU.directDownload || !CriusAdCardView.this.loU.getAdvertAppInfo().aUf()) ? s.c(CriusAdCardView.this.dVN, str, str4) : s.d(CriusAdCardView.this.dVN, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.jzQ != null) {
                        CriusAdCardView.this.jzQ.d(c, null);
                    }
                } else if (CriusAdCardView.this.jzQ != null) {
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
                    CriusAdCardView.this.jzQ.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        this.jBy = new LinearLayout(this.dVN.getPageActivity());
        this.jBy.setOrientation(1);
        return this.jBy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ao.setBackgroundResource(this.loP, R.drawable.addresslist_item_bg);
        this.loO.h(this.dVN.getPageActivity(), i == 1 || i == 4);
        if (this.loQ != null) {
            this.loQ.onChangeSkinType(i);
        }
        if (this.loR != null) {
            this.loR.onChangeSkinType();
        }
        if (this.loT != null) {
            this.loT.onChangeSkinType();
        }
        ao.setBackgroundResource(this.loS, R.drawable.btn_focus_border_bg);
        ao.setViewTextColor(this.loS, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.loU = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            dcw();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bsb();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsc();
    }

    private void bsb() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().a(this.fdc, this.fdd);
        }
    }

    private void bsc() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().b(this.fdc, this.fdd);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.kIJ != null) {
            this.kIJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.bdQ() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.dVN.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aUf()) {
            if (!this.loU.directDownload) {
                a(this.loU, advertAppInfo);
                this.loQ.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bA(View view) {
                        CriusAdCardView.this.dcv();
                    }
                });
            } else {
                this.loQ.setOnClickListener(aVar);
            }
            this.loX.setTag(this.dVN.getUniqueId());
            MessageManager.getInstance().registerListener(this.loX);
            this.lnS = advertAppInfo.dMZ;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.loQ.setData(c);
            this.loQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.loU.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.loQ.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.loR != null && advertAppInfo != null && advertAppInfo.dNf != null && advertAppInfo.dNf.adCloseInfo != null && advertAppInfo.dNf.adCloseInfo.support_close.intValue() > 0) {
            this.loR.setPage(getBusinessType());
            this.loR.setData(advertAppInfo);
            this.loR.onChangeSkinType();
            if (this.loR instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.loR).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.dVN.getPageActivity(), this.loR, 40, 40, 40, 120);
        }
    }

    private void dct() {
        if (this.loS != null) {
            this.loS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a dP;
                    if (CriusAdCardView.this.criusData != null && (dP = CriusAdCardView.this.criusData.dP("viewbtn")) != null) {
                        if (!t.NE(dP.aoE) && CriusAdCardView.this.jzQ != null) {
                            CriusAdCardView.this.jzQ.a(dP.aoF, dP.aoG, null);
                        }
                        if (TextUtils.isEmpty(dP.aoH)) {
                            int c = s.c(CriusAdCardView.this.dVN, dP.aoE, (CriusAdCardView.this.loU == null || CriusAdCardView.this.loU.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.loU.getAdvertAppInfo().dMW);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.jzQ != null) {
                                CriusAdCardView.this.jzQ.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.dVN.getPageActivity());
                        aVar.xl(dP.aoH);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.dVN, dP.aoE, (CriusAdCardView.this.loU == null || CriusAdCardView.this.loU.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.loU.getAdvertAppInfo().dMW);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.jzQ != null) {
                                    CriusAdCardView.this.jzQ.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.dVN).aYL();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.loT != null) {
            final com.baidu.c.a.c.a dP = this.criusData.dP("bottombar");
            if (dP != null) {
                a(this.loU.getAdvertAppInfo(), dP);
                this.loT.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.loT.setBarNameClickEnabled(false);
                this.loT.setReplyTimeVisible(false);
                if (dP.aoI != Integer.MIN_VALUE) {
                    this.loT.setShareClickable(true);
                    this.loT.setShareContainerBgGray(false);
                } else {
                    this.loT.setShareClickable(false);
                    this.loT.setShareContainerBgGray(true);
                }
                this.loT.getCommentContainer().setOnClickListener(aVar);
                this.loT.setNeedAddReplyIcon(true);
                this.loT.setCommentNumEnable(true);
                this.loT.setCommentClickable(true);
                this.loT.setReplayContainerBgGray(true);
                this.loT.setOnClickListener(aVar);
                this.loT.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return dP.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return dP.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return dP.aoL;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return dP.aoM;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.loU.getAdvertAppInfo();
                    }
                });
                if (dP.aoK != Integer.MIN_VALUE) {
                    this.loT.setAgreeClickable(true);
                    this.loT.setPraiseContainerBgGray(false);
                } else {
                    this.loT.setAgreeClickable(false);
                    this.loT.setPraiseContainerBgGray(true);
                }
                this.loT.onChangeSkinType();
            }
            if (this.loT != null) {
                if (this.loR == null) {
                    this.loR = new AdCloseView(this.dVN.getPageActivity());
                }
                if (this.loR.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.loR.getParent()).removeView(this.loR);
                }
                this.loT.addAdMoreView(this.loR);
                l(this.loU.getAdvertAppInfo());
            }
        }
    }

    public void a(bv bvVar, com.baidu.c.a.c.a aVar) {
        if (bvVar != null && aVar != null) {
            if (this.loV || (bvVar.aXJ() <= 0 && bvVar.aXN() <= 0)) {
                if (this.loV) {
                    this.loV = false;
                }
                bvVar.la(aVar.aoJ);
                bvVar.li(aVar.aoK);
                bvVar.ct(aVar.aoI);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.loU != null) {
            distributeVideoView.setPageContext(this.dVN);
            distributeVideoView.setVideoTailFrameData(this.loU.tailFrame);
            distributeVideoView.setChargeInfo(this.loU.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void dcu() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.loU.getAdvertAppInfo();
        a aVar = new a(this.loU);
        setCriusViewClick(aVar);
        View dS = this.loO.dS("head");
        if (dS != null && (dS instanceof HeadImageView)) {
            this.kIJ = (HeadImageView) dS;
            setHeadLongClick(advertAppInfo);
        }
        View dS2 = this.loO.dS("download");
        if (dS2 != null && (dS2 instanceof ApkDownloadView)) {
            this.loQ = (ApkDownloadView) dS2;
            this.loQ.y(this.dVN.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View dS3 = this.loO.dS("closead");
        if (dS3 != null && (dS3 instanceof AdCloseView)) {
            this.loR = (AdCloseView) dS3;
            l(advertAppInfo);
        }
        View dS4 = this.loO.dS("viewbtn");
        if (dS4 != null && (dS4 instanceof JumpButton)) {
            this.loS = (JumpButton) dS4;
            dct();
        }
        View dS5 = this.loO.dS("bottombar");
        if (dS5 != null && (dS5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dS5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.loT = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dT = this.loO.dT("video");
        if (dT != null && (distributeVideoView = (DistributeVideoView) dT.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.loU.directDownload) {
            this.loP.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.aoE)) {
            this.loP.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dT = this.loO.dT("video");
        if (dT == null || (distributeVideoView = (DistributeVideoView) dT.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dT = this.loO.dT("video");
        if (dT != null && (distributeVideoView = (DistributeVideoView) dT.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Bc;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dMW;
            if (!TextUtils.isEmpty(str)) {
                Bc = com.baidu.tieba.ad.download.d.bsi().Bb(str);
            } else {
                Bc = com.baidu.tieba.ad.download.d.bsi().Bc(scheme);
            }
            if (Bc == null) {
                Bc = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dMZ);
                com.baidu.tieba.ad.download.d.bsi().a(Bc, null);
            }
            i(Bc);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.fdc = downloadCacheKey;
        bsc();
        this.fdd = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bsi().d(downloadCacheKey);
        if (d != null) {
            this.loQ.a(d.getCurrentState());
        } else {
            this.loQ.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.loU != null || this.loU.getAdvertAppInfo() != null) {
            str = this.loU.getAdvertAppInfo().page;
        }
        this.loW = new com.baidu.tieba.ad.browser.newstyle.view.a(this.loQ, d, str);
        this.fdd = new com.baidu.tieba.ad.download.a.b(this.loW);
        if (d.extra().getPercent() > 0) {
            this.loW.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bsb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard lpb;

        public a(CriusAdCard criusAdCard) {
            this.lpb = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.dVN.showToast(R.string.neterror);
            } else if (this.lpb != null) {
                AdvertAppInfo advertAppInfo = this.lpb.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aUf()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.loQ) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.loQ, z);
                    CriusAdCardView.this.dcv();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.aoE;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dMY;
                }
                int c = s.c(CriusAdCardView.this.dVN, str, (CriusAdCardView.this.loU == null || CriusAdCardView.this.loU.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.loU.getAdvertAppInfo().dMW);
                if (CriusAdCardView.this.jzQ != null) {
                    CriusAdCardView.this.jzQ.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcv() {
        if (this.jzQ != null) {
            this.jzQ.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aM(this.dVN.getPageActivity(), advertAppInfo.dMZ);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bsi().av(this.dVN.getPageActivity(), advertAppInfo.dMZ);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dMW, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dVN.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.aUf()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dVN.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
                aVar.xl(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.loQ != null) {
                            CriusAdCardView.this.loQ.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.dVN).aYL();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aUe() != 0) {
                l.showToast(this.dVN.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dVN.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dVN.getPageActivity()) && this.jzR != null) {
                this.jzR.b(advertAppInfo, i);
                if (this.loQ != null) {
                    this.loQ.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void dcw() {
        boolean z = true;
        if (this.jBy != null && this.loO != null) {
            this.jBy.removeAllViews();
            com.baidu.c.a.d.a aVar = this.loO;
            Activity pageActivity = this.dVN.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.loP = aVar.a(pageActivity, aVar2, z);
            this.jBy.addView(this.loP);
            ao.setBackgroundResource(this.loP, R.drawable.addresslist_item_bg);
            dcu();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cBD() {
        if (this.loO != null && ((TextView) this.loO.dT("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.dVN.getPageActivity()));
            dcw();
        }
    }
}
