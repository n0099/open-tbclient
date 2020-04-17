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
    private d ezA;
    private DownloadCacheKey ezz;
    private LinearLayout iCm;
    private HeadImageView jMQ;
    protected String ktB;
    private CriusAdCard kuA;
    private boolean kuB;
    private com.baidu.tieba.ad.browser.newstyle.view.a kuC;
    protected CustomMessageListener kuD;
    private com.baidu.b.a.d.a kuu;
    private ViewGroup kuv;
    private ApkDownloadView kuw;
    private AdCloseView kux;
    private JumpButton kuy;
    private AdThreadCommentAndPraiseInfoLayout kuz;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kuB = true;
        this.ezA = null;
        this.kuD = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.ktB) && CriusAdCardView.this.ktB.equals(downloadData.getId()) && CriusAdCardView.this.kuw != null) {
                    CriusAdCardView.this.kuw.t(downloadData);
                }
            }
        };
        this.kuu = new com.baidu.b.a.d.a();
        this.kuu.a(new a.InterfaceC0067a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0067a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.kuA == null || CriusAdCardView.this.kuA.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuA.getAdvertAppInfo().dmo;
                int b = (CriusAdCardView.this.kuA.directDownload || !CriusAdCardView.this.kuA.getAdvertAppInfo().aIG()) ? r.b(CriusAdCardView.this.duG, str, str4) : r.c(CriusAdCardView.this.duG, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.iKk != null) {
                        CriusAdCardView.this.iKk.d(b, null);
                    }
                } else if (CriusAdCardView.this.iKk != null) {
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
                    CriusAdCardView.this.iKk.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cna() {
        this.iCm = new LinearLayout(this.duG.getPageActivity());
        this.iCm.setOrientation(1);
        return this.iCm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.kuv, R.drawable.addresslist_item_bg);
        this.kuu.f(this.duG.getPageActivity(), i == 1 || i == 4);
        if (this.kuw != null) {
            this.kuw.onChangeSkinType(i);
        }
        if (this.kux != null) {
            this.kux.onChangeSkinType();
        }
        if (this.kuz != null) {
            this.kuz.onChangeSkinType();
        }
        am.setBackgroundResource(this.kuy, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.kuy, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.kuA = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cNK();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bgo();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgp();
    }

    private void bgo() {
        if (this.ezz != null && this.ezA != null) {
            com.baidu.tieba.ad.download.d.bgu().a(this.ezz, this.ezA);
        }
    }

    private void bgp() {
        if (this.ezz != null && this.ezA != null) {
            com.baidu.tieba.ad.download.d.bgu().b(this.ezz, this.ezA);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.jMQ != null) {
            this.jMQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aRJ() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.duG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aIG()) {
            if (!this.kuA.directDownload) {
                a(this.kuA, advertAppInfo);
                this.kuw.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bq(View view) {
                        CriusAdCardView.this.cNJ();
                    }
                });
            } else {
                this.kuw.setOnClickListener(aVar);
            }
            this.kuD.setTag(this.duG.getUniqueId());
            MessageManager.getInstance().registerListener(this.kuD);
            this.ktB = advertAppInfo.dmr;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.kuw.setData(c);
            this.kuw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.kuA.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.kuw.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.kux != null && advertAppInfo != null && advertAppInfo.dmx != null && advertAppInfo.dmx.adCloseInfo != null && advertAppInfo.dmx.adCloseInfo.support_close.intValue() > 0) {
            this.kux.setPage(getBusinessType());
            this.kux.setData(advertAppInfo);
            this.kux.onChangeSkinType();
            if (this.kux instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.kux).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.duG.getPageActivity(), this.kux, 40, 40, 40, 120);
        }
    }

    private void cNH() {
        if (this.kuy != null) {
            this.kuy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a dv;
                    if (CriusAdCardView.this.criusData != null && (dv = CriusAdCardView.this.criusData.dv("viewbtn")) != null) {
                        if (!t.KE(dv.alI) && CriusAdCardView.this.iKk != null) {
                            CriusAdCardView.this.iKk.b(dv.alJ, dv.alK, null);
                        }
                        if (TextUtils.isEmpty(dv.alL)) {
                            int b = r.b(CriusAdCardView.this.duG, dv.alI, (CriusAdCardView.this.kuA == null || CriusAdCardView.this.kuA.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuA.getAdvertAppInfo().dmo);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.iKk != null) {
                                CriusAdCardView.this.iKk.d(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.duG.getPageActivity());
                        aVar.uf(dv.alL);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = r.b(CriusAdCardView.this.duG, dv.alI, (CriusAdCardView.this.kuA == null || CriusAdCardView.this.kuA.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuA.getAdvertAppInfo().dmo);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.iKk != null) {
                                    CriusAdCardView.this.iKk.d(b2, null);
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
                        aVar.b(CriusAdCardView.this.duG).aMU();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.kuz != null) {
            final com.baidu.b.a.c.a dv = this.criusData.dv("bottombar");
            if (dv != null) {
                a(this.kuA.getAdvertAppInfo(), dv);
                this.kuz.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.kuz.setBarNameClickEnabled(false);
                this.kuz.setReplyTimeVisible(false);
                if (dv.alM != Integer.MIN_VALUE) {
                    this.kuz.setShareClickable(true);
                    this.kuz.setShareContainerBgGray(false);
                } else {
                    this.kuz.setShareClickable(false);
                    this.kuz.setShareContainerBgGray(true);
                }
                this.kuz.getCommentContainer().setOnClickListener(aVar);
                this.kuz.setNeedAddReplyIcon(true);
                this.kuz.setCommentNumEnable(true);
                this.kuz.setCommentClickable(true);
                this.kuz.setReplayContainerBgGray(true);
                this.kuz.setOnClickListener(aVar);
                this.kuz.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return dv.alP;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return dv.alQ;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.kuA.getAdvertAppInfo();
                    }
                });
                if (dv.alO != Integer.MIN_VALUE) {
                    this.kuz.setAgreeClickable(true);
                    this.kuz.setPraiseContainerBgGray(false);
                } else {
                    this.kuz.setAgreeClickable(false);
                    this.kuz.setPraiseContainerBgGray(true);
                }
                this.kuz.onChangeSkinType();
            }
            if (this.kuz != null) {
                if (this.kux == null) {
                    this.kux = new AdCloseView(this.duG.getPageActivity());
                }
                if (this.kux.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kux.getParent()).removeView(this.kux);
                }
                this.kuz.addAdMoreView(this.kux);
                l(this.kuA.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.b.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.kuB || (bjVar.aLZ() <= 0 && bjVar.aMd() <= 0)) {
                if (this.kuB) {
                    this.kuB = false;
                }
                bjVar.jQ(aVar.alN);
                bjVar.jY(aVar.alO);
                bjVar.cd(aVar.alM);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.kuA != null) {
            distributeVideoView.setPageContext(this.duG);
            distributeVideoView.setVideoTailFrameData(this.kuA.tailFrame);
            distributeVideoView.setChargeInfo(this.kuA.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cNI() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.kuA.getAdvertAppInfo();
        a aVar = new a(this.kuA);
        setCriusViewClick(aVar);
        View dy = this.kuu.dy("head");
        if (dy != null && (dy instanceof HeadImageView)) {
            this.jMQ = (HeadImageView) dy;
            setHeadLongClick(advertAppInfo);
        }
        View dy2 = this.kuu.dy("download");
        if (dy2 != null && (dy2 instanceof ApkDownloadView)) {
            this.kuw = (ApkDownloadView) dy2;
            this.kuw.u(this.duG.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View dy3 = this.kuu.dy("closead");
        if (dy3 != null && (dy3 instanceof AdCloseView)) {
            this.kux = (AdCloseView) dy3;
            l(advertAppInfo);
        }
        View dy4 = this.kuu.dy("viewbtn");
        if (dy4 != null && (dy4 instanceof JumpButton)) {
            this.kuy = (JumpButton) dy4;
            cNH();
        }
        View dy5 = this.kuu.dy("bottombar");
        if (dy5 != null && (dy5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dy5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.kuz = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dz = this.kuu.dz("video");
        if (dz != null && (distributeVideoView = (DistributeVideoView) dz.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.kuA.directDownload) {
            this.kuv.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.alI)) {
            this.kuv.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dz = this.kuu.dz("video");
        if (dz == null || (distributeVideoView = (DistributeVideoView) dz.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dz = this.kuu.dz("video");
        if (dz != null && (distributeVideoView = (DistributeVideoView) dz.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey yp;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dmo;
            if (!TextUtils.isEmpty(str)) {
                yp = com.baidu.tieba.ad.download.d.bgu().yo(str);
            } else {
                yp = com.baidu.tieba.ad.download.d.bgu().yp(scheme);
            }
            if (yp == null) {
                yp = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dmr);
                com.baidu.tieba.ad.download.d.bgu().a(yp, null);
            }
            i(yp);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.ezz = downloadCacheKey;
        bgp();
        this.ezA = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bgu().d(downloadCacheKey);
        if (d != null) {
            this.kuw.a(d.getCurrentState());
        } else {
            this.kuw.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.kuA != null || this.kuA.getAdvertAppInfo() != null) {
            str = this.kuA.getAdvertAppInfo().page;
        }
        this.kuC = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kuw, d, str);
        this.ezA = new com.baidu.tieba.ad.download.a.b(this.kuC);
        if (d.extra().getPercent() > 0) {
            this.kuC.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bgo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard kuH;

        public a(CriusAdCard criusAdCard) {
            this.kuH = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.duG.showToast(R.string.neterror);
            } else if (this.kuH != null) {
                AdvertAppInfo advertAppInfo = this.kuH.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aIG()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !com.baidu.adp.lib.util.j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.kuw) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.kuw, z);
                    CriusAdCardView.this.cNJ();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.alI;
                }
                if (k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dmq;
                }
                int b = r.b(CriusAdCardView.this.duG, str, (CriusAdCardView.this.kuA == null || CriusAdCardView.this.kuA.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.kuA.getAdvertAppInfo().dmo);
                if (CriusAdCardView.this.iKk != null) {
                    CriusAdCardView.this.iKk.d(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNJ() {
        if (this.iKk != null) {
            this.iKk.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aY(this.duG.getPageActivity(), advertAppInfo.dmr);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bgu().aH(this.duG.getPageActivity(), advertAppInfo.dmr);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmr);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmp);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dmo, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
                aVar.uf(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.kuw != null) {
                            CriusAdCardView.this.kuw.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.duG).aMU();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aIF() != 0) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.duG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.duG.getPageActivity()) && this.iKl != null) {
                this.iKl.b(advertAppInfo, i);
                if (this.kuw != null) {
                    this.kuw.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cNK() {
        boolean z = true;
        if (this.iCm != null && this.kuu != null) {
            this.iCm.removeAllViews();
            com.baidu.b.a.d.a aVar = this.kuu;
            Activity pageActivity = this.duG.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.kuv = aVar.a(pageActivity, aVar2, z);
            this.iCm.addView(this.kuv);
            am.setBackgroundResource(this.kuv, R.drawable.addresslist_item_bg);
            cNI();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cng() {
        if (this.kuu != null && ((TextView) this.kuu.dz("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.duG.getPageActivity()));
            cNK();
        }
    }
}
