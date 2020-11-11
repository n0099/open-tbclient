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
    private DownloadCacheKey fSc;
    private d fSd;
    private LinearLayout kzu;
    private HeadImageView lOU;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected String mvk;
    private com.baidu.g.a.d.a mwd;
    private ViewGroup mwe;
    private ApkDownloadView mwf;
    private AdCloseView mwg;
    private JumpButton mwh;
    private AdThreadCommentAndPraiseInfoLayout mwi;
    private CriusAdCard mwj;
    private boolean mwk;
    private com.baidu.tieba.ad.browser.newstyle.view.a mwl;
    protected CustomMessageListener mwm;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mwk = true;
        this.fSd = null;
        this.mwm = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.mvk) && CriusAdCardView.this.mvk.equals(downloadData.getId()) && CriusAdCardView.this.mwf != null) {
                    CriusAdCardView.this.mwf.t(downloadData);
                }
            }
        };
        this.mwd = new com.baidu.g.a.d.a(tbPageContext);
        this.mwd.a(new a.InterfaceC0134a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.g.a.d.a.InterfaceC0134a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.mwj == null || CriusAdCardView.this.mwj.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mwj.getAdvertAppInfo().eyO;
                int c = (CriusAdCardView.this.mwj == null || CriusAdCardView.this.mwj.directDownload || !CriusAdCardView.this.mwj.getAdvertAppInfo().bks()) ? s.c(CriusAdCardView.this.eIc, str, str4) : s.d(CriusAdCardView.this.eIc, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.kFA != null) {
                        CriusAdCardView.this.kFA.d(c, null);
                    }
                } else if (CriusAdCardView.this.kFA != null) {
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
                    CriusAdCardView.this.kFA.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZo() {
        this.kzu = new LinearLayout(this.eIc.getPageActivity());
        this.kzu.setOrientation(1);
        return this.kzu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ap.setBackgroundResource(this.mwe, R.drawable.addresslist_item_bg);
        this.mwd.h(this.eIc.getPageActivity(), i == 1 || i == 4);
        if (this.mwf != null) {
            this.mwf.onChangeSkinType(i);
        }
        if (this.mwg != null) {
            this.mwg.onChangeSkinType();
        }
        if (this.mwi != null) {
            this.mwi.onChangeSkinType();
        }
        ap.setBackgroundResource(this.mwh, R.drawable.btn_focus_border_bg);
        ap.setViewTextColor(this.mwh, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.mwj = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            dAK();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bJp();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bJq();
    }

    private void bJp() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().a(this.fSc, this.fSd);
        }
    }

    private void bJq() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().b(this.fSc, this.fSd);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.lOU != null) {
            this.lOU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.but() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.eIc.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.bks()) {
            if (!this.mwj.directDownload) {
                a(this.mwj, advertAppInfo);
                this.mwf.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bP(View view) {
                        CriusAdCardView.this.dAJ();
                        return false;
                    }
                });
            } else {
                this.mwf.setOnClickListener(aVar);
            }
            this.mwm.setTag(this.eIc.getUniqueId());
            MessageManager.getInstance().registerListener(this.mwm);
            this.mvk = advertAppInfo.eyR;
            DownloadData b = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(b);
            this.mwf.setData(b);
            this.mwf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.mwj.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mwf.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.mwg != null && advertAppInfo != null && advertAppInfo.eyX != null && advertAppInfo.eyX.adCloseInfo != null && advertAppInfo.eyX.adCloseInfo.support_close.intValue() > 0) {
            this.mwg.setPage(getBusinessType());
            this.mwg.setData(advertAppInfo);
            this.mwg.onChangeSkinType();
            if (this.mwg instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.mwg).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.eIc.getPageActivity(), this.mwg, 40, 40, 40, 120);
        }
    }

    private void dAH() {
        if (this.mwh != null) {
            this.mwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.g.a.c.a fq;
                    if (CriusAdCardView.this.criusData != null && (fq = CriusAdCardView.this.criusData.fq("viewbtn")) != null) {
                        if (!u.Rp(fq.auQ) && CriusAdCardView.this.kFA != null) {
                            CriusAdCardView.this.kFA.a(fq.auR, fq.auS, null);
                        }
                        if (TextUtils.isEmpty(fq.auT)) {
                            int c = s.c(CriusAdCardView.this.eIc, fq.auQ, (CriusAdCardView.this.mwj == null || CriusAdCardView.this.mwj.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mwj.getAdvertAppInfo().eyO);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.kFA != null) {
                                CriusAdCardView.this.kFA.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.eIc.getPageActivity());
                        aVar.Bo(fq.auT);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.eIc, fq.auQ, (CriusAdCardView.this.mwj == null || CriusAdCardView.this.mwj.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mwj.getAdvertAppInfo().eyO);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.kFA != null) {
                                    CriusAdCardView.this.kFA.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.eIc).bpc();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.mwi != null) {
            final com.baidu.g.a.c.a fq = this.criusData.fq("bottombar");
            if (fq != null) {
                a(this.mwj.getAdvertAppInfo(), fq);
                this.mwi.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.mwi.setBarNameClickEnabled(false);
                this.mwi.setReplyTimeVisible(false);
                if (fq.auU != Integer.MIN_VALUE) {
                    this.mwi.setShareClickable(true);
                    this.mwi.setShareContainerBgGray(false);
                } else {
                    this.mwi.setShareClickable(false);
                    this.mwi.setShareContainerBgGray(true);
                }
                this.mwi.getCommentContainer().setOnClickListener(aVar);
                this.mwi.setNeedAddReplyIcon(true);
                this.mwi.setCommentNumEnable(true);
                this.mwi.setCommentClickable(true);
                this.mwi.setReplayContainerBgGray(true);
                this.mwi.setOnClickListener(aVar);
                this.mwi.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return fq.auX;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return fq.auY;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.mwj.getAdvertAppInfo();
                    }
                });
                if (fq.auW != Integer.MIN_VALUE) {
                    this.mwi.setAgreeClickable(true);
                    this.mwi.setPraiseContainerBgGray(false);
                } else {
                    this.mwi.setAgreeClickable(false);
                    this.mwi.setPraiseContainerBgGray(true);
                }
                this.mwi.onChangeSkinType();
            }
            if (this.mwi != null) {
                if (this.mwg == null) {
                    this.mwg = new AdCloseView(this.eIc.getPageActivity());
                }
                if (this.mwg.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mwg.getParent()).removeView(this.mwg);
                }
                this.mwi.addAdMoreView(this.mwg);
                k(this.mwj.getAdvertAppInfo());
            }
        }
    }

    public void a(bw bwVar, com.baidu.g.a.c.a aVar) {
        if (bwVar != null && aVar != null) {
            if (this.mwk || (bwVar.bnY() <= 0 && bwVar.boc() <= 0)) {
                if (this.mwk) {
                    this.mwk = false;
                }
                bwVar.oj(aVar.auV);
                bwVar.or(aVar.auW);
                bwVar.dk(aVar.auU);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.mwj != null) {
            distributeVideoView.setPageContext(this.eIc);
            distributeVideoView.setVideoTailFrameData(this.mwj.tailFrame);
            distributeVideoView.setChargeInfo(this.mwj.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void dAI() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.mwj.getAdvertAppInfo();
        a aVar = new a(this.mwj);
        setCriusViewClick(aVar);
        View ft = this.mwd.ft("head");
        if (ft != null && (ft instanceof HeadImageView)) {
            this.lOU = (HeadImageView) ft;
            setHeadLongClick(advertAppInfo);
        }
        View ft2 = this.mwd.ft("download");
        if (ft2 != null && (ft2 instanceof ApkDownloadView)) {
            this.mwf = (ApkDownloadView) ft2;
            this.mwf.x(this.eIc.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View ft3 = this.mwd.ft("closead");
        if (ft3 != null && (ft3 instanceof AdCloseView)) {
            this.mwg = (AdCloseView) ft3;
            k(advertAppInfo);
        }
        View ft4 = this.mwd.ft("viewbtn");
        if (ft4 != null && (ft4 instanceof JumpButton)) {
            this.mwh = (JumpButton) ft4;
            dAH();
        }
        View ft5 = this.mwd.ft("bottombar");
        if (ft5 != null && (ft5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) ft5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.mwi = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View fu = this.mwd.fu("video");
        if (fu != null && (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.mwj.directDownload) {
            this.mwe.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.auQ)) {
            this.mwe.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View fu = this.mwd.fu("video");
        if (fu == null || (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View fu = this.mwd.fu("video");
        if (fu != null && (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Fm;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.eyO;
            if (!TextUtils.isEmpty(str)) {
                Fm = com.baidu.tieba.ad.download.d.bJw().Fl(str);
            } else {
                Fm = com.baidu.tieba.ad.download.d.bJw().Fm(scheme);
            }
            if (Fm == null) {
                Fm = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eyR);
                com.baidu.tieba.ad.download.d.bJw().a(Fm, null);
            }
            i(Fm);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.fSc = downloadCacheKey;
        bJq();
        this.fSd = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
        if (d != null) {
            this.mwf.a(d.getCurrentState());
        } else {
            this.mwf.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.mwj != null && this.mwj.getAdvertAppInfo() != null) {
            str = this.mwj.getAdvertAppInfo().page;
            d.setExtInfo(this.mwj.getAdvertAppInfo().extensionInfo);
        }
        this.mwl = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mwf, d, str);
        this.fSd = new com.baidu.tieba.ad.download.a.b(this.mwl);
        if (d.extra().getPercent() > 0) {
            this.mwl.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bJp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard mwq;

        public a(CriusAdCard criusAdCard) {
            this.mwq = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.eIc.showToast(R.string.neterror);
            } else if (this.mwq != null) {
                AdvertAppInfo advertAppInfo = this.mwq.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.bks()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.b(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.mwf) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.mwf, z);
                    CriusAdCardView.this.dAJ();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.auQ;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.eyQ;
                }
                int c = s.c(CriusAdCardView.this.eIc, str, (CriusAdCardView.this.mwj == null || CriusAdCardView.this.mwj.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mwj.getAdvertAppInfo().eyO);
                if (CriusAdCardView.this.kFA != null) {
                    CriusAdCardView.this.kFA.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAJ() {
        if (this.kFA != null) {
            this.kFA.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aX(this.eIc.getPageActivity(), advertAppInfo.eyR);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bJw().aG(this.eIc.getPageActivity(), advertAppInfo.eyR);
                    return;
            }
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eyR);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eyP);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eyO, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eIc.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bks()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eIc.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
                aVar.Bo(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.mwf != null) {
                            CriusAdCardView.this.mwf.q(CriusAdCardView.this.b(advertAppInfo, i));
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
                aVar.b(this.eIc).bpc();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bkr() != 0) {
                l.showToast(this.eIc.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eIc.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eIc.getPageActivity()) && this.kFB != null) {
                this.kFB.c(advertAppInfo, i);
                if (this.mwf != null) {
                    this.mwf.q(b(advertAppInfo, i));
                }
            }
        }
    }

    private void dAK() {
        boolean z = true;
        if (this.kzu != null && this.mwd != null) {
            this.kzu.removeAllViews();
            com.baidu.g.a.d.a aVar = this.mwd;
            Activity pageActivity = this.eIc.getPageActivity();
            com.baidu.g.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.mwe = aVar.a(pageActivity, aVar2, z);
            this.kzu.addView(this.mwe);
            ap.setBackgroundResource(this.mwe, R.drawable.addresslist_item_bg);
            dAI();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cZu() {
        if (this.mwd != null && ((TextView) this.mwd.fu("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.eIc.getPageActivity()));
            dAK();
        }
    }
}
