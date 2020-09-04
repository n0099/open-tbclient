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
/* loaded from: classes20.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.g.a.c.a criusData;
    private d foA;
    private DownloadCacheKey foz;
    private LinearLayout jJB;
    private HeadImageView kYD;
    protected String lED;
    private JumpButton lFA;
    private AdThreadCommentAndPraiseInfoLayout lFB;
    private CriusAdCard lFC;
    private boolean lFD;
    private com.baidu.tieba.ad.browser.newstyle.view.a lFE;
    protected CustomMessageListener lFF;
    private com.baidu.g.a.d.a lFw;
    private ViewGroup lFx;
    private ApkDownloadView lFy;
    private AdCloseView lFz;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lFD = true;
        this.foA = null;
        this.lFF = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.lED) && CriusAdCardView.this.lED.equals(downloadData.getId()) && CriusAdCardView.this.lFy != null) {
                    CriusAdCardView.this.lFy.t(downloadData);
                }
            }
        };
        this.lFw = new com.baidu.g.a.d.a(tbPageContext);
        this.lFw.a(new a.InterfaceC0129a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.g.a.d.a.InterfaceC0129a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.lFC == null || CriusAdCardView.this.lFC.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFC.getAdvertAppInfo().dWj;
                int c = (CriusAdCardView.this.lFC == null || CriusAdCardView.this.lFC.directDownload || !CriusAdCardView.this.lFC.getAdvertAppInfo().bcw()) ? s.c(CriusAdCardView.this.efr, str, str4) : s.d(CriusAdCardView.this.efr, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.jPq != null) {
                        CriusAdCardView.this.jPq.d(c, null);
                    }
                } else if (CriusAdCardView.this.jPq != null) {
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
                    CriusAdCardView.this.jPq.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMq() {
        this.jJB = new LinearLayout(this.efr.getPageActivity());
        this.jJB.setOrientation(1);
        return this.jJB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ap.setBackgroundResource(this.lFx, R.drawable.addresslist_item_bg);
        this.lFw.h(this.efr.getPageActivity(), i == 1 || i == 4);
        if (this.lFy != null) {
            this.lFy.onChangeSkinType(i);
        }
        if (this.lFz != null) {
            this.lFz.onChangeSkinType();
        }
        if (this.lFB != null) {
            this.lFB.onChangeSkinType();
        }
        ap.setBackgroundResource(this.lFA, R.drawable.btn_focus_border_bg);
        ap.setViewTextColor(this.lFA, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.lFC = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            dnH();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bAZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bBa();
    }

    private void bAZ() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().a(this.foz, this.foA);
        }
    }

    private void bBa() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().b(this.foz, this.foA);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.kYD != null) {
            this.kYD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.bmw() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.efr.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            if (!this.lFC.directDownload) {
                a(this.lFC, advertAppInfo);
                this.lFy.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bC(View view) {
                        CriusAdCardView.this.dnG();
                        return false;
                    }
                });
            } else {
                this.lFy.setOnClickListener(aVar);
            }
            this.lFF.setTag(this.efr.getUniqueId());
            MessageManager.getInstance().registerListener(this.lFF);
            this.lED = advertAppInfo.dWm;
            DownloadData b = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(b);
            this.lFy.setData(b);
            this.lFy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.lFC.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lFy.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.lFz != null && advertAppInfo != null && advertAppInfo.dWs != null && advertAppInfo.dWs.adCloseInfo != null && advertAppInfo.dWs.adCloseInfo.support_close.intValue() > 0) {
            this.lFz.setPage(getBusinessType());
            this.lFz.setData(advertAppInfo);
            this.lFz.onChangeSkinType();
            if (this.lFz instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.lFz).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.efr.getPageActivity(), this.lFz, 40, 40, 40, 120);
        }
    }

    private void dnE() {
        if (this.lFA != null) {
            this.lFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.g.a.c.a fj;
                    if (CriusAdCardView.this.criusData != null && (fj = CriusAdCardView.this.criusData.fj("viewbtn")) != null) {
                        if (!u.Pl(fj.atE) && CriusAdCardView.this.jPq != null) {
                            CriusAdCardView.this.jPq.a(fj.atF, fj.atG, null);
                        }
                        if (TextUtils.isEmpty(fj.atH)) {
                            int c = s.c(CriusAdCardView.this.efr, fj.atE, (CriusAdCardView.this.lFC == null || CriusAdCardView.this.lFC.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFC.getAdvertAppInfo().dWj);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.jPq != null) {
                                CriusAdCardView.this.jPq.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.efr.getPageActivity());
                        aVar.zA(fj.atH);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.efr, fj.atE, (CriusAdCardView.this.lFC == null || CriusAdCardView.this.lFC.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFC.getAdvertAppInfo().dWj);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.jPq != null) {
                                    CriusAdCardView.this.jPq.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.efr).bhg();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.lFB != null) {
            final com.baidu.g.a.c.a fj = this.criusData.fj("bottombar");
            if (fj != null) {
                a(this.lFC.getAdvertAppInfo(), fj);
                this.lFB.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.lFB.setBarNameClickEnabled(false);
                this.lFB.setReplyTimeVisible(false);
                if (fj.atI != Integer.MIN_VALUE) {
                    this.lFB.setShareClickable(true);
                    this.lFB.setShareContainerBgGray(false);
                } else {
                    this.lFB.setShareClickable(false);
                    this.lFB.setShareContainerBgGray(true);
                }
                this.lFB.getCommentContainer().setOnClickListener(aVar);
                this.lFB.setNeedAddReplyIcon(true);
                this.lFB.setCommentNumEnable(true);
                this.lFB.setCommentClickable(true);
                this.lFB.setReplayContainerBgGray(true);
                this.lFB.setOnClickListener(aVar);
                this.lFB.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return fj.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return fj.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return fj.atL;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return fj.atM;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.lFC.getAdvertAppInfo();
                    }
                });
                if (fj.atK != Integer.MIN_VALUE) {
                    this.lFB.setAgreeClickable(true);
                    this.lFB.setPraiseContainerBgGray(false);
                } else {
                    this.lFB.setAgreeClickable(false);
                    this.lFB.setPraiseContainerBgGray(true);
                }
                this.lFB.onChangeSkinType();
            }
            if (this.lFB != null) {
                if (this.lFz == null) {
                    this.lFz = new AdCloseView(this.efr.getPageActivity());
                }
                if (this.lFz.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lFz.getParent()).removeView(this.lFz);
                }
                this.lFB.addAdMoreView(this.lFz);
                k(this.lFC.getAdvertAppInfo());
            }
        }
    }

    public void a(bw bwVar, com.baidu.g.a.c.a aVar) {
        if (bwVar != null && aVar != null) {
            if (this.lFD || (bwVar.bgc() <= 0 && bwVar.bgg() <= 0)) {
                if (this.lFD) {
                    this.lFD = false;
                }
                bwVar.ng(aVar.atJ);
                bwVar.no(aVar.atK);
                bwVar.cD(aVar.atI);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.lFC != null) {
            distributeVideoView.setPageContext(this.efr);
            distributeVideoView.setVideoTailFrameData(this.lFC.tailFrame);
            distributeVideoView.setChargeInfo(this.lFC.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void dnF() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.lFC.getAdvertAppInfo();
        a aVar = new a(this.lFC);
        setCriusViewClick(aVar);
        View fm = this.lFw.fm("head");
        if (fm != null && (fm instanceof HeadImageView)) {
            this.kYD = (HeadImageView) fm;
            setHeadLongClick(advertAppInfo);
        }
        View fm2 = this.lFw.fm("download");
        if (fm2 != null && (fm2 instanceof ApkDownloadView)) {
            this.lFy = (ApkDownloadView) fm2;
            this.lFy.y(this.efr.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View fm3 = this.lFw.fm("closead");
        if (fm3 != null && (fm3 instanceof AdCloseView)) {
            this.lFz = (AdCloseView) fm3;
            k(advertAppInfo);
        }
        View fm4 = this.lFw.fm("viewbtn");
        if (fm4 != null && (fm4 instanceof JumpButton)) {
            this.lFA = (JumpButton) fm4;
            dnE();
        }
        View fm5 = this.lFw.fm("bottombar");
        if (fm5 != null && (fm5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) fm5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.lFB = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View fn = this.lFw.fn("video");
        if (fn != null && (distributeVideoView = (DistributeVideoView) fn.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.lFC.directDownload) {
            this.lFx.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.atE)) {
            this.lFx.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View fn = this.lFw.fn("video");
        if (fn == null || (distributeVideoView = (DistributeVideoView) fn.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View fn = this.lFw.fn("video");
        if (fn != null && (distributeVideoView = (DistributeVideoView) fn.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Dx;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dWj;
            if (!TextUtils.isEmpty(str)) {
                Dx = com.baidu.tieba.ad.download.d.bBg().Dw(str);
            } else {
                Dx = com.baidu.tieba.ad.download.d.bBg().Dx(scheme);
            }
            if (Dx == null) {
                Dx = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dWm);
                com.baidu.tieba.ad.download.d.bBg().a(Dx, null);
            }
            i(Dx);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.foz = downloadCacheKey;
        bBa();
        this.foA = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bBg().d(downloadCacheKey);
        if (d != null) {
            this.lFy.a(d.getCurrentState());
        } else {
            this.lFy.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.lFC != null && this.lFC.getAdvertAppInfo() != null) {
            str = this.lFC.getAdvertAppInfo().page;
            d.setExtInfo(this.lFC.getAdvertAppInfo().extensionInfo);
        }
        this.lFE = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lFy, d, str);
        this.foA = new com.baidu.tieba.ad.download.a.b(this.lFE);
        if (d.extra().getPercent() > 0) {
            this.lFE.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bAZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard lFJ;

        public a(CriusAdCard criusAdCard) {
            this.lFJ = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.efr.showToast(R.string.neterror);
            } else if (this.lFJ != null) {
                AdvertAppInfo advertAppInfo = this.lFJ.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.bcw()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.b(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.lFy) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.lFy, z);
                    CriusAdCardView.this.dnG();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.atE;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dWl;
                }
                int c = s.c(CriusAdCardView.this.efr, str, (CriusAdCardView.this.lFC == null || CriusAdCardView.this.lFC.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFC.getAdvertAppInfo().dWj);
                if (CriusAdCardView.this.jPq != null) {
                    CriusAdCardView.this.jPq.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnG() {
        if (this.jPq != null) {
            this.jPq.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aQ(this.efr.getPageActivity(), advertAppInfo.dWm);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bBg().az(this.efr.getPageActivity(), advertAppInfo.dWm);
                    return;
            }
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWm);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWk);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWj, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efr.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efr.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
                aVar.zA(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.lFy != null) {
                            CriusAdCardView.this.lFy.q(CriusAdCardView.this.b(advertAppInfo, i));
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
                aVar.b(this.efr).bhg();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bcv() != 0) {
                l.showToast(this.efr.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.efr.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.efr.getPageActivity()) && this.jPr != null) {
                this.jPr.c(advertAppInfo, i);
                if (this.lFy != null) {
                    this.lFy.q(b(advertAppInfo, i));
                }
            }
        }
    }

    private void dnH() {
        boolean z = true;
        if (this.jJB != null && this.lFw != null) {
            this.jJB.removeAllViews();
            com.baidu.g.a.d.a aVar = this.lFw;
            Activity pageActivity = this.efr.getPageActivity();
            com.baidu.g.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.lFx = aVar.a(pageActivity, aVar2, z);
            this.jJB.addView(this.lFx);
            ap.setBackgroundResource(this.lFx, R.drawable.addresslist_item_bg);
            dnF();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cMw() {
        if (this.lFw != null && ((TextView) this.lFw.fn("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.efr.getPageActivity()));
            dnH();
        }
    }
}
