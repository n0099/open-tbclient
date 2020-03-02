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
    private DownloadCacheKey dYZ;
    private d dZa;
    private LinearLayout hQJ;
    private com.baidu.c.a.d.a jIW;
    private ViewGroup jIX;
    private ApkDownloadView jIY;
    private AdCloseView jIZ;
    protected String jIe;
    private JumpButton jJa;
    private AdThreadCommentAndPraiseInfoLayout jJb;
    private CriusAdCard jJc;
    private boolean jJd;
    private com.baidu.tieba.ad.browser.newstyle.view.a jJe;
    protected CustomMessageListener jJf;
    private HeadImageView jaX;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jJd = true;
        this.dZa = null;
        this.jJf = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.jIe) && CriusAdCardView.this.jIe.equals(downloadData.getId()) && CriusAdCardView.this.jIY != null) {
                    CriusAdCardView.this.jIY.t(downloadData);
                }
            }
        };
        this.jIW = new com.baidu.c.a.d.a();
        this.jIW.a(new a.InterfaceC0051a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0051a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.jJc == null || CriusAdCardView.this.jJc.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJc.getAdvertAppInfo().cMW;
                int b = (CriusAdCardView.this.jJc.directDownload || !CriusAdCardView.this.jJc.getAdvertAppInfo().aAq()) ? s.b(CriusAdCardView.this.cVh, str, str4) : s.c(CriusAdCardView.this.cVh, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.hYE != null) {
                        CriusAdCardView.this.hYE.b(b, null);
                    }
                } else if (CriusAdCardView.this.hYE != null) {
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
                    CriusAdCardView.this.hYE.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccf() {
        this.hQJ = new LinearLayout(this.cVh.getPageActivity());
        this.hQJ.setOrientation(1);
        return this.hQJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.jIX, R.drawable.addresslist_item_bg);
        this.jIW.f(this.cVh.getPageActivity(), i == 1 || i == 4);
        if (this.jIY != null) {
            this.jIY.onChangeSkinType(i);
        }
        if (this.jIZ != null) {
            this.jIZ.onChangeSkinType();
        }
        if (this.jJb != null) {
            this.jJb.onChangeSkinType();
        }
        am.setBackgroundResource(this.jJa, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.jJa, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.jJc = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cCR();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYe();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYf();
    }

    private void aYe() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().a(this.dYZ, this.dZa);
        }
    }

    private void aYf() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().b(this.dYZ, this.dZa);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.jaX != null) {
            this.jaX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aJh() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cVh.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aAq()) {
            if (!this.jJc.directDownload) {
                a(this.jJc, advertAppInfo);
                this.jIY.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                        CriusAdCardView.this.cCQ();
                    }
                });
            } else {
                this.jIY.setOnClickListener(aVar);
            }
            this.jJf.setTag(this.cVh.getUniqueId());
            MessageManager.getInstance().registerListener(this.jJf);
            this.jIe = advertAppInfo.cMZ;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.jIY.setData(c);
            this.jIY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.jJc.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jIY.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.jIZ != null && advertAppInfo != null && advertAppInfo.cNf != null && advertAppInfo.cNf.adCloseInfo != null && advertAppInfo.cNf.adCloseInfo.support_close.intValue() > 0) {
            this.jIZ.setPage(getBusinessType());
            this.jIZ.setData(advertAppInfo);
            this.jIZ.onChangeSkinType();
            if (this.jIZ instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.jIZ).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.cVh.getPageActivity(), this.jIZ, 40, 40, 40, 120);
        }
    }

    private void cCO() {
        if (this.jJa != null) {
            this.jJa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cB;
                    if (CriusAdCardView.this.criusData != null && (cB = CriusAdCardView.this.criusData.cB("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.IU(cB.Tl) && CriusAdCardView.this.hYE != null) {
                            CriusAdCardView.this.hYE.b(cB.Tm, cB.Tn, null);
                        }
                        if (TextUtils.isEmpty(cB.To)) {
                            int b = s.b(CriusAdCardView.this.cVh, cB.Tl, (CriusAdCardView.this.jJc == null || CriusAdCardView.this.jJc.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJc.getAdvertAppInfo().cMW);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.hYE != null) {
                                CriusAdCardView.this.hYE.b(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cVh.getPageActivity());
                        aVar.sS(cB.To);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = s.b(CriusAdCardView.this.cVh, cB.Tl, (CriusAdCardView.this.jJc == null || CriusAdCardView.this.jJc.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJc.getAdvertAppInfo().cMW);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.hYE != null) {
                                    CriusAdCardView.this.hYE.b(b2, null);
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
                        aVar.b(CriusAdCardView.this.cVh).aEC();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.jJb != null) {
            final com.baidu.c.a.c.a cB = this.criusData.cB("bottombar");
            if (cB != null) {
                a(this.jJc.getAdvertAppInfo(), cB);
                this.jJb.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.jJb.setBarNameClickEnabled(false);
                this.jJb.setReplyTimeVisible(false);
                if (cB.Tp != Integer.MIN_VALUE) {
                    this.jJb.setShareClickable(true);
                    this.jJb.setShareContainerBgGray(false);
                } else {
                    this.jJb.setShareClickable(false);
                    this.jJb.setShareContainerBgGray(true);
                }
                this.jJb.getCommentContainer().setOnClickListener(aVar);
                this.jJb.setNeedAddReplyIcon(true);
                this.jJb.setCommentNumEnable(true);
                this.jJb.setCommentClickable(true);
                this.jJb.setReplayContainerBgGray(true);
                this.jJb.setOnClickListener(aVar);
                this.jJb.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return CriusAdCardView.this.jJc.getAdvertAppInfo();
                    }
                });
                if (cB.Tr != Integer.MIN_VALUE) {
                    this.jJb.setAgreeClickable(true);
                    this.jJb.setPraiseContainerBgGray(false);
                } else {
                    this.jJb.setAgreeClickable(false);
                    this.jJb.setPraiseContainerBgGray(true);
                }
                this.jJb.onChangeSkinType();
            }
            if (this.jJb != null) {
                if (this.jIZ == null) {
                    this.jIZ = new AdCloseView(this.cVh.getPageActivity());
                }
                if (this.jIZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jIZ.getParent()).removeView(this.jIZ);
                }
                this.jJb.addAdMoreView(this.jIZ);
                k(this.jJc.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.c.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.jJd || (bjVar.aDH() <= 0 && bjVar.aDL() <= 0)) {
                if (this.jJd) {
                    this.jJd = false;
                }
                bjVar.jJ(aVar.Tq);
                bjVar.jR(aVar.Tr);
                bjVar.by(aVar.Tp);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.jJc != null) {
            distributeVideoView.setPageContext(this.cVh);
            distributeVideoView.setVideoTailFrameData(this.jJc.tailFrame);
            distributeVideoView.setChargeInfo(this.jJc.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cCP() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.jJc.getAdvertAppInfo();
        a aVar = new a(this.jJc);
        setCriusViewClick(aVar);
        View cE = this.jIW.cE("head");
        if (cE != null && (cE instanceof HeadImageView)) {
            this.jaX = (HeadImageView) cE;
            setHeadLongClick(advertAppInfo);
        }
        View cE2 = this.jIW.cE(LaunchParams.SRC_TYPE_DOWNLOAD);
        if (cE2 != null && (cE2 instanceof ApkDownloadView)) {
            this.jIY = (ApkDownloadView) cE2;
            this.jIY.u(this.cVh.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View cE3 = this.jIW.cE("closead");
        if (cE3 != null && (cE3 instanceof AdCloseView)) {
            this.jIZ = (AdCloseView) cE3;
            k(advertAppInfo);
        }
        View cE4 = this.jIW.cE("viewbtn");
        if (cE4 != null && (cE4 instanceof JumpButton)) {
            this.jJa = (JumpButton) cE4;
            cCO();
        }
        View cE5 = this.jIW.cE("bottombar");
        if (cE5 != null && (cE5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cE5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.jJb = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cF = this.jIW.cF("video");
        if (cF != null && (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.jJc.directDownload) {
            this.jIX.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.Tl)) {
            this.jIX.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cF = this.jIW.cF("video");
        if (cF == null || (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cF = this.jIW.cF("video");
        if (cF != null && (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xb;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.cMW;
            if (!TextUtils.isEmpty(str)) {
                xb = com.baidu.tieba.ad.download.d.aYk().xa(str);
            } else {
                xb = com.baidu.tieba.ad.download.d.aYk().xb(scheme);
            }
            if (xb == null) {
                xb = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cMZ);
                com.baidu.tieba.ad.download.d.aYk().a(xb, null);
            }
            i(xb);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dYZ = downloadCacheKey;
        aYf();
        this.dZa = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aYk().d(downloadCacheKey);
        if (d != null) {
            this.jIY.a(d.getCurrentState());
        } else {
            this.jIY.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.jJc != null || this.jJc.getAdvertAppInfo() != null) {
            str = this.jJc.getAdvertAppInfo().page;
        }
        this.jJe = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIY, d, str);
        this.dZa = new com.baidu.tieba.ad.download.a.b(this.jJe);
        if (d.extra().getPercent() > 0) {
            this.jJe.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aYe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard jJj;

        public a(CriusAdCard criusAdCard) {
            this.jJj = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cVh.showToast(R.string.neterror);
            } else if (this.jJj != null) {
                AdvertAppInfo advertAppInfo = this.jJj.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aAq()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.jIY) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.jIY, z);
                    CriusAdCardView.this.cCQ();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Tl;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.cMY;
                }
                int b = s.b(CriusAdCardView.this.cVh, str, (CriusAdCardView.this.jJc == null || CriusAdCardView.this.jJc.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJc.getAdvertAppInfo().cMW);
                if (CriusAdCardView.this.hYE != null) {
                    CriusAdCardView.this.hYE.b(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCQ() {
        if (this.hYE != null) {
            this.hYE.b(3, null);
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
                    h.bd(this.cVh.getPageActivity(), advertAppInfo.cMZ);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYk().aN(this.cVh.getPageActivity(), advertAppInfo.cMZ);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMW, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVh.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.jIY != null) {
                            CriusAdCardView.this.jIY.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVh).aEC();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aAp() != 0) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVh.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVh.getPageActivity()) && this.hYF != null) {
                this.hYF.b(advertAppInfo, i);
                if (this.jIY != null) {
                    this.jIY.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cCR() {
        boolean z = true;
        if (this.hQJ != null && this.jIW != null) {
            this.hQJ.removeAllViews();
            com.baidu.c.a.d.a aVar = this.jIW;
            Activity pageActivity = this.cVh.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.jIX = aVar.a(pageActivity, aVar2, z);
            this.hQJ.addView(this.jIX);
            am.setBackgroundResource(this.jIX, R.drawable.addresslist_item_bg);
            cCP();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccl() {
        if (this.jIW != null && ((TextView) this.jIW.cF("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cVh.getPageActivity()));
            cCR();
        }
    }
}
