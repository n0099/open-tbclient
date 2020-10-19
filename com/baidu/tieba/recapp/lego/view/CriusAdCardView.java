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
/* loaded from: classes26.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.g.a.c.a criusData;
    private DownloadCacheKey fDR;
    private d fDS;
    private LinearLayout kha;
    private HeadImageView lwA;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected String mcO;
    private com.baidu.g.a.d.a mdH;
    private ViewGroup mdI;
    private ApkDownloadView mdJ;
    private AdCloseView mdK;
    private JumpButton mdL;
    private AdThreadCommentAndPraiseInfoLayout mdM;
    private CriusAdCard mdN;
    private boolean mdO;
    private com.baidu.tieba.ad.browser.newstyle.view.a mdP;
    protected CustomMessageListener mdQ;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mdO = true;
        this.fDS = null;
        this.mdQ = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.mcO) && CriusAdCardView.this.mcO.equals(downloadData.getId()) && CriusAdCardView.this.mdJ != null) {
                    CriusAdCardView.this.mdJ.t(downloadData);
                }
            }
        };
        this.mdH = new com.baidu.g.a.d.a(tbPageContext);
        this.mdH.a(new a.InterfaceC0134a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.g.a.d.a.InterfaceC0134a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.mdN == null || CriusAdCardView.this.mdN.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mdN.getAdvertAppInfo().ekv;
                int c = (CriusAdCardView.this.mdN == null || CriusAdCardView.this.mdN.directDownload || !CriusAdCardView.this.mdN.getAdvertAppInfo().bfZ()) ? s.c(CriusAdCardView.this.etO, str, str4) : s.d(CriusAdCardView.this.etO, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.knj != null) {
                        CriusAdCardView.this.knj.d(c, null);
                    }
                } else if (CriusAdCardView.this.knj != null) {
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
                    CriusAdCardView.this.knj.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cTG() {
        this.kha = new LinearLayout(this.etO.getPageActivity());
        this.kha.setOrientation(1);
        return this.kha;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ap.setBackgroundResource(this.mdI, R.drawable.addresslist_item_bg);
        this.mdH.h(this.etO.getPageActivity(), i == 1 || i == 4);
        if (this.mdJ != null) {
            this.mdJ.onChangeSkinType(i);
        }
        if (this.mdK != null) {
            this.mdK.onChangeSkinType();
        }
        if (this.mdM != null) {
            this.mdM.onChangeSkinType();
        }
        ap.setBackgroundResource(this.mdL, R.drawable.btn_focus_border_bg);
        ap.setViewTextColor(this.mdL, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.mdN = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            dvb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bEX();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEY();
    }

    private void bEX() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().a(this.fDR, this.fDS);
        }
    }

    private void bEY() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().b(this.fDR, this.fDS);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.lwA != null) {
            this.lwA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.bqa() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.etO.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.bfZ()) {
            if (!this.mdN.directDownload) {
                a(this.mdN, advertAppInfo);
                this.mdJ.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bK(View view) {
                        CriusAdCardView.this.dva();
                        return false;
                    }
                });
            } else {
                this.mdJ.setOnClickListener(aVar);
            }
            this.mdQ.setTag(this.etO.getUniqueId());
            MessageManager.getInstance().registerListener(this.mdQ);
            this.mcO = advertAppInfo.eky;
            DownloadData b = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(b);
            this.mdJ.setData(b);
            this.mdJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.mdN.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mdJ.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.mdK != null && advertAppInfo != null && advertAppInfo.ekE != null && advertAppInfo.ekE.adCloseInfo != null && advertAppInfo.ekE.adCloseInfo.support_close.intValue() > 0) {
            this.mdK.setPage(getBusinessType());
            this.mdK.setData(advertAppInfo);
            this.mdK.onChangeSkinType();
            if (this.mdK instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.mdK).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.etO.getPageActivity(), this.mdK, 40, 40, 40, 120);
        }
    }

    private void duY() {
        if (this.mdL != null) {
            this.mdL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.g.a.c.a fq;
                    if (CriusAdCardView.this.criusData != null && (fq = CriusAdCardView.this.criusData.fq("viewbtn")) != null) {
                        if (!u.QA(fq.auP) && CriusAdCardView.this.knj != null) {
                            CriusAdCardView.this.knj.a(fq.auQ, fq.auR, null);
                        }
                        if (TextUtils.isEmpty(fq.auS)) {
                            int c = s.c(CriusAdCardView.this.etO, fq.auP, (CriusAdCardView.this.mdN == null || CriusAdCardView.this.mdN.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mdN.getAdvertAppInfo().ekv);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.knj != null) {
                                CriusAdCardView.this.knj.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.etO.getPageActivity());
                        aVar.AH(fq.auS);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.etO, fq.auP, (CriusAdCardView.this.mdN == null || CriusAdCardView.this.mdN.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mdN.getAdvertAppInfo().ekv);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.knj != null) {
                                    CriusAdCardView.this.knj.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.etO).bkJ();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.mdM != null) {
            final com.baidu.g.a.c.a fq = this.criusData.fq("bottombar");
            if (fq != null) {
                a(this.mdN.getAdvertAppInfo(), fq);
                this.mdM.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.mdM.setBarNameClickEnabled(false);
                this.mdM.setReplyTimeVisible(false);
                if (fq.auT != Integer.MIN_VALUE) {
                    this.mdM.setShareClickable(true);
                    this.mdM.setShareContainerBgGray(false);
                } else {
                    this.mdM.setShareClickable(false);
                    this.mdM.setShareContainerBgGray(true);
                }
                this.mdM.getCommentContainer().setOnClickListener(aVar);
                this.mdM.setNeedAddReplyIcon(true);
                this.mdM.setCommentNumEnable(true);
                this.mdM.setCommentClickable(true);
                this.mdM.setReplayContainerBgGray(true);
                this.mdM.setOnClickListener(aVar);
                this.mdM.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return fq.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return fq.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return fq.auW;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return fq.auX;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.mdN.getAdvertAppInfo();
                    }
                });
                if (fq.auV != Integer.MIN_VALUE) {
                    this.mdM.setAgreeClickable(true);
                    this.mdM.setPraiseContainerBgGray(false);
                } else {
                    this.mdM.setAgreeClickable(false);
                    this.mdM.setPraiseContainerBgGray(true);
                }
                this.mdM.onChangeSkinType();
            }
            if (this.mdM != null) {
                if (this.mdK == null) {
                    this.mdK = new AdCloseView(this.etO.getPageActivity());
                }
                if (this.mdK.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mdK.getParent()).removeView(this.mdK);
                }
                this.mdM.addAdMoreView(this.mdK);
                k(this.mdN.getAdvertAppInfo());
            }
        }
    }

    public void a(bw bwVar, com.baidu.g.a.c.a aVar) {
        if (bwVar != null && aVar != null) {
            if (this.mdO || (bwVar.bjF() <= 0 && bwVar.bjJ() <= 0)) {
                if (this.mdO) {
                    this.mdO = false;
                }
                bwVar.nO(aVar.auU);
                bwVar.nW(aVar.auV);
                bwVar.cM(aVar.auT);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.mdN != null) {
            distributeVideoView.setPageContext(this.etO);
            distributeVideoView.setVideoTailFrameData(this.mdN.tailFrame);
            distributeVideoView.setChargeInfo(this.mdN.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void duZ() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.mdN.getAdvertAppInfo();
        a aVar = new a(this.mdN);
        setCriusViewClick(aVar);
        View ft = this.mdH.ft("head");
        if (ft != null && (ft instanceof HeadImageView)) {
            this.lwA = (HeadImageView) ft;
            setHeadLongClick(advertAppInfo);
        }
        View ft2 = this.mdH.ft("download");
        if (ft2 != null && (ft2 instanceof ApkDownloadView)) {
            this.mdJ = (ApkDownloadView) ft2;
            this.mdJ.x(this.etO.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View ft3 = this.mdH.ft("closead");
        if (ft3 != null && (ft3 instanceof AdCloseView)) {
            this.mdK = (AdCloseView) ft3;
            k(advertAppInfo);
        }
        View ft4 = this.mdH.ft("viewbtn");
        if (ft4 != null && (ft4 instanceof JumpButton)) {
            this.mdL = (JumpButton) ft4;
            duY();
        }
        View ft5 = this.mdH.ft("bottombar");
        if (ft5 != null && (ft5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) ft5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.mdM = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View fu = this.mdH.fu("video");
        if (fu != null && (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.mdN.directDownload) {
            this.mdI.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.auP)) {
            this.mdI.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View fu = this.mdH.fu("video");
        if (fu == null || (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View fu = this.mdH.fu("video");
        if (fu != null && (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EF;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.ekv;
            if (!TextUtils.isEmpty(str)) {
                EF = com.baidu.tieba.ad.download.d.bFe().EE(str);
            } else {
                EF = com.baidu.tieba.ad.download.d.bFe().EF(scheme);
            }
            if (EF == null) {
                EF = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eky);
                com.baidu.tieba.ad.download.d.bFe().a(EF, null);
            }
            i(EF);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.fDR = downloadCacheKey;
        bEY();
        this.fDS = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bFe().d(downloadCacheKey);
        if (d != null) {
            this.mdJ.a(d.getCurrentState());
        } else {
            this.mdJ.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.mdN != null && this.mdN.getAdvertAppInfo() != null) {
            str = this.mdN.getAdvertAppInfo().page;
            d.setExtInfo(this.mdN.getAdvertAppInfo().extensionInfo);
        }
        this.mdP = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mdJ, d, str);
        this.fDS = new com.baidu.tieba.ad.download.a.b(this.mdP);
        if (d.extra().getPercent() > 0) {
            this.mdP.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bEX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard mdU;

        public a(CriusAdCard criusAdCard) {
            this.mdU = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.etO.showToast(R.string.neterror);
            } else if (this.mdU != null) {
                AdvertAppInfo advertAppInfo = this.mdU.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.bfZ()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.b(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.mdJ) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.mdJ, z);
                    CriusAdCardView.this.dva();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.auP;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.ekx;
                }
                int c = s.c(CriusAdCardView.this.etO, str, (CriusAdCardView.this.mdN == null || CriusAdCardView.this.mdN.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mdN.getAdvertAppInfo().ekv);
                if (CriusAdCardView.this.knj != null) {
                    CriusAdCardView.this.knj.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dva() {
        if (this.knj != null) {
            this.knj.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aV(this.etO.getPageActivity(), advertAppInfo.eky);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bFe().aF(this.etO.getPageActivity(), advertAppInfo.eky);
                    return;
            }
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eky);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.ekw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.ekv, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.etO.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bfZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.etO.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
                aVar.AH(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.mdJ != null) {
                            CriusAdCardView.this.mdJ.q(CriusAdCardView.this.b(advertAppInfo, i));
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
                aVar.b(this.etO).bkJ();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bfY() != 0) {
                l.showToast(this.etO.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.etO.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.etO.getPageActivity()) && this.knk != null) {
                this.knk.c(advertAppInfo, i);
                if (this.mdJ != null) {
                    this.mdJ.q(b(advertAppInfo, i));
                }
            }
        }
    }

    private void dvb() {
        boolean z = true;
        if (this.kha != null && this.mdH != null) {
            this.kha.removeAllViews();
            com.baidu.g.a.d.a aVar = this.mdH;
            Activity pageActivity = this.etO.getPageActivity();
            com.baidu.g.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.mdI = aVar.a(pageActivity, aVar2, z);
            this.kha.addView(this.mdI);
            ap.setBackgroundResource(this.mdI, R.drawable.addresslist_item_bg);
            duZ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cTM() {
        if (this.mdH != null && ((TextView) this.mdH.fu("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.etO.getPageActivity()));
            dvb();
        }
    }
}
