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
    private DownloadCacheKey dgW;
    private d dgX;
    private LinearLayout gXf;
    private com.baidu.b.a.d.a iJZ;
    protected String iJj;
    private ViewGroup iKa;
    private HeadImageView iKb;
    private ApkDownloadView iKc;
    private AdCloseView iKd;
    private JumpButton iKe;
    private AdThreadCommentAndPraiseInfoLayout iKf;
    private CriusAdCard iKg;
    private boolean iKh;
    private com.baidu.tieba.ad.browser.newstyle.view.a iKi;
    protected CustomMessageListener iKj;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iKh = true;
        this.dgX = null;
        this.iKj = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iJj) && CriusAdCardView.this.iJj.equals(downloadData.getId()) && CriusAdCardView.this.iKc != null) {
                    CriusAdCardView.this.iKc.t(downloadData);
                }
            }
        };
        this.iJZ = new com.baidu.b.a.d.a();
        this.iJZ.a(new a.InterfaceC0041a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0041a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.iKg == null || CriusAdCardView.this.iKg.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKg.getAdvertAppInfo().bWt;
                int a2 = (CriusAdCardView.this.iKg.directDownload || !CriusAdCardView.this.iKg.getAdvertAppInfo().agQ()) ? s.a(CriusAdCardView.this.ceu, str, str4) : s.b(CriusAdCardView.this.ceu, str, str4);
                if (a2 == 1 || a2 == 2) {
                    if (CriusAdCardView.this.heW != null) {
                        CriusAdCardView.this.heW.b(a2, null);
                    }
                } else if (CriusAdCardView.this.heW != null) {
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
                    CriusAdCardView.this.heW.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIe() {
        this.gXf = new LinearLayout(this.ceu.getPageActivity());
        this.gXf.setOrientation(1);
        return this.gXf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.iKa, R.drawable.addresslist_item_bg);
        this.iJZ.f(this.ceu.getPageActivity(), i == 1 || i == 4);
        if (this.iKc != null) {
            this.iKc.onChangeSkinType(i);
        }
        if (this.iKd != null) {
            this.iKd.onChangeSkinType();
        }
        if (this.iKf != null) {
            this.iKf.onChangeSkinType();
        }
        am.setBackgroundResource(this.iKe, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.iKe, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iKg = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cgg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDA();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDB();
    }

    private void aDA() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().a(this.dgW, this.dgX);
        }
    }

    private void aDB() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().b(this.dgW, this.dgX);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iKb != null) {
            this.iKb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aoW() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.ceu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.agQ()) {
            if (!this.iKg.directDownload) {
                a(this.iKg, advertAppInfo);
                this.iKc.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bo(View view) {
                        CriusAdCardView.this.cgf();
                    }
                });
            } else {
                this.iKc.setOnClickListener(aVar);
            }
            this.iKj.setTag(this.ceu.getUniqueId());
            MessageManager.getInstance().registerListener(this.iKj);
            this.iJj = advertAppInfo.bWx;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.iKc.setData(c);
            this.iKc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.iKg.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.iKc.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.iKd != null && advertAppInfo != null && advertAppInfo.bWD != null && advertAppInfo.bWD.adCloseInfo != null && advertAppInfo.bWD.adCloseInfo.support_close.intValue() > 0) {
            this.iKd.setPage(getBusinessType());
            this.iKd.setData(advertAppInfo);
            this.iKd.onChangeSkinType();
            l.addToParentArea(this.ceu.getPageActivity(), this.iKd, 40, 40, 40, 120);
        }
    }

    private void cgd() {
        if (this.iKe != null) {
            this.iKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a bM;
                    if (CriusAdCardView.this.criusData != null && (bM = CriusAdCardView.this.criusData.bM("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.DH(bM.Ld) && CriusAdCardView.this.heW != null) {
                            CriusAdCardView.this.heW.b(bM.Le, bM.Lf, null);
                        }
                        if (TextUtils.isEmpty(bM.Lg)) {
                            int a2 = s.a(CriusAdCardView.this.ceu, bM.Ld, (CriusAdCardView.this.iKg == null || CriusAdCardView.this.iKg.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKg.getAdvertAppInfo().bWt);
                            if ((a2 == 1 || a2 == 2) && CriusAdCardView.this.heW != null) {
                                CriusAdCardView.this.heW.b(a2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.ceu.getPageActivity());
                        aVar.nn(bM.Lg);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int a3 = s.a(CriusAdCardView.this.ceu, bM.Ld, (CriusAdCardView.this.iKg == null || CriusAdCardView.this.iKg.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKg.getAdvertAppInfo().bWt);
                                if ((a3 == 1 || a3 == 2) && CriusAdCardView.this.heW != null) {
                                    CriusAdCardView.this.heW.b(a3, null);
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
                        aVar.b(CriusAdCardView.this.ceu).akM();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bM;
        if (this.iKf != null && (bM = this.criusData.bM("bottombar")) != null) {
            a(this.iKg.getAdvertAppInfo(), bM);
            this.iKf.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iKf.setBarNameClickEnabled(false);
            this.iKf.setReplyTimeVisible(false);
            if (bM.Lh != Integer.MIN_VALUE) {
                this.iKf.setShareClickable(true);
                this.iKf.setShareContainerBgGray(false);
            } else {
                this.iKf.setShareClickable(false);
                this.iKf.setShareContainerBgGray(true);
            }
            this.iKf.getCommentContainer().setOnClickListener(aVar);
            this.iKf.setNeedAddReplyIcon(true);
            this.iKf.setCommentNumEnable(true);
            this.iKf.setCommentClickable(true);
            this.iKf.setReplayContainerBgGray(true);
            this.iKf.setOnClickListener(aVar);
            this.iKf.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                    return bM.Lk;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bM.Ll;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.iKg.getAdvertAppInfo();
                }
            });
            if (bM.Lj != Integer.MIN_VALUE) {
                this.iKf.setAgreeClickable(true);
                this.iKf.setPraiseContainerBgGray(false);
            } else {
                this.iKf.setAgreeClickable(false);
                this.iKf.setPraiseContainerBgGray(true);
            }
            this.iKf.onChangeSkinType();
        }
    }

    public void a(bh bhVar, com.baidu.b.a.c.a aVar) {
        if (bhVar != null && aVar != null) {
            if (this.iKh || (bhVar.ajW() <= 0 && bhVar.aka() <= 0)) {
                if (this.iKh) {
                    this.iKh = false;
                }
                bhVar.hH(aVar.Li);
                bhVar.hP(aVar.Lj);
                bhVar.aM(aVar.Lh);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iKg != null) {
            distributeVideoView.setPageContext(this.ceu);
            distributeVideoView.setVideoTailFrameData(this.iKg.tailFrame);
            distributeVideoView.setChargeInfo(this.iKg.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cge() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iKg.getAdvertAppInfo();
        a aVar = new a(this.iKg);
        setCriusViewClick(aVar);
        View bP = this.iJZ.bP("head");
        if (bP != null && (bP instanceof HeadImageView)) {
            this.iKb = (HeadImageView) bP;
            setHeadLongClick(advertAppInfo);
        }
        View bP2 = this.iJZ.bP("download");
        if (bP2 != null && (bP2 instanceof ApkDownloadView)) {
            this.iKc = (ApkDownloadView) bP2;
            this.iKc.t(this.ceu.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View bP3 = this.iJZ.bP("closead");
        if (bP3 != null && (bP3 instanceof AdCloseView)) {
            this.iKd = (AdCloseView) bP3;
            l(advertAppInfo);
        }
        View bP4 = this.iJZ.bP("viewbtn");
        if (bP4 != null && (bP4 instanceof JumpButton)) {
            this.iKe = (JumpButton) bP4;
            cgd();
        }
        View bP5 = this.iJZ.bP("bottombar");
        if (bP5 != null && (bP5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bP5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iKf = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bQ = this.iJZ.bQ("video");
        if (bQ != null && (distributeVideoView = (DistributeVideoView) bQ.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.iKg.directDownload) {
            this.iKa.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.Ld)) {
            this.iKa.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bQ = this.iJZ.bQ("video");
        if (bQ == null || (distributeVideoView = (DistributeVideoView) bQ.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bQ = this.iJZ.bQ("video");
        if (bQ != null && (distributeVideoView = (DistributeVideoView) bQ.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ru;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.bWt;
            if (!TextUtils.isEmpty(str)) {
                ru = com.baidu.tieba.ad.download.d.aDG().rt(str);
            } else {
                ru = com.baidu.tieba.ad.download.d.aDG().ru(scheme);
            }
            if (ru == null) {
                ru = DownloadCacheKey.create(str, advertAppInfo.bWw, advertAppInfo.bWx);
                com.baidu.tieba.ad.download.d.aDG().a(ru, null);
            }
            i(ru);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dgW = downloadCacheKey;
        aDB();
        this.dgX = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aDG().d(downloadCacheKey);
        if (d != null) {
            this.iKc.a(d.getCurrentState());
        } else {
            this.iKc.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.iKg != null || this.iKg.getAdvertAppInfo() != null) {
            str = this.iKg.getAdvertAppInfo().page;
        }
        this.iKi = new com.baidu.tieba.ad.browser.newstyle.view.a(this.iKc, d, str);
        this.dgX = new com.baidu.tieba.ad.download.a.b(this.iKi);
        if (d.extra().getPercent() > 0) {
            this.iKi.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aDA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iKn;

        public a(CriusAdCard criusAdCard) {
            this.iKn = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.ceu.showToast(R.string.neterror);
            } else if (this.iKn != null) {
                AdvertAppInfo advertAppInfo = this.iKn.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.agQ()) {
                    int i = com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.iKc) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.iKc, z);
                    CriusAdCardView.this.cgf();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Ld;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bWv;
                }
                int a = s.a(CriusAdCardView.this.ceu, str, (CriusAdCardView.this.iKg == null || CriusAdCardView.this.iKg.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iKg.getAdvertAppInfo().bWt);
                if (CriusAdCardView.this.heW != null) {
                    CriusAdCardView.this.heW.b(a, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgf() {
        if (this.heW != null) {
            this.heW.b(3, null);
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
                    h.aK(this.ceu.getPageActivity(), advertAppInfo.bWx);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aDG().au(this.ceu.getPageActivity(), advertAppInfo.bWx);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bWx);
        downloadData.setUrl(advertAppInfo.bWw);
        downloadData.setName(advertAppInfo.bWu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.toInt(advertAppInfo.bWt, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agQ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ceu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iKc != null) {
                            CriusAdCardView.this.iKc.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.ceu).akM();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.agP() != 0) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.ceu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.ceu.getPageActivity()) && this.heX != null) {
                this.heX.b(advertAppInfo, i);
                if (this.iKc != null) {
                    this.iKc.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cgg() {
        boolean z = true;
        if (this.gXf != null && this.iJZ != null) {
            this.gXf.removeAllViews();
            com.baidu.b.a.d.a aVar = this.iJZ;
            Activity pageActivity = this.ceu.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.iKa = aVar.a(pageActivity, aVar2, z);
            this.gXf.addView(this.iKa);
            am.setBackgroundResource(this.iKa, R.drawable.addresslist_item_bg);
            cge();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bIl() {
        if (this.iJZ != null && ((TextView) this.iJZ.bQ("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.ceu.getPageActivity()));
            cgg();
        }
    }
}
