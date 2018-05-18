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
    private LinearLayout eqn;
    protected String fZQ;
    private com.baidu.b.a.d.a gaF;
    private ViewGroup gaG;
    private HeadImageView gaH;
    private ApkDownloadView gaI;
    private AdCloseView gaJ;
    private JumpButton gaK;
    private AdThreadCommentAndPraiseInfoLayout gaL;
    private CriusAdCard gaM;
    private boolean gaN;
    protected CustomMessageListener gaO;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gaN = true;
        this.gaO = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.fZQ) && CriusAdCardView.this.fZQ.equals(downloadData.getId()) && CriusAdCardView.this.gaI != null) {
                    CriusAdCardView.this.gaI.u(downloadData);
                }
            }
        };
        this.gaF = new com.baidu.b.a.d.a();
        this.gaF.a(new a.InterfaceC0043a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0043a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.exr != null) {
                        CriusAdCardView.this.exr.b(e, null);
                    }
                } else if (CriusAdCardView.this.exr != null) {
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
                    CriusAdCardView.this.exr.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKT() {
        this.eqn = new LinearLayout(this.mContext.getPageActivity());
        this.eqn.setOrientation(1);
        return this.eqn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        ak.i(this.gaG, d.f.addresslist_item_bg);
        this.gaF.s(this.mContext.getPageActivity(), i == 1);
        if (this.gaI != null) {
            this.gaI.onChangeSkinType(i);
        }
        if (this.gaJ != null) {
            this.gaJ.onChangeSkinType();
        }
        if (this.gaL != null) {
            this.gaL.onChangeSkinType();
        }
        ak.i(this.gaK, d.f.btn_focus_border_bg);
        ak.c(this.gaK, d.C0126d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gaM = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bjE();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gaH != null) {
            this.gaH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.yk() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aB(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void h(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.qs()) {
            this.gaO.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gaO);
            this.fZQ = advertAppInfo.VQ;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gaI.setData(c);
            this.gaI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (this.gaJ != null && advertAppInfo != null && advertAppInfo.VX != null && advertAppInfo.VX.Ws != null && advertAppInfo.VX.Ws.support_close.intValue() > 0) {
            this.gaJ.setPage(getBusinessType());
            this.gaJ.setData(advertAppInfo);
            this.gaJ.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.gaJ, 40, 40, 40, 120);
        }
    }

    private void bjC() {
        if (this.gaK != null) {
            this.gaK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final com.baidu.b.a.c.a bR;
                    if (CriusAdCardView.this.criusData != null && (bR = CriusAdCardView.this.criusData.bR("viewbtn")) != null) {
                        if (!q.sQ(bR.LR) && CriusAdCardView.this.exr != null) {
                            CriusAdCardView.this.exr.b(bR.LS, bR.LT, null);
                        }
                        if (TextUtils.isEmpty(bR.LU)) {
                            int e = s.e(CriusAdCardView.this.mContext, bR.LR);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.exr != null) {
                                CriusAdCardView.this.exr.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.dc(bR.LU);
                        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, bR.LR);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.exr != null) {
                                    CriusAdCardView.this.exr.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).tC();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bR;
        if (this.gaL != null && (bR = this.criusData.bR("bottombar")) != null) {
            a(this.gaM.getAdvertAppInfo(), bR);
            this.gaL.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gaL.setBarNameClickEnabled(false);
            this.gaL.setReplyTimeVisible(false);
            if (bR.LV != Integer.MIN_VALUE) {
                this.gaL.setShareClickable(true);
                this.gaL.setShareContainerBgGray(false);
            } else {
                this.gaL.setShareClickable(false);
                this.gaL.setShareContainerBgGray(true);
            }
            this.gaL.getCommentContainer().setOnClickListener(aVar);
            this.gaL.setNeedAddReplyIcon(true);
            this.gaL.setCommentNumEnable(true);
            this.gaL.setCommentClickable(true);
            this.gaL.setReplayContainerBgGray(true);
            this.gaL.setOnClickListener(aVar);
            this.gaL.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
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
                    return bR.LY;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bR.LZ;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gaM.getAdvertAppInfo();
                }
            });
            if (bR.LX != Integer.MIN_VALUE) {
                this.gaL.setAgreeClickable(true);
                this.gaL.setPraiseContainerBgGray(false);
            } else {
                this.gaL.setAgreeClickable(false);
                this.gaL.setPraiseContainerBgGray(true);
            }
            this.gaL.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.gaN || (bdVar.sY() <= 0 && bdVar.ta() <= 0)) {
                if (this.gaN) {
                    this.gaN = false;
                }
                bdVar.bO(aVar.LW);
                bdVar.bX(aVar.LX);
                bdVar.o(aVar.LV);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gaM != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gaM.tailFrame);
            distributeVideoView.setChargeInfo(this.gaM.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.Vp);
            }
        }
    }

    private void bjD() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gaM.getAdvertAppInfo();
        a aVar = new a(this.gaM);
        this.gaG.setOnClickListener(aVar);
        View bU = this.gaF.bU("head");
        if (bU != null && (bU instanceof HeadImageView)) {
            this.gaH = (HeadImageView) bU;
            setHeadLongClick(advertAppInfo);
        }
        View bU2 = this.gaF.bU("download");
        if (bU2 != null && (bU2 instanceof ApkDownloadView)) {
            this.gaI = (ApkDownloadView) bU2;
            this.gaI.p(this.mContext.getUniqueId());
            this.gaI.setOnClickListener(aVar);
            h(advertAppInfo);
        }
        View bU3 = this.gaF.bU("closead");
        if (bU3 != null && (bU3 instanceof AdCloseView)) {
            this.gaJ = (AdCloseView) bU3;
            i(advertAppInfo);
        }
        View bU4 = this.gaF.bU("viewbtn");
        if (bU4 != null && (bU4 instanceof JumpButton)) {
            this.gaK = (JumpButton) bU4;
            bjC();
        }
        View bU5 = this.gaF.bU("bottombar");
        if (bU5 != null && (bU5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bU5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gaL = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bV = this.gaF.bV("video");
        if (bV != null && (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bV = this.gaF.bV("video");
        if (bV == null || (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bV = this.gaF.bV("video");
        if (bV != null && (distributeVideoView = (DistributeVideoView) bV.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gaS;

        public a(CriusAdCard criusAdCard) {
            this.gaS = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                CriusAdCardView.this.mContext.showToast(d.k.neterror);
            } else if (this.gaS != null) {
                AdvertAppInfo advertAppInfo = this.gaS.getAdvertAppInfo();
                boolean z = view2 == CriusAdCardView.this.gaI;
                if (advertAppInfo != null && advertAppInfo.qs()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.gP() || j.gQ()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.gaI, z);
                        if (CriusAdCardView.this.exr != null) {
                            CriusAdCardView.this.exr.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, g, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.LR;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.VO;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.exr != null) {
                    CriusAdCardView.this.exr.b(e, null);
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
                    g.aj(this.mContext.getPageActivity(), advertAppInfo.VQ);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.VQ);
        downloadData.setUrl(advertAppInfo.VP);
        downloadData.setName(advertAppInfo.VM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.VL, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qs()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gaI != null) {
                            CriusAdCardView.this.gaI.s(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).tC();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.qr() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.wt();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.mContext.getPageActivity()) && this.exs != null) {
                this.exs.b(advertAppInfo, i);
                if (this.gaI != null) {
                    this.gaI.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bjE() {
        if (this.eqn != null && this.gaF != null) {
            this.eqn.removeAllViews();
            this.gaG = this.gaF.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eqn.addView(this.gaG);
            ak.i(this.gaG, d.f.addresslist_item_bg);
            bjD();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLc() {
        if (this.gaF != null && ((TextView) this.gaF.bV("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.ai(this.mContext.getPageActivity()));
            bjE();
        }
    }
}
