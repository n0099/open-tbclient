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
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private DownloadCacheKey dZm;
    private d dZn;
    private LinearLayout hQV;
    protected String jIq;
    private com.baidu.c.a.d.a jJi;
    private ViewGroup jJj;
    private ApkDownloadView jJk;
    private AdCloseView jJl;
    private JumpButton jJm;
    private AdThreadCommentAndPraiseInfoLayout jJn;
    private CriusAdCard jJo;
    private boolean jJp;
    private com.baidu.tieba.ad.browser.newstyle.view.a jJq;
    protected CustomMessageListener jJr;
    private HeadImageView jbj;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jJp = true;
        this.dZn = null;
        this.jJr = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.jIq) && CriusAdCardView.this.jIq.equals(downloadData.getId()) && CriusAdCardView.this.jJk != null) {
                    CriusAdCardView.this.jJk.t(downloadData);
                }
            }
        };
        this.jJi = new com.baidu.c.a.d.a();
        this.jJi.a(new a.InterfaceC0051a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0051a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.jJo == null || CriusAdCardView.this.jJo.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJo.getAdvertAppInfo().cMX;
                int b = (CriusAdCardView.this.jJo.directDownload || !CriusAdCardView.this.jJo.getAdvertAppInfo().aAq()) ? s.b(CriusAdCardView.this.cVi, str, str4) : s.c(CriusAdCardView.this.cVi, str, str4);
                if (b == 1 || b == 2) {
                    if (CriusAdCardView.this.hYQ != null) {
                        CriusAdCardView.this.hYQ.b(b, null);
                    }
                } else if (CriusAdCardView.this.hYQ != null) {
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
                    CriusAdCardView.this.hYQ.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccg() {
        this.hQV = new LinearLayout(this.cVi.getPageActivity());
        this.hQV.setOrientation(1);
        return this.hQV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.setBackgroundResource(this.jJj, R.drawable.addresslist_item_bg);
        this.jJi.f(this.cVi.getPageActivity(), i == 1 || i == 4);
        if (this.jJk != null) {
            this.jJk.onChangeSkinType(i);
        }
        if (this.jJl != null) {
            this.jJl.onChangeSkinType();
        }
        if (this.jJn != null) {
            this.jJn.onChangeSkinType();
        }
        am.setBackgroundResource(this.jJm, R.drawable.btn_focus_border_bg);
        am.setViewTextColor(this.jJm, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.jJo = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cCS();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYf();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYg();
    }

    private void aYf() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().a(this.dZm, this.dZn);
        }
    }

    private void aYg() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().b(this.dZm, this.dZn);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.jbj != null) {
            this.jbj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aJi() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.cVi.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aAq()) {
            if (!this.jJo.directDownload) {
                a(this.jJo, advertAppInfo);
                this.jJk.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bp(View view) {
                        CriusAdCardView.this.cCR();
                    }
                });
            } else {
                this.jJk.setOnClickListener(aVar);
            }
            this.jJr.setTag(this.cVi.getUniqueId());
            MessageManager.getInstance().registerListener(this.jJr);
            this.jIq = advertAppInfo.cNa;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.jJk.setData(c);
            this.jJk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.jJo.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jJk.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.jJl != null && advertAppInfo != null && advertAppInfo.cNg != null && advertAppInfo.cNg.adCloseInfo != null && advertAppInfo.cNg.adCloseInfo.support_close.intValue() > 0) {
            this.jJl.setPage(getBusinessType());
            this.jJl.setData(advertAppInfo);
            this.jJl.onChangeSkinType();
            if (this.jJl instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.jJl).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.cVi.getPageActivity(), this.jJl, 40, 40, 40, 120);
        }
    }

    private void cCP() {
        if (this.jJm != null) {
            this.jJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cB;
                    if (CriusAdCardView.this.criusData != null && (cB = CriusAdCardView.this.criusData.cB("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.IV(cB.Tl) && CriusAdCardView.this.hYQ != null) {
                            CriusAdCardView.this.hYQ.b(cB.Tm, cB.Tn, null);
                        }
                        if (TextUtils.isEmpty(cB.To)) {
                            int b = s.b(CriusAdCardView.this.cVi, cB.Tl, (CriusAdCardView.this.jJo == null || CriusAdCardView.this.jJo.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJo.getAdvertAppInfo().cMX);
                            if ((b == 1 || b == 2) && CriusAdCardView.this.hYQ != null) {
                                CriusAdCardView.this.hYQ.b(b, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.cVi.getPageActivity());
                        aVar.sS(cB.To);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int b2 = s.b(CriusAdCardView.this.cVi, cB.Tl, (CriusAdCardView.this.jJo == null || CriusAdCardView.this.jJo.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJo.getAdvertAppInfo().cMX);
                                if ((b2 == 1 || b2 == 2) && CriusAdCardView.this.hYQ != null) {
                                    CriusAdCardView.this.hYQ.b(b2, null);
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
                        aVar.b(CriusAdCardView.this.cVi).aEC();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.jJn != null) {
            final com.baidu.c.a.c.a cB = this.criusData.cB("bottombar");
            if (cB != null) {
                a(this.jJo.getAdvertAppInfo(), cB);
                this.jJn.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.jJn.setBarNameClickEnabled(false);
                this.jJn.setReplyTimeVisible(false);
                if (cB.Tp != Integer.MIN_VALUE) {
                    this.jJn.setShareClickable(true);
                    this.jJn.setShareContainerBgGray(false);
                } else {
                    this.jJn.setShareClickable(false);
                    this.jJn.setShareContainerBgGray(true);
                }
                this.jJn.getCommentContainer().setOnClickListener(aVar);
                this.jJn.setNeedAddReplyIcon(true);
                this.jJn.setCommentNumEnable(true);
                this.jJn.setCommentClickable(true);
                this.jJn.setReplayContainerBgGray(true);
                this.jJn.setOnClickListener(aVar);
                this.jJn.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
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
                        return CriusAdCardView.this.jJo.getAdvertAppInfo();
                    }
                });
                if (cB.Tr != Integer.MIN_VALUE) {
                    this.jJn.setAgreeClickable(true);
                    this.jJn.setPraiseContainerBgGray(false);
                } else {
                    this.jJn.setAgreeClickable(false);
                    this.jJn.setPraiseContainerBgGray(true);
                }
                this.jJn.onChangeSkinType();
            }
            if (this.jJn != null) {
                if (this.jJl == null) {
                    this.jJl = new AdCloseView(this.cVi.getPageActivity());
                }
                if (this.jJl.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jJl.getParent()).removeView(this.jJl);
                }
                this.jJn.addAdMoreView(this.jJl);
                k(this.jJo.getAdvertAppInfo());
            }
        }
    }

    public void a(bj bjVar, com.baidu.c.a.c.a aVar) {
        if (bjVar != null && aVar != null) {
            if (this.jJp || (bjVar.aDH() <= 0 && bjVar.aDL() <= 0)) {
                if (this.jJp) {
                    this.jJp = false;
                }
                bjVar.jJ(aVar.Tq);
                bjVar.jR(aVar.Tr);
                bjVar.by(aVar.Tp);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.jJo != null) {
            distributeVideoView.setPageContext(this.cVi);
            distributeVideoView.setVideoTailFrameData(this.jJo.tailFrame);
            distributeVideoView.setChargeInfo(this.jJo.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cCQ() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.jJo.getAdvertAppInfo();
        a aVar = new a(this.jJo);
        setCriusViewClick(aVar);
        View cE = this.jJi.cE("head");
        if (cE != null && (cE instanceof HeadImageView)) {
            this.jbj = (HeadImageView) cE;
            setHeadLongClick(advertAppInfo);
        }
        View cE2 = this.jJi.cE(LaunchParams.SRC_TYPE_DOWNLOAD);
        if (cE2 != null && (cE2 instanceof ApkDownloadView)) {
            this.jJk = (ApkDownloadView) cE2;
            this.jJk.u(this.cVi.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View cE3 = this.jJi.cE("closead");
        if (cE3 != null && (cE3 instanceof AdCloseView)) {
            this.jJl = (AdCloseView) cE3;
            k(advertAppInfo);
        }
        View cE4 = this.jJi.cE("viewbtn");
        if (cE4 != null && (cE4 instanceof JumpButton)) {
            this.jJm = (JumpButton) cE4;
            cCP();
        }
        View cE5 = this.jJi.cE("bottombar");
        if (cE5 != null && (cE5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cE5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.jJn = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cF = this.jJi.cF("video");
        if (cF != null && (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.jJo.directDownload) {
            this.jJj.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.Tl)) {
            this.jJj.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cF = this.jJi.cF("video");
        if (cF == null || (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cF = this.jJi.cF("video");
        if (cF != null && (distributeVideoView = (DistributeVideoView) cF.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xc;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.cMX;
            if (!TextUtils.isEmpty(str)) {
                xc = com.baidu.tieba.ad.download.d.aYl().xb(str);
            } else {
                xc = com.baidu.tieba.ad.download.d.aYl().xc(scheme);
            }
            if (xc == null) {
                xc = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cNa);
                com.baidu.tieba.ad.download.d.aYl().a(xc, null);
            }
            i(xc);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.dZm = downloadCacheKey;
        aYg();
        this.dZn = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.aYl().d(downloadCacheKey);
        if (d != null) {
            this.jJk.a(d.getCurrentState());
        } else {
            this.jJk.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.jJo != null || this.jJo.getAdvertAppInfo() != null) {
            str = this.jJo.getAdvertAppInfo().page;
        }
        this.jJq = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jJk, d, str);
        this.dZn = new com.baidu.tieba.ad.download.a.b(this.jJq);
        if (d.extra().getPercent() > 0) {
            this.jJq.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        aYf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard jJv;

        public a(CriusAdCard criusAdCard) {
            this.jJv = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.cVi.showToast(R.string.neterror);
            } else if (this.jJv != null) {
                AdvertAppInfo advertAppInfo = this.jJv.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aAq()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.jJk) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.jJk, z);
                    CriusAdCardView.this.cCR();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Tl;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.cMZ;
                }
                int b = s.b(CriusAdCardView.this.cVi, str, (CriusAdCardView.this.jJo == null || CriusAdCardView.this.jJo.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.jJo.getAdvertAppInfo().cMX);
                if (CriusAdCardView.this.hYQ != null) {
                    CriusAdCardView.this.hYQ.b(b, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCR() {
        if (this.hYQ != null) {
            this.hYQ.b(3, null);
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
                    h.bd(this.cVi.getPageActivity(), advertAppInfo.cNa);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYl().aN(this.cVi.getPageActivity(), advertAppInfo.cNa);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNa);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMY);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMX, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVi.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.jJk != null) {
                            CriusAdCardView.this.jJk.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVi).aEC();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aAp() != 0) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVi.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVi.getPageActivity()) && this.hYR != null) {
                this.hYR.b(advertAppInfo, i);
                if (this.jJk != null) {
                    this.jJk.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cCS() {
        boolean z = true;
        if (this.hQV != null && this.jJi != null) {
            this.hQV.removeAllViews();
            com.baidu.c.a.d.a aVar = this.jJi;
            Activity pageActivity = this.cVi.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.jJj = aVar.a(pageActivity, aVar2, z);
            this.hQV.addView(this.jJj);
            am.setBackgroundResource(this.jJj, R.drawable.addresslist_item_bg);
            cCQ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccm() {
        if (this.jJi != null && ((TextView) this.jJi.cF("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.cVi.getPageActivity()));
            cCS();
        }
    }
}
