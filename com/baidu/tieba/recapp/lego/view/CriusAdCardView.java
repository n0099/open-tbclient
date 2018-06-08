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
import com.baidu.tbadk.core.util.al;
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
    private LinearLayout eBE;
    private com.baidu.b.a.d.a glX;
    private ViewGroup glY;
    private HeadImageView glZ;
    protected String gli;
    private ApkDownloadView gma;
    private AdCloseView gmb;
    private JumpButton gmc;
    private AdThreadCommentAndPraiseInfoLayout gmd;
    private CriusAdCard gme;
    private boolean gmf;
    protected CustomMessageListener gmg;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gmf = true;
        this.gmg = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gli) && CriusAdCardView.this.gli.equals(downloadData.getId()) && CriusAdCardView.this.gma != null) {
                    CriusAdCardView.this.gma.u(downloadData);
                }
            }
        };
        this.glX = new com.baidu.b.a.d.a();
        this.glX.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.eIN != null) {
                        CriusAdCardView.this.eIN.b(e, null);
                    }
                } else if (CriusAdCardView.this.eIN != null) {
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
                    CriusAdCardView.this.eIN.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aPQ() {
        this.eBE = new LinearLayout(this.mContext.getPageActivity());
        this.eBE.setOrientation(1);
        return this.eBE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.glY, d.f.addresslist_item_bg);
        this.glX.s(this.mContext.getPageActivity(), i == 1);
        if (this.gma != null) {
            this.gma.onChangeSkinType(i);
        }
        if (this.gmb != null) {
            this.gmb.onChangeSkinType();
        }
        if (this.gmd != null) {
            this.gmd.onChangeSkinType();
        }
        al.i(this.gmc, d.f.btn_focus_border_bg);
        al.c(this.gmc, d.C0141d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gme = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            boD();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.glZ != null) {
            this.glZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.BK() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aN(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.tO()) {
            this.gmg.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gmg);
            this.gli = advertAppInfo.adQ;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gma.setData(c);
            this.gma.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (this.gmb != null && advertAppInfo != null && advertAppInfo.adX != null && advertAppInfo.adX.aet != null && advertAppInfo.adX.aet.support_close.intValue() > 0) {
            this.gmb.setPage(getBusinessType());
            this.gmb.setData(advertAppInfo);
            this.gmb.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.gmb, 40, 40, 40, 120);
        }
    }

    private void boB() {
        if (this.gmc != null) {
            this.gmc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a cr;
                    if (CriusAdCardView.this.criusData != null && (cr = CriusAdCardView.this.criusData.cr("viewbtn")) != null) {
                        if (!q.tH(cr.Ub) && CriusAdCardView.this.eIN != null) {
                            CriusAdCardView.this.eIN.b(cr.Uc, cr.Ud, null);
                        }
                        if (TextUtils.isEmpty(cr.Ue)) {
                            int e = s.e(CriusAdCardView.this.mContext, cr.Ub);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.eIN != null) {
                                CriusAdCardView.this.eIN.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.dB(cr.Ue);
                        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cr.Ub);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.eIN != null) {
                                    CriusAdCardView.this.eIN.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).xa();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a cr;
        if (this.gmd != null && (cr = this.criusData.cr("bottombar")) != null) {
            a(this.gme.getAdvertAppInfo(), cr);
            this.gmd.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gmd.setBarNameClickEnabled(false);
            this.gmd.setReplyTimeVisible(false);
            if (cr.Uf != Integer.MIN_VALUE) {
                this.gmd.setShareClickable(true);
                this.gmd.setShareContainerBgGray(false);
            } else {
                this.gmd.setShareClickable(false);
                this.gmd.setShareContainerBgGray(true);
            }
            this.gmd.getCommentContainer().setOnClickListener(aVar);
            this.gmd.setNeedAddReplyIcon(true);
            this.gmd.setCommentNumEnable(true);
            this.gmd.setCommentClickable(true);
            this.gmd.setReplayContainerBgGray(true);
            this.gmd.setOnClickListener(aVar);
            this.gmd.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cr.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cr.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cr.Ui;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cr.Uj;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gme.getAdvertAppInfo();
                }
            });
            if (cr.Uh != Integer.MIN_VALUE) {
                this.gmd.setAgreeClickable(true);
                this.gmd.setPraiseContainerBgGray(false);
            } else {
                this.gmd.setAgreeClickable(false);
                this.gmd.setPraiseContainerBgGray(true);
            }
            this.gmd.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.gmf || (bdVar.wv() <= 0 && bdVar.wx() <= 0)) {
                if (this.gmf) {
                    this.gmf = false;
                }
                bdVar.bQ(aVar.Ug);
                bdVar.bZ(aVar.Uh);
                bdVar.r(aVar.Uf);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gme != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gme.tailFrame);
            distributeVideoView.setChargeInfo(this.gme.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.adp);
            }
        }
    }

    private void boC() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gme.getAdvertAppInfo();
        a aVar = new a(this.gme);
        this.glY.setOnClickListener(aVar);
        View cu = this.glX.cu("head");
        if (cu != null && (cu instanceof HeadImageView)) {
            this.glZ = (HeadImageView) cu;
            setHeadLongClick(advertAppInfo);
        }
        View cu2 = this.glX.cu("download");
        if (cu2 != null && (cu2 instanceof ApkDownloadView)) {
            this.gma = (ApkDownloadView) cu2;
            this.gma.q(this.mContext.getUniqueId());
            this.gma.setOnClickListener(aVar);
            i(advertAppInfo);
        }
        View cu3 = this.glX.cu("closead");
        if (cu3 != null && (cu3 instanceof AdCloseView)) {
            this.gmb = (AdCloseView) cu3;
            j(advertAppInfo);
        }
        View cu4 = this.glX.cu("viewbtn");
        if (cu4 != null && (cu4 instanceof JumpButton)) {
            this.gmc = (JumpButton) cu4;
            boB();
        }
        View cu5 = this.glX.cu("bottombar");
        if (cu5 != null && (cu5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cu5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gmd = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cv = this.glX.cv("video");
        if (cv != null && (distributeVideoView = (DistributeVideoView) cv.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cv = this.glX.cv("video");
        if (cv == null || (distributeVideoView = (DistributeVideoView) cv.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cv = this.glX.cv("video");
        if (cv != null && (distributeVideoView = (DistributeVideoView) cv.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gmk;

        public a(CriusAdCard criusAdCard) {
            this.gmk = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                CriusAdCardView.this.mContext.showToast(d.k.neterror);
            } else if (this.gmk != null) {
                AdvertAppInfo advertAppInfo = this.gmk.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gma;
                if (advertAppInfo != null && advertAppInfo.tO()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.gma, z);
                        if (CriusAdCardView.this.eIN != null) {
                            CriusAdCardView.this.eIN.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, g, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Ub;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.adO;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.eIN != null) {
                    CriusAdCardView.this.eIN.b(e, null);
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
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.al(this.mContext.getPageActivity(), advertAppInfo.adQ);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.adQ);
        downloadData.setUrl(advertAppInfo.adP);
        downloadData.setName(advertAppInfo.adM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.adL, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tO()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gma != null) {
                            CriusAdCardView.this.gma.s(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).xa();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.tN() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zU();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eIO != null) {
                this.eIO.b(advertAppInfo, i);
                if (this.gma != null) {
                    this.gma.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void boD() {
        if (this.eBE != null && this.glX != null) {
            this.eBE.removeAllViews();
            this.glY = this.glX.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eBE.addView(this.glY);
            al.i(this.glY, d.f.addresslist_item_bg);
            boC();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aPZ() {
        if (this.glX != null && ((TextView) this.glX.cv("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ak(this.mContext.getPageActivity()));
            boD();
        }
    }
}
