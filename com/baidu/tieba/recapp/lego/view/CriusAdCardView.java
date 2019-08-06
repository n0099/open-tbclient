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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private LinearLayout gYa;
    protected String iIN;
    private com.baidu.c.a.d.a iJC;
    private ViewGroup iJD;
    private HeadImageView iJE;
    private ApkDownloadView iJF;
    private AdCloseView iJG;
    private JumpButton iJH;
    private AdThreadCommentAndPraiseInfoLayout iJI;
    private CriusAdCard iJJ;
    private boolean iJK;
    protected CustomMessageListener iJL;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iJK = true;
        this.iJL = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iIN) && CriusAdCardView.this.iIN.equals(downloadData.getId()) && CriusAdCardView.this.iJF != null) {
                    CriusAdCardView.this.iJF.s(downloadData);
                }
            }
        };
        this.iJC = new com.baidu.c.a.d.a();
        this.iJC.a(new a.InterfaceC0037a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0037a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.hfO != null) {
                        CriusAdCardView.this.hfO.b(e, null);
                    }
                } else if (CriusAdCardView.this.hfO != null) {
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
                    CriusAdCardView.this.hfO.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKJ() {
        this.gYa = new LinearLayout(this.mContext.getPageActivity());
        this.gYa.setOrientation(1);
        return this.gYa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.k(this.iJD, R.drawable.addresslist_item_bg);
        this.iJC.g(this.mContext.getPageActivity(), i == 1);
        if (this.iJF != null) {
            this.iJF.onChangeSkinType(i);
        }
        if (this.iJG != null) {
            this.iJG.onChangeSkinType();
        }
        if (this.iJI != null) {
            this.iJI.onChangeSkinType();
        }
        am.k(this.iJH, R.drawable.btn_focus_border_bg);
        am.f(this.iJH, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iJJ = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            ciq();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iJE != null) {
            this.iJE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.amh() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aS(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.acI()) {
            this.iJL.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.iJL);
            this.iIN = advertAppInfo.bEY;
            DownloadData c = c(advertAppInfo, b.f(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iJF.setData(c);
            this.iJF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.iJG != null && advertAppInfo != null && advertAppInfo.bFe != null && advertAppInfo.bFe.adCloseInfo != null && advertAppInfo.bFe.adCloseInfo.support_close.intValue() > 0) {
            this.iJG.setPage(getBusinessType());
            this.iJG.setData(advertAppInfo);
            this.iJG.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.iJG, 40, 40, 40, 120);
        }
    }

    private void cio() {
        if (this.iJH != null) {
            this.iJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cz;
                    if (CriusAdCardView.this.criusData != null && (cz = CriusAdCardView.this.criusData.cz("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.EC(cz.abH) && CriusAdCardView.this.hfO != null) {
                            CriusAdCardView.this.hfO.b(cz.abI, cz.abJ, null);
                        }
                        if (TextUtils.isEmpty(cz.abK)) {
                            int e = s.e(CriusAdCardView.this.mContext, cz.abH);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.hfO != null) {
                                CriusAdCardView.this.hfO.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.mO(cz.abK);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cz.abH);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.hfO != null) {
                                    CriusAdCardView.this.hfO.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.mContext).agK();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cz;
        if (this.iJI != null && (cz = this.criusData.cz("bottombar")) != null) {
            a(this.iJJ.getAdvertAppInfo(), cz);
            this.iJI.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iJI.setBarNameClickEnabled(false);
            this.iJI.setReplyTimeVisible(false);
            if (cz.abL != Integer.MIN_VALUE) {
                this.iJI.setShareClickable(true);
                this.iJI.setShareContainerBgGray(false);
            } else {
                this.iJI.setShareClickable(false);
                this.iJI.setShareContainerBgGray(true);
            }
            this.iJI.getCommentContainer().setOnClickListener(aVar);
            this.iJI.setNeedAddReplyIcon(true);
            this.iJI.setCommentNumEnable(true);
            this.iJI.setCommentClickable(true);
            this.iJI.setReplayContainerBgGray(true);
            this.iJI.setOnClickListener(aVar);
            this.iJI.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cz.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cz.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cz.abO;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cz.abP;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.iJJ.getAdvertAppInfo();
                }
            });
            if (cz.abN != Integer.MIN_VALUE) {
                this.iJI.setAgreeClickable(true);
                this.iJI.setPraiseContainerBgGray(false);
            } else {
                this.iJI.setAgreeClickable(false);
                this.iJI.setPraiseContainerBgGray(true);
            }
            this.iJI.onChangeSkinType();
        }
    }

    public void a(bh bhVar, com.baidu.c.a.c.a aVar) {
        if (bhVar != null && aVar != null) {
            if (this.iJK || (bhVar.afR() <= 0 && bhVar.afV() <= 0)) {
                if (this.iJK) {
                    this.iJK = false;
                }
                bhVar.hi(aVar.abM);
                bhVar.hq(aVar.abN);
                bhVar.au(aVar.abL);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iJJ != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.iJJ.tailFrame);
            distributeVideoView.setChargeInfo(this.iJJ.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cip() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iJJ.getAdvertAppInfo();
        a aVar = new a(this.iJJ);
        this.iJD.setOnClickListener(aVar);
        View cC = this.iJC.cC("head");
        if (cC != null && (cC instanceof HeadImageView)) {
            this.iJE = (HeadImageView) cC;
            setHeadLongClick(advertAppInfo);
        }
        View cC2 = this.iJC.cC("download");
        if (cC2 != null && (cC2 instanceof ApkDownloadView)) {
            this.iJF = (ApkDownloadView) cC2;
            this.iJF.s(this.mContext.getUniqueId());
            this.iJF.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cC3 = this.iJC.cC("closead");
        if (cC3 != null && (cC3 instanceof AdCloseView)) {
            this.iJG = (AdCloseView) cC3;
            k(advertAppInfo);
        }
        View cC4 = this.iJC.cC("viewbtn");
        if (cC4 != null && (cC4 instanceof JumpButton)) {
            this.iJH = (JumpButton) cC4;
            cio();
        }
        View cC5 = this.iJC.cC("bottombar");
        if (cC5 != null && (cC5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cC5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iJI = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cD = this.iJC.cD("video");
        if (cD != null && (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cD = this.iJC.cD("video");
        if (cD == null || (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cD = this.iJC.cD("video");
        if (cD != null && (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iJP;

        public a(CriusAdCard criusAdCard) {
            this.iJP = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.jQ()) {
                CriusAdCardView.this.mContext.showToast(R.string.neterror);
            } else if (this.iJP != null) {
                AdvertAppInfo advertAppInfo = this.iJP.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.acI()) {
                    int f = b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.kc() && !j.kd()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, f, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.iJF) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, f, CriusAdCardView.this.iJF, z);
                    if (CriusAdCardView.this.hfO != null) {
                        CriusAdCardView.this.hfO.b(3, null);
                        return;
                    }
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abH;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bEW;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.hfO != null) {
                    CriusAdCardView.this.hfO.b(e, null);
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
                    g.aG(this.mContext.getPageActivity(), advertAppInfo.bEY);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bEY);
        downloadData.setUrl(advertAppInfo.bEX);
        downloadData.setName(advertAppInfo.bEV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bEU, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iJF != null) {
                            CriusAdCardView.this.iJF.p(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agK();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.acH() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.ajS();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.hfP != null) {
                this.hfP.b(advertAppInfo, i);
                if (this.iJF != null) {
                    this.iJF.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void ciq() {
        if (this.gYa != null && this.iJC != null) {
            this.gYa.removeAllViews();
            this.iJD = this.iJC.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gYa.addView(this.iJD);
            am.k(this.iJD, R.drawable.addresslist_item_bg);
            cip();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bKQ() {
        if (this.iJC != null && ((TextView) this.iJC.cD("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ai(this.mContext.getPageActivity()));
            ciq();
        }
    }
}
