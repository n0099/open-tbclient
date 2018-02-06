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
import com.baidu.tieba.tbadkCore.q;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.lego.card.e.b<CriusAdCard> implements com.baidu.tieba.recapp.k {
    private com.baidu.b.a.c.a criusData;
    private LinearLayout eUz;
    protected String gDZ;
    private com.baidu.b.a.d.a gEO;
    private ViewGroup gEP;
    private HeadImageView gEQ;
    private ApkDownloadView gER;
    private AdCloseView gES;
    private JumpButton gET;
    private AdThreadCommentAndPraiseInfoLayout gEU;
    private CriusAdCard gEV;
    private boolean gEW;
    protected CustomMessageListener gEX;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public i(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEW = true;
        this.gEX = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(i.this.gDZ) && i.this.gDZ.equals(downloadData.getId()) && i.this.gER != null) {
                    i.this.gER.u(downloadData);
                }
            }
        };
        this.gEO = new com.baidu.b.a.d.a();
        this.gEO.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.i.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int f = s.f(i.this.aRR, str);
                if (f == 1 || f == 2) {
                    if (i.this.fbC != null) {
                        i.this.fbC.b(f, null);
                    }
                } else if (i.this.fbC != null) {
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
                    i.this.fbC.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPT() {
        this.eUz = new LinearLayout(this.aRR.getPageActivity());
        this.eUz.setOrientation(1);
        return this.eUz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(CriusAdCard criusAdCard, int i) {
        aj.s(this.gEP, d.f.addresslist_item_bg);
        this.gEO.t(this.aRR.getPageActivity(), i == 1);
        if (this.gER != null) {
            this.gER.onChangeSkinType(i);
        }
        if (this.gES != null) {
            this.gES.onChangeSkinType();
        }
        if (this.gEU != null) {
            this.gEU.onChangeSkinType();
        }
        aj.s(this.gET, d.f.btn_focus_border_bg);
        aj.e(this.gET, d.C0140d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gEV = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            boz();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gEQ != null) {
            this.gEQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.i.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Fy() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aE(advertAppInfo.xM());
                    ((Vibrator) i.this.aRR.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void h(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.xK()) {
            this.gEX.setTag(this.aRR.getUniqueId());
            MessageManager.getInstance().registerListener(this.gEX);
            this.gDZ = advertAppInfo.aKK;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gER.setData(c);
            this.gER.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (this.gES != null && advertAppInfo != null && advertAppInfo.aKR != null && advertAppInfo.aKR.aLm != null && advertAppInfo.aKR.aLm.support_close.intValue() > 0) {
            this.gES.setPage(getBusinessType());
            this.gES.setData(advertAppInfo);
            this.gES.onChangeSkinType();
            l.a(this.aRR.getPageActivity(), this.gES, 40, 40, 40, 120);
        }
    }

    private void box() {
        if (this.gET != null) {
            this.gET.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a bU;
                    if (i.this.criusData != null && (bU = i.this.criusData.bU("viewbtn")) != null) {
                        if (!q.sG(bU.azP) && i.this.fbC != null) {
                            i.this.fbC.b(bU.azQ, bU.azR, null);
                        }
                        if (TextUtils.isEmpty(bU.azS)) {
                            int f = s.f(i.this.aRR, bU.azP);
                            if ((f == 1 || f == 2) && i.this.fbC != null) {
                                i.this.fbC.b(f, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.this.aRR.getPageActivity());
                        aVar.dk(bU.azS);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int f2 = s.f(i.this.aRR, bU.azP);
                                if ((f2 == 1 || f2 == 2) && i.this.fbC != null) {
                                    i.this.fbC.b(f2, null);
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
                        aVar.b(i.this.aRR).AU();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bU;
        if (this.gEU != null && (bU = this.criusData.bU("bottombar")) != null) {
            a(this.gEV.getAdvertAppInfo(), bU);
            this.gEU.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gEU.setBarNameClickEnabled(false);
            this.gEU.setReplyTimeVisible(false);
            if (bU.azT != Integer.MIN_VALUE) {
                this.gEU.setShareClickable(true);
                this.gEU.setShareContainerBgGray(false);
            } else {
                this.gEU.setShareClickable(false);
                this.gEU.setShareContainerBgGray(true);
            }
            this.gEU.getCommentContainer().setOnClickListener(aVar);
            this.gEU.setNeedAddReplyIcon(true);
            this.gEU.setCommentNumEnable(true);
            this.gEU.setCommentClickable(true);
            this.gEU.setReplayContainerBgGray(true);
            this.gEU.setOnClickListener(aVar);
            this.gEU.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.i.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return bU.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return bU.azW;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return bU.azX;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bU.azY;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return i.this.gEV.getAdvertAppInfo();
                }
            });
            if (bU.azV != Integer.MIN_VALUE) {
                this.gEU.setAgreeClickable(true);
                this.gEU.setPraiseContainerBgGray(false);
            } else {
                this.gEU.setAgreeClickable(false);
                this.gEU.setPraiseContainerBgGray(true);
            }
            this.gEU.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.gEW || (bdVar.Ax() <= 0 && bdVar.Az() <= 0)) {
                if (this.gEW) {
                    this.gEW = false;
                }
                bdVar.eP(aVar.azU);
                bdVar.eY(aVar.azV);
                bdVar.w(aVar.azT);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gEV != null) {
            distributeVideoView.setPageContext(this.aRR);
            distributeVideoView.setVideoTailFrameData(this.gEV.tailFrame);
            distributeVideoView.setChargeInfo(this.gEV.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.aKi);
            }
        }
    }

    private void boy() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gEV.getAdvertAppInfo();
        a aVar = new a(this.gEV);
        this.gEP.setOnClickListener(aVar);
        View bX = this.gEO.bX("head");
        if (bX != null && (bX instanceof HeadImageView)) {
            this.gEQ = (HeadImageView) bX;
            setHeadLongClick(advertAppInfo);
        }
        View bX2 = this.gEO.bX("download");
        if (bX2 != null && (bX2 instanceof ApkDownloadView)) {
            this.gER = (ApkDownloadView) bX2;
            this.gER.p(this.aRR.getUniqueId());
            this.gER.setOnClickListener(aVar);
            h(advertAppInfo);
        }
        View bX3 = this.gEO.bX("closead");
        if (bX3 != null && (bX3 instanceof AdCloseView)) {
            this.gES = (AdCloseView) bX3;
            i(advertAppInfo);
        }
        View bX4 = this.gEO.bX("viewbtn");
        if (bX4 != null && (bX4 instanceof JumpButton)) {
            this.gET = (JumpButton) bX4;
            box();
        }
        View bX5 = this.gEO.bX("bottombar");
        if (bX5 != null && (bX5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bX5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gEU = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bY = this.gEO.bY("video");
        if (bY != null && (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public com.baidu.tieba.recapp.i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bY = this.gEO.bY("video");
        if (bY == null || (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bY = this.gEO.bY("video");
        if (bY != null && (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gFb;

        public a(CriusAdCard criusAdCard) {
            this.gFb = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                i.this.aRR.showToast(d.j.neterror);
            } else if (this.gFb != null) {
                AdvertAppInfo advertAppInfo = this.gFb.getAdvertAppInfo();
                boolean z = view == i.this.gER;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(i.this.c(advertAppInfo, h));
                    if ((6 != status && 7 != status) || !com.baidu.adp.lib.util.j.oJ() || com.baidu.adp.lib.util.j.oK()) {
                        i.this.a(advertAppInfo, h, i.this.gER, z);
                        if (i.this.fbC != null) {
                            i.this.fbC.b(3, null);
                            return;
                        }
                        return;
                    }
                    i.this.showDownloadAppDialog(advertAppInfo, h, true, "");
                    return;
                }
                String str = "";
                if (i.this.criusData != null) {
                    str = i.this.criusData.azP;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.aKI;
                }
                int f = s.f(i.this.aRR, str);
                if (i.this.fbC != null) {
                    i.this.fbC.b(f, null);
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
                    com.baidu.tieba.recapp.download.g.ao(this.aRR.getPageActivity(), advertAppInfo.aKK);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aKK);
        downloadData.setUrl(advertAppInfo.aKJ);
        downloadData.setName(advertAppInfo.aKG);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKF, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                l.showToast(this.aRR.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRR.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        i.this.d(advertAppInfo, i);
                        if (i.this.gER != null) {
                            i.this.gER.s(i.this.c(advertAppInfo, i));
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
                aVar.b(this.aRR).AU();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.xJ() != 0) {
                l.showToast(this.aRR.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.aRR.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRR.getPageActivity()) && this.fbD != null) {
                this.fbD.b(advertAppInfo, i);
                if (this.gER != null) {
                    this.gER.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void boz() {
        if (this.eUz != null && this.gEO != null) {
            this.eUz.removeAllViews();
            this.gEP = this.gEO.a(this.aRR.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eUz.addView(this.gEP);
            aj.s(this.gEP, d.f.addresslist_item_bg);
            boy();
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQd() {
        if (this.gEO != null && ((TextView) this.gEO.bY("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.ar(this.aRR.getPageActivity()));
            boz();
        }
    }
}
