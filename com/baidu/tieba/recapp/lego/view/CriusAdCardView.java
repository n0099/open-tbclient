package com.baidu.tieba.recapp.lego.view;

import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.d.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.q;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.b.a.c.a criusData;
    private LinearLayout eph;
    protected String fYN;
    private com.baidu.b.a.d.a fZC;
    private ViewGroup fZD;
    private HeadImageView fZE;
    private ApkDownloadView fZF;
    private AdCloseView fZG;
    private JumpButton fZH;
    private AdThreadCommentAndPraiseInfoLayout fZI;
    private CriusAdCard fZJ;
    private boolean fZK;
    protected CustomMessageListener fZL;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fZK = true;
        this.fZL = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.fYN) && CriusAdCardView.this.fYN.equals(downloadData.getId()) && CriusAdCardView.this.fZF != null) {
                    CriusAdCardView.this.fZF.u(downloadData);
                }
            }
        };
        this.fZC = new com.baidu.b.a.d.a();
        this.fZC.a(new a.InterfaceC0043a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0043a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.adf, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.ewm != null) {
                        CriusAdCardView.this.ewm.b(e, null);
                    }
                } else if (CriusAdCardView.this.ewm != null) {
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
                    CriusAdCardView.this.ewm.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        this.eph = new LinearLayout(this.adf.getPageActivity());
        this.eph.setOrientation(1);
        return this.eph;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ak.i(this.fZD, d.f.addresslist_item_bg);
        this.fZC.s(this.adf.getPageActivity(), i == 1);
        if (this.fZF != null) {
            this.fZF.onChangeSkinType(i);
        }
        if (this.fZG != null) {
            this.fZG.onChangeSkinType();
        }
        if (this.fZI != null) {
            this.fZI.onChangeSkinType();
        }
        ak.i(this.fZH, d.f.btn_focus_border_bg);
        ak.c(this.fZH, d.C0126d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.fZJ = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bjF();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.fZE != null) {
            this.fZE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.yl() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aB(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.adf.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void h(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.qt()) {
            this.fZL.setTag(this.adf.getUniqueId());
            MessageManager.getInstance().registerListener(this.fZL);
            this.fYN = advertAppInfo.VU;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.fZF.setData(c);
            this.fZF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (this.fZG != null && advertAppInfo != null && advertAppInfo.Wb != null && advertAppInfo.Wb.Ww != null && advertAppInfo.Wb.Ww.support_close.intValue() > 0) {
            this.fZG.setPage(getBusinessType());
            this.fZG.setData(advertAppInfo);
            this.fZG.onChangeSkinType();
            l.a(this.adf.getPageActivity(), this.fZG, 40, 40, 40, 120);
        }
    }

    private void bjD() {
        if (this.fZH != null) {
            this.fZH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final com.baidu.b.a.c.a bR;
                    if (CriusAdCardView.this.criusData != null && (bR = CriusAdCardView.this.criusData.bR("viewbtn")) != null) {
                        if (!q.sN(bR.LV) && CriusAdCardView.this.ewm != null) {
                            CriusAdCardView.this.ewm.b(bR.LW, bR.LX, null);
                        }
                        if (TextUtils.isEmpty(bR.LY)) {
                            int e = s.e(CriusAdCardView.this.adf, bR.LV);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.ewm != null) {
                                CriusAdCardView.this.ewm.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.adf.getPageActivity());
                        aVar.dc(bR.LY);
                        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.adf, bR.LV);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.ewm != null) {
                                    CriusAdCardView.this.ewm.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.adf).tD();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bR;
        if (this.fZI != null && (bR = this.criusData.bR("bottombar")) != null) {
            a(this.fZJ.getAdvertAppInfo(), bR);
            this.fZI.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.fZI.setBarNameClickEnabled(false);
            this.fZI.setReplyTimeVisible(false);
            if (bR.LZ != Integer.MIN_VALUE) {
                this.fZI.setShareClickable(true);
                this.fZI.setShareContainerBgGray(false);
            } else {
                this.fZI.setShareClickable(false);
                this.fZI.setShareContainerBgGray(true);
            }
            this.fZI.getCommentContainer().setOnClickListener(aVar);
            this.fZI.setNeedAddReplyIcon(true);
            this.fZI.setCommentNumEnable(true);
            this.fZI.setCommentClickable(true);
            this.fZI.setReplayContainerBgGray(true);
            this.fZI.setOnClickListener(aVar);
            this.fZI.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return bR.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return bR.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return bR.Mc;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bR.Md;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.fZJ.getAdvertAppInfo();
                }
            });
            if (bR.Mb != Integer.MIN_VALUE) {
                this.fZI.setAgreeClickable(true);
                this.fZI.setPraiseContainerBgGray(false);
            } else {
                this.fZI.setAgreeClickable(false);
                this.fZI.setPraiseContainerBgGray(true);
            }
            this.fZI.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.fZK || (bdVar.sZ() <= 0 && bdVar.tb() <= 0)) {
                if (this.fZK) {
                    this.fZK = false;
                }
                bdVar.bO(aVar.Ma);
                bdVar.bX(aVar.Mb);
                bdVar.o(aVar.LZ);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.fZJ != null) {
            distributeVideoView.setPageContext(this.adf);
            distributeVideoView.setVideoTailFrameData(this.fZJ.tailFrame);
            distributeVideoView.setChargeInfo(this.fZJ.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.Vt);
            }
        }
    }

    private void bjE() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.fZJ.getAdvertAppInfo();
        a aVar = new a(this.fZJ);
        this.fZD.setOnClickListener(aVar);
        View bU = this.fZC.bU("head");
        if (bU != null && (bU instanceof HeadImageView)) {
            this.fZE = (HeadImageView) bU;
            setHeadLongClick(advertAppInfo);
        }
        View bU2 = this.fZC.bU("download");
        if (bU2 != null && (bU2 instanceof ApkDownloadView)) {
            this.fZF = (ApkDownloadView) bU2;
            this.fZF.p(this.adf.getUniqueId());
            this.fZF.setOnClickListener(aVar);
            h(advertAppInfo);
        }
        View bU3 = this.fZC.bU("closead");
        if (bU3 != null && (bU3 instanceof AdCloseView)) {
            this.fZG = (AdCloseView) bU3;
            i(advertAppInfo);
        }
        View bU4 = this.fZC.bU("viewbtn");
        if (bU4 != null && (bU4 instanceof JumpButton)) {
            this.fZH = (JumpButton) bU4;
            bjD();
        }
        View bU5 = this.fZC.bU("bottombar");
        if (bU5 != null && (bU5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bU5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.fZI = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bV = this.fZC.bV("video");
        if (bV != null && (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bV = this.fZC.bV("video");
        if (bV == null || (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bV = this.fZC.bV("video");
        if (bV != null && (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard fZP;

        public a(CriusAdCard criusAdCard) {
            this.fZP = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                CriusAdCardView.this.adf.showToast(d.k.neterror);
            } else if (this.fZP != null) {
                AdvertAppInfo advertAppInfo = this.fZP.getAdvertAppInfo();
                boolean z = view2 == CriusAdCardView.this.fZF;
                if (advertAppInfo != null && advertAppInfo.qt()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.fZF, z);
                        if (CriusAdCardView.this.ewm != null) {
                            CriusAdCardView.this.ewm.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, g, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.LV;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.VS;
                }
                int e = s.e(CriusAdCardView.this.adf, str);
                if (CriusAdCardView.this.ewm != null) {
                    CriusAdCardView.this.ewm.b(e, null);
                }
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null && apkDownloadView != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        g.e(advertAppInfo);
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.aj(this.adf.getPageActivity(), advertAppInfo.VU);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.h(c);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.VU);
        downloadData.setUrl(advertAppInfo.VT);
        downloadData.setName(advertAppInfo.VQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.VP, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.adf.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.adf.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.fZF != null) {
                            CriusAdCardView.this.fZF.s(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.adf).tD();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.qs() != 0) {
                l.showToast(this.adf.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.wu();
            this.mPermissionJudgePolicy.c(this.adf.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.adf.getPageActivity()) && this.ewn != null) {
                this.ewn.b(advertAppInfo, i);
                if (this.fZF != null) {
                    this.fZF.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bjF() {
        if (this.eph != null && this.fZC != null) {
            this.eph.removeAllViews();
            this.fZD = this.fZC.a(this.adf.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eph.addView(this.fZD);
            ak.i(this.fZD, d.f.addresslist_item_bg);
            bjE();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLd() {
        if (this.fZC != null && ((TextView) this.fZC.bV("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.ai(this.adf.getPageActivity()));
            bjF();
        }
    }
}
