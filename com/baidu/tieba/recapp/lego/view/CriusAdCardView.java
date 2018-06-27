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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
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
    private LinearLayout eFu;
    protected String goZ;
    private com.baidu.b.a.d.a gpO;
    private ViewGroup gpP;
    private HeadImageView gpQ;
    private ApkDownloadView gpR;
    private AdCloseView gpS;
    private JumpButton gpT;
    private AdThreadCommentAndPraiseInfoLayout gpU;
    private CriusAdCard gpV;
    private boolean gpW;
    protected CustomMessageListener gpX;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpW = true;
        this.gpX = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.goZ) && CriusAdCardView.this.goZ.equals(downloadData.getId()) && CriusAdCardView.this.gpR != null) {
                    CriusAdCardView.this.gpR.u(downloadData);
                }
            }
        };
        this.gpO = new com.baidu.b.a.d.a();
        this.gpO.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.eME != null) {
                        CriusAdCardView.this.eME.b(e, null);
                    }
                } else if (CriusAdCardView.this.eME != null) {
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
                    CriusAdCardView.this.eME.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aQw() {
        this.eFu = new LinearLayout(this.mContext.getPageActivity());
        this.eFu.setOrientation(1);
        return this.eFu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.i(this.gpP, d.f.addresslist_item_bg);
        this.gpO.s(this.mContext.getPageActivity(), i == 1);
        if (this.gpR != null) {
            this.gpR.onChangeSkinType(i);
        }
        if (this.gpS != null) {
            this.gpS.onChangeSkinType();
        }
        if (this.gpU != null) {
            this.gpU.onChangeSkinType();
        }
        am.i(this.gpT, d.f.btn_focus_border_bg);
        am.c(this.gpT, d.C0142d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gpV = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bpe();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gpQ != null) {
            this.gpQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Cb() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aP(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.tU()) {
            this.gpX.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gpX);
            this.goZ = advertAppInfo.aef;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gpR.setData(c);
            this.gpR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gpS != null && advertAppInfo != null && advertAppInfo.aem != null && advertAppInfo.aem.aeI != null && advertAppInfo.aem.aeI.support_close.intValue() > 0) {
            this.gpS.setPage(getBusinessType());
            this.gpS.setData(advertAppInfo);
            this.gpS.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.gpS, 40, 40, 40, 120);
        }
    }

    private void bpc() {
        if (this.gpT != null) {
            this.gpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a ct;
                    if (CriusAdCardView.this.criusData != null && (ct = CriusAdCardView.this.criusData.ct("viewbtn")) != null) {
                        if (!q.tG(ct.Ud) && CriusAdCardView.this.eME != null) {
                            CriusAdCardView.this.eME.b(ct.Ue, ct.Uf, null);
                        }
                        if (TextUtils.isEmpty(ct.Ug)) {
                            int e = s.e(CriusAdCardView.this.mContext, ct.Ud);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.eME != null) {
                                CriusAdCardView.this.eME.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.dE(ct.Ug);
                        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, ct.Ud);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.eME != null) {
                                    CriusAdCardView.this.eME.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).xn();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a ct;
        if (this.gpU != null && (ct = this.criusData.ct("bottombar")) != null) {
            a(this.gpV.getAdvertAppInfo(), ct);
            this.gpU.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gpU.setBarNameClickEnabled(false);
            this.gpU.setReplyTimeVisible(false);
            if (ct.Uh != Integer.MIN_VALUE) {
                this.gpU.setShareClickable(true);
                this.gpU.setShareContainerBgGray(false);
            } else {
                this.gpU.setShareClickable(false);
                this.gpU.setShareContainerBgGray(true);
            }
            this.gpU.getCommentContainer().setOnClickListener(aVar);
            this.gpU.setNeedAddReplyIcon(true);
            this.gpU.setCommentNumEnable(true);
            this.gpU.setCommentClickable(true);
            this.gpU.setReplayContainerBgGray(true);
            this.gpU.setOnClickListener(aVar);
            this.gpU.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return ct.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return ct.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return ct.Uk;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return ct.Ul;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gpV.getAdvertAppInfo();
                }
            });
            if (ct.Uj != Integer.MIN_VALUE) {
                this.gpU.setAgreeClickable(true);
                this.gpU.setPraiseContainerBgGray(false);
            } else {
                this.gpU.setAgreeClickable(false);
                this.gpU.setPraiseContainerBgGray(true);
            }
            this.gpU.onChangeSkinType();
        }
    }

    public void a(bc bcVar, com.baidu.b.a.c.a aVar) {
        if (bcVar != null && aVar != null) {
            if (this.gpW || (bcVar.wF() <= 0 && bcVar.wH() <= 0)) {
                if (this.gpW) {
                    this.gpW = false;
                }
                bcVar.bR(aVar.Ui);
                bcVar.ca(aVar.Uj);
                bcVar.r(aVar.Uh);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gpV != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gpV.tailFrame);
            distributeVideoView.setChargeInfo(this.gpV.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.adE);
            }
        }
    }

    private void bpd() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gpV.getAdvertAppInfo();
        a aVar = new a(this.gpV);
        this.gpP.setOnClickListener(aVar);
        View cw = this.gpO.cw("head");
        if (cw != null && (cw instanceof HeadImageView)) {
            this.gpQ = (HeadImageView) cw;
            setHeadLongClick(advertAppInfo);
        }
        View cw2 = this.gpO.cw("download");
        if (cw2 != null && (cw2 instanceof ApkDownloadView)) {
            this.gpR = (ApkDownloadView) cw2;
            this.gpR.q(this.mContext.getUniqueId());
            this.gpR.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cw3 = this.gpO.cw("closead");
        if (cw3 != null && (cw3 instanceof AdCloseView)) {
            this.gpS = (AdCloseView) cw3;
            k(advertAppInfo);
        }
        View cw4 = this.gpO.cw("viewbtn");
        if (cw4 != null && (cw4 instanceof JumpButton)) {
            this.gpT = (JumpButton) cw4;
            bpc();
        }
        View cw5 = this.gpO.cw("bottombar");
        if (cw5 != null && (cw5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cw5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gpU = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cx = this.gpO.cx("video");
        if (cx != null && (distributeVideoView = (DistributeVideoView) cx.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cx = this.gpO.cx("video");
        if (cx == null || (distributeVideoView = (DistributeVideoView) cx.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cx = this.gpO.cx("video");
        if (cx != null && (distributeVideoView = (DistributeVideoView) cx.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gqb;

        public a(CriusAdCard criusAdCard) {
            this.gqb = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                CriusAdCardView.this.mContext.showToast(d.k.neterror);
            } else if (this.gqb != null) {
                AdvertAppInfo advertAppInfo = this.gqb.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gpR;
                if (advertAppInfo != null && advertAppInfo.tU()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jD() || j.jE()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.gpR, z);
                        if (CriusAdCardView.this.eME != null) {
                            CriusAdCardView.this.eME.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, g, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.Ud;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.aed;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.eME != null) {
                    CriusAdCardView.this.eME.b(e, null);
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
                    g.al(this.mContext.getPageActivity(), advertAppInfo.aef);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aef);
        downloadData.setUrl(advertAppInfo.aee);
        downloadData.setName(advertAppInfo.aeb);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.aea, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tU()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dE(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gpR != null) {
                            CriusAdCardView.this.gpR.s(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).xn();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.tT() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Aj();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eMF != null) {
                this.eMF.b(advertAppInfo, i);
                if (this.gpR != null) {
                    this.gpR.s(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bpe() {
        if (this.eFu != null && this.gpO != null) {
            this.eFu.removeAllViews();
            this.gpP = this.gpO.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eFu.addView(this.gpP);
            am.i(this.gpP, d.f.addresslist_item_bg);
            bpd();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aQF() {
        if (this.gpO != null && ((TextView) this.gpO.cx("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ak(this.mContext.getPageActivity()));
            bpe();
        }
    }
}
