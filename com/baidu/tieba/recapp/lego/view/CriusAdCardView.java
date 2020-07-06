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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
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
    private DownloadCacheKey eYA;
    private d eYB;
    private LinearLayout jjb;
    private HeadImageView kzF;
    protected String lgB;
    private boolean lhA;
    private com.baidu.tieba.ad.browser.newstyle.view.a lhB;
    protected CustomMessageListener lhC;
    private com.baidu.b.a.d.a lht;
    private ViewGroup lhu;
    private ApkDownloadView lhv;
    private AdCloseView lhw;
    private JumpButton lhx;
    private AdThreadCommentAndPraiseInfoLayout lhy;
    private CriusAdCard lhz;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lhA = true;
        this.eYB = null;
        this.lhC = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.lgB) && CriusAdCardView.this.lgB.equals(downloadData.getId()) && CriusAdCardView.this.lhv != null) {
                    CriusAdCardView.this.lhv.t(downloadData);
                }
            }
        };
        this.lht = new com.baidu.b.a.d.a();
        this.lht.a(new a.InterfaceC0091a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0091a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.lhz == null || CriusAdCardView.this.lhz.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lhz.getAdvertAppInfo().dGL;
                int c = (CriusAdCardView.this.lhz.directDownload || !CriusAdCardView.this.lhz.getAdvertAppInfo().aQj()) ? r.c(CriusAdCardView.this.dPv, str, str4) : r.d(CriusAdCardView.this.dPv, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.jrl != null) {
                        CriusAdCardView.this.jrl.d(c, null);
                    }
                } else if (CriusAdCardView.this.jrl != null) {
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
                    CriusAdCardView.this.jrl.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cxz() {
        this.jjb = new LinearLayout(this.dPv.getPageActivity());
        this.jjb.setOrientation(1);
        return this.jjb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        an.setBackgroundResource(this.lhu, R.drawable.addresslist_item_bg);
        this.lht.h(this.dPv.getPageActivity(), i == 1 || i == 4);
        if (this.lhv != null) {
            this.lhv.onChangeSkinType(i);
        }
        if (this.lhw != null) {
            this.lhw.onChangeSkinType();
        }
        if (this.lhy != null) {
            this.lhy.onChangeSkinType();
        }
        an.setBackgroundResource(this.lhx, R.drawable.btn_focus_border_bg);
        an.setViewTextColor(this.lhx, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.lhz = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cZp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bpa();
    }

    private void boZ() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpg().a(this.eYA, this.eYB);
        }
    }

    private void bpa() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpg().b(this.eYA, this.eYB);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.kzF != null) {
            this.kzF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.aZT() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.dPv.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.aQj()) {
            if (!this.lhz.directDownload) {
                a(this.lhz, advertAppInfo);
                this.lhv.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public void bu(View view) {
                        CriusAdCardView.this.cZo();
                    }
                });
            } else {
                this.lhv.setOnClickListener(aVar);
            }
            this.lhC.setTag(this.dPv.getUniqueId());
            MessageManager.getInstance().registerListener(this.lhC);
            this.lgB = advertAppInfo.dGO;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(c);
            this.lhv.setData(c);
            this.lhv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.lhz.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lhv.getDownloadStatus());
        }
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (this.lhw != null && advertAppInfo != null && advertAppInfo.dGU != null && advertAppInfo.dGU.adCloseInfo != null && advertAppInfo.dGU.adCloseInfo.support_close.intValue() > 0) {
            this.lhw.setPage(getBusinessType());
            this.lhw.setData(advertAppInfo);
            this.lhw.onChangeSkinType();
            if (this.lhw instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.lhw).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.dPv.getPageActivity(), this.lhw, 40, 40, 40, 120);
        }
    }

    private void cZm() {
        if (this.lhx != null) {
            this.lhx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a dQ;
                    if (CriusAdCardView.this.criusData != null && (dQ = CriusAdCardView.this.criusData.dQ("viewbtn")) != null) {
                        if (!t.MW(dQ.aoI) && CriusAdCardView.this.jrl != null) {
                            CriusAdCardView.this.jrl.a(dQ.aoJ, dQ.aoK, null);
                        }
                        if (TextUtils.isEmpty(dQ.aoL)) {
                            int c = r.c(CriusAdCardView.this.dPv, dQ.aoI, (CriusAdCardView.this.lhz == null || CriusAdCardView.this.lhz.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lhz.getAdvertAppInfo().dGL);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.jrl != null) {
                                CriusAdCardView.this.jrl.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.dPv.getPageActivity());
                        aVar.we(dQ.aoL);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = r.c(CriusAdCardView.this.dPv, dQ.aoI, (CriusAdCardView.this.lhz == null || CriusAdCardView.this.lhz.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lhz.getAdvertAppInfo().dGL);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.jrl != null) {
                                    CriusAdCardView.this.jrl.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.dPv).aUN();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.lhy != null) {
            final com.baidu.b.a.c.a dQ = this.criusData.dQ("bottombar");
            if (dQ != null) {
                a(this.lhz.getAdvertAppInfo(), dQ);
                this.lhy.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.lhy.setBarNameClickEnabled(false);
                this.lhy.setReplyTimeVisible(false);
                if (dQ.aoM != Integer.MIN_VALUE) {
                    this.lhy.setShareClickable(true);
                    this.lhy.setShareContainerBgGray(false);
                } else {
                    this.lhy.setShareClickable(false);
                    this.lhy.setShareContainerBgGray(true);
                }
                this.lhy.getCommentContainer().setOnClickListener(aVar);
                this.lhy.setNeedAddReplyIcon(true);
                this.lhy.setCommentNumEnable(true);
                this.lhy.setCommentClickable(true);
                this.lhy.setReplayContainerBgGray(true);
                this.lhy.setOnClickListener(aVar);
                this.lhy.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return dQ.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return dQ.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return dQ.aoP;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return dQ.aoQ;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.lhz.getAdvertAppInfo();
                    }
                });
                if (dQ.aoO != Integer.MIN_VALUE) {
                    this.lhy.setAgreeClickable(true);
                    this.lhy.setPraiseContainerBgGray(false);
                } else {
                    this.lhy.setAgreeClickable(false);
                    this.lhy.setPraiseContainerBgGray(true);
                }
                this.lhy.onChangeSkinType();
            }
            if (this.lhy != null) {
                if (this.lhw == null) {
                    this.lhw = new AdCloseView(this.dPv.getPageActivity());
                }
                if (this.lhw.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lhw.getParent()).removeView(this.lhw);
                }
                this.lhy.addAdMoreView(this.lhw);
                l(this.lhz.getAdvertAppInfo());
            }
        }
    }

    public void a(bu buVar, com.baidu.b.a.c.a aVar) {
        if (buVar != null && aVar != null) {
            if (this.lhA || (buVar.aTN() <= 0 && buVar.aTR() <= 0)) {
                if (this.lhA) {
                    this.lhA = false;
                }
                buVar.kG(aVar.aoN);
                buVar.kO(aVar.aoO);
                buVar.ce(aVar.aoM);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.lhz != null) {
            distributeVideoView.setPageContext(this.dPv);
            distributeVideoView.setVideoTailFrameData(this.lhz.tailFrame);
            distributeVideoView.setChargeInfo(this.lhz.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cZn() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.lhz.getAdvertAppInfo();
        a aVar = new a(this.lhz);
        setCriusViewClick(aVar);
        View dT = this.lht.dT("head");
        if (dT != null && (dT instanceof HeadImageView)) {
            this.kzF = (HeadImageView) dT;
            setHeadLongClick(advertAppInfo);
        }
        View dT2 = this.lht.dT("download");
        if (dT2 != null && (dT2 instanceof ApkDownloadView)) {
            this.lhv = (ApkDownloadView) dT2;
            this.lhv.x(this.dPv.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View dT3 = this.lht.dT("closead");
        if (dT3 != null && (dT3 instanceof AdCloseView)) {
            this.lhw = (AdCloseView) dT3;
            l(advertAppInfo);
        }
        View dT4 = this.lht.dT("viewbtn");
        if (dT4 != null && (dT4 instanceof JumpButton)) {
            this.lhx = (JumpButton) dT4;
            cZm();
        }
        View dT5 = this.lht.dT("bottombar");
        if (dT5 != null && (dT5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dT5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.lhy = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dU = this.lht.dU("video");
        if (dU != null && (distributeVideoView = (DistributeVideoView) dU.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.lhz.directDownload) {
            this.lhu.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.aoI)) {
            this.lhu.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dU = this.lht.dU("video");
        if (dU == null || (distributeVideoView = (DistributeVideoView) dU.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dU = this.lht.dU("video");
        if (dU != null && (distributeVideoView = (DistributeVideoView) dU.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Ar;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dGL;
            if (!TextUtils.isEmpty(str)) {
                Ar = com.baidu.tieba.ad.download.d.bpg().Aq(str);
            } else {
                Ar = com.baidu.tieba.ad.download.d.bpg().Ar(scheme);
            }
            if (Ar == null) {
                Ar = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dGO);
                com.baidu.tieba.ad.download.d.bpg().a(Ar, null);
            }
            i(Ar);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.eYA = downloadCacheKey;
        bpa();
        this.eYB = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bpg().d(downloadCacheKey);
        if (d != null) {
            this.lhv.a(d.getCurrentState());
        } else {
            this.lhv.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.lhz != null || this.lhz.getAdvertAppInfo() != null) {
            str = this.lhz.getAdvertAppInfo().page;
        }
        this.lhB = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lhv, d, str);
        this.eYB = new com.baidu.tieba.ad.download.a.b(this.lhB);
        if (d.extra().getPercent() > 0) {
            this.lhB.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        boZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard lhG;

        public a(CriusAdCard criusAdCard) {
            this.lhG = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.dPv.showToast(R.string.neterror);
            } else if (this.lhG != null) {
                AdvertAppInfo advertAppInfo = this.lhG.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.aQj()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, i));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !com.baidu.adp.lib.util.j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.lhv) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.lhv, z);
                    CriusAdCardView.this.cZo();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.aoI;
                }
                if (k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dGN;
                }
                int c = r.c(CriusAdCardView.this.dPv, str, (CriusAdCardView.this.lhz == null || CriusAdCardView.this.lhz.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lhz.getAdvertAppInfo().dGL);
                if (CriusAdCardView.this.jrl != null) {
                    CriusAdCardView.this.jrl.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZo() {
        if (this.jrl != null) {
            this.jrl.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aN(this.dPv.getPageActivity(), advertAppInfo.dGO);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(c);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bpg().aw(this.dPv.getPageActivity(), advertAppInfo.dGO);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dGO);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dGM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dGL, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aQj()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dPv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
                aVar.we(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.lhv != null) {
                            CriusAdCardView.this.lhv.q(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.dPv).aUN();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aQi() != 0) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dPv.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dPv.getPageActivity()) && this.jrm != null) {
                this.jrm.b(advertAppInfo, i);
                if (this.lhv != null) {
                    this.lhv.q(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cZp() {
        boolean z = true;
        if (this.jjb != null && this.lht != null) {
            this.jjb.removeAllViews();
            com.baidu.b.a.d.a aVar = this.lht;
            Activity pageActivity = this.dPv.getPageActivity();
            com.baidu.b.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.lhu = aVar.a(pageActivity, aVar2, z);
            this.jjb.addView(this.lhu);
            an.setBackgroundResource(this.lhu, R.drawable.addresslist_item_bg);
            cZn();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cxF() {
        if (this.lht != null && ((TextView) this.lht.dU("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.dPv.getPageActivity()));
            cZp();
        }
    }
}
