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
import com.baidu.tieba.tbadkCore.q;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private LinearLayout gXi;
    protected String iHJ;
    private HeadImageView iIA;
    private ApkDownloadView iIB;
    private AdCloseView iIC;
    private JumpButton iID;
    private AdThreadCommentAndPraiseInfoLayout iIE;
    private CriusAdCard iIF;
    private boolean iIG;
    protected CustomMessageListener iIH;
    private com.baidu.c.a.d.a iIy;
    private ViewGroup iIz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iIG = true;
        this.iIH = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iHJ) && CriusAdCardView.this.iHJ.equals(downloadData.getId()) && CriusAdCardView.this.iIB != null) {
                    CriusAdCardView.this.iIB.s(downloadData);
                }
            }
        };
        this.iIy = new com.baidu.c.a.d.a();
        this.iIy.a(new a.InterfaceC0037a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0037a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.heW != null) {
                        CriusAdCardView.this.heW.b(e, null);
                    }
                } else if (CriusAdCardView.this.heW != null) {
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
                    CriusAdCardView.this.heW.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKv() {
        this.gXi = new LinearLayout(this.mContext.getPageActivity());
        this.gXi.setOrientation(1);
        return this.gXi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.k(this.iIz, R.drawable.addresslist_item_bg);
        this.iIy.g(this.mContext.getPageActivity(), i == 1);
        if (this.iIB != null) {
            this.iIB.onChangeSkinType(i);
        }
        if (this.iIC != null) {
            this.iIC.onChangeSkinType();
        }
        if (this.iIE != null) {
            this.iIE.onChangeSkinType();
        }
        am.k(this.iID, R.drawable.btn_focus_border_bg);
        am.f(this.iID, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iIF = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            chY();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iIA != null) {
            this.iIA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.amf() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.acH()) {
            this.iIH.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.iIH);
            this.iHJ = advertAppInfo.bEX;
            DownloadData c = c(advertAppInfo, b.f(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iIB.setData(c);
            this.iIB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.iIC != null && advertAppInfo != null && advertAppInfo.bFd != null && advertAppInfo.bFd.adCloseInfo != null && advertAppInfo.bFd.adCloseInfo.support_close.intValue() > 0) {
            this.iIC.setPage(getBusinessType());
            this.iIC.setData(advertAppInfo);
            this.iIC.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.iIC, 40, 40, 40, 120);
        }
    }

    private void chW() {
        if (this.iID != null) {
            this.iID.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cz;
                    if (CriusAdCardView.this.criusData != null && (cz = CriusAdCardView.this.criusData.cz("viewbtn")) != null) {
                        if (!q.EB(cz.abH) && CriusAdCardView.this.heW != null) {
                            CriusAdCardView.this.heW.b(cz.abI, cz.abJ, null);
                        }
                        if (TextUtils.isEmpty(cz.abK)) {
                            int e = s.e(CriusAdCardView.this.mContext, cz.abH);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.heW != null) {
                                CriusAdCardView.this.heW.b(e, null);
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
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.heW != null) {
                                    CriusAdCardView.this.heW.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).agI();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cz;
        if (this.iIE != null && (cz = this.criusData.cz("bottombar")) != null) {
            a(this.iIF.getAdvertAppInfo(), cz);
            this.iIE.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iIE.setBarNameClickEnabled(false);
            this.iIE.setReplyTimeVisible(false);
            if (cz.abL != Integer.MIN_VALUE) {
                this.iIE.setShareClickable(true);
                this.iIE.setShareContainerBgGray(false);
            } else {
                this.iIE.setShareClickable(false);
                this.iIE.setShareContainerBgGray(true);
            }
            this.iIE.getCommentContainer().setOnClickListener(aVar);
            this.iIE.setNeedAddReplyIcon(true);
            this.iIE.setCommentNumEnable(true);
            this.iIE.setCommentClickable(true);
            this.iIE.setReplayContainerBgGray(true);
            this.iIE.setOnClickListener(aVar);
            this.iIE.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
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
                    return CriusAdCardView.this.iIF.getAdvertAppInfo();
                }
            });
            if (cz.abN != Integer.MIN_VALUE) {
                this.iIE.setAgreeClickable(true);
                this.iIE.setPraiseContainerBgGray(false);
            } else {
                this.iIE.setAgreeClickable(false);
                this.iIE.setPraiseContainerBgGray(true);
            }
            this.iIE.onChangeSkinType();
        }
    }

    public void a(bg bgVar, com.baidu.c.a.c.a aVar) {
        if (bgVar != null && aVar != null) {
            if (this.iIG || (bgVar.afQ() <= 0 && bgVar.afU() <= 0)) {
                if (this.iIG) {
                    this.iIG = false;
                }
                bgVar.hi(aVar.abM);
                bgVar.hq(aVar.abN);
                bgVar.au(aVar.abL);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iIF != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.iIF.tailFrame);
            distributeVideoView.setChargeInfo(this.iIF.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void chX() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iIF.getAdvertAppInfo();
        a aVar = new a(this.iIF);
        this.iIz.setOnClickListener(aVar);
        View cC = this.iIy.cC("head");
        if (cC != null && (cC instanceof HeadImageView)) {
            this.iIA = (HeadImageView) cC;
            setHeadLongClick(advertAppInfo);
        }
        View cC2 = this.iIy.cC("download");
        if (cC2 != null && (cC2 instanceof ApkDownloadView)) {
            this.iIB = (ApkDownloadView) cC2;
            this.iIB.s(this.mContext.getUniqueId());
            this.iIB.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cC3 = this.iIy.cC("closead");
        if (cC3 != null && (cC3 instanceof AdCloseView)) {
            this.iIC = (AdCloseView) cC3;
            k(advertAppInfo);
        }
        View cC4 = this.iIy.cC("viewbtn");
        if (cC4 != null && (cC4 instanceof JumpButton)) {
            this.iID = (JumpButton) cC4;
            chW();
        }
        View cC5 = this.iIy.cC("bottombar");
        if (cC5 != null && (cC5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cC5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iIE = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cD = this.iIy.cD("video");
        if (cD != null && (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cD = this.iIy.cD("video");
        if (cD == null || (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cD = this.iIy.cD("video");
        if (cD != null && (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iIL;

        public a(CriusAdCard criusAdCard) {
            this.iIL = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.jQ()) {
                CriusAdCardView.this.mContext.showToast(R.string.neterror);
            } else if (this.iIL != null) {
                AdvertAppInfo advertAppInfo = this.iIL.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.acH()) {
                    int f = b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.kc() && !j.kd()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, f, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.iIB) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, f, CriusAdCardView.this.iIB, z);
                    if (CriusAdCardView.this.heW != null) {
                        CriusAdCardView.this.heW.b(3, null);
                        return;
                    }
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abH;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bEV;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.heW != null) {
                    CriusAdCardView.this.heW.b(e, null);
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
                    g.aG(this.mContext.getPageActivity(), advertAppInfo.bEX);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bEX);
        downloadData.setUrl(advertAppInfo.bEW);
        downloadData.setName(advertAppInfo.bEU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bET, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iIB != null) {
                            CriusAdCardView.this.iIB.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).agI();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.acG() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.ajQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.heX != null) {
                this.heX.b(advertAppInfo, i);
                if (this.iIB != null) {
                    this.iIB.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void chY() {
        if (this.gXi != null && this.iIy != null) {
            this.gXi.removeAllViews();
            this.iIz = this.iIy.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gXi.addView(this.iIz);
            am.k(this.iIz, R.drawable.addresslist_item_bg);
            chX();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bKC() {
        if (this.iIy != null && ((TextView) this.iIy.cD("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ai(this.mContext.getPageActivity()));
            chY();
        }
    }
}
