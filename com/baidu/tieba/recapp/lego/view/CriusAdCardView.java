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
import com.baidu.tbadk.core.data.bj;
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
    private DownloadCacheKey ezE;
    private d ezF;
    private LinearLayout iCs;
    private HeadImageView jMU;
    protected String ktF;
    private ApkDownloadView kuA;
    private AdCloseView kuB;
    private JumpButton kuC;
    private AdThreadCommentAndPraiseInfoLayout kuD;
    private CriusAdCard kuE;
    private boolean kuF;
    private com.baidu.tieba.ad.browser.newstyle.view.a kuG;
    protected CustomMessageListener kuH;
    private com.baidu.b.a.d.a kuy;
    private ViewGroup kuz;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kuF = true;
        this.ezF = null;
        this.kuH = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.ktF) && CriusAdCardView.this.ktF.equals(downloadData.getId()) && CriusAdCardView.this.kuA != null) {
                    CriusAdCardView.this.kuA.t(downloadData);
                }
            }
        };
        this.kuy = new com.baidu.b.a.d.a();
        this.kuy.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0088a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.kuE == null || CriusAdCardView.this.kuE.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuE.getAdvertAppInfo().dms;
                int b = (CriusAdCardView.this.kuE.directDownload || !CriusAdCardView.this.kuE.getAdvertAppInfo().aIE()) ? r.b(CriusAdCardView.this.duK, str, str4) : r.c(CriusAdCardView.this.duK, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.iKo != null) {
                        CriusAdCardView.this.iKo.d(b, null);
                    }
                } else if (CriusAdCardView.this.iKo != null) {
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
                    CriusAdCardView.this.iKo.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cmY() {
        this.iCs = new LinearLayout(this.duK.getPageActivity());
        this.iCs.setOrientation(1);
        return this.iCs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.kuz, R.drawable.addresslist_item_bg);
        this.kuy.f(this.duK.getPageActivity(), i == 1 || i == 4);
        if (this.kuA != null) {
            this.kuA.onChangeSkinType(i);
        }
        if (this.kuB != null) {
            this.kuB.onChangeSkinType();
        }
        if (this.kuD != null) {
            this.kuD.onChangeSkinType();
        }
        am.setBackgroundResource(this.kuC, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.kuC, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.kuE = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cNI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bgm();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgn();
    }

    private void bgm() {
        if (this.ezE != null && this.ezF != null) {
            com.baidu.tieba.ad.download.d.bgs().a(this.ezE, this.ezF);
        }
    }

    private void bgn() {
        if (this.ezE != null && this.ezF != null) {
            com.baidu.tieba.ad.download.d.bgs().b(this.ezE, this.ezF);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.jMU != null) {
            this.jMU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aRG() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.duK.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aIE()) {
            if (!this.kuE.directDownload) {
                a(this.kuE, advertAppInfo);
                this.kuA.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bq(View view) {
                        CriusAdCardView.this.cNH();
                    }
                });
            } else {
                this.kuA.setOnClickListener(aVar);
            }
            this.kuH.setTag(this.duK.getUniqueId());
            MessageManager.getInstance().registerListener(this.kuH);
            this.ktF = advertAppInfo.dmv;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.kuA.setData(c);
            this.kuA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.kuE.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.kuA.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.kuB != null && advertAppInfo != null && advertAppInfo.dmB != null && advertAppInfo.dmB.adCloseInfo != null && advertAppInfo.dmB.adCloseInfo.support_close.intValue() > 0) {
            this.kuB.setPage(getBusinessType());
            this.kuB.setData(advertAppInfo);
            this.kuB.onChangeSkinType();
            if (this.kuB instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.kuB).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.duK.getPageActivity(), this.kuB, 40, 40, 40, 120);
        }
    }

    private void cNF() {
        if (this.kuC != null) {
            this.kuC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a dv;
                    if (CriusAdCardView.this.criusData != null && (dv = CriusAdCardView.this.criusData.dv("viewbtn")) != null) {
                        if (!t.KH(dv.alO) && CriusAdCardView.this.iKo != null) {
                            CriusAdCardView.this.iKo.a(dv.alP, dv.alQ, null);
                        }
                        if (TextUtils.isEmpty(dv.alR)) {
                            int b = r.b(CriusAdCardView.this.duK, dv.alO, (CriusAdCardView.this.kuE == null || CriusAdCardView.this.kuE.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuE.getAdvertAppInfo().dms);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.iKo != null) {
                                CriusAdCardView.this.iKo.d(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.duK.getPageActivity());
                        aVar.ui(dv.alR);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = r.b(CriusAdCardView.this.duK, dv.alO, (CriusAdCardView.this.kuE == null || CriusAdCardView.this.kuE.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuE.getAdvertAppInfo().dms);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.iKo != null) {
                                    CriusAdCardView.this.iKo.d(b2, null);
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
                        aVar.b(CriusAdCardView.this.duK).aMS();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.kuD != null) {
            final com.baidu.b.a.c.a dv = this.criusData.dv("bottombar");
            if (dv != null) {
                a(this.kuE.getAdvertAppInfo(), dv);
                this.kuD.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.kuD.setBarNameClickEnabled(false);
                this.kuD.setReplyTimeVisible(false);
                if (dv.alS != Integer.MIN_VALUE) {
                    this.kuD.setShareClickable(true);
                    this.kuD.setShareContainerBgGray(false);
                } else {
                    this.kuD.setShareClickable(false);
                    this.kuD.setShareContainerBgGray(true);
                }
                this.kuD.getCommentContainer().setOnClickListener(aVar);
                this.kuD.setNeedAddReplyIcon(true);
                this.kuD.setCommentNumEnable(true);
                this.kuD.setCommentClickable(true);
                this.kuD.setReplayContainerBgGray(true);
                this.kuD.setOnClickListener(aVar);
                this.kuD.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return dv.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return dv.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return dv.alV;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return dv.alW;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.kuE.getAdvertAppInfo();
                    }
                });
                if (dv.alU != Integer.MIN_VALUE) {
                    this.kuD.setAgreeClickable(true);
                    this.kuD.setPraiseContainerBgGray(false);
                } else {
                    this.kuD.setAgreeClickable(false);
                    this.kuD.setPraiseContainerBgGray(true);
                }
                this.kuD.onChangeSkinType();
            }
            if (this.kuD != null) {
                if (this.kuB == null) {
                    this.kuB = new AdCloseView(this.duK.getPageActivity());
                }
                if (this.kuB.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kuB.getParent()).removeView(this.kuB);
                }
                this.kuD.addAdMoreView(this.kuB);
                l(this.kuE.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.b.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.kuF || (bjVar.aLX() <= 0 && bjVar.aMb() <= 0)) {
                if (this.kuF) {
                    this.kuF = false;
                }
                bjVar.jQ(aVar.alT);
                bjVar.jY(aVar.alU);
                bjVar.cd(aVar.alS);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.kuE != null) {
            distributeVideoView.setPageContext(this.duK);
            distributeVideoView.setVideoTailFrameData(this.kuE.tailFrame);
            distributeVideoView.setChargeInfo(this.kuE.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cNG() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.kuE.getAdvertAppInfo();
        a aVar = new a(this.kuE);
        setCriusViewClick(aVar);
        View dy = this.kuy.dy("head");
        if (dy != null && (dy instanceof HeadImageView)) {
            this.jMU = (HeadImageView) dy;
            setHeadLongClick(advertAppInfo);
        }
        View dy2 = this.kuy.dy("download");
        if (dy2 != null && (dy2 instanceof ApkDownloadView)) {
            this.kuA = (ApkDownloadView) dy2;
            this.kuA.u(this.duK.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View dy3 = this.kuy.dy("closead");
        if (dy3 != null && (dy3 instanceof AdCloseView)) {
            this.kuB = (AdCloseView) dy3;
            l(advertAppInfo);
        }
        View dy4 = this.kuy.dy("viewbtn");
        if (dy4 != null && (dy4 instanceof JumpButton)) {
            this.kuC = (JumpButton) dy4;
            cNF();
        }
        View dy5 = this.kuy.dy("bottombar");
        if (dy5 != null && (dy5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dy5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.kuD = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dz = this.kuy.dz("video");
        if (dz != null && (distributeVideoView = (DistributeVideoView) dz.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.kuE.directDownload) {
            this.kuz.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.alO)) {
            this.kuz.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dz = this.kuy.dz("video");
        if (dz == null || (distributeVideoView = (DistributeVideoView) dz.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dz = this.kuy.dz("video");
        if (dz != null && (distributeVideoView = (DistributeVideoView) dz.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ys;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dms;
            if (!TextUtils.isEmpty(str)) {
                ys = com.baidu.tieba.ad.download.d.bgs().yr(str);
            } else {
                ys = com.baidu.tieba.ad.download.d.bgs().ys(scheme);
            }
            if (ys == null) {
                ys = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dmv);
                com.baidu.tieba.ad.download.d.bgs().a(ys, null);
            }
            i(ys);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.ezE = downloadCacheKey;
        bgn();
        this.ezF = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bgs().d(downloadCacheKey);
        if (d != null) {
            this.kuA.a(d.getCurrentState());
        } else {
            this.kuA.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.kuE != null || this.kuE.getAdvertAppInfo() != null) {
            str = this.kuE.getAdvertAppInfo().page;
        }
        this.kuG = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kuA, d, str);
        this.ezF = new com.baidu.tieba.ad.download.a.b(this.kuG);
        if (d.extra().getPercent() > 0) {
            this.kuG.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bgm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard kuL;

        public a(CriusAdCard criusAdCard) {
            this.kuL = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.duK.showToast(R.string.neterror);
            } else if (this.kuL != null) {
                AdvertAppInfo advertAppInfo = this.kuL.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aIE()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !com.baidu.adp.lib.util.j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.kuA) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.kuA, z);
                    CriusAdCardView.this.cNH();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.alO;
                }
                if (k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dmu;
                }
                int b = r.b(CriusAdCardView.this.duK, str, (CriusAdCardView.this.kuE == null || CriusAdCardView.this.kuE.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuE.getAdvertAppInfo().dms);
                if (CriusAdCardView.this.iKo != null) {
                    CriusAdCardView.this.iKo.d(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNH() {
        if (this.iKo != null) {
            this.iKo.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aM(this.duK.getPageActivity(), advertAppInfo.dmv);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bgs().av(this.duK.getPageActivity(), advertAppInfo.dmv);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmv);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dms, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duK.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
                aVar.ui(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.kuA != null) {
                            CriusAdCardView.this.kuA.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.duK).aMS();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aID() != 0) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.duK.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.duK.getPageActivity()) && this.iKp != null) {
                this.iKp.b(advertAppInfo, i);
                if (this.kuA != null) {
                    this.kuA.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cNI() {
        boolean z = true;
        if (this.iCs != null && this.kuy != null) {
            this.iCs.removeAllViews();
            com.baidu.b.a.d.a aVar = this.kuy;
            Activity pageActivity = this.duK.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.kuz = aVar.a(pageActivity, aVar2, z);
            this.iCs.addView(this.kuz);
            am.setBackgroundResource(this.kuz, R.drawable.addresslist_item_bg);
            cNG();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cne() {
        if (this.kuy != null && ((TextView) this.kuy.dz("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.duK.getPageActivity()));
            cNI();
        }
    }
}
