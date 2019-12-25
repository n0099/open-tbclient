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
/* loaded from: classes10.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private DownloadCacheKey dUL;
    private d dUM;
    private LinearLayout hLg;
    private HeadImageView iVM;
    protected String jDA;
    protected CustomMessageListener jEA;
    private com.baidu.c.a.d.a jEr;
    private ViewGroup jEs;
    private ApkDownloadView jEt;
    private AdCloseView jEu;
    private JumpButton jEv;
    private AdThreadCommentAndPraiseInfoLayout jEw;
    private CriusAdCard jEx;
    private boolean jEy;
    private com.baidu.tieba.ad.browser.newstyle.view.a jEz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jEy = true;
        this.dUM = null;
        this.jEA = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.jDA) && CriusAdCardView.this.jDA.equals(downloadData.getId()) && CriusAdCardView.this.jEt != null) {
                    CriusAdCardView.this.jEt.t(downloadData);
                }
            }
        };
        this.jEr = new com.baidu.c.a.d.a();
        this.jEr.a(new a.InterfaceC0049a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0049a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.jEx == null || CriusAdCardView.this.jEx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jEx.getAdvertAppInfo().cIG;
                int a2 = (CriusAdCardView.this.jEx.directDownload || !CriusAdCardView.this.jEx.getAdvertAppInfo().axH()) ? s.a(CriusAdCardView.this.cQU, str, str4) : s.b(CriusAdCardView.this.cQU, str, str4);
                if (a2 == 1 || a2 == 2) {
                    if (CriusAdCardView.this.hTa != null) {
                        CriusAdCardView.this.hTa.b(a2, null);
                    }
                } else if (CriusAdCardView.this.hTa != null) {
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
                    CriusAdCardView.this.hTa.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bZt() {
        this.hLg = new LinearLayout(this.cQU.getPageActivity());
        this.hLg.setOrientation(1);
        return this.hLg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.jEs, R.drawable.addresslist_item_bg);
        this.jEr.f(this.cQU.getPageActivity(), i == 1 || i == 4);
        if (this.jEt != null) {
            this.jEt.onChangeSkinType(i);
        }
        if (this.jEu != null) {
            this.jEu.onChangeSkinType();
        }
        if (this.jEw != null) {
            this.jEw.onChangeSkinType();
        }
        am.setBackgroundResource(this.jEv, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.jEv, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.jEx = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cAk();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aVu();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aVv();
    }

    private void aVu() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().a(this.dUL, this.dUM);
        }
    }

    private void aVv() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().b(this.dUL, this.dUM);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iVM != null) {
            this.iVM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aGy() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cQU.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.axH()) {
            if (!this.jEx.directDownload) {
                a(this.jEx, advertAppInfo);
                this.jEt.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bl(View view) {
                        CriusAdCardView.this.cAj();
                    }
                });
            } else {
                this.jEt.setOnClickListener(aVar);
            }
            this.jEA.setTag(this.cQU.getUniqueId());
            MessageManager.getInstance().registerListener(this.jEA);
            this.jDA = advertAppInfo.cIK;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.jEt.setData(c);
            this.jEt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.jEx.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jEt.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.jEu != null && advertAppInfo != null && advertAppInfo.cIQ != null && advertAppInfo.cIQ.adCloseInfo != null && advertAppInfo.cIQ.adCloseInfo.support_close.intValue() > 0) {
            this.jEu.setPage(getBusinessType());
            this.jEu.setData(advertAppInfo);
            this.jEu.onChangeSkinType();
            if (this.jEu instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.jEu).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.cQU.getPageActivity(), this.jEu, 40, 40, 40, 120);
        }
    }

    private void cAh() {
        if (this.jEv != null) {
            this.jEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a ct;
                    if (CriusAdCardView.this.criusData != null && (ct = CriusAdCardView.this.criusData.ct("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.Iw(ct.Rz) && CriusAdCardView.this.hTa != null) {
                            CriusAdCardView.this.hTa.b(ct.RA, ct.RB, null);
                        }
                        if (TextUtils.isEmpty(ct.RC)) {
                            int a2 = s.a(CriusAdCardView.this.cQU, ct.Rz, (CriusAdCardView.this.jEx == null || CriusAdCardView.this.jEx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jEx.getAdvertAppInfo().cIG);
                            if ((a2 == 1 || a2 == 2) && CriusAdCardView.this.hTa != null) {
                                CriusAdCardView.this.hTa.b(a2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cQU.getPageActivity());
                        aVar.sz(ct.RC);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int a3 = s.a(CriusAdCardView.this.cQU, ct.Rz, (CriusAdCardView.this.jEx == null || CriusAdCardView.this.jEx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jEx.getAdvertAppInfo().cIG);
                                if ((a3 == 1 || a3 == 2) && CriusAdCardView.this.hTa != null) {
                                    CriusAdCardView.this.hTa.b(a3, null);
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
                        aVar.b(CriusAdCardView.this.cQU).aBW();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.jEw != null) {
            final com.baidu.c.a.c.a ct = this.criusData.ct("bottombar");
            if (ct != null) {
                a(this.jEx.getAdvertAppInfo(), ct);
                this.jEw.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.jEw.setBarNameClickEnabled(false);
                this.jEw.setReplyTimeVisible(false);
                if (ct.RD != Integer.MIN_VALUE) {
                    this.jEw.setShareClickable(true);
                    this.jEw.setShareContainerBgGray(false);
                } else {
                    this.jEw.setShareClickable(false);
                    this.jEw.setShareContainerBgGray(true);
                }
                this.jEw.getCommentContainer().setOnClickListener(aVar);
                this.jEw.setNeedAddReplyIcon(true);
                this.jEw.setCommentNumEnable(true);
                this.jEw.setCommentClickable(true);
                this.jEw.setReplayContainerBgGray(true);
                this.jEw.setOnClickListener(aVar);
                this.jEw.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return ct.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return ct.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return ct.RG;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return ct.RH;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.jEx.getAdvertAppInfo();
                    }
                });
                if (ct.RF != Integer.MIN_VALUE) {
                    this.jEw.setAgreeClickable(true);
                    this.jEw.setPraiseContainerBgGray(false);
                } else {
                    this.jEw.setAgreeClickable(false);
                    this.jEw.setPraiseContainerBgGray(true);
                }
                this.jEw.onChangeSkinType();
            }
            if (this.jEw != null) {
                if (this.jEu == null) {
                    this.jEu = new AdCloseView(this.cQU.getPageActivity());
                }
                if (this.jEu.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jEu.getParent()).removeView(this.jEu);
                }
                this.jEw.addAdMoreView(this.jEu);
                k(this.jEx.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.c.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.jEy || (bjVar.aAZ() <= 0 && bjVar.aBd() <= 0)) {
                if (this.jEy) {
                    this.jEy = false;
                }
                bjVar.js(aVar.RE);
                bjVar.jA(aVar.RF);
                bjVar.br(aVar.RD);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.jEx != null) {
            distributeVideoView.setPageContext(this.cQU);
            distributeVideoView.setVideoTailFrameData(this.jEx.tailFrame);
            distributeVideoView.setChargeInfo(this.jEx.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cAi() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.jEx.getAdvertAppInfo();
        a aVar = new a(this.jEx);
        setCriusViewClick(aVar);
        View cw = this.jEr.cw("head");
        if (cw != null && (cw instanceof HeadImageView)) {
            this.iVM = (HeadImageView) cw;
            setHeadLongClick(advertAppInfo);
        }
        View cw2 = this.jEr.cw(LaunchParams.SRC_TYPE_DOWNLOAD);
        if (cw2 != null && (cw2 instanceof ApkDownloadView)) {
            this.jEt = (ApkDownloadView) cw2;
            this.jEt.u(this.cQU.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View cw3 = this.jEr.cw("closead");
        if (cw3 != null && (cw3 instanceof AdCloseView)) {
            this.jEu = (AdCloseView) cw3;
            k(advertAppInfo);
        }
        View cw4 = this.jEr.cw("viewbtn");
        if (cw4 != null && (cw4 instanceof JumpButton)) {
            this.jEv = (JumpButton) cw4;
            cAh();
        }
        View cw5 = this.jEr.cw("bottombar");
        if (cw5 != null && (cw5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cw5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.jEw = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cx = this.jEr.cx("video");
        if (cx != null && (distributeVideoView = (DistributeVideoView) cx.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.jEx.directDownload) {
            this.jEs.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.Rz)) {
            this.jEs.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cx = this.jEr.cx("video");
        if (cx == null || (distributeVideoView = (DistributeVideoView) cx.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cx = this.jEr.cx("video");
        if (cx != null && (distributeVideoView = (DistributeVideoView) cx.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey wD;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.cIG;
            if (!TextUtils.isEmpty(str)) {
                wD = com.baidu.tieba.ad.download.d.aVA().wC(str);
            } else {
                wD = com.baidu.tieba.ad.download.d.aVA().wD(scheme);
            }
            if (wD == null) {
                wD = DownloadCacheKey.create(str, advertAppInfo.cIJ, advertAppInfo.cIK);
                com.baidu.tieba.ad.download.d.aVA().a(wD, null);
            }
            i(wD);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dUL = downloadCacheKey;
        aVv();
        this.dUM = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aVA().d(downloadCacheKey);
        if (d != null) {
            this.jEt.a(d.getCurrentState());
        } else {
            this.jEt.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.jEx != null || this.jEx.getAdvertAppInfo() != null) {
            str = this.jEx.getAdvertAppInfo().page;
        }
        this.jEz = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jEt, d, str);
        this.dUM = new com.baidu.tieba.ad.download.a.b(this.jEz);
        if (d.extra().getPercent() > 0) {
            this.jEz.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aVu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard jEE;

        public a(CriusAdCard criusAdCard) {
            this.jEE = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cQU.showToast(R.string.neterror);
            } else if (this.jEE != null) {
                AdvertAppInfo advertAppInfo = this.jEE.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.axH()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.jEt) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.jEt, z);
                    CriusAdCardView.this.cAj();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Rz;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.cII;
                }
                int a = s.a(CriusAdCardView.this.cQU, str, (CriusAdCardView.this.jEx == null || CriusAdCardView.this.jEx.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jEx.getAdvertAppInfo().cIG);
                if (CriusAdCardView.this.hTa != null) {
                    CriusAdCardView.this.hTa.b(a, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAj() {
        if (this.hTa != null) {
            this.hTa.b(3, null);
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
                    h.bc(this.cQU.getPageActivity(), advertAppInfo.cIK);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aVA().aM(this.cQU.getPageActivity(), advertAppInfo.cIK);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIK);
        downloadData.setUrl(advertAppInfo.cIJ);
        downloadData.setName(advertAppInfo.cIH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cIG, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.axH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cQU.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
                aVar.sz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.jEt != null) {
                            CriusAdCardView.this.jEt.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cQU).aBW();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.axG() != 0) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cQU.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cQU.getPageActivity()) && this.hTb != null) {
                this.hTb.b(advertAppInfo, i);
                if (this.jEt != null) {
                    this.jEt.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cAk() {
        boolean z = true;
        if (this.hLg != null && this.jEr != null) {
            this.hLg.removeAllViews();
            com.baidu.c.a.d.a aVar = this.jEr;
            Activity pageActivity = this.cQU.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.jEs = aVar.a(pageActivity, aVar2, z);
            this.hLg.addView(this.jEs);
            am.setBackgroundResource(this.jEs, R.drawable.addresslist_item_bg);
            cAi();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bZz() {
        if (this.jEr != null && ((TextView) this.jEr.cx("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cQU.getPageActivity()));
            cAk();
        }
    }
}
