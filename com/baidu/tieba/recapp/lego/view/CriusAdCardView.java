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
    private DownloadCacheKey fMm;
    private d fMn;
    private LinearLayout kty;
    private HeadImageView lIY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected String mpn;
    private com.baidu.g.a.d.a mqg;
    private ViewGroup mqh;
    private ApkDownloadView mqi;
    private AdCloseView mqj;
    private JumpButton mqk;
    private AdThreadCommentAndPraiseInfoLayout mql;
    private CriusAdCard mqm;
    private boolean mqn;
    private com.baidu.tieba.ad.browser.newstyle.view.a mqo;
    protected CustomMessageListener mqp;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mqn = true;
        this.fMn = null;
        this.mqp = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.mpn) && CriusAdCardView.this.mpn.equals(downloadData.getId()) && CriusAdCardView.this.mqi != null) {
                    CriusAdCardView.this.mqi.t(downloadData);
                }
            }
        };
        this.mqg = new com.baidu.g.a.d.a(tbPageContext);
        this.mqg.a(new a.InterfaceC0134a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.g.a.d.a.InterfaceC0134a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.mqm == null || CriusAdCardView.this.mqm.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mqm.getAdvertAppInfo().esU;
                int c = (CriusAdCardView.this.mqm == null || CriusAdCardView.this.mqm.directDownload || !CriusAdCardView.this.mqm.getAdvertAppInfo().bhS()) ? s.c(CriusAdCardView.this.eCn, str, str4) : s.d(CriusAdCardView.this.eCn, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.kzG != null) {
                        CriusAdCardView.this.kzG.d(c, null);
                    }
                } else if (CriusAdCardView.this.kzG != null) {
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
                    CriusAdCardView.this.kzG.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cWN() {
        this.kty = new LinearLayout(this.eCn.getPageActivity());
        this.kty.setOrientation(1);
        return this.kty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ap.setBackgroundResource(this.mqh, R.drawable.addresslist_item_bg);
        this.mqg.h(this.eCn.getPageActivity(), i == 1 || i == 4);
        if (this.mqi != null) {
            this.mqi.onChangeSkinType(i);
        }
        if (this.mqj != null) {
            this.mqj.onChangeSkinType();
        }
        if (this.mql != null) {
            this.mql.onChangeSkinType();
        }
        ap.setBackgroundResource(this.mqk, R.drawable.btn_focus_border_bg);
        ap.setViewTextColor(this.mqk, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.mqm = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            dyi();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGQ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGR();
    }

    private void bGQ() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().a(this.fMm, this.fMn);
        }
    }

    private void bGR() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().b(this.fMm, this.fMn);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.lIY != null) {
            this.lIY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.brT() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.eCn.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.bhS()) {
            if (!this.mqm.directDownload) {
                a(this.mqm, advertAppInfo);
                this.mqi.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bL(View view) {
                        CriusAdCardView.this.dyh();
                        return false;
                    }
                });
            } else {
                this.mqi.setOnClickListener(aVar);
            }
            this.mqp.setTag(this.eCn.getUniqueId());
            MessageManager.getInstance().registerListener(this.mqp);
            this.mpn = advertAppInfo.esX;
            DownloadData b = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(b);
            this.mqi.setData(b);
            this.mqi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.mqm.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mqi.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.mqj != null && advertAppInfo != null && advertAppInfo.ete != null && advertAppInfo.ete.adCloseInfo != null && advertAppInfo.ete.adCloseInfo.support_close.intValue() > 0) {
            this.mqj.setPage(getBusinessType());
            this.mqj.setData(advertAppInfo);
            this.mqj.onChangeSkinType();
            if (this.mqj instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.mqj).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.eCn.getPageActivity(), this.mqj, 40, 40, 40, 120);
        }
    }

    private void dyf() {
        if (this.mqk != null) {
            this.mqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.g.a.c.a fq;
                    if (CriusAdCardView.this.criusData != null && (fq = CriusAdCardView.this.criusData.fq("viewbtn")) != null) {
                        if (!u.QY(fq.auQ) && CriusAdCardView.this.kzG != null) {
                            CriusAdCardView.this.kzG.a(fq.auR, fq.auS, null);
                        }
                        if (TextUtils.isEmpty(fq.auT)) {
                            int c = s.c(CriusAdCardView.this.eCn, fq.auQ, (CriusAdCardView.this.mqm == null || CriusAdCardView.this.mqm.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mqm.getAdvertAppInfo().esU);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.kzG != null) {
                                CriusAdCardView.this.kzG.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.eCn.getPageActivity());
                        aVar.Ba(fq.auT);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.eCn, fq.auQ, (CriusAdCardView.this.mqm == null || CriusAdCardView.this.mqm.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mqm.getAdvertAppInfo().esU);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.kzG != null) {
                                    CriusAdCardView.this.kzG.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.eCn).bmC();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.mql != null) {
            final com.baidu.g.a.c.a fq = this.criusData.fq("bottombar");
            if (fq != null) {
                a(this.mqm.getAdvertAppInfo(), fq);
                this.mql.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.mql.setBarNameClickEnabled(false);
                this.mql.setReplyTimeVisible(false);
                if (fq.auU != Integer.MIN_VALUE) {
                    this.mql.setShareClickable(true);
                    this.mql.setShareContainerBgGray(false);
                } else {
                    this.mql.setShareClickable(false);
                    this.mql.setShareContainerBgGray(true);
                }
                this.mql.getCommentContainer().setOnClickListener(aVar);
                this.mql.setNeedAddReplyIcon(true);
                this.mql.setCommentNumEnable(true);
                this.mql.setCommentClickable(true);
                this.mql.setReplayContainerBgGray(true);
                this.mql.setOnClickListener(aVar);
                this.mql.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return CriusAdCardView.this.mqm.getAdvertAppInfo();
                    }
                });
                if (fq.auW != Integer.MIN_VALUE) {
                    this.mql.setAgreeClickable(true);
                    this.mql.setPraiseContainerBgGray(false);
                } else {
                    this.mql.setAgreeClickable(false);
                    this.mql.setPraiseContainerBgGray(true);
                }
                this.mql.onChangeSkinType();
            }
            if (this.mql != null) {
                if (this.mqj == null) {
                    this.mqj = new AdCloseView(this.eCn.getPageActivity());
                }
                if (this.mqj.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mqj.getParent()).removeView(this.mqj);
                }
                this.mql.addAdMoreView(this.mqj);
                k(this.mqm.getAdvertAppInfo());
            }
        }
    }

    public void a(bw bwVar, com.baidu.g.a.c.a aVar) {
        if (bwVar != null && aVar != null) {
            if (this.mqn || (bwVar.bly() <= 0 && bwVar.blC() <= 0)) {
                if (this.mqn) {
                    this.mqn = false;
                }
                bwVar.nZ(aVar.auV);
                bwVar.oh(aVar.auW);
                bwVar.cO(aVar.auU);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.mqm != null) {
            distributeVideoView.setPageContext(this.eCn);
            distributeVideoView.setVideoTailFrameData(this.mqm.tailFrame);
            distributeVideoView.setChargeInfo(this.mqm.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void dyg() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.mqm.getAdvertAppInfo();
        a aVar = new a(this.mqm);
        setCriusViewClick(aVar);
        View ft = this.mqg.ft("head");
        if (ft != null && (ft instanceof HeadImageView)) {
            this.lIY = (HeadImageView) ft;
            setHeadLongClick(advertAppInfo);
        }
        View ft2 = this.mqg.ft("download");
        if (ft2 != null && (ft2 instanceof ApkDownloadView)) {
            this.mqi = (ApkDownloadView) ft2;
            this.mqi.x(this.eCn.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View ft3 = this.mqg.ft("closead");
        if (ft3 != null && (ft3 instanceof AdCloseView)) {
            this.mqj = (AdCloseView) ft3;
            k(advertAppInfo);
        }
        View ft4 = this.mqg.ft("viewbtn");
        if (ft4 != null && (ft4 instanceof JumpButton)) {
            this.mqk = (JumpButton) ft4;
            dyf();
        }
        View ft5 = this.mqg.ft("bottombar");
        if (ft5 != null && (ft5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) ft5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.mql = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View fu = this.mqg.fu("video");
        if (fu != null && (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.mqm.directDownload) {
            this.mqh.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.auQ)) {
            this.mqh.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View fu = this.mqg.fu("video");
        if (fu == null || (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View fu = this.mqg.fu("video");
        if (fu != null && (distributeVideoView = (DistributeVideoView) fu.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EY;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.esU;
            if (!TextUtils.isEmpty(str)) {
                EY = com.baidu.tieba.ad.download.d.bGX().EX(str);
            } else {
                EY = com.baidu.tieba.ad.download.d.bGX().EY(scheme);
            }
            if (EY == null) {
                EY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.esX);
                com.baidu.tieba.ad.download.d.bGX().a(EY, null);
            }
            i(EY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.fMm = downloadCacheKey;
        bGR();
        this.fMn = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bGX().d(downloadCacheKey);
        if (d != null) {
            this.mqi.a(d.getCurrentState());
        } else {
            this.mqi.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.mqm != null && this.mqm.getAdvertAppInfo() != null) {
            str = this.mqm.getAdvertAppInfo().page;
            d.setExtInfo(this.mqm.getAdvertAppInfo().extensionInfo);
        }
        this.mqo = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mqi, d, str);
        this.fMn = new com.baidu.tieba.ad.download.a.b(this.mqo);
        if (d.extra().getPercent() > 0) {
            this.mqo.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bGQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard mqt;

        public a(CriusAdCard criusAdCard) {
            this.mqt = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.eCn.showToast(R.string.neterror);
            } else if (this.mqt != null) {
                AdvertAppInfo advertAppInfo = this.mqt.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.bhS()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.b(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.mqi) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.mqi, z);
                    CriusAdCardView.this.dyh();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.auQ;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.esW;
                }
                int c = s.c(CriusAdCardView.this.eCn, str, (CriusAdCardView.this.mqm == null || CriusAdCardView.this.mqm.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.mqm.getAdvertAppInfo().esU);
                if (CriusAdCardView.this.kzG != null) {
                    CriusAdCardView.this.kzG.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyh() {
        if (this.kzG != null) {
            this.kzG.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aX(this.eCn.getPageActivity(), advertAppInfo.esX);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bGX().aG(this.eCn.getPageActivity(), advertAppInfo.esX);
                    return;
            }
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.esX);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.esV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.esU, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eCn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bhS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eCn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
                aVar.Ba(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.mqi != null) {
                            CriusAdCardView.this.mqi.q(CriusAdCardView.this.b(advertAppInfo, i));
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
                aVar.b(this.eCn).bmC();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bhR() != 0) {
                l.showToast(this.eCn.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eCn.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eCn.getPageActivity()) && this.kzH != null) {
                this.kzH.c(advertAppInfo, i);
                if (this.mqi != null) {
                    this.mqi.q(b(advertAppInfo, i));
                }
            }
        }
    }

    private void dyi() {
        boolean z = true;
        if (this.kty != null && this.mqg != null) {
            this.kty.removeAllViews();
            com.baidu.g.a.d.a aVar = this.mqg;
            Activity pageActivity = this.eCn.getPageActivity();
            com.baidu.g.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.mqh = aVar.a(pageActivity, aVar2, z);
            this.kty.addView(this.mqh);
            ap.setBackgroundResource(this.mqh, R.drawable.addresslist_item_bg);
            dyg();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cWT() {
        if (this.mqg != null && ((TextView) this.mqg.fu("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.eCn.getPageActivity()));
            dyi();
        }
    }
}
