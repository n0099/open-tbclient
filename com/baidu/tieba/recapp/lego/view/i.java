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
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.d.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.r;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.lego.card.e.b<CriusAdCard> implements com.baidu.tieba.recapp.k {
    private com.baidu.b.a.c.a criusData;
    private LinearLayout eUB;
    private com.baidu.b.a.d.a gEP;
    private ViewGroup gEQ;
    private HeadImageView gER;
    private ApkDownloadView gES;
    private AdCloseView gET;
    private JumpButton gEU;
    private AdThreadCommentAndPraiseInfoLayout gEV;
    private CriusAdCard gEW;
    private boolean gEX;
    protected CustomMessageListener gEY;
    protected String gEa;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public i(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEX = true;
        this.gEY = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(i.this.gEa) && i.this.gEa.equals(downloadData.getId()) && i.this.gES != null) {
                    i.this.gES.u(downloadData);
                }
            }
        };
        this.gEP = new com.baidu.b.a.d.a();
        this.gEP.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.i.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int f = s.f(i.this.aRI, str);
                if (f == 1 || f == 2) {
                    if (i.this.fbE != null) {
                        i.this.fbE.b(f, null);
                    }
                } else if (i.this.fbE != null) {
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
                    i.this.fbE.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPT() {
        this.eUB = new LinearLayout(this.aRI.getPageActivity());
        this.eUB.setOrientation(1);
        return this.eUB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(CriusAdCard criusAdCard, int i) {
        aj.s(this.gEQ, d.f.addresslist_item_bg);
        this.gEP.t(this.aRI.getPageActivity(), i == 1);
        if (this.gES != null) {
            this.gES.onChangeSkinType(i);
        }
        if (this.gET != null) {
            this.gET.onChangeSkinType();
        }
        if (this.gEV != null) {
            this.gEV.onChangeSkinType();
        }
        aj.s(this.gEU, d.f.btn_focus_border_bg);
        aj.e(this.gEU, d.C0141d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gEW = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            boz();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gER != null) {
            this.gER.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.i.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Fy() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aE(advertAppInfo.xM());
                    ((Vibrator) i.this.aRI.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void h(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.xK()) {
            this.gEY.setTag(this.aRI.getUniqueId());
            MessageManager.getInstance().registerListener(this.gEY);
            this.gEa = advertAppInfo.aKA;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gES.setData(c);
            this.gES.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (this.gET != null && advertAppInfo != null && advertAppInfo.aKH != null && advertAppInfo.aKH.aLc != null && advertAppInfo.aKH.aLc.support_close.intValue() > 0) {
            this.gET.setPage(getBusinessType());
            this.gET.setData(advertAppInfo);
            this.gET.onChangeSkinType();
            l.a(this.aRI.getPageActivity(), this.gET, 40, 40, 40, 120);
        }
    }

    private void box() {
        if (this.gEU != null) {
            this.gEU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a bU;
                    if (i.this.criusData != null && (bU = i.this.criusData.bU("viewbtn")) != null) {
                        if (!r.sG(bU.azH) && i.this.fbE != null) {
                            i.this.fbE.b(bU.azI, bU.azJ, null);
                        }
                        if (TextUtils.isEmpty(bU.azK)) {
                            int f = s.f(i.this.aRI, bU.azH);
                            if ((f == 1 || f == 2) && i.this.fbE != null) {
                                i.this.fbE.b(f, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.this.aRI.getPageActivity());
                        aVar.dk(bU.azK);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int f2 = s.f(i.this.aRI, bU.azH);
                                if ((f2 == 1 || f2 == 2) && i.this.fbE != null) {
                                    i.this.fbE.b(f2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(i.this.aRI).AV();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bU;
        if (this.gEV != null && (bU = this.criusData.bU("bottombar")) != null) {
            a(this.gEW.getAdvertAppInfo(), bU);
            this.gEV.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gEV.setBarNameClickEnabled(false);
            this.gEV.setReplyTimeVisible(false);
            if (bU.azL != Integer.MIN_VALUE) {
                this.gEV.setShareClickable(true);
                this.gEV.setShareContainerBgGray(false);
            } else {
                this.gEV.setShareClickable(false);
                this.gEV.setShareContainerBgGray(true);
            }
            this.gEV.getCommentContainer().setOnClickListener(aVar);
            this.gEV.setNeedAddReplyIcon(true);
            this.gEV.setCommentNumEnable(true);
            this.gEV.setCommentClickable(true);
            this.gEV.setReplayContainerBgGray(true);
            this.gEV.setOnClickListener(aVar);
            this.gEV.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.i.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return bU.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return bU.azO;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return bU.azP;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bU.azQ;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return i.this.gEW.getAdvertAppInfo();
                }
            });
            if (bU.azN != Integer.MIN_VALUE) {
                this.gEV.setAgreeClickable(true);
                this.gEV.setPraiseContainerBgGray(false);
            } else {
                this.gEV.setAgreeClickable(false);
                this.gEV.setPraiseContainerBgGray(true);
            }
            this.gEV.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.gEX || (bdVar.Ax() <= 0 && bdVar.Az() <= 0)) {
                if (this.gEX) {
                    this.gEX = false;
                }
                bdVar.eP(aVar.azM);
                bdVar.eY(aVar.azN);
                bdVar.w(aVar.azL);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gEW != null) {
            distributeVideoView.setPageContext(this.aRI);
            distributeVideoView.setVideoTailFrameData(this.gEW.tailFrame);
            distributeVideoView.setChargeInfo(this.gEW.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.aJY);
            }
        }
    }

    private void boy() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gEW.getAdvertAppInfo();
        a aVar = new a(this.gEW);
        this.gEQ.setOnClickListener(aVar);
        View bX = this.gEP.bX("head");
        if (bX != null && (bX instanceof HeadImageView)) {
            this.gER = (HeadImageView) bX;
            setHeadLongClick(advertAppInfo);
        }
        View bX2 = this.gEP.bX("download");
        if (bX2 != null && (bX2 instanceof ApkDownloadView)) {
            this.gES = (ApkDownloadView) bX2;
            this.gES.p(this.aRI.getUniqueId());
            this.gES.setOnClickListener(aVar);
            h(advertAppInfo);
        }
        View bX3 = this.gEP.bX("closead");
        if (bX3 != null && (bX3 instanceof AdCloseView)) {
            this.gET = (AdCloseView) bX3;
            i(advertAppInfo);
        }
        View bX4 = this.gEP.bX("viewbtn");
        if (bX4 != null && (bX4 instanceof JumpButton)) {
            this.gEU = (JumpButton) bX4;
            box();
        }
        View bX5 = this.gEP.bX("bottombar");
        if (bX5 != null && (bX5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bX5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gEV = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bY = this.gEP.bY("video");
        if (bY != null && (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public com.baidu.tieba.recapp.i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bY = this.gEP.bY("video");
        if (bY == null || (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bY = this.gEP.bY("video");
        if (bY != null && (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gFc;

        public a(CriusAdCard criusAdCard) {
            this.gFc = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                i.this.aRI.showToast(d.j.neterror);
            } else if (this.gFc != null) {
                AdvertAppInfo advertAppInfo = this.gFc.getAdvertAppInfo();
                boolean z = view == i.this.gES;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(i.this.c(advertAppInfo, h));
                    if ((6 != status && 7 != status) || !com.baidu.adp.lib.util.j.oJ() || com.baidu.adp.lib.util.j.oK()) {
                        i.this.a(advertAppInfo, h, i.this.gES, z);
                        if (i.this.fbE != null) {
                            i.this.fbE.b(3, null);
                            return;
                        }
                        return;
                    }
                    i.this.showDownloadAppDialog(advertAppInfo, h, true, "");
                    return;
                }
                String str = "";
                if (i.this.criusData != null) {
                    str = i.this.criusData.azH;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.aKy;
                }
                int f = s.f(i.this.aRI, str);
                if (i.this.fbE != null) {
                    i.this.fbE.b(f, null);
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
                        com.baidu.tieba.recapp.download.g.e(advertAppInfo);
                        apkDownloadView.t(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    com.baidu.tieba.recapp.download.g.ao(this.aRI.getPageActivity(), advertAppInfo.aKA);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aKA);
        downloadData.setUrl(advertAppInfo.aKz);
        downloadData.setName(advertAppInfo.aKw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKv, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                l.showToast(this.aRI.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRI.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        i.this.d(advertAppInfo, i);
                        if (i.this.gES != null) {
                            i.this.gES.s(i.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRI).AV();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.xJ() != 0) {
                l.showToast(this.aRI.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.aRI.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRI.getPageActivity()) && this.fbF != null) {
                this.fbF.b(advertAppInfo, i);
                if (this.gES != null) {
                    this.gES.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void boz() {
        if (this.eUB != null && this.gEP != null) {
            this.eUB.removeAllViews();
            this.gEQ = this.gEP.a(this.aRI.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eUB.addView(this.gEQ);
            aj.s(this.gEQ, d.f.addresslist_item_bg);
            boy();
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQd() {
        if (this.gEP != null && ((TextView) this.gEP.bY("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.ar(this.aRI.getPageActivity()));
            boz();
        }
    }
}
