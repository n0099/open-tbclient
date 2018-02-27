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
    private LinearLayout eUn;
    protected String gDK;
    private ViewGroup gEA;
    private HeadImageView gEB;
    private ApkDownloadView gEC;
    private AdCloseView gED;
    private JumpButton gEE;
    private AdThreadCommentAndPraiseInfoLayout gEF;
    private CriusAdCard gEG;
    private boolean gEH;
    protected CustomMessageListener gEI;
    private com.baidu.b.a.d.a gEz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public i(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEH = true;
        this.gEI = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(i.this.gDK) && i.this.gDK.equals(downloadData.getId()) && i.this.gEC != null) {
                    i.this.gEC.u(downloadData);
                }
            }
        };
        this.gEz = new com.baidu.b.a.d.a();
        this.gEz.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.i.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int f = s.f(i.this.aRG, str);
                if (f == 1 || f == 2) {
                    if (i.this.fbq != null) {
                        i.this.fbq.b(f, null);
                    }
                } else if (i.this.fbq != null) {
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
                    i.this.fbq.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPS() {
        this.eUn = new LinearLayout(this.aRG.getPageActivity());
        this.eUn.setOrientation(1);
        return this.eUn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(CriusAdCard criusAdCard, int i) {
        aj.s(this.gEA, d.f.addresslist_item_bg);
        this.gEz.t(this.aRG.getPageActivity(), i == 1);
        if (this.gEC != null) {
            this.gEC.onChangeSkinType(i);
        }
        if (this.gED != null) {
            this.gED.onChangeSkinType();
        }
        if (this.gEF != null) {
            this.gEF.onChangeSkinType();
        }
        aj.s(this.gEE, d.f.btn_focus_border_bg);
        aj.e(this.gEE, d.C0141d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gEG = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            boy();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gEB != null) {
            this.gEB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.i.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Fx() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aE(advertAppInfo.xM());
                    ((Vibrator) i.this.aRG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void h(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.xK()) {
            this.gEI.setTag(this.aRG.getUniqueId());
            MessageManager.getInstance().registerListener(this.gEI);
            this.gDK = advertAppInfo.aKz;
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gEC.setData(c);
            this.gEC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void i(AdvertAppInfo advertAppInfo) {
        if (this.gED != null && advertAppInfo != null && advertAppInfo.aKG != null && advertAppInfo.aKG.aLb != null && advertAppInfo.aKG.aLb.support_close.intValue() > 0) {
            this.gED.setPage(getBusinessType());
            this.gED.setData(advertAppInfo);
            this.gED.onChangeSkinType();
            l.a(this.aRG.getPageActivity(), this.gED, 40, 40, 40, 120);
        }
    }

    private void bow() {
        if (this.gEE != null) {
            this.gEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a bU;
                    if (i.this.criusData != null && (bU = i.this.criusData.bU("viewbtn")) != null) {
                        if (!q.sG(bU.azG) && i.this.fbq != null) {
                            i.this.fbq.b(bU.azH, bU.azI, null);
                        }
                        if (TextUtils.isEmpty(bU.azJ)) {
                            int f = s.f(i.this.aRG, bU.azG);
                            if ((f == 1 || f == 2) && i.this.fbq != null) {
                                i.this.fbq.b(f, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.this.aRG.getPageActivity());
                        aVar.dk(bU.azJ);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int f2 = s.f(i.this.aRG, bU.azG);
                                if ((f2 == 1 || f2 == 2) && i.this.fbq != null) {
                                    i.this.fbq.b(f2, null);
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
                        aVar.b(i.this.aRG).AU();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a bU;
        if (this.gEF != null && (bU = this.criusData.bU("bottombar")) != null) {
            a(this.gEG.getAdvertAppInfo(), bU);
            this.gEF.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gEF.setBarNameClickEnabled(false);
            this.gEF.setReplyTimeVisible(false);
            if (bU.azK != Integer.MIN_VALUE) {
                this.gEF.setShareClickable(true);
                this.gEF.setShareContainerBgGray(false);
            } else {
                this.gEF.setShareClickable(false);
                this.gEF.setShareContainerBgGray(true);
            }
            this.gEF.getCommentContainer().setOnClickListener(aVar);
            this.gEF.setNeedAddReplyIcon(true);
            this.gEF.setCommentNumEnable(true);
            this.gEF.setCommentClickable(true);
            this.gEF.setReplayContainerBgGray(true);
            this.gEF.setOnClickListener(aVar);
            this.gEF.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.i.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return bU.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return bU.azN;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return bU.azO;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return bU.azP;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return i.this.gEG.getAdvertAppInfo();
                }
            });
            if (bU.azM != Integer.MIN_VALUE) {
                this.gEF.setAgreeClickable(true);
                this.gEF.setPraiseContainerBgGray(false);
            } else {
                this.gEF.setAgreeClickable(false);
                this.gEF.setPraiseContainerBgGray(true);
            }
            this.gEF.onChangeSkinType();
        }
    }

    public void a(bd bdVar, com.baidu.b.a.c.a aVar) {
        if (bdVar != null && aVar != null) {
            if (this.gEH || (bdVar.Ax() <= 0 && bdVar.Az() <= 0)) {
                if (this.gEH) {
                    this.gEH = false;
                }
                bdVar.eP(aVar.azL);
                bdVar.eY(aVar.azM);
                bdVar.w(aVar.azK);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gEG != null) {
            distributeVideoView.setPageContext(this.aRG);
            distributeVideoView.setVideoTailFrameData(this.gEG.tailFrame);
            distributeVideoView.setChargeInfo(this.gEG.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.aJX);
            }
        }
    }

    private void box() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gEG.getAdvertAppInfo();
        a aVar = new a(this.gEG);
        this.gEA.setOnClickListener(aVar);
        View bX = this.gEz.bX("head");
        if (bX != null && (bX instanceof HeadImageView)) {
            this.gEB = (HeadImageView) bX;
            setHeadLongClick(advertAppInfo);
        }
        View bX2 = this.gEz.bX("download");
        if (bX2 != null && (bX2 instanceof ApkDownloadView)) {
            this.gEC = (ApkDownloadView) bX2;
            this.gEC.p(this.aRG.getUniqueId());
            this.gEC.setOnClickListener(aVar);
            h(advertAppInfo);
        }
        View bX3 = this.gEz.bX("closead");
        if (bX3 != null && (bX3 instanceof AdCloseView)) {
            this.gED = (AdCloseView) bX3;
            i(advertAppInfo);
        }
        View bX4 = this.gEz.bX("viewbtn");
        if (bX4 != null && (bX4 instanceof JumpButton)) {
            this.gEE = (JumpButton) bX4;
            bow();
        }
        View bX5 = this.gEz.bX("bottombar");
        if (bX5 != null && (bX5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) bX5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gEF = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View bY = this.gEz.bY("video");
        if (bY != null && (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public com.baidu.tieba.recapp.i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View bY = this.gEz.bY("video");
        if (bY == null || (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View bY = this.gEz.bY("video");
        if (bY != null && (distributeVideoView = (DistributeVideoView) bY.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gEM;

        public a(CriusAdCard criusAdCard) {
            this.gEM = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                i.this.aRG.showToast(d.j.neterror);
            } else if (this.gEM != null) {
                AdvertAppInfo advertAppInfo = this.gEM.getAdvertAppInfo();
                boolean z = view == i.this.gEC;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(i.this.c(advertAppInfo, h));
                    if ((6 != status && 7 != status) || !com.baidu.adp.lib.util.j.oJ() || com.baidu.adp.lib.util.j.oK()) {
                        i.this.a(advertAppInfo, h, i.this.gEC, z);
                        if (i.this.fbq != null) {
                            i.this.fbq.b(3, null);
                            return;
                        }
                        return;
                    }
                    i.this.showDownloadAppDialog(advertAppInfo, h, true, "");
                    return;
                }
                String str = "";
                if (i.this.criusData != null) {
                    str = i.this.criusData.azG;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.aKx;
                }
                int f = s.f(i.this.aRG, str);
                if (i.this.fbq != null) {
                    i.this.fbq.b(f, null);
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
                    com.baidu.tieba.recapp.download.g.ao(this.aRG.getPageActivity(), advertAppInfo.aKz);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aKz);
        downloadData.setUrl(advertAppInfo.aKy);
        downloadData.setName(advertAppInfo.aKv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKu, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                l.showToast(this.aRG.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRG.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.i.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        i.this.d(advertAppInfo, i);
                        if (i.this.gEC != null) {
                            i.this.gEC.s(i.this.c(advertAppInfo, i));
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
                aVar.b(this.aRG).AU();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.xJ() != 0) {
                l.showToast(this.aRG.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DH();
            this.mPermissionJudgePolicy.c(this.aRG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRG.getPageActivity()) && this.fbr != null) {
                this.fbr.b(advertAppInfo, i);
                if (this.gEC != null) {
                    this.gEC.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void boy() {
        if (this.eUn != null && this.gEz != null) {
            this.eUn.removeAllViews();
            this.gEA = this.gEz.a(this.aRG.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eUn.addView(this.gEA);
            aj.s(this.gEA, d.f.addresslist_item_bg);
            box();
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQc() {
        if (this.gEz != null && ((TextView) this.gEz.bY("title")) != null) {
            this.criusData.c("title", TbConfig.getContentSize() / l.ar(this.aRG.getPageActivity()));
            boy();
        }
    }
}
