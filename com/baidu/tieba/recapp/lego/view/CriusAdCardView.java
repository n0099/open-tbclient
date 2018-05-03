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
    private LinearLayout epe;
    protected String fYK;
    private ViewGroup fZA;
    private HeadImageView fZB;
    private ApkDownloadView fZC;
    private AdCloseView fZD;
    private JumpButton fZE;
    private AdThreadCommentAndPraiseInfoLayout fZF;
    private CriusAdCard fZG;
    private boolean fZH;
    protected CustomMessageListener fZI;
    private com.baidu.b.a.d.a fZz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fZH = true;
        this.fZI = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.fYK) && CriusAdCardView.this.fYK.equals(downloadData.getId()) && CriusAdCardView.this.fZC != null) {
                    CriusAdCardView.this.fZC.u(downloadData);
                }
            }
        };
        this.fZz = new com.baidu.b.a.d.a();
        this.fZz.a(new a.InterfaceC0043a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0043a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.adf, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.ewj != null) {
                        CriusAdCardView.this.ewj.b(e, null);
                    }
                } else if (CriusAdCardView.this.ewj != null) {
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
                    CriusAdCardView.this.ewj.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        this.epe = new LinearLayout(this.adf.getPageActivity());
        this.epe.setOrientation(1);
        return this.epe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ak.i(this.fZA, d.f.addresslist_item_bg);
        this.fZz.s(this.adf.getPageActivity(), i == 1);
        if (this.fZC != null) {
            this.fZC.onChangeSkinType(i);
        }
        if (this.fZD != null) {
            this.fZD.onChangeSkinType();
        }
        if (this.fZF != null) {
            this.fZF.onChangeSkinType();
        }
        ak.i(this.fZE, d.f.btn_focus_border_bg);
        ak.c(this.fZE, d.C0126d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.fZG = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bjF();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.fZB != null) {
            this.fZB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
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
            this.fZI.setTag(this.adf.getUniqueId());
            MessageManager.getInstance().registerListener(this.fZI);
            this.fYK = advertAppInfo.VU;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.fZC.setData(c);
            this.fZC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (this.fZD != null && advertAppInfo != null && advertAppInfo.Wb != null && advertAppInfo.Wb.Ww != null && advertAppInfo.Wb.Ww.support_close.intValue() > 0) {
            this.fZD.setPage(getBusinessType());
            this.fZD.setData(advertAppInfo);
            this.fZD.onChangeSkinType();
            l.a(this.adf.getPageActivity(), this.fZD, 40, 40, 40, 120);
        }
    }

    private void bjD() {
        if (this.fZE != null) {
            this.fZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final com.baidu.b.a.c.a bR;
                    if (CriusAdCardView.this.criusData != null && (bR = CriusAdCardView.this.criusData.bR("viewbtn")) != null) {
                        if (!q.sN(bR.LV) && CriusAdCardView.this.ewj != null) {
                            CriusAdCardView.this.ewj.b(bR.LW, bR.LX, null);
                        }
                        if (TextUtils.isEmpty(bR.LY)) {
                            int e = s.e(CriusAdCardView.this.adf, bR.LV);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.ewj != null) {
                                CriusAdCardView.this.ewj.b(e, null);
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
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.ewj != null) {
                                    CriusAdCardView.this.ewj.b(e2, null);
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
        if (this.fZF != null && (bR = this.criusData.bR("bottombar")) != null) {
            a(this.fZG.getAdvertAppInfo(), bR);
            this.fZF.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.fZF.setBarNameClickEnabled(false);
            this.fZF.setReplyTimeVisible(false);
            if (bR.LZ != Integer.MIN_VALUE) {
                this.fZF.setShareClickable(true);
                this.fZF.setShareContainerBgGray(false);
            } else {
                this.fZF.setShareClickable(false);
                this.fZF.setShareContainerBgGray(true);
            }
            this.fZF.getCommentContainer().setOnClickListener(aVar);
            this.fZF.setNeedAddReplyIcon(true);
            this.fZF.setCommentNumEnable(true);
            this.fZF.setCommentClickable(true);
            this.fZF.setReplayContainerBgGray(true);
            this.fZF.setOnClickListener(aVar);
            this.fZF.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
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
                    return CriusAdCardView.this.fZG.getAdvertAppInfo();
                }
            });
            if (bR.Mb != Integer.MIN_VALUE) {
                this.fZF.setAgreeClickable(true);
                this.fZF.setPraiseContainerBgGray(false);
            } else {
                this.fZF.setAgreeClickable(false);
                this.fZF.setPraiseContainerBgGray(true);
            }
            this.fZF.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.fZH || (bdVar.sZ() <= 0 && bdVar.tb() <= 0)) {
                if (this.fZH) {
                    this.fZH = false;
                }
                bdVar.bN(aVar.Ma);
                bdVar.bW(aVar.Mb);
                bdVar.o(aVar.LZ);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.fZG != null) {
            distributeVideoView.setPageContext(this.adf);
            distributeVideoView.setVideoTailFrameData(this.fZG.tailFrame);
            distributeVideoView.setChargeInfo(this.fZG.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.Vt);
            }
        }
    }

    private void bjE() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.fZG.getAdvertAppInfo();
        a aVar = new a(this.fZG);
        this.fZA.setOnClickListener(aVar);
        View bU = this.fZz.bU("head");
        if (bU != null && (bU instanceof HeadImageView)) {
            this.fZB = (HeadImageView) bU;
            setHeadLongClick(advertAppInfo);
        }
        View bU2 = this.fZz.bU("download");
        if (bU2 != null && (bU2 instanceof ApkDownloadView)) {
            this.fZC = (ApkDownloadView) bU2;
            this.fZC.p(this.adf.getUniqueId());
            this.fZC.setOnClickListener(aVar);
            h(advertAppInfo);
        }
        View bU3 = this.fZz.bU("closead");
        if (bU3 != null && (bU3 instanceof AdCloseView)) {
            this.fZD = (AdCloseView) bU3;
            i(advertAppInfo);
        }
        View bU4 = this.fZz.bU("viewbtn");
        if (bU4 != null && (bU4 instanceof JumpButton)) {
            this.fZE = (JumpButton) bU4;
            bjD();
        }
        View bU5 = this.fZz.bU("bottombar");
        if (bU5 != null && (bU5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bU5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.fZF = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bV = this.fZz.bV("video");
        if (bV != null && (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bV = this.fZz.bV("video");
        if (bV == null || (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bV = this.fZz.bV("video");
        if (bV != null && (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard fZM;

        public a(CriusAdCard criusAdCard) {
            this.fZM = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                CriusAdCardView.this.adf.showToast(d.k.neterror);
            } else if (this.fZM != null) {
                AdvertAppInfo advertAppInfo = this.fZM.getAdvertAppInfo();
                boolean z = view2 == CriusAdCardView.this.fZC;
                if (advertAppInfo != null && advertAppInfo.qt()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.fZC, z);
                        if (CriusAdCardView.this.ewj != null) {
                            CriusAdCardView.this.ewj.b(3, null);
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
                if (CriusAdCardView.this.ewj != null) {
                    CriusAdCardView.this.ewj.b(e, null);
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
                        if (CriusAdCardView.this.fZC != null) {
                            CriusAdCardView.this.fZC.s(CriusAdCardView.this.c(advertAppInfo, i));
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
            if (!this.mPermissionJudgePolicy.v(this.adf.getPageActivity()) && this.ewk != null) {
                this.ewk.b(advertAppInfo, i);
                if (this.fZC != null) {
                    this.fZC.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bjF() {
        if (this.epe != null && this.fZz != null) {
            this.epe.removeAllViews();
            this.fZA = this.fZz.a(this.adf.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.epe.addView(this.fZA);
            ak.i(this.fZA, d.f.addresslist_item_bg);
            bjE();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLd() {
        if (this.fZz != null && ((TextView) this.fZz.bV("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.ai(this.adf.getPageActivity()));
            bjF();
        }
    }
}
