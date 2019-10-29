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
import com.baidu.b.a.d.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
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
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.b.a.c.a criusData;
    private DownloadCacheKey dhN;
    private d dhO;
    private LinearLayout gXW;
    private com.baidu.b.a.d.a iKQ;
    private ViewGroup iKR;
    private HeadImageView iKS;
    private ApkDownloadView iKT;
    private AdCloseView iKU;
    private JumpButton iKV;
    private AdThreadCommentAndPraiseInfoLayout iKW;
    private CriusAdCard iKX;
    private boolean iKY;
    private com.baidu.tieba.ad.browser.newstyle.view.a iKZ;
    protected String iKa;
    protected CustomMessageListener iLa;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iKY = true;
        this.dhO = null;
        this.iLa = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iKa) && CriusAdCardView.this.iKa.equals(downloadData.getId()) && CriusAdCardView.this.iKT != null) {
                    CriusAdCardView.this.iKT.t(downloadData);
                }
            }
        };
        this.iKQ = new com.baidu.b.a.d.a();
        this.iKQ.a(new a.InterfaceC0041a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0041a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.iKX == null || CriusAdCardView.this.iKX.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKX.getAdvertAppInfo().bXk;
                int a2 = (CriusAdCardView.this.iKX.directDownload || !CriusAdCardView.this.iKX.getAdvertAppInfo().agS()) ? s.a(CriusAdCardView.this.cfl, str, str4) : s.b(CriusAdCardView.this.cfl, str, str4);
                if (a2 == 1 || a2 == 2) {
                    if (CriusAdCardView.this.hfN != null) {
                        CriusAdCardView.this.hfN.b(a2, null);
                    }
                } else if (CriusAdCardView.this.hfN != null) {
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
                    CriusAdCardView.this.hfN.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIg() {
        this.gXW = new LinearLayout(this.cfl.getPageActivity());
        this.gXW.setOrientation(1);
        return this.gXW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.iKR, R.drawable.addresslist_item_bg);
        this.iKQ.f(this.cfl.getPageActivity(), i == 1 || i == 4);
        if (this.iKT != null) {
            this.iKT.onChangeSkinType(i);
        }
        if (this.iKU != null) {
            this.iKU.onChangeSkinType();
        }
        if (this.iKW != null) {
            this.iKW.onChangeSkinType();
        }
        am.setBackgroundResource(this.iKV, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.iKV, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iKX = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cgi();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDC();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDD();
    }

    private void aDC() {
        if (this.dhN != null && this.dhO != null) {
            com.baidu.tieba.ad.download.d.aDI().a(this.dhN, this.dhO);
        }
    }

    private void aDD() {
        if (this.dhN != null && this.dhO != null) {
            com.baidu.tieba.ad.download.d.aDI().b(this.dhN, this.dhO);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iKS != null) {
            this.iKS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aoY() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cfl.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.agS()) {
            if (!this.iKX.directDownload) {
                a(this.iKX, advertAppInfo);
                this.iKT.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bo(View view) {
                        CriusAdCardView.this.cgh();
                    }
                });
            } else {
                this.iKT.setOnClickListener(aVar);
            }
            this.iLa.setTag(this.cfl.getUniqueId());
            MessageManager.getInstance().registerListener(this.iLa);
            this.iKa = advertAppInfo.bXo;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.iKT.setData(c);
            this.iKT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.iKX.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.iKT.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.iKU != null && advertAppInfo != null && advertAppInfo.bXu != null && advertAppInfo.bXu.adCloseInfo != null && advertAppInfo.bXu.adCloseInfo.support_close.intValue() > 0) {
            this.iKU.setPage(getBusinessType());
            this.iKU.setData(advertAppInfo);
            this.iKU.onChangeSkinType();
            l.addToParentArea(this.cfl.getPageActivity(), this.iKU, 40, 40, 40, 120);
        }
    }

    private void cgf() {
        if (this.iKV != null) {
            this.iKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a bM;
                    if (CriusAdCardView.this.criusData != null && (bM = CriusAdCardView.this.criusData.bM("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.DH(bM.LD) && CriusAdCardView.this.hfN != null) {
                            CriusAdCardView.this.hfN.b(bM.LE, bM.LG, null);
                        }
                        if (TextUtils.isEmpty(bM.LH)) {
                            int a2 = s.a(CriusAdCardView.this.cfl, bM.LD, (CriusAdCardView.this.iKX == null || CriusAdCardView.this.iKX.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKX.getAdvertAppInfo().bXk);
                            if ((a2 == 1 || a2 == 2) && CriusAdCardView.this.hfN != null) {
                                CriusAdCardView.this.hfN.b(a2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cfl.getPageActivity());
                        aVar.nn(bM.LH);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int a3 = s.a(CriusAdCardView.this.cfl, bM.LD, (CriusAdCardView.this.iKX == null || CriusAdCardView.this.iKX.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKX.getAdvertAppInfo().bXk);
                                if ((a3 == 1 || a3 == 2) && CriusAdCardView.this.hfN != null) {
                                    CriusAdCardView.this.hfN.b(a3, null);
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
                        aVar.b(CriusAdCardView.this.cfl).akO();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bM;
        if (this.iKW != null && (bM = this.criusData.bM("bottombar")) != null) {
            a(this.iKX.getAdvertAppInfo(), bM);
            this.iKW.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iKW.setBarNameClickEnabled(false);
            this.iKW.setReplyTimeVisible(false);
            if (bM.LI != Integer.MIN_VALUE) {
                this.iKW.setShareClickable(true);
                this.iKW.setShareContainerBgGray(false);
            } else {
                this.iKW.setShareClickable(false);
                this.iKW.setShareContainerBgGray(true);
            }
            this.iKW.getCommentContainer().setOnClickListener(aVar);
            this.iKW.setNeedAddReplyIcon(true);
            this.iKW.setCommentNumEnable(true);
            this.iKW.setCommentClickable(true);
            this.iKW.setReplayContainerBgGray(true);
            this.iKW.setOnClickListener(aVar);
            this.iKW.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return bM.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return bM.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return bM.LM;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bM.LN;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.iKX.getAdvertAppInfo();
                }
            });
            if (bM.LK != Integer.MIN_VALUE) {
                this.iKW.setAgreeClickable(true);
                this.iKW.setPraiseContainerBgGray(false);
            } else {
                this.iKW.setAgreeClickable(false);
                this.iKW.setPraiseContainerBgGray(true);
            }
            this.iKW.onChangeSkinType();
        }
    }

    public void a(bh bhVar, com.baidu.b.a.c.a aVar) {
        if (bhVar != null && aVar != null) {
            if (this.iKY || (bhVar.ajY() <= 0 && bhVar.akc() <= 0)) {
                if (this.iKY) {
                    this.iKY = false;
                }
                bhVar.hI(aVar.LJ);
                bhVar.hQ(aVar.LK);
                bhVar.aN(aVar.LI);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iKX != null) {
            distributeVideoView.setPageContext(this.cfl);
            distributeVideoView.setVideoTailFrameData(this.iKX.tailFrame);
            distributeVideoView.setChargeInfo(this.iKX.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cgg() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iKX.getAdvertAppInfo();
        a aVar = new a(this.iKX);
        setCriusViewClick(aVar);
        View bP = this.iKQ.bP("head");
        if (bP != null && (bP instanceof HeadImageView)) {
            this.iKS = (HeadImageView) bP;
            setHeadLongClick(advertAppInfo);
        }
        View bP2 = this.iKQ.bP("download");
        if (bP2 != null && (bP2 instanceof ApkDownloadView)) {
            this.iKT = (ApkDownloadView) bP2;
            this.iKT.t(this.cfl.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View bP3 = this.iKQ.bP("closead");
        if (bP3 != null && (bP3 instanceof AdCloseView)) {
            this.iKU = (AdCloseView) bP3;
            l(advertAppInfo);
        }
        View bP4 = this.iKQ.bP("viewbtn");
        if (bP4 != null && (bP4 instanceof JumpButton)) {
            this.iKV = (JumpButton) bP4;
            cgf();
        }
        View bP5 = this.iKQ.bP("bottombar");
        if (bP5 != null && (bP5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bP5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iKW = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bQ = this.iKQ.bQ("video");
        if (bQ != null && (distributeVideoView = (DistributeVideoView) bQ.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.iKX.directDownload) {
            this.iKR.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.LD)) {
            this.iKR.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bQ = this.iKQ.bQ("video");
        if (bQ == null || (distributeVideoView = (DistributeVideoView) bQ.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bQ = this.iKQ.bQ("video");
        if (bQ != null && (distributeVideoView = (DistributeVideoView) bQ.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ru;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.bXk;
            if (!TextUtils.isEmpty(str)) {
                ru = com.baidu.tieba.ad.download.d.aDI().rt(str);
            } else {
                ru = com.baidu.tieba.ad.download.d.aDI().ru(scheme);
            }
            if (ru == null) {
                ru = DownloadCacheKey.create(str, advertAppInfo.bXn, advertAppInfo.bXo);
                com.baidu.tieba.ad.download.d.aDI().a(ru, null);
            }
            i(ru);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dhN = downloadCacheKey;
        aDD();
        this.dhO = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aDI().d(downloadCacheKey);
        if (d != null) {
            this.iKT.a(d.getCurrentState());
        } else {
            this.iKT.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.iKX != null || this.iKX.getAdvertAppInfo() != null) {
            str = this.iKX.getAdvertAppInfo().page;
        }
        this.iKZ = new com.baidu.tieba.ad.browser.newstyle.view.a(this.iKT, d, str);
        this.dhO = new com.baidu.tieba.ad.download.a.b(this.iKZ);
        if (d.extra().getPercent() > 0) {
            this.iKZ.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aDC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iLe;

        public a(CriusAdCard criusAdCard) {
            this.iLe = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cfl.showToast(R.string.neterror);
            } else if (this.iLe != null) {
                AdvertAppInfo advertAppInfo = this.iLe.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.agS()) {
                    int i = com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.iKT) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.iKT, z);
                    CriusAdCardView.this.cgh();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.LD;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bXm;
                }
                int a = s.a(CriusAdCardView.this.cfl, str, (CriusAdCardView.this.iKX == null || CriusAdCardView.this.iKX.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKX.getAdvertAppInfo().bXk);
                if (CriusAdCardView.this.hfN != null) {
                    CriusAdCardView.this.hfN.b(a, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgh() {
        if (this.hfN != null) {
            this.hfN.b(3, null);
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null && apkDownloadView != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        h.f(advertAppInfo);
                        apkDownloadView.r(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aK(this.cfl.getPageActivity(), advertAppInfo.bXo);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aDI().au(this.cfl.getPageActivity(), advertAppInfo.bXo);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bXo);
        downloadData.setUrl(advertAppInfo.bXn);
        downloadData.setName(advertAppInfo.bXl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.toInt(advertAppInfo.bXk, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cfl.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iKT != null) {
                            CriusAdCardView.this.iKT.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cfl).akO();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.agR() != 0) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cfl.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cfl.getPageActivity()) && this.hfO != null) {
                this.hfO.b(advertAppInfo, i);
                if (this.iKT != null) {
                    this.iKT.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cgi() {
        boolean z = true;
        if (this.gXW != null && this.iKQ != null) {
            this.gXW.removeAllViews();
            com.baidu.b.a.d.a aVar = this.iKQ;
            Activity pageActivity = this.cfl.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.iKR = aVar.a(pageActivity, aVar2, z);
            this.gXW.addView(this.iKR);
            am.setBackgroundResource(this.iKR, R.drawable.addresslist_item_bg);
            cgg();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bIn() {
        if (this.iKQ != null && ((TextView) this.iKQ.bQ("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cfl.getPageActivity()));
            cgi();
        }
    }
}
