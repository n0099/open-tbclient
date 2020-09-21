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
import com.baidu.g.a.d.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
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
import com.baidu.tieba.tbadkCore.u;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes25.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.g.a.c.a criusData;
    private DownloadCacheKey frG;
    private d frH;
    private LinearLayout jSb;
    protected String lNx;
    private com.baidu.g.a.d.a lOq;
    private ViewGroup lOr;
    private ApkDownloadView lOs;
    private AdCloseView lOt;
    private JumpButton lOu;
    private AdThreadCommentAndPraiseInfoLayout lOv;
    private CriusAdCard lOw;
    private boolean lOx;
    private com.baidu.tieba.ad.browser.newstyle.view.a lOy;
    protected CustomMessageListener lOz;
    private HeadImageView lhj;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lOx = true;
        this.frH = null;
        this.lOz = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.lNx) && CriusAdCardView.this.lNx.equals(downloadData.getId()) && CriusAdCardView.this.lOs != null) {
                    CriusAdCardView.this.lOs.t(downloadData);
                }
            }
        };
        this.lOq = new com.baidu.g.a.d.a(tbPageContext);
        this.lOq.a(new a.InterfaceC0130a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.g.a.d.a.InterfaceC0130a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.lOw == null || CriusAdCardView.this.lOw.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lOw.getAdvertAppInfo().dYt;
                int c = (CriusAdCardView.this.lOw == null || CriusAdCardView.this.lOw.directDownload || !CriusAdCardView.this.lOw.getAdvertAppInfo().bdq()) ? s.c(CriusAdCardView.this.ehG, str, str4) : s.d(CriusAdCardView.this.ehG, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.jXT != null) {
                        CriusAdCardView.this.jXT.d(c, null);
                    }
                } else if (CriusAdCardView.this.jXT != null) {
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
                    CriusAdCardView.this.jXT.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cPW() {
        this.jSb = new LinearLayout(this.ehG.getPageActivity());
        this.jSb.setOrientation(1);
        return this.jSb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ap.setBackgroundResource(this.lOr, R.drawable.addresslist_item_bg);
        this.lOq.h(this.ehG.getPageActivity(), i == 1 || i == 4);
        if (this.lOs != null) {
            this.lOs.onChangeSkinType(i);
        }
        if (this.lOt != null) {
            this.lOt.onChangeSkinType();
        }
        if (this.lOv != null) {
            this.lOv.onChangeSkinType();
        }
        ap.setBackgroundResource(this.lOu, R.drawable.btn_focus_border_bg);
        ap.setViewTextColor(this.lOu, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.lOw = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            drq();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bCl();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCm();
    }

    private void bCl() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().a(this.frG, this.frH);
        }
    }

    private void bCm() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().b(this.frG, this.frH);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.lhj != null) {
            this.lhj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.bnq() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.ehG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.bdq()) {
            if (!this.lOw.directDownload) {
                a(this.lOw, advertAppInfo);
                this.lOs.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bG(View view) {
                        CriusAdCardView.this.drp();
                        return false;
                    }
                });
            } else {
                this.lOs.setOnClickListener(aVar);
            }
            this.lOz.setTag(this.ehG.getUniqueId());
            MessageManager.getInstance().registerListener(this.lOz);
            this.lNx = advertAppInfo.dYw;
            DownloadData b = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(b);
            this.lOs.setData(b);
            this.lOs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.lOw.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lOs.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.lOt != null && advertAppInfo != null && advertAppInfo.dYC != null && advertAppInfo.dYC.adCloseInfo != null && advertAppInfo.dYC.adCloseInfo.support_close.intValue() > 0) {
            this.lOt.setPage(getBusinessType());
            this.lOt.setData(advertAppInfo);
            this.lOt.onChangeSkinType();
            if (this.lOt instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.lOt).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.ehG.getPageActivity(), this.lOt, 40, 40, 40, 120);
        }
    }

    private void drn() {
        if (this.lOu != null) {
            this.lOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.g.a.c.a fl;
                    if (CriusAdCardView.this.criusData != null && (fl = CriusAdCardView.this.criusData.fl("viewbtn")) != null) {
                        if (!u.PL(fl.aug) && CriusAdCardView.this.jXT != null) {
                            CriusAdCardView.this.jXT.a(fl.auh, fl.aui, null);
                        }
                        if (TextUtils.isEmpty(fl.auj)) {
                            int c = s.c(CriusAdCardView.this.ehG, fl.aug, (CriusAdCardView.this.lOw == null || CriusAdCardView.this.lOw.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lOw.getAdvertAppInfo().dYt);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.jXT != null) {
                                CriusAdCardView.this.jXT.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.ehG.getPageActivity());
                        aVar.zV(fl.auj);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.ehG, fl.aug, (CriusAdCardView.this.lOw == null || CriusAdCardView.this.lOw.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lOw.getAdvertAppInfo().dYt);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.jXT != null) {
                                    CriusAdCardView.this.jXT.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.ehG).bia();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.lOv != null) {
            final com.baidu.g.a.c.a fl = this.criusData.fl("bottombar");
            if (fl != null) {
                a(this.lOw.getAdvertAppInfo(), fl);
                this.lOv.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.lOv.setBarNameClickEnabled(false);
                this.lOv.setReplyTimeVisible(false);
                if (fl.auk != Integer.MIN_VALUE) {
                    this.lOv.setShareClickable(true);
                    this.lOv.setShareContainerBgGray(false);
                } else {
                    this.lOv.setShareClickable(false);
                    this.lOv.setShareContainerBgGray(true);
                }
                this.lOv.getCommentContainer().setOnClickListener(aVar);
                this.lOv.setNeedAddReplyIcon(true);
                this.lOv.setCommentNumEnable(true);
                this.lOv.setCommentClickable(true);
                this.lOv.setReplayContainerBgGray(true);
                this.lOv.setOnClickListener(aVar);
                this.lOv.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return fl.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return fl.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return fl.aun;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return fl.auo;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.lOw.getAdvertAppInfo();
                    }
                });
                if (fl.aum != Integer.MIN_VALUE) {
                    this.lOv.setAgreeClickable(true);
                    this.lOv.setPraiseContainerBgGray(false);
                } else {
                    this.lOv.setAgreeClickable(false);
                    this.lOv.setPraiseContainerBgGray(true);
                }
                this.lOv.onChangeSkinType();
            }
            if (this.lOv != null) {
                if (this.lOt == null) {
                    this.lOt = new AdCloseView(this.ehG.getPageActivity());
                }
                if (this.lOt.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lOt.getParent()).removeView(this.lOt);
                }
                this.lOv.addAdMoreView(this.lOt);
                k(this.lOw.getAdvertAppInfo());
            }
        }
    }

    public void a(bw bwVar, com.baidu.g.a.c.a aVar) {
        if (bwVar != null && aVar != null) {
            if (this.lOx || (bwVar.bgW() <= 0 && bwVar.bha() <= 0)) {
                if (this.lOx) {
                    this.lOx = false;
                }
                bwVar.nr(aVar.aul);
                bwVar.nz(aVar.aum);
                bwVar.cE(aVar.auk);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.lOw != null) {
            distributeVideoView.setPageContext(this.ehG);
            distributeVideoView.setVideoTailFrameData(this.lOw.tailFrame);
            distributeVideoView.setChargeInfo(this.lOw.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void dro() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.lOw.getAdvertAppInfo();
        a aVar = new a(this.lOw);
        setCriusViewClick(aVar);
        View fo = this.lOq.fo("head");
        if (fo != null && (fo instanceof HeadImageView)) {
            this.lhj = (HeadImageView) fo;
            setHeadLongClick(advertAppInfo);
        }
        View fo2 = this.lOq.fo("download");
        if (fo2 != null && (fo2 instanceof ApkDownloadView)) {
            this.lOs = (ApkDownloadView) fo2;
            this.lOs.x(this.ehG.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View fo3 = this.lOq.fo("closead");
        if (fo3 != null && (fo3 instanceof AdCloseView)) {
            this.lOt = (AdCloseView) fo3;
            k(advertAppInfo);
        }
        View fo4 = this.lOq.fo("viewbtn");
        if (fo4 != null && (fo4 instanceof JumpButton)) {
            this.lOu = (JumpButton) fo4;
            drn();
        }
        View fo5 = this.lOq.fo("bottombar");
        if (fo5 != null && (fo5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) fo5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.lOv = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View fp = this.lOq.fp("video");
        if (fp != null && (distributeVideoView = (DistributeVideoView) fp.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.lOw.directDownload) {
            this.lOr.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.aug)) {
            this.lOr.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View fp = this.lOq.fp("video");
        if (fp == null || (distributeVideoView = (DistributeVideoView) fp.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View fp = this.lOq.fp("video");
        if (fp != null && (distributeVideoView = (DistributeVideoView) fp.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey DU;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dYt;
            if (!TextUtils.isEmpty(str)) {
                DU = com.baidu.tieba.ad.download.d.bCs().DT(str);
            } else {
                DU = com.baidu.tieba.ad.download.d.bCs().DU(scheme);
            }
            if (DU == null) {
                DU = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dYw);
                com.baidu.tieba.ad.download.d.bCs().a(DU, null);
            }
            i(DU);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.frG = downloadCacheKey;
        bCm();
        this.frH = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bCs().d(downloadCacheKey);
        if (d != null) {
            this.lOs.a(d.getCurrentState());
        } else {
            this.lOs.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.lOw != null && this.lOw.getAdvertAppInfo() != null) {
            str = this.lOw.getAdvertAppInfo().page;
            d.setExtInfo(this.lOw.getAdvertAppInfo().extensionInfo);
        }
        this.lOy = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lOs, d, str);
        this.frH = new com.baidu.tieba.ad.download.a.b(this.lOy);
        if (d.extra().getPercent() > 0) {
            this.lOy.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bCl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard lOD;

        public a(CriusAdCard criusAdCard) {
            this.lOD = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.ehG.showToast(R.string.neterror);
            } else if (this.lOD != null) {
                AdvertAppInfo advertAppInfo = this.lOD.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.bdq()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.b(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.lOs) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.lOs, z);
                    CriusAdCardView.this.drp();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.aug;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dYv;
                }
                int c = s.c(CriusAdCardView.this.ehG, str, (CriusAdCardView.this.lOw == null || CriusAdCardView.this.lOw.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lOw.getAdvertAppInfo().dYt);
                if (CriusAdCardView.this.jXT != null) {
                    CriusAdCardView.this.jXT.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drp() {
        if (this.jXT != null) {
            this.jXT.d(3, null);
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null && apkDownloadView != null) {
            DownloadData b = b(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(b)) {
                case 1:
                case 5:
                    if (z) {
                        com.baidu.tieba.recapp.download.h.e(advertAppInfo);
                        apkDownloadView.r(b);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    com.baidu.tieba.recapp.download.h.aT(this.ehG.getPageActivity(), advertAppInfo.dYw);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bCs().aC(this.ehG.getPageActivity(), advertAppInfo.dYw);
                    return;
            }
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dYw);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dYu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dYt, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ehG.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bdq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ehG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
                aVar.zV(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.lOs != null) {
                            CriusAdCardView.this.lOs.q(CriusAdCardView.this.b(advertAppInfo, i));
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
                aVar.b(this.ehG).bia();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bdp() != 0) {
                l.showToast(this.ehG.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.ehG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.ehG.getPageActivity()) && this.jXU != null) {
                this.jXU.c(advertAppInfo, i);
                if (this.lOs != null) {
                    this.lOs.q(b(advertAppInfo, i));
                }
            }
        }
    }

    private void drq() {
        boolean z = true;
        if (this.jSb != null && this.lOq != null) {
            this.jSb.removeAllViews();
            com.baidu.g.a.d.a aVar = this.lOq;
            Activity pageActivity = this.ehG.getPageActivity();
            com.baidu.g.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.lOr = aVar.a(pageActivity, aVar2, z);
            this.jSb.addView(this.lOr);
            ap.setBackgroundResource(this.lOr, R.drawable.addresslist_item_bg);
            dro();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cQc() {
        if (this.lOq != null && ((TextView) this.lOq.fp("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.ehG.getPageActivity()));
            drq();
        }
    }
}
