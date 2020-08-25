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
    private DownloadCacheKey fov;
    private d fow;
    private LinearLayout jJv;
    private HeadImageView kYw;
    protected String lEs;
    private com.baidu.g.a.d.a lFj;
    private ViewGroup lFk;
    private ApkDownloadView lFl;
    private AdCloseView lFm;
    private JumpButton lFn;
    private AdThreadCommentAndPraiseInfoLayout lFo;
    private CriusAdCard lFp;
    private boolean lFq;
    private com.baidu.tieba.ad.browser.newstyle.view.a lFr;
    protected CustomMessageListener lFs;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lFq = true;
        this.fow = null;
        this.lFs = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.lEs) && CriusAdCardView.this.lEs.equals(downloadData.getId()) && CriusAdCardView.this.lFl != null) {
                    CriusAdCardView.this.lFl.t(downloadData);
                }
            }
        };
        this.lFj = new com.baidu.g.a.d.a(tbPageContext);
        this.lFj.a(new a.InterfaceC0129a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.g.a.d.a.InterfaceC0129a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                String str4 = (CriusAdCardView.this.lFp == null || CriusAdCardView.this.lFp.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFp.getAdvertAppInfo().dWf;
                int c = (CriusAdCardView.this.lFp.directDownload || !CriusAdCardView.this.lFp.getAdvertAppInfo().bcw()) ? s.c(CriusAdCardView.this.efn, str, str4) : s.d(CriusAdCardView.this.efn, str, str4);
                if (c == 1 || c == 2) {
                    if (CriusAdCardView.this.jPk != null) {
                        CriusAdCardView.this.jPk.d(c, null);
                    }
                } else if (CriusAdCardView.this.jPk != null) {
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
                    CriusAdCardView.this.jPk.a(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMp() {
        this.jJv = new LinearLayout(this.efn.getPageActivity());
        this.jJv.setOrientation(1);
        return this.jJv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ap.setBackgroundResource(this.lFk, R.drawable.addresslist_item_bg);
        this.lFj.h(this.efn.getPageActivity(), i == 1 || i == 4);
        if (this.lFl != null) {
            this.lFl.onChangeSkinType(i);
        }
        if (this.lFm != null) {
            this.lFm.onChangeSkinType();
        }
        if (this.lFo != null) {
            this.lFo.onChangeSkinType();
        }
        ap.setBackgroundResource(this.lFn, R.drawable.btn_focus_border_bg);
        ap.setViewTextColor(this.lFn, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(CriusAdCard criusAdCard) {
        this.lFp = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            dnE();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bAY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bAZ();
    }

    private void bAY() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().a(this.fov, this.fow);
        }
    }

    private void bAZ() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().b(this.fov, this.fow);
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.kYw != null) {
            this.kYw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.bmw() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.efn.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void a(AdvertAppInfo advertAppInfo, a aVar) {
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            if (!this.lFp.directDownload) {
                a(this.lFp, advertAppInfo);
                this.lFl.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                    @Override // com.baidu.tieba.ad.download.mvp.b.a
                    public boolean bC(View view) {
                        CriusAdCardView.this.dnD();
                        return false;
                    }
                });
            } else {
                this.lFl.setOnClickListener(aVar);
            }
            this.lFs.setTag(this.efn.getUniqueId());
            MessageManager.getInstance().registerListener(this.lFs);
            this.lEs = advertAppInfo.dWi;
            DownloadData b = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            setDownloadDataStatus(b);
            this.lFl.setData(b);
            this.lFl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void setDownloadDataStatus(DownloadData downloadData) {
        if (this.lFp.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lFl.getDownloadStatus());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.lFm != null && advertAppInfo != null && advertAppInfo.dWo != null && advertAppInfo.dWo.adCloseInfo != null && advertAppInfo.dWo.adCloseInfo.support_close.intValue() > 0) {
            this.lFm.setPage(getBusinessType());
            this.lFm.setData(advertAppInfo);
            this.lFm.onChangeSkinType();
            if (this.lFm instanceof AdCriusCloseView) {
                ((AdCriusCloseView) this.lFm).resetSkin(getBusinessType());
            }
            l.addToParentArea(this.efn.getPageActivity(), this.lFm, 40, 40, 40, 120);
        }
    }

    private void dnB() {
        if (this.lFn != null) {
            this.lFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.g.a.c.a fi;
                    if (CriusAdCardView.this.criusData != null && (fi = CriusAdCardView.this.criusData.fi("viewbtn")) != null) {
                        if (!u.Pk(fi.atC) && CriusAdCardView.this.jPk != null) {
                            CriusAdCardView.this.jPk.a(fi.atD, fi.atE, null);
                        }
                        if (TextUtils.isEmpty(fi.atF)) {
                            int c = s.c(CriusAdCardView.this.efn, fi.atC, (CriusAdCardView.this.lFp == null || CriusAdCardView.this.lFp.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFp.getAdvertAppInfo().dWf);
                            if ((c == 1 || c == 2) && CriusAdCardView.this.jPk != null) {
                                CriusAdCardView.this.jPk.d(c, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.efn.getPageActivity());
                        aVar.zz(fi.atF);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c2 = s.c(CriusAdCardView.this.efn, fi.atC, (CriusAdCardView.this.lFp == null || CriusAdCardView.this.lFp.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFp.getAdvertAppInfo().dWf);
                                if ((c2 == 1 || c2 == 2) && CriusAdCardView.this.jPk != null) {
                                    CriusAdCardView.this.jPk.d(c2, null);
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
                        aVar.b(CriusAdCardView.this.efn).bhg();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        if (this.lFo != null) {
            final com.baidu.g.a.c.a fi = this.criusData.fi("bottombar");
            if (fi != null) {
                a(this.lFp.getAdvertAppInfo(), fi);
                this.lFo.setType(TbadkCoreApplication.getInst().getCardShowType());
                this.lFo.setBarNameClickEnabled(false);
                this.lFo.setReplyTimeVisible(false);
                if (fi.atG != Integer.MIN_VALUE) {
                    this.lFo.setShareClickable(true);
                    this.lFo.setShareContainerBgGray(false);
                } else {
                    this.lFo.setShareClickable(false);
                    this.lFo.setShareContainerBgGray(true);
                }
                this.lFo.getCommentContainer().setOnClickListener(aVar);
                this.lFo.setNeedAddReplyIcon(true);
                this.lFo.setCommentNumEnable(true);
                this.lFo.setCommentClickable(true);
                this.lFo.setReplayContainerBgGray(true);
                this.lFo.setOnClickListener(aVar);
                this.lFo.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tieba.recapp.c.a
                    public String getTitle() {
                        return fi.shareTitle;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getAbstract() {
                        return fi.shareContent;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getImageUrl() {
                        return fi.atJ;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public String getShareLink() {
                        return fi.atK;
                    }

                    @Override // com.baidu.tieba.recapp.c.a
                    public AdvertAppInfo getThreadData() {
                        return CriusAdCardView.this.lFp.getAdvertAppInfo();
                    }
                });
                if (fi.atI != Integer.MIN_VALUE) {
                    this.lFo.setAgreeClickable(true);
                    this.lFo.setPraiseContainerBgGray(false);
                } else {
                    this.lFo.setAgreeClickable(false);
                    this.lFo.setPraiseContainerBgGray(true);
                }
                this.lFo.onChangeSkinType();
            }
            if (this.lFo != null) {
                if (this.lFm == null) {
                    this.lFm = new AdCloseView(this.efn.getPageActivity());
                }
                if (this.lFm.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lFm.getParent()).removeView(this.lFm);
                }
                this.lFo.addAdMoreView(this.lFm);
                k(this.lFp.getAdvertAppInfo());
            }
        }
    }

    public void a(bw bwVar, com.baidu.g.a.c.a aVar) {
        if (bwVar != null && aVar != null) {
            if (this.lFq || (bwVar.bgc() <= 0 && bwVar.bgg() <= 0)) {
                if (this.lFq) {
                    this.lFq = false;
                }
                bwVar.ng(aVar.atH);
                bwVar.no(aVar.atI);
                bwVar.cD(aVar.atG);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.lFp != null) {
            distributeVideoView.setPageContext(this.efn);
            distributeVideoView.setVideoTailFrameData(this.lFp.tailFrame);
            distributeVideoView.setChargeInfo(this.lFp.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void dnC() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.lFp.getAdvertAppInfo();
        a aVar = new a(this.lFp);
        setCriusViewClick(aVar);
        View fl = this.lFj.fl("head");
        if (fl != null && (fl instanceof HeadImageView)) {
            this.kYw = (HeadImageView) fl;
            setHeadLongClick(advertAppInfo);
        }
        View fl2 = this.lFj.fl("download");
        if (fl2 != null && (fl2 instanceof ApkDownloadView)) {
            this.lFl = (ApkDownloadView) fl2;
            this.lFl.y(this.efn.getUniqueId());
            a(advertAppInfo, aVar);
        }
        View fl3 = this.lFj.fl("closead");
        if (fl3 != null && (fl3 instanceof AdCloseView)) {
            this.lFm = (AdCloseView) fl3;
            k(advertAppInfo);
        }
        View fl4 = this.lFj.fl("viewbtn");
        if (fl4 != null && (fl4 instanceof JumpButton)) {
            this.lFn = (JumpButton) fl4;
            dnB();
        }
        View fl5 = this.lFj.fl("bottombar");
        if (fl5 != null && (fl5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) fl5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.lFo = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View fm = this.lFj.fm("video");
        if (fm != null && (distributeVideoView = (DistributeVideoView) fm.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    private void setCriusViewClick(a aVar) {
        if (this.lFp.directDownload) {
            this.lFk.setOnClickListener(aVar);
        } else if (TextUtils.isEmpty(this.criusData.atC)) {
            this.lFk.setOnClickListener(aVar);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View fm = this.lFj.fm("video");
        if (fm == null || (distributeVideoView = (DistributeVideoView) fm.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View fm = this.lFj.fm("video");
        if (fm != null && (distributeVideoView = (DistributeVideoView) fm.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    private void a(CriusAdCard criusAdCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Dw;
        if (criusAdCard != null && advertAppInfo != null) {
            String scheme = criusAdCard.getScheme();
            String str = advertAppInfo.dWf;
            if (!TextUtils.isEmpty(str)) {
                Dw = com.baidu.tieba.ad.download.d.bBf().Dv(str);
            } else {
                Dw = com.baidu.tieba.ad.download.d.bBf().Dw(scheme);
            }
            if (Dw == null) {
                Dw = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dWi);
                com.baidu.tieba.ad.download.d.bBf().a(Dw, null);
            }
            i(Dw);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        this.fov = downloadCacheKey;
        bAZ();
        this.fow = null;
        AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
        if (d != null) {
            this.lFl.a(d.getCurrentState());
        } else {
            this.lFl.a(DownloadStatus.STATUS_NONE);
        }
        String str = "";
        if (this.lFp != null || this.lFp.getAdvertAppInfo() != null) {
            str = this.lFp.getAdvertAppInfo().page;
        }
        this.lFr = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lFl, d, str);
        this.fow = new com.baidu.tieba.ad.download.a.b(this.lFr);
        if (d.extra().getPercent() > 0) {
            this.lFr.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
        }
        bAY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard lFw;

        public a(CriusAdCard criusAdCard) {
            this.lFw = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.isNetworkAvailableForImmediately()) {
                CriusAdCardView.this.efn.showToast(R.string.neterror);
            } else if (this.lFw != null) {
                AdvertAppInfo advertAppInfo = this.lFw.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.bcw()) {
                    int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.b(advertAppInfo, i));
                    if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.lFl) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, i, CriusAdCardView.this.lFl, z);
                    CriusAdCardView.this.dnD();
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.atC;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.dWh;
                }
                int c = s.c(CriusAdCardView.this.efn, str, (CriusAdCardView.this.lFp == null || CriusAdCardView.this.lFp.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.lFp.getAdvertAppInfo().dWf);
                if (CriusAdCardView.this.jPk != null) {
                    CriusAdCardView.this.jPk.d(c, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnD() {
        if (this.jPk != null) {
            this.jPk.d(3, null);
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
                    com.baidu.tieba.recapp.download.h.aQ(this.efn.getPageActivity(), advertAppInfo.dWi);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.s(b);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bBf().az(this.efn.getPageActivity(), advertAppInfo.dWi);
                    return;
            }
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWf, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
                aVar.zz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.lFl != null) {
                            CriusAdCardView.this.lFl.q(CriusAdCardView.this.b(advertAppInfo, i));
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
                aVar.b(this.efn).bhg();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.bcv() != 0) {
                l.showToast(this.efn.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.efn.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.efn.getPageActivity()) && this.jPl != null) {
                this.jPl.c(advertAppInfo, i);
                if (this.lFl != null) {
                    this.lFl.q(b(advertAppInfo, i));
                }
            }
        }
    }

    private void dnE() {
        boolean z = true;
        if (this.jJv != null && this.lFj != null) {
            this.jJv.removeAllViews();
            com.baidu.g.a.d.a aVar = this.lFj;
            Activity pageActivity = this.efn.getPageActivity();
            com.baidu.g.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.lFk = aVar.a(pageActivity, aVar2, z);
            this.jJv.addView(this.lFk);
            ap.setBackgroundResource(this.lFk, R.drawable.addresslist_item_bg);
            dnC();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cMv() {
        if (this.lFj != null && ((TextView) this.lFj.fm("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.getEquipmentDensity(this.efn.getPageActivity()));
            dnE();
        }
    }
}
