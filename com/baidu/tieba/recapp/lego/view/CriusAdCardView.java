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
import com.baidu.tieba.tbadkCore.t;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private DownloadCacheKey dZC;
    private d dZD;
    private LinearLayout hSv;
    protected String jJP;
    private com.baidu.c.a.d.a jKK;
    private ViewGroup jKL;
    private ApkDownloadView jKM;
    private AdCloseView jKN;
    private JumpButton jKO;
    private AdThreadCommentAndPraiseInfoLayout jKP;
    private CriusAdCard jKQ;
    private boolean jKR;
    private com.baidu.tieba.ad.browser.newstyle.view.a jKS;
    protected CustomMessageListener jKT;
    private HeadImageView jcI;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jKR = true;
        this.dZD = null;
        this.jKT = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.jJP) && CriusAdCardView.this.jJP.equals(downloadData.getId()) && CriusAdCardView.this.jKM != null) {
                    CriusAdCardView.this.jKM.t(downloadData);
                }
            }
        };
        this.jKK = new com.baidu.c.a.d.a();
        this.jKK.a(new a.InterfaceC0051a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0051a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.jKQ == null || CriusAdCardView.this.jKQ.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jKQ.getAdvertAppInfo().cNk;
                int b = (CriusAdCardView.this.jKQ.directDownload || !CriusAdCardView.this.jKQ.getAdvertAppInfo().aAt()) ? s.b(CriusAdCardView.this.cVv, str, str4) : s.c(CriusAdCardView.this.cVv, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.iaq != null) {
                        CriusAdCardView.this.iaq.b(b, null);
                    }
                } else if (CriusAdCardView.this.iaq != null) {
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
                    CriusAdCardView.this.iaq.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccz() {
        this.hSv = new LinearLayout(this.cVv.getPageActivity());
        this.hSv.setOrientation(1);
        return this.hSv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.jKL, R.drawable.addresslist_item_bg);
        this.jKK.f(this.cVv.getPageActivity(), i == 1 || i == 4);
        if (this.jKM != null) {
            this.jKM.onChangeSkinType(i);
        }
        if (this.jKN != null) {
            this.jKN.onChangeSkinType();
        }
        if (this.jKP != null) {
            this.jKP.onChangeSkinType();
        }
        am.setBackgroundResource(this.jKO, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.jKO, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.jKQ = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cDm();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYj();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYk();
    }

    private void aYj() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().a(this.dZC, this.dZD);
        }
    }

    private void aYk() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().b(this.dZC, this.dZD);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.jcI != null) {
            this.jcI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aJm() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cVv.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aAt()) {
            if (!this.jKQ.directDownload) {
                a(this.jKQ, advertAppInfo);
                this.jKM.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                        CriusAdCardView.this.cDl();
                    }
                });
            } else {
                this.jKM.setOnClickListener(aVar);
            }
            this.jKT.setTag(this.cVv.getUniqueId());
            MessageManager.getInstance().registerListener(this.jKT);
            this.jJP = advertAppInfo.cNn;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.jKM.setData(c);
            this.jKM.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.jKQ.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jKM.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.jKN != null && advertAppInfo != null && advertAppInfo.cNt != null && advertAppInfo.cNt.adCloseInfo != null && advertAppInfo.cNt.adCloseInfo.support_close.intValue() > 0) {
            this.jKN.setPage(getBusinessType());
            this.jKN.setData(advertAppInfo);
            this.jKN.onChangeSkinType();
            if (this.jKN instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.jKN).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.cVv.getPageActivity(), this.jKN, 40, 40, 40, 120);
        }
    }

    private void cDj() {
        if (this.jKO != null) {
            this.jKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cA;
                    if (CriusAdCardView.this.criusData != null && (cA = CriusAdCardView.this.criusData.cA("viewbtn")) != null) {
                        if (!t.IU(cA.Tv) && CriusAdCardView.this.iaq != null) {
                            CriusAdCardView.this.iaq.b(cA.Tw, cA.Tx, null);
                        }
                        if (TextUtils.isEmpty(cA.Ty)) {
                            int b = s.b(CriusAdCardView.this.cVv, cA.Tv, (CriusAdCardView.this.jKQ == null || CriusAdCardView.this.jKQ.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jKQ.getAdvertAppInfo().cNk);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.iaq != null) {
                                CriusAdCardView.this.iaq.b(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cVv.getPageActivity());
                        aVar.sR(cA.Ty);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = s.b(CriusAdCardView.this.cVv, cA.Tv, (CriusAdCardView.this.jKQ == null || CriusAdCardView.this.jKQ.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jKQ.getAdvertAppInfo().cNk);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.iaq != null) {
                                    CriusAdCardView.this.iaq.b(b2, null);
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
                        aVar.b(CriusAdCardView.this.cVv).aEG();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.jKP != null) {
            final com.baidu.c.a.c.a cA = this.criusData.cA("bottombar");
            if (cA != null) {
                a(this.jKQ.getAdvertAppInfo(), cA);
                this.jKP.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.jKP.setBarNameClickEnabled(false);
                this.jKP.setReplyTimeVisible(false);
                if (cA.Tz != Integer.MIN_VALUE) {
                    this.jKP.setShareClickable(true);
                    this.jKP.setShareContainerBgGray(false);
                } else {
                    this.jKP.setShareClickable(false);
                    this.jKP.setShareContainerBgGray(true);
                }
                this.jKP.getCommentContainer().setOnClickListener(aVar);
                this.jKP.setNeedAddReplyIcon(true);
                this.jKP.setCommentNumEnable(true);
                this.jKP.setCommentClickable(true);
                this.jKP.setReplayContainerBgGray(true);
                this.jKP.setOnClickListener(aVar);
                this.jKP.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return cA.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return cA.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return cA.TC;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return cA.TD;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.jKQ.getAdvertAppInfo();
                    }
                });
                if (cA.TB != Integer.MIN_VALUE) {
                    this.jKP.setAgreeClickable(true);
                    this.jKP.setPraiseContainerBgGray(false);
                } else {
                    this.jKP.setAgreeClickable(false);
                    this.jKP.setPraiseContainerBgGray(true);
                }
                this.jKP.onChangeSkinType();
            }
            if (this.jKP != null) {
                if (this.jKN == null) {
                    this.jKN = new AdCloseView(this.cVv.getPageActivity());
                }
                if (this.jKN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jKN.getParent()).removeView(this.jKN);
                }
                this.jKP.addAdMoreView(this.jKN);
                l(this.jKQ.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.c.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.jKR || (bjVar.aDL() <= 0 && bjVar.aDP() <= 0)) {
                if (this.jKR) {
                    this.jKR = false;
                }
                bjVar.jJ(aVar.TA);
                bjVar.jR(aVar.TB);
                bjVar.by(aVar.Tz);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.jKQ != null) {
            distributeVideoView.setPageContext(this.cVv);
            distributeVideoView.setVideoTailFrameData(this.jKQ.tailFrame);
            distributeVideoView.setChargeInfo(this.jKQ.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cDk() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.jKQ.getAdvertAppInfo();
        a aVar = new a(this.jKQ);
        setCriusViewClick(aVar);
        View cD = this.jKK.cD("head");
        if (cD != null && (cD instanceof HeadImageView)) {
            this.jcI = (HeadImageView) cD;
            setHeadLongClick(advertAppInfo);
        }
        View cD2 = this.jKK.cD(LaunchParams.SRC_TYPE_DOWNLOAD);
        if (cD2 != null && (cD2 instanceof ApkDownloadView)) {
            this.jKM = (ApkDownloadView) cD2;
            this.jKM.u(this.cVv.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View cD3 = this.jKK.cD("closead");
        if (cD3 != null && (cD3 instanceof AdCloseView)) {
            this.jKN = (AdCloseView) cD3;
            l(advertAppInfo);
        }
        View cD4 = this.jKK.cD("viewbtn");
        if (cD4 != null && (cD4 instanceof JumpButton)) {
            this.jKO = (JumpButton) cD4;
            cDj();
        }
        View cD5 = this.jKK.cD("bottombar");
        if (cD5 != null && (cD5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cD5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.jKP = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cE = this.jKK.cE("video");
        if (cE != null && (distributeVideoView = (DistributeVideoView) cE.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.jKQ.directDownload) {
            this.jKL.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.Tv)) {
            this.jKL.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cE = this.jKK.cE("video");
        if (cE == null || (distributeVideoView = (DistributeVideoView) cE.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cE = this.jKK.cE("video");
        if (cE != null && (distributeVideoView = (DistributeVideoView) cE.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xc;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.cNk;
            if (!TextUtils.isEmpty(str)) {
                xc = com.baidu.tieba.ad.download.d.aYp().xb(str);
            } else {
                xc = com.baidu.tieba.ad.download.d.aYp().xc(scheme);
            }
            if (xc == null) {
                xc = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cNn);
                com.baidu.tieba.ad.download.d.aYp().a(xc, null);
            }
            i(xc);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dZC = downloadCacheKey;
        aYk();
        this.dZD = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aYp().d(downloadCacheKey);
        if (d != null) {
            this.jKM.a(d.getCurrentState());
        } else {
            this.jKM.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.jKQ != null || this.jKQ.getAdvertAppInfo() != null) {
            str = this.jKQ.getAdvertAppInfo().page;
        }
        this.jKS = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jKM, d, str);
        this.dZD = new com.baidu.tieba.ad.download.a.b(this.jKS);
        if (d.extra().getPercent() > 0) {
            this.jKS.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aYj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard jKX;

        public a(CriusAdCard criusAdCard) {
            this.jKX = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cVv.showToast(R.string.neterror);
            } else if (this.jKX != null) {
                AdvertAppInfo advertAppInfo = this.jKX.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aAt()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.jKM) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.jKM, z);
                    CriusAdCardView.this.cDl();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Tv;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.cNm;
                }
                int b = s.b(CriusAdCardView.this.cVv, str, (CriusAdCardView.this.jKQ == null || CriusAdCardView.this.jKQ.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jKQ.getAdvertAppInfo().cNk);
                if (CriusAdCardView.this.iaq != null) {
                    CriusAdCardView.this.iaq.b(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDl() {
        if (this.iaq != null) {
            this.iaq.b(3, null);
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
                    h.bd(this.cVv.getPageActivity(), advertAppInfo.cNn);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYp().aN(this.cVv.getPageActivity(), advertAppInfo.cNn);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNn);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cNl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cNk, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
                aVar.sR(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.jKM != null) {
                            CriusAdCardView.this.jKM.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVv).aEG();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aAs() != 0) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVv.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVv.getPageActivity()) && this.iar != null) {
                this.iar.b(advertAppInfo, i);
                if (this.jKM != null) {
                    this.jKM.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cDm() {
        boolean z = true;
        if (this.hSv != null && this.jKK != null) {
            this.hSv.removeAllViews();
            com.baidu.c.a.d.a aVar = this.jKK;
            Activity pageActivity = this.cVv.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.jKL = aVar.a(pageActivity, aVar2, z);
            this.hSv.addView(this.jKL);
            am.setBackgroundResource(this.jKL, R.drawable.addresslist_item_bg);
            cDk();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccF() {
        if (this.jKK != null && ((TextView) this.jKK.cE("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cVv.getPageActivity()));
            cDm();
        }
    }
}
