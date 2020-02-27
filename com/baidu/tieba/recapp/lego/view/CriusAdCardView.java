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
import com.baidu.searchbox.picture.params.LaunchParams;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.recapp.view.AdCriusCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private DownloadCacheKey dYY;
    private d dYZ;
    private LinearLayout hQH;
    private com.baidu.c.a.d.a jIU;
    private ViewGroup jIV;
    private ApkDownloadView jIW;
    private AdCloseView jIX;
    private JumpButton jIY;
    private AdThreadCommentAndPraiseInfoLayout jIZ;
    protected String jIc;
    private CriusAdCard jJa;
    private boolean jJb;
    private com.baidu.tieba.ad.browser.newstyle.view.a jJc;
    protected CustomMessageListener jJd;
    private HeadImageView jaV;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jJb = true;
        this.dYZ = null;
        this.jJd = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.jIc) && CriusAdCardView.this.jIc.equals(downloadData.getId()) && CriusAdCardView.this.jIW != null) {
                    CriusAdCardView.this.jIW.t(downloadData);
                }
            }
        };
        this.jIU = new com.baidu.c.a.d.a();
        this.jIU.a(new a.InterfaceC0051a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0051a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.jJa == null || CriusAdCardView.this.jJa.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJa.getAdvertAppInfo().cMV;
                int b = (CriusAdCardView.this.jJa.directDownload || !CriusAdCardView.this.jJa.getAdvertAppInfo().aAo()) ? s.b(CriusAdCardView.this.cVg, str, str4) : s.c(CriusAdCardView.this.cVg, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.hYC != null) {
                        CriusAdCardView.this.hYC.b(b, null);
                    }
                } else if (CriusAdCardView.this.hYC != null) {
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
                    CriusAdCardView.this.hYC.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccd() {
        this.hQH = new LinearLayout(this.cVg.getPageActivity());
        this.hQH.setOrientation(1);
        return this.hQH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.jIV, R.drawable.addresslist_item_bg);
        this.jIU.f(this.cVg.getPageActivity(), i == 1 || i == 4);
        if (this.jIW != null) {
            this.jIW.onChangeSkinType(i);
        }
        if (this.jIX != null) {
            this.jIX.onChangeSkinType();
        }
        if (this.jIZ != null) {
            this.jIZ.onChangeSkinType();
        }
        am.setBackgroundResource(this.jIY, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.jIY, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.jJa = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cCP();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYc();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYd();
    }

    private void aYc() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().a(this.dYY, this.dYZ);
        }
    }

    private void aYd() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().b(this.dYY, this.dYZ);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.jaV != null) {
            this.jaV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aJf() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cVg.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aAo()) {
            if (!this.jJa.directDownload) {
                a(this.jJa, advertAppInfo);
                this.jIW.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                        CriusAdCardView.this.cCO();
                    }
                });
            } else {
                this.jIW.setOnClickListener(aVar);
            }
            this.jJd.setTag(this.cVg.getUniqueId());
            MessageManager.getInstance().registerListener(this.jJd);
            this.jIc = advertAppInfo.cMY;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.jIW.setData(c);
            this.jIW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.jJa.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jIW.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.jIX != null && advertAppInfo != null && advertAppInfo.cNe != null && advertAppInfo.cNe.adCloseInfo != null && advertAppInfo.cNe.adCloseInfo.support_close.intValue() > 0) {
            this.jIX.setPage(getBusinessType());
            this.jIX.setData(advertAppInfo);
            this.jIX.onChangeSkinType();
            if (this.jIX instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.jIX).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.cVg.getPageActivity(), this.jIX, 40, 40, 40, 120);
        }
    }

    private void cCM() {
        if (this.jIY != null) {
            this.jIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cB;
                    if (CriusAdCardView.this.criusData != null && (cB = CriusAdCardView.this.criusData.cB("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.IU(cB.Tl) && CriusAdCardView.this.hYC != null) {
                            CriusAdCardView.this.hYC.b(cB.Tm, cB.Tn, null);
                        }
                        if (TextUtils.isEmpty(cB.To)) {
                            int b = s.b(CriusAdCardView.this.cVg, cB.Tl, (CriusAdCardView.this.jJa == null || CriusAdCardView.this.jJa.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJa.getAdvertAppInfo().cMV);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.hYC != null) {
                                CriusAdCardView.this.hYC.b(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cVg.getPageActivity());
                        aVar.sS(cB.To);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = s.b(CriusAdCardView.this.cVg, cB.Tl, (CriusAdCardView.this.jJa == null || CriusAdCardView.this.jJa.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJa.getAdvertAppInfo().cMV);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.hYC != null) {
                                    CriusAdCardView.this.hYC.b(b2, null);
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
                        aVar.b(CriusAdCardView.this.cVg).aEA();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.jIZ != null) {
            final com.baidu.c.a.c.a cB = this.criusData.cB("bottombar");
            if (cB != null) {
                a(this.jJa.getAdvertAppInfo(), cB);
                this.jIZ.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.jIZ.setBarNameClickEnabled(false);
                this.jIZ.setReplyTimeVisible(false);
                if (cB.Tp != Integer.MIN_VALUE) {
                    this.jIZ.setShareClickable(true);
                    this.jIZ.setShareContainerBgGray(false);
                } else {
                    this.jIZ.setShareClickable(false);
                    this.jIZ.setShareContainerBgGray(true);
                }
                this.jIZ.getCommentContainer().setOnClickListener(aVar);
                this.jIZ.setNeedAddReplyIcon(true);
                this.jIZ.setCommentNumEnable(true);
                this.jIZ.setCommentClickable(true);
                this.jIZ.setReplayContainerBgGray(true);
                this.jIZ.setOnClickListener(aVar);
                this.jIZ.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return cB.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return cB.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return cB.Ts;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return cB.Tt;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.jJa.getAdvertAppInfo();
                    }
                });
                if (cB.Tr != Integer.MIN_VALUE) {
                    this.jIZ.setAgreeClickable(true);
                    this.jIZ.setPraiseContainerBgGray(false);
                } else {
                    this.jIZ.setAgreeClickable(false);
                    this.jIZ.setPraiseContainerBgGray(true);
                }
                this.jIZ.onChangeSkinType();
            }
            if (this.jIZ != null) {
                if (this.jIX == null) {
                    this.jIX = new AdCloseView(this.cVg.getPageActivity());
                }
                if (this.jIX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jIX.getParent()).removeView(this.jIX);
                }
                this.jIZ.addAdMoreView(this.jIX);
                k(this.jJa.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.c.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.jJb || (bjVar.aDF() <= 0 && bjVar.aDJ() <= 0)) {
                if (this.jJb) {
                    this.jJb = false;
                }
                bjVar.jJ(aVar.Tq);
                bjVar.jR(aVar.Tr);
                bjVar.by(aVar.Tp);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.jJa != null) {
            distributeVideoView.setPageContext(this.cVg);
            distributeVideoView.setVideoTailFrameData(this.jJa.tailFrame);
            distributeVideoView.setChargeInfo(this.jJa.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cCN() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.jJa.getAdvertAppInfo();
        a aVar = new a(this.jJa);
        setCriusViewClick(aVar);
        View cE = this.jIU.cE("head");
        if (cE != null && (cE instanceof HeadImageView)) {
            this.jaV = (HeadImageView) cE;
            setHeadLongClick(advertAppInfo);
        }
        View cE2 = this.jIU.cE(LaunchParams.SRC_TYPE_DOWNLOAD);
        if (cE2 != null && (cE2 instanceof ApkDownloadView)) {
            this.jIW = (ApkDownloadView) cE2;
            this.jIW.u(this.cVg.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View cE3 = this.jIU.cE("closead");
        if (cE3 != null && (cE3 instanceof AdCloseView)) {
            this.jIX = (AdCloseView) cE3;
            k(advertAppInfo);
        }
        View cE4 = this.jIU.cE("viewbtn");
        if (cE4 != null && (cE4 instanceof JumpButton)) {
            this.jIY = (JumpButton) cE4;
            cCM();
        }
        View cE5 = this.jIU.cE("bottombar");
        if (cE5 != null && (cE5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cE5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.jIZ = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cF = this.jIU.cF("video");
        if (cF != null && (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.jJa.directDownload) {
            this.jIV.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.Tl)) {
            this.jIV.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cF = this.jIU.cF("video");
        if (cF == null || (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cF = this.jIU.cF("video");
        if (cF != null && (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xb;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.cMV;
            if (!TextUtils.isEmpty(str)) {
                xb = com.baidu.tieba.ad.download.d.aYi().xa(str);
            } else {
                xb = com.baidu.tieba.ad.download.d.aYi().xb(scheme);
            }
            if (xb == null) {
                xb = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cMY);
                com.baidu.tieba.ad.download.d.aYi().a(xb, null);
            }
            i(xb);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dYY = downloadCacheKey;
        aYd();
        this.dYZ = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aYi().d(downloadCacheKey);
        if (d != null) {
            this.jIW.a(d.getCurrentState());
        } else {
            this.jIW.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.jJa != null || this.jJa.getAdvertAppInfo() != null) {
            str = this.jJa.getAdvertAppInfo().page;
        }
        this.jJc = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIW, d, str);
        this.dYZ = new com.baidu.tieba.ad.download.a.b(this.jJc);
        if (d.extra().getPercent() > 0) {
            this.jJc.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aYc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard jJh;

        public a(CriusAdCard criusAdCard) {
            this.jJh = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cVg.showToast(R.string.neterror);
            } else if (this.jJh != null) {
                AdvertAppInfo advertAppInfo = this.jJh.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aAo()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.jIW) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.jIW, z);
                    CriusAdCardView.this.cCO();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Tl;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.cMX;
                }
                int b = s.b(CriusAdCardView.this.cVg, str, (CriusAdCardView.this.jJa == null || CriusAdCardView.this.jJa.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJa.getAdvertAppInfo().cMV);
                if (CriusAdCardView.this.hYC != null) {
                    CriusAdCardView.this.hYC.b(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCO() {
        if (this.hYC != null) {
            this.hYC.b(3, null);
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
                    h.bd(this.cVg.getPageActivity(), advertAppInfo.cMY);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYi().aN(this.cVg.getPageActivity(), advertAppInfo.cMY);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMY);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMW);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMV, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAo()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVg.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.jIW != null) {
                            CriusAdCardView.this.jIW.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVg).aEA();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aAn() != 0) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVg.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVg.getPageActivity()) && this.hYD != null) {
                this.hYD.b(advertAppInfo, i);
                if (this.jIW != null) {
                    this.jIW.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cCP() {
        boolean z = true;
        if (this.hQH != null && this.jIU != null) {
            this.hQH.removeAllViews();
            com.baidu.c.a.d.a aVar = this.jIU;
            Activity pageActivity = this.cVg.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.jIV = aVar.a(pageActivity, aVar2, z);
            this.hQH.addView(this.jIV);
            am.setBackgroundResource(this.jIV, R.drawable.addresslist_item_bg);
            cCN();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccj() {
        if (this.jIU != null && ((TextView) this.jIU.cF("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cVg.getPageActivity()));
            cCP();
        }
    }
}
