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
import com.baidu.c.a.d.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.c;
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
    private com.baidu.c.a.c.a criusData;
    private LinearLayout gzT;
    protected String iiP;
    private com.baidu.c.a.d.a ijE;
    private ViewGroup ijF;
    private HeadImageView ijG;
    private ApkDownloadView ijH;
    private AdCloseView ijI;
    private JumpButton ijJ;
    private AdThreadCommentAndPraiseInfoLayout ijK;
    private CriusAdCard ijL;
    private boolean ijM;
    protected CustomMessageListener ijN;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ijM = true;
        this.ijN = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iiP) && CriusAdCardView.this.iiP.equals(downloadData.getId()) && CriusAdCardView.this.ijH != null) {
                    CriusAdCardView.this.ijH.s(downloadData);
                }
            }
        };
        this.ijE = new com.baidu.c.a.d.a();
        this.ijE.a(new a.InterfaceC0038a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0038a
            public void c(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.gHy != null) {
                        CriusAdCardView.this.gHy.b(e, null);
                    }
                } else if (CriusAdCardView.this.gHy != null) {
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
                    CriusAdCardView.this.gHy.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gzT = new LinearLayout(this.mContext.getPageActivity());
        this.gzT.setOrientation(1);
        return this.gzT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.k(this.ijF, d.f.addresslist_item_bg);
        this.ijE.i(this.mContext.getPageActivity(), i == 1);
        if (this.ijH != null) {
            this.ijH.onChangeSkinType(i);
        }
        if (this.ijI != null) {
            this.ijI.onChangeSkinType();
        }
        if (this.ijK != null) {
            this.ijK.onChangeSkinType();
        }
        al.k(this.ijJ, d.f.btn_focus_border_bg);
        al.d(this.ijJ, d.C0277d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.ijL = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bXe();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.ijG != null) {
            this.ijG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.age() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.bh(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.Xb()) {
            this.ijN.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.ijN);
            this.iiP = advertAppInfo.bwH;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.ijH.setData(c);
            this.ijH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.ijI != null && advertAppInfo != null && advertAppInfo.bwN != null && advertAppInfo.bwN.adCloseInfo != null && advertAppInfo.bwN.adCloseInfo.support_close.intValue() > 0) {
            this.ijI.setPage(getBusinessType());
            this.ijI.setData(advertAppInfo);
            this.ijI.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.ijI, 40, 40, 40, 120);
        }
    }

    private void bXc() {
        if (this.ijJ != null) {
            this.ijJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cL;
                    if (CriusAdCardView.this.criusData != null && (cL = CriusAdCardView.this.criusData.cL("viewbtn")) != null) {
                        if (!q.Cr(cL.adq) && CriusAdCardView.this.gHy != null) {
                            CriusAdCardView.this.gHy.b(cL.adr, cL.ads, null);
                        }
                        if (TextUtils.isEmpty(cL.adt)) {
                            int e = s.e(CriusAdCardView.this.mContext, cL.adq);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.gHy != null) {
                                CriusAdCardView.this.gHy.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.ly(cL.adt);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cL.adq);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.gHy != null) {
                                    CriusAdCardView.this.gHy.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.mContext).aaZ();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cL;
        if (this.ijK != null && (cL = this.criusData.cL("bottombar")) != null) {
            a(this.ijL.getAdvertAppInfo(), cL);
            this.ijK.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.ijK.setBarNameClickEnabled(false);
            this.ijK.setReplyTimeVisible(false);
            if (cL.adu != Integer.MIN_VALUE) {
                this.ijK.setShareClickable(true);
                this.ijK.setShareContainerBgGray(false);
            } else {
                this.ijK.setShareClickable(false);
                this.ijK.setShareContainerBgGray(true);
            }
            this.ijK.getCommentContainer().setOnClickListener(aVar);
            this.ijK.setNeedAddReplyIcon(true);
            this.ijK.setCommentNumEnable(true);
            this.ijK.setCommentClickable(true);
            this.ijK.setReplayContainerBgGray(true);
            this.ijK.setOnClickListener(aVar);
            this.ijK.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cL.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cL.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cL.adx;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cL.ady;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.ijL.getAdvertAppInfo();
                }
            });
            if (cL.adw != Integer.MIN_VALUE) {
                this.ijK.setAgreeClickable(true);
                this.ijK.setPraiseContainerBgGray(false);
            } else {
                this.ijK.setAgreeClickable(false);
                this.ijK.setPraiseContainerBgGray(true);
            }
            this.ijK.onChangeSkinType();
        }
    }

    public void a(bg bgVar, com.baidu.c.a.c.a aVar) {
        if (bgVar != null && aVar != null) {
            if (this.ijM || (bgVar.aak() <= 0 && bgVar.aao() <= 0)) {
                if (this.ijM) {
                    this.ijM = false;
                }
                bgVar.gr(aVar.adv);
                bgVar.gz(aVar.adw);
                bgVar.ah(aVar.adu);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.ijL != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.ijL.tailFrame);
            distributeVideoView.setChargeInfo(this.ijL.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bXd() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.ijL.getAdvertAppInfo();
        a aVar = new a(this.ijL);
        this.ijF.setOnClickListener(aVar);
        View cO = this.ijE.cO("head");
        if (cO != null && (cO instanceof HeadImageView)) {
            this.ijG = (HeadImageView) cO;
            setHeadLongClick(advertAppInfo);
        }
        View cO2 = this.ijE.cO("download");
        if (cO2 != null && (cO2 instanceof ApkDownloadView)) {
            this.ijH = (ApkDownloadView) cO2;
            this.ijH.q(this.mContext.getUniqueId());
            this.ijH.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cO3 = this.ijE.cO("closead");
        if (cO3 != null && (cO3 instanceof AdCloseView)) {
            this.ijI = (AdCloseView) cO3;
            k(advertAppInfo);
        }
        View cO4 = this.ijE.cO("viewbtn");
        if (cO4 != null && (cO4 instanceof JumpButton)) {
            this.ijJ = (JumpButton) cO4;
            bXc();
        }
        View cO5 = this.ijE.cO("bottombar");
        if (cO5 != null && (cO5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cO5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.ijK = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cP = this.ijE.cP("video");
        if (cP != null && (distributeVideoView = (DistributeVideoView) cP.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cP = this.ijE.cP("video");
        if (cP == null || (distributeVideoView = (DistributeVideoView) cP.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cP = this.ijE.cP("video");
        if (cP != null && (distributeVideoView = (DistributeVideoView) cP.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard ijR;

        public a(CriusAdCard criusAdCard) {
            this.ijR = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                CriusAdCardView.this.mContext.showToast(d.j.neterror);
            } else if (this.ijR != null) {
                AdvertAppInfo advertAppInfo = this.ijR.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.ijH;
                if (advertAppInfo != null && advertAppInfo.Xb()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.ijH, z);
                        if (CriusAdCardView.this.gHy != null) {
                            CriusAdCardView.this.gHy.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.adq;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bwF;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.gHy != null) {
                    CriusAdCardView.this.gHy.b(e, null);
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
                        g.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.aR(this.mContext.getPageActivity(), advertAppInfo.bwH);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.r(c);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwH);
        downloadData.setUrl(advertAppInfo.bwG);
        downloadData.setName(advertAppInfo.bwE);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwD, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.Xb()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ly(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.ijH != null) {
                            CriusAdCardView.this.ijH.p(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).aaZ();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.Xa() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHz != null) {
                this.gHz.b(advertAppInfo, i);
                if (this.ijH != null) {
                    this.ijH.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bXe() {
        if (this.gzT != null && this.ijE != null) {
            this.gzT.removeAllViews();
            this.ijF = this.ijE.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gzT.addView(this.ijF);
            al.k(this.ijF, d.f.addresslist_item_bg);
            bXd();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAk() {
        if (this.ijE != null && ((TextView) this.ijE.cP("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            bXe();
        }
    }
}
