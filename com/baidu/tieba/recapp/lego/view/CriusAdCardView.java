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
/* loaded from: classes11.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private DownloadCacheKey dUU;
    private d dUV;
    private LinearLayout hOJ;
    private HeadImageView iZu;
    private com.baidu.c.a.d.a jHY;
    private ViewGroup jHZ;
    protected String jHh;
    private ApkDownloadView jIa;
    private AdCloseView jIb;
    private JumpButton jIc;
    private AdThreadCommentAndPraiseInfoLayout jId;
    private CriusAdCard jIe;
    private boolean jIf;
    private com.baidu.tieba.ad.browser.newstyle.view.a jIg;
    protected CustomMessageListener jIh;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jIf = true;
        this.dUV = null;
        this.jIh = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.jHh) && CriusAdCardView.this.jHh.equals(downloadData.getId()) && CriusAdCardView.this.jIa != null) {
                    CriusAdCardView.this.jIa.t(downloadData);
                }
            }
        };
        this.jHY = new com.baidu.c.a.d.a();
        this.jHY.a(new a.InterfaceC0049a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0049a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.jIe == null || CriusAdCardView.this.jIe.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jIe.getAdvertAppInfo().cIS;
                int b = (CriusAdCardView.this.jIe.directDownload || !CriusAdCardView.this.jIe.getAdvertAppInfo().aya()) ? s.b(CriusAdCardView.this.cRe, str, str4) : s.c(CriusAdCardView.this.cRe, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.hWE != null) {
                        CriusAdCardView.this.hWE.b(b, null);
                    }
                } else if (CriusAdCardView.this.hWE != null) {
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
                    CriusAdCardView.this.hWE.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View caC() {
        this.hOJ = new LinearLayout(this.cRe.getPageActivity());
        this.hOJ.setOrientation(1);
        return this.hOJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.jHZ, R.drawable.addresslist_item_bg);
        this.jHY.f(this.cRe.getPageActivity(), i == 1 || i == 4);
        if (this.jIa != null) {
            this.jIa.onChangeSkinType(i);
        }
        if (this.jIb != null) {
            this.jIb.onChangeSkinType();
        }
        if (this.jId != null) {
            this.jId.onChangeSkinType();
        }
        am.setBackgroundResource(this.jIc, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.jIc, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.jIe = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cBt();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aVN();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aVO();
    }

    private void aVN() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().a(this.dUU, this.dUV);
        }
    }

    private void aVO() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().b(this.dUU, this.dUV);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iZu != null) {
            this.iZu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aGR() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cRe.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aya()) {
            if (!this.jIe.directDownload) {
                a(this.jIe, advertAppInfo);
                this.jIa.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                        CriusAdCardView.this.cBs();
                    }
                });
            } else {
                this.jIa.setOnClickListener(aVar);
            }
            this.jIh.setTag(this.cRe.getUniqueId());
            MessageManager.getInstance().registerListener(this.jIh);
            this.jHh = advertAppInfo.cIV;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.jIa.setData(c);
            this.jIa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.jIe.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jIa.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.jIb != null && advertAppInfo != null && advertAppInfo.cJb != null && advertAppInfo.cJb.adCloseInfo != null && advertAppInfo.cJb.adCloseInfo.support_close.intValue() > 0) {
            this.jIb.setPage(getBusinessType());
            this.jIb.setData(advertAppInfo);
            this.jIb.onChangeSkinType();
            if (this.jIb instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.jIb).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.cRe.getPageActivity(), this.jIb, 40, 40, 40, 120);
        }
    }

    private void cBq() {
        if (this.jIc != null) {
            this.jIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a ct;
                    if (CriusAdCardView.this.criusData != null && (ct = CriusAdCardView.this.criusData.ct("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.IG(ct.RC) && CriusAdCardView.this.hWE != null) {
                            CriusAdCardView.this.hWE.b(ct.RD, ct.RE, null);
                        }
                        if (TextUtils.isEmpty(ct.RF)) {
                            int b = s.b(CriusAdCardView.this.cRe, ct.RC, (CriusAdCardView.this.jIe == null || CriusAdCardView.this.jIe.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jIe.getAdvertAppInfo().cIS);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.hWE != null) {
                                CriusAdCardView.this.hWE.b(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cRe.getPageActivity());
                        aVar.sC(ct.RF);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = s.b(CriusAdCardView.this.cRe, ct.RC, (CriusAdCardView.this.jIe == null || CriusAdCardView.this.jIe.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jIe.getAdvertAppInfo().cIS);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.hWE != null) {
                                    CriusAdCardView.this.hWE.b(b2, null);
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
                        aVar.b(CriusAdCardView.this.cRe).aCp();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.jId != null) {
            final com.baidu.c.a.c.a ct = this.criusData.ct("bottombar");
            if (ct != null) {
                a(this.jIe.getAdvertAppInfo(), ct);
                this.jId.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.jId.setBarNameClickEnabled(false);
                this.jId.setReplyTimeVisible(false);
                if (ct.RG != Integer.MIN_VALUE) {
                    this.jId.setShareClickable(true);
                    this.jId.setShareContainerBgGray(false);
                } else {
                    this.jId.setShareClickable(false);
                    this.jId.setShareContainerBgGray(true);
                }
                this.jId.getCommentContainer().setOnClickListener(aVar);
                this.jId.setNeedAddReplyIcon(true);
                this.jId.setCommentNumEnable(true);
                this.jId.setCommentClickable(true);
                this.jId.setReplayContainerBgGray(true);
                this.jId.setOnClickListener(aVar);
                this.jId.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return ct.RJ;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return ct.RK;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.jIe.getAdvertAppInfo();
                    }
                });
                if (ct.RI != Integer.MIN_VALUE) {
                    this.jId.setAgreeClickable(true);
                    this.jId.setPraiseContainerBgGray(false);
                } else {
                    this.jId.setAgreeClickable(false);
                    this.jId.setPraiseContainerBgGray(true);
                }
                this.jId.onChangeSkinType();
            }
            if (this.jId != null) {
                if (this.jIb == null) {
                    this.jIb = new AdCloseView(this.cRe.getPageActivity());
                }
                if (this.jIb.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jIb.getParent()).removeView(this.jIb);
                }
                this.jId.addAdMoreView(this.jIb);
                k(this.jIe.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.c.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.jIf || (bjVar.aBs() <= 0 && bjVar.aBw() <= 0)) {
                if (this.jIf) {
                    this.jIf = false;
                }
                bjVar.js(aVar.RH);
                bjVar.jA(aVar.RI);
                bjVar.bu(aVar.RG);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.jIe != null) {
            distributeVideoView.setPageContext(this.cRe);
            distributeVideoView.setVideoTailFrameData(this.jIe.tailFrame);
            distributeVideoView.setChargeInfo(this.jIe.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cBr() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.jIe.getAdvertAppInfo();
        a aVar = new a(this.jIe);
        setCriusViewClick(aVar);
        View cw = this.jHY.cw("head");
        if (cw != null && (cw instanceof HeadImageView)) {
            this.iZu = (HeadImageView) cw;
            setHeadLongClick(advertAppInfo);
        }
        View cw2 = this.jHY.cw(LaunchParams.SRC_TYPE_DOWNLOAD);
        if (cw2 != null && (cw2 instanceof ApkDownloadView)) {
            this.jIa = (ApkDownloadView) cw2;
            this.jIa.u(this.cRe.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View cw3 = this.jHY.cw("closead");
        if (cw3 != null && (cw3 instanceof AdCloseView)) {
            this.jIb = (AdCloseView) cw3;
            k(advertAppInfo);
        }
        View cw4 = this.jHY.cw("viewbtn");
        if (cw4 != null && (cw4 instanceof JumpButton)) {
            this.jIc = (JumpButton) cw4;
            cBq();
        }
        View cw5 = this.jHY.cw("bottombar");
        if (cw5 != null && (cw5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cw5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.jId = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cx = this.jHY.cx("video");
        if (cx != null && (distributeVideoView = (DistributeVideoView) cx.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.jIe.directDownload) {
            this.jHZ.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.RC)) {
            this.jHZ.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cx = this.jHY.cx("video");
        if (cx == null || (distributeVideoView = (DistributeVideoView) cx.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cx = this.jHY.cx("video");
        if (cx != null && (distributeVideoView = (DistributeVideoView) cx.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey wH;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.cIS;
            if (!TextUtils.isEmpty(str)) {
                wH = com.baidu.tieba.ad.download.d.aVT().wG(str);
            } else {
                wH = com.baidu.tieba.ad.download.d.aVT().wH(scheme);
            }
            if (wH == null) {
                wH = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cIV);
                com.baidu.tieba.ad.download.d.aVT().a(wH, null);
            }
            i(wH);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dUU = downloadCacheKey;
        aVO();
        this.dUV = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aVT().d(downloadCacheKey);
        if (d != null) {
            this.jIa.a(d.getCurrentState());
        } else {
            this.jIa.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.jIe != null || this.jIe.getAdvertAppInfo() != null) {
            str = this.jIe.getAdvertAppInfo().page;
        }
        this.jIg = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIa, d, str);
        this.dUV = new com.baidu.tieba.ad.download.a.b(this.jIg);
        if (d.extra().getPercent() > 0) {
            this.jIg.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aVN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard jIl;

        public a(CriusAdCard criusAdCard) {
            this.jIl = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cRe.showToast(R.string.neterror);
            } else if (this.jIl != null) {
                AdvertAppInfo advertAppInfo = this.jIl.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aya()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.jIa) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.jIa, z);
                    CriusAdCardView.this.cBs();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.RC;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.cIU;
                }
                int b = s.b(CriusAdCardView.this.cRe, str, (CriusAdCardView.this.jIe == null || CriusAdCardView.this.jIe.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jIe.getAdvertAppInfo().cIS);
                if (CriusAdCardView.this.hWE != null) {
                    CriusAdCardView.this.hWE.b(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBs() {
        if (this.hWE != null) {
            this.hWE.b(3, null);
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
                    h.bd(this.cRe.getPageActivity(), advertAppInfo.cIV);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aVT().aN(this.cRe.getPageActivity(), advertAppInfo.cIV);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIV);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cIT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cIS, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aya()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cRe.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
                aVar.sC(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.jIa != null) {
                            CriusAdCardView.this.jIa.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cRe).aCp();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.axZ() != 0) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cRe.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cRe.getPageActivity()) && this.hWF != null) {
                this.hWF.b(advertAppInfo, i);
                if (this.jIa != null) {
                    this.jIa.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cBt() {
        boolean z = true;
        if (this.hOJ != null && this.jHY != null) {
            this.hOJ.removeAllViews();
            com.baidu.c.a.d.a aVar = this.jHY;
            Activity pageActivity = this.cRe.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.jHZ = aVar.a(pageActivity, aVar2, z);
            this.hOJ.addView(this.jHZ);
            am.setBackgroundResource(this.jHZ, R.drawable.addresslist_item_bg);
            cBr();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void caI() {
        if (this.jHY != null && ((TextView) this.jHY.cx("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cRe.getPageActivity()));
            cBt();
        }
    }
}
